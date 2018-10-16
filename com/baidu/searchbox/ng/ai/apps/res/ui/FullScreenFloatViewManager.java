package com.baidu.searchbox.ng.ai.apps.res.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.searchbox.ng.ai.apps.R;
/* loaded from: classes2.dex */
public class FullScreenFloatViewManager {
    public static final int TYPE_BUTTON = 2;
    public static final int TYPE_IMAGE_VIEW = 1;

    public static FullScreenFloatView addFloatView(Context context, ViewGroup viewGroup) {
        return addFloatView(context, viewGroup, 1);
    }

    public static FullScreenFloatView addFloatView(Context context, ViewGroup viewGroup, int i) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FullScreenFloatView inflateFloatView = inflateFloatView(context, i);
        viewGroup.addView(inflateFloatView);
        return inflateFloatView;
    }

    private static FullScreenFloatView inflateFloatView(Context context, int i) {
        if (context == null) {
            return null;
        }
        int i2 = R.layout.aiapps_fullscreen_floatview;
        if (i == 1) {
            i2 = R.layout.aiapps_fullscreen_floatview;
        } else if (i == 2) {
            i2 = R.layout.aiapps_fullscreen_floatview_button;
        }
        return (FullScreenFloatView) LayoutInflater.from(context.getApplicationContext()).inflate(i2, (ViewGroup) null);
    }
}
