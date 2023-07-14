package com.baidu.nadcore.rotationpop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a71;
import com.baidu.tieba.b81;
import com.baidu.tieba.rp0;
import com.baidu.tieba.sp0;
import com.baidu.tieba.w31;
import com.baidu.tieba.y71;
import com.baidu.tieba.z31;
import com.baidu.tieba.z61;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002_`B'\b\u0007\u0012\u0006\u0010Y\u001a\u00020X\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010Z\u0012\b\b\u0002\u0010\\\u001a\u00020-¢\u0006\u0004\b]\u0010^J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u000fJ\u0019\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u000bJ\r\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u000bJ\r\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u000bJ\r\u0010\u001c\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u000bJ\r\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u000bJ\r\u0010\u001e\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u000bJ\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001f\u0010\u000fJ\u0015\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b$\u0010\u000fJ\u0015\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b)\u0010\u000fJ\u0015\u0010*\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b*\u0010\u000fJ\u0017\u0010+\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b+\u0010\u000fJ\r\u0010,\u001a\u00020\t¢\u0006\u0004\b,\u0010\u000bJ\u0015\u0010.\u001a\u00020\t2\u0006\u0010&\u001a\u00020-¢\u0006\u0004\b.\u0010/R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001d\u00108\u001a\u0002038B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001d\u0010=\u001a\u0002098B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010A\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010?R\u0016\u0010H\u001a\u00020G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u001f\u0010N\u001a\u0004\u0018\u00010J8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u00105\u001a\u0004\bL\u0010MR\u001d\u0010S\u001a\u00020O8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u00105\u001a\u0004\bQ\u0010RR\u0018\u0010U\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010W\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010E¨\u0006a"}, d2 = {"Lcom/baidu/nadcore/rotationpop/NadLottiePopView;", "android/view/View$OnClickListener", "Landroid/widget/RelativeLayout;", "Lcom/baidu/nadcore/rotationpop/NadLottiePopParams;", "params", "", "checkCanShow", "(Lcom/baidu/nadcore/rotationpop/NadLottiePopParams;)Z", "checkDataValid", "", "hide", "()V", "hideAnim", "hideWithoutAnim", "loadImage", "(Lcom/baidu/nadcore/rotationpop/NadLottiePopParams;)V", "Landroid/graphics/Bitmap;", "bitmap", "loadLottie", "(Lcom/baidu/nadcore/rotationpop/NadLottiePopParams;Landroid/graphics/Bitmap;)V", "loadText", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "pauseHideDelayTimer", "pauseShowDelayTimer", "release", "reset", "resumeHideDelayTimer", "resumeShowDelayTimer", "setBgColor", "Lcom/baidu/nadcore/rotationpop/NadLottiePopView$DefaultViewActionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setBusinessActionListener", "(Lcom/baidu/nadcore/rotationpop/NadLottiePopView$DefaultViewActionListener;)V", "setCountDownTimer", "", "progress", "setLottieProgress", "(F)V", "setLpParams", "setParams", "showAnim", "startShowDelayTimer", "", "updatePlayerProgress", "(I)V", "Lcom/baidu/nadcore/rotationpop/NadLottiePopView$IViewActionListener;", "actionListener", "Lcom/baidu/nadcore/rotationpop/NadLottiePopView$IViewActionListener;", "Lcom/baidu/nadcore/widget/AdImageView;", "bgView$delegate", "Lkotlin/Lazy;", "getBgView", "()Lcom/baidu/nadcore/widget/AdImageView;", "bgView", "Landroid/widget/FrameLayout;", "container$delegate", "getContainer", "()Landroid/widget/FrameLayout;", "container", "hasTriedToShow", "Z", "Landroid/animation/ObjectAnimator;", "hideAnimator", "Landroid/animation/ObjectAnimator;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "hideCountDownTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "loadLottieSuccess", "", "lottieShowMode", "Ljava/lang/String;", "Landroid/widget/TextView;", "lottieText$delegate", "getLottieText", "()Landroid/widget/TextView;", "lottieText", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieView$delegate", "getLottieView", "()Lcom/airbnb/lottie/LottieAnimationView;", "lottieView", "Landroid/animation/AnimatorSet;", "showAnimatorSet", "Landroid/animation/AnimatorSet;", "showCountDownTimer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DefaultViewActionListener", "IViewActionListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadLottiePopView extends RelativeLayout implements View.OnClickListener {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public boolean e;
    public e f;
    public y71 g;
    public y71 h;
    public boolean i;
    public String j;
    public AnimatorSet k;
    public ObjectAnimator l;

    /* loaded from: classes3.dex */
    public static abstract class d implements e {
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(View view2);

        void b(View view2);

        boolean c();

        void onHidden();

        void onShown();
    }

    @JvmOverloads
    public NadLottiePopView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public NadLottiePopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final AdImageView getBgView() {
        return (AdImageView) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout getContainer() {
        return (FrameLayout) this.a.getValue();
    }

    private final TextView getLottieText() {
        return (TextView) this.d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LottieAnimationView getLottieView() {
        return (LottieAnimationView) this.c.getValue();
    }

    /* loaded from: classes3.dex */
    public static final class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation, boolean z) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (Intrinsics.areEqual(NadLottiePopView.this.j, "auto")) {
                NadLottiePopView.this.getLottieView().setRepeatCount(-1);
                NadLottiePopView.this.getLottieView().playAnimation();
            } else {
                NadLottiePopView.this.getLottieView().cancelAnimation();
            }
            e eVar = NadLottiePopView.this.f;
            if (eVar != null) {
                eVar.onShown();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            NadLottiePopView.this.setVisibility(8);
            e eVar = NadLottiePopView.this.f;
            if (eVar != null) {
                eVar.onHidden();
            }
            NadLottiePopView.this.t();
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NadLottiePopView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ViewParent parent = NadLottiePopView.this.getParent();
            RelativeLayout.LayoutParams layoutParams = null;
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                int width = viewGroup.getWidth();
                Object tag = NadLottiePopView.this.getContainer().getTag();
                if (!(tag instanceof w31)) {
                    tag = null;
                }
                w31 w31Var = (w31) tag;
                if (w31Var != null) {
                    ViewGroup.LayoutParams layoutParams2 = NadLottiePopView.this.getContainer().getLayoutParams();
                    if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                        layoutParams = layoutParams2;
                    }
                    RelativeLayout.LayoutParams layoutParams3 = layoutParams;
                    if (layoutParams3 != null) {
                        float f = width;
                        layoutParams3.width = MathKt__MathJVMKt.roundToInt(w31Var.n() * f);
                        layoutParams3.height = MathKt__MathJVMKt.roundToInt(f * w31Var.n() * (1 / w31Var.m()));
                        if (layoutParams3 != null) {
                            NadLottiePopView.this.getContainer().setLayoutParams(layoutParams3);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements sp0 {
        public final /* synthetic */ w31 b;

        public f(w31 w31Var) {
            this.b = w31Var;
        }

        @Override // com.baidu.tieba.sp0
        public void a() {
            NadLottiePopView.this.q(this.b, null);
        }

        @Override // com.baidu.tieba.sp0
        public void b(Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            NadLottiePopView.this.q(this.b, bitmap);
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements LottieOnCompositionLoadedListener {
        public final /* synthetic */ w31 b;
        public final /* synthetic */ Bitmap c;

        public g(w31 w31Var, Bitmap bitmap) {
            this.b = w31Var;
            this.c = bitmap;
        }

        @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
        public final void onCompositionLoaded(LottieComposition lottieComposition) {
            Bitmap bitmap;
            Intrinsics.checkNotNullExpressionValue(lottieComposition, "lottieComposition");
            LottieImageAsset lottieImageAsset = (LottieImageAsset) z31.b(lottieComposition.getImages(), this.b.e());
            if (lottieImageAsset != null && (bitmap = this.c) != null && !bitmap.isRecycled()) {
                NadLottiePopView.this.getLottieView().updateBitmap(this.b.e(), z61.a(this.c, lottieImageAsset.getWidth(), lottieImageAsset.getHeight(), true));
            }
            NadLottiePopView.this.e = true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class h<T> implements LottieListener<Throwable> {
        public h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(Throwable th) {
            NadLottiePopView.this.e = false;
        }
    }

    /* loaded from: classes3.dex */
    public static final class i extends y71.b {
        public final /* synthetic */ w31 b;

        public i(w31 w31Var) {
            this.b = w31Var;
        }

        @Override // com.baidu.tieba.y71.b
        public void b() {
            if (!NadLottiePopView.this.k(this.b)) {
                return;
            }
            NadLottiePopView.this.u(this.b);
            y71 y71Var = NadLottiePopView.this.h;
            if (y71Var != null) {
                y71Var.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class j extends y71.b {
        public j() {
        }

        @Override // com.baidu.tieba.y71.b
        public void b() {
            NadLottiePopView.this.n();
        }
    }

    /* loaded from: classes3.dex */
    public static final class k extends y71 {
        public k(w31 w31Var, long j, long j2) {
            super(j, j2);
        }
    }

    /* loaded from: classes3.dex */
    public static final class l extends y71 {
        public l(w31 w31Var, long j, long j2) {
            super(j, j2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadLottiePopView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.baidu.nadcore.rotationpop.NadLottiePopView$container$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                View findViewById = NadLottiePopView.this.findViewById(R.id.nad_rotation_pop);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.nad_rotation_pop)");
                return (FrameLayout) findViewById;
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>() { // from class: com.baidu.nadcore.rotationpop.NadLottiePopView$bgView$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdImageView invoke() {
                View findViewById = NadLottiePopView.this.findViewById(R.id.nad_rotation_pop_circle_text);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.nad_rotation_pop_circle_text)");
                return (AdImageView) findViewById;
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<LottieAnimationView>() { // from class: com.baidu.nadcore.rotationpop.NadLottiePopView$lottieView$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LottieAnimationView invoke() {
                View findViewById = NadLottiePopView.this.findViewById(R.id.nad_rotation_pop_lottie_view);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.nad_rotation_pop_lottie_view)");
                return (LottieAnimationView) findViewById;
            }
        });
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.baidu.nadcore.rotationpop.NadLottiePopView$lottieText$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) NadLottiePopView.this.findViewById(R.id.nad_rotation_pop_lottie_text);
            }
        });
        this.j = "auto";
        LayoutInflater.from(context).inflate(R.layout.nad_lottie_pop_layout, (ViewGroup) this, true);
        setOnClickListener(this);
        getContainer().setOnClickListener(this);
        TextView lottieText = getLottieText();
        if (lottieText != null) {
            lottieText.setOnClickListener(this);
        }
        setVisibility(8);
        getViewTreeObserver().addOnGlobalLayoutListener(new c());
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(getContainer(), View.ALPHA, 0.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(alphaAnimator, "alphaAnimator");
        alphaAnimator.setDuration(160L);
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(getContainer(), View.SCALE_X, 0.5f, 1.0f);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(getContainer(), View.SCALE_Y, 0.5f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(scaleXAnimator, "scaleXAnimator");
        scaleXAnimator.setDuration(160L);
        Intrinsics.checkNotNullExpressionValue(scaleYAnimator, "scaleYAnimator");
        scaleYAnimator.setDuration(160L);
        animatorSet.playTogether(alphaAnimator, scaleXAnimator, scaleYAnimator);
        animatorSet.addListener(new a());
        Unit unit = Unit.INSTANCE;
        this.k = animatorSet;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getContainer(), View.ALPHA, 1.0f, 0.0f);
        ofFloat.setDuration(160L);
        ofFloat.addListener(new b());
        Unit unit2 = Unit.INSTANCE;
        this.l = ofFloat;
    }

    public /* synthetic */ NadLottiePopView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final void q(w31 w31Var, Bitmap bitmap) {
        getLottieView().setAnimationFromUrl(w31Var.g());
        getLottieView().addLottieOnCompositionLoadedListener(new g(w31Var, bitmap));
        getLottieView().setFailureListener(new h());
    }

    private final void setBgColor(w31 w31Var) {
        int a2 = a71.a(w31Var.a(), R.color.nad_rotation_pop_bg_color);
        FrameLayout container = getContainer();
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.nad_rotation_pop_bg);
        GradientDrawable gradientDrawable = null;
        if (!(drawable instanceof GradientDrawable)) {
            drawable = null;
        }
        GradientDrawable gradientDrawable2 = (GradientDrawable) drawable;
        if (gradientDrawable2 != null) {
            gradientDrawable2.setColor(a2);
            Unit unit = Unit.INSTANCE;
            gradientDrawable = gradientDrawable2;
        }
        container.setBackground(gradientDrawable);
    }

    private final void setLpParams(w31 w31Var) {
        ViewGroup.LayoutParams layoutParams = getContainer().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            b81.e(layoutParams2, w31Var.f());
            b81.d(getContext(), layoutParams2, w31Var.k());
            if (layoutParams2 != null) {
                getContainer().setLayoutParams(layoutParams2);
            }
        }
    }

    public final boolean k(w31 w31Var) {
        e eVar;
        if (l(w31Var) && this.e && (eVar = this.f) != null && eVar.c()) {
            return true;
        }
        return false;
    }

    public final boolean l(w31 w31Var) {
        boolean z;
        String g2 = w31Var.g();
        if (g2 != null && !StringsKt__StringsJVMKt.isBlank(g2)) {
            z = false;
        } else {
            z = true;
        }
        if (z || w31Var.l() < 0) {
            return false;
        }
        return true;
    }

    public final void p(w31 w31Var) {
        getBgView().o(w31Var.b());
        if (StringsKt__StringsJVMKt.isBlank(w31Var.c())) {
            q(w31Var, null);
        } else {
            rp0.a().c(w31Var.c(), new f(w31Var));
        }
    }

    public final void r(w31 w31Var) {
        boolean z;
        TextView lottieText = getLottieText();
        if (lottieText != null) {
            if (w31Var.j().length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                lottieText.setVisibility(8);
                return;
            }
            lottieText.setText(w31Var.j());
            lottieText.setVisibility(0);
        }
    }

    public final void setBusinessActionListener(d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f = listener;
    }

    public final void setLottieProgress(float f2) {
        if (this.e) {
            getLottieView().setProgress(f2);
        }
    }

    public final void setParams(w31 params) {
        Intrinsics.checkNotNullParameter(params, "params");
        getContainer().setTag(params);
        this.j = params.h();
        setBgColor(params);
        setLpParams(params);
        p(params);
        r(params);
        setCountDownTimer(params);
    }

    public final void x(int i2) {
        Object tag = getContainer().getTag();
        if (!(tag instanceof w31)) {
            tag = null;
        }
        w31 w31Var = (w31) tag;
        if (w31Var != null && i2 >= w31Var.l() && k(w31Var) && !this.i) {
            this.i = true;
            u(w31Var);
            y71 y71Var = this.h;
            if (y71Var != null) {
                y71Var.e();
            }
        }
    }

    private final void setCountDownTimer(w31 w31Var) {
        k kVar = new k(w31Var, w31Var.l() * 1000, 1000L);
        kVar.d(new i(w31Var));
        Unit unit = Unit.INSTANCE;
        this.g = kVar;
        l lVar = new l(w31Var, w31Var.d() * 1000, 1000L);
        lVar.d(new j());
        Unit unit2 = Unit.INSTANCE;
        this.h = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Integer num;
        e eVar;
        if (view2 != null) {
            num = Integer.valueOf(view2.getId());
        } else {
            num = null;
        }
        if ((num != null && num.intValue() == R.id.nad_rotation_pop) || (num != null && num.intValue() == R.id.nad_rotation_pop_lottie_text)) {
            e eVar2 = this.f;
            if (eVar2 != null) {
                eVar2.b(view2);
                return;
            }
            return;
        }
        int id = getId();
        if (num != null && num.intValue() == id && (eVar = this.f) != null) {
            eVar.a(view2);
        }
    }

    public final void u(w31 w31Var) {
        float f2 = 0.0f;
        getContainer().setAlpha(0.0f);
        getContainer().setScaleX(0.5f);
        getContainer().setScaleY(0.5f);
        if (Intrinsics.areEqual(w31Var.h(), "follow")) {
            f2 = w31Var.i();
        }
        getLottieView().setProgress(f2);
        setVisibility(0);
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public final void m() {
        if (getVisibility() == 0) {
            n();
        }
    }

    public final void n() {
        ObjectAnimator objectAnimator = this.l;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    public final void o() {
        if (getVisibility() == 0) {
            setVisibility(8);
            e eVar = this.f;
            if (eVar != null) {
                eVar.onHidden();
            }
            t();
        }
    }

    public final void s() {
        t();
        setTag(null);
        this.g = null;
        this.h = null;
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
        }
        ObjectAnimator objectAnimator = this.l;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
        }
    }

    public final void t() {
        this.i = false;
        y71 y71Var = this.g;
        if (y71Var != null) {
            y71Var.a();
        }
        y71 y71Var2 = this.h;
        if (y71Var2 != null) {
            y71Var2.a();
        }
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        ObjectAnimator objectAnimator = this.l;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        getLottieView().cancelAnimation();
    }
}
