package com.baidu.adp.lib.g;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
public class g {
    public static final boolean a(Dialog dialog, com.baidu.adp.base.e<?> eVar) {
        if (eVar == null || eVar.getPageActivity() == null) {
            return false;
        }
        return a(dialog, eVar.getPageActivity());
    }

    public static final boolean b(Dialog dialog, com.baidu.adp.base.e<?> eVar) {
        if (eVar == null || eVar.getPageActivity() == null) {
            return false;
        }
        return b(dialog, eVar.getPageActivity());
    }

    public static final boolean a(com.baidu.adp.base.e<?> eVar) {
        if (eVar == null) {
            return false;
        }
        return m(eVar.getPageActivity());
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
        if (activity.getWindow() == null || !aH(activity.getWindow().getDecorView())) {
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
        if (dialog == null || activity == null || activity.isFinishing() || activity.getWindow() == null || !aH(activity.getWindow().getDecorView())) {
            return false;
        }
        dialog.dismiss();
        return true;
    }

    public static final boolean b(PopupWindow popupWindow) {
        if (popupWindow == null || am(popupWindow.getContentView().getContext()) || !aH(popupWindow.getContentView())) {
            return false;
        }
        popupWindow.dismiss();
        return true;
    }

    public static final boolean a(PopupWindow popupWindow, Activity activity) {
        if (popupWindow != null && activity != null) {
            if (!am(activity) && aH(activity.getWindow().getDecorView())) {
                popupWindow.dismiss();
                return true;
            }
            return false;
        }
        return b(popupWindow);
    }

    public static final boolean showPopupWindowAtLocation(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (popupWindow == null || view == null || am(view.getContext()) || !aH(view)) {
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
        if (popupWindow == null || view == null || am(view.getContext()) || !aH(view)) {
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
        if (popupWindow == null || view == null || am(view.getContext()) || !aH(view)) {
            return false;
        }
        try {
            popupWindow.showAsDropDown(view, i, i2);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static final boolean m(Activity activity) {
        if (activity == null || am(activity)) {
            return false;
        }
        return aH(activity.getWindow().getDecorView()) || !activity.getWindow().isActive();
    }

    private static final boolean aH(View view) {
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

    private static final boolean am(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).isFinishing();
        }
        return true;
    }
}
