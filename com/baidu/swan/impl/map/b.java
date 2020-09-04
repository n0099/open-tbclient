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
    private SensorManager bnN;
    private double dAj;
    private LocationClient dAk;
    private BDLocation dAm;
    private boolean dAl = false;
    private boolean dAn = false;
    private List<com.baidu.swan.impl.map.item.c> dAi = new ArrayList(1);

    public b() {
        aRp();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.dAi.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c ws = ws(str);
        if (ws != null) {
            this.dAi.remove(ws);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c ws(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.dAi) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        aRp();
        for (com.baidu.swan.impl.map.item.c cVar : this.dAi) {
            cVar.dBs.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.dAi) {
            cVar.dBs.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.dAn = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.dAi) {
                cVar.dBs.onDestroy();
            }
        }
        this.dAi.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.dAj) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.dAi) {
                MyLocationData locationData = cVar.dBs.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.dBs.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    aRo();
                }
            }
        }
        this.dAj = d;
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
            if (bDLocation == null || b.this.dAi.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.dAm = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.dAi) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.dBs.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void aRo() {
        if (this.dAk == null) {
            this.dAk = new LocationClient(AppRuntime.getAppContext());
            this.dAk.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.dAk.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.dAn && this.dAk != null && this.dAk.isStarted()) {
            this.dAk.stop();
            aRr();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void aRp() {
        if (this.dAn) {
            aRo();
            if (this.dAk != null && !this.dAk.isStarted()) {
                this.dAk.start();
                aRq();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void aRq() {
        if (!this.dAl) {
            this.bnN = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.bnN != null) {
                this.bnN.registerListener(this, this.bnN.getDefaultSensor(3), 2);
                this.dAl = true;
            }
        }
    }

    private void aRr() {
        if (this.bnN != null && this.dAl) {
            this.bnN.unregisterListener(this);
            this.dAl = false;
        }
    }

    public boolean aRs() {
        return this.dAk != null && this.dAk.isStarted();
    }

    public BDLocation aRt() {
        return this.dAm;
    }

    public void gR(boolean z) {
        if (z) {
            this.dAn = true;
            aRp();
            return;
        }
        stopLocation();
        this.dAn = false;
    }
}
