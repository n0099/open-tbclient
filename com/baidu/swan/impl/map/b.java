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
/* loaded from: classes9.dex */
public class b implements SensorEventListener {
    private double eoq;
    private LocationClient eor;
    private BDLocation eot;
    private SensorManager mSensorManager;
    private boolean eos = false;
    private boolean eou = false;
    private List<com.baidu.swan.impl.map.item.c> eop = new ArrayList(1);

    public b() {
        bao();
    }

    public boolean a(com.baidu.swan.impl.map.item.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.eop.add(cVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.c xN = xN(str);
        if (xN != null) {
            this.eop.remove(xN);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.c xN(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.c cVar : this.eop) {
            if (cVar != null && TextUtils.equals(cVar.id, str)) {
                return cVar;
            }
        }
        return null;
    }

    public void resume() {
        bao();
        for (com.baidu.swan.impl.map.item.c cVar : this.eop) {
            cVar.epz.onResume();
        }
    }

    public void pause() {
        stopLocation();
        for (com.baidu.swan.impl.map.item.c cVar : this.eop) {
            cVar.epz.onPause();
        }
    }

    public void release() {
        stopLocation();
        this.eou = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.c cVar : this.eop) {
                cVar.epz.onDestroy();
            }
        }
        this.eop.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.eoq) > 1.0d) {
            for (com.baidu.swan.impl.map.item.c cVar : this.eop) {
                MyLocationData locationData = cVar.epz.getMap().getLocationData();
                if (locationData != null && cVar.isShowLocation) {
                    cVar.epz.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    ban();
                }
            }
        }
        this.eoq = d;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* loaded from: classes9.dex */
    public class a implements BDLocationListener {
        public a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null || b.this.eop.size() <= 0) {
                b.this.stopLocation();
                return;
            }
            b.this.eot = bDLocation;
            for (com.baidu.swan.impl.map.item.c cVar : b.this.eop) {
                if (cVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.epz.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void ban() {
        if (this.eor == null) {
            this.eor = new LocationClient(AppRuntime.getAppContext());
            this.eor.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.eor.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocation() {
        if (this.eou && this.eor != null && this.eor.isStarted()) {
            this.eor.stop();
            baq();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void bao() {
        if (this.eou) {
            ban();
            if (this.eor != null && !this.eor.isStarted()) {
                this.eor.start();
                bap();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void bap() {
        if (!this.eos) {
            this.mSensorManager = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.mSensorManager != null) {
                this.mSensorManager.registerListener(this, this.mSensorManager.getDefaultSensor(3), 2);
                this.eos = true;
            }
        }
    }

    private void baq() {
        if (this.mSensorManager != null && this.eos) {
            this.mSensorManager.unregisterListener(this);
            this.eos = false;
        }
    }

    public boolean bar() {
        return this.eor != null && this.eor.isStarted();
    }

    public BDLocation bas() {
        return this.eot;
    }

    public void ip(boolean z) {
        if (z) {
            this.eou = true;
            bao();
            return;
        }
        stopLocation();
        this.eou = false;
    }
}
