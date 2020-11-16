package com.baidu.ar.f;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.LinkedList;
/* loaded from: classes12.dex */
public class a implements SensorEventListener {
    private Context mContext;
    private SensorManager rq;
    private Sensor ve;
    private InterfaceC0083a vf;
    private boolean vg = true;
    private LinkedList<Double> vh = new LinkedList<>();

    /* renamed from: vi  reason: collision with root package name */
    private LinkedList<Float> f1194vi = new LinkedList<>();
    private LinkedList<Float> vj = new LinkedList<>();
    private LinkedList<Float> vk = new LinkedList<>();
    private int vl = 10;
    private double vm = 0.0d;
    private boolean vn = true;
    private boolean vo = false;

    /* renamed from: com.baidu.ar.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC0083a {
        void b(float f, float f2, float f3, float f4);

        void destroy();
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void U(boolean z) {
        this.vg = z;
    }

    public void a(InterfaceC0083a interfaceC0083a) {
        this.vf = interfaceC0083a;
    }

    public void a(LinkedList linkedList, double d) {
        if (linkedList.size() >= this.vl) {
            linkedList.poll();
        }
        linkedList.offer(Double.valueOf(d));
    }

    public void a(LinkedList linkedList, float f) {
        if (linkedList.size() >= this.vl) {
            linkedList.poll();
        }
        linkedList.offer(Float.valueOf(f));
    }

    public void b(float f, float f2, float f3) {
        double sqrt = Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
        if (sqrt > this.vm) {
            this.vm = sqrt;
        }
        com.baidu.ar.g.b.aN("max acc is : " + this.vm);
        a(this.vh, sqrt);
        a((LinkedList) this.f1194vi, Math.abs(f));
        a((LinkedList) this.vj, Math.abs(f2));
        a((LinkedList) this.vk, Math.abs(f3));
        if (this.vh.size() == this.vl) {
            int i = 0;
            double d = 0.0d;
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = 0.0f;
            while (true) {
                int i2 = i;
                if (i2 >= this.vh.size()) {
                    break;
                }
                d += this.vh.get(i2).doubleValue();
                f4 += this.f1194vi.get(i2).floatValue();
                f5 += this.vj.get(i2).floatValue();
                f6 += this.vk.get(i2).floatValue();
                i = i2 + 1;
            }
            double d2 = d / this.vl;
            float f7 = f4 / this.vl;
            float f8 = f5 / this.vl;
            float f9 = f6 / this.vl;
            if (this.vo) {
                if (this.vn) {
                    if (d2 > 10.0d) {
                        this.vn = false;
                    }
                } else if (d2 < 10.0d) {
                    this.vn = true;
                    if (this.vf != null) {
                        this.vf.b(f7, f8, f9, (float) this.vm);
                        this.vm = 0.0d;
                    }
                }
            } else if (this.vn) {
                if (d2 > 5.0d) {
                    this.vn = false;
                }
            } else if (d2 < 5.0d) {
                this.vn = true;
                if (this.vf != null) {
                    this.vf.b(f7, f8, f9, (float) this.vm);
                    this.vm = 0.0d;
                }
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.vg) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            b(f, f2, f3);
            com.baidu.ar.g.b.aN("acc  x : " + f + " , y : " + f2 + ", z : " + f3);
        }
    }

    public void start() {
        this.rq = (SensorManager) this.mContext.getSystemService("sensor");
        if (this.rq != null) {
            this.ve = this.rq.getDefaultSensor(10);
            if (this.ve == null) {
                this.ve = this.rq.getDefaultSensor(1);
                this.vo = true;
            }
        }
        if (this.ve == null || this.rq == null) {
            return;
        }
        this.rq.registerListener(this, this.ve, 1);
    }

    public void stop() {
        if (this.vf != null) {
            this.vf.destroy();
            this.vf = null;
        }
        if (this.rq != null) {
            this.rq.unregisterListener(this);
            this.rq = null;
        }
        this.vo = false;
    }
}
