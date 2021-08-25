package c.a.m.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.system.Os;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.m.b.a;
import c.a.m.g.a;
import c.a.m.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.m.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a.C0100a f3927f;

    /* renamed from: g  reason: collision with root package name */
    public b f3928g;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a(a.C0100a c0100a, c.a.m.g.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, c0100a, aVar)) == null) {
                if (Build.VERSION.SDK_INT < 23) {
                    while (c0100a != null && !c0100a.f().equals(aVar.a())) {
                        c0100a.f().setExecutable(true, false);
                        c0100a = c0100a.i();
                    }
                    return true;
                }
                while (c0100a != null) {
                    if (!b(c0100a.f())) {
                        return false;
                    }
                    c0100a = c0100a.i();
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
        public c.a.m.i.b f3929a;

        /* renamed from: b  reason: collision with root package name */
        public long f3930b;

        /* renamed from: c  reason: collision with root package name */
        public l.a f3931c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3932d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3933e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f3934f;

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
            this.f3934f = cVar;
            this.f3929a = new c.a.m.i.b();
            this.f3933e = true;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3930b : invokeV.longValue;
        }

        public void b(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || this.f3930b == j2) {
                return;
            }
            this.f3930b = j2;
            this.f3932d = true;
        }

        public void c(long j2, long j3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) && this.f3929a.a(j2, j3)) {
                this.f3932d = true;
            }
        }

        public void d(l.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar.equals(this.f3931c)) {
                return;
            }
            this.f3931c = aVar;
            this.f3932d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, packageInfo)) == null) {
                String c2 = this.f3934f.f3927f.a(new File(packageInfo.applicationInfo.dataDir)).c("pub.dat", true);
                this.f3933e = false;
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
                        this.f3930b = jSONObject.getLong("pub_lst_ts");
                        this.f3931c = l.c(jSONObject.getString("pub_info"));
                        jSONObject.getInt("d_form_ver");
                        this.f3932d = false;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3931c : (l.a) invokeV.objValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f(this.f3934f.f3927f.c("pub.dat", true)) : invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.f3933e) {
                    if (this.f3932d) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("pub_info", this.f3931c.m());
                            jSONObject.put("pub_lst_ts", this.f3930b);
                            jSONObject.put("d_form_ver", 1);
                            this.f3934f.f3927f.e("pub.dat", jSONObject.toString(), true);
                            this.f3932d = false;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? c.i(this.f3934f.f3927f.g("pub.dat"), true) : invokeV.booleanValue;
        }
    }

    /* renamed from: c.a.m.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0098c extends a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f3935d;

        /* renamed from: e  reason: collision with root package name */
        public long f3936e;

        /* renamed from: f  reason: collision with root package name */
        public long f3937f;

        /* renamed from: g  reason: collision with root package name */
        public long f3938g;

        /* renamed from: h  reason: collision with root package name */
        public l.a f3939h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0098c(c cVar, String str) {
            super(cVar.f3927f, str);
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
                    super((a.C0100a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.m.b.a.c
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f3935d = jSONObject.getString("pkg");
                this.f3937f = jSONObject.getInt("tar_pkg_lst_pub_ts");
                this.f3936e = jSONObject.getLong("last_fe_ts");
                this.f3939h = l.c(jSONObject.getString("info"));
                this.f3938g = jSONObject.getLong("tar_pkg_lst_up_ts");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // c.a.m.b.a.c
        public void d(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.f3935d);
                jSONObject.put("last_fe_ts", this.f3936e);
                jSONObject.put("tar_pkg_lst_pub_ts", this.f3937f);
                jSONObject.put("info", this.f3939h.m());
                jSONObject.put("tar_pkg_lst_up_ts", this.f3938g);
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

        public boolean g(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
                if (this.f3936e != j2) {
                    this.f3936e = j2;
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
                if (aVar.equals(this.f3939h)) {
                    return false;
                }
                this.f3939h = aVar;
                b(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                if (str.equals(this.f3935d)) {
                    return false;
                }
                this.f3935d = str;
                b(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public boolean j(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                if (this.f3937f != j2) {
                    this.f3937f = j2;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f3935d : (String) invokeV.objValue;
        }

        public boolean l(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) {
                if (this.f3938g != j2) {
                    this.f3938g = j2;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f3939h : (l.a) invokeV.objValue;
        }

        public long n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f3938g : invokeV.longValue;
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
        this.f3928g = new b(this);
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

    @Override // c.a.m.b.a
    public a.f a(a.e eVar, l.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, aVar)) == null) {
            Context context = this.f3914a.f3918a;
            if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
                this.f3928g.h();
                try {
                    return h(eVar, aVar);
                } finally {
                    this.f3928g.i();
                    j();
                    this.f3928g.i();
                    this.f3928g.j();
                }
            }
            return a.f.a(-100);
        }
        return (a.f) invokeLL.objValue;
    }

    @Override // c.a.m.b.a
    public a.h b(String str, a.g gVar) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        l.a g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, gVar)) == null) {
            C0098c c0098c = null;
            try {
                packageInfo = this.f3914a.f3918a.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return a.h.a(-2);
            }
            if (gVar.f3923a) {
                c0098c = new C0098c(this, str);
                c0098c.c();
                if (str.equals(c0098c.k()) && packageInfo.lastUpdateTime == c0098c.n()) {
                    g2 = c0098c.m();
                    return a.h.b(g2);
                }
            }
            b bVar = new b(this);
            if (bVar.e(packageInfo)) {
                if (gVar.f3923a && c0098c != null) {
                    c0098c.f(bVar);
                    c0098c.g(System.currentTimeMillis());
                    c0098c.l(packageInfo.lastUpdateTime);
                    c0098c.i(str);
                    c0098c.e();
                }
                g2 = bVar.g();
                return a.h.b(g2);
            }
            return a.h.a(-2);
        }
        return (a.h) invokeLL.objValue;
    }

    @Override // c.a.m.b.a
    public void e(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f3927f = this.f3915b.b("isc");
        }
    }

    public final a.f h(a.e eVar, l.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, eVar, aVar)) == null) {
            this.f3928g.h();
            this.f3927f.d();
            if (aVar.equals(this.f3928g.g())) {
                return a.f.b();
            }
            this.f3928g.d(aVar);
            this.f3928g.b(System.currentTimeMillis());
            return a.f.b();
        }
        return (a.f) invokeLL.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f3928g.c(a.a(this.f3927f, this.f3914a.f3919b) ? 1 : 2, 3L);
        }
    }
}
