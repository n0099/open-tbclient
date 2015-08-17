package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ h qa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, Looper looper) {
        super(looper);
        this.qa = hVar;
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
                handler = this.qa.myHandler;
                handler.removeMessages(1);
                StringBuilder sb = new StringBuilder("this is reconn time:");
                i = this.qa.pZ;
                BdLog.i(sb.append(i).toString());
                BdSocketLinkService.startService(true, "time to reconnStragety");
                h hVar = this.qa;
                i2 = hVar.pZ;
                hVar.pZ = i2 + 1;
                int[] eC = com.baidu.adp.framework.client.socket.j.eC();
                if (eC != null) {
                    i3 = this.qa.pZ;
                    if (i3 < eC.length) {
                        StringBuilder sb2 = new StringBuilder("Next will be delay:");
                        i4 = this.qa.pZ;
                        BdLog.i(sb2.append(eC[i4]).toString());
                        handler2 = this.qa.myHandler;
                        handler3 = this.qa.myHandler;
                        Message obtainMessage = handler3.obtainMessage(1);
                        i5 = this.qa.pZ;
                        handler2.sendMessageDelayed(obtainMessage, eC[i5] * 1000);
                        return;
                    }
                }
                this.qa.stop("reconnStragety to the end");
                return;
            default:
                return;
        }
    }
}
