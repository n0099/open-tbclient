package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.pushservice.g.m;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.jni.PushSocket;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public final class d {
    private static int c = -1;
    private static Boolean e = false;
    private static volatile d m;
    com.baidu.android.pushservice.message.d b;
    private b g;
    private a h;
    private Context k;
    private boolean n;
    private int p;
    private Thread q;
    private int v;
    private String y;
    private boolean d = false;
    private boolean f = false;
    private boolean i = false;
    private int j = 0;
    Handler a = new Handler();
    private boolean l = true;
    private String o = g.c();
    private Runnable r = new Runnable() { // from class: com.baidu.android.pushservice.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.i();
        }
    };
    private Runnable s = new Runnable() { // from class: com.baidu.android.pushservice.d.3
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.android.pushservice.f.a.c("PushConnection", " -- Send Timeout --", d.this.k.getApplicationContext());
            if (d.this.n) {
                d.this.n = false;
            }
            d.this.a(false);
            d.this.j();
            l.b("PushConnection Send Timeout " + d.this.k.getPackageName() + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + d.c + System.currentTimeMillis(), d.this.k.getApplicationContext());
        }
    };
    private long t = 0;
    private final int[] u = {SubsamplingScaleImageView.ORIENTATION_180, 300, 360, HttpStatus.SC_METHOD_FAILURE, 540, 720, 900};
    private int w = 0;
    private int x = 0;

    /* loaded from: classes3.dex */
    class a extends Thread {
        a() {
            setName("PushService-PushConnection-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            byte[] bArr;
            while (!d.this.f) {
                try {
                    bArr = PushSocket.a(d.this.k, d.c);
                } catch (Exception e) {
                    bArr = null;
                    com.baidu.android.pushservice.f.a.b("PushConnection", "Get message exception", d.this.k.getApplicationContext());
                    m.a(d.this.k, e);
                }
                d.this.a.removeCallbacks(d.this.s);
                if (d.this.n) {
                    d.this.n = false;
                    d.this.a(true);
                }
                if (bArr == null || bArr.length == 0) {
                    int lastSocketError = PushSocket.getLastSocketError();
                    com.baidu.android.pushservice.f.a.a("PushConnection", "Receive err,errno:" + lastSocketError, d.this.k.getApplicationContext());
                    d.this.a("039913", lastSocketError);
                    d.this.j();
                    l.b("PushConnection Receive err " + d.this.k.getPackageName() + " lastSocketError " + lastSocketError + " socketfd " + d.c + System.currentTimeMillis(), d.this.k.getApplicationContext());
                } else {
                    try {
                        com.baidu.android.pushservice.message.e a = d.this.b.a(bArr, bArr.length);
                        if (a != null) {
                            try {
                                d.this.b.b(a);
                            } catch (Exception e2) {
                                com.baidu.android.pushservice.f.a.b("PushConnection", "Handle message exception " + l.a(e2), d.this.k.getApplicationContext());
                                l.b("PushConnection Handle message exception " + d.this.k.getPackageName() + l.a(e2) + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + d.c + System.currentTimeMillis(), d.this.k.getApplicationContext());
                                d.this.j();
                            }
                        }
                        d.this.j = 0;
                    } catch (Exception e3) {
                        com.baidu.android.pushservice.f.a.c("PushConnection", "Read message exception " + l.a(e3), d.this.k.getApplicationContext());
                        d.this.j();
                        l.b("PushConnection Read message exception " + d.this.k.getPackageName() + l.a(e3) + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + d.c + System.currentTimeMillis(), d.this.k.getApplicationContext());
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    class b extends Thread {
        b() {
            setName("PushService-PushConnection-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            com.baidu.android.pushservice.message.e removeFirst;
            int i;
            while (!d.this.f) {
                synchronized (d.this.b.a()) {
                    if (d.this.b.a().size() == 0) {
                        try {
                            d.this.b.a().wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    removeFirst = d.this.b.a().size() > 0 ? d.this.b.a().removeFirst() : null;
                }
                if (d.this.f) {
                    return;
                }
                if (removeFirst != null && removeFirst.a() != null) {
                    if (removeFirst.b()) {
                        if (removeFirst.c()) {
                            d.this.n = true;
                        } else {
                            d.this.n = false;
                        }
                        d.this.a.removeCallbacks(d.this.s);
                        d.this.a.postDelayed(d.this.s, 60000L);
                    }
                    try {
                        i = PushSocket.sendMsg(d.c, removeFirst.a(), removeFirst.a().length);
                    } catch (Exception e2) {
                        i = -1;
                    }
                    if (i == -1) {
                        d.this.j();
                        l.b("PushConnection sendMsg err " + d.this.k.getPackageName() + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + d.c + System.currentTimeMillis(), d.this.k.getApplicationContext());
                    }
                }
            }
        }
    }

    private d(Context context) {
        this.p = 0;
        this.v = 0;
        this.k = context;
        int g = g();
        if (g >= 0 && g < this.u.length) {
            this.v = g;
        }
        b(context);
        f.a(this.k).a(this.u[this.v]);
        this.y = com.baidu.android.pushservice.i.g.d(this.k);
        this.p = g.a(this.k);
    }

    public static d a(Context context) {
        if (m == null) {
            m = new d(context);
        }
        return m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final int i) {
        com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("insertAgentBehavior", (short) 95) { // from class: com.baidu.android.pushservice.d.5
            @Override // com.baidu.android.pushservice.h.c
            public void a() {
                try {
                    com.baidu.android.pushservice.g.f fVar = new com.baidu.android.pushservice.g.f();
                    fVar.d = str;
                    fVar.e = System.currentTimeMillis();
                    fVar.f = com.baidu.android.pushservice.g.a.b.b(d.this.k);
                    fVar.g = i;
                    if (str.equals("030303")) {
                        fVar.i = l.w(d.this.k);
                    } else if (str.equals("030301")) {
                        fVar.i = l.x(d.this.k);
                    }
                    m.b(d.this.k, fVar);
                } catch (Exception e2) {
                    com.baidu.android.pushservice.f.a.c("PushConnection", "insertAgent exception", d.this.k.getApplicationContext());
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(Context context) {
        FileInputStream fileInputStream;
        if (!context.getPackageName().startsWith("com.baidu.push")) {
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/pushservice/pushservice.cfg");
        if (!file.exists()) {
            return;
        }
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    properties.load(fileInputStream);
                    String property = properties.getProperty("rtcseed");
                    if (property != null && property.length() > 0) {
                        JSONArray jSONArray = new JSONArray(property);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            this.u[i] = jSONArray.getInt(i);
                            this.v = 0;
                            this.w = 0;
                            this.x = 0;
                        }
                    }
                    String property2 = properties.getProperty("originseed");
                    if (property2 != null && property2.length() > 0) {
                        this.v = Integer.parseInt(property2);
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            com.baidu.android.pushservice.f.a.b("PushConnection", "error " + e2.getMessage(), this.k.getApplicationContext());
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    com.baidu.android.pushservice.f.a.b("PushConnection", "getTestConfig exception " + e.getMessage(), this.k.getApplicationContext());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            com.baidu.android.pushservice.f.a.b("PushConnection", "error " + e4.getMessage(), this.k.getApplicationContext());
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        com.baidu.android.pushservice.f.a.b("PushConnection", "error " + e5.getMessage(), this.k.getApplicationContext());
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        if (this.d || e.booleanValue()) {
            com.baidu.android.pushservice.f.a.c("PushConnection", "Connect return. mConnected:" + this.d + " mConnectting:" + e, this.k.getApplicationContext());
        } else if (i.a(this.k).e()) {
            l.b("PushConnection connectImpl from " + this.k.getPackageName() + " at Time " + System.currentTimeMillis(), this.k);
            e = true;
            c = -1;
            Runnable runnable = new Runnable() { // from class: com.baidu.android.pushservice.d.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        int unused = d.c = PushSocket.createSocket(d.this.o, d.this.p);
                    } catch (Exception e2) {
                    }
                    if (d.c == -1 || d.c == -2) {
                        int i = 132;
                        try {
                            i = PushSocket.getLastSocketError();
                        } catch (Exception e3) {
                        }
                        com.baidu.android.pushservice.f.a.b("PushConnection", "Create socket err, errno: " + i + "socketfd: " + d.c, d.this.k.getApplicationContext());
                        if (g.c().equals(d.this.o)) {
                            d.this.a("030301", i);
                        } else {
                            d.this.a("030303", 10002);
                        }
                        if (d.c == -2) {
                            String a2 = g.a(d.this.k, d.this.l);
                            d.this.l = false;
                            if (!TextUtils.isEmpty(a2)) {
                                d.this.o = a2;
                            }
                        }
                        if (d.c == -1 && i == 110) {
                            d.this.p = 80;
                        }
                        Boolean unused2 = d.e = false;
                        d.this.j();
                        l.b("PushConnection Create socket err " + d.this.k.getPackageName() + " lastSocketError " + i + " socketfd " + d.c + System.currentTimeMillis(), d.this.k.getApplicationContext());
                        return;
                    }
                    com.baidu.android.pushservice.f.a.a("PushConnection", "create Socket ok", d.this.k.getApplicationContext());
                    l.b("create Socket ok socketfd" + d.c, d.this.k);
                    d.this.b = new com.baidu.android.pushservice.message.f(d.this.k.getApplicationContext());
                    d.this.d = true;
                    if (d.this.h != null) {
                        d.this.h.interrupt();
                    }
                    if (d.this.g != null) {
                        d.this.g.interrupt();
                    }
                    d.this.f = false;
                    d.this.h = new a();
                    d.this.h.start();
                    d.this.g = new b();
                    d.this.g.start();
                    d.this.b.a(d.c);
                    if (!g.c().equals(d.this.o)) {
                        d.this.a("030302", 0);
                    }
                    Boolean unused3 = d.e = false;
                    d.this.l = true;
                    d.this.o = g.c();
                    g.c(d.this.k);
                }
            };
            if (this.q != null) {
                this.q.interrupt();
            }
            this.q = new Thread(runnable);
            this.q.setName("PushService-PushService-connect");
            this.q.start();
        } else {
            com.baidu.android.pushservice.f.a.a("PushConnection", "re-token", this.k.getApplicationContext());
            f.a(this.k).d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        com.baidu.android.pushservice.f.a.c("PushConnection", "disconnectedByPeer, mStoped == " + this.i, this.k.getApplicationContext());
        l.b("PushConnection destroy from " + this.k.getPackageName() + " at Time " + System.currentTimeMillis(), this.k);
        k();
        if (this.i) {
            return;
        }
        this.j++;
        if (this.j < 3) {
            this.a.removeCallbacks(this.r);
            int i = (this.j - 1) * 30 * 1000;
            if (this.j == 1) {
                i = 3000;
            }
            if (com.baidu.android.pushservice.a.d(this.k)) {
                if (this.k.getPackageName().equals(l.v(this.k))) {
                    com.baidu.android.pushservice.a.c(this.k, false);
                }
            }
            this.a.postDelayed(this.r, i);
            com.baidu.android.pushservice.f.a.c("PushConnection", "Schedule retry-- retry times: " + this.j + " time delay: " + i, this.k.getApplicationContext());
        }
    }

    private void k() {
        com.baidu.android.pushservice.f.a.c("PushConnection", "destroy", this.k.getApplicationContext());
        if (this.a != null) {
            this.a.removeCallbacks(this.s);
        }
        this.f = true;
        this.d = false;
        if (this.b != null) {
            try {
                synchronized (this.b.a()) {
                    this.b.a().notifyAll();
                }
            } catch (Exception e2) {
                m.a(this.k, e2);
            }
        }
        PushSocket.a(c);
        if (this.b != null) {
            this.b.b();
        }
    }

    public void a(boolean z) {
        String d = com.baidu.android.pushservice.i.g.d(this.k);
        if (TextUtils.equals(this.y, d)) {
            int e2 = e();
            if (!z) {
                this.w = 0;
                this.x = 0;
                if (!com.baidu.android.pushservice.i.g.a(this.k)) {
                    this.v++;
                } else if (this.v > 0) {
                    this.v--;
                    f();
                }
            } else if (com.baidu.android.pushservice.i.g.a(this.k)) {
                f();
                this.w++;
                if (this.w >= 3) {
                    this.w = 0;
                    if (this.v < this.u.length - 1) {
                        this.w = 0;
                        this.v++;
                    }
                }
                if (this.x >= 30) {
                    this.x = 0;
                    com.baidu.android.pushservice.g.f fVar = new com.baidu.android.pushservice.g.f();
                    fVar.d = "030101";
                    fVar.e = System.currentTimeMillis();
                    fVar.f = com.baidu.android.pushservice.g.a.b.b(this.k);
                    fVar.a = e();
                    m.a(this.k, fVar);
                }
            } else {
                this.v++;
            }
            l.b("RTC stat change from " + e2 + " to " + e(), this.k);
        } else {
            this.v = g();
            this.w = 0;
            l.b("RTC stat change " + e() + " because of network changing", this.k);
        }
        this.y = d;
        f.a(this.k).a(e());
    }

    public boolean a() {
        return this.d;
    }

    public void b() {
        this.j = 0;
        this.i = false;
        i();
    }

    public void c() {
        com.baidu.android.pushservice.f.a.c("PushConnection", "---stop---", this.k.getApplicationContext());
        l.b("PushConnection stop from " + this.k.getPackageName() + " at Time " + System.currentTimeMillis(), this.k);
        this.f = true;
        this.i = true;
        this.a.removeCallbacks(this.r);
        k();
        m = null;
    }

    public void d() {
        if (this.b != null) {
            if (System.currentTimeMillis() - this.t >= 60000) {
                com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("heartbeat", (short) 98) { // from class: com.baidu.android.pushservice.d.4
                    @Override // com.baidu.android.pushservice.h.c
                    public void a() {
                        long currentTimeMillis = System.currentTimeMillis();
                        int i = (int) ((currentTimeMillis / 60000) % 5);
                        int i2 = ((int) (currentTimeMillis / 1000)) % 60;
                        if (i == 0 && i2 < 15) {
                            try {
                                Thread.sleep((long) (Math.random() * 60.0d * 1000.0d));
                            } catch (InterruptedException e2) {
                            }
                        }
                        d.this.b.c();
                        d.this.t = System.currentTimeMillis();
                        com.baidu.android.pushservice.f.a.c("PushConnection", "sendHeartbeatMessage", d.this.k.getApplicationContext());
                    }
                });
            } else {
                com.baidu.android.pushservice.f.a.c("PushConnection", "sendHeartbeatMessage ingnored， because too frequent.", this.k.getApplicationContext());
            }
        }
    }

    public int e() {
        if (this.v < 0) {
            this.v = 0;
        } else if (this.v >= this.u.length) {
            this.v = this.u.length - 1;
        }
        return this.u[this.v];
    }

    public void f() {
        if (com.baidu.android.pushservice.i.g.b(this.k)) {
            com.baidu.android.pushservice.i.i.a(this.k, "com.baidu.pushservice.CUR_PERIOD_WIFI", this.v);
        } else {
            com.baidu.android.pushservice.i.i.a(this.k, "com.baidu.pushservice.CUR_PERIOD_MOBILE", this.v);
        }
    }

    public int g() {
        if (com.baidu.android.pushservice.i.g.a(this.k)) {
            return com.baidu.android.pushservice.i.g.b(this.k) ? com.baidu.android.pushservice.i.i.b(this.k, "com.baidu.pushservice.CUR_PERIOD_WIFI", 0) : com.baidu.android.pushservice.i.i.b(this.k, "com.baidu.pushservice.CUR_PERIOD_MOBILE", 0);
        }
        return 0;
    }
}
