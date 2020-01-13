package com.baidu.platform.comjni.jninative.vibrate;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Vibrator;
import com.baidu.platform.comapi.wnplatform.o.b.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class VibrateHelper {
    public static final int VIBRATE_DURATION_TIME = 500;
    private static boolean bStopVibration = false;
    private static List<IVibrateListener> mVibrateListeners;
    private static Vibrator vibrator;

    public static void mobileVibration() {
        if (vibrator == null) {
            vibrator = (Vibrator) a.a().getSystemService("vibrator");
        }
        if (checkVibrate() && !bStopVibration) {
            vibrator.vibrate(500L);
            if (mVibrateListeners != null) {
                for (IVibrateListener iVibrateListener : mVibrateListeners) {
                    if (iVibrateListener != null) {
                        iVibrateListener.onVibrate();
                    }
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private static boolean checkVibrate() {
        if (Build.VERSION.SDK_INT >= 11) {
            if (!vibrator.hasVibrator()) {
                return false;
            }
        } else if (vibrator == null) {
            return false;
        }
        return true;
    }

    public static void pauseVibration() {
        bStopVibration = true;
    }

    public static void resumeVibration() {
        bStopVibration = false;
    }

    public static void addVibrateListener(IVibrateListener iVibrateListener) {
        if (mVibrateListeners == null) {
            mVibrateListeners = new LinkedList();
        }
        mVibrateListeners.add(iVibrateListener);
    }

    public static void removeVibrateListener(IVibrateListener iVibrateListener) {
        if (mVibrateListeners == null && iVibrateListener != null) {
            mVibrateListeners.remove(iVibrateListener);
        }
    }
}
