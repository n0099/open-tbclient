package com.baidu.fsg.base.statistics;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class m extends Handler {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(l lVar, Looper looper) {
        super(looper);
        this.a = lVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (RimStatisticsUtil.getAppContext() != null) {
            if (10000 == message.what) {
                this.a.b((String) message.obj);
            } else if (10001 == message.what) {
                this.a.b(b.p);
            }
        }
    }
}
