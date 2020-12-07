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
import android.support.annotation.Nullable;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.util.android.VibrateUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.skin.NightModeHelper;
/* loaded from: classes20.dex */
public class ExplosionCommentView extends FrameLayout implements View.OnClickListener {
    private static final boolean DEBUG = false;
    private static final int DEFAULT_VIBRATE_AMPLITUDE = 30;
    private static final int DEFAULT_VIBRATE_TIMING = 90;
    private static final String TAG = "ExplosionCommentView";
    private ExplosionAnimListener mAnimListener;
    private View.OnClickListener mBombClickListener;
    private FrameLayout mCommentItemCover;
    private ViewGroup mCommentItemLayout;
    private Context mContext;
    private BdBaseImageView mExplodingView;
    private LottieAnimationView mExplosionLottie;
    private TextView mExplosionText;
    private ImageView mExplosionView;
    private LottieAnimPopup mLottieAnimPopup;
    private FrameLayout mLottieContainer;
    private RelativeLayout mRoot;

    /* loaded from: classes20.dex */
    public interface ExplosionAnimListener {
        void onAnimEnd();

        void onAnimStart();

        boolean shouldStartAnim();
    }

    public ExplosionCommentView(Context context) {
        this(context, null);
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
        this.mRoot = (RelativeLayout) LayoutInflater.from(context).inflate(com.baidu.android.common.ui.R.layout.explosion_comment_layout, (ViewGroup) this, false);
        this.mExplosionView = (ImageView) this.mRoot.findViewById(com.baidu.android.common.ui.R.id.explosion_image);
        this.mExplosionText = (TextView) this.mRoot.findViewById(com.baidu.android.common.ui.R.id.explosion_text);
        setUI();
        this.mRoot.setOnTouchListener(new TouchStateListener());
        this.mRoot.setOnClickListener(this);
        addView(this.mRoot);
    }

    public void setUI() {
        if (this.mExplosionText != null) {
            this.mExplosionText.setTextColor(getContext().getApplicationContext().getResources().getColor(com.baidu.android.common.ui.R.color.bomb_comment_text_color));
        }
        if (this.mExplosionView != null) {
            this.mExplosionView.setImageDrawable(getContext().getApplicationContext().getResources().getDrawable(com.baidu.android.common.ui.R.drawable.explosion_comment_icon));
        }
    }

    public void setExplosionCommentRes(Drawable drawable) {
        if (this.mExplosionView != null) {
            this.mExplosionView.setImageDrawable(drawable);
        }
    }

    public void attachCommentItemLayout(ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("argument is illegal: comment item layout is null.");
        }
        this.mCommentItemLayout = viewGroup;
    }

    public void setOnExplosionAnimListener(ExplosionAnimListener explosionAnimListener) {
        this.mAnimListener = explosionAnimListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRoot) {
            bombComment();
            if (this.mBombClickListener != null) {
                this.mBombClickListener.onClick(view);
            }
        }
    }

    public void bombComment() {
        if (this.mLottieAnimPopup == null) {
            if (this.mAnimListener != null) {
                if (this.mAnimListener.shouldStartAnim()) {
                    this.mAnimListener.onAnimStart();
                } else {
                    return;
                }
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
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mLottieAnimPopup != null && this.mLottieAnimPopup.isShowing()) {
            this.mLottieAnimPopup.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCommentAlphaAnim() {
        if (this.mCommentItemLayout != null) {
            this.mCommentItemLayout.animate().alpha(0.0f).setDuration(160L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.ui.ExplosionCommentView.4
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetExplosionView() {
        if (this.mExplosionView != null) {
            this.mExplosionView.setImageDrawable(getContext().getApplicationContext().getResources().getDrawable(com.baidu.android.common.ui.R.drawable.explosion_comment_icon));
        }
        if (this.mRoot != null) {
            this.mRoot.setVisibility(0);
        }
        if (this.mCommentItemLayout != null) {
            this.mCommentItemLayout.setAlpha(1.0f);
        }
        this.mLottieAnimPopup = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCommentCoverAnim() {
        if (this.mLottieAnimPopup != null) {
            this.mLottieAnimPopup.startCommentCoverAnim();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playExplosionLottie() {
        if (this.mLottieAnimPopup != null) {
            this.mLottieAnimPopup.playExplosionLottie();
        }
    }

    private void prepareLottieAnimPopup() {
        this.mLottieAnimPopup = new LottieAnimPopup(this.mContext);
        this.mLottieAnimPopup.show();
    }

    private void startExplodingAnimPhase() {
        if (this.mLottieAnimPopup != null) {
            this.mLottieAnimPopup.startExplodingAnimPhase();
        }
    }

    /* loaded from: classes20.dex */
    public class LottieAnimPopup extends PopupWindow {
        private FrameLayout mContent;

        public LottieAnimPopup(Context context) {
            super(context);
            initPopup();
        }

        private void initPopup() {
            setClippingEnabled(false);
            setBackgroundDrawable(new ColorDrawable(0));
            setWidth(-1);
            setHeight(-1);
            this.mContent = new FrameLayout(ExplosionCommentView.this.mContext);
            this.mContent.setClickable(true);
            ExplosionCommentView.this.mCommentItemCover = new FrameLayout(ExplosionCommentView.this.mContext);
            ExplosionCommentView.this.mCommentItemCover.setBackgroundColor(SupportMenu.CATEGORY_MASK);
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

        public void show() {
            showAtLocation(((Activity) ExplosionCommentView.this.mContext).getWindow().getDecorView(), 51, 0, 0);
        }

        public void startExplodingAnimPhase() {
            ExplosionCommentView.this.mExplosionLottie = new LottieAnimationView(ExplosionCommentView.this.mContext);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            ExplosionCommentView.this.mLottieContainer.addView(ExplosionCommentView.this.mExplosionLottie, layoutParams);
            ExplosionCommentView.this.mExplodingView = new BdBaseImageView(ExplosionCommentView.this.mContext);
            ExplosionCommentView.this.mExplodingView.setImageDrawable(ExplosionCommentView.this.getContext().getApplicationContext().getResources().getDrawable(com.baidu.android.common.ui.R.drawable.exploded_comment_icon));
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

        public void startCommentCoverAnim() {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(ExplosionCommentView.this.mCommentItemCover, "alpha", 0.0f, 0.05f, 0.05f, 0.0f);
            ofFloat.setDuration(480L);
            ofFloat.start();
        }

        private void vibrate() {
            new VibrateUtils.Builder((Vibrator) ExplosionCommentView.this.mContext.getSystemService("vibrator"), new long[]{90}, ExplosionCommentView.this.mContext).amplitudes(new int[]{30}).build().vibrateStart();
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mBombClickListener = onClickListener;
    }
}
