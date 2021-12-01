package com.baidu.swan.game.guide.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.h.j.h;
import c.a.p0.h.j.i;
import c.a.p0.h.j.j;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.guide.view.GameGuideProgressView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010?\u001a\u00020)\u0012\u0006\u0010@\u001a\u000201\u0012\u0006\u0010A\u001a\u00020,\u0012\u0006\u0010B\u001a\u00020,¢\u0006\u0004\bC\u0010DB\u0019\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010F\u001a\u00020E¢\u0006\u0004\bC\u0010GB!\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010F\u001a\u00020E\u0012\u0006\u0010H\u001a\u00020\u000e¢\u0006\u0004\bC\u0010IJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\tJ!\u0010\u0015\u001a\u00020\u00072\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\tJ\u0015\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010\tJ\u000f\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010\tJ\r\u0010$\u001a\u00020\u0007¢\u0006\u0004\b$\u0010\tJ\u0017\u0010%\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b%\u0010!J\u000f\u0010&\u001a\u00020\u0007H\u0002¢\u0006\u0004\b&\u0010\tR\u0016\u0010'\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010.R\u001c\u00105\u001a\u00020\u000e8B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b5\u0010(\u001a\u0004\b6\u0010\u0010R\u001c\u00107\u001a\u00020\u00188B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001c\u0010;\u001a\u00020\u00188B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b;\u00108\u001a\u0004\b<\u0010:¨\u0006J"}, d2 = {"Lcom/baidu/swan/game/guide/view/GameGuideView;", "Landroid/widget/FrameLayout;", "", "gameTime", "", "checkGameTimeAvailable", "(J)Z", "", "checkIsShowTips", "()V", "Landroid/view/View;", "coinView", "doCoinScaleAnim", "(Landroid/view/View;)V", "", "getCurrentStatus", "()I", "init", "Landroid/util/SparseArray;", "Landroid/os/Parcelable;", "container", "restoreHierarchyState", "(Landroid/util/SparseArray;)V", "restoreTailingView", "", "currentProgress", "reviseViewLayout", "(F)V", "Lcom/airbnb/lottie/LottieAnimationView;", "view", "setSaveDisable", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "startTime", "(J)V", "stopTime", "translateTailingView", "updateStatusWhenClick", "updateViewStatusByGameTimeWhenStart", "updateWhenOneProgressEnd", "currentStatus", "I", "Lcom/airbnb/lottie/LottieComposition;", "doneComposition", "Lcom/airbnb/lottie/LottieComposition;", "", "firstDoneTips", "Ljava/lang/String;", "isOnTiming", "Z", "Landroid/graphics/Bitmap;", "normalIconImg", "Landroid/graphics/Bitmap;", WBConstants.TRANS_PROGRESS_COLOR, "progressViewWidth", "getProgressViewWidth", "tailingViewOriginCenterX", "F", "getTailingViewOriginCenterX", "()F", "tailingViewOriginCenterY", "getTailingViewOriginCenterY", "Landroid/content/Context;", "context", "composition", "normalImg", "proColor", "tips", "<init>", "(Landroid/content/Context;Lcom/airbnb/lottie/LottieComposition;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gameguide_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class GameGuideView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f40472e;

    /* renamed from: f  reason: collision with root package name */
    public int f40473f;

    /* renamed from: g  reason: collision with root package name */
    public float f40474g;

    /* renamed from: h  reason: collision with root package name */
    public float f40475h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40476i;

    /* renamed from: j  reason: collision with root package name */
    public LottieComposition f40477j;

    /* renamed from: k  reason: collision with root package name */
    public String f40478k;
    public String l;
    public Bitmap m;
    public HashMap n;

    /* loaded from: classes9.dex */
    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f40479e;

        public a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40479e = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Object animatedValue = it.getAnimatedValue();
                if (animatedValue != null) {
                    float floatValue = ((Float) animatedValue).floatValue();
                    this.f40479e.setScaleX(floatValue);
                    this.f40479e.setScaleY(floatValue);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class b implements GameGuideProgressView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameGuideView a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b(GameGuideView gameGuideView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameGuideView;
        }

        @Override // com.baidu.swan.game.guide.view.GameGuideProgressView.a
        public void a(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
                this.a.reviseViewLayout(f2);
            }
        }

        @Override // com.baidu.swan.game.guide.view.GameGuideProgressView.a
        public void b(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                this.a.reviseViewLayout(f2);
            }
        }

        @Override // com.baidu.swan.game.guide.view.GameGuideProgressView.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.f40476i && (this.a.f40473f == 0 || this.a.f40473f == 1)) {
                    ((GameGuideProgressView) this.a._$_findCachedViewById(h.progress_view)).startProcess(0.0f);
                }
                this.a.h();
            }
        }

        @Override // com.baidu.swan.game.guide.view.GameGuideProgressView.a
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GameGuideView f40480e;

        public c(GameGuideView gameGuideView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40480e = gameGuideView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Object animatedValue = it.getAnimatedValue();
                if (animatedValue != null) {
                    float floatValue = ((Float) animatedValue).floatValue();
                    LottieAnimationView tailing_view = (LottieAnimationView) this.f40480e._$_findCachedViewById(h.tailing_view);
                    Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
                    ViewGroup.LayoutParams layoutParams = tailing_view.getLayoutParams();
                    if (layoutParams != null) {
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = (int) floatValue;
                        LottieAnimationView tailing_view2 = (LottieAnimationView) this.f40480e._$_findCachedViewById(h.tailing_view);
                        Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
                        tailing_view2.setLayoutParams(layoutParams2);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GameGuideView f40481e;

        public d(GameGuideView gameGuideView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40481e = gameGuideView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Object animatedValue = it.getAnimatedValue();
                if (animatedValue != null) {
                    float floatValue = ((Float) animatedValue).floatValue();
                    LottieAnimationView tailing_view = (LottieAnimationView) this.f40481e._$_findCachedViewById(h.tailing_view);
                    Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
                    ViewGroup.LayoutParams layoutParams = tailing_view.getLayoutParams();
                    if (layoutParams != null) {
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = (int) floatValue;
                        LottieAnimationView tailing_view2 = (LottieAnimationView) this.f40481e._$_findCachedViewById(h.tailing_view);
                        Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
                        tailing_view2.setLayoutParams(layoutParams2);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GameGuideView f40482e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f40483f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ double f40484g;

        public e(GameGuideView gameGuideView, Ref.BooleanRef booleanRef, double d2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideView, booleanRef, Double.valueOf(d2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40482e = gameGuideView;
            this.f40483f = booleanRef;
            this.f40484g = d2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                if (this.f40482e.f40476i) {
                    Ref.BooleanRef booleanRef = this.f40483f;
                    if (booleanRef.element) {
                        return;
                    }
                    booleanRef.element = true;
                    LottieAnimationView tailing_view = (LottieAnimationView) this.f40482e._$_findCachedViewById(h.tailing_view);
                    Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
                    tailing_view.setRotation(90 - ((float) this.f40484g));
                    this.f40482e.e();
                    LottieAnimationView tailing_view2 = (LottieAnimationView) this.f40482e._$_findCachedViewById(h.tailing_view);
                    Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
                    tailing_view2.setVisibility(8);
                    int i2 = this.f40482e.f40473f;
                    if (i2 == 0) {
                        LottieAnimationView done_coin_1 = (LottieAnimationView) this.f40482e._$_findCachedViewById(h.done_coin_1);
                        Intrinsics.checkNotNullExpressionValue(done_coin_1, "done_coin_1");
                        done_coin_1.setVisibility(0);
                        ImageView normal_coin_1 = (ImageView) this.f40482e._$_findCachedViewById(h.normal_coin_1);
                        Intrinsics.checkNotNullExpressionValue(normal_coin_1, "normal_coin_1");
                        normal_coin_1.setVisibility(4);
                        ((LottieAnimationView) this.f40482e._$_findCachedViewById(h.done_coin_1)).playAnimation();
                        this.f40482e.f40473f = 1;
                        GameGuideView gameGuideView = this.f40482e;
                        LottieAnimationView done_coin_12 = (LottieAnimationView) gameGuideView._$_findCachedViewById(h.done_coin_1);
                        Intrinsics.checkNotNullExpressionValue(done_coin_12, "done_coin_1");
                        gameGuideView.c(done_coin_12);
                        this.f40482e.b();
                    } else if (i2 == 1) {
                        LottieAnimationView done_coin_2 = (LottieAnimationView) this.f40482e._$_findCachedViewById(h.done_coin_2);
                        Intrinsics.checkNotNullExpressionValue(done_coin_2, "done_coin_2");
                        done_coin_2.setVisibility(0);
                        ImageView normal_coin_2 = (ImageView) this.f40482e._$_findCachedViewById(h.normal_coin_2);
                        Intrinsics.checkNotNullExpressionValue(normal_coin_2, "normal_coin_2");
                        normal_coin_2.setVisibility(4);
                        ((LottieAnimationView) this.f40482e._$_findCachedViewById(h.done_coin_2)).playAnimation();
                        this.f40482e.f40473f = 2;
                        GameGuideView gameGuideView2 = this.f40482e;
                        LottieAnimationView done_coin_22 = (LottieAnimationView) gameGuideView2._$_findCachedViewById(h.done_coin_2);
                        Intrinsics.checkNotNullExpressionValue(done_coin_22, "done_coin_2");
                        gameGuideView2.c(done_coin_22);
                    } else if (i2 != 2) {
                    } else {
                        LottieAnimationView done_coin_3 = (LottieAnimationView) this.f40482e._$_findCachedViewById(h.done_coin_3);
                        Intrinsics.checkNotNullExpressionValue(done_coin_3, "done_coin_3");
                        done_coin_3.setVisibility(0);
                        ImageView normal_coin_3 = (ImageView) this.f40482e._$_findCachedViewById(h.normal_coin_3);
                        Intrinsics.checkNotNullExpressionValue(normal_coin_3, "normal_coin_3");
                        normal_coin_3.setVisibility(4);
                        ((LottieAnimationView) this.f40482e._$_findCachedViewById(h.done_coin_3)).playAnimation();
                        this.f40482e.f40473f = 3;
                        ((LottieAnimationView) this.f40482e._$_findCachedViewById(h.spark_view)).cancelAnimation();
                        LottieAnimationView spark_view = (LottieAnimationView) this.f40482e._$_findCachedViewById(h.spark_view);
                        Intrinsics.checkNotNullExpressionValue(spark_view, "spark_view");
                        spark_view.setVisibility(8);
                        GameGuideView gameGuideView3 = this.f40482e;
                        LottieAnimationView done_coin_32 = (LottieAnimationView) gameGuideView3._$_findCachedViewById(h.done_coin_3);
                        Intrinsics.checkNotNullExpressionValue(done_coin_32, "done_coin_3");
                        gameGuideView3.c(done_coin_32);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class f extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GameGuideView f40485e;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public f(GameGuideView gameGuideView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40485e = gameGuideView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                LottieAnimationView bomb_view = (LottieAnimationView) this.f40485e._$_findCachedViewById(h.bomb_view);
                Intrinsics.checkNotNullExpressionValue(bomb_view, "bomb_view");
                bomb_view.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideView(Context context, LottieComposition composition, Bitmap normalImg, String proColor, String tips) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, composition, normalImg, proColor, tips};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(composition, "composition");
        Intrinsics.checkNotNullParameter(normalImg, "normalImg");
        Intrinsics.checkNotNullParameter(proColor, "proColor");
        Intrinsics.checkNotNullParameter(tips, "tips");
        this.f40478k = "";
        this.l = "";
        this.f40477j = composition;
        this.f40478k = proColor;
        this.l = tips;
        this.m = normalImg;
        d();
    }

    private final int getProgressViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.f40472e == 0) {
                GameGuideProgressView progress_view = (GameGuideProgressView) _$_findCachedViewById(h.progress_view);
                Intrinsics.checkNotNullExpressionValue(progress_view, "progress_view");
                this.f40472e = progress_view.getWidth();
            }
            return this.f40472e;
        }
        return invokeV.intValue;
    }

    private final float getTailingViewOriginCenterX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            if (this.f40474g == 0.0f) {
                GameGuideProgressView progress_view = (GameGuideProgressView) _$_findCachedViewById(h.progress_view);
                Intrinsics.checkNotNullExpressionValue(progress_view, "progress_view");
                this.f40474g = progress_view.getX() + getProgressViewWidth();
            }
            return this.f40474g;
        }
        return invokeV.floatValue;
    }

    private final float getTailingViewOriginCenterY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            if (this.f40475h == 0.0f) {
                GameGuideProgressView progress_view = (GameGuideProgressView) _$_findCachedViewById(h.progress_view);
                Intrinsics.checkNotNullExpressionValue(progress_view, "progress_view");
                float y = progress_view.getY();
                GameGuideProgressView progress_view2 = (GameGuideProgressView) _$_findCachedViewById(h.progress_view);
                Intrinsics.checkNotNullExpressionValue(progress_view2, "progress_view");
                this.f40475h = y + (progress_view2.getHeight() / 2);
            }
            return this.f40475h;
        }
        return invokeV.floatValue;
    }

    private final void setSaveDisable(LottieAnimationView lottieAnimationView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, lottieAnimationView) == null) {
            if (lottieAnimationView != null) {
                lottieAnimationView.setSaveEnabled(false);
            }
            if (lottieAnimationView != null) {
                lottieAnimationView.setSaveFromParentEnabled(false);
            }
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hashMap = this.n) == null) {
            return;
        }
        hashMap.clear();
    }

    public View _$_findCachedViewById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (this.n == null) {
                this.n = new HashMap();
            }
            View view = (View) this.n.get(Integer.valueOf(i2));
            if (view == null) {
                View findViewById = findViewById(i2);
                this.n.put(Integer.valueOf(i2), findViewById);
                return findViewById;
            }
            return view;
        }
        return (View) invokeI.objValue;
    }

    public final boolean a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            if (j2 >= 0) {
                return j2 <= SapiWebView.DEFAULT_TIMEOUT_MILLIS || !k.a;
            }
            boolean z = k.a;
            return false;
        }
        return invokeJ.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || c.a.p0.h.j.b.o.L()) {
            return;
        }
        if (this.l.length() > 0) {
            TextView tips = (TextView) _$_findCachedViewById(h.tips);
            Intrinsics.checkNotNullExpressionValue(tips, "tips");
            tips.setVisibility(0);
            TextView tips2 = (TextView) _$_findCachedViewById(h.tips);
            Intrinsics.checkNotNullExpressionValue(tips2, "tips");
            tips2.setText(this.l);
            c.a.p0.h.j.b.o.b0();
        }
    }

    public final void c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimator.addUpdateListener(new a(view));
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
            valueAnimator.setInterpolator(new OvershootInterpolator());
            valueAnimator.setDuration(250L);
            valueAnimator.start();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setSaveFromParentEnabled(false);
            setSaveEnabled(false);
            setLayerType(1, null);
            LayoutInflater.from(AppRuntime.getAppContext()).inflate(i.aiapps_game_guide_view, this);
            LottieComposition lottieComposition = this.f40477j;
            if (lottieComposition != null) {
                ((LottieAnimationView) _$_findCachedViewById(h.done_coin_1)).setComposition(lottieComposition);
                ((LottieAnimationView) _$_findCachedViewById(h.done_coin_2)).setComposition(lottieComposition);
                ((LottieAnimationView) _$_findCachedViewById(h.done_coin_3)).setComposition(lottieComposition);
                LottieAnimationView done_coin_1 = (LottieAnimationView) _$_findCachedViewById(h.done_coin_1);
                Intrinsics.checkNotNullExpressionValue(done_coin_1, "done_coin_1");
                done_coin_1.setRepeatCount(-1);
                LottieAnimationView done_coin_2 = (LottieAnimationView) _$_findCachedViewById(h.done_coin_2);
                Intrinsics.checkNotNullExpressionValue(done_coin_2, "done_coin_2");
                done_coin_2.setRepeatCount(-1);
                LottieAnimationView done_coin_3 = (LottieAnimationView) _$_findCachedViewById(h.done_coin_3);
                Intrinsics.checkNotNullExpressionValue(done_coin_3, "done_coin_3");
                done_coin_3.setRepeatCount(-1);
            }
            Bitmap bitmap = this.m;
            if (bitmap != null) {
                ((ImageView) _$_findCachedViewById(h.normal_coin_1)).setImageBitmap(bitmap);
                ((ImageView) _$_findCachedViewById(h.normal_coin_2)).setImageBitmap(bitmap);
                ((ImageView) _$_findCachedViewById(h.normal_coin_3)).setImageBitmap(bitmap);
            }
            if (this.f40478k.length() > 0) {
                try {
                    ((GameGuideProgressView) _$_findCachedViewById(h.progress_view)).setProgressColor(Color.parseColor(this.f40478k));
                } catch (Exception e2) {
                    if (k.a) {
                        throw e2;
                    }
                }
            }
            ((LottieAnimationView) _$_findCachedViewById(h.spark_view)).setAnimation(j.aiapps_game_guide_view_spark_view);
            LottieAnimationView spark_view = (LottieAnimationView) _$_findCachedViewById(h.spark_view);
            Intrinsics.checkNotNullExpressionValue(spark_view, "spark_view");
            spark_view.setRepeatCount(-1);
            ((LottieAnimationView) _$_findCachedViewById(h.bomb_view)).setAnimation(j.aiapps_game_guide_view_bomb_view);
            ((LottieAnimationView) _$_findCachedViewById(h.tailing_view)).setAnimation(j.aiapps_game_guide_view_tailing_view);
            ((GameGuideProgressView) _$_findCachedViewById(h.progress_view)).setProgressListener(new b(this));
            setSaveDisable((LottieAnimationView) _$_findCachedViewById(h.done_coin_1));
            setSaveDisable((LottieAnimationView) _$_findCachedViewById(h.done_coin_2));
            setSaveDisable((LottieAnimationView) _$_findCachedViewById(h.done_coin_2));
            setSaveDisable((LottieAnimationView) _$_findCachedViewById(h.spark_view));
            setSaveDisable((LottieAnimationView) _$_findCachedViewById(h.bomb_view));
            setSaveDisable((LottieAnimationView) _$_findCachedViewById(h.tailing_view));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LottieAnimationView tailing_view = (LottieAnimationView) _$_findCachedViewById(h.tailing_view);
            Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
            ViewGroup.LayoutParams layoutParams = tailing_view.getLayoutParams();
            if (layoutParams != null) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = 0;
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = 0;
                LottieAnimationView tailing_view2 = (LottieAnimationView) _$_findCachedViewById(h.tailing_view);
                Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
                tailing_view2.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
    }

    public final void f() {
        float width;
        float height;
        long j2;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i2 = this.f40473f;
            if (i2 == 0) {
                ImageView normal_coin_1 = (ImageView) _$_findCachedViewById(h.normal_coin_1);
                Intrinsics.checkNotNullExpressionValue(normal_coin_1, "normal_coin_1");
                float x = normal_coin_1.getX();
                ImageView normal_coin_12 = (ImageView) _$_findCachedViewById(h.normal_coin_1);
                Intrinsics.checkNotNullExpressionValue(normal_coin_12, "normal_coin_1");
                width = x + (normal_coin_12.getWidth() / 2);
                ImageView normal_coin_13 = (ImageView) _$_findCachedViewById(h.normal_coin_1);
                Intrinsics.checkNotNullExpressionValue(normal_coin_13, "normal_coin_1");
                float y = normal_coin_13.getY();
                ImageView normal_coin_14 = (ImageView) _$_findCachedViewById(h.normal_coin_1);
                Intrinsics.checkNotNullExpressionValue(normal_coin_14, "normal_coin_1");
                height = y + (normal_coin_14.getHeight() / 2);
                j2 = 700;
                f2 = 1.0f;
            } else if (i2 == 1) {
                ImageView normal_coin_2 = (ImageView) _$_findCachedViewById(h.normal_coin_2);
                Intrinsics.checkNotNullExpressionValue(normal_coin_2, "normal_coin_2");
                float x2 = normal_coin_2.getX();
                ImageView normal_coin_22 = (ImageView) _$_findCachedViewById(h.normal_coin_2);
                Intrinsics.checkNotNullExpressionValue(normal_coin_22, "normal_coin_2");
                width = x2 + (normal_coin_22.getWidth() / 2);
                ImageView normal_coin_23 = (ImageView) _$_findCachedViewById(h.normal_coin_2);
                Intrinsics.checkNotNullExpressionValue(normal_coin_23, "normal_coin_2");
                float y2 = normal_coin_23.getY();
                ImageView normal_coin_24 = (ImageView) _$_findCachedViewById(h.normal_coin_2);
                Intrinsics.checkNotNullExpressionValue(normal_coin_24, "normal_coin_2");
                height = y2 + (normal_coin_24.getHeight() / 2);
                j2 = 500;
                f2 = 1.4f;
            } else if (i2 != 2) {
                return;
            } else {
                ImageView normal_coin_3 = (ImageView) _$_findCachedViewById(h.normal_coin_3);
                Intrinsics.checkNotNullExpressionValue(normal_coin_3, "normal_coin_3");
                float x3 = normal_coin_3.getX();
                ImageView normal_coin_32 = (ImageView) _$_findCachedViewById(h.normal_coin_3);
                Intrinsics.checkNotNullExpressionValue(normal_coin_32, "normal_coin_3");
                width = x3 + (normal_coin_32.getWidth() / 2);
                ImageView normal_coin_33 = (ImageView) _$_findCachedViewById(h.normal_coin_3);
                Intrinsics.checkNotNullExpressionValue(normal_coin_33, "normal_coin_3");
                float y3 = normal_coin_33.getY();
                ImageView normal_coin_34 = (ImageView) _$_findCachedViewById(h.normal_coin_3);
                Intrinsics.checkNotNullExpressionValue(normal_coin_34, "normal_coin_3");
                height = y3 + (normal_coin_34.getHeight() / 2);
                j2 = 300;
                f2 = 0.33333334f;
            }
            double atan2 = (180 * ((float) Math.atan2(getTailingViewOriginCenterY() - height, getTailingViewOriginCenterX() - width))) / 3.141592653589793d;
            LottieAnimationView tailing_view = (LottieAnimationView) _$_findCachedViewById(h.tailing_view);
            Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
            tailing_view.setVisibility(0);
            e();
            LottieAnimationView tailing_view2 = (LottieAnimationView) _$_findCachedViewById(h.tailing_view);
            Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
            tailing_view2.setRotation(((float) atan2) - 90);
            LottieAnimationView tailing_view3 = (LottieAnimationView) _$_findCachedViewById(h.tailing_view);
            Intrinsics.checkNotNullExpressionValue(tailing_view3, "tailing_view");
            tailing_view3.setSpeed(f2);
            ((LottieAnimationView) _$_findCachedViewById(h.tailing_view)).playAnimation();
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = false;
            ValueAnimator xValueAnimator = ValueAnimator.ofFloat(0.0f, getTailingViewOriginCenterX() - width);
            xValueAnimator.addUpdateListener(new c(this));
            Intrinsics.checkNotNullExpressionValue(xValueAnimator, "xValueAnimator");
            xValueAnimator.setInterpolator(new LinearInterpolator());
            ValueAnimator yValueAnimator = ValueAnimator.ofFloat(0.0f, getTailingViewOriginCenterY() - height);
            yValueAnimator.addUpdateListener(new d(this));
            Intrinsics.checkNotNullExpressionValue(yValueAnimator, "yValueAnimator");
            yValueAnimator.setInterpolator(new LinearInterpolator());
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(j2);
            animatorSet.play(xValueAnimator).with(yValueAnimator);
            animatorSet.addListener(new e(this, booleanRef, atan2));
            animatorSet.start();
        }
    }

    public final void g(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            LottieAnimationView tailing_view = (LottieAnimationView) _$_findCachedViewById(h.tailing_view);
            Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
            tailing_view.setVisibility(8);
            if (0 <= j2 && 30000 > j2) {
                LottieAnimationView done_coin_1 = (LottieAnimationView) _$_findCachedViewById(h.done_coin_1);
                Intrinsics.checkNotNullExpressionValue(done_coin_1, "done_coin_1");
                done_coin_1.setVisibility(8);
                ImageView normal_coin_1 = (ImageView) _$_findCachedViewById(h.normal_coin_1);
                Intrinsics.checkNotNullExpressionValue(normal_coin_1, "normal_coin_1");
                normal_coin_1.setVisibility(0);
                ((LottieAnimationView) _$_findCachedViewById(h.done_coin_1)).cancelAnimation();
                LottieAnimationView done_coin_2 = (LottieAnimationView) _$_findCachedViewById(h.done_coin_2);
                Intrinsics.checkNotNullExpressionValue(done_coin_2, "done_coin_2");
                done_coin_2.setVisibility(8);
                ImageView normal_coin_2 = (ImageView) _$_findCachedViewById(h.normal_coin_2);
                Intrinsics.checkNotNullExpressionValue(normal_coin_2, "normal_coin_2");
                normal_coin_2.setVisibility(0);
                ((LottieAnimationView) _$_findCachedViewById(h.done_coin_2)).cancelAnimation();
                LottieAnimationView done_coin_3 = (LottieAnimationView) _$_findCachedViewById(h.done_coin_3);
                Intrinsics.checkNotNullExpressionValue(done_coin_3, "done_coin_3");
                done_coin_3.setVisibility(8);
                ImageView normal_coin_3 = (ImageView) _$_findCachedViewById(h.normal_coin_3);
                Intrinsics.checkNotNullExpressionValue(normal_coin_3, "normal_coin_3");
                normal_coin_3.setVisibility(0);
                ((LottieAnimationView) _$_findCachedViewById(h.done_coin_3)).cancelAnimation();
                LottieAnimationView spark_view = (LottieAnimationView) _$_findCachedViewById(h.spark_view);
                Intrinsics.checkNotNullExpressionValue(spark_view, "spark_view");
                spark_view.setVisibility(0);
                ((LottieAnimationView) _$_findCachedViewById(h.spark_view)).playAnimation();
                this.f40473f = 0;
            } else if (30000 <= j2 && 60000 > j2) {
                LottieAnimationView done_coin_12 = (LottieAnimationView) _$_findCachedViewById(h.done_coin_1);
                Intrinsics.checkNotNullExpressionValue(done_coin_12, "done_coin_1");
                done_coin_12.setVisibility(0);
                ImageView normal_coin_12 = (ImageView) _$_findCachedViewById(h.normal_coin_1);
                Intrinsics.checkNotNullExpressionValue(normal_coin_12, "normal_coin_1");
                normal_coin_12.setVisibility(4);
                ((LottieAnimationView) _$_findCachedViewById(h.done_coin_1)).playAnimation();
                LottieAnimationView done_coin_22 = (LottieAnimationView) _$_findCachedViewById(h.done_coin_2);
                Intrinsics.checkNotNullExpressionValue(done_coin_22, "done_coin_2");
                done_coin_22.setVisibility(8);
                ((LottieAnimationView) _$_findCachedViewById(h.done_coin_2)).cancelAnimation();
                LottieAnimationView done_coin_32 = (LottieAnimationView) _$_findCachedViewById(h.done_coin_3);
                Intrinsics.checkNotNullExpressionValue(done_coin_32, "done_coin_3");
                done_coin_32.setVisibility(8);
                ((LottieAnimationView) _$_findCachedViewById(h.done_coin_3)).cancelAnimation();
                LottieAnimationView spark_view2 = (LottieAnimationView) _$_findCachedViewById(h.spark_view);
                Intrinsics.checkNotNullExpressionValue(spark_view2, "spark_view");
                spark_view2.setVisibility(0);
                ((LottieAnimationView) _$_findCachedViewById(h.spark_view)).playAnimation();
                this.f40473f = 1;
            } else if (60000 <= j2 && SapiWebView.DEFAULT_TIMEOUT_MILLIS > j2) {
                LottieAnimationView done_coin_13 = (LottieAnimationView) _$_findCachedViewById(h.done_coin_1);
                Intrinsics.checkNotNullExpressionValue(done_coin_13, "done_coin_1");
                done_coin_13.setVisibility(0);
                ImageView normal_coin_13 = (ImageView) _$_findCachedViewById(h.normal_coin_1);
                Intrinsics.checkNotNullExpressionValue(normal_coin_13, "normal_coin_1");
                normal_coin_13.setVisibility(4);
                ((LottieAnimationView) _$_findCachedViewById(h.done_coin_1)).playAnimation();
                LottieAnimationView done_coin_23 = (LottieAnimationView) _$_findCachedViewById(h.done_coin_2);
                Intrinsics.checkNotNullExpressionValue(done_coin_23, "done_coin_2");
                done_coin_23.setVisibility(0);
                ImageView normal_coin_22 = (ImageView) _$_findCachedViewById(h.normal_coin_2);
                Intrinsics.checkNotNullExpressionValue(normal_coin_22, "normal_coin_2");
                normal_coin_22.setVisibility(4);
                ((LottieAnimationView) _$_findCachedViewById(h.done_coin_2)).playAnimation();
                LottieAnimationView done_coin_33 = (LottieAnimationView) _$_findCachedViewById(h.done_coin_3);
                Intrinsics.checkNotNullExpressionValue(done_coin_33, "done_coin_3");
                done_coin_33.setVisibility(8);
                ((LottieAnimationView) _$_findCachedViewById(h.done_coin_3)).cancelAnimation();
                LottieAnimationView spark_view3 = (LottieAnimationView) _$_findCachedViewById(h.spark_view);
                Intrinsics.checkNotNullExpressionValue(spark_view3, "spark_view");
                spark_view3.setVisibility(0);
                ((LottieAnimationView) _$_findCachedViewById(h.spark_view)).playAnimation();
                this.f40473f = 2;
            } else {
                LottieAnimationView done_coin_14 = (LottieAnimationView) _$_findCachedViewById(h.done_coin_1);
                Intrinsics.checkNotNullExpressionValue(done_coin_14, "done_coin_1");
                done_coin_14.setVisibility(0);
                ImageView normal_coin_14 = (ImageView) _$_findCachedViewById(h.normal_coin_1);
                Intrinsics.checkNotNullExpressionValue(normal_coin_14, "normal_coin_1");
                normal_coin_14.setVisibility(4);
                ((LottieAnimationView) _$_findCachedViewById(h.done_coin_1)).playAnimation();
                LottieAnimationView done_coin_24 = (LottieAnimationView) _$_findCachedViewById(h.done_coin_2);
                Intrinsics.checkNotNullExpressionValue(done_coin_24, "done_coin_2");
                done_coin_24.setVisibility(0);
                ImageView normal_coin_23 = (ImageView) _$_findCachedViewById(h.normal_coin_2);
                Intrinsics.checkNotNullExpressionValue(normal_coin_23, "normal_coin_2");
                normal_coin_23.setVisibility(4);
                ((LottieAnimationView) _$_findCachedViewById(h.done_coin_2)).playAnimation();
                LottieAnimationView done_coin_34 = (LottieAnimationView) _$_findCachedViewById(h.done_coin_3);
                Intrinsics.checkNotNullExpressionValue(done_coin_34, "done_coin_3");
                done_coin_34.setVisibility(0);
                ImageView normal_coin_32 = (ImageView) _$_findCachedViewById(h.normal_coin_3);
                Intrinsics.checkNotNullExpressionValue(normal_coin_32, "normal_coin_3");
                normal_coin_32.setVisibility(4);
                ((LottieAnimationView) _$_findCachedViewById(h.done_coin_3)).playAnimation();
                LottieAnimationView spark_view4 = (LottieAnimationView) _$_findCachedViewById(h.spark_view);
                Intrinsics.checkNotNullExpressionValue(spark_view4, "spark_view");
                spark_view4.setVisibility(8);
                ((LottieAnimationView) _$_findCachedViewById(h.spark_view)).cancelAnimation();
                this.f40473f = 3;
            }
        }
    }

    public final int getCurrentStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f40473f : invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            LottieAnimationView bomb_view = (LottieAnimationView) _$_findCachedViewById(h.bomb_view);
            Intrinsics.checkNotNullExpressionValue(bomb_view, "bomb_view");
            bomb_view.setVisibility(0);
            ((LottieAnimationView) _$_findCachedViewById(h.bomb_view)).playAnimation();
            ((LottieAnimationView) _$_findCachedViewById(h.bomb_view)).addAnimatorListener(new f(this));
            f();
        }
    }

    @Override // android.view.View
    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sparseArray) == null) {
        }
    }

    public final void reviseViewLayout(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f2) == null) {
            float progressViewWidth = getProgressViewWidth() * f2;
            LottieAnimationView spark_view = (LottieAnimationView) _$_findCachedViewById(h.spark_view);
            Intrinsics.checkNotNullExpressionValue(spark_view, "spark_view");
            ViewGroup.LayoutParams layoutParams = spark_view.getLayoutParams();
            if (layoutParams != null) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.setMarginStart((int) progressViewWidth);
                LottieAnimationView spark_view2 = (LottieAnimationView) _$_findCachedViewById(h.spark_view);
                Intrinsics.checkNotNullExpressionValue(spark_view2, "spark_view");
                spark_view2.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
    }

    public final void startTime(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) && a(j2)) {
            if (this.f40476i) {
                boolean z = k.a;
                return;
            }
            g(j2);
            if (j2 >= SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                boolean z2 = k.a;
                ((GameGuideProgressView) _$_findCachedViewById(h.progress_view)).startProcess(1.0f);
                return;
            }
            this.f40476i = true;
            ((GameGuideProgressView) _$_findCachedViewById(h.progress_view)).startProcess(((float) (j2 % 30000)) / ((float) 30000));
        }
    }

    public final void stopTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f40476i = false;
            ((GameGuideProgressView) _$_findCachedViewById(h.progress_view)).stopProcess();
            ((LottieAnimationView) _$_findCachedViewById(h.done_coin_1)).cancelAnimation();
            ((LottieAnimationView) _$_findCachedViewById(h.done_coin_2)).cancelAnimation();
            ((LottieAnimationView) _$_findCachedViewById(h.done_coin_3)).cancelAnimation();
            ((LottieAnimationView) _$_findCachedViewById(h.spark_view)).cancelAnimation();
            ((LottieAnimationView) _$_findCachedViewById(h.tailing_view)).cancelAnimation();
            ((LottieAnimationView) _$_findCachedViewById(h.bomb_view)).cancelAnimation();
            LottieAnimationView tailing_view = (LottieAnimationView) _$_findCachedViewById(h.tailing_view);
            Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
            tailing_view.setVisibility(4);
            LottieAnimationView bomb_view = (LottieAnimationView) _$_findCachedViewById(h.bomb_view);
            Intrinsics.checkNotNullExpressionValue(bomb_view, "bomb_view");
            bomb_view.setVisibility(8);
        }
    }

    public final void updateStatusWhenClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            TextView tips = (TextView) _$_findCachedViewById(h.tips);
            Intrinsics.checkNotNullExpressionValue(tips, "tips");
            if (tips.getVisibility() == 0) {
                TextView tips2 = (TextView) _$_findCachedViewById(h.tips);
                Intrinsics.checkNotNullExpressionValue(tips2, "tips");
                tips2.setVisibility(8);
            }
            this.f40473f = 0;
            ((LottieAnimationView) _$_findCachedViewById(h.done_coin_1)).cancelAnimation();
            LottieAnimationView done_coin_1 = (LottieAnimationView) _$_findCachedViewById(h.done_coin_1);
            Intrinsics.checkNotNullExpressionValue(done_coin_1, "done_coin_1");
            done_coin_1.setVisibility(8);
            ImageView normal_coin_1 = (ImageView) _$_findCachedViewById(h.normal_coin_1);
            Intrinsics.checkNotNullExpressionValue(normal_coin_1, "normal_coin_1");
            normal_coin_1.setVisibility(0);
            ((LottieAnimationView) _$_findCachedViewById(h.done_coin_2)).cancelAnimation();
            LottieAnimationView done_coin_2 = (LottieAnimationView) _$_findCachedViewById(h.done_coin_2);
            Intrinsics.checkNotNullExpressionValue(done_coin_2, "done_coin_2");
            done_coin_2.setVisibility(8);
            ImageView normal_coin_2 = (ImageView) _$_findCachedViewById(h.normal_coin_2);
            Intrinsics.checkNotNullExpressionValue(normal_coin_2, "normal_coin_2");
            normal_coin_2.setVisibility(0);
            ((LottieAnimationView) _$_findCachedViewById(h.done_coin_3)).cancelAnimation();
            LottieAnimationView done_coin_3 = (LottieAnimationView) _$_findCachedViewById(h.done_coin_3);
            Intrinsics.checkNotNullExpressionValue(done_coin_3, "done_coin_3");
            done_coin_3.setVisibility(8);
            ImageView normal_coin_3 = (ImageView) _$_findCachedViewById(h.normal_coin_3);
            Intrinsics.checkNotNullExpressionValue(normal_coin_3, "normal_coin_3");
            normal_coin_3.setVisibility(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        this.f40478k = "";
        this.l = "";
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        this.f40478k = "";
        this.l = "";
        d();
    }
}
