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
    private SensorManager aXa;
    private double bnv;
    private LocationClient bnw;
    private BDLocation bny;
    private boolean bnx = false;
    private boolean bnz = false;
    private List<com.baidu.swan.impl.map.item.b> bnu = new ArrayList(1);

    public b() {
        Ur();
    }

    public boolean a(com.baidu.swan.impl.map.item.b bVar) {
        if (bVar == null) {
            return false;
        }
        this.bnu.add(bVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.b kj = kj(str);
        if (kj != null) {
            this.bnu.remove(kj);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.b kj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.b bVar : this.bnu) {
            if (bVar != null && TextUtils.equals(bVar.id, str)) {
                return bVar;
            }
        }
        return null;
    }

    public void resume() {
        Ur();
        for (com.baidu.swan.impl.map.item.b bVar : this.bnu) {
            bVar.bof.onResume();
        }
    }

    public void pause() {
        ic();
        for (com.baidu.swan.impl.map.item.b bVar : this.bnu) {
            bVar.bof.onPause();
        }
    }

    public void release() {
        ic();
        this.bnz = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.b bVar : this.bnu) {
                bVar.bof.onDestroy();
            }
        }
        this.bnu.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.bnv) > 1.0d) {
            for (com.baidu.swan.impl.map.item.b bVar : this.bnu) {
                MyLocationData locationData = bVar.bof.getMap().getLocationData();
                if (locationData != null && bVar.isShowLocation) {
                    bVar.bof.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).accuracy(locationData.accuracy).satellitesNum(locationData.satellitesNum).build());
                    Uq();
                }
            }
        }
        this.bnv = d;
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
            if (bDLocation == null || b.this.bnu.size() <= 0) {
                b.this.ic();
                return;
            }
            b.this.bny = bDLocation;
            for (com.baidu.swan.impl.map.item.b bVar : b.this.bnu) {
                if (bVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = bVar.bof.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void Uq() {
        if (this.bnw == null) {
            this.bnw = new LocationClient(AppRuntime.getAppContext());
            this.bnw.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.bnw.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ic() {
        if (this.bnz && this.bnw != null && this.bnw.isStarted()) {
            this.bnw.stop();
            Ut();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void Ur() {
        if (this.bnz) {
            Uq();
            if (this.bnw != null && !this.bnw.isStarted()) {
                this.bnw.start();
                Us();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void Us() {
        if (!this.bnx) {
            this.aXa = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.aXa != null) {
                this.aXa.registerListener(this, this.aXa.getDefaultSensor(3), 2);
                this.bnx = true;
            }
        }
    }

    private void Ut() {
        if (this.aXa != null && this.bnx) {
            this.aXa.unregisterListener(this);
            this.bnx = false;
        }
    }

    public boolean Uu() {
        return this.bnw != null && this.bnw.isStarted();
    }

    public BDLocation Uv() {
        return this.bny;
    }

    public void cW(boolean z) {
        if (z) {
            this.bnz = true;
            Ur();
            return;
        }
        ic();
        this.bnz = false;
    }
}
