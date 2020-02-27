package com.baidu.swan.apps.res.ui.wheelview3d.c;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
/* loaded from: classes11.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {
    private final WheelView3d bND;

    public a(WheelView3d wheelView3d) {
        this.bND = wheelView3d;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.bND.scrollBy(f2);
        return true;
    }
}
