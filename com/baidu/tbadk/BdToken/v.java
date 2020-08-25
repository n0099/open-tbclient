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
/* loaded from: classes2.dex */
public class v implements SensorEventListener {
    private SensorManager bnK;
    private Sensor cYI;
    private Context context;
    private final double dQp = 9.8d;
    private final int dQq = 400;
    private final int dQr = 255;
    private final int dQs = 1;
    private final int dQt = 2000;
    private a dQu;
    private int dQv;
    private int dQw;
    private long dQx;
    private boolean isOpen;
    private MediaPlayer mMediaPlayer;
    private SoundPool mSoundPool;
    private Vibrator mVibrator;

    /* loaded from: classes2.dex */
    public interface a {
        void aZz();
    }

    public v(@NonNull Context context, @Nullable a aVar) {
        if (context != null) {
            this.context = context;
            this.dQu = aVar;
            this.bnK = (SensorManager) context.getSystemService("sensor");
            if (this.bnK != null) {
                this.cYI = this.bnK.getDefaultSensor(1);
            }
            this.mVibrator = (Vibrator) context.getSystemService("vibrator");
            this.mSoundPool = new SoundPool(1, 3, 0);
            if (this.mSoundPool != null) {
                this.dQv = this.mSoundPool.load(context, R.raw.shake_tone, 1);
            }
        }
    }

    public void open() {
        if (this.cYI != null) {
            this.bnK.registerListener(this, this.cYI, 2);
            this.isOpen = true;
        }
    }

    public void close() {
        if (this.bnK != null) {
            this.bnK.unregisterListener(this);
            this.isOpen = false;
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && y(sensorEvent.values) && this.dQu != null) {
            this.dQu.aZz();
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
            if (sqrt >= 2.5d && aZx()) {
                return true;
            }
        } else if (sqrt >= 4.2d && aZx()) {
            return true;
        }
        return false;
    }

    private boolean aZx() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dQx > 2000) {
            this.dQx = currentTimeMillis;
            return true;
        }
        return false;
    }

    public boolean aZy() {
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

    public void xU(String str) {
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

    public void hz(boolean z) {
        if (z || this.dQw == 0) {
            if (this.mSoundPool != null) {
                this.mSoundPool.play(this.dQv, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        } else if (this.mSoundPool != null) {
            this.mSoundPool.play(this.dQw, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }
}
