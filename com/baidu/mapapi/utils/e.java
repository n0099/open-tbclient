package com.baidu.mapapi.utils;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapframework.open.aidl.b;
/* loaded from: classes4.dex */
class e extends b.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f2962a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f2962a = dVar;
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
            b.a(b.f2959a);
        }
        boolean unused3 = b.t = true;
    }
}
