package com.baidu.mapapi.utils;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapframework.open.aidl.b;
/* loaded from: classes2.dex */
public final class c extends b.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7519a;

    public c(int i2) {
        this.f7519a = i2;
    }

    @Override // com.baidu.mapframework.open.aidl.b
    public void a(IBinder iBinder) throws RemoteException {
        String str;
        IComOpenClient iComOpenClient;
        str = b.f7512c;
        Log.d(str, "onClientReady");
        iComOpenClient = b.f7514e;
        if (iComOpenClient != null) {
            IComOpenClient unused = b.f7514e = null;
        }
        IComOpenClient unused2 = b.f7514e = IComOpenClient.a.a(iBinder);
        b.a(this.f7519a);
        boolean unused3 = b.t = true;
    }
}
