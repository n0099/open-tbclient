package com.baidu.sapi2.share;

import android.content.Context;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class w implements Runnable {
    final /* synthetic */ SapiContext a;
    final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SapiContext sapiContext, Context context) {
        this.a = sapiContext;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.getCurrentAccount() != null) {
            SapiContext.getInstance(this.b).put(SapiContext.KEY_PRE_LOGIN_TYPE, "slient_share");
            SapiAccountManager.getSilentShareListener().onSilentShare();
        }
    }
}
