package com.baidu.spswitch.emotion.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.baidu.spswitch.R;
import com.baidu.spswitch.utils.SoftInputUtil;
import com.baidu.spswitch.utils.UIUtils;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class PopupEmotionManager {
    public static final int ANCHOR_Y_OFFSET_DP = 2;
    public Context mCtx;
    public Animation mEnterAnimation;
    public Animation mExitAnimation;
    public boolean mIsPostRunning;
    public boolean mIsShowing;
    public ShowParam mLastShowParam;
    public PopupEmotionView mPopupEmotionView;
    public IShowListener mShowListener;
    public int mXpos;
    public int mYpos;
    public Handler mMainHandler = new Handler(Looper.getMainLooper());
    public LinkedList<DelayedTask> mDelayedTaskQueue = new LinkedList<>();
    public ViewGroup mContainerView = SoftInputUtil.getContentView();

    /* loaded from: classes2.dex */
    public static class DelayedTask {
        public static final int TASK_TYPE_DISMISS = 2;
        public static final int TASK_TYPE_DISMISS_WITHOUT_ANIM = 3;
        public static final int TASK_TYPE_SHOW = 0;
        public static final int TASK_TYPE_SHOW_WITHOUT_ANIM = 1;
        public Object extra;
        public int taskType;

        public DelayedTask(int i, Object obj) {
            this.taskType = i;
            this.extra = obj;
        }
    }

    /* loaded from: classes2.dex */
    public interface IShowListener {
        void show(int i, String str, int i2, int i3);
    }

    /* loaded from: classes2.dex */
    public static class ShowParam {
        public int anchorWidth;
        public int anchorXpos;
        public int anchorYpos;
        public boolean enableShowAnim = true;
        public Bitmap exprBitmap;
        public int exprCol;
        public String exprName;
        public int exprRow;
        public int sectionType;

        public static boolean validate(ShowParam showParam) {
            Bitmap bitmap;
            return (showParam == null || TextUtils.isEmpty(showParam.exprName) || (bitmap = showParam.exprBitmap) == null || bitmap.isRecycled() || showParam.anchorWidth <= 0) ? false : true;
        }

        public boolean isDuplicate(ShowParam showParam) {
            return showParam != null && TextUtils.equals(showParam.exprName, this.exprName) && showParam.anchorXpos == this.anchorXpos && showParam.anchorYpos == this.anchorYpos;
        }
    }

    public PopupEmotionManager(Context context) {
        this.mCtx = context;
    }

    private void calculatePos(ShowParam showParam) {
        this.mPopupEmotionView.measure(0, 0);
        this.mXpos = (showParam.anchorXpos - (this.mPopupEmotionView.getMeasuredWidth() / 2)) + (showParam.anchorWidth / 2);
        this.mYpos = ((showParam.anchorYpos + ((int) UIUtils.dp2px(this.mCtx, 2.0f))) - this.mPopupEmotionView.getMeasuredHeight()) - UIUtils.getStatusBarHeightEx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissInternal() {
        this.mIsPostRunning = true;
        this.mMainHandler.post(new Runnable() { // from class: com.baidu.spswitch.emotion.view.PopupEmotionManager.4
            @Override // java.lang.Runnable
            public void run() {
                if (PopupEmotionManager.this.mPopupEmotionView != null && PopupEmotionManager.this.mPopupEmotionView.getParent() != null && (PopupEmotionManager.this.mPopupEmotionView.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) PopupEmotionManager.this.mPopupEmotionView.getParent()).removeView(PopupEmotionManager.this.mPopupEmotionView);
                }
                PopupEmotionManager.this.mIsShowing = false;
                PopupEmotionManager.this.mIsPostRunning = false;
                PopupEmotionManager.this.mLastShowParam = null;
                PopupEmotionManager.this.runDelayedTaskIfNecessary();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runDelayedTaskIfNecessary() {
        if (this.mDelayedTaskQueue.isEmpty() || this.mDelayedTaskQueue.peek() == null) {
            return;
        }
        DelayedTask poll = this.mDelayedTaskQueue.poll();
        int i = poll.taskType;
        if (i == 0) {
            show((ShowParam) poll.extra);
        } else if (i == 1) {
            show((ShowParam) poll.extra);
        } else if (i == 2) {
            dismiss();
        } else if (i == 3) {
            dismissWithoutAnim();
        }
    }

    public void dismiss() {
        Animation animation;
        PopupEmotionView popupEmotionView = this.mPopupEmotionView;
        if (popupEmotionView == null || (animation = this.mExitAnimation) == null) {
            return;
        }
        if (this.mIsPostRunning) {
            this.mDelayedTaskQueue.add(new DelayedTask(2, null));
            return;
        }
        popupEmotionView.setAnimation(animation);
        this.mExitAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.spswitch.emotion.view.PopupEmotionManager.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                PopupEmotionManager.this.dismissInternal();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }
        });
        this.mPopupEmotionView.startAnimation(this.mExitAnimation);
        this.mIsPostRunning = true;
    }

    public void dismissWithoutAnim() {
        if (this.mIsPostRunning) {
            this.mDelayedTaskQueue.add(new DelayedTask(3, null));
        } else {
            dismissInternal();
        }
    }

    public boolean isPostRunning() {
        return this.mIsPostRunning;
    }

    public boolean isShowing() {
        return this.mIsShowing;
    }

    public void reset() {
        this.mDelayedTaskQueue.clear();
        this.mIsPostRunning = false;
        this.mIsShowing = false;
        this.mLastShowParam = null;
        PopupEmotionView popupEmotionView = this.mPopupEmotionView;
        if (popupEmotionView == null || popupEmotionView.getParent() == null || !(this.mPopupEmotionView.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) this.mPopupEmotionView.getParent()).removeView(this.mPopupEmotionView);
    }

    public void setShowListener(IShowListener iShowListener) {
        this.mShowListener = iShowListener;
    }

    public void show(ShowParam showParam) {
        if (this.mContainerView == null || !ShowParam.validate(showParam) || showParam.isDuplicate(this.mLastShowParam)) {
            return;
        }
        if (this.mIsPostRunning) {
            this.mDelayedTaskQueue.add(new DelayedTask(0, showParam));
        } else if (this.mIsShowing) {
            showParam.enableShowAnim = false;
            this.mDelayedTaskQueue.add(new DelayedTask(0, showParam));
            dismissWithoutAnim();
        } else {
            this.mLastShowParam = showParam;
            if (this.mPopupEmotionView == null) {
                this.mPopupEmotionView = new PopupEmotionView(this.mCtx);
                this.mEnterAnimation = AnimationUtils.loadAnimation(this.mCtx, R.anim.emotion_long_pressed_entry);
                this.mExitAnimation = AnimationUtils.loadAnimation(this.mCtx, R.anim.emotion_long_pressed_exit);
            }
            this.mPopupEmotionView.configView(showParam.exprName, showParam.exprBitmap);
            calculatePos(showParam);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.mXpos;
            layoutParams.topMargin = this.mYpos;
            this.mContainerView.addView(this.mPopupEmotionView, layoutParams);
            if (showParam.enableShowAnim) {
                this.mPopupEmotionView.setAnimation(this.mEnterAnimation);
                this.mEnterAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.spswitch.emotion.view.PopupEmotionManager.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        PopupEmotionManager.this.mIsPostRunning = false;
                        PopupEmotionManager.this.mIsShowing = true;
                        PopupEmotionManager.this.mMainHandler.post(new Runnable() { // from class: com.baidu.spswitch.emotion.view.PopupEmotionManager.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PopupEmotionManager.this.runDelayedTaskIfNecessary();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        PopupEmotionManager.this.mPopupEmotionView.setVisibility(0);
                    }
                });
                this.mPopupEmotionView.startAnimation(this.mEnterAnimation);
                this.mIsPostRunning = true;
            } else {
                this.mIsPostRunning = false;
                this.mIsShowing = true;
                this.mMainHandler.post(new Runnable() { // from class: com.baidu.spswitch.emotion.view.PopupEmotionManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PopupEmotionManager.this.runDelayedTaskIfNecessary();
                    }
                });
            }
            IShowListener iShowListener = this.mShowListener;
            if (iShowListener != null) {
                iShowListener.show(showParam.sectionType, showParam.exprName, showParam.exprRow, showParam.exprCol);
            }
        }
    }
}
