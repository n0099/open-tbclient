package com.baidu.swan.videoplayer;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes6.dex */
public class d {
    public static boolean bf(View view) {
        if (view != null && view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup.indexOfChild(view) != -1) {
                try {
                    viewGroup.removeView(view);
                } catch (Exception e) {
                }
                return true;
            }
        }
        return false;
    }

    public static boolean attachDecor(Activity activity, View view) {
        ViewGroup viewGroup;
        if (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null) {
            return false;
        }
        bf(view);
        viewGroup.removeView(view);
        viewGroup.addView(view);
        return true;
    }
}
