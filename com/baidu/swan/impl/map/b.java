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
    private SensorManager awg;
    private double cqU;
    private LocationClient cqV;
    private BDLocation cqX;
    private boolean cqW = false;
    private boolean cqY = false;
    private List<com.baidu.swan.impl.map.item.c> cqT = new ArrayList(1);

    public b() {
        aoN();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.cqT.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c pI = pI(str);
        if (pI != null) {
            this.cqT.remove(pI);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c pI(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.cqT) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        aoN();
        for (com.baidu.swan.impl.map.item.c cVar : this.cqT) {
            cVar.cse.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.cqT) {
            cVar.cse.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.cqY = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.cqT) {
                cVar.cse.onDestroy();
            }
        }
        this.cqT.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.cqU) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.cqT) {
                MyLocationData locationData = cVar.cse.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.cse.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    aoM();
                }
            }
        }
        this.cqU = d;
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
            if (bDLocation == null || b.this.cqT.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.cqX = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.cqT) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.cse.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void aoM() {
        if (this.cqV == null) {
            this.cqV = new LocationClient(AppRuntime.getAppContext());
            this.cqV.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.cqV.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.cqY && this.cqV != null && this.cqV.isStarted()) {
            this.cqV.stop();
            aoP();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void aoN() {
        if (this.cqY) {
            aoM();
            if (this.cqV != null && !this.cqV.isStarted()) {
                this.cqV.start();
                aoO();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void aoO() {
        if (!this.cqW) {
            this.awg = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.awg != null) {
                this.awg.registerListener(this, this.awg.getDefaultSensor(3), 2);
                this.cqW = true;
            }
        }
    }

    private void aoP() {
        if (this.awg != null && this.cqW) {
            this.awg.unregisterListener(this);
            this.cqW = false;
        }
    }

    public boolean aoQ() {
        return this.cqV != null && this.cqV.isStarted();
    }

    public BDLocation aoR() {
        return this.cqX;
    }

    public void ey(boolean z) {
        if (z) {
            this.cqY = true;
            aoN();
            return;
        }
        stopLocation();
        this.cqY = false;
    }
}
