package com.baidu.ar.npc;

import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: classes8.dex */
class aa implements GestureDetector.OnGestureListener {
    final /* synthetic */ BaiduArView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(BaiduArView baiduArView) {
        this.a = baiduArView;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.a.queueEvent(new ab(this, motionEvent));
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.a.queueEvent(new ac(this, motionEvent, motionEvent2, f, f2));
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.a.queueEvent(new ad(this, motionEvent));
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }
}
