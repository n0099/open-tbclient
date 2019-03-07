package com.baidu.swan.apps.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public class SwanAppRoundedImageView extends ImageView {
    private static final ImageView.ScaleType[] aYx = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private ImageView.ScaleType Om;
    private int Oo;
    private Drawable Oq;
    private boolean aYy;
    private int mBorderColor;
    private int mBorderWidth;
    private Drawable mDrawable;

    public SwanAppRoundedImageView(Context context) {
        super(context);
        this.Oo = 20;
        this.mBorderWidth = 2;
        this.mBorderColor = ViewCompat.MEASURED_STATE_MASK;
    }

    public SwanAppRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwanAppRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.j.RoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(b.j.RoundedImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(aYx[i2]);
        }
        this.Oo = obtainStyledAttributes.getDimensionPixelSize(b.j.RoundedImageView_corner_radius, -1);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(b.j.RoundedImageView_border_width, -1);
        if (this.Oo < 0) {
            this.Oo = 20;
        }
        if (this.mBorderWidth < 0) {
            this.mBorderWidth = 2;
        }
        this.mBorderColor = obtainStyledAttributes.getColor(b.j.RoundedImageView_border_color, ViewCompat.MEASURED_STATE_MASK);
        this.aYy = obtainStyledAttributes.getBoolean(b.j.RoundedImageView_round_background, false);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.Om;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            throw new NullPointerException();
        }
        if (this.Om != scaleType) {
            this.Om = scaleType;
            switch (AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            if ((this.mDrawable instanceof com.baidu.swan.apps.res.ui.c) && ((com.baidu.swan.apps.res.ui.c) this.mDrawable).getScaleType() != scaleType) {
                ((com.baidu.swan.apps.res.ui.c) this.mDrawable).setScaleType(scaleType);
            }
            if ((this.Oq instanceof com.baidu.swan.apps.res.ui.c) && ((com.baidu.swan.apps.res.ui.c) this.Oq).getScaleType() != scaleType) {
                ((com.baidu.swan.apps.res.ui.c) this.Oq).setScaleType(scaleType);
            }
            setWillNotCacheDrawing(true);
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.view.SwanAppRoundedImageView$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType = new int[ImageView.ScaleType.values().length];

        static {
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            this.mDrawable = com.baidu.swan.apps.res.ui.c.a(drawable, this.Om, this.Oo, this.mBorderWidth, this.mBorderColor);
        } else {
            this.mDrawable = null;
        }
        super.setImageDrawable(this.mDrawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.mDrawable = new com.baidu.swan.apps.res.ui.c(bitmap, this.Oo, this.mBorderWidth, this.mBorderColor);
            if (this.Om != null) {
                ((com.baidu.swan.apps.res.ui.c) this.mDrawable).setScaleType(this.Om);
            }
        } else {
            this.mDrawable = null;
        }
        super.setImageDrawable(this.mDrawable);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.aYy && drawable != null) {
            this.Oq = com.baidu.swan.apps.res.ui.c.a(drawable, this.Om, this.Oo, this.mBorderWidth, this.mBorderColor);
        } else {
            this.Oq = drawable;
        }
        super.setBackgroundDrawable(this.Oq);
    }

    public int getCornerRadius() {
        return this.Oo;
    }

    public void setCornerRadius(int i) {
        if (this.Oo != i) {
            this.Oo = i;
            if (this.mDrawable instanceof com.baidu.swan.apps.res.ui.c) {
                ((com.baidu.swan.apps.res.ui.c) this.mDrawable).setCornerRadius(i);
            }
            if (this.aYy && (this.Oq instanceof com.baidu.swan.apps.res.ui.c)) {
                ((com.baidu.swan.apps.res.ui.c) this.Oq).setCornerRadius(i);
            }
        }
    }

    public int getBorder() {
        return this.mBorderWidth;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
            if (this.mDrawable instanceof com.baidu.swan.apps.res.ui.c) {
                ((com.baidu.swan.apps.res.ui.c) this.mDrawable).setBorderColor(i);
            }
            if (this.aYy && (this.Oq instanceof com.baidu.swan.apps.res.ui.c)) {
                ((com.baidu.swan.apps.res.ui.c) this.Oq).setBorderColor(i);
            }
            if (this.mBorderWidth > 0) {
                invalidate();
            }
        }
    }

    public void setBorderWidth(int i) {
        if (this.mBorderWidth != i) {
            this.mBorderWidth = i;
            if (this.mDrawable instanceof com.baidu.swan.apps.res.ui.c) {
                ((com.baidu.swan.apps.res.ui.c) this.mDrawable).setBorderWidth(i);
            }
            if (this.aYy && (this.Oq instanceof com.baidu.swan.apps.res.ui.c)) {
                ((com.baidu.swan.apps.res.ui.c) this.Oq).setBorderWidth(i);
            }
            invalidate();
        }
    }

    public void setRoundBackground(boolean z) {
        if (this.aYy != z) {
            this.aYy = z;
            if (z) {
                if (this.Oq instanceof com.baidu.swan.apps.res.ui.c) {
                    ((com.baidu.swan.apps.res.ui.c) this.Oq).setScaleType(this.Om);
                    ((com.baidu.swan.apps.res.ui.c) this.Oq).setCornerRadius(this.Oo);
                    ((com.baidu.swan.apps.res.ui.c) this.Oq).setBorderWidth(this.mBorderWidth);
                    ((com.baidu.swan.apps.res.ui.c) this.Oq).setBorderColor(this.mBorderColor);
                } else {
                    setBackgroundDrawable(this.Oq);
                }
            } else if (this.Oq instanceof com.baidu.swan.apps.res.ui.c) {
                ((com.baidu.swan.apps.res.ui.c) this.Oq).setBorderWidth(0);
                ((com.baidu.swan.apps.res.ui.c) this.Oq).setCornerRadius(0.0f);
            }
            invalidate();
        }
    }
}
