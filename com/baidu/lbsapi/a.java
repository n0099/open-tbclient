package com.baidu.lbsapi;

import com.baidu.lbsapi.auth.LBSAuthManagerListener;
/* loaded from: classes4.dex */
class a implements LBSAuthManagerListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MKGeneralListener f2477a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ BMapManager f2478b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BMapManager bMapManager, MKGeneralListener mKGeneralListener) {
        this.f2478b = bMapManager;
        this.f2477a = mKGeneralListener;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
        if (i == 0) {
            boolean unused = BMapManager.f2475a = true;
            this.f2477a.onGetPermissionState(i);
            return;
        }
        boolean unused2 = BMapManager.f2475a = false;
        this.f2477a.onGetPermissionState(300);
    }
}
