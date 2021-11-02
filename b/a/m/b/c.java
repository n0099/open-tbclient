package b.a.m.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.system.Os;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.m.b.a;
import b.a.m.g.a;
import b.a.m.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends b.a.m.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a.C0095a f3339f;

    /* renamed from: g  reason: collision with root package name */
    public b f3340g;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a(a.C0095a c0095a, b.a.m.g.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, c0095a, aVar)) == null) {
                if (Build.VERSION.SDK_INT < 23) {
                    while (c0095a != null && !c0095a.f().equals(aVar.a())) {
                        c0095a.f().setExecutable(true, false);
                        c0095a = c0095a.i();
                    }
                    return true;
                }
                while (c0095a != null) {
                    if (!b(c0095a.f())) {
                        return false;
                    }
                    c0095a = c0095a.i();
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

        /* renamed from: a  reason: collision with root package name */
        public b.a.m.i.b f3341a;

        /* renamed from: b  reason: collision with root package name */
        public long f3342b;

        /* renamed from: c  reason: collision with root package name */
        public l.a f3343c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3344d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3345e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f3346f;

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
            this.f3346f = cVar;
            this.f3341a = new b.a.m.i.b();
            this.f3345e = true;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3342b : invokeV.longValue;
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.f3342b == j) {
                return;
            }
            this.f3342b = j;
            this.f3344d = true;
        }

        public void c(long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && this.f3341a.a(j, j2)) {
                this.f3344d = true;
            }
        }

        public void d(l.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar.equals(this.f3343c)) {
                return;
            }
            this.f3343c = aVar;
            this.f3344d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, packageInfo)) == null) {
                String c2 = this.f3346f.f3339f.a(new File(packageInfo.applicationInfo.dataDir)).c("pub.dat", true);
                this.f3345e = false;
                return f(c2);
            }
            return invokeL.booleanValue;
        }

        public final boolean f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        this.f3342b = jSONObject.getLong("pub_lst_ts");
                        this.f3343c = l.c(jSONObject.getString("pub_info"));
                        jSONObject.getInt("d_form_ver");
                        this.f3344d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public l.a g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3343c : (l.a) invokeV.objValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f(this.f3346f.f3339f.c("pub.dat", true)) : invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.f3345e) {
                    if (this.f3344d) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("pub_info", this.f3343c.x());
                            jSONObject.put("pub_lst_ts", this.f3342b);
                            jSONObject.put("d_form_ver", 1);
                            this.f3346f.f3339f.e("pub.dat", jSONObject.toString(), true);
                            this.f3344d = false;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? c.i(this.f3346f.f3339f.g("pub.dat"), true) : invokeV.booleanValue;
        }
    }

    /* renamed from: b.a.m.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0093c extends a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f3347d;

        /* renamed from: e  reason: collision with root package name */
        public long f3348e;

        /* renamed from: f  reason: collision with root package name */
        public long f3349f;

        /* renamed from: g  reason: collision with root package name */
        public long f3350g;

        /* renamed from: h  reason: collision with root package name */
        public l.a f3351h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0093c(c cVar, String str) {
            super(cVar.f3339f, str);
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
                    super((a.C0095a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // b.a.m.b.a.c
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f3347d = jSONObject.getString("pkg");
                this.f3349f = jSONObject.getInt("tar_pkg_lst_pub_ts");
                this.f3348e = jSONObject.getLong("last_fe_ts");
                this.f3351h = l.c(jSONObject.getString("info"));
                this.f3350g = jSONObject.getLong("tar_pkg_lst_up_ts");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // b.a.m.b.a.c
        public void d(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.f3347d);
                jSONObject.put("last_fe_ts", this.f3348e);
                jSONObject.put("tar_pkg_lst_pub_ts", this.f3349f);
                jSONObject.put("info", this.f3351h.x());
                jSONObject.put("tar_pkg_lst_up_ts", this.f3350g);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public void f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
                h(bVar.g());
                j(bVar.a());
            }
        }

        public boolean g(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                if (this.f3348e != j) {
                    this.f3348e = j;
                    b(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public boolean h(l.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
                if (aVar.equals(this.f3351h)) {
                    return false;
                }
                this.f3351h = aVar;
                b(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                if (str.equals(this.f3347d)) {
                    return false;
                }
                this.f3347d = str;
                b(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public boolean j(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                if (this.f3349f != j) {
                    this.f3349f = j;
                    b(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public String k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f3347d : (String) invokeV.objValue;
        }

        public boolean l(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
                if (this.f3350g != j) {
                    this.f3350g = j;
                    b(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public l.a m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f3351h : (l.a) invokeV.objValue;
        }

        public long n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f3350g : invokeV.longValue;
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
        this.f3340g = new b(this);
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

    @Override // b.a.m.b.a
    public a.f a(a.e eVar, l.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, aVar)) == null) {
            Context context = this.f3326a.f3330a;
            if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
                this.f3340g.h();
                try {
                    return h(eVar, aVar);
                } finally {
                    this.f3340g.i();
                    j();
                    this.f3340g.i();
                    this.f3340g.j();
                }
            }
            return a.f.a(-100);
        }
        return (a.f) invokeLL.objValue;
    }

    @Override // b.a.m.b.a
    public a.h b(String str, a.g gVar) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        l.a g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, gVar)) == null) {
            C0093c c0093c = null;
            boolean z = false;
            try {
                packageInfo = this.f3326a.f3330a.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return a.h.a(-2);
            }
            if (gVar.f3335a) {
                c0093c = new C0093c(this, str);
                c0093c.c();
                if (str.equals(c0093c.k())) {
                    l.a m = c0093c.m();
                    boolean z2 = packageInfo.lastUpdateTime == c0093c.n();
                    if (m != null && m.q() && !TextUtils.isEmpty(m.r())) {
                        z = true;
                    }
                    if (z2 && z) {
                        g2 = c0093c.m();
                        return a.h.b(g2);
                    }
                }
            }
            b bVar = new b(this);
            if (bVar.e(packageInfo)) {
                if (gVar.f3335a && c0093c != null) {
                    c0093c.f(bVar);
                    c0093c.g(System.currentTimeMillis());
                    c0093c.l(packageInfo.lastUpdateTime);
                    c0093c.i(str);
                    c0093c.e();
                }
                g2 = bVar.g();
                return a.h.b(g2);
            }
            return a.h.a(-2);
        }
        return (a.h) invokeLL.objValue;
    }

    @Override // b.a.m.b.a
    public void e(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f3339f = this.f3327b.b("isc");
        }
    }

    public final a.f h(a.e eVar, l.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, eVar, aVar)) == null) {
            this.f3340g.h();
            this.f3339f.d();
            if (aVar.equals(this.f3340g.g())) {
                return a.f.b();
            }
            this.f3340g.d(aVar);
            this.f3340g.b(System.currentTimeMillis());
            return a.f.b();
        }
        return (a.f) invokeLL.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f3340g.c(a.a(this.f3339f, this.f3326a.f3331b) ? 1 : 2, 3L);
        }
    }
}
