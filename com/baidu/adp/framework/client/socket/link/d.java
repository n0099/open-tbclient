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
    private int vy = 0;
    private final Handler vz = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.framework.client.socket.link.d.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    d.this.vz.removeMessages(1);
                    BdLog.i("this is reconn time:" + d.this.vy);
                    BdSocketLinkService.startService(true, "time to reconnStragety");
                    d.c(d.this);
                    if (j.jS()) {
                        if (d.this.vy >= com.baidu.adp.lib.stats.switchs.a.jk().getMaxAlertCount("alert_im", 3)) {
                            BdStatisticsManager.getInstance().alert("alert_im", "Socket_Reconnect_" + String.valueOf(d.this.vy) + "_times");
                        }
                    }
                    int[] fJ = h.fJ();
                    if (fJ != null && d.this.vy < fJ.length) {
                        BdLog.i("Next will be delay:" + fJ[d.this.vy]);
                        d.this.vz.sendMessageDelayed(d.this.vz.obtainMessage(1), fJ[d.this.vy] * 1000);
                        return;
                    }
                    d.this.V("reconnStragety to the end");
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ int c(d dVar) {
        int i = dVar.vy;
        dVar.vy = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            V("online failed 5");
        } else if (!this.isRunning) {
            this.isRunning = true;
            this.vz.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.h.kD().kG()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                V("in Opened");
                return;
            }
            fZ();
            BdLog.d("启动重连策略");
            this.vy = 0;
            int[] fJ = h.fJ();
            if (fJ != null && fJ.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + fJ[0]);
                i.a("reconn", 0, 0, "reconn", BdSocketLinkService.STOP_RECONN, str + " retryTimes=" + String.valueOf(this.vy));
                this.vz.sendMessageDelayed(this.vz.obtainMessage(1), fJ[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            i.a("reconn", 0, 0, IntentConfig.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void fZ() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V(String str) {
        if (this.isRunning) {
            i.a("reconn", 0, 0, IntentConfig.STOP, BdSocketLinkService.STOP_RECONN, str);
            this.isRunning = false;
            this.vy = 0;
            BdLog.i("stop reconnStrategy");
            this.vz.removeMessages(1);
        }
    }
}
