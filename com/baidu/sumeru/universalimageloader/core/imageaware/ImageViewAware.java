package com.baidu.sumeru.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.sumeru.universalimageloader.core.assist.ViewScaleType;
import com.baidu.sumeru.universalimageloader.utils.L;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
/* loaded from: classes11.dex */
public class ImageViewAware implements ImageAware {
    protected boolean checkActualViewSize;
    protected Reference<ImageView> imageViewRef;

    public ImageViewAware(ImageView imageView) {
        this(imageView, true);
    }

    public ImageViewAware(ImageView imageView, boolean z) {
        this.imageViewRef = new WeakReference(imageView);
        this.checkActualViewSize = z;
    }

    @Override // com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware
    public int getWidth() {
        int i = 0;
        ImageView imageView = this.imageViewRef.get();
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (this.checkActualViewSize && layoutParams != null && layoutParams.width != -2) {
                i = imageView.getWidth();
            }
            if (i <= 0 && layoutParams != null) {
                i = layoutParams.width;
            }
            return i <= 0 ? getImageViewFieldValue(imageView, "mMaxWidth") : i;
        }
        return 0;
    }

    @Override // com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware
    public int getHeight() {
        int i = 0;
        ImageView imageView = this.imageViewRef.get();
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (this.checkActualViewSize && layoutParams != null && layoutParams.height != -2) {
                i = imageView.getHeight();
            }
            if (i <= 0 && layoutParams != null) {
                i = layoutParams.height;
            }
            return i <= 0 ? getImageViewFieldValue(imageView, "mMaxHeight") : i;
        }
        return 0;
    }

    @Override // com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware
    public ViewScaleType getScaleType() {
        ImageView imageView = this.imageViewRef.get();
        if (imageView != null) {
            return ViewScaleType.fromImageView(imageView);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware
    public ImageView getWrappedView() {
        return this.imageViewRef.get();
    }

    @Override // com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware
    public boolean isCollected() {
        return this.imageViewRef.get() == null;
    }

    @Override // com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware
    public int getId() {
        ImageView imageView = this.imageViewRef.get();
        return imageView == null ? super.hashCode() : imageView.hashCode();
    }

    private static int getImageViewFieldValue(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(obj)).intValue();
            if (intValue > 0 && intValue < Integer.MAX_VALUE) {
                return intValue;
            }
        } catch (Exception e) {
            L.e(e);
        }
        return 0;
    }

    @Override // com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware
    public boolean setImageDrawable(Drawable drawable) {
        ImageView imageView = this.imageViewRef.get();
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            return true;
        }
        return false;
    }

    @Override // com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware
    public boolean setImageBitmap(Bitmap bitmap) {
        ImageView imageView = this.imageViewRef.get();
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
            return true;
        }
        return false;
    }
}
