package com.baidu.swan.apps.scheme.actions;

import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.ubc.UBC;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class r extends y {
    public r(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/pageScrollTo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null || context == null) {
            com.baidu.swan.apps.console.c.e("PageScrollToAction", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject c = c(unitedSchemeEntity, "params");
        if (c == null) {
            com.baidu.swan.apps.console.c.i("PageScrollToAction", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
            return false;
        }
        int optInt = c.optInt("scrollTop", -1);
        int optInt2 = c.optInt(UBC.CONTENT_KEY_DURATION, -1);
        if (optInt <= -1 || optInt2 <= -1) {
            com.baidu.swan.apps.console.c.e("PageScrollToAction", "illegal scrollTop or duration");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
            return false;
        }
        final com.baidu.swan.apps.b.c.d DN = com.baidu.swan.apps.w.e.Ea().DN();
        if (DN != null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(DN.getWebViewScrollY(), com.baidu.swan.apps.an.x.dip2px(context, optInt));
            ofInt.setDuration(optInt2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.scheme.actions.r.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    DN.z(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ofInt.start();
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
