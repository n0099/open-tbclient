package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ h qI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, Looper looper) {
        super(looper);
        this.qI = hVar;
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
                handler = this.qI.qH;
                handler.removeMessages(1);
                StringBuilder sb = new StringBuilder("this is reconn time:");
                i = this.qI.qG;
                BdLog.i(sb.append(i).toString());
                BdSocketLinkService.startService(true, "time to reconnStragety");
                h hVar = this.qI;
                i2 = hVar.qG;
                hVar.qG = i2 + 1;
                if (com.baidu.adp.lib.util.i.he()) {
                    int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.gw().getMaxAlertCount("alert_im", 3);
                    i6 = this.qI.qG;
                    if (i6 >= maxAlertCount) {
                        BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                        StringBuilder sb2 = new StringBuilder("Socket_Reconnect_");
                        i7 = this.qI.qG;
                        bdStatisticsManager.alert("alert_im", sb2.append(String.valueOf(i7)).append("_times").toString());
                    }
                }
                int[] cY = com.baidu.adp.framework.client.socket.j.cY();
                if (cY != null) {
                    i3 = this.qI.qG;
                    if (i3 < cY.length) {
                        StringBuilder sb3 = new StringBuilder("Next will be delay:");
                        i4 = this.qI.qG;
                        BdLog.i(sb3.append(cY[i4]).toString());
                        handler2 = this.qI.qH;
                        handler3 = this.qI.qH;
                        Message obtainMessage = handler3.obtainMessage(1);
                        i5 = this.qI.qG;
                        handler2.sendMessageDelayed(obtainMessage, cY[i5] * 1000);
                        return;
                    }
                }
                this.qI.stop("reconnStragety to the end");
                return;
            default:
                return;
        }
    }
}
