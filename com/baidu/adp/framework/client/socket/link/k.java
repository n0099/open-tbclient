package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    final /* synthetic */ j eE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(j jVar, Looper looper) {
        super(looper);
        this.eE = jVar;
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
                handler = this.eE.eD;
                handler.removeMessages(1);
                StringBuilder sb = new StringBuilder("this is reconn time:");
                i = this.eE.eC;
                BdLog.i(sb.append(i).toString());
                BdSocketLinkService.startService(true, "time to reconnStragety");
                j jVar = this.eE;
                i2 = jVar.eC;
                jVar.eC = i2 + 1;
                int[] bb = com.baidu.adp.framework.client.socket.l.bb();
                if (bb != null) {
                    i3 = this.eE.eC;
                    if (i3 < bb.length) {
                        StringBuilder sb2 = new StringBuilder("Next will be delay:");
                        i4 = this.eE.eC;
                        BdLog.i(sb2.append(bb[i4]).toString());
                        handler2 = this.eE.eD;
                        handler3 = this.eE.eD;
                        Message obtainMessage = handler3.obtainMessage(1);
                        i5 = this.eE.eC;
                        handler2.sendMessageDelayed(obtainMessage, bb[i5] * 1000);
                        return;
                    }
                }
                this.eE.A("reconnStragety to the end");
                return;
            default:
                return;
        }
    }
}
