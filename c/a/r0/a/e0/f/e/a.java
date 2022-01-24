package c.a.r0.a.e0.f.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.a1.d;
import c.a.r0.a.f1.e.c;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.o2.g.h;
import c.a.r0.a.p.d.n;
import c.a.r0.w.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.tbadk.core.util.TbEnum;
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

    /* renamed from: g  reason: collision with root package name */
    public static Set<String> f5791g;

    /* renamed from: h  reason: collision with root package name */
    public static Set<String> f5792h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public c f5793c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f5794d;

    /* renamed from: e  reason: collision with root package name */
    public int f5795e;

    /* renamed from: f  reason: collision with root package name */
    public c.a f5796f;

    /* renamed from: c.a.r0.a.e0.f.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0309a implements n.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f5797b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5798c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f5799d;

        public C0309a(a aVar, UnitedSchemeEntity unitedSchemeEntity, Context context, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, unitedSchemeEntity, context, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5799d = aVar;
            this.a = unitedSchemeEntity;
            this.f5797b = context;
            this.f5798c = callbackHandler;
        }

        @Override // c.a.r0.a.p.d.n.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    c.a.r0.a.e0.d.c("DebuggerLaunchAction", "Authentication Success");
                    a.f5792h.add(this.f5799d.o(this.f5797b));
                    this.f5799d.p(this.f5797b, this.a, this.f5798c);
                    return;
                }
                c.a.r0.a.e0.d.c("DebuggerLaunchAction", "Authentication Fail : Not developer");
                this.a.result = UnitedSchemeUtility.wrapCallbackParams(401);
                this.f5799d.v(this.f5797b, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
            }
        }

        @Override // c.a.r0.a.p.d.n.b
        public void b(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                c.a.r0.a.e0.d.d("DebuggerLaunchAction", "onFail : Authentication exception :", exc);
                this.a.result = UnitedSchemeUtility.wrapCallbackParams(401);
                this.f5799d.v(this.f5797b, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f5800e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5801f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f5802g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5803h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5804i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f5805j;

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
            this.f5805j = aVar;
            this.f5800e = context;
            this.f5801f = str;
            this.f5802g = file;
            this.f5803h = unitedSchemeEntity;
            this.f5804i = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5805j.w(this.f5800e, this.f5801f, this.f5802g, this.f5803h, this.f5804i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(891487800, "Lc/a/r0/a/e0/f/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(891487800, "Lc/a/r0/a/e0/f/e/a;");
                return;
            }
        }
        f5792h = new HashSet();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.r0.a.f2.e eVar) {
        super(eVar, "/swanAPI/debuggerlaunch");
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
            boolean equals = TextUtils.equals(h.a().getString("enableSwitch", "1"), "1");
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null && optParamsAsJo.length() > 0 && equals) {
                c b2 = c.b(optParamsAsJo);
                this.f5793c = b2;
                if (b2 == null) {
                    boolean z = z.f6343b;
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else if (!u()) {
                    v(context, "404");
                    return false;
                } else if (!SwanAppAllianceLoginHelper.f38661d.f() && !t().contains(c.a.r0.a.c1.a.h0().h(context)) && !f5792h.contains(o(context))) {
                    c.a.r0.a.m.b.b(this.f5793c.a, new C0309a(this, unitedSchemeEntity, context, callbackHandler));
                    return true;
                } else {
                    p(context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
            }
            c.a.r0.a.e0.d.c("DebuggerLaunchAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final String o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return c.a.r0.a.c1.a.h0().h(context) + this.f5793c.a;
        }
        return (String) invokeL.objValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler) == null) {
            d.j(r());
            File b2 = d.f.b();
            if (b2.exists()) {
                b2.delete();
            }
            this.f5794d = Executors.newFixedThreadPool(4);
            this.f5795e = 0;
            for (int i2 = 0; i2 < this.f5793c.f5807b.length(); i2++) {
                String a = this.f5793c.a(i2);
                if (TextUtils.isEmpty(a)) {
                    int i3 = this.f5795e + 1;
                    this.f5795e = i3;
                    if (i3 >= this.f5793c.f5807b.length()) {
                        c.a.r0.a.e0.d.c("DebuggerLaunchAction", "IPs are invalid");
                        v(context, "404");
                    }
                } else {
                    this.f5794d.execute(new b(this, context, a, b2, unitedSchemeEntity, callbackHandler));
                }
            }
        }
    }

    public final String q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final c.a r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f5796f == null && this.f5793c != null) {
                this.f5796f = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().v0(this.f5793c.a)).A0(false)).R0(this.f5793c.f5809d)).K0("baiduboxapp://swan/" + this.f5793c.a)).P0("1");
            }
            return this.f5796f;
        }
        return (c.a) invokeV.objValue;
    }

    public final String s(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != 51509) {
                if (hashCode == 51512 && str.equals("404")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (str.equals(TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND)) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                return "authorization fail " + str;
            } else if (c2 != 1) {
                return "";
            } else {
                return "IPs are invalid " + str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final Set<String> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (f5791g == null) {
                f5791g = new HashSet();
                try {
                    JSONArray jSONArray = new JSONArray(h.a().getString("authWlist", ""));
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        f5791g.add(jSONArray.optString(i2));
                    }
                } catch (JSONException unused) {
                    boolean z = z.f6343b;
                }
            }
            return f5791g;
        }
        return (Set) invokeV.objValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            JSONArray jSONArray = this.f5793c.f5807b;
            return (jSONArray == null || jSONArray.length() <= 0 || TextUtils.isEmpty(this.f5793c.f5808c)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void v(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str) == null) {
            String string = h.a().getString("errorURL", "");
            if (TextUtils.isEmpty(string)) {
                c.a.r0.a.c2.b.f.e.g(context, s(str)).G();
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(SchemeConfig.getSchemeHead());
            sb.append("://v1/easybrowse/open?url=");
            sb.append(q(string + "?" + str));
            SchemeRouter.invoke(context, sb.toString());
        }
    }

    public final void w(Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048585, this, context, str, file, unitedSchemeEntity, callbackHandler) == null) {
            c.a r = r();
            d.l();
            d.g().h("downloadstart");
            try {
                c.a.r0.p.c.c request = c.a.r0.p.e.a.g().getRequest();
                Response executeSync = request.url(str + "/app.zip").connectionTimeout(3000).build().executeSync();
                if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                    g.a(executeSync.body().byteStream(), file);
                    Intent g1 = c.a.r0.a.f1.e.c.g1(context, r);
                    g1.putExtra("remoteDebugUrl", str);
                    context.startActivity(g1);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.f5794d != null) {
                        this.f5794d.shutdownNow();
                        this.f5794d = null;
                    }
                    d.m(r);
                    d.g().h("downloadsuccess");
                }
                if (executeSync != null) {
                    executeSync.close();
                }
            } catch (IOException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                int i2 = this.f5795e + 1;
                this.f5795e = i2;
                if (i2 >= this.f5793c.f5807b.length()) {
                    c.a.r0.a.e0.d.c("DebuggerLaunchAction", "IPs are invalid");
                    v(context, "404");
                    d.g().h("downloadfail");
                }
            }
        }
    }
}
