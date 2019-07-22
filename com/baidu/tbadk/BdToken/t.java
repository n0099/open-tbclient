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
    private SensorManager aXa;
    private Sensor aXc;
    private Vibrator aYc;
    private MediaPlayer bAa;
    private final double bzQ = 9.8d;
    private final int bzR = 400;
    private final int bzS = 255;
    private final int bzT = 1;
    private final int bzU = 2000;
    private a bzV;
    private SoundPool bzW;
    private int bzX;
    private int bzY;
    private long bzZ;
    private Context context;
    private boolean isOpen;

    /* loaded from: classes.dex */
    public interface a {
        void ZS();
    }

    public t(@NonNull Context context, @Nullable a aVar) {
        if (context != null) {
            this.context = context;
            this.bzV = aVar;
            this.aXa = (SensorManager) context.getSystemService("sensor");
            if (this.aXa != null) {
                this.aXc = this.aXa.getDefaultSensor(1);
            }
            this.aYc = (Vibrator) context.getSystemService("vibrator");
            this.bzW = new SoundPool(1, 3, 0);
            if (this.bzW != null) {
                this.bzX = this.bzW.load(context, R.raw.shake_tone, 1);
            }
        }
    }

    public void ZP() {
        if (this.aXc != null) {
            this.aXa.registerListener(this, this.aXc, 2);
            this.isOpen = true;
        }
    }

    public void close() {
        if (this.aXa != null) {
            this.aXa.unregisterListener(this);
            this.isOpen = false;
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && i(sensorEvent.values) && this.bzV != null) {
            this.bzV.ZS();
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
            if (sqrt >= 2.5d && ZQ()) {
                return true;
            }
        } else if (sqrt >= 4.2d && ZQ()) {
            return true;
        }
        return false;
    }

    private boolean ZQ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bzZ > 2000) {
            this.bzZ = currentTimeMillis;
            return true;
        }
        return false;
    }

    public boolean ZR() {
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
        if (this.aYc == null || !this.aYc.hasVibrator() || i <= 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.aYc.vibrate(VibrationEffect.createOneShot(400L, 255));
        } else {
            this.aYc.vibrate(400L);
        }
        return true;
    }

    public void ls(String str) {
        if (this.bAa == null) {
            this.bAa = new MediaPlayer();
        }
        try {
            this.bAa.reset();
            this.bAa.setLooping(false);
            this.bAa.setDataSource(str);
            this.bAa.prepareAsync();
            this.bAa.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tbadk.BdToken.t.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    t.this.bAa.start();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dw(boolean z) {
        if (z || this.bzY == 0) {
            if (this.bzW != null) {
                this.bzW.play(this.bzX, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        } else if (this.bzW != null) {
            this.bzW.play(this.bzY, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }
}
