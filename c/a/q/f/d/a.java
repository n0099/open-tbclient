package c.a.q.f.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q.f.a;
import c.a.q.h.d.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.s;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends c.a.q.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a.C0742a f11332f;

    /* renamed from: g  reason: collision with root package name */
    public C0732a f11333g;

    /* renamed from: c.a.q.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0732a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public String f11334b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f11335c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f11336d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11337e;

        public C0732a(a aVar) {
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
            this.f11337e = aVar;
            this.f11336d = true;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11334b : (String) invokeV.objValue;
        }

        public void b(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || this.a == j2) {
                return;
            }
            this.a = j2;
            this.f11335c = true;
        }

        public final boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        this.a = jSONObject.getLong("pub_lst_ts");
                        this.f11334b = jSONObject.getString("pub_id");
                        jSONObject.getInt("d_form_ver");
                        this.f11335c = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.longValue;
        }

        public boolean e(String str) {
            InterceptResult invokeL;
            Context context;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f11336d = false;
                try {
                    context = this.f11337e.a.a.createPackageContext(str, 0);
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
                    return c(c.a.q.h.d.a.e(new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es"), "pub.dat", "UTF-8", true));
                } catch (Throwable unused) {
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        public void f(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || str.equals(this.f11334b)) {
                return;
            }
            this.f11334b = str;
            this.f11335c = true;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.f11336d) {
                    if (this.f11335c) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("pub_id", this.f11334b);
                            jSONObject.put("pub_lst_ts", this.a);
                            jSONObject.put("d_form_ver", 1);
                            this.f11337e.f11332f.i("pub.dat", jSONObject.toString(), true);
                            this.f11335c = false;
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

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                try {
                    File externalCacheDir = this.f11337e.a.a.getExternalCacheDir();
                    File file = new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pub_id", this.f11334b);
                    jSONObject.put("pub_lst_ts", this.a);
                    jSONObject.put("d_form_ver", 1);
                    c.a.q.h.d.a.f(file, "pub.dat", jSONObject.toString(), "UTF-8", true);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? c(this.f11337e.f11332f.g("pub.dat", true)) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f11338d;

        /* renamed from: e  reason: collision with root package name */
        public long f11339e;

        /* renamed from: f  reason: collision with root package name */
        public long f11340f;

        /* renamed from: g  reason: collision with root package name */
        public long f11341g;

        /* renamed from: h  reason: collision with root package name */
        public String f11342h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, String str) {
            super(aVar.f11332f, str);
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
                    super((a.C0742a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.q.f.a.b
        public void c(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f11338d = jSONObject.getString("pkg");
                this.f11340f = jSONObject.getInt("tar_pkg_lst_pub_ts");
                this.f11339e = jSONObject.getLong("last_fe_ts");
                this.f11342h = jSONObject.getString("id");
                this.f11341g = jSONObject.getLong("tar_pkg_lst_up_ts");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // c.a.q.f.a.b
        public void e(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.f11338d);
                jSONObject.put("last_fe_ts", this.f11339e);
                jSONObject.put("tar_pkg_lst_pub_ts", this.f11340f);
                jSONObject.put("id", this.f11342h);
                jSONObject.put("tar_pkg_lst_up_ts", this.f11341g);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f11342h : (String) invokeV.objValue;
        }

        public void g(C0732a c0732a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, c0732a) == null) {
                i(c0732a.a());
                k(c0732a.d());
            }
        }

        public boolean h(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
                if (this.f11339e != j2) {
                    this.f11339e = j2;
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
                if (str.equals(this.f11342h)) {
                    return false;
                }
                this.f11342h = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f11341g : invokeV.longValue;
        }

        public boolean k(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
                if (this.f11340f != j2) {
                    this.f11340f = j2;
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
                if (str.equals(this.f11338d)) {
                    return false;
                }
                this.f11338d = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public String m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f11338d : (String) invokeV.objValue;
        }

        public boolean n(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
                if (this.f11341g != j2) {
                    this.f11341g = j2;
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
        this.f11333g = new C0732a(this);
    }

    @Override // c.a.q.f.a
    public a.g b(String str, a.f fVar) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, fVar)) == null) {
            Context context = this.a.a;
            b bVar = null;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return a.g.b(-1);
            }
            if (fVar.a) {
                bVar = new b(this, str);
                bVar.d();
                if (str.equals(bVar.m()) && packageInfo.lastUpdateTime == bVar.j()) {
                    String f2 = bVar.f();
                    if (!TextUtils.isEmpty(f2)) {
                        return a.g.f(f2);
                    }
                }
            }
            if (context.checkPermission(s.f56844i, Process.myPid(), Process.myUid()) == 0) {
                C0732a c0732a = new C0732a(this);
                if (c0732a.e(str)) {
                    if (fVar.a && bVar != null) {
                        bVar.g(c0732a);
                        bVar.h(System.currentTimeMillis());
                        bVar.n(packageInfo.lastUpdateTime);
                        bVar.l(str);
                        bVar.b();
                    }
                    return a.g.f(c0732a.a());
                }
                return a.g.b(-2);
            }
            return a.g.b(-100);
        }
        return (a.g) invokeLL.objValue;
    }

    @Override // c.a.q.f.a
    public void e(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f11332f = this.f11322b.f("esc-es");
        }
    }

    @Override // c.a.q.f.a
    public a.e f(a.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return a.e.a();
            }
            this.f11333g.i();
            try {
                return i(dVar);
            } finally {
                this.f11333g.g();
            }
        }
        return (a.e) invokeL.objValue;
    }

    public final a.e i(a.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dVar)) == null) {
            String c2 = this.a.f11326c.a("aid").c();
            if (c2.equals(this.f11333g.a())) {
                return a.e.d();
            }
            this.f11333g.f(c2);
            this.f11333g.b(System.currentTimeMillis());
            this.f11333g.g();
            return this.f11333g.h() ? a.e.d() : a.e.a();
        }
        return (a.e) invokeL.objValue;
    }
}
