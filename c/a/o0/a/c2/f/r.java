package c.a.o0.a.c2.f;

import android.animation.ValueAnimator;
import android.content.Context;
import c.a.o0.a.v2.n0;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.p.e.c f5052e;

        public a(r rVar, c.a.o0.a.p.e.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5052e = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f5052e.webViewScrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(c.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/pageScrollTo");
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
            if (eVar != null && context != null) {
                JSONObject a2 = a0.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    c.a.o0.a.e0.d.g("PageScrollToAction", "params is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                    return false;
                }
                int optInt = a2.optInt("scrollTop", -1);
                int optInt2 = a2.optInt("duration", -1);
                if (optInt > -1 && optInt2 > -1) {
                    c.a.o0.a.p.e.c h2 = c.a.o0.a.g1.f.V().h();
                    if (h2 != null) {
                        ValueAnimator ofInt = ValueAnimator.ofInt(h2.getWebViewScrollY(), c.a.o0.a.u.e.g.d.s(h2, n0.f(context, optInt)));
                        ofInt.setDuration(optInt2);
                        ofInt.addUpdateListener(new a(this, h2));
                        ofInt.start();
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
                c.a.o0.a.e0.d.b("PageScrollToAction", "illegal scrollTop or duration");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
                return false;
            }
            c.a.o0.a.e0.d.b("PageScrollToAction", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
