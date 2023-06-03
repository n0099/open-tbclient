package com.baidu.searchbox.ui.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.DrawableRes;
import androidx.core.graphics.drawable.DrawableCompat;
/* loaded from: classes4.dex */
public class ColorStateDrawable {
    public static final String TAG = "ColorStateDrawable";
    public Drawable mBaseDrawable;
    public Drawable mFinalDrawable;

    /* loaded from: classes4.dex */
    public static final class ColorStateBuilder {
        public ColorStateDrawable mDrawable = new ColorStateDrawable();

        public Drawable build() {
            return this.mDrawable.getDrawable();
        }

        public ColorStateBuilder setBaseDrawable(Resources resources, @DrawableRes int i) {
            this.mDrawable.setBaseDrawable(resources, i);
            return this;
        }

        public ColorStateBuilder setColorStateList(ColorStateList colorStateList, PorterDuff.Mode mode) {
            this.mDrawable.setColorStateList(colorStateList, mode);
            return this;
        }

        public ColorStateBuilder setBaseDrawable(Resources resources, Drawable drawable) {
            this.mDrawable.setBaseDrawable(resources, drawable);
            return this;
        }

        public ColorStateBuilder setBaseDrawable(Drawable drawable) {
            this.mDrawable.setBaseDrawable(drawable);
            return this;
        }

        public ColorStateBuilder setColorStateList(ColorStateList colorStateList) {
            this.mDrawable.setColorStateList(colorStateList);
            return this;
        }
    }

    /* loaded from: classes4.dex */
    public static final class InnerBitmapDrawable extends BitmapDrawable {
        public InnerBitmapDrawable(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public boolean onStateChange(int[] iArr) {
            boolean onStateChange = super.onStateChange(iArr);
            if (Build.VERSION.SDK_INT >= 21 && onStateChange) {
                invalidateSelf();
            }
            return onStateChange;
        }
    }

    public ColorStateDrawable() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable getDrawable() {
        return this.mFinalDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBaseDrawable(Drawable drawable) {
        this.mBaseDrawable = drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorStateList(ColorStateList colorStateList) {
        setColorStateList(colorStateList, PorterDuff.Mode.DST_OVER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBaseDrawable(Resources resources, @DrawableRes int i) {
        this.mBaseDrawable = new InnerBitmapDrawable(resources, BitmapFactory.decodeResource(resources, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorStateList(ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = this.mBaseDrawable;
        if (drawable == null) {
            return;
        }
        Drawable mutate = DrawableCompat.wrap(drawable).mutate();
        this.mFinalDrawable = mutate;
        DrawableCompat.setTintMode(mutate, mode);
        DrawableCompat.setTintList(this.mFinalDrawable, colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBaseDrawable(Resources resources, Drawable drawable) {
        Bitmap.Config config;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        this.mBaseDrawable = new InnerBitmapDrawable(resources, createBitmap);
    }
}
