package com.baidu.live.tieba.d;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes3.dex */
public class a {
    private float aZA;
    private float aZB;
    private float aZC;
    private InterfaceC0176a aZD;
    private float aZz;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.tieba.d.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.aZD.B(i, i2);
                    return true;
                case 1:
                    a.this.aZD.C(i, i2);
                    return true;
                case 2:
                    a.this.aZD.D(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.live.tieba.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0176a {
        void B(int i, int i2);

        void C(int i, int i2);

        void D(int i, int i2);
    }

    public void a(InterfaceC0176a interfaceC0176a) {
        this.aZD = interfaceC0176a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aZB = motionEvent.getRawX();
                this.aZC = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.aZD != null) {
                    int i = (int) (this.aZz - this.aZB);
                    if (Math.abs(i) >= Math.abs((int) (this.aZA - this.aZC))) {
                        A(i, (int) this.aZB);
                    }
                }
                this.aZB = 0.0f;
                this.aZC = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.aZz);
                int i3 = (int) (rawY - this.aZA);
                if (this.aZD != null) {
                    if (i3 > 0) {
                        y(i2, i3);
                    } else {
                        z(i2, i3);
                    }
                }
                this.aZz = rawX;
                this.aZA = rawY;
                return true;
            default:
                return true;
        }
    }

    public void y(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void z(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void A(int i, int i2) {
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
