package c.a.p0.a.l1;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d2.e;
import c.a.p0.a.k;
import c.a.p0.a.z2.q0;
import c.a.p0.n.n;
import c.a.p0.n.o;
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
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.l1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0359a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f6752e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f6753f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6754g;

        public RunnableC0359a(Context context, SwanAppActionBar swanAppActionBar, String str) {
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
            this.f6752e = context;
            this.f6753f = swanAppActionBar;
            this.f6754g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.e(this.f6752e, this.f6753f, this.f6754g);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f6755e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f6756f;

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
            this.f6755e = jSONObject;
            this.f6756f = swanAppActionBar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.o(this.f6756f, a.n(this.f6755e));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f6757e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f6758f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f6759g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6760h;

        public c(Context context, n nVar, SwanAppActionBar swanAppActionBar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, nVar, swanAppActionBar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6757e = context;
            this.f6758f = nVar;
            this.f6759g = swanAppActionBar;
            this.f6760h = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.f(this.f6757e, this.f6758f, this.f6759g, this.f6760h);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f6761e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f6762f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f6763g;

        public d(JSONArray jSONArray, n nVar, SwanAppActionBar swanAppActionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONArray, nVar, swanAppActionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6761e = jSONArray;
            this.f6762f = nVar;
            this.f6763g = swanAppActionBar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONArray jSONArray = this.f6761e;
                int length = jSONArray == null ? 0 : jSONArray.length();
                if (length == 0) {
                    return;
                }
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = this.f6761e.optJSONObject(i2);
                    if (optJSONObject != null) {
                        this.f6762f.C(optJSONObject);
                        a.d(optJSONObject);
                    }
                }
                this.f6762f.n();
                e a0 = e.a0();
                if (a0 != null) {
                    a.o(this.f6763g, a0.T().d("key_unread_counts_message", 0).intValue());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(822730861, "Lc/a/p0/a/l1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(822730861, "Lc/a/p0/a/l1/a;");
                return;
            }
        }
        a = k.a;
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
        c.a.p0.a.k1.a.q(str, "1", "show");
    }

    public static void e(Context context, SwanAppActionBar swanAppActionBar, String str) {
        JSONObject c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, context, swanAppActionBar, str) == null) || (c2 = c.a.p0.a.c1.a.i().c(context, str)) == null || swanAppActionBar == null) {
            return;
        }
        c.a.p0.a.d2.d.L().post(new b(c2, swanAppActionBar));
    }

    public static void f(Context context, n nVar, SwanAppActionBar swanAppActionBar, String str) {
        JSONObject c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65542, null, context, nVar, swanAppActionBar, str) == null) || (c2 = c.a.p0.a.c1.a.i().c(context, str)) == null || nVar == null) {
            return;
        }
        m(c2, nVar, swanAppActionBar);
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? c.a.p0.a.d2.d.J().r().T().d("key_unread_counts_message", 0).intValue() : invokeV.intValue;
    }

    public static int h(Context context) {
        InterceptResult invokeL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            e r = c.a.p0.a.d2.d.J().r();
            if (r == null || r.V() == null || r.V().f0() == null) {
                return 0;
            }
            JSONObject c2 = c.a.p0.a.c1.a.i().c(context, r.V().f0().paNumber);
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
        if (!(interceptable == null || interceptable.invokeV(65545, null) == null) || e.a0() == null) {
            return;
        }
        e.a0().T().i("key_unread_counts_message", 0);
    }

    public static void j(o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, oVar) == null) || e.a0() == null) {
            return;
        }
        e.a0().T().i("key_unread_counts_message", Integer.valueOf(Math.max((int) (e.a0().T().d("key_unread_counts_message", 0).intValue() - oVar.e()), 0)));
    }

    public static void k(Context context, SwanAppActionBar swanAppActionBar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, swanAppActionBar, str) == null) {
            c.a.p0.a.u1.k.i.c.e().d(new RunnableC0359a(context, swanAppActionBar, str), "getRefreshTips", true);
        }
    }

    public static void l(Context context, n nVar, SwanAppActionBar swanAppActionBar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, null, context, nVar, swanAppActionBar, str) == null) {
            ExecutorUtilsExt.postOnElastic(new c(context, nVar, swanAppActionBar, str), "getMenuToolRefreshTips", 1);
        }
    }

    public static void m(JSONObject jSONObject, n nVar, SwanAppActionBar swanAppActionBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, jSONObject, nVar, swanAppActionBar) == null) {
            n(jSONObject);
            c.a.p0.a.d2.d.L().post(new d(jSONObject.optJSONArray("un_read_list"), nVar, swanAppActionBar));
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
                if (q0.R() && (optInt == 27 || optInt == 17)) {
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
            if (e.a0() != null) {
                e.a0().T().i("key_unread_counts_message", Integer.valueOf(i2));
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static void o(SwanAppActionBar swanAppActionBar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65551, null, swanAppActionBar, i2) == null) {
            if (c.a.p0.a.c1.a.y0().d()) {
                swanAppActionBar.setRightRedDotVisibility(false);
                return;
            }
            if (a) {
                String str = "update_red_dots:" + i2;
            }
            if (swanAppActionBar != null) {
                swanAppActionBar.setRightRedDotVisibility(i2 > 0);
            }
        }
    }
}
