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
    private SensorManager aBk;
    private double cvk;
    private LocationClient cvl;
    private BDLocation cvn;
    private boolean cvm = false;
    private boolean cvo = false;
    private List<com.baidu.swan.impl.map.item.c> cvj = new ArrayList(1);

    public b() {
        arw();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.cvj.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c qa = qa(str);
        if (qa != null) {
            this.cvj.remove(qa);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c qa(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.cvj) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        arw();
        for (com.baidu.swan.impl.map.item.c cVar : this.cvj) {
            cVar.cwt.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.cvj) {
            cVar.cwt.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.cvo = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.cvj) {
                cVar.cwt.onDestroy();
            }
        }
        this.cvj.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.cvk) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.cvj) {
                MyLocationData locationData = cVar.cwt.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.cwt.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    arv();
                }
            }
        }
        this.cvk = d;
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
            if (bDLocation == null || b.this.cvj.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.cvn = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.cvj) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.cwt.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void arv() {
        if (this.cvl == null) {
            this.cvl = new LocationClient(AppRuntime.getAppContext());
            this.cvl.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.cvl.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.cvo && this.cvl != null && this.cvl.isStarted()) {
            this.cvl.stop();
            ary();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void arw() {
        if (this.cvo) {
            arv();
            if (this.cvl != null && !this.cvl.isStarted()) {
                this.cvl.start();
                arx();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void arx() {
        if (!this.cvm) {
            this.aBk = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.aBk != null) {
                this.aBk.registerListener(this, this.aBk.getDefaultSensor(3), 2);
                this.cvm = true;
            }
        }
    }

    private void ary() {
        if (this.aBk != null && this.cvm) {
            this.aBk.unregisterListener(this);
            this.cvm = false;
        }
    }

    public boolean arz() {
        return this.cvl != null && this.cvl.isStarted();
    }

    public BDLocation arA() {
        return this.cvn;
    }

    public void eK(boolean z) {
        if (z) {
            this.cvo = true;
            arw();
            return;
        }
        stopLocation();
        this.cvo = false;
    }
}
