package b.a.p0.a.c2.f.j0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.v2.n0;
import b.a.p0.a.z1.b.c.a;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes.dex */
public class d extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/showLoading");
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
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4160b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
            }
            if (eVar != null && eVar.c0()) {
                boolean z = a0.f4160b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                return false;
            } else if (!(context instanceof SwanAppActivity)) {
                b.a.p0.a.e0.d.b("showLoading", "context not support");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    b.a.p0.a.e0.d.b("showLoading", "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                b.a.p0.a.e0.d.g("showLoading", "handleShowLoading : joParams = \n" + optParamsAsJo);
                String optString = optParamsAsJo.optString("title");
                if (TextUtils.isEmpty(optString)) {
                    b.a.p0.a.e0.d.b("showLoading", "none title");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                boolean optBoolean = optParamsAsJo.optBoolean("mask", false);
                g swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
                if (swanAppFragmentManager == null) {
                    b.a.p0.a.e0.d.b("showLoading", "none fragment");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none fragment");
                    return false;
                }
                b.a.p0.a.h0.g.d m = swanAppFragmentManager.m();
                if (!(m instanceof a.InterfaceC0478a)) {
                    b.a.p0.a.e0.d.b("showLoading", "fragment not support");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment not support");
                    return false;
                }
                b.a.p0.a.z1.b.c.a floatLayer = ((a.InterfaceC0478a) m).getFloatLayer();
                if (floatLayer == null) {
                    b.a.p0.a.e0.d.b("showLoading", "can't get floatLayer");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can't create floatLayer");
                    return false;
                }
                View d2 = floatLayer.d();
                if (d2 instanceof LoadingView) {
                    loadingView = (LoadingView) d2;
                } else {
                    loadingView = new LoadingView(context);
                    FrameLayout frameLayout = new FrameLayout(context);
                    frameLayout.setPadding(0, 0, 0, n0.g(160.0f));
                    frameLayout.addView(loadingView);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    floatLayer.k(frameLayout, layoutParams);
                }
                if (!TextUtils.isEmpty(optString)) {
                    loadingView.setMsg(optString);
                }
                floatLayer.h(optBoolean);
                b.a.p0.a.e0.d.g("showLoading", "show loading success");
                unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
