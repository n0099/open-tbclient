package com.baidu.sapi2.share;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class c implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ Handler b;
    final /* synthetic */ SapiAccount c;
    final /* synthetic */ boolean d;
    final /* synthetic */ HandlerThread e;
    final /* synthetic */ SapiShareClient f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SapiShareClient sapiShareClient, List list, Handler handler, SapiAccount sapiAccount, boolean z, HandlerThread handlerThread) {
        this.f = sapiShareClient;
        this.a = list;
        this.b = handler;
        this.c = sapiAccount;
        this.d = z;
        this.e = handlerThread;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiConfiguration sapiConfiguration;
        if (!this.a.isEmpty()) {
            try {
                sapiConfiguration = SapiShareClient.i;
                if (!sapiConfiguration.context.bindService((Intent) this.a.get(0), new b(this, this), 1)) {
                    this.a.remove(0);
                    if (!this.a.isEmpty()) {
                        this.b.post(this);
                    } else {
                        this.e.quit();
                    }
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }
}
