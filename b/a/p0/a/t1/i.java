package b.a.p0.a.t1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.h2.c.j.b;
import b.a.p0.a.n2.n;
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
    public static final boolean f8442g;

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f8443h;

    /* renamed from: i  reason: collision with root package name */
    public static final Map<String, String> f8444i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f8445a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.d2.e f8446b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppActivity f8447c;

    /* renamed from: d  reason: collision with root package name */
    public PaymentManager f8448d;

    /* renamed from: e  reason: collision with root package name */
    public String f8449e;

    /* renamed from: f  reason: collision with root package name */
    public String f8450f;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.z2.g1.c<b.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8451e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8452f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f8453g;

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
            this.f8453g = iVar;
            this.f8451e = jSONObject;
            this.f8452f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.h2.c.d.h(iVar)) {
                    this.f8453g.p(this.f8451e, this.f8452f);
                    return;
                }
                b.a.p0.a.e0.d.i("SwanAppThirdPayment", "authorize fail");
                n.H(false, this.f8453g.f8450f, n.m("", "authorize fail"));
                this.f8453g.i(new b.a.p0.a.u.h.b(iVar.b(), b.a.p0.a.h2.c.d.f(iVar.b())));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8454e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8455f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f8456g;

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
            this.f8456g = iVar;
            this.f8454e = str;
            this.f8455f = jSONObject;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    n.J(this.f8456g.f8450f, true, false);
                    n.S("success", 13, this.f8454e);
                    this.f8456g.l(this.f8455f);
                    return;
                }
                b.a.p0.a.e0.d.i("SwanAppThirdPayment", "login fail");
                n.H(false, this.f8456g.f8450f, n.m("", "login error"));
                n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 13, this.f8454e);
                n.J(this.f8456g.f8450f, false, false);
                this.f8456g.i(new b.a.p0.a.u.h.b(5, "login error"));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.d0.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8457a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f8458b;

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
            this.f8458b = iVar;
            this.f8457a = jSONObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // b.a.d0.f.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPayResult(int i2, String str) {
            JSONObject jSONObject;
            JSONException e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                b.a.p0.a.e0.d.b("SwanAppThirdPayment", "pay result from nuomi: code:" + i2 + ", result: " + str);
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
                        if (i.f8442g) {
                            Log.getStackTraceString(e2);
                        }
                        if (obj != null) {
                        }
                        if (i2 != 0) {
                        }
                        if (i2 != 1) {
                        }
                        String j = i.j(i2, this.f8458b.f8447c);
                        if (TextUtils.equals("WeChat", this.f8458b.f8449e)) {
                            i2 = 0;
                        }
                        this.f8458b.i(new b.a.p0.a.u.h.b(i2, j, jSONObject));
                    }
                } catch (JSONException e4) {
                    jSONObject = jSONObject2;
                    e2 = e4;
                }
                if (obj != null) {
                    try {
                        jSONObject.put("returnData", new JSONObject(String.valueOf(obj)));
                    } catch (JSONException e5) {
                        if (i.f8442g) {
                            Log.getStackTraceString(e5);
                        }
                        try {
                            jSONObject.put("returnData", obj);
                        } catch (JSONException e6) {
                            if (i.f8442g) {
                                Log.getStackTraceString(e6);
                            }
                        }
                    }
                }
                if (i2 != 0) {
                    n.H(true, this.f8458b.f8450f, this.f8458b.k(str, this.f8457a));
                } else {
                    b.a.p0.a.e0.d.i("SwanAppThirdPayment", "pay not success: code:" + i2 + ", result: " + str);
                    n.H(false, this.f8458b.f8450f, this.f8458b.k(str, this.f8457a));
                }
                if (i2 != 1) {
                    n.K(this.f8458b.f8450f, "result", i2);
                }
                String j2 = i.j(i2, this.f8458b.f8447c);
                if (TextUtils.equals("WeChat", this.f8458b.f8449e) && i2 == 1) {
                    i2 = 0;
                }
                this.f8458b.i(new b.a.p0.a.u.h.b(i2, j2, jSONObject));
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(@NonNull b.a.p0.a.u.h.b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1335677902, "Lb/a/p0/a/t1/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1335677902, "Lb/a/p0/a/t1/i;");
                return;
            }
        }
        f8442g = b.a.p0.a.k.f6863a;
        f8443h = new String[]{"dealId", "appKey", "totalAmount", "tpOrderId", "rsaSign", "dealTitle", PolyActivity.CHOSEN_CHANNEL_KEY, "payInfo", "tradeNo", "mchIdMd5"};
        HashMap hashMap = new HashMap();
        f8444i = hashMap;
        hashMap.put("WeChat", "thirdPayWechatH5");
        f8444i.put("Alipay", "thirdPayAlipay");
    }

    public i(@NonNull b.a.p0.a.d2.e eVar, @NonNull SwanAppActivity swanAppActivity, @NonNull d dVar) {
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
        this.f8450f = "thirdPayUnknown";
        this.f8446b = eVar;
        this.f8447c = swanAppActivity;
        this.f8445a = dVar;
        this.f8448d = new PaymentManager();
    }

    public static String j(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65546, null, i2, context)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        return context.getString(b.a.p0.a.h.swan_app_pay_result_fail);
                    }
                    return context.getString(b.a.p0.a.h.swan_app_pay_result_cancel);
                }
                return context.getString(b.a.p0.a.h.swan_app_pay_result_paying);
            }
            return context.getString(b.a.p0.a.h.swan_app_pay_result_success);
        }
        return (String) invokeIL.objValue;
    }

    public final void i(@NonNull b.a.p0.a.u.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f8445a.a(bVar);
            b.a.p0.a.e0.d.b("SwanAppThirdPayment", "pay result to js: " + bVar);
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
                b.a.p0.a.e0.d.b("SwanAppThirdPayment", Log.getStackTraceString(e2));
                try {
                    jSONObject2.put("orderId", jSONObject.opt("tpOrderId"));
                    jSONObject2.put("msg", str);
                } catch (JSONException e3) {
                    b.a.p0.a.e0.d.b("SwanAppThirdPayment", Log.getStackTraceString(e3));
                }
            }
            return jSONObject2.toString();
        }
        return (String) invokeLL.objValue;
    }

    public final void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            n.K(this.f8450f, "intoPayment", 0);
            try {
                e.z(this.f8446b, jSONObject);
                jSONObject.put(PolyActivity.TRADE_TYPE, PolyActivity.DIRECT_PAY_TRADE_TYPE);
                jSONObject.put(PolyActivity.PANEL_TYPE_KEY, "NONE");
            } catch (JSONException e2) {
                if (f8442g) {
                    Log.getStackTraceString(e2);
                }
            }
            b.a.p0.a.e0.d.b("SwanAppThirdPayment", "orderInfo to nuomi: " + jSONObject);
            this.f8448d.j(this.f8447c, jSONObject, null, new c(this, jSONObject));
        }
    }

    public final b.a.p0.a.u.h.b m(JSONObject jSONObject) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new b.a.p0.a.u.h.b(202, "parse orderInfo fail");
            }
            for (String str : f8443h) {
                Object opt = jSONObject.opt(str);
                if (opt == null) {
                    return new b.a.p0.a.u.h.b(202, str + " is necessary");
                } else if (!(opt instanceof String)) {
                    return new b.a.p0.a.u.h.b(202, str + " must be a string");
                } else if (TextUtils.isEmpty((String) opt)) {
                    return new b.a.p0.a.u.h.b(202, str + " is empty");
                }
            }
            Object opt2 = jSONObject.opt("returnData");
            if (opt2 == null || (opt2 instanceof JSONObject)) {
                return null;
            }
            return new b.a.p0.a.u.h.b(202, "returnData must be a object");
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public void n(@Nullable JSONObject jSONObject, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, str) == null) {
            n.K(this.f8450f, "create", 0);
            b.a.p0.a.u.h.b m = m(jSONObject);
            if (m != null) {
                b.a.p0.a.e0.d.i("SwanAppThirdPayment", "orderInfo param error: " + m);
                n.H(false, this.f8450f, n.m("", "orderInfo param error"));
                i(m);
                return;
            }
            String optString = jSONObject.optString(PolyActivity.CHOSEN_CHANNEL_KEY);
            this.f8449e = optString;
            String str2 = f8444i.get(optString);
            this.f8450f = str2;
            if (TextUtils.isEmpty(str2)) {
                b.a.p0.a.e0.d.i("SwanAppThirdPayment", "orderInfo param error: chosen channel error");
                n.H(false, "thirdPayUnknown", n.m("", "orderInfo param error: chosen channel error"));
                i(new b.a.p0.a.u.h.b(202, "chosenChannel error"));
                return;
            }
            o(jSONObject, str);
        }
    }

    public final void o(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, jSONObject, str) == null) {
            this.f8446b.d0().g(this.f8447c, "scope_request_thirdpayment", new a(this, jSONObject, str));
        }
    }

    public final void p(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, jSONObject, str) == null) {
            if (!b.a.d0.a.a().b(this.f8447c)) {
                SwanAppActivity swanAppActivity = this.f8447c;
                b.a.p0.a.c2.b.f.e.g(swanAppActivity, swanAppActivity.getText(b.a.p0.a.h.aiapps_wx_not_install_toast_msg)).G();
                n.H(false, "wechatH5Action", n.m("", "Error: wechat not install. "));
                i(new b.a.p0.a.u.h.b(1002, "had not installed WeChat"));
                return;
            }
            n.K(this.f8450f, "login", 0);
            if (this.f8446b.M().e(this.f8447c)) {
                n.J(this.f8450f, true, true);
                l(jSONObject);
                return;
            }
            n.S("show", 13, str);
            this.f8446b.M().f(this.f8447c, null, new b(this, str, jSONObject));
        }
    }
}
