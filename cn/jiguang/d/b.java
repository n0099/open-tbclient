package cn.jiguang.d;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import cn.jiguang.d.d.l;
/* loaded from: classes3.dex */
final class b implements ServiceConnection {
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        cn.jiguang.g.a.a.a(cn.jiguang.b.b.a(iBinder));
        if (a.d != null) {
            l.bI().d(a.d, "intent.INIT", new Bundle());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
