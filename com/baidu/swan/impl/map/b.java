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
    private SensorManager aTA;
    private double bgD;
    private LocationClient bgE;
    private BDLocation bgG;
    private boolean bgF = false;
    private boolean bgH = false;
    private List<com.baidu.swan.impl.map.item.b> bgC = new ArrayList(1);

    public b() {
        PN();
    }

    public boolean a(com.baidu.swan.impl.map.item.b bVar) {
        if (bVar == null) {
            return false;
        }
        this.bgC.add(bVar);
        return true;
    }

    public boolean remove(String str) {
        com.baidu.swan.impl.map.item.b jd = jd(str);
        if (jd != null) {
            this.bgC.remove(jd);
            return true;
        }
        return false;
    }

    public com.baidu.swan.impl.map.item.b jd(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.baidu.swan.impl.map.item.b bVar : this.bgC) {
            if (bVar != null && TextUtils.equals(bVar.id, str)) {
                return bVar;
            }
        }
        return null;
    }

    public void resume() {
        PN();
        for (com.baidu.swan.impl.map.item.b bVar : this.bgC) {
            bVar.bhn.onResume();
        }
    }

    public void pause() {
        ja();
        for (com.baidu.swan.impl.map.item.b bVar : this.bgC) {
            bVar.bhn.onPause();
        }
    }

    public void release() {
        ja();
        this.bgH = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (com.baidu.swan.impl.map.item.b bVar : this.bgC) {
                bVar.bhn.onDestroy();
            }
        }
        this.bgC.clear();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d = sensorEvent.values[0];
        if (Math.abs(d - this.bgD) > 1.0d) {
            for (com.baidu.swan.impl.map.item.b bVar : this.bgC) {
                MyLocationData locationData = bVar.bhn.getMap().getLocationData();
                if (locationData != null && bVar.isShowLocation) {
                    bVar.bhn.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).accuracy(locationData.accuracy).satellitesNum(locationData.satellitesNum).build());
                    PM();
                }
            }
        }
        this.bgD = d;
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
            if (bDLocation == null || b.this.bgC.size() <= 0) {
                b.this.ja();
                return;
            }
            b.this.bgG = bDLocation;
            for (com.baidu.swan.impl.map.item.b bVar : b.this.bgC) {
                if (bVar.isShowLocation) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = bVar.bhn.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    private void PM() {
        if (this.bgE == null) {
            this.bgE = new LocationClient(AppRuntime.getAppContext());
            this.bgE.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.bgE.setLocOption(locationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja() {
        if (this.bgH && this.bgE != null && this.bgE.isStarted()) {
            this.bgE.stop();
            PP();
            com.baidu.swan.apps.console.c.w("map", "stop location");
        }
    }

    private void PN() {
        if (this.bgH) {
            PM();
            if (this.bgE != null && !this.bgE.isStarted()) {
                this.bgE.start();
                PO();
                com.baidu.swan.apps.console.c.w("map", "start location");
            }
        }
    }

    private void PO() {
        if (!this.bgF) {
            this.aTA = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            if (this.aTA != null) {
                this.aTA.registerListener(this, this.aTA.getDefaultSensor(3), 2);
                this.bgF = true;
            }
        }
    }

    private void PP() {
        if (this.aTA != null && this.bgF) {
            this.aTA.unregisterListener(this);
            this.bgF = false;
        }
    }

    public boolean PQ() {
        return this.bgE != null && this.bgE.isStarted();
    }

    public BDLocation PR() {
        return this.bgG;
    }

    public void cC(boolean z) {
        if (z) {
            this.bgH = true;
            PN();
            return;
        }
        ja();
        this.bgH = false;
    }
}
