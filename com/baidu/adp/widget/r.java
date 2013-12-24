package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
class r extends Handler {
    final /* synthetic */ q a;

    private r(q qVar) {
        this.a = qVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case LocationClientOption.MIN_SCAN_SPAN /* 1000 */:
                q.a(this.a);
                return;
            default:
                return;
        }
    }
}
