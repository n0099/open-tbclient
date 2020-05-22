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
    private SensorManager bcy;
    private BDLocation dfA;
    private double dfx;
    private LocationClient dfy;
    private boolean dfz = false;
    private boolean dfB = false;
    private List<com.baidu.swan.impl.map.item.c> dfw = new ArrayList(1);

    public b() {
        aDC();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.dfw.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c sQ = sQ(str);
        if (sQ != null) {
            this.dfw.remove(sQ);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c sQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.dfw) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        aDC();
        for (com.baidu.swan.impl.map.item.c cVar : this.dfw) {
            cVar.dgG.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.dfw) {
            cVar.dgG.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.dfB = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.dfw) {
                cVar.dgG.onDestroy();
            }
        }
        this.dfw.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.dfx) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.dfw) {
                MyLocationData locationData = cVar.dgG.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.dgG.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    aDB();
                }
            }
        }
        this.dfx = d;
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
            if (bDLocation == null || b.this.dfw.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.dfA = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.dfw) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.dgG.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void aDB() {
        if (this.dfy == null) {
            this.dfy = new LocationClient(AppRuntime.getAppContext());
            this.dfy.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.dfy.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.dfB && this.dfy != null && this.dfy.isStarted()) {
            this.dfy.stop();
            aDE();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void aDC() {
        if (this.dfB) {
            aDB();
            if (this.dfy != null && !this.dfy.isStarted()) {
                this.dfy.start();
                aDD();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void aDD() {
        if (!this.dfz) {
            this.bcy = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.bcy != null) {
                this.bcy.registerListener(this, this.bcy.getDefaultSensor(3), 2);
                this.dfz = true;
            }
        }
    }

    private void aDE() {
        if (this.bcy != null && this.dfz) {
            this.bcy.unregisterListener(this);
            this.dfz = false;
        }
    }

    public boolean aDF() {
        return this.dfy != null && this.dfy.isStarted();
    }

    public BDLocation aDG() {
        return this.dfA;
    }

    public void fT(boolean z) {
        if (z) {
            this.dfB = true;
            aDC();
            return;
        }
        stopLocation();
        this.dfB = false;
    }
}
