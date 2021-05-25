package com.baidu.location.d;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.baidu.location.LLSInterface;
import com.baidu.location.b.h;
import com.baidu.location.b.l;
import com.baidu.location.b.o;
import com.baidu.location.b.u;
import com.baidu.location.b.v;
import com.baidu.location.b.w;
import com.baidu.location.b.x;
import com.baidu.location.c.e;
import com.baidu.location.c.i;
import com.baidu.location.e.k;
import com.baidu.location.f;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class a extends Service implements LLSInterface {

    /* renamed from: a  reason: collision with root package name */
    public static HandlerC0093a f6656a;

    /* renamed from: c  reason: collision with root package name */
    public static long f6657c;

    /* renamed from: g  reason: collision with root package name */
    public static long f6658g;

    /* renamed from: b  reason: collision with root package name */
    public Messenger f6659b = null;

    /* renamed from: d  reason: collision with root package name */
    public Looper f6660d = null;

    /* renamed from: e  reason: collision with root package name */
    public HandlerThread f6661e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6662f = false;

    /* renamed from: h  reason: collision with root package name */
    public int f6663h = 0;

    /* renamed from: com.baidu.location.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0093a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<a> f6664a;

        public HandlerC0093a(Looper looper, a aVar) {
            super(looper);
            this.f6664a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = this.f6664a.get();
            if (aVar == null) {
                return;
            }
            if (f.isServing) {
                int i2 = message.what;
                if (i2 == 11) {
                    aVar.a(message);
                } else if (i2 == 12) {
                    aVar.b(message);
                } else if (i2 == 15) {
                    aVar.c(message);
                } else if (i2 == 22) {
                    l.c().b(message);
                } else if (i2 == 41) {
                    l.c().h();
                } else if (i2 == 401) {
                    try {
                        message.getData();
                    } catch (Exception unused) {
                    }
                } else if (i2 == 406) {
                    h.a().e();
                } else if (i2 == 705) {
                    com.baidu.location.b.a.a().a(message.getData().getBoolean(Constant.FOREGROUND));
                }
            }
            if (message.what == 1) {
                aVar.b();
            }
            if (message.what == 0) {
                aVar.a();
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.baidu.location.a.a.a().a(f.getServiceContext());
        com.baidu.location.e.b.a();
        try {
            x.a().e();
        } catch (Exception unused) {
        }
        h.a().b();
        e.a().b();
        com.baidu.location.c.b.a().b();
        l.c().d();
        i.a().c();
        this.f6663h = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        Log.d("baidu_location_service", "baidu location service register ...");
        com.baidu.location.b.a.a().a(message);
        if (k.b()) {
            return;
        }
        o.b().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        e.a().e();
        i.a().d();
        x.a().f();
        com.baidu.location.c.b.a().c();
        l.c().e();
        h.a().c();
        w.d();
        com.baidu.location.b.a.a().b();
        v.a().d();
        this.f6663h = 4;
        Log.d("baidu_location_service", "baidu location service has stoped ...");
        if (this.f6662f) {
            return;
        }
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        com.baidu.location.b.a.a().b(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        com.baidu.location.b.a.a().c(message);
    }

    @Override // com.baidu.location.LLSInterface
    public double getVersion() {
        return 7.929999828338623d;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public IBinder onBind(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            com.baidu.location.e.b.f6679h = extras.getString("key");
            com.baidu.location.e.b.f6678g = extras.getString("sign");
            this.f6662f = extras.getBoolean("kill_process");
            extras.getBoolean("cache_exception");
        }
        return this.f6659b.getBinder();
    }

    @Override // com.baidu.location.LLSInterface
    public void onCreate(Context context) {
        try {
            k.ax = context.getPackageName();
        } catch (Exception unused) {
        }
        f6658g = System.currentTimeMillis();
        HandlerThread a2 = u.a();
        this.f6661e = a2;
        if (a2 != null) {
            this.f6660d = a2.getLooper();
        }
        f6656a = this.f6660d == null ? new HandlerC0093a(Looper.getMainLooper(), this) : new HandlerC0093a(this.f6660d, this);
        f6657c = System.currentTimeMillis();
        this.f6659b = new Messenger(f6656a);
        f6656a.sendEmptyMessage(0);
        this.f6663h = 1;
        Log.d("baidu_location_service", "baidu location service start1 ...20190725..." + Process.myPid());
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onDestroy() {
        try {
            f6656a.sendEmptyMessage(1);
        } catch (Exception unused) {
            Log.d("baidu_location_service", "baidu location service stop exception...");
            b();
            Process.killProcess(Process.myPid());
        }
        this.f6663h = 3;
        new Handler(Looper.getMainLooper()).postDelayed(new b(this, new WeakReference(this)), 1000L);
        Log.d("baidu_location_service", "baidu location service stop ...");
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public int onStartCommand(Intent intent, int i2, int i3) {
        return 1;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onTaskRemoved(Intent intent) {
        Log.d("baidu_location_service", "baidu location service remove task...");
    }

    @Override // com.baidu.location.LLSInterface
    public boolean onUnBind(Intent intent) {
        return false;
    }
}
