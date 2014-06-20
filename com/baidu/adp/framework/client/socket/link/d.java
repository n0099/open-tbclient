package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.client.socket.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.m;
/* loaded from: classes.dex */
public class d {
    private boolean a = false;
    private int b = 0;
    private final Handler c = new e(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            b("online failed 5");
        } else if (!this.a) {
            this.a = true;
            this.c.removeMessages(1);
            if (m.a().d()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                b("in Opened");
                return;
            }
            a();
            BdLog.d("启动重连策略");
            this.b = 0;
            int[] a = l.a();
            if (a != null && a.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + a[0]);
                this.c.sendMessageDelayed(this.c.obtainMessage(1), a[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            com.baidu.adp.framework.client.socket.m.a("reconn", 0, 0, com.baidu.tbadk.core.frameworkData.a.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        if (this.a) {
            com.baidu.adp.framework.client.socket.m.a("reconn", 0, 0, com.baidu.tbadk.core.frameworkData.a.STOP, BdSocketLinkService.STOP_RECONN, "ReConnStrategy:stop");
            this.a = false;
            this.b = 0;
            BdLog.i("stop reconnStrategy");
            this.c.removeMessages(1);
        }
    }
}
