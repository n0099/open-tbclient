package com.baidu.lbsapi;

import com.baidu.lbsapi.auth.LBSAuthManagerListener;
/* loaded from: classes3.dex */
class a implements LBSAuthManagerListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MKGeneralListener f2529a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ BMapManager f2530b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BMapManager bMapManager, MKGeneralListener mKGeneralListener) {
        this.f2530b = bMapManager;
        this.f2529a = mKGeneralListener;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
        if (i == 0) {
            boolean unused = BMapManager.f2527a = true;
            this.f2529a.onGetPermissionState(i);
            return;
        }
        boolean unused2 = BMapManager.f2527a = false;
        this.f2529a.onGetPermissionState(300);
    }
}
