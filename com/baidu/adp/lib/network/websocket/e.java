package com.baidu.adp.lib.network.websocket;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
public class e {
    private boolean a = false;
    private int b = 0;
    private int[] c = new int[0];
    private Handler d = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        if (!this.a) {
            this.a = true;
            this.d.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.m.a().d()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                b("in Opened");
                return;
            }
            a();
            BdLog.d("启动重连策略");
            this.b = 0;
            if (this.c != null && this.c.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + this.c[0]);
                this.d.sendMessageDelayed(this.d.obtainMessage(1), this.c[0] * LocationClientOption.MIN_SCAN_SPAN);
                return;
            }
            BdLog.i("don't have reconnStrategy!");
            return;
        }
        BdLog.d("重连策略正在运行中， 再次启动无效");
    }

    private void a() {
        this.c = com.baidu.adp.framework.b.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        if (this.a) {
            this.a = false;
            this.b = 0;
            BdLog.i("stop reconnStrategy");
            this.d.removeMessages(1);
        }
    }
}
