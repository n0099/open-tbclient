package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
/* loaded from: classes8.dex */
public class b {
    public static FullScreenFloatView a(Context context, ViewGroup viewGroup, int i) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FullScreenFloatView j = j(context, i);
        viewGroup.addView(j);
        return j;
    }

    private static FullScreenFloatView j(Context context, int i) {
        if (context == null) {
            return null;
        }
        int i2 = a.g.aiapps_fullscreen_floatview;
        if (i == 1) {
            i2 = a.g.aiapps_fullscreen_floatview;
        } else if (i == 2) {
            i2 = a.g.aiapps_fullscreen_floatview_button;
        }
        return (FullScreenFloatView) LayoutInflater.from(context.getApplicationContext()).inflate(i2, (ViewGroup) null);
    }
}
