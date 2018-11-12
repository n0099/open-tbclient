package com.baidu.searchbox.ng.ai.apps.impl.map.action.function;

import android.content.Context;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager;
import com.baidu.searchbox.ng.ai.apps.impl.map.MapViewManager;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.MapViewItem;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.IncludePointsModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.MapModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.CoordinateModel;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.webkit.sdk.WebView;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class IncludePointsAction extends AbsMapBaseAction {
    private static final boolean DEBUG = false;
    private static final String TAG = IncludePointsAction.class.getSimpleName();

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction
    protected boolean doAction(Context context, MapModel mapModel, WebView webView, AiApp aiApp, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        AiAppsLog.i("map", "IncludePointsAction start");
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
        AiAppsLog.i("map", "IncludePointsAction end");
        return includePoints((IncludePointsModel) mapModel, find, jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction
    public IncludePointsModel getModel(UnitedSchemeEntity unitedSchemeEntity) {
        IncludePointsModel includePointsModel;
        JSONException e;
        JSONObject jSONObject;
        if (unitedSchemeEntity == null) {
            return null;
        }
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params == null || params.isEmpty()) {
            AiAppsLog.e("map", "entity Params is empty");
            return null;
        }
        try {
            jSONObject = new JSONObject(params.get("params"));
            includePointsModel = new IncludePointsModel();
        } catch (JSONException e2) {
            includePointsModel = null;
            e = e2;
        }
        try {
            includePointsModel.parseFromJson(jSONObject);
            return includePointsModel;
        } catch (JSONException e3) {
            e = e3;
            e.printStackTrace();
            AiAppsLog.e("map", "Params json parse error");
            return includePointsModel;
        }
    }

    private boolean includePoints(IncludePointsModel includePointsModel, MapViewItem mapViewItem, JSONObject jSONObject) {
        if (includePointsModel == null || !includePointsModel.isValid()) {
            return false;
        }
        BaiduMap map = mapViewItem.mapView.getMap();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Iterator<CoordinateModel> it = includePointsModel.points.iterator();
        while (it.hasNext()) {
            CoordinateModel next = it.next();
            builder.include(new LatLng(next.latitude, next.longitude));
        }
        LatLngBounds build = builder.build();
        int i = includePointsModel.padding[0];
        int i2 = includePointsModel.padding[0];
        int i3 = includePointsModel.padding[0];
        int i4 = includePointsModel.padding[0];
        int i5 = map.getMapStatus().winRound.bottom - map.getMapStatus().winRound.top;
        map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, ((map.getMapStatus().winRound.right - map.getMapStatus().winRound.left) - i4) - i2, (i5 - i) - i3));
        return true;
    }
}
