package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.client.socket.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class h {
    private boolean fT = false;
    private int fU = 0;
    private final Handler fV = new i(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: protected */
    public void start(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            stop("online failed 5");
        } else if (!this.fT) {
            this.fT = true;
            this.fV.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.h.gg().gj()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                stop("in Opened");
                return;
            }
            bl();
            BdLog.d("启动重连策略");
            this.fU = 0;
            int[] aV = com.baidu.adp.framework.client.socket.j.aV();
            if (aV != null && aV.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + aV[0]);
                k.a("reconn", 0, 0, "reconn", BdSocketLinkService.STOP_RECONN, String.valueOf(str) + " retryTimes=" + String.valueOf(this.fU));
                this.fV.sendMessageDelayed(this.fV.obtainMessage(1), aV[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            k.a("reconn", 0, 0, IntentConfig.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void bl() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stop(String str) {
        if (this.fT) {
            k.a("reconn", 0, 0, IntentConfig.STOP, BdSocketLinkService.STOP_RECONN, str);
            this.fT = false;
            this.fU = 0;
            BdLog.i("stop reconnStrategy");
            this.fV.removeMessages(1);
        }
    }
}
