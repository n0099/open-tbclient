package com.baidu.mapapi;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MKLocationManager {
    public static final int MK_COORDINATE_BAIDU09 = 2;
    public static final int MK_COORDINATE_GCJ = 1;
    public static final int MK_COORDINATE_WGS84 = 0;
    public static final int MK_GPS_PROVIDER = 0;
    public static final int MK_NETWORK_PROVIDER = 1;

    /* renamed from: a  reason: collision with root package name */
    private Location f510a = null;
    private Location b = null;
    private long c = 864000;
    private long d = 0;
    private List e = new ArrayList();
    private List f = new ArrayList();
    private SensorEventListener g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SensorEventListener sensorEventListener) {
        if (this.f.size() == 0) {
            if (d()) {
                if (this.f.add(sensorEventListener)) {
                    return true;
                }
                e();
                return false;
            }
            return false;
        }
        return this.f.add(sensorEventListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(BMapManager bMapManager) {
        if (bMapManager == null) {
            return false;
        }
        Mj.r = true;
        this.e.clear();
        return Mj.InitLocationCC() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Mj.DisableProviderCC(0);
        Mj.DisableProviderCC(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(SensorEventListener sensorEventListener) {
        this.f.remove(sensorEventListener);
        if (this.f.size() == 0) {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        int i = 0;
        Location locationInfo = getLocationInfo();
        long currentTimeMillis = System.currentTimeMillis();
        if (locationInfo != null && currentTimeMillis - this.d >= this.c * 1000) {
            this.d = currentTimeMillis;
            while (true) {
                int i2 = i;
                if (i2 >= this.e.size()) {
                    return;
                }
                ((LocationListener) this.e.get(i2)).onLocationChanged(locationInfo);
                this.b = locationInfo;
                i = i2 + 1;
            }
        } else if (this.b != null && locationInfo != null && locationInfo.distanceTo(this.b) < 0.1d && locationInfo.getAccuracy() == this.b.getAccuracy() && locationInfo.getBearing() == this.b.getBearing() && locationInfo.getSpeed() == this.b.getSpeed() && locationInfo.getAltitude() == this.b.getAltitude()) {
        } else {
            this.d = currentTimeMillis;
            while (true) {
                int i3 = i;
                if (i3 >= this.e.size()) {
                    return;
                }
                ((LocationListener) this.e.get(i3)).onLocationChanged(locationInfo);
                this.b = locationInfo;
                i = i3 + 1;
            }
        }
    }

    boolean d() {
        Sensor defaultSensor;
        SensorManager sensorManager = (SensorManager) Mj.e.getSystemService("sensor");
        if (sensorManager != null && (defaultSensor = sensorManager.getDefaultSensor(3)) != null) {
            this.g = new SensorEventListener() { // from class: com.baidu.mapapi.MKLocationManager.1
                @Override // android.hardware.SensorEventListener
                public void onAccuracyChanged(Sensor sensor, int i) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= MKLocationManager.this.f.size()) {
                            return;
                        }
                        ((SensorEventListener) MKLocationManager.this.f.get(i3)).onAccuracyChanged(sensor, i);
                        i2 = i3 + 1;
                    }
                }

                @Override // android.hardware.SensorEventListener
                public void onSensorChanged(SensorEvent sensorEvent) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= MKLocationManager.this.f.size()) {
                            return;
                        }
                        ((SensorEventListener) MKLocationManager.this.f.get(i2)).onSensorChanged(sensorEvent);
                        i = i2 + 1;
                    }
                }
            };
            return sensorManager.registerListener(this.g, defaultSensor, 3);
        }
        return false;
    }

    public boolean disableProvider(int i) {
        if ((i == 0 || i == 1) && Mj.DisableProviderCC(i) != 0) {
            if (i == 0) {
                Mj.q = false;
            } else if (i == 1) {
                Mj.r = false;
            }
            return true;
        }
        return false;
    }

    void e() {
        SensorManager sensorManager;
        if (this.g == null || (sensorManager = (SensorManager) Mj.e.getSystemService("sensor")) == null || sensorManager.getDefaultSensor(3) == null) {
            return;
        }
        sensorManager.unregisterListener(this.g);
    }

    public boolean enableProvider(int i) {
        if ((i == 0 || i == 1) && Mj.EnableProviderCC(i) != 0) {
            if (i == 0) {
                Mj.q = true;
            } else if (i == 1) {
                Mj.r = true;
            }
            return true;
        }
        return false;
    }

    public Location getLocationInfo() {
        Bundle GetGPSStatus = Mj.GetGPSStatus();
        if (GetGPSStatus == null) {
            return null;
        }
        if (GetGPSStatus.getInt("t") == 1) {
            this.f510a = new Location("network");
            this.f510a.setLatitude(GetGPSStatus.getFloat("y"));
            this.f510a.setLongitude(GetGPSStatus.getFloat("x"));
            this.f510a.setAccuracy(GetGPSStatus.getInt("r"));
        } else {
            this.f510a = Mj.f528a.f552a;
            this.f510a.setLatitude(GetGPSStatus.getFloat("y"));
            this.f510a.setLongitude(GetGPSStatus.getFloat("x"));
        }
        return this.f510a;
    }

    public Bundle getNotifyInternal() {
        return Mj.GetNotifyInternal();
    }

    public void removeUpdates(LocationListener locationListener) {
        this.e.remove(locationListener);
    }

    public void requestLocationUpdates(LocationListener locationListener) {
        this.e.add(locationListener);
    }

    public void setLocationCoordinateType(int i) {
        Mj.c = i;
        Mj.SetLocationCoordinateType(i);
    }

    public boolean setNotifyInternal(int i, int i2) {
        if (i < i2 || i2 < 0) {
            return false;
        }
        this.c = i;
        return Mj.SetNotifyInternal(i, i2) == 1;
    }
}
