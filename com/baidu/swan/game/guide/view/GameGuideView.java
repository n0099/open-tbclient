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
import com.baidu.swan.game.guide.view.GameGuideProgressView;
import com.baidu.tieba.R;
import com.baidu.tieba.b24;
import com.baidu.tieba.ms1;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010?\u001a\u00020)\u0012\u0006\u0010@\u001a\u000201\u0012\u0006\u0010A\u001a\u00020,\u0012\u0006\u0010B\u001a\u00020,¢\u0006\u0004\bC\u0010DB\u0019\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010F\u001a\u00020E¢\u0006\u0004\bC\u0010GB!\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010F\u001a\u00020E\u0012\u0006\u0010H\u001a\u00020\u000e¢\u0006\u0004\bC\u0010IJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\tJ!\u0010\u0015\u001a\u00020\u00072\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\tJ\u0015\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010\tJ\u000f\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010\tJ\r\u0010$\u001a\u00020\u0007¢\u0006\u0004\b$\u0010\tJ\u0017\u0010%\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b%\u0010!J\u000f\u0010&\u001a\u00020\u0007H\u0002¢\u0006\u0004\b&\u0010\tR\u0016\u0010'\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010.R\u001c\u00105\u001a\u00020\u000e8B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b5\u0010(\u001a\u0004\b6\u0010\u0010R\u001c\u00107\u001a\u00020\u00188B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001c\u0010;\u001a\u00020\u00188B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b;\u00108\u001a\u0004\b<\u0010:¨\u0006J"}, d2 = {"Lcom/baidu/swan/game/guide/view/GameGuideView;", "Landroid/widget/FrameLayout;", "", "gameTime", "", "checkGameTimeAvailable", "(J)Z", "", "checkIsShowTips", "()V", "Landroid/view/View;", "coinView", "doCoinScaleAnim", "(Landroid/view/View;)V", "", "getCurrentStatus", "()I", "init", "Landroid/util/SparseArray;", "Landroid/os/Parcelable;", "container", "restoreHierarchyState", "(Landroid/util/SparseArray;)V", "restoreTailingView", "", "currentProgress", "reviseViewLayout", "(F)V", "Lcom/airbnb/lottie/LottieAnimationView;", "view", "setSaveDisable", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "startTime", "(J)V", "stopTime", "translateTailingView", "updateStatusWhenClick", "updateViewStatusByGameTimeWhenStart", "updateWhenOneProgressEnd", "currentStatus", "I", "Lcom/airbnb/lottie/LottieComposition;", "doneComposition", "Lcom/airbnb/lottie/LottieComposition;", "", "firstDoneTips", "Ljava/lang/String;", "isOnTiming", "Z", "Landroid/graphics/Bitmap;", "normalIconImg", "Landroid/graphics/Bitmap;", WBConstants.TRANS_PROGRESS_COLOR, "progressViewWidth", "getProgressViewWidth", "tailingViewOriginCenterX", "F", "getTailingViewOriginCenterX", "()F", "tailingViewOriginCenterY", "getTailingViewOriginCenterY", "Landroid/content/Context;", "context", "composition", "normalImg", "proColor", "tips", "<init>", "(Landroid/content/Context;Lcom/airbnb/lottie/LottieComposition;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gameguide_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class GameGuideView extends FrameLayout {
    public int a;
    public int b;
    public float c;
    public float d;
    public boolean e;
    public LottieComposition f;
    public String g;
    public String h;
    public Bitmap i;
    public HashMap j;

    public View a(int i) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        View view2 = (View) this.j.get(Integer.valueOf(i));
        if (view2 == null) {
            View findViewById = findViewById(i);
            this.j.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view2;
    }

    @Override // android.view.View
    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
    }

    /* loaded from: classes4.dex */
    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;

        public a(View view2) {
            this.a = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Object animatedValue = it.getAnimatedValue();
            if (animatedValue != null) {
                float floatValue = ((Float) animatedValue).floatValue();
                this.a.setScaleX(floatValue);
                this.a.setScaleY(floatValue);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements GameGuideProgressView.a {
        @Override // com.baidu.swan.game.guide.view.GameGuideProgressView.a
        public void d() {
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.swan.game.guide.view.GameGuideProgressView.a
        public void a(float f) {
            GameGuideView.this.n(f);
        }

        @Override // com.baidu.swan.game.guide.view.GameGuideProgressView.a
        public void b(float f) {
            GameGuideView.this.n(f);
        }

        @Override // com.baidu.swan.game.guide.view.GameGuideProgressView.a
        public void c() {
            if (GameGuideView.this.e && (GameGuideView.this.b == 0 || GameGuideView.this.b == 1)) {
                ((GameGuideProgressView) GameGuideView.this.a(R.id.obfuscated_res_0x7f091d42)).i(0.0f);
            }
            GameGuideView.this.t();
        }
    }

    /* loaded from: classes4.dex */
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Object animatedValue = it.getAnimatedValue();
            if (animatedValue != null) {
                float floatValue = ((Float) animatedValue).floatValue();
                LottieAnimationView tailing_view = (LottieAnimationView) GameGuideView.this.a(R.id.obfuscated_res_0x7f0923c9);
                Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
                ViewGroup.LayoutParams layoutParams = tailing_view.getLayoutParams();
                if (layoutParams != null) {
                    ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                    ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = (int) floatValue;
                    LottieAnimationView tailing_view2 = (LottieAnimationView) GameGuideView.this.a(R.id.obfuscated_res_0x7f0923c9);
                    Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
                    tailing_view2.setLayoutParams(layoutParams2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    /* loaded from: classes4.dex */
    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Object animatedValue = it.getAnimatedValue();
            if (animatedValue != null) {
                float floatValue = ((Float) animatedValue).floatValue();
                LottieAnimationView tailing_view = (LottieAnimationView) GameGuideView.this.a(R.id.obfuscated_res_0x7f0923c9);
                Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
                ViewGroup.LayoutParams layoutParams = tailing_view.getLayoutParams();
                if (layoutParams != null) {
                    ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                    ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = (int) floatValue;
                    LottieAnimationView tailing_view2 = (LottieAnimationView) GameGuideView.this.a(R.id.obfuscated_res_0x7f0923c9);
                    Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
                    tailing_view2.setLayoutParams(layoutParams2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    /* loaded from: classes4.dex */
    public static final class e extends AnimatorListenerAdapter {
        public final /* synthetic */ Ref.BooleanRef b;
        public final /* synthetic */ double c;

        public e(Ref.BooleanRef booleanRef, double d) {
            this.b = booleanRef;
            this.c = d;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (GameGuideView.this.e) {
                Ref.BooleanRef booleanRef = this.b;
                if (!booleanRef.element) {
                    booleanRef.element = true;
                    LottieAnimationView tailing_view = (LottieAnimationView) GameGuideView.this.a(R.id.obfuscated_res_0x7f0923c9);
                    Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
                    tailing_view.setRotation(90 - ((float) this.c));
                    GameGuideView.this.m();
                    LottieAnimationView tailing_view2 = (LottieAnimationView) GameGuideView.this.a(R.id.obfuscated_res_0x7f0923c9);
                    Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
                    tailing_view2.setVisibility(8);
                    int i = GameGuideView.this.b;
                    if (i != 0) {
                        if (i != 1) {
                            if (i == 2) {
                                LottieAnimationView done_coin_3 = (LottieAnimationView) GameGuideView.this.a(R.id.obfuscated_res_0x7f090916);
                                Intrinsics.checkNotNullExpressionValue(done_coin_3, "done_coin_3");
                                done_coin_3.setVisibility(0);
                                ImageView normal_coin_3 = (ImageView) GameGuideView.this.a(R.id.obfuscated_res_0x7f091954);
                                Intrinsics.checkNotNullExpressionValue(normal_coin_3, "normal_coin_3");
                                normal_coin_3.setVisibility(4);
                                ((LottieAnimationView) GameGuideView.this.a(R.id.obfuscated_res_0x7f090916)).playAnimation();
                                GameGuideView.this.b = 3;
                                ((LottieAnimationView) GameGuideView.this.a(R.id.obfuscated_res_0x7f0921f7)).cancelAnimation();
                                LottieAnimationView spark_view = (LottieAnimationView) GameGuideView.this.a(R.id.obfuscated_res_0x7f0921f7);
                                Intrinsics.checkNotNullExpressionValue(spark_view, "spark_view");
                                spark_view.setVisibility(8);
                                GameGuideView gameGuideView = GameGuideView.this;
                                LottieAnimationView done_coin_32 = (LottieAnimationView) gameGuideView.a(R.id.obfuscated_res_0x7f090916);
                                Intrinsics.checkNotNullExpressionValue(done_coin_32, "done_coin_3");
                                gameGuideView.k(done_coin_32);
                                return;
                            }
                            return;
                        }
                        LottieAnimationView done_coin_2 = (LottieAnimationView) GameGuideView.this.a(R.id.obfuscated_res_0x7f090915);
                        Intrinsics.checkNotNullExpressionValue(done_coin_2, "done_coin_2");
                        done_coin_2.setVisibility(0);
                        ImageView normal_coin_2 = (ImageView) GameGuideView.this.a(R.id.obfuscated_res_0x7f091953);
                        Intrinsics.checkNotNullExpressionValue(normal_coin_2, "normal_coin_2");
                        normal_coin_2.setVisibility(4);
                        ((LottieAnimationView) GameGuideView.this.a(R.id.obfuscated_res_0x7f090915)).playAnimation();
                        GameGuideView.this.b = 2;
                        GameGuideView gameGuideView2 = GameGuideView.this;
                        LottieAnimationView done_coin_22 = (LottieAnimationView) gameGuideView2.a(R.id.obfuscated_res_0x7f090915);
                        Intrinsics.checkNotNullExpressionValue(done_coin_22, "done_coin_2");
                        gameGuideView2.k(done_coin_22);
                        return;
                    }
                    LottieAnimationView done_coin_1 = (LottieAnimationView) GameGuideView.this.a(R.id.obfuscated_res_0x7f090914);
                    Intrinsics.checkNotNullExpressionValue(done_coin_1, "done_coin_1");
                    done_coin_1.setVisibility(0);
                    ImageView normal_coin_1 = (ImageView) GameGuideView.this.a(R.id.obfuscated_res_0x7f091952);
                    Intrinsics.checkNotNullExpressionValue(normal_coin_1, "normal_coin_1");
                    normal_coin_1.setVisibility(4);
                    ((LottieAnimationView) GameGuideView.this.a(R.id.obfuscated_res_0x7f090914)).playAnimation();
                    GameGuideView.this.b = 1;
                    GameGuideView gameGuideView3 = GameGuideView.this;
                    LottieAnimationView done_coin_12 = (LottieAnimationView) gameGuideView3.a(R.id.obfuscated_res_0x7f090914);
                    Intrinsics.checkNotNullExpressionValue(done_coin_12, "done_coin_1");
                    gameGuideView3.k(done_coin_12);
                    GameGuideView.this.j();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class f extends AnimatorListenerAdapter {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            LottieAnimationView bomb_view = (LottieAnimationView) GameGuideView.this.a(R.id.obfuscated_res_0x7f090415);
            Intrinsics.checkNotNullExpressionValue(bomb_view, "bomb_view");
            bomb_view.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        this.g = "";
        this.h = "";
        l();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        this.g = "";
        this.h = "";
        l();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideView(Context context, LottieComposition composition, Bitmap normalImg, String proColor, String tips) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(composition, "composition");
        Intrinsics.checkNotNullParameter(normalImg, "normalImg");
        Intrinsics.checkNotNullParameter(proColor, "proColor");
        Intrinsics.checkNotNullParameter(tips, "tips");
        this.g = "";
        this.h = "";
        this.f = composition;
        this.g = proColor;
        this.h = tips;
        this.i = normalImg;
        l();
    }

    private final void setSaveDisable(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.setSaveEnabled(false);
        }
        if (lottieAnimationView != null) {
            lottieAnimationView.setSaveFromParentEnabled(false);
        }
    }

    public final boolean i(long j) {
        if (j < 0) {
            if (ms1.a) {
                Log.d("GameTimeView", "传入的时间不能小于0");
            }
            return false;
        } else if (j > SapiWebView.DEFAULT_TIMEOUT_MILLIS && ms1.a) {
            Log.d("GameTimeView", "传入的时间大于最大值 90000");
            return false;
        } else {
            return true;
        }
    }

    public final void k(View view2) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimator.addUpdateListener(new a(view2));
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
        valueAnimator.setInterpolator(new OvershootInterpolator());
        valueAnimator.setDuration(250L);
        valueAnimator.start();
    }

    private final int getProgressViewWidth() {
        if (this.a == 0) {
            GameGuideProgressView progress_view = (GameGuideProgressView) a(R.id.obfuscated_res_0x7f091d42);
            Intrinsics.checkNotNullExpressionValue(progress_view, "progress_view");
            this.a = progress_view.getWidth();
        }
        return this.a;
    }

    private final float getTailingViewOriginCenterX() {
        if (this.c == 0.0f) {
            GameGuideProgressView progress_view = (GameGuideProgressView) a(R.id.obfuscated_res_0x7f091d42);
            Intrinsics.checkNotNullExpressionValue(progress_view, "progress_view");
            this.c = progress_view.getX() + getProgressViewWidth();
        }
        return this.c;
    }

    private final float getTailingViewOriginCenterY() {
        if (this.d == 0.0f) {
            GameGuideProgressView progress_view = (GameGuideProgressView) a(R.id.obfuscated_res_0x7f091d42);
            Intrinsics.checkNotNullExpressionValue(progress_view, "progress_view");
            float y = progress_view.getY();
            GameGuideProgressView progress_view2 = (GameGuideProgressView) a(R.id.obfuscated_res_0x7f091d42);
            Intrinsics.checkNotNullExpressionValue(progress_view2, "progress_view");
            this.d = y + (progress_view2.getHeight() / 2);
        }
        return this.d;
    }

    public final int getCurrentStatus() {
        return this.b;
    }

    public final void m() {
        LottieAnimationView tailing_view = (LottieAnimationView) a(R.id.obfuscated_res_0x7f0923c9);
        Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
        ViewGroup.LayoutParams layoutParams = tailing_view.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = 0;
            LottieAnimationView tailing_view2 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f0923c9);
            Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
            tailing_view2.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void t() {
        LottieAnimationView bomb_view = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090415);
        Intrinsics.checkNotNullExpressionValue(bomb_view, "bomb_view");
        bomb_view.setVisibility(0);
        ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090415)).playAnimation();
        ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090415)).addAnimatorListener(new f());
        q();
    }

    public final void j() {
        boolean z;
        if (!b24.o.L()) {
            if (this.h.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                TextView tips = (TextView) a(R.id.obfuscated_res_0x7f09250b);
                Intrinsics.checkNotNullExpressionValue(tips, "tips");
                tips.setVisibility(0);
                TextView tips2 = (TextView) a(R.id.obfuscated_res_0x7f09250b);
                Intrinsics.checkNotNullExpressionValue(tips2, "tips");
                tips2.setText(this.h);
                b24.o.b0();
            }
        }
    }

    public final void l() {
        boolean z = false;
        setSaveFromParentEnabled(false);
        setSaveEnabled(false);
        setLayerType(1, null);
        LayoutInflater.from(AppRuntime.getAppContext()).inflate(R.layout.obfuscated_res_0x7f0d00af, this);
        LottieComposition lottieComposition = this.f;
        if (lottieComposition != null) {
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090914)).setComposition(lottieComposition);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090915)).setComposition(lottieComposition);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090916)).setComposition(lottieComposition);
            LottieAnimationView done_coin_1 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090914);
            Intrinsics.checkNotNullExpressionValue(done_coin_1, "done_coin_1");
            done_coin_1.setRepeatCount(-1);
            LottieAnimationView done_coin_2 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090915);
            Intrinsics.checkNotNullExpressionValue(done_coin_2, "done_coin_2");
            done_coin_2.setRepeatCount(-1);
            LottieAnimationView done_coin_3 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090916);
            Intrinsics.checkNotNullExpressionValue(done_coin_3, "done_coin_3");
            done_coin_3.setRepeatCount(-1);
        }
        Bitmap bitmap = this.i;
        if (bitmap != null) {
            ((ImageView) a(R.id.obfuscated_res_0x7f091952)).setImageBitmap(bitmap);
            ((ImageView) a(R.id.obfuscated_res_0x7f091953)).setImageBitmap(bitmap);
            ((ImageView) a(R.id.obfuscated_res_0x7f091954)).setImageBitmap(bitmap);
        }
        if (this.g.length() > 0) {
            z = true;
        }
        if (z) {
            try {
                ((GameGuideProgressView) a(R.id.obfuscated_res_0x7f091d42)).setProgressColor(Color.parseColor(this.g));
            } catch (Exception e2) {
                if (ms1.a) {
                    throw e2;
                }
            }
        }
        ((LottieAnimationView) a(R.id.obfuscated_res_0x7f0921f7)).setAnimation(R.raw.obfuscated_res_0x7f110003);
        LottieAnimationView spark_view = (LottieAnimationView) a(R.id.obfuscated_res_0x7f0921f7);
        Intrinsics.checkNotNullExpressionValue(spark_view, "spark_view");
        spark_view.setRepeatCount(-1);
        ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090415)).setAnimation(R.raw.obfuscated_res_0x7f110002);
        ((LottieAnimationView) a(R.id.obfuscated_res_0x7f0923c9)).setAnimation(R.raw.obfuscated_res_0x7f110004);
        ((GameGuideProgressView) a(R.id.obfuscated_res_0x7f091d42)).setProgressListener(new b());
        setSaveDisable((LottieAnimationView) a(R.id.obfuscated_res_0x7f090914));
        setSaveDisable((LottieAnimationView) a(R.id.obfuscated_res_0x7f090915));
        setSaveDisable((LottieAnimationView) a(R.id.obfuscated_res_0x7f090915));
        setSaveDisable((LottieAnimationView) a(R.id.obfuscated_res_0x7f0921f7));
        setSaveDisable((LottieAnimationView) a(R.id.obfuscated_res_0x7f090415));
        setSaveDisable((LottieAnimationView) a(R.id.obfuscated_res_0x7f0923c9));
    }

    public final void n(float f2) {
        float progressViewWidth = getProgressViewWidth() * f2;
        LottieAnimationView spark_view = (LottieAnimationView) a(R.id.obfuscated_res_0x7f0921f7);
        Intrinsics.checkNotNullExpressionValue(spark_view, "spark_view");
        ViewGroup.LayoutParams layoutParams = spark_view.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginStart((int) progressViewWidth);
            LottieAnimationView spark_view2 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f0921f7);
            Intrinsics.checkNotNullExpressionValue(spark_view2, "spark_view");
            spark_view2.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void o(long j) {
        if (!i(j)) {
            return;
        }
        if (this.e) {
            if (ms1.a) {
                Log.e("GameTimeView", "已经在计时当中");
                return;
            }
            return;
        }
        s(j);
        if (j >= SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
            if (ms1.a) {
                Log.d("GameTimeView", "已经达到了最大的计时");
            }
            ((GameGuideProgressView) a(R.id.obfuscated_res_0x7f091d42)).i(1.0f);
            return;
        }
        this.e = true;
        ((GameGuideProgressView) a(R.id.obfuscated_res_0x7f091d42)).i(((float) (j % 30000)) / ((float) 30000));
    }

    public final void p() {
        this.e = false;
        ((GameGuideProgressView) a(R.id.obfuscated_res_0x7f091d42)).j();
        ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090914)).cancelAnimation();
        ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090915)).cancelAnimation();
        ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090916)).cancelAnimation();
        ((LottieAnimationView) a(R.id.obfuscated_res_0x7f0921f7)).cancelAnimation();
        ((LottieAnimationView) a(R.id.obfuscated_res_0x7f0923c9)).cancelAnimation();
        ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090415)).cancelAnimation();
        LottieAnimationView tailing_view = (LottieAnimationView) a(R.id.obfuscated_res_0x7f0923c9);
        Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
        tailing_view.setVisibility(4);
        LottieAnimationView bomb_view = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090415);
        Intrinsics.checkNotNullExpressionValue(bomb_view, "bomb_view");
        bomb_view.setVisibility(8);
    }

    public final void q() {
        float width;
        float height;
        long j;
        float f2;
        int i = this.b;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                ImageView normal_coin_3 = (ImageView) a(R.id.obfuscated_res_0x7f091954);
                Intrinsics.checkNotNullExpressionValue(normal_coin_3, "normal_coin_3");
                float x = normal_coin_3.getX();
                ImageView normal_coin_32 = (ImageView) a(R.id.obfuscated_res_0x7f091954);
                Intrinsics.checkNotNullExpressionValue(normal_coin_32, "normal_coin_3");
                width = x + (normal_coin_32.getWidth() / 2);
                ImageView normal_coin_33 = (ImageView) a(R.id.obfuscated_res_0x7f091954);
                Intrinsics.checkNotNullExpressionValue(normal_coin_33, "normal_coin_3");
                float y = normal_coin_33.getY();
                ImageView normal_coin_34 = (ImageView) a(R.id.obfuscated_res_0x7f091954);
                Intrinsics.checkNotNullExpressionValue(normal_coin_34, "normal_coin_3");
                height = y + (normal_coin_34.getHeight() / 2);
                j = 300;
                f2 = 0.33333334f;
            } else {
                ImageView normal_coin_2 = (ImageView) a(R.id.obfuscated_res_0x7f091953);
                Intrinsics.checkNotNullExpressionValue(normal_coin_2, "normal_coin_2");
                float x2 = normal_coin_2.getX();
                ImageView normal_coin_22 = (ImageView) a(R.id.obfuscated_res_0x7f091953);
                Intrinsics.checkNotNullExpressionValue(normal_coin_22, "normal_coin_2");
                width = x2 + (normal_coin_22.getWidth() / 2);
                ImageView normal_coin_23 = (ImageView) a(R.id.obfuscated_res_0x7f091953);
                Intrinsics.checkNotNullExpressionValue(normal_coin_23, "normal_coin_2");
                float y2 = normal_coin_23.getY();
                ImageView normal_coin_24 = (ImageView) a(R.id.obfuscated_res_0x7f091953);
                Intrinsics.checkNotNullExpressionValue(normal_coin_24, "normal_coin_2");
                height = y2 + (normal_coin_24.getHeight() / 2);
                j = 500;
                f2 = 1.4f;
            }
        } else {
            ImageView normal_coin_1 = (ImageView) a(R.id.obfuscated_res_0x7f091952);
            Intrinsics.checkNotNullExpressionValue(normal_coin_1, "normal_coin_1");
            float x3 = normal_coin_1.getX();
            ImageView normal_coin_12 = (ImageView) a(R.id.obfuscated_res_0x7f091952);
            Intrinsics.checkNotNullExpressionValue(normal_coin_12, "normal_coin_1");
            width = x3 + (normal_coin_12.getWidth() / 2);
            ImageView normal_coin_13 = (ImageView) a(R.id.obfuscated_res_0x7f091952);
            Intrinsics.checkNotNullExpressionValue(normal_coin_13, "normal_coin_1");
            float y3 = normal_coin_13.getY();
            ImageView normal_coin_14 = (ImageView) a(R.id.obfuscated_res_0x7f091952);
            Intrinsics.checkNotNullExpressionValue(normal_coin_14, "normal_coin_1");
            height = y3 + (normal_coin_14.getHeight() / 2);
            j = 700;
            f2 = 1.0f;
        }
        double atan2 = (180 * ((float) Math.atan2(getTailingViewOriginCenterY() - height, getTailingViewOriginCenterX() - width))) / 3.141592653589793d;
        LottieAnimationView tailing_view = (LottieAnimationView) a(R.id.obfuscated_res_0x7f0923c9);
        Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
        tailing_view.setVisibility(0);
        m();
        LottieAnimationView tailing_view2 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f0923c9);
        Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
        tailing_view2.setRotation(((float) atan2) - 90);
        LottieAnimationView tailing_view3 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f0923c9);
        Intrinsics.checkNotNullExpressionValue(tailing_view3, "tailing_view");
        tailing_view3.setSpeed(f2);
        ((LottieAnimationView) a(R.id.obfuscated_res_0x7f0923c9)).playAnimation();
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
        TextView tips = (TextView) a(R.id.obfuscated_res_0x7f09250b);
        Intrinsics.checkNotNullExpressionValue(tips, "tips");
        if (tips.getVisibility() == 0) {
            TextView tips2 = (TextView) a(R.id.obfuscated_res_0x7f09250b);
            Intrinsics.checkNotNullExpressionValue(tips2, "tips");
            tips2.setVisibility(8);
        }
        this.b = 0;
        ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090914)).cancelAnimation();
        LottieAnimationView done_coin_1 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090914);
        Intrinsics.checkNotNullExpressionValue(done_coin_1, "done_coin_1");
        done_coin_1.setVisibility(8);
        ImageView normal_coin_1 = (ImageView) a(R.id.obfuscated_res_0x7f091952);
        Intrinsics.checkNotNullExpressionValue(normal_coin_1, "normal_coin_1");
        normal_coin_1.setVisibility(0);
        ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090915)).cancelAnimation();
        LottieAnimationView done_coin_2 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090915);
        Intrinsics.checkNotNullExpressionValue(done_coin_2, "done_coin_2");
        done_coin_2.setVisibility(8);
        ImageView normal_coin_2 = (ImageView) a(R.id.obfuscated_res_0x7f091953);
        Intrinsics.checkNotNullExpressionValue(normal_coin_2, "normal_coin_2");
        normal_coin_2.setVisibility(0);
        ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090916)).cancelAnimation();
        LottieAnimationView done_coin_3 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090916);
        Intrinsics.checkNotNullExpressionValue(done_coin_3, "done_coin_3");
        done_coin_3.setVisibility(8);
        ImageView normal_coin_3 = (ImageView) a(R.id.obfuscated_res_0x7f091954);
        Intrinsics.checkNotNullExpressionValue(normal_coin_3, "normal_coin_3");
        normal_coin_3.setVisibility(0);
    }

    public final void s(long j) {
        LottieAnimationView tailing_view = (LottieAnimationView) a(R.id.obfuscated_res_0x7f0923c9);
        Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
        tailing_view.setVisibility(8);
        if (0 <= j && 30000 > j) {
            LottieAnimationView done_coin_1 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090914);
            Intrinsics.checkNotNullExpressionValue(done_coin_1, "done_coin_1");
            done_coin_1.setVisibility(8);
            ImageView normal_coin_1 = (ImageView) a(R.id.obfuscated_res_0x7f091952);
            Intrinsics.checkNotNullExpressionValue(normal_coin_1, "normal_coin_1");
            normal_coin_1.setVisibility(0);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090914)).cancelAnimation();
            LottieAnimationView done_coin_2 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090915);
            Intrinsics.checkNotNullExpressionValue(done_coin_2, "done_coin_2");
            done_coin_2.setVisibility(8);
            ImageView normal_coin_2 = (ImageView) a(R.id.obfuscated_res_0x7f091953);
            Intrinsics.checkNotNullExpressionValue(normal_coin_2, "normal_coin_2");
            normal_coin_2.setVisibility(0);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090915)).cancelAnimation();
            LottieAnimationView done_coin_3 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090916);
            Intrinsics.checkNotNullExpressionValue(done_coin_3, "done_coin_3");
            done_coin_3.setVisibility(8);
            ImageView normal_coin_3 = (ImageView) a(R.id.obfuscated_res_0x7f091954);
            Intrinsics.checkNotNullExpressionValue(normal_coin_3, "normal_coin_3");
            normal_coin_3.setVisibility(0);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090916)).cancelAnimation();
            LottieAnimationView spark_view = (LottieAnimationView) a(R.id.obfuscated_res_0x7f0921f7);
            Intrinsics.checkNotNullExpressionValue(spark_view, "spark_view");
            spark_view.setVisibility(0);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f0921f7)).playAnimation();
            this.b = 0;
        } else if (30000 <= j && 60000 > j) {
            LottieAnimationView done_coin_12 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090914);
            Intrinsics.checkNotNullExpressionValue(done_coin_12, "done_coin_1");
            done_coin_12.setVisibility(0);
            ImageView normal_coin_12 = (ImageView) a(R.id.obfuscated_res_0x7f091952);
            Intrinsics.checkNotNullExpressionValue(normal_coin_12, "normal_coin_1");
            normal_coin_12.setVisibility(4);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090914)).playAnimation();
            LottieAnimationView done_coin_22 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090915);
            Intrinsics.checkNotNullExpressionValue(done_coin_22, "done_coin_2");
            done_coin_22.setVisibility(8);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090915)).cancelAnimation();
            LottieAnimationView done_coin_32 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090916);
            Intrinsics.checkNotNullExpressionValue(done_coin_32, "done_coin_3");
            done_coin_32.setVisibility(8);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090916)).cancelAnimation();
            LottieAnimationView spark_view2 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f0921f7);
            Intrinsics.checkNotNullExpressionValue(spark_view2, "spark_view");
            spark_view2.setVisibility(0);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f0921f7)).playAnimation();
            this.b = 1;
        } else if (60000 <= j && SapiWebView.DEFAULT_TIMEOUT_MILLIS > j) {
            LottieAnimationView done_coin_13 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090914);
            Intrinsics.checkNotNullExpressionValue(done_coin_13, "done_coin_1");
            done_coin_13.setVisibility(0);
            ImageView normal_coin_13 = (ImageView) a(R.id.obfuscated_res_0x7f091952);
            Intrinsics.checkNotNullExpressionValue(normal_coin_13, "normal_coin_1");
            normal_coin_13.setVisibility(4);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090914)).playAnimation();
            LottieAnimationView done_coin_23 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090915);
            Intrinsics.checkNotNullExpressionValue(done_coin_23, "done_coin_2");
            done_coin_23.setVisibility(0);
            ImageView normal_coin_22 = (ImageView) a(R.id.obfuscated_res_0x7f091953);
            Intrinsics.checkNotNullExpressionValue(normal_coin_22, "normal_coin_2");
            normal_coin_22.setVisibility(4);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090915)).playAnimation();
            LottieAnimationView done_coin_33 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090916);
            Intrinsics.checkNotNullExpressionValue(done_coin_33, "done_coin_3");
            done_coin_33.setVisibility(8);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090916)).cancelAnimation();
            LottieAnimationView spark_view3 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f0921f7);
            Intrinsics.checkNotNullExpressionValue(spark_view3, "spark_view");
            spark_view3.setVisibility(0);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f0921f7)).playAnimation();
            this.b = 2;
        } else {
            LottieAnimationView done_coin_14 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090914);
            Intrinsics.checkNotNullExpressionValue(done_coin_14, "done_coin_1");
            done_coin_14.setVisibility(0);
            ImageView normal_coin_14 = (ImageView) a(R.id.obfuscated_res_0x7f091952);
            Intrinsics.checkNotNullExpressionValue(normal_coin_14, "normal_coin_1");
            normal_coin_14.setVisibility(4);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090914)).playAnimation();
            LottieAnimationView done_coin_24 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090915);
            Intrinsics.checkNotNullExpressionValue(done_coin_24, "done_coin_2");
            done_coin_24.setVisibility(0);
            ImageView normal_coin_23 = (ImageView) a(R.id.obfuscated_res_0x7f091953);
            Intrinsics.checkNotNullExpressionValue(normal_coin_23, "normal_coin_2");
            normal_coin_23.setVisibility(4);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090915)).playAnimation();
            LottieAnimationView done_coin_34 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f090916);
            Intrinsics.checkNotNullExpressionValue(done_coin_34, "done_coin_3");
            done_coin_34.setVisibility(0);
            ImageView normal_coin_32 = (ImageView) a(R.id.obfuscated_res_0x7f091954);
            Intrinsics.checkNotNullExpressionValue(normal_coin_32, "normal_coin_3");
            normal_coin_32.setVisibility(4);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f090916)).playAnimation();
            LottieAnimationView spark_view4 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f0921f7);
            Intrinsics.checkNotNullExpressionValue(spark_view4, "spark_view");
            spark_view4.setVisibility(8);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f0921f7)).cancelAnimation();
            this.b = 3;
        }
    }
}
