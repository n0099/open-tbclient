package com.baidu.loginshare;

import com.baidu.share.ShareAssistant;
import com.baidu.share.ShareModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h extends Thread {
    private /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.a = fVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            sleep(100L);
            if (this.a.e != null || this.a.a == null) {
                return;
            }
            ShareModel shareModel = new ShareModel();
            shareModel.mAction = Keystore.a();
            ShareAssistant.a(this.a.a).share(shareModel);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
