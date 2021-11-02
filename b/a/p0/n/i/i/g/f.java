package b.a.p0.n.i.i.g;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.ErrorConstant;
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
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f11118e;

    /* renamed from: f  reason: collision with root package name */
    public T f11119f;

    /* renamed from: g  reason: collision with root package name */
    public File f11120g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f11121h;

    /* renamed from: i  reason: collision with root package name */
    public c<T> f11122i;
    public boolean j;

    public f(e eVar, T t, c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, t, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11121h = new AtomicBoolean(false);
        this.f11118e = eVar;
        this.f11119f = t;
        this.f11122i = cVar;
    }

    public final void a(int i2, b.a.p0.n.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, eVar) == null) || eVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (i2 == 2200) {
            i2 = 0;
        } else {
            try {
                jSONObject.put("response", eVar.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (eVar instanceof b.a.p0.n.h.f) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, eVar.f11076g);
        }
        b.a.p0.n.m.a.a(eVar.f11077h, "pkg_download", null, i2, jSONObject);
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            b.a.p0.n.h.e eVar = this.f11118e.f11117b;
            if (eVar.f11074e != i2) {
                eVar.f11074e = i2;
                if (i2 != 2 && i2 != 3 && i2 != 10) {
                    r(false);
                } else {
                    r(true);
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
            if (TextUtils.isEmpty(this.f11118e.f11117b.f11070a)) {
                File b2 = b.a.p0.n.o.d.b(this.f11122i.d(this.f11119f), this.f11118e.f11117b.l);
                this.f11120g = b2;
                if (b2 == null) {
                    this.f11120g = b.a.p0.n.o.d.b(b.a.p0.m.b.b().getAppContext().getCacheDir().getAbsolutePath(), this.f11118e.f11117b.l);
                }
                File file = this.f11120g;
                if (file == null) {
                    this.f11122i.e(this.f11119f, new b.a.p0.n.h.a(2203, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH));
                    return false;
                }
                this.f11118e.f11117b.f11070a = file.getAbsolutePath();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d(f<T> fVar) {
        InterceptResult invokeL;
        e eVar;
        b.a.p0.n.h.e eVar2;
        e eVar3;
        b.a.p0.n.h.e eVar4;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) ? (fVar == null || (eVar = fVar.f11118e) == null || (eVar2 = eVar.f11117b) == null || (eVar3 = this.f11118e) == null || (eVar4 = eVar3.f11117b) == null || !eVar4.equals(eVar2)) ? false : true : invokeL.booleanValue;
    }

    public b.a.p0.n.f.c<T> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f11122i : (b.a.p0.n.f.c) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f11119f : (T) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new b.a.p0.n.i.i.d.a().a(this.f11122i.k()).intValue() : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f11118e.f11117b.f11074e : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Objects.hash(this.f11118e.f11117b) : invokeV.intValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean i(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
            String d2 = this.f11122i.d(this.f11119f);
            if (d2 == null) {
                return false;
            }
            try {
                StatFs statFs = new StatFs(d2);
                return Build.VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong() > j : ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) > j;
            } catch (Throwable th) {
                if (b.a.p0.n.c.f11048a) {
                    String str = b.a.p0.n.c.b().v() + ": path exception or no space left." + th.toString();
                }
                return false;
            }
        }
        return invokeJ.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f11122i.a(this.f11119f);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b(3);
            this.f11122i.e(this.f11119f, this.f11118e.f11116a);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b(10);
            this.f11122i.i(this.f11119f);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (b.a.p0.n.c.f11048a) {
                String str = b.a.p0.n.c.b().v() + ": onNotifyPending" + this;
            }
            this.j = true;
            r(true);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            b(1);
            this.f11122i.c(this.f11119f);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b(2);
            this.f11122i.j(this.f11119f);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (b.a.p0.n.c.f11048a) {
                String str = b.a.p0.n.c.b().v() + ": onResetPending" + this;
            }
            if (z) {
                this.f11118e.f11117b.f11071b = 0L;
            }
            b(0);
            r(false);
            this.j = false;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || this.f11121h.get() == z) {
            return;
        }
        this.f11121h.set(z);
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048596, this) != null) {
            return;
        }
        if (b.a.p0.n.c.f11048a) {
            String str = b.a.p0.n.c.b().v() + ": run:" + this.f11118e.f11117b.n;
        }
        j jVar = new j(this);
        while (true) {
            b.a.p0.n.h.a aVar = this.f11118e.f11116a;
            if (aVar != null && aVar.f11066a == 2200) {
                return;
            }
            if (this.f11121h.get()) {
                if (b.a.p0.n.c.f11048a) {
                    String str2 = b.a.p0.n.c.b().v() + ": stopped:" + this.f11118e.f11117b.n;
                }
                p();
                return;
            }
            jVar.b();
            b.a.p0.n.h.a aVar2 = this.f11118e.f11116a;
            if (aVar2 != null) {
                if (aVar2.f11066a != 2200) {
                    if (this.f11121h.get()) {
                        if (b.a.p0.n.c.f11048a) {
                            String str3 = b.a.p0.n.c.b().v() + ": stopped:" + this.f11118e.f11117b.n;
                        }
                        p();
                        return;
                    }
                    if (b.a.p0.n.c.f11048a) {
                        String str4 = b.a.p0.n.c.b().v() + ": retry download:" + this.f11118e.f11117b.n;
                    }
                    c<T> cVar = this.f11122i;
                    int i2 = cVar.f11113f + 1;
                    cVar.f11113f = i2;
                    if (i2 < 3) {
                        try {
                            if (!this.f11121h.get()) {
                                Thread.sleep(this.f11122i.f11113f * 1000);
                            }
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        l();
                        e eVar = this.f11118e;
                        a(eVar.f11116a.f11066a, eVar.f11117b);
                        return;
                    }
                } else {
                    if (b.a.p0.n.c.f11048a) {
                        String str5 = b.a.p0.n.c.b().v() + ": success download:" + this.f11118e.f11117b.n;
                    }
                    m();
                    return;
                }
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return "downloadUrl:" + this.f11118e.f11117b.n + ",versionName:" + this.f11118e.f11117b.j + ",versionCode:" + this.f11118e.f11117b.f11078i + "md5:" + this.f11118e.f11117b.l + "bundleId:" + this.f11118e.f11117b.f11076g;
        }
        return (String) invokeV.objValue;
    }
}
