package com.baidu.live.tieba.d;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes3.dex */
public class a {
    private float aSg;
    private float aSh;
    private float aSi;
    private float aSj;
    private InterfaceC0122a aSk;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.tieba.d.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.aSk.y(i, i2);
                    return true;
                case 1:
                    a.this.aSk.z(i, i2);
                    return true;
                case 2:
                    a.this.aSk.A(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.live.tieba.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0122a {
        void A(int i, int i2);

        void y(int i, int i2);

        void z(int i, int i2);
    }

    public void a(InterfaceC0122a interfaceC0122a) {
        this.aSk = interfaceC0122a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aSi = motionEvent.getRawX();
                this.aSj = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.aSk != null) {
                    int i = (int) (this.aSg - this.aSi);
                    if (Math.abs(i) >= Math.abs((int) (this.aSh - this.aSj))) {
                        x(i, (int) this.aSi);
                    }
                }
                this.aSi = 0.0f;
                this.aSj = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.aSg);
                int i3 = (int) (rawY - this.aSh);
                if (this.aSk != null) {
                    if (i3 > 0) {
                        v(i2, i3);
                    } else {
                        w(i2, i3);
                    }
                }
                this.aSg = rawX;
                this.aSh = rawY;
                return true;
            default:
                return true;
        }
    }

    public void v(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void w(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void x(int i, int i2) {
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
