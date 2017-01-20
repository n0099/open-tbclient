package com.baidu.adp.lib.g;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
public class j {
    public static final boolean a(Dialog dialog, com.baidu.adp.base.g<?> gVar) {
        if (gVar == null || gVar.getPageActivity() == null) {
            return false;
        }
        return a(dialog, gVar.getPageActivity());
    }

    public static final boolean b(Dialog dialog, com.baidu.adp.base.g<?> gVar) {
        if (gVar == null || gVar.getPageActivity() == null) {
            return false;
        }
        return b(dialog, gVar.getPageActivity());
    }

    public static final boolean a(com.baidu.adp.base.g<?> gVar) {
        if (gVar == null) {
            return false;
        }
        return l(gVar.getPageActivity());
    }

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
        if (activity.getWindow() == null || !p(activity.getWindow().getDecorView())) {
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
        if (dialog == null || activity == null || activity.isFinishing() || activity.getWindow() == null || !p(activity.getWindow().getDecorView())) {
            return false;
        }
        dialog.dismiss();
        return true;
    }

    public static final boolean a(PopupWindow popupWindow) {
        if (popupWindow == null || E(popupWindow.getContentView().getContext()) || !p(popupWindow.getContentView())) {
            return false;
        }
        popupWindow.dismiss();
        return true;
    }

    public static final boolean a(PopupWindow popupWindow, Activity activity) {
        if (popupWindow != null && activity != null) {
            if (!E(activity) && p(activity.getWindow().getDecorView())) {
                popupWindow.dismiss();
                return true;
            }
            return false;
        }
        return a(popupWindow);
    }

    public static final boolean showPopupWindowAtLocation(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (popupWindow == null || view == null || E(view.getContext()) || !p(view)) {
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
        if (popupWindow == null || view == null || E(view.getContext()) || !p(view)) {
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
        if (popupWindow == null || view == null || E(view.getContext()) || !p(view)) {
            return false;
        }
        try {
            popupWindow.showAsDropDown(view, i, i2);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static final boolean l(Activity activity) {
        if (activity == null || E(activity)) {
            return false;
        }
        return p(activity.getWindow().getDecorView()) || !activity.getWindow().isActive();
    }

    private static final boolean p(View view) {
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

    private static final boolean E(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).isFinishing();
        }
        return true;
    }
}
