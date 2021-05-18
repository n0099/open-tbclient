package com.baidu.sofire.g;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.sofire.rp.receiver.Receiver;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f10316c;

    /* renamed from: a  reason: collision with root package name */
    public Context f10317a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.sofire.f.a f10318b;

    public e(Context context) {
        this.f10317a = context.getApplicationContext();
        this.f10318b = new com.baidu.sofire.f.a(context);
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (f10316c == null) {
                f10316c = new e(context);
            }
            eVar = f10316c;
        }
        return eVar;
    }

    public final void b() {
        com.baidu.sofire.f.a aVar = this.f10318b;
        Message message = new Message();
        message.what = 7;
        aVar.a(message);
    }

    public final void c() {
        Message message = new Message();
        message.what = 2;
        this.f10318b.a(message);
    }

    public final void a() {
        com.baidu.sofire.f.a aVar = this.f10318b;
        if (aVar.f10299c == null) {
            aVar.f10299c = new Receiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        aVar.f10298b.getApplicationContext().registerReceiver(aVar.f10299c, intentFilter, aVar.f10298b.getPackageName() + ".permission.sofire.RECEIVE", null);
        Message message = new Message();
        message.what = 5;
        aVar.a(message);
    }
}
