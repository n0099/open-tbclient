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
import com.baidu.nadcore.webview.container.base.AbsContainer;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.tieba.R;
import com.baidu.tieba.ap0;
import com.baidu.tieba.bi0;
import com.baidu.tieba.bp0;
import com.baidu.tieba.cj0;
import com.baidu.tieba.dp0;
import com.baidu.tieba.ep0;
import com.baidu.tieba.fi0;
import com.baidu.tieba.gi0;
import com.baidu.tieba.gp0;
import com.baidu.tieba.jq0;
import com.baidu.tieba.ni0;
import com.baidu.tieba.qo0;
import com.baidu.tieba.r31;
import com.baidu.tieba.ro0;
import com.baidu.tieba.so0;
import com.baidu.tieba.to0;
import com.baidu.tieba.u01;
import com.baidu.tieba.uo0;
import com.baidu.tieba.wo0;
import com.baidu.tieba.xo0;
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
    public jq0 e;
    public ValueAnimator f;
    public boolean g;
    public fi0 h;
    public final Lazy i;
    public final WebViewContainer.c j;
    public final WebViewContainer.d k;

    public final NestedScrollComponent$nestedScrollService$2.a w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (NestedScrollComponent$nestedScrollService$2.a) this.i.getValue() : (NestedScrollComponent$nestedScrollService$2.a) invokeV.objValue;
    }

    public final WebViewContainer x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (WebViewContainer) this.d.getValue() : (WebViewContainer) invokeV.objValue;
    }

    /* loaded from: classes2.dex */
    public static final class a implements WebViewContainer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ep0 a;

        public a(ep0 ep0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ep0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ep0Var;
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.WebViewContainer.b
        public final boolean a() {
            InterceptResult invokeV;
            int i;
            AbsContainer b;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ep0 ep0Var = this.a;
                if (ep0Var != null && (b = ep0Var.b()) != null) {
                    i = b.k();
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
                    int topMargin = this.a.x().getTopMargin();
                    dp0 dp0Var = (dp0) this.a.b().j(dp0.class);
                    if (dp0Var != null) {
                        i = dp0Var.getVideoHeight();
                    } else {
                        i = 0;
                    }
                    if (topMargin <= i) {
                        this.a.B(false);
                        return true;
                    }
                }
                if (!z && this.a.x().getTopMargin() >= this.a.x().getMinTopMargin()) {
                    this.a.B(true);
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
                dp0 dp0Var = (dp0) this.a.b().j(dp0.class);
                if (dp0Var != null && (h = dp0Var.h()) != null) {
                    f = h.getY();
                } else {
                    f = 0.0f - i2;
                }
                dp0 dp0Var2 = (dp0) this.a.b().j(dp0.class);
                if (dp0Var2 != null) {
                    i3 = dp0Var2.getVideoHeight();
                } else {
                    i3 = 0;
                }
                float f2 = i3;
                float min = Math.min(Math.max(f, 0.0f - f2), 0.0f);
                this.a.t((f2 - nestedScrollComponent.x().getTopMargin()) / (i3 - this.a.x().getMinTopMargin()));
                this.a.b().d(new qo0(NestedEvent.MOVE_VIEW, min, i3, this.a.x().getTopMargin(), this.a.x().getMinTopMargin()));
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
            dp0 dp0Var = (dp0) nestedScrollComponent.b().j(dp0.class);
            if (dp0Var != null) {
                i2 = dp0Var.getVideoHeight();
            } else {
                i2 = 0;
            }
            this.a = i2;
            if (z) {
                topMargin = i2 - nestedScrollComponent.x().getTopMargin();
            } else {
                topMargin = nestedScrollComponent.x().getTopMargin() - nestedScrollComponent.x().getMinTopMargin();
            }
            this.c = topMargin;
            this.d = z2 ? topMargin : i;
            this.e = nestedScrollComponent.x().getTopMargin();
            dp0 dp0Var2 = (dp0) nestedScrollComponent.b().j(dp0.class);
            if (dp0Var2 != null && (h = dp0Var2.h()) != null) {
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
                        this.g.x().scrollBy(0, -i);
                        this.g.x().setTopMargin(this.e);
                    } else {
                        int i2 = (int) (this.d * (floatValue - this.b));
                        this.f -= i2;
                        this.e -= i2;
                        this.g.x().scrollBy(0, i2);
                        this.g.x().setTopMargin(this.e);
                    }
                    this.g.b().d(new qo0(NestedEvent.MOVE_VIEW, this.f, this.a, this.g.x().getTopMargin(), this.g.x().getMinTopMargin()));
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
                    this.a.t(0.0f);
                    this.a.b().d(new ro0(NestedEvent.SCROLL_FINISH));
                    return;
                }
                this.a.A(this.c, this.d);
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
            this.a.G(this.b);
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
                int topMargin = this.a.x().getTopMargin();
                dp0 dp0Var = (dp0) this.a.b().j(dp0.class);
                boolean z2 = false;
                if (dp0Var != null) {
                    i = dp0Var.getVideoHeight();
                } else {
                    i = 0;
                }
                if (topMargin != this.a.x().getMinTopMargin() && topMargin != i) {
                    if (z) {
                        d = 0.8d;
                    } else {
                        d = 0.2d;
                    }
                    if ((this.a.x().getTopMargin() * 1.0d) / (i * 1.0d) >= d) {
                        z2 = true;
                    }
                    this.a.b().d(new so0(NestedEvent.SCROLL_UP, z));
                    this.a.B(z2);
                    return;
                }
                this.a.A(!z, false);
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
            public static final class a implements bp0 {
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

                @Override // com.baidu.tieba.bp0
                public void i(MotionEvent event) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048579, this, event) == null) {
                        Intrinsics.checkNotNullParameter(event, "event");
                        this.a.this$0.x().dispatchTouchEvent(event);
                    }
                }

                @Override // com.baidu.tieba.bp0
                public WebViewContainer b() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                        return (WebViewContainer) invokeV.objValue;
                    }
                    return this.a.this$0.x();
                }

                @Override // com.baidu.tieba.bp0
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

                @Override // com.baidu.tieba.bp0
                public void f(boolean z, boolean z2, boolean z3, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i)}) == null) {
                        this.a.this$0.K(z, z2, z3, i);
                    }
                }

                @Override // com.baidu.tieba.bp0
                public void j(boolean z, boolean z2, boolean z3) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) {
                        return;
                    }
                    this.a.this$0.D(z, z2, z3);
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

    public final void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            D(z, false, false);
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

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            super.onNewIntent(intent);
            L(intent);
            H();
        }
    }

    public final void y(to0 to0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, to0Var) == null) {
            if (gp0.$EnumSwitchMapping$2[to0Var.getType().ordinal()] == 1) {
                this.g = true;
            }
        }
    }

    public final void z(uo0 uo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, uo0Var) == null) {
            if (gp0.$EnumSwitchMapping$3[uo0Var.getType().ordinal()] == 1) {
                this.g = true;
            }
        }
    }

    public final void J(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            K(z, z2, z3, -1);
        }
    }

    public final void A(boolean z, boolean z2) {
        int i;
        String str;
        float topMargin;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                b().d(new ro0(NestedEvent.UP_SHOW_VIDEO));
            } else {
                b().d(new ro0(NestedEvent.UP_SHOW_WEB));
            }
            dp0 dp0Var = (dp0) b().j(dp0.class);
            if (dp0Var != null) {
                i = dp0Var.getVideoHeight();
            } else {
                i = 0;
            }
            if (z) {
                x().scrollBy(0, -(i - x().getTopMargin()));
                x().setTopMargin(i);
                t(0.0f);
            } else {
                this.g = true;
                x().scrollBy(0, x().getTopMargin() - x().getMinTopMargin());
                x().setTopMargin(x().getMinTopMargin());
                ap0 ap0Var = (ap0) b().j(ap0.class);
                if (ap0Var != null) {
                    String str2 = ClogBuilder.LogType.VIDEO_LP_VIDEO_HIDE.type;
                    Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.LogType.VIDEO_LP_VIDEO_HIDE.type");
                    if (z2) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    ap0Var.c(str2, "", str);
                }
                t(1.0f);
            }
            if (z) {
                topMargin = 0.0f;
            } else {
                topMargin = x().getTopMargin() - x().getMinTopMargin();
            }
            b().d(new qo0(NestedEvent.MOVE_VIEW, topMargin, i, x().getTopMargin(), x().getMinTopMargin()));
        }
    }

    public final void D(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            jq0 jq0Var = this.e;
            if (jq0Var != null && jq0Var.e()) {
                return;
            }
            J(z, z2, z3);
        }
    }

    public final void E(wo0 wo0Var) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wo0Var) == null) {
            int i = gp0.$EnumSwitchMapping$1[wo0Var.getType().ordinal()];
            boolean z = true;
            if (i != 1) {
                if (i == 2) {
                    fi0 fi0Var = this.h;
                    Map<String, String> map2 = null;
                    if (fi0Var != null) {
                        map = fi0Var.c;
                    } else {
                        map = null;
                    }
                    fi0 fi0Var2 = this.h;
                    if (fi0Var2 != null) {
                        map2 = fi0Var2.b;
                    }
                    String a2 = gi0.a("leftslide", map, map2, "");
                    if (a2 != null && a2.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        ni0.c(a2, getContext());
                        ap0 ap0Var = (ap0) b().j(ap0.class);
                        if (ap0Var != null) {
                            String str = ClogBuilder.LogType.FREE_CLICK.type;
                            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
                            ap0Var.a(str, "leftslide");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            n();
        }
    }

    public final void F(xo0 xo0Var) {
        AbsContainer b2;
        View i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xo0Var) == null) {
            ep0 ep0Var = (ep0) b().j(ep0.class);
            if (gp0.$EnumSwitchMapping$0[xo0Var.getType().ordinal()] == 1) {
                x().setInterceptScrollLister(new a(ep0Var));
                if (ep0Var != null && (b2 = ep0Var.b()) != null && (i = b2.i()) != null) {
                    bi0.e(i);
                    x().addView(i, new FrameLayout.LayoutParams(-1, -1));
                }
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void o(cj0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.o(event);
            String a2 = event.a();
            if (Intrinsics.areEqual(a2, xo0.class.getSimpleName())) {
                F((xo0) event);
            } else if (Intrinsics.areEqual(a2, wo0.class.getSimpleName())) {
                E((wo0) event);
            } else if (Intrinsics.areEqual(a2, to0.class.getSimpleName())) {
                y((to0) event);
            } else if (Intrinsics.areEqual(a2, uo0.class.getSimpleName())) {
                z((uo0) event);
            }
        }
    }

    public final void G(ViewGroup viewGroup) {
        View view2;
        ViewGroup.LayoutParams layoutParams;
        int i;
        AbsContainer b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viewGroup) == null) {
            viewGroup.addView(x(), new FrameLayout.LayoutParams(-1, -1));
            ep0 ep0Var = (ep0) b().j(ep0.class);
            FrameLayout.LayoutParams layoutParams2 = null;
            if (ep0Var != null && (b2 = ep0Var.b()) != null) {
                view2 = b2.i();
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
            dp0 dp0Var = (dp0) b().j(dp0.class);
            if (dp0Var != null) {
                i = dp0Var.getVideoHeight();
            } else {
                i = 0;
            }
            layoutParams3.topMargin = i;
            layoutParams3.height = viewGroup.getMeasuredHeight();
            x().setTopMargin(i);
            x().setTopLimit(i);
            jq0 jq0Var = this.e;
            if (jq0Var != null && jq0Var.e()) {
                x().setStyle(2);
            } else {
                x().setStyle(3);
            }
            if (view2 != null) {
                view2.setLayoutParams(layoutParams3);
            }
            ep0 ep0Var2 = (ep0) b().j(ep0.class);
            if (ep0Var2 != null) {
                ep0Var2.e(8);
            }
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            x().setClipChildren(false);
            x().setLayerType(2, null);
            x().setOnScrollChangeListener(this.j);
            x().setOnUpListener(this.k);
            x().setHandleTopYMove(true);
            x().setMinFlingVelocity(400);
            x().setUpYVelocityRatio(3.5f);
            x().setInterceptFlingListener(new b(this));
            x().setMinTopMargin(r31.c.a(getContext(), 49.0f));
        }
    }

    public final void n() {
        int i;
        dp0 dp0Var;
        int i2;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && !this.g) {
            jq0 jq0Var = this.e;
            if (jq0Var != null) {
                i = jq0Var.a();
            } else {
                i = 0;
            }
            if (i <= 0 || (dp0Var = (dp0) b().j(dp0.class)) == null || !dp0Var.k()) {
                return;
            }
            int l = dp0Var.l();
            jq0 jq0Var2 = this.e;
            if (jq0Var2 != null) {
                i2 = jq0Var2.a();
            } else {
                i2 = 0;
            }
            if (l < i2) {
                return;
            }
            fi0 fi0Var = this.h;
            Map<String, String> map2 = null;
            if (fi0Var != null) {
                map = fi0Var.c;
            } else {
                map = null;
            }
            fi0 fi0Var2 = this.h;
            if (fi0Var2 != null) {
                map2 = fi0Var2.b;
            }
            String a2 = gi0.a("postplay", map, map2, "");
            Intrinsics.checkNotNullExpressionValue(a2, "AreaChargeUtil.area2Cmd(… adAreaInfo?.mCmdMap, \"\")");
            if (!TextUtils.isEmpty(a2)) {
                if (TextUtils.equals(a2, "AD_IMMERSIVE_VIDEO_SCROLL")) {
                    D(false, true, true);
                    return;
                }
                ni0.c(a2, getContext());
                this.g = true;
            }
        }
    }

    public final boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
            q();
        }
    }

    public final void q() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (valueAnimator = this.f) != null) {
            valueAnimator.cancel();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.r();
            b().m(bp0.class, w());
        }
    }

    public final void K(boolean z, boolean z2, boolean z3, int i) {
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i)}) == null) {
            if (!z2 && I()) {
                return;
            }
            if (i == -1) {
                z4 = true;
            } else {
                z4 = false;
            }
            q();
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

    public final void L(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, intent) == null) {
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
                    this.e = jq0.f.a(u01.c(str2));
                }
                this.h = fi0.a(hashMap);
            }
        }
    }

    public final void t(float f2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            String c2 = bi0.c(0.6f * f2, "000000");
            Intrinsics.checkNotNullExpressionValue(c2, "AdUtil.getOpacityColor(currentOpacity, \"000000\")");
            if (f2 > 0.5d) {
                i = R.color.nad_max_webview_visivle_bg_color;
            } else {
                i = R.color.nad_max_webview_invisivle_bg_color;
            }
            x().setBackgroundColor(bi0.d(c2, i));
        }
    }
}
