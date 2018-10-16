package com.baidu.searchbox.ng.ai.apps.system.accelerometer;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
/* loaded from: classes2.dex */
public class AiAppsAccelerometerManager {
    private static final double GRAVITY_ACCELERATION = 9.8d;
    private static final String MODULE_TAG = "accelerometer";
    private static final int REPORT_TIME_PERIOD = 200;
    private static final String TAG = "AccelerometerManager";
    private static volatile AiAppsAccelerometerManager instance;
    private SensorEventListener mAccelerometerListener;
    private Sensor mAccelerometerSensor;
    private Context mContext;
    private double[] mCurrentAccelerometerValues = new double[3];
    private boolean mIsStartListen = false;
    private long mLastReportTime = 0;
    private OnAccelerometerChangeListener mOnAccelerometerChangeListener;
    private SensorManager mSensorManager;

    /* loaded from: classes2.dex */
    public interface OnAccelerometerChangeListener {
        void OnAccelerometerChange(double[] dArr);
    }

    private AiAppsAccelerometerManager() {
    }

    public static AiAppsAccelerometerManager getInstance() {
        if (instance == null) {
            synchronized (AiAppsAccelerometerManager.class) {
                if (instance == null) {
                    instance = new AiAppsAccelerometerManager();
                }
            }
        }
        return instance;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void setOnAccelerometerChangeListener(OnAccelerometerChangeListener onAccelerometerChangeListener) {
        this.mOnAccelerometerChangeListener = onAccelerometerChangeListener;
    }

    public void startListenAccelerometer() {
        if (this.mContext == null) {
            AiAppsLog.e(MODULE_TAG, "start error, none context");
        } else if (this.mIsStartListen) {
            AiAppsLog.w(MODULE_TAG, "has already start");
        } else {
            this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.mSensorManager != null) {
                this.mAccelerometerSensor = this.mSensorManager.getDefaultSensor(1);
                this.mSensorManager.registerListener(getAccelerometerListener(), this.mAccelerometerSensor, 1);
                this.mIsStartListen = true;
                AiAppsLog.i(MODULE_TAG, "start listen");
                return;
            }
            AiAppsLog.e(MODULE_TAG, "none sensorManager");
        }
    }

    public void stopListenAccelerometer() {
        if (!this.mIsStartListen) {
            AiAppsLog.w(MODULE_TAG, "has already stop");
            return;
        }
        if (this.mAccelerometerListener != null && this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.mAccelerometerListener);
            this.mAccelerometerListener = null;
        }
        this.mSensorManager = null;
        this.mAccelerometerSensor = null;
        this.mIsStartListen = false;
    }

    public static void release() {
        if (instance != null) {
            instance.realRelease();
        }
    }

    private void realRelease() {
        AiAppsLog.i(MODULE_TAG, "release");
        if (this.mIsStartListen) {
            stopListenAccelerometer();
        }
        this.mSensorManager = null;
        this.mAccelerometerSensor = null;
        this.mAccelerometerListener = null;
        this.mCurrentAccelerometerValues = null;
        this.mContext = null;
        instance = null;
    }

    private SensorEventListener getAccelerometerListener() {
        AiAppsLog.i(MODULE_TAG, "get Accelerometer listener");
        if (this.mAccelerometerListener != null) {
            return this.mAccelerometerListener;
        }
        this.mAccelerometerListener = new SensorEventListener() { // from class: com.baidu.searchbox.ng.ai.apps.system.accelerometer.AiAppsAccelerometerManager.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (AiAppsAccelerometerManager.this.mOnAccelerometerChangeListener != null && System.currentTimeMillis() - AiAppsAccelerometerManager.this.mLastReportTime > 200) {
                            AiAppsAccelerometerManager.this.mCurrentAccelerometerValues[0] = (-sensorEvent.values[0]) / AiAppsAccelerometerManager.GRAVITY_ACCELERATION;
                            AiAppsAccelerometerManager.this.mCurrentAccelerometerValues[1] = (-sensorEvent.values[1]) / AiAppsAccelerometerManager.GRAVITY_ACCELERATION;
                            AiAppsAccelerometerManager.this.mCurrentAccelerometerValues[2] = (-sensorEvent.values[2]) / AiAppsAccelerometerManager.GRAVITY_ACCELERATION;
                            AiAppsAccelerometerManager.this.mOnAccelerometerChangeListener.OnAccelerometerChange(AiAppsAccelerometerManager.this.mCurrentAccelerometerValues);
                            AiAppsAccelerometerManager.this.mLastReportTime = System.currentTimeMillis();
                            return;
                        }
                        return;
                    }
                    AiAppsLog.w(AiAppsAccelerometerManager.MODULE_TAG, "illegal accelerometer event");
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.mAccelerometerListener;
    }
}
