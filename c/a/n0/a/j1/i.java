package c.a.n0.a.j1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.d2.n;
import c.a.n0.a.x1.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f4918g;

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f4919h;
    public static final Map<String, String> i;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.a.t1.e f4920b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppActivity f4921c;

    /* renamed from: d  reason: collision with root package name */
    public PaymentManager f4922d;

    /* renamed from: e  reason: collision with root package name */
    public String f4923e;

    /* renamed from: f  reason: collision with root package name */
    public String f4924f;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4925b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f4926c;

        public a(i iVar, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4926c = iVar;
            this.a = jSONObject;
            this.f4925b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.n0.a.x1.c.d.h(iVar)) {
                    this.f4926c.p(this.a, this.f4925b);
                    return;
                }
                c.a.n0.a.u.d.i("SwanAppThirdPayment", "authorize fail");
                n.H(false, this.f4926c.f4924f, n.m("", "authorize fail"));
                this.f4926c.i(new c.a.n0.a.k.h.b(iVar.b(), c.a.n0.a.x1.c.d.f(iVar.b())));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.a.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4927b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f4928c;

        public b(i iVar, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4928c = iVar;
            this.a = str;
            this.f4927b = jSONObject;
        }

        @Override // c.a.n0.a.c.a
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    n.J(this.f4928c.f4924f, true, false);
                    n.S("success", 13, this.a);
                    this.f4928c.l(this.f4927b);
                    return;
                }
                c.a.n0.a.u.d.i("SwanAppThirdPayment", "login fail");
                n.H(false, this.f4928c.f4924f, n.m("", "login error"));
                n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 13, this.a);
                n.J(this.f4928c.f4924f, false, false);
                this.f4928c.i(new c.a.n0.a.k.h.b(5, "login error"));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.c0.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f4929b;

        public c(i iVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4929b = iVar;
            this.a = jSONObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // c.a.c0.e.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPayResult(int i, String str) {
            JSONObject jSONObject;
            JSONException e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                c.a.n0.a.u.d.b("SwanAppThirdPayment", "pay result from nuomi: code:" + i + ", result: " + str);
                JSONObject jSONObject2 = new JSONObject();
                Object obj = null;
                try {
                    jSONObject = new JSONObject(str);
                    try {
                        obj = jSONObject.remove("returnData");
                        jSONObject.remove("msg");
                        jSONObject.remove("statusCode");
                    } catch (JSONException e3) {
                        e2 = e3;
                        if (i.f4918g) {
                            Log.e("SwanAppThirdPayment", Log.getStackTraceString(e2));
                        }
                        if (obj != null) {
                        }
                        if (i != 0) {
                        }
                        if (i != 1) {
                        }
                        String j = i.j(i, this.f4929b.f4921c);
                        if (TextUtils.equals("WeChat", this.f4929b.f4923e)) {
                            i = 0;
                        }
                        this.f4929b.i(new c.a.n0.a.k.h.b(i, j, jSONObject));
                    }
                } catch (JSONException e4) {
                    jSONObject = jSONObject2;
                    e2 = e4;
                }
                if (obj != null) {
                    try {
                        jSONObject.put("returnData", new JSONObject(String.valueOf(obj)));
                    } catch (JSONException e5) {
                        if (i.f4918g) {
                            Log.e("SwanAppThirdPayment", Log.getStackTraceString(e5));
                        }
                        try {
                            jSONObject.put("returnData", obj);
                        } catch (JSONException e6) {
                            if (i.f4918g) {
                                Log.e("SwanAppThirdPayment", Log.getStackTraceString(e6));
                            }
                        }
                    }
                }
                if (i != 0) {
                    n.H(true, this.f4929b.f4924f, this.f4929b.k(str, this.a));
                } else {
                    c.a.n0.a.u.d.i("SwanAppThirdPayment", "pay not success: code:" + i + ", result: " + str);
                    n.H(false, this.f4929b.f4924f, this.f4929b.k(str, this.a));
                }
                if (i != 1) {
                    n.K(this.f4929b.f4924f, "result", i);
                }
                String j2 = i.j(i, this.f4929b.f4921c);
                if (TextUtils.equals("WeChat", this.f4929b.f4923e) && i == 1) {
                    i = 0;
                }
                this.f4929b.i(new c.a.n0.a.k.h.b(i, j2, jSONObject));
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(@NonNull c.a.n0.a.k.h.b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1213911077, "Lc/a/n0/a/j1/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1213911077, "Lc/a/n0/a/j1/i;");
                return;
            }
        }
        f4918g = c.a.n0.a.a.a;
        f4919h = new String[]{"dealId", "appKey", "totalAmount", "tpOrderId", "rsaSign", "dealTitle", PolyActivity.CHOSEN_CHANNEL_KEY, "payInfo", "tradeNo", "mchIdMd5"};
        HashMap hashMap = new HashMap();
        i = hashMap;
        hashMap.put("WeChat", "thirdPayWechatH5");
        i.put("Alipay", "thirdPayAlipay");
    }

    public i(@NonNull c.a.n0.a.t1.e eVar, @NonNull SwanAppActivity swanAppActivity, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, swanAppActivity, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4924f = "thirdPayUnknown";
        this.f4920b = eVar;
        this.f4921c = swanAppActivity;
        this.a = dVar;
        this.f4922d = new PaymentManager();
    }

    public static String j(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65546, null, i2, context)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        return context.getString(R.string.obfuscated_res_0x7f0f121f);
                    }
                    return context.getString(R.string.obfuscated_res_0x7f0f121e);
                }
                return context.getString(R.string.obfuscated_res_0x7f0f1220);
            }
            return context.getString(R.string.obfuscated_res_0x7f0f1221);
        }
        return (String) invokeIL.objValue;
    }

    public final void i(@NonNull c.a.n0.a.k.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.a.a(bVar);
            c.a.n0.a.u.d.b("SwanAppThirdPayment", "pay result to js: " + bVar);
        }
    }

    public final String k(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject(str);
                jSONObject2.put("orderId", jSONObject.opt("tpOrderId"));
                jSONObject2.put("msg", jSONObject3.opt("msg"));
            } catch (JSONException e2) {
                c.a.n0.a.u.d.b("SwanAppThirdPayment", Log.getStackTraceString(e2));
                try {
                    jSONObject2.put("orderId", jSONObject.opt("tpOrderId"));
                    jSONObject2.put("msg", str);
                } catch (JSONException e3) {
                    c.a.n0.a.u.d.b("SwanAppThirdPayment", Log.getStackTraceString(e3));
                }
            }
            return jSONObject2.toString();
        }
        return (String) invokeLL.objValue;
    }

    public final void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            n.K(this.f4924f, "intoPayment", 0);
            try {
                e.z(this.f4920b, jSONObject);
                jSONObject.put(PolyActivity.TRADE_TYPE, PolyActivity.DIRECT_PAY_TRADE_TYPE);
                jSONObject.put(PolyActivity.PANEL_TYPE_KEY, "NONE");
            } catch (JSONException e2) {
                if (f4918g) {
                    Log.e("SwanAppThirdPayment", Log.getStackTraceString(e2));
                }
            }
            c.a.n0.a.u.d.b("SwanAppThirdPayment", "orderInfo to nuomi: " + jSONObject);
            this.f4922d.j(this.f4921c, jSONObject, null, new c(this, jSONObject));
        }
    }

    public final c.a.n0.a.k.h.b m(JSONObject jSONObject) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new c.a.n0.a.k.h.b(202, "parse orderInfo fail");
            }
            for (String str : f4919h) {
                Object opt = jSONObject.opt(str);
                if (opt == null) {
                    return new c.a.n0.a.k.h.b(202, str + " is necessary");
                } else if (!(opt instanceof String)) {
                    return new c.a.n0.a.k.h.b(202, str + " must be a string");
                } else if (TextUtils.isEmpty((String) opt)) {
                    return new c.a.n0.a.k.h.b(202, str + " is empty");
                }
            }
            Object opt2 = jSONObject.opt("returnData");
            if (opt2 == null || (opt2 instanceof JSONObject)) {
                return null;
            }
            return new c.a.n0.a.k.h.b(202, "returnData must be a object");
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public void n(@Nullable JSONObject jSONObject, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, str) == null) {
            n.K(this.f4924f, "create", 0);
            c.a.n0.a.k.h.b m = m(jSONObject);
            if (m != null) {
                c.a.n0.a.u.d.i("SwanAppThirdPayment", "orderInfo param error: " + m);
                n.H(false, this.f4924f, n.m("", "orderInfo param error"));
                i(m);
                return;
            }
            String optString = jSONObject.optString(PolyActivity.CHOSEN_CHANNEL_KEY);
            this.f4923e = optString;
            String str2 = i.get(optString);
            this.f4924f = str2;
            if (TextUtils.isEmpty(str2)) {
                c.a.n0.a.u.d.i("SwanAppThirdPayment", "orderInfo param error: chosen channel error");
                n.H(false, "thirdPayUnknown", n.m("", "orderInfo param error: chosen channel error"));
                i(new c.a.n0.a.k.h.b(202, "chosenChannel error"));
                return;
            }
            o(jSONObject, str);
        }
    }

    public final void o(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, jSONObject, str) == null) {
            this.f4920b.d0().g(this.f4921c, "scope_request_thirdpayment", new a(this, jSONObject, str));
        }
    }

    public final void p(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, jSONObject, str) == null) {
            if (!c.a.c0.a.a().b(this.f4921c)) {
                SwanAppActivity swanAppActivity = this.f4921c;
                c.a.n0.a.s1.b.f.e.g(swanAppActivity, swanAppActivity.getText(R.string.obfuscated_res_0x7f0f01df)).G();
                n.H(false, "wechatH5Action", n.m("", "Error: wechat not install. "));
                i(new c.a.n0.a.k.h.b(1002, "had not installed WeChat"));
                return;
            }
            n.K(this.f4924f, "login", 0);
            if (this.f4920b.M().e(this.f4921c)) {
                n.J(this.f4924f, true, true);
                l(jSONObject);
                return;
            }
            n.S("show", 13, str);
            this.f4920b.M().f(this.f4921c, null, new b(this, str, jSONObject));
        }
    }
}
