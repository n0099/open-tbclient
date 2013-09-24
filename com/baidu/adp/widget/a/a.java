package com.baidu.adp.widget.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.baidu.adp.h;
import com.baidu.adp.lib.c.f;
/* loaded from: classes.dex */
public class a extends ImageView {
    private static /* synthetic */ int[] p;

    /* renamed from: a  reason: collision with root package name */
    protected int f513a;
    private int b;
    private Paint c;
    private ImageView.ScaleType d;
    private Matrix e;
    private Matrix f;
    private String g;
    private int h;
    private boolean i;
    private boolean j;
    private f k;
    private Rect l;
    private boolean m;
    private boolean n;
    private boolean o;

    static /* synthetic */ int[] a() {
        int[] iArr = p;
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
            p = iArr;
        }
        return iArr;
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
        this.g = null;
        this.h = 0;
        this.i = false;
        this.j = false;
        this.l = null;
        this.m = false;
        a(context, attributeSet);
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag(obj);
        this.f = null;
    }

    public void setAutoAnim(boolean z) {
        this.m = z;
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.c = new Paint();
        this.c.setColor(-1);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.BDImageView);
            if (obtainStyledAttributes != null) {
                this.f513a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
                this.n = this.f513a != 0;
                return;
            }
            this.n = false;
        }
    }

    public void setRadius(int i) {
        this.f513a = i;
        this.n = this.f513a != 0;
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
        this.g = null;
        this.b = i;
    }

    public void a(long j, float f, float f2) {
        clearAnimation();
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setDuration(j);
        startAnimation(alphaAnimation);
    }

    public boolean getIsLoaded() {
        return this.j;
    }

    public boolean getIsGif() {
        return this.i;
    }

    public Rect getBitmapRect() {
        return this.l;
    }

    protected Matrix a(c cVar) {
        return this.d != null ? a(cVar, this.d) : a(cVar, getScaleType());
    }

    protected Matrix b(c cVar) {
        return a(cVar, getScaleType());
    }

    protected Matrix a(c cVar, ImageView.ScaleType scaleType) {
        if (cVar == null) {
            return null;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int b = cVar.b();
        int a2 = cVar.a();
        int height = (getHeight() - paddingTop) - paddingBottom;
        int width = (getWidth() - paddingLeft) - paddingRight;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = width / a2;
        float f4 = height / b;
        switch (a()[scaleType.ordinal()]) {
            case 1:
                f3 = 1.0f;
                f4 = 1.0f;
                f = (width - a2) / 2;
                f2 = (height - b) / 2;
                break;
            case 2:
                f3 = Math.max(f3, f4);
                f4 = Math.max(f3, f4);
                f = (width - (a2 * f3)) / 2.0f;
                f2 = (height - (b * f4)) / 2.0f;
                break;
            case 3:
                f4 = Math.min(f3, f4);
                if (f4 > 1.0f) {
                    f4 = 1.0f;
                }
                f = (width - (a2 * f4)) / 2.0f;
                f2 = (height - (b * f4)) / 2.0f;
                f3 = f4;
                break;
            case 4:
                f4 = Math.min(f3, f4);
                f = (width - (a2 * f4)) / 2.0f;
                f2 = (height - (b * f4)) / 2.0f;
                f3 = f4;
                break;
            case 5:
                f4 = Math.min(f3, f4);
                f = width - (a2 * f4);
                f2 = height - (b * f4);
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
        if (this.l == null) {
            this.l = new Rect();
        }
        int i = (int) (paddingLeft + f);
        int i2 = (int) ((f3 * a2) + f + paddingLeft);
        int i3 = (int) (paddingTop + f2);
        int i4 = (int) ((f4 * b) + f2 + paddingTop);
        if (i >= paddingLeft) {
            paddingLeft = i;
        }
        int i5 = i2 > width - paddingRight ? width - paddingRight : i2;
        if (i3 < paddingTop) {
            i3 = paddingTop;
        }
        if (i4 > height - paddingBottom) {
            i4 = height - paddingBottom;
        }
        this.l.left = paddingLeft;
        this.l.right = i5;
        this.l.top = i3;
        this.l.bottom = i4;
        return matrix;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        this.f = null;
        invalidate();
    }

    protected c getImage() {
        if (this.g != null) {
            try {
                Object a2 = com.baidu.adp.lib.c.c.a().a(this.g, this.h, null, getContext(), null, 1);
                if (a2 != null && (a2 instanceof c)) {
                    return (c) a2;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void a(String str, int i) {
        a(str, i, this.k);
    }

    public void a(String str, int i, f fVar) {
        this.g = str;
        if (this.g != null) {
            this.h = i;
            this.k = fVar;
            try {
                com.baidu.adp.lib.c.c.a().a(this.g, this.h, new b(this), getContext(), fVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Matrix matrix;
        super.onDraw(canvas);
        if (!this.o) {
            c image = getImage();
            if (image != null) {
                if (!this.j) {
                    this.j = true;
                    if (this.m) {
                        a(500L, 0.1f, 1.0f);
                        invalidate();
                        return;
                    }
                }
                this.i = image.c();
                if (this.j && this.i) {
                    if (this.l != null) {
                        canvas.drawRect(this.l, this.c);
                    } else {
                        canvas.drawColor(-1);
                    }
                }
                if (this.f == null) {
                    this.f = b(image);
                }
                matrix = this.f;
            } else {
                this.j = false;
                image = new c(com.baidu.adp.lib.f.a.a().a(this.b), false, null);
                if (this.e == null) {
                    this.e = a(image);
                }
                matrix = this.e;
            }
            if (this.n) {
                image.a(canvas, matrix, getResources(), this, this.f513a);
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
        this.o = bitmap != null;
    }
}
