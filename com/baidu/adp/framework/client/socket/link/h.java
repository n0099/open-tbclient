package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.client.socket.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class h {
    private boolean iP = false;
    private int iQ = 0;
    private final Handler iR = new i(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: protected */
    public void start(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            stop("online failed 5");
        } else if (!this.iP) {
            this.iP = true;
            this.iR.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.h.ha().hd()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                stop("in Opened");
                return;
            }
            cf();
            BdLog.d("启动重连策略");
            this.iQ = 0;
            int[] bP = com.baidu.adp.framework.client.socket.j.bP();
            if (bP != null && bP.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + bP[0]);
                k.a("reconn", 0, 0, "reconn", BdSocketLinkService.STOP_RECONN, String.valueOf(str) + " retryTimes=" + String.valueOf(this.iQ));
                this.iR.sendMessageDelayed(this.iR.obtainMessage(1), bP[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            k.a("reconn", 0, 0, IntentConfig.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void cf() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stop(String str) {
        if (this.iP) {
            k.a("reconn", 0, 0, IntentConfig.STOP, BdSocketLinkService.STOP_RECONN, str);
            this.iP = false;
            this.iQ = 0;
            BdLog.i("stop reconnStrategy");
            this.iR.removeMessages(1);
        }
    }
}
