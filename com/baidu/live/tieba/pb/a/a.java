package com.baidu.live.tieba.pb.a;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes7.dex */
public class a implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnTouchListener {
    private InterfaceC0196a bnh;
    private View bni;
    private GestureDetector mGestureDetector = new GestureDetector(TbadkCoreApplication.getInst(), this);

    /* renamed from: com.baidu.live.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0196a {
        boolean onDoubleTap(View view, MotionEvent motionEvent);

        boolean onDoubleTapEvent(View view, MotionEvent motionEvent);

        boolean onSingleTapConfirmed(View view, MotionEvent motionEvent);
    }

    public a(InterfaceC0196a interfaceC0196a) {
        this.bnh = interfaceC0196a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.bni = view;
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
        if (this.bnh != null) {
            return this.bnh.onDoubleTap(this.bni, motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        if (this.bnh != null) {
            return this.bnh.onDoubleTapEvent(this.bni, motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (this.bnh != null) {
            return this.bnh.onSingleTapConfirmed(this.bni, motionEvent);
        }
        return false;
    }

    public void X(View view) {
        this.bni = view;
    }
}
