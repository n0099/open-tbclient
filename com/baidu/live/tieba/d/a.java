package com.baidu.live.tieba.d;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes4.dex */
public class a {
    private float bnG;
    private float bnH;
    private float bnI;
    private float bnJ;
    private InterfaceC0192a bnK;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.tieba.d.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.bnK.H(i, i2);
                    return true;
                case 1:
                    a.this.bnK.I(i, i2);
                    return true;
                case 2:
                    a.this.bnK.J(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.live.tieba.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0192a {
        void H(int i, int i2);

        void I(int i, int i2);

        void J(int i, int i2);
    }

    public void a(InterfaceC0192a interfaceC0192a) {
        this.bnK = interfaceC0192a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bnI = motionEvent.getRawX();
                this.bnJ = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.bnK != null) {
                    int i = (int) (this.bnG - this.bnI);
                    if (Math.abs(i) >= Math.abs((int) (this.bnH - this.bnJ))) {
                        G(i, (int) this.bnI);
                    }
                }
                this.bnI = 0.0f;
                this.bnJ = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.bnG);
                int i3 = (int) (rawY - this.bnH);
                if (this.bnK != null) {
                    if (i3 > 0) {
                        E(i2, i3);
                    } else {
                        F(i2, i3);
                    }
                }
                this.bnG = rawX;
                this.bnH = rawY;
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
