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
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.swan.game.guide.view.GameGuideProgressView;
import com.baidu.tieba.R;
import com.baidu.tieba.du3;
import com.baidu.tieba.ok1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010?\u001a\u00020)\u0012\u0006\u0010@\u001a\u000201\u0012\u0006\u0010A\u001a\u00020,\u0012\u0006\u0010B\u001a\u00020,¢\u0006\u0004\bC\u0010DB\u0019\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010F\u001a\u00020E¢\u0006\u0004\bC\u0010GB!\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010F\u001a\u00020E\u0012\u0006\u0010H\u001a\u00020\u000e¢\u0006\u0004\bC\u0010IJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\tJ!\u0010\u0015\u001a\u00020\u00072\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\tJ\u0015\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010\tJ\u000f\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010\tJ\r\u0010$\u001a\u00020\u0007¢\u0006\u0004\b$\u0010\tJ\u0017\u0010%\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b%\u0010!J\u000f\u0010&\u001a\u00020\u0007H\u0002¢\u0006\u0004\b&\u0010\tR\u0016\u0010'\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010.R\u001c\u00105\u001a\u00020\u000e8B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b5\u0010(\u001a\u0004\b6\u0010\u0010R\u001c\u00107\u001a\u00020\u00188B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001c\u0010;\u001a\u00020\u00188B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b;\u00108\u001a\u0004\b<\u0010:¨\u0006J"}, d2 = {"Lcom/baidu/swan/game/guide/view/GameGuideView;", "Landroid/widget/FrameLayout;", "", "gameTime", "", "checkGameTimeAvailable", "(J)Z", "", "checkIsShowTips", "()V", "Landroid/view/View;", "coinView", "doCoinScaleAnim", "(Landroid/view/View;)V", "", "getCurrentStatus", "()I", "init", "Landroid/util/SparseArray;", "Landroid/os/Parcelable;", "container", "restoreHierarchyState", "(Landroid/util/SparseArray;)V", "restoreTailingView", "", "currentProgress", "reviseViewLayout", "(F)V", "Lcom/airbnb/lottie/LottieAnimationView;", NativeConstants.TYPE_VIEW, "setSaveDisable", "(Lcom/airbnb/lottie/LottieAnimationView;)V", FetchLog.START_TIME, "(J)V", "stopTime", "translateTailingView", "updateStatusWhenClick", "updateViewStatusByGameTimeWhenStart", "updateWhenOneProgressEnd", "currentStatus", "I", "Lcom/airbnb/lottie/LottieComposition;", "doneComposition", "Lcom/airbnb/lottie/LottieComposition;", "", "firstDoneTips", "Ljava/lang/String;", "isOnTiming", "Z", "Landroid/graphics/Bitmap;", "normalIconImg", "Landroid/graphics/Bitmap;", WBConstants.TRANS_PROGRESS_COLOR, "progressViewWidth", "getProgressViewWidth", "tailingViewOriginCenterX", "F", "getTailingViewOriginCenterX", "()F", "tailingViewOriginCenterY", "getTailingViewOriginCenterY", "Landroid/content/Context;", "context", "composition", "normalImg", "proColor", "tips", "<init>", "(Landroid/content/Context;Lcom/airbnb/lottie/LottieComposition;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gameguide_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class GameGuideView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
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
        return (View) invokeI.objValue;
    }

    @Override // android.view.View
    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, sparseArray) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
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
    }

    /* loaded from: classes3.dex */
    public static final class b implements GameGuideProgressView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameGuideView a;

        @Override // com.baidu.swan.game.guide.view.GameGuideProgressView.a
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b(GameGuideView gameGuideView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameGuideView;
        }

        @Override // com.baidu.swan.game.guide.view.GameGuideProgressView.a
        public void a(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
                this.a.n(f);
            }
        }

        @Override // com.baidu.swan.game.guide.view.GameGuideProgressView.a
        public void b(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
                this.a.n(f);
            }
        }

        @Override // com.baidu.swan.game.guide.view.GameGuideProgressView.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.e && (this.a.b == 0 || this.a.b == 1)) {
                    ((GameGuideProgressView) this.a.a(R.id.obfuscated_res_0x7f091b82)).i(0.0f);
                }
                this.a.t();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameGuideView a;

        public c(GameGuideView gameGuideView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameGuideView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Object animatedValue = it.getAnimatedValue();
                if (animatedValue != null) {
                    float floatValue = ((Float) animatedValue).floatValue();
                    LottieAnimationView tailing_view = (LottieAnimationView) this.a.a(R.id.obfuscated_res_0x7f092197);
                    Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
                    ViewGroup.LayoutParams layoutParams = tailing_view.getLayoutParams();
                    if (layoutParams != null) {
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = (int) floatValue;
                        LottieAnimationView tailing_view2 = (LottieAnimationView) this.a.a(R.id.obfuscated_res_0x7f092197);
                        Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
                        tailing_view2.setLayoutParams(layoutParams2);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameGuideView a;

        public d(GameGuideView gameGuideView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameGuideView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Object animatedValue = it.getAnimatedValue();
                if (animatedValue != null) {
                    float floatValue = ((Float) animatedValue).floatValue();
                    LottieAnimationView tailing_view = (LottieAnimationView) this.a.a(R.id.obfuscated_res_0x7f092197);
                    Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
                    ViewGroup.LayoutParams layoutParams = tailing_view.getLayoutParams();
                    if (layoutParams != null) {
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = (int) floatValue;
                        LottieAnimationView tailing_view2 = (LottieAnimationView) this.a.a(R.id.obfuscated_res_0x7f092197);
                        Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
                        tailing_view2.setLayoutParams(layoutParams2);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameGuideView a;
        public final /* synthetic */ Ref.BooleanRef b;
        public final /* synthetic */ double c;

        public e(GameGuideView gameGuideView, Ref.BooleanRef booleanRef, double d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideView, booleanRef, Double.valueOf(d)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameGuideView;
            this.b = booleanRef;
            this.c = d;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                if (this.a.e) {
                    Ref.BooleanRef booleanRef = this.b;
                    if (!booleanRef.element) {
                        booleanRef.element = true;
                        LottieAnimationView tailing_view = (LottieAnimationView) this.a.a(R.id.obfuscated_res_0x7f092197);
                        Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
                        tailing_view.setRotation(90 - ((float) this.c));
                        this.a.m();
                        LottieAnimationView tailing_view2 = (LottieAnimationView) this.a.a(R.id.obfuscated_res_0x7f092197);
                        Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
                        tailing_view2.setVisibility(8);
                        int i = this.a.b;
                        if (i != 0) {
                            if (i != 1) {
                                if (i == 2) {
                                    LottieAnimationView done_coin_3 = (LottieAnimationView) this.a.a(R.id.obfuscated_res_0x7f09085e);
                                    Intrinsics.checkNotNullExpressionValue(done_coin_3, "done_coin_3");
                                    done_coin_3.setVisibility(0);
                                    ImageView normal_coin_3 = (ImageView) this.a.a(R.id.obfuscated_res_0x7f091797);
                                    Intrinsics.checkNotNullExpressionValue(normal_coin_3, "normal_coin_3");
                                    normal_coin_3.setVisibility(4);
                                    ((LottieAnimationView) this.a.a(R.id.obfuscated_res_0x7f09085e)).playAnimation();
                                    this.a.b = 3;
                                    ((LottieAnimationView) this.a.a(R.id.obfuscated_res_0x7f091fea)).cancelAnimation();
                                    LottieAnimationView spark_view = (LottieAnimationView) this.a.a(R.id.obfuscated_res_0x7f091fea);
                                    Intrinsics.checkNotNullExpressionValue(spark_view, "spark_view");
                                    spark_view.setVisibility(8);
                                    GameGuideView gameGuideView = this.a;
                                    LottieAnimationView done_coin_32 = (LottieAnimationView) gameGuideView.a(R.id.obfuscated_res_0x7f09085e);
                                    Intrinsics.checkNotNullExpressionValue(done_coin_32, "done_coin_3");
                                    gameGuideView.k(done_coin_32);
                                    return;
                                }
                                return;
                            }
                            LottieAnimationView done_coin_2 = (LottieAnimationView) this.a.a(R.id.obfuscated_res_0x7f09085d);
                            Intrinsics.checkNotNullExpressionValue(done_coin_2, "done_coin_2");
                            done_coin_2.setVisibility(0);
                            ImageView normal_coin_2 = (ImageView) this.a.a(R.id.obfuscated_res_0x7f091796);
                            Intrinsics.checkNotNullExpressionValue(normal_coin_2, "normal_coin_2");
                            normal_coin_2.setVisibility(4);
                            ((LottieAnimationView) this.a.a(R.id.obfuscated_res_0x7f09085d)).playAnimation();
                            this.a.b = 2;
                            GameGuideView gameGuideView2 = this.a;
                            LottieAnimationView done_coin_22 = (LottieAnimationView) gameGuideView2.a(R.id.obfuscated_res_0x7f09085d);
                            Intrinsics.checkNotNullExpressionValue(done_coin_22, "done_coin_2");
                            gameGuideView2.k(done_coin_22);
                            return;
                        }
                        LottieAnimationView done_coin_1 = (LottieAnimationView) this.a.a(R.id.obfuscated_res_0x7f09085c);
                        Intrinsics.checkNotNullExpressionValue(done_coin_1, "done_coin_1");
                        done_coin_1.setVisibility(0);
                        ImageView normal_coin_1 = (ImageView) this.a.a(R.id.obfuscated_res_0x7f091795);
                        Intrinsics.checkNotNullExpressionValue(normal_coin_1, "normal_coin_1");
                        normal_coin_1.setVisibility(4);
                        ((LottieAnimationView) this.a.a(R.id.obfuscated_res_0x7f09085c)).playAnimation();
                        this.a.b = 1;
                        GameGuideView gameGuideView3 = this.a;
                        LottieAnimationView done_coin_12 = (LottieAnimationView) gameGuideView3.a(R.id.obfuscated_res_0x7f09085c);
                        Intrinsics.checkNotNullExpressionValue(done_coin_12, "done_coin_1");
                        gameGuideView3.k(done_coin_12);
                        this.a.j();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class f extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameGuideView a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public f(GameGuideView gameGuideView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameGuideView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                LottieAnimationView bomb_view = (LottieAnimationView) this.a.a(R.id.obfuscated_res_0x7f0903cf);
                Intrinsics.checkNotNullExpressionValue(bomb_view, "bomb_view");
                bomb_view.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        this.g = "";
        this.h = "";
        l();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        this.g = "";
        this.h = "";
        l();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameGuideView(Context context, LottieComposition composition, Bitmap normalImg, String proColor, String tips) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, composition, normalImg, proColor, tips};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, lottieAnimationView) == null) {
            if (lottieAnimationView != null) {
                lottieAnimationView.setSaveEnabled(false);
            }
            if (lottieAnimationView != null) {
                lottieAnimationView.setSaveFromParentEnabled(false);
            }
        }
    }

    private final int getProgressViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (this.a == 0) {
                GameGuideProgressView progress_view = (GameGuideProgressView) a(R.id.obfuscated_res_0x7f091b82);
                Intrinsics.checkNotNullExpressionValue(progress_view, "progress_view");
                this.a = progress_view.getWidth();
            }
            return this.a;
        }
        return invokeV.intValue;
    }

    public final int getCurrentStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    private final float getTailingViewOriginCenterX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.c == 0.0f) {
                GameGuideProgressView progress_view = (GameGuideProgressView) a(R.id.obfuscated_res_0x7f091b82);
                Intrinsics.checkNotNullExpressionValue(progress_view, "progress_view");
                this.c = progress_view.getX() + getProgressViewWidth();
            }
            return this.c;
        }
        return invokeV.floatValue;
    }

    private final float getTailingViewOriginCenterY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.d == 0.0f) {
                GameGuideProgressView progress_view = (GameGuideProgressView) a(R.id.obfuscated_res_0x7f091b82);
                Intrinsics.checkNotNullExpressionValue(progress_view, "progress_view");
                float y = progress_view.getY();
                GameGuideProgressView progress_view2 = (GameGuideProgressView) a(R.id.obfuscated_res_0x7f091b82);
                Intrinsics.checkNotNullExpressionValue(progress_view2, "progress_view");
                this.d = y + (progress_view2.getHeight() / 2);
            }
            return this.d;
        }
        return invokeV.floatValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LottieAnimationView tailing_view = (LottieAnimationView) a(R.id.obfuscated_res_0x7f092197);
            Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
            ViewGroup.LayoutParams layoutParams = tailing_view.getLayoutParams();
            if (layoutParams != null) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = 0;
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = 0;
                LottieAnimationView tailing_view2 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f092197);
                Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
                tailing_view2.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            LottieAnimationView bomb_view = (LottieAnimationView) a(R.id.obfuscated_res_0x7f0903cf);
            Intrinsics.checkNotNullExpressionValue(bomb_view, "bomb_view");
            bomb_view.setVisibility(0);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f0903cf)).playAnimation();
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f0903cf)).addAnimatorListener(new f(this));
            q();
        }
    }

    public final boolean i(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            if (j < 0) {
                if (ok1.a) {
                    Log.d("GameTimeView", "传入的时间不能小于0");
                }
                return false;
            } else if (j > SapiWebView.DEFAULT_TIMEOUT_MILLIS && ok1.a) {
                Log.d("GameTimeView", "传入的时间大于最大值 90000");
                return false;
            } else {
                return true;
            }
        }
        return invokeJ.booleanValue;
    }

    public final void k(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimator.addUpdateListener(new a(view2));
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
            valueAnimator.setInterpolator(new OvershootInterpolator());
            valueAnimator.setDuration(250L);
            valueAnimator.start();
        }
    }

    public final void n(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            float progressViewWidth = getProgressViewWidth() * f2;
            LottieAnimationView spark_view = (LottieAnimationView) a(R.id.obfuscated_res_0x7f091fea);
            Intrinsics.checkNotNullExpressionValue(spark_view, "spark_view");
            ViewGroup.LayoutParams layoutParams = spark_view.getLayoutParams();
            if (layoutParams != null) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.setMarginStart((int) progressViewWidth);
                LottieAnimationView spark_view2 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f091fea);
                Intrinsics.checkNotNullExpressionValue(spark_view2, "spark_view");
                spark_view2.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
    }

    public final void j() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !du3.o.L()) {
            if (this.h.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                TextView tips = (TextView) a(R.id.obfuscated_res_0x7f0922d1);
                Intrinsics.checkNotNullExpressionValue(tips, "tips");
                tips.setVisibility(0);
                TextView tips2 = (TextView) a(R.id.obfuscated_res_0x7f0922d1);
                Intrinsics.checkNotNullExpressionValue(tips2, "tips");
                tips2.setText(this.h);
                du3.o.b0();
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            boolean z = false;
            setSaveFromParentEnabled(false);
            setSaveEnabled(false);
            setLayerType(1, null);
            LayoutInflater.from(AppRuntime.getAppContext()).inflate(R.layout.obfuscated_res_0x7f0d00ab, this);
            LottieComposition lottieComposition = this.f;
            if (lottieComposition != null) {
                ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085c)).setComposition(lottieComposition);
                ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085d)).setComposition(lottieComposition);
                ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085e)).setComposition(lottieComposition);
                LottieAnimationView done_coin_1 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f09085c);
                Intrinsics.checkNotNullExpressionValue(done_coin_1, "done_coin_1");
                done_coin_1.setRepeatCount(-1);
                LottieAnimationView done_coin_2 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f09085d);
                Intrinsics.checkNotNullExpressionValue(done_coin_2, "done_coin_2");
                done_coin_2.setRepeatCount(-1);
                LottieAnimationView done_coin_3 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f09085e);
                Intrinsics.checkNotNullExpressionValue(done_coin_3, "done_coin_3");
                done_coin_3.setRepeatCount(-1);
            }
            Bitmap bitmap = this.i;
            if (bitmap != null) {
                ((ImageView) a(R.id.obfuscated_res_0x7f091795)).setImageBitmap(bitmap);
                ((ImageView) a(R.id.obfuscated_res_0x7f091796)).setImageBitmap(bitmap);
                ((ImageView) a(R.id.obfuscated_res_0x7f091797)).setImageBitmap(bitmap);
            }
            if (this.g.length() > 0) {
                z = true;
            }
            if (z) {
                try {
                    ((GameGuideProgressView) a(R.id.obfuscated_res_0x7f091b82)).setProgressColor(Color.parseColor(this.g));
                } catch (Exception e2) {
                    if (ok1.a) {
                        throw e2;
                    }
                }
            }
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f091fea)).setAnimation(R.raw.obfuscated_res_0x7f110003);
            LottieAnimationView spark_view = (LottieAnimationView) a(R.id.obfuscated_res_0x7f091fea);
            Intrinsics.checkNotNullExpressionValue(spark_view, "spark_view");
            spark_view.setRepeatCount(-1);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f0903cf)).setAnimation(R.raw.obfuscated_res_0x7f110002);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f092197)).setAnimation(R.raw.obfuscated_res_0x7f110004);
            ((GameGuideProgressView) a(R.id.obfuscated_res_0x7f091b82)).setProgressListener(new b(this));
            setSaveDisable((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085c));
            setSaveDisable((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085d));
            setSaveDisable((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085d));
            setSaveDisable((LottieAnimationView) a(R.id.obfuscated_res_0x7f091fea));
            setSaveDisable((LottieAnimationView) a(R.id.obfuscated_res_0x7f0903cf));
            setSaveDisable((LottieAnimationView) a(R.id.obfuscated_res_0x7f092197));
        }
    }

    public final void o(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) != null) || !i(j)) {
            return;
        }
        if (this.e) {
            if (ok1.a) {
                Log.e("GameTimeView", "已经在计时当中");
                return;
            }
            return;
        }
        s(j);
        if (j >= SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
            if (ok1.a) {
                Log.d("GameTimeView", "已经达到了最大的计时");
            }
            ((GameGuideProgressView) a(R.id.obfuscated_res_0x7f091b82)).i(1.0f);
            return;
        }
        this.e = true;
        ((GameGuideProgressView) a(R.id.obfuscated_res_0x7f091b82)).i(((float) (j % 30000)) / ((float) 30000));
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.e = false;
            ((GameGuideProgressView) a(R.id.obfuscated_res_0x7f091b82)).j();
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085c)).cancelAnimation();
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085d)).cancelAnimation();
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085e)).cancelAnimation();
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f091fea)).cancelAnimation();
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f092197)).cancelAnimation();
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f0903cf)).cancelAnimation();
            LottieAnimationView tailing_view = (LottieAnimationView) a(R.id.obfuscated_res_0x7f092197);
            Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
            tailing_view.setVisibility(4);
            LottieAnimationView bomb_view = (LottieAnimationView) a(R.id.obfuscated_res_0x7f0903cf);
            Intrinsics.checkNotNullExpressionValue(bomb_view, "bomb_view");
            bomb_view.setVisibility(8);
        }
    }

    public final void q() {
        float width;
        float height;
        long j;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int i = this.b;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return;
                    }
                    ImageView normal_coin_3 = (ImageView) a(R.id.obfuscated_res_0x7f091797);
                    Intrinsics.checkNotNullExpressionValue(normal_coin_3, "normal_coin_3");
                    float x = normal_coin_3.getX();
                    ImageView normal_coin_32 = (ImageView) a(R.id.obfuscated_res_0x7f091797);
                    Intrinsics.checkNotNullExpressionValue(normal_coin_32, "normal_coin_3");
                    width = x + (normal_coin_32.getWidth() / 2);
                    ImageView normal_coin_33 = (ImageView) a(R.id.obfuscated_res_0x7f091797);
                    Intrinsics.checkNotNullExpressionValue(normal_coin_33, "normal_coin_3");
                    float y = normal_coin_33.getY();
                    ImageView normal_coin_34 = (ImageView) a(R.id.obfuscated_res_0x7f091797);
                    Intrinsics.checkNotNullExpressionValue(normal_coin_34, "normal_coin_3");
                    height = y + (normal_coin_34.getHeight() / 2);
                    j = 300;
                    f2 = 0.33333334f;
                } else {
                    ImageView normal_coin_2 = (ImageView) a(R.id.obfuscated_res_0x7f091796);
                    Intrinsics.checkNotNullExpressionValue(normal_coin_2, "normal_coin_2");
                    float x2 = normal_coin_2.getX();
                    ImageView normal_coin_22 = (ImageView) a(R.id.obfuscated_res_0x7f091796);
                    Intrinsics.checkNotNullExpressionValue(normal_coin_22, "normal_coin_2");
                    width = x2 + (normal_coin_22.getWidth() / 2);
                    ImageView normal_coin_23 = (ImageView) a(R.id.obfuscated_res_0x7f091796);
                    Intrinsics.checkNotNullExpressionValue(normal_coin_23, "normal_coin_2");
                    float y2 = normal_coin_23.getY();
                    ImageView normal_coin_24 = (ImageView) a(R.id.obfuscated_res_0x7f091796);
                    Intrinsics.checkNotNullExpressionValue(normal_coin_24, "normal_coin_2");
                    height = y2 + (normal_coin_24.getHeight() / 2);
                    j = 500;
                    f2 = 1.4f;
                }
            } else {
                ImageView normal_coin_1 = (ImageView) a(R.id.obfuscated_res_0x7f091795);
                Intrinsics.checkNotNullExpressionValue(normal_coin_1, "normal_coin_1");
                float x3 = normal_coin_1.getX();
                ImageView normal_coin_12 = (ImageView) a(R.id.obfuscated_res_0x7f091795);
                Intrinsics.checkNotNullExpressionValue(normal_coin_12, "normal_coin_1");
                width = x3 + (normal_coin_12.getWidth() / 2);
                ImageView normal_coin_13 = (ImageView) a(R.id.obfuscated_res_0x7f091795);
                Intrinsics.checkNotNullExpressionValue(normal_coin_13, "normal_coin_1");
                float y3 = normal_coin_13.getY();
                ImageView normal_coin_14 = (ImageView) a(R.id.obfuscated_res_0x7f091795);
                Intrinsics.checkNotNullExpressionValue(normal_coin_14, "normal_coin_1");
                height = y3 + (normal_coin_14.getHeight() / 2);
                j = 700;
                f2 = 1.0f;
            }
            double atan2 = (180 * ((float) Math.atan2(getTailingViewOriginCenterY() - height, getTailingViewOriginCenterX() - width))) / 3.141592653589793d;
            LottieAnimationView tailing_view = (LottieAnimationView) a(R.id.obfuscated_res_0x7f092197);
            Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
            tailing_view.setVisibility(0);
            m();
            LottieAnimationView tailing_view2 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f092197);
            Intrinsics.checkNotNullExpressionValue(tailing_view2, "tailing_view");
            tailing_view2.setRotation(((float) atan2) - 90);
            LottieAnimationView tailing_view3 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f092197);
            Intrinsics.checkNotNullExpressionValue(tailing_view3, "tailing_view");
            tailing_view3.setSpeed(f2);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f092197)).playAnimation();
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = false;
            ValueAnimator xValueAnimator = ValueAnimator.ofFloat(0.0f, getTailingViewOriginCenterX() - width);
            xValueAnimator.addUpdateListener(new c(this));
            Intrinsics.checkNotNullExpressionValue(xValueAnimator, "xValueAnimator");
            xValueAnimator.setInterpolator(new LinearInterpolator());
            ValueAnimator yValueAnimator = ValueAnimator.ofFloat(0.0f, getTailingViewOriginCenterY() - height);
            yValueAnimator.addUpdateListener(new d(this));
            Intrinsics.checkNotNullExpressionValue(yValueAnimator, "yValueAnimator");
            yValueAnimator.setInterpolator(new LinearInterpolator());
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(j);
            animatorSet.play(xValueAnimator).with(yValueAnimator);
            animatorSet.addListener(new e(this, booleanRef, atan2));
            animatorSet.start();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            TextView tips = (TextView) a(R.id.obfuscated_res_0x7f0922d1);
            Intrinsics.checkNotNullExpressionValue(tips, "tips");
            if (tips.getVisibility() == 0) {
                TextView tips2 = (TextView) a(R.id.obfuscated_res_0x7f0922d1);
                Intrinsics.checkNotNullExpressionValue(tips2, "tips");
                tips2.setVisibility(8);
            }
            this.b = 0;
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085c)).cancelAnimation();
            LottieAnimationView done_coin_1 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f09085c);
            Intrinsics.checkNotNullExpressionValue(done_coin_1, "done_coin_1");
            done_coin_1.setVisibility(8);
            ImageView normal_coin_1 = (ImageView) a(R.id.obfuscated_res_0x7f091795);
            Intrinsics.checkNotNullExpressionValue(normal_coin_1, "normal_coin_1");
            normal_coin_1.setVisibility(0);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085d)).cancelAnimation();
            LottieAnimationView done_coin_2 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f09085d);
            Intrinsics.checkNotNullExpressionValue(done_coin_2, "done_coin_2");
            done_coin_2.setVisibility(8);
            ImageView normal_coin_2 = (ImageView) a(R.id.obfuscated_res_0x7f091796);
            Intrinsics.checkNotNullExpressionValue(normal_coin_2, "normal_coin_2");
            normal_coin_2.setVisibility(0);
            ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085e)).cancelAnimation();
            LottieAnimationView done_coin_3 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f09085e);
            Intrinsics.checkNotNullExpressionValue(done_coin_3, "done_coin_3");
            done_coin_3.setVisibility(8);
            ImageView normal_coin_3 = (ImageView) a(R.id.obfuscated_res_0x7f091797);
            Intrinsics.checkNotNullExpressionValue(normal_coin_3, "normal_coin_3");
            normal_coin_3.setVisibility(0);
        }
    }

    public final void s(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            LottieAnimationView tailing_view = (LottieAnimationView) a(R.id.obfuscated_res_0x7f092197);
            Intrinsics.checkNotNullExpressionValue(tailing_view, "tailing_view");
            tailing_view.setVisibility(8);
            if (0 <= j && 30000 > j) {
                LottieAnimationView done_coin_1 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f09085c);
                Intrinsics.checkNotNullExpressionValue(done_coin_1, "done_coin_1");
                done_coin_1.setVisibility(8);
                ImageView normal_coin_1 = (ImageView) a(R.id.obfuscated_res_0x7f091795);
                Intrinsics.checkNotNullExpressionValue(normal_coin_1, "normal_coin_1");
                normal_coin_1.setVisibility(0);
                ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085c)).cancelAnimation();
                LottieAnimationView done_coin_2 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f09085d);
                Intrinsics.checkNotNullExpressionValue(done_coin_2, "done_coin_2");
                done_coin_2.setVisibility(8);
                ImageView normal_coin_2 = (ImageView) a(R.id.obfuscated_res_0x7f091796);
                Intrinsics.checkNotNullExpressionValue(normal_coin_2, "normal_coin_2");
                normal_coin_2.setVisibility(0);
                ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085d)).cancelAnimation();
                LottieAnimationView done_coin_3 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f09085e);
                Intrinsics.checkNotNullExpressionValue(done_coin_3, "done_coin_3");
                done_coin_3.setVisibility(8);
                ImageView normal_coin_3 = (ImageView) a(R.id.obfuscated_res_0x7f091797);
                Intrinsics.checkNotNullExpressionValue(normal_coin_3, "normal_coin_3");
                normal_coin_3.setVisibility(0);
                ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085e)).cancelAnimation();
                LottieAnimationView spark_view = (LottieAnimationView) a(R.id.obfuscated_res_0x7f091fea);
                Intrinsics.checkNotNullExpressionValue(spark_view, "spark_view");
                spark_view.setVisibility(0);
                ((LottieAnimationView) a(R.id.obfuscated_res_0x7f091fea)).playAnimation();
                this.b = 0;
            } else if (30000 <= j && 60000 > j) {
                LottieAnimationView done_coin_12 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f09085c);
                Intrinsics.checkNotNullExpressionValue(done_coin_12, "done_coin_1");
                done_coin_12.setVisibility(0);
                ImageView normal_coin_12 = (ImageView) a(R.id.obfuscated_res_0x7f091795);
                Intrinsics.checkNotNullExpressionValue(normal_coin_12, "normal_coin_1");
                normal_coin_12.setVisibility(4);
                ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085c)).playAnimation();
                LottieAnimationView done_coin_22 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f09085d);
                Intrinsics.checkNotNullExpressionValue(done_coin_22, "done_coin_2");
                done_coin_22.setVisibility(8);
                ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085d)).cancelAnimation();
                LottieAnimationView done_coin_32 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f09085e);
                Intrinsics.checkNotNullExpressionValue(done_coin_32, "done_coin_3");
                done_coin_32.setVisibility(8);
                ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085e)).cancelAnimation();
                LottieAnimationView spark_view2 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f091fea);
                Intrinsics.checkNotNullExpressionValue(spark_view2, "spark_view");
                spark_view2.setVisibility(0);
                ((LottieAnimationView) a(R.id.obfuscated_res_0x7f091fea)).playAnimation();
                this.b = 1;
            } else if (60000 <= j && SapiWebView.DEFAULT_TIMEOUT_MILLIS > j) {
                LottieAnimationView done_coin_13 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f09085c);
                Intrinsics.checkNotNullExpressionValue(done_coin_13, "done_coin_1");
                done_coin_13.setVisibility(0);
                ImageView normal_coin_13 = (ImageView) a(R.id.obfuscated_res_0x7f091795);
                Intrinsics.checkNotNullExpressionValue(normal_coin_13, "normal_coin_1");
                normal_coin_13.setVisibility(4);
                ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085c)).playAnimation();
                LottieAnimationView done_coin_23 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f09085d);
                Intrinsics.checkNotNullExpressionValue(done_coin_23, "done_coin_2");
                done_coin_23.setVisibility(0);
                ImageView normal_coin_22 = (ImageView) a(R.id.obfuscated_res_0x7f091796);
                Intrinsics.checkNotNullExpressionValue(normal_coin_22, "normal_coin_2");
                normal_coin_22.setVisibility(4);
                ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085d)).playAnimation();
                LottieAnimationView done_coin_33 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f09085e);
                Intrinsics.checkNotNullExpressionValue(done_coin_33, "done_coin_3");
                done_coin_33.setVisibility(8);
                ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085e)).cancelAnimation();
                LottieAnimationView spark_view3 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f091fea);
                Intrinsics.checkNotNullExpressionValue(spark_view3, "spark_view");
                spark_view3.setVisibility(0);
                ((LottieAnimationView) a(R.id.obfuscated_res_0x7f091fea)).playAnimation();
                this.b = 2;
            } else {
                LottieAnimationView done_coin_14 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f09085c);
                Intrinsics.checkNotNullExpressionValue(done_coin_14, "done_coin_1");
                done_coin_14.setVisibility(0);
                ImageView normal_coin_14 = (ImageView) a(R.id.obfuscated_res_0x7f091795);
                Intrinsics.checkNotNullExpressionValue(normal_coin_14, "normal_coin_1");
                normal_coin_14.setVisibility(4);
                ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085c)).playAnimation();
                LottieAnimationView done_coin_24 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f09085d);
                Intrinsics.checkNotNullExpressionValue(done_coin_24, "done_coin_2");
                done_coin_24.setVisibility(0);
                ImageView normal_coin_23 = (ImageView) a(R.id.obfuscated_res_0x7f091796);
                Intrinsics.checkNotNullExpressionValue(normal_coin_23, "normal_coin_2");
                normal_coin_23.setVisibility(4);
                ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085d)).playAnimation();
                LottieAnimationView done_coin_34 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f09085e);
                Intrinsics.checkNotNullExpressionValue(done_coin_34, "done_coin_3");
                done_coin_34.setVisibility(0);
                ImageView normal_coin_32 = (ImageView) a(R.id.obfuscated_res_0x7f091797);
                Intrinsics.checkNotNullExpressionValue(normal_coin_32, "normal_coin_3");
                normal_coin_32.setVisibility(4);
                ((LottieAnimationView) a(R.id.obfuscated_res_0x7f09085e)).playAnimation();
                LottieAnimationView spark_view4 = (LottieAnimationView) a(R.id.obfuscated_res_0x7f091fea);
                Intrinsics.checkNotNullExpressionValue(spark_view4, "spark_view");
                spark_view4.setVisibility(8);
                ((LottieAnimationView) a(R.id.obfuscated_res_0x7f091fea)).cancelAnimation();
                this.b = 3;
            }
        }
    }
}
