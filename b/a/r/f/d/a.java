package b.a.r.f.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.r.f.a;
import b.a.r.h.d.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends b.a.r.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a.C0774a f15186f;

    /* renamed from: g  reason: collision with root package name */
    public C0764a f15187g;

    /* renamed from: b.a.r.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0764a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f15188a;

        /* renamed from: b  reason: collision with root package name */
        public String f15189b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f15190c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f15191d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15192e;

        public C0764a(a aVar) {
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
            this.f15192e = aVar;
            this.f15191d = true;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15189b : (String) invokeV.objValue;
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.f15188a == j) {
                return;
            }
            this.f15188a = j;
            this.f15190c = true;
        }

        public final boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        this.f15188a = jSONObject.getLong("pub_lst_ts");
                        this.f15189b = jSONObject.getString("pub_id");
                        jSONObject.getInt("d_form_ver");
                        this.f15190c = false;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15188a : invokeV.longValue;
        }

        public boolean e(String str) {
            InterceptResult invokeL;
            Context context;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f15191d = false;
                try {
                    context = this.f15192e.f15168a.f15172a.createPackageContext(str, 0);
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
                    return c(b.a.r.h.d.a.e(new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es"), "pub.dat", "UTF-8", true));
                } catch (Throwable unused) {
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        public void f(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || str.equals(this.f15189b)) {
                return;
            }
            this.f15189b = str;
            this.f15190c = true;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.f15191d) {
                    if (this.f15190c) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("pub_id", this.f15189b);
                            jSONObject.put("pub_lst_ts", this.f15188a);
                            jSONObject.put("d_form_ver", 1);
                            this.f15192e.f15186f.i("pub.dat", jSONObject.toString(), true);
                            this.f15190c = false;
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
                    File externalCacheDir = this.f15192e.f15168a.f15172a.getExternalCacheDir();
                    File file = new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pub_id", this.f15189b);
                    jSONObject.put("pub_lst_ts", this.f15188a);
                    jSONObject.put("d_form_ver", 1);
                    b.a.r.h.d.a.f(file, "pub.dat", jSONObject.toString(), "UTF-8", true);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? c(this.f15192e.f15186f.g("pub.dat", true)) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f15193d;

        /* renamed from: e  reason: collision with root package name */
        public long f15194e;

        /* renamed from: f  reason: collision with root package name */
        public long f15195f;

        /* renamed from: g  reason: collision with root package name */
        public long f15196g;

        /* renamed from: h  reason: collision with root package name */
        public String f15197h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, String str) {
            super(aVar.f15186f, str);
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
                    super((a.C0774a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // b.a.r.f.a.b
        public void c(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f15193d = jSONObject.getString("pkg");
                this.f15195f = jSONObject.getInt("tar_pkg_lst_pub_ts");
                this.f15194e = jSONObject.getLong("last_fe_ts");
                this.f15197h = jSONObject.getString("id");
                this.f15196g = jSONObject.getLong("tar_pkg_lst_up_ts");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // b.a.r.f.a.b
        public void e(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.f15193d);
                jSONObject.put("last_fe_ts", this.f15194e);
                jSONObject.put("tar_pkg_lst_pub_ts", this.f15195f);
                jSONObject.put("id", this.f15197h);
                jSONObject.put("tar_pkg_lst_up_ts", this.f15196g);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15197h : (String) invokeV.objValue;
        }

        public void g(C0764a c0764a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, c0764a) == null) {
                i(c0764a.a());
                k(c0764a.d());
            }
        }

        public boolean h(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                if (this.f15194e != j) {
                    this.f15194e = j;
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
                if (str.equals(this.f15197h)) {
                    return false;
                }
                this.f15197h = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f15196g : invokeV.longValue;
        }

        public boolean k(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                if (this.f15195f != j) {
                    this.f15195f = j;
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
                if (str.equals(this.f15193d)) {
                    return false;
                }
                this.f15193d = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public String m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f15193d : (String) invokeV.objValue;
        }

        public boolean n(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
                if (this.f15196g != j) {
                    this.f15196g = j;
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
        this.f15187g = new C0764a(this);
    }

    @Override // b.a.r.f.a
    public a.g b(String str, a.f fVar) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, fVar)) == null) {
            Context context = this.f15168a.f15172a;
            b bVar = null;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return a.g.b(-1);
            }
            if (fVar.f15178a) {
                bVar = new b(this, str);
                bVar.d();
                if (str.equals(bVar.m()) && packageInfo.lastUpdateTime == bVar.j()) {
                    String f2 = bVar.f();
                    if (!TextUtils.isEmpty(f2)) {
                        return a.g.f(f2);
                    }
                }
            }
            if (context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0) {
                C0764a c0764a = new C0764a(this);
                if (c0764a.e(str)) {
                    if (fVar.f15178a && bVar != null) {
                        bVar.g(c0764a);
                        bVar.h(System.currentTimeMillis());
                        bVar.n(packageInfo.lastUpdateTime);
                        bVar.l(str);
                        bVar.b();
                    }
                    return a.g.f(c0764a.a());
                }
                return a.g.b(-2);
            }
            return a.g.b(-100);
        }
        return (a.g) invokeLL.objValue;
    }

    @Override // b.a.r.f.a
    public void e(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f15186f = this.f15169b.f("esc-es");
        }
    }

    @Override // b.a.r.f.a
    public a.e f(a.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return a.e.a();
            }
            this.f15187g.i();
            try {
                return i(dVar);
            } finally {
                this.f15187g.g();
            }
        }
        return (a.e) invokeL.objValue;
    }

    public final a.e i(a.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dVar)) == null) {
            String c2 = this.f15168a.f15174c.a("aid").c();
            if (c2.equals(this.f15187g.a())) {
                return a.e.d();
            }
            this.f15187g.f(c2);
            this.f15187g.b(System.currentTimeMillis());
            this.f15187g.g();
            return this.f15187g.h() ? a.e.d() : a.e.a();
        }
        return (a.e) invokeL.objValue;
    }
}
