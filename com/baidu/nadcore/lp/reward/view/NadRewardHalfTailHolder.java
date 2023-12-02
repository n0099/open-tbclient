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
import com.baidu.tieba.bl0;
import com.baidu.tieba.cn0;
import com.baidu.tieba.dz0;
import com.baidu.tieba.ez0;
import com.baidu.tieba.in0;
import com.baidu.tieba.j41;
import com.baidu.tieba.jl0;
import com.baidu.tieba.l11;
import com.baidu.tieba.ln0;
import com.baidu.tieba.m41;
import com.baidu.tieba.ms;
import com.baidu.tieba.nn0;
import com.baidu.tieba.q41;
import com.baidu.tieba.qe0;
import com.baidu.tieba.r41;
import com.baidu.tieba.sk0;
import com.baidu.tieba.sn0;
import com.baidu.tieba.ti0;
import com.baidu.tieba.uk0;
import com.baidu.tieba.w11;
import com.baidu.tieba.xi0;
import com.baidu.tieba.xk0;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010Q\u001a\u00020P\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010R\u0012\b\b\u0002\u0010T\u001a\u00020\n¢\u0006\u0004\bU\u0010VJ9\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\fH\u0003¢\u0006\u0004\b\u0019\u0010\u0016J3\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\fH\u0014¢\u0006\u0004\b!\u0010\u0016J\u0017\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u001d\u0010(\u001a\u00020\f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0&H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\f2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\f2\u0006\u0010.\u001a\u00020*H\u0002¢\u0006\u0004\b/\u0010-J\u000f\u00100\u001a\u00020\fH\u0002¢\u0006\u0004\b0\u0010\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u00101R\u001d\u00107\u001a\u0002028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001d\u0010<\u001a\u0002088B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u00104\u001a\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u001d\u0010C\u001a\u00020?8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u00104\u001a\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010L\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010>R\u0016\u0010M\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010FR\u0016\u0010N\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006W"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardHalfTailHolder;", "Lcom/baidu/tieba/uk0;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "target", "", "from", "to", "", ms.c, "", "vis", "", "doViewAlphaAnimation", "(Landroid/view/View;FFJI)V", "", "getLogTime", "()Ljava/lang/String;", "Landroid/view/ViewGroup;", "getView", "()Landroid/view/ViewGroup;", "initArrowView", "()V", "initGuideView", "initPanelPop", "initTailInfoView", DnsModel.AREA_KEY, "Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;", "logType", PermissionStorage.PermissionItem.ITEM_EXT_1, PermissionStorage.PermissionItem.ITEM_EXT_2, "logAndCharge", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;Ljava/lang/String;)V", "onDetachedFromWindow", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setData", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "Lkotlin/Function0;", WebChromeClient.KEY_ARG_CALLBACK, "setOnReplayClickListener", "(Lkotlin/Function0;)V", "", "isVisible", "setVisibility", "(Z)V", "autoPopup", "showPanelPop", "tryShowGuideLottie", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Lcom/baidu/nadcore/widget/AdImageView;", "arrowView$delegate", "Lkotlin/Lazy;", "getArrowView", "()Lcom/baidu/nadcore/widget/AdImageView;", "arrowView", "Lcom/baidu/nadcore/lp/reward/view/NadRewardHalfTailView;", "halfTailView$delegate", "getHalfTailView", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardHalfTailView;", "halfTailView", "hasShowGuide", "Z", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieGuideView$delegate", "getLottieGuideView", "()Lcom/airbnb/lottie/LottieAnimationView;", "lottieGuideView", "Ljava/lang/Runnable;", "lottieRunnable", "Ljava/lang/Runnable;", "mLoadStartTime", "J", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "panelPop", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "shouldCharge", "shouldChargeTask", "tailNineChargeModify", "Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRewardHalfTailHolder extends FrameLayout implements uk0 {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public j41 d;
    public in0 e;
    public boolean f;
    public String g;
    public long h;
    public final Runnable i;
    public boolean j;
    public Runnable k;

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
    public static final class k<T> implements LottieListener<LottieComposition> {
        public k() {
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
                nadRewardHalfTailHolder.n(nadRewardHalfTailHolder.getLottieGuideView(), 1.0f, 0.0f, 320L, 8);
                NadRewardHalfTailHolder.this.getArrowView().setVisibility(0);
                NadRewardHalfTailHolder.this.getArrowView().bringToFront();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
                nadRewardHalfTailHolder.n(nadRewardHalfTailHolder.getLottieGuideView(), 1.0f, 0.0f, 320L, 8);
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
            nadRewardHalfTailHolder.n(nadRewardHalfTailHolder.getLottieGuideView(), 0.0f, 1.0f, 320L, 0);
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
            String str;
            ln0 ln0Var;
            nn0 nn0Var;
            if (jl0.a.f()) {
                in0 in0Var = NadRewardHalfTailHolder.this.e;
                if (in0Var != null && (ln0Var = in0Var.j) != null && (nn0Var = ln0Var.i) != null) {
                    str = nn0Var.h();
                } else {
                    str = null;
                }
                qe0.c(str, NadRewardHalfTailHolder.this.getContext());
            } else {
                NadRewardHalfTailHolder.this.u(false);
            }
            NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
            String str2 = ClogBuilder.Area.ARROW.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.ARROW.type");
            NadRewardHalfTailHolder.t(nadRewardHalfTailHolder, str2, ClogBuilder.LogType.CLICK, null, null, 12, null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends xi0<m41> {
        public c(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi0
        public void onEvent(m41 event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.a == 0 && NadRewardHalfTailHolder.this.getLottieGuideView().isAnimating()) {
                NadRewardHalfTailHolder.this.getLottieGuideView().cancelAnimation();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements sk0 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public d() {
        }

        @Override // com.baidu.tieba.sk0
        public boolean a(String area, ClogBuilder.LogType logType, String str) {
            Intrinsics.checkNotNullParameter(area, "area");
            Intrinsics.checkNotNullParameter(logType, "logType");
            if (TextUtils.equals(area, "morebtn") || TextUtils.equals(area, "replaybtn")) {
                return false;
            }
            if (jl0.a.f() || !jl0.a.b(str)) {
                qe0.c(str, NadRewardHalfTailHolder.this.getContext());
            } else {
                NadRewardHalfTailHolder.this.u(false);
            }
            NadRewardHalfTailHolder.t(NadRewardHalfTailHolder.this, area, logType, null, null, 12, null);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements View.OnTouchListener {
        public float a;
        public float b;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            boolean z;
            ln0 ln0Var;
            nn0 nn0Var;
            ln0 ln0Var2;
            nn0 nn0Var2;
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
                        String str = null;
                        if (jl0.a.f()) {
                            in0 in0Var = NadRewardHalfTailHolder.this.e;
                            if (in0Var != null && (ln0Var2 = in0Var.j) != null && (nn0Var2 = ln0Var2.i) != null) {
                                str = nn0Var2.h();
                            }
                            qe0.c(str, NadRewardHalfTailHolder.this.getContext());
                        } else {
                            in0 in0Var2 = NadRewardHalfTailHolder.this.e;
                            if (in0Var2 != null && (ln0Var = in0Var2.j) != null && (nn0Var = ln0Var.i) != null) {
                                str = nn0Var.g;
                            }
                            if (!jl0.a.b(str)) {
                                qe0.c(str, NadRewardHalfTailHolder.this.getContext());
                            } else {
                                NadRewardHalfTailHolder.this.u(false);
                            }
                        }
                        NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
                        String str2 = ClogBuilder.Area.SWIPE_UP.type;
                        Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.SWIPE_UP.type");
                        NadRewardHalfTailHolder.t(nadRewardHalfTailHolder, str2, ClogBuilder.LogType.CLICK, null, null, 12, null);
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
    public static final class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NadRewardHalfTailHolder.this.getLottieGuideView().cancelAnimation();
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
            String str = ClogBuilder.Area.AD_BLANK.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.AD_BLANK.type");
            NadRewardHalfTailHolder.t(nadRewardHalfTailHolder, str, ClogBuilder.LogType.FREE_CLICK, null, null, 12, null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public h() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
            if (r9 != false) goto L52;
         */
        @Override // android.view.animation.Animation.AnimationListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onAnimationEnd(Animation animation) {
            Boolean bool;
            String str;
            Long l;
            sn0 c;
            ln0 ln0Var;
            nn0 nn0Var;
            ln0 ln0Var2;
            nn0 nn0Var2;
            String str2;
            boolean z;
            ln0 ln0Var3;
            nn0 nn0Var3;
            Intrinsics.checkNotNullParameter(animation, "animation");
            NadRewardHalfTailHolder.this.v();
            List<MonitorUrl> list = null;
            if (!NadRewardHalfTailHolder.this.f) {
                in0 in0Var = NadRewardHalfTailHolder.this.e;
                if (in0Var != null && (ln0Var3 = in0Var.j) != null && (nn0Var3 = ln0Var3.i) != null) {
                    str2 = nn0Var3.C;
                } else {
                    str2 = null;
                }
                if (str2 != null && str2.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
            }
            NadRewardHalfTailHolder.this.getArrowView().setVisibility(0);
            in0 in0Var2 = NadRewardHalfTailHolder.this.e;
            if (in0Var2 != null && (ln0Var2 = in0Var2.j) != null && (nn0Var2 = ln0Var2.i) != null) {
                bool = nn0Var2.E;
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                if (jl0.a.f()) {
                    in0 in0Var3 = NadRewardHalfTailHolder.this.e;
                    if (in0Var3 != null && (ln0Var = in0Var3.j) != null && (nn0Var = ln0Var.i) != null) {
                        str = nn0Var.f;
                    } else {
                        str = null;
                    }
                    in0 in0Var4 = NadRewardHalfTailHolder.this.e;
                    if (in0Var4 != null && (c = in0Var4.c()) != null) {
                        l = Long.valueOf(c.r());
                    } else {
                        l = null;
                    }
                    in0 in0Var5 = NadRewardHalfTailHolder.this.e;
                    if (in0Var5 != null) {
                        list = in0Var5.e;
                    }
                    qe0.c(l11.c(str, l, list), NadRewardHalfTailHolder.this.getContext());
                } else {
                    NadRewardHalfTailHolder.this.u(true);
                }
                NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
                String str3 = ClogBuilder.Area.SWIPE_UP.type;
                Intrinsics.checkNotNullExpressionValue(str3, "ClogBuilder.Area.SWIPE_UP.type");
                NadRewardHalfTailHolder.t(nadRewardHalfTailHolder, str3, ClogBuilder.LogType.FREE_CLICK, null, null, 12, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NadRewardHalfTailHolder.this.j = true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class j implements q41 {
        public final /* synthetic */ boolean b;

        public j(boolean z) {
            this.b = z;
        }

        @Override // com.baidu.tieba.q41
        public void a() {
            NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
            String str = ClogBuilder.Area.DOWN_ARROW.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.DOWN_ARROW.type");
            NadRewardHalfTailHolder.t(nadRewardHalfTailHolder, str, ClogBuilder.LogType.FREE_CLICK, null, null, 12, null);
        }

        @Override // com.baidu.tieba.q41
        public void d() {
            NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
            String str = ClogBuilder.Area.AD_BLANK.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.AD_BLANK.type");
            NadRewardHalfTailHolder.t(nadRewardHalfTailHolder, str, ClogBuilder.LogType.FREE_CLICK, null, null, 12, null);
        }

        @Override // com.baidu.tieba.q41
        public void b() {
            if (!this.b) {
                return;
            }
            if ((TextUtils.equals(NadRewardHalfTailHolder.this.g, "1") || TextUtils.equals(NadRewardHalfTailHolder.this.g, "2")) && NadRewardHalfTailHolder.this.j) {
                NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                nadRewardHalfTailHolder.s(str, ClogBuilder.LogType.CLICK, NadRewardHalfTailHolder.this.getLogTime(), "1");
                return;
            }
            NadRewardHalfTailHolder nadRewardHalfTailHolder2 = NadRewardHalfTailHolder.this;
            String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
            nadRewardHalfTailHolder2.s(str2, ClogBuilder.LogType.FREE_CLICK, NadRewardHalfTailHolder.this.getLogTime(), "1");
        }

        @Override // com.baidu.tieba.q41
        public void c() {
            if (!this.b) {
                return;
            }
            if (TextUtils.equals(NadRewardHalfTailHolder.this.g, "2") && NadRewardHalfTailHolder.this.j) {
                NadRewardHalfTailHolder nadRewardHalfTailHolder = NadRewardHalfTailHolder.this;
                String str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                nadRewardHalfTailHolder.s(str, ClogBuilder.LogType.CLICK, NadRewardHalfTailHolder.this.getLogTime(), "2");
            }
            if (TextUtils.equals(NadRewardHalfTailHolder.this.g, "1")) {
                NadRewardHalfTailHolder nadRewardHalfTailHolder2 = NadRewardHalfTailHolder.this;
                String str2 = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.REWARD_LANDING_PAGE.type");
                nadRewardHalfTailHolder2.s(str2, ClogBuilder.LogType.FREE_CLICK, NadRewardHalfTailHolder.this.getLogTime(), "2");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class l<T> implements LottieListener<Throwable> {
        public l() {
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
        this.i = new f();
        this.k = new i();
        LayoutInflater.from(context).inflate(R.layout.nad_reward_half_tail_holder, this);
    }

    public /* synthetic */ NadRewardHalfTailHolder(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final void n(View view2, float f2, float f3, long j2, int i2) {
        if (view2 != null) {
            view2.setAlpha(f2);
            view2.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
            alphaAnimation.setDuration(j2);
            view2.startAnimation(alphaAnimation);
            alphaAnimation.setAnimationListener(new a(view2, f2, f3, j2, i2));
        }
    }

    @Override // com.baidu.tieba.uk0
    public void setData(in0 adModel) {
        Intrinsics.checkNotNullParameter(adModel, "adModel");
        this.e = adModel;
        r();
        o();
        p();
        q();
        setOnClickListener(new g());
    }

    @Override // com.baidu.tieba.uk0
    public void setOnReplayClickListener(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        getHalfTailView().setOnReplayClickListener(callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getLogTime() {
        return String.valueOf((System.currentTimeMillis() - this.h) / 1000);
    }

    @Override // com.baidu.tieba.uk0
    public ViewGroup getView() {
        return getHalfTailView();
    }

    public final void o() {
        getArrowView().setOnClickListener(new b());
        getArrowView().setImageResource(R.drawable.nad_reward_up_arrow);
        getArrowView().bringToFront();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.i);
        getHalfTailView().k();
        ti0.a().a(this);
    }

    public final void q() {
        if (!jl0.a.f()) {
            return;
        }
        ti0.a().c(this, new c(m41.class));
    }

    public static /* synthetic */ void t(NadRewardHalfTailHolder nadRewardHalfTailHolder, String str, ClogBuilder.LogType logType, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        if ((i2 & 8) != 0) {
            str3 = "";
        }
        nadRewardHalfTailHolder.s(str, logType, str2, str3);
    }

    public final void p() {
        ViewGroup.LayoutParams layoutParams = getLottieGuideView().getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = (((w11.c.f(getContext()) - w11.c.h()) - w11.c.a(getContext(), 47.0f)) - w11.c.a(getContext(), 472.0f)) - w11.c.a(getContext(), 135.0f);
            getLottieGuideView().setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void r() {
        getHalfTailView().setVisibility(8);
        getHalfTailView().setData(this.e);
        getHalfTailView().setBackgroundResource(R.drawable.nad_reward_half_tail_bg);
        getHalfTailView().i(new d());
        getHalfTailView().setClickable(true);
        getHalfTailView().setOnTouchListener(new e());
    }

    public final void s(String str, ClogBuilder.LogType logType, String str2, String str3) {
        String str4;
        boolean z;
        boolean z2;
        in0 in0Var;
        List<MonitorUrl> list;
        boolean z3;
        cn0 cn0Var;
        ClogBuilder u = new ClogBuilder().j(str).y(logType).u(ClogBuilder.Page.WELFARETAIL);
        in0 in0Var2 = this.e;
        if (in0Var2 != null && (cn0Var = in0Var2.f) != null) {
            str4 = cn0Var.d;
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
        dz0.e(p);
        if (logType == ClogBuilder.LogType.CLICK && (in0Var = this.e) != null && (list = in0Var.e) != null) {
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
                ez0.b(monitorUrl.clickUrl);
            }
        }
    }

    @Override // com.baidu.tieba.uk0
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
            in0 in0Var = this.e;
            if (in0Var != null) {
                getHalfTailView().setMoreButton(in0Var);
            }
            getHalfTailView().setVisibility(0);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(320L);
            translateAnimation.setAnimationListener(new h());
            getHalfTailView().startAnimation(translateAnimation);
            return;
        }
        j41 j41Var = this.d;
        if (j41Var != null) {
            j41Var.f();
        }
        getHalfTailView().setVisibility(8);
    }

    public final void u(boolean z) {
        String str;
        boolean z2;
        xk0 a2;
        String str2;
        String str3;
        String str4;
        cn0 cn0Var;
        cn0 cn0Var2;
        cn0 cn0Var3;
        ln0 ln0Var;
        nn0 nn0Var;
        Handler handler;
        long j2;
        sn0 c2;
        in0 in0Var = this.e;
        String str5 = null;
        if (in0Var != null) {
            str = in0Var.f();
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
            Runnable runnable = this.k;
            in0 in0Var2 = this.e;
            if (in0Var2 != null && (c2 = in0Var2.c()) != null) {
                j2 = c2.r();
            } else {
                j2 = 0;
            }
            handler.postDelayed(runnable, j2);
        }
        j41 j41Var = new j41(getContext());
        in0 in0Var3 = this.e;
        this.g = (in0Var3 == null || (ln0Var = in0Var3.j) == null || (nn0Var = ln0Var.i) == null || (r6 = nn0Var.F) == null) ? "0" : "0";
        j41Var.j(new j(z));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(bl0.a(), "NadRewardVideoLpRuntime.getUIProvider()");
        double dimension = 1 - (resources.getDimension(a2.w()) / w11.c.c(getContext()));
        in0 in0Var4 = this.e;
        if (in0Var4 != null) {
            str2 = in0Var4.f();
        } else {
            str2 = null;
        }
        in0 in0Var5 = this.e;
        if (in0Var5 != null && (cn0Var3 = in0Var5.f) != null) {
            str3 = cn0Var3.d;
        } else {
            str3 = null;
        }
        r41 r41Var = new r41(str2, dimension, 0, str3);
        r41Var.O(true);
        r41Var.N(false);
        r41Var.R(true);
        r41Var.Q(!z);
        r41Var.F(z);
        r41Var.G(z);
        r41Var.H(true);
        in0 in0Var6 = this.e;
        if (in0Var6 != null && (cn0Var2 = in0Var6.f) != null) {
            str4 = cn0Var2.l;
        } else {
            str4 = null;
        }
        if (!TextUtils.isEmpty(str4)) {
            in0 in0Var7 = this.e;
            if (in0Var7 != null && (cn0Var = in0Var7.f) != null) {
                str5 = cn0Var.k;
            }
            r41Var.E(str5);
        }
        Unit unit = Unit.INSTANCE;
        j41Var.i(r41Var);
        j41Var.k();
        this.h = System.currentTimeMillis();
        Unit unit2 = Unit.INSTANCE;
        this.d = j41Var;
        if (getLottieGuideView().isAnimating()) {
            getLottieGuideView().cancelAnimation();
        }
    }

    public final void v() {
        String str;
        boolean z;
        Boolean bool;
        ln0 ln0Var;
        nn0 nn0Var;
        ln0 ln0Var2;
        nn0 nn0Var2;
        ln0 ln0Var3;
        nn0 nn0Var3;
        if (!this.f) {
            in0 in0Var = this.e;
            String str2 = null;
            if (in0Var != null && (ln0Var3 = in0Var.j) != null && (nn0Var3 = ln0Var3.i) != null) {
                str = nn0Var3.C;
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
                in0 in0Var2 = this.e;
                if (in0Var2 != null && (ln0Var2 = in0Var2.j) != null && (nn0Var2 = ln0Var2.i) != null) {
                    bool = nn0Var2.E;
                } else {
                    bool = null;
                }
                if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    in0 in0Var3 = this.e;
                    if (in0Var3 != null && (ln0Var = in0Var3.j) != null && (nn0Var = ln0Var.i) != null) {
                        str2 = nn0Var.C;
                    }
                    Context context = getContext();
                    if (str2 != null) {
                        i2 = str2.hashCode();
                    }
                    LottieCompositionFactory.fromUrl(context, str2, String.valueOf(i2)).addListener(new k()).addFailureListener(new l());
                    getLottieGuideView().playAnimation();
                    postDelayed(this.i, 4500L);
                }
            }
        }
    }
}
