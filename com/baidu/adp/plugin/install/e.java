package com.baidu.adp.plugin.install;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends Handler {
    final /* synthetic */ d this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, Looper looper) {
        super(looper);
        this.this$0 = dVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        c cVar;
        c cVar2;
        Handler handler;
        Runnable runnable;
        cVar = this.this$0.wF;
        if (cVar != null && message != null) {
            try {
                String str = ((c) com.baidu.adp.lib.a.b.a.a.i.objectWithBundle(message.getData(), c.class)).vT;
                cVar2 = this.this$0.wF;
                if (TextUtils.equals(str, cVar2.vT)) {
                    handler = d.hi;
                    runnable = this.this$0.wM;
                    handler.removeCallbacks(runnable);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
