package com.baidu.tbadk.BdToken;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class t implements SensorEventListener {
    private SensorManager aoB;
    private final double bSU = 9.8d;
    private final int bSV = 400;
    private final int bSW = 255;
    private final int bSX = 1;
    private final int bSY = 2000;
    private a bSZ;
    private SoundPool bTa;
    private int bTb;
    private int bTc;
    private long bTd;
    private MediaPlayer bTe;
    private Sensor bqD;
    private Vibrator brC;
    private Context context;
    private boolean isOpen;

    /* loaded from: classes.dex */
    public interface a {
        void aeL();
    }

    public t(@NonNull Context context, @Nullable a aVar) {
        if (context != null) {
            this.context = context;
            this.bSZ = aVar;
            this.aoB = (SensorManager) context.getSystemService("sensor");
            if (this.aoB != null) {
                this.bqD = this.aoB.getDefaultSensor(1);
            }
            this.brC = (Vibrator) context.getSystemService("vibrator");
            this.bTa = new SoundPool(1, 3, 0);
            if (this.bTa != null) {
                this.bTb = this.bTa.load(context, R.raw.shake_tone, 1);
            }
        }
    }

    public void open() {
        if (this.bqD != null) {
            this.aoB.registerListener(this, this.bqD, 2);
            this.isOpen = true;
        }
    }

    public void close() {
        if (this.aoB != null) {
            this.aoB.unregisterListener(this);
            this.isOpen = false;
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && i(sensorEvent.values) && this.bSZ != null) {
            this.bSZ.aeL();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    private boolean i(float[] fArr) {
        float abs = Math.abs(fArr[0]);
        float abs2 = Math.abs(fArr[1]);
        float abs3 = Math.abs(fArr[2]);
        double sqrt = Math.sqrt(Math.pow(abs2 / 9.8d, 2.0d) + Math.pow(abs / 9.8d, 2.0d) + Math.pow(abs3 / 9.8d, 2.0d));
        if (Build.VERSION.SDK_INT <= 23) {
            if (sqrt >= 2.5d && aeJ()) {
                return true;
            }
        } else if (sqrt >= 4.2d && aeJ()) {
            return true;
        }
        return false;
    }

    private boolean aeJ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bTd > 2000) {
            this.bTd = currentTimeMillis;
            return true;
        }
        return false;
    }

    public boolean aeK() {
        int i;
        if (this.context == null) {
            return false;
        }
        AudioManager audioManager = (AudioManager) this.context.getSystemService("audio");
        if (audioManager == null) {
            i = -1;
        } else {
            i = audioManager.getRingerMode();
        }
        if (this.brC == null || !this.brC.hasVibrator() || i <= 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.brC.vibrate(VibrationEffect.createOneShot(400L, 255));
        } else {
            this.brC.vibrate(400L);
        }
        return true;
    }

    public void lX(String str) {
        if (this.bTe == null) {
            this.bTe = new MediaPlayer();
        }
        try {
            this.bTe.reset();
            this.bTe.setLooping(false);
            this.bTe.setDataSource(str);
            this.bTe.prepareAsync();
            this.bTe.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tbadk.BdToken.t.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    t.this.bTe.start();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dN(boolean z) {
        if (z || this.bTc == 0) {
            if (this.bTa != null) {
                this.bTa.play(this.bTb, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        } else if (this.bTa != null) {
            this.bTa.play(this.bTc, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }
}
