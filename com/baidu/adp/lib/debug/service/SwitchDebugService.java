package com.baidu.adp.lib.debug.service;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.content.res.AssetManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.os.Vibrator;
import android.widget.Toast;
import com.baidu.adp.f;
import com.baidu.adp.lib.debug.DebugConfigActivity;
import com.baidu.adp.lib.debug.b;
import com.baidu.location.LocationClientOption;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
/* loaded from: classes.dex */
public class SwitchDebugService extends Service implements SensorEventListener {
    private String q;
    private static int b = 80;
    private static int c = 15;
    private static int d = LocationClientOption.MIN_SCAN_SPAN;
    private static int e = 4;
    private static int f = 500;
    public static Properties a = null;
    private SensorManager g = null;
    private Vibrator h = null;
    private long i = 0;
    private float j = 0.0f;
    private float k = 0.0f;
    private float l = 0.0f;
    private int m = 0;
    private long n = 0;
    private boolean o = false;
    private boolean p = true;
    private ActivityManager r = null;

    @Override // android.app.Service
    public void onCreate() {
        this.q = getPackageName();
        this.r = (ActivityManager) getSystemService("activity");
        if (a()) {
            super.onCreate();
            Toast.makeText(getBaseContext(), getText(f.switch_debug).toString(), 1).show();
            this.g = (SensorManager) getSystemService("sensor");
            this.h = (Vibrator) getSystemService("vibrator");
            this.p = true;
            this.g.registerListener(this, this.g.getDefaultSensor(1), 3);
        }
        AssetManager assets = getApplicationContext().getAssets();
        if (a == null) {
            synchronized (SwitchDebugService.class) {
                if (a == null) {
                    a = new Properties();
                    try {
                        a.load(assets.open("debug/debug_ascii.conf"));
                    } catch (IOException e2) {
                        a = null;
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (intent != null) {
            try {
                if (intent.getBooleanExtra("stop", false)) {
                    stopSelf();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && sensorEvent.values != null && sensorEvent.values.length >= 3) {
            float f2 = sensorEvent.values[0];
            float f3 = sensorEvent.values[1];
            float f4 = sensorEvent.values[2];
            float f5 = f2 - this.j;
            float f6 = f3 - this.k;
            float f7 = f4 - this.l;
            this.j = f2;
            this.k = f3;
            this.l = f4;
            if (this.p) {
                if (!this.o) {
                    this.o = true;
                } else if ((f5 * f5) + (f6 * f6) + (f7 * f7) >= b) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.n <= f) {
                        this.m++;
                    } else {
                        this.m = 1;
                    }
                    if (Math.abs(f6) >= c || Math.abs(f5) >= c || Math.abs(f7) >= c) {
                        this.m = e;
                    }
                    this.n = currentTimeMillis;
                    if (this.m >= e && currentTimeMillis - this.i > d && a()) {
                        this.i = currentTimeMillis;
                        this.h.vibrate(100L);
                        if (b.c) {
                            Toast.makeText(getBaseContext(), getResources().getString(f.debug_opened), 1).show();
                            return;
                        }
                        Intent intent = new Intent(getApplicationContext(), DebugConfigActivity.class);
                        intent.setFlags(268435456);
                        startActivity(intent);
                    }
                }
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    private boolean a() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.r.getRunningAppProcesses();
        for (int i = 0; i < runningAppProcesses.size(); i++) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
            if (this.q.contains(runningAppProcessInfo.processName) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.g.unregisterListener(this);
    }
}
