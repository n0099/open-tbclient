package com.baidu.swan.apps.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import d.b.g0.a.j;
import d.b.g0.a.q1.a.c;
/* loaded from: classes3.dex */
public class SwanAppRoundedImageView extends ImageView {
    public static final ImageView.ScaleType[] l = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: e  reason: collision with root package name */
    public int f12695e;

    /* renamed from: f  reason: collision with root package name */
    public int f12696f;

    /* renamed from: g  reason: collision with root package name */
    public int f12697g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12698h;
    public Drawable i;
    public Drawable j;
    public ImageView.ScaleType k;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12699a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f12699a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12699a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12699a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12699a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12699a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12699a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12699a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public SwanAppRoundedImageView(Context context) {
        super(context);
        this.f12695e = 20;
        this.f12696f = 2;
        this.f12697g = -16777216;
    }

    public int getBorder() {
        return this.f12696f;
    }

    public int getBorderColor() {
        return this.f12697g;
    }

    public int getCornerRadius() {
        return this.f12695e;
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
        if (this.f12698h && drawable != null) {
            this.j = c.b(drawable, this.k, this.f12695e, this.f12696f, this.f12697g);
        } else {
            this.j = drawable;
        }
        super.setBackgroundDrawable(this.j);
    }

    public void setBorderColor(int i) {
        if (this.f12697g == i) {
            return;
        }
        this.f12697g = i;
        Drawable drawable = this.i;
        if (drawable instanceof c) {
            ((c) drawable).d(i);
        }
        if (this.f12698h) {
            Drawable drawable2 = this.j;
            if (drawable2 instanceof c) {
                ((c) drawable2).d(i);
            }
        }
        if (this.f12696f > 0) {
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.f12696f == i) {
            return;
        }
        this.f12696f = i;
        Drawable drawable = this.i;
        if (drawable instanceof c) {
            ((c) drawable).e(i);
        }
        if (this.f12698h) {
            Drawable drawable2 = this.j;
            if (drawable2 instanceof c) {
                ((c) drawable2).e(i);
            }
        }
        invalidate();
    }

    public void setCornerRadius(int i) {
        if (this.f12695e == i) {
            return;
        }
        this.f12695e = i;
        Drawable drawable = this.i;
        if (drawable instanceof c) {
            ((c) drawable).f(i);
        }
        if (this.f12698h) {
            Drawable drawable2 = this.j;
            if (drawable2 instanceof c) {
                ((c) drawable2).f(i);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            c cVar = new c(bitmap, this.f12695e, this.f12696f, this.f12697g);
            this.i = cVar;
            ImageView.ScaleType scaleType = this.k;
            if (scaleType != null) {
                cVar.h(scaleType);
            }
        } else {
            this.i = null;
        }
        super.setImageDrawable(this.i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            this.i = c.b(drawable, this.k, this.f12695e, this.f12696f, this.f12697g);
        } else {
            this.i = null;
        }
        super.setImageDrawable(this.i);
    }

    public void setRoundBackground(boolean z) {
        if (this.f12698h == z) {
            return;
        }
        this.f12698h = z;
        if (z) {
            Drawable drawable = this.j;
            if (drawable instanceof c) {
                ((c) drawable).h(this.k);
                ((c) this.j).f(this.f12695e);
                ((c) this.j).e(this.f12696f);
                ((c) this.j).d(this.f12697g);
            } else {
                setBackgroundDrawable(drawable);
            }
        } else {
            Drawable drawable2 = this.j;
            if (drawable2 instanceof c) {
                ((c) drawable2).e(0);
                ((c) this.j).f(0.0f);
            }
        }
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            if (this.k != scaleType) {
                this.k = scaleType;
                switch (a.f12699a[scaleType.ordinal()]) {
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
                Drawable drawable = this.i;
                if ((drawable instanceof c) && ((c) drawable).c() != scaleType) {
                    ((c) this.i).h(scaleType);
                }
                Drawable drawable2 = this.j;
                if ((drawable2 instanceof c) && ((c) drawable2).c() != scaleType) {
                    ((c) this.j).h(scaleType);
                }
                setWillNotCacheDrawing(true);
                requestLayout();
                invalidate();
                return;
            }
            return;
        }
        throw null;
    }

    public SwanAppRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwanAppRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.RoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(j.RoundedImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(l[i2]);
        }
        this.f12695e = obtainStyledAttributes.getDimensionPixelSize(j.RoundedImageView_corner_radius, -1);
        this.f12696f = obtainStyledAttributes.getDimensionPixelSize(j.RoundedImageView_border_width, -1);
        if (this.f12695e < 0) {
            this.f12695e = 20;
        }
        if (this.f12696f < 0) {
            this.f12696f = 2;
        }
        this.f12697g = obtainStyledAttributes.getColor(j.RoundedImageView_border_color, -16777216);
        this.f12698h = obtainStyledAttributes.getBoolean(j.RoundedImageView_round_background, false);
        obtainStyledAttributes.recycle();
    }
}
