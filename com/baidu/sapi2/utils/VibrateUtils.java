package com.baidu.sapi2.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;
import com.baidu.sapi2.NoProguard;
/* loaded from: classes2.dex */
public class VibrateUtils implements NoProguard {
    public static final String TAG = "VibrateUtils";

    public static void presetVibrate(Context context) {
        if (context == null) {
            Log.e(TAG, "context must can not be null");
        } else {
            ((Vibrator) context.getSystemService("vibrator")).vibrate(new long[]{200, 500}, -1);
        }
    }

    public static void virateCancle(Activity activity) {
        ((Vibrator) activity.getSystemService("vibrator")).cancel();
    }

    public static void vibrate(Context context, long[] jArr, int i) {
        if (context == null) {
            Log.e(TAG, "context must can not be null");
        } else {
            ((Vibrator) context.getSystemService("vibrator")).vibrate(jArr, i);
        }
    }
}
