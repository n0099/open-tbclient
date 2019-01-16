package com.baidu.browser.sailor.b;

import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        aVar = a.WD;
        if (aVar == null || a.qT() == null) {
            return;
        }
        com.baidu.browser.sailor.b.a.a qT = a.qT();
        if (qT.d != null) {
            SessionMonitorEngine.getInstance().recordImmediately("t7_init", qT.d.toString());
            qT.d = null;
        }
    }
}
