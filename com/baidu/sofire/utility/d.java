package com.baidu.sofire.utility;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.sofire.rp.receiver.Receiver;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static d f10408c;

    /* renamed from: a  reason: collision with root package name */
    public Context f10409a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.sofire.g.a f10410b;

    public d(Context context) {
        this.f10409a = context.getApplicationContext();
        this.f10410b = new com.baidu.sofire.g.a(context);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f10408c == null) {
                f10408c = new d(context);
            }
            dVar = f10408c;
        }
        return dVar;
    }

    public final void b() {
        com.baidu.sofire.g.a aVar = this.f10410b;
        Message message = new Message();
        message.what = 7;
        aVar.a(message);
    }

    public final void c() {
        Message message = new Message();
        message.what = 2;
        this.f10410b.a(message);
    }

    public final void a() {
        com.baidu.sofire.g.a aVar = this.f10410b;
        if (aVar.f10315c == null) {
            aVar.f10315c = new Receiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        aVar.f10314b.getApplicationContext().registerReceiver(aVar.f10315c, intentFilter, aVar.f10314b.getPackageName() + ".permission.sofire.RECEIVE", null);
        Message message = new Message();
        message.what = 5;
        aVar.a(message);
    }
}
