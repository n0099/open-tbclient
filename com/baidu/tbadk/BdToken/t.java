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
    private Sensor aXA;
    private SensorManager aXy;
    private Vibrator aYA;
    private final double bAo = 9.8d;
    private final int bAp = 400;
    private final int bAq = 255;
    private final int bAr = 1;
    private final int bAs = 2000;
    private a bAt;
    private SoundPool bAu;
    private int bAv;
    private int bAw;
    private long bAx;
    private MediaPlayer bAy;
    private Context context;
    private boolean isOpen;

    /* loaded from: classes.dex */
    public interface a {
        void ZW();
    }

    public t(@NonNull Context context, @Nullable a aVar) {
        if (context != null) {
            this.context = context;
            this.bAt = aVar;
            this.aXy = (SensorManager) context.getSystemService("sensor");
            if (this.aXy != null) {
                this.aXA = this.aXy.getDefaultSensor(1);
            }
            this.aYA = (Vibrator) context.getSystemService("vibrator");
            this.bAu = new SoundPool(1, 3, 0);
            if (this.bAu != null) {
                this.bAv = this.bAu.load(context, R.raw.shake_tone, 1);
            }
        }
    }

    public void ZT() {
        if (this.aXA != null) {
            this.aXy.registerListener(this, this.aXA, 2);
            this.isOpen = true;
        }
    }

    public void close() {
        if (this.aXy != null) {
            this.aXy.unregisterListener(this);
            this.isOpen = false;
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && i(sensorEvent.values) && this.bAt != null) {
            this.bAt.ZW();
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
            if (sqrt >= 2.5d && ZU()) {
                return true;
            }
        } else if (sqrt >= 4.2d && ZU()) {
            return true;
        }
        return false;
    }

    private boolean ZU() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bAx > 2000) {
            this.bAx = currentTimeMillis;
            return true;
        }
        return false;
    }

    public boolean ZV() {
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
        if (this.aYA == null || !this.aYA.hasVibrator() || i <= 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.aYA.vibrate(VibrationEffect.createOneShot(400L, 255));
        } else {
            this.aYA.vibrate(400L);
        }
        return true;
    }

    public void lu(String str) {
        if (this.bAy == null) {
            this.bAy = new MediaPlayer();
        }
        try {
            this.bAy.reset();
            this.bAy.setLooping(false);
            this.bAy.setDataSource(str);
            this.bAy.prepareAsync();
            this.bAy.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tbadk.BdToken.t.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    t.this.bAy.start();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dw(boolean z) {
        if (z || this.bAw == 0) {
            if (this.bAu != null) {
                this.bAu.play(this.bAv, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        } else if (this.bAu != null) {
            this.bAu.play(this.bAw, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }
}
