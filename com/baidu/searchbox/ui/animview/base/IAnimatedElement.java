package com.baidu.searchbox.ui.animview.base;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
/* loaded from: classes7.dex */
public interface IAnimatedElement {
    BaseAnimatedElement cloneInstance();

    void copyAttribute(BaseAnimatedElement baseAnimatedElement);

    void dispatchAnimate(Canvas canvas, float f2, long j);

    int getHeight();

    int getLeft();

    int getTop();

    int getWidth();

    void init(int i2, int i3, int i4, int i5, IResourceProvider iResourceProvider, Object... objArr);

    void releaseResouces();

    void setDrawableCallback(Drawable.Callback callback);

    void setInterpolator(Interpolator interpolator);

    void setRotate(float f2, float f3, float f4);

    void setVisibility(boolean z);
}
