package com.baidu.sofire.g;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.sofire.rp.receiver.Receiver;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f11755c;

    /* renamed from: a  reason: collision with root package name */
    public Context f11756a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.sofire.f.a f11757b;

    public e(Context context) {
        this.f11756a = context.getApplicationContext();
        this.f11757b = new com.baidu.sofire.f.a(context);
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (f11755c == null) {
                f11755c = new e(context);
            }
            eVar = f11755c;
        }
        return eVar;
    }

    public final void b() {
        com.baidu.sofire.f.a aVar = this.f11757b;
        Message message = new Message();
        message.what = 7;
        aVar.a(message);
    }

    public final void c() {
        Message message = new Message();
        message.what = 2;
        this.f11757b.a(message);
    }

    public final void a() {
        com.baidu.sofire.f.a aVar = this.f11757b;
        if (aVar.f11739c == null) {
            aVar.f11739c = new Receiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        aVar.f11738b.getApplicationContext().registerReceiver(aVar.f11739c, intentFilter, aVar.f11738b.getPackageName() + ".permission.sofire.RECEIVE", null);
        Message message = new Message();
        message.what = 5;
        aVar.a(message);
    }
}
