package com.baidu.searchbox.ng.ai.apps.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.ui.RoundedDrawable;
/* loaded from: classes2.dex */
public class AiAppsRoundedImageView extends ImageView {
    public static final int DEFAULT_BORDER = 2;
    public static final int DEFAULT_BORDER_COLOR = -16777216;
    public static final int DEFAULT_RADIUS = 20;
    private static final ImageView.ScaleType[] SCALE_TYPE_ARRAY = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public static final String TAG = "AiAppsRoundedImageView";
    private Drawable mBackgroundDrawable;
    private int mBorderColor;
    private int mBorderWidth;
    private int mCornerRadius;
    private Drawable mDrawable;
    private ImageView.ScaleType mScaleType;
    private boolean roundBackground;

    public AiAppsRoundedImageView(Context context) {
        super(context);
        this.mCornerRadius = 20;
        this.mBorderWidth = 2;
        this.mBorderColor = -16777216;
    }

    public AiAppsRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AiAppsRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.RoundedImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(SCALE_TYPE_ARRAY[i2]);
        }
        this.mCornerRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_corner_radius, -1);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_border_width, -1);
        if (this.mCornerRadius < 0) {
            this.mCornerRadius = 20;
        }
        if (this.mBorderWidth < 0) {
            this.mBorderWidth = 2;
        }
        this.mBorderColor = obtainStyledAttributes.getColor(R.styleable.RoundedImageView_border_color, -16777216);
        this.roundBackground = obtainStyledAttributes.getBoolean(R.styleable.RoundedImageView_round_background, false);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            throw new NullPointerException();
        }
        if (this.mScaleType != scaleType) {
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
            if ((this.mDrawable instanceof RoundedDrawable) && ((RoundedDrawable) this.mDrawable).getScaleType() != scaleType) {
                ((RoundedDrawable) this.mDrawable).setScaleType(scaleType);
            }
            if ((this.mBackgroundDrawable instanceof RoundedDrawable) && ((RoundedDrawable) this.mBackgroundDrawable).getScaleType() != scaleType) {
                ((RoundedDrawable) this.mBackgroundDrawable).setScaleType(scaleType);
            }
            setWillNotCacheDrawing(true);
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.searchbox.ng.ai.apps.view.AiAppsRoundedImageView$1  reason: invalid class name */
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
            this.mDrawable = RoundedDrawable.fromDrawable(drawable, this.mScaleType, this.mCornerRadius, this.mBorderWidth, this.mBorderColor);
        } else {
            this.mDrawable = null;
        }
        super.setImageDrawable(this.mDrawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.mDrawable = new RoundedDrawable(bitmap, this.mCornerRadius, this.mBorderWidth, this.mBorderColor);
            if (this.mScaleType != null) {
                ((RoundedDrawable) this.mDrawable).setScaleType(this.mScaleType);
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
        if (this.roundBackground && drawable != null) {
            this.mBackgroundDrawable = RoundedDrawable.fromDrawable(drawable, this.mScaleType, this.mCornerRadius, this.mBorderWidth, this.mBorderColor);
        } else {
            this.mBackgroundDrawable = drawable;
        }
        super.setBackgroundDrawable(this.mBackgroundDrawable);
    }

    public int getCornerRadius() {
        return this.mCornerRadius;
    }

    public void setCornerRadius(int i) {
        if (this.mCornerRadius != i) {
            this.mCornerRadius = i;
            if (this.mDrawable instanceof RoundedDrawable) {
                ((RoundedDrawable) this.mDrawable).setCornerRadius(i);
            }
            if (this.roundBackground && (this.mBackgroundDrawable instanceof RoundedDrawable)) {
                ((RoundedDrawable) this.mBackgroundDrawable).setCornerRadius(i);
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
            if (this.mDrawable instanceof RoundedDrawable) {
                ((RoundedDrawable) this.mDrawable).setBorderColor(i);
            }
            if (this.roundBackground && (this.mBackgroundDrawable instanceof RoundedDrawable)) {
                ((RoundedDrawable) this.mBackgroundDrawable).setBorderColor(i);
            }
            if (this.mBorderWidth > 0) {
                invalidate();
            }
        }
    }

    public void setBorderWidth(int i) {
        if (this.mBorderWidth != i) {
            this.mBorderWidth = i;
            if (this.mDrawable instanceof RoundedDrawable) {
                ((RoundedDrawable) this.mDrawable).setBorderWidth(i);
            }
            if (this.roundBackground && (this.mBackgroundDrawable instanceof RoundedDrawable)) {
                ((RoundedDrawable) this.mBackgroundDrawable).setBorderWidth(i);
            }
            invalidate();
        }
    }

    public boolean isRoundBackground() {
        return this.roundBackground;
    }

    public void setRoundBackground(boolean z) {
        if (this.roundBackground != z) {
            this.roundBackground = z;
            if (z) {
                if (this.mBackgroundDrawable instanceof RoundedDrawable) {
                    ((RoundedDrawable) this.mBackgroundDrawable).setScaleType(this.mScaleType);
                    ((RoundedDrawable) this.mBackgroundDrawable).setCornerRadius(this.mCornerRadius);
                    ((RoundedDrawable) this.mBackgroundDrawable).setBorderWidth(this.mBorderWidth);
                    ((RoundedDrawable) this.mBackgroundDrawable).setBorderColor(this.mBorderColor);
                } else {
                    setBackgroundDrawable(this.mBackgroundDrawable);
                }
            } else if (this.mBackgroundDrawable instanceof RoundedDrawable) {
                ((RoundedDrawable) this.mBackgroundDrawable).setBorderWidth(0);
                ((RoundedDrawable) this.mBackgroundDrawable).setCornerRadius(0.0f);
            }
            invalidate();
        }
    }
}
