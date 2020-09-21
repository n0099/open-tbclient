package com.baidu.pass.biometrics.base.utils;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.pass.biometrics.base.debug.Log;
/* loaded from: classes6.dex */
public class ViewUtility {
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
