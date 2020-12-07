package com.baidu.ar.f;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.LinkedList;
/* loaded from: classes10.dex */
public class a implements SensorEventListener {
    private Context mContext;
    private SensorManager rH;
    private Sensor vS;
    private InterfaceC0085a vT;
    private boolean vU = true;
    private LinkedList<Double> vV = new LinkedList<>();
    private LinkedList<Float> vW = new LinkedList<>();
    private LinkedList<Float> vX = new LinkedList<>();
    private LinkedList<Float> vY = new LinkedList<>();
    private int vZ = 10;
    private double wa = 0.0d;
    private boolean wb = true;
    private boolean wc = false;

    /* renamed from: com.baidu.ar.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0085a {
        void b(float f, float f2, float f3, float f4);

        void destroy();
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void S(boolean z) {
        this.vU = z;
    }

    public void a(InterfaceC0085a interfaceC0085a) {
        this.vT = interfaceC0085a;
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
            int i = 0;
            double d = 0.0d;
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = 0.0f;
            while (true) {
                int i2 = i;
                if (i2 >= this.vV.size()) {
                    break;
                }
                d += this.vV.get(i2).doubleValue();
                f4 += this.vW.get(i2).floatValue();
                f5 += this.vX.get(i2).floatValue();
                f6 += this.vY.get(i2).floatValue();
                i = i2 + 1;
            }
            double d2 = d / this.vZ;
            float f7 = f4 / this.vZ;
            float f8 = f5 / this.vZ;
            float f9 = f6 / this.vZ;
            if (this.wc) {
                if (this.wb) {
                    if (d2 > 10.0d) {
                        this.wb = false;
                    }
                } else if (d2 < 10.0d) {
                    this.wb = true;
                    if (this.vT != null) {
                        this.vT.b(f7, f8, f9, (float) this.wa);
                        this.wa = 0.0d;
                    }
                }
            } else if (this.wb) {
                if (d2 > 5.0d) {
                    this.wb = false;
                }
            } else if (d2 < 5.0d) {
                this.wb = true;
                if (this.vT != null) {
                    this.vT.b(f7, f8, f9, (float) this.wa);
                    this.wa = 0.0d;
                }
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.vU) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            b(f, f2, f3);
            com.baidu.ar.h.b.aQ("acc  x : " + f + " , y : " + f2 + ", z : " + f3);
        }
    }

    public void start() {
        this.rH = (SensorManager) this.mContext.getSystemService("sensor");
        if (this.rH != null) {
            this.vS = this.rH.getDefaultSensor(10);
            if (this.vS == null) {
                this.vS = this.rH.getDefaultSensor(1);
                this.wc = true;
            }
        }
        if (this.vS == null || this.rH == null) {
            return;
        }
        this.rH.registerListener(this, this.vS, 1);
    }

    public void stop() {
        if (this.vT != null) {
            this.vT.destroy();
            this.vT = null;
        }
        if (this.rH != null) {
            this.rH.unregisterListener(this);
            this.rH = null;
        }
        this.wc = false;
    }
}
