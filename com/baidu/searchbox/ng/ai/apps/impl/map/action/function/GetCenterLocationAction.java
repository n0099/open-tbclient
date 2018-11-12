package com.baidu.searchbox.ng.ai.apps.impl.map.action.function;

import android.content.Context;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager;
import com.baidu.searchbox.ng.ai.apps.impl.map.MapViewManager;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.MapViewItem;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.MapModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.CoordinateModel;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.webkit.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetCenterLocationAction extends AbsMapBaseAction {
    private static final boolean DEBUG = false;
    private static final String TAG = GetCenterLocationAction.class.getSimpleName();

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction
    protected boolean doAction(Context context, MapModel mapModel, WebView webView, AiApp aiApp, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        AiAppsLog.i("map", "GetCenterLcationAction start");
        AiAppsWebViewManager webViewManager = AiAppsController.getInstance().getWebViewManager(mapModel.slaveId);
        if (webViewManager == null || !(webViewManager instanceof AiAppsSlaveManager)) {
            AiAppsLog.e("map", "WebViewManager is null");
            return false;
        }
        MapViewItem find = MapViewManager.get().getMapViewHelper((AiAppsSlaveManager) webViewManager).find(mapModel.id);
        if (find == null) {
            AiAppsLog.e("map", "can not find map by id " + mapModel.id);
            return false;
        }
        MapStatus mapStatus = find.mapView.getMap().getMapStatus();
        CoordinateModel coordinateModel = new CoordinateModel();
        coordinateModel.latitude = mapStatus.target.latitude;
        coordinateModel.longitude = mapStatus.target.longitude;
        try {
            jSONObject.put(CoordinateModel.LATITUDE, coordinateModel.latitude);
            jSONObject.put(CoordinateModel.LONGITUDE, coordinateModel.longitude);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AiAppsLog.i("map", "GetCenterLocationAction end");
        return true;
    }
}
