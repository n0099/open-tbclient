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
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.location.LLSInterface;
import com.baidu.location.a.h;
import com.baidu.location.a.j;
import com.baidu.location.a.k;
import com.baidu.location.a.m;
import com.baidu.location.a.o;
import com.baidu.location.a.p;
import com.baidu.location.b.b;
import com.baidu.location.b.d;
import com.baidu.location.f;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class a extends Service implements LLSInterface {
    static HandlerC0084a a = null;
    private static long f = 0;
    private Looper c;
    private HandlerThread d;
    Messenger b = null;
    private boolean e = false;

    /* renamed from: com.baidu.location.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class HandlerC0084a extends Handler {
        private final WeakReference<a> a;

        public HandlerC0084a(Looper looper, a aVar) {
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
                        j.tr().b(message);
                        break;
                    case 41:
                        j.tr().h();
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
                        com.baidu.location.a.f.tn().e();
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
        h.tp().a(f.getServiceContext());
        k.tt().b();
        com.baidu.location.a.f.tn().b();
        d.tF().b();
        b.tA().b();
        com.baidu.location.d.b.tM();
        j.tr().d();
        com.baidu.location.b.f.tH().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        Log.d("baidu_location_service", "baidu location service register ...");
        com.baidu.location.a.a.ti().a(message);
        m.tv().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.baidu.location.b.f.tH().d();
        d.tF().e();
        b.tA().c();
        j.tr().e();
        com.baidu.location.a.f.tn().c();
        p.d();
        com.baidu.location.a.a.ti().b();
        com.baidu.location.a.d.tl().b();
        k.tt().c();
        Log.d("baidu_location_service", "baidu location service has stoped ...");
        if (this.e) {
            return;
        }
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        com.baidu.location.a.a.ti().b(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        com.baidu.location.a.a.ti().i(message);
    }

    @Override // com.baidu.location.LLSInterface
    public double getVersion() {
        return 7.420000076293945d;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public IBinder onBind(Intent intent) {
        Bundle extras = intent.getExtras();
        boolean z = false;
        if (extras != null) {
            com.baidu.location.d.b.g = extras.getString(RimArmor.KEY);
            com.baidu.location.d.b.f = extras.getString("sign");
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
        this.d = o.ty();
        this.c = this.d.getLooper();
        if (this.c == null) {
            a = new HandlerC0084a(Looper.getMainLooper(), this);
        } else {
            a = new HandlerC0084a(this.c, this);
        }
        this.b = new Messenger(a);
        a.sendEmptyMessage(0);
        Log.d("baidu_location_service", "baidu location service start1 ...20180321..." + Process.myPid());
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onDestroy() {
        try {
            a.sendEmptyMessage(1);
        } catch (Exception e) {
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
