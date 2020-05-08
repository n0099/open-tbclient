package com.baidu.swan.impl.map;

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
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class b implements SensorEventListener {
    private SensorManager aVk;
    private double cUw;
    private LocationClient cUx;
    private BDLocation cUz;
    private boolean cUy = false;
    private boolean cUA = false;
    private List<com.baidu.swan.impl.map.item.c> cUv = new ArrayList(1);

    public b() {
        azK();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.cUv.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c rm = rm(str);
        if (rm != null) {
            this.cUv.remove(rm);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c rm(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.cUv) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        azK();
        for (com.baidu.swan.impl.map.item.c cVar : this.cUv) {
            cVar.cVF.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.cUv) {
            cVar.cVF.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.cUA = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.cUv) {
                cVar.cVF.onDestroy();
            }
        }
        this.cUv.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.cUw) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.cUv) {
                MyLocationData locationData = cVar.cVF.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.cVF.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    azJ();
                }
            }
        }
        this.cUw = d;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* loaded from: classes12.dex */
    public class a implements BDLocationListener {
        public a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null || b.this.cUv.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.cUz = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.cUv) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.cVF.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void azJ() {
        if (this.cUx == null) {
            this.cUx = new LocationClient(AppRuntime.getAppContext());
            this.cUx.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.cUx.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.cUA && this.cUx != null && this.cUx.isStarted()) {
            this.cUx.stop();
            azM();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void azK() {
        if (this.cUA) {
            azJ();
            if (this.cUx != null && !this.cUx.isStarted()) {
                this.cUx.start();
                azL();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void azL() {
        if (!this.cUy) {
            this.aVk = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.aVk != null) {
                this.aVk.registerListener(this, this.aVk.getDefaultSensor(3), 2);
                this.cUy = true;
            }
        }
    }

    private void azM() {
        if (this.aVk != null && this.cUy) {
            this.aVk.unregisterListener(this);
            this.cUy = false;
        }
    }

    public boolean azN() {
        return this.cUx != null && this.cUx.isStarted();
    }

    public BDLocation azO() {
        return this.cUz;
    }

    public void fI(boolean z) {
        if (z) {
            this.cUA = true;
            azK();
            return;
        }
        stopLocation();
        this.cUA = false;
    }
}
