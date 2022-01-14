package c.a.t0.e2.k;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.live.interfaces.like.ILiveLikeView;
import com.baidu.searchbox.live.interfaces.like.LiveLikeAnimatorCallback;
import com.baidu.tieba.medialive.like.HeartSurfaceView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c implements ILiveLikeView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public int f17146b;

    /* renamed from: c  reason: collision with root package name */
    public float f17147c;

    /* loaded from: classes7.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f17148e;

        public a(c cVar, LottieAnimationView lottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, lottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17148e = lottieAnimationView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f17148e.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements HeartSurfaceView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveLikeAnimatorCallback a;

        public b(c cVar, LiveLikeAnimatorCallback liveLikeAnimatorCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, liveLikeAnimatorCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveLikeAnimatorCallback;
        }

        @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.e
        public void a(int i2, int i3) {
            LiveLikeAnimatorCallback liveLikeAnimatorCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || (liveLikeAnimatorCallback = this.a) == null) {
                return;
            }
            liveLikeAnimatorCallback.onAnimLocation(0, i2, i3);
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1.0f;
        this.f17146b = 500;
        this.f17147c = 0.4f;
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public void addLikeAnimation(View view, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) && (view instanceof HeartSurfaceView)) {
            ((HeartSurfaceView) view).addHeart(i2);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public View getLikeAnimatorView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LottieAnimationView lottieAnimationView = new LottieAnimationView(AppRuntime.getAppContext());
            lottieAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            lottieAnimationView.setAnimation("lottie/liveshow_video_like_explosion.json");
            return lottieAnimationView;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public View getLikeRippleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LottieAnimationView lottieAnimationView = new LottieAnimationView(AppRuntime.getAppContext());
            lottieAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            lottieAnimationView.setAnimation("lottie/liveshow_video_like_bg.json");
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f17147c, this.a);
            ofFloat.setDuration(this.f17146b);
            ofFloat.addUpdateListener(new a(this, lottieAnimationView));
            lottieAnimationView.setTag(ofFloat);
            return lottieAnimationView;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public View getLikeView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HeartSurfaceView heartSurfaceView = new HeartSurfaceView(AppRuntime.getAppContext());
            heartSurfaceView.setUpResNormalMode();
            heartSurfaceView.setZOrderOnTop(true);
            heartSurfaceView.getHolder().setFormat(-3);
            return heartSurfaceView;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public void playAnimation(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view) == null) && (view instanceof LottieAnimationView)) {
            ((LottieAnimationView) view).playAnimation();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public void setAnimatorListener(View view, Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, view, animatorListener) == null) && (view instanceof LottieAnimationView)) {
            ((LottieAnimationView) view).addAnimatorListener(animatorListener);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public void setLikeAnimatorListener(View view, LiveLikeAnimatorCallback liveLikeAnimatorCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, view, liveLikeAnimatorCallback) == null) && (view instanceof LottieAnimationView)) {
            ((HeartSurfaceView) view).setAnimateEndListener(new b(this, liveLikeAnimatorCallback));
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public void startRipple(View view) {
        Object tag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view) == null) && (view instanceof LottieAnimationView) && (tag = view.getTag()) != null && (tag instanceof ValueAnimator)) {
            ((ValueAnimator) tag).start();
        }
    }
}
