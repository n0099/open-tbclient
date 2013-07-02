package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.Process;
/* loaded from: classes.dex */
class i extends j {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(f fVar, l lVar) {
        super(lVar);
        this.a = fVar;
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
                com.baidu.adp.lib.c.b.a(e.getMessage());
            }
            a();
        } finally {
            if (!h()) {
                handler = this.a.i;
                handler2 = this.a.i;
                handler.sendMessageDelayed(handler2.obtainMessage(2, this), 1L);
            }
        }
    }
}
