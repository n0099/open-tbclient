package com.baidu.sofire.j;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sofire.j.a;
/* loaded from: classes2.dex */
public final class d implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public b f10289a;

    public d(b bVar) {
        this.f10289a = bVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f10289a.f10281a = a.AbstractBinderC0142a.a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f10289a.f10281a = null;
    }
}
