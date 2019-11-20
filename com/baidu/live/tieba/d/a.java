package com.baidu.live.tieba.d;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes6.dex */
public class a {
    private float alf;
    private float alg;
    private float alh;
    private float ali;
    private InterfaceC0073a alj;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.tieba.d.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.alj.t(i, i2);
                    return true;
                case 1:
                    a.this.alj.u(i, i2);
                    return true;
                case 2:
                    a.this.alj.v(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.live.tieba.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0073a {
        void t(int i, int i2);

        void u(int i, int i2);

        void v(int i, int i2);
    }

    public void a(InterfaceC0073a interfaceC0073a) {
        this.alj = interfaceC0073a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.alh = motionEvent.getRawX();
                this.ali = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.alj != null) {
                    int i = (int) (this.alf - this.alh);
                    if (Math.abs(i) >= Math.abs((int) (this.alg - this.ali))) {
                        s(i, (int) this.alh);
                    }
                }
                this.alh = 0.0f;
                this.ali = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.alf);
                int i3 = (int) (rawY - this.alg);
                if (this.alj != null) {
                    if (i3 > 0) {
                        q(i2, i3);
                    } else {
                        r(i2, i3);
                    }
                }
                this.alf = rawX;
                this.alg = rawY;
                return true;
            default:
                return true;
        }
    }

    public void q(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void r(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void s(int i, int i2) {
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
