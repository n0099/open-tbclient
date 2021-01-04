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
/* loaded from: classes9.dex */
public class b implements SensorEventListener {
    private double eqV;
    private LocationClient eqW;
    private BDLocation eqY;
    private SensorManager mSensorManager;
    private boolean eqX = false;
    private boolean eqZ = false;
    private List<com.baidu.swan.impl.map.item.c> eqU = new ArrayList(1);

    public b() {
        bdU();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.eqU.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c yF = yF(str);
        if (yF != null) {
            this.eqU.remove(yF);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c yF(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.eqU) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        bdU();
        for (com.baidu.swan.impl.map.item.c cVar : this.eqU) {
            cVar.esf.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.eqU) {
            cVar.esf.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.eqZ = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.eqU) {
                cVar.esf.onDestroy();
            }
        }
        this.eqU.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.eqV) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.eqU) {
                MyLocationData locationData = cVar.esf.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.esf.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    bdT();
                }
            }
        }
        this.eqV = d;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* loaded from: classes9.dex */
    public class a implements BDLocationListener {
        public a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null || b.this.eqU.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.eqY = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.eqU) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.esf.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void bdT() {
        if (this.eqW == null) {
            this.eqW = new LocationClient(AppRuntime.getAppContext());
            this.eqW.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.eqW.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.eqZ && this.eqW != null && this.eqW.isStarted()) {
            this.eqW.stop();
            bdW();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void bdU() {
        if (this.eqZ) {
            bdT();
            if (this.eqW != null && !this.eqW.isStarted()) {
                this.eqW.start();
                bdV();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void bdV() {
        if (!this.eqX) {
            this.mSensorManager = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.mSensorManager != null) {
                this.mSensorManager.registerListener(this, this.mSensorManager.getDefaultSensor(3), 2);
                this.eqX = true;
            }
        }
    }

    private void bdW() {
        if (this.mSensorManager != null && this.eqX) {
            this.mSensorManager.unregisterListener(this);
            this.eqX = false;
        }
    }

    public boolean bdX() {
        return this.eqW != null && this.eqW.isStarted();
    }

    public BDLocation bdY() {
        return this.eqY;
    }

    public void ir(boolean z) {
        if (z) {
            this.eqZ = true;
            bdU();
            return;
        }
        stopLocation();
        this.eqZ = false;
    }
}
