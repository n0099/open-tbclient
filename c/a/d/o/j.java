package c.a.d.o;

import android.graphics.Canvas;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public interface j {
    boolean a(MotionEvent motionEvent);

    void b(int i, int i2);

    void c(int i);

    boolean dispatchTouchEvent(MotionEvent motionEvent);

    void draw(Canvas canvas);

    boolean e(MotionEvent motionEvent);
}
