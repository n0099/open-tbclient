package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.client.socket.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.m;
/* loaded from: classes.dex */
public class i {
    private boolean cs = false;
    private int ct = 0;
    private final Handler cu = new j(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: protected */
    public void start(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            l("online failed 5");
        } else if (!this.cs) {
            this.cs = true;
            this.cu.removeMessages(1);
            if (m.fT().fW()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                l("in Opened");
                return;
            }
            aN();
            BdLog.d("启动重连策略");
            this.ct = 0;
            int[] aB = l.aB();
            if (aB != null && aB.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + aB[0]);
                this.cu.sendMessageDelayed(this.cu.obtainMessage(1), aB[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            com.baidu.adp.framework.client.socket.m.a("reconn", 0, 0, com.baidu.tbadk.core.frameworkData.a.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void aN() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(String str) {
        if (this.cs) {
            com.baidu.adp.framework.client.socket.m.a("reconn", 0, 0, com.baidu.tbadk.core.frameworkData.a.STOP, BdSocketLinkService.STOP_RECONN, "ReConnStrategy:stop");
            this.cs = false;
            this.ct = 0;
            BdLog.i("stop reconnStrategy");
            this.cu.removeMessages(1);
        }
    }
}
