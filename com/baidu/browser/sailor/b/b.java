package com.baidu.browser.sailor.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.webkit.sdk.CookieSyncManager;
import com.baidu.webkit.sdk.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b extends Handler {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, Looper looper) {
        super(looper);
        this.a = aVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Context context;
        Context context2;
        boolean ba;
        Context context3;
        switch (message.what) {
            case 1:
                context = this.a.mContext;
                if (context != null) {
                    a aVar = this.a;
                    context2 = this.a.mContext;
                    ba = aVar.ba(context2);
                    if (ba) {
                        return;
                    }
                    try {
                        Log.d(a.TAG, "do pause");
                        this.a.WL = com.baidu.browser.sailor.webkit.a.rb().c();
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
