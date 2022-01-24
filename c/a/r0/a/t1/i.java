package c.a.r0.a.t1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.r0.a.h2.c.j.b;
import c.a.r0.a.n2.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f9004g;

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f9005h;

    /* renamed from: i  reason: collision with root package name */
    public static final Map<String, String> f9006i;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.a.d2.e f9007b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppActivity f9008c;

    /* renamed from: d  reason: collision with root package name */
    public PaymentManager f9009d;

    /* renamed from: e  reason: collision with root package name */
    public String f9010e;

    /* renamed from: f  reason: collision with root package name */
    public String f9011f;

    /* loaded from: classes.dex */
    public class a implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f9012e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9013f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f9014g;

        public a(i iVar, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9014g = iVar;
            this.f9012e = jSONObject;
            this.f9013f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.r0.a.h2.c.d.h(iVar)) {
                    this.f9014g.p(this.f9012e, this.f9013f);
                    return;
                }
                c.a.r0.a.e0.d.i("SwanAppThirdPayment", "authorize fail");
                n.H(false, this.f9014g.f9011f, n.m("", "authorize fail"));
                this.f9014g.i(new c.a.r0.a.u.h.b(iVar.b(), c.a.r0.a.h2.c.d.f(iVar.b())));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.r0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9015e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f9016f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f9017g;

        public b(i iVar, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9017g = iVar;
            this.f9015e = str;
            this.f9016f = jSONObject;
        }

        @Override // c.a.r0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    n.J(this.f9017g.f9011f, true, false);
                    n.S("success", 13, this.f9015e);
                    this.f9017g.l(this.f9016f);
                    return;
                }
                c.a.r0.a.e0.d.i("SwanAppThirdPayment", "login fail");
                n.H(false, this.f9017g.f9011f, n.m("", "login error"));
                n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 13, this.f9015e);
                n.J(this.f9017g.f9011f, false, false);
                this.f9017g.i(new c.a.r0.a.u.h.b(5, "login error"));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.f0.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f9018b;

        public c(i iVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9018b = iVar;
            this.a = jSONObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // c.a.f0.f.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPayResult(int i2, String str) {
            JSONObject jSONObject;
            JSONException e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                c.a.r0.a.e0.d.b("SwanAppThirdPayment", "pay result from nuomi: code:" + i2 + ", result: " + str);
                JSONObject jSONObject2 = new JSONObject();
                Object obj = null;
                try {
                    jSONObject = new JSONObject(str);
                    try {
                        obj = jSONObject.remove("returnData");
                        jSONObject.remove("msg");
                        jSONObject.remove(EnterDxmPayServiceAction.SERVICE_STATUS_CODE);
                    } catch (JSONException e3) {
                        e2 = e3;
                        if (i.f9004g) {
                            Log.getStackTraceString(e2);
                        }
                        if (obj != null) {
                        }
                        if (i2 != 0) {
                        }
                        if (i2 != 1) {
                        }
                        String j2 = i.j(i2, this.f9018b.f9008c);
                        if (TextUtils.equals("WeChat", this.f9018b.f9010e)) {
                            i2 = 0;
                        }
                        this.f9018b.i(new c.a.r0.a.u.h.b(i2, j2, jSONObject));
                    }
                } catch (JSONException e4) {
                    jSONObject = jSONObject2;
                    e2 = e4;
                }
                if (obj != null) {
                    try {
                        jSONObject.put("returnData", new JSONObject(String.valueOf(obj)));
                    } catch (JSONException e5) {
                        if (i.f9004g) {
                            Log.getStackTraceString(e5);
                        }
                        try {
                            jSONObject.put("returnData", obj);
                        } catch (JSONException e6) {
                            if (i.f9004g) {
                                Log.getStackTraceString(e6);
                            }
                        }
                    }
                }
                if (i2 != 0) {
                    n.H(true, this.f9018b.f9011f, this.f9018b.k(str, this.a));
                } else {
                    c.a.r0.a.e0.d.i("SwanAppThirdPayment", "pay not success: code:" + i2 + ", result: " + str);
                    n.H(false, this.f9018b.f9011f, this.f9018b.k(str, this.a));
                }
                if (i2 != 1) {
                    n.K(this.f9018b.f9011f, "result", i2);
                }
                String j22 = i.j(i2, this.f9018b.f9008c);
                if (TextUtils.equals("WeChat", this.f9018b.f9010e) && i2 == 1) {
                    i2 = 0;
                }
                this.f9018b.i(new c.a.r0.a.u.h.b(i2, j22, jSONObject));
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(@NonNull c.a.r0.a.u.h.b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(437092267, "Lc/a/r0/a/t1/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(437092267, "Lc/a/r0/a/t1/i;");
                return;
            }
        }
        f9004g = c.a.r0.a.k.a;
        f9005h = new String[]{"dealId", "appKey", "totalAmount", "tpOrderId", "rsaSign", "dealTitle", PolyActivity.CHOSEN_CHANNEL_KEY, "payInfo", "tradeNo", "mchIdMd5"};
        HashMap hashMap = new HashMap();
        f9006i = hashMap;
        hashMap.put("WeChat", "thirdPayWechatH5");
        f9006i.put("Alipay", "thirdPayAlipay");
    }

    public i(@NonNull c.a.r0.a.d2.e eVar, @NonNull SwanAppActivity swanAppActivity, @NonNull d dVar) {
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
        this.f9011f = "thirdPayUnknown";
        this.f9007b = eVar;
        this.f9008c = swanAppActivity;
        this.a = dVar;
        this.f9009d = new PaymentManager();
    }

    public static String j(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65546, null, i2, context)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        return context.getString(c.a.r0.a.h.swan_app_pay_result_fail);
                    }
                    return context.getString(c.a.r0.a.h.swan_app_pay_result_cancel);
                }
                return context.getString(c.a.r0.a.h.swan_app_pay_result_paying);
            }
            return context.getString(c.a.r0.a.h.swan_app_pay_result_success);
        }
        return (String) invokeIL.objValue;
    }

    public final void i(@NonNull c.a.r0.a.u.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.a.a(bVar);
            c.a.r0.a.e0.d.b("SwanAppThirdPayment", "pay result to js: " + bVar);
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
                c.a.r0.a.e0.d.b("SwanAppThirdPayment", Log.getStackTraceString(e2));
                try {
                    jSONObject2.put("orderId", jSONObject.opt("tpOrderId"));
                    jSONObject2.put("msg", str);
                } catch (JSONException e3) {
                    c.a.r0.a.e0.d.b("SwanAppThirdPayment", Log.getStackTraceString(e3));
                }
            }
            return jSONObject2.toString();
        }
        return (String) invokeLL.objValue;
    }

    public final void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            n.K(this.f9011f, "intoPayment", 0);
            try {
                e.z(this.f9007b, jSONObject);
                jSONObject.put(PolyActivity.TRADE_TYPE, PolyActivity.DIRECT_PAY_TRADE_TYPE);
                jSONObject.put(PolyActivity.PANEL_TYPE_KEY, PolyActivity.NONE_PANEL_TYPE);
            } catch (JSONException e2) {
                if (f9004g) {
                    Log.getStackTraceString(e2);
                }
            }
            c.a.r0.a.e0.d.b("SwanAppThirdPayment", "orderInfo to nuomi: " + jSONObject);
            this.f9009d.j(this.f9008c, jSONObject, null, new c(this, jSONObject));
        }
    }

    public final c.a.r0.a.u.h.b m(JSONObject jSONObject) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new c.a.r0.a.u.h.b(202, "parse orderInfo fail");
            }
            for (String str : f9005h) {
                Object opt = jSONObject.opt(str);
                if (opt == null) {
                    return new c.a.r0.a.u.h.b(202, str + " is necessary");
                } else if (!(opt instanceof String)) {
                    return new c.a.r0.a.u.h.b(202, str + " must be a string");
                } else if (TextUtils.isEmpty((String) opt)) {
                    return new c.a.r0.a.u.h.b(202, str + " is empty");
                }
            }
            Object opt2 = jSONObject.opt("returnData");
            if (opt2 == null || (opt2 instanceof JSONObject)) {
                return null;
            }
            return new c.a.r0.a.u.h.b(202, "returnData must be a object");
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    public void n(@Nullable JSONObject jSONObject, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, str) == null) {
            n.K(this.f9011f, "create", 0);
            c.a.r0.a.u.h.b m = m(jSONObject);
            if (m != null) {
                c.a.r0.a.e0.d.i("SwanAppThirdPayment", "orderInfo param error: " + m);
                n.H(false, this.f9011f, n.m("", "orderInfo param error"));
                i(m);
                return;
            }
            String optString = jSONObject.optString(PolyActivity.CHOSEN_CHANNEL_KEY);
            this.f9010e = optString;
            String str2 = f9006i.get(optString);
            this.f9011f = str2;
            if (TextUtils.isEmpty(str2)) {
                c.a.r0.a.e0.d.i("SwanAppThirdPayment", "orderInfo param error: chosen channel error");
                n.H(false, "thirdPayUnknown", n.m("", "orderInfo param error: chosen channel error"));
                i(new c.a.r0.a.u.h.b(202, "chosenChannel error"));
                return;
            }
            o(jSONObject, str);
        }
    }

    public final void o(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, jSONObject, str) == null) {
            this.f9007b.d0().g(this.f9008c, "scope_request_thirdpayment", new a(this, jSONObject, str));
        }
    }

    public final void p(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, jSONObject, str) == null) {
            if (!c.a.f0.a.a().b(this.f9008c)) {
                SwanAppActivity swanAppActivity = this.f9008c;
                c.a.r0.a.c2.b.f.e.g(swanAppActivity, swanAppActivity.getText(c.a.r0.a.h.aiapps_wx_not_install_toast_msg)).G();
                n.H(false, "wechatH5Action", n.m("", "Error: wechat not install. "));
                i(new c.a.r0.a.u.h.b(1002, "had not installed WeChat"));
                return;
            }
            n.K(this.f9011f, "login", 0);
            if (this.f9007b.M().e(this.f9008c)) {
                n.J(this.f9011f, true, true);
                l(jSONObject);
                return;
            }
            n.S("show", 13, str);
            this.f9007b.M().f(this.f9008c, null, new b(this, str, jSONObject));
        }
    }
}
