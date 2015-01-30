package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.m;
/* loaded from: classes.dex */
public class j {
    private boolean eB = false;
    private int eC = 0;
    private final Handler eD = new k(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: protected */
    public void start(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            A("online failed 5");
        } else if (!this.eB) {
            this.eB = true;
            this.eD.removeMessages(1);
            if (m.fU().fX()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                A("in Opened");
                return;
            }
            bp();
            BdLog.d("启动重连策略");
            this.eC = 0;
            int[] bb = com.baidu.adp.framework.client.socket.l.bb();
            if (bb != null && bb.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + bb[0]);
                this.eD.sendMessageDelayed(this.eD.obtainMessage(1), bb[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            com.baidu.adp.framework.client.socket.m.a("reconn", 0, 0, com.baidu.tbadk.core.frameworkData.a.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void bp() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(String str) {
        if (this.eB) {
            com.baidu.adp.framework.client.socket.m.a("reconn", 0, 0, com.baidu.tbadk.core.frameworkData.a.STOP, BdSocketLinkService.STOP_RECONN, "ReConnStrategy:stop");
            this.eB = false;
            this.eC = 0;
            BdLog.i("stop reconnStrategy");
            this.eD.removeMessages(1);
        }
    }
}
