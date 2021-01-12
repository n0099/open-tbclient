package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.client.socket.h;
import com.baidu.adp.framework.client.socket.i;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class d {
    private boolean isRunning = false;
    private int Jq = 0;
    private final Handler Jr = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.framework.client.socket.link.d.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    d.this.Jr.removeMessages(1);
                    BdLog.i("this is reconn time:" + d.this.Jq);
                    BdSocketLinkService.startService(true, "time to reconnStragety");
                    d.c(d.this);
                    if (j.isNetWorkAvailable()) {
                        if (d.this.Jq >= com.baidu.adp.lib.stats.switchs.a.nt().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IM, 3)) {
                            BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IM, "Socket_Reconnect_" + String.valueOf(d.this.Jq) + "_times");
                        }
                    }
                    int[] reConnectInterval = h.getReConnectInterval();
                    if (reConnectInterval != null && d.this.Jq < reConnectInterval.length) {
                        BdLog.i("Next will be delay:" + reConnectInterval[d.this.Jq]);
                        d.this.Jr.sendMessageDelayed(d.this.Jr.obtainMessage(1), reConnectInterval[d.this.Jq] * 1000);
                        return;
                    }
                    d.this.bq("reconnStragety to the end");
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ int c(d dVar) {
        int i = dVar.Jq;
        dVar.Jq = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void start(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            bq("online failed 5");
        } else if (!this.isRunning) {
            this.isRunning = true;
            this.Jr.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.h.od().og()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                bq("in Opened");
                return;
            }
            kV();
            BdLog.d("启动重连策略");
            this.Jq = 0;
            int[] reConnectInterval = h.getReConnectInterval();
            if (reConnectInterval != null && reConnectInterval.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + reConnectInterval[0]);
                i.debug("reconn", 0, 0, "reconn", BdSocketLinkService.STOP_RECONN, str + " retryTimes=" + String.valueOf(this.Jq));
                this.Jr.sendMessageDelayed(this.Jr.obtainMessage(1), reConnectInterval[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            i.debug("reconn", 0, 0, "start", BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void kV() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bq(String str) {
        if (this.isRunning) {
            i.debug("reconn", 0, 0, "stop", BdSocketLinkService.STOP_RECONN, str);
            this.isRunning = false;
            this.Jq = 0;
            BdLog.i("stop reconnStrategy");
            this.Jr.removeMessages(1);
        }
    }
}
