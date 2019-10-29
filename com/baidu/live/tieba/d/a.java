package com.baidu.live.tieba.d;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes6.dex */
public class a {
    private float alA;
    private float alB;
    private InterfaceC0073a alC;
    private float aly;
    private float alz;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.tieba.d.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.alC.v(i, i2);
                    return true;
                case 1:
                    a.this.alC.w(i, i2);
                    return true;
                case 2:
                    a.this.alC.x(i, i2);
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
        void v(int i, int i2);

        void w(int i, int i2);

        void x(int i, int i2);
    }

    public void a(InterfaceC0073a interfaceC0073a) {
        this.alC = interfaceC0073a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.alA = motionEvent.getRawX();
                this.alB = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.alC != null) {
                    int i = (int) (this.aly - this.alA);
                    if (Math.abs(i) >= Math.abs((int) (this.alz - this.alB))) {
                        u(i, (int) this.alA);
                    }
                }
                this.alA = 0.0f;
                this.alB = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.aly);
                int i3 = (int) (rawY - this.alz);
                if (this.alC != null) {
                    if (i3 > 0) {
                        s(i2, i3);
                    } else {
                        t(i2, i3);
                    }
                }
                this.aly = rawX;
                this.alz = rawY;
                return true;
            default:
                return true;
        }
    }

    public void s(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void t(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void u(int i, int i2) {
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
