package com.baidu.browser.sailor.platform;

import android.content.Context;
import com.baidu.browser.sailor.webkit.update.a;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.sdk.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class b implements Runnable {
    final /* synthetic */ BdSailorPlatform a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorPlatform bdSailorPlatform) {
        this.a = bdSailorPlatform;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean is64Bit;
        Context context;
        boolean is64Bit2;
        Context context2;
        if (this.a.getAppContext() != null) {
            String str = BdSailorPlatform.TAG;
            StringBuilder sb = new StringBuilder("is64Bit(): ");
            is64Bit = BdSailorPlatform.is64Bit();
            Log.d(str, sb.append(is64Bit).toString());
            context = this.a.mContext;
            if (context != null) {
                String str2 = BdSailorPlatform.TAG;
                StringBuilder sb2 = new StringBuilder("nativeLibraryDir=");
                context2 = this.a.mContext;
                Log.d(str2, sb2.append(context2.getApplicationInfo().nativeLibraryDir).toString());
            }
            is64Bit2 = BdSailorPlatform.is64Bit();
            if (is64Bit2) {
                Log.i(BdSailorPlatform.TAG, "is64Bit");
                return;
            }
            Log.d(EngineManager.LOG_TAG, "start check zeus update");
            this.a.getAppContext();
            com.baidu.browser.sailor.webkit.update.a mG = com.baidu.browser.sailor.webkit.update.a.mG();
            Context appContext = this.a.getAppContext();
            if (com.baidu.browser.sailor.util.b.a(appContext)) {
                a.C0049a c0049a = new a.C0049a(appContext, "https://mbrowser.baidu.com/api/update/kernel?version=");
                BdNet bdNet = new BdNet(appContext);
                bdNet.setEventListener(c0049a);
                bdNet.start(c0049a, false);
            }
        }
    }
}
