package b.a.p0.q.j.i.g;

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
/* loaded from: classes4.dex */
public class f<T> implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final b.a.p0.q.p.a k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f11814e;

    /* renamed from: f  reason: collision with root package name */
    public T f11815f;

    /* renamed from: g  reason: collision with root package name */
    public File f11816g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f11817h;

    /* renamed from: i  reason: collision with root package name */
    public c<T> f11818i;
    public boolean j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-955823538, "Lb/a/p0/q/j/i/g/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-955823538, "Lb/a/p0/q/j/i/g/f;");
                return;
            }
        }
        k = b.a.p0.q.p.a.e();
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
        this.f11817h = new AtomicBoolean(false);
        this.f11814e = eVar;
        this.f11815f = t;
        this.f11818i = cVar;
    }

    public final void a(int i2, b.a.p0.q.i.f fVar) {
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
        if (fVar instanceof b.a.p0.q.i.g) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, fVar.f11774g);
        }
        b.a.p0.q.n.a.a(fVar.f11775h, "pkg_download", null, i2, jSONObject);
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            b.a.p0.q.i.f fVar = this.f11814e.f11813b;
            if (fVar.f11772e != i2) {
                fVar.f11772e = i2;
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
            if (!TextUtils.isEmpty(this.f11814e.f11813b.f11768a)) {
                k.i("PMSDownloadTask", "#checkAndCreateFile mParam.pmsPackage.filePath 为空");
                return true;
            }
            File c2 = b.a.p0.q.p.e.c(this.f11818i.d(this.f11815f), this.f11814e.f11813b.l);
            this.f11816g = c2;
            if (c2 == null) {
                String absolutePath = b.a.p0.p.b.b().getAppContext().getCacheDir().getAbsolutePath();
                b.a.p0.q.p.a aVar = k;
                aVar.i("PMSDownloadTask", "#checkAndCreateFile mLocalFile=null cacheDir=" + absolutePath);
                this.f11816g = b.a.p0.q.p.e.c(absolutePath, this.f11814e.f11813b.l);
            }
            File file = this.f11816g;
            if (file == null) {
                k.i("PMSDownloadTask", "#checkAndCreateFile generateFilePath=null");
                this.f11818i.e(this.f11815f, new b.a.p0.q.i.b(2203, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH));
                return false;
            }
            this.f11814e.f11813b.f11768a = file.getAbsolutePath();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d(f<T> fVar) {
        InterceptResult invokeL;
        e eVar;
        b.a.p0.q.i.f fVar2;
        e eVar2;
        b.a.p0.q.i.f fVar3;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) ? (fVar == null || (eVar = fVar.f11814e) == null || (fVar2 = eVar.f11813b) == null || (eVar2 = this.f11814e) == null || (fVar3 = eVar2.f11813b) == null || !fVar3.equals(fVar2)) ? false : true : invokeL.booleanValue;
    }

    public b.a.p0.q.f.e<T> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f11818i : (b.a.p0.q.f.e) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f11815f : (T) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new b.a.p0.q.j.i.d.a().a(this.f11818i.k()).intValue() : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c<T> cVar = this.f11818i;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Objects.hash(this.f11814e.f11813b) : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f11814e.f11813b.f11772e : invokeV.intValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            String d2 = this.f11818i.d(this.f11815f);
            if (d2 == null) {
                return false;
            }
            try {
                StatFs statFs = new StatFs(d2);
                return Build.VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong() > j : ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) > j;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f11818i.a(this.f11815f);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b(3);
            this.f11818i.e(this.f11815f, this.f11814e.f11812a);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            b(10);
            this.f11818i.i(this.f11815f);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.j = true;
            s(true);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b(1);
            this.f11818i.c(this.f11815f);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b(2);
            this.f11818i.j(this.f11815f);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            if (z) {
                this.f11814e.f11813b.f11769b = 0L;
            }
            b(0);
            s(false);
            this.j = false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048596, this) != null) {
            return;
        }
        String fVar = this.f11814e.f11813b.toString();
        k.i("PMSDownloadTask", "#run 开始下包 pkg=" + fVar);
        j jVar = new j(this, h());
        while (true) {
            b.a.p0.q.i.b bVar = this.f11814e.f11812a;
            if (bVar != null && bVar.f11762a == 2200) {
                return;
            }
            if (this.f11817h.get()) {
                k.i("PMSDownloadTask", "#run 已经取消下包 pkg=" + fVar);
                q();
                return;
            }
            jVar.b();
            b.a.p0.q.i.b bVar2 = this.f11814e.f11812a;
            if (bVar2 != null) {
                if (bVar2.f11762a != 2200) {
                    if (this.f11817h.get()) {
                        k.i("PMSDownloadTask", "#run 运行中取消下包 pkg=" + fVar);
                        q();
                        return;
                    }
                    this.f11818i.f11809f++;
                    k.i("PMSDownloadTask", "#run 下载出错 pkg=" + fVar + " retryCount=" + this.f11818i.f11809f);
                    if (this.f11818i.f11809f < 3) {
                        try {
                            if (!this.f11817h.get()) {
                                Thread.sleep(this.f11818i.f11809f * 1000);
                            }
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        m();
                        e eVar = this.f11814e;
                        a(eVar.f11812a.f11762a, eVar.f11813b);
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
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || this.f11817h.get() == z) {
            return;
        }
        this.f11817h.set(z);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "downloadUrl:" + this.f11814e.f11813b.n + ",versionName:" + this.f11814e.f11813b.j + ",versionCode:" + this.f11814e.f11813b.f11776i + "md5:" + this.f11814e.f11813b.l + "bundleId:" + this.f11814e.f11813b.f11774g;
        }
        return (String) invokeV.objValue;
    }
}
