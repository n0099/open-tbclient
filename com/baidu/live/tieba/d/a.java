package com.baidu.live.tieba.d;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes3.dex */
public class a {
    private float aym;
    private float ayn;
    private InterfaceC0096a ayo;
    private float mLastTouchX;
    private float mLastTouchY;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.tieba.d.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.ayo.z(i, i2);
                    return true;
                case 1:
                    a.this.ayo.A(i, i2);
                    return true;
                case 2:
                    a.this.ayo.B(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.live.tieba.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0096a {
        void A(int i, int i2);

        void B(int i, int i2);

        void z(int i, int i2);
    }

    public void a(InterfaceC0096a interfaceC0096a) {
        this.ayo = interfaceC0096a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aym = motionEvent.getRawX();
                this.ayn = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.ayo != null) {
                    int i = (int) (this.mLastTouchX - this.aym);
                    if (Math.abs(i) >= Math.abs((int) (this.mLastTouchY - this.ayn))) {
                        y(i, (int) this.aym);
                    }
                }
                this.aym = 0.0f;
                this.ayn = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.mLastTouchX);
                int i3 = (int) (rawY - this.mLastTouchY);
                if (this.ayo != null) {
                    if (i3 > 0) {
                        w(i2, i3);
                    } else {
                        x(i2, i3);
                    }
                }
                this.mLastTouchX = rawX;
                this.mLastTouchY = rawY;
                return true;
            default:
                return true;
        }
    }

    public void w(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void x(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void y(int i, int i2) {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(2)) {
            Message message = new Message();
            message.what = 2;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }
}
