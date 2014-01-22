package com.baidu.sapi2;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class c extends Handler {
    final /* synthetic */ SapiWebView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SapiWebView sapiWebView) {
        this.a = sapiWebView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1 && this.a.o != null) {
            this.a.o.onTimeout((String) message.obj);
        }
    }
}
