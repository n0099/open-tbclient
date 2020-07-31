package com.baidu.searchbox.suspensionball;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.searchbox.suspensionball.anim.ClipAnimLayout;
import com.baidu.searchbox.suspensionball.anim.ClipAnimationHelper;
import com.baidu.searchbox.widget.OnTranslucentListener;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideUtil;
/* loaded from: classes18.dex */
public class SuspensionBallHelper {
    private ClipAnimationHelper mClipAnimationHelper;
    private boolean mIsFinishFromSlide = false;
    private SlideHelper mSlideHelper;

    public void initSuspensionBallClipAnimHelper(Context context, SlideHelper slideHelper, boolean z) {
        if (slideHelper != null) {
            this.mSlideHelper = slideHelper;
        }
        if (z) {
            initClipAnimHelper(context);
            if (this.mSlideHelper != null && this.mSlideHelper.getMaskView() != null) {
                this.mSlideHelper.getMaskView().setAlpha(0.0f);
            }
        }
    }

    public void handleSuspensionPage(boolean z) {
        if (z && this.mClipAnimationHelper != null) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.suspensionball.SuspensionBallHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    SuspensionBallHelper.this.mClipAnimationHelper.setAnimDuration(240);
                    SuspensionBallHelper.this.mClipAnimationHelper.doViewAlphaAnim(SuspensionBallHelper.this.getMaskView(), 0.0f, 1.0f);
                    SuspensionBallHelper.this.mClipAnimationHelper.doClipAnimation(true, new ClipAnimLayout.OnAnimationListener() { // from class: com.baidu.searchbox.suspensionball.SuspensionBallHelper.1.1
                        @Override // com.baidu.searchbox.suspensionball.anim.ClipAnimLayout.OnAnimationListener
                        public void onAnimationStart() {
                        }

                        @Override // com.baidu.searchbox.suspensionball.anim.ClipAnimLayout.OnAnimationListener
                        public void onAnimationEnd() {
                        }

                        @Override // com.baidu.searchbox.suspensionball.anim.ClipAnimLayout.OnAnimationListener
                        public void onAnimationPrepare() {
                        }
                    });
                    SuspensionBallHelper.this.mClipAnimationHelper.doFgMaskView(1.0f, 0.0f);
                }
            }, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getMaskView() {
        if (this.mSlideHelper != null) {
            return this.mSlideHelper.getMaskView();
        }
        return null;
    }

    public void doSuspensionBallExitAnim(final Context context, SlideHelper slideHelper, final SuspensionBallAnimFinishListener suspensionBallAnimFinishListener) {
        if (slideHelper == null) {
            if (suspensionBallAnimFinishListener != null) {
                suspensionBallAnimFinishListener.onFinish();
            }
        } else if (context instanceof Activity) {
            SlideUtil.convertToTranslucent((Activity) context, new OnTranslucentListener() { // from class: com.baidu.searchbox.suspensionball.SuspensionBallHelper.2
                @Override // com.baidu.searchbox.widget.OnTranslucentListener
                public void onTranslucent(boolean z) {
                    SuspensionBallHelper.this.initClipAnimHelper(context);
                    if (SuspensionBallHelper.this.mClipAnimationHelper != null) {
                        SuspensionBallHelper.this.doFinishClipAnimation(suspensionBallAnimFinishListener);
                    } else if (suspensionBallAnimFinishListener != null) {
                        suspensionBallAnimFinishListener.onFinish();
                    }
                }
            });
        } else if (suspensionBallAnimFinishListener != null) {
            suspensionBallAnimFinishListener.onFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doFinishClipAnimation(final SuspensionBallAnimFinishListener suspensionBallAnimFinishListener) {
        this.mClipAnimationHelper.setAnimDuration(this.mIsFinishFromSlide ? 250 : 240);
        View maskView = getMaskView();
        if (maskView != null) {
            this.mClipAnimationHelper.doViewAlphaAnim(maskView, maskView.getAlpha(), 0.0f);
        }
        this.mClipAnimationHelper.doFgMaskView(0.0f, 1.0f);
        if (this.mIsFinishFromSlide) {
            this.mClipAnimationHelper.doSlideAnim();
        }
        this.mClipAnimationHelper.doClipAnimation(false, new ClipAnimLayout.OnAnimationListener() { // from class: com.baidu.searchbox.suspensionball.SuspensionBallHelper.3
            @Override // com.baidu.searchbox.suspensionball.anim.ClipAnimLayout.OnAnimationListener
            public void onAnimationStart() {
            }

            @Override // com.baidu.searchbox.suspensionball.anim.ClipAnimLayout.OnAnimationListener
            public void onAnimationEnd() {
                if (suspensionBallAnimFinishListener != null) {
                    suspensionBallAnimFinishListener.onFinish();
                }
            }

            @Override // com.baidu.searchbox.suspensionball.anim.ClipAnimLayout.OnAnimationListener
            public void onAnimationPrepare() {
            }
        });
    }

    public void setFinishFromSlide(boolean z) {
        this.mIsFinishFromSlide = z;
    }

    public void initClipAnimHelper(Context context) {
        if (context != null && (context instanceof Activity) && this.mClipAnimationHelper == null) {
            this.mClipAnimationHelper = new ClipAnimationHelper();
            this.mClipAnimationHelper.attachClipAnimView(context, ((Activity) context).findViewById(16908290));
            if (this.mSlideHelper != null) {
                this.mSlideHelper.setAutoSlideToRight(false);
            }
        }
    }
}
