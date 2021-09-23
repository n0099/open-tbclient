package c.a.p0.b.p.h;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.transition.Transition;
import c.a.p0.a.a2.e;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.k;
import c.a.p0.a.p.d.v0;
import c.a.p0.t.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes.dex */
public class a implements v0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f10273b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.d0.a f10274a;

    /* renamed from: c.a.p0.b.p.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0505a extends c.a.e0.l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f10275a;

        public C0505a(a aVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10275a = j2;
        }

        @Override // c.a.e0.l.a
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (a.f10273b) {
                    String str2 = "requestBatchRebateInfo onResult: " + i2 + " " + str;
                }
                d.i(a.e());
                d.M(String.valueOf(this.f10275a), a.e());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends c.a.e0.l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // c.a.e0.l.a
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) && a.f10273b) {
                String str2 = "requestSingleRebateInfo onResult: " + i2 + " " + str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1591984086, "Lc/a/p0/b/p/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1591984086, "Lc/a/p0/b/p/h/a;");
                return;
            }
        }
        f10273b = k.f7085a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10274a = new c.a.d0.a();
    }

    public static File e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new File(AppRuntime.getAppContext().getFilesDir().getPath(), "rebate_info_timestamp") : (File) invokeV.objValue;
    }

    @Override // c.a.p0.a.p.d.v0
    public boolean a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        e Q;
        b.a L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
            if (!c.a.p0.a.d2.e.l() || (Q = e.Q()) == null || (L = Q.L()) == null) {
                return false;
            }
            f(str, c.a.p0.r.e.h().v(AppRuntime.getAppContext()), c.a.p0.a.c1.a.a0().i(c.a.p0.a.c1.a.b()), c.a.p0.b.l.a.i(Q.getApplicationContext()), str2, str3, c.a.p0.a.c1.a.m().a(), L.T());
            return true;
        }
        return invokeLLL.booleanValue;
    }

    @Override // c.a.p0.a.p.d.v0
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String D = d.D(e());
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (!TextUtils.isEmpty(D)) {
                try {
                    if (currentTimeMillis - Long.parseLong(D) < 86400) {
                        boolean z = f10273b;
                        return;
                    }
                } catch (NumberFormatException e2) {
                    if (f10273b) {
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            this.f10274a.l(new C0505a(this, currentTimeMillis));
        }
    }

    public final void f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("masterId", str);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("userPassId", str2);
                }
                jSONObject.put("cuid", str3);
                jSONObject.put("bduss", str4);
                jSONObject.put(Transition.MATCH_ITEM_ID_STR, str5);
                jSONObject.put("businessId", str6);
                jSONObject.put("naid", str7);
                jSONObject.put("scene", str8);
                this.f10274a.k(jSONObject, new b(this));
            } catch (JSONException e2) {
                if (f10273b) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
