package com.baidu.adp.lib.stats;

import android.os.Handler;
import com.baidu.adp.lib.stats.switchs.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.InterfaceC0007a {
    final /* synthetic */ a this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.this$0 = aVar;
    }

    @Override // com.baidu.adp.lib.stats.switchs.a.InterfaceC0007a
    public void hz() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        this.this$0.wj = true;
        if (this.this$0.wh) {
            com.baidu.adp.lib.stats.b.i.ip().iw();
        }
        handler = a.mHandler;
        handler.removeMessages(2);
        handler2 = a.mHandler;
        handler3 = a.mHandler;
        handler2.sendMessageDelayed(handler3.obtainMessage(2), 15000L);
    }
}
