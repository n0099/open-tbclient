package com.baidu.mapapi.utils;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapframework.open.aidl.b;
/* loaded from: classes2.dex */
public class e extends b.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f7401a;

    public e(d dVar) {
        this.f7401a = dVar;
    }

    @Override // com.baidu.mapframework.open.aidl.b
    public void a(IBinder iBinder) throws RemoteException {
        String str;
        IComOpenClient iComOpenClient;
        boolean z;
        str = b.f7394c;
        Log.d(str, "onClientReady");
        iComOpenClient = b.f7396e;
        if (iComOpenClient != null) {
            IComOpenClient unused = b.f7396e = null;
        }
        IComOpenClient unused2 = b.f7396e = IComOpenClient.a.a(iBinder);
        z = b.t;
        if (!z) {
            b.a(b.f7392a);
        }
        boolean unused3 = b.t = true;
    }
}
