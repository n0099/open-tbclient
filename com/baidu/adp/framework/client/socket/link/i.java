package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ h qf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, Looper looper) {
        super(looper);
        this.qf = hVar;
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
                handler = this.qf.qe;
                handler.removeMessages(1);
                StringBuilder sb = new StringBuilder("this is reconn time:");
                i = this.qf.qd;
                BdLog.i(sb.append(i).toString());
                BdSocketLinkService.startService(true, "time to reconnStragety");
                h hVar = this.qf;
                i2 = hVar.qd;
                hVar.qd = i2 + 1;
                int[] eF = com.baidu.adp.framework.client.socket.j.eF();
                if (eF != null) {
                    i3 = this.qf.qd;
                    if (i3 < eF.length) {
                        StringBuilder sb2 = new StringBuilder("Next will be delay:");
                        i4 = this.qf.qd;
                        BdLog.i(sb2.append(eF[i4]).toString());
                        handler2 = this.qf.qe;
                        handler3 = this.qf.qe;
                        Message obtainMessage = handler3.obtainMessage(1);
                        i5 = this.qf.qd;
                        handler2.sendMessageDelayed(obtainMessage, eF[i5] * 1000);
                        return;
                    }
                }
                this.qf.stop("reconnStragety to the end");
                return;
            default:
                return;
        }
    }
}
