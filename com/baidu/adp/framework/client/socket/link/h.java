package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.client.socket.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class h {
    private boolean gv = false;
    private int gw = 0;
    private final Handler gx = new i(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: protected */
    public void start(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            stop("online failed 5");
        } else if (!this.gv) {
            this.gv = true;
            this.gx.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.h.gf().gi()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                stop("in Opened");
                return;
            }
            bk();
            BdLog.d("启动重连策略");
            this.gw = 0;
            int[] aU = com.baidu.adp.framework.client.socket.j.aU();
            if (aU != null && aU.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + aU[0]);
                k.a("reconn", 0, 0, "reconn", BdSocketLinkService.STOP_RECONN, String.valueOf(str) + " retryTimes=" + String.valueOf(this.gw));
                this.gx.sendMessageDelayed(this.gx.obtainMessage(1), aU[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            k.a("reconn", 0, 0, IntentConfig.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void bk() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stop(String str) {
        if (this.gv) {
            k.a("reconn", 0, 0, IntentConfig.STOP, BdSocketLinkService.STOP_RECONN, str);
            this.gv = false;
            this.gw = 0;
            BdLog.i("stop reconnStrategy");
            this.gx.removeMessages(1);
        }
    }
}
