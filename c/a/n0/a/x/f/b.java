package c.a.n0.a.x.f;

import android.view.KeyEvent;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public interface b {
    boolean dispatchTouchEvent(MotionEvent motionEvent);

    boolean onKeyDown(int i, KeyEvent keyEvent);

    void onScrollChanged(int i, int i2, int i3, int i4);

    boolean onTouchEvent(MotionEvent motionEvent);
}
