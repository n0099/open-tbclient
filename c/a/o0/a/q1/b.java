package c.a.o0.a.q1;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.e2.c.j.b;
import c.a.o0.a.f1.e.b;
import c.a.o0.a.j2.k;
import c.a.o0.a.l;
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
public class b implements c.a.o0.a.q1.g.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f8038j;
    public static String[] k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.o0.a.a2.e f8039a;

    /* renamed from: b  reason: collision with root package name */
    public UnitedSchemeEntity f8040b;

    /* renamed from: c  reason: collision with root package name */
    public CallbackHandler f8041c;

    /* renamed from: d  reason: collision with root package name */
    public String f8042d;

    /* renamed from: e  reason: collision with root package name */
    public String f8043e;

    /* renamed from: f  reason: collision with root package name */
    public int f8044f;

    /* renamed from: g  reason: collision with root package name */
    public String f8045g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.d0.a f8046h;

    /* renamed from: i  reason: collision with root package name */
    public String f8047i;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f8048e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8049f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8050g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f8051h;

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
            this.f8051h = bVar;
            this.f8048e = z;
            this.f8049f = str;
            this.f8050g = str2;
        }

        @Override // c.a.o0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    if (!this.f8048e) {
                        k.M("success", 9, this.f8049f);
                    }
                    this.f8051h.B(this.f8050g);
                    return;
                }
                if (!this.f8048e) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 9, this.f8049f);
                }
                this.f8051h.f8044f = 5;
                this.f8051h.f8045g = null;
                this.f8051h.K(null);
            }
        }
    }

    /* renamed from: c.a.o0.a.q1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0352b implements c.a.d0.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8052a;

        public C0352b(b bVar) {
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
            this.f8052a = bVar;
        }

        @Override // c.a.d0.e.a
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f8052a.f8044f = i2;
                this.f8052a.f8045g = str;
                if (b.f8038j) {
                    String str2 = "statusCode: " + i2 + " ,result:" + str;
                }
                this.f8052a.M(i2, "baiduqianbao", str);
                k.F("baiduqianbao", "result", i2);
                if (i2 != 0 || !TextUtils.equals(this.f8052a.f8042d, "2.0")) {
                    this.f8052a.K(null);
                } else {
                    c.a.o0.a.c1.a.R().e(this.f8052a.f8043e, this.f8052a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.d0.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8053a;

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
            this.f8053a = bVar;
        }

        @Override // c.a.d0.e.a
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f8053a.f8044f = i2;
                this.f8053a.f8045g = str;
                c.a.o0.a.e0.d.h("SwanAppPaymentManager", "statusCode: " + this.f8053a.f8044f + " ,result:" + this.f8053a.f8045g);
                this.f8053a.M(i2, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, str);
                if (i2 != 1) {
                    k.F(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "result", i2);
                }
                if (i2 != 0 || !TextUtils.equals(this.f8053a.f8042d, "2.0")) {
                    this.f8053a.K(null);
                } else {
                    c.a.o0.a.c1.a.R().e(this.f8053a.f8043e, this.f8053a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.o0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8054e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8055f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String[] f8056g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8057h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f8058i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f8059j;

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
            this.f8059j = bVar;
            this.f8054e = str;
            this.f8055f = str2;
            this.f8056g = strArr;
            this.f8057h = jSONObject;
            this.f8058i = z;
        }

        @Override // c.a.o0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    k.M("success", 8, this.f8054e);
                    if (this.f8059j.f8039a.m0()) {
                        this.f8059j.F(this.f8055f, this.f8056g, this.f8057h, true, false);
                        return;
                    } else {
                        this.f8059j.C(this.f8055f, this.f8056g, this.f8057h, true, false);
                        return;
                    }
                }
                if (!this.f8058i) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 8, this.f8054e);
                    c.a.o0.a.e0.d.h("SwanAppPaymentManager", "login error");
                    k.D(false, "nuomi", c.a.o0.a.q1.a.c("", "login error"));
                }
                this.f8059j.f8044f = 5;
                this.f8059j.f8045g = null;
                this.f8059j.K(null);
                k.E("nuomi", false, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8060a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f8061b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8062c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f8063d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f8064e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8065f;

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
            this.f8065f = bVar;
            this.f8060a = str;
            this.f8061b = strArr;
            this.f8062c = jSONObject;
            this.f8063d = z;
            this.f8064e = z2;
        }

        @Override // c.a.o0.a.q1.b.j
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(this.f8065f.f8047i)) {
                return;
            }
            CallbackHandler callbackHandler = this.f8065f.f8041c;
            String str2 = this.f8065f.f8047i;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f8065f.f8039a.x().getString(c.a.o0.a.h.swan_game_anti_addiction) + str).toString());
        }

        @Override // c.a.o0.a.q1.b.j
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f8065f.C(this.f8060a, this.f8061b, this.f8062c, this.f8063d, this.f8064e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Function1<Boolean, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8066e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f8067f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8068g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8069h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f8070i;

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
            this.f8070i = bVar;
            this.f8066e = jSONObject;
            this.f8067f = strArr;
            this.f8068g = jSONObject2;
            this.f8069h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) {
                if (bool.booleanValue()) {
                    this.f8070i.D(this.f8066e, this.f8067f, this.f8068g);
                    return null;
                }
                c.a.o0.a.e0.d.h("SwanAppPaymentManager", "paykey invalid order info " + this.f8069h);
                k.D(false, "nuomi", c.a.o0.a.q1.a.c("", "paykey invalid"));
                this.f8070i.L();
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.o0.a.q1.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8071a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8072b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f8073c;

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
            this.f8073c = bVar;
            this.f8071a = jSONObject;
            this.f8072b = jSONObject2;
        }

        @Override // c.a.o0.a.q1.d
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f8073c.J(i2, str, this.f8071a, this.f8072b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.d0.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8074a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8075b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f8076c;

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
            this.f8076c = bVar;
            this.f8074a = jSONObject;
            this.f8075b = jSONObject2;
        }

        @Override // c.a.d0.e.a
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f8076c.J(i2, str, this.f8074a, this.f8075b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.a.o0.a.v2.e1.b<c.a.o0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8077e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8078f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8079g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f8080h;

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
            this.f8080h = bVar;
            this.f8077e = str;
            this.f8078f = str2;
            this.f8079g = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
            if (r10.equals("mapp_request_duxiaoman") != false) goto L37;
         */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCallback(c.a.o0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                char c2 = 0;
                if (!c.a.o0.a.e2.c.d.h(iVar)) {
                    String str = null;
                    if (TextUtils.equals(this.f8080h.f8042d, "2.0")) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("payId", "");
                        } catch (JSONException e2) {
                            if (b.f8038j) {
                                e2.printStackTrace();
                            }
                        }
                        str = String.valueOf(jSONObject);
                    }
                    if (TextUtils.equals(this.f8077e, "mapp_request_duxiaoman")) {
                        k.D(false, "baiduqianbao", c.a.o0.a.q1.a.c("", "authorize fail"));
                    } else if (TextUtils.equals(this.f8077e, "mapp_request_alipayment")) {
                        k.D(false, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, c.a.o0.a.q1.a.c("", "authorize fail"));
                    } else if (TextUtils.equals(this.f8077e, "mapp_request_wechatpayment")) {
                        k.D(false, "wechatH5Action", c.a.o0.a.q1.a.c("", "authorize fail"));
                    }
                    c.a.o0.a.e0.d.h("SwanAppPaymentManager", "Error: authorized fail. scope = " + this.f8077e);
                    this.f8080h.f8041c.handleSchemeDispatchCallback(this.f8080h.f8047i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str, 1001, "authorize denied").toString());
                    return;
                }
                String str2 = this.f8077e;
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
                    this.f8080h.z(this.f8078f, this.f8079g);
                } else if (c2 == 1) {
                    this.f8080h.x(this.f8078f);
                } else if (c2 != 2) {
                } else {
                    this.f8080h.N();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1023862002, "Lc/a/o0/a/q1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1023862002, "Lc/a/o0/a/q1/b;");
                return;
            }
        }
        f8038j = c.a.o0.a.k.f7049a;
        k = new String[]{"duershow"};
    }

    public b(c.a.o0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
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
        this.f8039a = eVar;
        this.f8040b = unitedSchemeEntity;
        this.f8041c = callbackHandler;
        this.f8042d = str;
        this.f8043e = str2;
        this.f8047i = str3;
        this.f8046h = new c.a.d0.a();
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
                this.f8040b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.o0.a.e0.d.h("SwanAppPaymentManager", "Error: order info is null.");
                return false;
            }
            this.f8039a.T().g(this.f8039a.x(), str, new i(this, str, str2, str3));
            UnitedSchemeUtility.callCallback(this.f8041c, this.f8040b, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            k.F("baiduqianbao", "intoPayment", 0);
            this.f8046h.d(this.f8039a.k(), str, new C0352b(this));
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
                if (c.a.o0.a.s.a.f.f8464d.f()) {
                    jSONObject.put("openBduss", c.a.o0.a.c1.a.a0().d(c.a.o0.a.c1.a.b()));
                    jSONObject.put("clientId", c.a.o0.a.c1.a.m().b());
                } else {
                    jSONObject.put("bduss", c.a.o0.a.c1.a.a0().d(c.a.o0.a.c1.a.b()));
                }
                jSONObject.put("cuid", c.a.o0.a.c1.a.a0().i(c.a.o0.a.c1.a.b()));
                String optString = jSONObject.optString("bizInfo");
                JSONObject jSONObject3 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
                jSONObject3.put("swanFrom", this.f8039a.L().T());
                jSONObject3.put("cuid", c.a.o0.a.c1.a.a0().i(c.a.o0.a.c1.a.b()));
                jSONObject3.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, c.a.o0.a.a2.d.g().getAppId());
                w(jSONObject3);
                jSONObject.put("bizInfo", jSONObject3.toString());
                jSONObject.put("platformId", "100003");
                jSONObject.put("nativeAppId", c.a.o0.a.c1.a.m().a());
                jSONObject.put("sceneSource", "swan");
                jSONObject.put("swanNativeVersion", l.a());
                y(jSONObject, this.f8039a.D());
                if (f8038j) {
                    jSONObject.toString();
                }
            } catch (JSONException e2) {
                if (c.a.o0.a.k.f7049a) {
                    e2.printStackTrace();
                }
            }
            c.a.o0.a.g1.f.V().p();
            String[] strArr2 = k;
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                } else if (strArr2[i2].equals(c.a.o0.a.c1.a.m().a())) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            k.F("nuomi", "intoPayment", 0);
            if (z) {
                String a2 = c.a.o0.t.i.a(c.a.o0.t.i.a("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject.toString())), "deviceType", "ANDROID");
                c.a.o0.a.h0.g.k.O2("qrCodePay", c.a.o0.a.l1.b.g(a2, a2));
                c.a.o0.a.q1.e.b(new g(this, jSONObject2, jSONObject));
                c.a.o0.a.e0.d.h("SwanAppPaymentManager", "doPolymerPay Qr Code: " + jSONObject.toString());
            } else {
                this.f8046h.i(this.f8039a.x(), jSONObject, strArr, new h(this, jSONObject2, jSONObject));
                c.a.o0.a.e0.d.h("SwanAppPaymentManager", "doPolymerPay: " + jSONObject.toString());
            }
            UnitedSchemeUtility.callCallback(this.f8041c, this.f8040b, UnitedSchemeUtility.wrapCallbackParams(0));
            if (this.f8039a.z() != null) {
                String valueOf = String.valueOf(this.f8039a.L().G());
                String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.f8039a.L().W()).get("_baiduboxapp"));
                Bundle bundle = new Bundle();
                bundle.putString("frameType", valueOf);
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f8039a.L().H());
                try {
                    bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
                } catch (UnsupportedEncodingException e3) {
                    if (f8038j) {
                        throw new RuntimeException("This method requires UTF-8 encoding support", e3);
                    }
                }
                this.f8039a.z().N(7, bundle);
            }
        }
    }

    public final void E(String str, String[] strArr, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, strArr, jSONObject) == null) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                c.a.o0.a.n1.q.c.d.b(jSONObject2.optString("appKey"), new f(this, jSONObject2, strArr, jSONObject, str));
            } catch (JSONException e2) {
                L();
                c.a.o0.a.e0.d.h("SwanAppPaymentManager", " doPolymerPayChecked error " + str);
                if (c.a.o0.a.k.f7049a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void F(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            c.a.o0.a.c1.b.e().a(str, new e(this, str, strArr, jSONObject, z, z2));
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
                if (f8038j) {
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
            boolean e2 = this.f8039a.j().e(this.f8039a.x());
            if (!e2) {
                k.M("show", 8, str2);
            }
            if (TextUtils.isEmpty(str)) {
                this.f8040b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString2 = jSONObject.optString("__plugin__");
            c.a.o0.a.t1.d.a.a("start payment");
            if (!TextUtils.isEmpty(optString2) && (opt = jSONObject.opt("error")) != null) {
                String optString3 = jSONObject.optString("slaveId");
                c.a.o0.a.t1.c.c.a aVar = new c.a.o0.a.t1.c.c.a(jSONObject.optString("componentId"));
                aVar.f8647a = optString3;
                aVar.f8649c = opt;
                aVar.f8650d = false;
                aVar.f8651e = null;
                aVar.b();
                c.a.o0.a.e0.d.h("SwanAppPaymentManager", "Error: param check error - plugin pay contains custom error");
                k.D(false, "nuomi", c.a.o0.a.q1.a.c("", "param check error - plugin pay contains custom error"));
                this.f8040b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
            if (this.f8039a.x() == null) {
                this.f8044f = 5;
                this.f8045g = null;
                K(null);
                if (f8038j) {
                    throw new RuntimeException("swanApp getActivity returns null");
                }
                return true;
            } else if (this.f8039a.j().e(this.f8039a.k())) {
                if (this.f8039a.m0()) {
                    F(str, strArr, jSONObject, true, true);
                    return true;
                }
                C(str, strArr, jSONObject, true, true);
                return true;
            } else {
                this.f8039a.j().f(this.f8039a.k(), null, new d(this, str2, str, strArr, jSONObject, e2));
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void J(int i2, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), str, jSONObject, jSONObject2}) == null) {
            c.a.o0.a.g1.f.V().b();
            c.a.o0.a.e0.d.g("SwanAppPaymentManager", "sendSecondCallback statusCode: " + this.f8044f + " params: " + this.f8045g + " payParams: " + jSONObject.toString() + " orderId: " + jSONObject2.optString("tpOrderId"));
            M(i2, "nuomi", G(str, jSONObject2));
            this.f8044f = i2;
            this.f8045g = str;
            if (i2 != 1) {
                k.F("nuomi", "result", i2);
            }
            K(null);
            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
                String optString = jSONObject.optString("slaveId");
                String optString2 = jSONObject.optString("componentId");
                Object opt = jSONObject.opt("error");
                c.a.o0.a.t1.c.c.a aVar = new c.a.o0.a.t1.c.c.a(optString2);
                aVar.f8647a = optString;
                aVar.f8649c = opt;
                aVar.f8650d = i2 == 0;
                aVar.f8651e = str;
                aVar.b();
                c.a.o0.a.t1.g.b.j();
            }
            if (this.f8044f != 0 || c.a.o0.a.x1.c.f9677c.c()) {
                return;
            }
            c.a.o0.a.x1.c.f9677c.e();
        }
    }

    public final void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            try {
                if (TextUtils.equals(this.f8042d, "2.0")) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("payId", str);
                    if (!TextUtils.isEmpty(this.f8045g)) {
                        jSONObject.put("payResult", Base64.encodeToString(this.f8045g.getBytes("UTF-8"), 2));
                    }
                    c.a.o0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, data = " + jSONObject + " status code = " + this.f8044f);
                    this.f8041c.handleSchemeDispatchCallback(this.f8047i, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.f8044f, H(this.f8044f)).toString());
                    return;
                }
                c.a.o0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, result = " + this.f8045g + " status code = " + this.f8044f);
                this.f8041c.handleSchemeDispatchCallback(this.f8047i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.f8045g, this.f8044f, H(this.f8044f)).toString());
            } catch (UnsupportedEncodingException | JSONException e2) {
                c.a.o0.a.e0.d.g("SwanAppPaymentManager", "Fail: sendSecondCallback exception , exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace()));
                CallbackHandler callbackHandler = this.f8041c;
                String str2 = this.f8047i;
                int i2 = this.f8044f;
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i2, H(i2)).toString());
            }
        }
    }

    public final void L() {
        c.a.o0.a.a2.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (eVar = this.f8039a) == null) {
            return;
        }
        c.a.o0.a.z1.b.f.e.f(eVar.x(), c.a.o0.a.h.swanapp_payment_illegal).F();
        if (TextUtils.isEmpty(this.f8047i)) {
            return;
        }
        this.f8041c.handleSchemeDispatchCallback(this.f8047i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f8039a.x().getString(c.a.o0.a.h.swanapp_payment_illegal)).toString());
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
            c.a.o0.a.e0.d.g("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
            if (c.a.o0.a.q1.a.b().e(this.f8039a, this.f8041c, this.f8040b)) {
                this.f8044f = 0;
                this.f8045g = null;
                if (TextUtils.equals(this.f8042d, "2.0")) {
                    c.a.o0.a.c1.a.R().e(this.f8043e, this);
                } else {
                    K(null);
                }
                k.C("wechatH5Action", null, null);
                return true;
            }
            c.a.o0.a.e0.d.h("SwanAppPaymentManager", "Error: open webview error.  entity = " + this.f8040b.toString());
            this.f8041c.handleSchemeDispatchCallback(this.f8047i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.o0.a.x1.a
    public void a(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) {
            c.a.o0.a.e0.d.b("SwanAppPaymentManager", "Info: getPayId Request Response =  " + jSONObject.toString());
            if (jSONObject.optInt("errno") == 0) {
                str = jSONObject.optJSONObject("data").optString("payid");
                c.a.o0.a.e0.d.b("SwanAppPaymentManager", "Info: payId =  " + str);
            } else {
                str = null;
            }
            K(str);
            if (c.a.o0.a.x1.c.f9677c.c()) {
                return;
            }
            if (c.a.o0.a.c1.a.a0().e(this.f8039a)) {
                c.a.o0.a.x1.c.f9677c.e();
            } else {
                c.a.o0.a.x1.c.f9677c.f();
            }
        }
    }

    @Override // c.a.o0.a.x1.a
    public void onFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            c.a.o0.a.e0.d.b("SwanAppPaymentManager", "Fail: request payId failed");
            c.a.o0.a.e0.d.b("SwanAppPaymentManager", str);
            K(null);
        }
    }

    public final JSONObject w(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, jSONObject)) == null) {
            if (this.f8039a.m0() && jSONObject != null) {
                b.a L = this.f8039a.L();
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
                        if (f8038j) {
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
            if (f8038j) {
                String str2 = "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT orderInfo: " + str;
            }
            k.F(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "intoPayment", 0);
            this.f8046h.c(this.f8039a.k(), str, new c(this));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void y(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, jSONObject, str) == null) {
            PMSAppInfo s = c.a.o0.n.g.a.h().s(str);
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
            if (this.f8039a.j().e(this.f8039a.k())) {
                B(str);
                return true;
            }
            c.a.o0.a.a2.e eVar = this.f8039a;
            if (eVar == null) {
                return false;
            }
            boolean e2 = eVar.j().e(this.f8039a.x());
            if (!e2) {
                k.M("show", 9, str2);
            }
            this.f8039a.j().f(this.f8039a.k(), null, new a(this, e2, str2, str));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
