package com.baidu.swan.apps.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.eo1;
import com.baidu.tieba.f63;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class SwanAppRoundedImageView extends ImageView {
    public static final ImageView.ScaleType[] h = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public int a;
    public int b;
    public int c;
    public boolean d;
    public Drawable e;
    public Drawable f;
    public ImageView.ScaleType g;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public int getBorder() {
        return this.b;
    }

    public int getBorderColor() {
        return this.c;
    }

    public int getCornerRadius() {
        return this.a;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.g;
    }

    public SwanAppRoundedImageView(Context context) {
        super(context);
        this.a = 20;
        this.b = 2;
        this.c = -16777216;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.d && drawable != null) {
            this.f = f63.b(drawable, this.g, this.a, this.b, this.c);
        } else {
            this.f = drawable;
        }
        super.setBackgroundDrawable(this.f);
    }

    public void setBorderColor(int i) {
        if (this.c == i) {
            return;
        }
        this.c = i;
        Drawable drawable = this.e;
        if (drawable instanceof f63) {
            ((f63) drawable).d(i);
        }
        if (this.d) {
            Drawable drawable2 = this.f;
            if (drawable2 instanceof f63) {
                ((f63) drawable2).d(i);
            }
        }
        if (this.b > 0) {
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.b == i) {
            return;
        }
        this.b = i;
        Drawable drawable = this.e;
        if (drawable instanceof f63) {
            ((f63) drawable).e(i);
        }
        if (this.d) {
            Drawable drawable2 = this.f;
            if (drawable2 instanceof f63) {
                ((f63) drawable2).e(i);
            }
        }
        invalidate();
    }

    public void setCornerRadius(int i) {
        if (this.a == i) {
            return;
        }
        this.a = i;
        Drawable drawable = this.e;
        if (drawable instanceof f63) {
            ((f63) drawable).f(i);
        }
        if (this.d) {
            Drawable drawable2 = this.f;
            if (drawable2 instanceof f63) {
                ((f63) drawable2).f(i);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            f63 f63Var = new f63(bitmap, this.a, this.b, this.c);
            this.e = f63Var;
            ImageView.ScaleType scaleType = this.g;
            if (scaleType != null) {
                f63Var.h(scaleType);
            }
        } else {
            this.e = null;
        }
        super.setImageDrawable(this.e);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            this.e = f63.b(drawable, this.g, this.a, this.b, this.c);
        } else {
            this.e = null;
        }
        super.setImageDrawable(this.e);
    }

    public SwanAppRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwanAppRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, eo1.RoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(0, -1);
        if (i2 >= 0) {
            setScaleType(h[i2]);
        }
        this.a = obtainStyledAttributes.getDimensionPixelSize(3, -1);
        this.b = obtainStyledAttributes.getDimensionPixelSize(2, -1);
        if (this.a < 0) {
            this.a = 20;
        }
        if (this.b < 0) {
            this.b = 2;
        }
        this.c = obtainStyledAttributes.getColor(1, -16777216);
        this.d = obtainStyledAttributes.getBoolean(4, false);
        obtainStyledAttributes.recycle();
    }

    public void setRoundBackground(boolean z) {
        if (this.d == z) {
            return;
        }
        this.d = z;
        if (z) {
            Drawable drawable = this.f;
            if (drawable instanceof f63) {
                ((f63) drawable).h(this.g);
                ((f63) this.f).f(this.a);
                ((f63) this.f).e(this.b);
                ((f63) this.f).d(this.c);
            } else {
                setBackgroundDrawable(drawable);
            }
        } else {
            Drawable drawable2 = this.f;
            if (drawable2 instanceof f63) {
                ((f63) drawable2).e(0);
                ((f63) this.f).f(0.0f);
            }
        }
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != null && this.g != scaleType) {
            this.g = scaleType;
            switch (a.a[scaleType.ordinal()]) {
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
            Drawable drawable = this.e;
            if ((drawable instanceof f63) && ((f63) drawable).c() != scaleType) {
                ((f63) this.e).h(scaleType);
            }
            Drawable drawable2 = this.f;
            if ((drawable2 instanceof f63) && ((f63) drawable2).c() != scaleType) {
                ((f63) this.f).h(scaleType);
            }
            setWillNotCacheDrawing(true);
            requestLayout();
            invalidate();
        }
    }
}
