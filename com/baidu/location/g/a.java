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
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends Service implements LLSInterface {
    static HandlerC0022a a = null;
    private static long f = 0;
    private Looper c;
    private HandlerThread d;
    Messenger b = null;
    private boolean e = false;

    /* renamed from: com.baidu.location.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0022a extends Handler {
        public HandlerC0022a(Looper looper) {
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
                        e.ms().b(message);
                        break;
                    case 28:
                        e.ms().a(true);
                        break;
                    case r.l.PullToRefresh_mode /* 41 */:
                        e.ms().h();
                        break;
                    case 401:
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
        com.baidu.location.a.a.mq().a(message);
        d.mN();
        c.mG().d();
        g.mw().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.baidu.location.f.c.nf().b();
        k.no().b();
        com.baidu.location.h.c.np();
        e.ms().c();
        com.baidu.location.e.a.mM().b();
        b.mF().b();
        c.mG().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        com.baidu.location.a.a.mq().b(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        k.no().c();
        d.mN().n();
        com.baidu.location.f.f.ni().e();
        h.mL().c();
        c.mG().c();
        b.mF().c();
        com.baidu.location.c.a.mE().c();
        com.baidu.location.f.c.nf().c();
        e.ms().d();
        j.e();
        com.baidu.location.a.a.mq().b();
        com.baidu.location.c.e.mI().b();
        Log.d("baidu_location_service", "baidu location service has stoped ...");
        if (this.e) {
            return;
        }
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        com.baidu.location.a.a.mq().d(message);
    }

    @Override // com.baidu.location.LLSInterface
    public double getVersion() {
        return 6.230000019073486d;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public IBinder onBind(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            com.baidu.location.h.c.f = extras.getString("key");
            com.baidu.location.h.c.e = extras.getString(SapiUtils.KEY_QR_LOGIN_SIGN);
            this.e = extras.getBoolean("kill_process");
        }
        return this.b.getBinder();
    }

    @Override // com.baidu.location.LLSInterface
    public void onCreate(Context context) {
        f = System.currentTimeMillis();
        this.d = i.mz();
        this.c = this.d.getLooper();
        a = new HandlerC0022a(this.c);
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
