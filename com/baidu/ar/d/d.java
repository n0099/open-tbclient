package com.baidu.ar.d;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.ar.representation.Quaternion;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
/* loaded from: classes3.dex */
public abstract class d extends Observable implements SensorEventListener {
    protected SensorManager g;
    protected Object a = new Object();
    protected Boolean b = new Boolean(true);
    protected final Object c = new Object();
    protected List<Sensor> d = new ArrayList();
    boolean h = false;
    protected final com.baidu.ar.representation.b e = new com.baidu.ar.representation.b();
    protected final Quaternion f = new Quaternion();
    protected final com.baidu.ar.representation.b i = new com.baidu.ar.representation.b();
    protected final com.baidu.ar.representation.b j = new com.baidu.ar.representation.b();
    protected final com.baidu.ar.representation.b k = new com.baidu.ar.representation.b();

    public d(SensorManager sensorManager) {
        this.g = sensorManager;
    }

    public static void a(float[] fArr, float[] fArr2, float[] fArr3) {
        float[] fArr4 = new float[16];
        com.baidu.ar.representation.a.a(fArr4, 0);
        com.baidu.ar.representation.a.a(fArr4, 0, fArr3, 0);
        com.baidu.ar.representation.a.a(fArr, 0, fArr2, 0, fArr4, 0);
    }

    public static boolean b(float[] fArr, float[] fArr2) {
        float f;
        float[] fArr3 = new float[4];
        float[] fArr4 = {1.0f, 0.0f, 0.0f, 0.0f};
        com.baidu.ar.representation.a.a(fArr3, fArr2, fArr4);
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
        com.baidu.ar.util.b.c("orientation provider0: outputV[0] = " + fArr3[0] + ", outputV[1] = " + fArr3[1] + ", angleZ = " + f);
        com.baidu.ar.representation.a.a(fArr, 0);
        com.baidu.ar.representation.a.a(fArr, 0, f, 0.0f, 0.0f, 1.0f);
        return true;
    }

    public static void c(float[] fArr, float[] fArr2) {
        System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
    }

    public void b() {
        for (Sensor sensor : this.d) {
            this.g.registerListener(this, sensor, 1);
        }
    }

    public boolean c() {
        for (Sensor sensor : this.d) {
            if (sensor == null) {
                return false;
            }
        }
        return true;
    }

    public void d() {
        for (Sensor sensor : this.d) {
            this.g.unregisterListener(this, sensor);
        }
    }

    public com.baidu.ar.representation.b e() {
        return this.k;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
