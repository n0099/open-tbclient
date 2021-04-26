package com.baidu.android.util.android;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.annotation.RequiresPermission;
import androidx.core.content.ContextCompat;
/* loaded from: classes.dex */
public class VibrateUtils {
    public int[] amplitudes;
    public Context mContext;
    public Vibrator mVibrator;
    public long[] timings;

    /* loaded from: classes.dex */
    public static final class Builder {
        public int[] amplitudes;
        public Context mContext;
        public Vibrator mVibrator;
        public long[] timings;

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

    private boolean checkVibratePermission() {
        Context context = this.mContext;
        return context != null && ContextCompat.checkSelfPermission(context, "android.permission.VIBRATE") == 0;
    }

    @RequiresPermission("android.permission.VIBRATE")
    public void cancelVibrator() {
        Vibrator vibrator = this.mVibrator;
        if (vibrator != null && vibrator.hasVibrator() && checkVibratePermission()) {
            this.mVibrator.cancel();
        }
    }

    @RequiresPermission("android.permission.VIBRATE")
    public void vibrateStart() {
        Vibrator vibrator;
        long[] jArr;
        if (!checkVibratePermission() || (vibrator = this.mVibrator) == null || (jArr = this.timings) == null || jArr.length <= 0 || !vibrator.hasVibrator()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            int[] iArr = this.amplitudes;
            if (iArr != null && iArr.length > 0) {
                long[] jArr2 = this.timings;
                if (jArr2.length == iArr.length) {
                    if (jArr2.length == 1) {
                        this.mVibrator.vibrate(VibrationEffect.createOneShot(jArr2[0], iArr[0]));
                        return;
                    } else {
                        this.mVibrator.vibrate(VibrationEffect.createWaveform(jArr2, iArr, -1));
                        return;
                    }
                } else if (jArr2.length == 1) {
                    this.mVibrator.vibrate(VibrationEffect.createOneShot(jArr2[0], iArr[0]));
                    return;
                } else {
                    this.mVibrator.vibrate(VibrationEffect.createWaveform(jArr2, -1));
                    return;
                }
            }
            long[] jArr3 = this.timings;
            if (jArr3.length == 1) {
                this.mVibrator.vibrate(VibrationEffect.createOneShot(jArr3[0], -1));
                return;
            } else {
                this.mVibrator.vibrate(VibrationEffect.createWaveform(jArr3, -1));
                return;
            }
        }
        long[] jArr4 = this.timings;
        if (jArr4.length == 1) {
            this.mVibrator.vibrate(jArr4[0]);
        } else {
            this.mVibrator.vibrate(jArr4, -1);
        }
    }

    public VibrateUtils(Builder builder) {
        this.mVibrator = builder.mVibrator;
        this.timings = builder.timings;
        this.amplitudes = builder.amplitudes;
        this.mContext = builder.mContext;
    }
}
