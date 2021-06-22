package com.baidu.sofire.l;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sofire.l.a;
/* loaded from: classes2.dex */
public final class d implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public b f10365a;

    public d(b bVar) {
        this.f10365a = bVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f10365a.f10357a = a.AbstractBinderC0145a.a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f10365a.f10357a = null;
    }
}
