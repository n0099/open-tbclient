package com.baidu.adp.lib.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
public class g {
    public static final boolean a(Dialog dialog, com.baidu.adp.base.f<?> fVar) {
        if (fVar == null || fVar.getPageActivity() == null) {
            return false;
        }
        return showDialog(dialog, fVar.getPageActivity());
    }

    public static final boolean b(Dialog dialog, com.baidu.adp.base.f<?> fVar) {
        if (fVar == null || fVar.getPageActivity() == null) {
            return false;
        }
        return dismissDialog(dialog, fVar.getPageActivity());
    }

    public static final boolean a(com.baidu.adp.base.f<?> fVar) {
        if (fVar == null) {
            return false;
        }
        return isActivityCanShowDialogOrPopupWindow(fVar.getPageActivity());
    }

    public static final boolean showDialog(Dialog dialog, Activity activity) {
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
        if (activity.getWindow() == null || !isTokenValid(activity.getWindow().getDecorView())) {
            return false;
        }
        try {
            dialog.show();
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public static final boolean dismissDialog(Dialog dialog, Activity activity) {
        if (dialog == null || activity == null || activity.isFinishing() || activity.getWindow() == null || !isTokenValid(activity.getWindow().getDecorView())) {
            return false;
        }
        dialog.dismiss();
        return true;
    }

    public static final boolean dismissPopupWindow(PopupWindow popupWindow) {
        if (popupWindow == null || isActivityFinishing(popupWindow.getContentView().getContext()) || !isTokenValid(popupWindow.getContentView())) {
            return false;
        }
        popupWindow.dismiss();
        return true;
    }

    public static final boolean dismissPopupWindow(PopupWindow popupWindow, Activity activity) {
        if (popupWindow != null && activity != null) {
            if (!isActivityFinishing(activity) && isTokenValid(activity.getWindow().getDecorView())) {
                popupWindow.dismiss();
                return true;
            }
            return false;
        }
        return dismissPopupWindow(popupWindow);
    }

    public static final boolean showPopupWindowAtLocation(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (popupWindow == null || view == null || isActivityFinishing(view.getContext()) || !isTokenValid(view)) {
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
        if (popupWindow == null || view == null || isActivityFinishing(view.getContext()) || !isTokenValid(view)) {
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
        if (popupWindow == null || view == null || isActivityFinishing(view.getContext()) || !isTokenValid(view)) {
            return false;
        }
        try {
            popupWindow.showAsDropDown(view, i, i2);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static final boolean isActivityCanShowDialogOrPopupWindow(Activity activity) {
        if (activity == null || isActivityFinishing(activity)) {
            return false;
        }
        return isTokenValid(activity.getWindow().getDecorView()) || !activity.getWindow().isActive();
    }

    private static final boolean isTokenValid(View view) {
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

    private static final boolean isActivityFinishing(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).isFinishing();
        }
        return true;
    }
}
