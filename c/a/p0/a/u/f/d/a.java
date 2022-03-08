package c.a.p0.a.u.f.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f.d.n;
import c.a.p0.a.v0.e.c;
import c.a.p0.a.v1.f.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends z {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static Set<String> f7564f;

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f7565g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f7566c;

    /* renamed from: d  reason: collision with root package name */
    public int f7567d;

    /* renamed from: e  reason: collision with root package name */
    public c f7568e;

    /* renamed from: c.a.p0.a.u.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0472a implements n.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7569b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7570c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f7571d;

        public C0472a(a aVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7571d = aVar;
            this.a = context;
            this.f7569b = unitedSchemeEntity;
            this.f7570c = callbackHandler;
        }

        @Override // c.a.p0.a.f.d.n.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    c.a.p0.a.u.d.c("LocalDebugAction", "Authentication Success");
                    a.f7565g.add(this.f7571d.o(this.a));
                    this.f7571d.p(this.a, this.f7569b, this.f7570c);
                    return;
                }
                c.a.p0.a.u.d.c("LocalDebugAction", "Authentication Fail : Not developer");
                this.f7571d.w(this.a, this.f7569b, 401);
            }
        }

        @Override // c.a.p0.a.f.d.n.b
        public void b(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                c.a.p0.a.u.d.d("LocalDebugAction", "onFail : Authentication exception :", exc);
                this.f7571d.w(this.a, this.f7569b, 401);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f7572e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7573f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f7574g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7575h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7576i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f7577j;

        public b(a aVar, Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, str, file, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7577j = aVar;
            this.f7572e = context;
            this.f7573f = str;
            this.f7574g = file;
            this.f7575h = unitedSchemeEntity;
            this.f7576i = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7577j.x(this.f7572e, this.f7573f, this.f7574g, this.f7575h, this.f7576i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1151802463, "Lc/a/p0/a/u/f/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1151802463, "Lc/a/p0/a/u/f/d/a;");
                return;
            }
        }
        f7565g = new HashSet();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.p0.a.v1.e eVar) {
        super(eVar, "/swanAPI/localdebuglaunch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (!t()) {
                c.a.p0.a.u.d.c("LocalDebugAction", "switch is off");
                w(context, unitedSchemeEntity, 1003);
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                this.f7568e = c.c(optParamsAsJo);
                if (c.a.p0.a.g2.b.e(0).swanCoreVersionCode < this.f7568e.f7587h) {
                    c.a.p0.a.u.d.c("LocalDebugAction", "swan js version is low");
                    w(context, unitedSchemeEntity, 1002);
                    return false;
                } else if (!u()) {
                    c.a.p0.a.u.d.c("LocalDebugAction", "debug model invalid");
                    w(context, unitedSchemeEntity, 202);
                    return false;
                } else if (!SwanAppAllianceLoginHelper.f37293d.f() && !s().contains(c.a.p0.a.s0.a.h0().h(context)) && !f7565g.contains(o(context))) {
                    c.a.p0.a.c.b.b(this.f7568e.f7581b, new C0472a(this, context, unitedSchemeEntity, callbackHandler));
                    return true;
                } else {
                    p(context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
            }
            c.a.p0.a.u.d.c("LocalDebugAction", "param is null");
            w(context, unitedSchemeEntity, 202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final String o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return c.a.p0.a.s0.a.h0().h(context) + this.f7568e.f7581b;
        }
        return (String) invokeL.objValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler) == null) {
            File b2 = c.a.p0.a.u.f.d.b.b();
            if (b2.exists()) {
                boolean L = c.a.p0.w.d.L(b2);
                c.a.p0.a.u.d.i("LocalDebugAction", "debug bundle delete: " + L);
            }
            if (c.a.p0.a.u.f.d.b.g()) {
                boolean L2 = c.a.p0.w.d.L(c.a.p0.a.u.f.d.b.d());
                c.a.p0.a.u.d.i("LocalDebugAction", "unzip folder delete: " + L2);
            }
            this.f7566c = Executors.newFixedThreadPool(4);
            this.f7567d = 0;
            d.e().f("downloadstart");
            for (int i2 = 0; i2 < this.f7568e.f7582c.length(); i2++) {
                String a = this.f7568e.a(i2);
                if (TextUtils.isEmpty(a)) {
                    int i3 = this.f7567d + 1;
                    this.f7567d = i3;
                    if (i3 >= this.f7568e.f7582c.length()) {
                        c.a.p0.a.u.d.c("LocalDebugAction", "IPs are invalid");
                        w(context, unitedSchemeEntity, 202);
                        d.e().f("downloadfail");
                    }
                } else {
                    this.f7566c.execute(new b(this, context, a, b2, unitedSchemeEntity, callbackHandler));
                }
            }
        }
    }

    public final void q() {
        c.a.p0.a.t1.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (a0 = c.a.p0.a.t1.e.a0()) == null) {
            return;
        }
        c.a.p0.a.p2.f.j(a0.x());
        System.exit(0);
    }

    public final String r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                boolean z = z.f8176b;
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final Set<String> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (f7564f == null) {
                f7564f = new HashSet();
                c.a.p0.q.a b2 = c.a.p0.q.c.b();
                String string = b2 != null ? b2.i().getString("auth_white_list", "") : "";
                JSONArray jSONArray = null;
                try {
                    jSONArray = new JSONArray(string);
                } catch (JSONException unused) {
                    boolean z = z.f8176b;
                }
                if (jSONArray != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        f7564f.add(jSONArray.optString(i2));
                    }
                }
            }
            return f7564f;
        }
        return (Set) invokeV.objValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.p0.q.a b2 = c.a.p0.q.c.b();
            return TextUtils.equals(b2 != null ? b2.i().getString("enable_local_debug_switch", "1") : "1", "1");
        }
        return invokeV.booleanValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (TextUtils.isEmpty(this.f7568e.a) || TextUtils.isEmpty(this.f7568e.f7581b) || (jSONArray = this.f7568e.f7582c) == null || jSONArray.length() <= 0 || TextUtils.isEmpty(this.f7568e.f7583d)) ? false : true : invokeV.booleanValue;
    }

    public final c.a v(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, unitedSchemeEntity)) == null) {
            String uri = (unitedSchemeEntity == null || unitedSchemeEntity.getUri() == null) ? "" : unitedSchemeEntity.getUri().toString();
            c.a.p0.a.u.d.i("LocalDebugAction", "local debug scheme = " + uri);
            return (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().v0(this.f7568e.f7581b)).A0(false)).L0(true)).M0(this.f7568e.f7584e)).N0(this.f7568e.f7585f)).K0(uri)).P0(this.f7568e.f7586g);
        }
        return (c.a) invokeL.objValue;
    }

    public final void w(Context context, UnitedSchemeEntity unitedSchemeEntity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048585, this, context, unitedSchemeEntity, i2) == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(i2);
            c.a.p0.q.a b2 = c.a.p0.q.c.b();
            String string = b2 != null ? b2.i().getString("error_url", "") : "";
            if (TextUtils.isEmpty(string)) {
                c.a.p0.a.s1.b.f.e.g(context, "IPs are invalid ：" + i2).G();
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(SchemeConfig.getSchemeHead());
            sb.append("://v1/easybrowse/open?url=");
            sb.append(r(string + "?" + i2));
            SchemeRouter.invoke(context, sb.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bb, code lost:
        if (r6 >= r4.f7568e.f7582c.length()) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x(Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048586, this, context, str, file, unitedSchemeEntity, callbackHandler) == null) {
            try {
                Response executeSync = c.a.p0.p.e.a.g().getRequest().url(this.f7568e.b(str)).connectionTimeout(3000).build().executeSync();
                if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                    boolean a = c.a.p0.w.g.a(executeSync.body().byteStream(), file);
                    c.a.p0.a.u.d.i("LocalDebugAction", "save debug bundle: " + a);
                    d.e().f("downloadsuccess");
                    this.f7568e.f7584e = str;
                    context.startActivity(c.a.p0.a.v0.e.c.g1(context, v(unitedSchemeEntity)));
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.f7566c != null) {
                        this.f7566c.shutdownNow();
                        this.f7566c = null;
                    }
                    if (!ProcessUtils.isMainProcess()) {
                        boolean z = z.f8176b;
                        q();
                    }
                }
                if (executeSync != null) {
                    executeSync.close();
                }
            } catch (IOException unused) {
                synchronized (this) {
                    if (this.f7568e.f7582c != null) {
                        int i2 = this.f7567d + 1;
                        this.f7567d = i2;
                    }
                    c.a.p0.a.u.d.c("LocalDebugAction", "Host IPs are invalid");
                    w(context, unitedSchemeEntity, 1001);
                    d.e().f("downloadfail");
                }
            }
        }
    }
}
