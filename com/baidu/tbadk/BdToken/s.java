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
public class s implements SensorEventListener {
    private SensorManager aWq;
    private Sensor aWs;
    private Vibrator aXs;
    private final double byT = 9.8d;
    private final int byU = 400;
    private final int byV = 255;
    private final int byW = 1;
    private final int byX = 2000;
    private a byY;
    private SoundPool byZ;
    private int bza;
    private int bzb;
    private long bzc;
    private MediaPlayer bzd;
    private Context context;
    private boolean isOpen;

    /* loaded from: classes.dex */
    public interface a {
        void YT();
    }

    public s(@NonNull Context context, @Nullable a aVar) {
        if (context != null) {
            this.context = context;
            this.byY = aVar;
            this.aWq = (SensorManager) context.getSystemService("sensor");
            if (this.aWq != null) {
                this.aWs = this.aWq.getDefaultSensor(1);
            }
            this.aXs = (Vibrator) context.getSystemService("vibrator");
            this.byZ = new SoundPool(1, 3, 0);
            if (this.byZ != null) {
                this.bza = this.byZ.load(context, R.raw.shake_tone, 1);
            }
        }
    }

    public void open() {
        if (this.aWs != null) {
            this.aWq.registerListener(this, this.aWs, 2);
            this.isOpen = true;
        }
    }

    public void close() {
        if (this.aWq != null) {
            this.aWq.unregisterListener(this);
            this.isOpen = false;
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && i(sensorEvent.values) && this.byY != null) {
            this.byY.YT();
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
            if (sqrt >= 2.5d && YR()) {
                return true;
            }
        } else if (sqrt >= 4.2d && YR()) {
            return true;
        }
        return false;
    }

    private boolean YR() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bzc > 2000) {
            this.bzc = currentTimeMillis;
            return true;
        }
        return false;
    }

    public boolean YS() {
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
        if (this.aXs == null || !this.aXs.hasVibrator() || i <= 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.aXs.vibrate(VibrationEffect.createOneShot(400L, 255));
        } else {
            this.aXs.vibrate(400L);
        }
        return true;
    }

    public void lk(String str) {
        if (this.bzd == null) {
            this.bzd = new MediaPlayer();
        }
        try {
            this.bzd.reset();
            this.bzd.setLooping(false);
            this.bzd.setDataSource(str);
            this.bzd.prepareAsync();
            this.bzd.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tbadk.BdToken.s.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    s.this.bzd.start();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dr(boolean z) {
        if (z || this.bzb == 0) {
            if (this.byZ != null) {
                this.byZ.play(this.bza, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        } else if (this.byZ != null) {
            this.byZ.play(this.bzb, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }
}
