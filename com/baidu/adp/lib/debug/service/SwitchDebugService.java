package com.baidu.adp.lib.debug.service;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.os.Vibrator;
import android.widget.Toast;
import com.baidu.adp.R;
import com.baidu.adp.lib.debug.DebugConfigActivity;
import com.baidu.adp.lib.debug.d;
import com.baidu.adp.lib.debug.e;
import com.baidu.tbadk.core.frameworkData.a;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
/* loaded from: classes.dex */
public class SwitchDebugService extends Service implements SensorEventListener {
    private String mPackageName;
    private static int ACCELERATION = 80;
    private static int ACCELERATION_ONE = 15;
    private static int TIME_INTERVAL = 1000;
    private static int ROCK_MIN_NUM = 4;
    private static int ROCK_MAX_INTERVAL = 500;
    public static Properties customConfig = null;
    private SensorManager mSensorManager = null;
    private Vibrator mVibrator = null;
    private long mPreLotteryTime = 0;
    private float mLastX = 0.0f;
    private float mLastY = 0.0f;
    private float mLastZ = 0.0f;
    private int mRockNum = 0;
    private long mPreRockTime = 0;
    private boolean mValidRock = false;
    private boolean mRockPage = true;
    private ActivityManager mActivityManager = null;

    @Override // android.app.Service
    public void onCreate() {
        this.mPackageName = getPackageName();
        this.mActivityManager = (ActivityManager) getSystemService("activity");
        if (isProcessOnForGroud()) {
            super.onCreate();
            Toast.makeText(getBaseContext(), getText(R.string.switch_debug).toString(), 1).show();
            this.mSensorManager = (SensorManager) getSystemService("sensor");
            this.mVibrator = (Vibrator) getSystemService("vibrator");
            this.mRockPage = true;
            this.mSensorManager.registerListener(this, this.mSensorManager.getDefaultSensor(1), 3);
        }
        initCoustomConfig(getApplicationContext().getAssets());
    }

    public static void startSwitchDebugService(Context context, e eVar) {
        context.startService(new Intent(context, SwitchDebugService.class));
        d.gk = eVar;
    }

    private static void initCoustomConfig(AssetManager assetManager) {
        if (customConfig == null) {
            synchronized (SwitchDebugService.class) {
                if (customConfig == null) {
                    customConfig = new Properties();
                    try {
                        customConfig.load(assetManager.open("debug/debug_ascii.conf"));
                    } catch (IOException e) {
                        customConfig = null;
                        e.printStackTrace();
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
                if (intent.getBooleanExtra(a.STOP, false)) {
                    stopSelf();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && sensorEvent.values != null && sensorEvent.values.length >= 3) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            float f4 = f - this.mLastX;
            float f5 = f2 - this.mLastY;
            float f6 = f3 - this.mLastZ;
            this.mLastX = f;
            this.mLastY = f2;
            this.mLastZ = f3;
            if (this.mRockPage) {
                if (!this.mValidRock) {
                    this.mValidRock = true;
                } else if ((f4 * f4) + (f5 * f5) + (f6 * f6) >= ACCELERATION) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.mPreRockTime <= ROCK_MAX_INTERVAL) {
                        this.mRockNum++;
                    } else {
                        this.mRockNum = 1;
                    }
                    if (Math.abs(f5) >= ACCELERATION_ONE || Math.abs(f4) >= ACCELERATION_ONE || Math.abs(f6) >= ACCELERATION_ONE) {
                        this.mRockNum = ROCK_MIN_NUM;
                    }
                    this.mPreRockTime = currentTimeMillis;
                    if (this.mRockNum >= ROCK_MIN_NUM && currentTimeMillis - this.mPreLotteryTime > TIME_INTERVAL && isProcessOnForGroud()) {
                        this.mPreLotteryTime = currentTimeMillis;
                        this.mVibrator.vibrate(100L);
                        if (d.gh) {
                            Toast.makeText(getBaseContext(), getResources().getString(R.string.debug_opened), 1).show();
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

    private boolean isProcessOnForGroud() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.mActivityManager.getRunningAppProcesses();
        for (int i = 0; i < runningAppProcesses.size(); i++) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
            if (this.mPackageName.contains(runningAppProcessInfo.processName) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mSensorManager.unregisterListener(this);
    }
}
