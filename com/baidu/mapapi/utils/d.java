package com.baidu.mapapi.utils;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.mapframework.open.aidl.a;
/* loaded from: classes2.dex */
public final class d implements ServiceConnection {
    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Thread thread;
        String str;
        String str2;
        com.baidu.mapframework.open.aidl.a aVar;
        com.baidu.mapframework.open.aidl.a aVar2;
        com.baidu.mapframework.open.aidl.a aVar3;
        Thread thread2;
        thread = b.v;
        if (thread != null) {
            thread2 = b.v;
            thread2.interrupt();
        }
        str = b.f7429c;
        Log.d(str, "onServiceConnected " + componentName);
        try {
            aVar2 = b.f7430d;
            if (aVar2 != null) {
                com.baidu.mapframework.open.aidl.a unused = b.f7430d = null;
            }
            com.baidu.mapframework.open.aidl.a unused2 = b.f7430d = a.AbstractBinderC0095a.a(iBinder);
            aVar3 = b.f7430d;
            aVar3.a(new e(this));
        } catch (RemoteException e2) {
            str2 = b.f7429c;
            Log.d(str2, "getComOpenClient ", e2);
            aVar = b.f7430d;
            if (aVar != null) {
                com.baidu.mapframework.open.aidl.a unused3 = b.f7430d = null;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        String str;
        com.baidu.mapframework.open.aidl.a aVar;
        str = b.f7429c;
        Log.d(str, "onServiceDisconnected " + componentName);
        aVar = b.f7430d;
        if (aVar != null) {
            com.baidu.mapframework.open.aidl.a unused = b.f7430d = null;
            boolean unused2 = b.u = false;
        }
    }
}
