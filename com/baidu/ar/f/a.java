package com.baidu.ar.f;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a implements SensorEventListener {
    public Context mContext;
    public SensorManager rH;
    public Sensor vS;
    public InterfaceC0056a vT;
    public boolean vU = true;
    public LinkedList<Double> vV = new LinkedList<>();
    public LinkedList<Float> vW = new LinkedList<>();
    public LinkedList<Float> vX = new LinkedList<>();
    public LinkedList<Float> vY = new LinkedList<>();
    public int vZ = 10;
    public double wa = 0.0d;
    public boolean wb = true;
    public boolean wc = false;

    /* renamed from: com.baidu.ar.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0056a {
        void b(float f, float f2, float f3, float f4);

        void destroy();
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void S(boolean z) {
        this.vU = z;
    }

    public void a(InterfaceC0056a interfaceC0056a) {
        this.vT = interfaceC0056a;
    }

    public void a(LinkedList linkedList, double d) {
        if (linkedList.size() >= this.vZ) {
            linkedList.poll();
        }
        linkedList.offer(Double.valueOf(d));
    }

    public void a(LinkedList linkedList, float f) {
        if (linkedList.size() >= this.vZ) {
            linkedList.poll();
        }
        linkedList.offer(Float.valueOf(f));
    }

    public void b(float f, float f2, float f3) {
        InterfaceC0056a interfaceC0056a;
        double sqrt = Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
        if (sqrt > this.wa) {
            this.wa = sqrt;
        }
        com.baidu.ar.h.b.aQ("max acc is : " + this.wa);
        a(this.vV, sqrt);
        a((LinkedList) this.vW, Math.abs(f));
        a((LinkedList) this.vX, Math.abs(f2));
        a((LinkedList) this.vY, Math.abs(f3));
        if (this.vV.size() == this.vZ) {
            float f4 = 0.0f;
            double d = 0.0d;
            float f5 = 0.0f;
            float f6 = 0.0f;
            for (int i = 0; i < this.vV.size(); i++) {
                d += this.vV.get(i).doubleValue();
                f4 += this.vW.get(i).floatValue();
                f5 += this.vX.get(i).floatValue();
                f6 += this.vY.get(i).floatValue();
            }
            int i2 = this.vZ;
            double d2 = d / i2;
            float f7 = f4 / i2;
            float f8 = f5 / i2;
            float f9 = f6 / i2;
            if (this.wc) {
                if (this.wb) {
                    if (d2 <= 10.0d) {
                        return;
                    }
                    this.wb = false;
                } else if (d2 < 10.0d) {
                    this.wb = true;
                    interfaceC0056a = this.vT;
                    if (interfaceC0056a == null) {
                        return;
                    }
                    interfaceC0056a.b(f7, f8, f9, (float) this.wa);
                    this.wa = 0.0d;
                }
            } else if (this.wb) {
                if (d2 <= 5.0d) {
                    return;
                }
                this.wb = false;
            } else if (d2 < 5.0d) {
                this.wb = true;
                interfaceC0056a = this.vT;
                if (interfaceC0056a == null) {
                    return;
                }
                interfaceC0056a.b(f7, f8, f9, (float) this.wa);
                this.wa = 0.0d;
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.vU) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            b(f, f2, f3);
            com.baidu.ar.h.b.aQ("acc  x : " + f + " , y : " + f2 + ", z : " + f3);
        }
    }

    public void start() {
        SensorManager sensorManager;
        SensorManager sensorManager2 = (SensorManager) this.mContext.getSystemService("sensor");
        this.rH = sensorManager2;
        if (sensorManager2 != null) {
            Sensor defaultSensor = sensorManager2.getDefaultSensor(10);
            this.vS = defaultSensor;
            if (defaultSensor == null) {
                this.vS = this.rH.getDefaultSensor(1);
                this.wc = true;
            }
        }
        Sensor sensor = this.vS;
        if (sensor == null || (sensorManager = this.rH) == null) {
            return;
        }
        sensorManager.registerListener(this, sensor, 1);
    }

    public void stop() {
        InterfaceC0056a interfaceC0056a = this.vT;
        if (interfaceC0056a != null) {
            interfaceC0056a.destroy();
            this.vT = null;
        }
        SensorManager sensorManager = this.rH;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.rH = null;
        }
        this.wc = false;
    }
}
