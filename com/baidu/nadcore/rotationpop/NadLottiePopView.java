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
import com.baidu.tieba.gk0;
import com.baidu.tieba.hj0;
import com.baidu.tieba.hk0;
import com.baidu.tieba.jy0;
import com.baidu.tieba.my0;
import com.baidu.tieba.o11;
import com.baidu.tieba.o21;
import com.baidu.tieba.p11;
import com.baidu.tieba.r21;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002abB'\b\u0007\u0012\u0006\u0010[\u001a\u00020Z\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\\\u0012\b\b\u0002\u0010^\u001a\u00020/¢\u0006\u0004\b_\u0010`J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0011J\u0019\u0010\u0019\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u000bJ\r\u0010\u001c\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u000bJ\r\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u000bJ\r\u0010\u001e\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u000bJ\r\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010\u000bJ\r\u0010 \u001a\u00020\t¢\u0006\u0004\b \u0010\u000bJ\u0017\u0010!\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b!\u0010\u0011J\u0015\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b&\u0010\u0011J\u0015\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b+\u0010\u0011J\u0015\u0010,\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b,\u0010\u0011J\u0017\u0010-\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b-\u0010\u0011J\r\u0010.\u001a\u00020\t¢\u0006\u0004\b.\u0010\u000bJ\u0015\u00100\u001a\u00020\t2\u0006\u0010(\u001a\u00020/¢\u0006\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001d\u0010:\u001a\u0002058B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001d\u0010?\u001a\u00020;8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u00107\u001a\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010F\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010AR\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u001f\u0010P\u001a\u0004\u0018\u00010L8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u00107\u001a\u0004\bN\u0010OR\u001d\u0010U\u001a\u00020Q8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u00107\u001a\u0004\bS\u0010TR\u0018\u0010W\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010Y\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010G¨\u0006c"}, d2 = {"Lcom/baidu/nadcore/rotationpop/NadLottiePopView;", "android/view/View$OnClickListener", "Landroid/widget/RelativeLayout;", "Lcom/baidu/nadcore/rotationpop/NadLottiePopParams;", "params", "", "checkCanShow", "(Lcom/baidu/nadcore/rotationpop/NadLottiePopParams;)Z", "checkDataValid", "", "hide", "()V", "hideAnim", "hideWithoutAnim", "isHitUpgradeClickExp", "()Z", "loadImage", "(Lcom/baidu/nadcore/rotationpop/NadLottiePopParams;)V", "Landroid/graphics/Bitmap;", "bitmap", "loadLottie", "(Lcom/baidu/nadcore/rotationpop/NadLottiePopParams;Landroid/graphics/Bitmap;)V", "loadText", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "pauseHideDelayTimer", "pauseShowDelayTimer", "release", "reset", "resumeHideDelayTimer", "resumeShowDelayTimer", "setBgColor", "Lcom/baidu/nadcore/rotationpop/NadLottiePopView$DefaultViewActionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setBusinessActionListener", "(Lcom/baidu/nadcore/rotationpop/NadLottiePopView$DefaultViewActionListener;)V", "setCountDownTimer", "", "progress", "setLottieProgress", "(F)V", "setLpParams", "setParams", "showAnim", "startShowDelayTimer", "", "updatePlayerProgress", "(I)V", "Lcom/baidu/nadcore/rotationpop/NadLottiePopView$IViewActionListener;", "actionListener", "Lcom/baidu/nadcore/rotationpop/NadLottiePopView$IViewActionListener;", "Lcom/baidu/nadcore/widget/AdImageView;", "bgView$delegate", "Lkotlin/Lazy;", "getBgView", "()Lcom/baidu/nadcore/widget/AdImageView;", "bgView", "Landroid/widget/FrameLayout;", "container$delegate", "getContainer", "()Landroid/widget/FrameLayout;", "container", "hasTriedToShow", "Z", "Landroid/animation/ObjectAnimator;", "hideAnimator", "Landroid/animation/ObjectAnimator;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "hideCountDownTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "loadLottieSuccess", "", "lottieShowMode", "Ljava/lang/String;", "Landroid/widget/TextView;", "lottieText$delegate", "getLottieText", "()Landroid/widget/TextView;", "lottieText", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieView$delegate", "getLottieView", "()Lcom/airbnb/lottie/LottieAnimationView;", "lottieView", "Landroid/animation/AnimatorSet;", "showAnimatorSet", "Landroid/animation/AnimatorSet;", "showCountDownTimer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DefaultViewActionListener", "IViewActionListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadLottiePopView extends RelativeLayout implements View.OnClickListener {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public boolean e;
    public e f;
    public o21 g;
    public o21 h;
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
            NadLottiePopView.this.x();
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
                if (!(tag instanceof jy0)) {
                    tag = null;
                }
                jy0 jy0Var = (jy0) tag;
                if (jy0Var != null) {
                    ViewGroup.LayoutParams layoutParams2 = NadLottiePopView.this.getContainer().getLayoutParams();
                    if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                        layoutParams = layoutParams2;
                    }
                    RelativeLayout.LayoutParams layoutParams3 = layoutParams;
                    if (layoutParams3 != null) {
                        float f = width;
                        layoutParams3.width = MathKt__MathJVMKt.roundToInt(jy0Var.n() * f);
                        layoutParams3.height = MathKt__MathJVMKt.roundToInt(f * jy0Var.n() * (1 / jy0Var.m()));
                        if (layoutParams3 != null) {
                            NadLottiePopView.this.getContainer().setLayoutParams(layoutParams3);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements hk0 {
        public final /* synthetic */ jy0 b;

        public f(jy0 jy0Var) {
            this.b = jy0Var;
        }

        @Override // com.baidu.tieba.hk0
        public void a() {
            NadLottiePopView.this.s(this.b, null);
        }

        @Override // com.baidu.tieba.hk0
        public void b(Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            NadLottiePopView.this.s(this.b, bitmap);
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements LottieOnCompositionLoadedListener {
        public final /* synthetic */ jy0 b;
        public final /* synthetic */ Bitmap c;

        public g(jy0 jy0Var, Bitmap bitmap) {
            this.b = jy0Var;
            this.c = bitmap;
        }

        @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
        public final void onCompositionLoaded(LottieComposition lottieComposition) {
            Bitmap bitmap;
            Intrinsics.checkNotNullExpressionValue(lottieComposition, "lottieComposition");
            LottieImageAsset lottieImageAsset = (LottieImageAsset) my0.b(lottieComposition.getImages(), this.b.e());
            if (lottieImageAsset != null && (bitmap = this.c) != null && !bitmap.isRecycled()) {
                NadLottiePopView.this.getLottieView().updateBitmap(this.b.e(), o11.a(this.c, lottieImageAsset.getWidth(), lottieImageAsset.getHeight(), true));
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
    public static final class i extends o21.b {
        public final /* synthetic */ jy0 b;

        public i(jy0 jy0Var) {
            this.b = jy0Var;
        }

        @Override // com.baidu.tieba.o21.b
        public void b() {
            if (!NadLottiePopView.this.l(this.b)) {
                return;
            }
            NadLottiePopView.this.y(this.b);
            o21 o21Var = NadLottiePopView.this.h;
            if (o21Var != null) {
                o21Var.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class j extends o21.b {
        public j() {
        }

        @Override // com.baidu.tieba.o21.b
        public void b() {
            NadLottiePopView.this.o();
        }
    }

    /* loaded from: classes3.dex */
    public static final class k extends o21 {
        public k(jy0 jy0Var, long j, long j2) {
            super(j, j2);
        }
    }

    /* loaded from: classes3.dex */
    public static final class l extends o21 {
        public l(jy0 jy0Var, long j, long j2) {
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
        if (q()) {
            setClickable(false);
            setFocusable(false);
            setFocusableInTouchMode(false);
            getContainer().setOnClickListener(this);
            TextView lottieText = getLottieText();
            if (lottieText != null) {
                lottieText.setOnClickListener(this);
            }
        } else {
            setOnClickListener(this);
            getContainer().setOnClickListener(this);
            TextView lottieText2 = getLottieText();
            if (lottieText2 != null) {
                lottieText2.setOnClickListener(this);
            }
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

    public final void s(jy0 jy0Var, Bitmap bitmap) {
        getLottieView().setAnimationFromUrl(jy0Var.g());
        getLottieView().addLottieOnCompositionLoadedListener(new g(jy0Var, bitmap));
        getLottieView().setFailureListener(new h());
    }

    private final void setBgColor(jy0 jy0Var) {
        int a2 = p11.a(jy0Var.a(), R.color.nad_rotation_pop_bg_color);
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

    private final void setLpParams(jy0 jy0Var) {
        ViewGroup.LayoutParams layoutParams = getContainer().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            r21.e(layoutParams2, jy0Var.f());
            r21.d(getContext(), layoutParams2, jy0Var.k());
            if (layoutParams2 != null) {
                getContainer().setLayoutParams(layoutParams2);
            }
        }
    }

    public final boolean l(jy0 jy0Var) {
        e eVar;
        if (m(jy0Var) && this.e && (eVar = this.f) != null && eVar.c()) {
            return true;
        }
        return false;
    }

    public final boolean m(jy0 jy0Var) {
        boolean z;
        String g2 = jy0Var.g();
        if (g2 != null && !StringsKt__StringsJVMKt.isBlank(g2)) {
            z = false;
        } else {
            z = true;
        }
        if (z || jy0Var.l() < 0) {
            return false;
        }
        return true;
    }

    public final void r(jy0 jy0Var) {
        getBgView().r(jy0Var.b());
        if (StringsKt__StringsJVMKt.isBlank(jy0Var.c())) {
            s(jy0Var, null);
        } else {
            gk0.a().c(jy0Var.c(), new f(jy0Var));
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

    public final void setParams(jy0 params) {
        Intrinsics.checkNotNullParameter(params, "params");
        getContainer().setTag(params);
        this.j = params.h();
        setBgColor(params);
        setLpParams(params);
        r(params);
        t(params);
        setCountDownTimer(params);
    }

    public final void t(jy0 jy0Var) {
        boolean z;
        TextView lottieText = getLottieText();
        if (lottieText != null) {
            if (jy0Var.j().length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                lottieText.setVisibility(8);
                return;
            }
            lottieText.setText(jy0Var.j());
            lottieText.setVisibility(0);
        }
    }

    private final void setCountDownTimer(jy0 jy0Var) {
        k kVar = new k(jy0Var, jy0Var.l() * 1000, 1000L);
        kVar.d(new i(jy0Var));
        Unit unit = Unit.INSTANCE;
        this.g = kVar;
        l lVar = new l(jy0Var, jy0Var.d() * 1000, 1000L);
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

    public final void y(jy0 jy0Var) {
        float f2 = 0.0f;
        getContainer().setAlpha(0.0f);
        getContainer().setScaleX(0.5f);
        getContainer().setScaleY(0.5f);
        if (Intrinsics.areEqual(jy0Var.h(), "follow")) {
            f2 = jy0Var.i();
        }
        getLottieView().setProgress(f2);
        setVisibility(0);
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public final void z(int i2) {
        Object tag = getContainer().getTag();
        if (!(tag instanceof jy0)) {
            tag = null;
        }
        jy0 jy0Var = (jy0) tag;
        if (jy0Var != null && i2 >= jy0Var.l() && l(jy0Var)) {
            if (!q()) {
                if (this.i) {
                    return;
                }
                this.i = true;
            }
            y(jy0Var);
            o21 o21Var = this.h;
            if (o21Var != null) {
                o21Var.e();
            }
        }
    }

    public final void n() {
        if (getVisibility() == 0) {
            o();
        }
    }

    public final void o() {
        ObjectAnimator objectAnimator = this.l;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    public final void p() {
        if (getVisibility() == 0) {
            setVisibility(8);
            e eVar = this.f;
            if (eVar != null) {
                eVar.onHidden();
            }
            x();
        }
    }

    public final boolean q() {
        if (hj0.b().a().a("flow_video_rotation_click_upgrade", 0) != 1) {
            return false;
        }
        return true;
    }

    public final void u() {
        x();
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

    public final void x() {
        this.i = false;
        o21 o21Var = this.g;
        if (o21Var != null) {
            o21Var.a();
        }
        o21 o21Var2 = this.h;
        if (o21Var2 != null) {
            o21Var2.a();
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
