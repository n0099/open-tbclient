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
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.j51;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/animation/AnimatorSet;", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadSlidingTagBaseView$animatorSet$2 extends Lambda implements Function0<AnimatorSet> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ NadSlidingTagBaseView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadSlidingTagBaseView$animatorSet$2(NadSlidingTagBaseView nadSlidingTagBaseView, Context context) {
        super(0);
        this.this$0 = nadSlidingTagBaseView;
        this.$context = context;
    }

    /* loaded from: classes2.dex */
    public static final class e extends AnimatorListenerAdapter {

        /* loaded from: classes2.dex */
        public static final class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                NadSlidingTagBaseView$animatorSet$2.this.this$0.u(valueAnimator);
            }
        }

        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(NadSlidingTagBaseView$animatorSet$2.this.this$0.getTvList(), NadSlidingTagBaseView$animatorSet$2.this.this$0.getCurrentIdx());
            if (textView != null) {
                NadSlidingTagBaseView$animatorSet$2.this.this$0.getLinear().removeView(textView);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            int i;
            int i2;
            int a2;
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (NadSlidingTagBaseView$animatorSet$2.this.this$0.getWidthMap().get(Integer.valueOf(NadSlidingTagBaseView$animatorSet$2.this.this$0.getCurrentIdx())) != null) {
                NadSlidingTagBaseView nadSlidingTagBaseView = NadSlidingTagBaseView$animatorSet$2.this.this$0;
                Integer num = nadSlidingTagBaseView.getWidthMap().get(Integer.valueOf(NadSlidingTagBaseView$animatorSet$2.this.this$0.getCurrentIdx()));
                if (num == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                nadSlidingTagBaseView.i = num.intValue();
            } else {
                NadSlidingTagBaseView nadSlidingTagBaseView2 = NadSlidingTagBaseView$animatorSet$2.this.this$0;
                nadSlidingTagBaseView2.i = nadSlidingTagBaseView2.getCurrentMeasuredWidth();
            }
            int nextIndex = NadSlidingTagBaseView$animatorSet$2.this.this$0.getNextIndex();
            if (NadSlidingTagBaseView$animatorSet$2.this.this$0.getWidthMap().get(Integer.valueOf(nextIndex)) != null) {
                NadSlidingTagBaseView nadSlidingTagBaseView3 = NadSlidingTagBaseView$animatorSet$2.this.this$0;
                Integer num2 = nadSlidingTagBaseView3.getWidthMap().get(Integer.valueOf(nextIndex));
                if (num2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                nadSlidingTagBaseView3.j = num2.intValue();
            } else {
                NadSlidingTagBaseView nadSlidingTagBaseView4 = NadSlidingTagBaseView$animatorSet$2.this.this$0;
                nadSlidingTagBaseView4.j = nadSlidingTagBaseView4.getNextMeasuredWidth();
            }
            i = NadSlidingTagBaseView$animatorSet$2.this.this$0.i;
            i2 = NadSlidingTagBaseView$animatorSet$2.this.this$0.j;
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.setDuration(400L);
            ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
            ofInt.addUpdateListener(new a());
            ofInt.start();
            if (NadSlidingTagBaseView$animatorSet$2.this.this$0.getOriginalY() != 0.0f) {
                return;
            }
            for (int childCount = NadSlidingTagBaseView$animatorSet$2.this.this$0.getLinear().getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = NadSlidingTagBaseView$animatorSet$2.this.this$0.getLinear().getChildAt(childCount);
                if (childAt instanceof TextView) {
                    NadSlidingTagBaseView nadSlidingTagBaseView5 = NadSlidingTagBaseView$animatorSet$2.this.this$0;
                    float y = ((TextView) childAt).getY();
                    if (NadSlidingTagBaseView$animatorSet$2.this.this$0.getLinear().getChildAt(0) instanceof AdImageView) {
                        a2 = NadSlidingTagBaseView$animatorSet$2.this.this$0.m;
                    } else {
                        a2 = j51.c.a(NadSlidingTagBaseView$animatorSet$2.this.$context, 8.0f);
                    }
                    nadSlidingTagBaseView5.setOriginalY(y + a2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            NadSlidingTagBaseView nadSlidingTagBaseView = NadSlidingTagBaseView$animatorSet$2.this.this$0;
            nadSlidingTagBaseView.setCurrentIdx(nadSlidingTagBaseView.getNextIndex());
            TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(NadSlidingTagBaseView$animatorSet$2.this.this$0.getTvList(), NadSlidingTagBaseView$animatorSet$2.this.this$0.getCurrentIdx());
            if (textView != null) {
                LinearLayout linear = NadSlidingTagBaseView$animatorSet$2.this.this$0.getLinear();
                NadSlidingTagBaseView$animatorSet$2.this.this$0.s(textView);
                linear.addView(textView, NadSlidingTagBaseView$animatorSet$2.this.this$0.r());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ AnimatorSet a;
        public final /* synthetic */ NadSlidingTagBaseView$animatorSet$2 b;
        public final /* synthetic */ AnimatorSet c;
        public final /* synthetic */ AnimatorSet d;
        public final /* synthetic */ ValueAnimator e;

        public b(AnimatorSet animatorSet, NadSlidingTagBaseView$animatorSet$2 nadSlidingTagBaseView$animatorSet$2, AnimatorSet animatorSet2, AnimatorSet animatorSet3, ValueAnimator valueAnimator) {
            this.a = animatorSet;
            this.b = nadSlidingTagBaseView$animatorSet$2;
            this.c = animatorSet2;
            this.d = animatorSet3;
            this.e = valueAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            boolean z;
            z = this.b.this$0.h;
            if (z) {
                this.b.this$0.q();
                this.b.this$0.h = false;
                return;
            }
            this.a.start();
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            NadSlidingTagBaseView$animatorSet$2.this.this$0.w(valueAnimator);
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            NadSlidingTagBaseView$animatorSet$2.this.this$0.t(valueAnimator);
        }
    }

    /* loaded from: classes2.dex */
    public static final class f implements ValueAnimator.AnimatorUpdateListener {
        public f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            NadSlidingTagBaseView$animatorSet$2.this.this$0.v(valueAnimator);
        }
    }

    /* loaded from: classes2.dex */
    public static final class g implements ValueAnimator.AnimatorUpdateListener {
        public g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            NadSlidingTagBaseView$animatorSet$2.this.this$0.t(valueAnimator);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnimatorSet invoke() {
        long j;
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new c());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setDuration(200L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new d());
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.addListener(new e());
        AnimatorSet animatorSet2 = new AnimatorSet();
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat3.setDuration(200L);
        ofFloat3.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat3.addUpdateListener(new f());
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat4.setDuration(200L);
        ofFloat4.setInterpolator(new LinearInterpolator());
        ofFloat4.addUpdateListener(new g());
        animatorSet2.play(ofFloat3).with(ofFloat4);
        animatorSet2.addListener(new a());
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
        j = this.this$0.g;
        ofInt.setDuration(j);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.play(animatorSet).before(animatorSet2).before(ofInt);
        animatorSet3.addListener(new b(animatorSet3, this, animatorSet, animatorSet2, ofInt));
        return animatorSet3;
    }
}
