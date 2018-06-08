package com.baidu.ar.util;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.ar.constants.HttpConstants;
/* loaded from: classes3.dex */
public class ViewUtils {
    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", HttpConstants.OS_TYPE_VALUE));
    }

    public static void removeFromParent(final View view) {
        if (view != null) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.util.ViewUtils.4
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(view);
                    }
                }
            });
        }
    }

    public static void setRelativeMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.leftMargin = i;
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.rightMargin = i3;
        marginLayoutParams.bottomMargin = i4;
        view.requestLayout();
    }

    public static void setViewEnabled(final View view, final boolean z) {
        if (view != null) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.util.ViewUtils.3
                @Override // java.lang.Runnable
                public void run() {
                    view.setEnabled(z);
                }
            });
        }
    }

    public static void setViewText(final TextView textView, final String str) {
        if (textView != null) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.util.ViewUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    textView.setText(str);
                }
            });
        }
    }

    public static void setViewVisibility(final View view, final int i) {
        if (view != null) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.util.ViewUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(i);
                }
            });
        }
    }
}
