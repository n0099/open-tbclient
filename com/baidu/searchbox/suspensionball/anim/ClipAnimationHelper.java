package com.baidu.searchbox.suspensionball.anim;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.suspension_ball_anim.R;
import com.baidu.searchbox.suspensionball.anim.ClipAnimLayout;
import com.baidu.searchbox.suspensionball.anim.ioc.SuspensionBallAnimationRuntime;
/* loaded from: classes14.dex */
public class ClipAnimationHelper {
    private static final boolean DEBUG = AppConfig.isDebug();
    private boolean canClip;
    private int mAnimDuration;
    private ClipAnimLayout mClipAnimLayout;
    private ImageView mFgMaskView;

    public ClipAnimationHelper() {
        this(true);
    }

    public ClipAnimationHelper(boolean z) {
        this.canClip = true;
        this.mFgMaskView = null;
        this.mAnimDuration = 240;
        this.canClip = z;
    }

    public void attachClipAnimView(Context context, View view) {
        if (context != null && view != null && this.canClip) {
            boolean isFocused = view.isFocused();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
                if (this.mFgMaskView == null) {
                    this.mFgMaskView = new ImageView(context);
                    this.mFgMaskView.setImageDrawable(new ColorDrawable(context.getResources().getColor(R.color.suspension_ball_anim_fg_mask_color)));
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.mClipAnimLayout = new ClipAnimLayout(context);
                this.mClipAnimLayout.addView(view, layoutParams);
                this.mClipAnimLayout.addView(this.mFgMaskView, layoutParams);
                viewGroup.addView(this.mClipAnimLayout, layoutParams);
                this.mFgMaskView.setAlpha(0.0f);
                if (isFocused) {
                    this.mClipAnimLayout.requestFocus();
                }
            }
        }
    }

    public void setAnimDuration(int i) {
        this.mAnimDuration = i <= 0 ? 240 : i;
        if (this.mClipAnimLayout != null) {
            this.mClipAnimLayout.setAnimDuration(i);
        }
    }

    public void doClipAnimation(boolean z, ClipAnimLayout.OnAnimationListener onAnimationListener) {
        if (this.mClipAnimLayout != null && onAnimationListener != null) {
            int ballCenterXCoordinate = SuspensionBallAnimationRuntime.getBallInfoImpl().getBallCenterXCoordinate();
            int ballCenterYCoordinate = SuspensionBallAnimationRuntime.getBallInfoImpl().getBallCenterYCoordinate();
            if (ballCenterXCoordinate == 0 && ballCenterYCoordinate == 0) {
                if (DEBUG) {
                    Log.d("ClipAnimationHelper", "——> doClipAnimation:  !!! invalid position of the ball ");
                    return;
                }
                return;
            }
            this.mClipAnimLayout.doClipAnimation(z, ballCenterXCoordinate, ballCenterYCoordinate, onAnimationListener);
        }
    }

    public void doFgMaskView(float f, float f2) {
        updateView();
        doViewAlphaAnim(this.mFgMaskView, f, f2);
    }

    private void updateView() {
        if (this.mFgMaskView != null) {
            this.mFgMaskView.setImageDrawable(new ColorDrawable(AppRuntime.getAppContext().getResources().getColor(R.color.suspension_ball_anim_fg_mask_color)));
        }
    }

    public void doViewAlphaAnim(View view, float f, float f2) {
        if (view == null) {
            if (DEBUG) {
                Log.d("ClipAnimationHelper", "——> doViewAlphaAnim: error !!! null view ");
            }
        } else if (f < 0.0f || f > 1.0f) {
            if (DEBUG) {
                Log.d("ClipAnimationHelper", "——> doViewAlphaAnim: error !!!! startBgAlpha is invalid ");
            }
        } else if (f2 < 0.0f || f2 > 1.0f) {
            if (DEBUG) {
                Log.d("ClipAnimationHelper", "——> doViewAlphaAnim: error !!!! endBgAlpha is invalid ");
            }
        } else {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", f, f2);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setDuration(this.mAnimDuration);
            ofFloat.start();
        }
    }

    public void doSlideAnim() {
        if (this.mClipAnimLayout != null) {
            this.mClipAnimLayout.doSlideAnim();
        }
    }
}
