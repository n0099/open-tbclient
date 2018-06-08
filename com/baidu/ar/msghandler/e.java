package com.baidu.ar.msghandler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes3.dex */
public class e {
    private static e a;
    private Handler b;

    private e() {
    }

    public static e a() {
        if (a == null) {
            a = new e();
        }
        return a;
    }

    private void b(int i, Bundle bundle) {
        if (this.b != null) {
            Message obtainMessage = this.b.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.setData(bundle);
            this.b.sendMessage(obtainMessage);
        }
    }

    public synchronized void a(int i, Bundle bundle) {
        switch (i) {
            case 30000:
                b(30000, bundle);
                break;
        }
    }

    public void a(Handler handler) {
        this.b = handler;
    }
}
