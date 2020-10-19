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
    private SensorManager buw;
    private double dOl;
    private LocationClient dOm;
    private BDLocation dOo;
    private boolean dOn = false;
    private boolean dOp = false;
    private List<com.baidu.swan.impl.map.item.c> dOk = new ArrayList(1);

    public b() {
        aUK();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.dOk.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c xx = xx(str);
        if (xx != null) {
            this.dOk.remove(xx);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c xx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.dOk) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        aUK();
        for (com.baidu.swan.impl.map.item.c cVar : this.dOk) {
            cVar.dPu.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.dOk) {
            cVar.dPu.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.dOp = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.dOk) {
                cVar.dPu.onDestroy();
            }
        }
        this.dOk.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.dOl) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.dOk) {
                MyLocationData locationData = cVar.dPu.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.dPu.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    aUJ();
                }
            }
        }
        this.dOl = d;
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
            if (bDLocation == null || b.this.dOk.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.dOo = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.dOk) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.dPu.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void aUJ() {
        if (this.dOm == null) {
            this.dOm = new LocationClient(AppRuntime.getAppContext());
            this.dOm.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.dOm.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.dOp && this.dOm != null && this.dOm.isStarted()) {
            this.dOm.stop();
            aUM();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void aUK() {
        if (this.dOp) {
            aUJ();
            if (this.dOm != null && !this.dOm.isStarted()) {
                this.dOm.start();
                aUL();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void aUL() {
        if (!this.dOn) {
            this.buw = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.buw != null) {
                this.buw.registerListener(this, this.buw.getDefaultSensor(3), 2);
                this.dOn = true;
            }
        }
    }

    private void aUM() {
        if (this.buw != null && this.dOn) {
            this.buw.unregisterListener(this);
            this.dOn = false;
        }
    }

    public boolean aUN() {
        return this.dOm != null && this.dOm.isStarted();
    }

    public BDLocation aUO() {
        return this.dOo;
    }

    public void hl(boolean z) {
        if (z) {
            this.dOp = true;
            aUK();
            return;
        }
        stopLocation();
        this.dOp = false;
    }
}
