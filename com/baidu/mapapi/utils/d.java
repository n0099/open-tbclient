package com.baidu.mapapi.utils;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapframework.open.aidl.b;
/* loaded from: classes4.dex */
class d extends b.a {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.mapframework.open.aidl.b
    public void a(IBinder iBinder) throws RemoteException {
        String str;
        IComOpenClient iComOpenClient;
        boolean z;
        str = a.c;
        Log.d(str, "onClientReady");
        iComOpenClient = a.e;
        if (iComOpenClient != null) {
            IComOpenClient unused = a.e = null;
        }
        IComOpenClient unused2 = a.e = IComOpenClient.a.a(iBinder);
        z = a.t;
        if (!z) {
            a.a(a.a);
        }
        boolean unused3 = a.t = true;
    }
}
