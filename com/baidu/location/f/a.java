package com.baidu.location.f;

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
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.location.LLSInterface;
import com.baidu.location.a.g;
import com.baidu.location.a.i;
import com.baidu.location.a.j;
import com.baidu.location.a.m;
import com.baidu.location.a.o;
import com.baidu.location.a.p;
import com.baidu.location.a.q;
import com.baidu.location.b.c;
import com.baidu.location.b.e;
import com.baidu.location.d.d;
import com.baidu.location.f;
import com.baidu.location.g.b;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class a extends Service implements LLSInterface {
    static HandlerC0088a a = null;
    private static long f = 0;
    private Looper c;
    private HandlerThread d;
    Messenger b = null;
    private boolean e = false;

    /* renamed from: com.baidu.location.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class HandlerC0088a extends Handler {
        private final WeakReference<a> a;

        public HandlerC0088a(Looper looper, a aVar) {
            super(looper);
            this.a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = this.a.get();
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
                        j.ti().b(message);
                        break;
                    case 28:
                        j.ti().a(true, true);
                        break;
                    case 41:
                        j.ti().i();
                        break;
                    case 401:
                        try {
                            message.getData();
                            break;
                        } catch (Exception e) {
                            break;
                        }
                    case 405:
                        byte[] byteArray = message.getData().getByteArray("errorid");
                        if (byteArray != null && byteArray.length > 0) {
                            new String(byteArray);
                            break;
                        }
                        break;
                    case 406:
                        g.tg().e();
                        break;
                }
            }
            if (message.what == 1) {
                aVar.c();
            }
            if (message.what == 0) {
                aVar.b();
            }
            super.handleMessage(message);
        }
    }

    public static long a() {
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        Log.d("baidu_location_service", "baidu location service register ...");
        com.baidu.location.a.a.tb().a(message);
        d.tE();
        com.baidu.location.b.d.tw().d();
        m.tm().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        i.th().a(f.getServiceContext());
        b.tV();
        q.ts().e();
        g.tg().b();
        com.baidu.location.e.d.tO().b();
        com.baidu.location.e.b.tL().b();
        j.ti().d();
        com.baidu.location.d.a.tz().c();
        c.tv().b();
        com.baidu.location.b.d.tw().b();
        e.tx().b();
        com.baidu.location.b.a.tt().b();
        com.baidu.location.e.f.tQ().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        com.baidu.location.a.a.tb().b(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.baidu.location.e.f.tQ().e();
        d.tE().n();
        com.baidu.location.e.d.tO().e();
        q.ts().f();
        com.baidu.location.b.d.tw().c();
        c.tv().c();
        com.baidu.location.b.b.tu().c();
        com.baidu.location.b.a.tt().c();
        com.baidu.location.a.b.tc().b();
        com.baidu.location.e.b.tL().c();
        j.ti().e();
        g.tg().c();
        p.d();
        com.baidu.location.a.a.tb().b();
        Log.d("baidu_location_service", "baidu location service has stoped ...");
        if (this.e) {
            return;
        }
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        com.baidu.location.a.a.tb().k(message);
    }

    @Override // com.baidu.location.LLSInterface
    public double getVersion() {
        return 7.800000190734863d;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public IBinder onBind(Intent intent) {
        Bundle extras = intent.getExtras();
        boolean z = false;
        if (extras != null) {
            b.g = extras.getString(RimArmor.KEY);
            b.f = extras.getString("sign");
            this.e = extras.getBoolean("kill_process");
            z = extras.getBoolean("cache_exception");
        }
        if (!z) {
        }
        return this.b.getBinder();
    }

    @Override // com.baidu.location.LLSInterface
    public void onCreate(Context context) {
        f = System.currentTimeMillis();
        this.d = o.tq();
        this.c = this.d.getLooper();
        if (this.c == null) {
            a = new HandlerC0088a(Looper.getMainLooper(), this);
        } else {
            a = new HandlerC0088a(this.c, this);
        }
        this.b = new Messenger(a);
        a.sendEmptyMessage(0);
        Log.d("baidu_location_service", "baidu location service start1 ...20181022..." + Process.myPid());
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onDestroy() {
        try {
            a.sendEmptyMessage(1);
        } catch (Exception e) {
            Log.d("baidu_location_service", "baidu location service stop exception...");
            c();
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
