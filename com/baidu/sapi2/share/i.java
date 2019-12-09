package com.baidu.sapi2.share;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.HashMap;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ boolean b;
    final /* synthetic */ Handler c;
    final /* synthetic */ HandlerThread d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(List list, boolean z, Handler handler, HandlerThread handlerThread) {
        this.a = list;
        this.b = z;
        this.c = handler;
        this.d = handlerThread;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiConfiguration sapiConfiguration;
        SapiContext sapiContext;
        SapiConfiguration sapiConfiguration2;
        if (!this.a.isEmpty()) {
            try {
                if (this.b) {
                    HashMap hashMap = new HashMap();
                    sapiConfiguration2 = SapiShareClient.i;
                    hashMap.put("cuid", SapiUtils.getClientId(sapiConfiguration2.context));
                    hashMap.put(Config.DEVICE_PART, Build.MODEL);
                    hashMap.put("num", this.a.size() + "");
                    com.baidu.sapi2.utils.r.a("share_silent_account", hashMap);
                }
                sapiConfiguration = SapiShareClient.i;
                if (!sapiConfiguration.context.bindService((Intent) this.a.get(0), new h(this, this), 1)) {
                    this.a.remove(0);
                    if (!this.a.isEmpty()) {
                        sapiContext = SapiShareClient.j;
                        if (sapiContext.getShareAccounts().size() < 5) {
                            this.c.post(this);
                            return;
                        }
                    }
                    this.d.quit();
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }
}
