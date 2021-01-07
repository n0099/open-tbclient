package com.baidu.browser.sailor.webkit.update;

import android.content.Context;
import com.baidu.browser.sailor.webkit.update.a;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1664a;
    final /* synthetic */ a ahb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, Context context) {
        this.ahb = aVar;
        this.f1664a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1664a != null) {
            Log.i(EngineManager.LOG_TAG, "start check zeus update async");
            a aVar = this.ahb;
            Context context = this.f1664a;
            if (WebKitFactory.isUserPrivacyEnabled() && !aVar.d && com.baidu.browser.sailor.util.b.a(context)) {
                a.C0088a c0088a = new a.C0088a(context, "https://mbrowser.baidu.com/api/update/kernel?version=");
                BdNet bdNet = new BdNet(context);
                bdNet.setEventListener(c0088a);
                bdNet.start(c0088a, false);
                aVar.d = true;
            }
        }
    }
}
