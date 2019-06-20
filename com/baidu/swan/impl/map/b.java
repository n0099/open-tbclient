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
    private SensorManager aWq;
    private double bmI;
    private LocationClient bmJ;
    private BDLocation bmL;
    private boolean bmK = false;
    private boolean bmM = false;
    private List<com.baidu.swan.impl.map.item.b> bmH = new ArrayList(1);

    public b() {
        Tz();
    }

    public boolean a(com.baidu.swan.impl.map.item.b bVar) {
        if (bVar == null) {
            return false;
        }
        this.bmH.add(bVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.b kb = kb(str);
        if (kb != null) {
            this.bmH.remove(kb);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.b kb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.b bVar : this.bmH) {
            if (bVar != null && TextUtils.equals(bVar.id, str)) {
                return bVar;
            }
        }
        return null;
    }

    public void resume() {
        Tz();
        for (com.baidu.swan.impl.map.item.b bVar : this.bmH) {
            bVar.bns.onResume();
        }
    }

    public void pause() {
        hS();
        for (com.baidu.swan.impl.map.item.b bVar : this.bmH) {
            bVar.bns.onPause();
        }
    }

    public void release() {
        hS();
        this.bmM = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.b bVar : this.bmH) {
                bVar.bns.onDestroy();
            }
        }
        this.bmH.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.bmI) > 1.0d) {
            for (com.baidu.swan.impl.map.item.b bVar : this.bmH) {
                MyLocationData locationData = bVar.bns.getMap().getLocationData();
                if (locationData != null && bVar.isShowLocation) {
                    bVar.bns.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).accuracy(locationData.accuracy).satellitesNum(locationData.satellitesNum).build());
                    Ty();
                }
            }
        }
        this.bmI = d;
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
            if (bDLocation == null || b.this.bmH.size() <= 0) {
                b.this.hS();
                return;
            }
            b.this.bmL = bDLocation;
            for (com.baidu.swan.impl.map.item.b bVar : b.this.bmH) {
                if (bVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = bVar.bns.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void Ty() {
        if (this.bmJ == null) {
            this.bmJ = new LocationClient(AppRuntime.getAppContext());
            this.bmJ.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.bmJ.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hS() {
        if (this.bmM && this.bmJ != null && this.bmJ.isStarted()) {
            this.bmJ.stop();
            TB();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void Tz() {
        if (this.bmM) {
            Ty();
            if (this.bmJ != null && !this.bmJ.isStarted()) {
                this.bmJ.start();
                TA();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void TA() {
        if (!this.bmK) {
            this.aWq = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.aWq != null) {
                this.aWq.registerListener(this, this.aWq.getDefaultSensor(3), 2);
                this.bmK = true;
            }
        }
    }

    private void TB() {
        if (this.aWq != null && this.bmK) {
            this.aWq.unregisterListener(this);
            this.bmK = false;
        }
    }

    public boolean TC() {
        return this.bmJ != null && this.bmJ.isStarted();
    }

    public BDLocation TD() {
        return this.bmL;
    }

    public void cT(boolean z) {
        if (z) {
            this.bmM = true;
            Tz();
            return;
        }
        hS();
        this.bmM = false;
    }
}
