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
    private SensorManager aVf;
    private double cUr;
    private LocationClient cUs;
    private BDLocation cUu;
    private boolean cUt = false;
    private boolean cUv = false;
    private List<com.baidu.swan.impl.map.item.c> cUq = new ArrayList(1);

    public b() {
        azK();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.cUq.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c rm = rm(str);
        if (rm != null) {
            this.cUq.remove(rm);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c rm(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.cUq) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        azK();
        for (com.baidu.swan.impl.map.item.c cVar : this.cUq) {
            cVar.cVA.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.cUq) {
            cVar.cVA.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.cUv = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.cUq) {
                cVar.cVA.onDestroy();
            }
        }
        this.cUq.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.cUr) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.cUq) {
                MyLocationData locationData = cVar.cVA.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.cVA.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    azJ();
                }
            }
        }
        this.cUr = d;
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
            if (bDLocation == null || b.this.cUq.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.cUu = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.cUq) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.cVA.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void azJ() {
        if (this.cUs == null) {
            this.cUs = new LocationClient(AppRuntime.getAppContext());
            this.cUs.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.cUs.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.cUv && this.cUs != null && this.cUs.isStarted()) {
            this.cUs.stop();
            azM();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void azK() {
        if (this.cUv) {
            azJ();
            if (this.cUs != null && !this.cUs.isStarted()) {
                this.cUs.start();
                azL();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void azL() {
        if (!this.cUt) {
            this.aVf = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.aVf != null) {
                this.aVf.registerListener(this, this.aVf.getDefaultSensor(3), 2);
                this.cUt = true;
            }
        }
    }

    private void azM() {
        if (this.aVf != null && this.cUt) {
            this.aVf.unregisterListener(this);
            this.cUt = false;
        }
    }

    public boolean azN() {
        return this.cUs != null && this.cUs.isStarted();
    }

    public BDLocation azO() {
        return this.cUu;
    }

    public void fI(boolean z) {
        if (z) {
            this.cUv = true;
            azK();
            return;
        }
        stopLocation();
        this.cUv = false;
    }
}
