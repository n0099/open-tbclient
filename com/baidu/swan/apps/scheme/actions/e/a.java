package com.baidu.swan.apps.scheme.actions.e;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
@Deprecated
/* loaded from: classes11.dex */
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
        com.baidu.swan.apps.core.d.e QH = ((SwanAppActivity) context).QH();
        if (QH == null) {
            com.baidu.swan.apps.console.c.e("hideLoading", "none fragmentManger");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none fragmentManger");
            return false;
        }
        com.baidu.swan.apps.core.d.b YP = QH.YP();
        if (!(YP instanceof a.InterfaceC0377a)) {
            com.baidu.swan.apps.console.c.e("hideLoading", "fragment not support");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment not support");
            return false;
        } else if (YP.getContext() == null) {
            com.baidu.swan.apps.console.c.e("hideLoading", "fragment has detached");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment has detached");
            return false;
        } else {
            com.baidu.swan.apps.res.widget.floatlayer.a QC = ((a.InterfaceC0377a) YP).QC();
            if (QC != null && (QC.getView() instanceof LoadingView)) {
                QC.reset();
            }
            com.baidu.swan.apps.console.c.i("hideLoading", "hide loading success");
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
