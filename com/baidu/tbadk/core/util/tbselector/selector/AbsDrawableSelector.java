package com.baidu.tbadk.core.util.tbselector.selector;

import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public abstract class AbsDrawableSelector {
    public static final int TYPE_BACKGROUND = 1;
    public static final int TYPE_SRC = 2;
    public int mAlpha;
    public Drawable mDisabledDrawable;
    public Drawable mFocusedDrawable;
    public Drawable mNormalDrawable;
    public Drawable mPressedDrawable;
    public Drawable mSelectedDrawable;
    public int mType = 1;
    public boolean hasSetDisabledDrawable = false;
    public boolean hasSetPressedDrawable = false;
    public boolean hasSetSelectedDrawable = false;
    public boolean hasSetFocusedDrawable = false;
    public boolean hasSetAlpha = false;

    public abstract Drawable onItemDefaultDrawable();

    public abstract Drawable onItemDisabledDrawable();

    public abstract Drawable onItemFocusedDrawable();

    public abstract Drawable onItemPressedDrawable();

    public abstract Drawable onItemSelectedDrawable();

    public void updateDrawableAlpha(Drawable drawable) {
        if (!this.hasSetAlpha || drawable == null) {
            return;
        }
        drawable.mutate().setAlpha(this.mAlpha);
    }
}
