package com.baidu.live.utils;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
/* loaded from: classes2.dex */
public class d {
    public static final Drawable a(Resources resources, int i) {
        return a(resources, i, -1006632960);
    }

    public static final Drawable a(Resources resources, int i, int i2) {
        Drawable drawable = resources.getDrawable(i);
        if (drawable instanceof BitmapDrawable) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            bitmapDrawable.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_ATOP));
            stateListDrawable.addState(new int[]{16842919}, bitmapDrawable);
            stateListDrawable.addState(new int[]{16842910}, bitmapDrawable2);
            return stateListDrawable;
        }
        return drawable;
    }
}
