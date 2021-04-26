package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.util.e;
/* loaded from: classes.dex */
public class h extends IRemoteServiceCallback.Stub {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f1962a;

    public h(e eVar) {
        this.f1962a = eVar;
    }

    @Override // com.alipay.android.app.IRemoteServiceCallback
    public boolean isHideLoadingScreen() throws RemoteException {
        return false;
    }

    @Override // com.alipay.android.app.IRemoteServiceCallback
    public void payEnd(boolean z, String str) throws RemoteException {
    }

    @Override // com.alipay.android.app.IRemoteServiceCallback
    public void startActivity(String str, String str2, int i2, Bundle bundle) throws RemoteException {
        Activity activity;
        e.a aVar;
        Activity activity2;
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putInt("CallingPid", i2);
            intent.putExtras(bundle);
        } catch (Exception unused) {
        }
        intent.setClassName(str, str2);
        activity = this.f1962a.f1952c;
        if (activity != null) {
            activity2 = this.f1962a.f1952c;
            activity2.startActivity(intent);
        }
        aVar = this.f1962a.f1956g;
        aVar.b();
    }
}
