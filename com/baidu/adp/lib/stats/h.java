package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.stats.g;
/* loaded from: classes.dex */
class h extends Handler {
    final /* synthetic */ g wW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, Looper looper) {
        super(looper);
        this.wW = gVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        g.a aVar;
        switch (message.what) {
            case 5:
                if ((message.obj instanceof g.a) && (aVar = (g.a) message.obj) != null) {
                    aVar.F(false);
                    aVar.G(false);
                    aVar.am(0);
                    aVar.f(System.currentTimeMillis());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
