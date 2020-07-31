package com.baidu.sapi2.share;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* loaded from: classes19.dex */
class b implements ServiceConnection {
    final /* synthetic */ Runnable a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar, Runnable runnable) {
        this.b = cVar;
        this.a = runnable;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.b.b.post(new a(this, iBinder, this));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
