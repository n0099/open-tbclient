package com.baidu.lbsapi;

import com.baidu.lbsapi.auth.LBSAuthManagerListener;
/* loaded from: classes4.dex */
class a implements LBSAuthManagerListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MKGeneralListener f1872a;
    final /* synthetic */ BMapManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BMapManager bMapManager, MKGeneralListener mKGeneralListener) {
        this.b = bMapManager;
        this.f1872a = mKGeneralListener;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
        if (i == 0) {
            boolean unused = BMapManager.f1871a = true;
            this.f1872a.onGetPermissionState(i);
            return;
        }
        boolean unused2 = BMapManager.f1871a = false;
        this.f1872a.onGetPermissionState(300);
    }
}
