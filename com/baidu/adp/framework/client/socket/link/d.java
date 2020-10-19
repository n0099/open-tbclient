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
    private int Ja = 0;
    private final Handler Jb = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.framework.client.socket.link.d.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    d.this.Jb.removeMessages(1);
                    BdLog.i("this is reconn time:" + d.this.Ja);
                    BdSocketLinkService.startService(true, "time to reconnStragety");
                    d.c(d.this);
                    if (j.isNetWorkAvailable()) {
                        if (d.this.Ja >= com.baidu.adp.lib.stats.switchs.a.nS().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IM, 3)) {
                            BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IM, "Socket_Reconnect_" + String.valueOf(d.this.Ja) + "_times");
                        }
                    }
                    int[] reConnectInterval = h.getReConnectInterval();
                    if (reConnectInterval != null && d.this.Ja < reConnectInterval.length) {
                        BdLog.i("Next will be delay:" + reConnectInterval[d.this.Ja]);
                        d.this.Jb.sendMessageDelayed(d.this.Jb.obtainMessage(1), reConnectInterval[d.this.Ja] * 1000);
                        return;
                    }
                    d.this.bt("reconnStragety to the end");
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ int c(d dVar) {
        int i = dVar.Ja;
        dVar.Ja = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bs(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            bt("online failed 5");
        } else if (!this.isRunning) {
            this.isRunning = true;
            this.Jb.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.h.oD().oF()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                bt("in Opened");
                return;
            }
            lz();
            BdLog.d("启动重连策略");
            this.Ja = 0;
            int[] reConnectInterval = h.getReConnectInterval();
            if (reConnectInterval != null && reConnectInterval.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + reConnectInterval[0]);
                i.debug("reconn", 0, 0, "reconn", BdSocketLinkService.STOP_RECONN, str + " retryTimes=" + String.valueOf(this.Ja));
                this.Jb.sendMessageDelayed(this.Jb.obtainMessage(1), reConnectInterval[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            i.debug("reconn", 0, 0, "start", BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void lz() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bt(String str) {
        if (this.isRunning) {
            i.debug("reconn", 0, 0, "stop", BdSocketLinkService.STOP_RECONN, str);
            this.isRunning = false;
            this.Ja = 0;
            BdLog.i("stop reconnStrategy");
            this.Jb.removeMessages(1);
        }
    }
}
