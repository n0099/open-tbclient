package com.baidu.cloudsdk.assets;

import android.content.Context;
import android.util.DisplayMetrics;
/* loaded from: classes.dex */
public final class DrawableUtils {
    public static int fix720px(Context context, int i) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return context.getResources().getConfiguration().orientation == 1 ? (int) (((displayMetrics.widthPixels * i) / 720.0f) + 0.5f) : (int) (((displayMetrics.heightPixels * i) / 720.0f) + 0.5f);
    }
}
