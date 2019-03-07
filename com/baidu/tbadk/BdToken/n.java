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
    private SensorManager aTv;
    private Sensor aTx;
    private Vibrator aUr;
    private final double bsb = 9.8d;
    private final int bsc = 400;
    private final int bsd = 255;
    private final int bse = 1;
    private final int bsf = 2000;
    private a bsg;
    private SoundPool bsh;
    private int bsi;
    private int bsj;
    private long bsk;
    private MediaPlayer bsl;
    private Context context;
    private boolean isOpen;

    /* loaded from: classes.dex */
    public interface a {
        void UA();
    }

    public n(@NonNull Context context, @Nullable a aVar) {
        if (context != null) {
            this.context = context;
            this.bsg = aVar;
            this.aTv = (SensorManager) context.getSystemService("sensor");
            if (this.aTv != null) {
                this.aTx = this.aTv.getDefaultSensor(1);
            }
            this.aUr = (Vibrator) context.getSystemService("vibrator");
            this.bsh = new SoundPool(1, 3, 0);
            if (this.bsh != null) {
                this.bsi = this.bsh.load(context, d.i.shake_tone, 1);
            }
        }
    }

    public void open() {
        if (this.aTx != null) {
            this.aTv.registerListener(this, this.aTx, 2);
            this.isOpen = true;
        }
    }

    public void close() {
        if (this.aTv != null) {
            this.aTv.unregisterListener(this);
            this.isOpen = false;
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && e(sensorEvent.values) && this.bsg != null) {
            this.bsg.UA();
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
            if (sqrt >= 2.5d && Uy()) {
                return true;
            }
        } else if (sqrt >= 4.2d && Uy()) {
            return true;
        }
        return false;
    }

    private boolean Uy() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bsk > 2000) {
            this.bsk = currentTimeMillis;
            return true;
        }
        return false;
    }

    public boolean Uz() {
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
        if (this.aUr == null || !this.aUr.hasVibrator() || i <= 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.aUr.vibrate(VibrationEffect.createOneShot(400L, 255));
        } else {
            this.aUr.vibrate(400L);
        }
        return true;
    }

    public void kj(String str) {
        if (this.bsl == null) {
            this.bsl = new MediaPlayer();
        }
        try {
            this.bsl.reset();
            this.bsl.setLooping(false);
            this.bsl.setDataSource(str);
            this.bsl.prepareAsync();
            this.bsl.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tbadk.BdToken.n.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    n.this.bsl.start();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cY(boolean z) {
        if (z || this.bsj == 0) {
            if (this.bsh != null) {
                this.bsh.play(this.bsi, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        } else if (this.bsh != null) {
            this.bsh.play(this.bsj, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }
}
