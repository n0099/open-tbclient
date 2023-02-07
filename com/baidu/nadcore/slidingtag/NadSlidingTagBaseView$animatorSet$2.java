package com.baidu.nadcore.slidingtag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.b51;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/animation/AnimatorSet;", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadSlidingTagBaseView$animatorSet$2 extends Lambda implements Function0<AnimatorSet> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ Context $context;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ NadSlidingTagBaseView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadSlidingTagBaseView$animatorSet$2(NadSlidingTagBaseView nadSlidingTagBaseView, Context context) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nadSlidingTagBaseView, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = nadSlidingTagBaseView;
        this.$context = context;
    }

    /* loaded from: classes2.dex */
    public static final class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadSlidingTagBaseView$animatorSet$2 a;

        /* loaded from: classes2.dex */
        public static final class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, valueAnimator) != null) {
                    return;
                }
                this.a.a.this$0.u(valueAnimator);
            }
        }

        public e(NadSlidingTagBaseView$animatorSet$2 nadSlidingTagBaseView$animatorSet$2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadSlidingTagBaseView$animatorSet$2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadSlidingTagBaseView$animatorSet$2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TextView textView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && (textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(this.a.this$0.getTvList(), this.a.this$0.getCurrentIdx())) != null) {
                this.a.this$0.getLinear().removeView(textView);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            int i;
            int i2;
            int a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (this.a.this$0.getWidthMap().get(Integer.valueOf(this.a.this$0.getCurrentIdx())) != null) {
                    NadSlidingTagBaseView nadSlidingTagBaseView = this.a.this$0;
                    Integer num = nadSlidingTagBaseView.getWidthMap().get(Integer.valueOf(this.a.this$0.getCurrentIdx()));
                    if (num == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    nadSlidingTagBaseView.i = num.intValue();
                } else {
                    NadSlidingTagBaseView nadSlidingTagBaseView2 = this.a.this$0;
                    nadSlidingTagBaseView2.i = nadSlidingTagBaseView2.getCurrentMeasuredWidth();
                }
                int nextIndex = this.a.this$0.getNextIndex();
                if (this.a.this$0.getWidthMap().get(Integer.valueOf(nextIndex)) != null) {
                    NadSlidingTagBaseView nadSlidingTagBaseView3 = this.a.this$0;
                    Integer num2 = nadSlidingTagBaseView3.getWidthMap().get(Integer.valueOf(nextIndex));
                    if (num2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    nadSlidingTagBaseView3.j = num2.intValue();
                } else {
                    NadSlidingTagBaseView nadSlidingTagBaseView4 = this.a.this$0;
                    nadSlidingTagBaseView4.j = nadSlidingTagBaseView4.getNextMeasuredWidth();
                }
                i = this.a.this$0.i;
                i2 = this.a.this$0.j;
                ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
                ofInt.setDuration(400L);
                ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
                ofInt.addUpdateListener(new a(this));
                ofInt.start();
                if (this.a.this$0.getOriginalY() != 0.0f) {
                    return;
                }
                for (int childCount = this.a.this$0.getLinear().getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = this.a.this$0.getLinear().getChildAt(childCount);
                    if (childAt instanceof TextView) {
                        NadSlidingTagBaseView nadSlidingTagBaseView5 = this.a.this$0;
                        float y = ((TextView) childAt).getY();
                        if (this.a.this$0.getLinear().getChildAt(0) instanceof AdImageView) {
                            a2 = this.a.this$0.m;
                        } else {
                            a2 = b51.c.a(this.a.$context, 8.0f);
                        }
                        nadSlidingTagBaseView5.setOriginalY(y + a2);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadSlidingTagBaseView$animatorSet$2 a;

        public a(NadSlidingTagBaseView$animatorSet$2 nadSlidingTagBaseView$animatorSet$2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadSlidingTagBaseView$animatorSet$2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadSlidingTagBaseView$animatorSet$2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                NadSlidingTagBaseView nadSlidingTagBaseView = this.a.this$0;
                nadSlidingTagBaseView.setCurrentIdx(nadSlidingTagBaseView.getNextIndex());
                TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(this.a.this$0.getTvList(), this.a.this$0.getCurrentIdx());
                if (textView != null) {
                    LinearLayout linear = this.a.this$0.getLinear();
                    this.a.this$0.s(textView);
                    linear.addView(textView, this.a.this$0.r());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AnimatorSet a;
        public final /* synthetic */ NadSlidingTagBaseView$animatorSet$2 b;
        public final /* synthetic */ AnimatorSet c;
        public final /* synthetic */ AnimatorSet d;
        public final /* synthetic */ ValueAnimator e;

        public b(AnimatorSet animatorSet, NadSlidingTagBaseView$animatorSet$2 nadSlidingTagBaseView$animatorSet$2, AnimatorSet animatorSet2, AnimatorSet animatorSet3, ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {animatorSet, nadSlidingTagBaseView$animatorSet$2, animatorSet2, animatorSet3, valueAnimator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = animatorSet;
            this.b = nadSlidingTagBaseView$animatorSet$2;
            this.c = animatorSet2;
            this.d = animatorSet3;
            this.e = valueAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                z = this.b.this$0.h;
                if (z) {
                    this.b.this$0.q();
                    this.b.this$0.h = false;
                    return;
                }
                this.a.start();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadSlidingTagBaseView$animatorSet$2 a;

        public c(NadSlidingTagBaseView$animatorSet$2 nadSlidingTagBaseView$animatorSet$2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadSlidingTagBaseView$animatorSet$2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadSlidingTagBaseView$animatorSet$2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, valueAnimator) != null) {
                return;
            }
            this.a.this$0.w(valueAnimator);
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadSlidingTagBaseView$animatorSet$2 a;

        public d(NadSlidingTagBaseView$animatorSet$2 nadSlidingTagBaseView$animatorSet$2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadSlidingTagBaseView$animatorSet$2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadSlidingTagBaseView$animatorSet$2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, valueAnimator) != null) {
                return;
            }
            this.a.this$0.t(valueAnimator);
        }
    }

    /* loaded from: classes2.dex */
    public static final class f implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadSlidingTagBaseView$animatorSet$2 a;

        public f(NadSlidingTagBaseView$animatorSet$2 nadSlidingTagBaseView$animatorSet$2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadSlidingTagBaseView$animatorSet$2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadSlidingTagBaseView$animatorSet$2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, valueAnimator) != null) {
                return;
            }
            this.a.this$0.v(valueAnimator);
        }
    }

    /* loaded from: classes2.dex */
    public static final class g implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadSlidingTagBaseView$animatorSet$2 a;

        public g(NadSlidingTagBaseView$animatorSet$2 nadSlidingTagBaseView$animatorSet$2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadSlidingTagBaseView$animatorSet$2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadSlidingTagBaseView$animatorSet$2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, valueAnimator) != null) {
                return;
            }
            this.a.this$0.t(valueAnimator);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnimatorSet invoke() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(200L);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.addUpdateListener(new c(this));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat2.setDuration(200L);
            ofFloat2.setInterpolator(new LinearInterpolator());
            ofFloat2.addUpdateListener(new d(this));
            animatorSet.play(ofFloat).with(ofFloat2);
            animatorSet.addListener(new e(this));
            AnimatorSet animatorSet2 = new AnimatorSet();
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat3.setDuration(200L);
            ofFloat3.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat3.addUpdateListener(new f(this));
            ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat4.setDuration(200L);
            ofFloat4.setInterpolator(new LinearInterpolator());
            ofFloat4.addUpdateListener(new g(this));
            animatorSet2.play(ofFloat3).with(ofFloat4);
            animatorSet2.addListener(new a(this));
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
            j = this.this$0.g;
            ofInt.setDuration(j);
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.play(animatorSet).before(animatorSet2).before(ofInt);
            animatorSet3.addListener(new b(animatorSet3, this, animatorSet, animatorSet2, ofInt));
            return animatorSet3;
        }
        return (AnimatorSet) invokeV.objValue;
    }
}
