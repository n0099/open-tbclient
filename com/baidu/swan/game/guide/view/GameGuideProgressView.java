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
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.k;
import c.a.q0.a.z2.n0;
import c.a.q0.h.j.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001PB\u0011\b\u0016\u0012\u0006\u0010H\u001a\u00020G¢\u0006\u0004\bI\u0010JB\u0019\b\u0016\u0012\u0006\u0010H\u001a\u00020G\u0012\u0006\u0010L\u001a\u00020K¢\u0006\u0004\bI\u0010MB!\b\u0016\u0012\u0006\u0010H\u001a\u00020G\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010N\u001a\u00020\f¢\u0006\u0004\bI\u0010OJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\u0006J/\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\nR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010%\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010'R\u0016\u0010,\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010\u001fR\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010'R$\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b=\u0010\u001fR\u0016\u0010>\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010'R\u0016\u0010?\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00104R\u0016\u0010@\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b@\u0010\u001fR\u0016\u0010A\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010'R\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u00104R\u0016\u0010F\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u00104¨\u0006Q"}, d2 = {"Lcom/baidu/swan/game/guide/view/GameGuideProgressView;", "Landroid/view/View;", "Landroid/graphics/Canvas;", "canvas", "", "drawGradientImg", "(Landroid/graphics/Canvas;)V", "drawProcess", "drawStroke", "init", "()V", "onDraw", "", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "", "process", "reviseProcess", "(F)F", "color", "setProgressColor", "(I)V", "startProcess", "(F)V", "stopProcess", "Landroid/graphics/Paint;", "clipPaint", "Landroid/graphics/Paint;", "Landroid/graphics/Path;", "clipPath$delegate", "Lkotlin/Lazy;", "getClipPath", "()Landroid/graphics/Path;", "clipPath", "currentProgress", "F", "Landroid/graphics/Bitmap;", "gradientBitmap", "Landroid/graphics/Bitmap;", "gradientImgWidth", "imgPaint", "", "isProgressStopped", "Z", "Landroid/graphics/Rect;", "originImgRect", "Landroid/graphics/Rect;", WBConstants.TRANS_PROGRESS_COLOR, "I", "progressHeight", "Lcom/baidu/swan/game/guide/view/GameGuideProgressView$OnGameTimeProgressListener;", "progressListener", "Lcom/baidu/swan/game/guide/view/GameGuideProgressView$OnGameTimeProgressListener;", "getProgressListener", "()Lcom/baidu/swan/game/guide/view/GameGuideProgressView$OnGameTimeProgressListener;", "setProgressListener", "(Lcom/baidu/swan/game/guide/view/GameGuideProgressView$OnGameTimeProgressListener;)V", "progressPaint", "roundCorner", "strokeColor", "strokePaint", "strokeWidth", "Landroid/animation/ValueAnimator;", "valueAnim", "Landroid/animation/ValueAnimator;", "viewHeight", "viewWidth", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OnGameTimeProgressListener", "gameguide_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes11.dex */
public final class GameGuideProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f40951e;

    /* renamed from: f  reason: collision with root package name */
    public int f40952f;

    /* renamed from: g  reason: collision with root package name */
    public int f40953g;

    /* renamed from: h  reason: collision with root package name */
    public float f40954h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f40955i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f40956j;

    /* renamed from: k  reason: collision with root package name */
    public float f40957k;
    public int l;
    public int m;
    public float n;
    public float o;
    public Paint p;
    public Paint q;
    public Bitmap r;
    public Rect s;
    public ValueAnimator t;
    public a u;
    public final Lazy v;
    public HashMap w;

    /* loaded from: classes11.dex */
    public interface a {
        void a(float f2);

        void b(float f2);

        void c();

        void d();
    }

    /* loaded from: classes11.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GameGuideProgressView f40958e;

        public b(GameGuideProgressView gameGuideProgressView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideProgressView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40958e = gameGuideProgressView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Object animatedValue = it.getAnimatedValue();
                if (!(animatedValue instanceof Float)) {
                    animatedValue = null;
                }
                Float f2 = (Float) animatedValue;
                if (f2 != null) {
                    f2.floatValue();
                    GameGuideProgressView gameGuideProgressView = this.f40958e;
                    gameGuideProgressView.o = gameGuideProgressView.e(f2.floatValue());
                    a progressListener = this.f40958e.getProgressListener();
                    if (progressListener != null) {
                        progressListener.b(this.f40958e.o);
                    }
                    this.f40958e.invalidate();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static final class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f40959e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GameGuideProgressView f40960f;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public c(GameGuideProgressView gameGuideProgressView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideProgressView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40960f = gameGuideProgressView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationCancel(animator);
                this.f40959e = true;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a progressListener;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationEnd(animator);
                if (this.f40959e || (progressListener = this.f40960f.getProgressListener()) == null) {
                    return;
                }
                progressListener.c();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                super.onAnimationStart(animator);
                this.f40959e = false;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideProgressView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.f40951e = n0.h(1.0f);
        int parseColor = Color.parseColor("#FFCD5D");
        this.f40952f = parseColor;
        this.f40953g = parseColor;
        this.f40954h = n0.h(20.0f);
        float h2 = n0.h(6.0f);
        this.f40957k = h2;
        this.n = h2 / 2.0f;
        this.v = LazyKt__LazyJVMKt.lazy(GameGuideProgressView$clipPath$2.INSTANCE);
        d();
    }

    private final Path getClipPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? (Path) this.v.getValue() : (Path) invokeV.objValue;
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hashMap = this.w) == null) {
            return;
        }
        hashMap.clear();
    }

    public View _$_findCachedViewById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (this.w == null) {
                this.w = new HashMap();
            }
            View view = (View) this.w.get(Integer.valueOf(i2));
            if (view == null) {
                View findViewById = findViewById(i2);
                this.w.put(Integer.valueOf(i2), findViewById);
                return findViewById;
            }
            return view;
        }
        return (View) invokeI.objValue;
    }

    public final void a(Canvas canvas) {
        Bitmap bitmap;
        Rect rect;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) || (bitmap = this.r) == null || (rect = this.s) == null || bitmap == null) {
            return;
        }
        float f2 = this.o;
        int i3 = this.l;
        float f3 = this.f40954h;
        if (i3 * f2 <= f3) {
            if (rect != null) {
                rect.left = (int) (f3 - (f2 * i3));
            }
            i2 = 0;
        } else {
            if (rect != null) {
                rect.left = 0;
            }
            i2 = (int) ((this.o * this.l) - this.f40954h);
        }
        Rect rect2 = new Rect(i2, 0, (int) (this.o * this.l), this.m);
        Rect rect3 = this.s;
        Paint paint = this.p;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgPaint");
        }
        canvas.drawBitmap(bitmap, rect3, rect2, paint);
        if (i2 == 0) {
            getClipPath().reset();
            int i4 = this.m;
            float f4 = this.f40957k;
            float f5 = 2;
            float f6 = this.f40951e;
            RectF rectF = new RectF(0.0f, ((i4 / 2.0f) - (f4 / f5)) - (f6 / f5), this.l, (i4 / 2.0f) + (f4 / f5) + (f6 / f5));
            float f7 = this.n;
            getClipPath().addRoundRect(rectF, new float[]{f7, f7, f7, f7, f7, f7, f7, f7}, Path.Direction.CW);
            if (Build.VERSION.SDK_INT <= 27) {
                Paint paint2 = this.q;
                if (paint2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clipPaint");
                }
                paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                Path clipPath = getClipPath();
                Paint paint3 = this.q;
                if (paint3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clipPaint");
                }
                canvas.drawPath(clipPath, paint3);
                return;
            }
            Paint paint4 = this.q;
            if (paint4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clipPaint");
            }
            paint4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            Path path = new Path();
            path.addRect(-1.0f, -1.0f, this.l, this.m, Path.Direction.CW);
            path.op(getClipPath(), Path.Op.DIFFERENCE);
            Paint paint5 = this.q;
            if (paint5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clipPaint");
            }
            canvas.drawPath(path, paint5);
        }
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            float f2 = this.o;
            if (f2 == 0.0f) {
                return;
            }
            float e2 = e(f2);
            this.o = e2;
            float f3 = this.f40951e;
            float f4 = 2;
            int i2 = this.m;
            float f5 = this.f40957k;
            RectF rectF = new RectF((f3 / f4) + 0.0f, (i2 / 2.0f) - (f5 / 2.0f), (e2 * this.l) - (f3 / f4), (i2 / 2.0f) + (f5 / 2.0f));
            float f6 = this.n;
            Paint paint = this.f40956j;
            if (paint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
            }
            canvas.drawRoundRect(rectF, f6, f6, paint);
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            float f2 = this.f40951e;
            float f3 = 2;
            float f4 = this.l - (f2 / f3);
            int i2 = this.m;
            float f5 = this.f40957k;
            RectF rectF = new RectF((f2 / f3) + 0.0f, (i2 / 2.0f) - (f5 / 2.0f), f4, (i2 / 2.0f) + (f5 / 2.0f));
            float f6 = this.n;
            Paint paint = this.f40955i;
            if (paint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("strokePaint");
            }
            canvas.drawRoundRect(rectF, f6, f6, paint);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Paint paint = new Paint(1);
            this.f40955i = paint;
            if (paint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("strokePaint");
            }
            paint.setStrokeWidth(this.f40951e);
            Paint paint2 = this.f40955i;
            if (paint2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("strokePaint");
            }
            paint2.setColor(this.f40952f);
            Paint paint3 = this.f40955i;
            if (paint3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("strokePaint");
            }
            paint3.setStyle(Paint.Style.STROKE);
            Paint paint4 = new Paint(1);
            this.f40956j = paint4;
            if (paint4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
            }
            paint4.setColor(this.f40953g);
            Paint paint5 = this.f40956j;
            if (paint5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
            }
            paint5.setStyle(Paint.Style.FILL);
            Paint paint6 = new Paint(1);
            this.p = paint6;
            if (paint6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgPaint");
            }
            paint6.setFilterBitmap(true);
            Paint paint7 = this.p;
            if (paint7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgPaint");
            }
            paint7.setDither(true);
            Paint paint8 = new Paint(1);
            this.q = paint8;
            if (paint8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clipPaint");
            }
            paint8.setStyle(Paint.Style.FILL);
            Context appContext = AppRuntime.getAppContext();
            Intrinsics.checkNotNullExpressionValue(appContext, "AppRuntime.getAppContext()");
            Drawable drawable = appContext.getResources().getDrawable(g.aiapps_game_guide_progress_view_gradient_bg);
            if (!(drawable instanceof BitmapDrawable)) {
                drawable = null;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable != null ? bitmapDrawable.getBitmap() : null;
            this.r = bitmap;
            if (bitmap != null) {
                this.s = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            }
        }
    }

    public final float e(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048582, this, f2)) == null) {
            if (f2 < 0.0f) {
                return 0.0f;
            }
            if (f2 > 1.0f) {
                return 1.0f;
            }
            return f2;
        }
        return invokeF.floatValue;
    }

    public final a getProgressListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.u : (a) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            super.onDraw(canvas);
            if (canvas == null) {
                return;
            }
            c(canvas);
            b(canvas);
            a(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048585, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.l = i2;
            this.m = i3;
            if (i2 <= this.f40954h) {
                if (!k.a) {
                    this.f40954h = i2;
                    return;
                }
                throw new RuntimeException("进度条宽度异常");
            }
        }
    }

    public final void setProgressColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            Paint paint = this.f40955i;
            if (paint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("strokePaint");
            }
            paint.setColor(i2);
            Paint paint2 = this.f40956j;
            if (paint2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
            }
            paint2.setColor(i2);
        }
    }

    public final void setProgressListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.u = aVar;
        }
    }

    public final void startProcess(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f2) == null) {
            float e2 = e(f2);
            this.o = e2;
            if (e2 == 1.0f) {
                boolean z = k.a;
                invalidate();
                return;
            }
            long j2 = ((float) 30000) * (1.0f - e2);
            long j3 = j2 != 0 ? j2 : 30000L;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.o, 1.0f);
            this.t = ofFloat;
            if (ofFloat != null) {
                ofFloat.setDuration(j3);
            }
            ValueAnimator valueAnimator = this.t;
            if (valueAnimator != null) {
                valueAnimator.setInterpolator(new LinearInterpolator());
            }
            ValueAnimator valueAnimator2 = this.t;
            if (valueAnimator2 != null) {
                valueAnimator2.addUpdateListener(new b(this));
            }
            ValueAnimator valueAnimator3 = this.t;
            if (valueAnimator3 != null) {
                valueAnimator3.addListener(new c(this));
            }
            a aVar = this.u;
            if (aVar != null) {
                aVar.a(this.o);
            }
            ValueAnimator valueAnimator4 = this.t;
            if (valueAnimator4 != null) {
                valueAnimator4.start();
            }
        }
    }

    public final void stopProcess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ValueAnimator valueAnimator = this.t;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            a aVar = this.u;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        this.f40951e = n0.h(1.0f);
        int parseColor = Color.parseColor("#FFCD5D");
        this.f40952f = parseColor;
        this.f40953g = parseColor;
        this.f40954h = n0.h(20.0f);
        float h2 = n0.h(6.0f);
        this.f40957k = h2;
        this.n = h2 / 2.0f;
        this.v = LazyKt__LazyJVMKt.lazy(GameGuideProgressView$clipPath$2.INSTANCE);
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        this.f40951e = n0.h(1.0f);
        int parseColor = Color.parseColor("#FFCD5D");
        this.f40952f = parseColor;
        this.f40953g = parseColor;
        this.f40954h = n0.h(20.0f);
        float h2 = n0.h(6.0f);
        this.f40957k = h2;
        this.n = h2 / 2.0f;
        this.v = LazyKt__LazyJVMKt.lazy(GameGuideProgressView$clipPath$2.INSTANCE);
        d();
    }
}
