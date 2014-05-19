package com.baidu.adp.lib.debug.b;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
/* loaded from: classes.dex */
class q extends Handler {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(m mVar) {
        this.a = mVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    this.a.n.setText("fps:" + com.baidu.adp.lib.debug.c.a());
                    break;
                case 1:
                    this.a.o.setText("mem:" + com.baidu.adp.lib.debug.c.b());
                    break;
                case 2:
                    this.a.p.setText("cpu:" + com.baidu.adp.lib.debug.c.c());
                    break;
                case 3:
                    this.a.q.setText("gc:" + com.baidu.adp.lib.debug.c.d());
                    break;
                case 4:
                    this.a.r.setText("strictMode:" + com.baidu.adp.lib.debug.c.e());
                    break;
                case 5:
                    Log.i("Monitor", "battery run");
                    this.a.s.setText("battery:" + com.baidu.adp.lib.debug.c.i());
                    break;
                case 6:
                    this.a.v.setText("-T:" + com.baidu.adp.lib.debug.c.f().a() + "kb");
                    this.a.t.setText("-S:" + com.baidu.adp.lib.debug.c.f().c() + "kb");
                    this.a.u.setText("-R:" + com.baidu.adp.lib.debug.c.f().b() + "kb");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
