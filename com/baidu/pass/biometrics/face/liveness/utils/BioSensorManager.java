package com.baidu.pass.biometrics.face.liveness.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.pass.biometrics.base.debug.Log;
/* loaded from: classes6.dex */
public class BioSensorManager {
    private Context context;
    private SensorEventListener listener;
    private SensorManager senserManager;
    private Sensor sensor;
    public static final String TAG = BioSensorManager.class.getSimpleName();
    private static long SHOW_WHITE_BG_INTERNAL_TIME = 1000;
    private long lastSensorChangeTime = 0;
    private float curIllum = 2.1474836E9f;

    /* loaded from: classes6.dex */
    public interface SensorCallback {
        void onChange(float f);
    }

    public BioSensorManager(Context context) {
        this.context = context;
    }

    @TargetApi(3)
    public void registerSensorListener(final SensorCallback sensorCallback) {
        this.senserManager = (SensorManager) this.context.getSystemService("sensor");
        if (this.senserManager == null) {
            Log.w(TAG, "sensorManager|senserManager == null");
            return;
        }
        this.sensor = this.senserManager.getDefaultSensor(5);
        if (this.sensor != null) {
            this.listener = new SensorEventListener() { // from class: com.baidu.pass.biometrics.face.liveness.utils.BioSensorManager.1
                @Override // android.hardware.SensorEventListener
                public void onAccuracyChanged(Sensor sensor, int i) {
                    Log.w(BioSensorManager.TAG, "onAccuracyChanged" + i);
                }

                @Override // android.hardware.SensorEventListener
                public void onSensorChanged(SensorEvent sensorEvent) {
                    Log.w(BioSensorManager.TAG, "onSensorChanged() time:" + System.currentTimeMillis());
                    if (sensorEvent.values != null && sensorEvent.values.length > 0) {
                        BioSensorManager.this.curIllum = sensorEvent.values[0];
                        Log.w(BioSensorManager.TAG, "onSensorChanged() event.values[0]:" + BioSensorManager.this.curIllum);
                    }
                    BioSensorManager.this.lastSensorChangeTime = System.currentTimeMillis();
                    if (sensorCallback != null) {
                        sensorCallback.onChange(BioSensorManager.this.getIllumValue());
                    }
                }
            };
            this.senserManager.registerListener(this.listener, this.sensor, 3);
        }
    }

    public float getIllumValue() {
        if (this.lastSensorChangeTime != 0 && System.currentTimeMillis() - this.lastSensorChangeTime > SHOW_WHITE_BG_INTERNAL_TIME) {
            this.curIllum = 0.0f;
        }
        return this.curIllum;
    }

    @TargetApi(3)
    public void unRegisterSensorListener() {
        Log.w(TAG, "unRegisterSensorListener()");
        if (this.senserManager != null && this.sensor != null) {
            this.senserManager.unregisterListener(this.listener);
        }
    }
}
