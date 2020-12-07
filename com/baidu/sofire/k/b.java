package com.baidu.sofire.k;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sofire.k.c;
/* loaded from: classes8.dex */
public final class b implements com.baidu.sofire.j.b {

    /* renamed from: a  reason: collision with root package name */
    private a f3658a;

    @Override // com.baidu.sofire.j.b
    public final void a(Context context, com.baidu.sofire.j.c cVar) {
        this.f3658a = new a(context, cVar);
        final a aVar = this.f3658a;
        aVar.c = new ServiceConnection() { // from class: com.baidu.sofire.k.a.1
            @Override // android.content.ServiceConnection
            public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                aVar.b = c.a.a(iBinder);
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(ComponentName componentName) {
                aVar.b = null;
            }
        };
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        aVar.f3656a.bindService(intent, aVar.c, 1);
    }

    @Override // com.baidu.sofire.j.b
    public final String b() {
        return this.f3658a.a();
    }
}
