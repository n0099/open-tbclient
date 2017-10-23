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
    private static final ImageView.ScaleType[] GQ = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private int BB;
    private boolean GL;
    private ColorStateList GN;
    private ImageView.ScaleType GO;
    private int GR;
    private boolean GS;
    private Drawable GT;
    private Drawable GU;

    public BdRoundedImageView(Context context) {
        super(context);
        this.GR = 0;
        this.BB = 0;
        this.GN = ColorStateList.valueOf(0);
        this.GS = false;
        this.GL = false;
    }

    public BdRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.GR = 0;
        this.BB = 0;
        this.GN = ColorStateList.valueOf(0);
        this.GS = false;
        this.GL = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BdRoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.BdRoundedImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(GQ[i2]);
        }
        this.GR = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BdRoundedImageView_corner_radius, -1);
        this.BB = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BdRoundedImageView_border_width, -1);
        if (this.GR < 0) {
            this.GR = 0;
        }
        if (this.BB < 0) {
            this.BB = 0;
        }
        this.GN = obtainStyledAttributes.getColorStateList(R.styleable.BdRoundedImageView_border_color);
        if (this.GN == null) {
            this.GN = ColorStateList.valueOf(0);
        }
        this.GS = obtainStyledAttributes.getBoolean(R.styleable.BdRoundedImageView_round_background, false);
        this.GL = obtainStyledAttributes.getBoolean(R.styleable.BdRoundedImageView_is_oval, false);
        kW();
        kX();
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.GO;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            throw new NullPointerException();
        }
        if (this.GO != scaleType) {
            this.GO = scaleType;
            switch (AnonymousClass1.GP[scaleType.ordinal()]) {
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
            kW();
            kX();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.adp.widget.ImageView.BdRoundedImageView$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] GP = new int[ImageView.ScaleType.values().length];

        static {
            try {
                GP[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                GP[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                GP[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                GP[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                GP[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                GP[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                GP[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            this.GT = b.c(drawable);
            kW();
        } else {
            this.GT = null;
        }
        super.setImageDrawable(this.GT);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.GT = new b(bitmap);
            kW();
        } else {
            this.GT = null;
        }
        super.setImageDrawable(this.GT);
    }

    private void kW() {
        a(this.GT, false);
    }

    private void kX() {
        a(this.GU, true);
    }

    private void a(Drawable drawable, boolean z) {
        if (drawable != null) {
            if (drawable instanceof b) {
                ((b) drawable).b(this.GO).u((this.GS || !z) ? this.GR : 0.0f).aK((this.GS || !z) ? this.BB : 0).a(this.GN).T(this.GL);
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
        this.GU = b.c(drawable);
        kX();
        super.setBackgroundDrawable(this.GU);
    }

    public int getCornerRadius() {
        return this.GR;
    }

    public void setCornerRadius(int i) {
        if (this.GR != i) {
            this.GR = i;
            kW();
            kX();
        }
    }

    public int getBorderWidth() {
        return this.BB;
    }

    public void setBorderWidth(int i) {
        if (this.BB != i) {
            this.BB = i;
            kW();
            kX();
            invalidate();
        }
    }

    public int getBorderColor() {
        return this.GN.getDefaultColor();
    }

    public void setBorderColor(int i) {
        setBorderColors(ColorStateList.valueOf(i));
    }

    public ColorStateList getBorderColors() {
        return this.GN;
    }

    public void setBorderColors(ColorStateList colorStateList) {
        if (!this.GN.equals(colorStateList)) {
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(0);
            }
            this.GN = colorStateList;
            kW();
            kX();
            if (this.BB > 0) {
                invalidate();
            }
        }
    }

    public void setOval(boolean z) {
        this.GL = z;
        kW();
        kX();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        setImageDrawable(getDrawable());
    }

    public void setRoundBackground(boolean z) {
        if (this.GS != z) {
            this.GS = z;
            kX();
            invalidate();
        }
    }
}
