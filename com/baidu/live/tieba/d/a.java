package com.baidu.live.tieba.d;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes11.dex */
public class a {
    private float bGS;
    private float bGT;
    private float bGU;
    private float bGV;
    private InterfaceC0211a bGW;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.tieba.d.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.bGW.G(i, i2);
                    return true;
                case 1:
                    a.this.bGW.H(i, i2);
                    return true;
                case 2:
                    a.this.bGW.I(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.live.tieba.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0211a {
        void G(int i, int i2);

        void H(int i, int i2);

        void I(int i, int i2);
    }

    public void a(InterfaceC0211a interfaceC0211a) {
        this.bGW = interfaceC0211a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bGU = motionEvent.getRawX();
                this.bGV = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.bGW != null) {
                    int i = (int) (this.bGS - this.bGU);
                    if (Math.abs(i) >= Math.abs((int) (this.bGT - this.bGV))) {
                        F(i, (int) this.bGU);
                    }
                }
                this.bGU = 0.0f;
                this.bGV = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.bGS);
                int i3 = (int) (rawY - this.bGT);
                if (this.bGW != null) {
                    if (i3 > 0) {
                        D(i2, i3);
                    } else {
                        E(i2, i3);
                    }
                }
                this.bGS = rawX;
                this.bGT = rawY;
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
