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
import com.baidu.tieba.aj0;
import com.baidu.tieba.bq0;
import com.baidu.tieba.f21;
import com.baidu.tieba.j51;
import com.baidu.tieba.kr0;
import com.baidu.tieba.lp0;
import com.baidu.tieba.lq0;
import com.baidu.tieba.mp0;
import com.baidu.tieba.np0;
import com.baidu.tieba.oi0;
import com.baidu.tieba.op0;
import com.baidu.tieba.pj0;
import com.baidu.tieba.pp0;
import com.baidu.tieba.rp0;
import com.baidu.tieba.si0;
import com.baidu.tieba.sp0;
import com.baidu.tieba.ti0;
import com.baidu.tieba.vp0;
import com.baidu.tieba.wp0;
import com.baidu.tieba.yp0;
import com.baidu.tieba.zp0;
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
    public kr0 e;
    public ValueAnimator f;
    public boolean g;
    public si0 h;
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
        public static final class a implements wp0 {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.wp0
            public void i(MotionEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                NestedScrollComponent.this.C().dispatchTouchEvent(event);
            }

            @Override // com.baidu.tieba.wp0
            public WebViewContainer b() {
                return NestedScrollComponent.this.C();
            }

            @Override // com.baidu.tieba.wp0
            public boolean g() {
                boolean z;
                z = NestedScrollComponent.this.g;
                return z;
            }

            @Override // com.baidu.tieba.wp0
            public void f(boolean z, boolean z2, boolean z3, int i) {
                NestedScrollComponent.this.S(z, z2, z3, i);
            }

            @Override // com.baidu.tieba.wp0
            public void j(boolean z, boolean z2, boolean z3) {
                NestedScrollComponent.this.L(z, z2, z3);
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

    public final NestedScrollComponent$nestedScrollService$2.a B() {
        return (NestedScrollComponent$nestedScrollService$2.a) this.i.getValue();
    }

    public final WebViewContainer C() {
        return (WebViewContainer) this.d.getValue();
    }

    /* loaded from: classes2.dex */
    public static final class a implements WebViewContainer.b {
        public final /* synthetic */ zp0 a;

        public a(zp0 zp0Var) {
            this.a = zp0Var;
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.WebViewContainer.b
        public final boolean a() {
            int i;
            lq0 b;
            Integer c;
            zp0 zp0Var = this.a;
            if (zp0Var != null && (b = zp0Var.b()) != null && (c = b.c()) != null) {
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
                int topMargin = NestedScrollComponent.this.C().getTopMargin();
                yp0 yp0Var = (yp0) NestedScrollComponent.this.b().k(yp0.class);
                if (yp0Var != null) {
                    i = yp0Var.getVideoHeight();
                } else {
                    i = 0;
                }
                if (topMargin <= i) {
                    NestedScrollComponent.this.K(false);
                    return true;
                }
            }
            if (!z && NestedScrollComponent.this.C().getTopMargin() >= NestedScrollComponent.this.C().getMinTopMargin()) {
                NestedScrollComponent.this.K(true);
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
            yp0 yp0Var = (yp0) NestedScrollComponent.this.b().k(yp0.class);
            if (yp0Var != null && (h = yp0Var.h()) != null) {
                f = h.getY();
            } else {
                f = 0.0f - i2;
            }
            yp0 yp0Var2 = (yp0) NestedScrollComponent.this.b().k(yp0.class);
            if (yp0Var2 != null) {
                i3 = yp0Var2.getVideoHeight();
            } else {
                i3 = 0;
            }
            float f2 = i3;
            float min = Math.min(Math.max(f, 0.0f - f2), 0.0f);
            NestedScrollComponent.this.A((f2 - nestedScrollComponent.C().getTopMargin()) / (i3 - NestedScrollComponent.this.C().getMinTopMargin()));
            NestedScrollComponent.this.b().d(new lp0(NestedEvent.MOVE_VIEW, min, i3, NestedScrollComponent.this.C().getTopMargin(), NestedScrollComponent.this.C().getMinTopMargin()));
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
            yp0 yp0Var = (yp0) NestedScrollComponent.this.b().k(yp0.class);
            if (yp0Var != null) {
                i2 = yp0Var.getVideoHeight();
            } else {
                i2 = 0;
            }
            this.a = i2;
            if (z) {
                topMargin = i2 - NestedScrollComponent.this.C().getTopMargin();
            } else {
                topMargin = NestedScrollComponent.this.C().getTopMargin() - NestedScrollComponent.this.C().getMinTopMargin();
            }
            this.c = topMargin;
            this.d = z2 ? topMargin : i;
            this.e = NestedScrollComponent.this.C().getTopMargin();
            yp0 yp0Var2 = (yp0) NestedScrollComponent.this.b().k(yp0.class);
            if (yp0Var2 != null && (h = yp0Var2.h()) != null) {
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
                    NestedScrollComponent.this.C().scrollBy(0, -i);
                    NestedScrollComponent.this.C().setTopMargin(this.e);
                } else {
                    int i2 = (int) (this.d * (floatValue - this.b));
                    this.f -= i2;
                    this.e -= i2;
                    NestedScrollComponent.this.C().scrollBy(0, i2);
                    NestedScrollComponent.this.C().setTopMargin(this.e);
                }
                NestedScrollComponent.this.b().d(new lp0(NestedEvent.MOVE_VIEW, this.f, this.a, NestedScrollComponent.this.C().getTopMargin(), NestedScrollComponent.this.C().getMinTopMargin()));
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
                NestedScrollComponent.this.A(0.0f);
                NestedScrollComponent.this.b().d(new mp0(NestedEvent.SCROLL_FINISH));
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
            NestedScrollComponent.this.O(this.b);
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
            int topMargin = NestedScrollComponent.this.C().getTopMargin();
            yp0 yp0Var = (yp0) NestedScrollComponent.this.b().k(yp0.class);
            boolean z2 = false;
            if (yp0Var != null) {
                i = yp0Var.getVideoHeight();
            } else {
                i = 0;
            }
            if (topMargin != NestedScrollComponent.this.C().getMinTopMargin() && topMargin != i) {
                if (z) {
                    d = 0.8d;
                } else {
                    d = 0.2d;
                }
                if ((NestedScrollComponent.this.C().getTopMargin() * 1.0d) / (i * 1.0d) >= d) {
                    z2 = true;
                }
                NestedScrollComponent.this.b().d(new np0(NestedEvent.SCROLL_UP, z));
                NestedScrollComponent.this.K(z2);
                return;
            }
            NestedScrollComponent.this.G(!z, false);
        }
    }

    public final boolean Q() {
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
    public void u() {
        super.u();
        b().n(wp0.class, B());
    }

    public final void z() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void A(float f2) {
        int i;
        String e2 = oi0.e(0.6f * f2, "000000");
        Intrinsics.checkNotNullExpressionValue(e2, "AdUtil.getOpacityColor(currentOpacity, \"000000\")");
        if (f2 > 0.5d) {
            i = R.color.nad_max_webview_visivle_bg_color;
        } else {
            i = R.color.nad_max_webview_invisivle_bg_color;
        }
        C().setBackgroundColor(oi0.f(e2, i));
    }

    public final void D(op0 op0Var) {
        if (bq0.$EnumSwitchMapping$2[op0Var.getType().ordinal()] == 1) {
            this.g = true;
        }
    }

    public final void E(pp0 pp0Var) {
        if (bq0.$EnumSwitchMapping$3[pp0Var.getType().ordinal()] == 1) {
            this.g = true;
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void H(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.post(new f(parent));
    }

    public final void K(boolean z) {
        L(z, false, false);
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        T(intent);
        P();
    }

    public final void L(boolean z, boolean z2, boolean z3) {
        kr0 kr0Var = this.e;
        if (kr0Var != null && kr0Var.q()) {
            return;
        }
        R(z, z2, z3);
    }

    public final void R(boolean z, boolean z2, boolean z3) {
        S(z, z2, z3, -1);
    }

    public final void G(boolean z, boolean z2) {
        int i;
        String str;
        float topMargin;
        if (z) {
            b().d(new mp0(NestedEvent.UP_SHOW_VIDEO));
        } else {
            b().d(new mp0(NestedEvent.UP_SHOW_WEB));
        }
        yp0 yp0Var = (yp0) b().k(yp0.class);
        if (yp0Var != null) {
            i = yp0Var.getVideoHeight();
        } else {
            i = 0;
        }
        if (z) {
            C().scrollBy(0, -(i - C().getTopMargin()));
            C().setTopMargin(i);
            A(0.0f);
        } else {
            this.g = true;
            C().scrollBy(0, C().getTopMargin() - C().getMinTopMargin());
            C().setTopMargin(C().getMinTopMargin());
            vp0 vp0Var = (vp0) b().k(vp0.class);
            if (vp0Var != null) {
                String str2 = ClogBuilder.LogType.VIDEO_LP_VIDEO_HIDE.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.LogType.VIDEO_LP_VIDEO_HIDE.type");
                if (z2) {
                    str = "0";
                } else {
                    str = "1";
                }
                vp0Var.c(str2, "", str);
            }
            A(1.0f);
        }
        if (z) {
            topMargin = 0.0f;
        } else {
            topMargin = C().getTopMargin() - C().getMinTopMargin();
        }
        b().d(new lp0(NestedEvent.MOVE_VIEW, topMargin, i, C().getTopMargin(), C().getMinTopMargin()));
    }

    public final void M(rp0 rp0Var) {
        Map<String, String> map;
        int i = bq0.$EnumSwitchMapping$1[rp0Var.getType().ordinal()];
        boolean z = true;
        if (i != 1) {
            if (i == 2) {
                si0 si0Var = this.h;
                Map<String, String> map2 = null;
                if (si0Var != null) {
                    map = si0Var.c;
                } else {
                    map = null;
                }
                si0 si0Var2 = this.h;
                if (si0Var2 != null) {
                    map2 = si0Var2.b;
                }
                String a2 = ti0.a("leftslide", map, map2, "");
                if (a2 != null && a2.length() != 0) {
                    z = false;
                }
                if (!z) {
                    aj0.c(a2, getContext());
                    vp0 vp0Var = (vp0) b().k(vp0.class);
                    if (vp0Var != null) {
                        String str = ClogBuilder.LogType.FREE_CLICK.type;
                        Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
                        vp0Var.a(str, "leftslide");
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

    public final void N(sp0 sp0Var) {
        lq0 b2;
        View l;
        zp0 zp0Var = (zp0) b().k(zp0.class);
        if (bq0.$EnumSwitchMapping$0[sp0Var.getType().ordinal()] == 1) {
            C().setInterceptScrollLister(new a(zp0Var));
            if (zp0Var != null && (b2 = zp0Var.b()) != null && (l = b2.l()) != null) {
                oi0.g(l);
                C().addView(l, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void q(pj0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.q(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, sp0.class.getSimpleName())) {
            N((sp0) event);
        } else if (Intrinsics.areEqual(a2, rp0.class.getSimpleName())) {
            M((rp0) event);
        } else if (Intrinsics.areEqual(a2, op0.class.getSimpleName())) {
            D((op0) event);
        } else if (Intrinsics.areEqual(a2, pp0.class.getSimpleName())) {
            E((pp0) event);
        }
    }

    public final void O(ViewGroup viewGroup) {
        View view2;
        ViewGroup.LayoutParams layoutParams;
        int i;
        lq0 b2;
        viewGroup.addView(C(), new FrameLayout.LayoutParams(-1, -1));
        zp0 zp0Var = (zp0) b().k(zp0.class);
        FrameLayout.LayoutParams layoutParams2 = null;
        if (zp0Var != null && (b2 = zp0Var.b()) != null) {
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
        yp0 yp0Var = (yp0) b().k(yp0.class);
        if (yp0Var != null) {
            i = yp0Var.getVideoHeight();
        } else {
            i = 0;
        }
        layoutParams3.topMargin = i;
        layoutParams3.height = viewGroup.getMeasuredHeight();
        C().setTopMargin(i);
        C().setTopLimit(i);
        kr0 kr0Var = this.e;
        if (kr0Var != null && kr0Var.q()) {
            C().setStyle(2);
        } else {
            C().setStyle(3);
        }
        if (view2 != null) {
            view2.setLayoutParams(layoutParams3);
        }
        zp0 zp0Var2 = (zp0) b().k(zp0.class);
        if (zp0Var2 != null) {
            zp0Var2.e(8);
        }
    }

    public final void P() {
        C().setClipChildren(false);
        C().setLayerType(2, null);
        C().setOnScrollChangeListener(this.j);
        C().setOnUpListener(this.k);
        C().setHandleTopYMove(true);
        C().setMinFlingVelocity(400);
        C().setUpYVelocityRatio(3.5f);
        C().setInterceptFlingListener(new b());
        C().setMinTopMargin(j51.c.a(getContext(), 49.0f));
    }

    public final void S(boolean z, boolean z2, boolean z3, int i) {
        boolean z4;
        if (!z2 && Q()) {
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

    public final void T(Intent intent) {
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
                this.e = kr0.q.a(f21.c(str2));
            }
            this.h = si0.a(hashMap);
        }
    }

    public final void w() {
        int i;
        yp0 yp0Var;
        int i2;
        Map<String, String> map;
        if (!this.g) {
            kr0 kr0Var = this.e;
            if (kr0Var != null) {
                i = kr0Var.a();
            } else {
                i = 0;
            }
            if (i <= 0 || (yp0Var = (yp0) b().k(yp0.class)) == null || !yp0Var.k()) {
                return;
            }
            int l = yp0Var.l();
            kr0 kr0Var2 = this.e;
            if (kr0Var2 != null) {
                i2 = kr0Var2.a();
            } else {
                i2 = 0;
            }
            if (l < i2) {
                return;
            }
            si0 si0Var = this.h;
            Map<String, String> map2 = null;
            if (si0Var != null) {
                map = si0Var.c;
            } else {
                map = null;
            }
            si0 si0Var2 = this.h;
            if (si0Var2 != null) {
                map2 = si0Var2.b;
            }
            String a2 = ti0.a("postplay", map, map2, "");
            Intrinsics.checkNotNullExpressionValue(a2, "AreaChargeUtil.area2Cmd(… adAreaInfo?.mCmdMap, \"\")");
            if (!TextUtils.isEmpty(a2)) {
                if (TextUtils.equals(a2, "AD_IMMERSIVE_VIDEO_SCROLL")) {
                    L(false, true, true);
                    return;
                }
                aj0.c(a2, getContext());
                this.g = true;
            }
        }
    }
}
