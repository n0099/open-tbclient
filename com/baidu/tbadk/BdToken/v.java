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
public class v implements SensorEventListener {
    private SensorManager bhI;
    private Sensor cMl;
    private Context context;
    private final double dBm = 9.8d;
    private final int dBn = 400;
    private final int dBo = 255;
    private final int dBp = 1;
    private final int dBq = 2000;
    private a dBr;
    private int dBs;
    private int dBt;
    private long dBu;
    private boolean isOpen;
    private MediaPlayer mMediaPlayer;
    private SoundPool mSoundPool;
    private Vibrator mVibrator;

    /* loaded from: classes.dex */
    public interface a {
        void aNv();
    }

    public v(@NonNull Context context, @Nullable a aVar) {
        if (context != null) {
            this.context = context;
            this.dBr = aVar;
            this.bhI = (SensorManager) context.getSystemService("sensor");
            if (this.bhI != null) {
                this.cMl = this.bhI.getDefaultSensor(1);
            }
            this.mVibrator = (Vibrator) context.getSystemService("vibrator");
            this.mSoundPool = new SoundPool(1, 3, 0);
            if (this.mSoundPool != null) {
                this.dBs = this.mSoundPool.load(context, R.raw.shake_tone, 1);
            }
        }
    }

    public void open() {
        if (this.cMl != null) {
            this.bhI.registerListener(this, this.cMl, 2);
            this.isOpen = true;
        }
    }

    public void close() {
        if (this.bhI != null) {
            this.bhI.unregisterListener(this);
            this.isOpen = false;
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && y(sensorEvent.values) && this.dBr != null) {
            this.dBr.aNv();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    private boolean y(float[] fArr) {
        float abs = Math.abs(fArr[0]);
        float abs2 = Math.abs(fArr[1]);
        float abs3 = Math.abs(fArr[2]);
        double sqrt = Math.sqrt(Math.pow(abs2 / 9.8d, 2.0d) + Math.pow(abs / 9.8d, 2.0d) + Math.pow(abs3 / 9.8d, 2.0d));
        if (Build.VERSION.SDK_INT <= 23) {
            if (sqrt >= 2.5d && aNt()) {
                return true;
            }
        } else if (sqrt >= 4.2d && aNt()) {
            return true;
        }
        return false;
    }

    private boolean aNt() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dBu > 2000) {
            this.dBu = currentTimeMillis;
            return true;
        }
        return false;
    }

    public boolean aNu() {
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

    public void uG(String str) {
        if (this.mMediaPlayer == null) {
            this.mMediaPlayer = new MediaPlayer();
        }
        try {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setLooping(false);
            this.mMediaPlayer.setDataSource(str);
            this.mMediaPlayer.prepareAsync();
            this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tbadk.BdToken.v.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    v.this.mMediaPlayer.start();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gI(boolean z) {
        if (z || this.dBt == 0) {
            if (this.mSoundPool != null) {
                this.mSoundPool.play(this.dBs, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        } else if (this.mSoundPool != null) {
            this.mSoundPool.play(this.dBt, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }
}
