package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.Process;
/* loaded from: classes.dex */
class j extends k {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(g gVar, m mVar) {
        super(mVar);
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        try {
            try {
                if (d() == 3) {
                    Process.setThreadPriority(-1);
                } else if (d() == 2) {
                    Process.setThreadPriority(0);
                } else {
                    Process.setThreadPriority(10);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.a(e.getMessage());
            }
            a();
        } finally {
            if (!i()) {
                handler = this.a.i;
                handler2 = this.a.i;
                handler.sendMessageDelayed(handler2.obtainMessage(2, this), 1L);
            }
        }
    }
}
