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
public class GetRegionAction extends AbsMapBaseAction {
    private static final boolean DEBUG = false;
    public static final String NORTH_EAST = "northeast";
    public static final String SOURCE_WEST = "southwest";
    private static final String TAG = GetRegionAction.class.getSimpleName();

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction
    protected boolean doAction(Context context, MapModel mapModel, WebView webView, AiApp aiApp, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        AiAppsLog.i("map", "GetRegionAction start");
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
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put(CoordinateModel.LATITUDE, mapStatus.bound.southwest.latitude);
            jSONObject3.put(CoordinateModel.LONGITUDE, mapStatus.bound.southwest.longitude);
            jSONObject2.put(CoordinateModel.LATITUDE, mapStatus.bound.northeast.latitude);
            jSONObject2.put(CoordinateModel.LONGITUDE, mapStatus.bound.northeast.longitude);
            jSONObject.put(SOURCE_WEST, jSONObject3);
            jSONObject.put(NORTH_EAST, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AiAppsLog.i("map", "GetRegionAction end");
        return true;
    }
}
