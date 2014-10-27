package com.baidu.adp.lib.g;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
public class j {
    public static final boolean a(Dialog dialog, Activity activity) {
        if (dialog == null || activity == null || activity.isFinishing()) {
            return false;
        }
        if (activity.getWindow() != null && !activity.getWindow().isActive()) {
            try {
                dialog.show();
                return true;
            } catch (Exception e) {
            }
        }
        if (activity.getWindow() == null || !c(activity.getWindow().getDecorView())) {
            return false;
        }
        try {
            dialog.show();
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public static final boolean b(Dialog dialog, Activity activity) {
        if (dialog == null || activity == null || activity.isFinishing() || activity.getWindow() == null || !c(activity.getWindow().getDecorView())) {
            return false;
        }
        dialog.dismiss();
        return true;
    }

    public static final boolean a(PopupWindow popupWindow) {
        if (popupWindow == null || i(popupWindow.getContentView().getContext()) || !c(popupWindow.getContentView())) {
            return false;
        }
        popupWindow.dismiss();
        return true;
    }

    public static final boolean a(PopupWindow popupWindow, Activity activity) {
        if (popupWindow != null && activity != null) {
            if (!i(activity) && c(activity.getWindow().getDecorView())) {
                popupWindow.dismiss();
                return true;
            }
            return false;
        }
        return a(popupWindow);
    }

    public static final boolean showPopupWindowAtLocation(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (popupWindow == null || view == null || i(view.getContext()) || !c(view)) {
            return false;
        }
        try {
            popupWindow.showAtLocation(view, i, i2, i3);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static final boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view) {
        if (popupWindow == null || view == null || i(view.getContext()) || !c(view)) {
            return false;
        }
        try {
            popupWindow.showAsDropDown(view);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static final boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view, int i, int i2) {
        if (popupWindow == null || view == null || i(view.getContext()) || !c(view)) {
            return false;
        }
        try {
            popupWindow.showAsDropDown(view, i, i2);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static final boolean e(Activity activity) {
        if (activity == null || i(activity)) {
            return false;
        }
        return c(activity.getWindow().getDecorView()) || !activity.getWindow().isActive();
    }

    private static final boolean c(View view) {
        IBinder windowToken;
        if (view != null && (windowToken = view.getWindowToken()) != null) {
            try {
                if (windowToken.isBinderAlive()) {
                    if (windowToken.pingBinder()) {
                        return true;
                    }
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static final boolean i(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).isFinishing();
        }
        return true;
    }
}
