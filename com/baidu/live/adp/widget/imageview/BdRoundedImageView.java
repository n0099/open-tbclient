package com.baidu.live.adp.widget.imageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.live.adp.R;
/* loaded from: classes10.dex */
public class BdRoundedImageView extends ImageView {
    public static final int DEFAULT_BORDER_WIDTH = 0;
    public static final int DEFAULT_RADIUS = 0;
    public static final String TAG = "BdRoundedImageView";
    private static final ImageView.ScaleType[] sScaleTypeArray = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private Drawable mBackgroundDrawable;
    private ColorStateList mBorderColor;
    private int mBorderWidth;
    private int mCornerRadius;
    private Drawable mDrawable;
    private boolean mOval;
    private boolean mRoundBackground;
    private ImageView.ScaleType mScaleType;

    public BdRoundedImageView(Context context) {
        super(context);
        this.mCornerRadius = 0;
        this.mBorderWidth = 0;
        this.mBorderColor = ColorStateList.valueOf(0);
        this.mRoundBackground = false;
        this.mOval = false;
    }

    public BdRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCornerRadius = 0;
        this.mBorderWidth = 0;
        this.mBorderColor = ColorStateList.valueOf(0);
        this.mRoundBackground = false;
        this.mOval = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.sdk_BdRoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.sdk_BdRoundedImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(sScaleTypeArray[i2]);
        }
        this.mCornerRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.sdk_BdRoundedImageView_corner_radius, -1);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.sdk_BdRoundedImageView_border_width, -1);
        if (this.mCornerRadius < 0) {
            this.mCornerRadius = 0;
        }
        if (this.mBorderWidth < 0) {
            this.mBorderWidth = 0;
        }
        this.mBorderColor = obtainStyledAttributes.getColorStateList(R.styleable.sdk_BdRoundedImageView_border_color);
        if (this.mBorderColor == null) {
            this.mBorderColor = ColorStateList.valueOf(0);
        }
        this.mRoundBackground = obtainStyledAttributes.getBoolean(R.styleable.sdk_BdRoundedImageView_round_background, false);
        this.mOval = obtainStyledAttributes.getBoolean(R.styleable.sdk_BdRoundedImageView_is_oval, false);
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs();
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
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
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.live.adp.widget.imageview.BdRoundedImageView$1  reason: invalid class name */
    /* loaded from: classes10.dex */
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
            this.mDrawable = BdRoundedDrawable.fromDrawable(drawable);
            updateDrawableAttrs();
        } else {
            this.mDrawable = null;
        }
        super.setImageDrawable(this.mDrawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mDrawable = new BdRoundedDrawable(bitmap);
            updateDrawableAttrs();
        } else {
            this.mDrawable = null;
        }
        super.setImageDrawable(this.mDrawable);
    }

    private void updateDrawableAttrs() {
        updateAttrs(this.mDrawable, false);
    }

    private void updateBackgroundDrawableAttrs() {
        updateAttrs(this.mBackgroundDrawable, true);
    }

    private void updateAttrs(Drawable drawable, boolean z) {
        if (drawable != null) {
            if (drawable instanceof BdRoundedDrawable) {
                ((BdRoundedDrawable) drawable).setScaleType(this.mScaleType).setCornerRadius((this.mRoundBackground || !z) ? this.mCornerRadius : 0.0f).setBorderWidth((this.mRoundBackground || !z) ? this.mBorderWidth : 0).setBorderColors(this.mBorderColor).setOval(this.mOval);
            } else if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    updateAttrs(layerDrawable.getDrawable(i), z);
                }
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        this.mBackgroundDrawable = BdRoundedDrawable.fromDrawable(drawable);
        updateBackgroundDrawableAttrs();
        super.setBackgroundDrawable(this.mBackgroundDrawable);
    }

    public int getCornerRadius() {
        return this.mCornerRadius;
    }

    public void setCornerRadius(int i) {
        if (this.mCornerRadius != i) {
            this.mCornerRadius = i;
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs();
        }
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public void setBorderWidth(int i) {
        if (this.mBorderWidth != i) {
            this.mBorderWidth = i;
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs();
            invalidate();
        }
    }

    public int getBorderColor() {
        return this.mBorderColor.getDefaultColor();
    }

    public void setBorderColor(int i) {
        setBorderColors(ColorStateList.valueOf(i));
    }

    public ColorStateList getBorderColors() {
        return this.mBorderColor;
    }

    public void setBorderColors(ColorStateList colorStateList) {
        if (!this.mBorderColor.equals(colorStateList)) {
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(0);
            }
            this.mBorderColor = colorStateList;
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs();
            if (this.mBorderWidth > 0) {
                invalidate();
            }
        }
    }

    public boolean isOval() {
        return this.mOval;
    }

    public void setOval(boolean z) {
        this.mOval = z;
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        setImageDrawable(getDrawable());
    }

    public boolean isRoundBackground() {
        return this.mRoundBackground;
    }

    public void setRoundBackground(boolean z) {
        if (this.mRoundBackground != z) {
            this.mRoundBackground = z;
            updateBackgroundDrawableAttrs();
            invalidate();
        }
    }
}
