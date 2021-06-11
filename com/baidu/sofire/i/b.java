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
    public a f10339a;

    @Override // com.baidu.sofire.h.b
    public final void a(Context context, com.baidu.sofire.h.c cVar) {
        final a aVar = new a(context, cVar);
        this.f10339a = aVar;
        aVar.f10335c = new ServiceConnection() { // from class: com.baidu.sofire.i.a.1
            @Override // android.content.ServiceConnection
            public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                aVar.f10334b = c.a.a(iBinder);
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(ComponentName componentName) {
                aVar.f10334b = null;
            }
        };
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        aVar.f10333a.bindService(intent, aVar.f10335c, 1);
    }

    @Override // com.baidu.sofire.h.b
    public final String b() {
        return this.f10339a.a();
    }
}
