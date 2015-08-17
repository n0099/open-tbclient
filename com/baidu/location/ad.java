package com.baidu.location;

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
/* loaded from: classes.dex */
public class ad extends Service implements LLSInterface, a0, n {
    public static long gP;
    public static boolean gX;
    private HandlerThread gT;
    private Looper gU;
    static a gW = null;
    private static Context gR = null;
    public static boolean gO = false;
    private static long gV = 0;
    Messenger gS = null;
    private boolean gQ = false;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (ad.gO) {
                switch (message.what) {
                    case 11:
                        ad.this.h(message);
                        break;
                    case 12:
                        ad.this.e(message);
                        break;
                    case 15:
                        ad.this.i(message);
                        break;
                    case 22:
                        ak.aF().m161case(message);
                        break;
                    case 25:
                        v.aN().m361long(message);
                        break;
                    case 28:
                        a1.ct().j(message);
                        break;
                    case a0.x /* 41 */:
                        ak.aF().aD();
                        break;
                    case a0.m /* 57 */:
                        ad.this.d(message);
                        break;
                    case 110:
                        ag.bz().bD();
                        break;
                    case 111:
                        ag.bz().bB();
                        break;
                    case a0.t /* 201 */:
                        an.a().m182do();
                        break;
                    case a0.f37long /* 202 */:
                        an.a().m183if();
                        break;
                    case a0.f35if /* 203 */:
                        an.a().a(message);
                        break;
                    case a0.j /* 206 */:
                        a3.cE().m109if(f.getServiceContext(), message);
                        break;
                    case a0.J /* 207 */:
                        ax.m245int(f.getServiceContext());
                        break;
                }
            }
            if (message.what == 0) {
                ad.this.bt();
            }
            if (message.what == 1) {
                ad.this.bs();
            }
            super.handleMessage(message);
        }
    }

    public static long bq() {
        return gV;
    }

    public static Handler br() {
        return gW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs() {
        u.au().as();
        ak.aF().aE();
        j.dg().dd();
        ag.bz().bB();
        q.x();
        k.q().o();
        if (this.gQ) {
            return;
        }
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt() {
        gO = true;
        u.au().ax();
        au.cc().ci();
        a2.cC();
        z.bc().a2();
        r.I().L();
        j.dg().df();
        ak.aF().aJ();
        a1.ct().cy();
        aa.bf().bg();
        az.m252do().m253for();
        ac.bo().bp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Message message) {
        if (message == null || message.obj != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Message message) {
        k.q().m298do(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Message message) {
        k.q().m305new(message);
        aa.bf().bh();
        d.ac().ae();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Message message) {
        k.q().m304int(message);
    }

    @Override // com.baidu.location.LLSInterface
    public double getVersion() {
        return 5.010000228881836d;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public IBinder onBind(Intent intent) {
        Bundle extras = intent.getExtras();
        boolean z = false;
        if (extras != null) {
            z = extras.getBoolean("cache_exception");
            this.gQ = extras.getBoolean("kill_process");
            gX = extras.getBoolean("debug_dev");
            gP = extras.getLong("interval");
        }
        if (!z) {
            Thread.setDefaultUncaughtExceptionHandler(ac.bo());
        }
        return this.gS.getBinder();
    }

    @Override // com.baidu.location.LLSInterface
    public void onCreate(Context context) {
        gV = System.currentTimeMillis();
        gR = context;
        this.gT = ar.a();
        this.gU = this.gT.getLooper();
        gW = new a(this.gU);
        this.gS = new Messenger(gW);
        gW.sendEmptyMessage(0);
        Log.d(a0.i, "baidu location service start1 ..." + Process.myPid());
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onDestroy() {
        gO = false;
        au.cc().b8();
        h.m291for().m292do();
        r.I().H();
        z.bc().a4();
        az.m252do().m254if();
        gW.sendEmptyMessage(1);
        Log.d(a0.i, "baidu location service stop ...");
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
