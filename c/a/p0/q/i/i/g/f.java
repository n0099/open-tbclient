package c.a.p0.q.i.i.g;

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
    public static final c.a.p0.q.o.a k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f10990e;

    /* renamed from: f  reason: collision with root package name */
    public T f10991f;

    /* renamed from: g  reason: collision with root package name */
    public File f10992g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f10993h;

    /* renamed from: i  reason: collision with root package name */
    public c<T> f10994i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f10995j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1345324176, "Lc/a/p0/q/i/i/g/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1345324176, "Lc/a/p0/q/i/i/g/f;");
                return;
            }
        }
        k = c.a.p0.q.o.a.e();
    }

    public f(e eVar, T t, c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, t, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10993h = new AtomicBoolean(false);
        this.f10990e = eVar;
        this.f10991f = t;
        this.f10994i = cVar;
    }

    public final void a(int i2, c.a.p0.q.h.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, fVar) == null) || fVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (i2 == 2200) {
            i2 = 0;
        } else {
            try {
                jSONObject.put("response", fVar.toString());
            } catch (JSONException e2) {
                k.g("PMSDownloadTask", "#addStatistic json put data出错", e2);
            }
        }
        if (fVar instanceof c.a.p0.q.h.g) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, fVar.f10961g);
        }
        c.a.p0.q.m.a.a(fVar.f10962h, "pkg_download", null, i2, jSONObject);
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            c.a.p0.q.h.f fVar = this.f10990e.f10989b;
            if (fVar.f10959e != i2) {
                fVar.f10959e = i2;
                if (i2 != 2 && i2 != 3 && i2 != 10) {
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
            if (!TextUtils.isEmpty(this.f10990e.f10989b.a)) {
                k.i("PMSDownloadTask", "#checkAndCreateFile mParam.pmsPackage.filePath 为空");
                return true;
            }
            File c2 = c.a.p0.q.o.e.c(this.f10994i.d(this.f10991f), this.f10990e.f10989b.l);
            this.f10992g = c2;
            if (c2 == null) {
                String absolutePath = c.a.p0.p.b.b().getAppContext().getCacheDir().getAbsolutePath();
                c.a.p0.q.o.a aVar = k;
                aVar.i("PMSDownloadTask", "#checkAndCreateFile mLocalFile=null cacheDir=" + absolutePath);
                this.f10992g = c.a.p0.q.o.e.c(absolutePath, this.f10990e.f10989b.l);
            }
            File file = this.f10992g;
            if (file == null) {
                k.i("PMSDownloadTask", "#checkAndCreateFile generateFilePath=null");
                this.f10994i.e(this.f10991f, new c.a.p0.q.h.b(2203, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH));
                return false;
            }
            this.f10990e.f10989b.a = file.getAbsolutePath();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d(f<T> fVar) {
        InterceptResult invokeL;
        e eVar;
        c.a.p0.q.h.f fVar2;
        e eVar2;
        c.a.p0.q.h.f fVar3;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) ? (fVar == null || (eVar = fVar.f10990e) == null || (fVar2 = eVar.f10989b) == null || (eVar2 = this.f10990e) == null || (fVar3 = eVar2.f10989b) == null || !fVar3.equals(fVar2)) ? false : true : invokeL.booleanValue;
    }

    public c.a.p0.q.e.e<T> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f10994i : (c.a.p0.q.e.e) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f10991f : (T) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new c.a.p0.q.i.i.d.a().a(this.f10994i.k()).intValue() : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c<T> cVar = this.f10994i;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Objects.hash(this.f10990e.f10989b) : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f10990e.f10989b.f10959e : invokeV.intValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean j(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j2)) == null) {
            String d2 = this.f10994i.d(this.f10991f);
            if (d2 == null) {
                return false;
            }
            try {
                StatFs statFs = new StatFs(d2);
                return Build.VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong() > j2 : ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) > j2;
            } catch (Throwable th) {
                k.g("PMSDownloadTask", "#hasSpaceToWrite 异常或者磁盘空间不足", th);
                return false;
            }
        }
        return invokeJ.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f10995j : invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f10994i.a(this.f10991f);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b(3);
            this.f10994i.e(this.f10991f, this.f10990e.a);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            b(10);
            this.f10994i.i(this.f10991f);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f10995j = true;
            s(true);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b(1);
            this.f10994i.c(this.f10991f);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b(2);
            this.f10994i.j(this.f10991f);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            if (z) {
                this.f10990e.f10989b.f10956b = 0L;
            }
            b(0);
            s(false);
            this.f10995j = false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048596, this) != null) {
            return;
        }
        String fVar = this.f10990e.f10989b.toString();
        k.i("PMSDownloadTask", "#run 开始下包 pkg=" + fVar);
        j jVar = new j(this, h());
        while (true) {
            c.a.p0.q.h.b bVar = this.f10990e.a;
            if (bVar != null && bVar.a == 2200) {
                return;
            }
            if (this.f10993h.get()) {
                k.i("PMSDownloadTask", "#run 已经取消下包 pkg=" + fVar);
                q();
                return;
            }
            jVar.b();
            c.a.p0.q.h.b bVar2 = this.f10990e.a;
            if (bVar2 != null) {
                if (bVar2.a != 2200) {
                    if (this.f10993h.get()) {
                        k.i("PMSDownloadTask", "#run 运行中取消下包 pkg=" + fVar);
                        q();
                        return;
                    }
                    this.f10994i.f10987f++;
                    k.i("PMSDownloadTask", "#run 下载出错 pkg=" + fVar + " retryCount=" + this.f10994i.f10987f);
                    if (this.f10994i.f10987f < 3) {
                        try {
                            if (!this.f10993h.get()) {
                                Thread.sleep(this.f10994i.f10987f * 1000);
                            }
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        m();
                        e eVar = this.f10990e;
                        a(eVar.a.a, eVar.f10989b);
                        return;
                    }
                } else {
                    k.i("PMSDownloadTask", "#run 下包成功 pkg=" + fVar);
                    n();
                    return;
                }
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || this.f10993h.get() == z) {
            return;
        }
        this.f10993h.set(z);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "downloadUrl:" + this.f10990e.f10989b.n + ",versionName:" + this.f10990e.f10989b.f10964j + ",versionCode:" + this.f10990e.f10989b.f10963i + "md5:" + this.f10990e.f10989b.l + "bundleId:" + this.f10990e.f10989b.f10961g;
        }
        return (String) invokeV.objValue;
    }
}
