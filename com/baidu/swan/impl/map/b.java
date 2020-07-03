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
    private SensorManager bhI;
    private double dkj;
    private LocationClient dkk;
    private BDLocation dkm;
    private boolean dkl = false;
    private boolean dkn = false;
    private List<com.baidu.swan.impl.map.item.c> dki = new ArrayList(1);

    public b() {
        aEI();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.dki.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c sY = sY(str);
        if (sY != null) {
            this.dki.remove(sY);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c sY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.dki) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        aEI();
        for (com.baidu.swan.impl.map.item.c cVar : this.dki) {
            cVar.dls.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.dki) {
            cVar.dls.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.dkn = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.dki) {
                cVar.dls.onDestroy();
            }
        }
        this.dki.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.dkj) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.dki) {
                MyLocationData locationData = cVar.dls.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.dls.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    aEH();
                }
            }
        }
        this.dkj = d;
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
            if (bDLocation == null || b.this.dki.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.dkm = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.dki) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.dls.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void aEH() {
        if (this.dkk == null) {
            this.dkk = new LocationClient(AppRuntime.getAppContext());
            this.dkk.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.dkk.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.dkn && this.dkk != null && this.dkk.isStarted()) {
            this.dkk.stop();
            aEK();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void aEI() {
        if (this.dkn) {
            aEH();
            if (this.dkk != null && !this.dkk.isStarted()) {
                this.dkk.start();
                aEJ();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void aEJ() {
        if (!this.dkl) {
            this.bhI = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.bhI != null) {
                this.bhI.registerListener(this, this.bhI.getDefaultSensor(3), 2);
                this.dkl = true;
            }
        }
    }

    private void aEK() {
        if (this.bhI != null && this.dkl) {
            this.bhI.unregisterListener(this);
            this.dkl = false;
        }
    }

    public boolean aEL() {
        return this.dkk != null && this.dkk.isStarted();
    }

    public BDLocation aEM() {
        return this.dkm;
    }

    public void fY(boolean z) {
        if (z) {
            this.dkn = true;
            aEI();
            return;
        }
        stopLocation();
        this.dkn = false;
    }
}
