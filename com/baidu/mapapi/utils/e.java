package com.baidu.mapapi.utils;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapframework.open.aidl.b;
/* loaded from: classes8.dex */
class e extends b.a {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    @Override // com.baidu.mapframework.open.aidl.b
    public void a(IBinder iBinder) throws RemoteException {
        String str;
        IComOpenClient iComOpenClient;
        boolean z;
        str = b.c;
        Log.d(str, "onClientReady");
        iComOpenClient = b.e;
        if (iComOpenClient != null) {
            IComOpenClient unused = b.e = null;
        }
        IComOpenClient unused2 = b.e = IComOpenClient.a.a(iBinder);
        z = b.t;
        if (!z) {
            b.a(b.a);
        }
        boolean unused3 = b.t = true;
    }
}
