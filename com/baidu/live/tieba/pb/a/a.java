package com.baidu.live.tieba.pb.a;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class a implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnTouchListener {
    private InterfaceC0217a bCj;
    private View bCk;
    private GestureDetector mGestureDetector = new GestureDetector(TbadkCoreApplication.getInst(), this);

    /* renamed from: com.baidu.live.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0217a {
        boolean onDoubleTap(View view, MotionEvent motionEvent);

        boolean onDoubleTapEvent(View view, MotionEvent motionEvent);

        boolean onSingleTapConfirmed(View view, MotionEvent motionEvent);
    }

    public a(InterfaceC0217a interfaceC0217a) {
        this.bCj = interfaceC0217a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.bCk = view;
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
        if (this.bCj != null) {
            return this.bCj.onDoubleTap(this.bCk, motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        if (this.bCj != null) {
            return this.bCj.onDoubleTapEvent(this.bCk, motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (this.bCj != null) {
            return this.bCj.onSingleTapConfirmed(this.bCk, motionEvent);
        }
        return false;
    }

    public void ad(View view) {
        this.bCk = view;
    }
}
