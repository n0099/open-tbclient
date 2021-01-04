package com.baidu.lbsapi;

import com.baidu.lbsapi.auth.LBSAuthManagerListener;
/* loaded from: classes15.dex */
class a implements LBSAuthManagerListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MKGeneralListener f2528a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ BMapManager f2529b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BMapManager bMapManager, MKGeneralListener mKGeneralListener) {
        this.f2529b = bMapManager;
        this.f2528a = mKGeneralListener;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
        if (i == 0) {
            boolean unused = BMapManager.f2526a = true;
            this.f2528a.onGetPermissionState(i);
            return;
        }
        boolean unused2 = BMapManager.f2526a = false;
        this.f2528a.onGetPermissionState(300);
    }
}
