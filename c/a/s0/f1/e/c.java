package c.a.s0.f1.e;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ListView;
/* loaded from: classes6.dex */
public interface c {
    void a();

    void b(Canvas canvas);

    void c(ListView listView, Context context, AttributeSet attributeSet);

    void onDraw(Canvas canvas);

    boolean onInterceptTouchEvent(MotionEvent motionEvent);

    void onMeasure(int i2, int i3);

    void onSizeChanged(int i2, int i3, int i4, int i5);

    boolean onTouchEvent(MotionEvent motionEvent);

    void requestLayout();

    void setAdapter(ListAdapter listAdapter);
}
