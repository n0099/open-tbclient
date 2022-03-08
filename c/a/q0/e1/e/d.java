package c.a.q0.e1.e;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.ListAdapter;
/* loaded from: classes2.dex */
public interface d {
    void a();

    void b(Canvas canvas);

    void onDraw(Canvas canvas);

    boolean onInterceptTouchEvent(MotionEvent motionEvent);

    void onMeasure(int i2, int i3);

    void onSizeChanged(int i2, int i3, int i4, int i5);

    boolean onTouchEvent(MotionEvent motionEvent);

    void requestLayout();

    void setAdapter(ListAdapter listAdapter);
}
