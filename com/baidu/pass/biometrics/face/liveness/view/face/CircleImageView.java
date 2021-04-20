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
    public final RectF f9270a;

    /* renamed from: b  reason: collision with root package name */
    public final RectF f9271b;

    /* renamed from: c  reason: collision with root package name */
    public final Matrix f9272c;

    /* renamed from: d  reason: collision with root package name */
    public final Paint f9273d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f9274e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f9275f;

    /* renamed from: g  reason: collision with root package name */
    public int f9276g;

    /* renamed from: h  reason: collision with root package name */
    public int f9277h;
    public int i;
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
            CircleImageView.this.f9271b.roundOut(rect);
            outline.setRoundRect(rect, rect.width() / 2.0f);
        }
    }

    public CircleImageView(Context context) {
        super(context);
        this.f9270a = new RectF();
        this.f9271b = new RectF();
        this.f9272c = new Matrix();
        this.f9273d = new Paint();
        this.f9274e = new Paint();
        this.f9275f = new Paint();
        this.f9276g = -16777216;
        this.f9277h = 0;
        this.i = 0;
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
        this.f9273d.setAntiAlias(true);
        this.f9273d.setDither(true);
        this.f9273d.setFilterBitmap(true);
        this.f9273d.setAlpha(this.j);
        this.f9273d.setColorFilter(this.o);
        this.f9274e.setStyle(Paint.Style.STROKE);
        this.f9274e.setAntiAlias(true);
        this.f9274e.setColor(this.f9276g);
        this.f9274e.setStrokeWidth(this.f9277h);
        this.f9275f.setStyle(Paint.Style.FILL);
        this.f9275f.setAntiAlias(true);
        this.f9275f.setColor(this.i);
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
                this.f9273d.setShader(null);
            }
        }
    }

    private void f() {
        int i;
        this.f9271b.set(c());
        this.n = Math.min((this.f9271b.height() - this.f9277h) / 2.0f, (this.f9271b.width() - this.f9277h) / 2.0f);
        this.f9270a.set(this.f9271b);
        if (!this.s && (i = this.f9277h) > 0) {
            float f2 = i - 1.0f;
            this.f9270a.inset(f2, f2);
        }
        this.m = Math.min(this.f9270a.height() / 2.0f, this.f9270a.width() / 2.0f);
        g();
    }

    private void g() {
        float width;
        float height;
        if (this.k == null) {
            return;
        }
        this.f9272c.set(null);
        int height2 = this.k.getHeight();
        float width2 = this.k.getWidth();
        float f2 = height2;
        float f3 = 0.0f;
        if (this.f9270a.height() * width2 > this.f9270a.width() * f2) {
            width = this.f9270a.height() / f2;
            f3 = (this.f9270a.width() - (width2 * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = this.f9270a.width() / width2;
            height = (this.f9270a.height() - (f2 * width)) * 0.5f;
        }
        this.f9272c.setScale(width, width);
        Matrix matrix = this.f9272c;
        RectF rectF = this.f9270a;
        matrix.postTranslate(((int) (f3 + 0.5f)) + rectF.left, ((int) (height + 0.5f)) + rectF.top);
        this.q = true;
    }

    public int getBorderColor() {
        return this.f9276g;
    }

    public int getBorderWidth() {
        return this.f9277h;
    }

    public int getCircleBackgroundColor() {
        return this.i;
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
        if (this.i != 0) {
            canvas.drawCircle(this.f9270a.centerX(), this.f9270a.centerY(), this.m, this.f9275f);
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
                bitmapShader.setLocalMatrix(this.f9272c);
                this.f9273d.setShader(bitmapShader);
            }
            canvas.drawCircle(this.f9270a.centerX(), this.f9270a.centerY(), this.m, this.f9273d);
        }
        if (this.f9277h > 0) {
            canvas.drawCircle(this.f9271b.centerX(), this.f9271b.centerY(), this.n, this.f9274e);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
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

    public void setBorderColor(@ColorInt int i) {
        if (i == this.f9276g) {
            return;
        }
        this.f9276g = i;
        this.f9274e.setColor(i);
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

    public void setBorderWidth(int i) {
        if (i == this.f9277h) {
            return;
        }
        this.f9277h = i;
        this.f9274e.setStrokeWidth(i);
        f();
        invalidate();
    }

    public void setCircleBackgroundColor(@ColorInt int i) {
        if (i == this.i) {
            return;
        }
        this.i = i;
        this.f9275f.setColor(i);
        invalidate();
    }

    @Deprecated
    public void setCircleBackgroundColorResource(@ColorRes int i) {
        setCircleBackgroundColor(getContext().getResources().getColor(i));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.o) {
            return;
        }
        this.o = colorFilter;
        if (this.p) {
            this.f9273d.setColorFilter(colorFilter);
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
            this.f9273d.setShader(null);
        } else {
            e();
        }
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int i) {
        int i2 = i & 255;
        if (i2 == this.j) {
            return;
        }
        this.j = i2;
        if (this.p) {
            this.f9273d.setAlpha(i2);
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
    public void setImageResource(@DrawableRes int i) {
        super.setImageResource(i);
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
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        f();
        invalidate();
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
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
        return this.f9271b.isEmpty() || Math.pow((double) (f2 - this.f9271b.centerX()), 2.0d) + Math.pow((double) (f3 - this.f9271b.centerY()), 2.0d) <= Math.pow((double) this.n, 2.0d);
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9270a = new RectF();
        this.f9271b = new RectF();
        this.f9272c = new Matrix();
        this.f9273d = new Paint();
        this.f9274e = new Paint();
        this.f9275f = new Paint();
        this.f9276g = -16777216;
        this.f9277h = 0;
        this.i = 0;
        this.j = 255;
        d();
    }
}
