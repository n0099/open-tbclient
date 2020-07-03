package com.baidu.live.tieba.d;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes3.dex */
public class a {
    private float beG;
    private float beH;
    private float beI;
    private float beJ;
    private InterfaceC0183a beK;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.tieba.d.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.beK.D(i, i2);
                    return true;
                case 1:
                    a.this.beK.E(i, i2);
                    return true;
                case 2:
                    a.this.beK.F(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.live.tieba.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0183a {
        void D(int i, int i2);

        void E(int i, int i2);

        void F(int i, int i2);
    }

    public void a(InterfaceC0183a interfaceC0183a) {
        this.beK = interfaceC0183a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.beI = motionEvent.getRawX();
                this.beJ = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.beK != null) {
                    int i = (int) (this.beG - this.beI);
                    if (Math.abs(i) >= Math.abs((int) (this.beH - this.beJ))) {
                        C(i, (int) this.beI);
                    }
                }
                this.beI = 0.0f;
                this.beJ = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.beG);
                int i3 = (int) (rawY - this.beH);
                if (this.beK != null) {
                    if (i3 > 0) {
                        A(i2, i3);
                    } else {
                        B(i2, i3);
                    }
                }
                this.beG = rawX;
                this.beH = rawY;
                return true;
            default:
                return true;
        }
    }

    public void A(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void B(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void C(int i, int i2) {
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
