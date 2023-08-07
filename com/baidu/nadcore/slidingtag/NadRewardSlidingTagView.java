package com.baidu.nadcore.slidingtag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.core.content.ContextCompat;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.tieba.R;
import com.baidu.tieba.ch0;
import com.baidu.tieba.es0;
import com.baidu.tieba.h61;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yy.gslbsdk.db.DelayTB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001aB'\b\u0007\u0012\u0006\u0010]\u001a\u00020\\\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010^\u001a\u00020\u0005¢\u0006\u0004\b_\u0010`J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u0007J!\u0010\u0012\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u0015\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b#\u0010\"J\u0017\u0010$\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b$\u0010\"J\u0015\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0005¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b(\u0010\"J\u001f\u0010)\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b)\u0010\u0013J\u0017\u0010*\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b*\u0010\"J\r\u0010+\u001a\u00020\u0002¢\u0006\u0004\b+\u0010\u0004J\u0019\u0010.\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\b.\u0010/J\u0019\u00100\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\b0\u0010/J\u0019\u00101\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\b1\u0010/J\u0013\u00102\u001a\u00020\b*\u00020\bH\u0002¢\u0006\u0004\b2\u00103R\u001d\u00109\u001a\u0002048B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0016\u0010:\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u001d\u0010B\u001a\u00020>8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u00106\u001a\u0004\b@\u0010AR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010CR\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010;R\u0016\u0010H\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010;R\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010L\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010;R\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010KR\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020U0T8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR2\u0010Z\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050Xj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006b"}, d2 = {"Lcom/baidu/nadcore/slidingtag/NadRewardSlidingTagView;", "Landroid/widget/FrameLayout;", "", "destroy", "()V", "", "getCurrentMeasuredWidth", "()I", "Landroid/view/View;", "view", "getMeasuredWidth", "(Landroid/view/View;)I", "getNextIndex", "getNextMeasuredWidth", "Lcom/baidu/nadcore/model/NadSlidingTagModel;", "model", "", DelayTB.DELAY, "innerStartDelay", "(Lcom/baidu/nadcore/model/NadSlidingTagModel;J)V", "makeSureAtLeastOneTvDisplayWhenStop", "Landroid/widget/LinearLayout$LayoutParams;", "newTextViewLayoutParams", "()Landroid/widget/LinearLayout$LayoutParams;", "Landroid/util/AttributeSet;", "attributeSet", "processAttrs", "(Landroid/util/AttributeSet;)V", "reset", "Lcom/baidu/nadcore/slidingtag/NadRewardSlidingTagView$IOnActionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lcom/baidu/nadcore/slidingtag/NadRewardSlidingTagView$IOnActionListener;)V", "setAnimation", "(Lcom/baidu/nadcore/model/NadSlidingTagModel;)V", "setFrame", "setLinear", "maxWidthPx", "setMaxWidth", "(I)V", "setTextViewList", "startAnimationWithDelay", "startDelay", "stop", "Landroid/animation/ValueAnimator;", ShaderParams.VALUE_TYPE_ANIMATOR, "updateAlphaAnimation", "(Landroid/animation/ValueAnimator;)V", "updateFadeInPositionAnimation", "updateFadeOutPositionAnimation", "removeFromParent", "(Landroid/view/View;)Landroid/view/View;", "Landroid/animation/AnimatorSet;", "animatorSet$delegate", "Lkotlin/Lazy;", "getAnimatorSet", "()Landroid/animation/AnimatorSet;", "animatorSet", "currentIdx", "I", "displayIntervalMillis", "J", "Landroid/widget/LinearLayout;", "linear$delegate", "getLinear", "()Landroid/widget/LinearLayout;", Easing.LINEAR_NAME, "Lcom/baidu/nadcore/slidingtag/NadRewardSlidingTagView$IOnActionListener;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "maxWidth", "nextWidth", "", "originalY", "F", "prevWidth", "Ljava/lang/Runnable;", "startAnimation", "Ljava/lang/Runnable;", "", "stopAnimationFlag", "Z", "textSizePx", "", "Landroid/widget/TextView;", "tvList", "Ljava/util/List;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "widthMap", "Ljava/util/HashMap;", "Landroid/content/Context;", "context", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "IOnActionListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRewardSlidingTagView extends FrameLayout {
    public final Lazy a;
    public final List<TextView> b;
    public int c;
    public float d;
    public long e;
    public boolean f;
    public a g;
    public final Runnable h;
    public final Handler i;
    public int j;
    public int k;
    public int l;
    public float m;
    public HashMap<Integer, Integer> n;
    public final Lazy o;

    /* loaded from: classes3.dex */
    public interface a {
        void a(Context context, String str, int i, String str2);
    }

    @JvmOverloads
    public NadRewardSlidingTagView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public NadRewardSlidingTagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AnimatorSet getAnimatorSet() {
        return (AnimatorSet) this.o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout getLinear() {
        return (LinearLayout) this.a.getValue();
    }

    /* loaded from: classes3.dex */
    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LinearLayout a;
        public final /* synthetic */ NadRewardSlidingTagView b;
        public final /* synthetic */ es0 c;

        public b(LinearLayout linearLayout, NadRewardSlidingTagView nadRewardSlidingTagView, es0 es0Var) {
            this.a = linearLayout;
            this.b = nadRewardSlidingTagView;
            this.c = es0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            CharSequence text;
            a aVar = this.b.g;
            if (aVar != null) {
                Context context = this.a.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(this.b.b, this.b.c);
                aVar.a(context, (textView == null || (text = textView.getText()) == null || (r1 = text.toString()) == null) ? "" : "", this.b.c, this.c.g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NadRewardSlidingTagView.this.getAnimatorSet().start();
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NadRewardSlidingTagView.this.getAnimatorSet().cancel();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadRewardSlidingTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.baidu.nadcore.slidingtag.NadRewardSlidingTagView$linear$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View findViewById = NadRewardSlidingTagView.this.findViewById(R.id.nad_sliding_tag_layout_linear);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.nad_sliding_tag_layout_linear)");
                return (LinearLayout) findViewById;
            }
        });
        this.b = new ArrayList();
        this.e = 3000L;
        this.h = new c();
        this.i = new Handler(Looper.getMainLooper());
        this.m = h61.c.a(context, 11.0f);
        this.n = new HashMap<>();
        this.o = LazyKt__LazyJVMKt.lazy(new Function0<AnimatorSet>() { // from class: com.baidu.nadcore.slidingtag.NadRewardSlidingTagView$animatorSet$2
            {
                super(0);
            }

            /* loaded from: classes3.dex */
            public static final class a extends AnimatorListenerAdapter {
                public a() {
                }

                /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                    jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.nadcore.slidingtag.NadRewardSlidingTagView.o(com.baidu.nadcore.slidingtag.NadRewardSlidingTagView, android.view.View):android.view.View
                    	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                    	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
                    	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
                    	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
                    	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
                    	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                    	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                    	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                    	... 1 more
                    */
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator r3) {
                    /*
                        r2 = this;
                        java.lang.String r0 = "animation"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                        com.baidu.nadcore.slidingtag.NadRewardSlidingTagView$animatorSet$2 r3 = com.baidu.nadcore.slidingtag.NadRewardSlidingTagView$animatorSet$2.this
                        com.baidu.nadcore.slidingtag.NadRewardSlidingTagView r3 = com.baidu.nadcore.slidingtag.NadRewardSlidingTagView.this
                        int r0 = com.baidu.nadcore.slidingtag.NadRewardSlidingTagView.g(r3)
                        com.baidu.nadcore.slidingtag.NadRewardSlidingTagView.p(r3, r0)
                        com.baidu.nadcore.slidingtag.NadRewardSlidingTagView$animatorSet$2 r3 = com.baidu.nadcore.slidingtag.NadRewardSlidingTagView$animatorSet$2.this
                        com.baidu.nadcore.slidingtag.NadRewardSlidingTagView r3 = com.baidu.nadcore.slidingtag.NadRewardSlidingTagView.this
                        java.util.List r3 = com.baidu.nadcore.slidingtag.NadRewardSlidingTagView.k(r3)
                        com.baidu.nadcore.slidingtag.NadRewardSlidingTagView$animatorSet$2 r0 = com.baidu.nadcore.slidingtag.NadRewardSlidingTagView$animatorSet$2.this
                        com.baidu.nadcore.slidingtag.NadRewardSlidingTagView r0 = com.baidu.nadcore.slidingtag.NadRewardSlidingTagView.this
                        int r0 = com.baidu.nadcore.slidingtag.NadRewardSlidingTagView.b(r0)
                        java.lang.Object r3 = kotlin.collections.CollectionsKt___CollectionsKt.getOrNull(r3, r0)
                        android.widget.TextView r3 = (android.widget.TextView) r3
                        if (r3 == 0) goto L42
                        com.baidu.nadcore.slidingtag.NadRewardSlidingTagView$animatorSet$2 r0 = com.baidu.nadcore.slidingtag.NadRewardSlidingTagView$animatorSet$2.this
                        com.baidu.nadcore.slidingtag.NadRewardSlidingTagView r0 = com.baidu.nadcore.slidingtag.NadRewardSlidingTagView.this
                        android.widget.LinearLayout r0 = com.baidu.nadcore.slidingtag.NadRewardSlidingTagView.e(r0)
                        com.baidu.nadcore.slidingtag.NadRewardSlidingTagView$animatorSet$2 r1 = com.baidu.nadcore.slidingtag.NadRewardSlidingTagView$animatorSet$2.this
                        com.baidu.nadcore.slidingtag.NadRewardSlidingTagView r1 = com.baidu.nadcore.slidingtag.NadRewardSlidingTagView.this
                        com.baidu.nadcore.slidingtag.NadRewardSlidingTagView.o(r1, r3)
                        com.baidu.nadcore.slidingtag.NadRewardSlidingTagView$animatorSet$2 r1 = com.baidu.nadcore.slidingtag.NadRewardSlidingTagView$animatorSet$2.this
                        com.baidu.nadcore.slidingtag.NadRewardSlidingTagView r1 = com.baidu.nadcore.slidingtag.NadRewardSlidingTagView.this
                        android.widget.LinearLayout$LayoutParams r1 = com.baidu.nadcore.slidingtag.NadRewardSlidingTagView.n(r1)
                        r0.addView(r3, r1)
                    L42:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.nadcore.slidingtag.NadRewardSlidingTagView$animatorSet$2.a.onAnimationStart(android.animation.Animator):void");
                }
            }

            /* loaded from: classes3.dex */
            public static final class b extends AnimatorListenerAdapter {
                public final /* synthetic */ AnimatorSet a;
                public final /* synthetic */ NadRewardSlidingTagView$animatorSet$2 b;
                public final /* synthetic */ AnimatorSet c;
                public final /* synthetic */ AnimatorSet d;
                public final /* synthetic */ ValueAnimator e;

                public b(AnimatorSet animatorSet, NadRewardSlidingTagView$animatorSet$2 nadRewardSlidingTagView$animatorSet$2, AnimatorSet animatorSet2, AnimatorSet animatorSet3, ValueAnimator valueAnimator) {
                    this.a = animatorSet;
                    this.b = nadRewardSlidingTagView$animatorSet$2;
                    this.c = animatorSet2;
                    this.d = animatorSet3;
                    this.e = valueAnimator;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    boolean z;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    z = NadRewardSlidingTagView.this.f;
                    if (!z) {
                        this.a.start();
                        return;
                    }
                    NadRewardSlidingTagView.this.A();
                    NadRewardSlidingTagView.this.f = false;
                }
            }

            /* loaded from: classes3.dex */
            public static final class c implements ValueAnimator.AnimatorUpdateListener {
                public c() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    NadRewardSlidingTagView.this.K(valueAnimator);
                }
            }

            /* loaded from: classes3.dex */
            public static final class d implements ValueAnimator.AnimatorUpdateListener {
                public d() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    NadRewardSlidingTagView.this.I(valueAnimator);
                }
            }

            /* loaded from: classes3.dex */
            public static final class e extends AnimatorListenerAdapter {
                public e() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    LinearLayout linear;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(NadRewardSlidingTagView.this.b, NadRewardSlidingTagView.this.c);
                    if (textView == null) {
                        return;
                    }
                    linear = NadRewardSlidingTagView.this.getLinear();
                    linear.removeView(textView);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    HashMap hashMap;
                    int currentMeasuredWidth;
                    int nextIndex;
                    HashMap hashMap2;
                    int nextMeasuredWidth;
                    float f;
                    LinearLayout linear;
                    LinearLayout linear2;
                    HashMap hashMap3;
                    HashMap hashMap4;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    NadRewardSlidingTagView nadRewardSlidingTagView = NadRewardSlidingTagView.this;
                    hashMap = nadRewardSlidingTagView.n;
                    if (hashMap.get(Integer.valueOf(NadRewardSlidingTagView.this.c)) != null) {
                        hashMap4 = NadRewardSlidingTagView.this.n;
                        Object obj = hashMap4.get(Integer.valueOf(NadRewardSlidingTagView.this.c));
                        if (obj != null) {
                            currentMeasuredWidth = ((Integer) obj).intValue();
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                        }
                    } else {
                        currentMeasuredWidth = NadRewardSlidingTagView.this.getCurrentMeasuredWidth();
                    }
                    nadRewardSlidingTagView.j = currentMeasuredWidth;
                    nextIndex = NadRewardSlidingTagView.this.getNextIndex();
                    NadRewardSlidingTagView nadRewardSlidingTagView2 = NadRewardSlidingTagView.this;
                    hashMap2 = nadRewardSlidingTagView2.n;
                    if (hashMap2.get(Integer.valueOf(nextIndex)) != null) {
                        hashMap3 = NadRewardSlidingTagView.this.n;
                        Object obj2 = hashMap3.get(Integer.valueOf(nextIndex));
                        if (obj2 != null) {
                            nextMeasuredWidth = ((Integer) obj2).intValue();
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                        }
                    } else {
                        nextMeasuredWidth = NadRewardSlidingTagView.this.getNextMeasuredWidth();
                    }
                    nadRewardSlidingTagView2.k = nextMeasuredWidth;
                    f = NadRewardSlidingTagView.this.d;
                    if (f != 0.0f) {
                        return;
                    }
                    linear = NadRewardSlidingTagView.this.getLinear();
                    for (int childCount = linear.getChildCount() - 1; childCount >= 0; childCount--) {
                        linear2 = NadRewardSlidingTagView.this.getLinear();
                        View childAt = linear2.getChildAt(childCount);
                        if (childAt instanceof TextView) {
                            NadRewardSlidingTagView.this.d = ((TextView) childAt).getY();
                            return;
                        }
                    }
                }
            }

            /* loaded from: classes3.dex */
            public static final class f implements ValueAnimator.AnimatorUpdateListener {
                public f() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    NadRewardSlidingTagView.this.J(valueAnimator);
                }
            }

            /* loaded from: classes3.dex */
            public static final class g implements ValueAnimator.AnimatorUpdateListener {
                public g() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    NadRewardSlidingTagView.this.I(valueAnimator);
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
                j = NadRewardSlidingTagView.this.e;
                ofInt.setDuration(j);
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.play(animatorSet).before(animatorSet2).before(ofInt);
                animatorSet3.addListener(new b(animatorSet3, this, animatorSet, animatorSet2, ofInt));
                return animatorSet3;
            }
        });
        LayoutInflater.from(context).inflate(R.layout.nad_reward_sliding_tag, (ViewGroup) this, true);
        C(attributeSet);
    }

    public /* synthetic */ NadRewardSlidingTagView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.nadcore.slidingtag.NadRewardSlidingTagView$animatorSet$2.a.onAnimationStart(android.animation.Animator):void] */
    public static final /* synthetic */ LinearLayout.LayoutParams n(NadRewardSlidingTagView nadRewardSlidingTagView) {
        return nadRewardSlidingTagView.B();
    }

    private final void setAnimation(es0 es0Var) {
        this.e = es0Var.d;
    }

    private final void setFrame(es0 es0Var) {
        int i;
        if (getLinear().getVisibility() == 0) {
            i = 0;
        } else {
            i = 8;
        }
        setVisibility(i);
    }

    public final void C(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, ch0.NadRewardSlidingTagView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr….NadRewardSlidingTagView)");
        this.m = obtainStyledAttributes.getDimension(0, h61.c.a(getContext(), 11.0f));
    }

    public final View D(View view2) {
        ViewParent parent = view2.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(view2);
        }
        return view2;
    }

    public final void G(es0 es0Var) {
        long j;
        if (es0Var != null) {
            j = es0Var.e;
        } else {
            j = 3000;
        }
        z(es0Var, j);
    }

    public final void I(ValueAnimator valueAnimator) {
        Object obj;
        Float f = null;
        if (valueAnimator != null) {
            obj = valueAnimator.getAnimatedValue();
        } else {
            obj = null;
        }
        if (obj instanceof Float) {
            f = obj;
        }
        Float f2 = f;
        if (f2 != null) {
            float floatValue = f2.floatValue();
            TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(this.b, this.c);
            if (textView != null) {
                textView.setAlpha(floatValue);
            }
        }
    }

    public final void setActionListener(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.g = listener;
    }

    public final void setMaxWidth(int i) {
        this.l = i;
    }

    public final int y(View view2) {
        view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return view2.getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCurrentMeasuredWidth() {
        TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(this.b, this.c);
        if (textView == null) {
            setVisibility(8);
            return 0;
        }
        if (textView.getLayoutParams() == null) {
            textView.setLayoutParams(B());
        }
        int a2 = h61.c.a(getContext(), 7.0f) + y(textView) + h61.c.a(getContext(), 7.0f);
        int i = this.l;
        if (i > 0) {
            a2 = RangesKt___RangesKt.coerceAtMost(a2, i);
        }
        this.n.put(Integer.valueOf(this.c), Integer.valueOf(a2));
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getNextMeasuredWidth() {
        int nextIndex = getNextIndex();
        TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(this.b, nextIndex);
        if (textView == null) {
            setVisibility(8);
            return 0;
        }
        if (textView.getLayoutParams() == null) {
            textView.setLayoutParams(B());
        }
        int a2 = h61.c.a(getContext(), 7.0f) + y(textView) + h61.c.a(getContext(), 7.0f);
        int i = this.l;
        if (i > 0) {
            a2 = RangesKt___RangesKt.coerceAtMost(a2, i);
        }
        this.n.put(Integer.valueOf(nextIndex), Integer.valueOf(a2));
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getNextIndex() {
        int size = this.b.size();
        int i = this.c;
        int i2 = i + 1;
        if (i2 >= 0 && size > i2) {
            return i + 1;
        }
        return 0;
    }

    public final LinearLayout.LayoutParams B() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public final void E() {
        getLinear().removeAllViews();
        this.b.clear();
        this.c = 0;
        this.d = 0.0f;
        this.f = false;
        setVisibility(8);
        this.n.clear();
    }

    public final void H() {
        if (getVisibility() != 0) {
            return;
        }
        this.i.removeCallbacks(this.h);
        if (getAnimatorSet().isStarted()) {
            this.f = true;
            this.i.post(new d());
        }
        this.n.clear();
    }

    public final void x() {
        H();
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    public static final /* synthetic */ android.view.View o(com.baidu.nadcore.slidingtag.NadRewardSlidingTagView r0, android.view.View r1) {
        /*
            r0.D(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.nadcore.slidingtag.NadRewardSlidingTagView.o(com.baidu.nadcore.slidingtag.NadRewardSlidingTagView, android.view.View):android.view.View");
    }

    public final void F(es0 es0Var, long j) {
        if (getVisibility() != 0) {
            return;
        }
        H();
        if (this.b.size() < 2) {
            return;
        }
        this.i.postDelayed(this.h, j);
    }

    public final void z(es0 es0Var, long j) {
        boolean z;
        E();
        if (es0Var != null) {
            List<es0.c> list = es0Var.a;
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                setTextViewList(es0Var);
                setLinear(es0Var);
                setFrame(es0Var);
                setAnimation(es0Var);
                F(es0Var, j);
            }
        }
    }

    private final void setLinear(es0 es0Var) {
        LinearLayout linear = getLinear();
        int i = 0;
        if (!this.b.isEmpty()) {
            linear.setGravity(16);
            TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(this.b, 0);
            if (textView != null) {
                D(textView);
                linear.addView(textView, B());
                Unit unit = Unit.INSTANCE;
            }
            linear.setOnClickListener(new b(linear, this, es0Var));
        } else {
            i = 8;
        }
        linear.setVisibility(i);
    }

    public final void J(ValueAnimator valueAnimator) {
        Object obj;
        Float f = null;
        if (valueAnimator != null) {
            obj = valueAnimator.getAnimatedValue();
        } else {
            obj = null;
        }
        if (obj instanceof Float) {
            f = obj;
        }
        Float f2 = f;
        if (f2 != null) {
            float floatValue = f2.floatValue();
            TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(this.b, this.c);
            if (textView != null) {
                textView.setY(this.d + (h61.c.a(getContext(), 4.0f) * (1 - floatValue)));
            }
        }
    }

    public final void K(ValueAnimator valueAnimator) {
        Object obj;
        Float f = null;
        if (valueAnimator != null) {
            obj = valueAnimator.getAnimatedValue();
        } else {
            obj = null;
        }
        if (obj instanceof Float) {
            f = obj;
        }
        Float f2 = f;
        if (f2 != null) {
            float floatValue = f2.floatValue();
            TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(this.b, this.c);
            if (textView != null) {
                textView.setY(this.d - (h61.c.a(getContext(), 4.0f) * floatValue));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: android.text.SpannableString */
    /* JADX WARN: Multi-variable type inference failed */
    private final void setTextViewList(es0 es0Var) {
        String str;
        int color;
        int color2;
        for (es0.c cVar : es0Var.a) {
            if (!StringsKt__StringsJVMKt.isBlank(cVar.a)) {
                int[] iArr = cVar.b;
                if (iArr != null && iArr.length == 2) {
                    SpannableString spannableString = new SpannableString(cVar.a);
                    try {
                        color2 = Color.parseColor(cVar.d);
                    } catch (Throwable unused) {
                        color2 = ContextCompat.getColor(getContext(), R.color.nad_sliding_tag_highlight_color_default);
                    }
                    StyleSpan styleSpan = new StyleSpan(1);
                    ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color2);
                    spannableString.setSpan(styleSpan, iArr[0], iArr[1], 17);
                    spannableString.setSpan(foregroundColorSpan, iArr[0], iArr[1], 17);
                    str = spannableString;
                } else {
                    str = cVar.a;
                }
                try {
                    color = Color.parseColor(cVar.c);
                } catch (Throwable unused2) {
                    color = ContextCompat.getColor(getContext(), R.color.nad_sliding_tag_text_color_default);
                }
                TextView textView = new TextView(getContext());
                textView.setText(str);
                textView.setTextColor(color);
                textView.setTextSize(0, this.m);
                textView.setLayoutParams(B());
                textView.setPadding(0, 0, 0, 0);
                textView.setMaxLines(1);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setGravity(16);
                textView.setIncludeFontPadding(false);
                textView.setVisibility(0);
                this.b.add(textView);
            }
        }
    }

    public final void A() {
        if (getLinear().getChildCount() <= 0) {
            TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(this.b, this.c);
            if (textView != null) {
                textView.setAlpha(1.0f);
                textView.setVisibility(0);
                LinearLayout linear = getLinear();
                D(textView);
                linear.addView(textView, B());
                return;
            }
            return;
        }
        View childAt = getLinear().getChildAt(getLinear().getChildCount() - 1);
        if (childAt != null && (childAt instanceof TextView)) {
            TextView textView2 = (TextView) childAt;
            textView2.setAlpha(1.0f);
            textView2.setVisibility(0);
            LinearLayout linear2 = getLinear();
            D(childAt);
            linear2.addView(childAt, B());
            return;
        }
        TextView textView3 = (TextView) CollectionsKt___CollectionsKt.getOrNull(this.b, this.c);
        if (textView3 != null) {
            textView3.setAlpha(1.0f);
            textView3.setVisibility(0);
            LinearLayout linear3 = getLinear();
            D(textView3);
            linear3.addView(textView3, B());
        }
    }
}
