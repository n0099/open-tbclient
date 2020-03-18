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
    private SensorManager aBy;
    private Sensor bWD;
    private final double cJg = 9.8d;
    private final int cJh = 400;
    private final int cJi = 255;
    private final int cJj = 1;
    private final int cJk = 2000;
    private a cJl;
    private int cJm;
    private int cJn;
    private long cJo;
    private Context context;
    private boolean isOpen;
    private MediaPlayer mMediaPlayer;
    private SoundPool mSoundPool;
    private Vibrator mVibrator;

    /* loaded from: classes.dex */
    public interface a {
        void ayn();
    }

    public t(@NonNull Context context, @Nullable a aVar) {
        if (context != null) {
            this.context = context;
            this.cJl = aVar;
            this.aBy = (SensorManager) context.getSystemService("sensor");
            if (this.aBy != null) {
                this.bWD = this.aBy.getDefaultSensor(1);
            }
            this.mVibrator = (Vibrator) context.getSystemService("vibrator");
            this.mSoundPool = new SoundPool(1, 3, 0);
            if (this.mSoundPool != null) {
                this.cJm = this.mSoundPool.load(context, R.raw.shake_tone, 1);
            }
        }
    }

    public void open() {
        if (this.bWD != null) {
            this.aBy.registerListener(this, this.bWD, 2);
            this.isOpen = true;
        }
    }

    public void close() {
        if (this.aBy != null) {
            this.aBy.unregisterListener(this);
            this.isOpen = false;
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && j(sensorEvent.values) && this.cJl != null) {
            this.cJl.ayn();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    private boolean j(float[] fArr) {
        float abs = Math.abs(fArr[0]);
        float abs2 = Math.abs(fArr[1]);
        float abs3 = Math.abs(fArr[2]);
        double sqrt = Math.sqrt(Math.pow(abs2 / 9.8d, 2.0d) + Math.pow(abs / 9.8d, 2.0d) + Math.pow(abs3 / 9.8d, 2.0d));
        if (Build.VERSION.SDK_INT <= 23) {
            if (sqrt >= 2.5d && ayl()) {
                return true;
            }
        } else if (sqrt >= 4.2d && ayl()) {
            return true;
        }
        return false;
    }

    private boolean ayl() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.cJo > 2000) {
            this.cJo = currentTimeMillis;
            return true;
        }
        return false;
    }

    public boolean aym() {
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
        if (this.mVibrator == null || !this.mVibrator.hasVibrator() || i <= 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.mVibrator.vibrate(VibrationEffect.createOneShot(400L, 255));
        } else {
            this.mVibrator.vibrate(400L);
        }
        return true;
    }

    public void rC(String str) {
        if (this.mMediaPlayer == null) {
            this.mMediaPlayer = new MediaPlayer();
        }
        try {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setLooping(false);
            this.mMediaPlayer.setDataSource(str);
            this.mMediaPlayer.prepareAsync();
            this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tbadk.BdToken.t.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    t.this.mMediaPlayer.start();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fm(boolean z) {
        if (z || this.cJn == 0) {
            if (this.mSoundPool != null) {
                this.mSoundPool.play(this.cJm, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        } else if (this.mSoundPool != null) {
            this.mSoundPool.play(this.cJn, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }
}
