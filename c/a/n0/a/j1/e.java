package c.a.n0.a.j1;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d2.n;
import c.a.n0.a.j1.b;
import c.a.n0.a.v0.e.b;
import c.a.n0.a.x.g.l;
import c.a.n0.a.x1.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.payment.PaymentManager;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.pay.panel.PaymentPanelManager;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements c.a.n0.a.j1.l.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public static String[] k;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.a.t1.e a;

    /* renamed from: b  reason: collision with root package name */
    public UnitedSchemeEntity f4886b;

    /* renamed from: c  reason: collision with root package name */
    public CallbackHandler f4887c;

    /* renamed from: d  reason: collision with root package name */
    public String f4888d;

    /* renamed from: e  reason: collision with root package name */
    public String f4889e;

    /* renamed from: f  reason: collision with root package name */
    public int f4890f;

    /* renamed from: g  reason: collision with root package name */
    public String f4891g;

    /* renamed from: h  reason: collision with root package name */
    public PaymentManager f4892h;
    public String i;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4893b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4894c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f4895d;

        public a(e eVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4895d = eVar;
            this.a = str;
            this.f4893b = str2;
            this.f4894c = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
            if (r10.equals("mapp_request_duxiaoman") != false) goto L37;
         */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCallback(c.a.n0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                char c2 = 0;
                if (!c.a.n0.a.x1.c.d.h(iVar)) {
                    String str = null;
                    if (TextUtils.equals(this.f4895d.f4888d, "2.0")) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("payId", "");
                        } catch (JSONException e2) {
                            if (e.j) {
                                e2.printStackTrace();
                            }
                        }
                        str = String.valueOf(jSONObject);
                    }
                    if (TextUtils.equals(this.a, "mapp_request_duxiaoman")) {
                        n.H(false, "baiduqianbao", n.m("", "authorize fail"));
                    } else if (TextUtils.equals(this.a, "mapp_request_alipayment")) {
                        n.H(false, "alipay", n.m("", "authorize fail"));
                    } else if (TextUtils.equals(this.a, "mapp_request_wechatpayment")) {
                        n.H(false, "wechatH5Action", n.m("", "authorize fail"));
                    }
                    c.a.n0.a.u.d.k("SwanAppPaymentManager", "Error: authorized fail. scope = " + this.a);
                    this.f4895d.f4887c.handleSchemeDispatchCallback(this.f4895d.i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str, 1001, "authorize denied").toString());
                    return;
                }
                String str2 = this.a;
                int hashCode = str2.hashCode();
                if (hashCode == -1689456891) {
                    if (str2.equals("mapp_request_wechatpayment")) {
                        c2 = 2;
                    }
                    c2 = 65535;
                } else if (hashCode != -1250772529) {
                    if (hashCode == 1111965155 && str2.equals("mapp_request_alipayment")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                }
                if (c2 == 0) {
                    this.f4895d.B(this.f4893b, this.f4894c);
                } else if (c2 == 1) {
                    this.f4895d.x(this.f4893b);
                } else if (c2 != 2) {
                } else {
                    this.f4895d.P();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.a.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4896b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4897c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f4898d;

        public b(e eVar, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4898d = eVar;
            this.a = z;
            this.f4896b = str;
            this.f4897c = str2;
        }

        @Override // c.a.n0.a.c.a
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    if (!this.a) {
                        n.S("success", 9, this.f4896b);
                    }
                    this.f4898d.D(this.f4897c);
                    return;
                }
                if (!this.a) {
                    n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 9, this.f4896b);
                }
                this.f4898d.f4890f = 5;
                this.f4898d.f4891g = null;
                this.f4898d.M(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.c0.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.c0.e.b
        public void onPayResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.a.f4890f = i;
                this.a.f4891g = str;
                if (e.j) {
                    Log.d("SwanAppPaymentManager", "statusCode: " + i + " ,result:" + str);
                }
                this.a.O(i, "baiduqianbao", str);
                n.K("baiduqianbao", "result", i);
                if (i != 0 || !TextUtils.equals(this.a.f4888d, "2.0")) {
                    this.a.M(null);
                } else {
                    c.a.n0.a.s0.a.W().e(this.a.f4889e, this.a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.c0.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.c0.e.b
        public void onPayResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.a.f4890f = i;
                this.a.f4891g = str;
                c.a.n0.a.u.d.k("SwanAppPaymentManager", "statusCode: " + this.a.f4890f + " ,result:" + this.a.f4891g);
                this.a.O(i, "alipay", str);
                if (i != 1) {
                    n.K("alipay", "result", i);
                }
                if (i != 0 || !TextUtils.equals(this.a.f4888d, "2.0")) {
                    this.a.M(null);
                } else {
                    c.a.n0.a.s0.a.W().e(this.a.f4889e, this.a);
                }
            }
        }
    }

    /* renamed from: c.a.n0.a.j1.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0324e implements c.a.n0.a.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4899b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String[] f4900c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4901d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f4902e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f4903f;

        public C0324e(e eVar, String str, String str2, String[] strArr, JSONObject jSONObject, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, strArr, jSONObject, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4903f = eVar;
            this.a = str;
            this.f4899b = str2;
            this.f4900c = strArr;
            this.f4901d = jSONObject;
            this.f4902e = z;
        }

        @Override // c.a.n0.a.c.a
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    n.S("success", 8, this.a);
                    if (this.f4903f.a.v0()) {
                        this.f4903f.H(this.f4899b, this.f4900c, this.f4901d, true, false);
                        return;
                    } else {
                        this.f4903f.E(this.f4899b, this.f4900c, this.f4901d, true, false);
                        return;
                    }
                }
                if (!this.f4902e) {
                    n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 8, this.a);
                    c.a.n0.a.u.d.k("SwanAppPaymentManager", "login error");
                    n.H(false, "nuomi", n.m("", "login error"));
                }
                this.f4903f.f4890f = 5;
                this.f4903f.f4891g = null;
                this.f4903f.M(null);
                n.J("nuomi", false, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f4904b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4905c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f4906d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f4907e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f4908f;

        public f(e eVar, String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4908f = eVar;
            this.a = str;
            this.f4904b = strArr;
            this.f4905c = jSONObject;
            this.f4906d = z;
            this.f4907e = z2;
        }

        @Override // c.a.n0.a.j1.e.k
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(this.f4908f.i)) {
                return;
            }
            CallbackHandler callbackHandler = this.f4908f.f4887c;
            String str2 = this.f4908f.i;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f4908f.a.x().getString(R.string.obfuscated_res_0x7f0f123d) + str).toString());
        }

        @Override // c.a.n0.a.j1.e.k
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f4908f.E(this.a, this.f4904b, this.f4905c, this.f4906d, this.f4907e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Function1<Boolean, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f4909b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4910c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f4911d;

        public g(e eVar, String str, String[] strArr, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, strArr, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4911d = eVar;
            this.a = str;
            this.f4909b = strArr;
            this.f4910c = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) {
                if (bool.booleanValue()) {
                    this.f4911d.F(this.a, this.f4909b, this.f4910c);
                    return null;
                }
                c.a.n0.a.u.d.k("SwanAppPaymentManager", "paykey invalid order info " + this.a);
                n.H(false, "nuomi", n.m("", "paykey invalid"));
                this.f4911d.N();
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.n0.a.j1.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4912b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f4913c;

        public h(e eVar, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4913c = eVar;
            this.a = jSONObject;
            this.f4912b = str;
        }

        @Override // c.a.n0.a.j1.g
        public void onPayResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.f4913c.L(i, str, this.a, this.f4912b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.a.c0.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4914b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f4915c;

        public i(e eVar, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4915c = eVar;
            this.a = jSONObject;
            this.f4914b = str;
        }

        @Override // c.a.c0.e.b
        public void onPayResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.f4915c.L(i, str, this.a, this.f4914b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements b.InterfaceC0323b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        public j(e eVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject;
        }

        @Override // c.a.n0.a.j1.b.InterfaceC0323b
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject == null) {
                    c.a.n0.a.u.d.i("SwanAppPaymentManager", "pay_check request success, but result is null.");
                    return;
                }
                try {
                    boolean z = jSONObject.getBoolean("channel_check");
                    n.I("nuomi", z ? "pay check success" : "pay check fail", this.a.optString("appKey"), z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0);
                } catch (JSONException e2) {
                    c.a.n0.a.u.d.i("SwanAppPaymentManager", "pay_check request success, but result error: " + jSONObject + "\n" + Log.getStackTraceString(e2));
                }
            }
        }

        @Override // c.a.n0.a.j1.b.InterfaceC0323b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                c.a.n0.a.u.d.i("SwanAppPaymentManager", "pay_check request fail: " + str);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface k {
        void onFail(String str);

        void onSuccess();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1213910953, "Lc/a/n0/a/j1/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1213910953, "Lc/a/n0/a/j1/e;");
                return;
            }
        }
        j = c.a.n0.a.a.a;
        k = new String[]{"duershow"};
    }

    public e(c.a.n0.a.t1.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, unitedSchemeEntity, callbackHandler, str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = eVar;
        this.f4886b = unitedSchemeEntity;
        this.f4887c = callbackHandler;
        this.f4888d = str;
        this.f4889e = str2;
        this.i = str3;
        this.f4892h = new PaymentManager();
    }

    public static boolean A(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            Object remove = jSONObject.remove("inlinePaySign");
            if (remove == null) {
                return true;
            }
            String str = remove + "";
            String A = PaymentPanelManager.z().A(str);
            String B = PaymentPanelManager.z().B(str);
            if (TextUtils.isEmpty(A)) {
                return false;
            }
            jSONObject.put("channelSource", "INNER_SDK");
            jSONObject.put(PolyActivity.PANEL_TYPE_KEY, "NONE");
            jSONObject.put(PolyActivity.CHOSEN_CHANNEL_KEY, A);
            if (!TextUtils.isEmpty(B)) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(new JSONObject(B));
                jSONObject.put("hostMarketingDetail", jSONArray.toString());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String J(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 != 0 ? i2 != 2 ? EventAlias.PayEventAlias.PAY_FAIL : "支付取消" : EventAlias.PayEventAlias.PAY_SUCCESS : (String) invokeI.objValue;
    }

    public static JSONObject w(c.a.n0.a.t1.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, eVar, jSONObject)) == null) {
            if (eVar.v0() && jSONObject != null) {
                b.a V = eVar.V();
                if (V.M() == null) {
                    return jSONObject;
                }
                JSONObject M = V.M();
                String optString = M.optString(TiebaStatic.Params.LOGID);
                String optString2 = M.optString("module_id");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    try {
                        jSONObject.put(TiebaStatic.Params.LOGID, optString);
                        jSONObject.put("module_id", optString2);
                    } catch (JSONException e2) {
                        if (j) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void y(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, jSONObject, str) == null) {
            PMSAppInfo u = c.a.n0.q.f.a.i().u(str);
            int i2 = u == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : u.payProtected;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("baoStatus", i2);
            jSONObject2.put("sappId", 10001);
            jSONObject2.put("objectId", str);
            jSONObject.put("baoInfo", jSONObject2.toString());
        }
    }

    public static void z(@NonNull c.a.n0.a.t1.e eVar, JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, null, eVar, jSONObject) == null) {
            if (SwanAppAllianceLoginHelper.f28743d.f()) {
                jSONObject.put("openBduss", c.a.n0.a.s0.a.h0().d(c.a.n0.a.s0.a.c()));
                jSONObject.put("clientId", c.a.n0.a.s0.a.n().b());
            } else {
                jSONObject.put("bduss", c.a.n0.a.s0.a.h0().d(c.a.n0.a.s0.a.c()));
            }
            jSONObject.put("cuid", c.a.n0.a.s0.a.h0().i(c.a.n0.a.s0.a.c()));
            String a2 = c.a.n0.a.s0.a.y().a();
            if (!TextUtils.isEmpty(a2)) {
                jSONObject.put("tpUid", a2);
            }
            String optString = jSONObject.optString("bizInfo");
            JSONObject jSONObject2 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
            jSONObject2.put("swanFrom", eVar.V().T());
            jSONObject2.put("cuid", c.a.n0.a.s0.a.h0().i(c.a.n0.a.s0.a.c()));
            jSONObject2.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, c.a.n0.a.t1.d.J().getAppId());
            w(eVar, jSONObject2);
            jSONObject.put("bizInfo", jSONObject2.toString());
            jSONObject.put("platformId", "100003");
            jSONObject.put("nativeAppId", c.a.n0.a.s0.a.n().a());
            jSONObject.put("sceneSource", "swan");
            jSONObject.put("swanNativeVersion", c.a.n0.a.b.a());
            y(jSONObject, eVar.N());
            if (j) {
                Log.i("SwanAppPaymentManager", jSONObject.toString());
            }
        }
    }

    public final boolean B(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (this.a.M().e(this.a.getActivity())) {
                D(str);
                return true;
            }
            c.a.n0.a.t1.e eVar = this.a;
            if (eVar == null) {
                return false;
            }
            boolean e2 = eVar.M().e(this.a.x());
            if (!e2) {
                n.S("show", 9, str2);
            }
            this.a.M().f(this.a.getActivity(), null, new b(this, e2, str2, str));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean C(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str2) && (str.equals("mapp_request_duxiaoman") || str.equals("mapp_request_alipayment"))) {
                this.f4886b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.n0.a.u.d.k("SwanAppPaymentManager", "Error: order info is null.");
                return false;
            }
            this.a.d0().g(this.a.x(), str, new a(this, str, str2, str3));
            UnitedSchemeUtility.callCallback(this.f4887c, this.f4886b, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            n.K("baiduqianbao", "intoPayment", 0);
            this.f4892h.e(this.a.getActivity(), str, new c(this));
        }
    }

    public final void E(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            G(str, strArr, jSONObject);
            n.J("nuomi", z, z2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0147 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x005b A[SYNTHETIC] */
    @SuppressLint({"BDThrowableCheck"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void F(String str, String[] strArr, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONException e2;
        int length;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, strArr, jSONObject) == null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject2 = new JSONObject(str);
                try {
                    z(this.a, jSONObject2);
                    if (!A(jSONObject2)) {
                        this.f4887c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParams(202).toString());
                        return;
                    }
                } catch (JSONException e3) {
                    e2 = e3;
                    if (c.a.n0.a.a.a) {
                        e2.printStackTrace();
                    }
                    c.a.n0.a.w0.f.U().p();
                    String[] strArr2 = k;
                    length = strArr2.length;
                    i2 = 0;
                    while (true) {
                        if (i2 < length) {
                        }
                        i2++;
                    }
                    n.K("nuomi", "intoPayment", 0);
                    if (!z) {
                    }
                    UnitedSchemeUtility.callCallback(this.f4887c, this.f4886b, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.a.z() == null) {
                    }
                }
            } catch (JSONException e4) {
                jSONObject2 = jSONObject3;
                e2 = e4;
            }
            c.a.n0.a.w0.f.U().p();
            String[] strArr22 = k;
            length = strArr22.length;
            i2 = 0;
            while (true) {
                if (i2 < length) {
                    z = false;
                    break;
                } else if (strArr22[i2].equals(c.a.n0.a.s0.a.n().a())) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            n.K("nuomi", "intoPayment", 0);
            if (!z) {
                String a2 = c.a.n0.w.i.a(c.a.n0.w.i.a("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject2.toString())), "deviceType", "ANDROID");
                l.b3("qrCodePay", c.a.n0.a.c1.b.d(a2, a2));
                c.a.n0.a.j1.h.b(new h(this, jSONObject, str));
                c.a.n0.a.u.d.k("SwanAppPaymentManager", "doPolymerPay Qr Code: " + jSONObject2.toString());
            } else {
                this.f4892h.j(this.a.x(), jSONObject2, strArr, new i(this, jSONObject, str));
                c.a.n0.a.u.d.k("SwanAppPaymentManager", "doPolymerPay: " + jSONObject2.toString());
            }
            UnitedSchemeUtility.callCallback(this.f4887c, this.f4886b, UnitedSchemeUtility.wrapCallbackParams(0));
            if (this.a.z() == null) {
                String valueOf = String.valueOf(this.a.V().G());
                String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.a.V().W()).get("_baiduboxapp"));
                Bundle bundle = new Bundle();
                bundle.putString("frameType", valueOf);
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.a.V().H());
                try {
                    bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
                } catch (UnsupportedEncodingException e5) {
                    if (j) {
                        throw new RuntimeException("This method requires UTF-8 encoding support", e5);
                    }
                }
                this.a.z().Y(7, bundle);
            }
        }
    }

    public final void G(String str, String[] strArr, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, strArr, jSONObject) == null) {
            try {
                String optString = new JSONObject(str).optString("appKey");
                if (!this.a.v0()) {
                    F(str, strArr, jSONObject);
                } else {
                    c.a.n0.a.f1.r.c.d.b(optString, new g(this, str, strArr, jSONObject));
                }
            } catch (JSONException e2) {
                N();
                c.a.n0.a.u.d.k("SwanAppPaymentManager", " doPolymerPayChecked error " + str);
                if (c.a.n0.a.a.a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void H(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            c.a.n0.a.s0.b.e().a(str, new f(this, str, strArr, jSONObject, z, z2));
        }
    }

    public final String I(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, jSONObject)) == null) {
            String optString = jSONObject.optString("tpOrderId");
            try {
                return new JSONObject(str).put("orderId", optString).toString();
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                }
                return str + " orderId = " + optString;
            }
        }
        return (String) invokeLL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public boolean K(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        String[] strArr;
        Object opt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, jSONObject)) == null) {
            String optString = jSONObject.optString("invokeFrom");
            if (TextUtils.isEmpty(optString)) {
                optString = RetrieveTaskManager.KEY;
            }
            String str2 = optString;
            boolean e2 = this.a.M().e(this.a.x());
            if (!e2) {
                n.S("show", 8, str2);
            }
            if (TextUtils.isEmpty(str)) {
                this.f4886b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString2 = jSONObject.optString("__plugin__");
            c.a.n0.a.m1.e.a.b("start payment");
            if (!TextUtils.isEmpty(optString2) && (opt = jSONObject.opt("error")) != null) {
                String optString3 = jSONObject.optString("slaveId");
                c.a.n0.a.m1.d.c.a aVar = new c.a.n0.a.m1.d.c.a(jSONObject.optString("componentId"));
                aVar.a = optString3;
                aVar.f5455c = opt;
                aVar.f5456d = false;
                aVar.f5457e = null;
                aVar.b();
                c.a.n0.a.u.d.k("SwanAppPaymentManager", "Error: param check error - plugin pay contains custom error");
                n.H(false, "nuomi", n.m("", "param check error - plugin pay contains custom error"));
                this.f4886b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("bannedChannels");
            if (optJSONArray != null) {
                String[] strArr2 = new String[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    strArr2[i2] = String.valueOf(optJSONArray.opt(i2));
                }
                strArr = strArr2;
            } else {
                strArr = null;
            }
            n.K("nuomi", "login", 0);
            if (this.a.x() == null) {
                this.f4890f = 5;
                this.f4891g = null;
                M(null);
                if (j) {
                    throw new RuntimeException("swanApp getActivity returns null");
                }
                return true;
            } else if (this.a.M().e(this.a.getActivity())) {
                if (this.a.v0()) {
                    H(str, strArr, jSONObject, true, true);
                    return true;
                }
                E(str, strArr, jSONObject, true, true);
                return true;
            } else {
                this.a.M().f(this.a.getActivity(), null, new C0324e(this, str2, str, strArr, jSONObject, e2));
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void L(int i2, String str, JSONObject jSONObject, String str2) {
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), str, jSONObject, str2}) == null) {
            try {
                jSONObject2 = new JSONObject(str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
                jSONObject2 = new JSONObject();
            }
            c.a.n0.a.w0.f.U().c();
            c.a.n0.a.u.d.i("SwanAppPaymentManager", "sendSecondCallback statusCode: " + this.f4890f + " params: " + this.f4891g + " payParams: " + jSONObject.toString() + " orderId: " + jSONObject2.optString("tpOrderId"));
            O(i2, "nuomi", I(str, jSONObject2));
            this.f4890f = i2;
            this.f4891g = str;
            if (i2 != 1) {
                n.K("nuomi", "result", i2);
            }
            M(null);
            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
                String optString = jSONObject.optString("slaveId");
                String optString2 = jSONObject.optString("componentId");
                Object opt = jSONObject.opt("error");
                c.a.n0.a.m1.d.c.a aVar = new c.a.n0.a.m1.d.c.a(optString2);
                aVar.a = optString;
                aVar.f5455c = opt;
                aVar.f5456d = i2 == 0;
                aVar.f5457e = str;
                aVar.b();
                c.a.n0.a.m1.h.b.j();
            }
            if (this.f4890f == 0 && !c.a.n0.a.q1.c.f5996c.c()) {
                c.a.n0.a.q1.c.f5996c.e();
            }
            if (i2 == 0) {
                c.a.n0.a.j1.b bVar = new c.a.n0.a.j1.b();
                bVar.h(jSONObject2);
                bVar.d(new j(this, jSONObject2));
            }
        }
    }

    public final void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            try {
                if (TextUtils.equals(this.f4888d, "2.0")) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("payId", str);
                    if (!TextUtils.isEmpty(this.f4891g)) {
                        jSONObject.put("payResult", Base64.encodeToString(this.f4891g.getBytes("UTF-8"), 2));
                    }
                    c.a.n0.a.u.d.i("SwanAppPaymentManager", "Success: sendSecondCallback, data = " + jSONObject + " status code = " + this.f4890f);
                    this.f4887c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.f4890f, J(this.f4890f)).toString());
                    return;
                }
                c.a.n0.a.u.d.i("SwanAppPaymentManager", "Success: sendSecondCallback, result = " + this.f4891g + " status code = " + this.f4890f);
                this.f4887c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.f4891g, this.f4890f, J(this.f4890f)).toString());
            } catch (UnsupportedEncodingException | JSONException e2) {
                c.a.n0.a.u.d.i("SwanAppPaymentManager", "Fail: sendSecondCallback exception , exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace()));
                CallbackHandler callbackHandler = this.f4887c;
                String str2 = this.i;
                int i2 = this.f4890f;
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i2, J(i2)).toString());
            }
        }
    }

    public final void N() {
        c.a.n0.a.t1.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (eVar = this.a) == null) {
            return;
        }
        c.a.n0.a.s1.b.f.e.f(eVar.x(), R.string.obfuscated_res_0x7f0f12aa).G();
        if (TextUtils.isEmpty(this.i)) {
            return;
        }
        this.f4887c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.a.x().getString(R.string.obfuscated_res_0x7f0f12aa)).toString());
    }

    public final void O(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048588, this, i2, str, str2) == null) {
            n.H(i2 == 0, str, str2);
        }
    }

    public final boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            c.a.n0.a.u.d.i("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
            if (c.a.n0.a.j1.k.a(this.a, this.f4887c, this.f4886b)) {
                this.f4890f = 0;
                this.f4891g = null;
                if (TextUtils.equals(this.f4888d, "2.0")) {
                    c.a.n0.a.s0.a.W().e(this.f4889e, this);
                } else {
                    M(null);
                }
                n.G("wechatH5Action", null, null);
                return true;
            }
            c.a.n0.a.u.d.k("SwanAppPaymentManager", "Error: open webview error.  entity = " + this.f4886b.toString());
            this.f4887c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.q1.a
    public void a(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jSONObject) == null) {
            c.a.n0.a.u.d.c("SwanAppPaymentManager", "Info: getPayId Request Response =  " + jSONObject.toString());
            if (jSONObject.optInt("errno") == 0) {
                str = jSONObject.optJSONObject("data").optString("payid");
                c.a.n0.a.u.d.c("SwanAppPaymentManager", "Info: payId =  " + str);
            } else {
                str = null;
            }
            M(str);
            if (c.a.n0.a.q1.c.f5996c.c()) {
                return;
            }
            if (c.a.n0.a.s0.a.h0().e(this.a)) {
                c.a.n0.a.q1.c.f5996c.e();
            } else {
                c.a.n0.a.q1.c.f5996c.f();
            }
        }
    }

    @Override // c.a.n0.a.q1.a
    public void onFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            c.a.n0.a.u.d.c("SwanAppPaymentManager", "Fail: request payId failed");
            c.a.n0.a.u.d.c("SwanAppPaymentManager", str);
            M(null);
        }
    }

    public final boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (j) {
                Log.d("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT orderInfo: " + str);
            }
            n.K("alipay", "intoPayment", 0);
            this.f4892h.d(this.a.getActivity(), str, new d(this));
            return true;
        }
        return invokeL.booleanValue;
    }
}
