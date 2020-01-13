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
/* loaded from: classes10.dex */
public class b implements SensorEventListener {
    private SensorManager awS;
    private double crg;
    private LocationClient crh;
    private BDLocation crj;
    private boolean cri = false;
    private boolean crk = false;
    private List<com.baidu.swan.impl.map.item.c> crf = new ArrayList(1);

    public b() {
        apg();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.crf.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c pL = pL(str);
        if (pL != null) {
            this.crf.remove(pL);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c pL(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.crf) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        apg();
        for (com.baidu.swan.impl.map.item.c cVar : this.crf) {
            cVar.csp.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.crf) {
            cVar.csp.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.crk = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.crf) {
                cVar.csp.onDestroy();
            }
        }
        this.crf.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.crg) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.crf) {
                MyLocationData locationData = cVar.csp.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.csp.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    apf();
                }
            }
        }
        this.crg = d;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* loaded from: classes10.dex */
    public class a implements BDLocationListener {
        public a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null || b.this.crf.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.crj = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.crf) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.csp.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void apf() {
        if (this.crh == null) {
            this.crh = new LocationClient(AppRuntime.getAppContext());
            this.crh.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.crh.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.crk && this.crh != null && this.crh.isStarted()) {
            this.crh.stop();
            apj();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void apg() {
        if (this.crk) {
            apf();
            if (this.crh != null && !this.crh.isStarted()) {
                this.crh.start();
                aph();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void aph() {
        if (!this.cri) {
            this.awS = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.awS != null) {
                this.awS.registerListener(this, this.awS.getDefaultSensor(3), 2);
                this.cri = true;
            }
        }
    }

    private void apj() {
        if (this.awS != null && this.cri) {
            this.awS.unregisterListener(this);
            this.cri = false;
        }
    }

    public boolean apk() {
        return this.crh != null && this.crh.isStarted();
    }

    public BDLocation apl() {
        return this.crj;
    }

    public void eD(boolean z) {
        if (z) {
            this.crk = true;
            apg();
            return;
        }
        stopLocation();
        this.crk = false;
    }
}
