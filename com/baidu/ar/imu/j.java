package com.baidu.ar.imu;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.ar.arplay.representation.Matrix;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Quaternion;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
/* loaded from: classes6.dex */
public abstract class j extends Observable implements SensorEventListener {
    private static final String TAG = j.class.getSimpleName();
    private SensorManager sC;
    protected float[] se;
    protected Object sw = new Object();
    protected Boolean sx = true;
    protected final Object sy = new Object();
    protected List<Sensor> sz = new ArrayList();
    boolean sD = false;
    protected final Matrixf4x4 sA = new Matrixf4x4();
    protected final Quaternion sB = new Quaternion();
    protected final Matrixf4x4 sE = new Matrixf4x4();
    protected final Matrixf4x4 sF = new Matrixf4x4();
    protected final Matrixf4x4 sG = new Matrixf4x4();

    public j(SensorManager sensorManager) {
        this.sC = sensorManager;
        com.baidu.ar.h.b.c(TAG, "sensorList size " + String.valueOf(this.sz.size()));
        if (this.sz.size() > 120) {
            this.sz.clear();
        }
    }

    public static void a(float[] fArr, float[] fArr2, float[] fArr3) {
        float[] fArr4 = new float[16];
        Matrix.setIdentityM(fArr4, 0);
        Matrix.invertM(fArr4, 0, fArr3, 0);
        Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr4, 0);
    }

    public static boolean a(float[] fArr, float[] fArr2) {
        float f;
        float[] fArr3 = new float[4];
        float[] fArr4 = {1.0f, 0.0f, 0.0f, 0.0f};
        Matrix.multiplyMV(fArr3, fArr2, fArr4);
        if (Float.compare(fArr3[0], fArr4[0]) == 0 && Float.compare(fArr3[1], fArr4[1]) == 0 && Float.compare(fArr3[2], fArr4[2]) == 0) {
            return false;
        }
        int compare = Float.compare(fArr3[0], 0.0f);
        int compare2 = Float.compare(fArr3[1], 0.0f);
        if (compare != 0) {
            double d = fArr3[1] / fArr3[0];
            f = (compare <= 0 || compare2 < 0) ? (compare <= 0 || compare2 >= 0) ? 180.0f + ((float) ((Math.atan(d) * 180.0d) / 3.141592653589793d)) : 360.0f + ((float) ((Math.atan(d) * 180.0d) / 3.141592653589793d)) : (float) ((Math.atan(d) * 180.0d) / 3.141592653589793d);
        } else {
            f = Float.compare(fArr3[1], 1.0f) == 0 ? 0.0f : Float.compare(fArr3[1], -1.0f) == 0 ? 180.0f : 0.0f;
        }
        com.baidu.ar.h.b.c(TAG, "orientation: outputV[0] = " + fArr3[0] + ", outputV[1] = " + fArr3[1] + ", angleZ = " + f);
        Matrix.setIdentityM(fArr, 0);
        Matrix.rotateM(fArr, 0, f, 0.0f, 0.0f, 1.0f);
        return true;
    }

    public static void b(float[] fArr, float[] fArr2) {
        System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
    }

    public boolean fc() {
        for (Sensor sensor : this.sz) {
            if (sensor == null) {
                return false;
            }
        }
        return true;
    }

    public Matrixf4x4 fd() {
        return this.sG;
    }

    public float[] fe() {
        return this.se;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void release() {
        deleteObservers();
        for (Sensor sensor : this.sz) {
            this.sC.unregisterListener(this, sensor);
        }
        this.sz.clear();
    }

    public void start() {
        for (Sensor sensor : this.sz) {
            this.sC.registerListener(this, sensor, 1);
        }
    }
}
