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
    private SensorManager aoj;
    private double bFO;
    private LocationClient bFP;
    private BDLocation bFR;
    private boolean bFQ = false;
    private boolean bFS = false;
    private List<com.baidu.swan.impl.map.item.b> bFN = new ArrayList(1);

    public b() {
        Zi();
    }

    public boolean a(com.baidu.swan.impl.map.item.b bVar) {
        if (bVar == null) {
            return false;
        }
        this.bFN.add(bVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.b kN = kN(str);
        if (kN != null) {
            this.bFN.remove(kN);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.b kN(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.b bVar : this.bFN) {
            if (bVar != null && TextUtils.equals(bVar.id, str)) {
                return bVar;
            }
        }
        return null;
    }

    public void resume() {
        Zi();
        for (com.baidu.swan.impl.map.item.b bVar : this.bFN) {
            bVar.bGy.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.b bVar : this.bFN) {
            bVar.bGy.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.bFS = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.b bVar : this.bFN) {
                bVar.bGy.onDestroy();
            }
        }
        this.bFN.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.bFO) > 1.0d) {
            for (com.baidu.swan.impl.map.item.b bVar : this.bFN) {
                MyLocationData locationData = bVar.bGy.getMap().getLocationData();
                if (locationData != null && bVar.isShowLocation) {
                    bVar.bGy.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).accuracy(locationData.accuracy).satellitesNum(locationData.satellitesNum).build());
                    Zh();
                }
            }
        }
        this.bFO = d;
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
            if (bDLocation == null || b.this.bFN.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.bFR = bDLocation;
            for (com.baidu.swan.impl.map.item.b bVar : b.this.bFN) {
                if (bVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = bVar.bGy.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void Zh() {
        if (this.bFP == null) {
            this.bFP = new LocationClient(AppRuntime.getAppContext());
            this.bFP.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.bFP.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.bFS && this.bFP != null && this.bFP.isStarted()) {
            this.bFP.stop();
            Zk();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void Zi() {
        if (this.bFS) {
            Zh();
            if (this.bFP != null && !this.bFP.isStarted()) {
                this.bFP.start();
                Zj();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void Zj() {
        if (!this.bFQ) {
            this.aoj = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.aoj != null) {
                this.aoj.registerListener(this, this.aoj.getDefaultSensor(3), 2);
                this.bFQ = true;
            }
        }
    }

    private void Zk() {
        if (this.aoj != null && this.bFQ) {
            this.aoj.unregisterListener(this);
            this.bFQ = false;
        }
    }

    public boolean Zl() {
        return this.bFP != null && this.bFP.isStarted();
    }

    public BDLocation Zm() {
        return this.bFR;
    }

    public void dn(boolean z) {
        if (z) {
            this.bFS = true;
            Zi();
            return;
        }
        stopLocation();
        this.bFS = false;
    }
}
