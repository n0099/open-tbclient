package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
/* loaded from: classes.dex */
public class PathKeyframe extends Keyframe<PointF> {
    @Nullable
    public Path path;
    public final Keyframe<PointF> pointKeyFrame;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        super(lottieComposition, keyframe.startValue, keyframe.endValue, keyframe.interpolator, keyframe.startFrame, keyframe.endFrame);
        this.pointKeyFrame = keyframe;
        createPath();
    }

    public void createPath() {
        boolean z;
        T t;
        T t2 = this.endValue;
        if (t2 != 0 && (t = this.startValue) != 0 && ((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) {
            z = true;
        } else {
            z = false;
        }
        T t3 = this.endValue;
        if (t3 != 0 && !z) {
            Keyframe<PointF> keyframe = this.pointKeyFrame;
            this.path = Utils.createPath((PointF) this.startValue, (PointF) t3, keyframe.pathCp1, keyframe.pathCp2);
        }
    }

    @Nullable
    public Path getPath() {
        return this.path;
    }
}
