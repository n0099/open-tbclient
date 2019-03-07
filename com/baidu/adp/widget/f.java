package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public interface f {
    void aR(int i);

    boolean dispatchTouchEvent(MotionEvent motionEvent);

    void draw(Canvas canvas);

    boolean l(MotionEvent motionEvent);

    boolean m(MotionEvent motionEvent);

    void measure(int i, int i2);
}
