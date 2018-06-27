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
    private int uS = 0;
    private final Handler uT = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.framework.client.socket.link.d.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    d.this.uT.removeMessages(1);
                    BdLog.i("this is reconn time:" + d.this.uS);
                    BdSocketLinkService.startService(true, "time to reconnStragety");
                    d.c(d.this);
                    if (j.jD()) {
                        if (d.this.uS >= com.baidu.adp.lib.stats.switchs.a.iV().getMaxAlertCount("alert_im", 3)) {
                            BdStatisticsManager.getInstance().alert("alert_im", "Socket_Reconnect_" + String.valueOf(d.this.uS) + "_times");
                        }
                    }
                    int[] fu = h.fu();
                    if (fu != null && d.this.uS < fu.length) {
                        BdLog.i("Next will be delay:" + fu[d.this.uS]);
                        d.this.uT.sendMessageDelayed(d.this.uT.obtainMessage(1), fu[d.this.uS] * 1000);
                        return;
                    }
                    d.this.U("reconnStragety to the end");
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ int c(d dVar) {
        int i = dVar.uS;
        dVar.uS = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void start(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            U("online failed 5");
        } else if (!this.isRunning) {
            this.isRunning = true;
            this.uT.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.h.kp().ks()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                U("in Opened");
                return;
            }
            fL();
            BdLog.d("启动重连策略");
            this.uS = 0;
            int[] fu = h.fu();
            if (fu != null && fu.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + fu[0]);
                i.a("reconn", 0, 0, "reconn", BdSocketLinkService.STOP_RECONN, str + " retryTimes=" + String.valueOf(this.uS));
                this.uT.sendMessageDelayed(this.uT.obtainMessage(1), fu[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            i.a("reconn", 0, 0, IntentConfig.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void fL() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U(String str) {
        if (this.isRunning) {
            i.a("reconn", 0, 0, IntentConfig.STOP, BdSocketLinkService.STOP_RECONN, str);
            this.isRunning = false;
            this.uS = 0;
            BdLog.i("stop reconnStrategy");
            this.uT.removeMessages(1);
        }
    }
}
