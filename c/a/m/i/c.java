package c.a.m.i;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.system.Os;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.m.g;
import c.a.m.i.a;
import c.a.m.l.a;
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
public class c extends c.a.m.i.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a.C0208a f4172f;

    /* renamed from: g  reason: collision with root package name */
    public b f4173g;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a(a.C0208a c0208a, c.a.m.l.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, c0208a, aVar)) == null) {
                if (Build.VERSION.SDK_INT < 23) {
                    while (c0208a != null && !c0208a.g().equals(aVar.a())) {
                        c0208a.g().setExecutable(true, false);
                        c0208a = c0208a.i();
                    }
                    return true;
                }
                while (c0208a != null) {
                    if (!b(c0208a.g())) {
                        return false;
                    }
                    c0208a = c0208a.i();
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
        public c.a.m.m.b a;

        /* renamed from: b  reason: collision with root package name */
        public long f4174b;

        /* renamed from: c  reason: collision with root package name */
        public g.a f4175c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4176d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4177e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f4178f;

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
            this.f4178f = cVar;
            this.a = new c.a.m.m.b();
            this.f4177e = true;
        }

        public g.a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f4175c : (g.a) invokeV.objValue;
        }

        public void b(long j2, long j3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) && this.a.a(j2, j3)) {
                this.f4176d = true;
            }
        }

        public void c(g.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar.equals(this.f4175c)) {
                return;
            }
            this.f4175c = aVar;
            this.f4176d = true;
        }

        public boolean d(PackageInfo packageInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, packageInfo)) == null) {
                String c2 = this.f4178f.f4172f.a(new File(packageInfo.applicationInfo.dataDir)).c("pub.dat", true);
                this.f4177e = false;
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
                        this.f4174b = jSONObject.getLong("pub_lst_ts");
                        this.f4175c = g.l(jSONObject.getString("pub_info"));
                        jSONObject.getInt("d_form_ver");
                        this.f4176d = false;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f4174b : invokeV.longValue;
        }

        public void g(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) || this.f4174b == j2) {
                return;
            }
            this.f4174b = j2;
            this.f4176d = true;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? c.i(this.f4178f.f4172f.b("pub.dat"), true) : invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.f4177e) {
                    if (this.f4176d) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("pub_info", this.f4175c.x());
                            jSONObject.put("pub_lst_ts", this.f4174b);
                            jSONObject.put("d_form_ver", 1);
                            this.f4178f.f4172f.e("pub.dat", jSONObject.toString(), true);
                            this.f4176d = false;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? e(this.f4178f.f4172f.c("pub.dat", true)) : invokeV.booleanValue;
        }
    }

    /* renamed from: c.a.m.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0206c extends a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f4179d;

        /* renamed from: e  reason: collision with root package name */
        public long f4180e;

        /* renamed from: f  reason: collision with root package name */
        public long f4181f;

        /* renamed from: g  reason: collision with root package name */
        public long f4182g;

        /* renamed from: h  reason: collision with root package name */
        public g.a f4183h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0206c(c cVar, String str) {
            super(cVar.f4172f, str);
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
                    super((a.C0208a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.m.i.a.c
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f4179d = jSONObject.getString("pkg");
                this.f4181f = jSONObject.getInt("tar_pkg_lst_pub_ts");
                this.f4180e = jSONObject.getLong("last_fe_ts");
                this.f4183h = g.l(jSONObject.getString("info"));
                this.f4182g = jSONObject.getLong("tar_pkg_lst_up_ts");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // c.a.m.i.a.c
        public void d(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.f4179d);
                jSONObject.put("last_fe_ts", this.f4180e);
                jSONObject.put("tar_pkg_lst_pub_ts", this.f4181f);
                jSONObject.put("info", this.f4183h.x());
                jSONObject.put("tar_pkg_lst_up_ts", this.f4182g);
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
                if (this.f4180e != j2) {
                    this.f4180e = j2;
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
                if (aVar.equals(this.f4183h)) {
                    return false;
                }
                this.f4183h = aVar;
                b(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                if (str.equals(this.f4179d)) {
                    return false;
                }
                this.f4179d = str;
                b(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public boolean j(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                if (this.f4181f != j2) {
                    this.f4181f = j2;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f4183h : (g.a) invokeV.objValue;
        }

        public boolean l(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) {
                if (this.f4182g != j2) {
                    this.f4182g = j2;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f4182g : invokeV.longValue;
        }

        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f4179d : (String) invokeV.objValue;
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
        this.f4173g = new b(this);
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

    @Override // c.a.m.i.a
    public a.f a(a.e eVar, g.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, aVar)) == null) {
            Context context = this.a.a;
            if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
                this.f4173g.j();
                try {
                    return h(eVar, aVar);
                } finally {
                    this.f4173g.i();
                    j();
                    this.f4173g.i();
                    this.f4173g.h();
                }
            }
            return a.f.b(-100);
        }
        return (a.f) invokeLL.objValue;
    }

    @Override // c.a.m.i.a
    public a.h b(String str, a.g gVar) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        g.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, gVar)) == null) {
            C0206c c0206c = null;
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
                c0206c = new C0206c(this, str);
                c0206c.e();
                if (str.equals(c0206c.n())) {
                    g.a k = c0206c.k();
                    boolean z2 = packageInfo.lastUpdateTime == c0206c.m();
                    if (k != null && k.m() && !TextUtils.isEmpty(k.u())) {
                        z = true;
                    }
                    if (z2 && z) {
                        a2 = c0206c.k();
                        return a.h.c(a2);
                    }
                }
            }
            b bVar = new b(this);
            if (bVar.d(packageInfo)) {
                if (gVar.a && c0206c != null) {
                    c0206c.f(bVar);
                    c0206c.g(System.currentTimeMillis());
                    c0206c.l(packageInfo.lastUpdateTime);
                    c0206c.i(str);
                    c0206c.c();
                }
                a2 = bVar.a();
                return a.h.c(a2);
            }
            return a.h.b(-2);
        }
        return (a.h) invokeLL.objValue;
    }

    @Override // c.a.m.i.a
    public void e(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f4172f = this.f4165b.f("isc");
        }
    }

    public final a.f h(a.e eVar, g.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, eVar, aVar)) == null) {
            this.f4173g.j();
            this.f4172f.d();
            if (aVar.equals(this.f4173g.a())) {
                return a.f.c();
            }
            this.f4173g.c(aVar);
            this.f4173g.g(System.currentTimeMillis());
            return a.f.c();
        }
        return (a.f) invokeLL.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f4173g.b(a.a(this.f4172f, this.a.f4168b) ? 1 : 2, 3L);
        }
    }
}
