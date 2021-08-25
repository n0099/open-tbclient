package c.a.o0.a.c2.f.j0;

import android.content.Context;
import android.widget.FrameLayout;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.h0.g.g;
import c.a.o0.a.z1.b.c.a;
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
@Deprecated
/* loaded from: classes.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/hideLoading");
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

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4738b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
            }
            if (!(context instanceof SwanAppActivity)) {
                c.a.o0.a.e0.d.b("hideLoading", "context not support");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
                return false;
            }
            g swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
            if (swanAppFragmentManager == null) {
                c.a.o0.a.e0.d.b("hideLoading", "none fragmentManger");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none fragmentManger");
                return false;
            }
            c.a.o0.a.h0.g.d m = swanAppFragmentManager.m();
            if (!(m instanceof a.InterfaceC0481a)) {
                c.a.o0.a.e0.d.b("hideLoading", "fragment not support");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment not support");
                return false;
            } else if (m.q() == null) {
                c.a.o0.a.e0.d.b("hideLoading", "fragment has detached");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment has detached");
                return false;
            } else {
                c.a.o0.a.z1.b.c.a floatLayer = ((a.InterfaceC0481a) m).getFloatLayer();
                if (floatLayer != null && (floatLayer.e() instanceof FrameLayout) && (((FrameLayout) floatLayer.e()).getChildAt(0) instanceof LoadingView)) {
                    floatLayer.g();
                }
                c.a.o0.a.e0.d.g("hideLoading", "hide loading success");
                unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
