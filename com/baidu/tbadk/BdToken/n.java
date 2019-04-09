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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class n implements SensorEventListener {
    private SensorManager aTA;
    private Sensor aTC;
    private Vibrator aUw;
    private final double bsg = 9.8d;
    private final int bsh = 400;
    private final int bsi = 255;
    private final int bsj = 1;
    private final int bsk = 2000;
    private a bsl;
    private SoundPool bsm;
    private int bsn;
    private int bso;
    private long bsp;
    private MediaPlayer bsq;
    private Context context;
    private boolean isOpen;

    /* loaded from: classes.dex */
    public interface a {
        void Ux();
    }

    public n(@NonNull Context context, @Nullable a aVar) {
        if (context != null) {
            this.context = context;
            this.bsl = aVar;
            this.aTA = (SensorManager) context.getSystemService("sensor");
            if (this.aTA != null) {
                this.aTC = this.aTA.getDefaultSensor(1);
            }
            this.aUw = (Vibrator) context.getSystemService("vibrator");
            this.bsm = new SoundPool(1, 3, 0);
            if (this.bsm != null) {
                this.bsn = this.bsm.load(context, d.i.shake_tone, 1);
            }
        }
    }

    public void open() {
        if (this.aTC != null) {
            this.aTA.registerListener(this, this.aTC, 2);
            this.isOpen = true;
        }
    }

    public void close() {
        if (this.aTA != null) {
            this.aTA.unregisterListener(this);
            this.isOpen = false;
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && e(sensorEvent.values) && this.bsl != null) {
            this.bsl.Ux();
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
            if (sqrt >= 2.5d && Uv()) {
                return true;
            }
        } else if (sqrt >= 4.2d && Uv()) {
            return true;
        }
        return false;
    }

    private boolean Uv() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bsp > 2000) {
            this.bsp = currentTimeMillis;
            return true;
        }
        return false;
    }

    public boolean Uw() {
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
        if (this.aUw == null || !this.aUw.hasVibrator() || i <= 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.aUw.vibrate(VibrationEffect.createOneShot(400L, 255));
        } else {
            this.aUw.vibrate(400L);
        }
        return true;
    }

    public void kk(String str) {
        if (this.bsq == null) {
            this.bsq = new MediaPlayer();
        }
        try {
            this.bsq.reset();
            this.bsq.setLooping(false);
            this.bsq.setDataSource(str);
            this.bsq.prepareAsync();
            this.bsq.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tbadk.BdToken.n.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    n.this.bsq.start();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cY(boolean z) {
        if (z || this.bso == 0) {
            if (this.bsm != null) {
                this.bsm.play(this.bsn, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        } else if (this.bsm != null) {
            this.bsm.play(this.bso, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }
}
