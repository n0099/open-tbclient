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
import com.baidu.location.b.ab;
import com.baidu.location.b.ac;
import com.baidu.location.b.k;
import com.baidu.location.b.o;
import com.baidu.location.b.s;
import com.baidu.location.b.y;
import com.baidu.location.b.z;
import com.baidu.location.c.i;
import com.baidu.location.e.l;
import com.baidu.location.f;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class a extends Service implements LLSInterface {
    Messenger b = null;
    private Looper d = null;
    private HandlerThread e = null;
    private boolean f = true;
    private int h = 0;
    private boolean i = true;

    /* renamed from: a  reason: collision with root package name */
    static HandlerC0247a f1941a = null;
    private static long g = 0;
    public static long c = 0;

    /* renamed from: com.baidu.location.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class HandlerC0247a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<a> f1942a;

        public HandlerC0247a(Looper looper, a aVar) {
            super(looper);
            this.f1942a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = this.f1942a.get();
            if (aVar == null) {
                return;
            }
            if (f.isServing) {
                switch (message.what) {
                    case 11:
                        aVar.a(message);
                        break;
                    case 12:
                        aVar.b(message);
                        break;
                    case 15:
                        aVar.c(message);
                        break;
                    case 22:
                        o.c().b(message);
                        break;
                    case 41:
                        o.c().i();
                        break;
                    case 401:
                        try {
                            message.getData();
                            break;
                        } catch (Exception e) {
                            break;
                        }
                    case 406:
                        k.a().e();
                        break;
                    case 705:
                        com.baidu.location.b.b.a().a(message.getData().getBoolean("foreground"));
                        break;
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
            ac.a().e();
        } catch (Exception e) {
        }
        k.a().b();
        com.baidu.location.c.f.a().b();
        com.baidu.location.c.b.a().b();
        o.c().d();
        i.a().c();
        this.h = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        com.baidu.location.b.b.a().a(message);
        if (l.b()) {
            return;
        }
        s.b().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.baidu.location.c.f.a().e();
        i.a().d();
        ac.a().f();
        com.baidu.location.c.b.a().c();
        o.c().e();
        k.a().c();
        if (this.i) {
            ab.d();
        }
        com.baidu.location.b.b.a().b();
        try {
            z.a().d();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.h = 4;
        Log.d("baidu_location_service", "baidu location service has stoped ...");
        if (this.f) {
            return;
        }
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        com.baidu.location.b.b.a().b(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        com.baidu.location.b.b.a().c(message);
    }

    @Override // com.baidu.location.LLSInterface
    public double getVersion() {
        return 9.020000457763672d;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public IBinder onBind(Intent intent) {
        Bundle extras = intent.getExtras();
        boolean z = false;
        if (extras != null) {
            com.baidu.location.e.b.h = extras.getString("key");
            com.baidu.location.e.b.g = extras.getString("sign");
            this.f = extras.getBoolean("kill_process");
            z = extras.getBoolean("cache_exception");
        }
        if (!z) {
        }
        return this.b.getBinder();
    }

    @Override // com.baidu.location.LLSInterface
    public void onCreate(Context context) {
        try {
            l.ax = context.getPackageName();
        } catch (Exception e) {
        }
        g = System.currentTimeMillis();
        this.e = y.a();
        if (this.e != null) {
            this.d = this.e.getLooper();
        }
        if (this.d == null) {
            f1941a = new HandlerC0247a(Looper.getMainLooper(), this);
        } else {
            f1941a = new HandlerC0247a(this.d, this);
        }
        c = System.currentTimeMillis();
        this.b = new Messenger(f1941a);
        f1941a.sendEmptyMessage(0);
        this.h = 1;
        Log.d("baidu_location_service", "baidu location service start1 ...20200703_1..." + Process.myPid());
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onDestroy() {
        try {
            f1941a.sendEmptyMessage(1);
        } catch (Exception e) {
            Log.d("baidu_location_service", "baidu location service stop exception...");
            this.i = false;
            b();
            Process.killProcess(Process.myPid());
        }
        this.h = 3;
        new Handler(Looper.getMainLooper()).postDelayed(new b(this, new WeakReference(this)), 1000L);
        Log.d("baidu_location_service", "baidu location service stop ...");
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public int onStartCommand(Intent intent, int i, int i2) {
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
