package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.Process;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class i extends j {
    final /* synthetic */ f fb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(f fVar, k kVar) {
        super(kVar);
        this.fb = fVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [137=4] */
    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        try {
            try {
                if (getPriority() == 4) {
                    Process.setThreadPriority(-2);
                } else if (getPriority() == 3) {
                    Process.setThreadPriority(-1);
                } else if (getPriority() == 2) {
                    Process.setThreadPriority(0);
                } else {
                    Process.setThreadPriority(10);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            bW();
        } finally {
            if (!isSelfExecute()) {
                handler = this.fb.mHandler;
                handler2 = this.fb.mHandler;
                handler.sendMessageDelayed(handler2.obtainMessage(2, this), 1L);
            }
        }
    }
}
