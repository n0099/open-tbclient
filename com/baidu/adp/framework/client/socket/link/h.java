package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.client.socket.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class h {
    private boolean isRunning = false;
    private int qG = 0;
    private final Handler qH = new i(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: protected */
    public void start(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            stop("online failed 5");
        } else if (!this.isRunning) {
            this.isRunning = true;
            this.qH.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.h.hS().hV()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                stop("in Opened");
                return;
            }
            m2do();
            BdLog.d("启动重连策略");
            this.qG = 0;
            int[] cY = com.baidu.adp.framework.client.socket.j.cY();
            if (cY != null && cY.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + cY[0]);
                k.a("reconn", 0, 0, "reconn", BdSocketLinkService.STOP_RECONN, String.valueOf(str) + " retryTimes=" + String.valueOf(this.qG));
                this.qH.sendMessageDelayed(this.qH.obtainMessage(1), cY[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            k.a("reconn", 0, 0, IntentConfig.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    /* renamed from: do  reason: not valid java name */
    private void m2do() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stop(String str) {
        if (this.isRunning) {
            k.a("reconn", 0, 0, IntentConfig.STOP, BdSocketLinkService.STOP_RECONN, str);
            this.isRunning = false;
            this.qG = 0;
            BdLog.i("stop reconnStrategy");
            this.qH.removeMessages(1);
        }
    }
}
