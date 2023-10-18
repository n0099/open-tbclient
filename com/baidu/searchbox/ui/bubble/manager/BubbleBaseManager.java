package com.baidu.searchbox.ui.bubble.manager;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.ui.bubble.BubbleHistory;
import com.baidu.searchbox.ui.bubble.BubbleLocationManager;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager;
import com.baidu.searchbox.ui.bubble.views.BubbleBaseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public abstract class BubbleBaseManager {
    public static final boolean DEBUG = false;
    public static final String TAG = "BubbleBaseManager";
    public BubbleHandler mBubbleHandler;
    public boolean mEnableAnchorClk;
    public boolean mEnableAnimation;
    public boolean mEnableBgClk;
    public boolean mIsShowing;
    public boolean mNeedUpdateLocation;
    public ObjectAnimator mObjectAnimator;
    public BubbleManager.OnAnchorClickListener mOnAnchorClickListener;
    public BubbleManager.OnBubbleEventListener mOnBubbleEventListener;
    public boolean mShowAnimationEnd;
    public BubbleBaseView mViews;
    public int[] oldAnchorPos;
    public boolean mAutoDismiss = true;
    public int mAutoDismissInterval = 7000;
    public boolean mEnableClkDismiss = true;
    public float mBubbleViewAlpha = 1.0f;
    public BubbleLocationManager mLocation = new BubbleLocationManager();

    public abstract BubbleBaseView getViews();

    public abstract void onShow();

    /* loaded from: classes4.dex */
    public static class BubbleHandler extends Handler {
        public static final int MSG_DISMISS = 0;
        public final WeakReference<BubbleBaseManager> mBubbleManager;

        public BubbleHandler(BubbleBaseManager bubbleBaseManager) {
            this.mBubbleManager = new WeakReference<>(bubbleBaseManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BubbleBaseManager bubbleBaseManager;
            if (message.what == 0 && (bubbleBaseManager = this.mBubbleManager.get()) != null) {
                bubbleBaseManager.autoDismissBubble();
                bubbleBaseManager.dismissBubble();
            }
        }
    }

    public BubbleBaseManager(BubbleBaseView bubbleBaseView) {
        this.mViews = bubbleBaseView;
    }

    public void enableAnchorClk(boolean z) {
        this.mEnableAnchorClk = z;
    }

    public void enableAnimation(boolean z) {
        this.mEnableAnimation = z;
    }

    public void enableBgClk(boolean z) {
        this.mEnableBgClk = z;
    }

    public void enableClkDismiss(boolean z) {
        this.mEnableClkDismiss = z;
    }

    public void onClickCore(View view2) {
        BubbleManager.OnBubbleEventListener onBubbleEventListener = this.mOnBubbleEventListener;
        if (onBubbleEventListener != null) {
            onBubbleEventListener.onBubbleClick();
        }
        if (this.mEnableClkDismiss) {
            dismissBubble();
        }
    }

    public void setAutoDismiss(boolean z) {
        this.mAutoDismiss = z;
    }

    public void setAutoDismissInterval(int i) {
        if (i <= 0) {
            this.mAutoDismissInterval = 7000;
        } else {
            this.mAutoDismissInterval = i;
        }
    }

    public void setBubbleAlpha(float f) {
        BubbleBaseView bubbleBaseView;
        View view2;
        this.mBubbleViewAlpha = f;
        if (this.mShowAnimationEnd && (bubbleBaseView = this.mViews) != null && (view2 = bubbleBaseView.mBubbleView) != null) {
            view2.setAlpha(f);
        }
    }

    public void setNeedUpdateLocation(boolean z) {
        this.mNeedUpdateLocation = z;
    }

    public void setOffsetOfArrow(float f) {
        this.mLocation.mOffsetOfArrow = f;
    }

    public void setOnAnchorEventListener(BubbleManager.OnAnchorClickListener onAnchorClickListener) {
        this.mOnAnchorClickListener = onAnchorClickListener;
    }

    public void setOnBubbleEventListener(BubbleManager.OnBubbleEventListener onBubbleEventListener) {
        this.mOnBubbleEventListener = onBubbleEventListener;
    }

    public void showBubbleView(final BubblePosition bubblePosition) {
        this.mViews.postAnchorView(new Runnable() { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager.4
            @Override // java.lang.Runnable
            public void run() {
                int i;
                int i2;
                BubbleBaseManager bubbleBaseManager = BubbleBaseManager.this;
                BubbleBaseView bubbleBaseView = bubbleBaseManager.mViews;
                if (bubbleBaseView == null) {
                    return;
                }
                int[] showPosition = bubbleBaseManager.mLocation.getShowPosition(bubblePosition, bubbleBaseView);
                BubbleBaseManager.this.mViews.showBubbleOnLocation(showPosition);
                BubbleBaseManager bubbleBaseManager2 = BubbleBaseManager.this;
                if (bubbleBaseManager2.mEnableAnimation) {
                    int dp2px = DeviceUtil.ScreenInfo.dp2px(null, bubbleBaseManager2.mLocation.mBetweenPadding + 11.0f);
                    BubblePosition bubblePosition2 = bubblePosition;
                    if (bubblePosition2 != BubblePosition.UP && bubblePosition2 != BubblePosition.DOWN) {
                        if (bubblePosition2 == BubblePosition.RIGHT || bubblePosition2 == BubblePosition.LEFT) {
                            if (bubblePosition == BubblePosition.LEFT) {
                                i2 = showPosition[0] + dp2px;
                            } else {
                                i2 = showPosition[0] - dp2px;
                            }
                            BubbleBaseManager bubbleBaseManager3 = BubbleBaseManager.this;
                            bubbleBaseManager3.animation(bubbleBaseManager3.mViews.mBubbleView, i2, showPosition[0], showPosition[1], showPosition[1]);
                        }
                    } else {
                        if (bubblePosition == BubblePosition.UP) {
                            i = showPosition[1] + dp2px;
                        } else {
                            i = showPosition[1] - dp2px;
                        }
                        BubbleBaseManager bubbleBaseManager4 = BubbleBaseManager.this;
                        bubbleBaseManager4.animation(bubbleBaseManager4.mViews.mBubbleView, showPosition[0], showPosition[0], i, showPosition[1]);
                    }
                }
                BubbleBaseManager bubbleBaseManager5 = BubbleBaseManager.this;
                if (bubbleBaseManager5.mEnableAnchorClk) {
                    bubbleBaseManager5.mViews.showAnchorLayer();
                }
                BubbleBaseManager bubbleBaseManager6 = BubbleBaseManager.this;
                bubbleBaseManager6.mIsShowing = true;
                if (bubbleBaseManager6.mAutoDismiss) {
                    bubbleBaseManager6.mBubbleHandler.sendEmptyMessageDelayed(0, bubbleBaseManager6.mAutoDismissInterval);
                }
                BubbleManager.OnBubbleEventListener onBubbleEventListener = BubbleBaseManager.this.mOnBubbleEventListener;
                if (onBubbleEventListener != null) {
                    onBubbleEventListener.onBubbleShow();
                }
            }
        });
    }

    private void addAnchorGlobalLayoutListener() {
        BubbleBaseView bubbleBaseView;
        View view2;
        if (this.mNeedUpdateLocation && (bubbleBaseView = this.mViews) != null && (view2 = bubbleBaseView.mAnchorView) != null) {
            this.oldAnchorPos = BubbleLocationManager.getPositions(view2);
            this.mViews.mAnchorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager.10
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    View view3;
                    BubbleBaseView bubbleBaseView2 = BubbleBaseManager.this.mViews;
                    if (bubbleBaseView2 != null && (view3 = bubbleBaseView2.mAnchorView) != null) {
                        int[] positions = BubbleLocationManager.getPositions(view3);
                        if (BubbleLocationManager.isSamePos(BubbleBaseManager.this.oldAnchorPos, positions)) {
                            return;
                        }
                        BubbleBaseManager.this.oldAnchorPos = positions;
                        BubbleBaseManager.this.updateBubblePosition();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realAutoDismissBubble() {
        if (!this.mIsShowing) {
            return;
        }
        BubbleManager.OnBubbleEventListener onBubbleEventListener = this.mOnBubbleEventListener;
        if (onBubbleEventListener instanceof BubbleManager.OnBubbleSmartEventListener) {
            ((BubbleManager.OnBubbleSmartEventListener) onBubbleEventListener).onBubbleAutoDismiss();
        }
    }

    public void autoDismissBubble() {
        if (!this.mIsShowing) {
            return;
        }
        UiThreadUtils.getMainHandler().post(new Runnable() { // from class: com.baidu.tieba.ni1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    BubbleBaseManager.this.realAutoDismissBubble();
                }
            }
        });
    }

    public void dismissBubble() {
        if (!this.mIsShowing) {
            return;
        }
        UiThreadUtils.getMainHandler().post(new Runnable() { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager.1
            @Override // java.lang.Runnable
            public void run() {
                BubbleBaseManager.this.realDismissBubble();
            }
        });
    }

    public BubbleLocationManager getLocation() {
        return this.mLocation;
    }

    public BubbleManager.OnBubbleEventListener getOnBubbleEventListener() {
        return this.mOnBubbleEventListener;
    }

    public void initViewIfNeed() {
        if (this.mViews.initViewIfNeed()) {
            this.mBubbleHandler = new BubbleHandler(this);
            this.mViews.setBubbleClick(new View.OnClickListener() { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    BubbleBaseManager.this.onClickCore(view2);
                }
            });
            this.mViews.setBGClick(new View.OnClickListener() { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    BubbleBaseManager.this.onClickCore(view2);
                }
            });
            this.mViews.setAnchorClick(new View.OnClickListener() { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    BubbleBaseManager.this.onClickCore(view2);
                    BubbleManager.OnAnchorClickListener onAnchorClickListener = BubbleBaseManager.this.mOnAnchorClickListener;
                    if (onAnchorClickListener != null) {
                        onAnchorClickListener.onAnchorClick();
                    }
                }
            });
            addAnchorGlobalLayoutListener();
        }
    }

    public boolean isDismissed() {
        return !this.mIsShowing;
    }

    public void resetAll() {
        BubbleBaseView bubbleBaseView = this.mViews;
        if (bubbleBaseView != null) {
            bubbleBaseView.resetAll();
            this.mViews = null;
        }
        this.mOnBubbleEventListener = null;
        this.mBubbleHandler = null;
        this.mObjectAnimator = null;
    }

    public void showBubble() {
        BubbleBaseView bubbleBaseView = this.mViews;
        if (bubbleBaseView == null || bubbleBaseView.mAnchorView == null || TextUtils.isEmpty(bubbleBaseView.getAnchorViewName()) || !this.mViews.isValidate() || !isDismissed()) {
            return;
        }
        show();
    }

    public void updateBubblePosition() {
        BubbleBaseView bubbleBaseView = this.mViews;
        if (bubbleBaseView != null && this.mIsShowing) {
            bubbleBaseView.postAnchorView(new Runnable() { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager.9
                @Override // java.lang.Runnable
                public void run() {
                    BubbleBaseManager bubbleBaseManager = BubbleBaseManager.this;
                    BubbleBaseView bubbleBaseView2 = bubbleBaseManager.mViews;
                    if (bubbleBaseView2 != null && bubbleBaseManager.mIsShowing) {
                        BubblePosition detectShowPosition = bubbleBaseManager.mLocation.detectShowPosition(bubbleBaseView2);
                        BubbleBaseManager bubbleBaseManager2 = BubbleBaseManager.this;
                        BubbleBaseManager.this.mViews.showBubbleOnLocation(bubbleBaseManager2.mLocation.getShowPosition(detectShowPosition, bubbleBaseManager2.mViews));
                        BubbleBaseManager bubbleBaseManager3 = BubbleBaseManager.this;
                        if (bubbleBaseManager3.mEnableAnchorClk) {
                            bubbleBaseManager3.mViews.showAnchorLayer();
                        }
                    }
                }
            });
        }
    }

    public void updateFontSizeUI() {
        BubbleBaseView bubbleBaseView = this.mViews;
        if (bubbleBaseView != null) {
            bubbleBaseView.updateViewUI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animation(View view2, float f, float f2, float f3, float f4) {
        ObjectAnimator objectAnimator = this.mObjectAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mObjectAnimator.cancel();
        }
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view2, PropertyValuesHolder.ofFloat(Key.ALPHA, 0.0f, this.mBubbleViewAlpha), PropertyValuesHolder.ofFloat(Key.TRANSLATION_X, f, f2), PropertyValuesHolder.ofFloat(Key.TRANSLATION_Y, f3, f4)).setDuration(180L);
        this.mObjectAnimator = duration;
        duration.addListener(new Animator.AnimatorListener() { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BubbleBaseManager.this.mShowAnimationEnd = true;
                BubbleBaseManager bubbleBaseManager = BubbleBaseManager.this;
                bubbleBaseManager.setBubbleAlpha(bubbleBaseManager.mBubbleViewAlpha);
            }
        });
        this.mObjectAnimator.start();
    }

    private void show() {
        BubbleHistory.getInstance().trackBubbleOpHistory("——>show");
        initViewIfNeed();
        if (this.mEnableBgClk) {
            this.mViews.safeAddBGView();
        }
        if (this.mEnableAnchorClk) {
            this.mViews.safeAddAnchorView();
            this.mViews.resetAnchorParams();
        }
        this.mViews.safeAddBubbleView();
        if (this.mViews.mBubbleView != null) {
            BdEventBus.Companion.getDefault().register(this.mViews.mBubbleView, FontSizeChangeMessage.class, 1, new Action<FontSizeChangeMessage>() { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.bdeventbus.Action
                public void call(FontSizeChangeMessage fontSizeChangeMessage) {
                    BubbleBaseManager.this.updateFontSizeUI();
                }
            });
        }
        if (!this.mEnableClkDismiss) {
            this.mViews.initLinkBubble();
        }
        onShow();
        this.mViews.postAnchorView(new Runnable() { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager.3
            @Override // java.lang.Runnable
            public void run() {
                BubbleBaseManager bubbleBaseManager = BubbleBaseManager.this;
                BubblePosition detectShowPosition = bubbleBaseManager.mLocation.detectShowPosition(bubbleBaseManager.mViews);
                if (detectShowPosition == BubblePosition.INVALID) {
                    BubbleBaseManager.this.mViews.removemBubbleView();
                    BubbleHistory.getInstance().trackBubbleOpHistory("——>show: remove bubble view end");
                    BubbleBaseManager bubbleBaseManager2 = BubbleBaseManager.this;
                    if (bubbleBaseManager2.mEnableBgClk) {
                        bubbleBaseManager2.mViews.removeBGView();
                        BubbleHistory.getInstance().trackBubbleOpHistory("——>show: remove bg view end");
                    }
                    BubbleBaseManager bubbleBaseManager3 = BubbleBaseManager.this;
                    if (bubbleBaseManager3.mEnableAnchorClk) {
                        bubbleBaseManager3.mViews.removeAnchorView();
                        BubbleHistory.getInstance().trackBubbleOpHistory("——>show: remove anchorlayer view end");
                        return;
                    }
                    return;
                }
                BubbleBaseManager.this.mViews.showArrowView(detectShowPosition);
                BubbleBaseManager.this.showBubbleView(detectShowPosition);
            }
        });
    }

    public void realDismissBubble() {
        if (this.mIsShowing) {
            ObjectAnimator objectAnimator = this.mObjectAnimator;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.mObjectAnimator.cancel();
            }
            if (this.mEnableBgClk) {
                this.mViews.removeBGView();
                BubbleHistory.getInstance().trackBubbleOpHistory("——>dismiss BgView end");
            }
            if (this.mEnableAnchorClk) {
                this.mViews.removeAnchorView();
                BubbleHistory.getInstance().trackBubbleOpHistory("——>dismiss anchorLayer end");
            }
            if (this.mViews.mBubbleView != null) {
                BdEventBus.Companion.getDefault().unregister(this.mViews.mBubbleView);
            }
            this.mViews.removemBubbleView();
            BubbleHistory.getInstance().trackBubbleOpHistory("——>dismiss BubbleView end");
            this.mIsShowing = false;
            BubbleHandler bubbleHandler = this.mBubbleHandler;
            if (bubbleHandler != null) {
                bubbleHandler.removeMessages(0);
            }
            BubbleManager.OnBubbleEventListener onBubbleEventListener = this.mOnBubbleEventListener;
            if (onBubbleEventListener != null) {
                onBubbleEventListener.onBubbleDismiss();
            }
            resetAll();
        }
    }
}
