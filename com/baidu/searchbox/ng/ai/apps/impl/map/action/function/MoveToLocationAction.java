package com.baidu.searchbox.ng.ai.apps.impl.map.action.function;

import android.content.Context;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager;
import com.baidu.searchbox.ng.ai.apps.impl.map.MapViewHelper;
import com.baidu.searchbox.ng.ai.apps.impl.map.MapViewManager;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.helper.LocationPermissionHelper;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.MapViewItem;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.MapModel;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLocationIoc;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.location.LocationResult;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.webkit.sdk.WebView;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class MoveToLocationAction extends AbsMapBaseAction {
    private static final boolean DEBUG = false;
    private static final String TAG = MoveToLocationAction.class.getSimpleName();

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction
    protected boolean doAction(final Context context, MapModel mapModel, WebView webView, AiApp aiApp, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        AiAppsLog.i("map", "MoveToLocationAction start");
        AiAppsWebViewManager webViewManager = AiAppsController.getInstance().getWebViewManager(mapModel.slaveId);
        if (webViewManager == null || !(webViewManager instanceof AiAppsSlaveManager)) {
            AiAppsLog.e("map", "WebViewManager is null");
            return false;
        }
        final MapViewHelper mapViewHelper = MapViewManager.get().getMapViewHelper((AiAppsSlaveManager) webViewManager);
        final MapViewItem find = mapViewHelper.find(mapModel.id);
        if (find == null) {
            AiAppsLog.e("map", "can not find map by id " + mapModel.id);
            return false;
        } else if (!find.isShowLocation) {
            AiAppsLog.w("map", "can not move to location because showLocation is not set");
            return false;
        } else {
            BDLocation currentLocation = mapViewHelper.getCurrentLocation();
            if (currentLocation == null || !mapViewHelper.isLocationOn()) {
                LocationPermissionHelper.checkLocationPermission(context, new LocationPermissionHelper.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.action.function.MoveToLocationAction.1
                    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.helper.LocationPermissionHelper.PermissionCallback
                    public void onSuccess() {
                        AiAppsLog.w("map", "location permission success");
                        MoveToLocationAction.this.doRequestLocation(context, find, mapViewHelper);
                    }

                    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.helper.LocationPermissionHelper.PermissionCallback
                    public void onFail() {
                        AiAppsLog.w("map", "location permission fail");
                    }
                });
                return true;
            }
            find.mapView.getMap().animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude())));
            find.mapView.getMap().setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
            find.mapView.getMap().setMyLocationEnabled(true);
            find.mapView.getMap().setMyLocationData(new MyLocationData.Builder().accuracy(currentLocation.getRadius()).latitude(currentLocation.getLatitude()).longitude(currentLocation.getLongitude()).build());
            AiAppsLog.i("map", "MoveToLocationAction end");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRequestLocation(Context context, final MapViewItem mapViewItem, final MapViewHelper mapViewHelper) {
        AiAppsRuntime.getLocationRuntime().requestLocation("gcj02", true, false, new IAiAppLocationIoc.LocationListener() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.action.function.MoveToLocationAction.2
            @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLocationIoc.LocationListener
            public void onSuccess(LocationResult locationResult) {
                AiAppsLog.i("map", "get location " + locationResult.toJSON().toString());
                BaiduMap map = mapViewItem.mapView.getMap();
                map.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(locationResult.latitude, locationResult.longitude)));
                map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                map.setMyLocationEnabled(true);
                map.setMyLocationData(new MyLocationData.Builder().accuracy((float) locationResult.accuracy).latitude(locationResult.latitude).longitude(locationResult.longitude).build());
                mapViewHelper.triggerLocation(true);
            }

            @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLocationIoc.LocationListener
            public void onFailed(int i) {
                AiAppsLog.i("map", "get location error " + i);
            }
        });
    }
}
