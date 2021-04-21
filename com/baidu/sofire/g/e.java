package com.baidu.sofire.g;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.sofire.rp.receiver.Receiver;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f11425c;

    /* renamed from: a  reason: collision with root package name */
    public Context f11426a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.sofire.f.a f11427b;

    public e(Context context) {
        this.f11426a = context.getApplicationContext();
        this.f11427b = new com.baidu.sofire.f.a(context);
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (f11425c == null) {
                f11425c = new e(context);
            }
            eVar = f11425c;
        }
        return eVar;
    }

    public final void b() {
        com.baidu.sofire.f.a aVar = this.f11427b;
        Message message = new Message();
        message.what = 7;
        aVar.a(message);
    }

    public final void c() {
        Message message = new Message();
        message.what = 2;
        this.f11427b.a(message);
    }

    public final void a() {
        com.baidu.sofire.f.a aVar = this.f11427b;
        if (aVar.f11409c == null) {
            aVar.f11409c = new Receiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        aVar.f11408b.getApplicationContext().registerReceiver(aVar.f11409c, intentFilter, aVar.f11408b.getPackageName() + ".permission.sofire.RECEIVE", null);
        Message message = new Message();
        message.what = 5;
        aVar.a(message);
    }
}
