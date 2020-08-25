package com.baidu.sofire.l;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sofire.l.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public final class d implements ServiceConnection {
    private b a;

    public d(b bVar) {
        this.a = bVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a.a = a.AbstractBinderC0323a.a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.a = null;
    }
}
