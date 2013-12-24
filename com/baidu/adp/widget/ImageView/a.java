package com.baidu.adp.widget.ImageView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.baidu.adp.g;
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
public class a extends ImageView {
    protected int a;
    private int b;
    private Paint c;
    private ImageView.ScaleType d;
    private Matrix e;
    private Matrix f;
    private SparseArray<SoftReference<e>> g;
    private String h;
    private int i;
    private boolean j;
    private boolean k;
    private com.baidu.adp.lib.e.f l;
    private Rect m;
    private boolean n;
    private ColorFilter o;
    private boolean p;
    private boolean q;

    public int getRealWidth() {
        return getWidth();
    }

    public int getRealHeight() {
        return getHeight();
    }

    public a(Context context) {
        this(context, null, 0);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.i = 0;
        this.j = false;
        this.k = false;
        this.m = null;
        this.n = false;
        this.o = null;
        a(context, attributeSet);
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag(obj);
        this.f = null;
    }

    public void setAutoAnim(boolean z) {
        this.n = z;
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.c = new Paint();
        this.c.setColor(-1);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.BDImageView);
            if (obtainStyledAttributes != null) {
                this.a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
                this.p = this.a != 0;
                return;
            }
            this.p = false;
        }
    }

    public void setRadius(int i) {
        this.a = i;
        this.p = this.a != 0;
    }

    @Override // android.widget.ImageView
    public void setAlpha(int i) {
        super.setAlpha(i);
        this.c.setAlpha(i);
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
        this.c.setColorFilter(colorFilter);
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        this.d = scaleType;
    }

    public void setDefaultResource(int i) {
        this.e = null;
        this.f = null;
        this.h = null;
        this.b = i;
    }

    public void a() {
        setDefaultResource(0);
        this.h = null;
        setTag(null);
        this.e = null;
        this.f = null;
    }

    public void a(long j, float f, float f2) {
        clearAnimation();
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setDuration(j);
        startAnimation(alphaAnimation);
    }

    public boolean getIsLoaded() {
        return this.k;
    }

    public boolean getIsGif() {
        return this.j;
    }

    public Rect getBitmapRect() {
        return this.m;
    }

    protected Matrix a(e eVar) {
        return this.d != null ? a(eVar, this.d) : a(eVar, getScaleType());
    }

    protected Matrix b(e eVar) {
        return a(eVar, getScaleType());
    }

    protected Matrix a(e eVar, ImageView.ScaleType scaleType) {
        if (eVar == null) {
            return null;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int b = eVar.b();
        int a = eVar.a();
        int realHeight = (getRealHeight() - paddingTop) - paddingBottom;
        int realWidth = (getRealWidth() - paddingLeft) - paddingRight;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = realWidth / a;
        float f4 = realHeight / b;
        switch (c.a[scaleType.ordinal()]) {
            case 2:
                f4 = Math.min(f3, f4);
                f3 = f4;
                break;
            case 3:
                f4 = Math.min(f3, f4);
                f = (realWidth - (a * f4)) / 2.0f;
                f2 = (realHeight - (b * f4)) / 2.0f;
                f3 = f4;
                break;
            case 4:
                f4 = Math.min(f3, f4);
                f = realWidth - (a * f4);
                f2 = realHeight - (b * f4);
                f3 = f4;
                break;
            case 5:
                f3 = 1.0f;
                f4 = 1.0f;
                f = (realWidth - a) / 2.0f;
                f2 = (realHeight - b) / 2.0f;
                break;
            case 6:
                f3 = Math.max(f3, f4);
                f4 = Math.max(f3, f4);
                f = (realWidth - (a * f3)) / 2.0f;
                f2 = (realHeight - (b * f4)) / 2.0f;
                break;
            case 7:
                f4 = Math.min(f3, f4);
                if (f4 > 1.0f) {
                    f4 = 1.0f;
                }
                f = (realWidth - (a * f4)) / 2.0f;
                f2 = (realHeight - (b * f4)) / 2.0f;
                f3 = f4;
                break;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f3, f4);
        matrix.postTranslate(paddingLeft + f, paddingTop + f2);
        if (this.m == null) {
            this.m = new Rect();
        }
        int i = (int) (paddingLeft + f);
        int i2 = (int) ((f3 * a) + f + paddingLeft);
        int i3 = (int) (paddingTop + f2);
        int i4 = (int) ((f4 * b) + f2 + paddingTop);
        if (i >= paddingLeft) {
            paddingLeft = i;
        }
        int i5 = i2 > realWidth - paddingRight ? realWidth - paddingRight : i2;
        if (i3 < paddingTop) {
            i3 = paddingTop;
        }
        if (i4 > realHeight - paddingBottom) {
            i4 = realHeight - paddingBottom;
        }
        this.m.left = paddingLeft;
        this.m.right = i5;
        this.m.top = i3;
        this.m.bottom = i4;
        return matrix;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        this.f = null;
        invalidate();
    }

    protected e getImage() {
        if (this.h != null) {
            try {
                Object a = com.baidu.adp.lib.e.c.a().a(this.h, this.i, null, getContext(), null, 1);
                if (a != null && (a instanceof e)) {
                    return (e) a;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void a(String str, int i) {
        a(str, i, this.l);
    }

    public void a(String str, int i, com.baidu.adp.lib.e.f fVar) {
        this.h = str;
        if (this.h != null) {
            this.i = i;
            this.l = fVar;
            try {
                com.baidu.adp.lib.e.c.a().a(this.h, this.i, new b(this), getContext(), fVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private e getDefaultBdImage() {
        SoftReference<e> softReference;
        e eVar;
        if (this.g == null) {
            this.g = new SparseArray<>();
        }
        if (this.g.indexOfKey(this.b) <= -1 || (softReference = this.g.get(this.b)) == null || (eVar = softReference.get()) == null) {
            e eVar2 = new e(com.baidu.adp.lib.h.a.a().a(this.b), false, null);
            this.g.put(this.b, new SoftReference<>(eVar2));
            return eVar2;
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Matrix matrix;
        super.onDraw(canvas);
        if (!this.q) {
            e image = getImage();
            if (image != null) {
                if (!this.k) {
                    this.k = true;
                    if (this.n) {
                        a(500L, 0.1f, 1.0f);
                        invalidate();
                        return;
                    }
                }
                this.j = image.c();
                if (this.k && this.j) {
                    if (this.m != null) {
                        canvas.drawRect(this.m, this.c);
                    } else {
                        canvas.drawColor(-1);
                    }
                }
                if (this.f == null) {
                    this.f = b(image);
                }
                matrix = this.f;
            } else {
                this.k = false;
                image = getDefaultBdImage();
                if (this.e == null) {
                    this.e = a(image);
                }
                matrix = this.e;
            }
            if (this.p) {
                image.a(canvas, matrix, getResources(), this, this.a, this.o);
            } else if (matrix == null) {
                image.a(canvas, 0.0f, 0.0f, this.c);
            } else {
                image.a(canvas, matrix, this.c);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.q = bitmap != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setColorFilterForSkin(ColorFilter colorFilter) {
        this.o = colorFilter;
        this.c.setColorFilter(colorFilter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.o = null;
        this.c.setColorFilter(null);
    }
}
