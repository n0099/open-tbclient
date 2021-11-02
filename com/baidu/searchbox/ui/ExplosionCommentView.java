package com.baidu.searchbox.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.android.VibrateUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ExplosionCommentView extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_VIBRATE_AMPLITUDE = 30;
    public static final int DEFAULT_VIBRATE_TIMING = 90;
    public static final String TAG = "ExplosionCommentView";
    public transient /* synthetic */ FieldHolder $fh;
    public ExplosionAnimListener mAnimListener;
    public View.OnClickListener mBombClickListener;
    public FrameLayout mCommentItemCover;
    public ViewGroup mCommentItemLayout;
    public Context mContext;
    public BdBaseImageView mExplodingView;
    public LottieAnimationView mExplosionLottie;
    public TextView mExplosionText;
    public ImageView mExplosionView;
    public LottieAnimPopup mLottieAnimPopup;
    public FrameLayout mLottieContainer;
    public RelativeLayout mRoot;

    /* loaded from: classes7.dex */
    public interface ExplosionAnimListener {
        void onAnimEnd();

        void onAnimStart();

        boolean shouldStartAnim();
    }

    /* loaded from: classes7.dex */
    public class LottieAnimPopup extends PopupWindow {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FrameLayout mContent;
        public final /* synthetic */ ExplosionCommentView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LottieAnimPopup(ExplosionCommentView explosionCommentView, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {explosionCommentView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = explosionCommentView;
            initPopup();
        }

        private void initPopup() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                setClippingEnabled(false);
                setBackgroundDrawable(new ColorDrawable(0));
                setWidth(-1);
                setHeight(-1);
                FrameLayout frameLayout = new FrameLayout(this.this$0.mContext);
                this.mContent = frameLayout;
                frameLayout.setClickable(true);
                this.this$0.mCommentItemCover = new FrameLayout(this.this$0.mContext);
                this.this$0.mCommentItemCover.setBackgroundColor(-65536);
                this.this$0.mCommentItemCover.setAlpha(0.0f);
                Rect rect = new Rect();
                this.this$0.mCommentItemLayout.getGlobalVisibleRect(rect);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(rect.width(), rect.height());
                int[] iArr = new int[2];
                this.this$0.mCommentItemLayout.getLocationOnScreen(iArr);
                layoutParams.leftMargin = iArr[0];
                layoutParams.topMargin = iArr[1];
                this.mContent.addView(this.this$0.mCommentItemCover, layoutParams);
                int[] iArr2 = new int[2];
                this.this$0.mExplosionView.getLocationOnScreen(iArr2);
                int width = iArr2[0] + (this.this$0.mExplosionView.getWidth() / 2);
                int height = iArr2[1] + (this.this$0.mExplosionView.getHeight() / 2);
                this.this$0.mLottieContainer = new FrameLayout(this.this$0.mContext);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 74.0f), DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 74.0f));
                layoutParams2.leftMargin = width - (DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 74.0f) / 2);
                layoutParams2.topMargin = height - (DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 74.0f) / 2);
                this.mContent.addView(this.this$0.mLottieContainer, layoutParams2);
                setContentView(this.mContent);
            }
        }

        private void vibrate() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                new VibrateUtils.Builder((Vibrator) this.this$0.mContext.getSystemService("vibrator"), new long[]{90}, this.this$0.mContext).amplitudes(new int[]{30}).build().vibrateStart();
            }
        }

        public void playExplosionLottie() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.mExplosionLottie.setAnimation(NightModeHelper.getNightModeSwitcherState() ? "explosion_comment_lottie_night.json" : "explosion_comment_lottie.json");
                this.this$0.mExplosionLottie.playAnimation();
                this.this$0.mExplosionLottie.addAnimatorListener(new AnimatorListenerAdapter(this) { // from class: com.baidu.searchbox.ui.ExplosionCommentView.LottieAnimPopup.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieAnimPopup this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                            super.onAnimationEnd(animator);
                        }
                    }
                });
            }
        }

        public void show() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                showAtLocation(((Activity) this.this$0.mContext).getWindow().getDecorView(), 51, 0, 0);
            }
        }

        public void startCommentCoverAnim() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.this$0.mCommentItemCover, Key.ALPHA, 0.0f, 0.05f, 0.05f, 0.0f);
                ofFloat.setDuration(480L);
                ofFloat.start();
            }
        }

        public void startExplodingAnimPhase() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.this$0.mExplosionLottie = new LottieAnimationView(this.this$0.mContext);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                this.this$0.mLottieContainer.addView(this.this$0.mExplosionLottie, layoutParams);
                this.this$0.mExplodingView = new BdBaseImageView(this.this$0.mContext);
                this.this$0.mExplodingView.setImageDrawable(this.this$0.getContext().getApplicationContext().getResources().getDrawable(com.baidu.android.common.ui.R.drawable.exploded_comment_icon));
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 20.0f), DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 16.0f));
                layoutParams2.gravity = 17;
                this.this$0.mLottieContainer.addView(this.this$0.mExplodingView, layoutParams2);
                this.this$0.mRoot.setVisibility(4);
                this.this$0.mExplosionView.setScaleY(1.0f);
                this.this$0.mExplosionView.setScaleX(1.0f);
                this.this$0.mExplodingView.setVisibility(0);
                this.this$0.mExplodingView.animate().scaleY(4.0f).scaleX(4.0f).setDuration(160L).setListener(new AnimatorListenerAdapter(this) { // from class: com.baidu.searchbox.ui.ExplosionCommentView.LottieAnimPopup.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieAnimPopup this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                            super.onAnimationEnd(animator);
                            this.this$1.this$0.mRoot.postDelayed(new Runnable(this) { // from class: com.baidu.searchbox.ui.ExplosionCommentView.LottieAnimPopup.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$2;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$2 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.this$2.this$1.this$0.mExplodingView.setVisibility(8);
                                    }
                                }
                            }, 40L);
                        }
                    }
                }).start();
                vibrate();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExplosionCommentView(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, context) == null) {
            this.mExplosionLottie = new LottieAnimationView(this.mContext);
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(com.baidu.android.common.ui.R.layout.explosion_comment_layout, (ViewGroup) this, false);
            this.mRoot = relativeLayout;
            this.mExplosionView = (ImageView) relativeLayout.findViewById(com.baidu.android.common.ui.R.id.explosion_image);
            this.mExplosionText = (TextView) this.mRoot.findViewById(com.baidu.android.common.ui.R.id.explosion_text);
            setUI();
            this.mRoot.setOnTouchListener(new TouchStateListener());
            this.mRoot.setOnClickListener(this);
            addView(this.mRoot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playExplosionLottie() {
        LottieAnimPopup lottieAnimPopup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || (lottieAnimPopup = this.mLottieAnimPopup) == null) {
            return;
        }
        lottieAnimPopup.playExplosionLottie();
    }

    private void prepareLottieAnimPopup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            LottieAnimPopup lottieAnimPopup = new LottieAnimPopup(this, this.mContext);
            this.mLottieAnimPopup = lottieAnimPopup;
            lottieAnimPopup.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetExplosionView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            if (this.mExplosionView != null) {
                this.mExplosionView.setImageDrawable(getContext().getApplicationContext().getResources().getDrawable(com.baidu.android.common.ui.R.drawable.explosion_comment_icon));
            }
            RelativeLayout relativeLayout = this.mRoot;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            ViewGroup viewGroup = this.mCommentItemLayout;
            if (viewGroup != null) {
                viewGroup.setAlpha(1.0f);
            }
            this.mLottieAnimPopup = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCommentAlphaAnim() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || (viewGroup = this.mCommentItemLayout) == null) {
            return;
        }
        viewGroup.animate().alpha(0.0f).setDuration(160L).setListener(new AnimatorListenerAdapter(this) { // from class: com.baidu.searchbox.ui.ExplosionCommentView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ExplosionCommentView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    if (this.this$0.mLottieAnimPopup != null) {
                        this.this$0.mLottieAnimPopup.dismiss();
                    }
                    this.this$0.resetExplosionView();
                    if (this.this$0.mAnimListener != null) {
                        this.this$0.mAnimListener.onAnimEnd();
                    }
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCommentCoverAnim() {
        LottieAnimPopup lottieAnimPopup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || (lottieAnimPopup = this.mLottieAnimPopup) == null) {
            return;
        }
        lottieAnimPopup.startCommentCoverAnim();
    }

    private void startExplodingAnimPhase() {
        LottieAnimPopup lottieAnimPopup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65563, this) == null) || (lottieAnimPopup = this.mLottieAnimPopup) == null) {
            return;
        }
        lottieAnimPopup.startExplodingAnimPhase();
    }

    public void attachCommentItemLayout(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
            if (viewGroup != null) {
                this.mCommentItemLayout = viewGroup;
                return;
            }
            throw new IllegalArgumentException("argument is illegal: comment item layout is null.");
        }
    }

    public void bombComment() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.mLottieAnimPopup == null) {
            ExplosionAnimListener explosionAnimListener = this.mAnimListener;
            if (explosionAnimListener != null) {
                if (!explosionAnimListener.shouldStartAnim()) {
                    return;
                }
                this.mAnimListener.onAnimStart();
            }
            prepareLottieAnimPopup();
            startExplodingAnimPhase();
            this.mRoot.postDelayed(new Runnable(this) { // from class: com.baidu.searchbox.ui.ExplosionCommentView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ExplosionCommentView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.playExplosionLottie();
                    }
                }
            }, 160L);
            this.mRoot.postDelayed(new Runnable(this) { // from class: com.baidu.searchbox.ui.ExplosionCommentView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ExplosionCommentView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.startCommentCoverAnim();
                    }
                }
            }, 120L);
            this.mRoot.postDelayed(new Runnable(this) { // from class: com.baidu.searchbox.ui.ExplosionCommentView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ExplosionCommentView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.startCommentAlphaAnim();
                    }
                }
            }, 520L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) && view == this.mRoot) {
            bombComment();
            View.OnClickListener onClickListener = this.mBombClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            LottieAnimPopup lottieAnimPopup = this.mLottieAnimPopup;
            if (lottieAnimPopup == null || !lottieAnimPopup.isShowing()) {
                return;
            }
            this.mLottieAnimPopup.dismiss();
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.mBombClickListener = onClickListener;
        }
    }

    public void setExplosionCommentRes(Drawable drawable) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, drawable) == null) || (imageView = this.mExplosionView) == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
    }

    public void setExplosionCommentTextSize(float f2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048582, this, f2) == null) || (textView = this.mExplosionText) == null) {
            return;
        }
        textView.setTextSize(f2);
    }

    public void setOnExplosionAnimListener(ExplosionAnimListener explosionAnimListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, explosionAnimListener) == null) {
            this.mAnimListener = explosionAnimListener;
        }
    }

    public void setUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.mExplosionText != null) {
                this.mExplosionText.setTextColor(getContext().getApplicationContext().getResources().getColor(com.baidu.android.common.ui.R.color.GC1));
            }
            if (this.mExplosionView != null) {
                this.mExplosionView.setImageDrawable(getContext().getApplicationContext().getResources().getDrawable(com.baidu.android.common.ui.R.drawable.explosion_comment_icon));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExplosionCommentView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExplosionCommentView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.mContext = context;
        init(context);
    }
}
