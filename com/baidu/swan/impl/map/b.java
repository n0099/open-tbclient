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
/* loaded from: classes24.dex */
public class b implements SensorEventListener {
    private SensorManager bBc;
    private double eaR;
    private LocationClient eaS;
    private BDLocation eaU;
    private boolean eaT = false;
    private boolean eaV = false;
    private List<com.baidu.swan.impl.map.item.c> eaQ = new ArrayList(1);

    public b() {
        aYx();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.eaQ.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c xZ = xZ(str);
        if (xZ != null) {
            this.eaQ.remove(xZ);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c xZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.eaQ) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        aYx();
        for (com.baidu.swan.impl.map.item.c cVar : this.eaQ) {
            cVar.eca.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.eaQ) {
            cVar.eca.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.eaV = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.eaQ) {
                cVar.eca.onDestroy();
            }
        }
        this.eaQ.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.eaR) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.eaQ) {
                MyLocationData locationData = cVar.eca.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.eca.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    aYw();
                }
            }
        }
        this.eaR = d;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* loaded from: classes24.dex */
    public class a implements BDLocationListener {
        public a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null || b.this.eaQ.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.eaU = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.eaQ) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.eca.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void aYw() {
        if (this.eaS == null) {
            this.eaS = new LocationClient(AppRuntime.getAppContext());
            this.eaS.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.eaS.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.eaV && this.eaS != null && this.eaS.isStarted()) {
            this.eaS.stop();
            aYz();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void aYx() {
        if (this.eaV) {
            aYw();
            if (this.eaS != null && !this.eaS.isStarted()) {
                this.eaS.start();
                aYy();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void aYy() {
        if (!this.eaT) {
            this.bBc = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.bBc != null) {
                this.bBc.registerListener(this, this.bBc.getDefaultSensor(3), 2);
                this.eaT = true;
            }
        }
    }

    private void aYz() {
        if (this.bBc != null && this.eaT) {
            this.bBc.unregisterListener(this);
            this.eaT = false;
        }
    }

    public boolean aYA() {
        return this.eaS != null && this.eaS.isStarted();
    }

    public BDLocation aYB() {
        return this.eaU;
    }

    public void hK(boolean z) {
        if (z) {
            this.eaV = true;
            aYx();
            return;
        }
        stopLocation();
        this.eaV = false;
    }
}
