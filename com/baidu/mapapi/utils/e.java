package com.baidu.mapapi.utils;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapframework.open.aidl.b;
/* loaded from: classes2.dex */
public class e extends b.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f7436a;

    public e(d dVar) {
        this.f7436a = dVar;
    }

    @Override // com.baidu.mapframework.open.aidl.b
    public void a(IBinder iBinder) throws RemoteException {
        String str;
        IComOpenClient iComOpenClient;
        boolean z;
        str = b.f7429c;
        Log.d(str, "onClientReady");
        iComOpenClient = b.f7431e;
        if (iComOpenClient != null) {
            IComOpenClient unused = b.f7431e = null;
        }
        IComOpenClient unused2 = b.f7431e = IComOpenClient.a.a(iBinder);
        z = b.t;
        if (!z) {
            b.a(b.f7427a);
        }
        boolean unused3 = b.t = true;
    }
}
