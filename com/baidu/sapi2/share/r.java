package com.baidu.sapi2.share;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.share.ShareService;
/* loaded from: classes19.dex */
class r implements Runnable {
    final /* synthetic */ ShareService.a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ShareService.a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (SapiAccountManager.getReceiveShareListener() != null) {
            SapiAccountManager.getReceiveShareListener().onReceiveShare();
        }
    }
}
