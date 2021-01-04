package com.baidu.live.tieba.d;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes11.dex */
public class a {
    private float bHU;
    private float bHV;
    private float bHW;
    private float bHX;
    private InterfaceC0218a bHY;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.tieba.d.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.bHY.G(i, i2);
                    return true;
                case 1:
                    a.this.bHY.H(i, i2);
                    return true;
                case 2:
                    a.this.bHY.I(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.live.tieba.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0218a {
        void G(int i, int i2);

        void H(int i, int i2);

        void I(int i, int i2);
    }

    public void a(InterfaceC0218a interfaceC0218a) {
        this.bHY = interfaceC0218a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bHW = motionEvent.getRawX();
                this.bHX = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.bHY != null) {
                    int i = (int) (this.bHU - this.bHW);
                    if (Math.abs(i) >= Math.abs((int) (this.bHV - this.bHX))) {
                        F(i, (int) this.bHW);
                    }
                }
                this.bHW = 0.0f;
                this.bHX = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.bHU);
                int i3 = (int) (rawY - this.bHV);
                if (this.bHY != null) {
                    if (i3 > 0) {
                        D(i2, i3);
                    } else {
                        E(i2, i3);
                    }
                }
                this.bHU = rawX;
                this.bHV = rawY;
                return true;
            default:
                return true;
        }
    }

    public void D(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void E(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void F(int i, int i2) {
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
