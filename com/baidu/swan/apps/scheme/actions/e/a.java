package com.baidu.swan.apps.scheme.actions.e;

import android.content.Context;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
@Deprecated
/* loaded from: classes25.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/hideLoading");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("HideLoadingAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (!(context instanceof SwanAppActivity)) {
            com.baidu.swan.apps.console.c.e("hideLoading", "context not support");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
            return false;
        }
        f aim = ((SwanAppActivity) context).aim();
        if (aim == null) {
            com.baidu.swan.apps.console.c.e("hideLoading", "none fragmentManger");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none fragmentManger");
            return false;
        }
        com.baidu.swan.apps.core.d.c arB = aim.arB();
        if (!(arB instanceof a.InterfaceC0480a)) {
            com.baidu.swan.apps.console.c.e("hideLoading", "fragment not support");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment not support");
            return false;
        } else if (arB.getContext() == null) {
            com.baidu.swan.apps.console.c.e("hideLoading", "fragment has detached");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment has detached");
            return false;
        } else {
            com.baidu.swan.apps.res.widget.floatlayer.a aih = ((a.InterfaceC0480a) arB).aih();
            if (aih != null && (aih.getView() instanceof FrameLayout) && (((FrameLayout) aih.getView()).getChildAt(0) instanceof LoadingView)) {
                aih.reset();
            }
            com.baidu.swan.apps.console.c.i("hideLoading", "hide loading success");
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
