package c.a.p0.a.j1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.p0.a.d2.n;
import c.a.p0.a.x1.c.j.b;
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
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f5832g;

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f5833h;

    /* renamed from: i  reason: collision with root package name */
    public static final Map<String, String> f5834i;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.a.t1.e f5835b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppActivity f5836c;

    /* renamed from: d  reason: collision with root package name */
    public PaymentManager f5837d;

    /* renamed from: e  reason: collision with root package name */
    public String f5838e;

    /* renamed from: f  reason: collision with root package name */
    public String f5839f;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.p2.g1.c<c.a.p0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f5840e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5841f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f5842g;

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
            this.f5842g = iVar;
            this.f5840e = jSONObject;
            this.f5841f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.x1.c.d.h(iVar)) {
                    this.f5842g.p(this.f5840e, this.f5841f);
                    return;
                }
                c.a.p0.a.u.d.i("SwanAppThirdPayment", "authorize fail");
                n.H(false, this.f5842g.f5839f, n.m("", "authorize fail"));
                this.f5842g.i(new c.a.p0.a.k.h.b(iVar.b(), c.a.p0.a.x1.c.d.f(iVar.b())));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5843e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f5844f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f5845g;

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
            this.f5845g = iVar;
            this.f5843e = str;
            this.f5844f = jSONObject;
        }

        @Override // c.a.p0.a.c.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    n.J(this.f5845g.f5839f, true, false);
                    n.S("success", 13, this.f5843e);
                    this.f5845g.l(this.f5844f);
                    return;
                }
                c.a.p0.a.u.d.i("SwanAppThirdPayment", "login fail");
                n.H(false, this.f5845g.f5839f, n.m("", "login error"));
                n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 13, this.f5843e);
                n.J(this.f5845g.f5839f, false, false);
                this.f5845g.i(new c.a.p0.a.k.h.b(5, "login error"));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.d0.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f5846b;

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
            this.f5846b = iVar;
            this.a = jSONObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // c.a.d0.e.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPayResult(int i2, String str) {
            JSONObject jSONObject;
            JSONException e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                c.a.p0.a.u.d.b("SwanAppThirdPayment", "pay result from nuomi: code:" + i2 + ", result: " + str);
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
                        if (i.f5832g) {
                            Log.getStackTraceString(e2);
                        }
                        if (obj != null) {
                        }
                        if (i2 != 0) {
                        }
                        if (i2 != 1) {
                        }
                        String j2 = i.j(i2, this.f5846b.f5836c);
                        if (TextUtils.equals("WeChat", this.f5846b.f5838e)) {
                            i2 = 0;
                        }
                        this.f5846b.i(new c.a.p0.a.k.h.b(i2, j2, jSONObject));
                    }
                } catch (JSONException e4) {
                    jSONObject = jSONObject2;
                    e2 = e4;
                }
                if (obj != null) {
                    try {
                        jSONObject.put("returnData", new JSONObject(String.valueOf(obj)));
                    } catch (JSONException e5) {
                        if (i.f5832g) {
                            Log.getStackTraceString(e5);
                        }
                        try {
                            jSONObject.put("returnData", obj);
                        } catch (JSONException e6) {
                            if (i.f5832g) {
                                Log.getStackTraceString(e6);
                            }
                        }
                    }
                }
                if (i2 != 0) {
                    n.H(true, this.f5846b.f5839f, this.f5846b.k(str, this.a));
                } else {
                    c.a.p0.a.u.d.i("SwanAppThirdPayment", "pay not success: code:" + i2 + ", result: " + str);
                    n.H(false, this.f5846b.f5839f, this.f5846b.k(str, this.a));
                }
                if (i2 != 1) {
                    n.K(this.f5846b.f5839f, "result", i2);
                }
                String j22 = i.j(i2, this.f5846b.f5836c);
                if (TextUtils.equals("WeChat", this.f5846b.f5838e) && i2 == 1) {
                    i2 = 0;
                }
                this.f5846b.i(new c.a.p0.a.k.h.b(i2, j22, jSONObject));
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(@NonNull c.a.p0.a.k.h.b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(820884067, "Lc/a/p0/a/j1/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(820884067, "Lc/a/p0/a/j1/i;");
                return;
            }
        }
        f5832g = c.a.p0.a.a.a;
        f5833h = new String[]{"dealId", "appKey", "totalAmount", "tpOrderId", "rsaSign", "dealTitle", PolyActivity.CHOSEN_CHANNEL_KEY, "payInfo", "tradeNo", "mchIdMd5"};
        HashMap hashMap = new HashMap();
        f5834i = hashMap;
        hashMap.put("WeChat", "thirdPayWechatH5");
        f5834i.put("Alipay", "thirdPayAlipay");
    }

    public i(@NonNull c.a.p0.a.t1.e eVar, @NonNull SwanAppActivity swanAppActivity, @NonNull d dVar) {
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
        this.f5839f = "thirdPayUnknown";
        this.f5835b = eVar;
        this.f5836c = swanAppActivity;
        this.a = dVar;
        this.f5837d = new PaymentManager();
    }

    public static String j(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65546, null, i2, context)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        return context.getString(R.string.swan_app_pay_result_fail);
                    }
                    return context.getString(R.string.swan_app_pay_result_cancel);
                }
                return context.getString(R.string.swan_app_pay_result_paying);
            }
            return context.getString(R.string.swan_app_pay_result_success);
        }
        return (String) invokeIL.objValue;
    }

    public final void i(@NonNull c.a.p0.a.k.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.a.a(bVar);
            c.a.p0.a.u.d.b("SwanAppThirdPayment", "pay result to js: " + bVar);
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
                c.a.p0.a.u.d.b("SwanAppThirdPayment", Log.getStackTraceString(e2));
                try {
                    jSONObject2.put("orderId", jSONObject.opt("tpOrderId"));
                    jSONObject2.put("msg", str);
                } catch (JSONException e3) {
                    c.a.p0.a.u.d.b("SwanAppThirdPayment", Log.getStackTraceString(e3));
                }
            }
            return jSONObject2.toString();
        }
        return (String) invokeLL.objValue;
    }

    public final void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            n.K(this.f5839f, "intoPayment", 0);
            try {
                e.z(this.f5835b, jSONObject);
                jSONObject.put(PolyActivity.TRADE_TYPE, PolyActivity.DIRECT_PAY_TRADE_TYPE);
                jSONObject.put(PolyActivity.PANEL_TYPE_KEY, "NONE");
            } catch (JSONException e2) {
                if (f5832g) {
                    Log.getStackTraceString(e2);
                }
            }
            c.a.p0.a.u.d.b("SwanAppThirdPayment", "orderInfo to nuomi: " + jSONObject);
            this.f5837d.j(this.f5836c, jSONObject, null, new c(this, jSONObject));
        }
    }

    public final c.a.p0.a.k.h.b m(JSONObject jSONObject) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new c.a.p0.a.k.h.b(202, "parse orderInfo fail");
            }
            for (String str : f5833h) {
                Object opt = jSONObject.opt(str);
                if (opt == null) {
                    return new c.a.p0.a.k.h.b(202, str + " is necessary");
                } else if (!(opt instanceof String)) {
                    return new c.a.p0.a.k.h.b(202, str + " must be a string");
                } else if (TextUtils.isEmpty((String) opt)) {
                    return new c.a.p0.a.k.h.b(202, str + " is empty");
                }
            }
            Object opt2 = jSONObject.opt("returnData");
            if (opt2 == null || (opt2 instanceof JSONObject)) {
                return null;
            }
            return new c.a.p0.a.k.h.b(202, "returnData must be a object");
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    public void n(@Nullable JSONObject jSONObject, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, str) == null) {
            n.K(this.f5839f, "create", 0);
            c.a.p0.a.k.h.b m = m(jSONObject);
            if (m != null) {
                c.a.p0.a.u.d.i("SwanAppThirdPayment", "orderInfo param error: " + m);
                n.H(false, this.f5839f, n.m("", "orderInfo param error"));
                i(m);
                return;
            }
            String optString = jSONObject.optString(PolyActivity.CHOSEN_CHANNEL_KEY);
            this.f5838e = optString;
            String str2 = f5834i.get(optString);
            this.f5839f = str2;
            if (TextUtils.isEmpty(str2)) {
                c.a.p0.a.u.d.i("SwanAppThirdPayment", "orderInfo param error: chosen channel error");
                n.H(false, "thirdPayUnknown", n.m("", "orderInfo param error: chosen channel error"));
                i(new c.a.p0.a.k.h.b(202, "chosenChannel error"));
                return;
            }
            o(jSONObject, str);
        }
    }

    public final void o(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, jSONObject, str) == null) {
            this.f5835b.d0().g(this.f5836c, "scope_request_thirdpayment", new a(this, jSONObject, str));
        }
    }

    public final void p(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, jSONObject, str) == null) {
            if (!c.a.d0.a.a().b(this.f5836c)) {
                SwanAppActivity swanAppActivity = this.f5836c;
                c.a.p0.a.s1.b.f.e.g(swanAppActivity, swanAppActivity.getText(R.string.aiapps_wx_not_install_toast_msg)).G();
                n.H(false, "wechatH5Action", n.m("", "Error: wechat not install. "));
                i(new c.a.p0.a.k.h.b(1002, "had not installed WeChat"));
                return;
            }
            n.K(this.f5839f, "login", 0);
            if (this.f5835b.M().e(this.f5836c)) {
                n.J(this.f5839f, true, true);
                l(jSONObject);
                return;
            }
            n.S("show", 13, str);
            this.f5835b.M().f(this.f5836c, null, new b(this, str, jSONObject));
        }
    }
}
