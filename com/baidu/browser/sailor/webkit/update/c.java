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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1289a;
    final /* synthetic */ a afB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, Context context) {
        this.afB = aVar;
        this.f1289a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1289a != null) {
            Log.i(EngineManager.LOG_TAG, "start check zeus update async");
            a aVar = this.afB;
            Context context = this.f1289a;
            if (WebKitFactory.isUserPrivacyEnabled() && !aVar.d && com.baidu.browser.sailor.util.b.a(context)) {
                a.C0095a c0095a = new a.C0095a(context, "https://mbrowser.baidu.com/api/update/kernel?version=");
                BdNet bdNet = new BdNet(context);
                bdNet.setEventListener(c0095a);
                bdNet.start(c0095a, false);
                aVar.d = true;
            }
        }
    }
}
