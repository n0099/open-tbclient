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
    private SensorManager bCN;
    private LocationClient ecA;
    private BDLocation ecC;
    private double ecz;
    private boolean ecB = false;
    private boolean ecD = false;
    private List<com.baidu.swan.impl.map.item.c> ecy = new ArrayList(1);

    public b() {
        aZe();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.ecy.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c ye = ye(str);
        if (ye != null) {
            this.ecy.remove(ye);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c ye(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.ecy) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        aZe();
        for (com.baidu.swan.impl.map.item.c cVar : this.ecy) {
            cVar.edI.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.ecy) {
            cVar.edI.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.ecD = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.ecy) {
                cVar.edI.onDestroy();
            }
        }
        this.ecy.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.ecz) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.ecy) {
                MyLocationData locationData = cVar.edI.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.edI.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    aZd();
                }
            }
        }
        this.ecz = d;
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
            if (bDLocation == null || b.this.ecy.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.ecC = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.ecy) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.edI.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void aZd() {
        if (this.ecA == null) {
            this.ecA = new LocationClient(AppRuntime.getAppContext());
            this.ecA.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.ecA.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.ecD && this.ecA != null && this.ecA.isStarted()) {
            this.ecA.stop();
            aZg();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void aZe() {
        if (this.ecD) {
            aZd();
            if (this.ecA != null && !this.ecA.isStarted()) {
                this.ecA.start();
                aZf();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void aZf() {
        if (!this.ecB) {
            this.bCN = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.bCN != null) {
                this.bCN.registerListener(this, this.bCN.getDefaultSensor(3), 2);
                this.ecB = true;
            }
        }
    }

    private void aZg() {
        if (this.bCN != null && this.ecB) {
            this.bCN.unregisterListener(this);
            this.ecB = false;
        }
    }

    public boolean aZh() {
        return this.ecA != null && this.ecA.isStarted();
    }

    public BDLocation aZi() {
        return this.ecC;
    }

    public void hH(boolean z) {
        if (z) {
            this.ecD = true;
            aZe();
            return;
        }
        stopLocation();
        this.ecD = false;
    }
}
