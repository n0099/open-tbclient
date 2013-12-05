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

    /* renamed from: a  reason: collision with root package name */
    private int f559a;
    private Paint b;
    private Matrix c;
    private Matrix d;
    private String e;
    private int f;

    public BDImageView2(Context context) {
        super(context);
        this.f559a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        b();
    }

    public BDImageView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f559a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        b();
    }

    public BDImageView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f559a = 0;
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
        this.f559a = i;
    }

    public void a() {
        setDefaultResource(0);
        this.e = null;
        setTag(null);
        this.c = null;
        this.d = null;
    }

    private Matrix a(e eVar) {
        float f;
        float f2;
        float f3 = 0.0f;
        if (eVar == null) {
            return null;
        }
        ImageView.ScaleType scaleType = getScaleType();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int b = eVar.b();
        int a2 = eVar.a();
        int height = (getHeight() - paddingTop) - paddingBottom;
        int width = (getWidth() - paddingLeft) - paddingRight;
        float f4 = width / a2;
        float f5 = height / b;
        switch (d.f563a[scaleType.ordinal()]) {
            case 1:
                r0 = f5;
                f2 = f4;
                f = 0.0f;
                break;
            case 2:
                r0 = Math.min(f4, f5);
                f2 = r0;
                f = 0.0f;
                break;
            case 3:
                r0 = Math.min(f4, f5);
                f3 = (width - (a2 * r0)) / 2.0f;
                f = (height - (b * r0)) / 2.0f;
                f2 = r0;
                break;
            case 4:
                r0 = Math.min(f4, f5);
                f3 = width - (a2 * r0);
                f = height - (b * r0);
                f2 = r0;
                break;
            case 5:
                f3 = (width - a2) / 2;
                f = (height - b) / 2;
                f2 = 1.0f;
                break;
            case 6:
                float max = Math.max(f4, f5);
                r0 = Math.max(max, f5);
                f3 = (width - (a2 * max)) / 2.0f;
                f = (height - (b * r0)) / 2.0f;
                f2 = max;
                break;
            case 7:
                float min = Math.min(f4, f5);
                r0 = min <= 1.0f ? min : 1.0f;
                f3 = (width - (a2 * r0)) / 2.0f;
                f = (height - (b * r0)) / 2.0f;
                f2 = r0;
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

    private e getImage() {
        if (this.e != null) {
            try {
                Object a2 = com.baidu.adp.lib.e.c.a().a(this.e, this.f, null, getContext(), null, 1);
                if (a2 != null && (a2 instanceof e)) {
                    return (e) a2;
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
        e image = getImage();
        if (image != null) {
            if (this.d == null) {
                this.d = a(image);
            }
            matrix = this.d;
        } else {
            image = new e(com.baidu.adp.lib.h.a.a().a(this.f559a), false, null);
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
