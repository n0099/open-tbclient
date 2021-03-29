package com.baidu.ar.npc;

import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class aa implements GestureDetector.OnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaiduArView f4156a;

    public aa(BaiduArView baiduArView) {
        this.f4156a = baiduArView;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.f4156a.queueEvent(new ad(this, motionEvent));
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f4156a.queueEvent(new ac(this, motionEvent, motionEvent2, f2, f3));
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f4156a.queueEvent(new ab(this, motionEvent));
        return false;
    }
}
