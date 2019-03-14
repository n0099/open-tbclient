package com.baidu.swan.apps.scheme.actions.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.c.e;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends y {
    public c(j jVar) {
        super(jVar, "/swan/showLoading");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
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
        e uz = ((SwanAppActivity) context).uz();
        if (uz == null) {
            com.baidu.swan.apps.console.c.e("showLoading", "none fragment");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none fragment");
            return false;
        }
        com.baidu.swan.apps.core.c.b yO = uz.yO();
        if (!(yO instanceof a.InterfaceC0164a)) {
            com.baidu.swan.apps.console.c.e("showLoading", "fragment not support");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment not support");
            return false;
        }
        com.baidu.swan.apps.res.widget.floatlayer.a uv = ((a.InterfaceC0164a) yO).uv();
        if (uv == null) {
            com.baidu.swan.apps.console.c.e("showLoading", "can't get floatLayer");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can't create floatLayer");
            return false;
        }
        View view = uv.getView();
        if (view instanceof LoadingView) {
            loadingView = (LoadingView) view;
        } else {
            loadingView = new LoadingView(context);
            uv.ae(loadingView);
        }
        if (!TextUtils.isEmpty(optString)) {
            loadingView.setMsg(optString);
        }
        uv.setMask(optBoolean);
        com.baidu.swan.apps.console.c.i("showLoading", "show loading success");
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
