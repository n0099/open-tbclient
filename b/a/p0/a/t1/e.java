package b.a.p0.a.t1;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.h2.c.j.b;
import b.a.p0.a.l;
import b.a.p0.a.n2.n;
import b.a.p0.a.t1.b;
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
public class e implements b.a.p0.a.t1.l.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public static String[] k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.a.d2.e f8399a;

    /* renamed from: b  reason: collision with root package name */
    public UnitedSchemeEntity f8400b;

    /* renamed from: c  reason: collision with root package name */
    public CallbackHandler f8401c;

    /* renamed from: d  reason: collision with root package name */
    public String f8402d;

    /* renamed from: e  reason: collision with root package name */
    public String f8403e;

    /* renamed from: f  reason: collision with root package name */
    public int f8404f;

    /* renamed from: g  reason: collision with root package name */
    public String f8405g;

    /* renamed from: h  reason: collision with root package name */
    public PaymentManager f8406h;

    /* renamed from: i  reason: collision with root package name */
    public String f8407i;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.z2.g1.c<b.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8408e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8409f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8410g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f8411h;

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
            this.f8411h = eVar;
            this.f8408e = str;
            this.f8409f = str2;
            this.f8410g = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
            if (r10.equals("mapp_request_duxiaoman") != false) goto L37;
         */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCallback(b.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                char c2 = 0;
                if (!b.a.p0.a.h2.c.d.h(iVar)) {
                    String str = null;
                    if (TextUtils.equals(this.f8411h.f8402d, "2.0")) {
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
                    if (TextUtils.equals(this.f8408e, "mapp_request_duxiaoman")) {
                        n.H(false, "baiduqianbao", n.m("", "authorize fail"));
                    } else if (TextUtils.equals(this.f8408e, "mapp_request_alipayment")) {
                        n.H(false, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, n.m("", "authorize fail"));
                    } else if (TextUtils.equals(this.f8408e, "mapp_request_wechatpayment")) {
                        n.H(false, "wechatH5Action", n.m("", "authorize fail"));
                    }
                    b.a.p0.a.e0.d.k("SwanAppPaymentManager", "Error: authorized fail. scope = " + this.f8408e);
                    this.f8411h.f8401c.handleSchemeDispatchCallback(this.f8411h.f8407i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str, 1001, "authorize denied").toString());
                    return;
                }
                String str2 = this.f8408e;
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
                    this.f8411h.B(this.f8409f, this.f8410g);
                } else if (c2 == 1) {
                    this.f8411h.x(this.f8409f);
                } else if (c2 != 2) {
                } else {
                    this.f8411h.P();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f8412e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8413f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8414g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f8415h;

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
            this.f8415h = eVar;
            this.f8412e = z;
            this.f8413f = str;
            this.f8414g = str2;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    if (!this.f8412e) {
                        n.S("success", 9, this.f8413f);
                    }
                    this.f8415h.D(this.f8414g);
                    return;
                }
                if (!this.f8412e) {
                    n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 9, this.f8413f);
                }
                this.f8415h.f8404f = 5;
                this.f8415h.f8405g = null;
                this.f8415h.M(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.d0.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f8416a;

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
            this.f8416a = eVar;
        }

        @Override // b.a.d0.f.b
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f8416a.f8404f = i2;
                this.f8416a.f8405g = str;
                if (e.j) {
                    String str2 = "statusCode: " + i2 + " ,result:" + str;
                }
                this.f8416a.O(i2, "baiduqianbao", str);
                n.K("baiduqianbao", "result", i2);
                if (i2 != 0 || !TextUtils.equals(this.f8416a.f8402d, "2.0")) {
                    this.f8416a.M(null);
                } else {
                    b.a.p0.a.c1.a.W().e(this.f8416a.f8403e, this.f8416a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements b.a.d0.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f8417a;

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
            this.f8417a = eVar;
        }

        @Override // b.a.d0.f.b
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f8417a.f8404f = i2;
                this.f8417a.f8405g = str;
                b.a.p0.a.e0.d.k("SwanAppPaymentManager", "statusCode: " + this.f8417a.f8404f + " ,result:" + this.f8417a.f8405g);
                this.f8417a.O(i2, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, str);
                if (i2 != 1) {
                    n.K(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "result", i2);
                }
                if (i2 != 0 || !TextUtils.equals(this.f8417a.f8402d, "2.0")) {
                    this.f8417a.M(null);
                } else {
                    b.a.p0.a.c1.a.W().e(this.f8417a.f8403e, this.f8417a);
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.t1.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0410e implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8418e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8419f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String[] f8420g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8421h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f8422i;
        public final /* synthetic */ e j;

        public C0410e(e eVar, String str, String str2, String[] strArr, JSONObject jSONObject, boolean z) {
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
            this.j = eVar;
            this.f8418e = str;
            this.f8419f = str2;
            this.f8420g = strArr;
            this.f8421h = jSONObject;
            this.f8422i = z;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    n.S("success", 8, this.f8418e);
                    if (this.j.f8399a.v0()) {
                        this.j.H(this.f8419f, this.f8420g, this.f8421h, true, false);
                        return;
                    } else {
                        this.j.E(this.f8419f, this.f8420g, this.f8421h, true, false);
                        return;
                    }
                }
                if (!this.f8422i) {
                    n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 8, this.f8418e);
                    b.a.p0.a.e0.d.k("SwanAppPaymentManager", "login error");
                    n.H(false, "nuomi", n.m("", "login error"));
                }
                this.j.f8404f = 5;
                this.j.f8405g = null;
                this.j.M(null);
                n.J("nuomi", false, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8423a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f8424b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8425c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f8426d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f8427e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f8428f;

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
            this.f8428f = eVar;
            this.f8423a = str;
            this.f8424b = strArr;
            this.f8425c = jSONObject;
            this.f8426d = z;
            this.f8427e = z2;
        }

        @Override // b.a.p0.a.t1.e.k
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(this.f8428f.f8407i)) {
                return;
            }
            CallbackHandler callbackHandler = this.f8428f.f8401c;
            String str2 = this.f8428f.f8407i;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f8428f.f8399a.x().getString(b.a.p0.a.h.swan_game_anti_addiction) + str).toString());
        }

        @Override // b.a.p0.a.t1.e.k
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f8428f.E(this.f8423a, this.f8424b, this.f8425c, this.f8426d, this.f8427e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Function1<Boolean, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8429e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f8430f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8431g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f8432h;

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
            this.f8432h = eVar;
            this.f8429e = str;
            this.f8430f = strArr;
            this.f8431g = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) {
                if (bool.booleanValue()) {
                    this.f8432h.F(this.f8429e, this.f8430f, this.f8431g);
                    return null;
                }
                b.a.p0.a.e0.d.k("SwanAppPaymentManager", "paykey invalid order info " + this.f8429e);
                n.H(false, "nuomi", n.m("", "paykey invalid"));
                this.f8432h.N();
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class h implements b.a.p0.a.t1.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8433a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8434b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f8435c;

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
            this.f8435c = eVar;
            this.f8433a = jSONObject;
            this.f8434b = str;
        }

        @Override // b.a.p0.a.t1.g
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f8435c.L(i2, str, this.f8433a, this.f8434b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements b.a.d0.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8436a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8437b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f8438c;

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
            this.f8438c = eVar;
            this.f8436a = jSONObject;
            this.f8437b = str;
        }

        @Override // b.a.d0.f.b
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f8438c.L(i2, str, this.f8436a, this.f8437b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements b.InterfaceC0409b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8439a;

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
            this.f8439a = jSONObject;
        }

        @Override // b.a.p0.a.t1.b.InterfaceC0409b
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject == null) {
                    b.a.p0.a.e0.d.i("SwanAppPaymentManager", "pay_check request success, but result is null.");
                    return;
                }
                try {
                    boolean z = jSONObject.getBoolean("channel_check");
                    n.I("nuomi", z ? "pay check success" : "pay check fail", this.f8439a.optString("appKey"), z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0);
                } catch (JSONException e2) {
                    b.a.p0.a.e0.d.i("SwanAppPaymentManager", "pay_check request success, but result error: " + jSONObject + StringUtils.LF + Log.getStackTraceString(e2));
                }
            }
        }

        @Override // b.a.p0.a.t1.b.InterfaceC0409b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                b.a.p0.a.e0.d.i("SwanAppPaymentManager", "pay_check request fail: " + str);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1335677778, "Lb/a/p0/a/t1/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1335677778, "Lb/a/p0/a/t1/e;");
                return;
            }
        }
        j = b.a.p0.a.k.f6863a;
        k = new String[]{"duershow"};
    }

    public e(b.a.p0.a.d2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
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
        this.f8399a = eVar;
        this.f8400b = unitedSchemeEntity;
        this.f8401c = callbackHandler;
        this.f8402d = str;
        this.f8403e = str2;
        this.f8407i = str3;
        this.f8406h = new PaymentManager();
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

    public static JSONObject w(b.a.p0.a.d2.e eVar, JSONObject jSONObject) {
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
            PMSAppInfo u = b.a.p0.q.g.a.i().u(str);
            int i2 = u == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : u.payProtected;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("baoStatus", i2);
            jSONObject2.put("sappId", 10001);
            jSONObject2.put("objectId", str);
            jSONObject.put("baoInfo", jSONObject2.toString());
        }
    }

    public static void z(@NonNull b.a.p0.a.d2.e eVar, JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, null, eVar, jSONObject) == null) {
            if (SwanAppAllianceLoginHelper.f44256d.f()) {
                jSONObject.put("openBduss", b.a.p0.a.c1.a.h0().d(b.a.p0.a.c1.a.c()));
                jSONObject.put("clientId", b.a.p0.a.c1.a.n().b());
            } else {
                jSONObject.put("bduss", b.a.p0.a.c1.a.h0().d(b.a.p0.a.c1.a.c()));
            }
            jSONObject.put("cuid", b.a.p0.a.c1.a.h0().i(b.a.p0.a.c1.a.c()));
            String a2 = b.a.p0.a.c1.a.y().a();
            if (!TextUtils.isEmpty(a2)) {
                jSONObject.put("tpUid", a2);
            }
            String optString = jSONObject.optString("bizInfo");
            JSONObject jSONObject2 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
            jSONObject2.put("swanFrom", eVar.V().T());
            jSONObject2.put("cuid", b.a.p0.a.c1.a.h0().i(b.a.p0.a.c1.a.c()));
            jSONObject2.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, b.a.p0.a.d2.d.J().getAppId());
            w(eVar, jSONObject2);
            jSONObject.put("bizInfo", jSONObject2.toString());
            jSONObject.put("platformId", "100003");
            jSONObject.put("nativeAppId", b.a.p0.a.c1.a.n().a());
            jSONObject.put("sceneSource", "swan");
            jSONObject.put("swanNativeVersion", l.a());
            y(jSONObject, eVar.N());
            if (j) {
                jSONObject.toString();
            }
        }
    }

    public final boolean B(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (this.f8399a.M().e(this.f8399a.getActivity())) {
                D(str);
                return true;
            }
            b.a.p0.a.d2.e eVar = this.f8399a;
            if (eVar == null) {
                return false;
            }
            boolean e2 = eVar.M().e(this.f8399a.x());
            if (!e2) {
                n.S("show", 9, str2);
            }
            this.f8399a.M().f(this.f8399a.getActivity(), null, new b(this, e2, str2, str));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean C(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str2) && (str.equals("mapp_request_duxiaoman") || str.equals("mapp_request_alipayment"))) {
                this.f8400b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                b.a.p0.a.e0.d.k("SwanAppPaymentManager", "Error: order info is null.");
                return false;
            }
            this.f8399a.d0().g(this.f8399a.x(), str, new a(this, str, str2, str3));
            UnitedSchemeUtility.callCallback(this.f8401c, this.f8400b, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            n.K("baiduqianbao", "intoPayment", 0);
            this.f8406h.e(this.f8399a.getActivity(), str, new c(this));
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
                    z(this.f8399a, jSONObject2);
                    if (!A(jSONObject2)) {
                        this.f8401c.handleSchemeDispatchCallback(this.f8407i, UnitedSchemeUtility.wrapCallbackParams(202).toString());
                        return;
                    }
                } catch (JSONException e3) {
                    e2 = e3;
                    if (b.a.p0.a.k.f6863a) {
                        e2.printStackTrace();
                    }
                    b.a.p0.a.g1.f.U().o();
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
                    UnitedSchemeUtility.callCallback(this.f8401c, this.f8400b, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.f8399a.z() == null) {
                    }
                }
            } catch (JSONException e4) {
                jSONObject2 = jSONObject3;
                e2 = e4;
            }
            b.a.p0.a.g1.f.U().o();
            String[] strArr22 = k;
            length = strArr22.length;
            i2 = 0;
            while (true) {
                if (i2 < length) {
                    z = false;
                    break;
                } else if (strArr22[i2].equals(b.a.p0.a.c1.a.n().a())) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            n.K("nuomi", "intoPayment", 0);
            if (!z) {
                String a2 = b.a.p0.w.i.a(b.a.p0.w.i.a("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject2.toString())), "deviceType", "ANDROID");
                b.a.p0.a.h0.g.l.a3("qrCodePay", b.a.p0.a.m1.b.e(a2, a2));
                b.a.p0.a.t1.h.b(new h(this, jSONObject, str));
                b.a.p0.a.e0.d.k("SwanAppPaymentManager", "doPolymerPay Qr Code: " + jSONObject2.toString());
            } else {
                this.f8406h.j(this.f8399a.x(), jSONObject2, strArr, new i(this, jSONObject, str));
                b.a.p0.a.e0.d.k("SwanAppPaymentManager", "doPolymerPay: " + jSONObject2.toString());
            }
            UnitedSchemeUtility.callCallback(this.f8401c, this.f8400b, UnitedSchemeUtility.wrapCallbackParams(0));
            if (this.f8399a.z() == null) {
                String valueOf = String.valueOf(this.f8399a.V().G());
                String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.f8399a.V().W()).get("_baiduboxapp"));
                Bundle bundle = new Bundle();
                bundle.putString("frameType", valueOf);
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f8399a.V().H());
                try {
                    bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
                } catch (UnsupportedEncodingException e5) {
                    if (j) {
                        throw new RuntimeException("This method requires UTF-8 encoding support", e5);
                    }
                }
                this.f8399a.z().Y(7, bundle);
            }
        }
    }

    public final void G(String str, String[] strArr, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, strArr, jSONObject) == null) {
            try {
                String optString = new JSONObject(str).optString("appKey");
                if (!this.f8399a.v0()) {
                    F(str, strArr, jSONObject);
                } else {
                    b.a.p0.a.p1.r.c.d.b(optString, new g(this, str, strArr, jSONObject));
                }
            } catch (JSONException e2) {
                N();
                b.a.p0.a.e0.d.k("SwanAppPaymentManager", " doPolymerPayChecked error " + str);
                if (b.a.p0.a.k.f6863a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void H(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            b.a.p0.a.c1.b.e().a(str, new f(this, str, strArr, jSONObject, z, z2));
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
            boolean e2 = this.f8399a.M().e(this.f8399a.x());
            if (!e2) {
                n.S("show", 8, str2);
            }
            if (TextUtils.isEmpty(str)) {
                this.f8400b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString2 = jSONObject.optString("__plugin__");
            b.a.p0.a.w1.e.a.b("start payment");
            if (!TextUtils.isEmpty(optString2) && (opt = jSONObject.opt("error")) != null) {
                String optString3 = jSONObject.optString("slaveId");
                b.a.p0.a.w1.d.c.a aVar = new b.a.p0.a.w1.d.c.a(jSONObject.optString("componentId"));
                aVar.f9220a = optString3;
                aVar.f9222c = opt;
                aVar.f9223d = false;
                aVar.f9224e = null;
                aVar.b();
                b.a.p0.a.e0.d.k("SwanAppPaymentManager", "Error: param check error - plugin pay contains custom error");
                n.H(false, "nuomi", n.m("", "param check error - plugin pay contains custom error"));
                this.f8400b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
            if (this.f8399a.x() == null) {
                this.f8404f = 5;
                this.f8405g = null;
                M(null);
                if (j) {
                    throw new RuntimeException("swanApp getActivity returns null");
                }
                return true;
            } else if (this.f8399a.M().e(this.f8399a.getActivity())) {
                if (this.f8399a.v0()) {
                    H(str, strArr, jSONObject, true, true);
                    return true;
                }
                E(str, strArr, jSONObject, true, true);
                return true;
            } else {
                this.f8399a.M().f(this.f8399a.getActivity(), null, new C0410e(this, str2, str, strArr, jSONObject, e2));
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
            b.a.p0.a.g1.f.U().b();
            b.a.p0.a.e0.d.i("SwanAppPaymentManager", "sendSecondCallback statusCode: " + this.f8404f + " params: " + this.f8405g + " payParams: " + jSONObject.toString() + " orderId: " + jSONObject2.optString("tpOrderId"));
            O(i2, "nuomi", I(str, jSONObject2));
            this.f8404f = i2;
            this.f8405g = str;
            if (i2 != 1) {
                n.K("nuomi", "result", i2);
            }
            M(null);
            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
                String optString = jSONObject.optString("slaveId");
                String optString2 = jSONObject.optString("componentId");
                Object opt = jSONObject.opt("error");
                b.a.p0.a.w1.d.c.a aVar = new b.a.p0.a.w1.d.c.a(optString2);
                aVar.f9220a = optString;
                aVar.f9222c = opt;
                aVar.f9223d = i2 == 0;
                aVar.f9224e = str;
                aVar.b();
                b.a.p0.a.w1.h.b.j();
            }
            if (this.f8404f == 0 && !b.a.p0.a.a2.c.f4043c.c()) {
                b.a.p0.a.a2.c.f4043c.e();
            }
            if (i2 == 0) {
                b.a.p0.a.t1.b bVar = new b.a.p0.a.t1.b();
                bVar.h(jSONObject2);
                bVar.d(new j(this, jSONObject2));
            }
        }
    }

    public final void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            try {
                if (TextUtils.equals(this.f8402d, "2.0")) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("payId", str);
                    if (!TextUtils.isEmpty(this.f8405g)) {
                        jSONObject.put("payResult", Base64.encodeToString(this.f8405g.getBytes("UTF-8"), 2));
                    }
                    b.a.p0.a.e0.d.i("SwanAppPaymentManager", "Success: sendSecondCallback, data = " + jSONObject + " status code = " + this.f8404f);
                    this.f8401c.handleSchemeDispatchCallback(this.f8407i, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.f8404f, J(this.f8404f)).toString());
                    return;
                }
                b.a.p0.a.e0.d.i("SwanAppPaymentManager", "Success: sendSecondCallback, result = " + this.f8405g + " status code = " + this.f8404f);
                this.f8401c.handleSchemeDispatchCallback(this.f8407i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.f8405g, this.f8404f, J(this.f8404f)).toString());
            } catch (UnsupportedEncodingException | JSONException e2) {
                b.a.p0.a.e0.d.i("SwanAppPaymentManager", "Fail: sendSecondCallback exception , exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace()));
                CallbackHandler callbackHandler = this.f8401c;
                String str2 = this.f8407i;
                int i2 = this.f8404f;
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i2, J(i2)).toString());
            }
        }
    }

    public final void N() {
        b.a.p0.a.d2.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (eVar = this.f8399a) == null) {
            return;
        }
        b.a.p0.a.c2.b.f.e.f(eVar.x(), b.a.p0.a.h.swanapp_payment_illegal).G();
        if (TextUtils.isEmpty(this.f8407i)) {
            return;
        }
        this.f8401c.handleSchemeDispatchCallback(this.f8407i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f8399a.x().getString(b.a.p0.a.h.swanapp_payment_illegal)).toString());
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
            b.a.p0.a.e0.d.i("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
            if (b.a.p0.a.t1.k.a(this.f8399a, this.f8401c, this.f8400b)) {
                this.f8404f = 0;
                this.f8405g = null;
                if (TextUtils.equals(this.f8402d, "2.0")) {
                    b.a.p0.a.c1.a.W().e(this.f8403e, this);
                } else {
                    M(null);
                }
                n.G("wechatH5Action", null, null);
                return true;
            }
            b.a.p0.a.e0.d.k("SwanAppPaymentManager", "Error: open webview error.  entity = " + this.f8400b.toString());
            this.f8401c.handleSchemeDispatchCallback(this.f8407i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.a2.a
    public void a(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jSONObject) == null) {
            b.a.p0.a.e0.d.c("SwanAppPaymentManager", "Info: getPayId Request Response =  " + jSONObject.toString());
            if (jSONObject.optInt("errno") == 0) {
                str = jSONObject.optJSONObject("data").optString("payid");
                b.a.p0.a.e0.d.c("SwanAppPaymentManager", "Info: payId =  " + str);
            } else {
                str = null;
            }
            M(str);
            if (b.a.p0.a.a2.c.f4043c.c()) {
                return;
            }
            if (b.a.p0.a.c1.a.h0().e(this.f8399a)) {
                b.a.p0.a.a2.c.f4043c.e();
            } else {
                b.a.p0.a.a2.c.f4043c.f();
            }
        }
    }

    @Override // b.a.p0.a.a2.a
    public void onFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            b.a.p0.a.e0.d.c("SwanAppPaymentManager", "Fail: request payId failed");
            b.a.p0.a.e0.d.c("SwanAppPaymentManager", str);
            M(null);
        }
    }

    public final boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (j) {
                String str2 = "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT orderInfo: " + str;
            }
            n.K(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "intoPayment", 0);
            this.f8406h.d(this.f8399a.getActivity(), str, new d(this));
            return true;
        }
        return invokeL.booleanValue;
    }
}
