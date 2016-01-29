package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.client.socket.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class h {
    private boolean qc = false;
    private int qd = 0;
    private final Handler qe = new i(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: protected */
    public void start(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            stop("online failed 5");
        } else if (!this.qc) {
            this.qc = true;
            this.qe.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.h.jL().jO()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                stop("in Opened");
                return;
            }
            eT();
            BdLog.d("启动重连策略");
            this.qd = 0;
            int[] eF = com.baidu.adp.framework.client.socket.j.eF();
            if (eF != null && eF.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + eF[0]);
                k.a("reconn", 0, 0, "reconn", BdSocketLinkService.STOP_RECONN, String.valueOf(str) + " retryTimes=" + String.valueOf(this.qd));
                this.qe.sendMessageDelayed(this.qe.obtainMessage(1), eF[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            k.a("reconn", 0, 0, IntentConfig.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void eT() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stop(String str) {
        if (this.qc) {
            k.a("reconn", 0, 0, IntentConfig.STOP, BdSocketLinkService.STOP_RECONN, str);
            this.qc = false;
            this.qd = 0;
            BdLog.i("stop reconnStrategy");
            this.qe.removeMessages(1);
        }
    }
}
