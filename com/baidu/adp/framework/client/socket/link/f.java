package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.client.socket.l;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Handler {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, Looper looper) {
        super(looper);
        this.a = eVar;
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
                handler = this.a.c;
                handler.removeMessages(1);
                StringBuilder sb = new StringBuilder("this is reconn time:");
                i = this.a.b;
                BdLog.i(sb.append(i).toString());
                BdSocketLinkService.startService(true, "time to reconnStragety");
                e eVar = this.a;
                i2 = eVar.b;
                eVar.b = i2 + 1;
                int[] a = l.a();
                if (a != null) {
                    i3 = this.a.b;
                    if (i3 < a.length) {
                        StringBuilder sb2 = new StringBuilder("Next will be delay:");
                        i4 = this.a.b;
                        BdLog.i(sb2.append(a[i4]).toString());
                        handler2 = this.a.c;
                        handler3 = this.a.c;
                        Message obtainMessage = handler3.obtainMessage(1);
                        i5 = this.a.b;
                        handler2.sendMessageDelayed(obtainMessage, a[i5] * 1000);
                        return;
                    }
                }
                this.a.b("reconnStragety to the end");
                return;
            default:
                return;
        }
    }
}
