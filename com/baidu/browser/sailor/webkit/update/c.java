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
    final /* synthetic */ Context f1329a;
    final /* synthetic */ a ahu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, Context context) {
        this.ahu = aVar;
        this.f1329a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1329a != null) {
            Log.i(EngineManager.LOG_TAG, "start check zeus update async");
            a aVar = this.ahu;
            Context context = this.f1329a;
            if (WebKitFactory.isUserPrivacyEnabled() && !aVar.d && com.baidu.browser.sailor.util.b.a(context)) {
                a.C0092a c0092a = new a.C0092a(context, "https://mbrowser.baidu.com/api/update/kernel?version=");
                BdNet bdNet = new BdNet(context);
                bdNet.setEventListener(c0092a);
                bdNet.start(c0092a, false);
                aVar.d = true;
            }
        }
    }
}
