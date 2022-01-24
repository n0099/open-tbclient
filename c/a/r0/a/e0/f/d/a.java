package c.a.r0.a.e0.f.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.f1.e.c;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.p.d.n;
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
    public static Set<String> f5731f;

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f5732g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f5733c;

    /* renamed from: d  reason: collision with root package name */
    public int f5734d;

    /* renamed from: e  reason: collision with root package name */
    public c f5735e;

    /* renamed from: c.a.r0.a.e0.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0307a implements n.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5736b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5737c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f5738d;

        public C0307a(a aVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
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
            this.f5738d = aVar;
            this.a = context;
            this.f5736b = unitedSchemeEntity;
            this.f5737c = callbackHandler;
        }

        @Override // c.a.r0.a.p.d.n.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    c.a.r0.a.e0.d.c("LocalDebugAction", "Authentication Success");
                    a.f5732g.add(this.f5738d.o(this.a));
                    this.f5738d.p(this.a, this.f5736b, this.f5737c);
                    return;
                }
                c.a.r0.a.e0.d.c("LocalDebugAction", "Authentication Fail : Not developer");
                this.f5738d.w(this.a, this.f5736b, 401);
            }
        }

        @Override // c.a.r0.a.p.d.n.b
        public void b(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                c.a.r0.a.e0.d.d("LocalDebugAction", "onFail : Authentication exception :", exc);
                this.f5738d.w(this.a, this.f5736b, 401);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f5739e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5740f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f5741g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5742h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5743i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f5744j;

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
            this.f5744j = aVar;
            this.f5739e = context;
            this.f5740f = str;
            this.f5741g = file;
            this.f5742h = unitedSchemeEntity;
            this.f5743i = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5744j.x(this.f5739e, this.f5740f, this.f5741g, this.f5742h, this.f5743i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(891458009, "Lc/a/r0/a/e0/f/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(891458009, "Lc/a/r0/a/e0/f/d/a;");
                return;
            }
        }
        f5732g = new HashSet();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.r0.a.f2.e eVar) {
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

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (!t()) {
                c.a.r0.a.e0.d.c("LocalDebugAction", "switch is off");
                w(context, unitedSchemeEntity, 1003);
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                this.f5735e = c.c(optParamsAsJo);
                if (c.a.r0.a.q2.b.e(0).swanCoreVersionCode < this.f5735e.f5754h) {
                    c.a.r0.a.e0.d.c("LocalDebugAction", "swan js version is low");
                    w(context, unitedSchemeEntity, 1002);
                    return false;
                } else if (!u()) {
                    c.a.r0.a.e0.d.c("LocalDebugAction", "debug model invalid");
                    w(context, unitedSchemeEntity, 202);
                    return false;
                } else if (!SwanAppAllianceLoginHelper.f38661d.f() && !s().contains(c.a.r0.a.c1.a.h0().h(context)) && !f5732g.contains(o(context))) {
                    c.a.r0.a.m.b.b(this.f5735e.f5748b, new C0307a(this, context, unitedSchemeEntity, callbackHandler));
                    return true;
                } else {
                    p(context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
            }
            c.a.r0.a.e0.d.c("LocalDebugAction", "param is null");
            w(context, unitedSchemeEntity, 202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final String o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return c.a.r0.a.c1.a.h0().h(context) + this.f5735e.f5748b;
        }
        return (String) invokeL.objValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler) == null) {
            File b2 = c.a.r0.a.e0.f.d.b.b();
            if (b2.exists()) {
                boolean L = c.a.r0.w.d.L(b2);
                c.a.r0.a.e0.d.i("LocalDebugAction", "debug bundle delete: " + L);
            }
            if (c.a.r0.a.e0.f.d.b.g()) {
                boolean L2 = c.a.r0.w.d.L(c.a.r0.a.e0.f.d.b.d());
                c.a.r0.a.e0.d.i("LocalDebugAction", "unzip folder delete: " + L2);
            }
            this.f5733c = Executors.newFixedThreadPool(4);
            this.f5734d = 0;
            d.e().f("downloadstart");
            for (int i2 = 0; i2 < this.f5735e.f5749c.length(); i2++) {
                String a = this.f5735e.a(i2);
                if (TextUtils.isEmpty(a)) {
                    int i3 = this.f5734d + 1;
                    this.f5734d = i3;
                    if (i3 >= this.f5735e.f5749c.length()) {
                        c.a.r0.a.e0.d.c("LocalDebugAction", "IPs are invalid");
                        w(context, unitedSchemeEntity, 202);
                        d.e().f("downloadfail");
                    }
                } else {
                    this.f5733c.execute(new b(this, context, a, b2, unitedSchemeEntity, callbackHandler));
                }
            }
        }
    }

    public final void q() {
        c.a.r0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (a0 = c.a.r0.a.d2.e.a0()) == null) {
            return;
        }
        c.a.r0.a.z2.f.j(a0.x());
        System.exit(0);
    }

    public final String r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                boolean z = z.f6343b;
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final Set<String> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (f5731f == null) {
                f5731f = new HashSet();
                c.a.r0.q.a b2 = c.a.r0.q.c.b();
                String string = b2 != null ? b2.i().getString("auth_white_list", "") : "";
                JSONArray jSONArray = null;
                try {
                    jSONArray = new JSONArray(string);
                } catch (JSONException unused) {
                    boolean z = z.f6343b;
                }
                if (jSONArray != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        f5731f.add(jSONArray.optString(i2));
                    }
                }
            }
            return f5731f;
        }
        return (Set) invokeV.objValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.r0.q.a b2 = c.a.r0.q.c.b();
            return TextUtils.equals(b2 != null ? b2.i().getString("enable_local_debug_switch", "1") : "1", "1");
        }
        return invokeV.booleanValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (TextUtils.isEmpty(this.f5735e.a) || TextUtils.isEmpty(this.f5735e.f5748b) || (jSONArray = this.f5735e.f5749c) == null || jSONArray.length() <= 0 || TextUtils.isEmpty(this.f5735e.f5750d)) ? false : true : invokeV.booleanValue;
    }

    public final c.a v(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, unitedSchemeEntity)) == null) {
            String uri = (unitedSchemeEntity == null || unitedSchemeEntity.getUri() == null) ? "" : unitedSchemeEntity.getUri().toString();
            c.a.r0.a.e0.d.i("LocalDebugAction", "local debug scheme = " + uri);
            return (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().v0(this.f5735e.f5748b)).A0(false)).L0(true)).M0(this.f5735e.f5751e)).N0(this.f5735e.f5752f)).K0(uri)).P0(this.f5735e.f5753g);
        }
        return (c.a) invokeL.objValue;
    }

    public final void w(Context context, UnitedSchemeEntity unitedSchemeEntity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048585, this, context, unitedSchemeEntity, i2) == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(i2);
            c.a.r0.q.a b2 = c.a.r0.q.c.b();
            String string = b2 != null ? b2.i().getString("error_url", "") : "";
            if (TextUtils.isEmpty(string)) {
                c.a.r0.a.c2.b.f.e.g(context, "IPs are invalid ：" + i2).G();
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
        if (r6 >= r4.f5735e.f5749c.length()) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x(Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048586, this, context, str, file, unitedSchemeEntity, callbackHandler) == null) {
            try {
                Response executeSync = c.a.r0.p.e.a.g().getRequest().url(this.f5735e.b(str)).connectionTimeout(3000).build().executeSync();
                if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                    boolean a = c.a.r0.w.g.a(executeSync.body().byteStream(), file);
                    c.a.r0.a.e0.d.i("LocalDebugAction", "save debug bundle: " + a);
                    d.e().f("downloadsuccess");
                    this.f5735e.f5751e = str;
                    context.startActivity(c.a.r0.a.f1.e.c.g1(context, v(unitedSchemeEntity)));
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.f5733c != null) {
                        this.f5733c.shutdownNow();
                        this.f5733c = null;
                    }
                    if (!ProcessUtils.isMainProcess()) {
                        boolean z = z.f6343b;
                        q();
                    }
                }
                if (executeSync != null) {
                    executeSync.close();
                }
            } catch (IOException unused) {
                synchronized (this) {
                    if (this.f5735e.f5749c != null) {
                        int i2 = this.f5734d + 1;
                        this.f5734d = i2;
                    }
                    c.a.r0.a.e0.d.c("LocalDebugAction", "Host IPs are invalid");
                    w(context, unitedSchemeEntity, 1001);
                    d.e().f("downloadfail");
                }
            }
        }
    }
}
