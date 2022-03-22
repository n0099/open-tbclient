package c.a.o0.e1.e;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ListView;
/* loaded from: classes2.dex */
public interface c {
    void a();

    void b(Canvas canvas);

    void c(ListView listView, Context context, AttributeSet attributeSet);

    void onDraw(Canvas canvas);

    boolean onInterceptTouchEvent(MotionEvent motionEvent);

    void onMeasure(int i, int i2);

    void onSizeChanged(int i, int i2, int i3, int i4);

    boolean onTouchEvent(MotionEvent motionEvent);

    void requestLayout();

    void setAdapter(ListAdapter listAdapter);
}
