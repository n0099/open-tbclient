package com.baidu.sapi2.share;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* loaded from: classes2.dex */
class e implements ServiceConnection {
    final /* synthetic */ Runnable a;
    final /* synthetic */ f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f fVar, Runnable runnable) {
        this.b = fVar;
        this.a = runnable;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.b.b.post(new d(this, iBinder, this));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
