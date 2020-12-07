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
    private SensorManager bGk;
    private double ehS;
    private LocationClient ehT;
    private BDLocation ehV;
    private boolean ehU = false;
    private boolean ehW = false;
    private List<com.baidu.swan.impl.map.item.c> ehR = new ArrayList(1);

    public b() {
        bbC();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.ehR.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c yG = yG(str);
        if (yG != null) {
            this.ehR.remove(yG);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c yG(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.ehR) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        bbC();
        for (com.baidu.swan.impl.map.item.c cVar : this.ehR) {
            cVar.ejb.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.ehR) {
            cVar.ejb.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.ehW = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.ehR) {
                cVar.ejb.onDestroy();
            }
        }
        this.ehR.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.ehS) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.ehR) {
                MyLocationData locationData = cVar.ejb.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.ejb.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    bbB();
                }
            }
        }
        this.ehS = d;
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
            if (bDLocation == null || b.this.ehR.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.ehV = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.ehR) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.ejb.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void bbB() {
        if (this.ehT == null) {
            this.ehT = new LocationClient(AppRuntime.getAppContext());
            this.ehT.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.ehT.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.ehW && this.ehT != null && this.ehT.isStarted()) {
            this.ehT.stop();
            bbE();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void bbC() {
        if (this.ehW) {
            bbB();
            if (this.ehT != null && !this.ehT.isStarted()) {
                this.ehT.start();
                bbD();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void bbD() {
        if (!this.ehU) {
            this.bGk = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.bGk != null) {
                this.bGk.registerListener(this, this.bGk.getDefaultSensor(3), 2);
                this.ehU = true;
            }
        }
    }

    private void bbE() {
        if (this.bGk != null && this.ehU) {
            this.bGk.unregisterListener(this);
            this.ehU = false;
        }
    }

    public boolean bbF() {
        return this.ehT != null && this.ehT.isStarted();
    }

    public BDLocation bbG() {
        return this.ehV;
    }

    public void hZ(boolean z) {
        if (z) {
            this.ehW = true;
            bbC();
            return;
        }
        stopLocation();
        this.ehW = false;
    }
}
