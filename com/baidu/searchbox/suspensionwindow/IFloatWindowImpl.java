package com.baidu.searchbox.suspensionwindow;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.baidu.searchbox.suspensionwindow.SuspensionWindow;
import com.baidu.searchbox.suspensionwindow.barrierpool.BarrierPool;
import com.baidu.searchbox.suspensionwindow.cancelwindow.CancelWindowManager;
import com.baidu.searchbox.suspensionwindow.util.DeviceUtil;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class IFloatWindowImpl extends IFloatWindow {
    private static final String TAG = "IFloatWindowImpl";
    private static int mScreenHeight;
    private static int mScreenWidth;
    private static int mStatusHeight;
    private AnimatorSet mAnimatorSet;
    private SuspensionWindow.Builder mBuilder;
    private Rect mCancelWindowRect;
    private boolean mClick = false;
    private float mDownX;
    private float mDownY;
    private FloatView mFloatView;
    private boolean mIsVibrated;
    private int mSlop;
    private float mUpX;
    private float mUpY;
    private Vibrator mVibrator;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IFloatWindowImpl(SuspensionWindow.Builder builder) {
        this.mBuilder = builder;
        if (mScreenWidth == 0) {
            mScreenWidth = DeviceUtil.getScreenWidth(builder.mApplicationContext);
        }
        if (mScreenHeight == 0) {
            mScreenHeight = DeviceUtil.getScreenHeight(builder.mApplicationContext);
        }
        if (mStatusHeight == 0) {
            mStatusHeight = DeviceUtil.getStatusBarHeight(builder.mApplicationContext);
        }
        this.mVibrator = (Vibrator) builder.mApplicationContext.getSystemService("vibrator");
        this.mFloatView = new FloatPhone(builder.mApplicationContext);
        this.mFloatView.setSize(builder.mWidth, builder.mHeight);
        this.mFloatView.setGravity(builder.mGravity, builder.mXOffset, builder.mYOffset);
        this.mFloatView.setView(builder.mView);
        BarrierPool.getInstance().setSpacing(builder.mSpacing);
        BarrierPool.getInstance().setPadding(builder.mLeftPadding, builder.mTopPadding, builder.mRightPadding, builder.mBottomPadding);
        initTouchEvent();
    }

    @Override // com.baidu.searchbox.suspensionwindow.IFloatWindow
    public void show() {
        this.mFloatView.init();
        if (!isShowing()) {
            getView().setVisibility(0);
            BarrierPool.getInstance().add(1, this.mBuilder.mView);
            if (this.mBuilder.mSuspensionListener != null) {
                this.mBuilder.mSuspensionListener.onStateChange(this.mBuilder.mTag, 1);
            }
        }
    }

    @Override // com.baidu.searchbox.suspensionwindow.IFloatWindow
    public void hide() {
        if (this.mFloatView.isInited() && isShowing()) {
            getView().setVisibility(4);
            BarrierPool.getInstance().remove(this.mBuilder.mView);
            if (this.mBuilder.mSuspensionListener != null) {
                this.mBuilder.mSuspensionListener.onStateChange(this.mBuilder.mTag, 2);
            }
        }
    }

    @Override // com.baidu.searchbox.suspensionwindow.IFloatWindow
    public boolean isShowing() {
        return this.mBuilder != null && this.mBuilder.mView != null && this.mBuilder.mView.isAttachedToWindow() && this.mBuilder.mView.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.searchbox.suspensionwindow.IFloatWindow
    public void dismiss() {
        this.mFloatView.dismiss();
        BarrierPool.getInstance().remove(this.mBuilder.mView);
    }

    @Override // com.baidu.searchbox.suspensionwindow.IFloatWindow
    public void updateX(float f) {
        this.mBuilder.mXOffset = f;
        this.mFloatView.updateX(f);
    }

    @Override // com.baidu.searchbox.suspensionwindow.IFloatWindow
    public void updateX(int i, float f) {
        this.mBuilder.mXOffset = (i == 0 ? mScreenWidth : mScreenHeight) * f;
        this.mFloatView.updateX(this.mBuilder.mXOffset);
    }

    @Override // com.baidu.searchbox.suspensionwindow.IFloatWindow
    public void updateY(float f) {
        this.mBuilder.mYOffset = f;
        this.mFloatView.updateY(f);
    }

    @Override // com.baidu.searchbox.suspensionwindow.IFloatWindow
    public void updateY(int i, float f) {
        this.mBuilder.mYOffset = (i == 0 ? mScreenWidth : mScreenHeight) * f;
        this.mFloatView.updateY(this.mBuilder.mYOffset);
    }

    @Override // com.baidu.searchbox.suspensionwindow.IFloatWindow
    public float getX() {
        return this.mFloatView.getX();
    }

    @Override // com.baidu.searchbox.suspensionwindow.IFloatWindow
    public float getY() {
        return this.mFloatView.getY();
    }

    @Override // com.baidu.searchbox.suspensionwindow.IFloatWindow
    public View getView() {
        this.mSlop = ViewConfiguration.get(this.mBuilder.mApplicationContext).getScaledTouchSlop();
        return this.mBuilder.mView;
    }

    @Override // com.baidu.searchbox.suspensionwindow.IFloatWindow
    public void setTag(@NonNull String str) {
        this.mBuilder.setTag(str);
    }

    @Override // com.baidu.searchbox.suspensionwindow.IFloatWindow
    public String getTag() {
        return this.mBuilder.mTag;
    }

    private void initTouchEvent() {
        getView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.searchbox.suspensionwindow.IFloatWindowImpl.1
            float changeX;
            float changeY;
            float lastX;
            float lastY;
            float newX;
            float newY;

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        if (IFloatWindowImpl.this.mBuilder.mSuspensionListener != null) {
                            IFloatWindowImpl.this.mBuilder.mSuspensionListener.onTouchChange(IFloatWindowImpl.this.mBuilder.mTag, 1, null);
                        }
                        IFloatWindowImpl.this.mDownX = motionEvent.getRawX();
                        IFloatWindowImpl.this.mDownY = motionEvent.getRawY();
                        this.lastX = motionEvent.getRawX();
                        this.lastY = motionEvent.getRawY();
                        IFloatWindowImpl.this.cancelAnimator();
                        break;
                    case 1:
                        CancelWindowManager.getInstance().hide();
                        IFloatWindowImpl.this.mUpX = motionEvent.getRawX();
                        IFloatWindowImpl.this.mUpY = motionEvent.getRawY();
                        IFloatWindowImpl.this.mClick = Math.abs(IFloatWindowImpl.this.mUpX - IFloatWindowImpl.this.mDownX) > ((float) IFloatWindowImpl.this.mSlop) || Math.abs(IFloatWindowImpl.this.mUpY - IFloatWindowImpl.this.mDownY) > ((float) IFloatWindowImpl.this.mSlop);
                        if (!IFloatWindowImpl.this.mIsVibrated || IFloatWindowImpl.this.mBuilder.mSuspensionListener == null) {
                            Rect destinationRect = BarrierPool.getInstance().getDestinationRect(IFloatWindowImpl.this.mBuilder.mView);
                            if (destinationRect != null) {
                                IFloatWindowImpl.this.mAnimatorSet = new AnimatorSet();
                                ValueAnimator ofFloat = ObjectAnimator.ofFloat(IFloatWindowImpl.this.mFloatView.getX(), destinationRect.left);
                                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.suspensionwindow.IFloatWindowImpl.1.1
                                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                        IFloatWindowImpl.this.mFloatView.updateX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                    }
                                });
                                ValueAnimator ofFloat2 = ObjectAnimator.ofFloat(IFloatWindowImpl.this.mFloatView.getY(), destinationRect.top + IFloatWindowImpl.mStatusHeight);
                                ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.suspensionwindow.IFloatWindowImpl.1.2
                                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                        IFloatWindowImpl.this.mFloatView.updateY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                    }
                                });
                                IFloatWindowImpl.this.mAnimatorSet.play(ofFloat).with(ofFloat2);
                                if (IFloatWindowImpl.this.mClick && !IFloatWindowImpl.this.mIsVibrated && IFloatWindowImpl.this.mBuilder.mSuspensionListener != null) {
                                    IFloatWindowImpl.this.mBuilder.mSuspensionListener.onTouchChange(IFloatWindowImpl.this.mBuilder.mTag, 4, destinationRect);
                                }
                                IFloatWindowImpl.this.startAnimator(destinationRect);
                                break;
                            }
                        } else {
                            IFloatWindowImpl.this.mBuilder.mSuspensionListener.onTouchChange(IFloatWindowImpl.this.mBuilder.mTag, 5, null);
                            break;
                        }
                        break;
                    case 2:
                        if (Math.abs(motionEvent.getRawX() - IFloatWindowImpl.this.mDownX) > 60.0f || Math.abs(motionEvent.getRawY() - IFloatWindowImpl.this.mDownY) > 60.0f) {
                            CancelWindowManager.getInstance().show();
                        }
                        this.changeX = motionEvent.getRawX() - this.lastX;
                        this.changeY = motionEvent.getRawY() - this.lastY;
                        this.newX = IFloatWindowImpl.this.mFloatView.getX() + this.changeX;
                        this.newY = IFloatWindowImpl.this.mFloatView.getY() + this.changeY;
                        IFloatWindowImpl.this.mFloatView.updateXY(this.newX, this.newY);
                        this.lastX = motionEvent.getRawX();
                        this.lastY = motionEvent.getRawY();
                        if (IFloatWindowImpl.this.mCancelWindowRect == null) {
                            IFloatWindowImpl.this.mCancelWindowRect = CancelWindowManager.getInstance().getCancelWindowRect();
                        }
                        if (IFloatWindowImpl.this.mCancelWindowRect != null) {
                            if (this.newX <= IFloatWindowImpl.this.mCancelWindowRect.left || this.newY + IFloatWindowImpl.mStatusHeight <= IFloatWindowImpl.this.mCancelWindowRect.top) {
                                if (IFloatWindowImpl.this.mIsVibrated) {
                                    IFloatWindowImpl.this.mIsVibrated = false;
                                    IFloatWindowImpl.this.mVibrator.cancel();
                                    CancelWindowManager.getInstance().unfocus();
                                    break;
                                }
                            } else if (!IFloatWindowImpl.this.mIsVibrated) {
                                IFloatWindowImpl.this.mIsVibrated = true;
                                IFloatWindowImpl.this.mVibrator.vibrate(20L);
                                CancelWindowManager.getInstance().focus();
                                break;
                            }
                        }
                        break;
                }
                return IFloatWindowImpl.this.mClick;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnimator(Rect rect) {
        this.mAnimatorSet.setDuration(this.mBuilder.mDuration);
        this.mAnimatorSet.setInterpolator(this.mBuilder.mInterpolator);
        this.mAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.suspensionwindow.IFloatWindowImpl.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Iterator<Animator> it = IFloatWindowImpl.this.mAnimatorSet.getChildAnimations().iterator();
                while (it.hasNext()) {
                    ((ValueAnimator) it.next()).removeAllUpdateListeners();
                }
                IFloatWindowImpl.this.mAnimatorSet.removeAllListeners();
                IFloatWindowImpl.this.mAnimatorSet = null;
            }
        });
        this.mAnimatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelAnimator() {
        if (this.mAnimatorSet != null && this.mAnimatorSet.isRunning()) {
            this.mAnimatorSet.cancel();
        }
    }
}
