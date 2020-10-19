package com.baidu.live.tieba.d;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes4.dex */
public class a {
    private float brt;
    private float bru;
    private float brv;
    private float brw;
    private InterfaceC0200a brx;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.tieba.d.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.brx.H(i, i2);
                    return true;
                case 1:
                    a.this.brx.I(i, i2);
                    return true;
                case 2:
                    a.this.brx.J(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.live.tieba.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0200a {
        void H(int i, int i2);

        void I(int i, int i2);

        void J(int i, int i2);
    }

    public void a(InterfaceC0200a interfaceC0200a) {
        this.brx = interfaceC0200a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.brv = motionEvent.getRawX();
                this.brw = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.brx != null) {
                    int i = (int) (this.brt - this.brv);
                    if (Math.abs(i) >= Math.abs((int) (this.bru - this.brw))) {
                        G(i, (int) this.brv);
                    }
                }
                this.brv = 0.0f;
                this.brw = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.brt);
                int i3 = (int) (rawY - this.bru);
                if (this.brx != null) {
                    if (i3 > 0) {
                        E(i2, i3);
                    } else {
                        F(i2, i3);
                    }
                }
                this.brt = rawX;
                this.bru = rawY;
                return true;
            default:
                return true;
        }
    }

    public void E(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void F(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void G(int i, int i2) {
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
