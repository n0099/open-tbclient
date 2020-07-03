package com.baidu.browser.sailor.webkit.update;

import android.content.Context;
import com.baidu.browser.sailor.webkit.update.a;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class c implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ a adT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, Context context) {
        this.adT = aVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a != null) {
            Log.d(EngineManager.LOG_TAG, "start check zeus update async");
            a aVar = this.adT;
            Context context = this.a;
            if (WebKitFactory.isUserPrivacyEnabled() && !aVar.d && com.baidu.browser.sailor.util.b.a(context)) {
                a.C0094a c0094a = new a.C0094a(context, "https://mbrowser.baidu.com/api/update/kernel?version=");
                BdNet bdNet = new BdNet(context);
                bdNet.setEventListener(c0094a);
                bdNet.start(c0094a, false);
                aVar.d = true;
            }
        }
    }
}
