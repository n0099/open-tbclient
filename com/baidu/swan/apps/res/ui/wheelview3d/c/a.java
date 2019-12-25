package com.baidu.swan.apps.res.ui.wheelview3d.c;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
/* loaded from: classes9.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {
    private final WheelView3d bIO;

    public a(WheelView3d wheelView3d) {
        this.bIO = wheelView3d;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.bIO.scrollBy(f2);
        return true;
    }
}
