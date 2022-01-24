package c.a.r.f.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r.f.a;
import c.a.r.h.d.a;
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
/* loaded from: classes.dex */
public class a extends c.a.r.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a.C0259a f4964f;

    /* renamed from: g  reason: collision with root package name */
    public C0249a f4965g;

    /* renamed from: c.a.r.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0249a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public String f4966b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f4967c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4968d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4969e;

        public C0249a(a aVar) {
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
            this.f4969e = aVar;
            this.f4968d = true;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f4966b : (String) invokeV.objValue;
        }

        public void b(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || this.a == j2) {
                return;
            }
            this.a = j2;
            this.f4967c = true;
        }

        public final boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        this.a = jSONObject.getLong("pub_lst_ts");
                        this.f4966b = jSONObject.getString("pub_id");
                        jSONObject.getInt("d_form_ver");
                        this.f4967c = false;
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
                this.f4968d = false;
                try {
                    context = this.f4969e.a.a.createPackageContext(str, 0);
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
                    return c(c.a.r.h.d.a.e(new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es"), "pub.dat", "UTF-8", true));
                } catch (Throwable unused) {
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        public void f(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || str.equals(this.f4966b)) {
                return;
            }
            this.f4966b = str;
            this.f4967c = true;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.f4968d) {
                    if (this.f4967c) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("pub_id", this.f4966b);
                            jSONObject.put("pub_lst_ts", this.a);
                            jSONObject.put("d_form_ver", 1);
                            this.f4969e.f4964f.i("pub.dat", jSONObject.toString(), true);
                            this.f4967c = false;
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
                    File externalCacheDir = this.f4969e.a.a.getExternalCacheDir();
                    File file = new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pub_id", this.f4966b);
                    jSONObject.put("pub_lst_ts", this.a);
                    jSONObject.put("d_form_ver", 1);
                    c.a.r.h.d.a.f(file, "pub.dat", jSONObject.toString(), "UTF-8", true);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? c(this.f4969e.f4964f.g("pub.dat", true)) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class b extends a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f4970d;

        /* renamed from: e  reason: collision with root package name */
        public long f4971e;

        /* renamed from: f  reason: collision with root package name */
        public long f4972f;

        /* renamed from: g  reason: collision with root package name */
        public long f4973g;

        /* renamed from: h  reason: collision with root package name */
        public String f4974h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, String str) {
            super(aVar.f4964f, str);
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
                    super((a.C0259a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.r.f.a.b
        public void c(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f4970d = jSONObject.getString("pkg");
                this.f4972f = jSONObject.getInt("tar_pkg_lst_pub_ts");
                this.f4971e = jSONObject.getLong("last_fe_ts");
                this.f4974h = jSONObject.getString("id");
                this.f4973g = jSONObject.getLong("tar_pkg_lst_up_ts");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // c.a.r.f.a.b
        public void e(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.f4970d);
                jSONObject.put("last_fe_ts", this.f4971e);
                jSONObject.put("tar_pkg_lst_pub_ts", this.f4972f);
                jSONObject.put("id", this.f4974h);
                jSONObject.put("tar_pkg_lst_up_ts", this.f4973g);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f4974h : (String) invokeV.objValue;
        }

        public void g(C0249a c0249a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, c0249a) == null) {
                i(c0249a.a());
                k(c0249a.d());
            }
        }

        public boolean h(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
                if (this.f4971e != j2) {
                    this.f4971e = j2;
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
                if (str.equals(this.f4974h)) {
                    return false;
                }
                this.f4974h = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f4973g : invokeV.longValue;
        }

        public boolean k(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
                if (this.f4972f != j2) {
                    this.f4972f = j2;
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
                if (str.equals(this.f4970d)) {
                    return false;
                }
                this.f4970d = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public String m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f4970d : (String) invokeV.objValue;
        }

        public boolean n(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
                if (this.f4973g != j2) {
                    this.f4973g = j2;
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
        this.f4965g = new C0249a(this);
    }

    @Override // c.a.r.f.a
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
            if (context.checkPermission(s.f55293i, Process.myPid(), Process.myUid()) == 0) {
                C0249a c0249a = new C0249a(this);
                if (c0249a.e(str)) {
                    if (fVar.a && bVar != null) {
                        bVar.g(c0249a);
                        bVar.h(System.currentTimeMillis());
                        bVar.n(packageInfo.lastUpdateTime);
                        bVar.l(str);
                        bVar.b();
                    }
                    return a.g.f(c0249a.a());
                }
                return a.g.b(-2);
            }
            return a.g.b(-100);
        }
        return (a.g) invokeLL.objValue;
    }

    @Override // c.a.r.f.a
    public void e(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f4964f = this.f4954b.f("esc-es");
        }
    }

    @Override // c.a.r.f.a
    public a.e f(a.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return a.e.a();
            }
            this.f4965g.i();
            try {
                return i(dVar);
            } finally {
                this.f4965g.g();
            }
        }
        return (a.e) invokeL.objValue;
    }

    public final a.e i(a.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dVar)) == null) {
            String c2 = this.a.f4958c.a("aid").c();
            if (c2.equals(this.f4965g.a())) {
                return a.e.d();
            }
            this.f4965g.f(c2);
            this.f4965g.b(System.currentTimeMillis());
            this.f4965g.g();
            return this.f4965g.h() ? a.e.d() : a.e.a();
        }
        return (a.e) invokeL.objValue;
    }
}
