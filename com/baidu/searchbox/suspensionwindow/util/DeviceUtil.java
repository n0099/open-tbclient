package com.baidu.searchbox.suspensionwindow.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes5.dex */
public class DeviceUtil {
    public static View inflate(Context context, int i) {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, (ViewGroup) null);
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getStatusBarHeight(@NonNull Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static int getNavigationBarHeight(@NonNull Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static boolean isFullScreen(Activity activity) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if ((activity.getWindow().getAttributes().flags & 1024) == 1024 || (activity.getWindow().getDecorView().getSystemUiVisibility() & 4) == 4) {
            return true;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().obtainStyledAttributes(new int[]{16843277}).getValue(0, typedValue);
        if (typedValue.type == 18) {
            if (typedValue.data != 0) {
                return true;
            }
        }
        return false;
    }
}
