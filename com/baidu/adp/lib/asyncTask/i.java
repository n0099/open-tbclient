package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.Process;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class i extends j {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(f fVar, k kVar) {
        super(kVar);
        this.a = fVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [135=4] */
    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        try {
            try {
                if (e() == 4) {
                    Process.setThreadPriority(-2);
                } else if (e() == 3) {
                    Process.setThreadPriority(-1);
                } else if (e() == 2) {
                    Process.setThreadPriority(0);
                } else {
                    Process.setThreadPriority(10);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            a();
        } finally {
            if (!k()) {
                handler = this.a.m;
                handler2 = this.a.m;
                handler.sendMessage(handler2.obtainMessage(2, this));
            }
        }
    }
}
