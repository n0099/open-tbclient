package c.a.n0.q.i.i.g;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f<T> implements Runnable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final c.a.n0.q.o.a f9168g;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public T f9169b;

    /* renamed from: c  reason: collision with root package name */
    public File f9170c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f9171d;

    /* renamed from: e  reason: collision with root package name */
    public c<T> f9172e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9173f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-758518162, "Lc/a/n0/q/i/i/g/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-758518162, "Lc/a/n0/q/i/i/g/f;");
                return;
            }
        }
        f9168g = c.a.n0.q.o.a.e();
    }

    public f(e eVar, T t, c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, t, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9171d = new AtomicBoolean(false);
        this.a = eVar;
        this.f9169b = t;
        this.f9172e = cVar;
    }

    public final void a(int i, c.a.n0.q.h.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, fVar) == null) || fVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (i == 2200) {
            i = 0;
        } else {
            try {
                jSONObject.put("response", fVar.toString());
            } catch (JSONException e2) {
                f9168g.g("PMSDownloadTask", "#addStatistic json put data出错", e2);
            }
        }
        if (fVar instanceof c.a.n0.q.h.g) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, fVar.f9145g);
        }
        c.a.n0.q.m.a.a(fVar.f9146h, "pkg_download", null, i, jSONObject);
    }

    public boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            c.a.n0.q.h.f fVar = this.a.f9167b;
            if (fVar.f9143e != i) {
                fVar.f9143e = i;
                if (i != 2 && i != 3 && i != 10) {
                    s(false);
                } else {
                    s(true);
                }
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!TextUtils.isEmpty(this.a.f9167b.a)) {
                f9168g.i("PMSDownloadTask", "#checkAndCreateFile mParam.pmsPackage.filePath 为空");
                return true;
            }
            File c2 = c.a.n0.q.o.e.c(this.f9172e.d(this.f9169b), this.a.f9167b.l);
            this.f9170c = c2;
            if (c2 == null) {
                String absolutePath = c.a.n0.p.b.b().getAppContext().getCacheDir().getAbsolutePath();
                c.a.n0.q.o.a aVar = f9168g;
                aVar.i("PMSDownloadTask", "#checkAndCreateFile mLocalFile=null cacheDir=" + absolutePath);
                this.f9170c = c.a.n0.q.o.e.c(absolutePath, this.a.f9167b.l);
            }
            File file = this.f9170c;
            if (file == null) {
                f9168g.i("PMSDownloadTask", "#checkAndCreateFile generateFilePath=null");
                this.f9172e.e(this.f9169b, new c.a.n0.q.h.b(2203, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH));
                return false;
            }
            this.a.f9167b.a = file.getAbsolutePath();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d(f<T> fVar) {
        InterceptResult invokeL;
        e eVar;
        c.a.n0.q.h.f fVar2;
        e eVar2;
        c.a.n0.q.h.f fVar3;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) ? (fVar == null || (eVar = fVar.a) == null || (fVar2 = eVar.f9167b) == null || (eVar2 = this.a) == null || (fVar3 = eVar2.f9167b) == null || !fVar3.equals(fVar2)) ? false : true : invokeL.booleanValue;
    }

    public c.a.n0.q.e.e<T> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f9172e : (c.a.n0.q.e.e) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj != null && (obj instanceof f)) {
                return d((f) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public T f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f9169b : (T) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new c.a.n0.q.i.i.d.a().a(this.f9172e.k()).intValue() : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c<T> cVar = this.f9172e;
            if (cVar != null) {
                return cVar.g();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Objects.hash(this.a.f9167b) : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a.f9167b.f9143e : invokeV.intValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            String d2 = this.f9172e.d(this.f9169b);
            if (d2 == null) {
                return false;
            }
            try {
                StatFs statFs = new StatFs(d2);
                return Build.VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong() > j : ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) > j;
            } catch (Throwable th) {
                f9168g.g("PMSDownloadTask", "#hasSpaceToWrite 异常或者磁盘空间不足", th);
                return false;
            }
        }
        return invokeJ.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f9173f : invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f9172e.a(this.f9169b);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b(3);
            this.f9172e.e(this.f9169b, this.a.a);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            b(10);
            this.f9172e.i(this.f9169b);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f9173f = true;
            s(true);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b(1);
            this.f9172e.c(this.f9169b);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b(2);
            this.f9172e.j(this.f9169b);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            if (z) {
                this.a.f9167b.f9140b = 0L;
            }
            b(0);
            s(false);
            this.f9173f = false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048596, this) != null) {
            return;
        }
        String fVar = this.a.f9167b.toString();
        f9168g.i("PMSDownloadTask", "#run 开始下包 pkg=" + fVar);
        j jVar = new j(this, h());
        while (true) {
            c.a.n0.q.h.b bVar = this.a.a;
            if (bVar != null && bVar.a == 2200) {
                return;
            }
            if (this.f9171d.get()) {
                f9168g.i("PMSDownloadTask", "#run 已经取消下包 pkg=" + fVar);
                q();
                return;
            }
            jVar.b();
            c.a.n0.q.h.b bVar2 = this.a.a;
            if (bVar2 != null) {
                if (bVar2.a != 2200) {
                    if (this.f9171d.get()) {
                        f9168g.i("PMSDownloadTask", "#run 运行中取消下包 pkg=" + fVar);
                        q();
                        return;
                    }
                    this.f9172e.f9165b++;
                    f9168g.i("PMSDownloadTask", "#run 下载出错 pkg=" + fVar + " retryCount=" + this.f9172e.f9165b);
                    if (this.f9172e.f9165b < 3) {
                        try {
                            if (!this.f9171d.get()) {
                                Thread.sleep(this.f9172e.f9165b * 1000);
                            }
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        m();
                        e eVar = this.a;
                        a(eVar.a.a, eVar.f9167b);
                        return;
                    }
                } else {
                    f9168g.i("PMSDownloadTask", "#run 下包成功 pkg=" + fVar);
                    n();
                    return;
                }
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || this.f9171d.get() == z) {
            return;
        }
        this.f9171d.set(z);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "downloadUrl:" + this.a.f9167b.n + ",versionName:" + this.a.f9167b.j + ",versionCode:" + this.a.f9167b.i + "md5:" + this.a.f9167b.l + "bundleId:" + this.a.f9167b.f9145g;
        }
        return (String) invokeV.objValue;
    }
}
