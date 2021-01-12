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
    private double emg;
    private LocationClient emh;
    private BDLocation emj;
    private SensorManager mSensorManager;
    private boolean emi = false;
    private boolean emk = false;
    private List<com.baidu.swan.impl.map.item.c> emf = new ArrayList(1);

    public b() {
        bab();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.emf.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c xu = xu(str);
        if (xu != null) {
            this.emf.remove(xu);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c xu(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.emf) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        bab();
        for (com.baidu.swan.impl.map.item.c cVar : this.emf) {
            cVar.enq.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.emf) {
            cVar.enq.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.emk = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.emf) {
                cVar.enq.onDestroy();
            }
        }
        this.emf.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.emg) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.emf) {
                MyLocationData locationData = cVar.enq.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.enq.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    baa();
                }
            }
        }
        this.emg = d;
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
            if (bDLocation == null || b.this.emf.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.emj = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.emf) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.enq.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void baa() {
        if (this.emh == null) {
            this.emh = new LocationClient(AppRuntime.getAppContext());
            this.emh.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.emh.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.emk && this.emh != null && this.emh.isStarted()) {
            this.emh.stop();
            bad();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void bab() {
        if (this.emk) {
            baa();
            if (this.emh != null && !this.emh.isStarted()) {
                this.emh.start();
                bac();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void bac() {
        if (!this.emi) {
            this.mSensorManager = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.mSensorManager != null) {
                this.mSensorManager.registerListener(this, this.mSensorManager.getDefaultSensor(3), 2);
                this.emi = true;
            }
        }
    }

    private void bad() {
        if (this.mSensorManager != null && this.emi) {
            this.mSensorManager.unregisterListener(this);
            this.emi = false;
        }
    }

    public boolean bae() {
        return this.emh != null && this.emh.isStarted();
    }

    public BDLocation baf() {
        return this.emj;
    }

    public void in(boolean z) {
        if (z) {
            this.emk = true;
            bab();
            return;
        }
        stopLocation();
        this.emk = false;
    }
}
