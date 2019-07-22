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
    private int vA = 0;
    private final Handler vB = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.framework.client.socket.link.d.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    d.this.vB.removeMessages(1);
                    BdLog.i("this is reconn time:" + d.this.vA);
                    BdSocketLinkService.startService(true, "time to reconnStragety");
                    d.c(d.this);
                    if (j.kc()) {
                        if (d.this.vA >= com.baidu.adp.lib.stats.switchs.a.jt().getMaxAlertCount("alert_im", 3)) {
                            BdStatisticsManager.getInstance().alert("alert_im", "Socket_Reconnect_" + String.valueOf(d.this.vA) + "_times");
                        }
                    }
                    int[] fR = h.fR();
                    if (fR != null && d.this.vA < fR.length) {
                        BdLog.i("Next will be delay:" + fR[d.this.vA]);
                        d.this.vB.sendMessageDelayed(d.this.vB.obtainMessage(1), fR[d.this.vA] * 1000);
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
        int i = dVar.vA;
        dVar.vA = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            V("online failed 5");
        } else if (!this.isRunning) {
            this.isRunning = true;
            this.vB.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.h.kS().kV()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                V("in Opened");
                return;
            }
            gj();
            BdLog.d("启动重连策略");
            this.vA = 0;
            int[] fR = h.fR();
            if (fR != null && fR.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + fR[0]);
                i.a("reconn", 0, 0, "reconn", BdSocketLinkService.STOP_RECONN, str + " retryTimes=" + String.valueOf(this.vA));
                this.vB.sendMessageDelayed(this.vB.obtainMessage(1), fR[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            i.a("reconn", 0, 0, IntentConfig.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void gj() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V(String str) {
        if (this.isRunning) {
            i.a("reconn", 0, 0, IntentConfig.STOP, BdSocketLinkService.STOP_RECONN, str);
            this.isRunning = false;
            this.vA = 0;
            BdLog.i("stop reconnStrategy");
            this.vB.removeMessages(1);
        }
    }
}
