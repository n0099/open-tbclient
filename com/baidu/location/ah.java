package com.baidu.location;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements SensorEventListener, a0, n {
    private static float hp;
    private static ah ht;
    private boolean hn;
    float[] ho;
    SensorManager hq;
    float[] hr = new float[9];
    float[] hs;

    ah() {
    }

    public static ah bG() {
        if (ht == null) {
            ht = new ah();
        }
        return ht;
    }

    public float bE() {
        return hp;
    }

    public synchronized void bF() {
        if (this.hq != null) {
            this.hq.unregisterListener(this);
            this.hq = null;
        }
    }

    public synchronized void bH() {
        if (this.hq == null) {
            this.hq = (SensorManager) f.getServiceContext().getSystemService("sensor");
        }
        this.hq.registerListener(this, this.hq.getDefaultSensor(1), 3);
        this.hq.registerListener(this, this.hq.getDefaultSensor(2), 3);
    }

    public boolean bI() {
        return this.hn;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case 1:
                this.ho = sensorEvent.values;
                break;
            case 2:
                this.hs = sensorEvent.values;
                break;
        }
        if (this.ho == null || this.hs == null) {
            return;
        }
        float[] fArr = new float[9];
        if (SensorManager.getRotationMatrix(fArr, null, this.ho, this.hs)) {
            float[] fArr2 = new float[3];
            SensorManager.getOrientation(fArr, fArr2);
            hp = (float) Math.toDegrees(fArr2[0]);
            hp = (float) Math.floor(hp >= 0.0f ? hp : hp + 360.0f);
        }
    }

    /* renamed from: try  reason: not valid java name */
    public void m152try(boolean z) {
        this.hn = z;
    }
}
