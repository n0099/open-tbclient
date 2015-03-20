package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    final /* synthetic */ j pW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(j jVar, Looper looper) {
        super(looper);
        this.pW = jVar;
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
                handler = this.pW.pV;
                handler.removeMessages(1);
                StringBuilder sb = new StringBuilder("this is reconn time:");
                i = this.pW.pU;
                BdLog.i(sb.append(i).toString());
                BdSocketLinkService.startService(true, "time to reconnStragety");
                j jVar = this.pW;
                i2 = jVar.pU;
                jVar.pU = i2 + 1;
                int[] ey = com.baidu.adp.framework.client.socket.l.ey();
                if (ey != null) {
                    i3 = this.pW.pU;
                    if (i3 < ey.length) {
                        StringBuilder sb2 = new StringBuilder("Next will be delay:");
                        i4 = this.pW.pU;
                        BdLog.i(sb2.append(ey[i4]).toString());
                        handler2 = this.pW.pV;
                        handler3 = this.pW.pV;
                        Message obtainMessage = handler3.obtainMessage(1);
                        i5 = this.pW.pU;
                        handler2.sendMessageDelayed(obtainMessage, ey[i5] * 1000);
                        return;
                    }
                }
                this.pW.stop("reconnStragety to the end");
                return;
            default:
                return;
        }
    }
}
