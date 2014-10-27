package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.client.socket.l;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends Handler {
    final /* synthetic */ i cv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(i iVar, Looper looper) {
        super(looper);
        this.cv = iVar;
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
                handler = this.cv.cu;
                handler.removeMessages(1);
                StringBuilder sb = new StringBuilder("this is reconn time:");
                i = this.cv.ct;
                BdLog.i(sb.append(i).toString());
                BdSocketLinkService.startService(true, "time to reconnStragety");
                i iVar = this.cv;
                i2 = iVar.ct;
                iVar.ct = i2 + 1;
                int[] aB = l.aB();
                if (aB != null) {
                    i3 = this.cv.ct;
                    if (i3 < aB.length) {
                        StringBuilder sb2 = new StringBuilder("Next will be delay:");
                        i4 = this.cv.ct;
                        BdLog.i(sb2.append(aB[i4]).toString());
                        handler2 = this.cv.cu;
                        handler3 = this.cv.cu;
                        Message obtainMessage = handler3.obtainMessage(1);
                        i5 = this.cv.ct;
                        handler2.sendMessageDelayed(obtainMessage, aB[i5] * 1000);
                        return;
                    }
                }
                this.cv.l("reconnStragety to the end");
                return;
            default:
                return;
        }
    }
}
