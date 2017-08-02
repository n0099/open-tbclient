package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.client.socket.h;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class d {
    private boolean isRunning = false;
    private int ql = 0;
    private final Handler qm = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.framework.client.socket.link.d.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    d.this.qm.removeMessages(1);
                    BdLog.i("this is reconn time:" + d.this.ql);
                    BdSocketLinkService.startService(true, "time to reconnStragety");
                    d.c(d.this);
                    if (i.hh()) {
                        if (d.this.ql >= com.baidu.adp.lib.stats.switchs.a.gz().getMaxAlertCount("alert_im", 3)) {
                            BdStatisticsManager.getInstance().alert("alert_im", "Socket_Reconnect_" + String.valueOf(d.this.ql) + "_times");
                        }
                    }
                    int[] cW = h.cW();
                    if (cW != null && d.this.ql < cW.length) {
                        BdLog.i("Next will be delay:" + cW[d.this.ql]);
                        d.this.qm.sendMessageDelayed(d.this.qm.obtainMessage(1), cW[d.this.ql] * 1000);
                        return;
                    }
                    d.this.stop("reconnStragety to the end");
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ int c(d dVar) {
        int i = dVar.ql;
        dVar.ql = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void start(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            stop("online failed 5");
        } else if (!this.isRunning) {
            this.isRunning = true;
            this.qm.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.h.hU().hX()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                stop("in Opened");
                return;
            }
            dn();
            BdLog.d("启动重连策略");
            this.ql = 0;
            int[] cW = h.cW();
            if (cW != null && cW.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + cW[0]);
                com.baidu.adp.framework.client.socket.i.a("reconn", 0, 0, "reconn", BdSocketLinkService.STOP_RECONN, str + " retryTimes=" + String.valueOf(this.ql));
                this.qm.sendMessageDelayed(this.qm.obtainMessage(1), cW[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            com.baidu.adp.framework.client.socket.i.a("reconn", 0, 0, IntentConfig.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void dn() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stop(String str) {
        if (this.isRunning) {
            com.baidu.adp.framework.client.socket.i.a("reconn", 0, 0, IntentConfig.STOP, BdSocketLinkService.STOP_RECONN, str);
            this.isRunning = false;
            this.ql = 0;
            BdLog.i("stop reconnStrategy");
            this.qm.removeMessages(1);
        }
    }
}
