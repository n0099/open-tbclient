package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o extends Handler {
    final /* synthetic */ n a;

    private o(n nVar) {
        this.a = nVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(n nVar, byte b) {
        this(nVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case LocationClientOption.MIN_SCAN_SPAN /* 1000 */:
                n.a(this.a);
                return;
            default:
                return;
        }
    }
}
