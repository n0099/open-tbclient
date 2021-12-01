package c.a.l.i;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.system.Os;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.l.g;
import c.a.l.i.a;
import c.a.l.l.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.l.i.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a.C0150a f3735f;

    /* renamed from: g  reason: collision with root package name */
    public b f3736g;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a(a.C0150a c0150a, c.a.l.l.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, c0150a, aVar)) == null) {
                if (Build.VERSION.SDK_INT < 23) {
                    while (c0150a != null && !c0150a.g().equals(aVar.a())) {
                        c0150a.g().setExecutable(true, false);
                        c0150a = c0150a.i();
                    }
                    return true;
                }
                while (c0150a != null) {
                    if (!b(c0150a.g())) {
                        return false;
                    }
                    c0150a = c0150a.i();
                }
                return b(aVar.a());
            }
            return invokeLL.booleanValue;
        }

        public static boolean b(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        int i2 = Os.stat(file.getAbsolutePath()).st_mode;
                        if ((i2 & 1) == 0) {
                            Os.chmod(file.getAbsolutePath(), i2 | 1);
                        }
                        return true;
                    } catch (Throwable unused) {
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.l.m.b a;

        /* renamed from: b  reason: collision with root package name */
        public long f3737b;

        /* renamed from: c  reason: collision with root package name */
        public g.a f3738c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3739d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3740e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f3741f;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3741f = cVar;
            this.a = new c.a.l.m.b();
            this.f3740e = true;
        }

        public g.a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3738c : (g.a) invokeV.objValue;
        }

        public void b(long j2, long j3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) && this.a.a(j2, j3)) {
                this.f3739d = true;
            }
        }

        public void c(g.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar.equals(this.f3738c)) {
                return;
            }
            this.f3738c = aVar;
            this.f3739d = true;
        }

        public boolean d(PackageInfo packageInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, packageInfo)) == null) {
                String c2 = this.f3741f.f3735f.a(new File(packageInfo.applicationInfo.dataDir)).c("pub.dat", true);
                this.f3740e = false;
                return e(c2);
            }
            return invokeL.booleanValue;
        }

        public final boolean e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        this.f3737b = jSONObject.getLong("pub_lst_ts");
                        this.f3738c = g.l(jSONObject.getString("pub_info"));
                        jSONObject.getInt("d_form_ver");
                        this.f3739d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3737b : invokeV.longValue;
        }

        public void g(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) || this.f3737b == j2) {
                return;
            }
            this.f3737b = j2;
            this.f3739d = true;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? c.i(this.f3741f.f3735f.b("pub.dat"), true) : invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.f3740e) {
                    if (this.f3739d) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("pub_info", this.f3738c.x());
                            jSONObject.put("pub_lst_ts", this.f3737b);
                            jSONObject.put("d_form_ver", 1);
                            this.f3741f.f3735f.e("pub.dat", jSONObject.toString(), true);
                            this.f3739d = false;
                            return true;
                        } catch (Exception unused) {
                        }
                    }
                    return false;
                }
                throw new IllegalStateException();
            }
            return invokeV.booleanValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? e(this.f3741f.f3735f.c("pub.dat", true)) : invokeV.booleanValue;
        }
    }

    /* renamed from: c.a.l.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0148c extends a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f3742d;

        /* renamed from: e  reason: collision with root package name */
        public long f3743e;

        /* renamed from: f  reason: collision with root package name */
        public long f3744f;

        /* renamed from: g  reason: collision with root package name */
        public long f3745g;

        /* renamed from: h  reason: collision with root package name */
        public g.a f3746h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0148c(c cVar, String str) {
            super(cVar.f3735f, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a.C0150a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.l.i.a.c
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f3742d = jSONObject.getString("pkg");
                this.f3744f = jSONObject.getInt("tar_pkg_lst_pub_ts");
                this.f3743e = jSONObject.getLong("last_fe_ts");
                this.f3746h = g.l(jSONObject.getString("info"));
                this.f3745g = jSONObject.getLong("tar_pkg_lst_up_ts");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // c.a.l.i.a.c
        public void d(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.f3742d);
                jSONObject.put("last_fe_ts", this.f3743e);
                jSONObject.put("tar_pkg_lst_pub_ts", this.f3744f);
                jSONObject.put("info", this.f3746h.x());
                jSONObject.put("tar_pkg_lst_up_ts", this.f3745g);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public void f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
                h(bVar.a());
                j(bVar.f());
            }
        }

        public boolean g(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
                if (this.f3743e != j2) {
                    this.f3743e = j2;
                    b(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public boolean h(g.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
                if (aVar.equals(this.f3746h)) {
                    return false;
                }
                this.f3746h = aVar;
                b(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                if (str.equals(this.f3742d)) {
                    return false;
                }
                this.f3742d = str;
                b(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public boolean j(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                if (this.f3744f != j2) {
                    this.f3744f = j2;
                    b(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public g.a k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f3746h : (g.a) invokeV.objValue;
        }

        public boolean l(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) {
                if (this.f3745g != j2) {
                    this.f3745g = j2;
                    b(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public long m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f3745g : invokeV.longValue;
        }

        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f3742d : (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c() {
        super("isc", 8000000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], ((Long) objArr[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3736g = new b(this);
    }

    public static boolean i(File file, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, file, z)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    Os.chmod(file.getAbsolutePath(), z ? 436 : 432);
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }
            try {
                if (z) {
                    return file.setReadable(true, false);
                }
                return file.setReadable(false, false) && file.setReadable(true, true);
            } catch (Throwable unused2) {
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    @Override // c.a.l.i.a
    public a.f a(a.e eVar, g.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, aVar)) == null) {
            Context context = this.a.a;
            if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
                this.f3736g.j();
                try {
                    return h(eVar, aVar);
                } finally {
                    this.f3736g.i();
                    j();
                    this.f3736g.i();
                    this.f3736g.h();
                }
            }
            return a.f.b(-100);
        }
        return (a.f) invokeLL.objValue;
    }

    @Override // c.a.l.i.a
    public a.h b(String str, a.g gVar) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        g.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, gVar)) == null) {
            C0148c c0148c = null;
            boolean z = false;
            try {
                packageInfo = this.a.a.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return a.h.b(-2);
            }
            if (gVar.a) {
                c0148c = new C0148c(this, str);
                c0148c.e();
                if (str.equals(c0148c.n())) {
                    g.a k2 = c0148c.k();
                    boolean z2 = packageInfo.lastUpdateTime == c0148c.m();
                    if (k2 != null && k2.m() && !TextUtils.isEmpty(k2.u())) {
                        z = true;
                    }
                    if (z2 && z) {
                        a2 = c0148c.k();
                        return a.h.c(a2);
                    }
                }
            }
            b bVar = new b(this);
            if (bVar.d(packageInfo)) {
                if (gVar.a && c0148c != null) {
                    c0148c.f(bVar);
                    c0148c.g(System.currentTimeMillis());
                    c0148c.l(packageInfo.lastUpdateTime);
                    c0148c.i(str);
                    c0148c.c();
                }
                a2 = bVar.a();
                return a.h.c(a2);
            }
            return a.h.b(-2);
        }
        return (a.h) invokeLL.objValue;
    }

    @Override // c.a.l.i.a
    public void e(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f3735f = this.f3728b.f("isc");
        }
    }

    public final a.f h(a.e eVar, g.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, eVar, aVar)) == null) {
            this.f3736g.j();
            this.f3735f.d();
            if (aVar.equals(this.f3736g.a())) {
                return a.f.c();
            }
            this.f3736g.c(aVar);
            this.f3736g.g(System.currentTimeMillis());
            return a.f.c();
        }
        return (a.f) invokeLL.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f3736g.b(a.a(this.f3735f, this.a.f3731b) ? 1 : 2, 3L);
        }
    }
}
