package com.baidu.location.g;

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
import com.baidu.location.a.e;
import com.baidu.location.a.g;
import com.baidu.location.a.i;
import com.baidu.location.a.j;
import com.baidu.location.c.b;
import com.baidu.location.c.c;
import com.baidu.location.c.h;
import com.baidu.location.e.d;
import com.baidu.location.f;
import com.baidu.location.f.k;
import org.apache.http.HttpStatus;
/* loaded from: classes.dex */
public class a extends Service implements LLSInterface {
    static HandlerC0064a a = null;
    private static long f = 0;
    private Looper c;
    private HandlerThread d;
    Messenger b = null;
    private boolean e = false;

    /* renamed from: com.baidu.location.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0064a extends Handler {
        public HandlerC0064a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (f.isServing) {
                switch (message.what) {
                    case 11:
                        a.this.a(message);
                        break;
                    case 12:
                        a.this.b(message);
                        break;
                    case 15:
                        a.this.c(message);
                        break;
                    case 22:
                        e.up().b(message);
                        break;
                    case 28:
                        e.up().a(true);
                        break;
                    case 41:
                        e.up().h();
                        break;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        try {
                            message.getData();
                            break;
                        } catch (Exception e) {
                            break;
                        }
                }
            }
            if (message.what == 1) {
                a.this.c();
            }
            if (message.what == 0) {
                a.this.b();
            }
            super.handleMessage(message);
        }
    }

    public static Handler a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        Log.d("baidu_location_service", "baidu location service register ...");
        com.baidu.location.a.a.un().a(message);
        d.uL();
        c.uE().d();
        g.ut().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.baidu.location.f.c.vd().b();
        k.vm().b();
        com.baidu.location.h.c.vn();
        e.up().c();
        com.baidu.location.e.a.uK().b();
        b.uD().b();
        c.uE().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        com.baidu.location.a.a.un().b(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        k.vm().c();
        d.uL().n();
        com.baidu.location.f.f.vg().e();
        h.uJ().c();
        c.uE().c();
        b.uD().c();
        com.baidu.location.c.a.uC().c();
        com.baidu.location.f.c.vd().c();
        e.up().d();
        j.e();
        com.baidu.location.a.a.un().b();
        com.baidu.location.c.e.uG().b();
        Log.d("baidu_location_service", "baidu location service has stoped ...");
        if (this.e) {
            return;
        }
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        com.baidu.location.a.a.un().f(message);
    }

    @Override // com.baidu.location.LLSInterface
    public double getVersion() {
        return 6.230000019073486d;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public IBinder onBind(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            com.baidu.location.h.c.f = extras.getString(RimArmor.KEY);
            com.baidu.location.h.c.e = extras.getString("sign");
            this.e = extras.getBoolean("kill_process");
        }
        return this.b.getBinder();
    }

    @Override // com.baidu.location.LLSInterface
    public void onCreate(Context context) {
        f = System.currentTimeMillis();
        this.d = i.ux();
        this.c = this.d.getLooper();
        a = new HandlerC0064a(this.c);
        this.b = new Messenger(a);
        a.sendEmptyMessage(0);
        Log.d("baidu_location_service", "baidu location service start1 ..." + Process.myPid());
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onDestroy() {
        a.sendEmptyMessage(1);
        Log.d("baidu_location_service", "baidu location service stop ...");
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    @Override // com.baidu.location.LLSInterface
    public boolean onUnBind(Intent intent) {
        return false;
    }
}
