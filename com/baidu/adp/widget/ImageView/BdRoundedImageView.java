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
    private static final ImageView.ScaleType[] KU = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private boolean KR;
    private ColorStateList KS;
    private ImageView.ScaleType KT;
    private int KV;
    private boolean KW;
    private Drawable KX;
    private int mBorderWidth;
    private Drawable mDrawable;

    public BdRoundedImageView(Context context) {
        super(context);
        this.KV = 0;
        this.mBorderWidth = 0;
        this.KS = ColorStateList.valueOf(0);
        this.KW = false;
        this.KR = false;
    }

    public BdRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.KV = 0;
        this.mBorderWidth = 0;
        this.KS = ColorStateList.valueOf(0);
        this.KW = false;
        this.KR = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BdRoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.BdRoundedImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(KU[i2]);
        }
        this.KV = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BdRoundedImageView_corner_radius, -1);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BdRoundedImageView_border_width, -1);
        if (this.KV < 0) {
            this.KV = 0;
        }
        if (this.mBorderWidth < 0) {
            this.mBorderWidth = 0;
        }
        this.KS = obtainStyledAttributes.getColorStateList(R.styleable.BdRoundedImageView_border_color);
        if (this.KS == null) {
            this.KS = ColorStateList.valueOf(0);
        }
        this.KW = obtainStyledAttributes.getBoolean(R.styleable.BdRoundedImageView_round_background, false);
        this.KR = obtainStyledAttributes.getBoolean(R.styleable.BdRoundedImageView_is_oval, false);
        nh();
        ni();
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.KT;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            throw new NullPointerException();
        }
        if (this.KT != scaleType) {
            this.KT = scaleType;
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
            nh();
            ni();
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
            this.mDrawable = b.c(drawable);
            nh();
        } else {
            this.mDrawable = null;
        }
        super.setImageDrawable(this.mDrawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mDrawable = new b(bitmap);
            nh();
        } else {
            this.mDrawable = null;
        }
        super.setImageDrawable(this.mDrawable);
    }

    private void nh() {
        a(this.mDrawable, false);
    }

    private void ni() {
        a(this.KX, true);
    }

    private void a(Drawable drawable, boolean z) {
        if (drawable != null) {
            if (drawable instanceof b) {
                ((b) drawable).c(this.KT).L((this.KW || !z) ? this.KV : 0.0f).aE((this.KW || !z) ? this.mBorderWidth : 0).b(this.KS).Y(this.KR);
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
        this.KX = b.c(drawable);
        ni();
        super.setBackgroundDrawable(this.KX);
    }

    public int getCornerRadius() {
        return this.KV;
    }

    public void setCornerRadius(int i) {
        if (this.KV != i) {
            this.KV = i;
            nh();
            ni();
        }
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public void setBorderWidth(int i) {
        if (this.mBorderWidth != i) {
            this.mBorderWidth = i;
            nh();
            ni();
            invalidate();
        }
    }

    public int getBorderColor() {
        return this.KS.getDefaultColor();
    }

    public void setBorderColor(int i) {
        setBorderColors(ColorStateList.valueOf(i));
    }

    public ColorStateList getBorderColors() {
        return this.KS;
    }

    public void setBorderColors(ColorStateList colorStateList) {
        if (!this.KS.equals(colorStateList)) {
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(0);
            }
            this.KS = colorStateList;
            nh();
            ni();
            if (this.mBorderWidth > 0) {
                invalidate();
            }
        }
    }

    public void setOval(boolean z) {
        this.KR = z;
        nh();
        ni();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        setImageDrawable(getDrawable());
    }

    public void setRoundBackground(boolean z) {
        if (this.KW != z) {
            this.KW = z;
            ni();
            invalidate();
        }
    }
}
