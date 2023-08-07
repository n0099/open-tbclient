package com.baidu.nadcore.lp.reward.view;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
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
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.searchbox.common.security.PermissionStorage;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.R;
import com.baidu.tieba.a91;
import com.baidu.tieba.ap0;
import com.baidu.tieba.b91;
import com.baidu.tieba.cp0;
import com.baidu.tieba.dj0;
import com.baidu.tieba.fp0;
import com.baidu.tieba.gr0;
import com.baidu.tieba.h61;
import com.baidu.tieba.jp0;
import com.baidu.tieba.mj0;
import com.baidu.tieba.mr0;
import com.baidu.tieba.pr0;
import com.baidu.tieba.q31;
import com.baidu.tieba.r31;
import com.baidu.tieba.rr0;
import com.baidu.tieba.t81;
import com.baidu.tieba.vr0;
import com.baidu.tieba.yi0;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010_\u001a\u00020^\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010`\u0012\b\b\u0002\u0010b\u001a\u00020\u000f¢\u0006\u0004\bc\u0010dJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J9\u0010\u0012\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u0011H\u0003¢\u0006\u0004\b\u001c\u0010\u001aJ3\u0010\"\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0011H\u0014¢\u0006\u0004\b$\u0010\u001aJ\u001b\u0010'\u001a\u00020\u00112\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110%¢\u0006\u0004\b'\u0010(J\u001b\u0010)\u001a\u00020\u00112\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110%¢\u0006\u0004\b)\u0010(J\u0017\u0010,\u001a\u00020\u00112\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u001d\u0010.\u001a\u00020\u00112\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110%H\u0016¢\u0006\u0004\b.\u0010(J\u001b\u0010/\u001a\u00020\u00112\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110%¢\u0006\u0004\b/\u0010(J!\u00101\u001a\u00020\u00112\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001100¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u0005H\u0016¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u0005H\u0002¢\u0006\u0004\b7\u00105J\u000f\u00108\u001a\u00020\u0011H\u0002¢\u0006\u0004\b8\u0010\u001aR\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u00109R\u001d\u0010?\u001a\u00020:8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001e\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010AR\u001d\u0010G\u001a\u00020C8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010<\u001a\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u001d\u0010N\u001a\u00020J8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010<\u001a\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010U\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u001e\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010AR\u0016\u0010X\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010IR\u0016\u0010Y\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010QR$\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0011\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]¨\u0006e"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardHalfTailHolder;", "Lcom/baidu/tieba/cp0;", "Landroid/widget/FrameLayout;", "", "scheme", "", "checkRewardPanelPop", "(Ljava/lang/String;)Z", "Landroid/view/View;", "target", "", "from", "to", "", "ms", "", "vis", "", "doViewAlphaAnimation", "(Landroid/view/View;FFJI)V", "getLogTime", "()Ljava/lang/String;", "Landroid/view/ViewGroup;", "getView", "()Landroid/view/ViewGroup;", "initArrowView", "()V", "initGuideView", "initTailInfoView", DnsModel.AREA_KEY, "Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;", "logType", PermissionStorage.PermissionItem.ITEM_EXT_1, PermissionStorage.PermissionItem.ITEM_EXT_2, "logAndCharge", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;Ljava/lang/String;)V", "onDetachedFromWindow", "Lkotlin/Function0;", WebChromeClient.KEY_ARG_CALLBACK, "setBackBtnCallback", "(Lkotlin/Function0;)V", "setCloseClickCallback", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setData", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "setOnReplayClickListener", "setPanelPopDismissCallback", "Lkotlin/Function1;", "setShowPanelPopCallback", "(Lkotlin/Function1;)V", "isVisible", "setVisibility", "(Z)V", "autoPopup", "showPanelPop", "tryShowGuideLottie", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Lcom/baidu/nadcore/widget/AdImageView;", "arrowView$delegate", "Lkotlin/Lazy;", "getArrowView", "()Lcom/baidu/nadcore/widget/AdImageView;", "arrowView", "backBtnCallback", "Lkotlin/Function0;", "closeIconCallback", "Lcom/baidu/nadcore/lp/reward/view/NadRewardHalfTailView;", "halfTailView$delegate", "getHalfTailView", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardHalfTailView;", "halfTailView", "hasShowGuide", "Z", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieGuideView$delegate", "getLottieGuideView", "()Lcom/airbnb/lottie/LottieAnimationView;", "lottieGuideView", "Ljava/lang/Runnable;", "lottieRunnable", "Ljava/lang/Runnable;", "mLoadStartTime", "J", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "panelPop", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "panelPopDismissCallback", "shouldCharge", "shouldChargeTask", "showPanelPopCallback", "Lkotlin/Function1;", "tailNineChargeModify", "Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRewardHalfTailHolder extends FrameLayout implements cp0 {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public t81 d;
    public mr0 e;
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

    @JvmOverloads
    public NadRewardHalfTailHolder(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public NadRewardHalfTailHolder(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdImageView getArrowView() {
        return (AdImageView) this.c.getValue();
    }

    private final NadRewardHalfTailView getHalfTailView() {
        return (NadRewardHalfTailView) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LottieAnimationView getLottieGuideView() {
        return (LottieAnimationView) this.a.getValue();
    }

    /* loaded from: classes3.dex */
    public static final class j<T> implements LottieListener<LottieComposition> {
        public j() {
        }

        /* loaded from: classes3.dex */
        public static final class a implements Animator.AnimatorListener {
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
                nadRewardHalfTailHolder.s(nadRewardHalfTailHolder.getLottieGuideView(), 1.0f, 0.0f, 320L, 8);
                NadRewardHalfTailHolder.this.getArrowView().setVisibility(0);
                NadRewardHalfTailHolder.this.getArrowView().bringToFront();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
                nadRewardHalfTailHolder.s(nadRewardHalfTailHolder.getLottieGuideView(), 1.0f, 0.0f, 320L, 8);
                NadRewardHalfTailHolder.this.getArrowView().setVisibility(0);
                NadRewardHalfTailHolder.this.getArrowView().bringToFront();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(LottieComposition lottieComposition) {
            NadRewardHalfTailHolder.this.f = true;
            NadRewardHalfTailHolder.this.getLottieGuideView().bringToFront();
            NadRewardHalfTailHolder.this.getLottieGuideView().setComposition(lottieComposition);
            NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
            nadRewardHalfTailHolder.s(nadRewardHalfTailHolder.getLottieGuideView(), 0.0f, 1.0f, 320L, 0);
            NadRewardHalfTailHolder.this.getLottieGuideView().setRepeatCount(1);
            NadRewardHalfTailHolder.this.getLottieGuideView().addAnimatorListener(new a());
        }
    }

    /* loaded from: classes3.dex */
    public static final class a implements Animation.AnimationListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        public a(View view2, float f, float f2, long j, int i) {
            this.a = view2;
            this.b = i;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.a.setAlpha(1.0f);
            this.a.setVisibility(this.b);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardHalfTailHolder.this.y(false);
            NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
            String str = ClogBuilder.Area.ARROW.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.ARROW.type");
            NadRewardHalfTailHolder.x(nadRewardHalfTailHolder, str, ClogBuilder.LogType.CLICK, null, null, 12, null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements ap0 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // com.baidu.tieba.ap0
        public boolean a(String area, ClogBuilder.LogType logType, String str) {
            Intrinsics.checkNotNullParameter(area, "area");
            Intrinsics.checkNotNullParameter(logType, "logType");
            if (TextUtils.equals(area, "morebtn") || TextUtils.equals(area, "replaybtn")) {
                return false;
            }
            if (!NadRewardHalfTailHolder.this.r(str)) {
                yi0.c(str, NadRewardHalfTailHolder.this.getContext());
            } else {
                NadRewardHalfTailHolder.this.y(false);
            }
            NadRewardHalfTailHolder.x(NadRewardHalfTailHolder.this, area, logType, null, null, 12, null);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements View.OnTouchListener {
        public float a;
        public float b;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            boolean z;
            String str;
            pr0 pr0Var;
            rr0 rr0Var;
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
                        mr0 mr0Var = NadRewardHalfTailHolder.this.e;
                        if (mr0Var != null && (pr0Var = mr0Var.j) != null && (rr0Var = pr0Var.i) != null) {
                            str = rr0Var.f;
                        } else {
                            str = null;
                        }
                        if (!NadRewardHalfTailHolder.this.r(str)) {
                            yi0.c(str, NadRewardHalfTailHolder.this.getContext());
                        } else {
                            NadRewardHalfTailHolder.this.y(false);
                        }
                        NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
                        String str2 = ClogBuilder.Area.SWIPE_UP.type;
                        Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.SWIPE_UP.type");
                        NadRewardHalfTailHolder.x(nadRewardHalfTailHolder, str2, ClogBuilder.LogType.CLICK, null, null, 12, null);
                        return true;
                    }
                }
            } else {
                this.b = event.getRawX();
                this.a = event.getRawY();
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NadRewardHalfTailHolder.this.getLottieGuideView().cancelAnimation();
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
            String str = ClogBuilder.Area.AD_BLANK.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.AD_BLANK.type");
            NadRewardHalfTailHolder.x(nadRewardHalfTailHolder, str, ClogBuilder.LogType.FREE_CLICK, null, null, 12, null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public g() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
            if (r9 != false) goto L30;
         */
        @Override // android.view.animation.Animation.AnimationListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onAnimationEnd(Animation animation) {
            pr0 pr0Var;
            rr0 rr0Var;
            String str;
            boolean z;
            pr0 pr0Var2;
            rr0 rr0Var2;
            Intrinsics.checkNotNullParameter(animation, "animation");
            NadRewardHalfTailHolder.this.z();
            Boolean bool = null;
            if (!NadRewardHalfTailHolder.this.f) {
                mr0 mr0Var = NadRewardHalfTailHolder.this.e;
                if (mr0Var != null && (pr0Var2 = mr0Var.j) != null && (rr0Var2 = pr0Var2.i) != null) {
                    str = rr0Var2.B;
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
            }
            NadRewardHalfTailHolder.this.getArrowView().setVisibility(0);
            mr0 mr0Var2 = NadRewardHalfTailHolder.this.e;
            if (mr0Var2 != null && (pr0Var = mr0Var2.j) != null && (rr0Var = pr0Var.i) != null) {
                bool = rr0Var.D;
            }
            if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
                return;
            }
            NadRewardHalfTailHolder.this.y(true);
            NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
            String str2 = ClogBuilder.Area.SWIPE_UP.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.SWIPE_UP.type");
            NadRewardHalfTailHolder.x(nadRewardHalfTailHolder, str2, ClogBuilder.LogType.FREE_CLICK, null, null, 12, null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NadRewardHalfTailHolder.this.n = true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class i implements a91 {
        public final /* synthetic */ boolean b;

        public i(boolean z) {
            this.b = z;
        }

        @Override // com.baidu.tieba.a91
        public void a() {
            NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
            String str = ClogBuilder.Area.DOWN_ARROW.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.DOWN_ARROW.type");
            NadRewardHalfTailHolder.x(nadRewardHalfTailHolder, str, ClogBuilder.LogType.FREE_CLICK, null, null, 12, null);
        }

        @Override // com.baidu.tieba.a91
        public void b() {
            Function0 function0 = NadRewardHalfTailHolder.this.m;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }

        @Override // com.baidu.tieba.a91
        public void d() {
            Function0 function0 = NadRewardHalfTailHolder.this.l;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }

        @Override // com.baidu.tieba.a91
        public void dismiss() {
            Function0 function0 = NadRewardHalfTailHolder.this.k;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }

        @Override // com.baidu.tieba.a91
        public void f() {
            NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
            String str = ClogBuilder.Area.AD_BLANK.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.AD_BLANK.type");
            NadRewardHalfTailHolder.x(nadRewardHalfTailHolder, str, ClogBuilder.LogType.FREE_CLICK, null, null, 12, null);
        }

        @Override // com.baidu.tieba.a91
        public void c() {
            if (!this.b) {
                return;
            }
            if ((TextUtils.equals(NadRewardHalfTailHolder.this.g, "1") || TextUtils.equals(NadRewardHalfTailHolder.this.g, "2")) && NadRewardHalfTailHolder.this.n) {
                NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                nadRewardHalfTailHolder.w(str, ClogBuilder.LogType.CLICK, NadRewardHalfTailHolder.this.getLogTime(), "1");
                return;
            }
            NadRewardHalfTailHolder nadRewardHalfTailHolder2 = NadRewardHalfTailHolder.this;
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            nadRewardHalfTailHolder2.w(str2, ClogBuilder.LogType.FREE_CLICK, NadRewardHalfTailHolder.this.getLogTime(), "1");
        }

        @Override // com.baidu.tieba.a91
        public void e() {
            if (!this.b) {
                return;
            }
            if (TextUtils.equals(NadRewardHalfTailHolder.this.g, "2") && NadRewardHalfTailHolder.this.n) {
                NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                nadRewardHalfTailHolder.w(str, ClogBuilder.LogType.CLICK, NadRewardHalfTailHolder.this.getLogTime(), "2");
            }
            if (TextUtils.equals(NadRewardHalfTailHolder.this.g, "1")) {
                NadRewardHalfTailHolder nadRewardHalfTailHolder2 = NadRewardHalfTailHolder.this;
                String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                nadRewardHalfTailHolder2.w(str2, ClogBuilder.LogType.FREE_CLICK, NadRewardHalfTailHolder.this.getLogTime(), "2");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class k<T> implements LottieListener<Throwable> {
        public k() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(Throwable th) {
            NadRewardHalfTailHolder.this.getLottieGuideView().setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadRewardHalfTailHolder(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<LottieAnimationView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailHolder$lottieGuideView$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LottieAnimationView invoke() {
                View findViewById = NadRewardHalfTailHolder.this.findViewById(R.id.lottie_guide);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.lottie_guide)");
                return (LottieAnimationView) findViewById;
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<NadRewardHalfTailView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailHolder$halfTailView$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NadRewardHalfTailView invoke() {
                View findViewById = NadRewardHalfTailHolder.this.findViewById(R.id.half_tail_view);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.half_tail_view)");
                return (NadRewardHalfTailView) findViewById;
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailHolder$arrowView$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdImageView invoke() {
                View findViewById = NadRewardHalfTailHolder.this.findViewById(R.id.arrow_image);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.arrow_image)");
                return (AdImageView) findViewById;
            }
        });
        this.g = "0";
        this.i = new e();
        this.o = new h();
        LayoutInflater.from(context).inflate(R.layout.nad_reward_half_tail_holder, this);
    }

    public /* synthetic */ NadRewardHalfTailHolder(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final void s(View view2, float f2, float f3, long j2, int i2) {
        if (view2 != null) {
            view2.setAlpha(f2);
            view2.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
            alphaAnimation.setDuration(j2);
            view2.startAnimation(alphaAnimation);
            alphaAnimation.setAnimationListener(new a(view2, f2, f3, j2, i2));
        }
    }

    public final boolean r(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z || !mj0.o(str)) {
            return false;
        }
        return Intrinsics.areEqual(new dj0(str).a(), "rewardWebPanel");
    }

    public final void setBackBtnCallback(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.l = callback;
    }

    public final void setCloseClickCallback(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.m = callback;
    }

    @Override // com.baidu.tieba.cp0
    public void setData(mr0 adModel) {
        Intrinsics.checkNotNullParameter(adModel, "adModel");
        this.e = adModel;
        v();
        t();
        u();
        setOnClickListener(new f());
    }

    @Override // com.baidu.tieba.cp0
    public void setOnReplayClickListener(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        getHalfTailView().setOnReplayClickListener(callback);
    }

    public final void setPanelPopDismissCallback(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.k = callback;
    }

    public final void setShowPanelPopCallback(Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.j = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getLogTime() {
        return String.valueOf((System.currentTimeMillis() - this.h) / 1000);
    }

    @Override // com.baidu.tieba.cp0
    public ViewGroup getView() {
        return getHalfTailView();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.i);
    }

    public final void t() {
        getArrowView().setOnClickListener(new b());
        getArrowView().setImageResource(R.drawable.nad_reward_up_arrow);
        getArrowView().bringToFront();
    }

    public static /* synthetic */ void x(NadRewardHalfTailHolder nadRewardHalfTailHolder, String str, ClogBuilder.LogType logType, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        if ((i2 & 8) != 0) {
            str3 = "";
        }
        nadRewardHalfTailHolder.w(str, logType, str2, str3);
    }

    @Override // com.baidu.tieba.cp0
    public void setVisibility(boolean z) {
        int i2;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        setVisibility(i2);
        getArrowView().setVisibility(8);
        if (z) {
            mr0 mr0Var = this.e;
            if (mr0Var != null) {
                getHalfTailView().setMoreButton(mr0Var);
            }
            getHalfTailView().setVisibility(0);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(320L);
            translateAnimation.setAnimationListener(new g());
            getHalfTailView().startAnimation(translateAnimation);
            return;
        }
        t81 t81Var = this.d;
        if (t81Var != null) {
            t81Var.e();
        }
        getHalfTailView().setVisibility(8);
    }

    public final void u() {
        ViewGroup.LayoutParams layoutParams = getLottieGuideView().getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = (((h61.c.f(getContext()) - h61.c.g()) - h61.c.a(getContext(), 47.0f)) - h61.c.a(getContext(), 472.0f)) - h61.c.a(getContext(), 135.0f);
            getLottieGuideView().setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void v() {
        getHalfTailView().setVisibility(8);
        getHalfTailView().setData(this.e);
        getHalfTailView().setBackgroundResource(R.drawable.nad_reward_half_tail_bg);
        getHalfTailView().i(new c());
        getHalfTailView().setClickable(true);
        getHalfTailView().setOnTouchListener(new d());
    }

    public final void w(String str, ClogBuilder.LogType logType, String str2, String str3) {
        String str4;
        boolean z;
        boolean z2;
        mr0 mr0Var;
        List<MonitorUrl> list;
        boolean z3;
        gr0 gr0Var;
        ClogBuilder u = new ClogBuilder().j(str).y(logType).u(ClogBuilder.Page.WELFARETAIL);
        mr0 mr0Var2 = this.e;
        if (mr0Var2 != null && (gr0Var = mr0Var2.f) != null) {
            str4 = gr0Var.d;
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
        q31.e(p);
        if (logType == ClogBuilder.LogType.CLICK && (mr0Var = this.e) != null && (list = mr0Var.e) != null) {
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
                r31.b(monitorUrl.clickUrl);
            }
        }
    }

    public final void y(boolean z) {
        String str;
        boolean z2;
        fp0 a2;
        String str2;
        String str3;
        String str4;
        gr0 gr0Var;
        gr0 gr0Var2;
        gr0 gr0Var3;
        pr0 pr0Var;
        rr0 rr0Var;
        Handler handler;
        long j2;
        vr0 c2;
        mr0 mr0Var = this.e;
        String str5 = null;
        if (mr0Var != null) {
            str = mr0Var.f();
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
            mr0 mr0Var2 = this.e;
            if (mr0Var2 != null && (c2 = mr0Var2.c()) != null) {
                j2 = c2.p();
            } else {
                j2 = 0;
            }
            handler.postDelayed(runnable, j2);
        }
        t81 t81Var = new t81(getContext());
        mr0 mr0Var3 = this.e;
        this.g = (mr0Var3 == null || (pr0Var = mr0Var3.j) == null || (rr0Var = pr0Var.i) == null || (r6 = rr0Var.E) == null) ? "0" : "0";
        t81Var.i(new i(z));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(jp0.a(), "NadRewardVideoLpRuntime.getUIProvider()");
        double dimension = 1 - (resources.getDimension(a2.s()) / h61.c.c(getContext()));
        mr0 mr0Var4 = this.e;
        if (mr0Var4 != null) {
            str2 = mr0Var4.f();
        } else {
            str2 = null;
        }
        mr0 mr0Var5 = this.e;
        if (mr0Var5 != null && (gr0Var3 = mr0Var5.f) != null) {
            str3 = gr0Var3.d;
        } else {
            str3 = null;
        }
        b91 b91Var = new b91(str2, dimension, 0, str3);
        b91Var.J(true);
        b91Var.I(false);
        b91Var.M(true);
        b91Var.L(!z);
        b91Var.A(z);
        b91Var.B(z);
        b91Var.C(true);
        mr0 mr0Var6 = this.e;
        if (mr0Var6 != null && (gr0Var2 = mr0Var6.f) != null) {
            str4 = gr0Var2.m;
        } else {
            str4 = null;
        }
        if (!TextUtils.isEmpty(str4)) {
            mr0 mr0Var7 = this.e;
            if (mr0Var7 != null && (gr0Var = mr0Var7.f) != null) {
                str5 = gr0Var.l;
            }
            b91Var.z(str5);
        }
        Unit unit = Unit.INSTANCE;
        t81Var.h(b91Var);
        t81Var.j();
        this.h = System.currentTimeMillis();
        Unit unit2 = Unit.INSTANCE;
        this.d = t81Var;
        if (getLottieGuideView().isAnimating()) {
            getLottieGuideView().cancelAnimation();
        }
        Function1<? super Boolean, Unit> function1 = this.j;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
    }

    public final void z() {
        String str;
        boolean z;
        Boolean bool;
        pr0 pr0Var;
        rr0 rr0Var;
        pr0 pr0Var2;
        rr0 rr0Var2;
        pr0 pr0Var3;
        rr0 rr0Var3;
        if (!this.f) {
            mr0 mr0Var = this.e;
            String str2 = null;
            if (mr0Var != null && (pr0Var3 = mr0Var.j) != null && (rr0Var3 = pr0Var3.i) != null) {
                str = rr0Var3.B;
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
                mr0 mr0Var2 = this.e;
                if (mr0Var2 != null && (pr0Var2 = mr0Var2.j) != null && (rr0Var2 = pr0Var2.i) != null) {
                    bool = rr0Var2.D;
                } else {
                    bool = null;
                }
                if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    mr0 mr0Var3 = this.e;
                    if (mr0Var3 != null && (pr0Var = mr0Var3.j) != null && (rr0Var = pr0Var.i) != null) {
                        str2 = rr0Var.B;
                    }
                    Context context = getContext();
                    if (str2 != null) {
                        i2 = str2.hashCode();
                    }
                    LottieCompositionFactory.fromUrl(context, str2, String.valueOf(i2)).addListener(new j()).addFailureListener(new k());
                    getLottieGuideView().playAnimation();
                    postDelayed(this.i, 4500L);
                }
            }
        }
    }
}
