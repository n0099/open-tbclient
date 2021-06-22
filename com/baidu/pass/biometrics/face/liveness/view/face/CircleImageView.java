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
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
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
    public final RectF f9188a;

    /* renamed from: b  reason: collision with root package name */
    public final RectF f9189b;

    /* renamed from: c  reason: collision with root package name */
    public final Matrix f9190c;

    /* renamed from: d  reason: collision with root package name */
    public final Paint f9191d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f9192e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f9193f;

    /* renamed from: g  reason: collision with root package name */
    public int f9194g;

    /* renamed from: h  reason: collision with root package name */
    public int f9195h;

    /* renamed from: i  reason: collision with root package name */
    public int f9196i;
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

    /* loaded from: classes2.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            CircleImageView.this.setBackgroundColor(0);
            CircleImageView.this.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

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
            CircleImageView.this.f9189b.roundOut(rect);
            outline.setRoundRect(rect, rect.width() / 2.0f);
        }

        public /* synthetic */ b(CircleImageView circleImageView, a aVar) {
            this();
        }
    }

    public CircleImageView(Context context) {
        super(context);
        this.f9188a = new RectF();
        this.f9189b = new RectF();
        this.f9190c = new Matrix();
        this.f9191d = new Paint();
        this.f9192e = new Paint();
        this.f9193f = new Paint();
        this.f9194g = -16777216;
        this.f9195h = 0;
        this.f9196i = 0;
        this.j = 255;
        e();
    }

    private RectF d() {
        int width;
        int height;
        int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float paddingLeft = getPaddingLeft() + ((width - min) / 2.0f);
        float paddingTop = getPaddingTop() + ((height - min) / 2.0f);
        float f2 = min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f2, f2 + paddingTop);
    }

    private void e() {
        this.p = true;
        super.setScaleType(u);
        this.f9191d.setAntiAlias(true);
        this.f9191d.setDither(true);
        this.f9191d.setFilterBitmap(true);
        this.f9191d.setAlpha(this.j);
        this.f9191d.setColorFilter(this.o);
        this.f9192e.setStyle(Paint.Style.STROKE);
        this.f9192e.setAntiAlias(true);
        this.f9192e.setColor(this.f9194g);
        this.f9192e.setStrokeWidth(this.f9195h);
        this.f9193f.setStyle(Paint.Style.FILL);
        this.f9193f.setAntiAlias(true);
        this.f9193f.setColor(this.f9196i);
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b(this, null));
        }
    }

    private void f() {
        Bitmap a2 = a(getDrawable());
        this.k = a2;
        if (a2 != null && a2.isMutable()) {
            this.l = new Canvas(this.k);
        } else {
            this.l = null;
        }
        if (this.p) {
            if (this.k != null) {
                h();
            } else {
                this.f9191d.setShader(null);
            }
        }
    }

    private void g() {
        int i2;
        this.f9189b.set(d());
        this.n = Math.min((this.f9189b.height() - this.f9195h) / 2.0f, (this.f9189b.width() - this.f9195h) / 2.0f);
        this.f9188a.set(this.f9189b);
        if (!this.s && (i2 = this.f9195h) > 0) {
            float f2 = i2 - 1.0f;
            this.f9188a.inset(f2, f2);
        }
        this.m = Math.min(this.f9188a.height() / 2.0f, this.f9188a.width() / 2.0f);
        h();
    }

    private void h() {
        float width;
        float height;
        if (this.k == null) {
            return;
        }
        this.f9190c.set(null);
        int height2 = this.k.getHeight();
        float width2 = this.k.getWidth();
        float f2 = height2;
        float f3 = 0.0f;
        if (this.f9188a.height() * width2 > this.f9188a.width() * f2) {
            width = this.f9188a.height() / f2;
            f3 = (this.f9188a.width() - (width2 * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = this.f9188a.width() / width2;
            height = (this.f9188a.height() - (f2 * width)) * 0.5f;
        }
        this.f9190c.setScale(width, width);
        Matrix matrix = this.f9190c;
        RectF rectF = this.f9188a;
        matrix.postTranslate(((int) (f3 + 0.5f)) + rectF.left, ((int) (height + 0.5f)) + rectF.top);
        this.q = true;
    }

    public void c() {
        setBackgroundColor(-1);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setAnimationListener(new a());
        startAnimation(alphaAnimation);
    }

    public int getBorderColor() {
        return this.f9194g;
    }

    public int getBorderWidth() {
        return this.f9195h;
    }

    public int getCircleBackgroundColor() {
        return this.f9196i;
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
        if (this.f9196i != 0) {
            canvas.drawCircle(this.f9188a.centerX(), this.f9188a.centerY(), this.m, this.f9193f);
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
                bitmapShader.setLocalMatrix(this.f9190c);
                this.f9191d.setShader(bitmapShader);
            }
            canvas.drawCircle(this.f9188a.centerX(), this.f9188a.centerY(), this.m, this.f9191d);
        }
        if (this.f9195h > 0) {
            canvas.drawCircle(this.f9189b.centerX(), this.f9189b.centerY(), this.n, this.f9192e);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        g();
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
        if (i2 == this.f9194g) {
            return;
        }
        this.f9194g = i2;
        this.f9192e.setColor(i2);
        invalidate();
    }

    public void setBorderOverlay(boolean z2) {
        if (z2 == this.s) {
            return;
        }
        this.s = z2;
        g();
        invalidate();
    }

    public void setBorderWidth(int i2) {
        if (i2 == this.f9195h) {
            return;
        }
        this.f9195h = i2;
        this.f9192e.setStrokeWidth(i2);
        g();
        invalidate();
    }

    public void setCircleBackgroundColor(@ColorInt int i2) {
        if (i2 == this.f9196i) {
            return;
        }
        this.f9196i = i2;
        this.f9193f.setColor(i2);
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
            this.f9191d.setColorFilter(colorFilter);
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
            this.f9191d.setShader(null);
        } else {
            f();
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
            this.f9191d.setAlpha(i3);
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        f();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        f();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i2) {
        super.setImageResource(i2);
        f();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        f();
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        g();
        invalidate();
    }

    @Override // android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2, i3, i4, i5);
        g();
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
        return this.f9189b.isEmpty() || Math.pow((double) (f2 - this.f9189b.centerX()), 2.0d) + Math.pow((double) (f3 - this.f9189b.centerY()), 2.0d) <= Math.pow((double) this.n, 2.0d);
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9188a = new RectF();
        this.f9189b = new RectF();
        this.f9190c = new Matrix();
        this.f9191d = new Paint();
        this.f9192e = new Paint();
        this.f9193f = new Paint();
        this.f9194g = -16777216;
        this.f9195h = 0;
        this.f9196i = 0;
        this.j = 255;
        e();
    }
}
