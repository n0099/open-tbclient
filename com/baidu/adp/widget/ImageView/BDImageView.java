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
import com.baidu.adp.lib.e.h;
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
public class BDImageView extends ImageView {
    private static /* synthetic */ int[] r;
    protected int a;
    private int b;
    private Paint c;
    private ImageView.ScaleType d;
    private Matrix e;
    private Matrix f;
    private SparseArray<SoftReference<b>> g;
    private String h;
    private int i;
    private boolean j;
    private boolean k;
    private h l;
    private Rect m;
    private boolean n;
    private ColorFilter o;
    private boolean p;
    private boolean q;

    private static /* synthetic */ int[] c() {
        int[] iArr = r;
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
            r = iArr;
        }
        return iArr;
    }

    public int getRealWidth() {
        return getWidth();
    }

    public int getRealHeight() {
        return getHeight();
    }

    public BDImageView(Context context) {
        this(context, null, 0);
    }

    public BDImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BDImageView(Context context, AttributeSet attributeSet, int i) {
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
        this.c = new Paint();
        this.c.setColor(-1);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.BDImageView);
            if (obtainStyledAttributes == null) {
                this.p = false;
                return;
            }
            this.a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.p = this.a != 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f = null;
        this.e = null;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag(obj);
        this.f = null;
        this.e = null;
    }

    public void setAutoAnim(boolean z) {
        this.n = z;
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
        this.e = null;
        this.f = null;
        invalidate();
    }

    public void setDefaultResource(int i) {
        this.e = null;
        this.f = null;
        this.h = null;
        this.b = i;
    }

    public final void a() {
        setDefaultResource(0);
        this.h = null;
        setTag(null);
        this.e = null;
        this.f = null;
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

    private Matrix a(b bVar, ImageView.ScaleType scaleType) {
        if (bVar == null) {
            return null;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int d = bVar.d();
        int c = bVar.c();
        int realHeight = (getRealHeight() - paddingTop) - paddingBottom;
        int realWidth = (getRealWidth() - paddingLeft) - paddingRight;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = realWidth / c;
        float f4 = realHeight / d;
        switch (c()[scaleType.ordinal()]) {
            case 1:
                f3 = 1.0f;
                f4 = 1.0f;
                f = (realWidth - c) / 2.0f;
                f2 = (realHeight - d) / 2.0f;
                break;
            case 2:
                f3 = Math.max(f3, f4);
                f4 = Math.max(f3, f4);
                f = (realWidth - (c * f3)) / 2.0f;
                f2 = (realHeight - (d * f4)) / 2.0f;
                break;
            case 3:
                f4 = Math.min(f3, f4);
                if (f4 > 1.0f) {
                    f4 = 1.0f;
                }
                f = (realWidth - (c * f4)) / 2.0f;
                f2 = (realHeight - (d * f4)) / 2.0f;
                f3 = f4;
                break;
            case 4:
                f4 = Math.min(f3, f4);
                f = (realWidth - (c * f4)) / 2.0f;
                f2 = (realHeight - (d * f4)) / 2.0f;
                f3 = f4;
                break;
            case 5:
                f4 = Math.min(f3, f4);
                f = realWidth - (c * f4);
                f2 = realHeight - (d * f4);
                f3 = f4;
                break;
            case 6:
                f4 = Math.min(f3, f4);
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
        int i2 = (int) ((f3 * c) + f + paddingLeft);
        int i3 = (int) (paddingTop + f2);
        int i4 = (int) ((f4 * d) + f2 + paddingTop);
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
        this.e = null;
        this.f = null;
        invalidate();
    }

    protected b getImage() {
        if (this.h != null) {
            try {
                Object a = com.baidu.adp.lib.e.c.a().a(this.h, this.i, null, getContext(), null, 1);
                if (a != null && (a instanceof b)) {
                    return (b) a;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public final void a(String str, int i) {
        h hVar = this.l;
        this.h = str;
        if (this.h != null) {
            this.i = 1;
            this.l = hVar;
            try {
                com.baidu.adp.lib.e.c.a().a(this.h, this.i, new a(this), getContext(), hVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private b getDefaultBdImage() {
        SoftReference<b> softReference;
        b bVar;
        if (this.g == null) {
            this.g = new SparseArray<>();
        }
        if (this.g.indexOfKey(this.b) < 0 || (softReference = this.g.get(this.b)) == null || (bVar = softReference.get()) == null) {
            b bVar2 = new b(com.baidu.adp.lib.util.a.a().a(this.b), false, null);
            this.g.put(this.b, new SoftReference<>(bVar2));
            return bVar2;
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Matrix matrix;
        super.onDraw(canvas);
        if (!this.q) {
            b image = getImage();
            if (image != null) {
                if (!this.k) {
                    this.k = true;
                    if (this.n) {
                        clearAnimation();
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                        alphaAnimation.setDuration(500L);
                        startAnimation(alphaAnimation);
                        invalidate();
                        return;
                    }
                }
                this.j = image.e();
                if (this.k && this.j) {
                    if (this.m != null) {
                        canvas.drawRect(this.m, this.c);
                    } else {
                        canvas.drawColor(-1);
                    }
                }
                if (this.f == null) {
                    this.f = a(image, getScaleType());
                }
                matrix = this.f;
            } else {
                this.k = false;
                b defaultBdImage = getDefaultBdImage();
                if (this.e == null) {
                    this.e = this.d != null ? a(defaultBdImage, this.d) : a(defaultBdImage, getScaleType());
                }
                matrix = this.e;
                image = defaultBdImage;
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
    public final void b() {
        this.o = null;
        this.c.setColorFilter(null);
    }
}
