package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public interface f {
    void animate(int i);

    boolean dispatchTouchEvent(MotionEvent motionEvent);

    void draw(Canvas canvas);

    boolean interceptionTouchEvent(MotionEvent motionEvent);

    void measure(int i, int i2);

    boolean touchEvent(MotionEvent motionEvent);
}
