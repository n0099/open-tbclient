package com.baidu.pass.biometrics.face.liveness.view.face;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class CircleImageView extends ImageView {
    public static final int A = 255;
    public static final boolean B = false;
    public static final ImageView.ScaleType u = ImageView.ScaleType.CENTER_CROP;
    public static final Bitmap.Config v = Bitmap.Config.ARGB_8888;
    public static final int w = 2;
    public static final int x = 0;
    public static final int y = -16777216;
    public static final int z = 0;

    /* renamed from: a  reason: collision with root package name */
    public final RectF f9134a;

    /* renamed from: b  reason: collision with root package name */
    public final RectF f9135b;

    /* renamed from: c  reason: collision with root package name */
    public final Matrix f9136c;

    /* renamed from: d  reason: collision with root package name */
    public final Paint f9137d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f9138e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f9139f;

    /* renamed from: g  reason: collision with root package name */
    public int f9140g;

    /* renamed from: h  reason: collision with root package name */
    public int f9141h;

    /* renamed from: i  reason: collision with root package name */
    public int f9142i;
    public int j;
    public Bitmap k;
    public Canvas l;
    public float m;
    public float n;
    public ColorFilter o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;

    @RequiresApi(api = 21)
    /* loaded from: classes2.dex */
    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (CircleImageView.this.t) {
                ViewOutlineProvider.BACKGROUND.getOutline(view, outline);
                return;
            }
            Rect rect = new Rect();
            CircleImageView.this.f9135b.roundOut(rect);
            outline.setRoundRect(rect, rect.width() / 2.0f);
        }
    }

    public CircleImageView(Context context) {
        super(context);
        this.f9134a = new RectF();
        this.f9135b = new RectF();
        this.f9136c = new Matrix();
        this.f9137d = new Paint();
        this.f9138e = new Paint();
        this.f9139f = new Paint();
        this.f9140g = -16777216;
        this.f9141h = 0;
        this.f9142i = 0;
        this.j = 255;
        d();
    }

    private RectF c() {
        int width;
        int height;
        int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float paddingLeft = getPaddingLeft() + ((width - min) / 2.0f);
        float paddingTop = getPaddingTop() + ((height - min) / 2.0f);
        float f2 = min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f2, f2 + paddingTop);
    }

    private void d() {
        this.p = true;
        super.setScaleType(u);
        this.f9137d.setAntiAlias(true);
        this.f9137d.setDither(true);
        this.f9137d.setFilterBitmap(true);
        this.f9137d.setAlpha(this.j);
        this.f9137d.setColorFilter(this.o);
        this.f9138e.setStyle(Paint.Style.STROKE);
        this.f9138e.setAntiAlias(true);
        this.f9138e.setColor(this.f9140g);
        this.f9138e.setStrokeWidth(this.f9141h);
        this.f9139f.setStyle(Paint.Style.FILL);
        this.f9139f.setAntiAlias(true);
        this.f9139f.setColor(this.f9142i);
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b());
        }
    }

    private void e() {
        Bitmap a2 = a(getDrawable());
        this.k = a2;
        if (a2 != null && a2.isMutable()) {
            this.l = new Canvas(this.k);
        } else {
            this.l = null;
        }
        if (this.p) {
            if (this.k != null) {
                g();
            } else {
                this.f9137d.setShader(null);
            }
        }
    }

    private void f() {
        int i2;
        this.f9135b.set(c());
        this.n = Math.min((this.f9135b.height() - this.f9141h) / 2.0f, (this.f9135b.width() - this.f9141h) / 2.0f);
        this.f9134a.set(this.f9135b);
        if (!this.s && (i2 = this.f9141h) > 0) {
            float f2 = i2 - 1.0f;
            this.f9134a.inset(f2, f2);
        }
        this.m = Math.min(this.f9134a.height() / 2.0f, this.f9134a.width() / 2.0f);
        g();
    }

    private void g() {
        float width;
        float height;
        if (this.k == null) {
            return;
        }
        this.f9136c.set(null);
        int height2 = this.k.getHeight();
        float width2 = this.k.getWidth();
        float f2 = height2;
        float f3 = 0.0f;
        if (this.f9134a.height() * width2 > this.f9134a.width() * f2) {
            width = this.f9134a.height() / f2;
            f3 = (this.f9134a.width() - (width2 * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = this.f9134a.width() / width2;
            height = (this.f9134a.height() - (f2 * width)) * 0.5f;
        }
        this.f9136c.setScale(width, width);
        Matrix matrix = this.f9136c;
        RectF rectF = this.f9134a;
        matrix.postTranslate(((int) (f3 + 0.5f)) + rectF.left, ((int) (height + 0.5f)) + rectF.top);
        this.q = true;
    }

    public int getBorderColor() {
        return this.f9140g;
    }

    public int getBorderWidth() {
        return this.f9141h;
    }

    public int getCircleBackgroundColor() {
        return this.f9142i;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.o;
    }

    @Override // android.widget.ImageView
    public int getImageAlpha() {
        return this.j;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        this.r = true;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"CanvasSize"})
    public void onDraw(Canvas canvas) {
        if (this.t) {
            super.onDraw(canvas);
            return;
        }
        if (this.f9142i != 0) {
            canvas.drawCircle(this.f9134a.centerX(), this.f9134a.centerY(), this.m, this.f9139f);
        }
        if (this.k != null) {
            if (this.r && this.l != null) {
                this.r = false;
                Drawable drawable = getDrawable();
                drawable.setBounds(0, 0, this.l.getWidth(), this.l.getHeight());
                drawable.draw(this.l);
            }
            if (this.q) {
                this.q = false;
                Bitmap bitmap = this.k;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
                bitmapShader.setLocalMatrix(this.f9136c);
                this.f9137d.setShader(bitmapShader);
            }
            canvas.drawCircle(this.f9134a.centerX(), this.f9134a.centerY(), this.m, this.f9137d);
        }
        if (this.f9141h > 0) {
            canvas.drawCircle(this.f9135b.centerX(), this.f9135b.centerY(), this.n, this.f9138e);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        f();
        invalidate();
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.t) {
            return super.onTouchEvent(motionEvent);
        }
        return a(motionEvent.getX(), motionEvent.getY()) && super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z2) {
        if (z2) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(@ColorInt int i2) {
        if (i2 == this.f9140g) {
            return;
        }
        this.f9140g = i2;
        this.f9138e.setColor(i2);
        invalidate();
    }

    public void setBorderOverlay(boolean z2) {
        if (z2 == this.s) {
            return;
        }
        this.s = z2;
        f();
        invalidate();
    }

    public void setBorderWidth(int i2) {
        if (i2 == this.f9141h) {
            return;
        }
        this.f9141h = i2;
        this.f9138e.setStrokeWidth(i2);
        f();
        invalidate();
    }

    public void setCircleBackgroundColor(@ColorInt int i2) {
        if (i2 == this.f9142i) {
            return;
        }
        this.f9142i = i2;
        this.f9139f.setColor(i2);
        invalidate();
    }

    @Deprecated
    public void setCircleBackgroundColorResource(@ColorRes int i2) {
        setCircleBackgroundColor(getContext().getResources().getColor(i2));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.o) {
            return;
        }
        this.o = colorFilter;
        if (this.p) {
            this.f9137d.setColorFilter(colorFilter);
            invalidate();
        }
    }

    public void setDisableCircularTransformation(boolean z2) {
        if (z2 == this.t) {
            return;
        }
        this.t = z2;
        if (z2) {
            this.k = null;
            this.l = null;
            this.f9137d.setShader(null);
        } else {
            e();
        }
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int i2) {
        int i3 = i2 & 255;
        if (i3 == this.j) {
            return;
        }
        this.j = i3;
        if (this.p) {
            this.f9137d.setAlpha(i3);
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        e();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        e();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i2) {
        super.setImageResource(i2);
        e();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        e();
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        f();
        invalidate();
    }

    @Override // android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2, i3, i4, i5);
        f();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != u) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    public boolean a() {
        return this.s;
    }

    public boolean b() {
        return this.t;
    }

    private Bitmap a(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, v);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), v);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private boolean a(float f2, float f3) {
        return this.f9135b.isEmpty() || Math.pow((double) (f2 - this.f9135b.centerX()), 2.0d) + Math.pow((double) (f3 - this.f9135b.centerY()), 2.0d) <= Math.pow((double) this.n, 2.0d);
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9134a = new RectF();
        this.f9135b = new RectF();
        this.f9136c = new Matrix();
        this.f9137d = new Paint();
        this.f9138e = new Paint();
        this.f9139f = new Paint();
        this.f9140g = -16777216;
        this.f9141h = 0;
        this.f9142i = 0;
        this.j = 255;
        d();
    }
}
