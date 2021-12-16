package c.a.q0.a.t1;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.f1.e.b;
import c.a.q0.a.h2.c.j.b;
import c.a.q0.a.l;
import c.a.q0.a.n2.n;
import c.a.q0.a.t1.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.android.lbspay.presenter.LBSTransAuthPresenter;
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
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements c.a.q0.a.t1.l.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f8286j;

    /* renamed from: k  reason: collision with root package name */
    public static String[] f8287k;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.q0.a.d2.e a;

    /* renamed from: b  reason: collision with root package name */
    public UnitedSchemeEntity f8288b;

    /* renamed from: c  reason: collision with root package name */
    public CallbackHandler f8289c;

    /* renamed from: d  reason: collision with root package name */
    public String f8290d;

    /* renamed from: e  reason: collision with root package name */
    public String f8291e;

    /* renamed from: f  reason: collision with root package name */
    public int f8292f;

    /* renamed from: g  reason: collision with root package name */
    public String f8293g;

    /* renamed from: h  reason: collision with root package name */
    public PaymentManager f8294h;

    /* renamed from: i  reason: collision with root package name */
    public String f8295i;

    /* loaded from: classes.dex */
    public class a implements c.a.q0.a.z2.g1.c<c.a.q0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8296e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8297f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8298g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f8299h;

        public a(e eVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8299h = eVar;
            this.f8296e = str;
            this.f8297f = str2;
            this.f8298g = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
            if (r10.equals("mapp_request_duxiaoman") != false) goto L37;
         */
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCallback(c.a.q0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                char c2 = 0;
                if (!c.a.q0.a.h2.c.d.h(iVar)) {
                    String str = null;
                    if (TextUtils.equals(this.f8299h.f8290d, "2.0")) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("payId", "");
                        } catch (JSONException e2) {
                            if (e.f8286j) {
                                e2.printStackTrace();
                            }
                        }
                        str = String.valueOf(jSONObject);
                    }
                    if (TextUtils.equals(this.f8296e, "mapp_request_duxiaoman")) {
                        n.H(false, "baiduqianbao", n.m("", "authorize fail"));
                    } else if (TextUtils.equals(this.f8296e, "mapp_request_alipayment")) {
                        n.H(false, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, n.m("", "authorize fail"));
                    } else if (TextUtils.equals(this.f8296e, "mapp_request_wechatpayment")) {
                        n.H(false, "wechatH5Action", n.m("", "authorize fail"));
                    }
                    c.a.q0.a.e0.d.k("SwanAppPaymentManager", "Error: authorized fail. scope = " + this.f8296e);
                    this.f8299h.f8289c.handleSchemeDispatchCallback(this.f8299h.f8295i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str, 1001, "authorize denied").toString());
                    return;
                }
                String str2 = this.f8296e;
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
                    this.f8299h.B(this.f8297f, this.f8298g);
                } else if (c2 == 1) {
                    this.f8299h.x(this.f8297f);
                } else if (c2 != 2) {
                } else {
                    this.f8299h.P();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.q0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f8300e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8301f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8302g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f8303h;

        public b(e eVar, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8303h = eVar;
            this.f8300e = z;
            this.f8301f = str;
            this.f8302g = str2;
        }

        @Override // c.a.q0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    if (!this.f8300e) {
                        n.S("success", 9, this.f8301f);
                    }
                    this.f8303h.D(this.f8302g);
                    return;
                }
                if (!this.f8300e) {
                    n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 9, this.f8301f);
                }
                this.f8303h.f8292f = 5;
                this.f8303h.f8293g = null;
                this.f8303h.M(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.f0.f.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.f0.f.b
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.a.f8292f = i2;
                this.a.f8293g = str;
                if (e.f8286j) {
                    String str2 = "statusCode: " + i2 + " ,result:" + str;
                }
                this.a.O(i2, "baiduqianbao", str);
                n.K("baiduqianbao", "result", i2);
                if (i2 != 0 || !TextUtils.equals(this.a.f8290d, "2.0")) {
                    this.a.M(null);
                } else {
                    c.a.q0.a.c1.a.W().e(this.a.f8291e, this.a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.f0.f.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.f0.f.b
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.a.f8292f = i2;
                this.a.f8293g = str;
                c.a.q0.a.e0.d.k("SwanAppPaymentManager", "statusCode: " + this.a.f8292f + " ,result:" + this.a.f8293g);
                this.a.O(i2, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, str);
                if (i2 != 1) {
                    n.K(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "result", i2);
                }
                if (i2 != 0 || !TextUtils.equals(this.a.f8290d, "2.0")) {
                    this.a.M(null);
                } else {
                    c.a.q0.a.c1.a.W().e(this.a.f8291e, this.a);
                }
            }
        }
    }

    /* renamed from: c.a.q0.a.t1.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0500e implements c.a.q0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8304e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8305f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String[] f8306g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8307h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f8308i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f8309j;

        public C0500e(e eVar, String str, String str2, String[] strArr, JSONObject jSONObject, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, strArr, jSONObject, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8309j = eVar;
            this.f8304e = str;
            this.f8305f = str2;
            this.f8306g = strArr;
            this.f8307h = jSONObject;
            this.f8308i = z;
        }

        @Override // c.a.q0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    n.S("success", 8, this.f8304e);
                    if (this.f8309j.a.v0()) {
                        this.f8309j.H(this.f8305f, this.f8306g, this.f8307h, true, false);
                        return;
                    } else {
                        this.f8309j.E(this.f8305f, this.f8306g, this.f8307h, true, false);
                        return;
                    }
                }
                if (!this.f8308i) {
                    n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 8, this.f8304e);
                    c.a.q0.a.e0.d.k("SwanAppPaymentManager", "login error");
                    n.H(false, "nuomi", n.m("", "login error"));
                }
                this.f8309j.f8292f = 5;
                this.f8309j.f8293g = null;
                this.f8309j.M(null);
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
        public final /* synthetic */ String[] f8310b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8311c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f8312d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f8313e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f8314f;

        public f(e eVar, String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8314f = eVar;
            this.a = str;
            this.f8310b = strArr;
            this.f8311c = jSONObject;
            this.f8312d = z;
            this.f8313e = z2;
        }

        @Override // c.a.q0.a.t1.e.k
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(this.f8314f.f8295i)) {
                return;
            }
            CallbackHandler callbackHandler = this.f8314f.f8289c;
            String str2 = this.f8314f.f8295i;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f8314f.a.x().getString(c.a.q0.a.h.swan_game_anti_addiction) + str).toString());
        }

        @Override // c.a.q0.a.t1.e.k
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f8314f.E(this.a, this.f8310b, this.f8311c, this.f8312d, this.f8313e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Function1<Boolean, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8315e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f8316f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8317g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f8318h;

        public g(e eVar, String str, String[] strArr, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, strArr, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8318h = eVar;
            this.f8315e = str;
            this.f8316f = strArr;
            this.f8317g = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) {
                if (bool.booleanValue()) {
                    this.f8318h.F(this.f8315e, this.f8316f, this.f8317g);
                    return null;
                }
                c.a.q0.a.e0.d.k("SwanAppPaymentManager", "paykey invalid order info " + this.f8315e);
                n.H(false, "nuomi", n.m("", "paykey invalid"));
                this.f8318h.N();
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.q0.a.t1.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8319b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f8320c;

        public h(e eVar, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8320c = eVar;
            this.a = jSONObject;
            this.f8319b = str;
        }

        @Override // c.a.q0.a.t1.g
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f8320c.L(i2, str, this.a, this.f8319b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.a.f0.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8321b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f8322c;

        public i(e eVar, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8322c = eVar;
            this.a = jSONObject;
            this.f8321b = str;
        }

        @Override // c.a.f0.f.b
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f8322c.L(i2, str, this.a, this.f8321b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements b.InterfaceC0499b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject;
        }

        @Override // c.a.q0.a.t1.b.InterfaceC0499b
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject == null) {
                    c.a.q0.a.e0.d.i("SwanAppPaymentManager", "pay_check request success, but result is null.");
                    return;
                }
                try {
                    boolean z = jSONObject.getBoolean("channel_check");
                    n.I("nuomi", z ? "pay check success" : "pay check fail", this.a.optString("appKey"), z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0);
                } catch (JSONException e2) {
                    c.a.q0.a.e0.d.i("SwanAppPaymentManager", "pay_check request success, but result error: " + jSONObject + StringUtils.LF + Log.getStackTraceString(e2));
                }
            }
        }

        @Override // c.a.q0.a.t1.b.InterfaceC0499b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                c.a.q0.a.e0.d.i("SwanAppPaymentManager", "pay_check request fail: " + str);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(633605648, "Lc/a/q0/a/t1/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(633605648, "Lc/a/q0/a/t1/e;");
                return;
            }
        }
        f8286j = c.a.q0.a.k.a;
        f8287k = new String[]{"duershow"};
    }

    public e(c.a.q0.a.d2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
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
        this.f8288b = unitedSchemeEntity;
        this.f8289c = callbackHandler;
        this.f8290d = str;
        this.f8291e = str2;
        this.f8295i = str3;
        this.f8294h = new PaymentManager();
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
            jSONObject.put(PolyActivity.PANEL_TYPE_KEY, PolyActivity.NONE_PANEL_TYPE);
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

    public static JSONObject w(c.a.q0.a.d2.e eVar, JSONObject jSONObject) {
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
                        if (f8286j) {
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
            PMSAppInfo u = c.a.q0.q.g.a.i().u(str);
            int i2 = u == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : u.payProtected;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("baoStatus", i2);
            jSONObject2.put("sappId", 10001);
            jSONObject2.put("objectId", str);
            jSONObject.put("baoInfo", jSONObject2.toString());
        }
    }

    public static void z(@NonNull c.a.q0.a.d2.e eVar, JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, null, eVar, jSONObject) == null) {
            if (SwanAppAllianceLoginHelper.f39800d.f()) {
                jSONObject.put("openBduss", c.a.q0.a.c1.a.h0().d(c.a.q0.a.c1.a.c()));
                jSONObject.put("clientId", c.a.q0.a.c1.a.n().b());
            } else {
                jSONObject.put("bduss", c.a.q0.a.c1.a.h0().d(c.a.q0.a.c1.a.c()));
            }
            jSONObject.put("cuid", c.a.q0.a.c1.a.h0().i(c.a.q0.a.c1.a.c()));
            String a2 = c.a.q0.a.c1.a.y().a();
            if (!TextUtils.isEmpty(a2)) {
                jSONObject.put("tpUid", a2);
            }
            String optString = jSONObject.optString("bizInfo");
            JSONObject jSONObject2 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
            jSONObject2.put("swanFrom", eVar.V().T());
            jSONObject2.put("cuid", c.a.q0.a.c1.a.h0().i(c.a.q0.a.c1.a.c()));
            jSONObject2.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, c.a.q0.a.d2.d.J().getAppId());
            w(eVar, jSONObject2);
            jSONObject.put("bizInfo", jSONObject2.toString());
            jSONObject.put("platformId", "100003");
            jSONObject.put("nativeAppId", c.a.q0.a.c1.a.n().a());
            jSONObject.put("sceneSource", "swan");
            jSONObject.put("swanNativeVersion", l.a());
            y(jSONObject, eVar.N());
            if (f8286j) {
                jSONObject.toString();
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
            c.a.q0.a.d2.e eVar = this.a;
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
                this.f8288b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.q0.a.e0.d.k("SwanAppPaymentManager", "Error: order info is null.");
                return false;
            }
            this.a.d0().g(this.a.x(), str, new a(this, str, str2, str3));
            UnitedSchemeUtility.callCallback(this.f8289c, this.f8288b, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            n.K("baiduqianbao", "intoPayment", 0);
            this.f8294h.e(this.a.getActivity(), str, new c(this));
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
                        this.f8289c.handleSchemeDispatchCallback(this.f8295i, UnitedSchemeUtility.wrapCallbackParams(202).toString());
                        return;
                    }
                } catch (JSONException e3) {
                    e2 = e3;
                    if (c.a.q0.a.k.a) {
                        e2.printStackTrace();
                    }
                    c.a.q0.a.g1.f.U().p();
                    String[] strArr2 = f8287k;
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
                    UnitedSchemeUtility.callCallback(this.f8289c, this.f8288b, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.a.z() == null) {
                    }
                }
            } catch (JSONException e4) {
                jSONObject2 = jSONObject3;
                e2 = e4;
            }
            c.a.q0.a.g1.f.U().p();
            String[] strArr22 = f8287k;
            length = strArr22.length;
            i2 = 0;
            while (true) {
                if (i2 < length) {
                    z = false;
                    break;
                } else if (strArr22[i2].equals(c.a.q0.a.c1.a.n().a())) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            n.K("nuomi", "intoPayment", 0);
            if (!z) {
                String a2 = c.a.q0.w.i.a(c.a.q0.w.i.a("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject2.toString())), "deviceType", "ANDROID");
                c.a.q0.a.h0.g.l.e3("qrCodePay", c.a.q0.a.m1.b.e(a2, a2));
                c.a.q0.a.t1.h.b(new h(this, jSONObject, str));
                c.a.q0.a.e0.d.k("SwanAppPaymentManager", "doPolymerPay Qr Code: " + jSONObject2.toString());
            } else {
                this.f8294h.j(this.a.x(), jSONObject2, strArr, new i(this, jSONObject, str));
                c.a.q0.a.e0.d.k("SwanAppPaymentManager", "doPolymerPay: " + jSONObject2.toString());
            }
            UnitedSchemeUtility.callCallback(this.f8289c, this.f8288b, UnitedSchemeUtility.wrapCallbackParams(0));
            if (this.a.z() == null) {
                String valueOf = String.valueOf(this.a.V().G());
                String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.a.V().W()).get("_baiduboxapp"));
                Bundle bundle = new Bundle();
                bundle.putString("frameType", valueOf);
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.a.V().H());
                try {
                    bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
                } catch (UnsupportedEncodingException e5) {
                    if (f8286j) {
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
                    c.a.q0.a.p1.r.c.d.b(optString, new g(this, str, strArr, jSONObject));
                }
            } catch (JSONException e2) {
                N();
                c.a.q0.a.e0.d.k("SwanAppPaymentManager", " doPolymerPayChecked error " + str);
                if (c.a.q0.a.k.a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void H(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            c.a.q0.a.c1.b.e().a(str, new f(this, str, strArr, jSONObject, z, z2));
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
                if (f8286j) {
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
                this.f8288b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString2 = jSONObject.optString("__plugin__");
            c.a.q0.a.w1.e.a.b("start payment");
            if (!TextUtils.isEmpty(optString2) && (opt = jSONObject.opt("error")) != null) {
                String optString3 = jSONObject.optString("slaveId");
                c.a.q0.a.w1.d.c.a aVar = new c.a.q0.a.w1.d.c.a(jSONObject.optString("componentId"));
                aVar.a = optString3;
                aVar.f8999c = opt;
                aVar.f9000d = false;
                aVar.f9001e = null;
                aVar.b();
                c.a.q0.a.e0.d.k("SwanAppPaymentManager", "Error: param check error - plugin pay contains custom error");
                n.H(false, "nuomi", n.m("", "param check error - plugin pay contains custom error"));
                this.f8288b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
                this.f8292f = 5;
                this.f8293g = null;
                M(null);
                if (f8286j) {
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
                this.a.M().f(this.a.getActivity(), null, new C0500e(this, str2, str, strArr, jSONObject, e2));
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
            c.a.q0.a.g1.f.U().c();
            c.a.q0.a.e0.d.i("SwanAppPaymentManager", "sendSecondCallback statusCode: " + this.f8292f + " params: " + this.f8293g + " payParams: " + jSONObject.toString() + " orderId: " + jSONObject2.optString("tpOrderId"));
            O(i2, "nuomi", I(str, jSONObject2));
            this.f8292f = i2;
            this.f8293g = str;
            if (i2 != 1) {
                n.K("nuomi", "result", i2);
            }
            M(null);
            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
                String optString = jSONObject.optString("slaveId");
                String optString2 = jSONObject.optString("componentId");
                Object opt = jSONObject.opt("error");
                c.a.q0.a.w1.d.c.a aVar = new c.a.q0.a.w1.d.c.a(optString2);
                aVar.a = optString;
                aVar.f8999c = opt;
                aVar.f9000d = i2 == 0;
                aVar.f9001e = str;
                aVar.b();
                c.a.q0.a.w1.h.b.j();
            }
            if (this.f8292f == 0 && !c.a.q0.a.a2.c.f4555c.c()) {
                c.a.q0.a.a2.c.f4555c.e();
            }
            if (i2 == 0) {
                c.a.q0.a.t1.b bVar = new c.a.q0.a.t1.b();
                bVar.h(jSONObject2);
                bVar.d(new j(this, jSONObject2));
            }
        }
    }

    public final void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            try {
                if (TextUtils.equals(this.f8290d, "2.0")) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("payId", str);
                    if (!TextUtils.isEmpty(this.f8293g)) {
                        jSONObject.put("payResult", Base64.encodeToString(this.f8293g.getBytes("UTF-8"), 2));
                    }
                    c.a.q0.a.e0.d.i("SwanAppPaymentManager", "Success: sendSecondCallback, data = " + jSONObject + " status code = " + this.f8292f);
                    this.f8289c.handleSchemeDispatchCallback(this.f8295i, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.f8292f, J(this.f8292f)).toString());
                    return;
                }
                c.a.q0.a.e0.d.i("SwanAppPaymentManager", "Success: sendSecondCallback, result = " + this.f8293g + " status code = " + this.f8292f);
                this.f8289c.handleSchemeDispatchCallback(this.f8295i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.f8293g, this.f8292f, J(this.f8292f)).toString());
            } catch (UnsupportedEncodingException | JSONException e2) {
                c.a.q0.a.e0.d.i("SwanAppPaymentManager", "Fail: sendSecondCallback exception , exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace()));
                CallbackHandler callbackHandler = this.f8289c;
                String str2 = this.f8295i;
                int i2 = this.f8292f;
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i2, J(i2)).toString());
            }
        }
    }

    public final void N() {
        c.a.q0.a.d2.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (eVar = this.a) == null) {
            return;
        }
        c.a.q0.a.c2.b.f.e.f(eVar.x(), c.a.q0.a.h.swanapp_payment_illegal).G();
        if (TextUtils.isEmpty(this.f8295i)) {
            return;
        }
        this.f8289c.handleSchemeDispatchCallback(this.f8295i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.a.x().getString(c.a.q0.a.h.swanapp_payment_illegal)).toString());
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
            c.a.q0.a.e0.d.i("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
            if (c.a.q0.a.t1.k.a(this.a, this.f8289c, this.f8288b)) {
                this.f8292f = 0;
                this.f8293g = null;
                if (TextUtils.equals(this.f8290d, "2.0")) {
                    c.a.q0.a.c1.a.W().e(this.f8291e, this);
                } else {
                    M(null);
                }
                n.G("wechatH5Action", null, null);
                return true;
            }
            c.a.q0.a.e0.d.k("SwanAppPaymentManager", "Error: open webview error.  entity = " + this.f8288b.toString());
            this.f8289c.handleSchemeDispatchCallback(this.f8295i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.a.a2.a
    public void a(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jSONObject) == null) {
            c.a.q0.a.e0.d.c("SwanAppPaymentManager", "Info: getPayId Request Response =  " + jSONObject.toString());
            if (jSONObject.optInt("errno") == 0) {
                str = jSONObject.optJSONObject("data").optString("payid");
                c.a.q0.a.e0.d.c("SwanAppPaymentManager", "Info: payId =  " + str);
            } else {
                str = null;
            }
            M(str);
            if (c.a.q0.a.a2.c.f4555c.c()) {
                return;
            }
            if (c.a.q0.a.c1.a.h0().e(this.a)) {
                c.a.q0.a.a2.c.f4555c.e();
            } else {
                c.a.q0.a.a2.c.f4555c.f();
            }
        }
    }

    @Override // c.a.q0.a.a2.a
    public void onFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            c.a.q0.a.e0.d.c("SwanAppPaymentManager", "Fail: request payId failed");
            c.a.q0.a.e0.d.c("SwanAppPaymentManager", str);
            M(null);
        }
    }

    public final boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (f8286j) {
                String str2 = "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT orderInfo: " + str;
            }
            n.K(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "intoPayment", 0);
            this.f8294h.d(this.a.getActivity(), str, new d(this));
            return true;
        }
        return invokeL.booleanValue;
    }
}
