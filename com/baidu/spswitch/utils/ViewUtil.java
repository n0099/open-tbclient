package com.baidu.spswitch.utils;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.spswitch.view.SPSwitchRootLinearLayout;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes3.dex */
public class ViewUtil {
    public static final boolean DEBUG = SPConfig.isDebug();
    public static final String TAG = "ViewUtil";

    public static View getSPSRootLayout(View view) {
        View view2 = null;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof SPSwitchRootLinearLayout) {
                    view2 = childAt;
                }
                if (view2 != null) {
                    break;
                }
                view2 = getSPSRootLayout(childAt);
            }
        }
        return view2;
    }

    public static boolean isFitsSystemWindows(Activity activity) {
        View sPSRootLayout = getSPSRootLayout(activity.getWindow().getDecorView());
        if (sPSRootLayout == null) {
            if (DEBUG) {
                Log.d(TAG, "#isFitsSystemWindows#, getSPSRootLayout is NULL");
                return false;
            }
            return false;
        }
        return sPSRootLayout.getFitsSystemWindows();
    }

    public static boolean isFullScreen(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) != 0;
    }

    public static boolean isSystemUILayoutFullScreen(Activity activity) {
        return (activity.getWindow().getDecorView().getSystemUiVisibility() & 1024) != 0;
    }

    public static boolean isTranslucentStatus(Activity activity) {
        return (activity.getWindow().getAttributes().flags & CodedInputStream.DEFAULT_SIZE_LIMIT) != 0;
    }

    public static boolean refreshHeight(View view, int i) {
        if (view.getHeight() == i) {
            return false;
        }
        if (DEBUG) {
            Log.d(TAG, "refreshHeight, originalHeight: " + view.getHeight() + ", aimHeight: " + i);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        } else {
            layoutParams.height = i;
            view.requestLayout();
        }
        if (DEBUG) {
            Log.d(TAG, "refreshHeight, newHeight: " + view.getHeight());
            return true;
        }
        return true;
    }
}
