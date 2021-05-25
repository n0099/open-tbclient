package com.baidu.swan.game.guide.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.swan.game.guide.view.GameGuideProgressView;
import com.sina.weibo.sdk.constant.WBConstants;
import d.a.l0.a.k;
import d.a.l0.f.j.h;
import d.a.l0.f.j.i;
import d.a.l0.f.j.j;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010?\u001a\u00020)\u0012\u0006\u0010@\u001a\u000201\u0012\u0006\u0010A\u001a\u00020,\u0012\u0006\u0010B\u001a\u00020,¢\u0006\u0004\bC\u0010DB\u0019\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010F\u001a\u00020E¢\u0006\u0004\bC\u0010GB!\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010F\u001a\u00020E\u0012\u0006\u0010H\u001a\u00020\u000e¢\u0006\u0004\bC\u0010IJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\tJ!\u0010\u0015\u001a\u00020\u00072\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\tJ\u0015\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010\tJ\u000f\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010\tJ\r\u0010$\u001a\u00020\u0007¢\u0006\u0004\b$\u0010\tJ\u0017\u0010%\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b%\u0010!J\u000f\u0010&\u001a\u00020\u0007H\u0002¢\u0006\u0004\b&\u0010\tR\u0016\u0010'\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010.R\u001c\u00105\u001a\u00020\u000e8B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b5\u0010(\u001a\u0004\b6\u0010\u0010R\u001c\u00107\u001a\u00020\u00188B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001c\u0010;\u001a\u00020\u00188B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b;\u00108\u001a\u0004\b<\u0010:¨\u0006J"}, d2 = {"Lcom/baidu/swan/game/guide/view/GameGuideView;", "Landroid/widget/FrameLayout;", "", "gameTime", "", "checkGameTimeAvailable", "(J)Z", "", "checkIsShowTips", "()V", "Landroid/view/View;", "coinView", "doCoinScaleAnim", "(Landroid/view/View;)V", "", "getCurrentStatus", "()I", "init", "Landroid/util/SparseArray;", "Landroid/os/Parcelable;", "container", "restoreHierarchyState", "(Landroid/util/SparseArray;)V", "restoreTailingView", "", "currentProgress", "reviseViewLayout", "(F)V", "Lcom/airbnb/lottie/LottieAnimationView;", "view", "setSaveDisable", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "startTime", "(J)V", "stopTime", "translateTailingView", "updateStatusWhenClick", "updateViewStatusByGameTimeWhenStart", "updateWhenOneProgressEnd", "currentStatus", "I", "Lcom/airbnb/lottie/LottieComposition;", "doneComposition", "Lcom/airbnb/lottie/LottieComposition;", "", "firstDoneTips", "Ljava/lang/String;", "isOnTiming", "Z", "Landroid/graphics/Bitmap;", "normalIconImg", "Landroid/graphics/Bitmap;", WBConstants.TRANS_PROGRESS_COLOR, "progressViewWidth", "getProgressViewWidth", "tailingViewOriginCenterX", "F", "getTailingViewOriginCenterX", "()F", "tailingViewOriginCenterY", "getTailingViewOriginCenterY", "Landroid/content/Context;", "context", "composition", "normalImg", "proColor", "tips", "<init>", "(Landroid/content/Context;Lcom/airbnb/lottie/LottieComposition;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gameguide_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class GameGuideView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f11612e;

    /* renamed from: f  reason: collision with root package name */
    public int f11613f;

    /* renamed from: g  reason: collision with root package name */
    public float f11614g;

    /* renamed from: h  reason: collision with root package name */
    public float f11615h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11616i;
    public LottieComposition j;
    public String k;
    public String l;
    public Bitmap m;
    public HashMap n;

    /* loaded from: classes3.dex */
    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f11617e;

        public a(View view) {
            this.f11617e = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Object animatedValue = it.getAnimatedValue();
            if (animatedValue != null) {
                float floatValue = ((Float) animatedValue).floatValue();
                this.f11617e.setScaleX(floatValue);
                this.f11617e.setScaleY(floatValue);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements GameGuideProgressView.a {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.swan.game.guide.view.GameGuideProgressView.a
        public void a(float f2) {
            GameGuideView.this.n(f2);
        }

        @Override // com.baidu.swan.game.guide.view.GameGuideProgressView.a
        public void b(float f2) {
            GameGuideView.this.n(f2);
        }

        @Override // com.baidu.swan.game.guide.view.GameGuideProgressView.a
        public void c() {
            if (GameGuideView.this.f11616i && (GameGuideView.this.f11613f == 0 || GameGuideView.this.f11613f == 1)) {
                ((GameGuideProgressView) GameGuideView.this.a(h.progress_view)).i(0.0f);
            }
            GameGuideView.this.t();
        }

        @Override // com.baidu.swan.game.guide.view.GameGuideProgressView.a
        public void d() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Object animatedValue = it.getAnimatedValue();
            if (animatedValue != null) {
                float floatValue = ((Float) animatedValue).floatValue();
                LottieAnimationView tailing_view = (LottieAnimationView) GameGuideView.this.a(h.tailing_view);
                Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
                ViewGroup.LayoutParams layoutParams = tailing_view.getLayoutParams();
                if (layoutParams != null) {
                    ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                    ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = (int) floatValue;
                    LottieAnimationView tailing_view2 = (LottieAnimationView) GameGuideView.this.a(h.tailing_view);
                    Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
                    tailing_view2.setLayoutParams(layoutParams2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Object animatedValue = it.getAnimatedValue();
            if (animatedValue != null) {
                float floatValue = ((Float) animatedValue).floatValue();
                LottieAnimationView tailing_view = (LottieAnimationView) GameGuideView.this.a(h.tailing_view);
                Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
                ViewGroup.LayoutParams layoutParams = tailing_view.getLayoutParams();
                if (layoutParams != null) {
                    ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                    ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = (int) floatValue;
                    LottieAnimationView tailing_view2 = (LottieAnimationView) GameGuideView.this.a(h.tailing_view);
                    Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
                    tailing_view2.setLayoutParams(layoutParams2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    /* loaded from: classes3.dex */
    public static final class e extends AnimatorListenerAdapter {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f11622f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ double f11623g;

        public e(Ref.BooleanRef booleanRef, double d2) {
            this.f11622f = booleanRef;
            this.f11623g = d2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (GameGuideView.this.f11616i) {
                Ref.BooleanRef booleanRef = this.f11622f;
                if (booleanRef.element) {
                    return;
                }
                booleanRef.element = true;
                LottieAnimationView tailing_view = (LottieAnimationView) GameGuideView.this.a(h.tailing_view);
                Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
                tailing_view.setRotation(90 - ((float) this.f11623g));
                GameGuideView.this.m();
                LottieAnimationView tailing_view2 = (LottieAnimationView) GameGuideView.this.a(h.tailing_view);
                Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
                tailing_view2.setVisibility(8);
                int i2 = GameGuideView.this.f11613f;
                if (i2 == 0) {
                    LottieAnimationView done_coin_1 = (LottieAnimationView) GameGuideView.this.a(h.done_coin_1);
                    Intrinsics.checkNotNullExpressionValue(done_coin_1, "done_coin_1");
                    done_coin_1.setVisibility(0);
                    ImageView normal_coin_1 = (ImageView) GameGuideView.this.a(h.normal_coin_1);
                    Intrinsics.checkNotNullExpressionValue(normal_coin_1, "normal_coin_1");
                    normal_coin_1.setVisibility(4);
                    ((LottieAnimationView) GameGuideView.this.a(h.done_coin_1)).playAnimation();
                    GameGuideView.this.f11613f = 1;
                    GameGuideView gameGuideView = GameGuideView.this;
                    LottieAnimationView done_coin_12 = (LottieAnimationView) gameGuideView.a(h.done_coin_1);
                    Intrinsics.checkNotNullExpressionValue(done_coin_12, "done_coin_1");
                    gameGuideView.k(done_coin_12);
                    GameGuideView.this.j();
                } else if (i2 == 1) {
                    LottieAnimationView done_coin_2 = (LottieAnimationView) GameGuideView.this.a(h.done_coin_2);
                    Intrinsics.checkNotNullExpressionValue(done_coin_2, "done_coin_2");
                    done_coin_2.setVisibility(0);
                    ImageView normal_coin_2 = (ImageView) GameGuideView.this.a(h.normal_coin_2);
                    Intrinsics.checkNotNullExpressionValue(normal_coin_2, "normal_coin_2");
                    normal_coin_2.setVisibility(4);
                    ((LottieAnimationView) GameGuideView.this.a(h.done_coin_2)).playAnimation();
                    GameGuideView.this.f11613f = 2;
                    GameGuideView gameGuideView2 = GameGuideView.this;
                    LottieAnimationView done_coin_22 = (LottieAnimationView) gameGuideView2.a(h.done_coin_2);
                    Intrinsics.checkNotNullExpressionValue(done_coin_22, "done_coin_2");
                    gameGuideView2.k(done_coin_22);
                } else if (i2 != 2) {
                } else {
                    LottieAnimationView done_coin_3 = (LottieAnimationView) GameGuideView.this.a(h.done_coin_3);
                    Intrinsics.checkNotNullExpressionValue(done_coin_3, "done_coin_3");
                    done_coin_3.setVisibility(0);
                    ImageView normal_coin_3 = (ImageView) GameGuideView.this.a(h.normal_coin_3);
                    Intrinsics.checkNotNullExpressionValue(normal_coin_3, "normal_coin_3");
                    normal_coin_3.setVisibility(4);
                    ((LottieAnimationView) GameGuideView.this.a(h.done_coin_3)).playAnimation();
                    GameGuideView.this.f11613f = 3;
                    ((LottieAnimationView) GameGuideView.this.a(h.spark_view)).cancelAnimation();
                    LottieAnimationView spark_view = (LottieAnimationView) GameGuideView.this.a(h.spark_view);
                    Intrinsics.checkNotNullExpressionValue(spark_view, "spark_view");
                    spark_view.setVisibility(8);
                    GameGuideView gameGuideView3 = GameGuideView.this;
                    LottieAnimationView done_coin_32 = (LottieAnimationView) gameGuideView3.a(h.done_coin_3);
                    Intrinsics.checkNotNullExpressionValue(done_coin_32, "done_coin_3");
                    gameGuideView3.k(done_coin_32);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class f extends AnimatorListenerAdapter {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            LottieAnimationView bomb_view = (LottieAnimationView) GameGuideView.this.a(h.bomb_view);
            Intrinsics.checkNotNullExpressionValue(bomb_view, "bomb_view");
            bomb_view.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideView(Context context, LottieComposition composition, Bitmap normalImg, String proColor, String tips) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(composition, "composition");
        Intrinsics.checkNotNullParameter(normalImg, "normalImg");
        Intrinsics.checkNotNullParameter(proColor, "proColor");
        Intrinsics.checkNotNullParameter(tips, "tips");
        this.k = "";
        this.l = "";
        this.j = composition;
        this.k = proColor;
        this.l = tips;
        this.m = normalImg;
        l();
    }

    private final int getProgressViewWidth() {
        if (this.f11612e == 0) {
            GameGuideProgressView progress_view = (GameGuideProgressView) a(h.progress_view);
            Intrinsics.checkNotNullExpressionValue(progress_view, "progress_view");
            this.f11612e = progress_view.getWidth();
        }
        return this.f11612e;
    }

    private final float getTailingViewOriginCenterX() {
        if (this.f11614g == 0.0f) {
            GameGuideProgressView progress_view = (GameGuideProgressView) a(h.progress_view);
            Intrinsics.checkNotNullExpressionValue(progress_view, "progress_view");
            this.f11614g = progress_view.getX() + getProgressViewWidth();
        }
        return this.f11614g;
    }

    private final float getTailingViewOriginCenterY() {
        if (this.f11615h == 0.0f) {
            GameGuideProgressView progress_view = (GameGuideProgressView) a(h.progress_view);
            Intrinsics.checkNotNullExpressionValue(progress_view, "progress_view");
            float y = progress_view.getY();
            GameGuideProgressView progress_view2 = (GameGuideProgressView) a(h.progress_view);
            Intrinsics.checkNotNullExpressionValue(progress_view2, "progress_view");
            this.f11615h = y + (progress_view2.getHeight() / 2);
        }
        return this.f11615h;
    }

    private final void setSaveDisable(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.setSaveEnabled(false);
        }
        if (lottieAnimationView != null) {
            lottieAnimationView.setSaveFromParentEnabled(false);
        }
    }

    public View a(int i2) {
        if (this.n == null) {
            this.n = new HashMap();
        }
        View view = (View) this.n.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            this.n.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    public final int getCurrentStatus() {
        return this.f11613f;
    }

    public final boolean i(long j) {
        if (j < 0) {
            if (k.f43199a) {
                Log.d("GameTimeView", "传入的时间不能小于0");
            }
            return false;
        } else if (j <= SapiWebView.DEFAULT_TIMEOUT_MILLIS || !k.f43199a) {
            return true;
        } else {
            Log.d("GameTimeView", "传入的时间大于最大值 90000");
            return false;
        }
    }

    public final void j() {
        if (d.a.l0.f.j.b.o.L()) {
            return;
        }
        if (this.l.length() > 0) {
            TextView tips = (TextView) a(h.tips);
            Intrinsics.checkNotNullExpressionValue(tips, "tips");
            tips.setVisibility(0);
            TextView tips2 = (TextView) a(h.tips);
            Intrinsics.checkNotNullExpressionValue(tips2, "tips");
            tips2.setText(this.l);
            d.a.l0.f.j.b.o.b0();
        }
    }

    public final void k(View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimator.addUpdateListener(new a(view));
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
        valueAnimator.setInterpolator(new OvershootInterpolator());
        valueAnimator.setDuration(250L);
        valueAnimator.start();
    }

    public final void l() {
        setSaveFromParentEnabled(false);
        setSaveEnabled(false);
        setLayerType(1, null);
        LayoutInflater.from(AppRuntime.getAppContext()).inflate(i.aiapps_game_guide_view, this);
        LottieComposition lottieComposition = this.j;
        if (lottieComposition != null) {
            ((LottieAnimationView) a(h.done_coin_1)).setComposition(lottieComposition);
            ((LottieAnimationView) a(h.done_coin_2)).setComposition(lottieComposition);
            ((LottieAnimationView) a(h.done_coin_3)).setComposition(lottieComposition);
            LottieAnimationView done_coin_1 = (LottieAnimationView) a(h.done_coin_1);
            Intrinsics.checkNotNullExpressionValue(done_coin_1, "done_coin_1");
            done_coin_1.setRepeatCount(-1);
            LottieAnimationView done_coin_2 = (LottieAnimationView) a(h.done_coin_2);
            Intrinsics.checkNotNullExpressionValue(done_coin_2, "done_coin_2");
            done_coin_2.setRepeatCount(-1);
            LottieAnimationView done_coin_3 = (LottieAnimationView) a(h.done_coin_3);
            Intrinsics.checkNotNullExpressionValue(done_coin_3, "done_coin_3");
            done_coin_3.setRepeatCount(-1);
        }
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            ((ImageView) a(h.normal_coin_1)).setImageBitmap(bitmap);
            ((ImageView) a(h.normal_coin_2)).setImageBitmap(bitmap);
            ((ImageView) a(h.normal_coin_3)).setImageBitmap(bitmap);
        }
        if (this.k.length() > 0) {
            try {
                ((GameGuideProgressView) a(h.progress_view)).setProgressColor(Color.parseColor(this.k));
            } catch (Exception e2) {
                if (k.f43199a) {
                    throw e2;
                }
            }
        }
        ((LottieAnimationView) a(h.spark_view)).setAnimation(j.aiapps_game_guide_view_spark_view);
        LottieAnimationView spark_view = (LottieAnimationView) a(h.spark_view);
        Intrinsics.checkNotNullExpressionValue(spark_view, "spark_view");
        spark_view.setRepeatCount(-1);
        ((LottieAnimationView) a(h.bomb_view)).setAnimation(j.aiapps_game_guide_view_bomb_view);
        ((LottieAnimationView) a(h.tailing_view)).setAnimation(j.aiapps_game_guide_view_tailing_view);
        ((GameGuideProgressView) a(h.progress_view)).setProgressListener(new b());
        setSaveDisable((LottieAnimationView) a(h.done_coin_1));
        setSaveDisable((LottieAnimationView) a(h.done_coin_2));
        setSaveDisable((LottieAnimationView) a(h.done_coin_2));
        setSaveDisable((LottieAnimationView) a(h.spark_view));
        setSaveDisable((LottieAnimationView) a(h.bomb_view));
        setSaveDisable((LottieAnimationView) a(h.tailing_view));
    }

    public final void m() {
        LottieAnimationView tailing_view = (LottieAnimationView) a(h.tailing_view);
        Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
        ViewGroup.LayoutParams layoutParams = tailing_view.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = 0;
            LottieAnimationView tailing_view2 = (LottieAnimationView) a(h.tailing_view);
            Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
            tailing_view2.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void n(float f2) {
        float progressViewWidth = getProgressViewWidth() * f2;
        LottieAnimationView spark_view = (LottieAnimationView) a(h.spark_view);
        Intrinsics.checkNotNullExpressionValue(spark_view, "spark_view");
        ViewGroup.LayoutParams layoutParams = spark_view.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginStart((int) progressViewWidth);
            LottieAnimationView spark_view2 = (LottieAnimationView) a(h.spark_view);
            Intrinsics.checkNotNullExpressionValue(spark_view2, "spark_view");
            spark_view2.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void o(long j) {
        if (i(j)) {
            if (this.f11616i) {
                if (k.f43199a) {
                    Log.e("GameTimeView", "已经在计时当中");
                    return;
                }
                return;
            }
            s(j);
            if (j >= SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                if (k.f43199a) {
                    Log.d("GameTimeView", "已经达到了最大的计时");
                }
                ((GameGuideProgressView) a(h.progress_view)).i(1.0f);
                return;
            }
            this.f11616i = true;
            ((GameGuideProgressView) a(h.progress_view)).i(((float) (j % StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD)) / ((float) StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD));
        }
    }

    public final void p() {
        this.f11616i = false;
        ((GameGuideProgressView) a(h.progress_view)).j();
        ((LottieAnimationView) a(h.done_coin_1)).cancelAnimation();
        ((LottieAnimationView) a(h.done_coin_2)).cancelAnimation();
        ((LottieAnimationView) a(h.done_coin_3)).cancelAnimation();
        ((LottieAnimationView) a(h.spark_view)).cancelAnimation();
        ((LottieAnimationView) a(h.tailing_view)).cancelAnimation();
        ((LottieAnimationView) a(h.bomb_view)).cancelAnimation();
        LottieAnimationView tailing_view = (LottieAnimationView) a(h.tailing_view);
        Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
        tailing_view.setVisibility(4);
        LottieAnimationView bomb_view = (LottieAnimationView) a(h.bomb_view);
        Intrinsics.checkNotNullExpressionValue(bomb_view, "bomb_view");
        bomb_view.setVisibility(8);
    }

    public final void q() {
        float width;
        float height;
        long j;
        float f2;
        int i2 = this.f11613f;
        if (i2 == 0) {
            ImageView normal_coin_1 = (ImageView) a(h.normal_coin_1);
            Intrinsics.checkNotNullExpressionValue(normal_coin_1, "normal_coin_1");
            float x = normal_coin_1.getX();
            ImageView normal_coin_12 = (ImageView) a(h.normal_coin_1);
            Intrinsics.checkNotNullExpressionValue(normal_coin_12, "normal_coin_1");
            width = x + (normal_coin_12.getWidth() / 2);
            ImageView normal_coin_13 = (ImageView) a(h.normal_coin_1);
            Intrinsics.checkNotNullExpressionValue(normal_coin_13, "normal_coin_1");
            float y = normal_coin_13.getY();
            ImageView normal_coin_14 = (ImageView) a(h.normal_coin_1);
            Intrinsics.checkNotNullExpressionValue(normal_coin_14, "normal_coin_1");
            height = y + (normal_coin_14.getHeight() / 2);
            j = 700;
            f2 = 1.0f;
        } else if (i2 == 1) {
            ImageView normal_coin_2 = (ImageView) a(h.normal_coin_2);
            Intrinsics.checkNotNullExpressionValue(normal_coin_2, "normal_coin_2");
            float x2 = normal_coin_2.getX();
            ImageView normal_coin_22 = (ImageView) a(h.normal_coin_2);
            Intrinsics.checkNotNullExpressionValue(normal_coin_22, "normal_coin_2");
            width = x2 + (normal_coin_22.getWidth() / 2);
            ImageView normal_coin_23 = (ImageView) a(h.normal_coin_2);
            Intrinsics.checkNotNullExpressionValue(normal_coin_23, "normal_coin_2");
            float y2 = normal_coin_23.getY();
            ImageView normal_coin_24 = (ImageView) a(h.normal_coin_2);
            Intrinsics.checkNotNullExpressionValue(normal_coin_24, "normal_coin_2");
            height = y2 + (normal_coin_24.getHeight() / 2);
            j = 500;
            f2 = 1.4f;
        } else if (i2 != 2) {
            return;
        } else {
            ImageView normal_coin_3 = (ImageView) a(h.normal_coin_3);
            Intrinsics.checkNotNullExpressionValue(normal_coin_3, "normal_coin_3");
            float x3 = normal_coin_3.getX();
            ImageView normal_coin_32 = (ImageView) a(h.normal_coin_3);
            Intrinsics.checkNotNullExpressionValue(normal_coin_32, "normal_coin_3");
            width = x3 + (normal_coin_32.getWidth() / 2);
            ImageView normal_coin_33 = (ImageView) a(h.normal_coin_3);
            Intrinsics.checkNotNullExpressionValue(normal_coin_33, "normal_coin_3");
            float y3 = normal_coin_33.getY();
            ImageView normal_coin_34 = (ImageView) a(h.normal_coin_3);
            Intrinsics.checkNotNullExpressionValue(normal_coin_34, "normal_coin_3");
            height = y3 + (normal_coin_34.getHeight() / 2);
            j = 300;
            f2 = 0.33333334f;
        }
        double atan2 = (180 * ((float) Math.atan2(getTailingViewOriginCenterY() - height, getTailingViewOriginCenterX() - width))) / 3.141592653589793d;
        LottieAnimationView tailing_view = (LottieAnimationView) a(h.tailing_view);
        Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
        tailing_view.setVisibility(0);
        m();
        LottieAnimationView tailing_view2 = (LottieAnimationView) a(h.tailing_view);
        Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
        tailing_view2.setRotation(((float) atan2) - 90);
        LottieAnimationView tailing_view3 = (LottieAnimationView) a(h.tailing_view);
        Intrinsics.checkNotNullExpressionValue(tailing_view3, "tailing_view");
        tailing_view3.setSpeed(f2);
        ((LottieAnimationView) a(h.tailing_view)).playAnimation();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        ValueAnimator xValueAnimator = ValueAnimator.ofFloat(0.0f, getTailingViewOriginCenterX() - width);
        xValueAnimator.addUpdateListener(new c());
        Intrinsics.checkNotNullExpressionValue(xValueAnimator, "xValueAnimator");
        xValueAnimator.setInterpolator(new LinearInterpolator());
        ValueAnimator yValueAnimator = ValueAnimator.ofFloat(0.0f, getTailingViewOriginCenterY() - height);
        yValueAnimator.addUpdateListener(new d());
        Intrinsics.checkNotNullExpressionValue(yValueAnimator, "yValueAnimator");
        yValueAnimator.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j);
        animatorSet.play(xValueAnimator).with(yValueAnimator);
        animatorSet.addListener(new e(booleanRef, atan2));
        animatorSet.start();
    }

    public final void r() {
        TextView tips = (TextView) a(h.tips);
        Intrinsics.checkNotNullExpressionValue(tips, "tips");
        if (tips.getVisibility() == 0) {
            TextView tips2 = (TextView) a(h.tips);
            Intrinsics.checkNotNullExpressionValue(tips2, "tips");
            tips2.setVisibility(8);
        }
        this.f11613f = 0;
        ((LottieAnimationView) a(h.done_coin_1)).cancelAnimation();
        LottieAnimationView done_coin_1 = (LottieAnimationView) a(h.done_coin_1);
        Intrinsics.checkNotNullExpressionValue(done_coin_1, "done_coin_1");
        done_coin_1.setVisibility(8);
        ImageView normal_coin_1 = (ImageView) a(h.normal_coin_1);
        Intrinsics.checkNotNullExpressionValue(normal_coin_1, "normal_coin_1");
        normal_coin_1.setVisibility(0);
        ((LottieAnimationView) a(h.done_coin_2)).cancelAnimation();
        LottieAnimationView done_coin_2 = (LottieAnimationView) a(h.done_coin_2);
        Intrinsics.checkNotNullExpressionValue(done_coin_2, "done_coin_2");
        done_coin_2.setVisibility(8);
        ImageView normal_coin_2 = (ImageView) a(h.normal_coin_2);
        Intrinsics.checkNotNullExpressionValue(normal_coin_2, "normal_coin_2");
        normal_coin_2.setVisibility(0);
        ((LottieAnimationView) a(h.done_coin_3)).cancelAnimation();
        LottieAnimationView done_coin_3 = (LottieAnimationView) a(h.done_coin_3);
        Intrinsics.checkNotNullExpressionValue(done_coin_3, "done_coin_3");
        done_coin_3.setVisibility(8);
        ImageView normal_coin_3 = (ImageView) a(h.normal_coin_3);
        Intrinsics.checkNotNullExpressionValue(normal_coin_3, "normal_coin_3");
        normal_coin_3.setVisibility(0);
    }

    @Override // android.view.View
    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
    }

    public final void s(long j) {
        LottieAnimationView tailing_view = (LottieAnimationView) a(h.tailing_view);
        Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
        tailing_view.setVisibility(8);
        if (0 <= j && StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD > j) {
            LottieAnimationView done_coin_1 = (LottieAnimationView) a(h.done_coin_1);
            Intrinsics.checkNotNullExpressionValue(done_coin_1, "done_coin_1");
            done_coin_1.setVisibility(8);
            ImageView normal_coin_1 = (ImageView) a(h.normal_coin_1);
            Intrinsics.checkNotNullExpressionValue(normal_coin_1, "normal_coin_1");
            normal_coin_1.setVisibility(0);
            ((LottieAnimationView) a(h.done_coin_1)).cancelAnimation();
            LottieAnimationView done_coin_2 = (LottieAnimationView) a(h.done_coin_2);
            Intrinsics.checkNotNullExpressionValue(done_coin_2, "done_coin_2");
            done_coin_2.setVisibility(8);
            ImageView normal_coin_2 = (ImageView) a(h.normal_coin_2);
            Intrinsics.checkNotNullExpressionValue(normal_coin_2, "normal_coin_2");
            normal_coin_2.setVisibility(0);
            ((LottieAnimationView) a(h.done_coin_2)).cancelAnimation();
            LottieAnimationView done_coin_3 = (LottieAnimationView) a(h.done_coin_3);
            Intrinsics.checkNotNullExpressionValue(done_coin_3, "done_coin_3");
            done_coin_3.setVisibility(8);
            ImageView normal_coin_3 = (ImageView) a(h.normal_coin_3);
            Intrinsics.checkNotNullExpressionValue(normal_coin_3, "normal_coin_3");
            normal_coin_3.setVisibility(0);
            ((LottieAnimationView) a(h.done_coin_3)).cancelAnimation();
            LottieAnimationView spark_view = (LottieAnimationView) a(h.spark_view);
            Intrinsics.checkNotNullExpressionValue(spark_view, "spark_view");
            spark_view.setVisibility(0);
            ((LottieAnimationView) a(h.spark_view)).playAnimation();
            this.f11613f = 0;
        } else if (StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD <= j && 60000 > j) {
            LottieAnimationView done_coin_12 = (LottieAnimationView) a(h.done_coin_1);
            Intrinsics.checkNotNullExpressionValue(done_coin_12, "done_coin_1");
            done_coin_12.setVisibility(0);
            ImageView normal_coin_12 = (ImageView) a(h.normal_coin_1);
            Intrinsics.checkNotNullExpressionValue(normal_coin_12, "normal_coin_1");
            normal_coin_12.setVisibility(4);
            ((LottieAnimationView) a(h.done_coin_1)).playAnimation();
            LottieAnimationView done_coin_22 = (LottieAnimationView) a(h.done_coin_2);
            Intrinsics.checkNotNullExpressionValue(done_coin_22, "done_coin_2");
            done_coin_22.setVisibility(8);
            ((LottieAnimationView) a(h.done_coin_2)).cancelAnimation();
            LottieAnimationView done_coin_32 = (LottieAnimationView) a(h.done_coin_3);
            Intrinsics.checkNotNullExpressionValue(done_coin_32, "done_coin_3");
            done_coin_32.setVisibility(8);
            ((LottieAnimationView) a(h.done_coin_3)).cancelAnimation();
            LottieAnimationView spark_view2 = (LottieAnimationView) a(h.spark_view);
            Intrinsics.checkNotNullExpressionValue(spark_view2, "spark_view");
            spark_view2.setVisibility(0);
            ((LottieAnimationView) a(h.spark_view)).playAnimation();
            this.f11613f = 1;
        } else if (60000 <= j && SapiWebView.DEFAULT_TIMEOUT_MILLIS > j) {
            LottieAnimationView done_coin_13 = (LottieAnimationView) a(h.done_coin_1);
            Intrinsics.checkNotNullExpressionValue(done_coin_13, "done_coin_1");
            done_coin_13.setVisibility(0);
            ImageView normal_coin_13 = (ImageView) a(h.normal_coin_1);
            Intrinsics.checkNotNullExpressionValue(normal_coin_13, "normal_coin_1");
            normal_coin_13.setVisibility(4);
            ((LottieAnimationView) a(h.done_coin_1)).playAnimation();
            LottieAnimationView done_coin_23 = (LottieAnimationView) a(h.done_coin_2);
            Intrinsics.checkNotNullExpressionValue(done_coin_23, "done_coin_2");
            done_coin_23.setVisibility(0);
            ImageView normal_coin_22 = (ImageView) a(h.normal_coin_2);
            Intrinsics.checkNotNullExpressionValue(normal_coin_22, "normal_coin_2");
            normal_coin_22.setVisibility(4);
            ((LottieAnimationView) a(h.done_coin_2)).playAnimation();
            LottieAnimationView done_coin_33 = (LottieAnimationView) a(h.done_coin_3);
            Intrinsics.checkNotNullExpressionValue(done_coin_33, "done_coin_3");
            done_coin_33.setVisibility(8);
            ((LottieAnimationView) a(h.done_coin_3)).cancelAnimation();
            LottieAnimationView spark_view3 = (LottieAnimationView) a(h.spark_view);
            Intrinsics.checkNotNullExpressionValue(spark_view3, "spark_view");
            spark_view3.setVisibility(0);
            ((LottieAnimationView) a(h.spark_view)).playAnimation();
            this.f11613f = 2;
        } else {
            LottieAnimationView done_coin_14 = (LottieAnimationView) a(h.done_coin_1);
            Intrinsics.checkNotNullExpressionValue(done_coin_14, "done_coin_1");
            done_coin_14.setVisibility(0);
            ImageView normal_coin_14 = (ImageView) a(h.normal_coin_1);
            Intrinsics.checkNotNullExpressionValue(normal_coin_14, "normal_coin_1");
            normal_coin_14.setVisibility(4);
            ((LottieAnimationView) a(h.done_coin_1)).playAnimation();
            LottieAnimationView done_coin_24 = (LottieAnimationView) a(h.done_coin_2);
            Intrinsics.checkNotNullExpressionValue(done_coin_24, "done_coin_2");
            done_coin_24.setVisibility(0);
            ImageView normal_coin_23 = (ImageView) a(h.normal_coin_2);
            Intrinsics.checkNotNullExpressionValue(normal_coin_23, "normal_coin_2");
            normal_coin_23.setVisibility(4);
            ((LottieAnimationView) a(h.done_coin_2)).playAnimation();
            LottieAnimationView done_coin_34 = (LottieAnimationView) a(h.done_coin_3);
            Intrinsics.checkNotNullExpressionValue(done_coin_34, "done_coin_3");
            done_coin_34.setVisibility(0);
            ImageView normal_coin_32 = (ImageView) a(h.normal_coin_3);
            Intrinsics.checkNotNullExpressionValue(normal_coin_32, "normal_coin_3");
            normal_coin_32.setVisibility(4);
            ((LottieAnimationView) a(h.done_coin_3)).playAnimation();
            LottieAnimationView spark_view4 = (LottieAnimationView) a(h.spark_view);
            Intrinsics.checkNotNullExpressionValue(spark_view4, "spark_view");
            spark_view4.setVisibility(8);
            ((LottieAnimationView) a(h.spark_view)).cancelAnimation();
            this.f11613f = 3;
        }
    }

    public final void t() {
        LottieAnimationView bomb_view = (LottieAnimationView) a(h.bomb_view);
        Intrinsics.checkNotNullExpressionValue(bomb_view, "bomb_view");
        bomb_view.setVisibility(0);
        ((LottieAnimationView) a(h.bomb_view)).playAnimation();
        ((LottieAnimationView) a(h.bomb_view)).addAnimatorListener(new f());
        q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        this.k = "";
        this.l = "";
        l();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        this.k = "";
        this.l = "";
        l();
    }
}
