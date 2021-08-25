package c.a.o0.a.e0.f.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.f1.e.c;
import c.a.o0.a.p.d.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
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
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static Set<String> f5163f;

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f5164g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f5165c;

    /* renamed from: d  reason: collision with root package name */
    public int f5166d;

    /* renamed from: e  reason: collision with root package name */
    public c f5167e;

    /* renamed from: c.a.o0.a.e0.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0149a implements n.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f5168a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5169b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5170c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f5171d;

        public C0149a(a aVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
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
            this.f5171d = aVar;
            this.f5168a = context;
            this.f5169b = unitedSchemeEntity;
            this.f5170c = callbackHandler;
        }

        @Override // c.a.o0.a.p.d.n.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    c.a.o0.a.e0.d.b("LocalDebugAction", "Authentication Success");
                    a.f5164g.add(this.f5171d.o(this.f5168a));
                    this.f5171d.p(this.f5168a, this.f5169b, this.f5170c);
                    return;
                }
                c.a.o0.a.e0.d.b("LocalDebugAction", "Authentication Fail : Not developer");
                this.f5171d.w(this.f5168a, this.f5169b, 401);
            }
        }

        @Override // c.a.o0.a.p.d.n.b
        public void b(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                c.a.o0.a.e0.d.c("LocalDebugAction", "onFail : Authentication exception :", exc);
                this.f5171d.w(this.f5168a, this.f5169b, 401);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f5172e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5173f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f5174g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5175h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5176i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f5177j;

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
            this.f5177j = aVar;
            this.f5172e = context;
            this.f5173f = str;
            this.f5174g = file;
            this.f5175h = unitedSchemeEntity;
            this.f5176i = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5177j.x(this.f5172e, this.f5173f, this.f5174g, this.f5175h, this.f5176i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1886833412, "Lc/a/o0/a/e0/f/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1886833412, "Lc/a/o0/a/e0/f/d/a;");
                return;
            }
        }
        f5164g = new HashSet();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.o0.a.c2.e eVar) {
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

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (!t()) {
                c.a.o0.a.e0.d.b("LocalDebugAction", "switch is off");
                w(context, unitedSchemeEntity, 1003);
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                this.f5167e = c.c(optParamsAsJo);
                if (c.a.o0.a.m2.b.e(0).swanCoreVersionCode < this.f5167e.f5189h) {
                    c.a.o0.a.e0.d.b("LocalDebugAction", "swan js version is low");
                    w(context, unitedSchemeEntity, 1002);
                    return false;
                } else if (!u()) {
                    c.a.o0.a.e0.d.b("LocalDebugAction", "debug model invalid");
                    w(context, unitedSchemeEntity, 202);
                    return false;
                } else if (!c.a.o0.a.s.a.f.f8464d.f() && !s().contains(c.a.o0.a.c1.a.a0().h(context)) && !f5164g.contains(o(context))) {
                    c.a.o0.a.m.b.b(this.f5167e.f5183b, new C0149a(this, context, unitedSchemeEntity, callbackHandler));
                    return true;
                } else {
                    p(context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
            }
            c.a.o0.a.e0.d.b("LocalDebugAction", "param is null");
            w(context, unitedSchemeEntity, 202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final String o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return c.a.o0.a.c1.a.a0().h(context) + this.f5167e.f5183b;
        }
        return (String) invokeL.objValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler) == null) {
            File b2 = c.a.o0.a.e0.f.d.b.b();
            if (b2.exists()) {
                boolean delete = b2.delete();
                c.a.o0.a.e0.d.g("LocalDebugAction", "debug bundle delete: " + delete);
            }
            this.f5165c = Executors.newFixedThreadPool(4);
            this.f5166d = 0;
            d.e().f("downloadstart");
            for (int i2 = 0; i2 < this.f5167e.f5184c.length(); i2++) {
                String a2 = this.f5167e.a(i2);
                if (TextUtils.isEmpty(a2)) {
                    int i3 = this.f5166d + 1;
                    this.f5166d = i3;
                    if (i3 >= this.f5167e.f5184c.length()) {
                        c.a.o0.a.e0.d.b("LocalDebugAction", "IPs are invalid");
                        w(context, unitedSchemeEntity, 202);
                        d.e().f("downloadfail");
                    }
                } else {
                    this.f5165c.execute(new b(this, context, a2, b2, unitedSchemeEntity, callbackHandler));
                }
            }
        }
    }

    public final void q() {
        c.a.o0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (Q = c.a.o0.a.a2.e.Q()) == null) {
            return;
        }
        c.a.o0.a.v2.f.j(Q.x());
        System.exit(0);
    }

    public final String r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                boolean z = a0.f4738b;
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final Set<String> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (f5163f == null) {
                f5163f = new HashSet();
                c.a.o0.n.a b2 = c.a.o0.n.c.b();
                String string = b2 != null ? b2.j().getString("auth_white_list", "") : "";
                JSONArray jSONArray = null;
                try {
                    jSONArray = new JSONArray(string);
                } catch (JSONException unused) {
                    boolean z = a0.f4738b;
                }
                if (jSONArray != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        f5163f.add(jSONArray.optString(i2));
                    }
                }
            }
            return f5163f;
        }
        return (Set) invokeV.objValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.o0.n.a b2 = c.a.o0.n.c.b();
            return TextUtils.equals(b2 != null ? b2.j().getString("enable_local_debug_switch", "1") : "1", "1");
        }
        return invokeV.booleanValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (TextUtils.isEmpty(this.f5167e.f5182a) || TextUtils.isEmpty(this.f5167e.f5183b) || (jSONArray = this.f5167e.f5184c) == null || jSONArray.length() <= 0 || TextUtils.isEmpty(this.f5167e.f5185d)) ? false : true : invokeV.booleanValue;
    }

    public final c.a v(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, unitedSchemeEntity)) == null) {
            String uri = (unitedSchemeEntity == null || unitedSchemeEntity.getUri() == null) ? "" : unitedSchemeEntity.getUri().toString();
            c.a.o0.a.e0.d.g("LocalDebugAction", "local debug scheme = " + uri);
            return (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().u0(this.f5167e.f5183b)).z0(false)).K0(true)).L0(this.f5167e.f5186e)).M0(this.f5167e.f5187f)).J0(uri)).O0(this.f5167e.f5188g);
        }
        return (c.a) invokeL.objValue;
    }

    public final void w(Context context, UnitedSchemeEntity unitedSchemeEntity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048585, this, context, unitedSchemeEntity, i2) == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(i2);
            c.a.o0.n.a b2 = c.a.o0.n.c.b();
            String string = b2 != null ? b2.j().getString("error_url", "") : "";
            if (TextUtils.isEmpty(string)) {
                c.a.o0.a.z1.b.f.e.g(context, "IPs are invalid ：" + i2).F();
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
        if (r6 >= r4.f5167e.f5184c.length()) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x(Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048586, this, context, str, file, unitedSchemeEntity, callbackHandler) == null) {
            try {
                Response executeSync = c.a.o0.m.e.a.g().getRequest().url(this.f5167e.b(str)).connectionTimeout(3000).build().executeSync();
                if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                    boolean a2 = c.a.o0.t.g.a(executeSync.body().byteStream(), file);
                    c.a.o0.a.e0.d.g("LocalDebugAction", "save debug bundle: " + a2);
                    d.e().f("downloadsuccess");
                    this.f5167e.f5186e = str;
                    context.startActivity(c.a.o0.a.f1.e.c.d1(context, v(unitedSchemeEntity)));
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.f5165c != null) {
                        this.f5165c.shutdownNow();
                        this.f5165c = null;
                    }
                    if (!ProcessUtils.isMainProcess()) {
                        boolean z = a0.f4738b;
                        q();
                    }
                }
                if (executeSync != null) {
                    executeSync.close();
                }
            } catch (IOException unused) {
                synchronized (this) {
                    if (this.f5167e.f5184c != null) {
                        int i2 = this.f5166d + 1;
                        this.f5166d = i2;
                    }
                    c.a.o0.a.e0.d.b("LocalDebugAction", "Host IPs are invalid");
                    w(context, unitedSchemeEntity, 1001);
                    d.e().f("downloadfail");
                }
            }
        }
    }
}
