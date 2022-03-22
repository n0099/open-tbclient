package com.airbnb.lottie.model.content;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes3.dex */
public class GradientColor {
    public final int[] colors;
    public final float[] positions;

    public GradientColor(float[] fArr, int[] iArr) {
        this.positions = fArr;
        this.colors = iArr;
    }

    public int[] getColors() {
        return this.colors;
    }

    public float[] getPositions() {
        return this.positions;
    }

    public int getSize() {
        return this.colors.length;
    }

    public void lerp(GradientColor gradientColor, GradientColor gradientColor2, float f2) {
        if (gradientColor.colors.length == gradientColor2.colors.length) {
            for (int i = 0; i < gradientColor.colors.length; i++) {
                this.positions[i] = MiscUtils.lerp(gradientColor.positions[i], gradientColor2.positions[i], f2);
                this.colors[i] = GammaEvaluator.evaluate(f2, gradientColor.colors[i], gradientColor2.colors[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + gradientColor.colors.length + " vs " + gradientColor2.colors.length + SmallTailInfo.EMOTION_SUFFIX);
    }
}
