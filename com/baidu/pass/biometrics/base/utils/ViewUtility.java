package com.baidu.pass.biometrics.base.utils;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.pass.biometrics.base.debug.Log;
/* loaded from: classes3.dex */
public class ViewUtility {
    public static int dip2pxForBio(float f, int[] iArr) {
        float f2 = 2.0f;
        if (iArr[0] >= 240 && iArr[0] <= 320 && iArr[1] >= 320 && iArr[1] >= 480) {
            f2 = 0.75f;
        } else if (iArr[0] >= 320 && iArr[0] < 480 && iArr[1] >= 480 && iArr[1] < 800) {
            f2 = 1.0f;
        } else if (iArr[0] >= 480 && iArr[0] < 720 && iArr[1] >= 800 && iArr[1] < 1280) {
            f2 = 1.5f;
        } else if ((iArr[0] < 720 || iArr[0] >= 1080 || iArr[1] < 1280 || iArr[1] >= 1920) && iArr[0] >= 1080 && iArr[1] >= 1920) {
            f2 = 3.0f;
        }
        return (int) ((f * f2) + 0.5f);
    }

    public static void dismissDialog(Activity activity, Dialog dialog) {
        if (activity != null) {
            if (dialog != null && !activity.isFinishing() && dialog.isShowing()) {
                try {
                    dialog.dismiss();
                    return;
                } catch (Exception e) {
                    Log.e(e);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("Activity must not be null");
    }
}
