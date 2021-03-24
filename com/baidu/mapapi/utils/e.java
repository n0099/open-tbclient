package com.baidu.mapapi.utils;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapframework.open.aidl.b;
/* loaded from: classes2.dex */
public class e extends b.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f7400a;

    public e(d dVar) {
        this.f7400a = dVar;
    }

    @Override // com.baidu.mapframework.open.aidl.b
    public void a(IBinder iBinder) throws RemoteException {
        String str;
        IComOpenClient iComOpenClient;
        boolean z;
        str = b.f7393c;
        Log.d(str, "onClientReady");
        iComOpenClient = b.f7395e;
        if (iComOpenClient != null) {
            IComOpenClient unused = b.f7395e = null;
        }
        IComOpenClient unused2 = b.f7395e = IComOpenClient.a.a(iBinder);
        z = b.t;
        if (!z) {
            b.a(b.f7391a);
        }
        boolean unused3 = b.t = true;
    }
}
