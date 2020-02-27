package com.baidu.sapi2.share;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* loaded from: classes6.dex */
class h implements ServiceConnection {
    final /* synthetic */ Runnable a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar, Runnable runnable) {
        this.b = iVar;
        this.a = runnable;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.b.c.post(new g(this, iBinder, this));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
