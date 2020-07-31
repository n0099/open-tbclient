package com.baidu.android.util.android;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.RequiresPermission;
import android.support.v4.app.ActivityCompat;
/* loaded from: classes20.dex */
public class VibrateUtils {
    private int[] amplitudes;
    private Context mContext;
    private Vibrator mVibrator;
    private long[] timings;

    private VibrateUtils(Builder builder) {
        this.mVibrator = builder.mVibrator;
        this.timings = builder.timings;
        this.amplitudes = builder.amplitudes;
        this.mContext = builder.mContext;
    }

    @RequiresPermission("android.permission.VIBRATE")
    public void vibrateStart() {
        if (checkVibratePermission() && this.mVibrator != null && this.timings != null && this.timings.length > 0 && this.mVibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= 26) {
                if (this.amplitudes != null && this.amplitudes.length > 0) {
                    if (this.timings.length == this.amplitudes.length) {
                        if (this.timings.length == 1) {
                            this.mVibrator.vibrate(VibrationEffect.createOneShot(this.timings[0], this.amplitudes[0]));
                        } else {
                            this.mVibrator.vibrate(VibrationEffect.createWaveform(this.timings, this.amplitudes, -1));
                        }
                    } else if (this.timings.length == 1) {
                        this.mVibrator.vibrate(VibrationEffect.createOneShot(this.timings[0], this.amplitudes[0]));
                    } else {
                        this.mVibrator.vibrate(VibrationEffect.createWaveform(this.timings, -1));
                    }
                } else if (this.timings.length == 1) {
                    this.mVibrator.vibrate(VibrationEffect.createOneShot(this.timings[0], -1));
                } else {
                    this.mVibrator.vibrate(VibrationEffect.createWaveform(this.timings, -1));
                }
            } else if (this.timings.length == 1) {
                this.mVibrator.vibrate(this.timings[0]);
            } else {
                this.mVibrator.vibrate(this.timings, -1);
            }
        }
    }

    @RequiresPermission("android.permission.VIBRATE")
    public void cancelVibrator() {
        if (this.mVibrator != null && this.mVibrator.hasVibrator() && checkVibratePermission()) {
            this.mVibrator.cancel();
        }
    }

    private boolean checkVibratePermission() {
        return this.mContext != null && ActivityCompat.checkSelfPermission(this.mContext, "android.permission.VIBRATE") == 0;
    }

    /* loaded from: classes20.dex */
    public static final class Builder {
        private int[] amplitudes;
        private Context mContext;
        private Vibrator mVibrator;
        private long[] timings;

        public Builder(Vibrator vibrator, long[] jArr, Context context) {
            this.mVibrator = vibrator;
            this.mContext = context;
            this.timings = jArr;
        }

        public Builder amplitudes(int[] iArr) {
            this.amplitudes = iArr;
            return this;
        }

        public VibrateUtils build() {
            return new VibrateUtils(this);
        }
    }
}
