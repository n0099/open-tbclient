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
    private int pH = 0;
    private final Handler pI = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.framework.client.socket.link.d.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    d.this.pI.removeMessages(1);
                    BdLog.i("this is reconn time:" + d.this.pH);
                    BdSocketLinkService.startService(true, "time to reconnStragety");
                    d.c(d.this);
                    if (i.hi()) {
                        if (d.this.pH >= com.baidu.adp.lib.stats.switchs.a.gA().getMaxAlertCount("alert_im", 3)) {
                            BdStatisticsManager.getInstance().alert("alert_im", "Socket_Reconnect_" + String.valueOf(d.this.pH) + "_times");
                        }
                    }
                    int[] cX = h.cX();
                    if (cX != null && d.this.pH < cX.length) {
                        BdLog.i("Next will be delay:" + cX[d.this.pH]);
                        d.this.pI.sendMessageDelayed(d.this.pI.obtainMessage(1), cX[d.this.pH] * 1000);
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
        int i = dVar.pH;
        dVar.pH = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void start(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            stop("online failed 5");
        } else if (!this.isRunning) {
            this.isRunning = true;
            this.pI.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.h.hV().hY()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                stop("in Opened");
                return;
            }
            m2do();
            BdLog.d("启动重连策略");
            this.pH = 0;
            int[] cX = h.cX();
            if (cX != null && cX.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + cX[0]);
                com.baidu.adp.framework.client.socket.i.a("reconn", 0, 0, "reconn", BdSocketLinkService.STOP_RECONN, str + " retryTimes=" + String.valueOf(this.pH));
                this.pI.sendMessageDelayed(this.pI.obtainMessage(1), cX[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            com.baidu.adp.framework.client.socket.i.a("reconn", 0, 0, IntentConfig.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    /* renamed from: do  reason: not valid java name */
    private void m2do() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stop(String str) {
        if (this.isRunning) {
            com.baidu.adp.framework.client.socket.i.a("reconn", 0, 0, IntentConfig.STOP, BdSocketLinkService.STOP_RECONN, str);
            this.isRunning = false;
            this.pH = 0;
            BdLog.i("stop reconnStrategy");
            this.pI.removeMessages(1);
        }
    }
}
