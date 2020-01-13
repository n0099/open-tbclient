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
    private SensorManager awS;
    private Sensor bSm;
    private final double cEP = 9.8d;
    private final int cEQ = 400;
    private final int cER = 255;
    private final int cES = 1;
    private final int cET = 2000;
    private a cEU;
    private int cEV;
    private int cEW;
    private long cEX;
    private Context context;
    private boolean isOpen;
    private MediaPlayer mMediaPlayer;
    private SoundPool mSoundPool;
    private Vibrator mVibrator;

    /* loaded from: classes.dex */
    public interface a {
        void avV();
    }

    public t(@NonNull Context context, @Nullable a aVar) {
        if (context != null) {
            this.context = context;
            this.cEU = aVar;
            this.awS = (SensorManager) context.getSystemService("sensor");
            if (this.awS != null) {
                this.bSm = this.awS.getDefaultSensor(1);
            }
            this.mVibrator = (Vibrator) context.getSystemService("vibrator");
            this.mSoundPool = new SoundPool(1, 3, 0);
            if (this.mSoundPool != null) {
                this.cEV = this.mSoundPool.load(context, R.raw.shake_tone, 1);
            }
        }
    }

    public void open() {
        if (this.bSm != null) {
            this.awS.registerListener(this, this.bSm, 2);
            this.isOpen = true;
        }
    }

    public void close() {
        if (this.awS != null) {
            this.awS.unregisterListener(this);
            this.isOpen = false;
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && j(sensorEvent.values) && this.cEU != null) {
            this.cEU.avV();
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
            if (sqrt >= 2.5d && avT()) {
                return true;
            }
        } else if (sqrt >= 4.2d && avT()) {
            return true;
        }
        return false;
    }

    private boolean avT() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.cEX > 2000) {
            this.cEX = currentTimeMillis;
            return true;
        }
        return false;
    }

    public boolean avU() {
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

    public void ro(String str) {
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

    public void fe(boolean z) {
        if (z || this.cEW == 0) {
            if (this.mSoundPool != null) {
                this.mSoundPool.play(this.cEV, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        } else if (this.mSoundPool != null) {
            this.mSoundPool.play(this.cEW, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }
}
