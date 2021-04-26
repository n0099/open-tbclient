package com.baidu.mapapi.utils;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapframework.open.aidl.b;
/* loaded from: classes2.dex */
public class e extends b.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f7703a;

    public e(d dVar) {
        this.f7703a = dVar;
    }

    @Override // com.baidu.mapframework.open.aidl.b
    public void a(IBinder iBinder) throws RemoteException {
        String str;
        IComOpenClient iComOpenClient;
        boolean z;
        str = b.f7695c;
        Log.d(str, "onClientReady");
        iComOpenClient = b.f7697e;
        if (iComOpenClient != null) {
            IComOpenClient unused = b.f7697e = null;
        }
        IComOpenClient unused2 = b.f7697e = IComOpenClient.a.a(iBinder);
        z = b.t;
        if (!z) {
            b.a(b.f7693a);
        }
        boolean unused3 = b.t = true;
    }
}
