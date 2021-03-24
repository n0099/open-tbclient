package com.baidu.platform.comjni.jninative.vibrate;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Vibrator;
import com.baidu.platform.comapi.wnplatform.o.b.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class VibrateHelper {
    public static final int VIBRATE_DURATION_TIME = 500;
    public static boolean bStopVibration = false;
    public static List<IVibrateListener> mVibrateListeners;
    public static Vibrator vibrator;

    public static void addVibrateListener(IVibrateListener iVibrateListener) {
        if (mVibrateListeners == null) {
            mVibrateListeners = new LinkedList();
        }
        mVibrateListeners.add(iVibrateListener);
    }

    @SuppressLint({"NewApi"})
    public static boolean checkVibrate() {
        return Build.VERSION.SDK_INT >= 11 ? vibrator.hasVibrator() : vibrator != null;
    }

    public static void mobileVibration() {
        if (vibrator == null) {
            vibrator = (Vibrator) a.a().getSystemService("vibrator");
        }
        if (checkVibrate() && !bStopVibration) {
            vibrator.vibrate(500L);
            List<IVibrateListener> list = mVibrateListeners;
            if (list != null) {
                for (IVibrateListener iVibrateListener : list) {
                    if (iVibrateListener != null) {
                        iVibrateListener.onVibrate();
                    }
                }
            }
        }
    }

    public static void pauseVibration() {
        bStopVibration = true;
    }

    public static void removeVibrateListener(IVibrateListener iVibrateListener) {
        List<IVibrateListener> list = mVibrateListeners;
        if (list != null || iVibrateListener == null) {
            return;
        }
        list.remove(iVibrateListener);
    }

    public static void resumeVibration() {
        bStopVibration = false;
    }
}
