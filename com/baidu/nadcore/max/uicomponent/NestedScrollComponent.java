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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.component.AbsComponentPlugin;
import com.baidu.nadcore.max.event.NestedEvent;
import com.baidu.nadcore.max.uicomponent.NestedScrollComponent$nestedScrollService$2;
import com.baidu.nadcore.max.uiwidget.basic.WebViewContainer;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.tieba.R;
import com.baidu.tieba.b51;
import com.baidu.tieba.fr0;
import com.baidu.tieba.hp0;
import com.baidu.tieba.hq0;
import com.baidu.tieba.ip0;
import com.baidu.tieba.jp0;
import com.baidu.tieba.ki0;
import com.baidu.tieba.kp0;
import com.baidu.tieba.lj0;
import com.baidu.tieba.lp0;
import com.baidu.tieba.np0;
import com.baidu.tieba.oi0;
import com.baidu.tieba.op0;
import com.baidu.tieba.pi0;
import com.baidu.tieba.rp0;
import com.baidu.tieba.sp0;
import com.baidu.tieba.up0;
import com.baidu.tieba.vp0;
import com.baidu.tieba.wi0;
import com.baidu.tieba.xp0;
import com.baidu.tieba.y11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001?\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bS\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0002H\u0002¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0011H\u0002¢\u0006\u0004\b&\u0010'J'\u0010(\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011H\u0002¢\u0006\u0004\b(\u0010\u0019J-\u0010+\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b-\u0010#J\u0017\u00100\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0002H\u0016¢\u0006\u0004\b2\u0010\u0004J\u0017\u00103\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b3\u00101J\u0017\u00105\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001d\u0010D\u001a\u00020?8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010I\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u001d\u0010R\u001a\u00020N8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010A\u001a\u0004\bP\u0010Q¨\u0006T"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/NestedScrollComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "autoScroll", "()V", "cancelScrollAnimator", "", "fraction", "changeMaskColor", "(F)V", "Lcom/baidu/nadcore/max/event/PanelViewEvent;", "event", "handlePanelEvent", "(Lcom/baidu/nadcore/max/event/PanelViewEvent;)V", "Lcom/baidu/nadcore/max/event/PopOverViewEvent;", "handlePopEvent", "(Lcom/baidu/nadcore/max/event/PopOverViewEvent;)V", "", "scrollDown", "handleScrollAnimateEnd", "(ZZ)V", "isShowUpHalf", "handleUpAction", "(Z)V", "forceAnim", "(ZZZ)V", "Lcom/baidu/nadcore/max/event/VideoViewEvent;", "handleVideoEvent", "(Lcom/baidu/nadcore/max/event/VideoViewEvent;)V", "Lcom/baidu/nadcore/max/event/WebViewEvent;", "handleWebEvent", "(Lcom/baidu/nadcore/max/event/WebViewEvent;)V", "Landroid/view/ViewGroup;", "parent", "initVideoLPStatus", "(Landroid/view/ViewGroup;)V", "initWebViewContainer", "injectService", "isScrollAnimatorRunning", "()Z", "moveViewWithAnim", "", "moveDistance", "moveViewWithDistance", "(ZZZI)V", "onCreateView", "Landroid/content/Intent;", IntentData.KEY, "onNewIntent", "(Landroid/content/Intent;)V", "onRelease", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/charge/AdAreaInfo;", "adAreaInfo", "Lcom/baidu/nadcore/charge/AdAreaInfo;", "hasUpScroll", "Z", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer$OnScrollChangedCallback;", "mScrollCallback", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer$OnScrollChangedCallback;", "com/baidu/nadcore/max/uicomponent/NestedScrollComponent$nestedScrollService$2$1", "nestedScrollService$delegate", "Lkotlin/Lazy;", "getNestedScrollService", "()Lcom/baidu/nadcore/max/uicomponent/NestedScrollComponent$nestedScrollService$2$1;", "nestedScrollService", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer$OnUpListener;", "onUpListener", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer$OnUpListener;", "Landroid/animation/ValueAnimator;", "scrollAnimator", "Landroid/animation/ValueAnimator;", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer;", "webViewContainer$delegate", "getWebViewContainer", "()Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer;", "webViewContainer", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NestedScrollComponent extends AbsComponentPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy d;
    public fr0 e;
    public ValueAnimator f;
    public boolean g;
    public oi0 h;
    public final Lazy i;
    public final WebViewContainer.c j;
    public final WebViewContainer.d k;

    public final NestedScrollComponent$nestedScrollService$2.a x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (NestedScrollComponent$nestedScrollService$2.a) this.i.getValue() : (NestedScrollComponent$nestedScrollService$2.a) invokeV.objValue;
    }

    public final WebViewContainer y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (WebViewContainer) this.d.getValue() : (WebViewContainer) invokeV.objValue;
    }

    /* loaded from: classes2.dex */
    public static final class a implements WebViewContainer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vp0 a;

        public a(vp0 vp0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vp0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vp0Var;
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.WebViewContainer.b
        public final boolean a() {
            InterceptResult invokeV;
            int i;
            hq0 b;
            Integer c;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                vp0 vp0Var = this.a;
                if (vp0Var != null && (b = vp0Var.b()) != null && (c = b.c()) != null) {
                    i = c.intValue();
                } else {
                    i = -1;
                }
                if (i <= 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements WebViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NestedScrollComponent a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b(NestedScrollComponent nestedScrollComponent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollComponent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nestedScrollComponent;
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.WebViewContainer.a
        public boolean a(boolean z) {
            InterceptResult invokeZ;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                if (z) {
                    int topMargin = this.a.y().getTopMargin();
                    up0 up0Var = (up0) this.a.b().j(up0.class);
                    if (up0Var != null) {
                        i = up0Var.getVideoHeight();
                    } else {
                        i = 0;
                    }
                    if (topMargin <= i) {
                        this.a.D(false);
                        return true;
                    }
                }
                if (!z && this.a.y().getTopMargin() >= this.a.y().getMinTopMargin()) {
                    this.a.D(true);
                    return true;
                }
                return false;
            }
            return invokeZ.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements WebViewContainer.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NestedScrollComponent a;

        public c(NestedScrollComponent nestedScrollComponent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollComponent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nestedScrollComponent;
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.WebViewContainer.c
        public final void onScroll(int i, int i2) {
            float f;
            int i3;
            NestedScrollComponent nestedScrollComponent;
            FrameLayout h;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                up0 up0Var = (up0) this.a.b().j(up0.class);
                if (up0Var != null && (h = up0Var.h()) != null) {
                    f = h.getY();
                } else {
                    f = 0.0f - i2;
                }
                up0 up0Var2 = (up0) this.a.b().j(up0.class);
                if (up0Var2 != null) {
                    i3 = up0Var2.getVideoHeight();
                } else {
                    i3 = 0;
                }
                float f2 = i3;
                float min = Math.min(Math.max(f, 0.0f - f2), 0.0f);
                this.a.w((f2 - nestedScrollComponent.y().getTopMargin()) / (i3 - this.a.y().getMinTopMargin()));
                this.a.b().d(new hp0(NestedEvent.MOVE_VIEW, min, i3, this.a.y().getTopMargin(), this.a.y().getMinTopMargin()));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public float b;
        public int c;
        public int d;
        public int e;
        public float f;
        public final /* synthetic */ NestedScrollComponent g;
        public final /* synthetic */ boolean h;

        public d(NestedScrollComponent nestedScrollComponent, boolean z, boolean z2, int i) {
            int i2;
            int topMargin;
            float f;
            FrameLayout h;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollComponent, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = nestedScrollComponent;
            this.h = z;
            up0 up0Var = (up0) nestedScrollComponent.b().j(up0.class);
            if (up0Var != null) {
                i2 = up0Var.getVideoHeight();
            } else {
                i2 = 0;
            }
            this.a = i2;
            if (z) {
                topMargin = i2 - nestedScrollComponent.y().getTopMargin();
            } else {
                topMargin = nestedScrollComponent.y().getTopMargin() - nestedScrollComponent.y().getMinTopMargin();
            }
            this.c = topMargin;
            this.d = z2 ? topMargin : i;
            this.e = nestedScrollComponent.y().getTopMargin();
            up0 up0Var2 = (up0) nestedScrollComponent.b().j(up0.class);
            if (up0Var2 != null && (h = up0Var2.h()) != null) {
                f = h.getY();
            } else {
                f = 0.0f;
            }
            this.f = f;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue != null) {
                    float floatValue = ((Float) animatedValue).floatValue();
                    if (this.h) {
                        int i = (int) (this.d * (floatValue - this.b));
                        this.f += i;
                        this.e += i;
                        this.g.y().scrollBy(0, -i);
                        this.g.y().setTopMargin(this.e);
                    } else {
                        int i2 = (int) (this.d * (floatValue - this.b));
                        this.f -= i2;
                        this.e -= i2;
                        this.g.y().scrollBy(0, i2);
                        this.g.y().setTopMargin(this.e);
                    }
                    this.g.b().d(new hp0(NestedEvent.MOVE_VIEW, this.f, this.a, this.g.y().getTopMargin(), this.g.y().getMinTopMargin()));
                    this.b = floatValue;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NestedScrollComponent a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        public e(NestedScrollComponent nestedScrollComponent, boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollComponent, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nestedScrollComponent;
            this.b = z;
            this.c = z2;
            this.d = z3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (!this.b) {
                    this.a.w(0.0f);
                    this.a.b().d(new ip0(NestedEvent.SCROLL_FINISH));
                    return;
                }
                this.a.B(this.c, this.d);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NestedScrollComponent a;
        public final /* synthetic */ ViewGroup b;

        public f(NestedScrollComponent nestedScrollComponent, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollComponent, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nestedScrollComponent;
            this.b = viewGroup;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.H(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class g implements WebViewContainer.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NestedScrollComponent a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public g(NestedScrollComponent nestedScrollComponent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollComponent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nestedScrollComponent;
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.WebViewContainer.d
        public void a(boolean z) {
            int i;
            double d;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                int topMargin = this.a.y().getTopMargin();
                up0 up0Var = (up0) this.a.b().j(up0.class);
                boolean z2 = false;
                if (up0Var != null) {
                    i = up0Var.getVideoHeight();
                } else {
                    i = 0;
                }
                if (topMargin != this.a.y().getMinTopMargin() && topMargin != i) {
                    if (z) {
                        d = 0.8d;
                    } else {
                        d = 0.2d;
                    }
                    if ((this.a.y().getTopMargin() * 1.0d) / (i * 1.0d) >= d) {
                        z2 = true;
                    }
                    this.a.b().d(new jp0(NestedEvent.SCROLL_UP, z));
                    this.a.D(z2);
                    return;
                }
                this.a.B(!z, false);
            }
        }
    }

    public NestedScrollComponent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<WebViewContainer>(this) { // from class: com.baidu.nadcore.max.uicomponent.NestedScrollComponent$webViewContainer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NestedScrollComponent this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WebViewContainer invoke() {
                InterceptResult invokeV;
                Context context;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (WebViewContainer) invokeV.objValue;
                }
                context = this.this$0.getContext();
                return new WebViewContainer(context);
            }
        });
        this.i = LazyKt__LazyJVMKt.lazy(new Function0<NestedScrollComponent$nestedScrollService$2.a>(this) { // from class: com.baidu.nadcore.max.uicomponent.NestedScrollComponent$nestedScrollService$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NestedScrollComponent this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* loaded from: classes2.dex */
            public static final class a implements sp0 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NestedScrollComponent$nestedScrollService$2 a;

                /* JADX DEBUG: Incorrect args count in method signature: ()V */
                public a(NestedScrollComponent$nestedScrollService$2 nestedScrollComponent$nestedScrollService$2) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nestedScrollComponent$nestedScrollService$2};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = nestedScrollComponent$nestedScrollService$2;
                }

                @Override // com.baidu.tieba.sp0
                public void i(MotionEvent event) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048579, this, event) == null) {
                        Intrinsics.checkNotNullParameter(event, "event");
                        this.a.this$0.y().dispatchTouchEvent(event);
                    }
                }

                @Override // com.baidu.tieba.sp0
                public WebViewContainer b() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                        return (WebViewContainer) invokeV.objValue;
                    }
                    return this.a.this$0.y();
                }

                @Override // com.baidu.tieba.sp0
                public boolean g() {
                    InterceptResult invokeV;
                    boolean z;
                    Interceptable interceptable = $ic;
                    if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
                        return invokeV.booleanValue;
                    }
                    z = this.a.this$0.g;
                    return z;
                }

                @Override // com.baidu.tieba.sp0
                public void f(boolean z, boolean z2, boolean z3, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i)}) == null) {
                        this.a.this$0.L(z, z2, z3, i);
                    }
                }

                @Override // com.baidu.tieba.sp0
                public void j(boolean z, boolean z2, boolean z3) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) {
                        return;
                    }
                    this.a.this$0.E(z, z2, z3);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new a(this);
                }
                return (a) invokeV.objValue;
            }
        });
        this.j = new c(this);
        this.k = new g(this);
    }

    public final void A(lp0 lp0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lp0Var) == null) {
            if (xp0.$EnumSwitchMapping$3[lp0Var.getType().ordinal()] == 1) {
                this.g = true;
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void C(ViewGroup parent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            parent.post(new f(this, parent));
        }
    }

    public final void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            E(z, false, false);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            super.onNewIntent(intent);
            M(intent);
            I();
        }
    }

    public final void z(kp0 kp0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, kp0Var) == null) {
            if (xp0.$EnumSwitchMapping$2[kp0Var.getType().ordinal()] == 1) {
                this.g = true;
            }
        }
    }

    public final void K(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            L(z, z2, z3, -1);
        }
    }

    public final void B(boolean z, boolean z2) {
        int i;
        String str;
        float topMargin;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                b().d(new ip0(NestedEvent.UP_SHOW_VIDEO));
            } else {
                b().d(new ip0(NestedEvent.UP_SHOW_WEB));
            }
            up0 up0Var = (up0) b().j(up0.class);
            if (up0Var != null) {
                i = up0Var.getVideoHeight();
            } else {
                i = 0;
            }
            if (z) {
                y().scrollBy(0, -(i - y().getTopMargin()));
                y().setTopMargin(i);
                w(0.0f);
            } else {
                this.g = true;
                y().scrollBy(0, y().getTopMargin() - y().getMinTopMargin());
                y().setTopMargin(y().getMinTopMargin());
                rp0 rp0Var = (rp0) b().j(rp0.class);
                if (rp0Var != null) {
                    String str2 = ClogBuilder.LogType.VIDEO_LP_VIDEO_HIDE.type;
                    Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.LogType.VIDEO_LP_VIDEO_HIDE.type");
                    if (z2) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    rp0Var.c(str2, "", str);
                }
                w(1.0f);
            }
            if (z) {
                topMargin = 0.0f;
            } else {
                topMargin = y().getTopMargin() - y().getMinTopMargin();
            }
            b().d(new hp0(NestedEvent.MOVE_VIEW, topMargin, i, y().getTopMargin(), y().getMinTopMargin()));
        }
    }

    public final void E(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            fr0 fr0Var = this.e;
            if (fr0Var != null && fr0Var.n()) {
                return;
            }
            K(z, z2, z3);
        }
    }

    public final void F(np0 np0Var) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, np0Var) == null) {
            int i = xp0.$EnumSwitchMapping$1[np0Var.getType().ordinal()];
            boolean z = true;
            if (i != 1) {
                if (i == 2) {
                    oi0 oi0Var = this.h;
                    Map<String, String> map2 = null;
                    if (oi0Var != null) {
                        map = oi0Var.c;
                    } else {
                        map = null;
                    }
                    oi0 oi0Var2 = this.h;
                    if (oi0Var2 != null) {
                        map2 = oi0Var2.b;
                    }
                    String a2 = pi0.a("leftslide", map, map2, "");
                    if (a2 != null && a2.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        wi0.c(a2, getContext());
                        rp0 rp0Var = (rp0) b().j(rp0.class);
                        if (rp0Var != null) {
                            String str = ClogBuilder.LogType.FREE_CLICK.type;
                            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
                            rp0Var.a(str, "leftslide");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            t();
        }
    }

    public final void G(op0 op0Var) {
        hq0 b2;
        View l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, op0Var) == null) {
            vp0 vp0Var = (vp0) b().j(vp0.class);
            if (xp0.$EnumSwitchMapping$0[op0Var.getType().ordinal()] == 1) {
                y().setInterceptScrollLister(new a(vp0Var));
                if (vp0Var != null && (b2 = vp0Var.b()) != null && (l = b2.l()) != null) {
                    ki0.g(l);
                    y().addView(l, new FrameLayout.LayoutParams(-1, -1));
                }
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void o(lj0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.o(event);
            String a2 = event.a();
            if (Intrinsics.areEqual(a2, op0.class.getSimpleName())) {
                G((op0) event);
            } else if (Intrinsics.areEqual(a2, np0.class.getSimpleName())) {
                F((np0) event);
            } else if (Intrinsics.areEqual(a2, kp0.class.getSimpleName())) {
                z((kp0) event);
            } else if (Intrinsics.areEqual(a2, lp0.class.getSimpleName())) {
                A((lp0) event);
            }
        }
    }

    public final void H(ViewGroup viewGroup) {
        View view2;
        ViewGroup.LayoutParams layoutParams;
        int i;
        hq0 b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, viewGroup) == null) {
            viewGroup.addView(y(), new FrameLayout.LayoutParams(-1, -1));
            vp0 vp0Var = (vp0) b().j(vp0.class);
            FrameLayout.LayoutParams layoutParams2 = null;
            if (vp0Var != null && (b2 = vp0Var.b()) != null) {
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
            up0 up0Var = (up0) b().j(up0.class);
            if (up0Var != null) {
                i = up0Var.getVideoHeight();
            } else {
                i = 0;
            }
            layoutParams3.topMargin = i;
            layoutParams3.height = viewGroup.getMeasuredHeight();
            y().setTopMargin(i);
            y().setTopLimit(i);
            fr0 fr0Var = this.e;
            if (fr0Var != null && fr0Var.n()) {
                y().setStyle(2);
            } else {
                y().setStyle(3);
            }
            if (view2 != null) {
                view2.setLayoutParams(layoutParams3);
            }
            vp0 vp0Var2 = (vp0) b().j(vp0.class);
            if (vp0Var2 != null) {
                vp0Var2.e(8);
            }
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            y().setClipChildren(false);
            y().setLayerType(2, null);
            y().setOnScrollChangeListener(this.j);
            y().setOnUpListener(this.k);
            y().setHandleTopYMove(true);
            y().setMinFlingVelocity(400);
            y().setUpYVelocityRatio(3.5f);
            y().setInterceptFlingListener(new b(this));
            y().setMinTopMargin(b51.c.a(getContext(), 49.0f));
        }
    }

    public final void t() {
        int i;
        up0 up0Var;
        int i2;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && !this.g) {
            fr0 fr0Var = this.e;
            if (fr0Var != null) {
                i = fr0Var.a();
            } else {
                i = 0;
            }
            if (i <= 0 || (up0Var = (up0) b().j(up0.class)) == null || !up0Var.k()) {
                return;
            }
            int l = up0Var.l();
            fr0 fr0Var2 = this.e;
            if (fr0Var2 != null) {
                i2 = fr0Var2.a();
            } else {
                i2 = 0;
            }
            if (l < i2) {
                return;
            }
            oi0 oi0Var = this.h;
            Map<String, String> map2 = null;
            if (oi0Var != null) {
                map = oi0Var.c;
            } else {
                map = null;
            }
            oi0 oi0Var2 = this.h;
            if (oi0Var2 != null) {
                map2 = oi0Var2.b;
            }
            String a2 = pi0.a("postplay", map, map2, "");
            Intrinsics.checkNotNullExpressionValue(a2, "AreaChargeUtil.area2Cmd(… adAreaInfo?.mCmdMap, \"\")");
            if (!TextUtils.isEmpty(a2)) {
                if (TextUtils.equals(a2, "AD_IMMERSIVE_VIDEO_SCROLL")) {
                    E(false, true, true);
                    return;
                }
                wi0.c(a2, getContext());
                this.g = true;
            }
        }
    }

    public final boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ValueAnimator valueAnimator = this.f;
            if (valueAnimator != null) {
                return valueAnimator.isRunning();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onRelease();
            v();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.r();
            b().m(sp0.class, x());
        }
    }

    public final void v() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (valueAnimator = this.f) != null) {
            valueAnimator.cancel();
        }
    }

    public final void L(boolean z, boolean z2, boolean z3, int i) {
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i)}) == null) {
            if (!z2 && J()) {
                return;
            }
            if (i == -1) {
                z4 = true;
            } else {
                z4 = false;
            }
            v();
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
                valueAnimator2.addUpdateListener(new d(this, z, z4, i));
            }
            ValueAnimator valueAnimator3 = this.f;
            if (valueAnimator3 != null) {
                valueAnimator3.addListener(new e(this, z4, z, z3));
            }
            ValueAnimator valueAnimator4 = this.f;
            if (valueAnimator4 != null) {
                valueAnimator4.start();
            }
        }
    }

    public final void M(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, intent) == null) {
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
                    this.e = fr0.n.a(y11.c(str2));
                }
                this.h = oi0.a(hashMap);
            }
        }
    }

    public final void w(float f2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f2) == null) {
            String e2 = ki0.e(0.6f * f2, "000000");
            Intrinsics.checkNotNullExpressionValue(e2, "AdUtil.getOpacityColor(currentOpacity, \"000000\")");
            if (f2 > 0.5d) {
                i = R.color.nad_max_webview_visivle_bg_color;
            } else {
                i = R.color.nad_max_webview_invisivle_bg_color;
            }
            y().setBackgroundColor(ki0.f(e2, i));
        }
    }
}
