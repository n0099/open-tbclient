package com.baidu.sofire.l;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sofire.l.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class d implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private b f3663a;

    public d(b bVar) {
        this.f3663a = bVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f3663a.f3661a = a.AbstractBinderC0371a.a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f3663a.f3661a = null;
    }
}
