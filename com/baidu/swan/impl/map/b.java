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
/* loaded from: classes12.dex */
public class b implements SensorEventListener {
    private SensorManager aBi;
    private double cvi;
    private LocationClient cvj;
    private BDLocation cvl;
    private boolean cvk = false;
    private boolean cvm = false;
    private List<com.baidu.swan.impl.map.item.c> cvh = new ArrayList(1);

    public b() {
        aru();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.cvh.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c qa = qa(str);
        if (qa != null) {
            this.cvh.remove(qa);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c qa(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.cvh) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        aru();
        for (com.baidu.swan.impl.map.item.c cVar : this.cvh) {
            cVar.cwr.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.cvh) {
            cVar.cwr.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.cvm = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.cvh) {
                cVar.cwr.onDestroy();
            }
        }
        this.cvh.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.cvi) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.cvh) {
                MyLocationData locationData = cVar.cwr.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.cwr.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    art();
                }
            }
        }
        this.cvi = d;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* loaded from: classes12.dex */
    public class a implements BDLocationListener {
        public a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null || b.this.cvh.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.cvl = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.cvh) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.cwr.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void art() {
        if (this.cvj == null) {
            this.cvj = new LocationClient(AppRuntime.getAppContext());
            this.cvj.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.cvj.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.cvm && this.cvj != null && this.cvj.isStarted()) {
            this.cvj.stop();
            arw();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void aru() {
        if (this.cvm) {
            art();
            if (this.cvj != null && !this.cvj.isStarted()) {
                this.cvj.start();
                arv();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void arv() {
        if (!this.cvk) {
            this.aBi = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.aBi != null) {
                this.aBi.registerListener(this, this.aBi.getDefaultSensor(3), 2);
                this.cvk = true;
            }
        }
    }

    private void arw() {
        if (this.aBi != null && this.cvk) {
            this.aBi.unregisterListener(this);
            this.cvk = false;
        }
    }

    public boolean arx() {
        return this.cvj != null && this.cvj.isStarted();
    }

    public BDLocation ary() {
        return this.cvl;
    }

    public void eK(boolean z) {
        if (z) {
            this.cvm = true;
            aru();
            return;
        }
        stopLocation();
        this.cvm = false;
    }
}
