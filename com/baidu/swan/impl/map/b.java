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
    private SensorManager aTz;
    private double bgC;
    private LocationClient bgD;
    private BDLocation bgF;
    private boolean bgE = false;
    private boolean bgG = false;
    private List<com.baidu.swan.impl.map.item.b> bgB = new ArrayList(1);

    public b() {
        PN();
    }

    public boolean a(com.baidu.swan.impl.map.item.b bVar) {
        if (bVar == null) {
            return false;
        }
        this.bgB.add(bVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.b jd = jd(str);
        if (jd != null) {
            this.bgB.remove(jd);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.b jd(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.b bVar : this.bgB) {
            if (bVar != null && TextUtils.equals(bVar.id, str)) {
                return bVar;
            }
        }
        return null;
    }

    public void resume() {
        PN();
        for (com.baidu.swan.impl.map.item.b bVar : this.bgB) {
            bVar.bhm.onResume();
        }
    }

    public void pause() {
        ja();
        for (com.baidu.swan.impl.map.item.b bVar : this.bgB) {
            bVar.bhm.onPause();
        }
    }

    public void release() {
        ja();
        this.bgG = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.b bVar : this.bgB) {
                bVar.bhm.onDestroy();
            }
        }
        this.bgB.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.bgC) > 1.0d) {
            for (com.baidu.swan.impl.map.item.b bVar : this.bgB) {
                MyLocationData locationData = bVar.bhm.getMap().getLocationData();
                if (locationData != null && bVar.isShowLocation) {
                    bVar.bhm.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).accuracy(locationData.accuracy).satellitesNum(locationData.satellitesNum).build());
                    PM();
                }
            }
        }
        this.bgC = d;
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
            if (bDLocation == null || b.this.bgB.size() <= 0) {
                b.this.ja();
                return;
            }
            b.this.bgF = bDLocation;
            for (com.baidu.swan.impl.map.item.b bVar : b.this.bgB) {
                if (bVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = bVar.bhm.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void PM() {
        if (this.bgD == null) {
            this.bgD = new LocationClient(AppRuntime.getAppContext());
            this.bgD.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.bgD.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja() {
        if (this.bgG && this.bgD != null && this.bgD.isStarted()) {
            this.bgD.stop();
            PP();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void PN() {
        if (this.bgG) {
            PM();
            if (this.bgD != null && !this.bgD.isStarted()) {
                this.bgD.start();
                PO();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void PO() {
        if (!this.bgE) {
            this.aTz = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.aTz != null) {
                this.aTz.registerListener(this, this.aTz.getDefaultSensor(3), 2);
                this.bgE = true;
            }
        }
    }

    private void PP() {
        if (this.aTz != null && this.bgE) {
            this.aTz.unregisterListener(this);
            this.bgE = false;
        }
    }

    public boolean PQ() {
        return this.bgD != null && this.bgD.isStarted();
    }

    public BDLocation PR() {
        return this.bgF;
    }

    public void cC(boolean z) {
        if (z) {
            this.bgG = true;
            PN();
            return;
        }
        ja();
        this.bgG = false;
    }
}
