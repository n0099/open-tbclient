package com.baidu.spswitch.b;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.spswitch.view.SPSwitchRootLinearLayout;
/* loaded from: classes13.dex */
public class g {
    private static final boolean DEBUG = b.isDebug();

    public static boolean f(View view, int i) {
        if (view.getHeight() == i) {
            return false;
        }
        if (DEBUG) {
            Log.d("ViewUtil", "refreshHeight, originalHeight: " + view.getHeight() + ", aimHeight: " + i);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        } else {
            layoutParams.height = i;
            view.requestLayout();
        }
        if (DEBUG) {
            Log.d("ViewUtil", "refreshHeight, newHeight: " + view.getHeight());
        }
        return true;
    }

    public static boolean isFullScreen(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) != 0;
    }

    public static boolean D(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 67108864) != 0;
    }

    public static boolean E(Activity activity) {
        return (activity.getWindow().getDecorView().getSystemUiVisibility() & 1024) != 0;
    }

    public static boolean F(Activity activity) {
        View ab = ab(activity.getWindow().getDecorView());
        if (ab == null) {
            if (DEBUG) {
                Log.d("ViewUtil", "#isFitsSystemWindows#, getSPSRootLayout is NULL");
            }
            return false;
        }
        return ab.getFitsSystemWindows();
    }

    private static View ab(View view) {
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
                view2 = ab(childAt);
            }
        }
        return view2;
    }
}
