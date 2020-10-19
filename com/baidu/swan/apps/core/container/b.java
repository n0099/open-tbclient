package com.baidu.swan.apps.core.container;

import android.view.KeyEvent;
import android.view.MotionEvent;
/* loaded from: classes10.dex */
public interface b {
    boolean dispatchTouchEvent(MotionEvent motionEvent);

    boolean onKeyDown(int i, KeyEvent keyEvent);

    void onScrollChanged(int i, int i2, int i3, int i4);

    boolean onTouchEvent(MotionEvent motionEvent);
}
