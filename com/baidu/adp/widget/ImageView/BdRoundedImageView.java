package com.baidu.adp.widget.ImageView;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class BdRoundedImageView extends ImageView {
    private static final ImageView.ScaleType[] NM = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private boolean NK;
    private ColorStateList NL;
    private boolean NN;
    private Drawable mBackgroundDrawable;
    private int mBorderWidth;
    private int mCornerRadius;
    private Drawable mDrawable;
    private ImageView.ScaleType mScaleType;

    public BdRoundedImageView(Context context) {
        super(context);
        this.mCornerRadius = 0;
        this.mBorderWidth = 0;
        this.NL = ColorStateList.valueOf(0);
        this.NN = false;
        this.NK = false;
    }

    public BdRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCornerRadius = 0;
        this.mBorderWidth = 0;
        this.NL = ColorStateList.valueOf(0);
        this.NN = false;
        this.NK = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BdRoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.BdRoundedImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(NM[i2]);
        }
        this.mCornerRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BdRoundedImageView_corner_radius, -1);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BdRoundedImageView_border_width, -1);
        if (this.mCornerRadius < 0) {
            this.mCornerRadius = 0;
        }
        if (this.mBorderWidth < 0) {
            this.mBorderWidth = 0;
        }
        this.NL = obtainStyledAttributes.getColorStateList(R.styleable.BdRoundedImageView_border_color);
        if (this.NL == null) {
            this.NL = ColorStateList.valueOf(0);
        }
        this.NN = obtainStyledAttributes.getBoolean(R.styleable.BdRoundedImageView_round_background, false);
        this.NK = obtainStyledAttributes.getBoolean(R.styleable.BdRoundedImageView_is_oval, false);
        oA();
        oB();
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
            oA();
            oB();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.adp.widget.ImageView.BdRoundedImageView$1  reason: invalid class name */
    /* loaded from: classes.dex */
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
            this.mDrawable = b.b(drawable);
            oA();
        } else {
            this.mDrawable = null;
        }
        super.setImageDrawable(this.mDrawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mDrawable = new b(bitmap);
            oA();
        } else {
            this.mDrawable = null;
        }
        super.setImageDrawable(this.mDrawable);
    }

    private void oA() {
        a(this.mDrawable, false);
    }

    private void oB() {
        a(this.mBackgroundDrawable, true);
    }

    private void a(Drawable drawable, boolean z) {
        if (drawable != null) {
            if (drawable instanceof b) {
                ((b) drawable).b(this.mScaleType).L((this.NN || !z) ? this.mCornerRadius : 0.0f).aP((this.NN || !z) ? this.mBorderWidth : 0).a(this.NL).ag(this.NK);
            } else if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    a(layerDrawable.getDrawable(i), z);
                }
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        this.mBackgroundDrawable = b.b(drawable);
        oB();
        super.setBackgroundDrawable(this.mBackgroundDrawable);
    }

    public int getCornerRadius() {
        return this.mCornerRadius;
    }

    public void setCornerRadius(int i) {
        if (this.mCornerRadius != i) {
            this.mCornerRadius = i;
            oA();
            oB();
        }
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public void setBorderWidth(int i) {
        if (this.mBorderWidth != i) {
            this.mBorderWidth = i;
            oA();
            oB();
            invalidate();
        }
    }

    public int getBorderColor() {
        return this.NL.getDefaultColor();
    }

    public void setBorderColor(int i) {
        setBorderColors(ColorStateList.valueOf(i));
    }

    public ColorStateList getBorderColors() {
        return this.NL;
    }

    public void setBorderColors(ColorStateList colorStateList) {
        if (!this.NL.equals(colorStateList)) {
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(0);
            }
            this.NL = colorStateList;
            oA();
            oB();
            if (this.mBorderWidth > 0) {
                invalidate();
            }
        }
    }

    public void setOval(boolean z) {
        this.NK = z;
        oA();
        oB();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        setImageDrawable(getDrawable());
    }

    public void setRoundBackground(boolean z) {
        if (this.NN != z) {
            this.NN = z;
            oB();
            invalidate();
        }
    }
}
