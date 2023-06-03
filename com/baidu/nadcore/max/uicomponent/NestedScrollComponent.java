package com.baidu.nadcore.max.uicomponent;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.baidu.nadcore.component.AbsComponentPlugin;
import com.baidu.nadcore.max.event.NestedEvent;
import com.baidu.nadcore.max.uicomponent.NestedScrollComponent$nestedScrollService$2;
import com.baidu.nadcore.max.uiwidget.basic.WebViewContainer;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.tieba.c61;
import com.baidu.tieba.ds0;
import com.baidu.tieba.eq0;
import com.baidu.tieba.er0;
import com.baidu.tieba.fq0;
import com.baidu.tieba.gq0;
import com.baidu.tieba.hj0;
import com.baidu.tieba.hq0;
import com.baidu.tieba.ik0;
import com.baidu.tieba.iq0;
import com.baidu.tieba.kq0;
import com.baidu.tieba.lj0;
import com.baidu.tieba.lq0;
import com.baidu.tieba.mj0;
import com.baidu.tieba.oq0;
import com.baidu.tieba.pq0;
import com.baidu.tieba.rq0;
import com.baidu.tieba.sq0;
import com.baidu.tieba.tj0;
import com.baidu.tieba.uq0;
import com.baidu.tieba.y21;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001?\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bS\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0002H\u0002¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0011H\u0002¢\u0006\u0004\b&\u0010'J'\u0010(\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011H\u0002¢\u0006\u0004\b(\u0010\u0019J-\u0010+\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b-\u0010#J\u0017\u00100\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0002H\u0016¢\u0006\u0004\b2\u0010\u0004J\u0017\u00103\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b3\u00101J\u0017\u00105\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001d\u0010D\u001a\u00020?8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010I\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u001d\u0010R\u001a\u00020N8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010A\u001a\u0004\bP\u0010Q¨\u0006T"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/NestedScrollComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "autoScroll", "()V", "cancelScrollAnimator", "", "fraction", "changeMaskColor", "(F)V", "Lcom/baidu/nadcore/max/event/PanelViewEvent;", "event", "handlePanelEvent", "(Lcom/baidu/nadcore/max/event/PanelViewEvent;)V", "Lcom/baidu/nadcore/max/event/PopOverViewEvent;", "handlePopEvent", "(Lcom/baidu/nadcore/max/event/PopOverViewEvent;)V", "", "scrollDown", "handleScrollAnimateEnd", "(ZZ)V", "isShowUpHalf", "handleUpAction", "(Z)V", "forceAnim", "(ZZZ)V", "Lcom/baidu/nadcore/max/event/VideoViewEvent;", "handleVideoEvent", "(Lcom/baidu/nadcore/max/event/VideoViewEvent;)V", "Lcom/baidu/nadcore/max/event/WebViewEvent;", "handleWebEvent", "(Lcom/baidu/nadcore/max/event/WebViewEvent;)V", "Landroid/view/ViewGroup;", "parent", "initVideoLPStatus", "(Landroid/view/ViewGroup;)V", "initWebViewContainer", "injectService", "isScrollAnimatorRunning", "()Z", "moveViewWithAnim", "", "moveDistance", "moveViewWithDistance", "(ZZZI)V", "onCreateView", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onRelease", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/charge/AdAreaInfo;", "adAreaInfo", "Lcom/baidu/nadcore/charge/AdAreaInfo;", "hasUpScroll", "Z", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer$OnScrollChangedCallback;", "mScrollCallback", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer$OnScrollChangedCallback;", "com/baidu/nadcore/max/uicomponent/NestedScrollComponent$nestedScrollService$2$1", "nestedScrollService$delegate", "Lkotlin/Lazy;", "getNestedScrollService", "()Lcom/baidu/nadcore/max/uicomponent/NestedScrollComponent$nestedScrollService$2$1;", "nestedScrollService", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer$OnUpListener;", "onUpListener", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer$OnUpListener;", "Landroid/animation/ValueAnimator;", "scrollAnimator", "Landroid/animation/ValueAnimator;", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer;", "webViewContainer$delegate", "getWebViewContainer", "()Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer;", "webViewContainer", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NestedScrollComponent extends AbsComponentPlugin {
    public ds0 e;
    public ValueAnimator f;
    public boolean g;
    public lj0 h;
    public final Lazy d = LazyKt__LazyJVMKt.lazy(new Function0<WebViewContainer>() { // from class: com.baidu.nadcore.max.uicomponent.NestedScrollComponent$webViewContainer$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WebViewContainer invoke() {
            Context context;
            context = NestedScrollComponent.this.getContext();
            return new WebViewContainer(context);
        }
    });
    public final Lazy i = LazyKt__LazyJVMKt.lazy(new Function0<NestedScrollComponent$nestedScrollService$2.a>() { // from class: com.baidu.nadcore.max.uicomponent.NestedScrollComponent$nestedScrollService$2
        {
            super(0);
        }

        /* loaded from: classes3.dex */
        public static final class a implements pq0 {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.pq0
            public void i(MotionEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                NestedScrollComponent.this.G().dispatchTouchEvent(event);
            }

            @Override // com.baidu.tieba.pq0
            public WebViewContainer b() {
                return NestedScrollComponent.this.G();
            }

            @Override // com.baidu.tieba.pq0
            public boolean g() {
                boolean z;
                z = NestedScrollComponent.this.g;
                return z;
            }

            @Override // com.baidu.tieba.pq0
            public void f(boolean z, boolean z2, boolean z3, int i) {
                NestedScrollComponent.this.U(z, z2, z3, i);
            }

            @Override // com.baidu.tieba.pq0
            public void j(boolean z, boolean z2, boolean z3) {
                NestedScrollComponent.this.M(z, z2, z3);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return new a();
        }
    });
    public final WebViewContainer.c j = new c();
    public final WebViewContainer.d k = new g();

    public final NestedScrollComponent$nestedScrollService$2.a E() {
        return (NestedScrollComponent$nestedScrollService$2.a) this.i.getValue();
    }

    public final WebViewContainer G() {
        return (WebViewContainer) this.d.getValue();
    }

    /* loaded from: classes3.dex */
    public static final class a implements WebViewContainer.b {
        public final /* synthetic */ sq0 a;

        public a(sq0 sq0Var) {
            this.a = sq0Var;
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.WebViewContainer.b
        public final boolean a() {
            int i;
            er0 b;
            Integer c;
            sq0 sq0Var = this.a;
            if (sq0Var != null && (b = sq0Var.b()) != null && (c = b.c()) != null) {
                i = c.intValue();
            } else {
                i = -1;
            }
            if (i <= 0) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements WebViewContainer.a {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.WebViewContainer.a
        public boolean a(boolean z) {
            int i;
            if (z) {
                int topMargin = NestedScrollComponent.this.G().getTopMargin();
                rq0 rq0Var = (rq0) NestedScrollComponent.this.j().q(rq0.class);
                if (rq0Var != null) {
                    i = rq0Var.getVideoHeight();
                } else {
                    i = 0;
                }
                if (topMargin <= i) {
                    NestedScrollComponent.this.L(false);
                    return true;
                }
            }
            if (!z && NestedScrollComponent.this.G().getTopMargin() >= NestedScrollComponent.this.G().getMinTopMargin()) {
                NestedScrollComponent.this.L(true);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements WebViewContainer.c {
        public c() {
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.WebViewContainer.c
        public final void onScroll(int i, int i2) {
            float f;
            int i3;
            NestedScrollComponent nestedScrollComponent;
            FrameLayout h;
            rq0 rq0Var = (rq0) NestedScrollComponent.this.j().q(rq0.class);
            if (rq0Var != null && (h = rq0Var.h()) != null) {
                f = h.getY();
            } else {
                f = 0.0f - i2;
            }
            rq0 rq0Var2 = (rq0) NestedScrollComponent.this.j().q(rq0.class);
            if (rq0Var2 != null) {
                i3 = rq0Var2.getVideoHeight();
            } else {
                i3 = 0;
            }
            float f2 = i3;
            float min = Math.min(Math.max(f, 0.0f - f2), 0.0f);
            NestedScrollComponent.this.D((f2 - nestedScrollComponent.G().getTopMargin()) / (i3 - NestedScrollComponent.this.G().getMinTopMargin()));
            NestedScrollComponent.this.j().g(new eq0(NestedEvent.MOVE_VIEW, min, i3, NestedScrollComponent.this.G().getTopMargin(), NestedScrollComponent.this.G().getMinTopMargin()));
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        public final int a;
        public float b;
        public int c;
        public int d;
        public int e;
        public float f;
        public final /* synthetic */ boolean h;

        public d(boolean z, boolean z2, int i) {
            int i2;
            int topMargin;
            float f;
            FrameLayout h;
            this.h = z;
            rq0 rq0Var = (rq0) NestedScrollComponent.this.j().q(rq0.class);
            if (rq0Var != null) {
                i2 = rq0Var.getVideoHeight();
            } else {
                i2 = 0;
            }
            this.a = i2;
            if (z) {
                topMargin = i2 - NestedScrollComponent.this.G().getTopMargin();
            } else {
                topMargin = NestedScrollComponent.this.G().getTopMargin() - NestedScrollComponent.this.G().getMinTopMargin();
            }
            this.c = topMargin;
            this.d = z2 ? topMargin : i;
            this.e = NestedScrollComponent.this.G().getTopMargin();
            rq0 rq0Var2 = (rq0) NestedScrollComponent.this.j().q(rq0.class);
            if (rq0Var2 != null && (h = rq0Var2.h()) != null) {
                f = h.getY();
            } else {
                f = 0.0f;
            }
            this.f = f;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            if (animatedValue != null) {
                float floatValue = ((Float) animatedValue).floatValue();
                if (this.h) {
                    int i = (int) (this.d * (floatValue - this.b));
                    this.f += i;
                    this.e += i;
                    NestedScrollComponent.this.G().scrollBy(0, -i);
                    NestedScrollComponent.this.G().setTopMargin(this.e);
                } else {
                    int i2 = (int) (this.d * (floatValue - this.b));
                    this.f -= i2;
                    this.e -= i2;
                    NestedScrollComponent.this.G().scrollBy(0, i2);
                    NestedScrollComponent.this.G().setTopMargin(this.e);
                }
                NestedScrollComponent.this.j().g(new eq0(NestedEvent.MOVE_VIEW, this.f, this.a, NestedScrollComponent.this.G().getTopMargin(), NestedScrollComponent.this.G().getMinTopMargin()));
                this.b = floatValue;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    /* loaded from: classes3.dex */
    public static final class e extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        public e(boolean z, boolean z2, boolean z3) {
            this.b = z;
            this.c = z2;
            this.d = z3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (!this.b) {
                NestedScrollComponent.this.D(0.0f);
                NestedScrollComponent.this.j().g(new fq0(NestedEvent.SCROLL_FINISH));
                return;
            }
            NestedScrollComponent.this.J(this.c, this.d);
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements Runnable {
        public final /* synthetic */ ViewGroup b;

        public f(ViewGroup viewGroup) {
            this.b = viewGroup;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NestedScrollComponent.this.Q(this.b);
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements WebViewContainer.d {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public g() {
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.WebViewContainer.d
        public void a(boolean z) {
            int i;
            double d;
            int topMargin = NestedScrollComponent.this.G().getTopMargin();
            rq0 rq0Var = (rq0) NestedScrollComponent.this.j().q(rq0.class);
            boolean z2 = false;
            if (rq0Var != null) {
                i = rq0Var.getVideoHeight();
            } else {
                i = 0;
            }
            if (topMargin != NestedScrollComponent.this.G().getMinTopMargin() && topMargin != i) {
                if (z) {
                    d = 0.8d;
                } else {
                    d = 0.2d;
                }
                if ((NestedScrollComponent.this.G().getTopMargin() * 1.0d) / (i * 1.0d) >= d) {
                    z2 = true;
                }
                NestedScrollComponent.this.j().g(new gq0(NestedEvent.SCROLL_UP, z));
                NestedScrollComponent.this.L(z2);
                return;
            }
            NestedScrollComponent.this.J(!z, false);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void A() {
        super.A();
        j().t(pq0.class, E());
    }

    public final void C() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final boolean S() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        C();
    }

    public final void D(float f2) {
        int i;
        String e2 = hj0.e(0.6f * f2, "000000");
        Intrinsics.checkNotNullExpressionValue(e2, "AdUtil.getOpacityColor(currentOpacity, \"000000\")");
        if (f2 > 0.5d) {
            i = R.color.nad_max_webview_visivle_bg_color;
        } else {
            i = R.color.nad_max_webview_invisivle_bg_color;
        }
        G().setBackgroundColor(hj0.f(e2, i));
    }

    public final void H(hq0 hq0Var) {
        if (uq0.$EnumSwitchMapping$2[hq0Var.getType().ordinal()] == 1) {
            this.g = true;
        }
    }

    public final void I(iq0 iq0Var) {
        if (uq0.$EnumSwitchMapping$3[iq0Var.getType().ordinal()] == 1) {
            this.g = true;
        }
    }

    public final void L(boolean z) {
        M(z, false, false);
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void P(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.post(new f(parent));
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        V(intent);
        R();
    }

    public final void M(boolean z, boolean z2, boolean z3) {
        ds0 ds0Var = this.e;
        if (ds0Var != null && ds0Var.q()) {
            return;
        }
        T(z, z2, z3);
    }

    public final void T(boolean z, boolean z2, boolean z3) {
        U(z, z2, z3, -1);
    }

    public final void J(boolean z, boolean z2) {
        int i;
        String str;
        float topMargin;
        if (z) {
            j().g(new fq0(NestedEvent.UP_SHOW_VIDEO));
        } else {
            j().g(new fq0(NestedEvent.UP_SHOW_WEB));
        }
        rq0 rq0Var = (rq0) j().q(rq0.class);
        if (rq0Var != null) {
            i = rq0Var.getVideoHeight();
        } else {
            i = 0;
        }
        if (z) {
            G().scrollBy(0, -(i - G().getTopMargin()));
            G().setTopMargin(i);
            D(0.0f);
        } else {
            this.g = true;
            G().scrollBy(0, G().getTopMargin() - G().getMinTopMargin());
            G().setTopMargin(G().getMinTopMargin());
            oq0 oq0Var = (oq0) j().q(oq0.class);
            if (oq0Var != null) {
                String str2 = ClogBuilder.LogType.VIDEO_LP_VIDEO_HIDE.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.LogType.VIDEO_LP_VIDEO_HIDE.type");
                if (z2) {
                    str = "0";
                } else {
                    str = "1";
                }
                oq0Var.c(str2, "", str);
            }
            D(1.0f);
        }
        if (z) {
            topMargin = 0.0f;
        } else {
            topMargin = G().getTopMargin() - G().getMinTopMargin();
        }
        j().g(new eq0(NestedEvent.MOVE_VIEW, topMargin, i, G().getTopMargin(), G().getMinTopMargin()));
    }

    public final void N(kq0 kq0Var) {
        Map<String, String> map;
        int i = uq0.$EnumSwitchMapping$1[kq0Var.getType().ordinal()];
        boolean z = true;
        if (i != 1) {
            if (i == 2) {
                lj0 lj0Var = this.h;
                Map<String, String> map2 = null;
                if (lj0Var != null) {
                    map = lj0Var.c;
                } else {
                    map = null;
                }
                lj0 lj0Var2 = this.h;
                if (lj0Var2 != null) {
                    map2 = lj0Var2.b;
                }
                String a2 = mj0.a("leftslide", map, map2, "");
                if (a2 != null && a2.length() != 0) {
                    z = false;
                }
                if (!z) {
                    tj0.c(a2, getContext());
                    oq0 oq0Var = (oq0) j().q(oq0.class);
                    if (oq0Var != null) {
                        String str = ClogBuilder.LogType.FREE_CLICK.type;
                        Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
                        oq0Var.a(str, "leftslide");
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        z();
    }

    public final void O(lq0 lq0Var) {
        er0 b2;
        View l;
        sq0 sq0Var = (sq0) j().q(sq0.class);
        if (uq0.$EnumSwitchMapping$0[lq0Var.getType().ordinal()] == 1) {
            G().setInterceptScrollLister(new a(sq0Var));
            if (sq0Var != null && (b2 = sq0Var.b()) != null && (l = b2.l()) != null) {
                hj0.g(l);
                G().addView(l, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void w(ik0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.w(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, lq0.class.getSimpleName())) {
            O((lq0) event);
        } else if (Intrinsics.areEqual(a2, kq0.class.getSimpleName())) {
            N((kq0) event);
        } else if (Intrinsics.areEqual(a2, hq0.class.getSimpleName())) {
            H((hq0) event);
        } else if (Intrinsics.areEqual(a2, iq0.class.getSimpleName())) {
            I((iq0) event);
        }
    }

    public final void Q(ViewGroup viewGroup) {
        View view2;
        ViewGroup.LayoutParams layoutParams;
        int i;
        er0 b2;
        viewGroup.addView(G(), new FrameLayout.LayoutParams(-1, -1));
        sq0 sq0Var = (sq0) j().q(sq0.class);
        FrameLayout.LayoutParams layoutParams2 = null;
        if (sq0Var != null && (b2 = sq0Var.b()) != null) {
            view2 = b2.l();
        } else {
            view2 = null;
        }
        if (view2 != null) {
            layoutParams = view2.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            layoutParams2 = layoutParams;
        }
        FrameLayout.LayoutParams layoutParams3 = layoutParams2;
        if (layoutParams3 == null) {
            layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        }
        rq0 rq0Var = (rq0) j().q(rq0.class);
        if (rq0Var != null) {
            i = rq0Var.getVideoHeight();
        } else {
            i = 0;
        }
        layoutParams3.topMargin = i;
        layoutParams3.height = viewGroup.getMeasuredHeight();
        G().setTopMargin(i);
        G().setTopLimit(i);
        ds0 ds0Var = this.e;
        if (ds0Var != null && ds0Var.q()) {
            G().setStyle(2);
        } else {
            G().setStyle(3);
        }
        if (view2 != null) {
            view2.setLayoutParams(layoutParams3);
        }
        sq0 sq0Var2 = (sq0) j().q(sq0.class);
        if (sq0Var2 != null) {
            sq0Var2.e(8);
        }
    }

    public final void R() {
        G().setClipChildren(false);
        G().setLayerType(2, null);
        G().setOnScrollChangeListener(this.j);
        G().setOnUpListener(this.k);
        G().setHandleTopYMove(true);
        G().setMinFlingVelocity(400);
        G().setUpYVelocityRatio(3.5f);
        G().setInterceptFlingListener(new b());
        G().setMinTopMargin(c61.c.a(getContext(), 49.0f));
    }

    public final void U(boolean z, boolean z2, boolean z3, int i) {
        boolean z4;
        if (!z2 && S()) {
            return;
        }
        if (i == -1) {
            z4 = true;
        } else {
            z4 = false;
        }
        C();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(250L);
        }
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        ValueAnimator valueAnimator2 = this.f;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new d(z, z4, i));
        }
        ValueAnimator valueAnimator3 = this.f;
        if (valueAnimator3 != null) {
            valueAnimator3.addListener(new e(z4, z, z3));
        }
        ValueAnimator valueAnimator4 = this.f;
        if (valueAnimator4 != null) {
            valueAnimator4.start();
        }
    }

    public final void V(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("map");
        String str = null;
        if (!(serializableExtra instanceof HashMap)) {
            serializableExtra = null;
        }
        HashMap hashMap = (HashMap) serializableExtra;
        if (hashMap != null) {
            Object obj = hashMap.get("cmd_policy");
            if (obj instanceof String) {
                str = obj;
            }
            String str2 = str;
            if (!TextUtils.isEmpty(str2)) {
                this.e = ds0.q.a(y21.c(str2));
            }
            this.h = lj0.a(hashMap);
        }
    }

    public final void z() {
        int i;
        rq0 rq0Var;
        int i2;
        Map<String, String> map;
        if (!this.g) {
            ds0 ds0Var = this.e;
            if (ds0Var != null) {
                i = ds0Var.a();
            } else {
                i = 0;
            }
            if (i <= 0 || (rq0Var = (rq0) j().q(rq0.class)) == null || !rq0Var.k()) {
                return;
            }
            int l = rq0Var.l();
            ds0 ds0Var2 = this.e;
            if (ds0Var2 != null) {
                i2 = ds0Var2.a();
            } else {
                i2 = 0;
            }
            if (l < i2) {
                return;
            }
            lj0 lj0Var = this.h;
            Map<String, String> map2 = null;
            if (lj0Var != null) {
                map = lj0Var.c;
            } else {
                map = null;
            }
            lj0 lj0Var2 = this.h;
            if (lj0Var2 != null) {
                map2 = lj0Var2.b;
            }
            String a2 = mj0.a("postplay", map, map2, "");
            Intrinsics.checkNotNullExpressionValue(a2, "AreaChargeUtil.area2Cmd(… adAreaInfo?.mCmdMap, \"\")");
            if (!TextUtils.isEmpty(a2)) {
                if (TextUtils.equals(a2, "AD_IMMERSIVE_VIDEO_SCROLL")) {
                    M(false, true, true);
                    return;
                }
                tj0.c(a2, getContext());
                this.g = true;
            }
        }
    }
}
