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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tieba.e;
import java.io.IOException;
/* loaded from: classes.dex */
public class n implements SensorEventListener {
    private MediaPlayer Wm;
    private a alC;
    private SoundPool alD;
    private int alE;
    private int alF;
    private long alG;
    private Context context;
    private boolean isOpen;
    private Sensor mAccelerometerSensor;
    private SensorManager mSensorManager;
    private Vibrator mVibrator;
    private final double GRAVITY_ACCELERATION = 9.8d;
    private final int aly = 400;
    private final int alz = 255;
    private final int alA = 1;
    private final int alB = 2000;

    /* loaded from: classes.dex */
    public interface a {
        void vZ();
    }

    public n(@NonNull Context context, @Nullable a aVar) {
        if (context != null) {
            this.context = context;
            this.alC = aVar;
            this.mSensorManager = (SensorManager) context.getSystemService("sensor");
            if (this.mSensorManager != null) {
                this.mAccelerometerSensor = this.mSensorManager.getDefaultSensor(1);
            }
            this.mVibrator = (Vibrator) context.getSystemService("vibrator");
            this.alD = new SoundPool(1, 3, 0);
            if (this.alD != null) {
                this.alE = this.alD.load(context, e.i.shake_tone, 1);
            }
        }
    }

    public void open() {
        if (this.mAccelerometerSensor != null) {
            this.mSensorManager.registerListener(this, this.mAccelerometerSensor, 2);
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
        if (sensorEvent.sensor.getType() == 1 && e(sensorEvent.values) && this.alC != null) {
            this.alC.vZ();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    private boolean e(float[] fArr) {
        float abs = Math.abs(fArr[0]);
        float abs2 = Math.abs(fArr[1]);
        float abs3 = Math.abs(fArr[2]);
        double sqrt = Math.sqrt(Math.pow(abs2 / 9.8d, 2.0d) + Math.pow(abs / 9.8d, 2.0d) + Math.pow(abs3 / 9.8d, 2.0d));
        if (Build.VERSION.SDK_INT <= 23) {
            if (sqrt >= 2.5d && vX()) {
                return true;
            }
        } else if (sqrt >= 4.2d && vX()) {
            return true;
        }
        return false;
    }

    private boolean vX() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.alG > SystemScreenshotManager.DELAY_TIME) {
            this.alG = currentTimeMillis;
            return true;
        }
        return false;
    }

    public boolean vY() {
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

    public void dD(String str) {
        if (this.Wm == null) {
            this.Wm = new MediaPlayer();
        }
        try {
            this.Wm.reset();
            this.Wm.setLooping(false);
            this.Wm.setDataSource(str);
            this.Wm.prepareAsync();
            this.Wm.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tbadk.BdToken.n.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    n.this.Wm.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void aP(boolean z) {
        if (z || this.alF == 0) {
            if (this.alD != null) {
                this.alD.play(this.alE, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        } else if (this.alD != null) {
            this.alD.play(this.alF, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }
}
