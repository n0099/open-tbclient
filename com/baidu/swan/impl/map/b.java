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
    private SensorManager aXy;
    private double bnT;
    private LocationClient bnU;
    private BDLocation bnW;
    private boolean bnV = false;
    private boolean bnX = false;
    private List<com.baidu.swan.impl.map.item.b> bnS = new ArrayList(1);

    public b() {
        Uv();
    }

    public boolean a(com.baidu.swan.impl.map.item.b bVar) {
        if (bVar == null) {
            return false;
        }
        this.bnS.add(bVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.b kl = kl(str);
        if (kl != null) {
            this.bnS.remove(kl);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.b kl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.b bVar : this.bnS) {
            if (bVar != null && TextUtils.equals(bVar.id, str)) {
                return bVar;
            }
        }
        return null;
    }

    public void resume() {
        Uv();
        for (com.baidu.swan.impl.map.item.b bVar : this.bnS) {
            bVar.boD.onResume();
        }
    }

    public void pause() {
        ic();
        for (com.baidu.swan.impl.map.item.b bVar : this.bnS) {
            bVar.boD.onPause();
        }
    }

    public void release() {
        ic();
        this.bnX = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.b bVar : this.bnS) {
                bVar.boD.onDestroy();
            }
        }
        this.bnS.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.bnT) > 1.0d) {
            for (com.baidu.swan.impl.map.item.b bVar : this.bnS) {
                MyLocationData locationData = bVar.boD.getMap().getLocationData();
                if (locationData != null && bVar.isShowLocation) {
                    bVar.boD.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).accuracy(locationData.accuracy).satellitesNum(locationData.satellitesNum).build());
                    Uu();
                }
            }
        }
        this.bnT = d;
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
            if (bDLocation == null || b.this.bnS.size() <= 0) {
                b.this.ic();
                return;
            }
            b.this.bnW = bDLocation;
            for (com.baidu.swan.impl.map.item.b bVar : b.this.bnS) {
                if (bVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = bVar.boD.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void Uu() {
        if (this.bnU == null) {
            this.bnU = new LocationClient(AppRuntime.getAppContext());
            this.bnU.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.bnU.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ic() {
        if (this.bnX && this.bnU != null && this.bnU.isStarted()) {
            this.bnU.stop();
            Ux();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void Uv() {
        if (this.bnX) {
            Uu();
            if (this.bnU != null && !this.bnU.isStarted()) {
                this.bnU.start();
                Uw();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void Uw() {
        if (!this.bnV) {
            this.aXy = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.aXy != null) {
                this.aXy.registerListener(this, this.aXy.getDefaultSensor(3), 2);
                this.bnV = true;
            }
        }
    }

    private void Ux() {
        if (this.aXy != null && this.bnV) {
            this.aXy.unregisterListener(this);
            this.bnV = false;
        }
    }

    public boolean Uy() {
        return this.bnU != null && this.bnU.isStarted();
    }

    public BDLocation Uz() {
        return this.bnW;
    }

    public void cW(boolean z) {
        if (z) {
            this.bnX = true;
            Uv();
            return;
        }
        ic();
        this.bnX = false;
    }
}
