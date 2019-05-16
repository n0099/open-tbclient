package com.baidu.swan.apps.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.swan.apps.a;
/* loaded from: classes2.dex */
public class SwanAppRoundedImageView extends ImageView {
    private static final ImageView.ScaleType[] bbq = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private ImageView.ScaleType LX;
    private int LZ;
    private Drawable Mb;
    private boolean bbr;
    private int mBorderColor;
    private int mBorderWidth;
    private Drawable mDrawable;

    public SwanAppRoundedImageView(Context context) {
        super(context);
        this.LZ = 20;
        this.mBorderWidth = 2;
        this.mBorderColor = ViewCompat.MEASURED_STATE_MASK;
    }

    public SwanAppRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwanAppRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.RoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(a.j.RoundedImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(bbq[i2]);
        }
        this.LZ = obtainStyledAttributes.getDimensionPixelSize(a.j.RoundedImageView_corner_radius, -1);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(a.j.RoundedImageView_border_width, -1);
        if (this.LZ < 0) {
            this.LZ = 20;
        }
        if (this.mBorderWidth < 0) {
            this.mBorderWidth = 2;
        }
        this.mBorderColor = obtainStyledAttributes.getColor(a.j.RoundedImageView_border_color, ViewCompat.MEASURED_STATE_MASK);
        this.bbr = obtainStyledAttributes.getBoolean(a.j.RoundedImageView_round_background, false);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.LX;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            throw new NullPointerException();
        }
        if (this.LX != scaleType) {
            this.LX = scaleType;
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
            if ((this.Mb instanceof com.baidu.swan.apps.res.ui.c) && ((com.baidu.swan.apps.res.ui.c) this.Mb).getScaleType() != scaleType) {
                ((com.baidu.swan.apps.res.ui.c) this.Mb).setScaleType(scaleType);
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
            this.mDrawable = com.baidu.swan.apps.res.ui.c.a(drawable, this.LX, this.LZ, this.mBorderWidth, this.mBorderColor);
        } else {
            this.mDrawable = null;
        }
        super.setImageDrawable(this.mDrawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.mDrawable = new com.baidu.swan.apps.res.ui.c(bitmap, this.LZ, this.mBorderWidth, this.mBorderColor);
            if (this.LX != null) {
                ((com.baidu.swan.apps.res.ui.c) this.mDrawable).setScaleType(this.LX);
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
        if (this.bbr && drawable != null) {
            this.Mb = com.baidu.swan.apps.res.ui.c.a(drawable, this.LX, this.LZ, this.mBorderWidth, this.mBorderColor);
        } else {
            this.Mb = drawable;
        }
        super.setBackgroundDrawable(this.Mb);
    }

    public int getCornerRadius() {
        return this.LZ;
    }

    public void setCornerRadius(int i) {
        if (this.LZ != i) {
            this.LZ = i;
            if (this.mDrawable instanceof com.baidu.swan.apps.res.ui.c) {
                ((com.baidu.swan.apps.res.ui.c) this.mDrawable).setCornerRadius(i);
            }
            if (this.bbr && (this.Mb instanceof com.baidu.swan.apps.res.ui.c)) {
                ((com.baidu.swan.apps.res.ui.c) this.Mb).setCornerRadius(i);
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
            if (this.bbr && (this.Mb instanceof com.baidu.swan.apps.res.ui.c)) {
                ((com.baidu.swan.apps.res.ui.c) this.Mb).setBorderColor(i);
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
            if (this.bbr && (this.Mb instanceof com.baidu.swan.apps.res.ui.c)) {
                ((com.baidu.swan.apps.res.ui.c) this.Mb).setBorderWidth(i);
            }
            invalidate();
        }
    }

    public void setRoundBackground(boolean z) {
        if (this.bbr != z) {
            this.bbr = z;
            if (z) {
                if (this.Mb instanceof com.baidu.swan.apps.res.ui.c) {
                    ((com.baidu.swan.apps.res.ui.c) this.Mb).setScaleType(this.LX);
                    ((com.baidu.swan.apps.res.ui.c) this.Mb).setCornerRadius(this.LZ);
                    ((com.baidu.swan.apps.res.ui.c) this.Mb).setBorderWidth(this.mBorderWidth);
                    ((com.baidu.swan.apps.res.ui.c) this.Mb).setBorderColor(this.mBorderColor);
                } else {
                    setBackgroundDrawable(this.Mb);
                }
            } else if (this.Mb instanceof com.baidu.swan.apps.res.ui.c) {
                ((com.baidu.swan.apps.res.ui.c) this.Mb).setBorderWidth(0);
                ((com.baidu.swan.apps.res.ui.c) this.Mb).setCornerRadius(0.0f);
            }
            invalidate();
        }
    }
}
