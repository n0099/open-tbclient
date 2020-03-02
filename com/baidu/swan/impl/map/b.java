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
    private SensorManager aBj;
    private double cvj;
    private LocationClient cvk;
    private BDLocation cvm;
    private boolean cvl = false;
    private boolean cvn = false;
    private List<com.baidu.swan.impl.map.item.c> cvi = new ArrayList(1);

    public b() {
        arw();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.cvi.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c qa = qa(str);
        if (qa != null) {
            this.cvi.remove(qa);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c qa(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.cvi) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        arw();
        for (com.baidu.swan.impl.map.item.c cVar : this.cvi) {
            cVar.cws.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.cvi) {
            cVar.cws.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.cvn = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.cvi) {
                cVar.cws.onDestroy();
            }
        }
        this.cvi.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.cvj) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.cvi) {
                MyLocationData locationData = cVar.cws.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.cws.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    arv();
                }
            }
        }
        this.cvj = d;
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
            if (bDLocation == null || b.this.cvi.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.cvm = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.cvi) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.cws.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void arv() {
        if (this.cvk == null) {
            this.cvk = new LocationClient(AppRuntime.getAppContext());
            this.cvk.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.cvk.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.cvn && this.cvk != null && this.cvk.isStarted()) {
            this.cvk.stop();
            ary();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void arw() {
        if (this.cvn) {
            arv();
            if (this.cvk != null && !this.cvk.isStarted()) {
                this.cvk.start();
                arx();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void arx() {
        if (!this.cvl) {
            this.aBj = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.aBj != null) {
                this.aBj.registerListener(this, this.aBj.getDefaultSensor(3), 2);
                this.cvl = true;
            }
        }
    }

    private void ary() {
        if (this.aBj != null && this.cvl) {
            this.aBj.unregisterListener(this);
            this.cvl = false;
        }
    }

    public boolean arz() {
        return this.cvk != null && this.cvk.isStarted();
    }

    public BDLocation arA() {
        return this.cvm;
    }

    public void eK(boolean z) {
        if (z) {
            this.cvn = true;
            arw();
            return;
        }
        stopLocation();
        this.cvn = false;
    }
}
