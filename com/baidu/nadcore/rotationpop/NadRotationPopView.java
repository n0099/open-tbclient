package com.baidu.nadcore.rotationpop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.baidu.nadcore.rotationpop.NadRotationPopView;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.b31;
import com.baidu.tieba.c31;
import com.baidu.tieba.i31;
import com.baidu.tieba.js0;
import com.baidu.tieba.k61;
import com.baidu.tieba.k71;
import com.baidu.tieba.n71;
import com.baidu.tieba.so0;
import com.baidu.tieba.tn0;
import com.baidu.tieba.to0;
import com.baidu.tieba.x41;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002]^B'\b\u0007\u0012\u0006\u0010W\u001a\u00020V\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010X\u0012\b\b\u0002\u0010Z\u001a\u00020*¢\u0006\u0004\b[\u0010\\J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u000bJ\r\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u000bJ\r\u0010\u001c\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u000bJ\r\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u000bJ\r\u0010\u001e\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u000bJ\r\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010\u000bJ\u0015\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b$\u0010\u0011J\u0017\u0010%\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b%\u0010\u0011J\u0017\u0010&\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b&\u0010\u0011J\u0017\u0010'\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b'\u0010\u0011J\u0017\u0010(\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b(\u0010\u0011J\r\u0010)\u001a\u00020\t¢\u0006\u0004\b)\u0010\u000bJ\u0015\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-R\u0018\u0010.\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001d\u00105\u001a\u0002008B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00107R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00107R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u001d\u0010G\u001a\u00020C8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u00102\u001a\u0004\bE\u0010FR\u001d\u0010L\u001a\u00020H8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u00102\u001a\u0004\bJ\u0010KR\u001d\u0010Q\u001a\u00020M8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u00102\u001a\u0004\bO\u0010PR\u0018\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010U\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010>¨\u0006_"}, d2 = {"Lcom/baidu/nadcore/rotationpop/NadRotationPopView;", "android/view/View$OnClickListener", "Landroid/widget/RelativeLayout;", "Lcom/baidu/nadcore/model/NadRotationPopModel;", "model", "", "checkCanShow", "(Lcom/baidu/nadcore/model/NadRotationPopModel;)Z", "checkDataValid", "", "hide", "()V", "hideAnim", "hideWithoutAnim", "isHitUpgradeClickExp", "()Z", "loadImage", "(Lcom/baidu/nadcore/model/NadRotationPopModel;)V", "Landroid/graphics/Bitmap;", "bitmap", "loadLottie", "(Lcom/baidu/nadcore/model/NadRotationPopModel;Landroid/graphics/Bitmap;)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "pauseHideDelayTimer", "pauseShowDelayTimer", "release", "reset", "resumeHideDelayTimer", "resumeShowDelayTimer", "Lcom/baidu/nadcore/rotationpop/NadRotationPopView$IOnActionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setBusinessActionListener", "(Lcom/baidu/nadcore/rotationpop/NadRotationPopView$IOnActionListener;)V", "setCountDownTimer", "setData", "setLpParams", "setRotationHelper", "showAnim", "startShowDelayTimer", "", "progress", "updatePlayerProgress", "(I)V", "actionListener", "Lcom/baidu/nadcore/rotationpop/NadRotationPopView$IOnActionListener;", "Lcom/baidu/nadcore/widget/AdImageView;", "bgView$delegate", "Lkotlin/Lazy;", "getBgView", "()Lcom/baidu/nadcore/widget/AdImageView;", "bgView", "hasStartShowCountTimer", "Z", "hasTriedToShow", "Landroid/animation/ObjectAnimator;", "hideAnimator", "Landroid/animation/ObjectAnimator;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "hideCountDownTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "loadLottieSuccess", "", "lottieShowMode", "Ljava/lang/String;", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieView$delegate", "getLottieView", "()Lcom/airbnb/lottie/LottieAnimationView;", "lottieView", "Landroid/widget/FrameLayout;", "popView$delegate", "getPopView", "()Landroid/widget/FrameLayout;", "popView", "Lcom/baidu/nadcore/rotation/NadRotationHelper;", "rotationHelper$delegate", "getRotationHelper", "()Lcom/baidu/nadcore/rotation/NadRotationHelper;", "rotationHelper", "Landroid/animation/AnimatorSet;", "showAnimatorSet", "Landroid/animation/AnimatorSet;", "showCountDownTimer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DefaultActionListener", "IOnActionListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRotationPopView extends RelativeLayout implements View.OnClickListener {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public boolean d;
    public d e;
    public final Lazy f;
    public boolean g;
    public k71 h;
    public k71 i;
    public String j;
    public AnimatorSet k;
    public ObjectAnimator l;

    /* loaded from: classes3.dex */
    public interface d {
        void a(View view2);

        void b(View view2);

        boolean c();

        void d(int i);

        void onHidden();

        void onShown();
    }

    @JvmOverloads
    public NadRotationPopView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public NadRotationPopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdImageView getBgView() {
        return (AdImageView) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LottieAnimationView getLottieView() {
        return (LottieAnimationView) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout getPopView() {
        return (FrameLayout) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b31 getRotationHelper() {
        return (b31) this.f.getValue();
    }

    /* loaded from: classes3.dex */
    public static final class f implements LottieOnCompositionLoadedListener {
        public final /* synthetic */ js0 b;
        public final /* synthetic */ Bitmap c;

        public f(js0 js0Var, Bitmap bitmap) {
            this.b = js0Var;
            this.c = bitmap;
        }

        /* loaded from: classes3.dex */
        public static final class a implements Runnable {
            public final /* synthetic */ LottieImageAsset b;

            public a(LottieImageAsset lottieImageAsset) {
                this.b = lottieImageAsset;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Bitmap bitmap;
                if (this.b == null || (bitmap = f.this.c) == null || bitmap.isRecycled()) {
                    return;
                }
                LottieAnimationView lottieView = NadRotationPopView.this.getLottieView();
                f fVar = f.this;
                lottieView.updateBitmap(fVar.b.l, k61.a(fVar.c, this.b.getWidth(), this.b.getHeight(), true));
            }
        }

        @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
        public final void onCompositionLoaded(LottieComposition lottieComposition) {
            Bitmap bitmap;
            Intrinsics.checkNotNullExpressionValue(lottieComposition, "lottieComposition");
            LottieImageAsset lottieImageAsset = (LottieImageAsset) i31.b(lottieComposition.getImages(), this.b.l);
            if (lottieImageAsset != null && (bitmap = this.c) != null && !bitmap.isRecycled()) {
                x41.c(new a(lottieImageAsset), "NadRotationPopView", 0);
            }
            NadRotationPopView.this.d = true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation, boolean z) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            NadRotationPopView.this.getRotationHelper().n();
            if (Intrinsics.areEqual(NadRotationPopView.this.j, "auto")) {
                NadRotationPopView.this.getLottieView().setRepeatCount(-1);
                NadRotationPopView.this.getLottieView().playAnimation();
            } else {
                NadRotationPopView.this.getLottieView().cancelAnimation();
            }
            d dVar = NadRotationPopView.this.e;
            if (dVar != null) {
                dVar.onShown();
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
            NadRotationPopView.this.setVisibility(8);
            d dVar = NadRotationPopView.this.e;
            if (dVar != null) {
                dVar.onHidden();
            }
            NadRotationPopView.this.t();
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NadRotationPopView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ViewParent parent = NadRotationPopView.this.getParent();
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                int width = viewGroup.getWidth();
                ViewGroup.LayoutParams layoutParams = NadRotationPopView.this.getPopView().getLayoutParams();
                if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
                    layoutParams = null;
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (layoutParams2 != null) {
                    float f = width * 0.43f;
                    layoutParams2.width = MathKt__MathJVMKt.roundToInt(f);
                    layoutParams2.height = MathKt__MathJVMKt.roundToInt(f);
                    if (layoutParams2 != null) {
                        NadRotationPopView.this.getPopView().setLayoutParams(layoutParams2);
                        float f2 = 0.1178344f * f;
                        NadRotationPopView.this.getPopView().setPadding(MathKt__MathJVMKt.roundToInt(f2), MathKt__MathJVMKt.roundToInt(0.05732484f * f), MathKt__MathJVMKt.roundToInt(f2), MathKt__MathJVMKt.roundToInt(0.07643312f * f));
                        ViewGroup.LayoutParams layoutParams3 = NadRotationPopView.this.getBgView().getLayoutParams();
                        if (!(layoutParams3 instanceof ViewGroup.MarginLayoutParams)) {
                            layoutParams3 = null;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams3;
                        if (marginLayoutParams2 != null) {
                            marginLayoutParams2.topMargin = MathKt__MathJVMKt.roundToInt(f * 0.025477707f);
                            marginLayoutParams = marginLayoutParams2;
                        }
                        NadRotationPopView.this.getBgView().setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements to0 {
        public final /* synthetic */ js0 b;

        public e(js0 js0Var) {
            this.b = js0Var;
        }

        @Override // com.baidu.tieba.to0
        public void a() {
            NadRotationPopView.this.s(this.b, null);
        }

        @Override // com.baidu.tieba.to0
        public void b(Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            NadRotationPopView.this.s(this.b, bitmap);
        }
    }

    /* loaded from: classes3.dex */
    public static final class g<T> implements LottieListener<Throwable> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(Throwable th) {
            NadRotationPopView.this.d = false;
        }
    }

    /* loaded from: classes3.dex */
    public static final class h extends k71.b {
        public final /* synthetic */ js0 b;

        public h(js0 js0Var) {
            this.b = js0Var;
        }

        @Override // com.baidu.tieba.k71.b
        public void b() {
            NadRotationPopView.this.g = false;
            if (!NadRotationPopView.this.n(this.b)) {
                return;
            }
            NadRotationPopView.this.u(this.b);
            k71 k71Var = NadRotationPopView.this.i;
            if (k71Var != null) {
                k71Var.e();
            }
        }

        @Override // com.baidu.tieba.k71.b
        public void e() {
            NadRotationPopView.this.g = true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class i extends k71.b {
        public i() {
        }

        @Override // com.baidu.tieba.k71.b
        public void b() {
            NadRotationPopView.this.p();
        }
    }

    /* loaded from: classes3.dex */
    public static final class j extends k71 {
        public j(js0 js0Var, long j, long j2) {
            super(j, j2);
        }
    }

    /* loaded from: classes3.dex */
    public static final class k extends k71 {
        public k(js0 js0Var, long j, long j2) {
            super(j, j2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadRotationPopView(final Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.baidu.nadcore.rotationpop.NadRotationPopView$popView$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                View findViewById = NadRotationPopView.this.findViewById(R.id.nad_rotation_pop);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.nad_rotation_pop)");
                return (FrameLayout) findViewById;
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>() { // from class: com.baidu.nadcore.rotationpop.NadRotationPopView$bgView$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdImageView invoke() {
                View findViewById = NadRotationPopView.this.findViewById(R.id.nad_rotation_pop_circle_text);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.nad_rotation_pop_circle_text)");
                return (AdImageView) findViewById;
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<LottieAnimationView>() { // from class: com.baidu.nadcore.rotationpop.NadRotationPopView$lottieView$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LottieAnimationView invoke() {
                View findViewById = NadRotationPopView.this.findViewById(R.id.nad_rotation_pop_lottie_view);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.nad_rotation_pop_lottie_view)");
                return (LottieAnimationView) findViewById;
            }
        });
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<b31>() { // from class: com.baidu.nadcore.rotationpop.NadRotationPopView$rotationHelper$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* loaded from: classes3.dex */
            public static final class a extends c31 {
                /* JADX DEBUG: Incorrect args count in method signature: ()V */
                public a() {
                }

                @Override // com.baidu.tieba.c31
                public void b(float f) {
                    if (Intrinsics.areEqual(NadRotationPopView.this.j, "follow")) {
                        NadRotationPopView.this.getLottieView().setProgress(f);
                    }
                }

                @Override // com.baidu.tieba.c31
                public void e(int i) {
                    NadRotationPopView.d dVar = NadRotationPopView.this.e;
                    if (dVar != null) {
                        dVar.d(i);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b31 invoke() {
                return new b31(context, new a());
            }
        });
        this.j = "auto";
        LayoutInflater.from(context).inflate(R.layout.nad_rotation_pop_layout, (ViewGroup) this, true);
        if (q()) {
            setClickable(false);
            setFocusable(false);
            setFocusableInTouchMode(false);
            getPopView().setOnClickListener(this);
        } else {
            setOnClickListener(this);
            getPopView().setOnClickListener(this);
        }
        setVisibility(8);
        getViewTreeObserver().addOnGlobalLayoutListener(new c());
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(getPopView(), View.ALPHA, 0.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(alphaAnimator, "alphaAnimator");
        alphaAnimator.setDuration(160L);
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(getPopView(), View.SCALE_X, 0.5f, 1.0f);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(getPopView(), View.SCALE_Y, 0.5f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(scaleXAnimator, "scaleXAnimator");
        scaleXAnimator.setDuration(160L);
        Intrinsics.checkNotNullExpressionValue(scaleYAnimator, "scaleYAnimator");
        scaleYAnimator.setDuration(160L);
        animatorSet.playTogether(alphaAnimator, scaleXAnimator, scaleYAnimator);
        animatorSet.addListener(new a());
        Unit unit = Unit.INSTANCE;
        this.k = animatorSet;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getPopView(), View.ALPHA, 1.0f, 0.0f);
        ofFloat.setDuration(160L);
        ofFloat.addListener(new b());
        Unit unit2 = Unit.INSTANCE;
        this.l = ofFloat;
    }

    public /* synthetic */ NadRotationPopView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final void s(js0 js0Var, Bitmap bitmap) {
        getLottieView().setAnimationFromUrl(js0Var.b);
        getLottieView().addLottieOnCompositionLoadedListener(new f(js0Var, bitmap));
        getLottieView().setFailureListener(new g());
    }

    private final void setLpParams(js0 js0Var) {
        ViewGroup.LayoutParams layoutParams = getPopView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            n71.e(layoutParams2, js0Var.j);
            n71.d(getContext(), layoutParams2, js0Var.k);
            if (layoutParams2 != null) {
                getPopView().setLayoutParams(layoutParams2);
            }
        }
    }

    private final void setRotationHelper(js0 js0Var) {
        getRotationHelper().s(0, js0Var.f, js0Var.g, js0Var.h, true);
    }

    public final boolean n(js0 js0Var) {
        d dVar;
        if (o(js0Var) && this.d && (dVar = this.e) != null && dVar.c() && getRotationHelper().k()) {
            return true;
        }
        return false;
    }

    public final boolean o(js0 js0Var) {
        boolean z;
        String str = js0Var.b;
        if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
            z = false;
        } else {
            z = true;
        }
        if (z || js0Var.d < 0) {
            return false;
        }
        return true;
    }

    public final void r(js0 js0Var) {
        boolean z;
        getBgView().r(js0Var.a);
        String str = js0Var.c;
        if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            s(js0Var, null);
        } else {
            so0.a().c(js0Var.c, new e(js0Var));
        }
    }

    public final void setBusinessActionListener(d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.e = listener;
    }

    public final void setData(js0 js0Var) {
        if (js0Var != null && o(js0Var)) {
            setTag(js0Var);
            this.j = js0Var.m;
            setLpParams(js0Var);
            r(js0Var);
            setRotationHelper(js0Var);
            setCountDownTimer(js0Var);
            return;
        }
        setVisibility(8);
        t();
    }

    private final void setCountDownTimer(js0 js0Var) {
        k71 k71Var = this.h;
        if (k71Var != null) {
            k71Var.a();
        }
        j jVar = new j(js0Var, js0Var.d * 1000, 1000L);
        jVar.d(new h(js0Var));
        Unit unit = Unit.INSTANCE;
        this.h = jVar;
        k71 k71Var2 = this.i;
        if (k71Var2 != null) {
            k71Var2.a();
        }
        k kVar = new k(js0Var, js0Var.e * 1000, 1000L);
        kVar.d(new i());
        Unit unit2 = Unit.INSTANCE;
        this.i = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Integer num;
        d dVar;
        if (view2 != null) {
            num = Integer.valueOf(view2.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.nad_rotation_pop) {
            d dVar2 = this.e;
            if (dVar2 != null) {
                dVar2.b(view2);
                return;
            }
            return;
        }
        int id = getId();
        if (num != null && num.intValue() == id && (dVar = this.e) != null) {
            dVar.a(view2);
        }
    }

    public final void u(js0 js0Var) {
        float f2 = 0.0f;
        getPopView().setAlpha(0.0f);
        getPopView().setScaleX(0.5f);
        getPopView().setScaleY(0.5f);
        if (Intrinsics.areEqual(this.j, "follow")) {
            int i2 = js0Var.f;
            f2 = i2 / (i2 + js0Var.g);
        }
        getLottieView().setProgress(f2);
        setVisibility(0);
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public final void p() {
        ObjectAnimator objectAnimator = this.l;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    public final boolean q() {
        if (tn0.b().a().a("flow_video_rotation_click_upgrade", 0) != 1) {
            return false;
        }
        return true;
    }

    public final void t() {
        k71 k71Var = this.h;
        if (k71Var != null) {
            k71Var.a();
        }
        k71 k71Var2 = this.i;
        if (k71Var2 != null) {
            k71Var2.a();
        }
        getLottieView().cancelAnimation();
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        ObjectAnimator objectAnimator = this.l;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        getRotationHelper().o();
    }
}
