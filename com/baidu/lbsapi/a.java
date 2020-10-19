package com.baidu.lbsapi;

import com.baidu.lbsapi.auth.LBSAuthManagerListener;
/* loaded from: classes7.dex */
class a implements LBSAuthManagerListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MKGeneralListener f1829a;
    final /* synthetic */ BMapManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BMapManager bMapManager, MKGeneralListener mKGeneralListener) {
        this.b = bMapManager;
        this.f1829a = mKGeneralListener;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
        if (i == 0) {
            boolean unused = BMapManager.f1828a = true;
            this.f1829a.onGetPermissionState(i);
            return;
        }
        boolean unused2 = BMapManager.f1828a = false;
        this.f1829a.onGetPermissionState(300);
    }
}
