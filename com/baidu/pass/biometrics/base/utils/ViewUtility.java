package com.baidu.pass.biometrics.base.utils;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.pass.biometrics.base.debug.Log;
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

    public static void setViewClickAlpha(View view, final float f) {
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.pass.biometrics.base.utils.ViewUtility.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        if (Build.VERSION.SDK_INT >= 11) {
                            view2.setAlpha(f);
                            return false;
                        }
                        return false;
                    case 1:
                        if (Build.VERSION.SDK_INT >= 11) {
                            view2.setAlpha(1.0f);
                            return false;
                        }
                        return false;
                    case 2:
                    default:
                        return false;
                    case 3:
                        if (Build.VERSION.SDK_INT >= 11) {
                            view2.setAlpha(1.0f);
                            return false;
                        }
                        return false;
                }
            }
        });
    }
}
