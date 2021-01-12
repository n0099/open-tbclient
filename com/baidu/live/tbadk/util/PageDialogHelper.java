package com.baidu.live.tbadk.util;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.WindowManager;
/* loaded from: classes10.dex */
public class PageDialogHelper {

    /* loaded from: classes10.dex */
    public enum PayForm {
        NOT_SET,
        DIALOG,
        NORMAL
    }

    private PageDialogHelper() {
    }

    public static void setDialogLayout(Activity activity) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        attributes.x = 0;
        attributes.height = displayMetrics.heightPixels - 400;
        attributes.width = -1;
        attributes.y = 0;
        attributes.gravity = 80;
        activity.getWindow().setAttributes(attributes);
        activity.setFinishOnTouchOutside(false);
    }
}
