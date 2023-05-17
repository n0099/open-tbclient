package com.baidu.swan.game.guide.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
import com.baidu.tieba.qp1;
import com.baidu.tieba.xm3;
import com.sina.weibo.sdk.constant.WBConstants;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001PB\u0011\b\u0016\u0012\u0006\u0010H\u001a\u00020G¢\u0006\u0004\bI\u0010JB\u0019\b\u0016\u0012\u0006\u0010H\u001a\u00020G\u0012\u0006\u0010L\u001a\u00020K¢\u0006\u0004\bI\u0010MB!\b\u0016\u0012\u0006\u0010H\u001a\u00020G\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010N\u001a\u00020\f¢\u0006\u0004\bI\u0010OJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\u0006J/\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\nR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010%\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010'R\u0016\u0010,\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010\u001fR\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010'R$\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b=\u0010\u001fR\u0016\u0010>\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010'R\u0016\u0010?\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00104R\u0016\u0010@\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b@\u0010\u001fR\u0016\u0010A\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010'R\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u00104R\u0016\u0010F\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u00104¨\u0006Q"}, d2 = {"Lcom/baidu/swan/game/guide/view/GameGuideProgressView;", "Landroid/view/View;", "Landroid/graphics/Canvas;", "canvas", "", "drawGradientImg", "(Landroid/graphics/Canvas;)V", "drawProcess", "drawStroke", "init", "()V", "onDraw", "", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "", "process", "reviseProcess", "(F)F", "color", "setProgressColor", "(I)V", "startProcess", "(F)V", "stopProcess", "Landroid/graphics/Paint;", "clipPaint", "Landroid/graphics/Paint;", "Landroid/graphics/Path;", "clipPath$delegate", "Lkotlin/Lazy;", "getClipPath", "()Landroid/graphics/Path;", "clipPath", "currentProgress", "F", "Landroid/graphics/Bitmap;", "gradientBitmap", "Landroid/graphics/Bitmap;", "gradientImgWidth", "imgPaint", "", "isProgressStopped", "Z", "Landroid/graphics/Rect;", "originImgRect", "Landroid/graphics/Rect;", WBConstants.TRANS_PROGRESS_COLOR, "I", "progressHeight", "Lcom/baidu/swan/game/guide/view/GameGuideProgressView$OnGameTimeProgressListener;", "progressListener", "Lcom/baidu/swan/game/guide/view/GameGuideProgressView$OnGameTimeProgressListener;", "getProgressListener", "()Lcom/baidu/swan/game/guide/view/GameGuideProgressView$OnGameTimeProgressListener;", "setProgressListener", "(Lcom/baidu/swan/game/guide/view/GameGuideProgressView$OnGameTimeProgressListener;)V", "progressPaint", "roundCorner", "strokeColor", "strokePaint", "strokeWidth", "Landroid/animation/ValueAnimator;", "valueAnim", "Landroid/animation/ValueAnimator;", "viewHeight", "viewWidth", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OnGameTimeProgressListener", "gameguide_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class GameGuideProgressView extends View {
    public float a;
    public int b;
    public int c;
    public float d;
    public Paint e;
    public Paint f;
    public float g;
    public int h;
    public int i;
    public float j;
    public float k;
    public Paint l;
    public Paint m;
    public Bitmap n;
    public Rect o;
    public ValueAnimator p;
    public a q;
    public final Lazy r;

    /* loaded from: classes4.dex */
    public interface a {
        void a(float f);

        void b(float f);

        void c();

        void d();
    }

    private final Path getClipPath() {
        return (Path) this.r.getValue();
    }

    public final float h(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    /* loaded from: classes4.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Object animatedValue = it.getAnimatedValue();
            if (!(animatedValue instanceof Float)) {
                animatedValue = null;
            }
            Float f = (Float) animatedValue;
            if (f != null) {
                f.floatValue();
                GameGuideProgressView gameGuideProgressView = GameGuideProgressView.this;
                gameGuideProgressView.k = gameGuideProgressView.h(f.floatValue());
                a progressListener = GameGuideProgressView.this.getProgressListener();
                if (progressListener != null) {
                    progressListener.b(GameGuideProgressView.this.k);
                }
                GameGuideProgressView.this.invalidate();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c extends AnimatorListenerAdapter {
        public boolean a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a progressListener;
            super.onAnimationEnd(animator);
            if (!this.a && (progressListener = GameGuideProgressView.this.getProgressListener()) != null) {
                progressListener.c();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.a = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideProgressView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = xm3.h(1.0f);
        int parseColor = Color.parseColor("#FFCD5D");
        this.b = parseColor;
        this.c = parseColor;
        this.d = xm3.h(20.0f);
        float h = xm3.h(6.0f);
        this.g = h;
        this.j = h / 2.0f;
        this.r = LazyKt__LazyJVMKt.lazy(GameGuideProgressView$clipPath$2.INSTANCE);
        g();
    }

    public final void e(Canvas canvas) {
        float f = this.k;
        if (f == 0.0f) {
            return;
        }
        float h = h(f);
        this.k = h;
        float f2 = this.a;
        float f3 = 2;
        int i = this.i;
        float f4 = this.g;
        RectF rectF = new RectF((f2 / f3) + 0.0f, (i / 2.0f) - (f4 / 2.0f), (h * this.h) - (f2 / f3), (i / 2.0f) + (f4 / 2.0f));
        float f5 = this.j;
        Paint paint = this.f;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
        }
        canvas.drawRoundRect(rectF, f5, f5, paint);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        this.a = xm3.h(1.0f);
        int parseColor = Color.parseColor("#FFCD5D");
        this.b = parseColor;
        this.c = parseColor;
        this.d = xm3.h(20.0f);
        float h = xm3.h(6.0f);
        this.g = h;
        this.j = h / 2.0f;
        this.r = LazyKt__LazyJVMKt.lazy(GameGuideProgressView$clipPath$2.INSTANCE);
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        this.a = xm3.h(1.0f);
        int parseColor = Color.parseColor("#FFCD5D");
        this.b = parseColor;
        this.c = parseColor;
        this.d = xm3.h(20.0f);
        float h = xm3.h(6.0f);
        this.g = h;
        this.j = h / 2.0f;
        this.r = LazyKt__LazyJVMKt.lazy(GameGuideProgressView$clipPath$2.INSTANCE);
        g();
    }

    public final void f(Canvas canvas) {
        float f = this.a;
        float f2 = 2;
        float f3 = this.h - (f / f2);
        int i = this.i;
        float f4 = this.g;
        RectF rectF = new RectF((f / f2) + 0.0f, (i / 2.0f) - (f4 / 2.0f), f3, (i / 2.0f) + (f4 / 2.0f));
        float f5 = this.j;
        Paint paint = this.e;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("strokePaint");
        }
        canvas.drawRoundRect(rectF, f5, f5, paint);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas == null) {
            return;
        }
        f(canvas);
        e(canvas);
        d(canvas);
    }

    public final void setProgressColor(int i) {
        Paint paint = this.e;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("strokePaint");
        }
        paint.setColor(i);
        Paint paint2 = this.f;
        if (paint2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
        }
        paint2.setColor(i);
    }

    public final void setProgressListener(a aVar) {
        this.q = aVar;
    }

    public final void d(Canvas canvas) {
        Rect rect;
        int i;
        Bitmap bitmap = this.n;
        if (bitmap != null && (rect = this.o) != null && bitmap != null) {
            float f = this.k;
            int i2 = this.h;
            float f2 = this.d;
            if (i2 * f <= f2) {
                if (rect != null) {
                    rect.left = (int) (f2 - (f * i2));
                }
                i = 0;
            } else {
                if (rect != null) {
                    rect.left = 0;
                }
                i = (int) ((this.k * this.h) - this.d);
            }
            Rect rect2 = new Rect(i, 0, (int) (this.k * this.h), this.i);
            Rect rect3 = this.o;
            Paint paint = this.l;
            if (paint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgPaint");
            }
            canvas.drawBitmap(bitmap, rect3, rect2, paint);
            if (i == 0) {
                getClipPath().reset();
                int i3 = this.i;
                float f3 = this.g;
                float f4 = 2;
                float f5 = this.a;
                RectF rectF = new RectF(0.0f, ((i3 / 2.0f) - (f3 / f4)) - (f5 / f4), this.h, (i3 / 2.0f) + (f3 / f4) + (f5 / f4));
                float f6 = this.j;
                getClipPath().addRoundRect(rectF, new float[]{f6, f6, f6, f6, f6, f6, f6, f6}, Path.Direction.CW);
                if (Build.VERSION.SDK_INT <= 27) {
                    Paint paint2 = this.m;
                    if (paint2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipPaint");
                    }
                    paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                    Path clipPath = getClipPath();
                    Paint paint3 = this.m;
                    if (paint3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipPaint");
                    }
                    canvas.drawPath(clipPath, paint3);
                    return;
                }
                Paint paint4 = this.m;
                if (paint4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clipPaint");
                }
                paint4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
                Path path = new Path();
                path.addRect(-1.0f, -1.0f, this.h, this.i, Path.Direction.CW);
                path.op(getClipPath(), Path.Op.DIFFERENCE);
                Paint paint5 = this.m;
                if (paint5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clipPaint");
                }
                canvas.drawPath(path, paint5);
            }
        }
    }

    public final void g() {
        Paint paint = new Paint(1);
        this.e = paint;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("strokePaint");
        }
        paint.setStrokeWidth(this.a);
        Paint paint2 = this.e;
        if (paint2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("strokePaint");
        }
        paint2.setColor(this.b);
        Paint paint3 = this.e;
        if (paint3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("strokePaint");
        }
        paint3.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint(1);
        this.f = paint4;
        if (paint4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
        }
        paint4.setColor(this.c);
        Paint paint5 = this.f;
        if (paint5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
        }
        paint5.setStyle(Paint.Style.FILL);
        Paint paint6 = new Paint(1);
        this.l = paint6;
        if (paint6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgPaint");
        }
        paint6.setFilterBitmap(true);
        Paint paint7 = this.l;
        if (paint7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgPaint");
        }
        paint7.setDither(true);
        Paint paint8 = new Paint(1);
        this.m = paint8;
        if (paint8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clipPaint");
        }
        paint8.setStyle(Paint.Style.FILL);
        Context appContext = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "AppRuntime.getAppContext()");
        Drawable drawable = appContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08017d);
        Bitmap bitmap = null;
        if (!(drawable instanceof BitmapDrawable)) {
            drawable = null;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        if (bitmapDrawable != null) {
            bitmap = bitmapDrawable.getBitmap();
        }
        this.n = bitmap;
        if (bitmap != null) {
            this.o = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    public final a getProgressListener() {
        return this.q;
    }

    public final void j() {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        a aVar = this.q;
        if (aVar != null) {
            aVar.d();
        }
    }

    public final void i(float f) {
        float h = h(f);
        this.k = h;
        if (h == 1.0f) {
            if (qp1.a) {
                Log.d("GameTimeProgressView", "当前进度为1，不处理");
            }
            invalidate();
            return;
        }
        long j = 30000;
        long j2 = ((float) 30000) * (1.0f - h);
        if (j2 != 0) {
            j = j2;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.k, 1.0f);
        this.p = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(j);
        }
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.setInterpolator(new LinearInterpolator());
        }
        ValueAnimator valueAnimator2 = this.p;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new b());
        }
        ValueAnimator valueAnimator3 = this.p;
        if (valueAnimator3 != null) {
            valueAnimator3.addListener(new c());
        }
        a aVar = this.q;
        if (aVar != null) {
            aVar.a(this.k);
        }
        ValueAnimator valueAnimator4 = this.p;
        if (valueAnimator4 != null) {
            valueAnimator4.start();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.h = i;
        this.i = i2;
        if (i <= this.d) {
            if (!qp1.a) {
                this.d = i;
                return;
            }
            throw new RuntimeException("进度条宽度异常");
        }
    }
}
