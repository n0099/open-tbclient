package c.a.p0.a.a1;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.v1.e;
import c.a.p0.a.v1.f.z;
import c.a.p0.a.w0.f;
import c.a.p0.a.x.g.g;
import c.a.p0.a.x1.c.i;
import c.a.p0.a.x1.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4540e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4541f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f4542g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ float f4543h;

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
            this.f4540e = callbackHandler;
            this.f4541f = str;
            this.f4542g = swanAppActionBar;
            this.f4543h = f2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.p0.a.x1.c.d.h(iVar)) {
                    c.a.p0.a.x1.c.d.q(iVar, this.f4540e, this.f4541f);
                } else if (this.f4542g.getRightMenu() == null) {
                    this.f4540e.handleSchemeDispatchCallback(this.f4541f, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                } else {
                    this.f4542g.setRightMenuAlpha(this.f4543h);
                    this.f4540e.handleSchemeDispatchCallback(this.f4541f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4544e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4545f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f4546g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f4547h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f4548i;

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
            this.f4548i = cVar;
            this.f4544e = callbackHandler;
            this.f4545f = str;
            this.f4546g = z;
            this.f4547h = swanAppActionBar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.p0.a.x1.c.d.h(iVar)) {
                    c.a.p0.a.x1.c.d.q(iVar, this.f4544e, this.f4545f);
                    return;
                }
                if (this.f4546g) {
                    this.f4548i.r(this.f4547h);
                } else {
                    this.f4548i.n(this.f4547h);
                }
                this.f4544e.handleSchemeDispatchCallback(this.f4545f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
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

    @Override // c.a.p0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.a.p0.a.v1.f.z
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, c.a.p0.a.t1.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            if (context != null && eVar != null) {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    c.a.p0.a.u.d.c(SupportMenuInflater.XML_MENU, "parameters are illegal");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                f U = f.U();
                if (U == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                g V = U.V();
                if (V == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                c.a.p0.a.x.g.d m = V.m();
                if (m == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                SwanAppActionBar E1 = m.E1();
                if (E1 == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                l(eVar, context, callbackHandler, optString, E1, optParamsAsJo, str, m);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            c.a.p0.a.u.d.c(SupportMenuInflater.XML_MENU, "parameters dismissed");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public final void l(c.a.p0.a.t1.e eVar, Context context, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, JSONObject jSONObject, String str2, c.a.p0.a.x.g.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{eVar, context, callbackHandler, str, swanAppActionBar, jSONObject, str2, dVar}) == null) {
            if (swanAppActionBar == null) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            } else if (TextUtils.equals(str2, "/swanAPI/menu/setMenuEnabled")) {
                p(eVar, context, callbackHandler, str, swanAppActionBar, jSONObject.optBoolean(SapiOptions.KEY_CACHE_ENABLED, true));
            } else if (TextUtils.equals(str2, "/swanAPI/menu/setPageStyle")) {
                String optString = jSONObject.optString("menuColorStyle", "");
                boolean m = m(jSONObject);
                if (TextUtils.isEmpty(optString)) {
                    optString = "white";
                }
                q(callbackHandler, str, swanAppActionBar, optString, m, dVar);
                c.a.p0.a.r2.b.c().j(jSONObject.optString("pageUrl", ""));
            } else if (TextUtils.equals(str2, "/swanAPI/menu/setMenuOpacity")) {
                float optDouble = (float) jSONObject.optDouble(AnimationProperty.OPACITY, 1.0d);
                if (optDouble <= 1.0f && optDouble >= 0.1f) {
                    o(eVar, context, callbackHandler, str, swanAppActionBar, optDouble);
                    return;
                }
                c.a.p0.a.u.d.c(SupportMenuInflater.XML_MENU, "The range of alpha should be in [0.1,1]");
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            } else {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public final boolean m(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            boolean d2 = c.a.p0.a.r2.b.c().d();
            if (jSONObject == null || !jSONObject.has("immersion")) {
                return d2;
            }
            boolean optBoolean = jSONObject.optBoolean("immersion", true);
            c.a.p0.a.r2.b.c().k(optBoolean);
            return optBoolean;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(SwanAppActionBar swanAppActionBar) {
        InterceptResult invokeL;
        View rightMenu;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, swanAppActionBar)) == null) {
            if (swanAppActionBar == null || (rightMenu = swanAppActionBar.getRightMenu()) == null) {
                return false;
            }
            rightMenu.setVisibility(4);
            swanAppActionBar.setRightMenuEnable(false);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void o(c.a.p0.a.t1.e eVar, Context context, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{eVar, context, callbackHandler, str, swanAppActionBar, Float.valueOf(f2)}) == null) {
            eVar.d0().g(context, "mapp_change_menu_appearance", new a(this, callbackHandler, str, swanAppActionBar, f2));
        }
    }

    public final void p(c.a.p0.a.t1.e eVar, Context context, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{eVar, context, callbackHandler, str, swanAppActionBar, Boolean.valueOf(z)}) == null) {
            eVar.d0().g(context, "scope_hide_menu", new b(this, callbackHandler, str, z, swanAppActionBar));
        }
    }

    public final void q(CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, String str2, boolean z, c.a.p0.a.x.g.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{callbackHandler, str, swanAppActionBar, str2, Boolean.valueOf(z), dVar}) == null) {
            if (swanAppActionBar.getRightMenu() == null) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            }
            int t = SwanAppConfigData.t(str2);
            swanAppActionBar.setActionBarFrontColor(t, false);
            c.a.p0.a.q2.d.b C1 = dVar.C1();
            if (C1 == null) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            }
            if (t == -1) {
                C1.m(0, z, false);
            } else {
                boolean z2 = true;
                if (t == -16777216) {
                    C1.m(0, z, true);
                } else {
                    C1.m(0, z, ((t != 1) || !c.a.p0.a.p2.i.a(t)) ? false : false);
                }
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    public final boolean r(SwanAppActionBar swanAppActionBar) {
        InterceptResult invokeL;
        View rightMenu;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, swanAppActionBar)) == null) {
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
