package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ h qb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, Looper looper) {
        super(looper);
        this.qb = hVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        int i;
        int i2;
        int i3;
        int i4;
        Handler handler2;
        Handler handler3;
        int i5;
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                handler = this.qb.myHandler;
                handler.removeMessages(1);
                StringBuilder sb = new StringBuilder("this is reconn time:");
                i = this.qb.qa;
                BdLog.i(sb.append(i).toString());
                BdSocketLinkService.startService(true, "time to reconnStragety");
                h hVar = this.qb;
                i2 = hVar.qa;
                hVar.qa = i2 + 1;
                int[] eB = com.baidu.adp.framework.client.socket.j.eB();
                if (eB != null) {
                    i3 = this.qb.qa;
                    if (i3 < eB.length) {
                        StringBuilder sb2 = new StringBuilder("Next will be delay:");
                        i4 = this.qb.qa;
                        BdLog.i(sb2.append(eB[i4]).toString());
                        handler2 = this.qb.myHandler;
                        handler3 = this.qb.myHandler;
                        Message obtainMessage = handler3.obtainMessage(1);
                        i5 = this.qb.qa;
                        handler2.sendMessageDelayed(obtainMessage, eB[i5] * 1000);
                        return;
                    }
                }
                this.qb.stop("reconnStragety to the end");
                return;
            default:
                return;
        }
    }
}
