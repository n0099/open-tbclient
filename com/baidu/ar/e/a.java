package com.baidu.ar.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class a implements SensorEventListener {
    private Context mContext;
    private SensorManager qm;
    private Sensor ua;
    private InterfaceC0079a ub;
    private boolean uc = true;
    private LinkedList<Double> ud = new LinkedList<>();
    private LinkedList<Float> ue = new LinkedList<>();
    private LinkedList<Float> uf = new LinkedList<>();
    private LinkedList<Float> ug = new LinkedList<>();
    private int uh = 10;
    private double ui = 0.0d;
    private boolean uj = true;
    private boolean uk = false;

    /* renamed from: com.baidu.ar.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0079a {
        void b(float f, float f2, float f3, float f4);

        void destroy();
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void T(boolean z) {
        this.uc = z;
    }

    public void a(InterfaceC0079a interfaceC0079a) {
        this.ub = interfaceC0079a;
    }

    public void a(LinkedList linkedList, double d) {
        if (linkedList.size() >= this.uh) {
            linkedList.poll();
        }
        linkedList.offer(Double.valueOf(d));
    }

    public void a(LinkedList linkedList, float f) {
        if (linkedList.size() >= this.uh) {
            linkedList.poll();
        }
        linkedList.offer(Float.valueOf(f));
    }

    public void b(float f, float f2, float f3) {
        double sqrt = Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
        if (sqrt > this.ui) {
            this.ui = sqrt;
        }
        com.baidu.ar.f.b.aI("max acc is : " + this.ui);
        a(this.ud, sqrt);
        a((LinkedList) this.ue, Math.abs(f));
        a((LinkedList) this.uf, Math.abs(f2));
        a((LinkedList) this.ug, Math.abs(f3));
        if (this.ud.size() == this.uh) {
            int i = 0;
            double d = 0.0d;
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = 0.0f;
            while (true) {
                int i2 = i;
                if (i2 >= this.ud.size()) {
                    break;
                }
                d += this.ud.get(i2).doubleValue();
                f4 += this.ue.get(i2).floatValue();
                f5 += this.uf.get(i2).floatValue();
                f6 += this.ug.get(i2).floatValue();
                i = i2 + 1;
            }
            double d2 = d / this.uh;
            float f7 = f4 / this.uh;
            float f8 = f5 / this.uh;
            float f9 = f6 / this.uh;
            if (this.uk) {
                if (this.uj) {
                    if (d2 > 10.0d) {
                        this.uj = false;
                    }
                } else if (d2 < 10.0d) {
                    this.uj = true;
                    if (this.ub != null) {
                        this.ub.b(f7, f8, f9, (float) this.ui);
                        this.ui = 0.0d;
                    }
                }
            } else if (this.uj) {
                if (d2 > 5.0d) {
                    this.uj = false;
                }
            } else if (d2 < 5.0d) {
                this.uj = true;
                if (this.ub != null) {
                    this.ub.b(f7, f8, f9, (float) this.ui);
                    this.ui = 0.0d;
                }
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.uc) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            b(f, f2, f3);
            com.baidu.ar.f.b.aI("acc  x : " + f + " , y : " + f2 + ", z : " + f3);
        }
    }

    public void start() {
        this.qm = (SensorManager) this.mContext.getSystemService("sensor");
        if (this.qm != null) {
            this.ua = this.qm.getDefaultSensor(10);
            if (this.ua == null) {
                this.ua = this.qm.getDefaultSensor(1);
                this.uk = true;
            }
        }
        if (this.ua == null || this.qm == null) {
            return;
        }
        this.qm.registerListener(this, this.ua, 1);
    }

    public void stop() {
        if (this.ub != null) {
            this.ub.destroy();
            this.ub = null;
        }
        if (this.qm != null) {
            this.qm.unregisterListener(this);
            this.qm = null;
        }
        this.uk = false;
    }
}
