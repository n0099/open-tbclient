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
import com.baidu.tieba.b41;
import com.baidu.tieba.cq0;
import com.baidu.tieba.do0;
import com.baidu.tieba.dp0;
import com.baidu.tieba.eo0;
import com.baidu.tieba.fo0;
import com.baidu.tieba.gh0;
import com.baidu.tieba.go0;
import com.baidu.tieba.hi0;
import com.baidu.tieba.ho0;
import com.baidu.tieba.jo0;
import com.baidu.tieba.kh0;
import com.baidu.tieba.ko0;
import com.baidu.tieba.lh0;
import com.baidu.tieba.no0;
import com.baidu.tieba.oo0;
import com.baidu.tieba.qo0;
import com.baidu.tieba.ro0;
import com.baidu.tieba.sh0;
import com.baidu.tieba.to0;
import com.baidu.tieba.x01;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001?\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bS\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0002H\u0002¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0011H\u0002¢\u0006\u0004\b&\u0010'J'\u0010(\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011H\u0002¢\u0006\u0004\b(\u0010\u0019J-\u0010+\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b-\u0010#J\u0017\u00100\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0002H\u0016¢\u0006\u0004\b2\u0010\u0004J\u0017\u00103\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b3\u00101J\u0017\u00105\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001d\u0010D\u001a\u00020?8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010I\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u001d\u0010R\u001a\u00020N8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010A\u001a\u0004\bP\u0010Q¨\u0006T"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/NestedScrollComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "autoScroll", "()V", "cancelScrollAnimator", "", "fraction", "changeMaskColor", "(F)V", "Lcom/baidu/nadcore/max/event/PanelViewEvent;", "event", "handlePanelEvent", "(Lcom/baidu/nadcore/max/event/PanelViewEvent;)V", "Lcom/baidu/nadcore/max/event/PopOverViewEvent;", "handlePopEvent", "(Lcom/baidu/nadcore/max/event/PopOverViewEvent;)V", "", "scrollDown", "handleScrollAnimateEnd", "(ZZ)V", "isShowUpHalf", "handleUpAction", "(Z)V", "forceAnim", "(ZZZ)V", "Lcom/baidu/nadcore/max/event/VideoViewEvent;", "handleVideoEvent", "(Lcom/baidu/nadcore/max/event/VideoViewEvent;)V", "Lcom/baidu/nadcore/max/event/WebViewEvent;", "handleWebEvent", "(Lcom/baidu/nadcore/max/event/WebViewEvent;)V", "Landroid/view/ViewGroup;", "parent", "initVideoLPStatus", "(Landroid/view/ViewGroup;)V", "initWebViewContainer", "injectService", "isScrollAnimatorRunning", "()Z", "moveViewWithAnim", "", "moveDistance", "moveViewWithDistance", "(ZZZI)V", "onCreateView", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onRelease", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/charge/AdAreaInfo;", "adAreaInfo", "Lcom/baidu/nadcore/charge/AdAreaInfo;", "hasUpScroll", "Z", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer$OnScrollChangedCallback;", "mScrollCallback", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer$OnScrollChangedCallback;", "com/baidu/nadcore/max/uicomponent/NestedScrollComponent$nestedScrollService$2$1", "nestedScrollService$delegate", "Lkotlin/Lazy;", "getNestedScrollService", "()Lcom/baidu/nadcore/max/uicomponent/NestedScrollComponent$nestedScrollService$2$1;", "nestedScrollService", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer$OnUpListener;", "onUpListener", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer$OnUpListener;", "Landroid/animation/ValueAnimator;", "scrollAnimator", "Landroid/animation/ValueAnimator;", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer;", "webViewContainer$delegate", "getWebViewContainer", "()Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer;", "webViewContainer", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NestedScrollComponent extends AbsComponentPlugin {
    public cq0 e;
    public ValueAnimator f;
    public boolean g;
    public kh0 h;
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

        /* loaded from: classes2.dex */
        public static final class a implements oo0 {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.oo0
            public void i(MotionEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                NestedScrollComponent.this.D().dispatchTouchEvent(event);
            }

            @Override // com.baidu.tieba.oo0
            public WebViewContainer b() {
                return NestedScrollComponent.this.D();
            }

            @Override // com.baidu.tieba.oo0
            public boolean g() {
                boolean z;
                z = NestedScrollComponent.this.g;
                return z;
            }

            @Override // com.baidu.tieba.oo0
            public void f(boolean z, boolean z2, boolean z3, int i) {
                NestedScrollComponent.this.Q(z, z2, z3, i);
            }

            @Override // com.baidu.tieba.oo0
            public void j(boolean z, boolean z2, boolean z3) {
                NestedScrollComponent.this.I(z, z2, z3);
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

    public final NestedScrollComponent$nestedScrollService$2.a C() {
        return (NestedScrollComponent$nestedScrollService$2.a) this.i.getValue();
    }

    public final WebViewContainer D() {
        return (WebViewContainer) this.d.getValue();
    }

    /* loaded from: classes2.dex */
    public static final class a implements WebViewContainer.b {
        public final /* synthetic */ ro0 a;

        public a(ro0 ro0Var) {
            this.a = ro0Var;
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.WebViewContainer.b
        public final boolean a() {
            int i;
            dp0 b;
            Integer c;
            ro0 ro0Var = this.a;
            if (ro0Var != null && (b = ro0Var.b()) != null && (c = b.c()) != null) {
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

    /* loaded from: classes2.dex */
    public static final class b implements WebViewContainer.a {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.WebViewContainer.a
        public boolean a(boolean z) {
            int i;
            if (z) {
                int topMargin = NestedScrollComponent.this.D().getTopMargin();
                qo0 qo0Var = (qo0) NestedScrollComponent.this.j().o(qo0.class);
                if (qo0Var != null) {
                    i = qo0Var.getVideoHeight();
                } else {
                    i = 0;
                }
                if (topMargin <= i) {
                    NestedScrollComponent.this.H(false);
                    return true;
                }
            }
            if (!z && NestedScrollComponent.this.D().getTopMargin() >= NestedScrollComponent.this.D().getMinTopMargin()) {
                NestedScrollComponent.this.H(true);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements WebViewContainer.c {
        public c() {
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.WebViewContainer.c
        public final void onScroll(int i, int i2) {
            float f;
            int i3;
            NestedScrollComponent nestedScrollComponent;
            FrameLayout h;
            qo0 qo0Var = (qo0) NestedScrollComponent.this.j().o(qo0.class);
            if (qo0Var != null && (h = qo0Var.h()) != null) {
                f = h.getY();
            } else {
                f = 0.0f - i2;
            }
            qo0 qo0Var2 = (qo0) NestedScrollComponent.this.j().o(qo0.class);
            if (qo0Var2 != null) {
                i3 = qo0Var2.getVideoHeight();
            } else {
                i3 = 0;
            }
            float f2 = i3;
            float min = Math.min(Math.max(f, 0.0f - f2), 0.0f);
            NestedScrollComponent.this.B((f2 - nestedScrollComponent.D().getTopMargin()) / (i3 - NestedScrollComponent.this.D().getMinTopMargin()));
            NestedScrollComponent.this.j().g(new do0(NestedEvent.MOVE_VIEW, min, i3, NestedScrollComponent.this.D().getTopMargin(), NestedScrollComponent.this.D().getMinTopMargin()));
        }
    }

    /* loaded from: classes2.dex */
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
            qo0 qo0Var = (qo0) NestedScrollComponent.this.j().o(qo0.class);
            if (qo0Var != null) {
                i2 = qo0Var.getVideoHeight();
            } else {
                i2 = 0;
            }
            this.a = i2;
            if (z) {
                topMargin = i2 - NestedScrollComponent.this.D().getTopMargin();
            } else {
                topMargin = NestedScrollComponent.this.D().getTopMargin() - NestedScrollComponent.this.D().getMinTopMargin();
            }
            this.c = topMargin;
            this.d = z2 ? topMargin : i;
            this.e = NestedScrollComponent.this.D().getTopMargin();
            qo0 qo0Var2 = (qo0) NestedScrollComponent.this.j().o(qo0.class);
            if (qo0Var2 != null && (h = qo0Var2.h()) != null) {
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
                    NestedScrollComponent.this.D().scrollBy(0, -i);
                    NestedScrollComponent.this.D().setTopMargin(this.e);
                } else {
                    int i2 = (int) (this.d * (floatValue - this.b));
                    this.f -= i2;
                    this.e -= i2;
                    NestedScrollComponent.this.D().scrollBy(0, i2);
                    NestedScrollComponent.this.D().setTopMargin(this.e);
                }
                NestedScrollComponent.this.j().g(new do0(NestedEvent.MOVE_VIEW, this.f, this.a, NestedScrollComponent.this.D().getTopMargin(), NestedScrollComponent.this.D().getMinTopMargin()));
                this.b = floatValue;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    /* loaded from: classes2.dex */
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
                NestedScrollComponent.this.B(0.0f);
                NestedScrollComponent.this.j().g(new eo0(NestedEvent.SCROLL_FINISH));
                return;
            }
            NestedScrollComponent.this.G(this.c, this.d);
        }
    }

    /* loaded from: classes2.dex */
    public static final class f implements Runnable {
        public final /* synthetic */ ViewGroup b;

        public f(ViewGroup viewGroup) {
            this.b = viewGroup;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NestedScrollComponent.this.M(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class g implements WebViewContainer.d {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public g() {
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.WebViewContainer.d
        public void a(boolean z) {
            int i;
            double d;
            int topMargin = NestedScrollComponent.this.D().getTopMargin();
            qo0 qo0Var = (qo0) NestedScrollComponent.this.j().o(qo0.class);
            boolean z2 = false;
            if (qo0Var != null) {
                i = qo0Var.getVideoHeight();
            } else {
                i = 0;
            }
            if (topMargin != NestedScrollComponent.this.D().getMinTopMargin() && topMargin != i) {
                if (z) {
                    d = 0.8d;
                } else {
                    d = 0.2d;
                }
                if ((NestedScrollComponent.this.D().getTopMargin() * 1.0d) / (i * 1.0d) >= d) {
                    z2 = true;
                }
                NestedScrollComponent.this.j().g(new fo0(NestedEvent.SCROLL_UP, z));
                NestedScrollComponent.this.H(z2);
                return;
            }
            NestedScrollComponent.this.G(!z, false);
        }
    }

    public final boolean O() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        z();
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void x() {
        super.x();
        j().r(oo0.class, C());
    }

    public final void z() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void B(float f2) {
        int i;
        String e2 = gh0.e(0.6f * f2, "000000");
        Intrinsics.checkNotNullExpressionValue(e2, "AdUtil.getOpacityColor(currentOpacity, \"000000\")");
        if (f2 > 0.5d) {
            i = R.color.nad_max_webview_visivle_bg_color;
        } else {
            i = R.color.nad_max_webview_invisivle_bg_color;
        }
        D().setBackgroundColor(gh0.f(e2, i));
    }

    public final void E(go0 go0Var) {
        if (to0.$EnumSwitchMapping$2[go0Var.getType().ordinal()] == 1) {
            this.g = true;
        }
    }

    public final void F(ho0 ho0Var) {
        if (to0.$EnumSwitchMapping$3[ho0Var.getType().ordinal()] == 1) {
            this.g = true;
        }
    }

    public final void H(boolean z) {
        I(z, false, false);
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void L(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.post(new f(parent));
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        R(intent);
        N();
    }

    public final void I(boolean z, boolean z2, boolean z3) {
        cq0 cq0Var = this.e;
        if (cq0Var != null && cq0Var.q()) {
            return;
        }
        P(z, z2, z3);
    }

    public final void P(boolean z, boolean z2, boolean z3) {
        Q(z, z2, z3, -1);
    }

    public final void G(boolean z, boolean z2) {
        int i;
        String str;
        float topMargin;
        if (z) {
            j().g(new eo0(NestedEvent.UP_SHOW_VIDEO));
        } else {
            j().g(new eo0(NestedEvent.UP_SHOW_WEB));
        }
        qo0 qo0Var = (qo0) j().o(qo0.class);
        if (qo0Var != null) {
            i = qo0Var.getVideoHeight();
        } else {
            i = 0;
        }
        if (z) {
            D().scrollBy(0, -(i - D().getTopMargin()));
            D().setTopMargin(i);
            B(0.0f);
        } else {
            this.g = true;
            D().scrollBy(0, D().getTopMargin() - D().getMinTopMargin());
            D().setTopMargin(D().getMinTopMargin());
            no0 no0Var = (no0) j().o(no0.class);
            if (no0Var != null) {
                String str2 = ClogBuilder.LogType.VIDEO_LP_VIDEO_HIDE.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.LogType.VIDEO_LP_VIDEO_HIDE.type");
                if (z2) {
                    str = "0";
                } else {
                    str = "1";
                }
                no0Var.c(str2, "", str);
            }
            B(1.0f);
        }
        if (z) {
            topMargin = 0.0f;
        } else {
            topMargin = D().getTopMargin() - D().getMinTopMargin();
        }
        j().g(new do0(NestedEvent.MOVE_VIEW, topMargin, i, D().getTopMargin(), D().getMinTopMargin()));
    }

    public final void J(jo0 jo0Var) {
        Map<String, String> map;
        int i = to0.$EnumSwitchMapping$1[jo0Var.getType().ordinal()];
        boolean z = true;
        if (i != 1) {
            if (i == 2) {
                kh0 kh0Var = this.h;
                Map<String, String> map2 = null;
                if (kh0Var != null) {
                    map = kh0Var.c;
                } else {
                    map = null;
                }
                kh0 kh0Var2 = this.h;
                if (kh0Var2 != null) {
                    map2 = kh0Var2.b;
                }
                String a2 = lh0.a("leftslide", map, map2, "");
                if (a2 != null && a2.length() != 0) {
                    z = false;
                }
                if (!z) {
                    sh0.c(a2, getContext());
                    no0 no0Var = (no0) j().o(no0.class);
                    if (no0Var != null) {
                        String str = ClogBuilder.LogType.FREE_CLICK.type;
                        Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
                        no0Var.a(str, "leftslide");
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        w();
    }

    public final void K(ko0 ko0Var) {
        dp0 b2;
        View l;
        ro0 ro0Var = (ro0) j().o(ro0.class);
        if (to0.$EnumSwitchMapping$0[ko0Var.getType().ordinal()] == 1) {
            D().setInterceptScrollLister(new a(ro0Var));
            if (ro0Var != null && (b2 = ro0Var.b()) != null && (l = b2.l()) != null) {
                gh0.g(l);
                D().addView(l, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void u(hi0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.u(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, ko0.class.getSimpleName())) {
            K((ko0) event);
        } else if (Intrinsics.areEqual(a2, jo0.class.getSimpleName())) {
            J((jo0) event);
        } else if (Intrinsics.areEqual(a2, go0.class.getSimpleName())) {
            E((go0) event);
        } else if (Intrinsics.areEqual(a2, ho0.class.getSimpleName())) {
            F((ho0) event);
        }
    }

    public final void M(ViewGroup viewGroup) {
        View view2;
        ViewGroup.LayoutParams layoutParams;
        int i;
        dp0 b2;
        viewGroup.addView(D(), new FrameLayout.LayoutParams(-1, -1));
        ro0 ro0Var = (ro0) j().o(ro0.class);
        FrameLayout.LayoutParams layoutParams2 = null;
        if (ro0Var != null && (b2 = ro0Var.b()) != null) {
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
        qo0 qo0Var = (qo0) j().o(qo0.class);
        if (qo0Var != null) {
            i = qo0Var.getVideoHeight();
        } else {
            i = 0;
        }
        layoutParams3.topMargin = i;
        layoutParams3.height = viewGroup.getMeasuredHeight();
        D().setTopMargin(i);
        D().setTopLimit(i);
        cq0 cq0Var = this.e;
        if (cq0Var != null && cq0Var.q()) {
            D().setStyle(2);
        } else {
            D().setStyle(3);
        }
        if (view2 != null) {
            view2.setLayoutParams(layoutParams3);
        }
        ro0 ro0Var2 = (ro0) j().o(ro0.class);
        if (ro0Var2 != null) {
            ro0Var2.e(8);
        }
    }

    public final void N() {
        D().setClipChildren(false);
        D().setLayerType(2, null);
        D().setOnScrollChangeListener(this.j);
        D().setOnUpListener(this.k);
        D().setHandleTopYMove(true);
        D().setMinFlingVelocity(400);
        D().setUpYVelocityRatio(3.5f);
        D().setInterceptFlingListener(new b());
        D().setMinTopMargin(b41.c.a(getContext(), 49.0f));
    }

    public final void Q(boolean z, boolean z2, boolean z3, int i) {
        boolean z4;
        if (!z2 && O()) {
            return;
        }
        if (i == -1) {
            z4 = true;
        } else {
            z4 = false;
        }
        z();
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

    public final void R(Intent intent) {
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
                this.e = cq0.q.a(x01.c(str2));
            }
            this.h = kh0.a(hashMap);
        }
    }

    public final void w() {
        int i;
        qo0 qo0Var;
        int i2;
        Map<String, String> map;
        if (!this.g) {
            cq0 cq0Var = this.e;
            if (cq0Var != null) {
                i = cq0Var.a();
            } else {
                i = 0;
            }
            if (i <= 0 || (qo0Var = (qo0) j().o(qo0.class)) == null || !qo0Var.k()) {
                return;
            }
            int l = qo0Var.l();
            cq0 cq0Var2 = this.e;
            if (cq0Var2 != null) {
                i2 = cq0Var2.a();
            } else {
                i2 = 0;
            }
            if (l < i2) {
                return;
            }
            kh0 kh0Var = this.h;
            Map<String, String> map2 = null;
            if (kh0Var != null) {
                map = kh0Var.c;
            } else {
                map = null;
            }
            kh0 kh0Var2 = this.h;
            if (kh0Var2 != null) {
                map2 = kh0Var2.b;
            }
            String a2 = lh0.a("postplay", map, map2, "");
            Intrinsics.checkNotNullExpressionValue(a2, "AreaChargeUtil.area2Cmd(… adAreaInfo?.mCmdMap, \"\")");
            if (!TextUtils.isEmpty(a2)) {
                if (TextUtils.equals(a2, "AD_IMMERSIVE_VIDEO_SCROLL")) {
                    I(false, true, true);
                    return;
                }
                sh0.c(a2, getContext());
                this.g = true;
            }
        }
    }
}
