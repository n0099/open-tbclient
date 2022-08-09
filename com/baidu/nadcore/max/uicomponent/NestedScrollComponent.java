package com.baidu.nadcore.max.uicomponent;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.text.TextUtils;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ag0;
import com.repackage.bh0;
import com.repackage.bm0;
import com.repackage.cm0;
import com.repackage.eg0;
import com.repackage.fg0;
import com.repackage.fm0;
import com.repackage.gm0;
import com.repackage.im0;
import com.repackage.jm0;
import com.repackage.lm0;
import com.repackage.mg0;
import com.repackage.on0;
import com.repackage.p01;
import com.repackage.vl0;
import com.repackage.wl0;
import com.repackage.xl0;
import com.repackage.xx0;
import com.repackage.yl0;
import com.repackage.zl0;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001?\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bS\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0002H\u0002¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0011H\u0002¢\u0006\u0004\b&\u0010'J'\u0010(\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011H\u0002¢\u0006\u0004\b(\u0010\u0019J-\u0010+\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b-\u0010#J\u0017\u00100\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0002H\u0016¢\u0006\u0004\b2\u0010\u0004J\u0017\u00103\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b3\u00101J\u0017\u00105\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001d\u0010D\u001a\u00020?8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010I\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u001d\u0010R\u001a\u00020N8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010A\u001a\u0004\bP\u0010Q¨\u0006T"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/NestedScrollComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "autoScroll", "()V", "cancelScrollAnimator", "", "fraction", "changeMaskColor", "(F)V", "Lcom/baidu/nadcore/max/event/PanelViewEvent;", "event", "handlePanelEvent", "(Lcom/baidu/nadcore/max/event/PanelViewEvent;)V", "Lcom/baidu/nadcore/max/event/PopOverViewEvent;", "handlePopEvent", "(Lcom/baidu/nadcore/max/event/PopOverViewEvent;)V", "", "scrollDown", "handleScrollAnimateEnd", "(ZZ)V", "isShowUpHalf", "handleUpAction", "(Z)V", "forceAnim", "(ZZZ)V", "Lcom/baidu/nadcore/max/event/VideoViewEvent;", "handleVideoEvent", "(Lcom/baidu/nadcore/max/event/VideoViewEvent;)V", "Lcom/baidu/nadcore/max/event/WebViewEvent;", "handleWebEvent", "(Lcom/baidu/nadcore/max/event/WebViewEvent;)V", "Landroid/view/ViewGroup;", "parent", "initVideoLPStatus", "(Landroid/view/ViewGroup;)V", "initWebViewContainer", "injectService", "isScrollAnimatorRunning", "()Z", "moveViewWithAnim", "", "moveDistance", "moveViewWithDistance", "(ZZZI)V", "onCreateView", "Landroid/content/Intent;", IntentData.KEY, "onNewIntent", "(Landroid/content/Intent;)V", "onRelease", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Lcom/baidu/nadcore/charge/AdAreaInfo;", "adAreaInfo", "Lcom/baidu/nadcore/charge/AdAreaInfo;", "hasUpScroll", "Z", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer$OnScrollChangedCallback;", "mScrollCallback", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer$OnScrollChangedCallback;", "com/baidu/nadcore/max/uicomponent/NestedScrollComponent$nestedScrollService$2$1", "nestedScrollService$delegate", "Lkotlin/Lazy;", "getNestedScrollService", "()Lcom/baidu/nadcore/max/uicomponent/NestedScrollComponent$nestedScrollService$2$1;", "nestedScrollService", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer$OnUpListener;", "onUpListener", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer$OnUpListener;", "Landroid/animation/ValueAnimator;", "scrollAnimator", "Landroid/animation/ValueAnimator;", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer;", "webViewContainer$delegate", "getWebViewContainer", "()Lcom/baidu/nadcore/max/uiwidget/basic/WebViewContainer;", "webViewContainer", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NestedScrollComponent extends AbsComponentPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy d;
    public on0 e;
    public ValueAnimator f;
    public boolean g;
    public eg0 h;
    public final Lazy i;
    public final WebViewContainer.c j;
    public final WebViewContainer.d k;

    /* loaded from: classes2.dex */
    public static final class a implements WebViewContainer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jm0 a;

        public a(jm0 jm0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jm0Var;
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.WebViewContainer.b
        public final boolean a() {
            InterceptResult invokeV;
            AbsContainer b;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                jm0 jm0Var = this.a;
                return ((jm0Var == null || (b = jm0Var.b()) == null) ? -1 : b.k()) <= 0;
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
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                if (z) {
                    int topMargin = this.a.y().getTopMargin();
                    im0 im0Var = (im0) this.a.j().p(im0.class);
                    if (topMargin <= (im0Var != null ? im0Var.getVideoHeight() : 0)) {
                        this.a.C(false);
                        return true;
                    }
                }
                if (z || this.a.y().getTopMargin() < this.a.y().getMinTopMargin()) {
                    return false;
                }
                this.a.C(true);
                return true;
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
            NestedScrollComponent nestedScrollComponent;
            FrameLayout h;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                im0 im0Var = (im0) this.a.j().p(im0.class);
                float y = (im0Var == null || (h = im0Var.h()) == null) ? 0.0f - i2 : h.getY();
                im0 im0Var2 = (im0) this.a.j().p(im0.class);
                int videoHeight = im0Var2 != null ? im0Var2.getVideoHeight() : 0;
                float f = videoHeight;
                float min = Math.min(Math.max(y, 0.0f - f), 0.0f);
                this.a.w((f - nestedScrollComponent.y().getTopMargin()) / (videoHeight - this.a.y().getMinTopMargin()));
                this.a.j().k(new vl0(NestedEvent.MOVE_VIEW, min, videoHeight, this.a.y().getTopMargin(), this.a.y().getMinTopMargin()));
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
            FrameLayout h;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nestedScrollComponent, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = nestedScrollComponent;
            this.h = z;
            im0 im0Var = (im0) nestedScrollComponent.j().p(im0.class);
            int videoHeight = im0Var != null ? im0Var.getVideoHeight() : 0;
            this.a = videoHeight;
            int topMargin = z ? videoHeight - nestedScrollComponent.y().getTopMargin() : nestedScrollComponent.y().getTopMargin() - nestedScrollComponent.y().getMinTopMargin();
            this.c = topMargin;
            this.d = z2 ? topMargin : i;
            this.e = nestedScrollComponent.y().getTopMargin();
            im0 im0Var2 = (im0) nestedScrollComponent.j().p(im0.class);
            this.f = (im0Var2 == null || (h = im0Var2.h()) == null) ? 0.0f : h.getY();
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
                    this.g.j().k(new vl0(NestedEvent.MOVE_VIEW, this.f, this.a, this.g.y().getTopMargin(), this.g.y().getMinTopMargin()));
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
                if (this.b) {
                    this.a.B(this.c, this.d);
                    return;
                }
                this.a.w(0.0f);
                this.a.j().k(new wl0(NestedEvent.SCROLL_FINISH));
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.G(this.b);
            }
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                int topMargin = this.a.y().getTopMargin();
                im0 im0Var = (im0) this.a.j().p(im0.class);
                int videoHeight = im0Var != null ? im0Var.getVideoHeight() : 0;
                if (topMargin == this.a.y().getMinTopMargin() || topMargin == videoHeight) {
                    this.a.B(!z, false);
                    return;
                }
                boolean z2 = (((double) this.a.y().getTopMargin()) * 1.0d) / (((double) videoHeight) * 1.0d) >= (z ? 0.8d : 0.2d);
                this.a.j().k(new xl0(NestedEvent.SCROLL_UP, z));
                this.a.C(z2);
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
        this.d = LazyKt__LazyJVMKt.lazy(new NestedScrollComponent$webViewContainer$2(this));
        this.i = LazyKt__LazyJVMKt.lazy(new NestedScrollComponent$nestedScrollService$2(this));
        this.j = new c(this);
        this.k = new g(this);
    }

    public final void A(zl0 zl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zl0Var) == null) {
            if (lm0.$EnumSwitchMapping$3[zl0Var.getType().ordinal()] != 1) {
                return;
            }
            this.g = true;
        }
    }

    public final void B(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                j().k(new wl0(NestedEvent.UP_SHOW_VIDEO));
            } else {
                j().k(new wl0(NestedEvent.UP_SHOW_WEB));
            }
            im0 im0Var = (im0) j().p(im0.class);
            int videoHeight = im0Var != null ? im0Var.getVideoHeight() : 0;
            if (z) {
                y().scrollBy(0, -(videoHeight - y().getTopMargin()));
                y().setTopMargin(videoHeight);
                w(0.0f);
            } else {
                this.g = true;
                y().scrollBy(0, y().getTopMargin() - y().getMinTopMargin());
                y().setTopMargin(y().getMinTopMargin());
                fm0 fm0Var = (fm0) j().p(fm0.class);
                if (fm0Var != null) {
                    String str = ClogBuilder.LogType.VIDEO_LP_VIDEO_HIDE.type;
                    Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.VIDEO_LP_VIDEO_HIDE.type");
                    fm0Var.c(str, "", z2 ? "0" : "1");
                }
                w(1.0f);
            }
            j().k(new vl0(NestedEvent.MOVE_VIEW, z ? 0.0f : y().getTopMargin() - y().getMinTopMargin(), videoHeight, y().getTopMargin(), y().getMinTopMargin()));
        }
    }

    public final void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            D(z, false, false);
        }
    }

    public final void D(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            on0 on0Var = this.e;
            if (on0Var == null || !on0Var.d()) {
                J(z, z2, z3);
            }
        }
    }

    public final void E(bm0 bm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bm0Var) == null) {
            int i = lm0.$EnumSwitchMapping$1[bm0Var.getType().ordinal()];
            boolean z = true;
            if (i == 1) {
                u();
            } else if (i != 2) {
            } else {
                eg0 eg0Var = this.h;
                Map<String, String> map = eg0Var != null ? eg0Var.c : null;
                eg0 eg0Var2 = this.h;
                String a2 = fg0.a("leftslide", map, eg0Var2 != null ? eg0Var2.b : null, "");
                if (a2 != null && a2.length() != 0) {
                    z = false;
                }
                if (z) {
                    return;
                }
                mg0.c(a2, getContext());
                fm0 fm0Var = (fm0) j().p(fm0.class);
                if (fm0Var != null) {
                    String str = ClogBuilder.LogType.FREE_CLICK.type;
                    Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
                    fm0Var.a(str, "leftslide");
                }
            }
        }
    }

    public final void F(cm0 cm0Var) {
        AbsContainer b2;
        View i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cm0Var) == null) {
            jm0 jm0Var = (jm0) j().p(jm0.class);
            if (lm0.$EnumSwitchMapping$0[cm0Var.getType().ordinal()] != 1) {
                return;
            }
            y().setInterceptScrollLister(new a(jm0Var));
            if (jm0Var == null || (b2 = jm0Var.b()) == null || (i = b2.i()) == null) {
                return;
            }
            ag0.f(i);
            y().addView(i, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void G(ViewGroup viewGroup) {
        AbsContainer b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viewGroup) == null) {
            viewGroup.addView(y(), new FrameLayout.LayoutParams(-1, -1));
            jm0 jm0Var = (jm0) j().p(jm0.class);
            View i = (jm0Var == null || (b2 = jm0Var.b()) == null) ? null : b2.i();
            ViewGroup.LayoutParams layoutParams = i != null ? i.getLayoutParams() : null;
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? layoutParams : null;
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            im0 im0Var = (im0) j().p(im0.class);
            int videoHeight = im0Var != null ? im0Var.getVideoHeight() : 0;
            layoutParams2.topMargin = videoHeight;
            layoutParams2.height = viewGroup.getMeasuredHeight();
            y().setTopMargin(videoHeight);
            y().setTopLimit(videoHeight);
            on0 on0Var = this.e;
            if (on0Var != null && on0Var.d()) {
                y().setStyle(2);
            } else {
                y().setStyle(3);
            }
            if (i != null) {
                i.setLayoutParams(layoutParams2);
            }
            jm0 jm0Var2 = (jm0) j().p(jm0.class);
            if (jm0Var2 != null) {
                jm0Var2.e(8);
            }
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            y().setClipChildren(false);
            y().setLayerType(2, null);
            y().setOnScrollChangeListener(this.j);
            y().setOnUpListener(this.k);
            y().setHandleTopYMove(true);
            y().setMinFlingVelocity(400);
            y().setUpYVelocityRatio(3.5f);
            y().setInterceptFlingListener(new b(this));
            y().setMinTopMargin(p01.c.a(getContext(), 49.0f));
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

    public final void J(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            K(z, z2, z3, -1);
        }
    }

    public final void K(boolean z, boolean z2, boolean z3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i)}) == null) {
            if (z2 || !I()) {
                boolean z4 = i == -1;
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
    }

    public final void L(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, intent) == null) {
            Serializable serializableExtra = intent.getSerializableExtra("map");
            if (!(serializableExtra instanceof HashMap)) {
                serializableExtra = null;
            }
            HashMap hashMap = (HashMap) serializableExtra;
            if (hashMap != null) {
                Object obj = hashMap.get("cmd_policy");
                String str = obj instanceof String ? obj : null;
                if (!TextUtils.isEmpty(str)) {
                    this.e = on0.g.a(xx0.c(str));
                }
                this.h = eg0.a(hashMap);
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void b(bh0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.b(event);
            String a2 = event.a();
            if (Intrinsics.areEqual(a2, cm0.class.getSimpleName())) {
                F((cm0) event);
            } else if (Intrinsics.areEqual(a2, bm0.class.getSimpleName())) {
                E((bm0) event);
            } else if (Intrinsics.areEqual(a2, yl0.class.getSimpleName())) {
                z((yl0) event);
            } else if (Intrinsics.areEqual(a2, zl0.class.getSimpleName())) {
                A((zl0) event);
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.d();
            j().s(gm0.class, x());
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void h(ViewGroup parent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            parent.post(new f(this, parent));
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            super.onNewIntent(intent);
            L(intent);
            H();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onRelease();
            v();
        }
    }

    public final void u() {
        im0 im0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.g) {
            return;
        }
        on0 on0Var = this.e;
        if ((on0Var != null ? on0Var.a() : 0) > 0 && (im0Var = (im0) j().p(im0.class)) != null && im0Var.k()) {
            int l = im0Var.l();
            on0 on0Var2 = this.e;
            if (l < (on0Var2 != null ? on0Var2.a() : 0)) {
                return;
            }
            eg0 eg0Var = this.h;
            Map<String, String> map = eg0Var != null ? eg0Var.c : null;
            eg0 eg0Var2 = this.h;
            String a2 = fg0.a("postplay", map, eg0Var2 != null ? eg0Var2.b : null, "");
            Intrinsics.checkNotNullExpressionValue(a2, "AreaChargeUtil.area2Cmd(… adAreaInfo?.mCmdMap, \"\")");
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            if (TextUtils.equals(a2, "AD_IMMERSIVE_VIDEO_SCROLL")) {
                D(false, true, true);
                return;
            }
            mg0.c(a2, getContext());
            this.g = true;
        }
    }

    public final void v() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (valueAnimator = this.f) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    public final void w(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f2) == null) {
            String d2 = ag0.d(0.6f * f2, "000000");
            Intrinsics.checkNotNullExpressionValue(d2, "AdUtil.getOpacityColor(currentOpacity, \"000000\")");
            y().setBackgroundColor(ag0.e(d2, ((double) f2) > 0.5d ? R.color.obfuscated_res_0x7f060841 : R.color.obfuscated_res_0x7f060840));
        }
    }

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

    public final void z(yl0 yl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, yl0Var) == null) {
            if (lm0.$EnumSwitchMapping$2[yl0Var.getType().ordinal()] != 1) {
                return;
            }
            this.g = true;
        }
    }
}
