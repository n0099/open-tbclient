package com.baidu.searchbox.player.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
/* loaded from: classes9.dex */
public class BdViewOpUtils {
    private static final String TAG = "BdViewOpUtils";

    public static boolean removeView(View view) {
        if (view != null && view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup.indexOfChild(view) != -1) {
                try {
                    BdVideoLog.d(TAG, "removeView " + view.hashCode());
                    viewGroup.removeView(view);
                } catch (Exception e) {
                    BdVideoLog.e(TAG, "remove view ex");
                    e.printStackTrace();
                }
                return true;
            }
        }
        return false;
    }

    public static boolean removeChilds(ViewGroup viewGroup) {
        if (viewGroup != null) {
            BdVideoLog.d(TAG, "removeChilds " + viewGroup.hashCode());
            viewGroup.removeAllViews();
            return true;
        }
        return false;
    }

    public static boolean isParentView(View view, ViewGroup viewGroup) {
        return (view == null || viewGroup == null || viewGroup != ((ViewGroup) view.getParent())) ? false : true;
    }

    public static boolean isAttachDecor(Activity activity, View view) {
        return (activity == null || view == null || ((ViewGroup) activity.getWindow().getDecorView()).indexOfChild(view) == -1) ? false : true;
    }

    public static ViewGroup getDecorView(Activity activity) {
        if (activity != null) {
            return (ViewGroup) activity.getWindow().getDecorView();
        }
        return null;
    }

    public static boolean isParent(View view) {
        return (view == null || view.getParent() == null) ? false : true;
    }

    public static boolean hasChild(ViewGroup viewGroup) {
        return viewGroup != null && viewGroup.getChildCount() > 0;
    }

    public static boolean hasParent(View view) {
        return (view == null || view.getParent() == null) ? false : true;
    }

    public static boolean isZeroSize(View view) {
        return view == null || view.getWidth() == 0 || view.getHeight() == 0;
    }

    public static boolean attachDecor(Activity activity, View view) {
        if (activity == null || view == null) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        removeView(view);
        viewGroup.removeView(view);
        viewGroup.addView(view);
        if (hasPermanentMenuKey(activity)) {
            setSystemUiVisibility(viewGroup, true);
        }
        return true;
    }

    public static boolean attachView(View view, ViewGroup viewGroup) {
        if (view == null || viewGroup == null || viewGroup.getParent() == null) {
            return false;
        }
        BdVideoLog.d(TAG, "attachView " + view.hashCode() + " " + viewGroup.hashCode());
        try {
            viewGroup.addView(view);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean hasPermanentMenuKey(Context context) {
        return (context == null || ViewConfiguration.get(context).hasPermanentMenuKey()) ? false : true;
    }

    public static void fixFullScreen4Notch(Activity activity, boolean z) {
        if (activity != null && Build.VERSION.SDK_INT >= 28) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (z) {
                attributes.layoutInDisplayCutoutMode = 1;
            } else {
                attributes.layoutInDisplayCutoutMode = 0;
            }
            window.setAttributes(attributes);
        }
    }

    public static void fixFullScreen4Notch(Dialog dialog, boolean z) {
        if (dialog != null && Build.VERSION.SDK_INT >= 28) {
            Window window = dialog.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (z) {
                attributes.layoutInDisplayCutoutMode = 1;
            } else {
                attributes.layoutInDisplayCutoutMode = 0;
            }
            window.setAttributes(attributes);
        }
    }

    public static void setSystemUiVisibility(View view, boolean z) {
        BdVideoLog.d(TAG, "setSystemUiVisibility immersive: " + z);
        if (view != null) {
            if (z) {
                view.setSystemUiVisibility(5638);
            } else {
                view.setSystemUiVisibility(0);
            }
        }
    }

    public static void showSystemUi(View view) {
        if (view != null) {
            view.setSystemUiVisibility(0);
        }
    }
}
