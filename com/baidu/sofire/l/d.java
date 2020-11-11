package com.baidu.sofire.l;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sofire.l.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class d implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private b f3660a;

    public d(b bVar) {
        this.f3660a = bVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f3660a.f3658a = a.AbstractBinderC0361a.a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f3660a.f3658a = null;
    }
}
