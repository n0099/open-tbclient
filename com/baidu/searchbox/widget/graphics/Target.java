package com.baidu.searchbox.widget.graphics;

import android.support.annotation.FloatRange;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes18.dex */
public final class Target {
    public static final Target DARK_MUTED;
    public static final Target DARK_VIBRANT;
    static final int INDEX_MAX = 2;
    static final int INDEX_MIN = 0;
    static final int INDEX_TARGET = 1;
    static final int INDEX_WEIGHT_LUMA = 1;
    static final int INDEX_WEIGHT_POP = 2;
    static final int INDEX_WEIGHT_SAT = 0;
    public static final Target LIGHT_MUTED;
    public static final Target LIGHT_VIBRANT = new Target();
    private static final float MAX_DARK_LUMA = 0.45f;
    private static final float MAX_MUTED_SATURATION = 0.4f;
    private static final float MAX_NORMAL_LUMA = 0.7f;
    private static final float MIN_LIGHT_LUMA = 0.55f;
    private static final float MIN_NORMAL_LUMA = 0.3f;
    private static final float MIN_VIBRANT_SATURATION = 0.35f;
    public static final Target MUTED;
    private static final float TARGET_DARK_LUMA = 0.26f;
    private static final float TARGET_LIGHT_LUMA = 0.74f;
    private static final float TARGET_MUTED_SATURATION = 0.3f;
    private static final float TARGET_NORMAL_LUMA = 0.5f;
    private static final float TARGET_VIBRANT_SATURATION = 1.0f;
    public static final Target VIBRANT;
    private static final float WEIGHT_LUMA = 0.52f;
    private static final float WEIGHT_POPULATION = 0.24f;
    private static final float WEIGHT_SATURATION = 0.24f;
    boolean mIsExclusive;
    final float[] mLightnessTargets;
    final float[] mSaturationTargets;
    final float[] mWeights;

    static {
        setDefaultLightLightnessValues(LIGHT_VIBRANT);
        setDefaultVibrantSaturationValues(LIGHT_VIBRANT);
        VIBRANT = new Target();
        setDefaultNormalLightnessValues(VIBRANT);
        setDefaultVibrantSaturationValues(VIBRANT);
        DARK_VIBRANT = new Target();
        setDefaultDarkLightnessValues(DARK_VIBRANT);
        setDefaultVibrantSaturationValues(DARK_VIBRANT);
        LIGHT_MUTED = new Target();
        setDefaultLightLightnessValues(LIGHT_MUTED);
        setDefaultMutedSaturationValues(LIGHT_MUTED);
        MUTED = new Target();
        setDefaultNormalLightnessValues(MUTED);
        setDefaultMutedSaturationValues(MUTED);
        DARK_MUTED = new Target();
        setDefaultDarkLightnessValues(DARK_MUTED);
        setDefaultMutedSaturationValues(DARK_MUTED);
    }

    Target() {
        this.mSaturationTargets = new float[3];
        this.mLightnessTargets = new float[3];
        this.mWeights = new float[3];
        this.mIsExclusive = true;
        setTargetDefaultValues(this.mSaturationTargets);
        setTargetDefaultValues(this.mLightnessTargets);
        setDefaultWeights();
    }

