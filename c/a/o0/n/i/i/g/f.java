package c.a.o0.n.i.i.g;

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
/* loaded from: classes3.dex */
public class f<T> implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f11900e;

    /* renamed from: f  reason: collision with root package name */
    public T f11901f;

    /* renamed from: g  reason: collision with root package name */
    public File f11902g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f11903h;

    /* renamed from: i  reason: collision with root package name */
    public c<T> f11904i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f11905j;

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
        this.f11903h = new AtomicBoolean(false);
        this.f11900e = eVar;
        this.f11901f = t;
        this.f11904i = cVar;
    }

    public final void a(int i2, c.a.o0.n.h.e eVar) {
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
        if (eVar instanceof c.a.o0.n.h.f) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, eVar.f11857g);
        }
        c.a.o0.n.m.a.a(eVar.f11858h, "pkg_download", null, i2, jSONObject);
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            c.a.o0.n.h.e eVar = this.f11900e.f11899b;
            if (eVar.f11855e != i2) {
                eVar.f11855e = i2;
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
            if (TextUtils.isEmpty(this.f11900e.f11899b.f11851a)) {
                File b2 = c.a.o0.n.o.d.b(this.f11904i.d(this.f11901f), this.f11900e.f11899b.l);
                this.f11902g = b2;
                if (b2 == null) {
                    this.f11902g = c.a.o0.n.o.d.b(c.a.o0.m.b.b().getAppContext().getCacheDir().getAbsolutePath(), this.f11900e.f11899b.l);
                }
                File file = this.f11902g;
                if (file == null) {
                    this.f11904i.e(this.f11901f, new c.a.o0.n.h.a(2203, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH));
                    return false;
                }
                this.f11900e.f11899b.f11851a = file.getAbsolutePath();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d(f<T> fVar) {
        InterceptResult invokeL;
        e eVar;
        c.a.o0.n.h.e eVar2;
        e eVar3;
        c.a.o0.n.h.e eVar4;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) ? (fVar == null || (eVar = fVar.f11900e) == null || (eVar2 = eVar.f11899b) == null || (eVar3 = this.f11900e) == null || (eVar4 = eVar3.f11899b) == null || !eVar4.equals(eVar2)) ? false : true : invokeL.booleanValue;
    }

    public c.a.o0.n.f.c<T> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f11904i : (c.a.o0.n.f.c) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f11901f : (T) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new c.a.o0.n.i.i.d.a().a(this.f11904i.k()).intValue() : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f11900e.f11899b.f11855e : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Objects.hash(this.f11900e.f11899b) : invokeV.intValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean i(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
            String d2 = this.f11904i.d(this.f11901f);
            if (d2 == null) {
                return false;
            }
            try {
                StatFs statFs = new StatFs(d2);
                return Build.VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong() > j2 : ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) > j2;
            } catch (Throwable th) {
                if (c.a.o0.n.c.f11828a) {
                    String str = c.a.o0.n.c.b().v() + ": path exception or no space left." + th.toString();
                }
                return false;
            }
        }
        return invokeJ.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f11905j : invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f11904i.a(this.f11901f);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b(3);
            this.f11904i.e(this.f11901f, this.f11900e.f11898a);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b(10);
            this.f11904i.i(this.f11901f);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (c.a.o0.n.c.f11828a) {
                String str = c.a.o0.n.c.b().v() + ": onNotifyPending" + this;
            }
            this.f11905j = true;
            r(true);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            b(1);
            this.f11904i.c(this.f11901f);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b(2);
            this.f11904i.j(this.f11901f);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (c.a.o0.n.c.f11828a) {
                String str = c.a.o0.n.c.b().v() + ": onResetPending" + this;
            }
            if (z) {
                this.f11900e.f11899b.f11852b = 0L;
            }
            b(0);
            r(false);
            this.f11905j = false;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || this.f11903h.get() == z) {
            return;
        }
        this.f11903h.set(z);
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048596, this) != null) {
            return;
        }
        if (c.a.o0.n.c.f11828a) {
            String str = c.a.o0.n.c.b().v() + ": run:" + this.f11900e.f11899b.n;
        }
        j jVar = new j(this);
        while (true) {
            c.a.o0.n.h.a aVar = this.f11900e.f11898a;
            if (aVar != null && aVar.f11847a == 2200) {
                return;
            }
            if (this.f11903h.get()) {
                if (c.a.o0.n.c.f11828a) {
                    String str2 = c.a.o0.n.c.b().v() + ": stopped:" + this.f11900e.f11899b.n;
                }
                p();
                return;
            }
            jVar.b();
            c.a.o0.n.h.a aVar2 = this.f11900e.f11898a;
            if (aVar2 != null) {
                if (aVar2.f11847a != 2200) {
                    if (this.f11903h.get()) {
                        if (c.a.o0.n.c.f11828a) {
                            String str3 = c.a.o0.n.c.b().v() + ": stopped:" + this.f11900e.f11899b.n;
                        }
                        p();
                        return;
                    }
                    if (c.a.o0.n.c.f11828a) {
                        String str4 = c.a.o0.n.c.b().v() + ": retry download:" + this.f11900e.f11899b.n;
                    }
                    c<T> cVar = this.f11904i;
                    int i2 = cVar.f11895f + 1;
                    cVar.f11895f = i2;
                    if (i2 < 3) {
                        try {
                            if (!this.f11903h.get()) {
                                Thread.sleep(this.f11904i.f11895f * 1000);
                            }
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        l();
                        e eVar = this.f11900e;
                        a(eVar.f11898a.f11847a, eVar.f11899b);
                        return;
                    }
                } else {
                    if (c.a.o0.n.c.f11828a) {
                        String str5 = c.a.o0.n.c.b().v() + ": success download:" + this.f11900e.f11899b.n;
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
            return "downloadUrl:" + this.f11900e.f11899b.n + ",versionName:" + this.f11900e.f11899b.f11860j + ",versionCode:" + this.f11900e.f11899b.f11859i + "md5:" + this.f11900e.f11899b.l + "bundleId:" + this.f11900e.f11899b.f11857g;
        }
        return (String) invokeV.objValue;
    }
}
