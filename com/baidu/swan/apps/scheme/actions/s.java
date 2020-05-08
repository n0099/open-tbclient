package com.baidu.swan.apps.scheme.actions;

import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.as.af;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class s extends ab {
    public s(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/pageScrollTo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null || context == null) {
            com.baidu.swan.apps.console.c.e("PageScrollToAction", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            com.baidu.swan.apps.console.c.i("PageScrollToAction", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
            return false;
        }
        int optInt = b.optInt("scrollTop", -1);
        int optInt2 = b.optInt("duration", -1);
        if (optInt <= -1 || optInt2 <= -1) {
            com.baidu.swan.apps.console.c.e("PageScrollToAction", "illegal scrollTop or duration");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
            return false;
        }
        final com.baidu.swan.apps.adaptation.b.d aev = com.baidu.swan.apps.y.f.aeJ().aev();
        if (aev != null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(aev.getWebViewScrollY(), com.baidu.swan.apps.api.module.e.d.a(aev, af.dip2px(context, optInt)));
            ofInt.setDuration(optInt2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.scheme.actions.s.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    aev.webViewScrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ofInt.start();
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
