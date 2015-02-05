package com.baidu.tbadk.core.util.httpNet;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends Handler {
    final /* synthetic */ CDNIPDirectConnect this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(CDNIPDirectConnect cDNIPDirectConnect, Looper looper) {
        super(looper);
        this.this$0 = cDNIPDirectConnect;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1003) {
            CDNIPDirectConnect.pQ().pS();
        }
    }
}
