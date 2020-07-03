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
    private int HR = 0;
    private final Handler HS = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.framework.client.socket.link.d.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    d.this.HS.removeMessages(1);
                    BdLog.i("this is reconn time:" + d.this.HR);
                    BdSocketLinkService.startService(true, "time to reconnStragety");
                    d.c(d.this);
                    if (j.isNetWorkAvailable()) {
                        if (d.this.HR >= com.baidu.adp.lib.stats.switchs.a.mn().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IM, 3)) {
                            BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IM, "Socket_Reconnect_" + String.valueOf(d.this.HR) + "_times");
                        }
                    }
                    int[] reConnectInterval = h.getReConnectInterval();
                    if (reConnectInterval != null && d.this.HR < reConnectInterval.length) {
                        BdLog.i("Next will be delay:" + reConnectInterval[d.this.HR]);
                        d.this.HS.sendMessageDelayed(d.this.HS.obtainMessage(1), reConnectInterval[d.this.HR] * 1000);
                        return;
                    }
                    d.this.bm("reconnStragety to the end");
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ int c(d dVar) {
        int i = dVar.HR;
        dVar.HR = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bl(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            bm("online failed 5");
        } else if (!this.isRunning) {
            this.isRunning = true;
            this.HS.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.h.mX().mZ()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                bm("in Opened");
                return;
            }
            jV();
            BdLog.d("启动重连策略");
            this.HR = 0;
            int[] reConnectInterval = h.getReConnectInterval();
            if (reConnectInterval != null && reConnectInterval.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + reConnectInterval[0]);
                i.debug("reconn", 0, 0, "reconn", BdSocketLinkService.STOP_RECONN, str + " retryTimes=" + String.valueOf(this.HR));
                this.HS.sendMessageDelayed(this.HS.obtainMessage(1), reConnectInterval[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            i.debug("reconn", 0, 0, "start", BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void jV() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bm(String str) {
        if (this.isRunning) {
            i.debug("reconn", 0, 0, "stop", BdSocketLinkService.STOP_RECONN, str);
            this.isRunning = false;
            this.HR = 0;
            BdLog.i("stop reconnStrategy");
            this.HS.removeMessages(1);
        }
    }
}
