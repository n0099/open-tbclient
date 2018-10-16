package com.baidu.searchbox.ng.ai.apps.system.compass;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
/* loaded from: classes2.dex */
public class AiAppsCompassManager {
    private static final String MODULE_TAG = "compass";
    private static final int REPORT_TIME_PERIOD = 200;
    private static final String TAG = "AiAppsCompassManager";
    private static volatile AiAppsCompassManager instance;
    private SensorEventListener mAccelerometerListener;
    private Sensor mAccelerometerSensor;
    private Context mContext;
    private SensorEventListener mMagneticFieldListener;
    private Sensor mMagneticSensor;
    private OnCompassChangeListener mOnCompassChangeListener;
    private SensorManager mSensorManager;
    private float[] mAccelerometerValues = new float[3];
    private float[] mMagneticFieldValues = new float[3];
    private boolean mIsStartListen = false;
    private long mLastReportTime = 0;

    /* loaded from: classes2.dex */
    public interface OnCompassChangeListener {
        void OnCompassChange(float f);
    }

    private AiAppsCompassManager() {
    }

    public static AiAppsCompassManager getInstance() {
        if (instance == null) {
            synchronized (AiAppsCompassManager.class) {
                if (instance == null) {
                    instance = new AiAppsCompassManager();
                }
            }
        }
        return instance;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void setOnCompassChangeListener(OnCompassChangeListener onCompassChangeListener) {
        this.mOnCompassChangeListener = onCompassChangeListener;
    }

    public void startListenCompass() {
        if (this.mContext == null) {
            AiAppsLog.e(MODULE_TAG, "start error, none context");
        } else if (this.mIsStartListen) {
            AiAppsLog.w(MODULE_TAG, "has already start");
        } else {
            this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.mSensorManager != null) {
                this.mAccelerometerSensor = this.mSensorManager.getDefaultSensor(1);
                this.mMagneticSensor = this.mSensorManager.getDefaultSensor(2);
                this.mSensorManager.registerListener(getAccelerometerListener(), this.mAccelerometerSensor, 1);
                this.mSensorManager.registerListener(getMagneticFieldListener(), this.mMagneticSensor, 2);
                this.mIsStartListen = true;
                AiAppsLog.i(MODULE_TAG, "start listen");
                return;
            }
            AiAppsLog.e(MODULE_TAG, "none sensorManager");
        }
    }

    public void stopListenCompass() {
        if (!this.mIsStartListen) {
            AiAppsLog.w(MODULE_TAG, "has already stop");
            return;
        }
        AiAppsLog.i(MODULE_TAG, "stop listen");
        if (this.mAccelerometerListener != null && this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.mAccelerometerListener);
            this.mAccelerometerListener = null;
        }
        if (this.mMagneticFieldListener != null && this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.mMagneticFieldListener);
            this.mMagneticFieldListener = null;
        }
        this.mSensorManager = null;
        this.mMagneticSensor = null;
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
            stopListenCompass();
        }
        this.mSensorManager = null;
        this.mMagneticSensor = null;
        this.mAccelerometerSensor = null;
        this.mAccelerometerListener = null;
        this.mMagneticFieldListener = null;
        this.mOnCompassChangeListener = null;
        this.mContext = null;
        instance = null;
    }

    private SensorEventListener getAccelerometerListener() {
        AiAppsLog.i(MODULE_TAG, "get Accelerometer listener");
        if (this.mAccelerometerListener != null) {
            return this.mAccelerometerListener;
        }
        this.mAccelerometerListener = new SensorEventListener() { // from class: com.baidu.searchbox.ng.ai.apps.system.compass.AiAppsCompassManager.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    AiAppsCompassManager.this.mAccelerometerValues = sensorEvent.values;
                    AiAppsLog.i(AiAppsCompassManager.MODULE_TAG, "accelerometer changed");
                    AiAppsCompassManager.this.handleSensorChanged();
                    return;
                }
                AiAppsLog.w(AiAppsCompassManager.MODULE_TAG, "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.mAccelerometerListener;
    }

    private SensorEventListener getMagneticFieldListener() {
        AiAppsLog.i(MODULE_TAG, "get MagneticFiled listener");
        if (this.mMagneticFieldListener != null) {
            return this.mMagneticFieldListener;
        }
        this.mMagneticFieldListener = new SensorEventListener() { // from class: com.baidu.searchbox.ng.ai.apps.system.compass.AiAppsCompassManager.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    AiAppsCompassManager.this.mMagneticFieldValues = sensorEvent.values;
                    AiAppsLog.i(AiAppsCompassManager.MODULE_TAG, "magneticFiled changed");
                    AiAppsCompassManager.this.handleSensorChanged();
                    return;
                }
                AiAppsLog.w(AiAppsCompassManager.MODULE_TAG, "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.mMagneticFieldListener;
    }

    private float calculateOrientation() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.mAccelerometerValues, this.mMagneticFieldValues);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSensorChanged() {
        if (this.mOnCompassChangeListener != null && System.currentTimeMillis() - this.mLastReportTime > 200) {
            float calculateOrientation = calculateOrientation();
            AiAppsLog.i(MODULE_TAG, "orientation changed, orientation : " + calculateOrientation);
            this.mOnCompassChangeListener.OnCompassChange(calculateOrientation);
            this.mLastReportTime = System.currentTimeMillis();
        }
    }
}
