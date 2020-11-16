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
/* loaded from: classes12.dex */
public abstract class j extends Observable implements SensorEventListener {
    private static final String TAG = j.class.getSimpleName();
    protected float[] rN;
    private SensorManager sl;
    protected Object sf = new Object();
    protected Boolean sg = true;
    protected final Object sh = new Object();
    protected List<Sensor> si = new ArrayList();
    boolean sm = false;
    protected final Matrixf4x4 sj = new Matrixf4x4();
    protected final Quaternion sk = new Quaternion();
    protected final Matrixf4x4 sn = new Matrixf4x4();
    protected final Matrixf4x4 so = new Matrixf4x4();
    protected final Matrixf4x4 sp = new Matrixf4x4();

    public j(SensorManager sensorManager) {
        this.sl = sensorManager;
        com.baidu.ar.g.b.c(TAG, "sensorList size " + String.valueOf(this.si.size()));
        if (this.si.size() > 120) {
            this.si.clear();
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
        com.baidu.ar.g.b.c(TAG, "orientation: outputV[0] = " + fArr3[0] + ", outputV[1] = " + fArr3[1] + ", angleZ = " + f);
        Matrix.setIdentityM(fArr, 0);
        Matrix.rotateM(fArr, 0, f, 0.0f, 0.0f, 1.0f);
        return true;
    }

    public static void b(float[] fArr, float[] fArr2) {
        System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
    }

    public boolean fd() {
        for (Sensor sensor : this.si) {
            if (sensor == null) {
                return false;
            }
        }
        return true;
    }

    public Matrixf4x4 fe() {
        return this.sp;
    }

    public float[] ff() {
        return this.rN;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void release() {
        deleteObservers();
        for (Sensor sensor : this.si) {
            this.sl.unregisterListener(this, sensor);
        }
        this.si.clear();
    }

    public void start() {
        for (Sensor sensor : this.si) {
            this.sl.registerListener(this, sensor, 1);
        }
    }
}
