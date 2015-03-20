package com.baidu.location;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes.dex */
public class am implements a0, n {
    private static final float h4 = 0.8f;
    public static final float h5 = 4.0f;
    public static final float hO = 0.01f;
    private static final int hX = 6;
    private static final int hZ = 20;
    private float[] h0;
    private volatile int h1;
    private int h2;
    private double[] h3;
    private int h6;
    private SensorManager h7;
    private boolean h8;
    private int hJ;
    private int hK;
    private int hL;
    private final long hM;
    private float[] hN;
    private int hP;
    private double hQ;
    private double[] hR;
    public SensorEventListener hS;
    private int hT;
    private long hU;
    Timer hV;
    private int hW;
    private Sensor hY;

    public am(Context context) {
        this(context, 0);
    }

    private am(Context context, int i) {
        this.hM = 30L;
        this.h1 = 0;
        this.hL = 1;
        this.hN = new float[3];
        this.h0 = new float[]{0.0f, 0.0f, 0.0f};
        this.h2 = 31;
        this.h3 = new double[this.h2];
        this.h6 = 0;
        this.hR = new double[6];
        this.hT = 0;
        this.hU = 0L;
        this.hP = 0;
        this.hS = new SensorEventListener() { // from class: com.baidu.location.am.1
            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i2) {
            }

            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                switch (sensorEvent.sensor.getType()) {
                    case 1:
                        float[] fArr = (float[]) sensorEvent.values.clone();
                        am.this.h0 = (float[]) fArr.clone();
                        float[] m175if = am.this.m175if(fArr[0], fArr[1], fArr[2]);
                        if (am.m168do(am.this) >= 20) {
                            double d = (m175if[2] * m175if[2]) + (m175if[0] * m175if[0]) + (m175if[1] * m175if[1]);
                            if (am.this.h1 == 0) {
                                if (d > 4.0d) {
                                    am.this.h1 = 1;
                                    return;
                                }
                                return;
                            } else if (d < 0.009999999776482582d) {
                                am.this.h1 = 0;
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hQ = 1.6d;
        this.hK = 440;
        try {
            this.h7 = (SensorManager) context.getSystemService("sensor");
            this.hW = i;
            this.hY = this.h7.getDefaultSensor(1);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bV() {
        float[] fArr;
        if (this.hJ < 20) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        System.arraycopy(this.h0, 0, new float[3], 0, 3);
        double sqrt = Math.sqrt((fArr[2] * fArr[2]) + (fArr[0] * fArr[0]) + (fArr[1] * fArr[1]));
        this.h3[this.h6] = sqrt;
        m169do(sqrt);
        this.h6++;
        if (this.h6 == this.h2) {
            this.h6 = 0;
            double m171if = m171if(this.h3);
            if (this.h1 != 0 || m171if >= 0.3d) {
                m167char(1);
                this.h1 = 1;
            } else {
                m167char(0);
                this.h1 = 0;
            }
        }
        if (currentTimeMillis - this.hU <= this.hK || !m174if(this.hQ)) {
            return;
        }
        this.hP++;
        this.hU = currentTimeMillis;
    }

    /* renamed from: char  reason: not valid java name */
    private synchronized void m167char(int i) {
        this.hL |= i;
    }

    /* renamed from: do  reason: not valid java name */
    static /* synthetic */ int m168do(am amVar) {
        int i = amVar.hJ + 1;
        amVar.hJ = i;
        return i;
    }

    /* renamed from: do  reason: not valid java name */
    private void m169do(double d) {
        this.hR[this.hT % 6] = d;
        this.hT++;
        this.hT %= 6;
    }

    /* renamed from: if  reason: not valid java name */
    private double m171if(double[] dArr) {
        double d = 0.0d;
        int length = dArr.length;
        double d2 = 0.0d;
        for (double d3 : dArr) {
            d2 += d3;
        }
        double d4 = d2 / length;
        for (int i = 0; i < length; i++) {
            d += (dArr[i] - d4) * (dArr[i] - d4);
        }
        return d / (length - 1);
    }

    /* renamed from: if  reason: not valid java name */
    private boolean m174if(double d) {
        for (int i = 1; i <= 5; i++) {
            if (this.hR[((((this.hT - 1) - i) + 6) + 6) % 6] - this.hR[((this.hT - 1) + 6) % 6] > d) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public float[] m175if(float f, float f2, float f3) {
        this.hN[0] = (this.hN[0] * h4) + (0.19999999f * f);
        this.hN[1] = (this.hN[1] * h4) + (0.19999999f * f2);
        this.hN[2] = (this.hN[2] * h4) + (0.19999999f * f3);
        return new float[]{f - this.hN[0], f2 - this.hN[1], f3 - this.hN[2]};
    }

    public synchronized int bS() {
        return this.hJ < 20 ? -1 : this.hP;
    }

    public synchronized void bT() {
        this.hL = 0;
    }

    public synchronized int bU() {
        return this.hJ < 20 ? 1 : this.hL;
    }

    public void bW() {
        if (this.h8 || this.hY == null) {
            return;
        }
        try {
            this.h7.registerListener(this.hS, this.hY, this.hW);
        } catch (Exception e) {
        }
        this.hV = new Timer("UpdateData", false);
        this.hV.schedule(new TimerTask() { // from class: com.baidu.location.am.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                am.this.bV();
            }
        }, 500L, 30L);
        this.h8 = true;
    }

    public void bX() {
        if (this.h8) {
            try {
                this.h7.unregisterListener(this.hS);
            } catch (Exception e) {
            }
            this.hV.cancel();
            this.hV.purge();
            this.hV = null;
            this.h8 = false;
        }
    }
}
