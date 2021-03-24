package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.c;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.rtc.PeerConnectionClient;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: c  reason: collision with root package name */
    public static Boolean f2980c = Boolean.FALSE;
    public static volatile e n = null;
    public static int w = 2;
    public int B;
    public String E;

    /* renamed from: f  reason: collision with root package name */
    public b f2985f;

    /* renamed from: g  reason: collision with root package name */
    public a f2986g;
    public long i;
    public int j;
    public final Handler k;
    public final Context l;
    public com.baidu.android.pushservice.message.d m;
    public boolean o;
    public boolean p;
    public String q;
    public String r;
    public int s;
    public Thread t;
    public boolean v;

    /* renamed from: a  reason: collision with root package name */
    public volatile int f2981a = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2982b = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f2983d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2984e = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2987h = false;
    public List<String> u = Collections.synchronizedList(new ArrayList());
    public Runnable x = new Runnable() { // from class: com.baidu.android.pushservice.e.4
        @Override // java.lang.Runnable
        public void run() {
            e.this.i();
        }
    };
    public Runnable y = new Runnable() { // from class: com.baidu.android.pushservice.e.5
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.android.pushservice.g.a.c("PushConnection", " -- Send Timeout --", e.this.l.getApplicationContext());
            if (e.this.o) {
                e.this.o = false;
            }
            e.this.a(false);
            e.this.a(10004);
            e.this.j();
            m.a("PushConnection Send Timeout " + e.this.l.getPackageName() + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + e.this.f2981a + System.currentTimeMillis(), e.this.l.getApplicationContext());
        }
    };
    public long z = 0;
    public final int[] A = {180, 300, 360, HttpStatus.SC_METHOD_FAILURE, 540, PeerConnectionClient.HD_VIDEO_HEIGHT, 900};
    public int C = 0;
    public int D = 0;

    /* loaded from: classes2.dex */
    public class a extends Thread {
        public a() {
            setName("PushService-PushConnection-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            byte[] bArr;
            String str;
            while (!e.this.f2984e) {
                try {
                    bArr = PushSocket.a(e.this.l, e.this.f2981a);
                } catch (Exception e2) {
                    com.baidu.android.pushservice.g.a.b("PushConnection", "Get message exception", e.this.l.getApplicationContext());
                    new b.c(e.this.l).a(Log.getStackTraceString(e2)).a();
                    bArr = null;
                }
                e.this.k.removeCallbacks(e.this.y);
                if (e.this.o) {
                    e.this.o = false;
                    e.this.a(true);
                }
                if (e.this.p) {
                    e.this.p = false;
                }
                int lastSocketError = PushSocket.getLastSocketError();
                if (bArr == null || bArr.length == 0) {
                    e.this.a(lastSocketError);
                    e.this.j();
                    str = "PushConnection Receive err " + e.this.l.getPackageName() + " lastSocketError " + lastSocketError + " socketfd " + e.this.f2981a + System.currentTimeMillis();
                } else {
                    try {
                        com.baidu.android.pushservice.message.e a2 = e.this.m.a(bArr);
                        if (a2 != null) {
                            try {
                                e.this.m.b(a2);
                            } catch (Exception e3) {
                                com.baidu.android.pushservice.g.a.b("PushConnection", "Handle message exception " + m.a(e3), e.this.l.getApplicationContext());
                                m.a("PushConnection Handle message exception " + e.this.l.getPackageName() + m.a(e3) + " lastSocketError " + lastSocketError + " socketfd " + e.this.f2981a + System.currentTimeMillis(), e.this.l.getApplicationContext());
                                new b.c(e.this.l).a(Log.getStackTraceString(e3)).a();
                                e.this.j();
                            }
                        }
                        e.this.j = 0;
                    } catch (Exception e4) {
                        com.baidu.android.pushservice.g.a.c("PushConnection", "Read message exception " + m.a(e4), e.this.l.getApplicationContext());
                        new b.c(e.this.l).a(Log.getStackTraceString(e4)).a();
                        e.this.a(lastSocketError);
                        e.this.j();
                        str = "PushConnection Read message exception " + e.this.l.getPackageName() + m.a(e4) + " lastSocketError " + lastSocketError + " socketfd " + e.this.f2981a + System.currentTimeMillis();
                    }
                }
                m.a(str, e.this.l.getApplicationContext());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends Thread {
        public b() {
            setName("PushService-PushConnection-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            com.baidu.android.pushservice.message.e removeFirst;
            int i;
            while (!e.this.f2984e) {
                synchronized (e.this.m.a()) {
                    if (e.this.m.a().size() == 0) {
                        try {
                            e.this.m.a().wait();
                        } catch (InterruptedException e2) {
                            new b.c(e.this.l).a(Log.getStackTraceString(e2)).a();
                        }
                    }
                    removeFirst = e.this.m.a().size() > 0 ? e.this.m.a().removeFirst() : null;
                }
                if (e.this.f2984e) {
                    return;
                }
                if (removeFirst != null && removeFirst.b() != null) {
                    if (removeFirst.c()) {
                        e.this.o = removeFirst.d();
                        if (com.baidu.android.pushservice.message.h.a(removeFirst.a()) == com.baidu.android.pushservice.message.h.MSG_ID_HANDSHAKE) {
                            e.this.p = true;
                        }
                        e.this.k.removeCallbacks(e.this.y);
                        e.this.k.postDelayed(e.this.y, 60000L);
                    }
                    try {
                        i = PushSocket.a(e.this.f2981a, removeFirst.b(), removeFirst.b().length);
                    } catch (Exception e3) {
                        new b.c(e.this.l).a(Log.getStackTraceString(e3)).a();
                        i = -1;
                    }
                    if (i == -1) {
                        int lastSocketError = PushSocket.getLastSocketError();
                        e.this.a(lastSocketError);
                        e.this.j();
                        m.a("PushConnection sendMsg err " + e.this.l.getPackageName() + " lastSocketError " + lastSocketError + " socketfd " + e.this.f2981a + System.currentTimeMillis(), e.this.l.getApplicationContext());
                    }
                }
            }
        }
    }

    public e(Context context) {
        this.v = false;
        this.B = 0;
        this.l = context;
        this.k = new Handler(context.getMainLooper());
        int g2 = g();
        if (g2 >= 0 && g2 < this.A.length) {
            this.B = g2;
        }
        b(context);
        g.a(this.l).a(this.A[this.B] * 1000);
        this.E = com.baidu.android.pushservice.j.g.i(this.l);
        this.q = h.d();
        this.s = h.a(this.l);
        this.v = false;
    }

    public static e a(Context context) {
        if (n == null) {
            synchronized (e.class) {
                if (n == null) {
                    n = new e(context);
                }
            }
        }
        return n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.i != 0 || i == 0) {
            if (this.i != 0) {
                if (this.p) {
                    new b.C0052b(this.l).b(System.currentTimeMillis()).a(i + "").d(401102L).a();
                    this.p = false;
                    return;
                }
                new b.C0052b(this.l).a(true).a(this.i).b(System.currentTimeMillis()).a(i + "").c(this.j).d(401101L).a();
                this.i = 0L;
                return;
            }
            return;
        }
        new b.C0052b(this.l).a(System.currentTimeMillis()).a(i + "").b(this.q + "/" + this.r + ":" + this.s + ":" + w + ":" + com.baidu.android.pushservice.j.g.h(this.l)).d(401100L).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        c a2;
        c.a aVar;
        if (this.f2981a == -1 && i == 110) {
            this.s = 80;
        }
        a(i);
        if (this.u.size() > 0) {
            f2980c = Boolean.FALSE;
            j();
            return;
        }
        l();
        this.u.clear();
        int i2 = w;
        if (i2 != 0) {
            int i3 = 1;
            if (i2 == 1) {
                a2 = c.a(this.l);
                aVar = new c.a() { // from class: com.baidu.android.pushservice.e.7
                    @Override // com.baidu.android.pushservice.c.a
                    public void a(int i4, List<String> list) {
                        e.this.r = null;
                        Boolean unused = e.f2980c = Boolean.FALSE;
                        if (list == null || list.size() <= 0) {
                            e.this.b(10005);
                            return;
                        }
                        e.this.u.addAll(list);
                        e.this.j();
                    }
                };
            } else {
                if (this.v) {
                    i3 = 2;
                    if (i2 == 2) {
                        a2 = c.a(this.l);
                        aVar = new c.a() { // from class: com.baidu.android.pushservice.e.8
                            @Override // com.baidu.android.pushservice.c.a
                            public void a(int i4, List<String> list) {
                                e.this.r = null;
                                Boolean unused = e.f2980c = Boolean.FALSE;
                                if (list == null || list.size() <= 0) {
                                    e.this.b(10006);
                                    return;
                                }
                                e.this.u.addAll(list);
                                e.this.j();
                            }
                        };
                    }
                }
                w = 0;
            }
            a2.a(i3, aVar);
            return;
        }
        this.u.add(h.d());
        f2980c = Boolean.FALSE;
        j();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x0055 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    /* JADX WARN: Type inference failed for: r3v13, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r3v15 */
    private void b(Context context) {
        b.c cVar;
        FileInputStream fileInputStream;
        if (PushSettings.f(context)) {
            File file = new File(Environment.getExternalStorageDirectory(), "baidu/pushservice/pushservice.cfg");
            if (file.exists()) {
                Properties properties = new Properties();
                FileInputStream fileInputStream2 = null;
                ?? r3 = 0;
                FileInputStream fileInputStream3 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    properties.load(fileInputStream);
                    String property = properties.getProperty("rtcseed");
                    if (property != null && (r3 = property.length()) > 0) {
                        r3 = new JSONArray(property);
                        for (int i = 0; i < r3.length(); i++) {
                            this.A[i] = r3.getInt(i);
                            this.B = 0;
                            this.C = 0;
                            this.D = 0;
                        }
                    }
                    String property2 = properties.getProperty("originseed");
                    if (property2 != null && property2.length() > 0) {
                        this.B = Integer.parseInt(property2);
                    }
                    try {
                        fileInputStream.close();
                        fileInputStream2 = r3;
                    } catch (IOException e3) {
                        e = e3;
                        com.baidu.android.pushservice.g.a.b("PushConnection", "error " + e.getMessage(), this.l.getApplicationContext());
                        cVar = new b.c(this.l);
                        cVar.a(Log.getStackTraceString(e)).a();
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream3 = fileInputStream;
                    com.baidu.android.pushservice.g.a.b("PushConnection", "getTestConfig exception " + e.getMessage(), this.l.getApplicationContext());
                    new b.c(this.l).a(Log.getStackTraceString(e)).a();
                    fileInputStream2 = fileInputStream3;
                    if (fileInputStream3 != null) {
                        try {
                            fileInputStream3.close();
                            fileInputStream2 = fileInputStream3;
                        } catch (IOException e5) {
                            e = e5;
                            com.baidu.android.pushservice.g.a.b("PushConnection", "error " + e.getMessage(), this.l.getApplicationContext());
                            cVar = new b.c(this.l);
                            cVar.a(Log.getStackTraceString(e)).a();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e6) {
                            com.baidu.android.pushservice.g.a.b("PushConnection", "error " + e6.getMessage(), this.l.getApplicationContext());
                            new b.c(this.l).a(Log.getStackTraceString(e6)).a();
                        }
                    }
                    throw th;
                }
            }
        }
    }

    private synchronized void h() {
        if (!this.f2982b && !f2980c.booleanValue() && !this.f2983d) {
            this.f2983d = true;
            this.u.clear();
            if (w != 0) {
                if (w == 1) {
                    c.a(this.l).a(1, new c.a() { // from class: com.baidu.android.pushservice.e.1
                        @Override // com.baidu.android.pushservice.c.a
                        public void a(int i, List<String> list) {
                            e.this.f2983d = false;
                            if (list == null || list.size() <= 0) {
                                e.this.b(10005);
                                return;
                            }
                            if (e.this.u.isEmpty()) {
                                e.this.u.addAll(list);
                            }
                            e.this.i();
                        }
                    });
                } else if (this.v && w == 2) {
                    c.a(this.l).a(2, new c.a() { // from class: com.baidu.android.pushservice.e.2
                        @Override // com.baidu.android.pushservice.c.a
                        public void a(int i, List<String> list) {
                            e.this.f2983d = false;
                            if (list == null || list.size() <= 0) {
                                e.this.b(10006);
                                return;
                            }
                            if (e.this.u.isEmpty()) {
                                e.this.u.addAll(list);
                            }
                            e.this.i();
                        }
                    });
                } else {
                    w = 0;
                    if (this.u.isEmpty()) {
                        this.u.add(h.d());
                    }
                    this.f2983d = false;
                }
            }
            if (this.u.isEmpty()) {
                this.u.add(h.d());
            }
            this.f2983d = false;
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        if (!this.f2982b && !f2980c.booleanValue()) {
            if (!k.a(this.l).e()) {
                f.h(this.l);
                return;
            }
            m.a("PushConnection connectImpl from " + this.l.getPackageName() + " at Time " + System.currentTimeMillis(), this.l);
            if (this.u.size() > 0) {
                this.q = this.u.remove(0);
            }
            f2980c = Boolean.TRUE;
            this.f2981a = -1;
            Runnable runnable = new Runnable() { // from class: com.baidu.android.pushservice.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PushSocket.createSocket(e.this.q, e.this.s, new PushSocket.OnCreateSocketListener() { // from class: com.baidu.android.pushservice.e.3.1
                            @Override // com.baidu.android.pushservice.jni.PushSocket.OnCreateSocketListener
                            public void onConnect(int i) {
                                int i2;
                                e.this.f2981a = i;
                                e.this.r = PushSocket.getLastSocketIP();
                                try {
                                    i2 = PushSocket.getLastSocketError();
                                } catch (Exception unused) {
                                    i2 = 0;
                                }
                                if (e.this.f2981a <= -1 || (i2 >= 101 && i2 != 115)) {
                                    e.this.b(i2);
                                    return;
                                }
                                e eVar = e.this;
                                eVar.m = new com.baidu.android.pushservice.message.f(eVar.l.getApplicationContext());
                                e.this.f2982b = true;
                                e.this.i = System.currentTimeMillis();
                                if (e.this.f2986g != null) {
                                    e.this.f2986g.interrupt();
                                }
                                if (e.this.f2985f != null) {
                                    e.this.f2985f.interrupt();
                                }
                                e.this.f2984e = false;
                                e.this.f2986g = new a();
                                e.this.f2986g.start();
                                e.this.f2985f = new b();
                                e.this.f2985f.start();
                                e.this.m.b();
                                Boolean unused2 = e.f2980c = Boolean.FALSE;
                                e.this.q = h.d();
                                e.this.u.clear();
                            }
                        });
                    } catch (Exception e2) {
                        new b.c(e.this.l).a(Log.getStackTraceString(e2)).a();
                    }
                }
            };
            if (this.t != null) {
                this.t.interrupt();
            }
            Thread thread = new Thread(runnable);
            this.t = thread;
            thread.setName("PushService-PushService-connect");
            this.t.start();
            return;
        }
        com.baidu.android.pushservice.g.a.c("PushConnection", "Connect return. mConnected:" + this.f2982b + " mConnectting:" + f2980c, this.l.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        com.baidu.android.pushservice.g.a.c("PushConnection", "disconnectedByPeer, mStoped == " + this.f2987h, this.l.getApplicationContext());
        m.a("PushConnection destroy from " + this.l.getPackageName() + " at Time " + System.currentTimeMillis(), this.l);
        k();
        if (this.f2987h) {
            return;
        }
        this.j++;
        if (com.baidu.android.pushservice.b.d.g()) {
            this.k.removeCallbacks(this.x);
            this.k.postDelayed(this.x, 30000);
            com.baidu.android.pushservice.g.a.c("PushConnection", "PeakTime retry-- retry times: " + this.j + " time delay: 30000", this.l.getApplicationContext());
        } else if (this.j <= 5) {
            this.k.removeCallbacks(this.x);
            int i = this.j;
            int i2 = (i - 1) * 30 * 1000;
            if (i == 1) {
                i2 = 3000;
            }
            this.k.postDelayed(this.x, i2);
        }
    }

    private void k() {
        com.baidu.android.pushservice.g.a.c("PushConnection", "destroy", this.l.getApplicationContext());
        Handler handler = this.k;
        if (handler != null) {
            handler.removeCallbacks(this.y);
        }
        this.f2984e = true;
        this.f2982b = false;
        com.baidu.android.pushservice.message.d dVar = this.m;
        if (dVar != null) {
            try {
                synchronized (dVar.a()) {
                    this.m.a().notifyAll();
                }
            } catch (Exception e2) {
                new b.c(this.l).a(Log.getStackTraceString(e2)).a();
            }
        }
        PushSocket.a(this.f2981a);
        this.f2981a = -1;
        com.baidu.android.pushservice.message.d dVar2 = this.m;
        if (dVar2 != null) {
            dVar2.c();
        }
    }

    private void l() {
        w = (w + 1) % 3;
    }

    public void a(int i, String str, byte[] bArr) {
        com.baidu.android.pushservice.message.d dVar = this.m;
        if (dVar != null) {
            dVar.a(i, str, bArr);
        }
    }

    public void a(boolean z) {
        StringBuilder sb;
        String i = com.baidu.android.pushservice.j.g.i(this.l);
        if (TextUtils.equals(this.E, i)) {
            int e2 = e();
            if (z) {
                if (com.baidu.android.pushservice.j.g.a(this.l)) {
                    f();
                    int i2 = this.C + 1;
                    this.C = i2;
                    if (i2 >= 3) {
                        this.C = 0;
                        int i3 = this.B;
                        if (i3 < this.A.length - 1) {
                            this.C = 0;
                            this.B = i3 + 1;
                        }
                    }
                    if (this.D >= 30) {
                        this.D = 0;
                    }
                    sb = new StringBuilder();
                    sb.append("RTC stat change from ");
                    sb.append(e2);
                    sb.append(" to ");
                    sb.append(e());
                }
                this.B++;
                sb = new StringBuilder();
                sb.append("RTC stat change from ");
                sb.append(e2);
                sb.append(" to ");
                sb.append(e());
            } else {
                this.C = 0;
                this.D = 0;
                if (com.baidu.android.pushservice.j.g.a(this.l)) {
                    int i4 = this.B;
                    if (i4 > 0) {
                        this.B = i4 - 1;
                        f();
                    }
                    sb = new StringBuilder();
                    sb.append("RTC stat change from ");
                    sb.append(e2);
                    sb.append(" to ");
                    sb.append(e());
                }
                this.B++;
                sb = new StringBuilder();
                sb.append("RTC stat change from ");
                sb.append(e2);
                sb.append(" to ");
                sb.append(e());
            }
        } else {
            this.B = g();
            this.C = 0;
            sb = new StringBuilder();
            sb.append("RTC stat change ");
            sb.append(e());
            sb.append(" because of network changing");
        }
        m.a(sb.toString(), this.l);
        this.E = i;
        g.a(this.l).a(e() * 1000);
    }

    public boolean a() {
        return this.f2982b;
    }

    public void b() {
        this.j = 0;
        this.f2987h = false;
        h();
    }

    public void c() {
        com.baidu.android.pushservice.g.a.c("PushConnection", "---stop---", this.l.getApplicationContext());
        m.a("PushConnection stop from " + this.l.getPackageName() + " at Time " + System.currentTimeMillis(), this.l);
        this.f2984e = true;
        this.f2987h = true;
        this.k.removeCallbacks(this.x);
        k();
        n = null;
    }

    public void d() {
        if (this.m != null) {
            if (System.currentTimeMillis() - this.z >= 60000) {
                com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("heartbeat", (short) 98) { // from class: com.baidu.android.pushservice.e.6
                    @Override // com.baidu.android.pushservice.h.c
                    public void a() {
                        long currentTimeMillis = System.currentTimeMillis();
                        int i = ((int) (currentTimeMillis / 1000)) % 60;
                        if (((int) ((currentTimeMillis / 60000) % 5)) == 0 && i < 15) {
                            try {
                                Thread.sleep((long) (Math.random() * 60.0d * 1000.0d));
                            } catch (InterruptedException unused) {
                            }
                        }
                        e.this.m.d();
                        e.this.z = System.currentTimeMillis();
                        com.baidu.android.pushservice.g.a.c("PushConnection", "sendHeartbeatMessage", e.this.l.getApplicationContext());
                    }
                });
            } else {
                com.baidu.android.pushservice.g.a.c("PushConnection", "sendHeartbeatMessage ingnored， because too frequent.", this.l.getApplicationContext());
            }
        }
    }

    public int e() {
        int length;
        int i = this.B;
        if (i >= 0) {
            int[] iArr = this.A;
            if (i >= iArr.length) {
                length = iArr.length - 1;
            }
            return this.A[this.B];
        }
        length = 0;
        this.B = length;
        return this.A[this.B];
    }

    public void f() {
        Context context;
        int i;
        String str;
        if (com.baidu.android.pushservice.j.g.b(this.l)) {
            context = this.l;
            i = this.B;
            str = "com.baidu.pushservice.CUR_PERIOD_WIFI";
        } else {
            context = this.l;
            i = this.B;
            str = "com.baidu.pushservice.CUR_PERIOD_MOBILE";
        }
        com.baidu.android.pushservice.j.i.a(context, str, i);
    }

    public int g() {
        Context context;
        String str;
        if (com.baidu.android.pushservice.j.g.a(this.l)) {
            if (com.baidu.android.pushservice.j.g.b(this.l)) {
                context = this.l;
                str = "com.baidu.pushservice.CUR_PERIOD_WIFI";
            } else {
                context = this.l;
                str = "com.baidu.pushservice.CUR_PERIOD_MOBILE";
            }
            return com.baidu.android.pushservice.j.i.b(context, str, 0);
        }
        return 0;
    }
}
