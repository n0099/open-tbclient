package com.baidu.searchbox.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class RoundedImageView extends BdBaseImageView {
    public static final int DEFAULT_BORDER = 2;
    public static final int DEFAULT_BORDER_COLOR = -16777216;
    public static final int DEFAULT_RADIUS = 20;
    public static final ImageView.ScaleType[] SCALE_TYPE_ARRAY = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public static final String TAG = "RoundedImageView";
    public Drawable mBackgroundDrawable;
    public int mBorderColor;
    public int mBorderWidth;
    public int mCornerRadius;
    public Drawable mDrawable;
    public ImageView.ScaleType mScaleType;
    public boolean roundBackground;

    /* renamed from: com.baidu.searchbox.ui.RoundedImageView$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public int getBorder() {
        return this.mBorderWidth;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getCornerRadius() {
        return this.mCornerRadius;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public boolean isRoundBackground() {
        return this.roundBackground;
    }

    public RoundedImageView(Context context) {
        super(context);
        this.mCornerRadius = 20;
        this.mBorderWidth = 2;
        this.mBorderColor = -16777216;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.roundBackground && drawable != null) {
            this.mBackgroundDrawable = RoundedDrawable.fromDrawable(drawable, this.mScaleType, this.mCornerRadius, this.mBorderWidth, this.mBorderColor);
        } else {
            this.mBackgroundDrawable = drawable;
        }
        super.setBackgroundDrawable(this.mBackgroundDrawable);
    }

    public void setBorderColor(int i) {
        if (this.mBorderColor == i) {
            return;
        }
        this.mBorderColor = i;
        Drawable drawable = this.mDrawable;
        if (drawable instanceof RoundedDrawable) {
            ((RoundedDrawable) drawable).setBorderColor(i);
        }
        if (this.roundBackground) {
            Drawable drawable2 = this.mBackgroundDrawable;
            if (drawable2 instanceof RoundedDrawable) {
                ((RoundedDrawable) drawable2).setBorderColor(i);
            }
        }
        if (this.mBorderWidth > 0) {
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.mBorderWidth == i) {
            return;
        }
        this.mBorderWidth = i;
        Drawable drawable = this.mDrawable;
        if (drawable instanceof RoundedDrawable) {
            ((RoundedDrawable) drawable).setBorderWidth(i);
        }
        if (this.roundBackground) {
            Drawable drawable2 = this.mBackgroundDrawable;
            if (drawable2 instanceof RoundedDrawable) {
                ((RoundedDrawable) drawable2).setBorderWidth(i);
            }
        }
        invalidate();
    }

    public void setCornerRadius(int i) {
        if (this.mCornerRadius == i) {
            return;
        }
        this.mCornerRadius = i;
        Drawable drawable = this.mDrawable;
        if (drawable instanceof RoundedDrawable) {
            ((RoundedDrawable) drawable).setCornerRadius(i);
        }
        if (this.roundBackground) {
            Drawable drawable2 = this.mBackgroundDrawable;
            if (drawable2 instanceof RoundedDrawable) {
                ((RoundedDrawable) drawable2).setCornerRadius(i);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            RoundedDrawable roundedDrawable = new RoundedDrawable(bitmap, this.mCornerRadius, this.mBorderWidth, this.mBorderColor);
            this.mDrawable = roundedDrawable;
            ImageView.ScaleType scaleType = this.mScaleType;
            if (scaleType != null) {
                roundedDrawable.setScaleType(scaleType);
            }
        } else {
            this.mDrawable = null;
        }
        super.setImageDrawable(this.mDrawable);
    }

    @Override // com.baidu.searchbox.ui.BdBaseImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            this.mDrawable = RoundedDrawable.fromDrawable(drawable, this.mScaleType, this.mCornerRadius, this.mBorderWidth, this.mBorderColor);
        } else {
            this.mDrawable = null;
        }
        super.setImageDrawable(this.mDrawable);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.searchbox.common.res.R.styleable.RoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(0, -1);
        if (i2 >= 0) {
            setScaleType(SCALE_TYPE_ARRAY[i2]);
        }
        this.mCornerRadius = obtainStyledAttributes.getDimensionPixelSize(3, -1);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(2, -1);
        if (this.mCornerRadius < 0) {
            this.mCornerRadius = 20;
        }
        if (this.mBorderWidth < 0) {
            this.mBorderWidth = 2;
        }
        this.mBorderColor = obtainStyledAttributes.getColor(1, -16777216);
        this.roundBackground = obtainStyledAttributes.getBoolean(4, false);
        obtainStyledAttributes.recycle();
    }

    public void setRoundBackground(boolean z) {
        if (this.roundBackground == z) {
            return;
        }
        this.roundBackground = z;
        if (z) {
            Drawable drawable = this.mBackgroundDrawable;
            if (drawable instanceof RoundedDrawable) {
                ((RoundedDrawable) drawable).setScaleType(this.mScaleType);
                ((RoundedDrawable) this.mBackgroundDrawable).setCornerRadius(this.mCornerRadius);
                ((RoundedDrawable) this.mBackgroundDrawable).setBorderWidth(this.mBorderWidth);
                ((RoundedDrawable) this.mBackgroundDrawable).setBorderColor(this.mBorderColor);
            } else {
                setBackgroundDrawable(drawable);
            }
        } else {
            Drawable drawable2 = this.mBackgroundDrawable;
            if (drawable2 instanceof RoundedDrawable) {
                ((RoundedDrawable) drawable2).setBorderWidth(0);
                ((RoundedDrawable) this.mBackgroundDrawable).setCornerRadius(0.0f);
            }
        }
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != null && this.mScaleType != scaleType) {
            this.mScaleType = scaleType;
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
            Drawable drawable = this.mDrawable;
            if ((drawable instanceof RoundedDrawable) && ((RoundedDrawable) drawable).getScaleType() != scaleType) {
                ((RoundedDrawable) this.mDrawable).setScaleType(scaleType);
            }
            Drawable drawable2 = this.mBackgroundDrawable;
            if ((drawable2 instanceof RoundedDrawable) && ((RoundedDrawable) drawable2).getScaleType() != scaleType) {
                ((RoundedDrawable) this.mBackgroundDrawable).setScaleType(scaleType);
            }
            setWillNotCacheDrawing(true);
            requestLayout();
            invalidate();
        }
    }
}
