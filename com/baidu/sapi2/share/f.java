package com.baidu.sapi2.share;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ Handler b;
    final /* synthetic */ SapiAccount c;
    final /* synthetic */ HandlerThread d;
    final /* synthetic */ SapiShareClient e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SapiShareClient sapiShareClient, List list, Handler handler, SapiAccount sapiAccount, HandlerThread handlerThread) {
        this.e = sapiShareClient;
        this.a = list;
        this.b = handler;
        this.c = sapiAccount;
        this.d = handlerThread;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiConfiguration sapiConfiguration;
        if (!this.a.isEmpty()) {
            try {
                sapiConfiguration = SapiShareClient.i;
                if (!sapiConfiguration.context.bindService((Intent) this.a.get(0), new e(this, this), 1)) {
                    this.a.remove(0);
                    if (!this.a.isEmpty()) {
                        this.b.post(this);
                    } else {
                        this.d.quit();
                    }
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }
}
