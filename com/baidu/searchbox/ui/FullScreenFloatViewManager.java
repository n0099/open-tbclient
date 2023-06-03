package com.baidu.searchbox.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
/* loaded from: classes4.dex */
public class FullScreenFloatViewManager {
    public static final int TYPE_BUTTON = 2;
    public static final int TYPE_IMAGE_VIEW = 1;

    public static FullScreenFloatView addFloatView(Context context, ViewGroup viewGroup) {
        return addFloatView(context, viewGroup, 1);
    }

    public static FullScreenFloatView inflateFloatView(Context context, int i) {
        if (context == null) {
            return null;
        }
        int i2 = com.baidu.tieba.R.layout.fullscreen_floatview;
        if (i != 1 && i == 2) {
            i2 = com.baidu.tieba.R.layout.fullscreen_floatview_button;
        }
        return (FullScreenFloatView) LayoutInflater.from(context.getApplicationContext()).inflate(i2, (ViewGroup) null);
    }

    public static FullScreenFloatView addFloatView(Context context, ViewGroup viewGroup, int i) {
        if (context != null && viewGroup != null) {
            FullScreenFloatView inflateFloatView = inflateFloatView(context, i);
            viewGroup.addView(inflateFloatView);
            return inflateFloatView;
        }
        return null;
    }
}
