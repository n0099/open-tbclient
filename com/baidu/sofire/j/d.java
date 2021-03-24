package com.baidu.sofire.j;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sofire.j.a;
/* loaded from: classes3.dex */
public final class d implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public b f11826a;

    public d(b bVar) {
        this.f11826a = bVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f11826a.f11818a = a.AbstractBinderC0157a.a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f11826a.f11818a = null;
    }
}
