package com.baidu.adp.widget.ImageView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class BDImageView2 extends ImageView {
    private static /* synthetic */ int[] g;
    private int a;
    private Paint b;
    private Matrix c;
    private Matrix d;
    private String e;
    private int f;

    private static /* synthetic */ int[] c() {
        int[] iArr = g;
        if (iArr == null) {
            iArr = new int[ImageView.ScaleType.values().length];
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            g = iArr;
        }
        return iArr;
    }

    public BDImageView2(Context context) {
        super(context);
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        b();
    }

    public BDImageView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        b();
    }

    public BDImageView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        b();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag(obj);
    }

    private void b() {
        this.b = new Paint();
    }

    @Override // android.widget.ImageView
    public void setAlpha(int i) {
        super.setAlpha(i);
        this.b.setAlpha(i);
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
        this.b.setColorFilter(colorFilter);
    }

    public void setDefaultResource(int i) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = i;
    }

    public final void a() {
        setDefaultResource(0);
        this.e = null;
        setTag(null);
        this.c = null;
        this.d = null;
    }

    private Matrix a(b bVar) {
        float f;
        float f2;
        float f3 = 0.0f;
        if (bVar == null) {
            return null;
        }
        ImageView.ScaleType scaleType = getScaleType();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int d = bVar.d();
        int c = bVar.c();
        int height = (getHeight() - paddingTop) - paddingBottom;
        int width = (getWidth() - paddingLeft) - paddingRight;
        float f4 = width / c;
        float f5 = height / d;
        switch (c()[scaleType.ordinal()]) {
            case 1:
                f3 = (width - c) / 2;
                f = (height - d) / 2;
                f2 = 1.0f;
                break;
            case 2:
                float max = Math.max(f4, f5);
                r0 = Math.max(max, f5);
                f3 = (width - (c * max)) / 2.0f;
                f = (height - (d * r0)) / 2.0f;
                f2 = max;
                break;
            case 3:
                float min = Math.min(f4, f5);
                r0 = min <= 1.0f ? min : 1.0f;
                f3 = (width - (c * r0)) / 2.0f;
                f = (height - (d * r0)) / 2.0f;
                f2 = r0;
                break;
            case 4:
                r0 = Math.min(f4, f5);
                f3 = (width - (c * r0)) / 2.0f;
                f = (height - (d * r0)) / 2.0f;
                f2 = r0;
                break;
            case 5:
                r0 = Math.min(f4, f5);
                f3 = width - (c * r0);
                f = height - (d * r0);
                f2 = r0;
                break;
            case 6:
                r0 = Math.min(f4, f5);
                f2 = r0;
                f = 0.0f;
                break;
            case 7:
                r0 = f5;
                f2 = f4;
                f = 0.0f;
                break;
            default:
                r0 = f5;
                f2 = f4;
                f = 0.0f;
                break;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f2, r0);
        matrix.postTranslate(paddingLeft + f3, paddingTop + f);
        return matrix;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        invalidate();
    }

    private b getImage() {
        if (this.e != null) {
            try {
                Object a = com.baidu.adp.lib.e.c.a().a(this.e, this.f, null, getContext(), null, 1);
                if (a != null && (a instanceof b)) {
                    return (b) a;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Matrix matrix;
        super.onDraw(canvas);
        b image = getImage();
        if (image != null) {
            if (this.d == null) {
                this.d = a(image);
            }
            matrix = this.d;
        } else {
            image = new b(com.baidu.adp.lib.util.a.a().a(this.a), false, null);
            if (this.c == null) {
                this.c = a(image);
            }
            matrix = this.c;
        }
        if (matrix == null) {
            image.a(canvas, 0.0f, 0.0f, this.b);
        } else {
            image.a(canvas, matrix, this.b);
        }
    }
}
