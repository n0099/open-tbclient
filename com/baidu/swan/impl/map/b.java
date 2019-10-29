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
/* loaded from: classes5.dex */
public class b implements SensorEventListener {
    private SensorManager aoB;
    private double bGF;
    private LocationClient bGG;
    private BDLocation bGI;
    private boolean bGH = false;
    private boolean bGJ = false;
    private List<com.baidu.swan.impl.map.item.b> bGE = new ArrayList(1);

    public b() {
        Zk();
    }

    public boolean a(com.baidu.swan.impl.map.item.b bVar) {
        if (bVar == null) {
            return false;
        }
        this.bGE.add(bVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.b kN = kN(str);
        if (kN != null) {
            this.bGE.remove(kN);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.b kN(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.b bVar : this.bGE) {
            if (bVar != null && TextUtils.equals(bVar.id, str)) {
                return bVar;
            }
        }
        return null;
    }

    public void resume() {
        Zk();
        for (com.baidu.swan.impl.map.item.b bVar : this.bGE) {
            bVar.bHp.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.b bVar : this.bGE) {
            bVar.bHp.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.bGJ = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.b bVar : this.bGE) {
                bVar.bHp.onDestroy();
            }
        }
        this.bGE.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.bGF) > 1.0d) {
            for (com.baidu.swan.impl.map.item.b bVar : this.bGE) {
                MyLocationData locationData = bVar.bHp.getMap().getLocationData();
                if (locationData != null && bVar.isShowLocation) {
                    bVar.bHp.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).accuracy(locationData.accuracy).satellitesNum(locationData.satellitesNum).build());
                    Zj();
                }
            }
        }
        this.bGF = d;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* loaded from: classes5.dex */
    public class a implements BDLocationListener {
        public a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null || b.this.bGE.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.bGI = bDLocation;
            for (com.baidu.swan.impl.map.item.b bVar : b.this.bGE) {
                if (bVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = bVar.bHp.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void Zj() {
        if (this.bGG == null) {
            this.bGG = new LocationClient(AppRuntime.getAppContext());
            this.bGG.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.bGG.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.bGJ && this.bGG != null && this.bGG.isStarted()) {
            this.bGG.stop();
            Zm();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void Zk() {
        if (this.bGJ) {
            Zj();
            if (this.bGG != null && !this.bGG.isStarted()) {
                this.bGG.start();
                Zl();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void Zl() {
        if (!this.bGH) {
            this.aoB = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.aoB != null) {
                this.aoB.registerListener(this, this.aoB.getDefaultSensor(3), 2);
                this.bGH = true;
            }
        }
    }

    private void Zm() {
        if (this.aoB != null && this.bGH) {
            this.aoB.unregisterListener(this);
            this.bGH = false;
        }
    }

    public boolean Zn() {
        return this.bGG != null && this.bGG.isStarted();
    }

    public BDLocation Zo() {
        return this.bGI;
    }

    public void dn(boolean z) {
        if (z) {
            this.bGJ = true;
            Zk();
            return;
        }
        stopLocation();
        this.bGJ = false;
    }
}
