package com.baidu.ar.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.LinkedList;
/* loaded from: classes11.dex */
public class a implements SensorEventListener {
    private Context mContext;
    private SensorManager qL;
    private Sensor uA;
    private InterfaceC0083a uB;
    private boolean uC = true;
    private LinkedList<Double> uD = new LinkedList<>();
    private LinkedList<Float> uE = new LinkedList<>();
    private LinkedList<Float> uF = new LinkedList<>();
    private LinkedList<Float> uG = new LinkedList<>();
    private int uH = 10;
    private double uI = 0.0d;
    private boolean uJ = true;
    private boolean uK = false;

    /* renamed from: com.baidu.ar.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0083a {
        void b(float f, float f2, float f3, float f4);

        void destroy();
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void U(boolean z) {
        this.uC = z;
    }

    public void a(InterfaceC0083a interfaceC0083a) {
        this.uB = interfaceC0083a;
    }

    public void a(LinkedList linkedList, double d) {
        if (linkedList.size() >= this.uH) {
            linkedList.poll();
        }
        linkedList.offer(Double.valueOf(d));
    }

    public void a(LinkedList linkedList, float f) {
        if (linkedList.size() >= this.uH) {
            linkedList.poll();
        }
        linkedList.offer(Float.valueOf(f));
    }

    public void b(float f, float f2, float f3) {
        double sqrt = Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
        if (sqrt > this.uI) {
            this.uI = sqrt;
        }
        com.baidu.ar.f.b.aJ("max acc is : " + this.uI);
        a(this.uD, sqrt);
        a((LinkedList) this.uE, Math.abs(f));
        a((LinkedList) this.uF, Math.abs(f2));
        a((LinkedList) this.uG, Math.abs(f3));
        if (this.uD.size() == this.uH) {
            int i = 0;
            double d = 0.0d;
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = 0.0f;
            while (true) {
                int i2 = i;
                if (i2 >= this.uD.size()) {
                    break;
                }
                d += this.uD.get(i2).doubleValue();
                f4 += this.uE.get(i2).floatValue();
                f5 += this.uF.get(i2).floatValue();
                f6 += this.uG.get(i2).floatValue();
                i = i2 + 1;
            }
            double d2 = d / this.uH;
            float f7 = f4 / this.uH;
            float f8 = f5 / this.uH;
            float f9 = f6 / this.uH;
            if (this.uK) {
                if (this.uJ) {
                    if (d2 > 10.0d) {
                        this.uJ = false;
                    }
                } else if (d2 < 10.0d) {
                    this.uJ = true;
                    if (this.uB != null) {
                        this.uB.b(f7, f8, f9, (float) this.uI);
                        this.uI = 0.0d;
                    }
                }
            } else if (this.uJ) {
                if (d2 > 5.0d) {
                    this.uJ = false;
                }
            } else if (d2 < 5.0d) {
                this.uJ = true;
                if (this.uB != null) {
                    this.uB.b(f7, f8, f9, (float) this.uI);
                    this.uI = 0.0d;
                }
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.uC) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            b(f, f2, f3);
            com.baidu.ar.f.b.aJ("acc  x : " + f + " , y : " + f2 + ", z : " + f3);
        }
    }

    public void start() {
        this.qL = (SensorManager) this.mContext.getSystemService("sensor");
        if (this.qL != null) {
            this.uA = this.qL.getDefaultSensor(10);
            if (this.uA == null) {
                this.uA = this.qL.getDefaultSensor(1);
                this.uK = true;
            }
        }
        if (this.uA == null || this.qL == null) {
            return;
        }
        this.qL.registerListener(this, this.uA, 1);
    }

    public void stop() {
        if (this.uB != null) {
            this.uB.destroy();
            this.uB = null;
        }
        if (this.qL != null) {
            this.qL.unregisterListener(this);
            this.qL = null;
        }
        this.uK = false;
    }
}
