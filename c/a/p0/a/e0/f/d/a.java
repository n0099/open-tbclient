package c.a.p0.a.e0.f.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f1.e.c;
import c.a.p0.a.f2.f.z;
import c.a.p0.a.p.d.n;
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
    public static Set<String> f4671f;

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f4672g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f4673c;

    /* renamed from: d  reason: collision with root package name */
    public int f4674d;

    /* renamed from: e  reason: collision with root package name */
    public c f4675e;

    /* renamed from: c.a.p0.a.e0.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0205a implements n.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4676b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4677c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f4678d;

        public C0205a(a aVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
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
            this.f4678d = aVar;
            this.a = context;
            this.f4676b = unitedSchemeEntity;
            this.f4677c = callbackHandler;
        }

        @Override // c.a.p0.a.p.d.n.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    c.a.p0.a.e0.d.c("LocalDebugAction", "Authentication Success");
                    a.f4672g.add(this.f4678d.o(this.a));
                    this.f4678d.p(this.a, this.f4676b, this.f4677c);
                    return;
                }
                c.a.p0.a.e0.d.c("LocalDebugAction", "Authentication Fail : Not developer");
                this.f4678d.w(this.a, this.f4676b, 401);
            }
        }

        @Override // c.a.p0.a.p.d.n.b
        public void b(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                c.a.p0.a.e0.d.d("LocalDebugAction", "onFail : Authentication exception :", exc);
                this.f4678d.w(this.a, this.f4676b, 401);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4679e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4680f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f4681g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4682h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4683i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f4684j;

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
            this.f4684j = aVar;
            this.f4679e = context;
            this.f4680f = str;
            this.f4681g = file;
            this.f4682h = unitedSchemeEntity;
            this.f4683i = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4684j.x(this.f4679e, this.f4680f, this.f4681g, this.f4682h, this.f4683i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1902575259, "Lc/a/p0/a/e0/f/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1902575259, "Lc/a/p0/a/e0/f/d/a;");
                return;
            }
        }
        f4672g = new HashSet();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.p0.a.f2.e eVar) {
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

    @Override // c.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (!t()) {
                c.a.p0.a.e0.d.c("LocalDebugAction", "switch is off");
                w(context, unitedSchemeEntity, 1003);
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                this.f4675e = c.c(optParamsAsJo);
                if (c.a.p0.a.q2.b.e(0).swanCoreVersionCode < this.f4675e.f4694h) {
                    c.a.p0.a.e0.d.c("LocalDebugAction", "swan js version is low");
                    w(context, unitedSchemeEntity, 1002);
                    return false;
                } else if (!u()) {
                    c.a.p0.a.e0.d.c("LocalDebugAction", "debug model invalid");
                    w(context, unitedSchemeEntity, 202);
                    return false;
                } else if (!SwanAppAllianceLoginHelper.f39311d.f() && !s().contains(c.a.p0.a.c1.a.h0().h(context)) && !f4672g.contains(o(context))) {
                    c.a.p0.a.m.b.b(this.f4675e.f4688b, new C0205a(this, context, unitedSchemeEntity, callbackHandler));
                    return true;
                } else {
                    p(context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
            }
            c.a.p0.a.e0.d.c("LocalDebugAction", "param is null");
            w(context, unitedSchemeEntity, 202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final String o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return c.a.p0.a.c1.a.h0().h(context) + this.f4675e.f4688b;
        }
        return (String) invokeL.objValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler) == null) {
            File b2 = c.a.p0.a.e0.f.d.b.b();
            if (b2.exists()) {
                boolean L = c.a.p0.w.d.L(b2);
                c.a.p0.a.e0.d.i("LocalDebugAction", "debug bundle delete: " + L);
            }
            if (c.a.p0.a.e0.f.d.b.g()) {
                boolean L2 = c.a.p0.w.d.L(c.a.p0.a.e0.f.d.b.d());
                c.a.p0.a.e0.d.i("LocalDebugAction", "unzip folder delete: " + L2);
            }
            this.f4673c = Executors.newFixedThreadPool(4);
            this.f4674d = 0;
            d.e().f("downloadstart");
            for (int i2 = 0; i2 < this.f4675e.f4689c.length(); i2++) {
                String a = this.f4675e.a(i2);
                if (TextUtils.isEmpty(a)) {
                    int i3 = this.f4674d + 1;
                    this.f4674d = i3;
                    if (i3 >= this.f4675e.f4689c.length()) {
                        c.a.p0.a.e0.d.c("LocalDebugAction", "IPs are invalid");
                        w(context, unitedSchemeEntity, 202);
                        d.e().f("downloadfail");
                    }
                } else {
                    this.f4673c.execute(new b(this, context, a, b2, unitedSchemeEntity, callbackHandler));
                }
            }
        }
    }

    public final void q() {
        c.a.p0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (a0 = c.a.p0.a.d2.e.a0()) == null) {
            return;
        }
        c.a.p0.a.z2.f.j(a0.x());
        System.exit(0);
    }

    public final String r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                boolean z = z.f5296b;
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final Set<String> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (f4671f == null) {
                f4671f = new HashSet();
                c.a.p0.q.a b2 = c.a.p0.q.c.b();
                String string = b2 != null ? b2.i().getString("auth_white_list", "") : "";
                JSONArray jSONArray = null;
                try {
                    jSONArray = new JSONArray(string);
                } catch (JSONException unused) {
                    boolean z = z.f5296b;
                }
                if (jSONArray != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        f4671f.add(jSONArray.optString(i2));
                    }
                }
            }
            return f4671f;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (TextUtils.isEmpty(this.f4675e.a) || TextUtils.isEmpty(this.f4675e.f4688b) || (jSONArray = this.f4675e.f4689c) == null || jSONArray.length() <= 0 || TextUtils.isEmpty(this.f4675e.f4690d)) ? false : true : invokeV.booleanValue;
    }

    public final c.a v(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, unitedSchemeEntity)) == null) {
            String uri = (unitedSchemeEntity == null || unitedSchemeEntity.getUri() == null) ? "" : unitedSchemeEntity.getUri().toString();
            c.a.p0.a.e0.d.i("LocalDebugAction", "local debug scheme = " + uri);
            return (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().v0(this.f4675e.f4688b)).A0(false)).L0(true)).M0(this.f4675e.f4691e)).N0(this.f4675e.f4692f)).K0(uri)).P0(this.f4675e.f4693g);
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
                c.a.p0.a.c2.b.f.e.g(context, "IPs are invalid ：" + i2).G();
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
        if (r6 >= r4.f4675e.f4689c.length()) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x(Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048586, this, context, str, file, unitedSchemeEntity, callbackHandler) == null) {
            try {
                Response executeSync = c.a.p0.p.e.a.g().getRequest().url(this.f4675e.b(str)).connectionTimeout(3000).build().executeSync();
                if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                    boolean a = c.a.p0.w.g.a(executeSync.body().byteStream(), file);
                    c.a.p0.a.e0.d.i("LocalDebugAction", "save debug bundle: " + a);
                    d.e().f("downloadsuccess");
                    this.f4675e.f4691e = str;
                    context.startActivity(c.a.p0.a.f1.e.c.g1(context, v(unitedSchemeEntity)));
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.f4673c != null) {
                        this.f4673c.shutdownNow();
                        this.f4673c = null;
                    }
                    if (!ProcessUtils.isMainProcess()) {
                        boolean z = z.f5296b;
                        q();
                    }
                }
                if (executeSync != null) {
                    executeSync.close();
                }
            } catch (IOException unused) {
                synchronized (this) {
                    if (this.f4675e.f4689c != null) {
                        int i2 = this.f4674d + 1;
                        this.f4674d = i2;
                    }
                    c.a.p0.a.e0.d.c("LocalDebugAction", "Host IPs are invalid");
                    w(context, unitedSchemeEntity, 1001);
                    d.e().f("downloadfail");
                }
            }
        }
    }
}
