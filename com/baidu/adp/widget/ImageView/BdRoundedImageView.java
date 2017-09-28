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
    private static final ImageView.ScaleType[] GP = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private int BA;
    private boolean GK;
    private ColorStateList GM;
    private ImageView.ScaleType GN;
    private int GQ;
    private boolean GR;
    private Drawable GS;
    private Drawable GT;

    public BdRoundedImageView(Context context) {
        super(context);
        this.GQ = 0;
        this.BA = 0;
        this.GM = ColorStateList.valueOf(0);
        this.GR = false;
        this.GK = false;
    }

    public BdRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.GQ = 0;
        this.BA = 0;
        this.GM = ColorStateList.valueOf(0);
        this.GR = false;
        this.GK = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BdRoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.BdRoundedImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(GP[i2]);
        }
        this.GQ = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BdRoundedImageView_corner_radius, -1);
        this.BA = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BdRoundedImageView_border_width, -1);
        if (this.GQ < 0) {
            this.GQ = 0;
        }
        if (this.BA < 0) {
            this.BA = 0;
        }
        this.GM = obtainStyledAttributes.getColorStateList(R.styleable.BdRoundedImageView_border_color);
        if (this.GM == null) {
            this.GM = ColorStateList.valueOf(0);
        }
        this.GR = obtainStyledAttributes.getBoolean(R.styleable.BdRoundedImageView_round_background, false);
        this.GK = obtainStyledAttributes.getBoolean(R.styleable.BdRoundedImageView_is_oval, false);
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
        return this.GN;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            throw new NullPointerException();
        }
        if (this.GN != scaleType) {
            this.GN = scaleType;
            switch (AnonymousClass1.GO[scaleType.ordinal()]) {
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
        static final /* synthetic */ int[] GO = new int[ImageView.ScaleType.values().length];

        static {
            try {
                GO[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                GO[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                GO[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                GO[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                GO[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                GO[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                GO[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            this.GS = b.c(drawable);
            kW();
        } else {
            this.GS = null;
        }
        super.setImageDrawable(this.GS);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.GS = new b(bitmap);
            kW();
        } else {
            this.GS = null;
        }
        super.setImageDrawable(this.GS);
    }

    private void kW() {
        a(this.GS, false);
    }

    private void kX() {
        a(this.GT, true);
    }

    private void a(Drawable drawable, boolean z) {
        if (drawable != null) {
            if (drawable instanceof b) {
                ((b) drawable).b(this.GN).u((this.GR || !z) ? this.GQ : 0.0f).aK((this.GR || !z) ? this.BA : 0).a(this.GM).T(this.GK);
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
        this.GT = b.c(drawable);
        kX();
        super.setBackgroundDrawable(this.GT);
    }

    public int getCornerRadius() {
        return this.GQ;
    }

    public void setCornerRadius(int i) {
        if (this.GQ != i) {
            this.GQ = i;
            kW();
            kX();
        }
    }

    public int getBorderWidth() {
        return this.BA;
    }

    public void setBorderWidth(int i) {
        if (this.BA != i) {
            this.BA = i;
            kW();
            kX();
            invalidate();
        }
    }

    public int getBorderColor() {
        return this.GM.getDefaultColor();
    }

    public void setBorderColor(int i) {
        setBorderColors(ColorStateList.valueOf(i));
    }

    public ColorStateList getBorderColors() {
        return this.GM;
    }

    public void setBorderColors(ColorStateList colorStateList) {
        if (!this.GM.equals(colorStateList)) {
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(0);
            }
            this.GM = colorStateList;
            kW();
            kX();
            if (this.BA > 0) {
                invalidate();
            }
        }
    }

    public void setOval(boolean z) {
        this.GK = z;
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
        if (this.GR != z) {
            this.GR = z;
            kX();
            invalidate();
        }
    }
}
