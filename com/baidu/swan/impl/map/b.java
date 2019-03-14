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
    private SensorManager aTw;
    private LocationClient bgA;
    private BDLocation bgC;
    private double bgz;
    private boolean bgB = false;
    private boolean bgD = false;
    private List<com.baidu.swan.impl.map.item.b> bgy = new ArrayList(1);

    public b() {
        PP();
    }

    public boolean a(com.baidu.swan.impl.map.item.b bVar) {
        if (bVar == null) {
            return false;
        }
        this.bgy.add(bVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.b jc = jc(str);
        if (jc != null) {
            this.bgy.remove(jc);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.b jc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.b bVar : this.bgy) {
            if (bVar != null && TextUtils.equals(bVar.id, str)) {
                return bVar;
            }
        }
        return null;
    }

    public void resume() {
        PP();
        for (com.baidu.swan.impl.map.item.b bVar : this.bgy) {
            bVar.bhj.onResume();
        }
    }

    public void pause() {
        ja();
        for (com.baidu.swan.impl.map.item.b bVar : this.bgy) {
            bVar.bhj.onPause();
        }
    }

    public void release() {
        ja();
        this.bgD = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.b bVar : this.bgy) {
                bVar.bhj.onDestroy();
            }
        }
        this.bgy.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.bgz) > 1.0d) {
            for (com.baidu.swan.impl.map.item.b bVar : this.bgy) {
                MyLocationData locationData = bVar.bhj.getMap().getLocationData();
                if (locationData != null && bVar.isShowLocation) {
                    bVar.bhj.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).accuracy(locationData.accuracy).satellitesNum(locationData.satellitesNum).build());
                    PO();
                }
            }
        }
        this.bgz = d;
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
            if (bDLocation == null || b.this.bgy.size() <= 0) {
                b.this.ja();
                return;
            }
            b.this.bgC = bDLocation;
            for (com.baidu.swan.impl.map.item.b bVar : b.this.bgy) {
                if (bVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = bVar.bhj.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void PO() {
        if (this.bgA == null) {
            this.bgA = new LocationClient(AppRuntime.getAppContext());
            this.bgA.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.bgA.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja() {
        if (this.bgD && this.bgA != null && this.bgA.isStarted()) {
            this.bgA.stop();
            PR();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void PP() {
        if (this.bgD) {
            PO();
            if (this.bgA != null && !this.bgA.isStarted()) {
                this.bgA.start();
                PQ();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void PQ() {
        if (!this.bgB) {
            this.aTw = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.aTw != null) {
                this.aTw.registerListener(this, this.aTw.getDefaultSensor(3), 2);
                this.bgB = true;
            }
        }
    }

    private void PR() {
        if (this.aTw != null && this.bgB) {
            this.aTw.unregisterListener(this);
            this.bgB = false;
        }
    }

    public boolean PS() {
        return this.bgA != null && this.bgA.isStarted();
    }

    public BDLocation PT() {
        return this.bgC;
    }

    public void cC(boolean z) {
        if (z) {
            this.bgD = true;
            PP();
            return;
        }
        ja();
        this.bgD = false;
    }
}
