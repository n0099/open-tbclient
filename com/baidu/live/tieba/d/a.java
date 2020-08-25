package com.baidu.live.tieba.d;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes7.dex */
public class a {
    private float bkK;
    private float bkL;
    private float bkM;
    private float bkN;
    private InterfaceC0192a bkO;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.tieba.d.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.bkO.H(i, i2);
                    return true;
                case 1:
                    a.this.bkO.I(i, i2);
                    return true;
                case 2:
                    a.this.bkO.J(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.live.tieba.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0192a {
        void H(int i, int i2);

        void I(int i, int i2);

        void J(int i, int i2);
    }

    public void a(InterfaceC0192a interfaceC0192a) {
        this.bkO = interfaceC0192a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bkM = motionEvent.getRawX();
                this.bkN = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.bkO != null) {
                    int i = (int) (this.bkK - this.bkM);
                    if (Math.abs(i) >= Math.abs((int) (this.bkL - this.bkN))) {
                        G(i, (int) this.bkM);
                    }
                }
                this.bkM = 0.0f;
                this.bkN = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.bkK);
                int i3 = (int) (rawY - this.bkL);
                if (this.bkO != null) {
                    if (i3 > 0) {
                        E(i2, i3);
                    } else {
                        F(i2, i3);
                    }
                }
                this.bkK = rawX;
                this.bkL = rawY;
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
