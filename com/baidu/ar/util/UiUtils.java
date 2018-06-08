package com.baidu.ar.util;

import android.app.Dialog;
/* loaded from: classes3.dex */
public class UiUtils {
    public static void dismissDialog(Dialog dialog) {
        if (dialog != null) {
            try {
                dialog.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void showDialogSafely(Dialog dialog) {
        if (dialog != null) {
            try {
                dialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
