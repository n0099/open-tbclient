package c.a.p0.q.j.i.g;

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
/* loaded from: classes5.dex */
public class f<T> implements Runnable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final c.a.p0.q.p.a f10747k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f10748e;

    /* renamed from: f  reason: collision with root package name */
    public T f10749f;

    /* renamed from: g  reason: collision with root package name */
    public File f10750g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f10751h;

    /* renamed from: i  reason: collision with root package name */
    public c<T> f10752i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f10753j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(397486159, "Lc/a/p0/q/j/i/g/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(397486159, "Lc/a/p0/q/j/i/g/f;");
                return;
            }
        }
        f10747k = c.a.p0.q.p.a.e();
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
        this.f10751h = new AtomicBoolean(false);
        this.f10748e = eVar;
        this.f10749f = t;
        this.f10752i = cVar;
    }

    public final void a(int i2, c.a.p0.q.i.f fVar) {
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
                f10747k.g("PMSDownloadTask", "#addStatistic json put data出错", e2);
            }
        }
        if (fVar instanceof c.a.p0.q.i.g) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, fVar.f10717g);
        }
        c.a.p0.q.n.a.a(fVar.f10718h, "pkg_download", null, i2, jSONObject);
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            c.a.p0.q.i.f fVar = this.f10748e.f10746b;
            if (fVar.f10715e != i2) {
                fVar.f10715e = i2;
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
            if (!TextUtils.isEmpty(this.f10748e.f10746b.a)) {
                f10747k.i("PMSDownloadTask", "#checkAndCreateFile mParam.pmsPackage.filePath 为空");
                return true;
            }
            File c2 = c.a.p0.q.p.e.c(this.f10752i.d(this.f10749f), this.f10748e.f10746b.l);
            this.f10750g = c2;
            if (c2 == null) {
                String absolutePath = c.a.p0.p.b.b().getAppContext().getCacheDir().getAbsolutePath();
                c.a.p0.q.p.a aVar = f10747k;
                aVar.i("PMSDownloadTask", "#checkAndCreateFile mLocalFile=null cacheDir=" + absolutePath);
                this.f10750g = c.a.p0.q.p.e.c(absolutePath, this.f10748e.f10746b.l);
            }
            File file = this.f10750g;
            if (file == null) {
                f10747k.i("PMSDownloadTask", "#checkAndCreateFile generateFilePath=null");
                this.f10752i.e(this.f10749f, new c.a.p0.q.i.b(2203, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH));
                return false;
            }
            this.f10748e.f10746b.a = file.getAbsolutePath();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d(f<T> fVar) {
        InterceptResult invokeL;
        e eVar;
        c.a.p0.q.i.f fVar2;
        e eVar2;
        c.a.p0.q.i.f fVar3;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) ? (fVar == null || (eVar = fVar.f10748e) == null || (fVar2 = eVar.f10746b) == null || (eVar2 = this.f10748e) == null || (fVar3 = eVar2.f10746b) == null || !fVar3.equals(fVar2)) ? false : true : invokeL.booleanValue;
    }

    public c.a.p0.q.f.e<T> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f10752i : (c.a.p0.q.f.e) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f10749f : (T) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new c.a.p0.q.j.i.d.a().a(this.f10752i.k()).intValue() : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c<T> cVar = this.f10752i;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Objects.hash(this.f10748e.f10746b) : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f10748e.f10746b.f10715e : invokeV.intValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean j(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j2)) == null) {
            String d2 = this.f10752i.d(this.f10749f);
            if (d2 == null) {
                return false;
            }
            try {
                StatFs statFs = new StatFs(d2);
                return Build.VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong() > j2 : ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) > j2;
            } catch (Throwable th) {
                f10747k.g("PMSDownloadTask", "#hasSpaceToWrite 异常或者磁盘空间不足", th);
                return false;
            }
        }
        return invokeJ.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f10753j : invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f10752i.a(this.f10749f);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b(3);
            this.f10752i.e(this.f10749f, this.f10748e.a);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            b(10);
            this.f10752i.i(this.f10749f);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f10753j = true;
            s(true);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b(1);
            this.f10752i.c(this.f10749f);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b(2);
            this.f10752i.j(this.f10749f);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            if (z) {
                this.f10748e.f10746b.f10712b = 0L;
            }
            b(0);
            s(false);
            this.f10753j = false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048596, this) != null) {
            return;
        }
        String fVar = this.f10748e.f10746b.toString();
        f10747k.i("PMSDownloadTask", "#run 开始下包 pkg=" + fVar);
        j jVar = new j(this, h());
        while (true) {
            c.a.p0.q.i.b bVar = this.f10748e.a;
            if (bVar != null && bVar.a == 2200) {
                return;
            }
            if (this.f10751h.get()) {
                f10747k.i("PMSDownloadTask", "#run 已经取消下包 pkg=" + fVar);
                q();
                return;
            }
            jVar.b();
            c.a.p0.q.i.b bVar2 = this.f10748e.a;
            if (bVar2 != null) {
                if (bVar2.a != 2200) {
                    if (this.f10751h.get()) {
                        f10747k.i("PMSDownloadTask", "#run 运行中取消下包 pkg=" + fVar);
                        q();
                        return;
                    }
                    this.f10752i.f10744f++;
                    f10747k.i("PMSDownloadTask", "#run 下载出错 pkg=" + fVar + " retryCount=" + this.f10752i.f10744f);
                    if (this.f10752i.f10744f < 3) {
                        try {
                            if (!this.f10751h.get()) {
                                Thread.sleep(this.f10752i.f10744f * 1000);
                            }
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        m();
                        e eVar = this.f10748e;
                        a(eVar.a.a, eVar.f10746b);
                        return;
                    }
                } else {
                    f10747k.i("PMSDownloadTask", "#run 下包成功 pkg=" + fVar);
                    n();
                    return;
                }
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || this.f10751h.get() == z) {
            return;
        }
        this.f10751h.set(z);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "downloadUrl:" + this.f10748e.f10746b.n + ",versionName:" + this.f10748e.f10746b.f10720j + ",versionCode:" + this.f10748e.f10746b.f10719i + "md5:" + this.f10748e.f10746b.l + "bundleId:" + this.f10748e.f10746b.f10717g;
        }
        return (String) invokeV.objValue;
    }
}
