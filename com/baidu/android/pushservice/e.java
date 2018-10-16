package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.pushservice.h.o;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.jni.PushSocket;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public final class e {
    private static int c = -1;
    private static Boolean e = false;
    private static volatile e n;
    private String B;
    com.baidu.android.pushservice.message.d b;
    private b h;
    private a i;
    private Context l;
    private boolean o;
    private int q;
    private Thread r;
    private int w;
    private boolean d = false;
    private boolean f = false;
    private HashMap<Long, com.baidu.android.pushservice.e.a> g = new HashMap<>();
    private boolean j = false;
    private int k = 0;
    Handler a = new Handler();
    private boolean m = true;
    private String p = h.c();
    private Runnable s = new Runnable() { // from class: com.baidu.android.pushservice.e.2
        @Override // java.lang.Runnable
        public void run() {
            e.this.i();
        }
    };
    private Runnable t = new Runnable() { // from class: com.baidu.android.pushservice.e.3
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.android.pushservice.g.a.c("PushConnection", " -- Send Timeout --", e.this.l.getApplicationContext());
            if (e.this.o) {
                e.this.o = false;
            }
            e.this.a(false);
            e.this.j();
            m.b("PushConnection Send Timeout " + e.this.l.getPackageName() + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + e.c + System.currentTimeMillis(), e.this.l.getApplicationContext());
        }
    };
    private long u = 0;
    private int[] v = {180, 300, 360, HttpStatus.SC_METHOD_FAILURE, 540, 720, 900};
    private int x = 0;
    private final int y = 3;
    private int z = 0;
    private final int A = 30;

    /* loaded from: classes3.dex */
    class a extends Thread {
        a() {
            setName("PushService-PushConnection-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            byte[] bArr;
            while (!e.this.f) {
                try {
                    bArr = PushSocket.a(e.this.l, e.c);
                } catch (Exception e) {
                    bArr = null;
                    if (com.baidu.android.pushservice.a.b() > 0) {
                        o.a(e.this.l, "039908", PushSocket.getLastSocketError(), m.a(e));
                    }
                    com.baidu.android.pushservice.g.a.b("PushConnection", "Get message exception", e.this.l.getApplicationContext());
                    o.a(e.this.l, e);
                }
                e.this.a.removeCallbacks(e.this.t);
                if (e.this.o) {
                    e.this.o = false;
                    e.this.a(true);
                }
                if (bArr == null || bArr.length == 0) {
                    int lastSocketError = PushSocket.getLastSocketError();
                    com.baidu.android.pushservice.g.a.a("PushConnection", "Receive err,errno:" + lastSocketError, e.this.l.getApplicationContext());
                    e.this.a("039913", lastSocketError);
                    e.this.j();
                    m.b("PushConnection Receive err " + e.this.l.getPackageName() + " lastSocketError " + lastSocketError + " socketfd " + e.c + System.currentTimeMillis(), e.this.l.getApplicationContext());
                } else {
                    try {
                        com.baidu.android.pushservice.message.e a = e.this.b.a(bArr, bArr.length);
                        if (a != null) {
                            try {
                                e.this.b.b(a);
                            } catch (Exception e2) {
                                com.baidu.android.pushservice.g.a.b("PushConnection", "Handle message exception " + m.a(e2), e.this.l.getApplicationContext());
                                m.b("PushConnection Handle message exception " + e.this.l.getPackageName() + m.a(e2) + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + e.c + System.currentTimeMillis(), e.this.l.getApplicationContext());
                                if (com.baidu.android.pushservice.a.b() > 0) {
                                    o.a(e.this.l, "039910", PushSocket.getLastSocketError(), m.a(e2));
                                }
                                e.this.j();
                            }
                        }
                        e.this.k = 0;
                    } catch (Exception e3) {
                        com.baidu.android.pushservice.g.a.c("PushConnection", "Read message exception " + m.a(e3), e.this.l.getApplicationContext());
                        if (com.baidu.android.pushservice.a.b() > 0) {
                            o.a(e.this.l, "039909", PushSocket.getLastSocketError(), m.a(e3));
                        }
                        e.this.j();
                        m.b("PushConnection Read message exception " + e.this.l.getPackageName() + m.a(e3) + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + e.c + System.currentTimeMillis(), e.this.l.getApplicationContext());
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
            while (!e.this.f) {
                synchronized (e.this.b.a()) {
                    if (e.this.b.a().size() == 0) {
                        try {
                            e.this.b.a().wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    removeFirst = e.this.b.a().size() > 0 ? e.this.b.a().removeFirst() : null;
                }
                if (e.this.f) {
                    return;
                }
                if (removeFirst != null && removeFirst.a() != null) {
                    if (removeFirst.b()) {
                        if (removeFirst.c()) {
                            e.this.o = true;
                        } else {
                            e.this.o = false;
                        }
                        e.this.a.removeCallbacks(e.this.t);
                        e.this.a.postDelayed(e.this.t, 60000L);
                    }
                    try {
                        i = PushSocket.sendMsg(e.c, removeFirst.a(), removeFirst.a().length);
                    } catch (Exception e2) {
                        i = -1;
                    }
                    if (i == -1) {
                        e.this.j();
                        m.b("PushConnection sendMsg err " + e.this.l.getPackageName() + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + e.c + System.currentTimeMillis(), e.this.l.getApplicationContext());
                    }
                }
            }
        }
    }

    private e(Context context) {
        this.q = 0;
        this.w = 0;
        this.l = context;
        int g = g();
        if (g >= 0 && g < this.v.length) {
            this.w = g;
        }
        m();
        g.a(this.l).a(this.v[this.w]);
        this.B = com.baidu.android.pushservice.j.h.d(this.l);
        this.q = h.a(this.l);
    }

    public static e a(Context context) {
        if (n == null) {
            n = new e(context);
        }
        return n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final int i) {
        com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("insertAgentBehavior", (short) 95) { // from class: com.baidu.android.pushservice.e.5
            @Override // com.baidu.android.pushservice.i.c
            public void a() {
                try {
                    com.baidu.android.pushservice.h.h hVar = new com.baidu.android.pushservice.h.h();
                    hVar.d = str;
                    hVar.e = System.currentTimeMillis();
                    hVar.f = com.baidu.android.pushservice.h.a.b.b(e.this.l);
                    hVar.g = i;
                    if (str.equals("030303")) {
                        hVar.i = m.w(e.this.l);
                    } else if (str.equals("030301")) {
                        hVar.i = m.x(e.this.l);
                    }
                    o.b(e.this.l, hVar);
                } catch (Exception e2) {
                    com.baidu.android.pushservice.g.a.c("PushConnection", "insertAgent exception", e.this.l.getApplicationContext());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        if (this.d || e.booleanValue()) {
            com.baidu.android.pushservice.g.a.c("PushConnection", "Connect return. mConnected:" + this.d + " mConnectting:" + e, this.l.getApplicationContext());
        } else if (j.a(this.l).e()) {
            m.b("PushConnection connectImpl from " + this.l.getPackageName() + " at Time " + System.currentTimeMillis(), this.l);
            e = true;
            c = -1;
            Runnable runnable = new Runnable() { // from class: com.baidu.android.pushservice.e.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        int unused = e.c = PushSocket.createSocket(e.this.p, e.this.q);
                    } catch (Exception e2) {
                    }
                    if (com.baidu.android.pushservice.a.b() > 0) {
                        com.baidu.android.pushservice.h.h hVar = new com.baidu.android.pushservice.h.h();
                        hVar.d = "039907";
                        hVar.e = System.currentTimeMillis();
                        hVar.f = com.baidu.android.pushservice.h.a.b.b(e.this.l);
                        if (e.c >= 0) {
                            hVar.g = 0;
                        } else {
                            hVar.g = e.c;
                        }
                        o.b(e.this.l, hVar);
                    }
                    if (e.c == -1 || e.c == -2) {
                        int i = 132;
                        try {
                            i = PushSocket.getLastSocketError();
                        } catch (Exception e3) {
                        }
                        com.baidu.android.pushservice.g.a.b("PushConnection", "Create socket err, errno: " + i + "socketfd: " + e.c, e.this.l.getApplicationContext());
                        if (h.c().equals(e.this.p)) {
                            e.this.a("030301", i);
                        } else {
                            e.this.a("030303", 10002);
                        }
                        if (e.c == -2) {
                            String a2 = h.a(e.this.l, e.this.m);
                            e.this.m = false;
                            if (!TextUtils.isEmpty(a2)) {
                                e.this.p = a2;
                            }
                        }
                        if (e.c == -1 && i == 110) {
                            e.this.q = 80;
                        }
                        Boolean unused2 = e.e = false;
                        e.this.j();
                        m.b("PushConnection Create socket err " + e.this.l.getPackageName() + " lastSocketError " + i + " socketfd " + e.c + System.currentTimeMillis(), e.this.l.getApplicationContext());
                        return;
                    }
                    com.baidu.android.pushservice.g.a.a("PushConnection", "create Socket ok", e.this.l.getApplicationContext());
                    m.b("create Socket ok socketfd" + e.c, e.this.l);
                    e.this.b = new com.baidu.android.pushservice.message.f(e.this.l.getApplicationContext());
                    e.this.d = true;
                    if (e.this.i != null) {
                        e.this.i.interrupt();
                    }
                    if (e.this.h != null) {
                        e.this.h.interrupt();
                    }
                    e.this.f = false;
                    e.this.i = new a();
                    e.this.i.start();
                    e.this.h = new b();
                    e.this.h.start();
                    e.this.b.a(e.c);
                    if (!h.c().equals(e.this.p)) {
                        e.this.a("030302", 0);
                    }
                    Boolean unused3 = e.e = false;
                    e.this.m = true;
                    e.this.p = h.c();
                    h.c(e.this.l);
                }
            };
            if (this.r != null) {
                this.r.interrupt();
            }
            this.r = new Thread(runnable);
            this.r.setName("PushService-PushService-connect");
            this.r.start();
        } else {
            com.baidu.android.pushservice.g.a.a("PushConnection", "re-token", this.l.getApplicationContext());
            g.a(this.l).d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        com.baidu.android.pushservice.g.a.c("PushConnection", "disconnectedByPeer, mStoped == " + this.j, this.l.getApplicationContext());
        m.b("PushConnection destroy from " + this.l.getPackageName() + " at Time " + System.currentTimeMillis(), this.l);
        k();
        if (this.j) {
            return;
        }
        this.k++;
        if (this.k < 3) {
            this.a.removeCallbacks(this.s);
            int i = (this.k - 1) * 30 * 1000;
            if (this.k == 1) {
                i = 3000;
            }
            if (com.baidu.android.pushservice.a.d(this.l)) {
                if (this.l.getPackageName().equals(m.v(this.l))) {
                    com.baidu.android.pushservice.a.c(this.l, false);
                }
            }
            this.a.postDelayed(this.s, i);
            com.baidu.android.pushservice.g.a.c("PushConnection", "Schedule retry-- retry times: " + this.k + " time delay: " + i, this.l.getApplicationContext());
        }
    }

    private void k() {
        com.baidu.android.pushservice.g.a.c("PushConnection", "destroy", this.l.getApplicationContext());
        if (this.a != null) {
            this.a.removeCallbacks(this.t);
        }
        this.f = true;
        this.d = false;
        if (this.b != null) {
            try {
                synchronized (this.b.a()) {
                    this.b.a().notifyAll();
                }
            } catch (Exception e2) {
                o.a(this.l, e2);
            }
        }
        PushSocket.a(c);
        if (this.b != null) {
            this.b.b();
        }
    }

    private void l() {
        Set<Long> keySet = this.g.keySet();
        long currentTimeMillis = System.currentTimeMillis();
        i c2 = g.a(this.l).c();
        if (c2 != null) {
            for (Long l : keySet) {
                long longValue = l.longValue();
                if (longValue < currentTimeMillis) {
                    c2.a(this.g.get(Long.valueOf(longValue)));
                    this.g.remove(Long.valueOf(longValue));
                }
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0110 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.FileInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m() {
        FileInputStream fileInputStream;
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/pushservice/pushservice.cfg");
        ?? exists = file.exists();
        if (exists == 0) {
            return;
        }
        Properties properties = new Properties();
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    String property = properties.getProperty("rtcseed");
                    if (property != null && property.length() > 0) {
                        JSONArray jSONArray = new JSONArray(property);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            this.v[i] = jSONArray.getInt(i);
                            this.w = 0;
                            this.x = 0;
                            this.z = 0;
                        }
                    }
                    String property2 = properties.getProperty("originseed");
                    if (property2 != null && property2.length() > 0) {
                        this.w = Integer.parseInt(property2);
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            com.baidu.android.pushservice.g.a.b("PushConnection", "error " + e2.getMessage(), this.l.getApplicationContext());
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    com.baidu.android.pushservice.g.a.b("PushConnection", "getTestConfig exception " + e.getMessage(), this.l.getApplicationContext());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            com.baidu.android.pushservice.g.a.b("PushConnection", "error " + e4.getMessage(), this.l.getApplicationContext());
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (exists != 0) {
                    try {
                        exists.close();
                    } catch (IOException e5) {
                        com.baidu.android.pushservice.g.a.b("PushConnection", "error " + e5.getMessage(), this.l.getApplicationContext());
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            exists = 0;
            if (exists != 0) {
            }
            throw th;
        }
    }

    public void a(boolean z) {
        String d = com.baidu.android.pushservice.j.h.d(this.l);
        if (TextUtils.equals(this.B, d)) {
            int e2 = e();
            if (!z) {
                this.x = 0;
                this.z = 0;
                if (!com.baidu.android.pushservice.j.h.a(this.l)) {
                    this.w++;
                } else if (this.w > 0) {
                    this.w--;
                    f();
                }
            } else if (com.baidu.android.pushservice.j.h.a(this.l)) {
                f();
                this.x++;
                if (this.x >= 3) {
                    this.x = 0;
                    if (this.w < this.v.length - 1) {
                        this.x = 0;
                        this.w++;
                    }
                }
                if (this.z >= 30) {
                    this.z = 0;
                    com.baidu.android.pushservice.h.h hVar = new com.baidu.android.pushservice.h.h();
                    hVar.d = "030101";
                    hVar.e = System.currentTimeMillis();
                    hVar.f = com.baidu.android.pushservice.h.a.b.b(this.l);
                    hVar.a = e();
                    o.a(this.l, hVar);
                }
            } else {
                this.w++;
            }
            m.b("RTC stat change from " + e2 + " to " + e(), this.l);
        } else {
            this.w = g();
            this.x = 0;
            m.b("RTC stat change " + e() + " because of network changing", this.l);
        }
        this.B = d;
        g.a(this.l).a(e());
    }

    public boolean a() {
        return this.d;
    }

    public void b() {
        this.k = 0;
        this.j = false;
        i();
    }

    public void c() {
        com.baidu.android.pushservice.g.a.c("PushConnection", "---stop---", this.l.getApplicationContext());
        m.b("PushConnection stop from " + this.l.getPackageName() + " at Time " + System.currentTimeMillis(), this.l);
        this.f = true;
        this.j = true;
        this.a.removeCallbacks(this.s);
        k();
        n = null;
    }

    public void d() {
        if (this.b != null) {
            if (System.currentTimeMillis() - this.u > 120000) {
                com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("heartbeat", (short) 98) { // from class: com.baidu.android.pushservice.e.4
                    @Override // com.baidu.android.pushservice.i.c
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
                        e.this.b.c();
                        e.this.u = System.currentTimeMillis();
                        com.baidu.android.pushservice.g.a.c("PushConnection", "sendHeartbeatMessage", e.this.l.getApplicationContext());
                    }
                });
            } else {
                com.baidu.android.pushservice.g.a.c("PushConnection", "sendHeartbeatMessage ingnored， because too frequent.", this.l.getApplicationContext());
            }
        }
        l();
    }

    public int e() {
        if (this.w < 0) {
            this.w = 0;
        } else if (this.w >= this.v.length) {
            this.w = this.v.length - 1;
        }
        return this.v[this.w];
    }

    public void f() {
        if (com.baidu.android.pushservice.j.h.b(this.l)) {
            com.baidu.android.pushservice.j.j.a(this.l, "com.baidu.pushservice.CUR_PERIOD_WIFI", this.w);
        } else {
            com.baidu.android.pushservice.j.j.a(this.l, "com.baidu.pushservice.CUR_PERIOD_MOBILE", this.w);
        }
    }

    public int g() {
        if (com.baidu.android.pushservice.j.h.a(this.l)) {
            return com.baidu.android.pushservice.j.h.b(this.l) ? com.baidu.android.pushservice.j.j.b(this.l, "com.baidu.pushservice.CUR_PERIOD_WIFI", 0) : com.baidu.android.pushservice.j.j.b(this.l, "com.baidu.pushservice.CUR_PERIOD_MOBILE", 0);
        }
        return 0;
    }
}
