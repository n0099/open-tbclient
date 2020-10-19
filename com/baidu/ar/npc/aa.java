package com.baidu.ar.npc;

import android.view.GestureDetector;
import android.view.MotionEvent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class aa implements GestureDetector.OnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduArView f1211a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(BaiduArView baiduArView) {
        this.f1211a = baiduArView;
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
        this.f1211a.queueEvent(new ab(this, motionEvent));
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f1211a.queueEvent(new ac(this, motionEvent, motionEvent2, f, f2));
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.f1211a.queueEvent(new ad(this, motionEvent));
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }
}
