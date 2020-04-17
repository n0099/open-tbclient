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
/* loaded from: classes3.dex */
public abstract class j extends Observable implements SensorEventListener {
    private static final String TAG = j.class.getSimpleName();
    protected float[] qJ;
    private SensorManager ri;
    protected Object rc = new Object();
    protected Boolean rd = true;
    protected final Object re = new Object();
    protected List<Sensor> rf = new ArrayList();
    boolean rj = false;
    protected final Matrixf4x4 rg = new Matrixf4x4();
    protected final Quaternion rh = new Quaternion();
    protected final Matrixf4x4 rk = new Matrixf4x4();
    protected final Matrixf4x4 rl = new Matrixf4x4();
    protected final Matrixf4x4 rm = new Matrixf4x4();

    public j(SensorManager sensorManager) {
        this.ri = sensorManager;
        com.baidu.ar.f.b.c(TAG, "sensorList size " + String.valueOf(this.rf.size()));
        if (this.rf.size() > 120) {
            this.rf.clear();
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
        com.baidu.ar.f.b.c(TAG, "orientation: outputV[0] = " + fArr3[0] + ", outputV[1] = " + fArr3[1] + ", angleZ = " + f);
        Matrix.setIdentityM(fArr, 0);
        Matrix.rotateM(fArr, 0, f, 0.0f, 0.0f, 1.0f);
        return true;
    }

    public static void b(float[] fArr, float[] fArr2) {
        System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
    }

    public boolean dD() {
        for (Sensor sensor : this.rf) {
            if (sensor == null) {
                return false;
            }
        }
        return true;
    }

    public Matrixf4x4 dE() {
        return this.rm;
    }

    public float[] dF() {
        return this.qJ;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void release() {
        deleteObservers();
        for (Sensor sensor : this.rf) {
            this.ri.unregisterListener(this, sensor);
        }
        this.rf.clear();
    }

    public void start() {
        for (Sensor sensor : this.rf) {
            this.ri.registerListener(this, sensor, 1);
        }
    }
}
