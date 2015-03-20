package com.baidu.location;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a0, n {
    private static r cR = null;
    private l cQ = null;
    private Handler cS;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (ad.gO) {
                switch (message.what) {
                    case a0.f39try /* 92 */:
                        r.this.K();
                        break;
                }
                super.handleMessage(message);
            }
        }
    }

    private r() {
        this.cS = null;
        this.cS = new a();
    }

    public static r I() {
        if (cR == null) {
            cR = new r();
        }
        return cR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        try {
            if (aa.gu) {
                if (c.aK) {
                }
            }
        } catch (Exception e) {
        }
    }

    public void H() {
        if (this.cQ != null) {
            this.cQ.v();
        }
        this.cQ = null;
    }

    public Handler J() {
        return this.cS;
    }

    public void L() {
    }
}
