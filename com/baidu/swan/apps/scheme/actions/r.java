package com.baidu.swan.apps.scheme.actions;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class r extends z {
    public r(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/pageScrollTo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
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
        int optInt2 = c.optInt("duration", -1);
        if (optInt <= -1 || optInt2 <= -1) {
            com.baidu.swan.apps.console.c.e("PageScrollToAction", "illegal scrollTop or duration");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
            return false;
        }
        final com.baidu.swan.apps.b.c.d Gw = com.baidu.swan.apps.w.e.GJ().Gw();
        if (Gw != null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(Gw.getWebViewScrollY(), a(Gw, com.baidu.swan.apps.an.z.dip2px(context, optInt)));
            ofInt.setDuration(optInt2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.scheme.actions.r.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Gw.A(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ofInt.start();
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private int a(@NonNull com.baidu.swan.apps.b.c.d dVar, int i) {
        int contentHeight = ((int) (dVar.getContentHeight() * dVar.getScale())) - ((Integer) com.baidu.swan.apps.w.e.GJ().Gx().second).intValue();
        if (contentHeight <= 0) {
            return 0;
        }
        return i > contentHeight ? contentHeight : i;
    }
}
