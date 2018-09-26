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
    private int xe = 0;
    private final Handler xf = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.framework.client.socket.link.d.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    d.this.xf.removeMessages(1);
                    BdLog.i("this is reconn time:" + d.this.xe);
                    BdSocketLinkService.startService(true, "time to reconnStragety");
                    d.c(d.this);
                    if (j.kK()) {
                        if (d.this.xe >= com.baidu.adp.lib.stats.switchs.a.kc().getMaxAlertCount("alert_im", 3)) {
                            BdStatisticsManager.getInstance().alert("alert_im", "Socket_Reconnect_" + String.valueOf(d.this.xe) + "_times");
                        }
                    }
                    int[] gC = h.gC();
                    if (gC != null && d.this.xe < gC.length) {
                        BdLog.i("Next will be delay:" + gC[d.this.xe]);
                        d.this.xf.sendMessageDelayed(d.this.xf.obtainMessage(1), gC[d.this.xe] * 1000);
                        return;
                    }
                    d.this.am("reconnStragety to the end");
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ int c(d dVar) {
        int i = dVar.xe;
        dVar.xe = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            am("online failed 5");
        } else if (!this.isRunning) {
            this.isRunning = true;
            this.xf.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.h.lw().lz()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                am("in Opened");
                return;
            }
            gS();
            BdLog.d("启动重连策略");
            this.xe = 0;
            int[] gC = h.gC();
            if (gC != null && gC.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + gC[0]);
                i.a("reconn", 0, 0, "reconn", BdSocketLinkService.STOP_RECONN, str + " retryTimes=" + String.valueOf(this.xe));
                this.xf.sendMessageDelayed(this.xf.obtainMessage(1), gC[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            i.a("reconn", 0, 0, IntentConfig.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void gS() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am(String str) {
        if (this.isRunning) {
            i.a("reconn", 0, 0, IntentConfig.STOP, BdSocketLinkService.STOP_RECONN, str);
            this.isRunning = false;
            this.xe = 0;
            BdLog.i("stop reconnStrategy");
            this.xf.removeMessages(1);
        }
    }
}
