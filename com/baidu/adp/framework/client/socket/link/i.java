package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ h iS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, Looper looper) {
        super(looper);
        this.iS = hVar;
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
        int i6;
        int i7;
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                handler = this.iS.iR;
                handler.removeMessages(1);
                StringBuilder sb = new StringBuilder("this is reconn time:");
                i = this.iS.iQ;
                BdLog.i(sb.append(i).toString());
                BdSocketLinkService.startService(true, "time to reconnStragety");
                h hVar = this.iS;
                i2 = hVar.iQ;
                hVar.iQ = i2 + 1;
                if (com.baidu.adp.lib.util.i.gm()) {
                    int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.fD().getMaxAlertCount("alert_im", 3);
                    i6 = this.iS.iQ;
                    if (i6 >= maxAlertCount) {
                        com.baidu.adp.lib.stats.a eI = com.baidu.adp.lib.stats.a.eI();
                        StringBuilder sb2 = new StringBuilder("Socket_Reconnect_");
                        i7 = this.iS.iQ;
                        eI.p("alert_im", sb2.append(String.valueOf(i7)).append("_times").toString());
                    }
                }
                int[] bP = com.baidu.adp.framework.client.socket.j.bP();
                if (bP != null) {
                    i3 = this.iS.iQ;
                    if (i3 < bP.length) {
                        StringBuilder sb3 = new StringBuilder("Next will be delay:");
                        i4 = this.iS.iQ;
                        BdLog.i(sb3.append(bP[i4]).toString());
                        handler2 = this.iS.iR;
                        handler3 = this.iS.iR;
                        Message obtainMessage = handler3.obtainMessage(1);
                        i5 = this.iS.iQ;
                        handler2.sendMessageDelayed(obtainMessage, bP[i5] * 1000);
                        return;
                    }
                }
                this.iS.stop("reconnStragety to the end");
                return;
            default:
                return;
        }
    }
}
