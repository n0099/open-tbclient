package com.baidu.searchbox.ng.ai.apps.impl.map;

import android.content.Context;
import com.baidu.searchbox.bdmapsdk.BdMapRuntime;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.helper.MapViewInitHelper;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.MapViewItem;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.MapModel;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewContainer;
import com.baidu.searchbox.ng.ai.apps.view.container.util.NAViewFinder;
import com.baidu.webkit.sdk.WebView;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class MapViewManager {
    private static final boolean DEBUG = false;
    private static final String TAG = MapViewManager.class.getSimpleName();
    private static volatile MapViewManager sInstance;
    private Map<AiAppsSlaveManager, MapViewHelper> mHelpers;

    private MapViewManager() {
        BdMapRuntime.makeSureMapSDKInit();
        this.mHelpers = new HashMap();
    }

    public static MapViewManager get() {
        if (sInstance == null) {
            synchronized (MapViewManager.class) {
                if (sInstance == null) {
                    sInstance = new MapViewManager();
                }
            }
        }
        return sInstance;
    }

    public boolean create(Context context, WebView webView, MapModel mapModel) {
        AiAppsLog.i("map", "map create start");
        if (webView == null || mapModel == null || !mapModel.isValid()) {
            AiAppsLog.e("map", "model data is invalid");
            return false;
        }
        AiAppsWebViewManager webViewManager = AiAppsController.getInstance().getWebViewManager(mapModel.slaveId);
        if (webViewManager == null || !(webViewManager instanceof AiAppsSlaveManager)) {
            AiAppsLog.e("map", "WebViewManager is null");
            return false;
        }
        MapViewHelper mapViewHelper = getMapViewHelper((AiAppsSlaveManager) webViewManager);
        if (mapViewHelper.find(mapModel.id) != null) {
            AiAppsLog.e("map", "map with id " + mapModel.id + " exist");
            return false;
        }
        MapViewItem makeOne = MapViewItem.makeOne(context, mapModel);
        if (makeOne == null) {
            AiAppsLog.e("map", "map with id " + mapModel.id + " model is invalid");
            return false;
        } else if (!new AiAppsNAViewContainer(webView.getContext()).insertView(makeOne.mapView, mapModel)) {
            AiAppsLog.e("map", "map with id " + mapModel.id + " create fail");
            return false;
        } else if (mapViewHelper.insert(makeOne)) {
            AiAppsLog.i("map", "map with id " + mapModel.id + " init start");
            MapViewInitHelper.initMapView(context, makeOne, mapModel, mapViewHelper);
            AiAppsLog.i("map", "map with id " + mapModel.id + " init end");
            AiAppsLog.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(WebView webView, MapModel mapModel) {
        AiAppsLog.i("map", "map remove start");
        if (webView == null || mapModel == null) {
            AiAppsLog.e("map", "webView is null or mapModel is null");
            return false;
        }
        AiAppsWebViewManager webViewManager = AiAppsController.getInstance().getWebViewManager(mapModel.slaveId);
        if (webViewManager == null || !(webViewManager instanceof AiAppsSlaveManager)) {
            AiAppsLog.e("map", "WebViewManager is null");
            return false;
        }
        MapViewHelper mapViewHelper = getMapViewHelper((AiAppsSlaveManager) webViewManager);
        if (mapViewHelper.find(mapModel.id) == null) {
            AiAppsLog.e("map", "remove map with id " + mapModel.id + " not exist");
            return false;
        } else if (mapViewHelper.remove(mapModel.id)) {
            AiAppsLog.i("map", "map remove end");
            AiAppsNAViewContainer findNAViewContainer = NAViewFinder.findNAViewContainer(mapModel, null);
            return findNAViewContainer != null && findNAViewContainer.removeView();
        } else {
            return false;
        }
    }

    public boolean update(Context context, WebView webView, MapModel mapModel) {
        AiAppsLog.i("map", "map update start");
        if (webView == null || mapModel == null) {
            AiAppsLog.e("map", "webView is null or mapModel is null");
            return false;
        }
        AiAppsWebViewManager webViewManager = AiAppsController.getInstance().getWebViewManager(mapModel.slaveId);
        if (webViewManager == null || !(webViewManager instanceof AiAppsSlaveManager)) {
            AiAppsLog.e("map", "WebViewManager is null");
            return false;
        }
        MapViewHelper mapViewHelper = getMapViewHelper((AiAppsSlaveManager) webViewManager);
        MapViewItem find = mapViewHelper.find(mapModel.id);
        if (find == null) {
            AiAppsLog.e("map", "remove map with id " + mapModel.id + " not exist");
            return false;
        }
        find.clear();
        MapViewInitHelper.initMapView(context, find, mapModel, mapViewHelper);
        AiAppsLog.i("map", "map update end");
        AiAppsNAViewContainer findNAViewContainer = NAViewFinder.findNAViewContainer(mapModel, null);
        return findNAViewContainer != null && findNAViewContainer.updateView(mapModel);
    }

    public synchronized MapViewHelper getMapViewHelper(AiAppsSlaveManager aiAppsSlaveManager) {
        MapViewHelper mapViewHelper;
        if (aiAppsSlaveManager == null) {
            mapViewHelper = null;
        } else {
            mapViewHelper = this.mHelpers.get(aiAppsSlaveManager);
            if (mapViewHelper == null) {
                mapViewHelper = new MapViewHelper();
                this.mHelpers.put(aiAppsSlaveManager, mapViewHelper);
            }
        }
        return mapViewHelper;
    }

    public synchronized void releaseMapViewHelper(AiAppsSlaveManager aiAppsSlaveManager) {
        if (aiAppsSlaveManager != null) {
            MapViewHelper remove = this.mHelpers.remove(aiAppsSlaveManager);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
