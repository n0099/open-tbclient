package b.a.e.m;

import android.graphics.Canvas;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public interface j {
    boolean a(MotionEvent motionEvent);

    void b(int i2, int i3);

    void c(int i2);

    boolean dispatchTouchEvent(MotionEvent motionEvent);

    void draw(Canvas canvas);

    boolean e(MotionEvent motionEvent);
}
