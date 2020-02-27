package com.baidu.swan.apps.scheme.actions.e;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
@Deprecated
/* loaded from: classes11.dex */
public class a extends ab {
    public a(j jVar) {
        super(jVar, "/swanAPI/hideLoading");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("HideLoadingAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (!(context instanceof SwanAppActivity)) {
            com.baidu.swan.apps.console.c.e("hideLoading", "context not support");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
            return false;
        }
        com.baidu.swan.apps.core.d.e GA = ((SwanAppActivity) context).GA();
        if (GA == null) {
            com.baidu.swan.apps.console.c.e("hideLoading", "none fragmentManger");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none fragmentManger");
            return false;
        }
        com.baidu.swan.apps.core.d.b Ol = GA.Ol();
        if (!(Ol instanceof a.InterfaceC0283a)) {
            com.baidu.swan.apps.console.c.e("hideLoading", "fragment not support");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment not support");
            return false;
        } else if (Ol.getContext() == null) {
            com.baidu.swan.apps.console.c.e("hideLoading", "fragment has detached");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment has detached");
            return false;
        } else {
            com.baidu.swan.apps.res.widget.floatlayer.a Gv = ((a.InterfaceC0283a) Ol).Gv();
            if (Gv != null && (Gv.getView() instanceof LoadingView)) {
                Gv.reset();
            }
            com.baidu.swan.apps.console.c.i("hideLoading", "hide loading success");
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
