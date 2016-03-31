package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.client.socket.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class h {
    private boolean qg = false;
    private int qh = 0;
    private final Handler qi = new i(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: protected */
    public void start(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            stop("online failed 5");
        } else if (!this.qg) {
            this.qg = true;
            this.qi.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.h.jR().jU()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                stop("in Opened");
                return;
            }
            eU();
            BdLog.d("启动重连策略");
            this.qh = 0;
            int[] eF = com.baidu.adp.framework.client.socket.j.eF();
            if (eF != null && eF.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + eF[0]);
                k.a("reconn", 0, 0, "reconn", BdSocketLinkService.STOP_RECONN, String.valueOf(str) + " retryTimes=" + String.valueOf(this.qh));
                this.qi.sendMessageDelayed(this.qi.obtainMessage(1), eF[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            k.a("reconn", 0, 0, IntentConfig.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void eU() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stop(String str) {
        if (this.qg) {
            k.a("reconn", 0, 0, IntentConfig.STOP, BdSocketLinkService.STOP_RECONN, str);
            this.qg = false;
            this.qh = 0;
            BdLog.i("stop reconnStrategy");
            this.qi.removeMessages(1);
        }
    }
}
