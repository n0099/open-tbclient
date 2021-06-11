package com.baidu.sofire.g;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.sofire.rp.receiver.Receiver;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f10279c;

    /* renamed from: a  reason: collision with root package name */
    public Context f10280a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.sofire.f.a f10281b;

    public e(Context context) {
        this.f10280a = context.getApplicationContext();
        this.f10281b = new com.baidu.sofire.f.a(context);
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (f10279c == null) {
                f10279c = new e(context);
            }
            eVar = f10279c;
        }
        return eVar;
    }

    public final void b() {
        com.baidu.sofire.f.a aVar = this.f10281b;
        Message message = new Message();
        message.what = 7;
        aVar.a(message);
    }

    public final void c() {
        Message message = new Message();
        message.what = 2;
        this.f10281b.a(message);
    }

    public final void a() {
        com.baidu.sofire.f.a aVar = this.f10281b;
        if (aVar.f10262c == null) {
            aVar.f10262c = new Receiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        aVar.f10261b.getApplicationContext().registerReceiver(aVar.f10262c, intentFilter, aVar.f10261b.getPackageName() + ".permission.sofire.RECEIVE", null);
        Message message = new Message();
        message.what = 5;
        aVar.a(message);
    }
}
