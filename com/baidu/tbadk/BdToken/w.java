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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class w implements SensorEventListener {
    private Context context;
    private Vibrator dOO;
    private Sensor dOf;
    private final double eGA = 9.8d;
    private final int eGB = 400;
    private final int eGC = 255;
    private final int eGD = 1;
    private final int eGE = 2000;
    private a eGF;
    private SoundPool eGG;
    private int eGH;
    private int eGI;
    private long eGJ;
    private boolean isOpen;
    private MediaPlayer mMediaPlayer;
    private SensorManager mSensorManager;

    /* loaded from: classes.dex */
    public interface a {
        void biw();
    }

    public w(@NonNull Context context, @Nullable a aVar) {
        if (context != null) {
            this.context = context;
            this.eGF = aVar;
            this.mSensorManager = (SensorManager) context.getSystemService("sensor");
            if (this.mSensorManager != null) {
                this.dOf = this.mSensorManager.getDefaultSensor(1);
            }
            this.dOO = (Vibrator) context.getSystemService("vibrator");
            this.eGG = new SoundPool(1, 3, 0);
            if (this.eGG != null) {
                this.eGH = this.eGG.load(context, R.raw.shake_tone, 1);
            }
        }
    }

    public void open() {
        if (this.dOf != null) {
            this.mSensorManager.registerListener(this, this.dOf, 2);
            this.isOpen = true;
        }
    }

    public void close() {
        if (this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this);
            this.isOpen = false;
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && w(sensorEvent.values) && this.eGF != null) {
            this.eGF.biw();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    private boolean w(float[] fArr) {
        float abs = Math.abs(fArr[0]);
        float abs2 = Math.abs(fArr[1]);
        float abs3 = Math.abs(fArr[2]);
        double sqrt = Math.sqrt(Math.pow(abs2 / 9.8d, 2.0d) + Math.pow(abs / 9.8d, 2.0d) + Math.pow(abs3 / 9.8d, 2.0d));
        if (Build.VERSION.SDK_INT <= 23) {
            if (sqrt >= 2.5d && biu()) {
                return true;
            }
        } else if (sqrt >= 4.2d && biu()) {
            return true;
        }
        return false;
    }

    private boolean biu() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.eGJ > 2000) {
            this.eGJ = currentTimeMillis;
            return true;
        }
        return false;
    }

    public boolean biv() {
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
        if (this.dOO == null || !this.dOO.hasVibrator() || i <= 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.dOO.vibrate(VibrationEffect.createOneShot(400L, 255));
        } else {
            this.dOO.vibrate(400L);
        }
        return true;
    }

    public void zt(String str) {
        if (this.mMediaPlayer == null) {
            this.mMediaPlayer = new MediaPlayer();
        }
        try {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setLooping(false);
            this.mMediaPlayer.setDataSource(str);
            this.mMediaPlayer.prepareAsync();
            this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tbadk.BdToken.w.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    w.this.mMediaPlayer.start();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void iZ(boolean z) {
        if (z || this.eGI == 0) {
            if (this.eGG != null) {
                this.eGG.play(this.eGH, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        } else if (this.eGG != null) {
            this.eGG.play(this.eGI, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }
}
