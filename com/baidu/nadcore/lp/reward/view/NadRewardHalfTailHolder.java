package com.baidu.nadcore.lp.reward.view;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.core.net.MailTo;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.uiwidget.ExpandIconView;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.R;
import com.baidu.tieba.ar0;
import com.baidu.tieba.b51;
import com.baidu.tieba.cr0;
import com.baidu.tieba.fr0;
import com.baidu.tieba.j71;
import com.baidu.tieba.n21;
import com.baidu.tieba.o21;
import com.baidu.tieba.p71;
import com.baidu.tieba.q71;
import com.baidu.tieba.ro0;
import com.baidu.tieba.so0;
import com.baidu.tieba.tq0;
import com.baidu.tieba.wi0;
import com.baidu.tieba.xq0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\\\u001a\u00020[\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010]\u0012\b\b\u0002\u0010_\u001a\u00020\n¢\u0006\u0004\b`\u0010aJ9\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\fH\u0003¢\u0006\u0004\b\u0018\u0010\u0016J3\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\fH\u0014¢\u0006\u0004\b \u0010\u0016J\u001b\u0010#\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0!¢\u0006\u0004\b#\u0010$J\u001b\u0010%\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0!¢\u0006\u0004\b%\u0010$J\u0017\u0010(\u001a\u00020\f2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0!H\u0016¢\u0006\u0004\b*\u0010$J\u001b\u0010+\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0!¢\u0006\u0004\b+\u0010$J!\u0010.\u001a\u00020\f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\f0,¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\f2\u0006\u00100\u001a\u00020-H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\f2\u0006\u00103\u001a\u00020-H\u0002¢\u0006\u0004\b4\u00102J\u000f\u00105\u001a\u00020\fH\u0002¢\u0006\u0004\b5\u0010\u0016R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u00106R\u001d\u0010<\u001a\u0002078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001e\u0010=\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u001e\u0010?\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010>R\u001d\u0010D\u001a\u00020@8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u00109\u001a\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001d\u0010K\u001a\u00020G8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u00109\u001a\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010R\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u001e\u0010T\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010>R\u0016\u0010U\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010FR\u0016\u0010V\u001a\u00020L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010NR$\u0010W\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\f\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Y\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010Z¨\u0006b"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardHalfTailHolder;", "Lcom/baidu/tieba/so0;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "target", "", "from", MailTo.TO, "", "ms", "", "vis", "", "doViewAlphaAnimation", "(Landroid/view/View;FFJI)V", "", "getLogTime", "()Ljava/lang/String;", "Landroid/view/ViewGroup;", "getView", "()Landroid/view/ViewGroup;", "initArrowView", "()V", "initGuideView", "initTailInfoView", DnsModel.AREA_KEY, "Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;", "logType", "ext1", "ext2", "logAndCharge", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;Ljava/lang/String;)V", "onDetachedFromWindow", "Lkotlin/Function0;", WebChromeClient.KEY_ARG_CALLBACK, "setBackBtnCallback", "(Lkotlin/Function0;)V", "setCloseClickCallback", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setData", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "setOnReplayClickListener", "setPanelPopDismissCallback", "Lkotlin/Function1;", "", "setShowPanelPopCallback", "(Lkotlin/Function1;)V", "isVisible", "setVisibility", "(Z)V", "autoPopup", "showPanelPop", "tryShowGuideLottie", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Lcom/baidu/nadcore/widget/uiwidget/ExpandIconView;", "arrowView$delegate", "Lkotlin/Lazy;", "getArrowView", "()Lcom/baidu/nadcore/widget/uiwidget/ExpandIconView;", "arrowView", "backBtnCallback", "Lkotlin/Function0;", "closeIconCallback", "Lcom/baidu/nadcore/lp/reward/view/NadRewardHalfTailView;", "halfTailView$delegate", "getHalfTailView", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardHalfTailView;", "halfTailView", "hasShowGuide", "Z", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieGuideView$delegate", "getLottieGuideView", "()Lcom/airbnb/lottie/LottieAnimationView;", "lottieGuideView", "Ljava/lang/Runnable;", "lottieRunnable", "Ljava/lang/Runnable;", "mLoadStartTime", "J", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "panelPop", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "panelPopDismissCallback", "shouldCharge", "shouldChargeTask", "showPanelPopCallback", "Lkotlin/Function1;", "tailNineChargeModify", "Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadRewardHalfTailHolder extends FrameLayout implements so0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public j71 d;
    public xq0 e;
    public boolean f;
    public String g;
    public long h;
    public final Runnable i;
    public Function1<? super Boolean, Unit> j;
    public Function0<Unit> k;
    public Function0<Unit> l;
    public Function0<Unit> m;
    public boolean n;
    public Runnable o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadRewardHalfTailHolder(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadRewardHalfTailHolder(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExpandIconView getArrowView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? (ExpandIconView) this.c.getValue() : (ExpandIconView) invokeV.objValue;
    }

    private final NadRewardHalfTailView getHalfTailView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? (NadRewardHalfTailView) this.b.getValue() : (NadRewardHalfTailView) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LottieAnimationView getLottieGuideView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? (LottieAnimationView) this.a.getValue() : (LottieAnimationView) invokeV.objValue;
    }

    /* loaded from: classes2.dex */
    public static final class i<T> implements LottieListener<LottieComposition> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardHalfTailHolder a;

        public i(NadRewardHalfTailHolder nadRewardHalfTailHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardHalfTailHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardHalfTailHolder;
        }

        /* loaded from: classes2.dex */
        public static final class a implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, animation) == null) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }
            }

            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    NadRewardHalfTailHolder nadRewardHalfTailHolder = this.a.a;
                    nadRewardHalfTailHolder.q(nadRewardHalfTailHolder.getLottieGuideView(), 1.0f, 0.0f, 320L, 8);
                    this.a.a.getArrowView().setVisibility(0);
                    this.a.a.getArrowView().bringToFront();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    NadRewardHalfTailHolder nadRewardHalfTailHolder = this.a.a;
                    nadRewardHalfTailHolder.q(nadRewardHalfTailHolder.getLottieGuideView(), 1.0f, 0.0f, 320L, 8);
                    this.a.a.getArrowView().setVisibility(0);
                    this.a.a.getArrowView().bringToFront();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, lottieComposition) != null) {
                return;
            }
            this.a.f = true;
            this.a.getLottieGuideView().bringToFront();
            this.a.getLottieGuideView().setComposition(lottieComposition);
            NadRewardHalfTailHolder nadRewardHalfTailHolder = this.a;
            nadRewardHalfTailHolder.q(nadRewardHalfTailHolder.getLottieGuideView(), 0.0f, 1.0f, 320L, 0);
            this.a.getLottieGuideView().setRepeatCount(1);
            this.a.getLottieGuideView().addAnimatorListener(new a(this));
        }
    }

    /* loaded from: classes2.dex */
    public static final class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        public a(View view2, float f, float f2, long j, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, Float.valueOf(f), Float.valueOf(f2), Long.valueOf(j), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = i;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.a.setAlpha(1.0f);
                this.a.setVisibility(this.b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardHalfTailHolder a;

        public b(NadRewardHalfTailHolder nadRewardHalfTailHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardHalfTailHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardHalfTailHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.w(false);
            NadRewardHalfTailHolder nadRewardHalfTailHolder = this.a;
            String str = ClogBuilder.Area.ARROW.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.ARROW.type");
            NadRewardHalfTailHolder.v(nadRewardHalfTailHolder, str, ClogBuilder.LogType.CLICK, null, null, 12, null);
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements ro0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardHalfTailHolder a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public c(NadRewardHalfTailHolder nadRewardHalfTailHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardHalfTailHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardHalfTailHolder;
        }

        @Override // com.baidu.tieba.ro0
        public boolean a(String area, ClogBuilder.LogType logType, String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, area, logType, str)) == null) {
                Intrinsics.checkNotNullParameter(area, "area");
                Intrinsics.checkNotNullParameter(logType, "logType");
                if (TextUtils.equals(area, "morebtn") || TextUtils.equals(area, "replaybtn")) {
                    return false;
                }
                this.a.w(false);
                NadRewardHalfTailHolder.v(this.a, area, logType, null, null, 12, null);
                return true;
            }
            return invokeLLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public float b;
        public final /* synthetic */ NadRewardHalfTailHolder c;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public d(NadRewardHalfTailHolder nadRewardHalfTailHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardHalfTailHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nadRewardHalfTailHolder;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            InterceptResult invokeLL;
            boolean z;
            ar0 ar0Var;
            cr0 cr0Var;
            String str;
            ar0 ar0Var2;
            cr0 cr0Var2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, v, event)) == null) {
                Intrinsics.checkNotNullParameter(v, "v");
                Intrinsics.checkNotNullParameter(event, "event");
                int action = event.getAction();
                if (action != 0) {
                    if (action == 1 || action == 3) {
                        float rawX = event.getRawX();
                        float rawY = event.getRawY();
                        if (Math.abs(rawY - this.a) / Math.abs(rawX - this.b) > 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (rawY - this.a < -60 && z) {
                            xq0 xq0Var = this.c.e;
                            if (xq0Var != null && (ar0Var = xq0Var.j) != null && (cr0Var = ar0Var.h) != null && cr0Var.C) {
                                xq0 xq0Var2 = this.c.e;
                                if (xq0Var2 != null && (ar0Var2 = xq0Var2.j) != null && (cr0Var2 = ar0Var2.h) != null) {
                                    str = cr0Var2.f;
                                } else {
                                    str = null;
                                }
                                wi0.c(str, this.c.getContext());
                            } else {
                                this.c.w(false);
                            }
                            NadRewardHalfTailHolder nadRewardHalfTailHolder = this.c;
                            String str2 = ClogBuilder.Area.SWIPE_UP.type;
                            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.SWIPE_UP.type");
                            NadRewardHalfTailHolder.v(nadRewardHalfTailHolder, str2, ClogBuilder.LogType.CLICK, null, null, 12, null);
                            return true;
                        }
                    }
                } else {
                    this.b = event.getRawX();
                    this.a = event.getRawY();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardHalfTailHolder a;

        public e(NadRewardHalfTailHolder nadRewardHalfTailHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardHalfTailHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardHalfTailHolder;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.getLottieGuideView().cancelAnimation();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class f implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardHalfTailHolder a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public f(NadRewardHalfTailHolder nadRewardHalfTailHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardHalfTailHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardHalfTailHolder;
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
            if (r9 != false) goto L32;
         */
        @Override // android.view.animation.Animation.AnimationListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onAnimationEnd(Animation animation) {
            ar0 ar0Var;
            cr0 cr0Var;
            String str;
            boolean z;
            ar0 ar0Var2;
            cr0 cr0Var2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.a.x();
                Boolean bool = null;
                if (!this.a.f) {
                    xq0 xq0Var = this.a.e;
                    if (xq0Var != null && (ar0Var2 = xq0Var.j) != null && (cr0Var2 = ar0Var2.h) != null) {
                        str = cr0Var2.B;
                    } else {
                        str = null;
                    }
                    if (str != null && str.length() != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                }
                this.a.getArrowView().setVisibility(0);
                xq0 xq0Var2 = this.a.e;
                if (xq0Var2 != null && (ar0Var = xq0Var2.j) != null && (cr0Var = ar0Var.h) != null) {
                    bool = cr0Var.D;
                }
                if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    return;
                }
                this.a.w(true);
                NadRewardHalfTailHolder nadRewardHalfTailHolder = this.a;
                String str2 = ClogBuilder.Area.SWIPE_UP.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.SWIPE_UP.type");
                NadRewardHalfTailHolder.v(nadRewardHalfTailHolder, str2, ClogBuilder.LogType.FREE_CLICK, null, null, 12, null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardHalfTailHolder a;

        public g(NadRewardHalfTailHolder nadRewardHalfTailHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardHalfTailHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardHalfTailHolder;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.n = true;
        }
    }

    /* loaded from: classes2.dex */
    public static final class h implements p71 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardHalfTailHolder a;
        public final /* synthetic */ boolean b;

        public h(NadRewardHalfTailHolder nadRewardHalfTailHolder, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardHalfTailHolder, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardHalfTailHolder;
            this.b = z;
        }

        @Override // com.baidu.tieba.p71
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.b) {
                return;
            }
            if (TextUtils.equals(this.a.g, "2") && this.a.n) {
                NadRewardHalfTailHolder nadRewardHalfTailHolder = this.a;
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                nadRewardHalfTailHolder.u(str, ClogBuilder.LogType.CLICK, this.a.getLogTime(), "2");
            }
            if (TextUtils.equals(this.a.g, "1")) {
                NadRewardHalfTailHolder nadRewardHalfTailHolder2 = this.a;
                String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                nadRewardHalfTailHolder2.u(str2, ClogBuilder.LogType.FREE_CLICK, this.a.getLogTime(), "2");
            }
        }

        @Override // com.baidu.tieba.p71
        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || !this.b) {
                return;
            }
            if ((TextUtils.equals(this.a.g, "1") || TextUtils.equals(this.a.g, "2")) && this.a.n) {
                NadRewardHalfTailHolder nadRewardHalfTailHolder = this.a;
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                nadRewardHalfTailHolder.u(str, ClogBuilder.LogType.CLICK, this.a.getLogTime(), "1");
                return;
            }
            NadRewardHalfTailHolder nadRewardHalfTailHolder2 = this.a;
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            nadRewardHalfTailHolder2.u(str2, ClogBuilder.LogType.FREE_CLICK, this.a.getLogTime(), "1");
        }

        @Override // com.baidu.tieba.p71
        public void b() {
            Function0 function0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (function0 = this.a.m) != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }

        @Override // com.baidu.tieba.p71
        public void d() {
            Function0 function0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (function0 = this.a.l) != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }

        @Override // com.baidu.tieba.p71
        public void dismiss() {
            Function0 function0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (function0 = this.a.k) != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }

        @Override // com.baidu.tieba.p71
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                NadRewardHalfTailHolder nadRewardHalfTailHolder = this.a;
                String str = ClogBuilder.Area.AD_BLANK.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.AD_BLANK.type");
                NadRewardHalfTailHolder.v(nadRewardHalfTailHolder, str, ClogBuilder.LogType.FREE_CLICK, null, null, 12, null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class j<T> implements LottieListener<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardHalfTailHolder a;

        public j(NadRewardHalfTailHolder nadRewardHalfTailHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardHalfTailHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardHalfTailHolder;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.a.getLottieGuideView().setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadRewardHalfTailHolder(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<LottieAnimationView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailHolder$lottieGuideView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardHalfTailHolder this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
            public final LottieAnimationView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.lottie_guide);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.lottie_guide)");
                    return (LottieAnimationView) findViewById;
                }
                return (LottieAnimationView) invokeV.objValue;
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<NadRewardHalfTailView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailHolder$halfTailView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardHalfTailHolder this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
            public final NadRewardHalfTailView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.half_tail_view);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.half_tail_view)");
                    return (NadRewardHalfTailView) findViewById;
                }
                return (NadRewardHalfTailView) invokeV.objValue;
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<ExpandIconView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailHolder$arrowView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardHalfTailHolder this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
            public final ExpandIconView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.arrow_image);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.arrow_image)");
                    return (ExpandIconView) findViewById;
                }
                return (ExpandIconView) invokeV.objValue;
            }
        });
        this.g = "0";
        this.i = new e(this);
        this.o = new g(this);
        LayoutInflater.from(context).inflate(R.layout.nad_reward_half_tail_holder, this);
    }

    public /* synthetic */ NadRewardHalfTailHolder(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final void setBackBtnCallback(Function0<Unit> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.l = callback;
        }
    }

    public final void setCloseClickCallback(Function0<Unit> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.m = callback;
        }
    }

    @Override // com.baidu.tieba.so0
    public void setData(xq0 adModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, adModel) == null) {
            Intrinsics.checkNotNullParameter(adModel, "adModel");
            this.e = adModel;
            t();
            r();
            s();
        }
    }

    @Override // com.baidu.tieba.so0
    public void setOnReplayClickListener(Function0<Unit> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            getHalfTailView().setOnReplayClickListener(callback);
        }
    }

    public final void setPanelPopDismissCallback(Function0<Unit> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.k = callback;
        }
    }

    public final void setShowPanelPopCallback(Function1<? super Boolean, Unit> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.j = callback;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getLogTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            return String.valueOf((System.currentTimeMillis() - this.h) / 1000);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.so0
    public ViewGroup getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return getHalfTailView();
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDetachedFromWindow();
            removeCallbacks(this.i);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            getArrowView().setOnClickListener(new b(this));
            getArrowView().setState(1, false);
            getArrowView().bringToFront();
        }
    }

    public static /* synthetic */ void v(NadRewardHalfTailHolder nadRewardHalfTailHolder, String str, ClogBuilder.LogType logType, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        if ((i2 & 8) != 0) {
            str3 = "";
        }
        nadRewardHalfTailHolder.u(str, logType, str2, str3);
    }

    public final void q(View view2, float f2, float f3, long j2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j2), Integer.valueOf(i2)}) == null) && view2 != null) {
            view2.setAlpha(f2);
            view2.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
            alphaAnimation.setDuration(j2);
            view2.startAnimation(alphaAnimation);
            alphaAnimation.setAnimationListener(new a(view2, f2, f3, j2, i2));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ViewGroup.LayoutParams layoutParams = getLottieGuideView().getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = (((b51.c.f(getContext()) - b51.c.g()) - b51.c.a(getContext(), 47.0f)) - b51.c.a(getContext(), 472.0f)) - b51.c.a(getContext(), 135.0f);
                getLottieGuideView().setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            getHalfTailView().setVisibility(8);
            getHalfTailView().setData(this.e);
            getHalfTailView().setBackgroundResource(R.drawable.nad_reward_half_tail_bg);
            getHalfTailView().i(new c(this));
            getHalfTailView().setClickable(true);
            getHalfTailView().setOnTouchListener(new d(this));
        }
    }

    @Override // com.baidu.tieba.so0
    public void setVisibility(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            setVisibility(i2);
            getArrowView().setVisibility(8);
            if (z) {
                getHalfTailView().setVisibility(0);
                TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
                translateAnimation.setDuration(320L);
                translateAnimation.setAnimationListener(new f(this));
                getHalfTailView().startAnimation(translateAnimation);
                return;
            }
            j71 j71Var = this.d;
            if (j71Var != null) {
                j71Var.a(0);
            }
            getHalfTailView().setVisibility(8);
        }
    }

    public final void u(String str, ClogBuilder.LogType logType, String str2, String str3) {
        String str4;
        boolean z;
        boolean z2;
        xq0 xq0Var;
        List<MonitorUrl> list;
        boolean z3;
        tq0 tq0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048589, this, str, logType, str2, str3) == null) {
            ClogBuilder u = new ClogBuilder().j(str).y(logType).u(ClogBuilder.Page.WELFARETAIL);
            xq0 xq0Var2 = this.e;
            if (xq0Var2 != null && (tq0Var = xq0Var2.f) != null) {
                str4 = tq0Var.d;
            } else {
                str4 = null;
            }
            ClogBuilder p = u.p(str4);
            if (str2.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                p.k(str2);
            }
            if (str3.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                p.l(str3);
            }
            n21.b(p);
            if (logType == ClogBuilder.LogType.CLICK && (xq0Var = this.e) != null && (list = xq0Var.e) != null) {
                ArrayList<MonitorUrl> arrayList = new ArrayList();
                for (Object obj : list) {
                    String str5 = ((MonitorUrl) obj).clickUrl;
                    if (str5 != null && !StringsKt__StringsJVMKt.isBlank(str5)) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (!z3) {
                        arrayList.add(obj);
                    }
                }
                for (MonitorUrl monitorUrl : arrayList) {
                    o21.b(monitorUrl.clickUrl);
                }
            }
        }
    }

    public final void w(boolean z) {
        String str;
        boolean z2;
        String str2;
        String str3;
        String str4;
        tq0 tq0Var;
        tq0 tq0Var2;
        tq0 tq0Var3;
        ar0 ar0Var;
        cr0 cr0Var;
        Handler handler;
        long j2;
        fr0 b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            xq0 xq0Var = this.e;
            String str5 = null;
            if (xq0Var != null) {
                str = xq0Var.d();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                this.d = null;
                return;
            }
            if (z && (handler = getHandler()) != null) {
                Runnable runnable = this.o;
                xq0 xq0Var2 = this.e;
                if (xq0Var2 != null && (b2 = xq0Var2.b()) != null) {
                    j2 = b2.j();
                } else {
                    j2 = 0;
                }
                handler.postDelayed(runnable, j2);
            }
            j71 j71Var = new j71(getContext());
            xq0 xq0Var3 = this.e;
            this.g = (xq0Var3 == null || (ar0Var = xq0Var3.j) == null || (cr0Var = ar0Var.h) == null || (r3 = cr0Var.E) == null) ? "0" : "0";
            j71Var.f(new h(this, z));
            xq0 xq0Var4 = this.e;
            if (xq0Var4 != null) {
                str2 = xq0Var4.d();
            } else {
                str2 = null;
            }
            xq0 xq0Var5 = this.e;
            if (xq0Var5 != null && (tq0Var3 = xq0Var5.f) != null) {
                str3 = tq0Var3.d;
            } else {
                str3 = null;
            }
            q71 q71Var = new q71(str2, 0.9d, 0, str3);
            q71Var.x(false);
            q71Var.y(z);
            q71Var.u(z);
            q71Var.v(z);
            q71Var.z(!z);
            xq0 xq0Var6 = this.e;
            if (xq0Var6 != null && (tq0Var2 = xq0Var6.f) != null) {
                str4 = tq0Var2.m;
            } else {
                str4 = null;
            }
            if (!TextUtils.isEmpty(str4)) {
                xq0 xq0Var7 = this.e;
                if (xq0Var7 != null && (tq0Var = xq0Var7.f) != null) {
                    str5 = tq0Var.l;
                }
                q71Var.t(str5);
            }
            Unit unit = Unit.INSTANCE;
            j71Var.e(q71Var);
            j71Var.h();
            this.h = System.currentTimeMillis();
            Unit unit2 = Unit.INSTANCE;
            this.d = j71Var;
            if (getLottieGuideView().isAnimating()) {
                getLottieGuideView().cancelAnimation();
            }
            Function1<? super Boolean, Unit> function1 = this.j;
            if (function1 != null) {
                function1.invoke(Boolean.valueOf(z));
            }
        }
    }

    public final void x() {
        String str;
        boolean z;
        Boolean bool;
        ar0 ar0Var;
        cr0 cr0Var;
        ar0 ar0Var2;
        cr0 cr0Var2;
        ar0 ar0Var3;
        cr0 cr0Var3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && !this.f) {
            xq0 xq0Var = this.e;
            String str2 = null;
            if (xq0Var != null && (ar0Var3 = xq0Var.j) != null && (cr0Var3 = ar0Var3.h) != null) {
                str = cr0Var3.B;
            } else {
                str = null;
            }
            int i2 = 0;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                xq0 xq0Var2 = this.e;
                if (xq0Var2 != null && (ar0Var2 = xq0Var2.j) != null && (cr0Var2 = ar0Var2.h) != null) {
                    bool = cr0Var2.D;
                } else {
                    bool = null;
                }
                if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    xq0 xq0Var3 = this.e;
                    if (xq0Var3 != null && (ar0Var = xq0Var3.j) != null && (cr0Var = ar0Var.h) != null) {
                        str2 = cr0Var.B;
                    }
                    Context context = getContext();
                    if (str2 != null) {
                        i2 = str2.hashCode();
                    }
                    LottieCompositionFactory.fromUrl(context, str2, String.valueOf(i2)).addListener(new i(this)).addFailureListener(new j(this));
                    getLottieGuideView().playAnimation();
                    postDelayed(this.i, 4500L);
                }
            }
        }
    }
}
