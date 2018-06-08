package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import com.baidu.ar.representation.Quaternion;
import com.baidu.ar.representation.Vector4f;
import com.baidu.ar.util.ARLog;
/* loaded from: classes3.dex */
public class d extends f {
    private final Quaternion l;
    private Quaternion m;
    private Quaternion n;
    private long o;
    private double p;
    private boolean q;
    private int r;
    private int s;

    public d(SensorManager sensorManager) {
        super(sensorManager);
        this.l = new Quaternion();
        this.m = new Quaternion();
        this.n = new Quaternion();
        this.p = 0.0d;
        this.q = false;
        this.s = 0;
        ARLog.d("sensorList size " + String.valueOf(this.d.size()));
        if (this.d.size() > 120) {
            this.d.clear();
        }
        this.d.add(sensorManager.getDefaultSensor(4));
        this.d.add(sensorManager.getDefaultSensor(11));
    }

    private void a(Quaternion quaternion) {
        Quaternion clone = quaternion.clone();
        clone.e(-clone.h());
        synchronized (this.c) {
            this.f.a((Vector4f) quaternion);
            SensorManager.getRotationMatrixFromVector(this.e.g, clone.c());
            this.s++;
            if (this.s > 20) {
                a();
                setChanged();
                notifyObservers();
            }
        }
    }

    public static void a(float[] fArr, float[] fArr2) {
        if (fArr2.length >= 4) {
            fArr[0] = fArr2[3];
        } else {
            fArr[0] = ((1.0f - (fArr2[0] * fArr2[0])) - (fArr2[1] * fArr2[1])) - (fArr2[2] * fArr2[2]);
            fArr[0] = fArr[0] > 0.0f ? (float) Math.sqrt(fArr[0]) : 0.0f;
        }
        fArr[1] = fArr2[0];
        fArr[2] = fArr2[1];
        fArr[3] = fArr2[2];
    }

    protected void a() {
        if (this.h) {
            a(this.k.g, this.e.g, this.i.g);
            return;
        }
        this.h = true;
        System.arraycopy(this.e.g, 0, this.i.g, 0, this.e.g.length);
        Matrix.setIdentityM(this.k.g, 0);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 11) {
            synchronized (this.a) {
                for (int i = 0; i < sensorEvent.values.length; i++) {
                    if (Float.isNaN(sensorEvent.values[i])) {
                        this.b = false;
                        return;
                    }
                }
                float[] fArr = new float[4];
                try {
                    SensorManager.getQuaternionFromVector(fArr, sensorEvent.values);
                } catch (Exception e) {
                    a(fArr, sensorEvent.values);
                }
                this.n.a(fArr[1], fArr[2], fArr[3], -fArr[0]);
                if (this.q) {
                    return;
                }
                this.m.a(this.n);
                this.q = true;
            }
        } else if (sensorEvent.sensor.getType() == 4) {
            synchronized (this.a) {
                if (this.b.booleanValue()) {
                    if (this.o != 0) {
                        float f = ((float) (sensorEvent.timestamp - this.o)) * 1.0E-9f;
                        float f2 = sensorEvent.values[0];
                        float f3 = sensorEvent.values[1];
                        float f4 = sensorEvent.values[2];
                        this.p = Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
                        if (this.p > 0.10000000149011612d) {
                            f2 = (float) (f2 / this.p);
                            f3 = (float) (f3 / this.p);
                            f4 = (float) (f4 / this.p);
                        } else {
                            this.p = 0.0d;
                        }
                        double d = (f * this.p) / 2.0d;
                        double sin = Math.sin(d);
                        double cos = Math.cos(d);
                        this.l.a((float) (f2 * sin));
                        this.l.b((float) (f3 * sin));
                        this.l.c((float) (sin * f4));
                        this.l.d(-((float) cos));
                        this.l.a(this.m, this.m);
                        float b = this.m.b(this.n);
                        if (Math.abs(b) < 0.0f) {
                            if (Math.abs(b) < 0.0f) {
                                this.r++;
                            }
                            a(this.m);
                        } else {
                            Quaternion quaternion = new Quaternion();
                            this.m.a(this.n, quaternion, (float) (0.009999999776482582d * this.p));
                            a(quaternion);
                            this.m.a((Vector4f) quaternion);
                            this.r = 0;
                        }
                        if (this.r > 60) {
                            ARLog.d("Rotation VectorPanic counter is bigger than threshold; this indicates a Gyroscope failure. Panic reset is imminent.");
                            if (this.p < 3.0d) {
                                ARLog.d("Rotation VectorPerforming Panic-reset. Resetting orientation to rotation-vector value.");
                                a(this.n);
                                this.m.a((Vector4f) this.n);
                                this.r = 0;
                            } else {
                                ARLog.d("Rotation Vector" + String.format("Panic reset delayed due to ongoing motion (user is still shaking the device). Gyroscope Velocity: %.2f > 3", Double.valueOf(this.p)));
                            }
                        }
                    }
                    this.o = sensorEvent.timestamp;
                }
            }
        }
    }
}
