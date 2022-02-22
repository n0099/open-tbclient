package c.a.s0.a.s.a.i;

import android.content.Context;
import c.a.s0.a.f2.e;
import c.a.s0.a.f2.f.z;
import c.a.s0.a.h0.g.l;
import c.a.s0.a.s.a.f;
import c.a.s0.a.s.a.g;
import c.a.s0.a.z2.q0;
import c.a.s0.w.i;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
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
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.webkit.sdk.CookieManager;
import com.dxmpay.wallet.core.Domains;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final a f8985e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-579640858, "Lc/a/s0/a/s/a/i/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-579640858, "Lc/a/s0/a/s/a/i/b$a;");
                    return;
                }
            }
            f8985e = new a();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l.S2();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(e eVar) {
        super(eVar, "/swanAPI/setTplBdussSync");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.s0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity entity, CallbackHandler callbackHandler, c.a.s0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, entity, callbackHandler, eVar)) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(entity);
            SwanAppAllianceLoginHelper.f38889d.l(true);
            if (optParamsAsJo == null) {
                c.a.s0.a.m.a d2 = SwanAppAllianceLoginHelper.f38889d.d();
                if (d2 != null) {
                    d2.onResult(-1);
                }
                entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                SwanAppAllianceLoginHelper.f38889d.a(f.d(), f.a());
                return false;
            }
            int optInt = optParamsAsJo.optInt("errno");
            JSONObject optJSONObject = optParamsAsJo.optJSONObject("data");
            q0.a0(a.f8985e);
            if (optInt != 0) {
                c.a.s0.a.m.a d3 = SwanAppAllianceLoginHelper.f38889d.d();
                if (d3 != null) {
                    d3.onResult(-1);
                }
                entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "error number is " + optInt);
                SwanAppAllianceLoginHelper.f38889d.a(f.d(), f.a());
                return false;
            } else if (optJSONObject != null) {
                Map<String, String> c2 = i.c(CookieManager.getInstance().getCookie(Domains.BAIDU));
                Intrinsics.checkNotNullExpressionValue(c2, "SwanAppUrlUtils.parseCookie(cookieString)");
                String str = c2.get(BeanConstants.COOKIE_OPENBDUSS);
                if (!(str == null || StringsKt__StringsJVMKt.isBlank(str))) {
                    g.f8982b.c(optInt, optJSONObject);
                    c.a.s0.a.s.a.a.b(context, str);
                    SwanAppAllianceLoginHelper.f38889d.j(true);
                    c.a.s0.a.m.a d4 = SwanAppAllianceLoginHelper.f38889d.d();
                    if (d4 != null) {
                        d4.onResult(0);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, entity, 0);
                    SwanAppAllianceLoginHelper.f38889d.a(f.f(), f.c());
                    return true;
                }
                c.a.s0.a.m.a d5 = SwanAppAllianceLoginHelper.f38889d.d();
                if (d5 != null) {
                    d5.onResult(-1);
                }
                entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "bduss is null");
                SwanAppAllianceLoginHelper.f38889d.a(f.d(), f.a());
                return false;
            } else {
                entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "json data is null");
                SwanAppAllianceLoginHelper.f38889d.a(f.d(), f.a());
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
