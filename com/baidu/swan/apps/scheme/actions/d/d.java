package com.baidu.swan.apps.scheme.actions.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends z {
    public d(j jVar) {
        super(jVar, "/swan/showLoading");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        LoadingView loadingView;
        if (DEBUG) {
            Log.d("ShowLoadingAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (!(context instanceof SwanAppActivity)) {
            com.baidu.swan.apps.console.c.e("showLoading", "context not support");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("showLoading", "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        com.baidu.swan.apps.console.c.i("showLoading", "handleShowLoading : joParams = \n" + optParamsAsJo);
        String optString = optParamsAsJo.optString("title");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("showLoading", "none title");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        boolean optBoolean = optParamsAsJo.optBoolean("mask", false);
        com.baidu.swan.apps.core.d.e vi = ((SwanAppActivity) context).vi();
        if (vi == null) {
            com.baidu.swan.apps.console.c.e("showLoading", "none fragment");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none fragment");
            return false;
        }
        com.baidu.swan.apps.core.d.b zK = vi.zK();
        if (!(zK instanceof a.InterfaceC0170a)) {
            com.baidu.swan.apps.console.c.e("showLoading", "fragment not support");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment not support");
            return false;
        }
        com.baidu.swan.apps.res.widget.floatlayer.a ve = ((a.InterfaceC0170a) zK).ve();
        if (ve == null) {
            com.baidu.swan.apps.console.c.e("showLoading", "can't get floatLayer");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can't create floatLayer");
            return false;
        }
        View view = ve.getView();
        if (view instanceof LoadingView) {
            loadingView = (LoadingView) view;
        } else {
            loadingView = new LoadingView(context);
            ve.ae(loadingView);
        }
        if (!TextUtils.isEmpty(optString)) {
            loadingView.setMsg(optString);
        }
        ve.setMask(optBoolean);
        com.baidu.swan.apps.console.c.i("showLoading", "show loading success");
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
