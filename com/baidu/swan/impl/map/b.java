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
    private SensorManager aBy;
    private double cvv;
    private LocationClient cvw;
    private BDLocation cvy;
    private boolean cvx = false;
    private boolean cvz = false;
    private List<com.baidu.swan.impl.map.item.c> cvu = new ArrayList(1);

    public b() {
        arz();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.cvu.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c pZ = pZ(str);
        if (pZ != null) {
            this.cvu.remove(pZ);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c pZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.cvu) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        arz();
        for (com.baidu.swan.impl.map.item.c cVar : this.cvu) {
            cVar.cwE.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.cvu) {
            cVar.cwE.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.cvz = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.cvu) {
                cVar.cwE.onDestroy();
            }
        }
        this.cvu.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.cvv) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.cvu) {
                MyLocationData locationData = cVar.cwE.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.cwE.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    ary();
                }
            }
        }
        this.cvv = d;
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
            if (bDLocation == null || b.this.cvu.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.cvy = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.cvu) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.cwE.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void ary() {
        if (this.cvw == null) {
            this.cvw = new LocationClient(AppRuntime.getAppContext());
            this.cvw.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.cvw.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.cvz && this.cvw != null && this.cvw.isStarted()) {
            this.cvw.stop();
            arB();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void arz() {
        if (this.cvz) {
            ary();
            if (this.cvw != null && !this.cvw.isStarted()) {
                this.cvw.start();
                arA();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void arA() {
        if (!this.cvx) {
            this.aBy = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.aBy != null) {
                this.aBy.registerListener(this, this.aBy.getDefaultSensor(3), 2);
                this.cvx = true;
            }
        }
    }

    private void arB() {
        if (this.aBy != null && this.cvx) {
            this.aBy.unregisterListener(this);
            this.cvx = false;
        }
    }

    public boolean arC() {
        return this.cvw != null && this.cvw.isStarted();
    }

    public BDLocation arD() {
        return this.cvy;
    }

    public void eL(boolean z) {
        if (z) {
            this.cvz = true;
            arz();
            return;
        }
        stopLocation();
        this.cvz = false;
    }
}
