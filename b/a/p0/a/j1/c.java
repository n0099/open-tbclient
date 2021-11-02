package b.a.p0.a.j1;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.constraintlayout.motion.widget.Key;
import b.a.p0.a.c2.e;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.e2.c.d;
import b.a.p0.a.e2.c.i;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.g1.f;
import b.a.p0.a.h0.g.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6273e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6274f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f6275g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ float f6276h;

        public a(c cVar, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, callbackHandler, str, swanAppActionBar, Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6273e = callbackHandler;
            this.f6274f = str;
            this.f6275g = swanAppActionBar;
            this.f6276h = f2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!d.h(iVar)) {
                    d.p(iVar, this.f6273e, this.f6274f);
                } else if (this.f6275g.getRightMenu() == null) {
                    this.f6273e.handleSchemeDispatchCallback(this.f6274f, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                } else {
                    this.f6275g.setRightMenuAlpha(this.f6276h);
                    this.f6273e.handleSchemeDispatchCallback(this.f6274f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6277e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6278f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f6279g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f6280h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f6281i;

        public b(c cVar, CallbackHandler callbackHandler, String str, boolean z, SwanAppActionBar swanAppActionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, callbackHandler, str, Boolean.valueOf(z), swanAppActionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6281i = cVar;
            this.f6277e = callbackHandler;
            this.f6278f = str;
            this.f6279g = z;
            this.f6280h = swanAppActionBar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!d.h(iVar)) {
                    d.p(iVar, this.f6277e, this.f6278f);
                    return;
                }
                if (this.f6279g) {
                    this.f6281i.p(this.f6280h);
                } else {
                    this.f6281i.m(this.f6280h);
                }
                this.f6277e.handleSchemeDispatchCallback(this.f6278f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar) {
        super(eVar, "/swanAPI/menu");
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

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // b.a.p0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            if (context != null && eVar != null) {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    b.a.p0.a.e0.d.b(SupportMenuInflater.XML_MENU, "parameters are illegal");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                f T = f.T();
                if (T == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                g U = T.U();
                if (U == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                b.a.p0.a.h0.g.d m = U.m();
                if (m == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                SwanAppActionBar B1 = m.B1();
                if (B1 == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                l(eVar, context, callbackHandler, optString, B1, optParamsAsJo, str);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            b.a.p0.a.e0.d.b(SupportMenuInflater.XML_MENU, "parameters dismissed");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public final void l(b.a.p0.a.a2.e eVar, Context context, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{eVar, context, callbackHandler, str, swanAppActionBar, jSONObject, str2}) == null) {
            if (swanAppActionBar == null) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            } else if (TextUtils.equals(str2, "/swanAPI/menu/setMenuEnabled")) {
                o(eVar, context, callbackHandler, str, swanAppActionBar, jSONObject.optBoolean(SapiOptions.KEY_CACHE_ENABLED, true));
            } else if (TextUtils.equals(str2, "/swanAPI/menu/setMenuOpacity")) {
                float optDouble = (float) jSONObject.optDouble(Key.ALPHA, 1.0d);
                if (optDouble <= 1.0f && optDouble >= 0.1f) {
                    n(eVar, context, callbackHandler, str, swanAppActionBar, optDouble);
                    return;
                }
                b.a.p0.a.e0.d.b(SupportMenuInflater.XML_MENU, "The range of alpha should be in [0.1,1]");
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            } else {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public final boolean m(SwanAppActionBar swanAppActionBar) {
        InterceptResult invokeL;
        View rightMenu;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, swanAppActionBar)) == null) {
            if (swanAppActionBar == null || (rightMenu = swanAppActionBar.getRightMenu()) == null) {
                return false;
            }
            rightMenu.setVisibility(4);
            swanAppActionBar.setRightMenuEnable(false);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void n(b.a.p0.a.a2.e eVar, Context context, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{eVar, context, callbackHandler, str, swanAppActionBar, Float.valueOf(f2)}) == null) {
            eVar.S().g(context, "mapp_change_menu_appearance", new a(this, callbackHandler, str, swanAppActionBar, f2));
        }
    }

    public final void o(b.a.p0.a.a2.e eVar, Context context, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{eVar, context, callbackHandler, str, swanAppActionBar, Boolean.valueOf(z)}) == null) {
            eVar.S().g(context, "scope_hide_menu", new b(this, callbackHandler, str, z, swanAppActionBar));
        }
    }

    public final boolean p(SwanAppActionBar swanAppActionBar) {
        InterceptResult invokeL;
        View rightMenu;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, swanAppActionBar)) == null) {
            if (swanAppActionBar == null || (rightMenu = swanAppActionBar.getRightMenu()) == null) {
                return false;
            }
            rightMenu.setVisibility(0);
            swanAppActionBar.setRightMenuEnable(true);
            return true;
        }
        return invokeL.booleanValue;
    }
}
