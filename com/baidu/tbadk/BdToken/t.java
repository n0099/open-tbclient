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
    private SensorManager aoj;
    private final double bSd = 9.8d;
    private final int bSe = 400;
    private final int bSf = 255;
    private final int bSg = 1;
    private final int bSh = 2000;
    private a bSi;
    private SoundPool bSj;
    private int bSk;
    private int bSl;
    private long bSm;
    private MediaPlayer bSn;
    private Vibrator bqL;
    private Sensor bql;
    private Context context;
    private boolean isOpen;

    /* loaded from: classes.dex */
    public interface a {
        void aeJ();
    }

    public t(@NonNull Context context, @Nullable a aVar) {
        if (context != null) {
            this.context = context;
            this.bSi = aVar;
            this.aoj = (SensorManager) context.getSystemService("sensor");
            if (this.aoj != null) {
                this.bql = this.aoj.getDefaultSensor(1);
            }
            this.bqL = (Vibrator) context.getSystemService("vibrator");
            this.bSj = new SoundPool(1, 3, 0);
            if (this.bSj != null) {
                this.bSk = this.bSj.load(context, R.raw.shake_tone, 1);
            }
        }
    }

    public void open() {
        if (this.bql != null) {
            this.aoj.registerListener(this, this.bql, 2);
            this.isOpen = true;
        }
    }

    public void close() {
        if (this.aoj != null) {
            this.aoj.unregisterListener(this);
            this.isOpen = false;
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && i(sensorEvent.values) && this.bSi != null) {
            this.bSi.aeJ();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    private boolean i(float[] fArr) {
        float abs = Math.abs(fArr[0]);
        float abs2 = Math.abs(fArr[1]);
        float abs3 = Math.abs(fArr[2]);
        double sqrt = Math.sqrt(Math.pow(abs2 / 9.8d, 2.0d) + Math.pow(abs / 9.8d, 2.0d) + Math.pow(abs3 / 9.8d, 2.0d));
        if (Build.VERSION.SDK_INT <= 23) {
            if (sqrt >= 2.5d && aeH()) {
                return true;
            }
        } else if (sqrt >= 4.2d && aeH()) {
            return true;
        }
        return false;
    }

    private boolean aeH() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bSm > 2000) {
            this.bSm = currentTimeMillis;
            return true;
        }
        return false;
    }

    public boolean aeI() {
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
        if (this.bqL == null || !this.bqL.hasVibrator() || i <= 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.bqL.vibrate(VibrationEffect.createOneShot(400L, 255));
        } else {
            this.bqL.vibrate(400L);
        }
        return true;
    }

    public void lX(String str) {
        if (this.bSn == null) {
            this.bSn = new MediaPlayer();
        }
        try {
            this.bSn.reset();
            this.bSn.setLooping(false);
            this.bSn.setDataSource(str);
            this.bSn.prepareAsync();
            this.bSn.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tbadk.BdToken.t.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    t.this.bSn.start();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dN(boolean z) {
        if (z || this.bSl == 0) {
            if (this.bSj != null) {
                this.bSj.play(this.bSk, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        } else if (this.bSj != null) {
            this.bSj.play(this.bSl, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }
}
