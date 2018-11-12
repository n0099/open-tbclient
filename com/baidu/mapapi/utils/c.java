package com.baidu.mapapi.utils;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.mapframework.open.aidl.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class c implements ServiceConnection {
    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Thread thread;
        String str;
        String str2;
        com.baidu.mapframework.open.aidl.a aVar;
        com.baidu.mapframework.open.aidl.a aVar2;
        com.baidu.mapframework.open.aidl.a aVar3;
        Thread thread2;
        thread = a.v;
        if (thread != null) {
            thread2 = a.v;
            thread2.interrupt();
        }
        str = a.c;
        Log.d(str, "onServiceConnected " + componentName);
        try {
            aVar2 = a.d;
            if (aVar2 != null) {
                com.baidu.mapframework.open.aidl.a unused = a.d = null;
            }
            com.baidu.mapframework.open.aidl.a unused2 = a.d = a.AbstractBinderC0090a.a(iBinder);
            aVar3 = a.d;
            aVar3.a(new d(this));
        } catch (RemoteException e) {
            str2 = a.c;
            Log.d(str2, "getComOpenClient ", e);
            aVar = a.d;
            if (aVar != null) {
                com.baidu.mapframework.open.aidl.a unused3 = a.d = null;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        String str;
        com.baidu.mapframework.open.aidl.a aVar;
        str = a.c;
        Log.d(str, "onServiceDisconnected " + componentName);
        aVar = a.d;
        if (aVar != null) {
            com.baidu.mapframework.open.aidl.a unused = a.d = null;
            boolean unused2 = a.u = false;
        }
    }
}
