package com.baidu.swan.apps.scheme.actions.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes7.dex */
public class d extends aa {
    public d(j jVar) {
        super(jVar, "/swanAPI/showLoading");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        LoadingView loadingView;
        if (DEBUG) {
            Log.d("ShowLoadingAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (eVar != null && eVar.aiS()) {
            if (DEBUG) {
                Log.d("ShowLoadingAction", "ShowLoadingAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        } else if (!(context instanceof SwanAppActivity)) {
            com.baidu.swan.apps.console.c.e("showLoading", "context not support");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
            return false;
        } else {
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
            f afe = ((SwanAppActivity) context).afe();
            if (afe == null) {
                com.baidu.swan.apps.console.c.e("showLoading", "none fragment");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none fragment");
                return false;
            }
            com.baidu.swan.apps.core.d.c aot = afe.aot();
            if (!(aot instanceof a.InterfaceC0468a)) {
                com.baidu.swan.apps.console.c.e("showLoading", "fragment not support");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment not support");
                return false;
            }
            com.baidu.swan.apps.res.widget.floatlayer.a aeZ = ((a.InterfaceC0468a) aot).aeZ();
            if (aeZ == null) {
                com.baidu.swan.apps.console.c.e("showLoading", "can't get floatLayer");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can't create floatLayer");
                return false;
            }
            View view = aeZ.getView();
            if (view instanceof LoadingView) {
                loadingView = (LoadingView) view;
            } else {
                loadingView = new LoadingView(context);
                FrameLayout frameLayout = new FrameLayout(context);
                frameLayout.setPadding(0, 0, 0, ah.M(160.0f));
                frameLayout.addView(loadingView);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                aeZ.a(frameLayout, layoutParams);
            }
            if (!TextUtils.isEmpty(optString)) {
                loadingView.setMsg(optString);
            }
            aeZ.setMask(optBoolean);
            com.baidu.swan.apps.console.c.i("showLoading", "show loading success");
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
