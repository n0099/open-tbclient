package com.baidu.searchbox.config.ext;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.baidu.searchbox.config.FontSizeHelper;
import com.sina.weibo.sdk.utils.ResourceManager;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a*\u0010\b\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a*\u0010\u000b\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\r"}, d2 = {"setScaledImageBitmap", "", "Landroid/widget/ImageView;", "type", "", "bitmap", "Landroid/graphics/Bitmap;", "numRoundPolicy", "setScaledImageDrawable", ResourceManager.DRAWABLE, "Landroid/graphics/drawable/Drawable;", "setScaledImageDrawableRes", "resId", "lib-fontsize_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FontSizeImageViewExtKt {
    @JvmOverloads
    public static final void setScaledImageBitmap(ImageView imageView, int i, Bitmap bitmap) {
        setScaledImageBitmap$default(imageView, i, bitmap, 0, 4, null);
    }

    @JvmOverloads
    public static final void setScaledImageDrawable(ImageView imageView, int i, Drawable drawable) {
        setScaledImageDrawable$default(imageView, i, drawable, 0, 4, null);
    }

    @JvmOverloads
    public static final void setScaledImageDrawableRes(ImageView imageView, int i, @DrawableRes int i2) {
        setScaledImageDrawableRes$default(imageView, i, i2, 0, 4, null);
    }

    @JvmOverloads
    public static final void setScaledImageBitmap(ImageView imageView, int i, Bitmap bitmap, int i2) {
        if (imageView != null) {
            imageView.setImageBitmap(FontSizeHelper.getScaledBitmap(i, bitmap, i2));
        }
    }

    @JvmOverloads
    public static final void setScaledImageDrawable(ImageView imageView, int i, Drawable drawable, int i2) {
        if (imageView != null) {
            imageView.setImageDrawable(FontSizeHelper.getScaledDrawable(i, drawable, i2));
        }
    }

    @JvmOverloads
    public static final void setScaledImageDrawableRes(ImageView imageView, int i, @DrawableRes int i2, int i3) {
        setScaledImageDrawable(imageView, i, FontSizeHelper.getDrawableByResId(i2), i3);
    }

    public static /* synthetic */ void setScaledImageBitmap$default(ImageView imageView, int i, Bitmap bitmap, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 2;
        }
        setScaledImageBitmap(imageView, i, bitmap, i2);
    }

    public static /* synthetic */ void setScaledImageDrawable$default(ImageView imageView, int i, Drawable drawable, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 2;
        }
        setScaledImageDrawable(imageView, i, drawable, i2);
    }

    public static /* synthetic */ void setScaledImageDrawableRes$default(ImageView imageView, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 2;
        }
        setScaledImageDrawableRes(imageView, i, i2, i3);
    }
}
