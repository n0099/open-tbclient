package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ h qj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, Looper looper) {
        super(looper);
        this.qj = hVar;
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
                handler = this.qj.qi;
                handler.removeMessages(1);
                StringBuilder sb = new StringBuilder("this is reconn time:");
                i = this.qj.qh;
                BdLog.i(sb.append(i).toString());
                BdSocketLinkService.startService(true, "time to reconnStragety");
                h hVar = this.qj;
                i2 = hVar.qh;
                hVar.qh = i2 + 1;
                int[] eF = com.baidu.adp.framework.client.socket.j.eF();
                if (eF != null) {
                    i3 = this.qj.qh;
                    if (i3 < eF.length) {
                        StringBuilder sb2 = new StringBuilder("Next will be delay:");
                        i4 = this.qj.qh;
                        BdLog.i(sb2.append(eF[i4]).toString());
                        handler2 = this.qj.qi;
                        handler3 = this.qj.qi;
                        Message obtainMessage = handler3.obtainMessage(1);
                        i5 = this.qj.qh;
                        handler2.sendMessageDelayed(obtainMessage, eF[i5] * 1000);
                        return;
                    }
                }
                this.qj.stop("reconnStragety to the end");
                return;
            default:
                return;
        }
    }
}
