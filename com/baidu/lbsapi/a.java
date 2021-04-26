package com.baidu.lbsapi;

import com.baidu.lbsapi.auth.LBSAuthManagerListener;
/* loaded from: classes2.dex */
public class a implements LBSAuthManagerListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MKGeneralListener f6532a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BMapManager f6533b;

    public a(BMapManager bMapManager, MKGeneralListener mKGeneralListener) {
        this.f6533b = bMapManager;
        this.f6532a = mKGeneralListener;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i2, String str) {
        if (i2 == 0) {
            boolean unused = BMapManager.f6530a = true;
            this.f6532a.onGetPermissionState(i2);
            return;
        }
        boolean unused2 = BMapManager.f6530a = false;
        this.f6532a.onGetPermissionState(300);
    }
}
