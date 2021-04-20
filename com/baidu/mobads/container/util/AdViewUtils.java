package com.baidu.mobads.container.util;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
/* loaded from: classes2.dex */
public class AdViewUtils {
    public static final int SHOW_STATE_LOWER_THAN_MIN_SHOWPERCENT = 3;
    public static final int SHOW_STATE_NOT_ENOUGH_BIG = 6;
    public static final int SHOW_STATE_NOT_VISIBLE = 1;
    public static final int SHOW_STATE_SCREEN_OFF = 4;
    public static final int SHOW_STATE_SHOW = 0;

    public static int getViewState(View view) {
        if (isScreenOn(view.getContext())) {
            if (isAdViewShown(view)) {
                if (isNotEnoughBig(view)) {
                    return !isVisible(view, 50) ? 3 : 0;
                }
                return 6;
            }
            return 1;
        }
        return 4;
    }

    public static int getVisiblePercent(View view, Context context) {
        if (view != null) {
            try {
                if (view.isShown()) {
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    int i = displayMetrics.heightPixels;
                    int i2 = displayMetrics.widthPixels;
                    Rect rect = new Rect();
                    view.getGlobalVisibleRect(rect);
                    if (rect.top <= i && rect.left <= i2) {
                        return (int) (((rect.width() * rect.height()) * 100.0d) / (view.getWidth() * view.getHeight()));
                    }
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static boolean isAdViewOutsideScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect windowRect = ScreenUtils.getWindowRect(view.getContext());
        int width = iArr[0] + (view.getWidth() / 2);
        int height = iArr[1] + (view.getHeight() / 2);
        return width <= 0 || width >= windowRect.width() || height <= 0 || height >= windowRect.height();
    }

    public static boolean isAdViewShown(View view) {
        return view != null && view.isShown();
    }

    public static boolean isAdViewTooSmall(View view) {
        return view != null && (view.getWidth() < 10 || view.getHeight() < 10);
    }

    public static boolean isNotEnoughBig(View view) {
        return view.getWidth() > 15 && view.getHeight() > 15;
    }

    public static boolean isScreenOn(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(e2);
            return true;
        }
    }

    public static boolean isVisible(View view, int i) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            long height = rect.height() * rect.width();
            long height2 = view.getHeight() * view.getWidth();
            return height2 > 0 && height * 100 >= ((long) i) * height2;
        }
        return false;
    }
}
