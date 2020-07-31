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
/* loaded from: classes19.dex */
public class b implements SensorEventListener {
    private SensorManager bic;
    private double dqd;
    private LocationClient dqe;
    private BDLocation dqg;
    private boolean dqf = false;
    private boolean dqh = false;
    private List<com.baidu.swan.impl.map.item.c> dqc = new ArrayList(1);

    public b() {
        aIz();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.dqc.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c ub = ub(str);
        if (ub != null) {
            this.dqc.remove(ub);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c ub(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.dqc) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        aIz();
        for (com.baidu.swan.impl.map.item.c cVar : this.dqc) {
            cVar.drm.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.dqc) {
            cVar.drm.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.dqh = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.dqc) {
                cVar.drm.onDestroy();
            }
        }
        this.dqc.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.dqd) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.dqc) {
                MyLocationData locationData = cVar.drm.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.drm.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    aIy();
                }
            }
        }
        this.dqd = d;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* loaded from: classes19.dex */
    public class a implements BDLocationListener {
        public a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null || b.this.dqc.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.dqg = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.dqc) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.drm.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void aIy() {
        if (this.dqe == null) {
            this.dqe = new LocationClient(AppRuntime.getAppContext());
            this.dqe.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.dqe.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.dqh && this.dqe != null && this.dqe.isStarted()) {
            this.dqe.stop();
            aIB();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void aIz() {
        if (this.dqh) {
            aIy();
            if (this.dqe != null && !this.dqe.isStarted()) {
                this.dqe.start();
                aIA();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void aIA() {
        if (!this.dqf) {
            this.bic = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.bic != null) {
                this.bic.registerListener(this, this.bic.getDefaultSensor(3), 2);
                this.dqf = true;
            }
        }
    }

    private void aIB() {
        if (this.bic != null && this.dqf) {
            this.bic.unregisterListener(this);
            this.dqf = false;
        }
    }

    public boolean aIC() {
        return this.dqe != null && this.dqe.isStarted();
    }

    public BDLocation aID() {
        return this.dqg;
    }

    public void gu(boolean z) {
        if (z) {
            this.dqh = true;
            aIz();
            return;
        }
        stopLocation();
        this.dqh = false;
    }
}
