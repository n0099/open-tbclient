package c.a.p0.a.e0.f.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a1.d;
import c.a.p0.a.f1.e.c;
import c.a.p0.a.f2.f.z;
import c.a.p0.a.o2.g.h;
import c.a.p0.a.p.d.n;
import c.a.p0.w.g;
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
    public static Set<String> f4731g;

    /* renamed from: h  reason: collision with root package name */
    public static Set<String> f4732h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public c f4733c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f4734d;

    /* renamed from: e  reason: collision with root package name */
    public int f4735e;

    /* renamed from: f  reason: collision with root package name */
    public c.a f4736f;

    /* renamed from: c.a.p0.a.e0.f.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0207a implements n.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f4737b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4738c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f4739d;

        public C0207a(a aVar, UnitedSchemeEntity unitedSchemeEntity, Context context, CallbackHandler callbackHandler) {
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
            this.f4739d = aVar;
            this.a = unitedSchemeEntity;
            this.f4737b = context;
            this.f4738c = callbackHandler;
        }

        @Override // c.a.p0.a.p.d.n.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    c.a.p0.a.e0.d.c("DebuggerLaunchAction", "Authentication Success");
                    a.f4732h.add(this.f4739d.o(this.f4737b));
                    this.f4739d.p(this.f4737b, this.a, this.f4738c);
                    return;
                }
                c.a.p0.a.e0.d.c("DebuggerLaunchAction", "Authentication Fail : Not developer");
                this.a.result = UnitedSchemeUtility.wrapCallbackParams(401);
                this.f4739d.v(this.f4737b, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
            }
        }

        @Override // c.a.p0.a.p.d.n.b
        public void b(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                c.a.p0.a.e0.d.d("DebuggerLaunchAction", "onFail : Authentication exception :", exc);
                this.a.result = UnitedSchemeUtility.wrapCallbackParams(401);
                this.f4739d.v(this.f4737b, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4740e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4741f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f4742g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4743h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4744i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f4745j;

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
            this.f4745j = aVar;
            this.f4740e = context;
            this.f4741f = str;
            this.f4742g = file;
            this.f4743h = unitedSchemeEntity;
            this.f4744i = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4745j.w(this.f4740e, this.f4741f, this.f4742g, this.f4743h, this.f4744i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1902605050, "Lc/a/p0/a/e0/f/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1902605050, "Lc/a/p0/a/e0/f/e/a;");
                return;
            }
        }
        f4732h = new HashSet();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.p0.a.f2.e eVar) {
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

    @Override // c.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            boolean equals = TextUtils.equals(h.a().getString("enableSwitch", "1"), "1");
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null && optParamsAsJo.length() > 0 && equals) {
                c b2 = c.b(optParamsAsJo);
                this.f4733c = b2;
                if (b2 == null) {
                    boolean z = z.f5296b;
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else if (!u()) {
                    v(context, "404");
                    return false;
                } else if (!SwanAppAllianceLoginHelper.f39311d.f() && !t().contains(c.a.p0.a.c1.a.h0().h(context)) && !f4732h.contains(o(context))) {
                    c.a.p0.a.m.b.b(this.f4733c.a, new C0207a(this, unitedSchemeEntity, context, callbackHandler));
                    return true;
                } else {
                    p(context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
            }
            c.a.p0.a.e0.d.c("DebuggerLaunchAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final String o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return c.a.p0.a.c1.a.h0().h(context) + this.f4733c.a;
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
            this.f4734d = Executors.newFixedThreadPool(4);
            this.f4735e = 0;
            for (int i2 = 0; i2 < this.f4733c.f4747b.length(); i2++) {
                String a = this.f4733c.a(i2);
                if (TextUtils.isEmpty(a)) {
                    int i3 = this.f4735e + 1;
                    this.f4735e = i3;
                    if (i3 >= this.f4733c.f4747b.length()) {
                        c.a.p0.a.e0.d.c("DebuggerLaunchAction", "IPs are invalid");
                        v(context, "404");
                    }
                } else {
                    this.f4734d.execute(new b(this, context, a, b2, unitedSchemeEntity, callbackHandler));
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
            if (this.f4736f == null && this.f4733c != null) {
                this.f4736f = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().v0(this.f4733c.a)).A0(false)).R0(this.f4733c.f4749d)).K0("baiduboxapp://swan/" + this.f4733c.a)).P0("1");
            }
            return this.f4736f;
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
            if (f4731g == null) {
                f4731g = new HashSet();
                try {
                    JSONArray jSONArray = new JSONArray(h.a().getString("authWlist", ""));
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        f4731g.add(jSONArray.optString(i2));
                    }
                } catch (JSONException unused) {
                    boolean z = z.f5296b;
                }
            }
            return f4731g;
        }
        return (Set) invokeV.objValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            JSONArray jSONArray = this.f4733c.f4747b;
            return (jSONArray == null || jSONArray.length() <= 0 || TextUtils.isEmpty(this.f4733c.f4748c)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void v(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str) == null) {
            String string = h.a().getString("errorURL", "");
            if (TextUtils.isEmpty(string)) {
                c.a.p0.a.c2.b.f.e.g(context, s(str)).G();
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
                c.a.p0.p.c.c request = c.a.p0.p.e.a.g().getRequest();
                Response executeSync = request.url(str + "/app.zip").connectionTimeout(3000).build().executeSync();
                if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                    g.a(executeSync.body().byteStream(), file);
                    Intent g1 = c.a.p0.a.f1.e.c.g1(context, r);
                    g1.putExtra("remoteDebugUrl", str);
                    context.startActivity(g1);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.f4734d != null) {
                        this.f4734d.shutdownNow();
                        this.f4734d = null;
                    }
                    d.m(r);
                    d.g().h("downloadsuccess");
                }
                if (executeSync != null) {
                    executeSync.close();
                }
            } catch (IOException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                int i2 = this.f4735e + 1;
                this.f4735e = i2;
                if (i2 >= this.f4733c.f4747b.length()) {
                    c.a.p0.a.e0.d.c("DebuggerLaunchAction", "IPs are invalid");
                    v(context, "404");
                    d.g().h("downloadfail");
                }
            }
        }
    }
}
