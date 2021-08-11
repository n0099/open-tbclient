package c.a.n0.a.q1;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.e2.c.j.b;
import c.a.n0.a.f1.e.b;
import c.a.n0.a.j2.k;
import c.a.n0.a.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.android.lbspay.presenter.LBSTransAuthPresenter;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements c.a.n0.a.q1.g.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f7792j;
    public static String[] k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.n0.a.a2.e f7793a;

    /* renamed from: b  reason: collision with root package name */
    public UnitedSchemeEntity f7794b;

    /* renamed from: c  reason: collision with root package name */
    public CallbackHandler f7795c;

    /* renamed from: d  reason: collision with root package name */
    public String f7796d;

    /* renamed from: e  reason: collision with root package name */
    public String f7797e;

    /* renamed from: f  reason: collision with root package name */
    public int f7798f;

    /* renamed from: g  reason: collision with root package name */
    public String f7799g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.c0.a f7800h;

    /* renamed from: i  reason: collision with root package name */
    public String f7801i;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f7802e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7803f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7804g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f7805h;

        public a(b bVar, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7805h = bVar;
            this.f7802e = z;
            this.f7803f = str;
            this.f7804g = str2;
        }

        @Override // c.a.n0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    if (!this.f7802e) {
                        k.M("success", 9, this.f7803f);
                    }
                    this.f7805h.B(this.f7804g);
                    return;
                }
                if (!this.f7802e) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 9, this.f7803f);
                }
                this.f7805h.f7798f = 5;
                this.f7805h.f7799g = null;
                this.f7805h.K(null);
            }
        }
    }

    /* renamed from: c.a.n0.a.q1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0344b implements c.a.c0.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f7806a;

        public C0344b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7806a = bVar;
        }

        @Override // c.a.c0.e.a
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f7806a.f7798f = i2;
                this.f7806a.f7799g = str;
                if (b.f7792j) {
                    String str2 = "statusCode: " + i2 + " ,result:" + str;
                }
                this.f7806a.M(i2, "baiduqianbao", str);
                k.F("baiduqianbao", "result", i2);
                if (i2 != 0 || !TextUtils.equals(this.f7806a.f7796d, "2.0")) {
                    this.f7806a.K(null);
                } else {
                    c.a.n0.a.c1.a.R().e(this.f7806a.f7797e, this.f7806a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.c0.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f7807a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7807a = bVar;
        }

        @Override // c.a.c0.e.a
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f7807a.f7798f = i2;
                this.f7807a.f7799g = str;
                c.a.n0.a.e0.d.h("SwanAppPaymentManager", "statusCode: " + this.f7807a.f7798f + " ,result:" + this.f7807a.f7799g);
                this.f7807a.M(i2, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, str);
                if (i2 != 1) {
                    k.F(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "result", i2);
                }
                if (i2 != 0 || !TextUtils.equals(this.f7807a.f7796d, "2.0")) {
                    this.f7807a.K(null);
                } else {
                    c.a.n0.a.c1.a.R().e(this.f7807a.f7797e, this.f7807a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.n0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7808e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7809f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String[] f7810g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7811h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f7812i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f7813j;

        public d(b bVar, String str, String str2, String[] strArr, JSONObject jSONObject, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, strArr, jSONObject, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7813j = bVar;
            this.f7808e = str;
            this.f7809f = str2;
            this.f7810g = strArr;
            this.f7811h = jSONObject;
            this.f7812i = z;
        }

        @Override // c.a.n0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    k.M("success", 8, this.f7808e);
                    if (this.f7813j.f7793a.m0()) {
                        this.f7813j.F(this.f7809f, this.f7810g, this.f7811h, true, false);
                        return;
                    } else {
                        this.f7813j.C(this.f7809f, this.f7810g, this.f7811h, true, false);
                        return;
                    }
                }
                if (!this.f7812i) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 8, this.f7808e);
                    c.a.n0.a.e0.d.h("SwanAppPaymentManager", "login error");
                    k.D(false, "nuomi", c.a.n0.a.q1.a.c("", "login error"));
                }
                this.f7813j.f7798f = 5;
                this.f7813j.f7799g = null;
                this.f7813j.K(null);
                k.E("nuomi", false, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f7814a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f7815b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7816c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f7817d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f7818e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f7819f;

        public e(b bVar, String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7819f = bVar;
            this.f7814a = str;
            this.f7815b = strArr;
            this.f7816c = jSONObject;
            this.f7817d = z;
            this.f7818e = z2;
        }

        @Override // c.a.n0.a.q1.b.j
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(this.f7819f.f7801i)) {
                return;
            }
            CallbackHandler callbackHandler = this.f7819f.f7795c;
            String str2 = this.f7819f.f7801i;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f7819f.f7793a.x().getString(c.a.n0.a.h.swan_game_anti_addiction) + str).toString());
        }

        @Override // c.a.n0.a.q1.b.j
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f7819f.C(this.f7814a, this.f7815b, this.f7816c, this.f7817d, this.f7818e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Function1<Boolean, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7820e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f7821f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7822g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7823h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f7824i;

        public f(b bVar, JSONObject jSONObject, String[] strArr, JSONObject jSONObject2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, jSONObject, strArr, jSONObject2, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7824i = bVar;
            this.f7820e = jSONObject;
            this.f7821f = strArr;
            this.f7822g = jSONObject2;
            this.f7823h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) {
                if (bool.booleanValue()) {
                    this.f7824i.D(this.f7820e, this.f7821f, this.f7822g);
                    return null;
                }
                c.a.n0.a.e0.d.h("SwanAppPaymentManager", "paykey invalid order info " + this.f7823h);
                k.D(false, "nuomi", c.a.n0.a.q1.a.c("", "paykey invalid"));
                this.f7824i.L();
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.n0.a.q1.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7825a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7826b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f7827c;

        public g(b bVar, JSONObject jSONObject, JSONObject jSONObject2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, jSONObject, jSONObject2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7827c = bVar;
            this.f7825a = jSONObject;
            this.f7826b = jSONObject2;
        }

        @Override // c.a.n0.a.q1.d
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f7827c.J(i2, str, this.f7825a, this.f7826b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.c0.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7828a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7829b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f7830c;

        public h(b bVar, JSONObject jSONObject, JSONObject jSONObject2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, jSONObject, jSONObject2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7830c = bVar;
            this.f7828a = jSONObject;
            this.f7829b = jSONObject2;
        }

        @Override // c.a.c0.e.a
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f7830c.J(i2, str, this.f7828a, this.f7829b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.a.n0.a.v2.e1.b<c.a.n0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7831e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7832f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7833g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f7834h;

        public i(b bVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7834h = bVar;
            this.f7831e = str;
            this.f7832f = str2;
            this.f7833g = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
            if (r10.equals("mapp_request_duxiaoman") != false) goto L37;
         */
        @Override // c.a.n0.a.v2.e1.b
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCallback(c.a.n0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                char c2 = 0;
                if (!c.a.n0.a.e2.c.d.h(iVar)) {
                    String str = null;
                    if (TextUtils.equals(this.f7834h.f7796d, "2.0")) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("payId", "");
                        } catch (JSONException e2) {
                            if (b.f7792j) {
                                e2.printStackTrace();
                            }
                        }
                        str = String.valueOf(jSONObject);
                    }
                    if (TextUtils.equals(this.f7831e, "mapp_request_duxiaoman")) {
                        k.D(false, "baiduqianbao", c.a.n0.a.q1.a.c("", "authorize fail"));
                    } else if (TextUtils.equals(this.f7831e, "mapp_request_alipayment")) {
                        k.D(false, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, c.a.n0.a.q1.a.c("", "authorize fail"));
                    } else if (TextUtils.equals(this.f7831e, "mapp_request_wechatpayment")) {
                        k.D(false, "wechatH5Action", c.a.n0.a.q1.a.c("", "authorize fail"));
                    }
                    c.a.n0.a.e0.d.h("SwanAppPaymentManager", "Error: authorized fail. scope = " + this.f7831e);
                    this.f7834h.f7795c.handleSchemeDispatchCallback(this.f7834h.f7801i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str, 1001, "authorize denied").toString());
                    return;
                }
                String str2 = this.f7831e;
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
                    this.f7834h.z(this.f7832f, this.f7833g);
                } else if (c2 == 1) {
                    this.f7834h.x(this.f7832f);
                } else if (c2 != 2) {
                } else {
                    this.f7834h.N();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        void onFail(String str);

        void onSuccess();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1220375507, "Lc/a/n0/a/q1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1220375507, "Lc/a/n0/a/q1/b;");
                return;
            }
        }
        f7792j = c.a.n0.a.k.f6803a;
        k = new String[]{"duershow"};
    }

    public b(c.a.n0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
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
        this.f7793a = eVar;
        this.f7794b = unitedSchemeEntity;
        this.f7795c = callbackHandler;
        this.f7796d = str;
        this.f7797e = str2;
        this.f7801i = str3;
        this.f7800h = new c.a.c0.a();
    }

    public static String H(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 != 0 ? i2 != 2 ? EventAlias.PayEventAlias.PAY_FAIL : "支付取消" : EventAlias.PayEventAlias.PAY_SUCCESS : (String) invokeI.objValue;
    }

    public boolean A(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str2) && (str.equals("mapp_request_duxiaoman") || str.equals("mapp_request_alipayment"))) {
                this.f7794b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.n0.a.e0.d.h("SwanAppPaymentManager", "Error: order info is null.");
                return false;
            }
            this.f7793a.T().g(this.f7793a.x(), str, new i(this, str, str2, str3));
            UnitedSchemeUtility.callCallback(this.f7795c, this.f7794b, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            k.F("baiduqianbao", "intoPayment", 0);
            this.f7800h.d(this.f7793a.k(), str, new C0344b(this));
        }
    }

    public final void C(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            E(str, strArr, jSONObject);
            k.E("nuomi", z, z2);
        }
    }

    public final void D(JSONObject jSONObject, String[] strArr, JSONObject jSONObject2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, jSONObject, strArr, jSONObject2) == null) {
            try {
                if (c.a.n0.a.s.a.f.f8218d.f()) {
                    jSONObject.put("openBduss", c.a.n0.a.c1.a.a0().d(c.a.n0.a.c1.a.b()));
                    jSONObject.put("clientId", c.a.n0.a.c1.a.m().b());
                } else {
                    jSONObject.put("bduss", c.a.n0.a.c1.a.a0().d(c.a.n0.a.c1.a.b()));
                }
                jSONObject.put("cuid", c.a.n0.a.c1.a.a0().i(c.a.n0.a.c1.a.b()));
                String optString = jSONObject.optString("bizInfo");
                JSONObject jSONObject3 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
                jSONObject3.put("swanFrom", this.f7793a.L().T());
                jSONObject3.put("cuid", c.a.n0.a.c1.a.a0().i(c.a.n0.a.c1.a.b()));
                jSONObject3.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, c.a.n0.a.a2.d.g().getAppId());
                w(jSONObject3);
                jSONObject.put("bizInfo", jSONObject3.toString());
                jSONObject.put("platformId", "100003");
                jSONObject.put("nativeAppId", c.a.n0.a.c1.a.m().a());
                jSONObject.put("sceneSource", "swan");
                jSONObject.put("swanNativeVersion", l.a());
                y(jSONObject, this.f7793a.D());
                if (f7792j) {
                    jSONObject.toString();
                }
            } catch (JSONException e2) {
                if (c.a.n0.a.k.f6803a) {
                    e2.printStackTrace();
                }
            }
            c.a.n0.a.g1.f.V().p();
            String[] strArr2 = k;
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                } else if (strArr2[i2].equals(c.a.n0.a.c1.a.m().a())) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            k.F("nuomi", "intoPayment", 0);
            if (z) {
                String a2 = c.a.n0.t.i.a(c.a.n0.t.i.a("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject.toString())), "deviceType", "ANDROID");
                c.a.n0.a.h0.g.k.O2("qrCodePay", c.a.n0.a.l1.b.g(a2, a2));
                c.a.n0.a.q1.e.b(new g(this, jSONObject2, jSONObject));
                c.a.n0.a.e0.d.h("SwanAppPaymentManager", "doPolymerPay Qr Code: " + jSONObject.toString());
            } else {
                this.f7800h.i(this.f7793a.x(), jSONObject, strArr, new h(this, jSONObject2, jSONObject));
                c.a.n0.a.e0.d.h("SwanAppPaymentManager", "doPolymerPay: " + jSONObject.toString());
            }
            UnitedSchemeUtility.callCallback(this.f7795c, this.f7794b, UnitedSchemeUtility.wrapCallbackParams(0));
            if (this.f7793a.z() != null) {
                String valueOf = String.valueOf(this.f7793a.L().G());
                String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.f7793a.L().W()).get("_baiduboxapp"));
                Bundle bundle = new Bundle();
                bundle.putString("frameType", valueOf);
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f7793a.L().H());
                try {
                    bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
                } catch (UnsupportedEncodingException e3) {
                    if (f7792j) {
                        throw new RuntimeException("This method requires UTF-8 encoding support", e3);
                    }
                }
                this.f7793a.z().N(7, bundle);
            }
        }
    }

    public final void E(String str, String[] strArr, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, strArr, jSONObject) == null) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                c.a.n0.a.n1.q.c.d.b(jSONObject2.optString("appKey"), new f(this, jSONObject2, strArr, jSONObject, str));
            } catch (JSONException e2) {
                L();
                c.a.n0.a.e0.d.h("SwanAppPaymentManager", " doPolymerPayChecked error " + str);
                if (c.a.n0.a.k.f6803a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void F(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            c.a.n0.a.c1.b.e().a(str, new e(this, str, strArr, jSONObject, z, z2));
        }
    }

    public final String G(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, jSONObject)) == null) {
            String optString = jSONObject.optString("tpOrderId");
            try {
                return new JSONObject(str).put("orderId", optString).toString();
            } catch (JSONException e2) {
                if (f7792j) {
                    e2.printStackTrace();
                }
                return str + " orderId = " + optString;
            }
        }
        return (String) invokeLL.objValue;
    }

    public boolean I(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        String[] strArr;
        Object opt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, jSONObject)) == null) {
            String optString = jSONObject.optString("invokeFrom");
            if (TextUtils.isEmpty(optString)) {
                optString = RetrieveTaskManager.KEY;
            }
            String str2 = optString;
            boolean e2 = this.f7793a.j().e(this.f7793a.x());
            if (!e2) {
                k.M("show", 8, str2);
            }
            if (TextUtils.isEmpty(str)) {
                this.f7794b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString2 = jSONObject.optString("__plugin__");
            c.a.n0.a.t1.d.a.a("start payment");
            if (!TextUtils.isEmpty(optString2) && (opt = jSONObject.opt("error")) != null) {
                String optString3 = jSONObject.optString("slaveId");
                c.a.n0.a.t1.c.c.a aVar = new c.a.n0.a.t1.c.c.a(jSONObject.optString("componentId"));
                aVar.f8401a = optString3;
                aVar.f8403c = opt;
                aVar.f8404d = false;
                aVar.f8405e = null;
                aVar.b();
                c.a.n0.a.e0.d.h("SwanAppPaymentManager", "Error: param check error - plugin pay contains custom error");
                k.D(false, "nuomi", c.a.n0.a.q1.a.c("", "param check error - plugin pay contains custom error"));
                this.f7794b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
            k.F("nuomi", "login", 0);
            if (this.f7793a.x() == null) {
                this.f7798f = 5;
                this.f7799g = null;
                K(null);
                if (f7792j) {
                    throw new RuntimeException("swanApp getActivity returns null");
                }
                return true;
            } else if (this.f7793a.j().e(this.f7793a.k())) {
                if (this.f7793a.m0()) {
                    F(str, strArr, jSONObject, true, true);
                    return true;
                }
                C(str, strArr, jSONObject, true, true);
                return true;
            } else {
                this.f7793a.j().f(this.f7793a.k(), null, new d(this, str2, str, strArr, jSONObject, e2));
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void J(int i2, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), str, jSONObject, jSONObject2}) == null) {
            c.a.n0.a.g1.f.V().b();
            c.a.n0.a.e0.d.g("SwanAppPaymentManager", "sendSecondCallback statusCode: " + this.f7798f + " params: " + this.f7799g + " payParams: " + jSONObject.toString() + " orderId: " + jSONObject2.optString("tpOrderId"));
            M(i2, "nuomi", G(str, jSONObject2));
            this.f7798f = i2;
            this.f7799g = str;
            if (i2 != 1) {
                k.F("nuomi", "result", i2);
            }
            K(null);
            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
                String optString = jSONObject.optString("slaveId");
                String optString2 = jSONObject.optString("componentId");
                Object opt = jSONObject.opt("error");
                c.a.n0.a.t1.c.c.a aVar = new c.a.n0.a.t1.c.c.a(optString2);
                aVar.f8401a = optString;
                aVar.f8403c = opt;
                aVar.f8404d = i2 == 0;
                aVar.f8405e = str;
                aVar.b();
                c.a.n0.a.t1.g.b.j();
            }
            if (this.f7798f != 0 || c.a.n0.a.x1.c.f9431c.c()) {
                return;
            }
            c.a.n0.a.x1.c.f9431c.e();
        }
    }

    public final void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            try {
                if (TextUtils.equals(this.f7796d, "2.0")) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("payId", str);
                    if (!TextUtils.isEmpty(this.f7799g)) {
                        jSONObject.put("payResult", Base64.encodeToString(this.f7799g.getBytes("UTF-8"), 2));
                    }
                    c.a.n0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, data = " + jSONObject + " status code = " + this.f7798f);
                    this.f7795c.handleSchemeDispatchCallback(this.f7801i, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.f7798f, H(this.f7798f)).toString());
                    return;
                }
                c.a.n0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, result = " + this.f7799g + " status code = " + this.f7798f);
                this.f7795c.handleSchemeDispatchCallback(this.f7801i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.f7799g, this.f7798f, H(this.f7798f)).toString());
            } catch (UnsupportedEncodingException | JSONException e2) {
                c.a.n0.a.e0.d.g("SwanAppPaymentManager", "Fail: sendSecondCallback exception , exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace()));
                CallbackHandler callbackHandler = this.f7795c;
                String str2 = this.f7801i;
                int i2 = this.f7798f;
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i2, H(i2)).toString());
            }
        }
    }

    public final void L() {
        c.a.n0.a.a2.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (eVar = this.f7793a) == null) {
            return;
        }
        c.a.n0.a.z1.b.f.e.f(eVar.x(), c.a.n0.a.h.swanapp_payment_illegal).F();
        if (TextUtils.isEmpty(this.f7801i)) {
            return;
        }
        this.f7795c.handleSchemeDispatchCallback(this.f7801i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f7793a.x().getString(c.a.n0.a.h.swanapp_payment_illegal)).toString());
    }

    public final void M(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048587, this, i2, str, str2) == null) {
            k.D(i2 == 0, str, str2);
        }
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.n0.a.e0.d.g("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
            if (c.a.n0.a.q1.a.b().e(this.f7793a, this.f7795c, this.f7794b)) {
                this.f7798f = 0;
                this.f7799g = null;
                if (TextUtils.equals(this.f7796d, "2.0")) {
                    c.a.n0.a.c1.a.R().e(this.f7797e, this);
                } else {
                    K(null);
                }
                k.C("wechatH5Action", null, null);
                return true;
            }
            c.a.n0.a.e0.d.h("SwanAppPaymentManager", "Error: open webview error.  entity = " + this.f7794b.toString());
            this.f7795c.handleSchemeDispatchCallback(this.f7801i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x1.a
    public void a(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) {
            c.a.n0.a.e0.d.b("SwanAppPaymentManager", "Info: getPayId Request Response =  " + jSONObject.toString());
            if (jSONObject.optInt("errno") == 0) {
                str = jSONObject.optJSONObject("data").optString("payid");
                c.a.n0.a.e0.d.b("SwanAppPaymentManager", "Info: payId =  " + str);
            } else {
                str = null;
            }
            K(str);
            if (c.a.n0.a.x1.c.f9431c.c()) {
                return;
            }
            if (c.a.n0.a.c1.a.a0().e(this.f7793a)) {
                c.a.n0.a.x1.c.f9431c.e();
            } else {
                c.a.n0.a.x1.c.f9431c.f();
            }
        }
    }

    @Override // c.a.n0.a.x1.a
    public void onFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            c.a.n0.a.e0.d.b("SwanAppPaymentManager", "Fail: request payId failed");
            c.a.n0.a.e0.d.b("SwanAppPaymentManager", str);
            K(null);
        }
    }

    public final JSONObject w(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, jSONObject)) == null) {
            if (this.f7793a.m0() && jSONObject != null) {
                b.a L = this.f7793a.L();
                if (L.M() == null) {
                    return jSONObject;
                }
                JSONObject M = L.M();
                String optString = M.optString(TiebaStatic.Params.LOGID);
                String optString2 = M.optString("module_id");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    try {
                        jSONObject.put(TiebaStatic.Params.LOGID, optString);
                        jSONObject.put("module_id", optString2);
                    } catch (JSONException e2) {
                        if (f7792j) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (f7792j) {
                String str2 = "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT orderInfo: " + str;
            }
            k.F(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "intoPayment", 0);
            this.f7800h.c(this.f7793a.k(), str, new c(this));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void y(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, jSONObject, str) == null) {
            PMSAppInfo s = c.a.n0.n.g.a.h().s(str);
            int i2 = s == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : s.payProtected;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("baoStatus", i2);
            jSONObject2.put("sappId", 10001);
            jSONObject2.put("objectId", str);
            jSONObject.put("baoInfo", jSONObject2.toString());
        }
    }

    public final boolean z(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, str2)) == null) {
            if (this.f7793a.j().e(this.f7793a.k())) {
                B(str);
                return true;
            }
            c.a.n0.a.a2.e eVar = this.f7793a;
            if (eVar == null) {
                return false;
            }
            boolean e2 = eVar.j().e(this.f7793a.x());
            if (!e2) {
                k.M("show", 9, str2);
            }
            this.f7793a.j().f(this.f7793a.k(), null, new a(this, e2, str2, str));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
