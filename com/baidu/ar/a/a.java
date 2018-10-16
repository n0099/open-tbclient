package com.baidu.ar.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.ar.util.ARLog;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class a implements SensorEventListener {
    private SensorManager a;
    private Sensor b;
    private InterfaceC0035a c;
    private Context d;
    private boolean e = true;
    private LinkedList<Double> f = new LinkedList<>();
    private LinkedList<Float> g = new LinkedList<>();
    private LinkedList<Float> h = new LinkedList<>();
    private LinkedList<Float> i = new LinkedList<>();
    private int j = 10;
    private double k = 0.0d;
    private boolean l = true;
    private boolean m = false;

    /* renamed from: com.baidu.ar.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0035a {
        void a();

        void a(float f, float f2, float f3, float f4);
    }

    public a(Context context) {
        this.d = context;
    }

    public void a() {
        this.a = (SensorManager) this.d.getSystemService("sensor");
        if (this.a != null) {
            this.b = this.a.getDefaultSensor(10);
            if (this.b == null) {
                this.b = this.a.getDefaultSensor(1);
                this.m = true;
            }
        }
        if (this.b != null) {
            this.a.registerListener(this, this.b, 1);
        }
    }

    public void a(float f, float f2, float f3) {
        double sqrt = Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
        if (sqrt > this.k) {
            this.k = sqrt;
        }
        ARLog.d("max acc is : " + this.k);
        a(this.f, sqrt);
        a((LinkedList) this.g, Math.abs(f));
        a((LinkedList) this.h, Math.abs(f2));
        a((LinkedList) this.i, Math.abs(f3));
        if (this.f.size() == this.j) {
            int i = 0;
            double d = 0.0d;
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = 0.0f;
            while (true) {
                int i2 = i;
                if (i2 >= this.f.size()) {
                    break;
                }
                d += this.f.get(i2).doubleValue();
                f4 += this.g.get(i2).floatValue();
                f5 += this.h.get(i2).floatValue();
                f6 += this.i.get(i2).floatValue();
                i = i2 + 1;
            }
            double d2 = d / this.j;
            float f7 = f4 / this.j;
            float f8 = f5 / this.j;
            float f9 = f6 / this.j;
            if (this.m) {
                if (this.l) {
                    if (d2 > 10.0d) {
                        this.l = false;
                    }
                } else if (d2 < 10.0d) {
                    this.l = true;
                    if (this.c != null) {
                        this.c.a(f7, f8, f9, (float) this.k);
                        this.k = 0.0d;
                    }
                }
            } else if (this.l) {
                if (d2 > 5.0d) {
                    this.l = false;
                }
            } else if (d2 < 5.0d) {
                this.l = true;
                if (this.c != null) {
                    this.c.a(f7, f8, f9, (float) this.k);
                    this.k = 0.0d;
                }
            }
        }
    }

    public void a(InterfaceC0035a interfaceC0035a) {
        this.c = interfaceC0035a;
    }

    public void a(LinkedList linkedList, double d) {
        if (linkedList.size() >= this.j) {
            linkedList.poll();
        }
        linkedList.offer(Double.valueOf(d));
    }

    public void a(LinkedList linkedList, float f) {
        if (linkedList.size() >= this.j) {
            linkedList.poll();
        }
        linkedList.offer(Float.valueOf(f));
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void b() {
        if (this.c != null) {
            this.c.a();
            this.c = null;
        }
        if (this.a != null) {
            this.a.unregisterListener(this);
            this.a = null;
        }
        this.m = false;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.e) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            a(f, f2, f3);
            ARLog.d("acc  x : " + f + " , y : " + f2 + ", z : " + f3);
        }
    }
}
