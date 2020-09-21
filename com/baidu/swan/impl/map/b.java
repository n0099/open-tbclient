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
/* loaded from: classes24.dex */
public class b implements SensorEventListener {
    private SensorManager bqI;
    private double dCk;
    private LocationClient dCl;
    private BDLocation dCn;
    private boolean dCm = false;
    private boolean dCo = false;
    private List<com.baidu.swan.impl.map.item.c> dCj = new ArrayList(1);

    public b() {
        aSb();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.dCj.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c wL = wL(str);
        if (wL != null) {
            this.dCj.remove(wL);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c wL(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.dCj) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        aSb();
        for (com.baidu.swan.impl.map.item.c cVar : this.dCj) {
            cVar.dDt.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.dCj) {
            cVar.dDt.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.dCo = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.dCj) {
                cVar.dDt.onDestroy();
            }
        }
        this.dCj.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.dCk) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.dCj) {
                MyLocationData locationData = cVar.dDt.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.dDt.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    aSa();
                }
            }
        }
        this.dCk = d;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* loaded from: classes24.dex */
    public class a implements BDLocationListener {
        public a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null || b.this.dCj.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.dCn = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.dCj) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.dDt.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void aSa() {
        if (this.dCl == null) {
            this.dCl = new LocationClient(AppRuntime.getAppContext());
            this.dCl.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.dCl.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.dCo && this.dCl != null && this.dCl.isStarted()) {
            this.dCl.stop();
            aSd();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void aSb() {
        if (this.dCo) {
            aSa();
            if (this.dCl != null && !this.dCl.isStarted()) {
                this.dCl.start();
                aSc();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void aSc() {
        if (!this.dCm) {
            this.bqI = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.bqI != null) {
                this.bqI.registerListener(this, this.bqI.getDefaultSensor(3), 2);
                this.dCm = true;
            }
        }
    }

    private void aSd() {
        if (this.bqI != null && this.dCm) {
            this.bqI.unregisterListener(this);
            this.dCm = false;
        }
    }

    public boolean aSe() {
        return this.dCl != null && this.dCl.isStarted();
    }

    public BDLocation aSf() {
        return this.dCn;
    }

    public void gP(boolean z) {
        if (z) {
            this.dCo = true;
            aSb();
            return;
        }
        stopLocation();
        this.dCo = false;
    }
}