    Target(Target target) {
        this.mSaturationTargets = new float[3];
        this.mLightnessTargets = new float[3];
        this.mWeights = new float[3];
        this.mIsExclusive = true;
        System.arraycopy(target.mSaturationTargets, 0, this.mSaturationTargets, 0, this.mSaturationTargets.length);
        System.arraycopy(target.mLightnessTargets, 0, this.mLightnessTargets, 0, this.mLightnessTargets.length);
        System.arraycopy(target.mWeights, 0, this.mWeights, 0, this.mWeights.length);
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getMinimumSaturation() {
        return this.mSaturationTargets[0];
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getTargetSaturation() {
        return this.mSaturationTargets[1];
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getMaximumSaturation() {
        return this.mSaturationTargets[2];
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getMinimumLightness() {
        return this.mLightnessTargets[0];
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getTargetLightness() {
        return this.mLightnessTargets[1];
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getMaximumLightness() {
        return this.mLightnessTargets[2];
    }

    public float getSaturationWeight() {
        return this.mWeights[0];
    }

    public float getLightnessWeight() {
        return this.mWeights[1];
    }

    public float getPopulationWeight() {
        return this.mWeights[2];
    }

    public boolean isExclusive() {
        return this.mIsExclusive;
    }

    private static void setTargetDefaultValues(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }

    private void setDefaultWeights() {
        this.mWeights[0] = 0.24f;
        this.mWeights[1] = 0.52f;
        this.mWeights[2] = 0.24f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void normalizeWeights() {
        int length = this.mWeights.length;
        float f = 0.0f;
        for (int i = 0; i < length; i++) {
            float f2 = this.mWeights[i];
            if (f2 > 0.0f) {
                f += f2;
            }
        }
        if (f != 0.0f) {
            int length2 = this.mWeights.length;
            for (int i2 = 0; i2 < length2; i2++) {
                if (this.mWeights[i2] > 0.0f) {
                    float[] fArr = this.mWeights;
                    fArr[i2] = fArr[i2] / f;
                }
            }
        }
    }

    private static void setDefaultDarkLightnessValues(Target target) {
        target.mLightnessTargets[1] = 0.26f;
        target.mLightnessTargets[2] = 0.45f;
    }

    private static void setDefaultNormalLightnessValues(Target target) {
        target.mLightnessTargets[0] = 0.3f;
        target.mLightnessTargets[1] = 0.5f;
        target.mLightnessTargets[2] = 0.7f;
    }

    private static void setDefaultLightLightnessValues(Target target) {
        target.mLightnessTargets[0] = 0.55f;
        target.mLightnessTargets[1] = 0.74f;
    }

    private static void setDefaultVibrantSaturationValues(Target target) {
        target.mSaturationTargets[0] = 0.35f;
        target.mSaturationTargets[1] = 1.0f;
    }

    private static void setDefaultMutedSaturationValues(Target target) {
        target.mSaturationTargets[1] = 0.3f;
        target.mSaturationTargets[2] = 0.4f;
    }

    /* loaded from: classes18.dex */
    public static final class Builder {
        private final Target mTarget;

        public Builder() {
            this.mTarget = new Target();
        }

        public Builder(Target target) {
            this.mTarget = new Target(target);
        }

        public Builder setMinimumSaturation(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            this.mTarget.mSaturationTargets[0] = f;
            return this;
        }

        public Builder setTargetSaturation(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            this.mTarget.mSaturationTargets[1] = f;
            return this;
        }

        public Builder setMaximumSaturation(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            this.mTarget.mSaturationTargets[2] = f;
            return this;
        }

        public Builder setMinimumLightness(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            this.mTarget.mLightnessTargets[0] = f;
            return this;
        }

        public Builder setTargetLightness(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            this.mTarget.mLightnessTargets[1] = f;
            return this;
        }

        public Builder setMaximumLightness(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            this.mTarget.mLightnessTargets[2] = f;
            return this;
        }

        public Builder setSaturationWeight(@FloatRange(from = 0.0d) float f) {
            this.mTarget.mWeights[0] = f;
            return this;
        }

        public Builder setLightnessWeight(@FloatRange(from = 0.0d) float f) {
            this.mTarget.mWeights[1] = f;
            return this;
        }

        public Builder setPopulationWeight(@FloatRange(from = 0.0d) float f) {
            this.mTarget.mWeights[2] = f;
            return this;
        }

        public Builder setExclusive(boolean z) {
            this.mTarget.mIsExclusive = z;
            return this;
        }

        public Target build() {
            return this.mTarget;
        }
    }
}
