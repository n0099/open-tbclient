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
    private SensorManager bnK;
    private double dAf;
    private LocationClient dAg;
    private BDLocation dAi;
    private boolean dAh = false;
    private boolean dAj = false;
    private List<com.baidu.swan.impl.map.item.c> dAe = new ArrayList(1);

    public b() {
        aRp();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.dAe.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c wr = wr(str);
        if (wr != null) {
            this.dAe.remove(wr);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c wr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.dAe) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        aRp();
        for (com.baidu.swan.impl.map.item.c cVar : this.dAe) {
            cVar.dBo.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.dAe) {
            cVar.dBo.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.dAj = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.dAe) {
                cVar.dBo.onDestroy();
            }
        }
        this.dAe.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.dAf) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.dAe) {
                MyLocationData locationData = cVar.dBo.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.dBo.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    aRo();
                }
            }
        }
        this.dAf = d;
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
            if (bDLocation == null || b.this.dAe.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.dAi = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.dAe) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.dBo.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void aRo() {
        if (this.dAg == null) {
            this.dAg = new LocationClient(AppRuntime.getAppContext());
            this.dAg.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.dAg.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.dAj && this.dAg != null && this.dAg.isStarted()) {
            this.dAg.stop();
            aRr();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void aRp() {
        if (this.dAj) {
            aRo();
            if (this.dAg != null && !this.dAg.isStarted()) {
                this.dAg.start();
                aRq();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void aRq() {
        if (!this.dAh) {
            this.bnK = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.bnK != null) {
                this.bnK.registerListener(this, this.bnK.getDefaultSensor(3), 2);
                this.dAh = true;
            }
        }
    }

    private void aRr() {
        if (this.bnK != null && this.dAh) {
            this.bnK.unregisterListener(this);
            this.dAh = false;
        }
    }

    public boolean aRs() {
        return this.dAg != null && this.dAg.isStarted();
    }

    public BDLocation aRt() {
        return this.dAi;
    }

    public void gQ(boolean z) {
        if (z) {
            this.dAj = true;
            aRp();
            return;
        }
        stopLocation();
        this.dAj = false;
    }
}
