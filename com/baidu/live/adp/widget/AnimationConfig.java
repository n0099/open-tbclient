package com.baidu.live.adp.widget;

import android.content.Context;
import android.view.animation.Interpolator;
/* loaded from: classes11.dex */
public final class AnimationConfig {
    public static final int ANIMATION_FRAME_DURATION = 16;
    private static final int MAX_VELOCITY = 1000;
    private static final int MIN_VELOCITY = 100;
    public static final float ONE_SECOND_FLOAT = 1000.0f;
    public static final float PROPORTION_VELOCITY_LARGE = 4.0f;
    public static final float PROPORTION_VELOCITY_MEDIUM = 2.0f;
    public static final float PROPORTION_VELOCITY_SMALL = 1.0f;
    public static final int TOUCH_EVENT_MOVE_THRESHOLD_LARGE = 75;
    public static final int TOUCH_EVENT_MOVE_THRESHOLD_MEDIUM = 50;
    public static final int TOUCH_EVENT_MOVE_THRESHOLD_SMALL = 25;
    public static final int VELOCITY_LARGE = 1100;
    public static final int VELOCITY_MEDIUM = 800;
    public static final int VELOCITY_SMALL = 500;
    public static final Interpolator sInterpolator = new Interpolator() { // from class: com.baidu.live.adp.widget.AnimationConfig.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    public static final Interpolator sReverseInterpolator = new Interpolator() { // from class: com.baidu.live.adp.widget.AnimationConfig.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f * f * f * f * f;
        }
    };

    public static int getVelocitySmall(Context context) {
        return convertToPx(context, 500);
    }

    public static int getVelocityMedium(Context context) {
        return convertToPx(context, 800);
    }

    public static int getVelocityLarge(Context context) {
        return convertToPx(context, 1100);
    }

    public static int getTouchEventMoveThresholdSmall(Context context) {
        return convertToPx(context, 25);
    }

    public static int getTouchEventMoveThresholdMedium(Context context) {
        return convertToPx(context, 50);
    }

    public static int getTouchEventMoveThresholdLarge(Context context) {
        return convertToPx(context, 75);
    }

    public static int computeVelocityByDp(Context context, int i) {
        return convertToPx(context, Math.min(1000, Math.max(100, i)));
    }

    public static int computeVelocityByPx(Context context, int i) {
        return Math.min(convertToPx(context, 1000), Math.max(convertToPx(context, 100), i));
    }

    private static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    private static int convertToPx(Context context, int i) {
        return (int) ((getDensity(context) * i) + 0.5f);
    }

    public static int computeInterpolator(float f, float f2, boolean z) {
        if (z) {
            return (int) (f - (sInterpolator.getInterpolation(f2 / (f2 - f)) * f));
        }
        return (int) (sInterpolator.getInterpolation(f2 / f) * f);
    }
}
