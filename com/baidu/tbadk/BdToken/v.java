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
public class v implements SensorEventListener {
    private Context context;
    private Vibrator dPV;
    private Sensor dPm;
    private final double eHD = 9.8d;
    private final int eHE = 400;
    private final int eHF = 255;
    private final int eHG = 1;
    private final int eHH = 2000;
    private a eHI;
    private SoundPool eHJ;
    private int eHK;
    private int eHL;
    private long eHM;
    private boolean isOpen;
    private MediaPlayer mMediaPlayer;
    private SensorManager mSensorManager;

    /* loaded from: classes.dex */
    public interface a {
        void bmb();
    }

    public v(@NonNull Context context, @Nullable a aVar) {
        if (context != null) {
            this.context = context;
            this.eHI = aVar;
            this.mSensorManager = (SensorManager) context.getSystemService("sensor");
            if (this.mSensorManager != null) {
                this.dPm = this.mSensorManager.getDefaultSensor(1);
            }
            this.dPV = (Vibrator) context.getSystemService("vibrator");
            this.eHJ = new SoundPool(1, 3, 0);
            if (this.eHJ != null) {
                this.eHK = this.eHJ.load(context, R.raw.shake_tone, 1);
            }
        }
    }

    public void open() {
        if (this.dPm != null) {
            this.mSensorManager.registerListener(this, this.dPm, 2);
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
        if (sensorEvent.sensor.getType() == 1 && w(sensorEvent.values) && this.eHI != null) {
            this.eHI.bmb();
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
            if (sqrt >= 2.5d && blZ()) {
                return true;
            }
        } else if (sqrt >= 4.2d && blZ()) {
            return true;
        }
        return false;
    }

    private boolean blZ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.eHM > 2000) {
            this.eHM = currentTimeMillis;
            return true;
        }
        return false;
    }

    public boolean bma() {
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
        if (this.dPV == null || !this.dPV.hasVibrator() || i <= 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.dPV.vibrate(VibrationEffect.createOneShot(400L, 255));
        } else {
            this.dPV.vibrate(400L);
        }
        return true;
    }

    public void Af(String str) {
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

    public void jb(boolean z) {
        if (z || this.eHL == 0) {
            if (this.eHJ != null) {
                this.eHJ.play(this.eHK, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        } else if (this.eHJ != null) {
            this.eHJ.play(this.eHL, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }
}
