package com.baidu.swan.apps.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import d.a.m0.a.j;
import d.a.m0.a.z1.a.b;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class SwanAppRoundedImageView extends ImageView {
    public static final ImageView.ScaleType[] l = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: e  reason: collision with root package name */
    public int f11498e;

    /* renamed from: f  reason: collision with root package name */
    public int f11499f;

    /* renamed from: g  reason: collision with root package name */
    public int f11500g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11501h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f11502i;
    public Drawable j;
    public ImageView.ScaleType k;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11503a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f11503a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11503a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11503a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11503a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11503a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11503a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11503a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public SwanAppRoundedImageView(Context context) {
        super(context);
        this.f11498e = 20;
        this.f11499f = 2;
        this.f11500g = -16777216;
    }

    public int getBorder() {
        return this.f11499f;
    }

    public int getBorderColor() {
        return this.f11500g;
    }

    public int getCornerRadius() {
        return this.f11498e;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.k;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f11501h && drawable != null) {
            this.j = b.b(drawable, this.k, this.f11498e, this.f11499f, this.f11500g);
        } else {
            this.j = drawable;
        }
        super.setBackgroundDrawable(this.j);
    }

    public void setBorderColor(int i2) {
        if (this.f11500g == i2) {
            return;
        }
        this.f11500g = i2;
        Drawable drawable = this.f11502i;
        if (drawable instanceof b) {
            ((b) drawable).d(i2);
        }
        if (this.f11501h) {
            Drawable drawable2 = this.j;
            if (drawable2 instanceof b) {
                ((b) drawable2).d(i2);
            }
        }
        if (this.f11499f > 0) {
            invalidate();
        }
    }

    public void setBorderWidth(int i2) {
        if (this.f11499f == i2) {
            return;
        }
        this.f11499f = i2;
        Drawable drawable = this.f11502i;
        if (drawable instanceof b) {
            ((b) drawable).e(i2);
        }
        if (this.f11501h) {
            Drawable drawable2 = this.j;
            if (drawable2 instanceof b) {
                ((b) drawable2).e(i2);
            }
        }
        invalidate();
    }

    public void setCornerRadius(int i2) {
        if (this.f11498e == i2) {
            return;
        }
        this.f11498e = i2;
        Drawable drawable = this.f11502i;
        if (drawable instanceof b) {
            ((b) drawable).f(i2);
        }
        if (this.f11501h) {
            Drawable drawable2 = this.j;
            if (drawable2 instanceof b) {
                ((b) drawable2).f(i2);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            b bVar = new b(bitmap, this.f11498e, this.f11499f, this.f11500g);
            this.f11502i = bVar;
            ImageView.ScaleType scaleType = this.k;
            if (scaleType != null) {
                bVar.h(scaleType);
            }
        } else {
            this.f11502i = null;
        }
        super.setImageDrawable(this.f11502i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            this.f11502i = b.b(drawable, this.k, this.f11498e, this.f11499f, this.f11500g);
        } else {
            this.f11502i = null;
        }
        super.setImageDrawable(this.f11502i);
    }

    public void setRoundBackground(boolean z) {
        if (this.f11501h == z) {
            return;
        }
        this.f11501h = z;
        if (z) {
            Drawable drawable = this.j;
            if (drawable instanceof b) {
                ((b) drawable).h(this.k);
                ((b) this.j).f(this.f11498e);
                ((b) this.j).e(this.f11499f);
                ((b) this.j).d(this.f11500g);
            } else {
                setBackgroundDrawable(drawable);
            }
        } else {
            Drawable drawable2 = this.j;
            if (drawable2 instanceof b) {
                ((b) drawable2).e(0);
                ((b) this.j).f(0.0f);
            }
        }
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null || this.k == scaleType) {
            return;
        }
        this.k = scaleType;
        switch (a.f11503a[scaleType.ordinal()]) {
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
        Drawable drawable = this.f11502i;
        if ((drawable instanceof b) && ((b) drawable).c() != scaleType) {
            ((b) this.f11502i).h(scaleType);
        }
        Drawable drawable2 = this.j;
        if ((drawable2 instanceof b) && ((b) drawable2).c() != scaleType) {
            ((b) this.j).h(scaleType);
        }
        setWillNotCacheDrawing(true);
        requestLayout();
        invalidate();
    }

    public SwanAppRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwanAppRoundedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.RoundedImageView, i2, 0);
        int i3 = obtainStyledAttributes.getInt(j.RoundedImageView_android_scaleType, -1);
        if (i3 >= 0) {
            setScaleType(l[i3]);
        }
        this.f11498e = obtainStyledAttributes.getDimensionPixelSize(j.RoundedImageView_corner_radius, -1);
        this.f11499f = obtainStyledAttributes.getDimensionPixelSize(j.RoundedImageView_border_width, -1);
        if (this.f11498e < 0) {
            this.f11498e = 20;
        }
        if (this.f11499f < 0) {
            this.f11499f = 2;
        }
        this.f11500g = obtainStyledAttributes.getColor(j.RoundedImageView_border_color, -16777216);
        this.f11501h = obtainStyledAttributes.getBoolean(j.RoundedImageView_round_background, false);
        obtainStyledAttributes.recycle();
    }
}
