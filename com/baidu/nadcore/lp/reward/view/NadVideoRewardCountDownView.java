package com.baidu.nadcore.lp.reward.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.utils.ExtensionsKt;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.go0;
import com.baidu.tieba.iq0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010@\u001a\u00020?\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A\u0012\b\b\u0002\u0010C\u001a\u00020\u0004¢\u0006\u0004\bD\u0010EJ5\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u0011J-\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001f\u0010\u0018R\u001d\u0010%\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010*\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010)R\u001d\u0010-\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\"\u001a\u0004\b,\u0010)R\u001d\u00100\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\"\u001a\u0004\b/\u0010)R\u001d\u00105\u001a\u0002018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\"\u001a\u0004\b3\u00104R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u00106R\u001d\u0010;\u001a\u0002078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\"\u001a\u0004\b9\u0010:R\u001d\u0010>\u001a\u0002078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\"\u001a\u0004\b=\u0010:¨\u0006F"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadVideoRewardCountDownView;", "Lcom/baidu/nadcore/lp/reward/view/AbsRewardCountDownView;", "Landroid/view/ViewGroup;", "viewGroup", "", "index", "", "animation", "Lkotlin/Function0;", "Landroid/view/ViewGroup$MarginLayoutParams;", SapiUtils.KEY_QR_LOGIN_LP, "", "attachToViewGroup", "(Landroid/view/ViewGroup;IZLkotlin/Function0;)V", "Lcom/baidu/nadcore/model/RewardData;", "rewardData", "doTaskComplete", "(Lcom/baidu/nadcore/model/RewardData;)V", "", "getMillisUntilFinished", "()J", "", "url", "loadLottieAnimation", "(Ljava/lang/String;)V", "resetUI", "taskDuration", "onFinish", "setData", "(ILcom/baidu/nadcore/model/RewardData;Lkotlin/Function0;)V", "tips", "showRewardTips", "Lcom/baidu/nadcore/widget/AdImageView;", "ivIcon$delegate", "Lkotlin/Lazy;", "getIvIcon", "()Lcom/baidu/nadcore/widget/AdImageView;", "ivIcon", "Landroid/widget/LinearLayout;", "llContent$delegate", "getLlContent", "()Landroid/widget/LinearLayout;", "llContent", "llCountDown$delegate", "getLlCountDown", "llCountDown", "llLimit$delegate", "getLlLimit", "llLimit", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieView$delegate", "getLottieView", "()Lcom/airbnb/lottie/LottieAnimationView;", "lottieView", "I", "Landroid/widget/TextView;", "tvCountDown$delegate", "getTvCountDown", "()Landroid/widget/TextView;", "tvCountDown", "tvDesc$delegate", "getTvDesc", "tvDesc", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadVideoRewardCountDownView extends AbsRewardCountDownView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public int k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadVideoRewardCountDownView(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadVideoRewardCountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdImageView getIvIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? (AdImageView) this.g.getValue() : (AdImageView) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout getLlContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? (LinearLayout) this.f.getValue() : (LinearLayout) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout getLlCountDown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? (LinearLayout) this.d.getValue() : (LinearLayout) invokeV.objValue;
    }

    private final LinearLayout getLlLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? (LinearLayout) this.e.getValue() : (LinearLayout) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LottieAnimationView getLottieView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? (LottieAnimationView) this.j.getValue() : (LottieAnimationView) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvCountDown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? (TextView) this.h.getValue() : (TextView) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? (TextView) this.i.getValue() : (TextView) invokeV.objValue;
    }

    /* loaded from: classes2.dex */
    public static final class b<T> implements LottieListener<LottieComposition> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadVideoRewardCountDownView a;

        public b(NadVideoRewardCountDownView nadVideoRewardCountDownView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadVideoRewardCountDownView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadVideoRewardCountDownView;
        }

        /* loaded from: classes2.dex */
        public static final class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            /* renamed from: com.baidu.nadcore.lp.reward.view.NadVideoRewardCountDownView$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0118a implements ValueAnimator.AnimatorUpdateListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0118a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator animator) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                        return;
                    }
                    LinearLayout llContent = this.a.a.a.getLlContent();
                    Intrinsics.checkNotNullExpressionValue(animator, "animator");
                    Object animatedValue = animator.getAnimatedValue();
                    if (animatedValue != null) {
                        llContent.setAlpha(((Float) animatedValue).floatValue());
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
            }

            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.5f);
                    ofFloat.addUpdateListener(new C0118a(this));
                    ofFloat.setDuration(200L).start();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                this.a.getLottieView().addAnimatorListener(new a(this));
                this.a.getLottieView().setComposition(lottieComposition);
                this.a.getLottieView().playAnimation();
                this.a.getLottieView().setVisibility(0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadVideoRewardCountDownView a;
        public final /* synthetic */ iq0 b;

        public a(NadVideoRewardCountDownView nadVideoRewardCountDownView, iq0 iq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadVideoRewardCountDownView, iq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadVideoRewardCountDownView;
            this.b = iq0Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Object animatedValue = it.getAnimatedValue();
                if (animatedValue != null) {
                    float floatValue = ((Float) animatedValue).floatValue();
                    if (floatValue <= 0.2f) {
                        this.a.getTvCountDown().setVisibility(8);
                        this.a.getTvDesc().setText(this.b.k());
                        this.a.getIvIcon().setVisibility(8);
                        this.a.p(this.b.j());
                    }
                    this.a.getLlCountDown().setAlpha(floatValue);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c<T> implements LottieListener<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadVideoRewardCountDownView a;

        public c(NadVideoRewardCountDownView nadVideoRewardCountDownView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadVideoRewardCountDownView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadVideoRewardCountDownView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.a.getLottieView().setVisibility(8);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d extends go0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadVideoRewardCountDownView j;
        public final /* synthetic */ iq0 k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(NadVideoRewardCountDownView nadVideoRewardCountDownView, iq0 iq0Var, int i, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r6;
                Object[] objArr = {nadVideoRewardCountDownView, iq0Var, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = nadVideoRewardCountDownView;
            this.k = iq0Var;
        }

        @Override // com.baidu.tieba.go0
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Function0<Unit> countDownFinish = this.j.getCountDownFinish();
                if (countDownFinish != null) {
                    countDownFinish.invoke();
                }
                this.j.o(this.k);
            }
        }

        @Override // com.baidu.tieba.go0
        public void l(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                super.l(j);
                this.j.getTvCountDown().setText(String.valueOf(j / 1000));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadVideoRewardCountDownView a;

        public e(NadVideoRewardCountDownView nadVideoRewardCountDownView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadVideoRewardCountDownView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadVideoRewardCountDownView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            go0 countDownTime;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (countDownTime = this.a.getCountDownTime()) != null) {
                countDownTime.m();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadVideoRewardCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.d = LazyKt__LazyJVMKt.lazy(new NadVideoRewardCountDownView$llCountDown$2(this));
        this.e = LazyKt__LazyJVMKt.lazy(new NadVideoRewardCountDownView$llLimit$2(this));
        this.f = LazyKt__LazyJVMKt.lazy(new NadVideoRewardCountDownView$llContent$2(this));
        this.g = LazyKt__LazyJVMKt.lazy(new NadVideoRewardCountDownView$ivIcon$2(this));
        this.h = LazyKt__LazyJVMKt.lazy(new NadVideoRewardCountDownView$tvCountDown$2(this));
        this.i = LazyKt__LazyJVMKt.lazy(new NadVideoRewardCountDownView$tvDesc$2(this));
        this.j = LazyKt__LazyJVMKt.lazy(new NadVideoRewardCountDownView$lottieView$2(this));
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0625, this);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(ExtensionsKt.d(14, context));
        gradientDrawable.setStroke(ExtensionsKt.d(1, context), ContextCompat.getColor(context, R.color.obfuscated_res_0x7f0608a9));
        int color = ContextCompat.getColor(context, R.color.obfuscated_res_0x7f0608a7);
        gradientDrawable.setColors(new int[]{color, color});
        Unit unit = Unit.INSTANCE;
        setBackground(gradientDrawable);
    }

    public /* synthetic */ NadVideoRewardCountDownView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // com.baidu.nadcore.lp.reward.view.AbsRewardCountDownView
    public void e(String tips) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tips) == null) {
            Intrinsics.checkNotNullParameter(tips, "tips");
            getTvCountDown().setVisibility(8);
            getTvDesc().setText(tips);
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.AbsRewardCountDownView
    public void a(ViewGroup viewGroup, int i, boolean z, Function0<? extends ViewGroup.MarginLayoutParams> lp) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, Integer.valueOf(i), Boolean.valueOf(z), lp}) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            Intrinsics.checkNotNullParameter(lp, "lp");
            super.a(viewGroup, i, z, new NadVideoRewardCountDownView$attachToViewGroup$1(this));
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.AbsRewardCountDownView
    public long getMillisUntilFinished() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long millis = TimeUnit.SECONDS.toMillis(this.k);
            go0 countDownTime = getCountDownTime();
            if (countDownTime != null) {
                j = countDownTime.i();
            } else {
                j = 0;
            }
            return millis - j;
        }
        return invokeV.longValue;
    }

    public final void o(iq0 iq0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iq0Var) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f, 1.0f);
            ofFloat.addUpdateListener(new a(this, iq0Var));
            ofFloat.setDuration(400L).start();
        }
    }

    public final void p(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                getLottieView().setVisibility(8);
            } else {
                LottieCompositionFactory.fromUrl(getContext(), str, String.valueOf(str.hashCode())).addListener(new b(this)).addFailureListener(new c(this));
            }
        }
    }

    public final void q(iq0 iq0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iq0Var) == null) {
            getTvCountDown().setVisibility(0);
            getIvIcon().setVisibility(0);
            getTvDesc().setText(iq0Var.m());
            getLlLimit().setVisibility(8);
            getLottieView().setVisibility(8);
        }
    }

    @Override // com.baidu.nadcore.lp.reward.view.AbsRewardCountDownView
    @SuppressLint({"SetTextI18n"})
    public void setData(int i, iq0 rewardData, Function0<Unit> onFinish) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i, rewardData, onFinish) == null) {
            Intrinsics.checkNotNullParameter(rewardData, "rewardData");
            Intrinsics.checkNotNullParameter(onFinish, "onFinish");
            q(rewardData);
            setCountDownFinish(onFinish);
            this.k = i;
            getIvIcon().g(rewardData.l());
            getTvCountDown().setText(String.valueOf(i));
            setCountDownTime(new d(this, rewardData, i, TimeUnit.SECONDS.toMillis(i), 1000L));
            setDelayTimingTask(new e(this));
            postDelayed(getDelayTimingTask(), 1000L);
        }
    }
}
