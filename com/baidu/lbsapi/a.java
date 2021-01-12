package com.baidu.lbsapi;

import com.baidu.lbsapi.auth.LBSAuthManagerListener;
/* loaded from: classes6.dex */
class a implements LBSAuthManagerListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MKGeneralListener f2479a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ BMapManager f2480b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BMapManager bMapManager, MKGeneralListener mKGeneralListener) {
        this.f2480b = bMapManager;
        this.f2479a = mKGeneralListener;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
        if (i == 0) {
            boolean unused = BMapManager.f2477a = true;
            this.f2479a.onGetPermissionState(i);
            return;
        }
        boolean unused2 = BMapManager.f2477a = false;
        this.f2479a.onGetPermissionState(300);
    }
}
