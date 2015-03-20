package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.client.socket.m;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j {
    private boolean pT = false;
    private int pU = 0;
    private final Handler pV = new k(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: protected */
    public void start(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            stop("online failed 5");
        } else if (!this.pT) {
            this.pT = true;
            this.pV.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.l.jr().ju()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                stop("in Opened");
                return;
            }
            eM();
            BdLog.d("启动重连策略");
            this.pU = 0;
            int[] ey = com.baidu.adp.framework.client.socket.l.ey();
            if (ey != null && ey.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + ey[0]);
                this.pV.sendMessageDelayed(this.pV.obtainMessage(1), ey[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            m.a("reconn", 0, 0, com.baidu.tbadk.core.frameworkData.a.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void eM() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stop(String str) {
        if (this.pT) {
            m.a("reconn", 0, 0, com.baidu.tbadk.core.frameworkData.a.STOP, BdSocketLinkService.STOP_RECONN, "ReConnStrategy:stop");
            this.pT = false;
            this.pU = 0;
            BdLog.i("stop reconnStrategy");
            this.pV.removeMessages(1);
        }
    }
}
