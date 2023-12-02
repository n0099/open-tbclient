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
import com.baidu.tieba.am0;
import com.baidu.tieba.ce0;
import com.baidu.tieba.cm0;
import com.baidu.tieba.dm0;
import com.baidu.tieba.ff0;
import com.baidu.tieba.fm0;
import com.baidu.tieba.ie0;
import com.baidu.tieba.je0;
import com.baidu.tieba.oy0;
import com.baidu.tieba.pl0;
import com.baidu.tieba.pm0;
import com.baidu.tieba.qe0;
import com.baidu.tieba.ql0;
import com.baidu.tieba.rl0;
import com.baidu.tieba.sl0;
import com.baidu.tieba.sn0;
import com.baidu.tieba.tl0;
import com.baidu.tieba.vl0;
import com.baidu.tieba.w11;
import com.baidu.tieba.wl0;
import com.baidu.tieba.zl0;
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
    public sn0 e;
    public ValueAnimator f;
    public boolean g;
    public ie0 h;
    public final Lazy d = LazyKt__LazyJVMKt.lazy(new Function0<WebViewContainer>() { // from class: com.baidu.nadcore.max.uicomponent.NestedScrollComponent$webViewContainer$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WebViewContainer invoke() {
            Context b2;
            b2 = NestedScrollComponent.this.b();
            return new WebViewContainer(b2);
        }
    });
    public final Lazy i = LazyKt__LazyJVMKt.lazy(new Function0<NestedScrollComponent$nestedScrollService$2.a>() { // from class: com.baidu.nadcore.max.uicomponent.NestedScrollComponent$nestedScrollService$2
        {
            super(0);
        }

        /* loaded from: classes3.dex */
        public static final class a implements am0 {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.am0
            public void h(MotionEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                NestedScrollComponent.this.I().dispatchTouchEvent(event);
            }

            @Override // com.baidu.tieba.am0
            public WebViewContainer b() {
                return NestedScrollComponent.this.I();
            }

            @Override // com.baidu.tieba.am0
            public boolean g() {
                boolean z;
                z = NestedScrollComponent.this.g;
                return z;
            }

            @Override // com.baidu.tieba.am0
            public void f(boolean z, boolean z2, boolean z3, int i) {
                NestedScrollComponent.this.V(z, z2, z3, i);
            }

            @Override // com.baidu.tieba.am0
            public void i(boolean z, boolean z2, boolean z3) {
                NestedScrollComponent.this.O(z, z2, z3);
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

    public final NestedScrollComponent$nestedScrollService$2.a G() {
        return (NestedScrollComponent$nestedScrollService$2.a) this.i.getValue();
    }

    public final WebViewContainer I() {
        return (WebViewContainer) this.d.getValue();
    }

    /* loaded from: classes3.dex */
    public static final class a implements WebViewContainer.b {
        public final /* synthetic */ dm0 a;

        public a(dm0 dm0Var) {
            this.a = dm0Var;
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.WebViewContainer.b
        public final boolean a() {
            int i;
            pm0 b;
            Integer b2;
            dm0 dm0Var = this.a;
            if (dm0Var != null && (b = dm0Var.b()) != null && (b2 = b.b()) != null) {
                i = b2.intValue();
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
                int topMargin = NestedScrollComponent.this.I().getTopMargin();
                cm0 cm0Var = (cm0) NestedScrollComponent.this.f().q(cm0.class);
                if (cm0Var != null) {
                    i = cm0Var.getVideoHeight();
                } else {
                    i = 0;
                }
                if (topMargin <= i) {
                    NestedScrollComponent.this.N(false);
                    return true;
                }
            }
            if (!z && NestedScrollComponent.this.I().getTopMargin() >= NestedScrollComponent.this.I().getMinTopMargin()) {
                NestedScrollComponent.this.N(true);
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
            FrameLayout videoHolder;
            cm0 cm0Var = (cm0) NestedScrollComponent.this.f().q(cm0.class);
            if (cm0Var != null && (videoHolder = cm0Var.getVideoHolder()) != null) {
                f = videoHolder.getY();
            } else {
                f = 0.0f - i2;
            }
            cm0 cm0Var2 = (cm0) NestedScrollComponent.this.f().q(cm0.class);
            if (cm0Var2 != null) {
                i3 = cm0Var2.getVideoHeight();
            } else {
                i3 = 0;
            }
            float f2 = i3;
            float min = Math.min(Math.max(f, 0.0f - f2), 0.0f);
            NestedScrollComponent.this.F((f2 - nestedScrollComponent.I().getTopMargin()) / (i3 - NestedScrollComponent.this.I().getMinTopMargin()));
            NestedScrollComponent.this.f().i(new pl0(NestedEvent.MOVE_VIEW, min, i3, NestedScrollComponent.this.I().getTopMargin(), NestedScrollComponent.this.I().getMinTopMargin()));
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
            FrameLayout videoHolder;
            this.h = z;
            cm0 cm0Var = (cm0) NestedScrollComponent.this.f().q(cm0.class);
            if (cm0Var != null) {
                i2 = cm0Var.getVideoHeight();
            } else {
                i2 = 0;
            }
            this.a = i2;
            if (z) {
                topMargin = i2 - NestedScrollComponent.this.I().getTopMargin();
            } else {
                topMargin = NestedScrollComponent.this.I().getTopMargin() - NestedScrollComponent.this.I().getMinTopMargin();
            }
            this.c = topMargin;
            this.d = z2 ? topMargin : i;
            this.e = NestedScrollComponent.this.I().getTopMargin();
            cm0 cm0Var2 = (cm0) NestedScrollComponent.this.f().q(cm0.class);
            if (cm0Var2 != null && (videoHolder = cm0Var2.getVideoHolder()) != null) {
                f = videoHolder.getY();
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
                    NestedScrollComponent.this.I().scrollBy(0, -i);
                    NestedScrollComponent.this.I().setTopMargin(this.e);
                } else {
                    int i2 = (int) (this.d * (floatValue - this.b));
                    this.f -= i2;
                    this.e -= i2;
                    NestedScrollComponent.this.I().scrollBy(0, i2);
                    NestedScrollComponent.this.I().setTopMargin(this.e);
                }
                NestedScrollComponent.this.f().i(new pl0(NestedEvent.MOVE_VIEW, this.f, this.a, NestedScrollComponent.this.I().getTopMargin(), NestedScrollComponent.this.I().getMinTopMargin()));
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
                NestedScrollComponent.this.F(0.0f);
                NestedScrollComponent.this.f().i(new ql0(NestedEvent.SCROLL_FINISH));
                return;
            }
            NestedScrollComponent.this.M(this.c, this.d);
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
            NestedScrollComponent.this.R(this.b);
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
            int topMargin = NestedScrollComponent.this.I().getTopMargin();
            cm0 cm0Var = (cm0) NestedScrollComponent.this.f().q(cm0.class);
            boolean z2 = false;
            if (cm0Var != null) {
                i = cm0Var.getVideoHeight();
            } else {
                i = 0;
            }
            if (topMargin != NestedScrollComponent.this.I().getMinTopMargin() && topMargin != i) {
                if (z) {
                    d = 0.8d;
                } else {
                    d = 0.2d;
                }
                if ((NestedScrollComponent.this.I().getTopMargin() * 1.0d) / (i * 1.0d) >= d) {
                    z2 = true;
                }
                NestedScrollComponent.this.f().i(new rl0(NestedEvent.SCROLL_UP, z));
                NestedScrollComponent.this.N(z2);
                return;
            }
            NestedScrollComponent.this.M(!z, false);
        }
    }

    public final void E() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final boolean T() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        E();
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void z() {
        super.z();
        f().v(am0.class, G());
    }

    public final void F(float f2) {
        int i;
        String e2 = ce0.e(0.6f * f2, "000000");
        Intrinsics.checkNotNullExpressionValue(e2, "AdUtil.getOpacityColor(currentOpacity, \"000000\")");
        if (f2 > 0.5d) {
            i = R.color.nad_max_webview_visivle_bg_color;
        } else {
            i = R.color.nad_max_webview_invisivle_bg_color;
        }
        I().setBackgroundColor(ce0.f(e2, i));
    }

    public final void J(sl0 sl0Var) {
        if (fm0.$EnumSwitchMapping$2[sl0Var.b().ordinal()] == 1) {
            this.g = true;
        }
    }

    public final void K(tl0 tl0Var) {
        if (fm0.$EnumSwitchMapping$3[tl0Var.b().ordinal()] == 1) {
            this.g = true;
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void L(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.post(new f(parent));
    }

    public final void N(boolean z) {
        O(z, false, false);
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        W(intent);
        S();
    }

    public final void O(boolean z, boolean z2, boolean z3) {
        sn0 sn0Var = this.e;
        if (sn0Var != null && sn0Var.v()) {
            return;
        }
        U(z, z2, z3);
    }

    public final void U(boolean z, boolean z2, boolean z3) {
        V(z, z2, z3, -1);
    }

    public final void D() {
        int i;
        cm0 cm0Var;
        int i2;
        Map<String, String> map;
        if (!this.g) {
            sn0 sn0Var = this.e;
            if (sn0Var != null) {
                i = sn0Var.a();
            } else {
                i = 0;
            }
            if (i <= 0 || (cm0Var = (cm0) f().q(cm0.class)) == null || !cm0Var.j()) {
                return;
            }
            int k = cm0Var.k();
            sn0 sn0Var2 = this.e;
            if (sn0Var2 != null) {
                i2 = sn0Var2.a();
            } else {
                i2 = 0;
            }
            if (k < i2) {
                return;
            }
            ie0 ie0Var = this.h;
            Map<String, String> map2 = null;
            if (ie0Var != null) {
                map = ie0Var.c;
            } else {
                map = null;
            }
            ie0 ie0Var2 = this.h;
            if (ie0Var2 != null) {
                map2 = ie0Var2.b;
            }
            String a2 = je0.a("postplay", map, map2, "");
            Intrinsics.checkNotNullExpressionValue(a2, "AreaChargeUtil.area2Cmd(… adAreaInfo?.mCmdMap, \"\")");
            if (!TextUtils.isEmpty(a2)) {
                if (TextUtils.equals(a2, "AD_IMMERSIVE_VIDEO_SCROLL")) {
                    O(false, true, true);
                    return;
                }
                qe0.c(a2, b());
                this.g = true;
            }
        }
    }

    public final void M(boolean z, boolean z2) {
        int i;
        String str;
        float topMargin;
        if (z) {
            f().i(new ql0(NestedEvent.UP_SHOW_VIDEO));
        } else {
            f().i(new ql0(NestedEvent.UP_SHOW_WEB));
        }
        cm0 cm0Var = (cm0) f().q(cm0.class);
        if (cm0Var != null) {
            i = cm0Var.getVideoHeight();
        } else {
            i = 0;
        }
        if (z) {
            I().scrollBy(0, -(i - I().getTopMargin()));
            I().setTopMargin(i);
            F(0.0f);
        } else {
            this.g = true;
            I().scrollBy(0, I().getTopMargin() - I().getMinTopMargin());
            I().setTopMargin(I().getMinTopMargin());
            zl0 zl0Var = (zl0) f().q(zl0.class);
            if (zl0Var != null) {
                String str2 = ClogBuilder.LogType.VIDEO_LP_VIDEO_HIDE.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.LogType.VIDEO_LP_VIDEO_HIDE.type");
                if (z2) {
                    str = "0";
                } else {
                    str = "1";
                }
                zl0Var.c(str2, "", str);
            }
            F(1.0f);
        }
        if (z) {
            topMargin = 0.0f;
        } else {
            topMargin = I().getTopMargin() - I().getMinTopMargin();
        }
        f().i(new pl0(NestedEvent.MOVE_VIEW, topMargin, i, I().getTopMargin(), I().getMinTopMargin()));
    }

    public final void P(vl0 vl0Var) {
        Map<String, String> map;
        int i = fm0.$EnumSwitchMapping$1[vl0Var.b().ordinal()];
        boolean z = true;
        if (i != 1) {
            if (i == 2) {
                ie0 ie0Var = this.h;
                Map<String, String> map2 = null;
                if (ie0Var != null) {
                    map = ie0Var.c;
                } else {
                    map = null;
                }
                ie0 ie0Var2 = this.h;
                if (ie0Var2 != null) {
                    map2 = ie0Var2.b;
                }
                String a2 = je0.a("leftslide", map, map2, "");
                if (a2 != null && a2.length() != 0) {
                    z = false;
                }
                if (!z) {
                    qe0.c(a2, b());
                    zl0 zl0Var = (zl0) f().q(zl0.class);
                    if (zl0Var != null) {
                        String str = ClogBuilder.LogType.FREE_CLICK.type;
                        Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
                        zl0Var.a(str, "leftslide");
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        D();
    }

    public final void Q(wl0 wl0Var) {
        pm0 b2;
        View j;
        dm0 dm0Var = (dm0) f().q(dm0.class);
        if (fm0.$EnumSwitchMapping$0[wl0Var.b().ordinal()] == 1) {
            I().setInterceptScrollLister(new a(dm0Var));
            if (dm0Var != null && (b2 = dm0Var.b()) != null && (j = b2.j()) != null) {
                ce0.g(j);
                I().addView(j, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void s(ff0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.s(event);
        String a2 = event.a();
        if (Intrinsics.areEqual(a2, wl0.class.getSimpleName())) {
            Q((wl0) event);
        } else if (Intrinsics.areEqual(a2, vl0.class.getSimpleName())) {
            P((vl0) event);
        } else if (Intrinsics.areEqual(a2, sl0.class.getSimpleName())) {
            J((sl0) event);
        } else if (Intrinsics.areEqual(a2, tl0.class.getSimpleName())) {
            K((tl0) event);
        }
    }

    public final void R(ViewGroup viewGroup) {
        View view2;
        ViewGroup.LayoutParams layoutParams;
        int i;
        pm0 b2;
        viewGroup.addView(I(), new FrameLayout.LayoutParams(-1, -1));
        dm0 dm0Var = (dm0) f().q(dm0.class);
        FrameLayout.LayoutParams layoutParams2 = null;
        if (dm0Var != null && (b2 = dm0Var.b()) != null) {
            view2 = b2.j();
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
        cm0 cm0Var = (cm0) f().q(cm0.class);
        if (cm0Var != null) {
            i = cm0Var.getVideoHeight();
        } else {
            i = 0;
        }
        layoutParams3.topMargin = i;
        layoutParams3.height = viewGroup.getMeasuredHeight();
        I().setTopMargin(i);
        I().setTopLimit(i);
        sn0 sn0Var = this.e;
        if (sn0Var != null && sn0Var.v()) {
            I().setStyle(2);
        } else {
            I().setStyle(3);
        }
        if (view2 != null) {
            view2.setLayoutParams(layoutParams3);
        }
        dm0 dm0Var2 = (dm0) f().q(dm0.class);
        if (dm0Var2 != null) {
            dm0Var2.e(8);
        }
    }

    public final void S() {
        I().setClipChildren(false);
        I().setLayerType(2, null);
        I().setOnScrollChangeListener(this.j);
        I().setOnUpListener(this.k);
        I().setHandleTopYMove(true);
        I().setMinFlingVelocity(400);
        I().setUpYVelocityRatio(3.5f);
        I().setInterceptFlingListener(new b());
        I().setMinTopMargin(w11.c.a(b(), 49.0f));
    }

    public final void V(boolean z, boolean z2, boolean z3, int i) {
        boolean z4;
        if (!z2 && T()) {
            return;
        }
        if (i == -1) {
            z4 = true;
        } else {
            z4 = false;
        }
        E();
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

    public final void W(Intent intent) {
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
                this.e = sn0.v.a(oy0.c(str2));
            }
            this.h = ie0.a(hashMap);
        }
    }
}
