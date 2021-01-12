package com.baidu.browser.sailor.webkit.update;

import android.content.Context;
import com.baidu.browser.sailor.webkit.update.a;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1613a;
    final /* synthetic */ a agk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, Context context) {
        this.agk = aVar;
        this.f1613a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1613a != null) {
            Log.i(EngineManager.LOG_TAG, "start check zeus update async");
            a aVar = this.agk;
            Context context = this.f1613a;
            if (WebKitFactory.isUserPrivacyEnabled() && !aVar.d && com.baidu.browser.sailor.util.b.a(context)) {
                a.C0086a c0086a = new a.C0086a(context, "https://mbrowser.baidu.com/api/update/kernel?version=");
                BdNet bdNet = new BdNet(context);
                bdNet.setEventListener(c0086a);
                bdNet.start(c0086a, false);
                aVar.d = true;
            }
        }
    }
}
