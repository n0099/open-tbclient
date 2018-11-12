package com.baidu.searchbox.ng.ai.apps.impl.map;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.MapViewItem;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MapViewHelper implements SensorEventListener {
    private static final int SCAN_SPAN_MS = 1000;
    private BDLocation mCurrentLocation;
    private double mLastX;
    private LocationClient mLocationClient;
    private SensorManager mSensorManager;
    private boolean mIsSensorInit = false;
    private boolean mIsTriggerLocation = false;
    private List<MapViewItem> mapViews = new ArrayList(1);

    public MapViewHelper() {
        startLocation();
    }

    public boolean insert(MapViewItem mapViewItem) {
        if (mapViewItem == null) {
            return false;
        }
        this.mapViews.add(mapViewItem);
        return true;
    }

    public boolean remove(String str) {
        MapViewItem find = find(str);
        if (find != null) {
            this.mapViews.remove(find);
            return true;
        }
        return false;
    }

    public MapViewItem find(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (MapViewItem mapViewItem : this.mapViews) {
            if (mapViewItem != null && TextUtils.equals(mapViewItem.id, str)) {
                return mapViewItem;
            }
        }
        return null;
    }

    public void resume() {
        startLocation();
        for (MapViewItem mapViewItem : this.mapViews) {
            mapViewItem.mapView.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (MapViewItem mapViewItem : this.mapViews) {
            mapViewItem.mapView.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.mIsTriggerLocation = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (MapViewItem mapViewItem : this.mapViews) {
                mapViewItem.mapView.onDestroy();
            }
        }
        this.mapViews.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.mLastX) > 1.0d) {
            for (MapViewItem mapViewItem : this.mapViews) {
                MyLocationData locationData = mapViewItem.mapView.getMap().getLocationData();
                if (locationData != null && mapViewItem.isShowLocation) {
                    mapViewItem.mapView.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).accuracy(locationData.accuracy).satellitesNum(locationData.satellitesNum).build());
                    initLocationIfNeed();
                }
            }
        }
        this.mLastX = d;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* loaded from: classes4.dex */
    public class MyLocationListener implements BDLocationListener {
        public MyLocationListener() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null || MapViewHelper.this.mapViews.size() <= 0) {
                MapViewHelper.this.stopLocation();
                return;
            }
            MapViewHelper.this.mCurrentLocation = bDLocation;
            for (MapViewItem mapViewItem : MapViewHelper.this.mapViews) {
                MyLocationData locationData = mapViewItem.mapView.getMap().getLocationData();
                if (locationData != null && mapViewItem.isShowLocation) {
                    mapViewItem.mapView.getMap().setMyLocationData(new MyLocationData.Builder().direction(locationData.direction).accuracy(locationData.accuracy).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(locationData.satellitesNum).build());
                }
            }
        }

        public void onReceivePoi(BDLocation bDLocation) {
        }
    }

    private void initLocationIfNeed() {
        if (this.mLocationClient == null) {
            this.mLocationClient = new LocationClient(AppRuntime.getAppContext());
            this.mLocationClient.registerLocationListener(new MyLocationListener());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.mLocationClient.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.mIsTriggerLocation && this.mLocationClient != null && this.mLocationClient.isStarted()) {
            this.mLocationClient.stop();
            stopSensor();
            AiAppsLog.w("map", "stop location");
        }
    }

    private void startLocation() {
        if (this.mIsTriggerLocation) {
            initLocationIfNeed();
            if (this.mLocationClient != null && !this.mLocationClient.isStarted()) {
                this.mLocationClient.start();
                startSensor();
                AiAppsLog.w("map", "start location");
            }
        }
    }

    private void startSensor() {
        if (!this.mIsSensorInit) {
            this.mSensorManager = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.mSensorManager != null) {
                this.mSensorManager.registerListener(this, this.mSensorManager.getDefaultSensor(3), 2);
                this.mIsSensorInit = true;
            }
        }
    }

    private void stopSensor() {
        if (this.mSensorManager != null && this.mIsSensorInit) {
            this.mSensorManager.unregisterListener(this);
            this.mIsSensorInit = false;
        }
    }

    public boolean isLocationOn() {
        return this.mLocationClient != null && this.mLocationClient.isStarted();
    }

    public BDLocation getCurrentLocation() {
        return this.mCurrentLocation;
    }

    public void triggerLocation(boolean z) {
        if (z) {
            this.mIsTriggerLocation = true;
            startLocation();
            return;
        }
        stopLocation();
        this.mIsTriggerLocation = false;
    }
}
