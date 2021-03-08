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
/* loaded from: classes8.dex */
public class b implements SensorEventListener {
    private double epR;
    private LocationClient epS;
    private BDLocation epU;
    private SensorManager mSensorManager;
    private boolean epT = false;
    private boolean epV = false;
    private List<com.baidu.swan.impl.map.item.c> epQ = new ArrayList(1);

    public b() {
        bar();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.epQ.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c xU = xU(str);
        if (xU != null) {
            this.epQ.remove(xU);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c xU(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.epQ) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        bar();
        for (com.baidu.swan.impl.map.item.c cVar : this.epQ) {
            cVar.era.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.epQ) {
            cVar.era.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.epV = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.epQ) {
                cVar.era.onDestroy();
            }
        }
        this.epQ.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.epR) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.epQ) {
                MyLocationData locationData = cVar.era.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.era.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    baq();
                }
            }
        }
        this.epR = d;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* loaded from: classes8.dex */
    public class a implements BDLocationListener {
        public a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null || b.this.epQ.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.epU = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.epQ) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.era.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void baq() {
        if (this.epS == null) {
            this.epS = new LocationClient(AppRuntime.getAppContext());
            this.epS.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.epS.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.epV && this.epS != null && this.epS.isStarted()) {
            this.epS.stop();
            bat();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void bar() {
        if (this.epV) {
            baq();
            if (this.epS != null && !this.epS.isStarted()) {
                this.epS.start();
                bas();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void bas() {
        if (!this.epT) {
            this.mSensorManager = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.mSensorManager != null) {
                this.mSensorManager.registerListener(this, this.mSensorManager.getDefaultSensor(3), 2);
                this.epT = true;
            }
        }
    }

    private void bat() {
        if (this.mSensorManager != null && this.epT) {
            this.mSensorManager.unregisterListener(this);
            this.epT = false;
        }
    }

    public boolean bau() {
        return this.epS != null && this.epS.isStarted();
    }

    public BDLocation bav() {
        return this.epU;
    }

    public void ip(boolean z) {
        if (z) {
            this.epV = true;
            bar();
            return;
        }
        stopLocation();
        this.epV = false;
    }
}
