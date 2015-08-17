package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.client.socket.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class h {
    private boolean pY = false;
    private int pZ = 0;
    private final Handler myHandler = new i(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: protected */
    public void start(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            stop("online failed 5");
        } else if (!this.pY) {
            this.pY = true;
            this.myHandler.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.h.jB().jE()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                stop("in Opened");
                return;
            }
            eQ();
            BdLog.d("启动重连策略");
            this.pZ = 0;
            int[] eC = com.baidu.adp.framework.client.socket.j.eC();
            if (eC != null && eC.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + eC[0]);
                this.myHandler.sendMessageDelayed(this.myHandler.obtainMessage(1), eC[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            k.a("reconn", 0, 0, IntentConfig.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void eQ() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stop(String str) {
        if (this.pY) {
            k.a("reconn", 0, 0, IntentConfig.STOP, BdSocketLinkService.STOP_RECONN, "ReConnStrategy:stop");
            this.pY = false;
            this.pZ = 0;
            BdLog.i("stop reconnStrategy");
            this.myHandler.removeMessages(1);
        }
    }
}
