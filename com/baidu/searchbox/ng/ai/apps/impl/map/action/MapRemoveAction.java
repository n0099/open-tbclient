package com.baidu.searchbox.ng.ai.apps.impl.map.action;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.impl.map.MapViewManager;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.MapModel;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.webkit.sdk.WebView;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class MapRemoveAction extends AbsMapBaseAction {
    private static final boolean DEBUG = false;
    private static final String TAG = MapRemoveAction.class.getSimpleName();

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction
    protected boolean doAction(Context context, MapModel mapModel, WebView webView, AiApp aiApp, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        AiAppsLog.i("map", "MapRemoveAction start");
        boolean remove = MapViewManager.get().remove(webView, mapModel);
        AiAppsLog.i("map", "MapRemoveAction end");
        return remove;
    }
}
