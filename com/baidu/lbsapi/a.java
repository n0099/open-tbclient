package com.baidu.lbsapi;

import com.baidu.lbsapi.auth.LBSAuthManagerListener;
/* loaded from: classes2.dex */
public class a implements LBSAuthManagerListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MKGeneralListener f6311a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BMapManager f6312b;

    public a(BMapManager bMapManager, MKGeneralListener mKGeneralListener) {
        this.f6312b = bMapManager;
        this.f6311a = mKGeneralListener;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
        if (i == 0) {
            boolean unused = BMapManager.f6309a = true;
            this.f6311a.onGetPermissionState(i);
            return;
        }
        boolean unused2 = BMapManager.f6309a = false;
        this.f6311a.onGetPermissionState(300);
    }
}
