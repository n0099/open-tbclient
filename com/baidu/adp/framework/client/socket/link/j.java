package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.client.socket.l;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends Handler {
    final /* synthetic */ i eC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(i iVar, Looper looper) {
        super(looper);
        this.eC = iVar;
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
                handler = this.eC.eB;
                handler.removeMessages(1);
                StringBuilder sb = new StringBuilder("this is reconn time:");
                i = this.eC.eA;
                BdLog.i(sb.append(i).toString());
                BdSocketLinkService.startService(true, "time to reconnStragety");
                i iVar = this.eC;
                i2 = iVar.eA;
                iVar.eA = i2 + 1;
                int[] bb = l.bb();
                if (bb != null) {
                    i3 = this.eC.eA;
                    if (i3 < bb.length) {
                        StringBuilder sb2 = new StringBuilder("Next will be delay:");
                        i4 = this.eC.eA;
                        BdLog.i(sb2.append(bb[i4]).toString());
                        handler2 = this.eC.eB;
                        handler3 = this.eC.eB;
                        Message obtainMessage = handler3.obtainMessage(1);
                        i5 = this.eC.eA;
                        handler2.sendMessageDelayed(obtainMessage, bb[i5] * 1000);
                        return;
                    }
                }
                this.eC.A("reconnStragety to the end");
                return;
            default:
                return;
        }
    }
}
