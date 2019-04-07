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
    private Sensor aTB;
    private SensorManager aTz;
    private Vibrator aUv;
    private final double bsf = 9.8d;
    private final int bsg = 400;
    private final int bsh = 255;
    private final int bsi = 1;
    private final int bsj = 2000;
    private a bsk;
    private SoundPool bsl;
    private int bsm;
    private int bsn;
    private long bso;
    private MediaPlayer bsp;
    private Context context;
    private boolean isOpen;

    /* loaded from: classes.dex */
    public interface a {
        void Ux();
    }

    public n(@NonNull Context context, @Nullable a aVar) {
        if (context != null) {
            this.context = context;
            this.bsk = aVar;
            this.aTz = (SensorManager) context.getSystemService("sensor");
            if (this.aTz != null) {
                this.aTB = this.aTz.getDefaultSensor(1);
            }
            this.aUv = (Vibrator) context.getSystemService("vibrator");
            this.bsl = new SoundPool(1, 3, 0);
            if (this.bsl != null) {
                this.bsm = this.bsl.load(context, d.i.shake_tone, 1);
            }
        }
    }

    public void open() {
        if (this.aTB != null) {
            this.aTz.registerListener(this, this.aTB, 2);
            this.isOpen = true;
        }
    }

    public void close() {
        if (this.aTz != null) {
            this.aTz.unregisterListener(this);
            this.isOpen = false;
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && e(sensorEvent.values) && this.bsk != null) {
            this.bsk.Ux();
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
        if (currentTimeMillis - this.bso > 2000) {
            this.bso = currentTimeMillis;
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
        if (this.aUv == null || !this.aUv.hasVibrator() || i <= 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.aUv.vibrate(VibrationEffect.createOneShot(400L, 255));
        } else {
            this.aUv.vibrate(400L);
        }
        return true;
    }

    public void kk(String str) {
        if (this.bsp == null) {
            this.bsp = new MediaPlayer();
        }
        try {
            this.bsp.reset();
            this.bsp.setLooping(false);
            this.bsp.setDataSource(str);
            this.bsp.prepareAsync();
            this.bsp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tbadk.BdToken.n.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    n.this.bsp.start();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cY(boolean z) {
        if (z || this.bsn == 0) {
            if (this.bsl != null) {
                this.bsl.play(this.bsm, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        } else if (this.bsl != null) {
            this.bsl.play(this.bsn, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }
}
