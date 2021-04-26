package com.baidu.swan.apps.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import d.a.h0.a.j;
import d.a.h0.a.q1.a.c;
/* loaded from: classes3.dex */
public class SwanAppRoundedImageView extends ImageView {
    public static final ImageView.ScaleType[] l = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: e  reason: collision with root package name */
    public int f12241e;

    /* renamed from: f  reason: collision with root package name */
    public int f12242f;

    /* renamed from: g  reason: collision with root package name */
    public int f12243g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12244h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f12245i;
    public Drawable j;
    public ImageView.ScaleType k;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12246a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f12246a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12246a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12246a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12246a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12246a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12246a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12246a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public SwanAppRoundedImageView(Context context) {
        super(context);
        this.f12241e = 20;
        this.f12242f = 2;
        this.f12243g = -16777216;
    }

    public int getBorder() {
        return this.f12242f;
    }

    public int getBorderColor() {
        return this.f12243g;
    }

    public int getCornerRadius() {
        return this.f12241e;
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
        if (this.f12244h && drawable != null) {
            this.j = c.b(drawable, this.k, this.f12241e, this.f12242f, this.f12243g);
        } else {
            this.j = drawable;
        }
        super.setBackgroundDrawable(this.j);
    }

    public void setBorderColor(int i2) {
        if (this.f12243g == i2) {
            return;
        }
        this.f12243g = i2;
        Drawable drawable = this.f12245i;
        if (drawable instanceof c) {
            ((c) drawable).d(i2);
        }
        if (this.f12244h) {
            Drawable drawable2 = this.j;
            if (drawable2 instanceof c) {
                ((c) drawable2).d(i2);
            }
        }
        if (this.f12242f > 0) {
            invalidate();
        }
    }

    public void setBorderWidth(int i2) {
        if (this.f12242f == i2) {
            return;
        }
        this.f12242f = i2;
        Drawable drawable = this.f12245i;
        if (drawable instanceof c) {
            ((c) drawable).e(i2);
        }
        if (this.f12244h) {
            Drawable drawable2 = this.j;
            if (drawable2 instanceof c) {
                ((c) drawable2).e(i2);
            }
        }
        invalidate();
    }

    public void setCornerRadius(int i2) {
        if (this.f12241e == i2) {
            return;
        }
        this.f12241e = i2;
        Drawable drawable = this.f12245i;
        if (drawable instanceof c) {
            ((c) drawable).f(i2);
        }
        if (this.f12244h) {
            Drawable drawable2 = this.j;
            if (drawable2 instanceof c) {
                ((c) drawable2).f(i2);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            c cVar = new c(bitmap, this.f12241e, this.f12242f, this.f12243g);
            this.f12245i = cVar;
            ImageView.ScaleType scaleType = this.k;
            if (scaleType != null) {
                cVar.h(scaleType);
            }
        } else {
            this.f12245i = null;
        }
        super.setImageDrawable(this.f12245i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            this.f12245i = c.b(drawable, this.k, this.f12241e, this.f12242f, this.f12243g);
        } else {
            this.f12245i = null;
        }
        super.setImageDrawable(this.f12245i);
    }

    public void setRoundBackground(boolean z) {
        if (this.f12244h == z) {
            return;
        }
        this.f12244h = z;
        if (z) {
            Drawable drawable = this.j;
            if (drawable instanceof c) {
                ((c) drawable).h(this.k);
                ((c) this.j).f(this.f12241e);
                ((c) this.j).e(this.f12242f);
                ((c) this.j).d(this.f12243g);
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
                switch (a.f12246a[scaleType.ordinal()]) {
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
                Drawable drawable = this.f12245i;
                if ((drawable instanceof c) && ((c) drawable).c() != scaleType) {
                    ((c) this.f12245i).h(scaleType);
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

    public SwanAppRoundedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.RoundedImageView, i2, 0);
        int i3 = obtainStyledAttributes.getInt(j.RoundedImageView_android_scaleType, -1);
        if (i3 >= 0) {
            setScaleType(l[i3]);
        }
        this.f12241e = obtainStyledAttributes.getDimensionPixelSize(j.RoundedImageView_corner_radius, -1);
        this.f12242f = obtainStyledAttributes.getDimensionPixelSize(j.RoundedImageView_border_width, -1);
        if (this.f12241e < 0) {
            this.f12241e = 20;
        }
        if (this.f12242f < 0) {
            this.f12242f = 2;
        }
        this.f12243g = obtainStyledAttributes.getColor(j.RoundedImageView_border_color, -16777216);
        this.f12244h = obtainStyledAttributes.getBoolean(j.RoundedImageView_round_background, false);
        obtainStyledAttributes.recycle();
    }
}
