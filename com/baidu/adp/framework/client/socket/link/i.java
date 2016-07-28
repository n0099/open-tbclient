package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ h gy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, Looper looper) {
        super(looper);
        this.gy = hVar;
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
                handler = this.gy.gx;
                handler.removeMessages(1);
                StringBuilder sb = new StringBuilder("this is reconn time:");
                i = this.gy.gw;
                BdLog.i(sb.append(i).toString());
                BdSocketLinkService.startService(true, "time to reconnStragety");
                h hVar = this.gy;
                i2 = hVar.gw;
                hVar.gw = i2 + 1;
                if (com.baidu.adp.lib.util.i.fq()) {
                    int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.eI().getMaxAlertCount("alert_im", 3);
                    i6 = this.gy.gw;
                    if (i6 >= maxAlertCount) {
                        com.baidu.adp.lib.stats.a dN = com.baidu.adp.lib.stats.a.dN();
                        StringBuilder sb2 = new StringBuilder("Socket_Reconnect_");
                        i7 = this.gy.gw;
                        dN.p("alert_im", sb2.append(String.valueOf(i7)).append("_times").toString());
                    }
                }
                int[] aU = com.baidu.adp.framework.client.socket.j.aU();
                if (aU != null) {
                    i3 = this.gy.gw;
                    if (i3 < aU.length) {
                        StringBuilder sb3 = new StringBuilder("Next will be delay:");
                        i4 = this.gy.gw;
                        BdLog.i(sb3.append(aU[i4]).toString());
                        handler2 = this.gy.gx;
                        handler3 = this.gy.gx;
                        Message obtainMessage = handler3.obtainMessage(1);
                        i5 = this.gy.gw;
                        handler2.sendMessageDelayed(obtainMessage, aU[i5] * 1000);
                        return;
                    }
                }
                this.gy.stop("reconnStragety to the end");
                return;
            default:
                return;
        }
    }
}
