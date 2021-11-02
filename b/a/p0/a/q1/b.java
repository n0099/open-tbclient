package b.a.p0.a.q1;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.j2.k;
import b.a.p0.a.l;
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
public class b implements b.a.p0.a.q1.g.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public static String[] k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.a.a2.e f7364a;

    /* renamed from: b  reason: collision with root package name */
    public UnitedSchemeEntity f7365b;

    /* renamed from: c  reason: collision with root package name */
    public CallbackHandler f7366c;

    /* renamed from: d  reason: collision with root package name */
    public String f7367d;

    /* renamed from: e  reason: collision with root package name */
    public String f7368e;

    /* renamed from: f  reason: collision with root package name */
    public int f7369f;

    /* renamed from: g  reason: collision with root package name */
    public String f7370g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.d0.a f7371h;

    /* renamed from: i  reason: collision with root package name */
    public String f7372i;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f7373e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7374f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7375g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f7376h;

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
            this.f7376h = bVar;
            this.f7373e = z;
            this.f7374f = str;
            this.f7375g = str2;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    if (!this.f7373e) {
                        k.M("success", 9, this.f7374f);
                    }
                    this.f7376h.B(this.f7375g);
                    return;
                }
                if (!this.f7373e) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 9, this.f7374f);
                }
                this.f7376h.f7369f = 5;
                this.f7376h.f7370g = null;
                this.f7376h.K(null);
            }
        }
    }

    /* renamed from: b.a.p0.a.q1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0349b implements b.a.d0.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f7377a;

        public C0349b(b bVar) {
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
            this.f7377a = bVar;
        }

        @Override // b.a.d0.e.a
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f7377a.f7369f = i2;
                this.f7377a.f7370g = str;
                if (b.j) {
                    String str2 = "statusCode: " + i2 + " ,result:" + str;
                }
                this.f7377a.M(i2, "baiduqianbao", str);
                k.F("baiduqianbao", "result", i2);
                if (i2 != 0 || !TextUtils.equals(this.f7377a.f7367d, "2.0")) {
                    this.f7377a.K(null);
                } else {
                    b.a.p0.a.c1.a.R().e(this.f7377a.f7368e, this.f7377a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.d0.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f7378a;

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
            this.f7378a = bVar;
        }

        @Override // b.a.d0.e.a
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f7378a.f7369f = i2;
                this.f7378a.f7370g = str;
                b.a.p0.a.e0.d.h("SwanAppPaymentManager", "statusCode: " + this.f7378a.f7369f + " ,result:" + this.f7378a.f7370g);
                this.f7378a.M(i2, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, str);
                if (i2 != 1) {
                    k.F(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "result", i2);
                }
                if (i2 != 0 || !TextUtils.equals(this.f7378a.f7367d, "2.0")) {
                    this.f7378a.K(null);
                } else {
                    b.a.p0.a.c1.a.R().e(this.f7378a.f7368e, this.f7378a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7379e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7380f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String[] f7381g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7382h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f7383i;
        public final /* synthetic */ b j;

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
            this.j = bVar;
            this.f7379e = str;
            this.f7380f = str2;
            this.f7381g = strArr;
            this.f7382h = jSONObject;
            this.f7383i = z;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    k.M("success", 8, this.f7379e);
                    if (this.j.f7364a.l0()) {
                        this.j.F(this.f7380f, this.f7381g, this.f7382h, true, false);
                        return;
                    } else {
                        this.j.C(this.f7380f, this.f7381g, this.f7382h, true, false);
                        return;
                    }
                }
                if (!this.f7383i) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 8, this.f7379e);
                    b.a.p0.a.e0.d.h("SwanAppPaymentManager", "login error");
                    k.D(false, "nuomi", b.a.p0.a.q1.a.c("", "login error"));
                }
                this.j.f7369f = 5;
                this.j.f7370g = null;
                this.j.K(null);
                k.E("nuomi", false, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f7384a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f7385b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7386c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f7387d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f7388e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f7389f;

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
            this.f7389f = bVar;
            this.f7384a = str;
            this.f7385b = strArr;
            this.f7386c = jSONObject;
            this.f7387d = z;
            this.f7388e = z2;
        }

        @Override // b.a.p0.a.q1.b.j
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(this.f7389f.f7372i)) {
                return;
            }
            CallbackHandler callbackHandler = this.f7389f.f7366c;
            String str2 = this.f7389f.f7372i;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f7389f.f7364a.x().getString(b.a.p0.a.h.swan_game_anti_addiction) + str).toString());
        }

        @Override // b.a.p0.a.q1.b.j
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f7389f.C(this.f7384a, this.f7385b, this.f7386c, this.f7387d, this.f7388e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Function1<Boolean, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7390e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f7391f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7392g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7393h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f7394i;

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
            this.f7394i = bVar;
            this.f7390e = jSONObject;
            this.f7391f = strArr;
            this.f7392g = jSONObject2;
            this.f7393h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) {
                if (bool.booleanValue()) {
                    this.f7394i.D(this.f7390e, this.f7391f, this.f7392g);
                    return null;
                }
                b.a.p0.a.e0.d.h("SwanAppPaymentManager", "paykey invalid order info " + this.f7393h);
                k.D(false, "nuomi", b.a.p0.a.q1.a.c("", "paykey invalid"));
                this.f7394i.L();
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class g implements b.a.p0.a.q1.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7395a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7396b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f7397c;

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
            this.f7397c = bVar;
            this.f7395a = jSONObject;
            this.f7396b = jSONObject2;
        }

        @Override // b.a.p0.a.q1.d
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f7397c.J(i2, str, this.f7395a, this.f7396b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements b.a.d0.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7398a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7399b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f7400c;

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
            this.f7400c = bVar;
            this.f7398a = jSONObject;
            this.f7399b = jSONObject2;
        }

        @Override // b.a.d0.e.a
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f7400c.J(i2, str, this.f7398a, this.f7399b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7401e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7402f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7403g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f7404h;

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
            this.f7404h = bVar;
            this.f7401e = str;
            this.f7402f = str2;
            this.f7403g = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
            if (r10.equals("mapp_request_duxiaoman") != false) goto L37;
         */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCallback(b.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                char c2 = 0;
                if (!b.a.p0.a.e2.c.d.h(iVar)) {
                    String str = null;
                    if (TextUtils.equals(this.f7404h.f7367d, "2.0")) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("payId", "");
                        } catch (JSONException e2) {
                            if (b.j) {
                                e2.printStackTrace();
                            }
                        }
                        str = String.valueOf(jSONObject);
                    }
                    if (TextUtils.equals(this.f7401e, "mapp_request_duxiaoman")) {
                        k.D(false, "baiduqianbao", b.a.p0.a.q1.a.c("", "authorize fail"));
                    } else if (TextUtils.equals(this.f7401e, "mapp_request_alipayment")) {
                        k.D(false, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, b.a.p0.a.q1.a.c("", "authorize fail"));
                    } else if (TextUtils.equals(this.f7401e, "mapp_request_wechatpayment")) {
                        k.D(false, "wechatH5Action", b.a.p0.a.q1.a.c("", "authorize fail"));
                    }
                    b.a.p0.a.e0.d.h("SwanAppPaymentManager", "Error: authorized fail. scope = " + this.f7401e);
                    this.f7404h.f7366c.handleSchemeDispatchCallback(this.f7404h.f7372i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str, 1001, "authorize denied").toString());
                    return;
                }
                String str2 = this.f7401e;
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
                    this.f7404h.z(this.f7402f, this.f7403g);
                } else if (c2 == 1) {
                    this.f7404h.x(this.f7402f);
                } else if (c2 != 2) {
                } else {
                    this.f7404h.N();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1332907122, "Lb/a/p0/a/q1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1332907122, "Lb/a/p0/a/q1/b;");
                return;
            }
        }
        j = b.a.p0.a.k.f6397a;
        k = new String[]{"duershow"};
    }

    public b(b.a.p0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
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
        this.f7364a = eVar;
        this.f7365b = unitedSchemeEntity;
        this.f7366c = callbackHandler;
        this.f7367d = str;
        this.f7368e = str2;
        this.f7372i = str3;
        this.f7371h = new b.a.d0.a();
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
                this.f7365b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                b.a.p0.a.e0.d.h("SwanAppPaymentManager", "Error: order info is null.");
                return false;
            }
            this.f7364a.S().g(this.f7364a.x(), str, new i(this, str, str2, str3));
            UnitedSchemeUtility.callCallback(this.f7366c, this.f7365b, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            k.F("baiduqianbao", "intoPayment", 0);
            this.f7371h.d(this.f7364a.getActivity(), str, new C0349b(this));
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
                if (b.a.p0.a.s.a.f.f7771d.f()) {
                    jSONObject.put("openBduss", b.a.p0.a.c1.a.a0().d(b.a.p0.a.c1.a.b()));
                    jSONObject.put("clientId", b.a.p0.a.c1.a.m().b());
                } else {
                    jSONObject.put("bduss", b.a.p0.a.c1.a.a0().d(b.a.p0.a.c1.a.b()));
                }
                jSONObject.put("cuid", b.a.p0.a.c1.a.a0().i(b.a.p0.a.c1.a.b()));
                String optString = jSONObject.optString("bizInfo");
                JSONObject jSONObject3 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
                jSONObject3.put("swanFrom", this.f7364a.K().S());
                jSONObject3.put("cuid", b.a.p0.a.c1.a.a0().i(b.a.p0.a.c1.a.b()));
                jSONObject3.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, b.a.p0.a.a2.d.g().getAppId());
                w(jSONObject3);
                jSONObject.put("bizInfo", jSONObject3.toString());
                jSONObject.put("platformId", "100003");
                jSONObject.put("nativeAppId", b.a.p0.a.c1.a.m().a());
                jSONObject.put("sceneSource", "swan");
                jSONObject.put("swanNativeVersion", l.a());
                y(jSONObject, this.f7364a.k());
                if (j) {
                    jSONObject.toString();
                }
            } catch (JSONException e2) {
                if (b.a.p0.a.k.f6397a) {
                    e2.printStackTrace();
                }
            }
            b.a.p0.a.g1.f.T().o();
            String[] strArr2 = k;
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                } else if (strArr2[i2].equals(b.a.p0.a.c1.a.m().a())) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            k.F("nuomi", "intoPayment", 0);
            if (z) {
                String a2 = b.a.p0.t.i.a(b.a.p0.t.i.a("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject.toString())), "deviceType", "ANDROID");
                b.a.p0.a.h0.g.k.K2("qrCodePay", b.a.p0.a.l1.b.e(a2, a2));
                b.a.p0.a.q1.e.b(new g(this, jSONObject2, jSONObject));
                b.a.p0.a.e0.d.h("SwanAppPaymentManager", "doPolymerPay Qr Code: " + jSONObject.toString());
            } else {
                this.f7371h.i(this.f7364a.x(), jSONObject, strArr, new h(this, jSONObject2, jSONObject));
                b.a.p0.a.e0.d.h("SwanAppPaymentManager", "doPolymerPay: " + jSONObject.toString());
            }
            UnitedSchemeUtility.callCallback(this.f7366c, this.f7365b, UnitedSchemeUtility.wrapCallbackParams(0));
            if (this.f7364a.z() != null) {
                String valueOf = String.valueOf(this.f7364a.K().F());
                String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.f7364a.K().V()).get("_baiduboxapp"));
                Bundle bundle = new Bundle();
                bundle.putString("frameType", valueOf);
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f7364a.K().G());
                try {
                    bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
                } catch (UnsupportedEncodingException e3) {
                    if (j) {
                        throw new RuntimeException("This method requires UTF-8 encoding support", e3);
                    }
                }
                this.f7364a.z().N(7, bundle);
            }
        }
    }

    public final void E(String str, String[] strArr, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, strArr, jSONObject) == null) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                b.a.p0.a.n1.q.c.d.b(jSONObject2.optString("appKey"), new f(this, jSONObject2, strArr, jSONObject, str));
            } catch (JSONException e2) {
                L();
                b.a.p0.a.e0.d.h("SwanAppPaymentManager", " doPolymerPayChecked error " + str);
                if (b.a.p0.a.k.f6397a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void F(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            b.a.p0.a.c1.b.e().a(str, new e(this, str, strArr, jSONObject, z, z2));
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
                if (j) {
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
            boolean e2 = this.f7364a.j().e(this.f7364a.x());
            if (!e2) {
                k.M("show", 8, str2);
            }
            if (TextUtils.isEmpty(str)) {
                this.f7365b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString2 = jSONObject.optString("__plugin__");
            b.a.p0.a.t1.d.a.a("start payment");
            if (!TextUtils.isEmpty(optString2) && (opt = jSONObject.opt("error")) != null) {
                String optString3 = jSONObject.optString("slaveId");
                b.a.p0.a.t1.c.c.a aVar = new b.a.p0.a.t1.c.c.a(jSONObject.optString("componentId"));
                aVar.f7949a = optString3;
                aVar.f7951c = opt;
                aVar.f7952d = false;
                aVar.f7953e = null;
                aVar.b();
                b.a.p0.a.e0.d.h("SwanAppPaymentManager", "Error: param check error - plugin pay contains custom error");
                k.D(false, "nuomi", b.a.p0.a.q1.a.c("", "param check error - plugin pay contains custom error"));
                this.f7365b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
            if (this.f7364a.x() == null) {
                this.f7369f = 5;
                this.f7370g = null;
                K(null);
                if (j) {
                    throw new RuntimeException("swanApp getActivity returns null");
                }
                return true;
            } else if (this.f7364a.j().e(this.f7364a.getActivity())) {
                if (this.f7364a.l0()) {
                    F(str, strArr, jSONObject, true, true);
                    return true;
                }
                C(str, strArr, jSONObject, true, true);
                return true;
            } else {
                this.f7364a.j().f(this.f7364a.getActivity(), null, new d(this, str2, str, strArr, jSONObject, e2));
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void J(int i2, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), str, jSONObject, jSONObject2}) == null) {
            b.a.p0.a.g1.f.T().b();
            b.a.p0.a.e0.d.g("SwanAppPaymentManager", "sendSecondCallback statusCode: " + this.f7369f + " params: " + this.f7370g + " payParams: " + jSONObject.toString() + " orderId: " + jSONObject2.optString("tpOrderId"));
            M(i2, "nuomi", G(str, jSONObject2));
            this.f7369f = i2;
            this.f7370g = str;
            if (i2 != 1) {
                k.F("nuomi", "result", i2);
            }
            K(null);
            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
                String optString = jSONObject.optString("slaveId");
                String optString2 = jSONObject.optString("componentId");
                Object opt = jSONObject.opt("error");
                b.a.p0.a.t1.c.c.a aVar = new b.a.p0.a.t1.c.c.a(optString2);
                aVar.f7949a = optString;
                aVar.f7951c = opt;
                aVar.f7952d = i2 == 0;
                aVar.f7953e = str;
                aVar.b();
                b.a.p0.a.t1.g.b.j();
            }
            if (this.f7369f != 0 || b.a.p0.a.x1.c.f8949c.c()) {
                return;
            }
            b.a.p0.a.x1.c.f8949c.e();
        }
    }

    public final void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            try {
                if (TextUtils.equals(this.f7367d, "2.0")) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("payId", str);
                    if (!TextUtils.isEmpty(this.f7370g)) {
                        jSONObject.put("payResult", Base64.encodeToString(this.f7370g.getBytes("UTF-8"), 2));
                    }
                    b.a.p0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, data = " + jSONObject + " status code = " + this.f7369f);
                    this.f7366c.handleSchemeDispatchCallback(this.f7372i, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.f7369f, H(this.f7369f)).toString());
                    return;
                }
                b.a.p0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, result = " + this.f7370g + " status code = " + this.f7369f);
                this.f7366c.handleSchemeDispatchCallback(this.f7372i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.f7370g, this.f7369f, H(this.f7369f)).toString());
            } catch (UnsupportedEncodingException | JSONException e2) {
                b.a.p0.a.e0.d.g("SwanAppPaymentManager", "Fail: sendSecondCallback exception , exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace()));
                CallbackHandler callbackHandler = this.f7366c;
                String str2 = this.f7372i;
                int i2 = this.f7369f;
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i2, H(i2)).toString());
            }
        }
    }

    public final void L() {
        b.a.p0.a.a2.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (eVar = this.f7364a) == null) {
            return;
        }
        b.a.p0.a.z1.b.f.e.f(eVar.x(), b.a.p0.a.h.swanapp_payment_illegal).F();
        if (TextUtils.isEmpty(this.f7372i)) {
            return;
        }
        this.f7366c.handleSchemeDispatchCallback(this.f7372i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f7364a.x().getString(b.a.p0.a.h.swanapp_payment_illegal)).toString());
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
            b.a.p0.a.e0.d.g("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
            if (b.a.p0.a.q1.a.b().e(this.f7364a, this.f7366c, this.f7365b)) {
                this.f7369f = 0;
                this.f7370g = null;
                if (TextUtils.equals(this.f7367d, "2.0")) {
                    b.a.p0.a.c1.a.R().e(this.f7368e, this);
                } else {
                    K(null);
                }
                k.C("wechatH5Action", null, null);
                return true;
            }
            b.a.p0.a.e0.d.h("SwanAppPaymentManager", "Error: open webview error.  entity = " + this.f7365b.toString());
            this.f7366c.handleSchemeDispatchCallback(this.f7372i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.x1.a
    public void a(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) {
            b.a.p0.a.e0.d.b("SwanAppPaymentManager", "Info: getPayId Request Response =  " + jSONObject.toString());
            if (jSONObject.optInt("errno") == 0) {
                str = jSONObject.optJSONObject("data").optString("payid");
                b.a.p0.a.e0.d.b("SwanAppPaymentManager", "Info: payId =  " + str);
            } else {
                str = null;
            }
            K(str);
            if (b.a.p0.a.x1.c.f8949c.c()) {
                return;
            }
            if (b.a.p0.a.c1.a.a0().e(this.f7364a)) {
                b.a.p0.a.x1.c.f8949c.e();
            } else {
                b.a.p0.a.x1.c.f8949c.f();
            }
        }
    }

    @Override // b.a.p0.a.x1.a
    public void onFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            b.a.p0.a.e0.d.b("SwanAppPaymentManager", "Fail: request payId failed");
            b.a.p0.a.e0.d.b("SwanAppPaymentManager", str);
            K(null);
        }
    }

    public final JSONObject w(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, jSONObject)) == null) {
            if (this.f7364a.l0() && jSONObject != null) {
                b.a K = this.f7364a.K();
                if (K.L() == null) {
                    return jSONObject;
                }
                JSONObject L = K.L();
                String optString = L.optString(TiebaStatic.Params.LOGID);
                String optString2 = L.optString("module_id");
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
        return (JSONObject) invokeL.objValue;
    }

    public final boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (j) {
                String str2 = "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT orderInfo: " + str;
            }
            k.F(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "intoPayment", 0);
            this.f7371h.c(this.f7364a.getActivity(), str, new c(this));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void y(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, jSONObject, str) == null) {
            PMSAppInfo s = b.a.p0.n.g.a.h().s(str);
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
            if (this.f7364a.j().e(this.f7364a.getActivity())) {
                B(str);
                return true;
            }
            b.a.p0.a.a2.e eVar = this.f7364a;
            if (eVar == null) {
                return false;
            }
            boolean e2 = eVar.j().e(this.f7364a.x());
            if (!e2) {
                k.M("show", 9, str2);
            }
            this.f7364a.j().f(this.f7364a.getActivity(), null, new a(this, e2, str2, str));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
