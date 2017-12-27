package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.ImageView;
@RestrictTo
/* loaded from: classes2.dex */
public class AppCompatImageHelper {
    private final ImageView Na;

    public AppCompatImageHelper(ImageView imageView) {
        this.Na = imageView;
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        int resourceId;
        TintTypedArray tintTypedArray = null;
        try {
            Drawable drawable = this.Na.getDrawable();
            if (drawable == null && (resourceId = (tintTypedArray = TintTypedArray.obtainStyledAttributes(this.Na.getContext(), attributeSet, R.styleable.AppCompatImageView, i, 0)).getResourceId(R.styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = AppCompatResources.getDrawable(this.Na.getContext(), resourceId)) != null) {
                this.Na.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.g(drawable);
            }
        } finally {
            if (tintTypedArray != null) {
                tintTypedArray.recycle();
            }
        }
    }

    public void setImageResource(int i) {
        if (i != 0) {
            Drawable drawable = AppCompatResources.getDrawable(this.Na.getContext(), i);
            if (drawable != null) {
                DrawableUtils.g(drawable);
            }
            this.Na.setImageDrawable(drawable);
            return;
        }
        this.Na.setImageDrawable(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasOverlappingRendering() {
        return Build.VERSION.SDK_INT < 21 || !(this.Na.getBackground() instanceof RippleDrawable);
    }
}
