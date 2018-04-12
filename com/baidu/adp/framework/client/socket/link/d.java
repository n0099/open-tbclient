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
    private int oz = 0;
    private final Handler oA = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.framework.client.socket.link.d.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    d.this.oA.removeMessages(1);
                    BdLog.i("this is reconn time:" + d.this.oz);
                    BdSocketLinkService.startService(true, "time to reconnStragety");
                    d.c(d.this);
                    if (j.gP()) {
                        if (d.this.oz >= com.baidu.adp.lib.stats.switchs.a.gg().getMaxAlertCount("alert_im", 3)) {
                            BdStatisticsManager.getInstance().alert("alert_im", "Socket_Reconnect_" + String.valueOf(d.this.oz) + "_times");
                        }
                    }
                    int[] cF = h.cF();
                    if (cF != null && d.this.oz < cF.length) {
                        BdLog.i("Next will be delay:" + cF[d.this.oz]);
                        d.this.oA.sendMessageDelayed(d.this.oA.obtainMessage(1), cF[d.this.oz] * 1000);
                        return;
                    }
                    d.this.I("reconnStragety to the end");
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ int c(d dVar) {
        int i = dVar.oz;
        dVar.oz = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void start(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            I("online failed 5");
        } else if (!this.isRunning) {
            this.isRunning = true;
            this.oA.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.h.hB().hE()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                I("in Opened");
                return;
            }
            cW();
            BdLog.d("启动重连策略");
            this.oz = 0;
            int[] cF = h.cF();
            if (cF != null && cF.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + cF[0]);
                i.a("reconn", 0, 0, "reconn", BdSocketLinkService.STOP_RECONN, str + " retryTimes=" + String.valueOf(this.oz));
                this.oA.sendMessageDelayed(this.oA.obtainMessage(1), cF[0] * 1000);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            i.a("reconn", 0, 0, IntentConfig.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    private void cW() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(String str) {
        if (this.isRunning) {
            i.a("reconn", 0, 0, IntentConfig.STOP, BdSocketLinkService.STOP_RECONN, str);
            this.isRunning = false;
            this.oz = 0;
            BdLog.i("stop reconnStrategy");
            this.oA.removeMessages(1);
        }
    }
}
