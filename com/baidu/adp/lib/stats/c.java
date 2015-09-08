package com.baidu.adp.lib.stats;

import android.os.Handler;
import com.baidu.adp.lib.stats.switchs.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.InterfaceC0006a {
    final /* synthetic */ a this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.this$0 = aVar;
    }

    @Override // com.baidu.adp.lib.stats.switchs.a.InterfaceC0006a
    public void hv() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        this.this$0.wa = true;
        if (this.this$0.vY) {
            com.baidu.adp.lib.stats.b.i.il().is();
        }
        handler = a.mHandler;
        handler.removeMessages(2);
        handler2 = a.mHandler;
        handler3 = a.mHandler;
        handler2.sendMessageDelayed(handler3.obtainMessage(2), 15000L);
    }
}
