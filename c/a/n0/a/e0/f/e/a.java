package c.a.n0.a.e0.f.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.a1.e;
import c.a.n0.a.c2.f.a0;
import c.a.n0.a.f1.e.c;
import c.a.n0.a.k2.g.h;
import c.a.n0.a.p.d.n;
import c.a.n0.a.s.a.f;
import c.a.n0.t.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.countly.XAdRemoteSDKCountly;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
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
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static Set<String> f4986g;

    /* renamed from: h  reason: collision with root package name */
    public static Set<String> f4987h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public c f4988c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f4989d;

    /* renamed from: e  reason: collision with root package name */
    public int f4990e;

    /* renamed from: f  reason: collision with root package name */
    public c.a f4991f;

    /* renamed from: c.a.n0.a.e0.f.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0143a implements n.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4992a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f4993b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4994c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f4995d;

        public C0143a(a aVar, UnitedSchemeEntity unitedSchemeEntity, Context context, CallbackHandler callbackHandler) {
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
            this.f4995d = aVar;
            this.f4992a = unitedSchemeEntity;
            this.f4993b = context;
            this.f4994c = callbackHandler;
        }

        @Override // c.a.n0.a.p.d.n.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    c.a.n0.a.e0.d.b("DebuggerLaunchAction", "Authentication Success");
                    a.f4987h.add(this.f4995d.o(this.f4993b));
                    this.f4995d.p(this.f4993b, this.f4992a, this.f4994c);
                    return;
                }
                c.a.n0.a.e0.d.b("DebuggerLaunchAction", "Authentication Fail : Not developer");
                this.f4992a.result = UnitedSchemeUtility.wrapCallbackParams(401);
                this.f4995d.v(this.f4993b, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
            }
        }

        @Override // c.a.n0.a.p.d.n.b
        public void b(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                c.a.n0.a.e0.d.c("DebuggerLaunchAction", "onFail : Authentication exception :", exc);
                this.f4992a.result = UnitedSchemeUtility.wrapCallbackParams(401);
                this.f4995d.v(this.f4993b, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4996e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4997f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f4998g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4999h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5000i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f5001j;

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
            this.f5001j = aVar;
            this.f4996e = context;
            this.f4997f = str;
            this.f4998g = file;
            this.f4999h = unitedSchemeEntity;
            this.f5000i = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5001j.w(this.f4996e, this.f4997f, this.f4998g, this.f4999h, this.f5000i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1381244996, "Lc/a/n0/a/e0/f/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1381244996, "Lc/a/n0/a/e0/f/e/a;");
                return;
            }
        }
        f4987h = new HashSet();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.n0.a.c2.e eVar) {
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

    @Override // c.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            boolean equals = TextUtils.equals(h.a().getString("enableSwitch", "1"), "1");
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null && optParamsAsJo.length() > 0 && equals) {
                c b2 = c.b(optParamsAsJo);
                this.f4988c = b2;
                if (b2 == null) {
                    boolean z = a0.f4492b;
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else if (!u()) {
                    v(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                    return false;
                } else if (!f.f8218d.f() && !t().contains(c.a.n0.a.c1.a.a0().h(context)) && !f4987h.contains(o(context))) {
                    c.a.n0.a.m.b.b(this.f4988c.f5003a, new C0143a(this, unitedSchemeEntity, context, callbackHandler));
                    return true;
                } else {
                    p(context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
            }
            c.a.n0.a.e0.d.b("DebuggerLaunchAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final String o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return c.a.n0.a.c1.a.a0().h(context) + this.f4988c.f5003a;
        }
        return (String) invokeL.objValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler) == null) {
            d.j(r());
            File b2 = e.f.b();
            if (b2.exists()) {
                b2.delete();
            }
            this.f4989d = Executors.newFixedThreadPool(4);
            this.f4990e = 0;
            for (int i2 = 0; i2 < this.f4988c.f5004b.length(); i2++) {
                String a2 = this.f4988c.a(i2);
                if (TextUtils.isEmpty(a2)) {
                    int i3 = this.f4990e + 1;
                    this.f4990e = i3;
                    if (i3 >= this.f4988c.f5004b.length()) {
                        c.a.n0.a.e0.d.b("DebuggerLaunchAction", "IPs are invalid");
                        v(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                    }
                } else {
                    this.f4989d.execute(new b(this, context, a2, b2, unitedSchemeEntity, callbackHandler));
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
            if (this.f4991f == null && this.f4988c != null) {
                this.f4991f = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().u0(this.f4988c.f5003a)).z0(false)).Q0(this.f4988c.f5006d)).J0("baiduboxapp://swan/" + this.f4988c.f5003a)).O0("1");
            }
            return this.f4991f;
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
                if (hashCode == 51512 && str.equals(XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH)) {
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
            if (f4986g == null) {
                f4986g = new HashSet();
                try {
                    JSONArray jSONArray = new JSONArray(h.a().getString("authWlist", ""));
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        f4986g.add(jSONArray.optString(i2));
                    }
                } catch (JSONException unused) {
                    boolean z = a0.f4492b;
                }
            }
            return f4986g;
        }
        return (Set) invokeV.objValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            JSONArray jSONArray = this.f4988c.f5004b;
            return (jSONArray == null || jSONArray.length() <= 0 || TextUtils.isEmpty(this.f4988c.f5005c)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void v(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str) == null) {
            String string = h.a().getString("errorURL", "");
            if (TextUtils.isEmpty(string)) {
                c.a.n0.a.z1.b.f.e.g(context, s(str)).F();
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
                c.a.n0.m.c.c request = c.a.n0.m.e.a.g().getRequest();
                Response executeSync = request.url(str + "/app.zip").connectionTimeout(3000).build().executeSync();
                if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                    g.a(executeSync.body().byteStream(), file);
                    Intent d1 = c.a.n0.a.f1.e.c.d1(context, r);
                    d1.putExtra("remoteDebugUrl", str);
                    context.startActivity(d1);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.f4989d != null) {
                        this.f4989d.shutdownNow();
                        this.f4989d = null;
                    }
                    d.m(r);
                    d.g().h("downloadsuccess");
                }
                if (executeSync != null) {
                    executeSync.close();
                }
            } catch (IOException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                int i2 = this.f4990e + 1;
                this.f4990e = i2;
                if (i2 >= this.f4988c.f5004b.length()) {
                    c.a.n0.a.e0.d.b("DebuggerLaunchAction", "IPs are invalid");
                    v(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                    d.g().h("downloadfail");
                }
            }
        }
    }
}
