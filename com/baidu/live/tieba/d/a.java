package com.baidu.live.tieba.d;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes4.dex */
public class a {
    private float beZ;
    private float bfa;
    private float bfc;
    private float bfd;
    private InterfaceC0185a bfe;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.live.tieba.d.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.bfe.D(i, i2);
                    return true;
                case 1:
                    a.this.bfe.E(i, i2);
                    return true;
                case 2:
                    a.this.bfe.F(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.live.tieba.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0185a {
        void D(int i, int i2);

        void E(int i, int i2);

        void F(int i, int i2);
    }

    public void a(InterfaceC0185a interfaceC0185a) {
        this.bfe = interfaceC0185a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bfc = motionEvent.getRawX();
                this.bfd = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.bfe != null) {
                    int i = (int) (this.beZ - this.bfc);
                    if (Math.abs(i) >= Math.abs((int) (this.bfa - this.bfd))) {
                        C(i, (int) this.bfc);
                    }
                }
                this.bfc = 0.0f;
                this.bfd = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.beZ);
                int i3 = (int) (rawY - this.bfa);
                if (this.bfe != null) {
                    if (i3 > 0) {
                        A(i2, i3);
                    } else {
                        B(i2, i3);
                    }
                }
                this.beZ = rawX;
                this.bfa = rawY;
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
