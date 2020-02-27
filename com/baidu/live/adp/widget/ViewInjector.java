package com.baidu.live.adp.widget;

import android.graphics.Canvas;
import android.view.MotionEvent;
/* loaded from: classes3.dex */
public interface ViewInjector {
    void animate(int i);

    boolean dispatchTouchEvent(MotionEvent motionEvent);

    void draw(Canvas canvas);

    boolean interceptionTouchEvent(MotionEvent motionEvent);

    boolean isAnimating();

    void measure(int i, int i2);

    boolean touchEvent(MotionEvent motionEvent);
}
