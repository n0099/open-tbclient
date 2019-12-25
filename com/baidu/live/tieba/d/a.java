package com.baidu.live.tieba.d;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes2.dex */
public class a {
    private float atj;
    private float atk;
    private InterfaceC0089a atl;
    private float mLastTouchX;
    private float mLastTouchY;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.tieba.d.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.atl.u(i, i2);
                    return true;
                case 1:
                    a.this.atl.v(i, i2);
                    return true;
                case 2:
                    a.this.atl.w(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.live.tieba.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0089a {
        void u(int i, int i2);

        void v(int i, int i2);

        void w(int i, int i2);
    }

    public void a(InterfaceC0089a interfaceC0089a) {
        this.atl = interfaceC0089a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.atj = motionEvent.getRawX();
                this.atk = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.atl != null) {
                    int i = (int) (this.mLastTouchX - this.atj);
                    if (Math.abs(i) >= Math.abs((int) (this.mLastTouchY - this.atk))) {
                        t(i, (int) this.atj);
                    }
                }
                this.atj = 0.0f;
                this.atk = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.mLastTouchX);
                int i3 = (int) (rawY - this.mLastTouchY);
                if (this.atl != null) {
                    if (i3 > 0) {
                        r(i2, i3);
                    } else {
                        s(i2, i3);
                    }
                }
                this.mLastTouchX = rawX;
                this.mLastTouchY = rawY;
                return true;
            default:
                return true;
        }
    }

    public void r(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void s(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void t(int i, int i2) {
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
