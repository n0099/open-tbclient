package c.a.o0.a.e0.f.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.a1.e;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.f1.e.c;
import c.a.o0.a.k2.g.h;
import c.a.o0.a.p.d.n;
import c.a.o0.a.s.a.f;
import c.a.o0.t.g;
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
    public static Set<String> f5232g;

    /* renamed from: h  reason: collision with root package name */
    public static Set<String> f5233h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public c f5234c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f5235d;

    /* renamed from: e  reason: collision with root package name */
    public int f5236e;

    /* renamed from: f  reason: collision with root package name */
    public c.a f5237f;

    /* renamed from: c.a.o0.a.e0.f.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0151a implements n.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5238a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f5239b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5240c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f5241d;

        public C0151a(a aVar, UnitedSchemeEntity unitedSchemeEntity, Context context, CallbackHandler callbackHandler) {
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
            this.f5241d = aVar;
            this.f5238a = unitedSchemeEntity;
            this.f5239b = context;
            this.f5240c = callbackHandler;
        }

        @Override // c.a.o0.a.p.d.n.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    c.a.o0.a.e0.d.b("DebuggerLaunchAction", "Authentication Success");
                    a.f5233h.add(this.f5241d.o(this.f5239b));
                    this.f5241d.p(this.f5239b, this.f5238a, this.f5240c);
                    return;
                }
                c.a.o0.a.e0.d.b("DebuggerLaunchAction", "Authentication Fail : Not developer");
                this.f5238a.result = UnitedSchemeUtility.wrapCallbackParams(401);
                this.f5241d.v(this.f5239b, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
            }
        }

        @Override // c.a.o0.a.p.d.n.b
        public void b(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                c.a.o0.a.e0.d.c("DebuggerLaunchAction", "onFail : Authentication exception :", exc);
                this.f5238a.result = UnitedSchemeUtility.wrapCallbackParams(401);
                this.f5241d.v(this.f5239b, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f5242e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5243f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f5244g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5245h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5246i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f5247j;

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
            this.f5247j = aVar;
            this.f5242e = context;
            this.f5243f = str;
            this.f5244g = file;
            this.f5245h = unitedSchemeEntity;
            this.f5246i = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5247j.w(this.f5242e, this.f5243f, this.f5244g, this.f5245h, this.f5246i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1886803621, "Lc/a/o0/a/e0/f/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1886803621, "Lc/a/o0/a/e0/f/e/a;");
                return;
            }
        }
        f5233h = new HashSet();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.o0.a.c2.e eVar) {
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

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            boolean equals = TextUtils.equals(h.a().getString("enableSwitch", "1"), "1");
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null && optParamsAsJo.length() > 0 && equals) {
                c b2 = c.b(optParamsAsJo);
                this.f5234c = b2;
                if (b2 == null) {
                    boolean z = a0.f4738b;
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else if (!u()) {
                    v(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                    return false;
                } else if (!f.f8464d.f() && !t().contains(c.a.o0.a.c1.a.a0().h(context)) && !f5233h.contains(o(context))) {
                    c.a.o0.a.m.b.b(this.f5234c.f5249a, new C0151a(this, unitedSchemeEntity, context, callbackHandler));
                    return true;
                } else {
                    p(context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
            }
            c.a.o0.a.e0.d.b("DebuggerLaunchAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final String o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return c.a.o0.a.c1.a.a0().h(context) + this.f5234c.f5249a;
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
            this.f5235d = Executors.newFixedThreadPool(4);
            this.f5236e = 0;
            for (int i2 = 0; i2 < this.f5234c.f5250b.length(); i2++) {
                String a2 = this.f5234c.a(i2);
                if (TextUtils.isEmpty(a2)) {
                    int i3 = this.f5236e + 1;
                    this.f5236e = i3;
                    if (i3 >= this.f5234c.f5250b.length()) {
                        c.a.o0.a.e0.d.b("DebuggerLaunchAction", "IPs are invalid");
                        v(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                    }
                } else {
                    this.f5235d.execute(new b(this, context, a2, b2, unitedSchemeEntity, callbackHandler));
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
            if (this.f5237f == null && this.f5234c != null) {
                this.f5237f = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().u0(this.f5234c.f5249a)).z0(false)).Q0(this.f5234c.f5252d)).J0("baiduboxapp://swan/" + this.f5234c.f5249a)).O0("1");
            }
            return this.f5237f;
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
            if (f5232g == null) {
                f5232g = new HashSet();
                try {
                    JSONArray jSONArray = new JSONArray(h.a().getString("authWlist", ""));
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        f5232g.add(jSONArray.optString(i2));
                    }
                } catch (JSONException unused) {
                    boolean z = a0.f4738b;
                }
            }
            return f5232g;
        }
        return (Set) invokeV.objValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            JSONArray jSONArray = this.f5234c.f5250b;
            return (jSONArray == null || jSONArray.length() <= 0 || TextUtils.isEmpty(this.f5234c.f5251c)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void v(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str) == null) {
            String string = h.a().getString("errorURL", "");
            if (TextUtils.isEmpty(string)) {
                c.a.o0.a.z1.b.f.e.g(context, s(str)).F();
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
                c.a.o0.m.c.c request = c.a.o0.m.e.a.g().getRequest();
                Response executeSync = request.url(str + "/app.zip").connectionTimeout(3000).build().executeSync();
                if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                    g.a(executeSync.body().byteStream(), file);
                    Intent d1 = c.a.o0.a.f1.e.c.d1(context, r);
                    d1.putExtra("remoteDebugUrl", str);
                    context.startActivity(d1);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.f5235d != null) {
                        this.f5235d.shutdownNow();
                        this.f5235d = null;
                    }
                    d.m(r);
                    d.g().h("downloadsuccess");
                }
                if (executeSync != null) {
                    executeSync.close();
                }
            } catch (IOException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                int i2 = this.f5236e + 1;
                this.f5236e = i2;
                if (i2 >= this.f5234c.f5250b.length()) {
                    c.a.o0.a.e0.d.b("DebuggerLaunchAction", "IPs are invalid");
                    v(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                    d.g().h("downloadfail");
                }
            }
        }
    }
}
