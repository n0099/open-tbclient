package com.baidu.adp.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.widget.ImageView;
import com.baidu.adp.lib.d.b;
import com.baidu.adp.lib.d.c;
/* loaded from: classes.dex */
public class a extends ImageView {
    private static /* synthetic */ int[] h;
    private int a;
    private Paint b;
    private Matrix c;
    private Matrix d;
    private String e;
    private b f;
    private int g;

    static /* synthetic */ int[] a() {
        int[] iArr = h;
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
            h = iArr;
        }
        return iArr;
    }

    public a(Context context) {
        super(context);
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
        b();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag(obj);
        this.d = null;
        if ((obj instanceof String) && !obj.equals("")) {
            this.e = (String) obj;
        } else {
            this.e = null;
        }
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
        this.a = i;
    }

    private Matrix a(Bitmap bitmap) {
        float f;
        float f2;
        float f3 = 0.0f;
        if (bitmap == null) {
            return null;
        }
        ImageView.ScaleType scaleType = getScaleType();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int height2 = (getHeight() - paddingTop) - paddingBottom;
        int width2 = (getWidth() - paddingLeft) - paddingRight;
        float f4 = width2 / width;
        float f5 = height2 / height;
        switch (a()[scaleType.ordinal()]) {
            case 1:
                f3 = (width2 - width) / 2;
                f = (height2 - height) / 2;
                f2 = 1.0f;
                break;
            case 2:
                float max = Math.max(f4, f5);
                r0 = Math.max(max, f5);
                f3 = (width2 - (width * max)) / 2.0f;
                f = (height2 - (height * r0)) / 2.0f;
                f2 = max;
                break;
            case 3:
                float min = Math.min(f4, f5);
                r0 = min <= 1.0f ? min : 1.0f;
                f3 = (width2 - (width * r0)) / 2.0f;
                f = (height2 - (height * r0)) / 2.0f;
                f2 = r0;
                break;
            case 4:
                r0 = Math.min(f4, f5);
                f3 = (width2 - (width * r0)) / 2.0f;
                f = (height2 - (height * r0)) / 2.0f;
                f2 = r0;
                break;
            case 5:
                r0 = Math.min(f4, f5);
                f3 = width2 - (width * r0);
                f = height2 - (height * r0);
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

    private Bitmap getImage() {
        if (this.e != null) {
            return (Bitmap) c.a(this.e, this.g);
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Matrix matrix;
        super.onDraw(canvas);
        Bitmap image = getImage();
        if (image != null) {
            if (this.d == null) {
                this.d = a(image);
            }
            matrix = this.d;
        } else {
            image = com.baidu.adp.lib.e.a.a().a(this.a);
            if (this.c == null) {
                this.c = a(image);
            }
            matrix = this.c;
        }
        if (image != null) {
            if (matrix == null) {
                canvas.drawBitmap(image, 0.0f, 0.0f, this.b);
            } else {
                canvas.drawBitmap(image, matrix, this.b);
            }
        }
    }
}
