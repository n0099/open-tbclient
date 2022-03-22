package c.a.n0.a.v1.f.k0;

import android.content.Context;
import android.util.Log;
import android.view.View;
import c.a.n0.a.p2.n0;
import c.a.n0.a.s0.b;
import c.a.n0.a.v1.e;
import c.a.n0.a.v1.f.z;
import c.a.n0.a.w0.f;
import c.a.n0.a.x.g.d;
import c.a.n0.a.x.g.g;
import com.baidu.android.imsdk.internal.Constants;
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
import com.kwad.sdk.core.config.item.TipsConfigItem;
import com.tachikoma.core.component.anim.AnimationProperty;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/getMenuButtonBoundingClientRect");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            if (z.f6924b) {
                Log.d("GetMenuButtonBounding", "handle entity: " + unitedSchemeEntity.toString());
            }
            g V = f.U().V();
            if (V == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            d m = V.m();
            if (m == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (eVar.v0()) {
                View r = b.i().r(m);
                if (r == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                unitedSchemeEntity.result = j(r);
                return true;
            } else {
                SwanAppActionBar I1 = m.I1();
                if (I1 == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                View rightMenu = I1.getRightMenu();
                if (rightMenu == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                unitedSchemeEntity.result = j(rightMenu);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final JSONObject j(View view) {
        InterceptResult invokeL;
        JSONObject wrapCallbackParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
            int P = L != null ? L.v0() : false ? 0 : (int) (n0.P(n0.t()) + 0.5f);
            int P2 = (int) (n0.P(view.getLeft()) + 0.5f);
            int P3 = (int) (n0.P(view.getRight()) + 0.5f);
            int P4 = ((int) (n0.P(view.getTop()) + 0.5f)) + P;
            int P5 = ((int) (n0.P(view.getBottom()) + 0.5f)) + P;
            int i = P3 - P2;
            int i2 = P5 - P4;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("width", i);
                jSONObject.put("height", i2);
                jSONObject.put("left", P2);
                jSONObject.put("right", P3);
                jSONObject.put(AnimationProperty.TOP, P4);
                jSONObject.put(TipsConfigItem.TipConfigData.BOTTOM, P5);
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            } catch (JSONException e2) {
                if (z.f6924b) {
                    e2.printStackTrace();
                }
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
            }
            if (z.f6924b) {
                Log.e("GetMenuButtonBounding", wrapCallbackParams.toString());
            }
            return wrapCallbackParams;
        }
        return (JSONObject) invokeL.objValue;
    }
}
