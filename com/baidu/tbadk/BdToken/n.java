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
    private SensorManager aTw;
    private Sensor aTy;
    private Vibrator aUs;
    private final double bsc = 9.8d;
    private final int bsd = 400;
    private final int bse = 255;
    private final int bsf = 1;
    private final int bsg = 2000;
    private a bsh;
    private SoundPool bsi;
    private int bsj;
    private int bsk;
    private long bsl;
    private MediaPlayer bsm;
    private Context context;
    private boolean isOpen;

    /* loaded from: classes.dex */
    public interface a {
        void UA();
    }

    public n(@NonNull Context context, @Nullable a aVar) {
        if (context != null) {
            this.context = context;
            this.bsh = aVar;
            this.aTw = (SensorManager) context.getSystemService("sensor");
            if (this.aTw != null) {
                this.aTy = this.aTw.getDefaultSensor(1);
            }
            this.aUs = (Vibrator) context.getSystemService("vibrator");
            this.bsi = new SoundPool(1, 3, 0);
            if (this.bsi != null) {
                this.bsj = this.bsi.load(context, d.i.shake_tone, 1);
            }
        }
    }

    public void open() {
        if (this.aTy != null) {
            this.aTw.registerListener(this, this.aTy, 2);
            this.isOpen = true;
        }
    }

    public void close() {
        if (this.aTw != null) {
            this.aTw.unregisterListener(this);
            this.isOpen = false;
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && e(sensorEvent.values) && this.bsh != null) {
            this.bsh.UA();
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
        if (currentTimeMillis - this.bsl > 2000) {
            this.bsl = currentTimeMillis;
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
        if (this.aUs == null || !this.aUs.hasVibrator() || i <= 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.aUs.vibrate(VibrationEffect.createOneShot(400L, 255));
        } else {
            this.aUs.vibrate(400L);
        }
        return true;
    }

    public void kj(String str) {
        if (this.bsm == null) {
            this.bsm = new MediaPlayer();
        }
        try {
            this.bsm.reset();
            this.bsm.setLooping(false);
            this.bsm.setDataSource(str);
            this.bsm.prepareAsync();
            this.bsm.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tbadk.BdToken.n.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    n.this.bsm.start();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cY(boolean z) {
        if (z || this.bsk == 0) {
            if (this.bsi != null) {
                this.bsi.play(this.bsj, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        } else if (this.bsi != null) {
            this.bsi.play(this.bsk, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }
}
