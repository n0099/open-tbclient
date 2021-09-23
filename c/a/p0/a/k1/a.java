package c.a.p0.a.k1;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a2.e;
import c.a.p0.a.k;
import c.a.p0.a.v2.q0;
import c.a.p0.k.n;
import c.a.p0.k.o;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f7094a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0279a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f7095e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f7096f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7097g;

        public RunnableC0279a(Context context, SwanAppActionBar swanAppActionBar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, swanAppActionBar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7095e = context;
            this.f7096f = swanAppActionBar;
            this.f7097g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.e(this.f7095e, this.f7096f, this.f7097g);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7098e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f7099f;

        public b(JSONObject jSONObject, SwanAppActionBar swanAppActionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, swanAppActionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7098e = jSONObject;
            this.f7099f = swanAppActionBar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.o(this.f7099f, a.n(this.f7098e));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f7100e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f7101f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7102g;

        public c(Context context, n nVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, nVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7100e = context;
            this.f7101f = nVar;
            this.f7102g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.f(this.f7100e, this.f7101f, this.f7102g);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f7103e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f7104f;

        public d(JSONArray jSONArray, n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONArray, nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7103e = jSONArray;
            this.f7104f = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONArray jSONArray = this.f7103e;
                int length = jSONArray == null ? 0 : jSONArray.length();
                if (length == 0) {
                    return;
                }
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = this.f7103e.optJSONObject(i2);
                    if (optJSONObject != null) {
                        this.f7104f.v(optJSONObject);
                        a.d(optJSONObject);
                    }
                }
                this.f7104f.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(821807340, "Lc/a/p0/a/k1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(821807340, "Lc/a/p0/a/k1/a;");
                return;
            }
        }
        f7094a = k.f7085a;
    }

    public static void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || jSONObject == null || Long.valueOf(jSONObject.optLong("pa_unread_sums")).longValue() <= 0) {
            return;
        }
        int optInt = jSONObject.optInt("pa_type");
        String str = optInt != 7 ? optInt != 666 ? optInt != 888 ? optInt != 999 ? "" : "message" : PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE : ErrorContentResponse.Operations.NOTICE : LightappBusinessClient.MTD_CUSTOMER_SERVICE;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c.a.p0.a.j1.a.q(str, "1", "show");
    }

    public static void e(Context context, SwanAppActionBar swanAppActionBar, String str) {
        JSONObject c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, swanAppActionBar, str) == null) || (c2 = c.a.p0.a.c1.a.h().c(context, str)) == null || swanAppActionBar == null) {
            return;
        }
        c.a.p0.a.a2.d.i().post(new b(c2, swanAppActionBar));
    }

    public static void f(Context context, n nVar, String str) {
        JSONObject c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, nVar, str) == null) || (c2 = c.a.p0.a.c1.a.h().c(context, str)) == null || nVar == null) {
            return;
        }
        m(c2, nVar);
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? c.a.p0.a.a2.d.g().r().J().d("key_unread_counts_message", 0).intValue() : invokeV.intValue;
    }

    public static int h(Context context) {
        InterceptResult invokeL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            e r = c.a.p0.a.a2.d.g().r();
            if (r == null || r.L() == null || r.L().f0() == null) {
                return 0;
            }
            JSONObject c2 = c.a.p0.a.c1.a.h().c(context, r.L().f0().paNumber);
            if (c2 == null || (optJSONArray = c2.optJSONArray("un_read_list")) == null || optJSONArray.length() <= 0) {
                return 0;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null && optJSONObject.optInt("pa_type") == 888) {
                    i2 += optJSONObject.optInt("pa_unread_sums");
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, null) == null) || e.Q() == null) {
            return;
        }
        e.Q().J().i("key_unread_counts_message", 0);
    }

    public static void j(o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, oVar) == null) || e.Q() == null) {
            return;
        }
        e.Q().J().i("key_unread_counts_message", Integer.valueOf(Math.max((int) (e.Q().J().d("key_unread_counts_message", 0).intValue() - oVar.e()), 0)));
    }

    public static void k(Context context, SwanAppActionBar swanAppActionBar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, swanAppActionBar, str) == null) {
            c.a.p0.a.r1.k.i.c.f().e(new RunnableC0279a(context, swanAppActionBar, str), "getRefreshTips");
        }
    }

    public static void l(Context context, n nVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, context, nVar, str) == null) {
            ExecutorUtilsExt.postOnElastic(new c(context, nVar, str), "getMenuToolRefreshTips", 1);
        }
    }

    public static void m(JSONObject jSONObject, n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, jSONObject, nVar) == null) {
            n(jSONObject);
            c.a.p0.a.a2.d.i().post(new d(jSONObject.optJSONArray("un_read_list"), nVar));
        }
    }

    public static int n(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, jSONObject)) == null) {
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("un_read_list")) == null || optJSONArray.length() == 0) {
                return 0;
            }
            int length = optJSONArray.length();
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                int optInt = optJSONObject.optInt("pa_type");
                if (optInt == 7) {
                    i2 += optJSONObject.optInt("pa_unread_sums");
                }
                if (q0.Q() && (optInt == 27 || optInt == 17)) {
                    i2 += optJSONObject.optInt("pa_unread_sums");
                }
            }
            if (i2 == 0) {
                for (int i4 = 0; i4 < length; i4++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                    int optInt2 = optJSONObject2.optInt("pa_type");
                    if (optInt2 == 888 || optInt2 == 666 || optInt2 == 999) {
                        i2 += optJSONObject2.optInt("pa_unread_sums");
                    }
                }
            }
            if (e.Q() != null) {
                e.Q().J().i("key_unread_counts_message", Integer.valueOf(i2));
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static void o(SwanAppActionBar swanAppActionBar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65551, null, swanAppActionBar, i2) == null) {
            if (f7094a) {
                String str = "update_red_dots:" + i2;
            }
            if (swanAppActionBar != null) {
                swanAppActionBar.setRightRedDotVisibility(i2 > 0);
            }
        }
    }
}
