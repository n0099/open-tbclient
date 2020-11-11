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
import org.webrtc.MediaStreamTrack;
/* loaded from: classes.dex */
public class v implements SensorEventListener {
    private SensorManager bCN;
    private Context context;
    private Sensor dBq;
    private final double esS = 9.8d;
    private final int esT = 400;
    private final int esU = 255;
    private final int esV = 1;
    private final int esW = 2000;
    private a esX;
    private int esY;
    private int esZ;
    private long eta;
    private boolean isOpen;
    private MediaPlayer mMediaPlayer;
    private SoundPool mSoundPool;
    private Vibrator mVibrator;

    /* loaded from: classes.dex */
    public interface a {
        void bhn();
    }

    public v(@NonNull Context context, @Nullable a aVar) {
        if (context != null) {
            this.context = context;
            this.esX = aVar;
            this.bCN = (SensorManager) context.getSystemService("sensor");
            if (this.bCN != null) {
                this.dBq = this.bCN.getDefaultSensor(1);
            }
            this.mVibrator = (Vibrator) context.getSystemService("vibrator");
            this.mSoundPool = new SoundPool(1, 3, 0);
            if (this.mSoundPool != null) {
                this.esY = this.mSoundPool.load(context, R.raw.shake_tone, 1);
            }
        }
    }

    public void open() {
        if (this.dBq != null) {
            this.bCN.registerListener(this, this.dBq, 2);
            this.isOpen = true;
        }
    }

    public void close() {
        if (this.bCN != null) {
            this.bCN.unregisterListener(this);
            this.isOpen = false;
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && y(sensorEvent.values) && this.esX != null) {
            this.esX.bhn();
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
            if (sqrt >= 2.5d && bhl()) {
                return true;
            }
        } else if (sqrt >= 4.2d && bhl()) {
            return true;
        }
        return false;
    }

    private boolean bhl() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.eta > 2000) {
            this.eta = currentTimeMillis;
            return true;
        }
        return false;
    }

    public boolean bhm() {
        int i;
        if (this.context == null) {
            return false;
        }
        AudioManager audioManager = (AudioManager) this.context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
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

    public void zI(String str) {
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

    public void ip(boolean z) {
        if (z || this.esZ == 0) {
            if (this.mSoundPool != null) {
                this.mSoundPool.play(this.esY, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        } else if (this.mSoundPool != null) {
            this.mSoundPool.play(this.esZ, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }
}
