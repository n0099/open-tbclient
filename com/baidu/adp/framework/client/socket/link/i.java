package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ h fX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, Looper looper) {
        super(looper);
        this.fX = hVar;
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
                handler = this.fX.fW;
                handler.removeMessages(1);
                StringBuilder sb = new StringBuilder("this is reconn time:");
                i = this.fX.fV;
                BdLog.i(sb.append(i).toString());
                BdSocketLinkService.startService(true, "time to reconnStragety");
                h hVar = this.fX;
                i2 = hVar.fV;
                hVar.fV = i2 + 1;
                if (com.baidu.adp.lib.util.i.fq()) {
                    int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.eI().getMaxAlertCount("alert_im", 3);
                    i6 = this.fX.fV;
                    if (i6 >= maxAlertCount) {
                        com.baidu.adp.lib.stats.a dN = com.baidu.adp.lib.stats.a.dN();
                        StringBuilder sb2 = new StringBuilder("Socket_Reconnect_");
                        i7 = this.fX.fV;
                        dN.p("alert_im", sb2.append(String.valueOf(i7)).append("_times").toString());
                    }
                }
                int[] aV = com.baidu.adp.framework.client.socket.j.aV();
                if (aV != null) {
                    i3 = this.fX.fV;
                    if (i3 < aV.length) {
                        StringBuilder sb3 = new StringBuilder("Next will be delay:");
                        i4 = this.fX.fV;
                        BdLog.i(sb3.append(aV[i4]).toString());
                        handler2 = this.fX.fW;
                        handler3 = this.fX.fW;
                        Message obtainMessage = handler3.obtainMessage(1);
                        i5 = this.fX.fV;
                        handler2.sendMessageDelayed(obtainMessage, aV[i5] * 1000);
                        return;
                    }
                }
                this.fX.stop("reconnStragety to the end");
                return;
            default:
                return;
        }
    }
}
