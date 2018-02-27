package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.client.socket.h;
import com.baidu.adp.framework.client.socket.i;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class d {
    private boolean isRunning = false;
    private int aec = 0;
    private final Handler aed = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.framework.client.socket.link.d.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    d.this.aed.removeMessages(1);
                    BdLog.i("this is reconn time:" + d.this.aec);
                    BdSocketLinkService.startService(true, "time to reconnStragety");
                    d.c(d.this);
                    if (j.oJ()) {
                        if (d.this.aec >= com.baidu.adp.lib.stats.switchs.a.ob().getMaxAlertCount("alert_im", 3)) {
                            BdStatisticsManager.getInstance().alert("alert_im", "Socket_Reconnect_" + String.valueOf(d.this.aec) + "_times");
                        }
                    }
                    int[] kB = h.kB();
                    if (kB != null && d.this.aec < kB.length) {
                        BdLog.i("Next will be delay:" + kB[d.this.aec]);
                        d.this.aed.sendMessageDelayed(d.this.aed.obtainMessage(1), kB[d.this.aec] * 1000);
                        return;
                    }
                    d.this.L("reconnStragety to the end");
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ int c(d dVar) {
        int i = dVar.aec;
        dVar.aec = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void start(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            L("online failed 5");
        } else if (!this.isRunning) {
            this.isRunning = true;
            this.aed.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.h.pv().py()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                L("in Opened");
                return;
            }
            kS();
            BdLog.d("启动重连策略");
            this.aec = 0;
            int[] kB = h.kB();
            if (kB != null && kB.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + kB[0]);
                i.a("reconn", 0, 0, "reconn", BdSocketLinkService.STOP_RECONN, str + " retryTimes=" + String.valueOf(this.aec));
                this.aed.sendMessageDelayed(this.aed.obtainMessage(1), kB[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            i.a("reconn", 0, 0, IntentConfig.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void kS() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(String str) {
        if (this.isRunning) {
            i.a("reconn", 0, 0, IntentConfig.STOP, BdSocketLinkService.STOP_RECONN, str);
            this.isRunning = false;
            this.aec = 0;
            BdLog.i("stop reconnStrategy");
            this.aed.removeMessages(1);
        }
    }
}
