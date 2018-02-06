package com.baidu.ar.d;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import com.baidu.ar.representation.Quaternion;
/* loaded from: classes3.dex */
public class a extends d {
    private final Quaternion l;
    private long m;
    private int n;
    private double o;

    public a(SensorManager sensorManager) {
        super(sensorManager);
        this.l = new Quaternion();
        this.n = 0;
        this.o = 0.0d;
        this.d.add(sensorManager.getDefaultSensor(4));
    }

    protected void a() {
        if (this.h) {
            a(this.k.g, this.e.g, this.i.g);
            return;
        }
        System.arraycopy(this.e.g, 0, this.i.g, 0, this.i.g.length);
        Matrix.setIdentityM(this.k.g, 0);
        this.h = true;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 4) {
            if (this.m != 0) {
                float f = ((float) (sensorEvent.timestamp - this.m)) * 1.0E-9f;
                float f2 = sensorEvent.values[0];
                float f3 = sensorEvent.values[1];
                float f4 = sensorEvent.values[2];
                this.o = Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
                if (this.o > 0.10000000149011612d) {
                    f2 = (float) (f2 / this.o);
                    f3 = (float) (f3 / this.o);
                    f4 = (float) (f4 / this.o);
                }
                double d = (this.o * f) / 2.0d;
                double sin = Math.sin(d);
                double cos = Math.cos(d);
                this.l.a((float) (f2 * sin));
                this.l.b((float) (f3 * sin));
                this.l.c((float) (f4 * sin));
                this.l.d(-((float) cos));
                synchronized (this.c) {
                    this.l.a(this.f, this.f);
                }
                Quaternion clone = this.f.clone();
                clone.e(-clone.h());
                synchronized (this.c) {
                    SensorManager.getRotationMatrixFromVector(this.e.g, clone.c());
                }
            }
            this.m = sensorEvent.timestamp;
            this.n++;
            if (this.n > 20) {
                a();
                setChanged();
                notifyObservers();
            }
        }
    }
}
