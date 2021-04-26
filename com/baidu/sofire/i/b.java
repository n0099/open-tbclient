package com.baidu.sofire.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sofire.i.c;
/* loaded from: classes2.dex */
public final class b implements com.baidu.sofire.h.b {

    /* renamed from: a  reason: collision with root package name */
    public a f11309a;

    @Override // com.baidu.sofire.h.b
    public final void a(Context context, com.baidu.sofire.h.c cVar) {
        final a aVar = new a(context, cVar);
        this.f11309a = aVar;
        aVar.f11305c = new ServiceConnection() { // from class: com.baidu.sofire.i.a.1
            @Override // android.content.ServiceConnection
            public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                aVar.f11304b = c.a.a(iBinder);
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(ComponentName componentName) {
                aVar.f11304b = null;
            }
        };
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        aVar.f11303a.bindService(intent, aVar.f11305c, 1);
    }

    @Override // com.baidu.sofire.h.b
    public final String b() {
        return this.f11309a.a();
    }
}
