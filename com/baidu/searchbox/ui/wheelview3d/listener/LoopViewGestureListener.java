package com.baidu.searchbox.ui.wheelview3d.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.searchbox.ui.wheelview3d.WheelView3d;
/* loaded from: classes13.dex */
public final class LoopViewGestureListener extends GestureDetector.SimpleOnGestureListener {
    private final WheelView3d wheelView;

    public LoopViewGestureListener(WheelView3d wheelView3d) {
        this.wheelView = wheelView3d;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.wheelView.scrollBy(f2);
        return true;
    }
}
