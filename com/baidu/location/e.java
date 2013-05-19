package com.baidu.location;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class e {
    private j e;
    private Context g;
    private am t;
    private String a = "3.1";
    private long b = 0;
    private long c = 0;
    private String d = null;
    private boolean f = false;
    private Messenger h = null;
    private h i = new h(this, null);
    private final Messenger j = new Messenger(this.i);
    private ArrayList k = null;
    private a l = null;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private i p = null;
    private boolean q = false;
    private boolean r = false;
    private final Object s = new Object();
    private boolean u = false;
    private c v = null;
    private String w = null;
    private String x = "http://loc.map.baidu.com/sdk.php";
    private Boolean y = false;
    private Boolean z = false;
    private ServiceConnection A = new g(this);

    public e(Context context) {
        this.e = new j();
        this.g = null;
        this.t = null;
        this.g = context;
        this.e = new j();
        this.t = new am(this.g, this);
    }

    private void a(int i) {
        if (i == 26 && this.n) {
            Iterator it = this.k.iterator();
            while (it.hasNext()) {
                ((c) it.next()).onReceivePoi(this.l);
            }
            this.n = false;
        }
        if (this.m || ((this.e.h && this.l.d() == 61) || this.l.d() == 66 || this.l.d() == 67)) {
            if (this.e != null && this.e.a() && this.l.d() == 65) {
                return;
            }
            Iterator it2 = this.k.iterator();
            while (it2.hasNext()) {
                ((c) it2.next()).onReceiveLocation(this.l);
            }
            if (this.r && ap.a && this.l.d() == 65) {
                this.r = false;
            } else if (this.l.d() == 66 || this.l.d() == 67) {
            } else {
                this.m = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, int i) {
        String string = message.getData().getString("locStr");
        ap.a("baidu_location_Client", "on receive new location : " + string);
        ap.b("baidu_location_Client", "on receive new location : " + string);
        this.l = new a(string);
        a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Message message) {
        ap.a("baidu_location_Client", "onSetOption...");
        if (message == null || message.obj == null) {
            ap.a("baidu_location_Client", "setOption, but msg.obj is null");
            return;
        }
        j jVar = (j) message.obj;
        if (this.e.a(jVar)) {
            return;
        }
        if (this.e.d != jVar.d) {
            try {
                synchronized (this.s) {
                    if (this.o) {
                        this.i.removeCallbacks(this.p);
                        this.o = false;
                    }
                    if (jVar.d >= 1000 && !this.o) {
                        if (this.p == null) {
                            this.p = new i(this, null);
                        }
                        this.i.postDelayed(this.p, jVar.d);
                        this.o = true;
                    }
                }
            } catch (Exception e) {
                ap.a("baidu_location_Client", "set location excpetion...");
            }
        }
        this.e = new j(jVar);
        if (this.h == null) {
            ap.a("baidu_location_Client", "server not connected");
            return;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 15);
            obtain.replyTo = this.j;
            obtain.setData(i());
            this.h.send(obtain);
            ap.a("baidu_location_Client", "change option ...");
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        c cVar = (c) message.obj;
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Message obtain = Message.obtain((Handler) null, 28);
        try {
            obtain.replyTo = this.j;
            this.h.send(obtain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        c cVar = (c) message.obj;
        if (this.k == null || !this.k.contains(cVar)) {
            return;
        }
        this.k.remove(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f) {
            return;
        }
        ap.b();
        this.d = this.g.getPackageName();
        this.w = this.d + "_bdls_v2.9";
        ap.a("baidu_location_Client", this.w);
        Intent intent = new Intent(this.g, f.class);
        if (this.e == null) {
            this.e = new j();
        }
        try {
            this.g.bindService(intent, this.A, 1);
        } catch (Exception e) {
            e.printStackTrace();
            this.f = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Message message) {
        a aVar = new a(message.getData().getString("locStr"));
        if (this.v != null) {
            if (this.e != null && this.e.a() && aVar.d() == 65) {
                return;
            }
            this.v.onReceiveLocation(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!this.f || this.h == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 12);
        obtain.replyTo = this.j;
        try {
            this.h.send(obtain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.g.unbindService(this.A);
        synchronized (this.s) {
            try {
                if (this.o) {
                    this.i.removeCallbacks(this.p);
                    this.o = false;
                }
            } catch (Exception e2) {
            }
        }
        this.t.a();
        this.h = null;
        ap.c();
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle i() {
        if (this.e == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packName", this.d);
        bundle.putString("prodName", this.e.f);
        bundle.putString("coorType", this.e.a);
        bundle.putString("addrType", this.e.b);
        bundle.putString("Url", this.x);
        bundle.putBoolean("openGPS", this.e.c);
        bundle.putBoolean("location_change_notify", this.e.h);
        bundle.putInt("scanSpan", this.e.d);
        bundle.putInt("timeOut", this.e.e);
        bundle.putInt("priority", this.e.g);
        bundle.putBoolean("map", this.y.booleanValue());
        bundle.putBoolean("import", this.z.booleanValue());
        return bundle;
    }

    private Bundle j() {
        if (this.e == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("num", this.e.m);
        bundle.putFloat("distance", this.e.l);
        bundle.putBoolean("extraInfo", this.e.k);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.h == null) {
            ap.a("baidu_location_Client", "server not connected");
            return;
        }
        Message obtain = Message.obtain((Handler) null, 22);
        try {
            obtain.replyTo = this.j;
            this.h.send(obtain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.h == null) {
            ap.a("baidu_location_Client", "server not connected");
            return;
        }
        if (!this.q || !this.e.h) {
            Message obtain = Message.obtain((Handler) null, 22);
            try {
                obtain.replyTo = this.j;
                this.h.send(obtain);
                this.b = System.currentTimeMillis();
                this.m = true;
                ap.a("baidu_location_Client", "send request to server...");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        synchronized (this.s) {
            if (this.e != null && this.e.d >= 1000 && !this.o) {
                if (this.p == null) {
                    this.p = new i(this, null);
                }
                this.i.postDelayed(this.p, this.e.d);
                this.o = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.h == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 25);
        try {
            obtain.replyTo = this.j;
            obtain.setData(j());
            this.h.send(obtain);
            this.c = System.currentTimeMillis();
            this.n = true;
            ap.a("baidu_location_Client", "send poi request to server...");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void a() {
        this.i.obtainMessage(11).sendToTarget();
    }

    public void a(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        this.t.a((d) message.obj);
    }

    public void a(c cVar) {
        Message obtainMessage = this.i.obtainMessage(8);
        obtainMessage.obj = cVar;
        obtainMessage.sendToTarget();
    }

    public void a(j jVar) {
        if (jVar == null) {
            jVar = new j();
        }
        Message obtainMessage = this.i.obtainMessage(3);
        obtainMessage.obj = jVar;
        obtainMessage.sendToTarget();
    }

    public int b() {
        if (this.h == null || this.j == null) {
            return 1;
        }
        if (this.k == null || this.k.size() < 1) {
            return 2;
        }
        if (System.currentTimeMillis() - this.b < 1000) {
            return 6;
        }
        ap.a("baidu_location_Client", "request location ...");
        this.i.obtainMessage(4).sendToTarget();
        return 0;
    }

    public void b(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        this.t.b((d) message.obj);
    }

    public void b(c cVar) {
        Message obtainMessage = this.i.obtainMessage(5);
        obtainMessage.obj = cVar;
        obtainMessage.sendToTarget();
    }

    public void c(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        this.v = (c) message.obj;
    }

    public boolean c() {
        return this.f;
    }

    public void d() {
        this.i.obtainMessage(1).sendToTarget();
    }

    public void e() {
        this.i.obtainMessage(2).sendToTarget();
    }
}
