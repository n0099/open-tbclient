package com.baidu.searchbox.ui.animview.base;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
/* loaded from: classes13.dex */
public interface IAnimatedElement {
    BaseAnimatedElement cloneInstance();

    void dispatchAnimate(Canvas canvas, float f, long j);

    int getHeight();

    int getLeft();

    int getTop();

    int getWidth();

    void init(int i, int i2, int i3, int i4, IResourceProvider iResourceProvider, Object... objArr);

    void releaseResouces();

    void setDrawableCallback(Drawable.Callback callback);

    void setInterpolator(Interpolator interpolator);

    void setVisibility(boolean z);
}
