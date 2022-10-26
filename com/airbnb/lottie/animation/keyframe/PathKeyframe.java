package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
/* loaded from: classes.dex */
public class PathKeyframe extends Keyframe {
    public Path path;
    public final Keyframe pointKeyFrame;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe keyframe) {
        super(lottieComposition, keyframe.startValue, keyframe.endValue, keyframe.interpolator, keyframe.startFrame, keyframe.endFrame);
        this.pointKeyFrame = keyframe;
        createPath();
    }

    public void createPath() {
        boolean z;
        Object obj;
        Object obj2 = this.endValue;
        if (obj2 != null && (obj = this.startValue) != null && ((PointF) obj).equals(((PointF) obj2).x, ((PointF) obj2).y)) {
            z = true;
        } else {
            z = false;
        }
        Object obj3 = this.endValue;
        if (obj3 != null && !z) {
            Keyframe keyframe = this.pointKeyFrame;
            this.path = Utils.createPath((PointF) this.startValue, (PointF) obj3, keyframe.pathCp1, keyframe.pathCp2);
        }
    }

    public Path getPath() {
        return this.path;
    }
}
