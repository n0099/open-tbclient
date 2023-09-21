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
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.util.android.VibrateUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.skin.NightModeHelper;
/* loaded from: classes4.dex */
public class ExplosionCommentView extends FrameLayout implements View.OnClickListener {
    public static final boolean DEBUG = false;
    public static final int DEFAULT_VIBRATE_AMPLITUDE = 30;
    public static final int DEFAULT_VIBRATE_TIMING = 90;
    public static final String TAG = "ExplosionCommentView";
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

    /* loaded from: classes4.dex */
    public interface ExplosionAnimListener {
        void onAnimEnd();

        void onAnimStart();

        boolean shouldStartAnim();
    }

    /* loaded from: classes4.dex */
    public class LottieAnimPopup extends PopupWindow {
        public FrameLayout mContent;

        public LottieAnimPopup(Context context) {
            super(context);
            initPopup();
        }

        private void initPopup() {
            setClippingEnabled(false);
            setBackgroundDrawable(new ColorDrawable(0));
            setWidth(-1);
            setHeight(-1);
            FrameLayout frameLayout = new FrameLayout(ExplosionCommentView.this.mContext);
            this.mContent = frameLayout;
            frameLayout.setClickable(true);
            ExplosionCommentView.this.mCommentItemCover = new FrameLayout(ExplosionCommentView.this.mContext);
            ExplosionCommentView.this.mCommentItemCover.setBackgroundColor(-65536);
            ExplosionCommentView.this.mCommentItemCover.setAlpha(0.0f);
            Rect rect = new Rect();
            ExplosionCommentView.this.mCommentItemLayout.getGlobalVisibleRect(rect);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(rect.width(), rect.height());
            int[] iArr = new int[2];
            ExplosionCommentView.this.mCommentItemLayout.getLocationOnScreen(iArr);
            layoutParams.leftMargin = iArr[0];
            layoutParams.topMargin = iArr[1];
            this.mContent.addView(ExplosionCommentView.this.mCommentItemCover, layoutParams);
            int[] iArr2 = new int[2];
            ExplosionCommentView.this.mExplosionView.getLocationOnScreen(iArr2);
            int width = iArr2[0] + (ExplosionCommentView.this.mExplosionView.getWidth() / 2);
            int height = iArr2[1] + (ExplosionCommentView.this.mExplosionView.getHeight() / 2);
            ExplosionCommentView.this.mLottieContainer = new FrameLayout(ExplosionCommentView.this.mContext);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 74.0f), DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 74.0f));
            layoutParams2.leftMargin = width - (DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 74.0f) / 2);
            layoutParams2.topMargin = height - (DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 74.0f) / 2);
            this.mContent.addView(ExplosionCommentView.this.mLottieContainer, layoutParams2);
            setContentView(this.mContent);
        }

        public void startExplodingAnimPhase() {
            ExplosionCommentView.this.mExplosionLottie = new LottieAnimationView(ExplosionCommentView.this.mContext);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            ExplosionCommentView.this.mLottieContainer.addView(ExplosionCommentView.this.mExplosionLottie, layoutParams);
            ExplosionCommentView.this.mExplodingView = new BdBaseImageView(ExplosionCommentView.this.mContext);
            ExplosionCommentView.this.mExplodingView.setImageDrawable(ExplosionCommentView.this.getContext().getApplicationContext().getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080633));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 20.0f), DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 16.0f));
            layoutParams2.gravity = 17;
            ExplosionCommentView.this.mLottieContainer.addView(ExplosionCommentView.this.mExplodingView, layoutParams2);
            ExplosionCommentView.this.mRoot.setVisibility(4);
            ExplosionCommentView.this.mExplosionView.setScaleY(1.0f);
            ExplosionCommentView.this.mExplosionView.setScaleX(1.0f);
            ExplosionCommentView.this.mExplodingView.setVisibility(0);
            ExplosionCommentView.this.mExplodingView.animate().scaleY(4.0f).scaleX(4.0f).setDuration(160L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.ui.ExplosionCommentView.LottieAnimPopup.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    ExplosionCommentView.this.mRoot.postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.ExplosionCommentView.LottieAnimPopup.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ExplosionCommentView.this.mExplodingView.setVisibility(8);
                        }
                    }, 40L);
                }
            }).start();
            vibrate();
        }

        private void vibrate() {
            new VibrateUtils.Builder((Vibrator) ExplosionCommentView.this.mContext.getSystemService("vibrator"), new long[]{90}, ExplosionCommentView.this.mContext).amplitudes(new int[]{30}).build().vibrateStart();
        }

        public void playExplosionLottie() {
            String str;
            if (NightModeHelper.getNightModeSwitcherState()) {
                str = "explosion_comment_lottie_night.json";
            } else {
                str = "explosion_comment_lottie.json";
            }
            ExplosionCommentView.this.mExplosionLottie.setAnimation(str);
            ExplosionCommentView.this.mExplosionLottie.playAnimation();
            ExplosionCommentView.this.mExplosionLottie.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.ui.ExplosionCommentView.LottieAnimPopup.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                }
            });
        }

        public void show() {
            showAtLocation(((Activity) ExplosionCommentView.this.mContext).getWindow().getDecorView(), 51, 0, 0);
        }

        public void startCommentCoverAnim() {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(ExplosionCommentView.this.mCommentItemCover, Key.ALPHA, 0.0f, 0.05f, 0.05f, 0.0f);
            ofFloat.setDuration(480L);
            ofFloat.start();
        }
    }

    public ExplosionCommentView(Context context) {
        this(context, null);
    }

    public void attachCommentItemLayout(ViewGroup viewGroup) {
        this.mCommentItemLayout = viewGroup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.mRoot) {
            bombComment();
            View.OnClickListener onClickListener = this.mBombClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mBombClickListener = onClickListener;
    }

    public void setExplosionCommentRes(Drawable drawable) {
        ImageView imageView = this.mExplosionView;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setExplosionCommentTextColor(int i) {
        TextView textView = this.mExplosionText;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setExplosionCommentTextSize(float f) {
        TextView textView = this.mExplosionText;
        if (textView != null) {
            textView.setTextSize(f);
        }
    }

    public void setOnExplosionAnimListener(ExplosionAnimListener explosionAnimListener) {
        this.mAnimListener = explosionAnimListener;
    }

    public ExplosionCommentView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExplosionCommentView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init(context);
    }

    private void init(Context context) {
        this.mExplosionLottie = new LottieAnimationView(this.mContext);
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d02ca, (ViewGroup) this, false);
        this.mRoot = relativeLayout;
        this.mExplosionView = (ImageView) relativeLayout.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090aaf);
        this.mExplosionText = (TextView) this.mRoot.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090ab1);
        setUI();
        this.mRoot.setOnTouchListener(new TouchStateListener());
        this.mRoot.setOnClickListener(this);
        addView(this.mRoot);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playExplosionLottie() {
        LottieAnimPopup lottieAnimPopup = this.mLottieAnimPopup;
        if (lottieAnimPopup != null) {
            lottieAnimPopup.playExplosionLottie();
        }
    }

    private void prepareLottieAnimPopup() {
        LottieAnimPopup lottieAnimPopup = new LottieAnimPopup(this.mContext);
        this.mLottieAnimPopup = lottieAnimPopup;
        lottieAnimPopup.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetExplosionView() {
        if (this.mExplosionView != null) {
            this.mExplosionView.setImageDrawable(getContext().getApplicationContext().getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080634));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void startCommentAlphaAnim() {
        ViewGroup viewGroup = this.mCommentItemLayout;
        if (viewGroup == null) {
            return;
        }
        viewGroup.animate().alpha(0.0f).setDuration(160L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.ui.ExplosionCommentView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ExplosionCommentView.this.mLottieAnimPopup != null) {
                    ExplosionCommentView.this.mLottieAnimPopup.dismiss();
                }
                ExplosionCommentView.this.resetExplosionView();
                if (ExplosionCommentView.this.mAnimListener != null) {
                    ExplosionCommentView.this.mAnimListener.onAnimEnd();
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCommentCoverAnim() {
        LottieAnimPopup lottieAnimPopup = this.mLottieAnimPopup;
        if (lottieAnimPopup != null) {
            lottieAnimPopup.startCommentCoverAnim();
        }
    }

    private void startExplodingAnimPhase() {
        LottieAnimPopup lottieAnimPopup = this.mLottieAnimPopup;
        if (lottieAnimPopup != null) {
            lottieAnimPopup.startExplodingAnimPhase();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LottieAnimPopup lottieAnimPopup = this.mLottieAnimPopup;
        if (lottieAnimPopup != null && lottieAnimPopup.isShowing()) {
            this.mLottieAnimPopup.dismiss();
        }
    }

    public void bombComment() {
        if (this.mLottieAnimPopup != null) {
            return;
        }
        ExplosionAnimListener explosionAnimListener = this.mAnimListener;
        if (explosionAnimListener != null) {
            if (!explosionAnimListener.shouldStartAnim()) {
                return;
            }
            this.mAnimListener.onAnimStart();
        }
        prepareLottieAnimPopup();
        startExplodingAnimPhase();
        this.mRoot.postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.ExplosionCommentView.1
            @Override // java.lang.Runnable
            public void run() {
                ExplosionCommentView.this.playExplosionLottie();
            }
        }, 160L);
        this.mRoot.postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.ExplosionCommentView.2
            @Override // java.lang.Runnable
            public void run() {
                ExplosionCommentView.this.startCommentCoverAnim();
            }
        }, 120L);
        this.mRoot.postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.ExplosionCommentView.3
            @Override // java.lang.Runnable
            public void run() {
                ExplosionCommentView.this.startCommentAlphaAnim();
            }
        }, 520L);
    }

    public void setUI() {
        if (this.mExplosionText != null) {
            this.mExplosionText.setTextColor(getContext().getApplicationContext().getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f060193));
        }
        if (this.mExplosionView != null) {
            this.mExplosionView.setImageDrawable(getContext().getApplicationContext().getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080634));
        }
    }
}
