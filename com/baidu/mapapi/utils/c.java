package com.baidu.mapapi.utils;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapframework.open.aidl.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class c extends b.a {
    final /* synthetic */ int a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        this.a = i;
    }

    @Override // com.baidu.mapframework.open.aidl.b
    public void a(IBinder iBinder) throws RemoteException {
        String str;
        IComOpenClient iComOpenClient;
        str = b.c;
        Log.d(str, "onClientReady");
        iComOpenClient = b.e;
        if (iComOpenClient != null) {
            IComOpenClient unused = b.e = null;
        }
        IComOpenClient unused2 = b.e = IComOpenClient.a.a(iBinder);
        b.a(this.a);
        boolean unused3 = b.t = true;
    }
}
