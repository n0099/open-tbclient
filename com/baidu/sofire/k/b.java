package com.baidu.sofire.k;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sofire.k.c;
/* loaded from: classes2.dex */
public final class b implements com.baidu.sofire.j.b {

    /* renamed from: a  reason: collision with root package name */
    public a f10353a;

    @Override // com.baidu.sofire.j.b
    public final void a(Context context, com.baidu.sofire.j.c cVar) {
        final a aVar = new a(context, cVar);
        this.f10353a = aVar;
        aVar.f10349c = new ServiceConnection() { // from class: com.baidu.sofire.k.a.1
            @Override // android.content.ServiceConnection
            public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                aVar.f10348b = c.a.a(iBinder);
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(ComponentName componentName) {
                aVar.f10348b = null;
            }
        };
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        aVar.f10347a.bindService(intent, aVar.f10349c, 1);
    }

    @Override // com.baidu.sofire.j.b
    public final String b() {
        return this.f10353a.a();
    }
}
