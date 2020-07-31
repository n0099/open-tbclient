package com.baidu.lbsapi;

import com.baidu.lbsapi.auth.LBSAuthManagerListener;
/* loaded from: classes10.dex */
class a implements LBSAuthManagerListener {
    final /* synthetic */ MKGeneralListener a;
    final /* synthetic */ BMapManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BMapManager bMapManager, MKGeneralListener mKGeneralListener) {
        this.b = bMapManager;
        this.a = mKGeneralListener;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
        if (i == 0) {
            boolean unused = BMapManager.a = true;
            this.a.onGetPermissionState(i);
            return;
        }
        boolean unused2 = BMapManager.a = false;
        this.a.onGetPermissionState(300);
    }
}
