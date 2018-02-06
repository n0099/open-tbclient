package com.baidu.sapi2.views;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.sapi2.base.debug.Log;
/* loaded from: classes2.dex */
public class ViewUtility {
    public static void dismissDialog(Activity activity, Dialog dialog) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity must not be null");
        }
        if (dialog != null && !activity.isFinishing() && dialog.isShowing()) {
            try {
                dialog.dismiss();
            } catch (Exception e) {
                Log.e(e);
            }
        }
    }
}
