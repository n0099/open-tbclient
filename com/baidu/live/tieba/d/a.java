package com.baidu.live.tieba.d;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes3.dex */
public class a {
    private float aSl;
    private float aSm;
    private float aSn;
    private float aSo;
    private InterfaceC0143a aSp;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.tieba.d.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.aSp.y(i, i2);
                    return true;
                case 1:
                    a.this.aSp.z(i, i2);
                    return true;
                case 2:
                    a.this.aSp.A(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.live.tieba.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0143a {
        void A(int i, int i2);

        void y(int i, int i2);

        void z(int i, int i2);
    }

    public void a(InterfaceC0143a interfaceC0143a) {
        this.aSp = interfaceC0143a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aSn = motionEvent.getRawX();
                this.aSo = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.aSp != null) {
                    int i = (int) (this.aSl - this.aSn);
                    if (Math.abs(i) >= Math.abs((int) (this.aSm - this.aSo))) {
                        x(i, (int) this.aSn);
                    }
                }
                this.aSn = 0.0f;
                this.aSo = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.aSl);
                int i3 = (int) (rawY - this.aSm);
                if (this.aSp != null) {
                    if (i3 > 0) {
                        v(i2, i3);
                    } else {
                        w(i2, i3);
                    }
                }
                this.aSl = rawX;
                this.aSm = rawY;
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
