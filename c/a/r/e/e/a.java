package c.a.r.e.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.system.Os;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r.e.a;
import c.a.r.g.c.a.e;
import c.a.r.g.d.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends c.a.r.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a.C1379a f29495f;

    /* renamed from: g  reason: collision with root package name */
    public b f29496g;

    /* renamed from: c.a.r.e.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1376a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a(a.C1379a c1379a, c.a.r.g.d.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, c1379a, aVar)) == null) {
                if (Build.VERSION.SDK_INT < 23) {
                    while (c1379a != null && !c1379a.b().equals(aVar.b())) {
                        c1379a.b().setExecutable(true, false);
                        c1379a = c1379a.e();
                    }
                    return true;
                }
                while (c1379a != null) {
                    if (!b(c1379a.b())) {
                        return false;
                    }
                    c1379a = c1379a.e();
                }
                return b(aVar.b());
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

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public e f29497a;

        /* renamed from: b  reason: collision with root package name */
        public long f29498b;

        /* renamed from: c  reason: collision with root package name */
        public String f29499c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f29500d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f29501e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f29502f;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29502f = aVar;
            this.f29497a = new e();
            this.f29501e = true;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29498b : invokeV.longValue;
        }

        public void b(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || this.f29498b == j2) {
                return;
            }
            this.f29498b = j2;
            this.f29500d = true;
        }

        public void c(long j2, long j3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) && this.f29497a.c(j2, j3)) {
                this.f29500d = true;
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || str.equals(this.f29499c)) {
                return;
            }
            this.f29499c = str;
            this.f29500d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, packageInfo)) == null) {
                String g2 = this.f29502f.f29495f.h(new File(packageInfo.applicationInfo.dataDir)).g("pub.dat", true);
                this.f29501e = false;
                return g(g2);
            }
            return invokeL.booleanValue;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f29499c : (String) invokeV.objValue;
        }

        public final boolean g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        this.f29498b = jSONObject.getLong("pub_lst_ts");
                        this.f29499c = jSONObject.getString("pub_id");
                        jSONObject.getInt("d_form_ver");
                        this.f29500d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? g(this.f29502f.f29495f.g("pub.dat", true)) : invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.f29501e) {
                    if (this.f29500d) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("pub_id", this.f29499c);
                            jSONObject.put("pub_lst_ts", this.f29498b);
                            jSONObject.put("d_form_ver", 1);
                            this.f29502f.f29495f.i("pub.dat", jSONObject.toString(), true);
                            this.f29500d = false;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? a.k(this.f29502f.f29495f.d("pub.dat"), true) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f29503d;

        /* renamed from: e  reason: collision with root package name */
        public long f29504e;

        /* renamed from: f  reason: collision with root package name */
        public long f29505f;

        /* renamed from: g  reason: collision with root package name */
        public long f29506g;

        /* renamed from: h  reason: collision with root package name */
        public String f29507h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, String str) {
            super(aVar.f29495f, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a.C1379a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.r.e.a.c
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f29503d = jSONObject.getString("pkg");
                this.f29505f = jSONObject.getInt("tar_pkg_lst_pub_ts");
                this.f29504e = jSONObject.getLong("last_fe_ts");
                this.f29507h = jSONObject.getString("id");
                this.f29506g = jSONObject.getLong("tar_pkg_lst_up_ts");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // c.a.r.e.a.c
        public void e(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.f29503d);
                jSONObject.put("last_fe_ts", this.f29504e);
                jSONObject.put("tar_pkg_lst_pub_ts", this.f29505f);
                jSONObject.put("id", this.f29507h);
                jSONObject.put("tar_pkg_lst_up_ts", this.f29506g);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29503d : (String) invokeV.objValue;
        }

        public void g(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
                l(bVar.f());
                k(bVar.a());
            }
        }

        public boolean h(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
                if (this.f29504e != j2) {
                    this.f29504e = j2;
                    a(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                if (str.equals(this.f29503d)) {
                    return false;
                }
                this.f29503d = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f29507h : (String) invokeV.objValue;
        }

        public boolean k(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
                if (this.f29505f != j2) {
                    this.f29505f = j2;
                    a(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public boolean l(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                if (str.equals(this.f29507h)) {
                    return false;
                }
                this.f29507h = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public long m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f29506g : invokeV.longValue;
        }

        public boolean n(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
                if (this.f29506g != j2) {
                    this.f29506g = j2;
                    a(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
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
        this.f29496g = new b(this);
    }

    public static boolean k(File file, boolean z) {
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

    @Override // c.a.r.e.a
    public a.h b(String str, a.g gVar) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        String f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, gVar)) == null) {
            c cVar = null;
            try {
                packageInfo = this.f29456a.f29460a.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return a.h.a(-2);
            }
            if (gVar.f29466a) {
                cVar = new c(this, str);
                cVar.d();
                if (str.equals(cVar.f()) && packageInfo.lastUpdateTime == cVar.m()) {
                    f2 = cVar.j();
                    return a.h.e(f2);
                }
            }
            b bVar = new b(this);
            if (bVar.e(packageInfo)) {
                if (gVar.f29466a && cVar != null) {
                    cVar.g(bVar);
                    cVar.h(System.currentTimeMillis());
                    cVar.n(packageInfo.lastUpdateTime);
                    cVar.i(str);
                    cVar.b();
                }
                f2 = bVar.f();
                return a.h.e(f2);
            }
            return a.h.a(-2);
        }
        return (a.h) invokeLL.objValue;
    }

    @Override // c.a.r.e.a
    public void e(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.f29495f = this.f29457b.f("isc");
        }
    }

    @Override // c.a.r.e.a
    public a.f f(a.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            Context context = this.f29456a.f29460a;
            if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
                this.f29496g.h();
                try {
                    return h(eVar);
                } finally {
                    this.f29496g.i();
                    i();
                    this.f29496g.i();
                    this.f29496g.j();
                }
            }
            return a.f.b(-100);
        }
        return (a.f) invokeL.objValue;
    }

    public final a.f h(a.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eVar)) == null) {
            this.f29496g.h();
            this.f29495f.a();
            String c2 = this.f29456a.f29462c.a("aid").c();
            if (c2.equals(this.f29496g.f())) {
                return a.f.d();
            }
            this.f29496g.d(c2);
            this.f29496g.b(System.currentTimeMillis());
            return a.f.d();
        }
        return (a.f) invokeL.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f29496g.c(C1376a.a(this.f29495f, this.f29456a.f29461b) ? 1 : 2, 3L);
        }
    }
}
