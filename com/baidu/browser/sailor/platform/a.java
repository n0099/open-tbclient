package com.baidu.browser.sailor.platform;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.webkit.sdk.CookieSyncManager;
import com.baidu.webkit.sdk.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public final class a extends Handler {
    final /* synthetic */ BdSailorPlatform a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BdSailorPlatform bdSailorPlatform, Looper looper) {
        super(looper);
        this.a = bdSailorPlatform;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Context context;
        Context context2;
        boolean isAppOnForeground;
        Context context3;
        switch (message.what) {
            case 1:
                context = this.a.mContext;
                if (context != null) {
                    BdSailorPlatform bdSailorPlatform = this.a;
                    context2 = this.a.mContext;
                    isAppOnForeground = bdSailorPlatform.isAppOnForeground(context2);
                    if (isAppOnForeground) {
                        return;
                    }
                    try {
                        Log.d(BdSailorPlatform.TAG, "do pause");
                        this.a.mWebkitTimerPaused = com.baidu.browser.sailor.webkit.a.mq().c();
                        context3 = this.a.mContext;
                        CookieSyncManager createInstance = CookieSyncManager.createInstance(context3);
                        if (createInstance != null) {
                            createInstance.stopSync();
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }
}
