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
/* loaded from: classes25.dex */
public class b implements SensorEventListener {
    private SensorManager bwC;
    private double dWI;
    private LocationClient dWJ;
    private BDLocation dWL;
    private boolean dWK = false;
    private boolean dWM = false;
    private List<com.baidu.swan.impl.map.item.c> dWH = new ArrayList(1);

    public b() {
        aWE();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.dWH.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c xQ = xQ(str);
        if (xQ != null) {
            this.dWH.remove(xQ);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c xQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.dWH) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        aWE();
        for (com.baidu.swan.impl.map.item.c cVar : this.dWH) {
            cVar.dXR.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.dWH) {
            cVar.dXR.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.dWM = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.dWH) {
                cVar.dXR.onDestroy();
            }
        }
        this.dWH.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.dWI) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.dWH) {
                MyLocationData locationData = cVar.dXR.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.dXR.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    aWD();
                }
            }
        }
        this.dWI = d;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* loaded from: classes25.dex */
    public class a implements BDLocationListener {
        public a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null || b.this.dWH.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.dWL = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.dWH) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.dXR.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void aWD() {
        if (this.dWJ == null) {
            this.dWJ = new LocationClient(AppRuntime.getAppContext());
            this.dWJ.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.dWJ.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.dWM && this.dWJ != null && this.dWJ.isStarted()) {
            this.dWJ.stop();
            aWG();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void aWE() {
        if (this.dWM) {
            aWD();
            if (this.dWJ != null && !this.dWJ.isStarted()) {
                this.dWJ.start();
                aWF();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void aWF() {
        if (!this.dWK) {
            this.bwC = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.bwC != null) {
                this.bwC.registerListener(this, this.bwC.getDefaultSensor(3), 2);
                this.dWK = true;
            }
        }
    }

    private void aWG() {
        if (this.bwC != null && this.dWK) {
            this.bwC.unregisterListener(this);
            this.dWK = false;
        }
    }

    public boolean aWH() {
        return this.dWJ != null && this.dWJ.isStarted();
    }

    public BDLocation aWI() {
        return this.dWL;
    }

    public void hy(boolean z) {
        if (z) {
            this.dWM = true;
            aWE();
            return;
        }
        stopLocation();
        this.dWM = false;
    }
}
