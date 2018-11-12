package com.baidu.searchbox.ng.ai.apps.impl.map.action.function;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager;
import com.baidu.searchbox.ng.ai.apps.impl.map.MapViewManager;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.MapViewItem;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.MarkerViewItem;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.MapModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.TranslateMarkerModel;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.webkit.sdk.WebView;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TranslateMarkerAction extends AbsMapBaseAction {
    private static final String CB = "cb";
    private static final boolean DEBUG = false;
    private static final String TAG = TranslateMarkerAction.class.getSimpleName();
    private String mCallback = "";

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction
    protected boolean doAction(Context context, MapModel mapModel, WebView webView, AiApp aiApp, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        AiAppsLog.i("map", "TranslateMarkerAction start");
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
        return translateMarker((TranslateMarkerModel) mapModel, find, callbackHandler);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction
    public TranslateMarkerModel getModel(UnitedSchemeEntity unitedSchemeEntity) {
        TranslateMarkerModel translateMarkerModel;
        JSONException e;
        JSONObject jSONObject;
        if (unitedSchemeEntity == null) {
            return null;
        }
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params == null || params.isEmpty()) {
            AiAppsLog.e("map", "entity params is empty");
            return null;
        }
        try {
            jSONObject = new JSONObject(params.get("params"));
            translateMarkerModel = new TranslateMarkerModel();
        } catch (JSONException e2) {
            translateMarkerModel = null;
            e = e2;
        }
        try {
            translateMarkerModel.parseFromJson(jSONObject);
            this.mCallback = jSONObject.optString("cb");
            return translateMarkerModel;
        } catch (JSONException e3) {
            e = e3;
            e.printStackTrace();
            AiAppsLog.e("map", "entity params json parse error");
            return translateMarkerModel;
        }
    }

    private boolean translateMarker(TranslateMarkerModel translateMarkerModel, MapViewItem mapViewItem, final CallbackHandler callbackHandler) {
        if (!translateMarkerModel.isValid()) {
            return false;
        }
        LatLng latLng = new LatLng(translateMarkerModel.coordinate.latitude, translateMarkerModel.coordinate.longitude);
        List<MarkerViewItem> markerViewItem = mapViewItem.getMarkerViewItem(translateMarkerModel.markId);
        AiAppsLog.i("map", "TranslateMarkerAction animation start");
        if (markerViewItem != null) {
            for (MarkerViewItem markerViewItem2 : markerViewItem) {
                markerViewItem2.translateMarkerWithAnimation(mapViewItem, latLng, translateMarkerModel.duration, new MarkerViewItem.AnimationEndCallback() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.action.function.TranslateMarkerAction.1
                    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.item.MarkerViewItem.AnimationEndCallback
                    public void onAnimationEnd() {
                        if (!TextUtils.isEmpty(TranslateMarkerAction.this.mCallback)) {
                            callbackHandler.handleSchemeDispatchCallback(TranslateMarkerAction.this.mCallback, "");
                        }
                        AiAppsLog.i("map", "TranslateMarkerAction animation end");
                    }
                });
            }
        }
        AiAppsLog.i("map", "TranslateMarkerAction end");
        return true;
    }
}
