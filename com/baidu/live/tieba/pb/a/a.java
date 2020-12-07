package com.baidu.live.tieba.pb.a;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class a implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnTouchListener {
    private InterfaceC0224a bFG;
    private View bFH;
    private GestureDetector mGestureDetector = new GestureDetector(TbadkCoreApplication.getInst(), this);

    /* renamed from: com.baidu.live.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0224a {
        boolean onDoubleTap(View view, MotionEvent motionEvent);

        boolean onDoubleTapEvent(View view, MotionEvent motionEvent);

        boolean onSingleTapConfirmed(View view, MotionEvent motionEvent);
    }

    public a(InterfaceC0224a interfaceC0224a) {
        this.bFG = interfaceC0224a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.bFH = view;
        if (this.mGestureDetector != null) {
            return this.mGestureDetector.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.bFG != null) {
            return this.bFG.onDoubleTap(this.bFH, motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        if (this.bFG != null) {
            return this.bFG.onDoubleTapEvent(this.bFH, motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (this.bFG != null) {
            return this.bFG.onSingleTapConfirmed(this.bFH, motionEvent);
        }
        return false;
    }

    public void ad(View view) {
        this.bFH = view;
    }
}
