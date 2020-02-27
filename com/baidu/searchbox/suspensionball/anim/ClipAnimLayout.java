package com.baidu.searchbox.suspensionball.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes13.dex */
public class ClipAnimLayout extends FrameLayout {
    private static final boolean DEBUG = AppConfig.isDebug();
    private int mAnimDuration;
    private int mClipHeight;
    private int mClipLeft;
    private RectF mClipRect;
    private int mClipTop;
    private int mClipWidth;

    /* loaded from: classes13.dex */
    public interface OnAnimationListener {
        void onAnimationEnd();

        void onAnimationPrepare();

        void onAnimationStart();
    }

    public ClipAnimLayout(Context context) {
        super(context);
        this.mAnimDuration = 240;
        init();
    }

    public ClipAnimLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAnimDuration = 240;
        init();
    }

    public ClipAnimLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAnimDuration = 240;
        init();
    }

    private void init() {
        setWillNotDraw(false);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (DEBUG) {
            Log.d("ClipAnimLayout", "——> onDraw: clipLeft " + this.mClipLeft + " clipTop " + this.mClipTop + " clipWidth " + this.mClipWidth + " clipHeight " + this.mClipHeight);
        }
        this.mClipRect = new RectF(this.mClipLeft, this.mClipTop, this.mClipLeft + this.mClipWidth, this.mClipTop + this.mClipHeight);
        canvas.clipRect(this.mClipRect);
        super.onDraw(canvas);
    }

    public void doSlideAnim() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, View.X, getLeft(), 0.0f);
        ofFloat.setDuration(this.mAnimDuration);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.suspensionball.anim.ClipAnimLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ClipAnimLayout.DEBUG) {
                    Log.d("ClipAnimLayout", "——> doSlideAnim onAnimationUpdate: " + valueAnimator.getAnimatedValue());
                }
                ClipAnimLayout.this.invalidate();
            }
        });
        ofFloat.start();
    }

    public void doClipAnimation(boolean z, int i, int i2, final OnAnimationListener onAnimationListener) {
        int i3;
        int i4;
        int displayWidth;
        int displayHeight;
        int i5;
        int i6;
        if (DEBUG) {
            Log.d("ClipAnimLayout", "——> showAnimation: ");
        }
        if (z) {
            displayWidth = 0;
            displayHeight = 0;
            i5 = getWidth();
            i6 = getHeight();
            i4 = i2;
            i2 = 0;
            i3 = i;
            i = 0;
        } else {
            i3 = 0;
            i4 = 0;
            displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(AppRuntime.getAppContext());
            displayHeight = DeviceUtil.ScreenInfo.getDisplayHeight(AppRuntime.getAppContext());
            i5 = 0;
            i6 = 0;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofInt(this, "clipLeft", i3, i)).with(ObjectAnimator.ofInt(this, "clipTop", i4, i2)).with(ObjectAnimator.ofInt(this, "clipWidth", displayWidth, i5)).with(ObjectAnimator.ofInt(this, "clipHeight", displayHeight, i6));
        animatorSet.setDuration(this.mAnimDuration);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.searchbox.suspensionball.anim.ClipAnimLayout.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (onAnimationListener != null) {
                    onAnimationListener.onAnimationEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
    }

    public int getClipLeft() {
        return this.mClipLeft;
    }

    public void setClipLeft(int i) {
        if (DEBUG) {
            Log.d("ClipAnimLayout", "——> setClipLeft: " + i);
        }
        this.mClipLeft = i;
        invalidate();
    }

    public int getClipTop() {
        return this.mClipTop;
    }

    public void setClipTop(int i) {
        if (DEBUG) {
            Log.d("ClipAnimLayout", "——> setClipTop: " + i);
        }
        this.mClipTop = i;
    }

    public int getClipWidth() {
        return this.mClipWidth;
    }

    public void setClipWidth(int i) {
        if (DEBUG) {
            Log.d("ClipAnimLayout", "——> setClipWidth: " + i);
        }
        this.mClipWidth = i;
    }

    public int getClipHeight() {
        return this.mClipHeight;
    }

    public void setClipHeight(int i) {
        if (DEBUG) {
            Log.d("ClipAnimLayout", "——> setClipHeight: " + i);
        }
        this.mClipHeight = i;
    }

    public void setAnimDuration(int i) {
        this.mAnimDuration = i;
    }
}
