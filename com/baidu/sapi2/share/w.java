package com.baidu.sapi2.share;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class w implements Runnable {
    final /* synthetic */ SapiContext a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SapiContext sapiContext) {
        this.a = sapiContext;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.getCurrentAccount() != null) {
            SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, "slient_share");
            SapiAccountManager.getSilentShareListener().onSilentShare();
        }
    }
}
