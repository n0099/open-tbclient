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
import d.b.c.j.d.b;
/* loaded from: classes.dex */
public class BdRoundedImageView extends ImageView {
    public static final ImageView.ScaleType[] m = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: e  reason: collision with root package name */
    public int f2310e;

    /* renamed from: f  reason: collision with root package name */
    public int f2311f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f2312g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2313h;
    public boolean i;
    public Drawable j;
    public Drawable k;
    public ImageView.ScaleType l;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2314a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f2314a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2314a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2314a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2314a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2314a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2314a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2314a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public BdRoundedImageView(Context context) {
        super(context);
        this.f2310e = 0;
        this.f2311f = 0;
        this.f2312g = ColorStateList.valueOf(0);
        this.f2313h = false;
        this.i = false;
    }

    public final void a(Drawable drawable, boolean z) {
        if (drawable == null) {
            return;
        }
        int i = 0;
        if (drawable instanceof b) {
            b bVar = (b) drawable;
            bVar.g(this.l);
            bVar.e((this.f2313h || !z) ? this.f2310e : 0.0f);
            if (this.f2313h || !z) {
                i = this.f2311f;
            }
            bVar.d(i);
            bVar.c(this.f2312g);
            bVar.f(this.i);
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            while (i < numberOfLayers) {
                a(layerDrawable.getDrawable(i), z);
                i++;
            }
        }
    }

    public final void b() {
        a(this.k, true);
    }

    public final void c() {
        a(this.j, false);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor() {
        return this.f2312g.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.f2312g;
    }

    public int getBorderWidth() {
        return this.f2311f;
    }

    public int getCornerRadius() {
        return this.f2310e;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.l;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        this.k = b.b(drawable);
        b();
        super.setBackgroundDrawable(this.k);
    }

    public void setBorderColor(int i) {
        setBorderColors(ColorStateList.valueOf(i));
    }

    public void setBorderColors(ColorStateList colorStateList) {
        if (this.f2312g.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f2312g = colorStateList;
        c();
        b();
        if (this.f2311f > 0) {
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.f2311f == i) {
            return;
        }
        this.f2311f = i;
        c();
        b();
        invalidate();
    }

    public void setCornerRadius(int i) {
        if (this.f2310e == i) {
            return;
        }
        this.f2310e = i;
        c();
        b();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.j = new b(bitmap);
            c();
        } else {
            this.j = null;
        }
        super.setImageDrawable(this.j);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            this.j = b.b(drawable);
            c();
        } else {
            this.j = null;
        }
        super.setImageDrawable(this.j);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z) {
        this.i = z;
        c();
        b();
        invalidate();
    }

    public void setRoundBackground(boolean z) {
        if (this.f2313h == z) {
            return;
        }
        this.f2313h = z;
        b();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            if (this.l != scaleType) {
                this.l = scaleType;
                switch (a.f2314a[scaleType.ordinal()]) {
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
                c();
                b();
                invalidate();
                return;
            }
            return;
        }
        throw null;
    }

    public BdRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2310e = 0;
        this.f2311f = 0;
        this.f2312g = ColorStateList.valueOf(0);
        this.f2313h = false;
        this.i = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BdRoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.BdRoundedImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(m[i2]);
        }
        this.f2310e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BdRoundedImageView_corner_radius, -1);
        this.f2311f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BdRoundedImageView_border_width, -1);
        if (this.f2310e < 0) {
            this.f2310e = 0;
        }
        if (this.f2311f < 0) {
            this.f2311f = 0;
        }
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.BdRoundedImageView_border_color);
        this.f2312g = colorStateList;
        if (colorStateList == null) {
            this.f2312g = ColorStateList.valueOf(0);
        }
        this.f2313h = obtainStyledAttributes.getBoolean(R.styleable.BdRoundedImageView_round_background, false);
        this.i = obtainStyledAttributes.getBoolean(R.styleable.BdRoundedImageView_is_oval, false);
        c();
        b();
        obtainStyledAttributes.recycle();
    }
}
