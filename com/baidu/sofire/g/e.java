package com.baidu.sofire.g;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.sofire.rp.receiver.Receiver;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f10217c;

    /* renamed from: a  reason: collision with root package name */
    public Context f10218a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.sofire.f.a f10219b;

    public e(Context context) {
        this.f10218a = context.getApplicationContext();
        this.f10219b = new com.baidu.sofire.f.a(context);
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (f10217c == null) {
                f10217c = new e(context);
            }
            eVar = f10217c;
        }
        return eVar;
    }

    public final void b() {
        com.baidu.sofire.f.a aVar = this.f10219b;
        Message message = new Message();
        message.what = 7;
        aVar.a(message);
    }

    public final void c() {
        Message message = new Message();
        message.what = 2;
        this.f10219b.a(message);
    }

    public final void a() {
        com.baidu.sofire.f.a aVar = this.f10219b;
        if (aVar.f10200c == null) {
            aVar.f10200c = new Receiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        aVar.f10199b.getApplicationContext().registerReceiver(aVar.f10200c, intentFilter, aVar.f10199b.getPackageName() + ".permission.sofire.RECEIVE", null);
        Message message = new Message();
        message.what = 5;
        aVar.a(message);
    }
}
