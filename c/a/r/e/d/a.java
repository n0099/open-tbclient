package c.a.r.e.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r.e.a;
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
    public a.C1379a f29472f;

    /* renamed from: g  reason: collision with root package name */
    public C1374a f29473g;

    /* renamed from: c.a.r.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1374a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f29474a;

        /* renamed from: b  reason: collision with root package name */
        public String f29475b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f29476c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f29477d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f29478e;

        public C1374a(a aVar) {
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
            this.f29478e = aVar;
            this.f29477d = true;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29474a : invokeV.longValue;
        }

        public void b(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || this.f29474a == j2) {
                return;
            }
            this.f29474a = j2;
            this.f29476c = true;
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || str.equals(this.f29475b)) {
                return;
            }
            this.f29475b = str;
            this.f29476c = true;
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29475b : (String) invokeV.objValue;
        }

        public boolean e(String str) {
            InterceptResult invokeL;
            Context context;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f29477d = false;
                try {
                    context = this.f29478e.f29456a.f29460a.createPackageContext(str, 0);
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                    context = null;
                }
                if (context == null) {
                    return false;
                }
                try {
                    File externalCacheDir = context.getExternalCacheDir();
                    if (externalCacheDir == null) {
                        return false;
                    }
                    return g(c.a.r.g.d.a.e(new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es"), "pub.dat", "UTF-8", true));
                } catch (Throwable unused) {
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? g(this.f29478e.f29472f.g("pub.dat", true)) : invokeV.booleanValue;
        }

        public final boolean g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        this.f29474a = jSONObject.getLong("pub_lst_ts");
                        this.f29475b = jSONObject.getString("pub_id");
                        jSONObject.getInt("d_form_ver");
                        this.f29476c = false;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.f29477d) {
                    if (this.f29476c) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("pub_id", this.f29475b);
                            jSONObject.put("pub_lst_ts", this.f29474a);
                            jSONObject.put("d_form_ver", 1);
                            this.f29478e.f29472f.i("pub.dat", jSONObject.toString(), true);
                            this.f29476c = false;
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

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                try {
                    File externalCacheDir = this.f29478e.f29456a.f29460a.getExternalCacheDir();
                    File file = new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pub_id", this.f29475b);
                    jSONObject.put("pub_lst_ts", this.f29474a);
                    jSONObject.put("d_form_ver", 1);
                    c.a.r.g.d.a.f(file, "pub.dat", jSONObject.toString(), "UTF-8", true);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f29479d;

        /* renamed from: e  reason: collision with root package name */
        public long f29480e;

        /* renamed from: f  reason: collision with root package name */
        public long f29481f;

        /* renamed from: g  reason: collision with root package name */
        public long f29482g;

        /* renamed from: h  reason: collision with root package name */
        public String f29483h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, String str) {
            super(aVar.f29472f, str);
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
                this.f29479d = jSONObject.getString("pkg");
                this.f29481f = jSONObject.getInt("tar_pkg_lst_pub_ts");
                this.f29480e = jSONObject.getLong("last_fe_ts");
                this.f29483h = jSONObject.getString("id");
                this.f29482g = jSONObject.getLong("tar_pkg_lst_up_ts");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // c.a.r.e.a.c
        public void e(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.f29479d);
                jSONObject.put("last_fe_ts", this.f29480e);
                jSONObject.put("tar_pkg_lst_pub_ts", this.f29481f);
                jSONObject.put("id", this.f29483h);
                jSONObject.put("tar_pkg_lst_up_ts", this.f29482g);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29479d : (String) invokeV.objValue;
        }

        public void g(C1374a c1374a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, c1374a) == null) {
                l(c1374a.d());
                k(c1374a.a());
            }
        }

        public boolean h(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
                if (this.f29480e != j2) {
                    this.f29480e = j2;
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
                if (str.equals(this.f29479d)) {
                    return false;
                }
                this.f29479d = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f29483h : (String) invokeV.objValue;
        }

        public boolean k(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
                if (this.f29481f != j2) {
                    this.f29481f = j2;
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
                if (str.equals(this.f29483h)) {
                    return false;
                }
                this.f29483h = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public long m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f29482g : invokeV.longValue;
        }

        public boolean n(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
                if (this.f29482g != j2) {
                    this.f29482g = j2;
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
        super("esc-es", 7000000L);
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
        this.f29473g = new C1374a(this);
    }

    @Override // c.a.r.e.a
    public a.h b(String str, a.g gVar) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, gVar)) == null) {
            Context context = this.f29456a.f29460a;
            b bVar = null;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return a.h.a(-1);
            }
            if (gVar.f29466a) {
                bVar = new b(this, str);
                bVar.d();
                if (str.equals(bVar.f()) && packageInfo.lastUpdateTime == bVar.m()) {
                    String j2 = bVar.j();
                    if (!TextUtils.isEmpty(j2)) {
                        return a.h.e(j2);
                    }
                }
            }
            if (context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0) {
                C1374a c1374a = new C1374a(this);
                if (c1374a.e(str)) {
                    if (gVar.f29466a && bVar != null) {
                        bVar.g(c1374a);
                        bVar.h(System.currentTimeMillis());
                        bVar.n(packageInfo.lastUpdateTime);
                        bVar.i(str);
                        bVar.b();
                    }
                    return a.h.e(c1374a.d());
                }
                return a.h.a(-2);
            }
            return a.h.a(-100);
        }
        return (a.h) invokeLL.objValue;
    }

    @Override // c.a.r.e.a
    public void e(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.f29472f = this.f29457b.f("esc-es");
        }
    }

    @Override // c.a.r.e.a
    public a.f f(a.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return a.f.a();
            }
            this.f29473g.f();
            try {
                return i(eVar);
            } finally {
                this.f29473g.h();
            }
        }
        return (a.f) invokeL.objValue;
    }

    public final a.f i(a.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eVar)) == null) {
            String c2 = this.f29456a.f29462c.a("aid").c();
            if (c2.equals(this.f29473g.d())) {
                return a.f.d();
            }
            this.f29473g.c(c2);
            this.f29473g.b(System.currentTimeMillis());
            this.f29473g.h();
            return this.f29473g.i() ? a.f.d() : a.f.a();
        }
        return (a.f) invokeL.objValue;
    }
}
