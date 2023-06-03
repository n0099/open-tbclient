package com.baidu.searchbox.ui.multiwindow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class EdgeEffect {
    public static final float EPSILON = 0.001f;
    public static final float HELD_EDGE_SCALE_Y = 0.5f;
    public static final float MAX_ALPHA = 1.0f;
    public static final float MAX_GLOW_HEIGHT = 4.0f;
    public static final int MIN_VELOCITY = 100;
    public static final int MIN_WIDTH = 300;
    public static final int PULL_DECAY_TIME = 1000;
    public static final float PULL_DISTANCE_ALPHA_GLOW_FACTOR = 1.1f;
    public static final int PULL_DISTANCE_EDGE_FACTOR = 7;
    public static final int PULL_DISTANCE_GLOW_FACTOR = 7;
    public static final float PULL_EDGE_BEGIN = 0.6f;
    public static final float PULL_GLOW_BEGIN = 1.0f;
    public static final int PULL_TIME = 167;
    public static final int RECEDE_TIME = 1000;
    public static final int STATE_ABSORB = 2;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PULL = 1;
    public static final int STATE_PULL_DECAY = 4;
    public static final int STATE_RECEDE = 3;
    public static final String TAG = "EdgeEffect";
    public static final int VELOCITY_EDGE_FACTOR = 8;
    public static final int VELOCITY_GLOW_FACTOR = 16;
    public float mDuration;
    public final Drawable mEdge;
    public float mEdgeAlpha;
    public float mEdgeAlphaFinish;
    public float mEdgeAlphaStart;
    public final int mEdgeHeight;
    public float mEdgeScaleY;
    public float mEdgeScaleYFinish;
    public float mEdgeScaleYStart;
    public final Drawable mGlow;
    public float mGlowAlpha;
    public float mGlowAlphaFinish;
    public float mGlowAlphaStart;
    public final int mGlowHeight;
    public float mGlowScaleY;
    public float mGlowScaleYFinish;
    public float mGlowScaleYStart;
    public final int mGlowWidth;
    public int mHeight;
    public final Interpolator mInterpolator;
    public final int mMaxEffectHeight;
    public final int mMinWidth;
    public float mPullDistance;
    public long mStartTime;
    public int mWidth;
    public int mX;
    public int mY;
    public int mState = 0;
    public final Rect mBounds = new Rect();

    public EdgeEffect(Context context) {
        Resources resources = context.getResources();
        this.mEdge = resources.getDrawable(R.drawable.overscroll_edge);
        this.mGlow = resources.getDrawable(R.drawable.overscroll_glow);
        this.mEdgeHeight = this.mEdge.getIntrinsicHeight();
        this.mGlowHeight = this.mGlow.getIntrinsicHeight();
        int intrinsicWidth = this.mGlow.getIntrinsicWidth();
        this.mGlowWidth = intrinsicWidth;
        int i = this.mGlowHeight;
        this.mMaxEffectHeight = (int) (Math.min((((i * 4.0f) * i) / intrinsicWidth) * 0.6f, i * 4.0f) + 0.5f);
        this.mMinWidth = (int) ((resources.getDisplayMetrics().density * 300.0f) + 0.5f);
        this.mInterpolator = new DecelerateInterpolator();
    }

    public void onAbsorb(int i) {
        this.mState = 2;
        int max = Math.max(100, Math.abs(i));
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mDuration = (max * 0.03f) + 0.1f;
        this.mEdgeAlphaStart = 0.0f;
        this.mEdgeScaleYStart = 0.0f;
        this.mEdgeScaleY = 0.0f;
        this.mGlowAlphaStart = 0.5f;
        this.mGlowScaleYStart = 0.0f;
        int i2 = max * 8;
        this.mEdgeAlphaFinish = Math.max(0, Math.min(i2, 1));
        this.mEdgeScaleYFinish = Math.max(0.5f, Math.min(i2, 1.0f));
        this.mGlowScaleYFinish = Math.min(((max / 100) * max * 1.5E-4f) + 0.025f, 1.75f);
        this.mGlowAlphaFinish = Math.max(this.mGlowAlphaStart, Math.min(max * 16 * 1.0E-5f, 1.0f));
    }

    private void update() {
        float f;
        float min = Math.min(((float) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime)) / this.mDuration, 1.0f);
        float interpolation = this.mInterpolator.getInterpolation(min);
        float f2 = this.mEdgeAlphaStart;
        this.mEdgeAlpha = f2 + ((this.mEdgeAlphaFinish - f2) * interpolation);
        float f3 = this.mEdgeScaleYStart;
        this.mEdgeScaleY = f3 + ((this.mEdgeScaleYFinish - f3) * interpolation);
        float f4 = this.mGlowAlphaStart;
        this.mGlowAlpha = f4 + ((this.mGlowAlphaFinish - f4) * interpolation);
        float f5 = this.mGlowScaleYStart;
        float f6 = this.mGlowScaleYFinish;
        this.mGlowScaleY = f5 + ((f6 - f5) * interpolation);
        if (min >= 0.999f) {
            int i = this.mState;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            if (f6 != 0.0f) {
                                f = 1.0f / (f6 * f6);
                            } else {
                                f = Float.MAX_VALUE;
                            }
                            float f7 = this.mEdgeScaleYStart;
                            this.mEdgeScaleY = f7 + ((this.mEdgeScaleYFinish - f7) * interpolation * f);
                            this.mState = 3;
                            return;
                        }
                        return;
                    }
                    this.mState = 0;
                    return;
                }
                this.mState = 3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                this.mDuration = 1000.0f;
                this.mEdgeAlphaStart = this.mEdgeAlpha;
                this.mEdgeScaleYStart = this.mEdgeScaleY;
                this.mGlowAlphaStart = this.mGlowAlpha;
                this.mGlowScaleYStart = this.mGlowScaleY;
                this.mEdgeAlphaFinish = 0.0f;
                this.mEdgeScaleYFinish = 0.0f;
                this.mGlowAlphaFinish = 0.0f;
                this.mGlowScaleYFinish = 0.0f;
                return;
            }
            this.mState = 4;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 1000.0f;
            this.mEdgeAlphaStart = this.mEdgeAlpha;
            this.mEdgeScaleYStart = this.mEdgeScaleY;
            this.mGlowAlphaStart = this.mGlowAlpha;
            this.mGlowScaleYStart = this.mGlowScaleY;
            this.mEdgeAlphaFinish = 0.0f;
            this.mEdgeScaleYFinish = 0.0f;
            this.mGlowAlphaFinish = 0.0f;
            this.mGlowScaleYFinish = 0.0f;
        }
    }

    public boolean draw(Canvas canvas) {
        update();
        this.mGlow.setAlpha((int) (Math.max(0.0f, Math.min(this.mGlowAlpha, 1.0f)) * 255.0f));
        int i = this.mGlowHeight;
        int min = (int) Math.min((((i * this.mGlowScaleY) * i) / this.mGlowWidth) * 0.6f, i * 4.0f);
        int i2 = this.mWidth;
        int i3 = this.mMinWidth;
        if (i2 < i3) {
            int i4 = (i2 - i3) / 2;
            this.mGlow.setBounds(i4, 0, i2 - i4, min);
        } else {
            this.mGlow.setBounds(0, 0, i2, min);
        }
        this.mGlow.draw(canvas);
        this.mEdge.setAlpha((int) (Math.max(0.0f, Math.min(this.mEdgeAlpha, 1.0f)) * 255.0f));
        int i5 = (int) (this.mEdgeHeight * this.mEdgeScaleY);
        int i6 = this.mWidth;
        int i7 = this.mMinWidth;
        if (i6 < i7) {
            int i8 = (i6 - i7) / 2;
            this.mEdge.setBounds(i8, 0, i6 - i8, i5);
        } else {
            this.mEdge.setBounds(0, 0, i6, i5);
        }
        this.mEdge.draw(canvas);
        if (this.mState == 3 && min == 0 && i5 == 0) {
            this.mState = 0;
        }
        if (this.mState == 0) {
            return false;
        }
        return true;
    }

    public void onPull(float f) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.mState == 4 && ((float) (currentAnimationTimeMillis - this.mStartTime)) < this.mDuration) {
            return;
        }
        if (this.mState != 1) {
            this.mGlowScaleY = 1.0f;
        }
        this.mState = 1;
        this.mStartTime = currentAnimationTimeMillis;
        this.mDuration = 167.0f;
        float f2 = this.mPullDistance + f;
        this.mPullDistance = f2;
        float abs = Math.abs(f2);
        float max = Math.max(0.6f, Math.min(abs, 1.0f));
        this.mEdgeAlphaStart = max;
        this.mEdgeAlpha = max;
        float max2 = Math.max(0.5f, Math.min(abs * 7.0f, 1.0f));
        this.mEdgeScaleYStart = max2;
        this.mEdgeScaleY = max2;
        float min = Math.min(1.0f, this.mGlowAlpha + (Math.abs(f) * 1.1f));
        this.mGlowAlphaStart = min;
        this.mGlowAlpha = min;
        float abs2 = Math.abs(f);
        if (f > 0.0f && this.mPullDistance < 0.0f) {
            abs2 = -abs2;
        }
        if (this.mPullDistance == 0.0f) {
            this.mGlowScaleY = 0.0f;
        }
        float min2 = Math.min(4.0f, Math.max(0.0f, this.mGlowScaleY + (abs2 * 7.0f)));
        this.mGlowScaleYStart = min2;
        this.mGlowScaleY = min2;
        this.mEdgeAlphaFinish = this.mEdgeAlpha;
        this.mEdgeScaleYFinish = this.mEdgeScaleY;
        this.mGlowAlphaFinish = this.mGlowAlpha;
        this.mGlowScaleYFinish = min2;
    }

    public void finish() {
        this.mState = 0;
    }

    public boolean isFinished() {
        if (this.mState == 0) {
            return true;
        }
        return false;
    }

    public void onRelease() {
        this.mPullDistance = 0.0f;
        int i = this.mState;
        if (i != 1 && i != 4) {
            return;
        }
        this.mState = 3;
        this.mEdgeAlphaStart = this.mEdgeAlpha;
        this.mEdgeScaleYStart = this.mEdgeScaleY;
        this.mGlowAlphaStart = this.mGlowAlpha;
        this.mGlowScaleYStart = this.mGlowScaleY;
        this.mEdgeAlphaFinish = 0.0f;
        this.mEdgeScaleYFinish = 0.0f;
        this.mGlowAlphaFinish = 0.0f;
        this.mGlowScaleYFinish = 0.0f;
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mDuration = 1000.0f;
    }

    public Rect getBounds(boolean z) {
        int i = 0;
        this.mBounds.set(0, 0, this.mWidth, this.mMaxEffectHeight);
        Rect rect = this.mBounds;
        int i2 = this.mX;
        int i3 = this.mY;
        if (z) {
            i = this.mMaxEffectHeight;
        }
        rect.offset(i2, i3 - i);
        return this.mBounds;
    }

    public void setPosition(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    public void setSize(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }
}
