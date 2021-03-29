package com.baidu.lbsapi;

import com.baidu.lbsapi.auth.LBSAuthManagerListener;
/* loaded from: classes2.dex */
public class a implements LBSAuthManagerListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MKGeneralListener f6312a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BMapManager f6313b;

    public a(BMapManager bMapManager, MKGeneralListener mKGeneralListener) {
        this.f6313b = bMapManager;
        this.f6312a = mKGeneralListener;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
        if (i == 0) {
            boolean unused = BMapManager.f6310a = true;
            this.f6312a.onGetPermissionState(i);
            return;
        }
        boolean unused2 = BMapManager.f6310a = false;
        this.f6312a.onGetPermissionState(300);
    }
}
