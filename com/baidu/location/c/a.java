package com.baidu.location.c;

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
import com.baidu.location.a.h;
import com.baidu.location.a.j;
import com.baidu.location.a.l;
import com.baidu.location.a.n;
import com.baidu.location.a.p;
import com.baidu.location.a.v;
import com.baidu.location.a.w;
import com.baidu.location.a.x;
import com.baidu.location.b.e;
import com.baidu.location.b.i;
import com.baidu.location.d.b;
import com.baidu.location.f;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class a extends Service implements LLSInterface {

    /* renamed from: a  reason: collision with root package name */
    public static HandlerC0093a f6697a;

    /* renamed from: f  reason: collision with root package name */
    public static long f6698f;

    /* renamed from: c  reason: collision with root package name */
    public Looper f6700c;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f6701d;

    /* renamed from: b  reason: collision with root package name */
    public Messenger f6699b = null;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6702e = false;

    /* renamed from: com.baidu.location.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0093a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<a> f6703a;

        public HandlerC0093a(Looper looper, a aVar) {
            super(looper);
            this.f6703a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = this.f6703a.get();
            if (aVar == null) {
                return;
            }
            if (f.isServing) {
                int i = message.what;
                if (i == 11) {
                    aVar.a(message);
                } else if (i == 12) {
                    aVar.b(message);
                } else if (i == 15) {
                    aVar.c(message);
                } else if (i == 22) {
                    l.c().b(message);
                } else if (i == 41) {
                    l.c().h();
                } else if (i == 401) {
                    try {
                        message.getData();
                    } catch (Exception unused) {
                    }
                } else if (i == 405) {
                    byte[] byteArray = message.getData().getByteArray("errorid");
                    if (byteArray != null && byteArray.length > 0) {
                        new String(byteArray);
                    }
                } else if (i == 406) {
                    h.a().e();
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
        j.a().a(f.getServiceContext());
        b.a();
        x.a().e();
        n.a().b();
        h.a().b();
        e.a().b();
        com.baidu.location.b.b.a().b();
        l.c().d();
        i.a().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        Log.d("baidu_location_service", "baidu location service register ...");
        com.baidu.location.a.a.a().a(message);
        p.b().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        i.a().d();
        e.a().e();
        x.a().f();
        com.baidu.location.b.b.a().c();
        l.c().e();
        h.a().c();
        w.d();
        com.baidu.location.a.a.a().b();
        n.a().c();
        Log.d("baidu_location_service", "baidu location service has stoped ...");
        if (this.f6702e) {
            return;
        }
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        com.baidu.location.a.a.a().b(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        com.baidu.location.a.a.a().c(message);
    }

    @Override // com.baidu.location.LLSInterface
    public double getVersion() {
        return 7.630000114440918d;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public IBinder onBind(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            b.f6715g = extras.getString("key");
            b.f6714f = extras.getString("sign");
            this.f6702e = extras.getBoolean("kill_process");
            extras.getBoolean("cache_exception");
        }
        return this.f6699b.getBinder();
    }

    @Override // com.baidu.location.LLSInterface
    public void onCreate(Context context) {
        f6698f = System.currentTimeMillis();
        HandlerThread a2 = v.a();
        this.f6701d = a2;
        Looper looper = a2.getLooper();
        this.f6700c = looper;
        f6697a = looper == null ? new HandlerC0093a(Looper.getMainLooper(), this) : new HandlerC0093a(this.f6700c, this);
        this.f6699b = new Messenger(f6697a);
        f6697a.sendEmptyMessage(0);
        Log.d("baidu_location_service", "baidu location service start1 ...20181022..." + Process.myPid());
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onDestroy() {
        try {
            f6697a.sendEmptyMessage(1);
        } catch (Exception unused) {
            Log.d("baidu_location_service", "baidu location service stop exception...");
            b();
            Process.killProcess(Process.myPid());
        }
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
