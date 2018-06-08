package com.baidu.ar.ui.rotateview;

import android.view.animation.Animation;
import com.baidu.ar.rotate.Orientation;
/* loaded from: classes3.dex */
public interface IRotateView {
    void clearAnimation();

    int getAngle();

    int getVisibility();

    boolean isShown();

    void requestOrientation(Orientation orientation);

    void requestOrientation(Orientation orientation, boolean z);

    void setAngle(int i);

    void startAnimation(Animation animation);
}
