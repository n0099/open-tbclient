package com.baidu.browser.sailor.b;

import android.content.Context;
import com.baidu.browser.sailor.webkit.update.a;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.sdk.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.getAppContext() != null) {
            Log.d(EngineManager.LOG_TAG, "start check zeus update");
            this.a.getAppContext();
            com.baidu.browser.sailor.webkit.update.a rf = com.baidu.browser.sailor.webkit.update.a.rf();
            Context appContext = this.a.getAppContext();
            if (com.baidu.browser.sailor.util.c.a(appContext)) {
                a.C0068a c0068a = new a.C0068a(appContext, "https://mbrowser.baidu.com/api/update/kernel?version=");
                BdNet bdNet = new BdNet(appContext);
                bdNet.setEventListener(c0068a);
                bdNet.start(c0068a, false);
            }
        }
    }
}
