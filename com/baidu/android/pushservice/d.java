package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.pushservice.c;
import com.baidu.sapi2.share.ShareCallPacking;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
/* loaded from: classes.dex */
public final class d {
    public static Boolean E = Boolean.FALSE;
    public static volatile d F = null;
    public static int G = 2;
    public int A;
    public String D;
    public j d;
    public i e;
    public long g;
    public int h;
    public final Handler i;
    public final Context j;
    public com.baidu.android.pushservice.w.d k;
    public boolean l;
    public boolean m;
    public String n;
    public String o;
    public int p;
    public Thread q;
    public boolean s;
    public Socket t;
    public InputStream u;
    public OutputStream v;
    public boolean a = false;
    public volatile boolean b = false;
    public boolean c = false;
    public boolean f = false;
    public List<String> r = Collections.synchronizedList(new ArrayList());
    public com.baidu.android.pushservice.z.d w = new C0027d(0);
    public Runnable x = new e();
    public long y = 0;
    public final int[] z = {180, 300, 360, HttpStatus.SC_METHOD_FAILURE, 540, 720, 900};
    public int B = 0;
    public int C = 0;

    /* loaded from: classes.dex */
    public class a implements c.d {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // com.baidu.android.pushservice.c.d
        public void a(int i, List<String> list) {
            d.this.b = false;
            if (list == null || list.size() <= 0) {
                d.this.a(10005, this.a);
                return;
            }
            if (d.this.r.isEmpty()) {
                d.this.r.addAll(list);
            }
            d.this.b(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.d {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // com.baidu.android.pushservice.c.d
        public void a(int i, List<String> list) {
            d.this.b = false;
            if (list == null || list.size() <= 0) {
                d.this.a(10006, this.a);
                return;
            }
            if (d.this.r.isEmpty()) {
                d.this.r.addAll(list);
            }
            d.this.b(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.t = new Socket(d.this.n, d.this.p);
                d.this.u = d.this.t.getInputStream();
                d.this.v = d.this.t.getOutputStream();
                try {
                    d.this.k = new com.baidu.android.pushservice.w.f(d.this.j.getApplicationContext(), d.this.u, d.this.v);
                    d.this.a = true;
                    d.this.g = System.currentTimeMillis();
                    if (d.this.e != null) {
                        d.this.e.interrupt();
                    }
                    if (d.this.d != null) {
                        d.this.d.interrupt();
                    }
                    d.this.c = false;
                    d.this.e = new i();
                    d.this.e.start();
                    d.this.d = new j();
                    d.this.d.start();
                    Boolean unused = d.E = Boolean.FALSE;
                    d.this.k.a(this.a);
                    Boolean unused2 = d.E = Boolean.FALSE;
                    d.this.n = com.baidu.android.pushservice.g.e();
                    d.this.r.clear();
                } catch (Exception unused3) {
                }
            } catch (Exception unused4) {
                d.this.a((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT, this.a);
            }
        }
    }

    /* renamed from: com.baidu.android.pushservice.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0027d extends com.baidu.android.pushservice.z.d {
        public C0027d(int i) {
            super(i);
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.b(a());
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.android.pushservice.u.a.c("PushConnection", " -- Send Timeout --", d.this.j.getApplicationContext());
            if (d.this.l) {
                d.this.l = false;
            }
            d.this.a(false);
            d.this.f(10004);
            d.this.c();
            com.baidu.android.pushservice.u.a.a("PushConnection", "PushConnection Send Timeout " + d.this.j.getPackageName() + System.currentTimeMillis(), d.this.j.getApplicationContext());
        }
    }

    /* loaded from: classes.dex */
    public class f extends com.baidu.android.pushservice.z.c {
        public f(String str, short s) {
            super(str, s);
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            long currentTimeMillis = System.currentTimeMillis();
            int i = ((int) (currentTimeMillis / 1000)) % 60;
            if (((int) ((currentTimeMillis / 60000) % 5)) == 0 && i < 15) {
                try {
                    Thread.sleep((long) (Math.random() * 60.0d * 1000.0d));
                } catch (InterruptedException unused) {
                }
            }
            d.this.k.d();
            d.this.y = System.currentTimeMillis();
            com.baidu.android.pushservice.u.a.c("PushConnection", "sendHeartbeatMessage", d.this.j.getApplicationContext());
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.d {
        public final /* synthetic */ int a;

        public g(int i) {
            this.a = i;
        }

        @Override // com.baidu.android.pushservice.c.d
        public void a(int i, List<String> list) {
            d.this.o = null;
            Boolean unused = d.E = Boolean.FALSE;
            if (list == null || list.size() <= 0) {
                d.this.a(10005, this.a);
                return;
            }
            d.this.r.addAll(list);
            d.this.d(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.d {
        public final /* synthetic */ int a;

        public h(int i) {
            this.a = i;
        }

        @Override // com.baidu.android.pushservice.c.d
        public void a(int i, List<String> list) {
            d.this.o = null;
            Boolean unused = d.E = Boolean.FALSE;
            if (list == null || list.size() <= 0) {
                d.this.a(10006, this.a);
                return;
            }
            d.this.r.addAll(list);
            d.this.d(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class i extends Thread {
        public i() {
            setName("PushService-PushConnection-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!d.this.c) {
                com.baidu.android.pushservice.w.e eVar = null;
                try {
                    eVar = d.this.k.c();
                } catch (Exception unused) {
                }
                d.this.i.removeCallbacks(d.this.x);
                if (d.this.l) {
                    d.this.l = false;
                    d.this.a(true);
                }
                if (d.this.m) {
                    d.this.m = false;
                }
                if (eVar == null || !((eVar.a() != null && eVar.a().length != 0) || eVar.c() == com.baidu.android.pushservice.w.h.MSG_ID_TINY_HEARTBEAT_SERVER.a() || eVar.c() == com.baidu.android.pushservice.w.h.MSG_ID_TINY_HEARTBEAT_CLIENT.a())) {
                    d.this.f((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT);
                    d.this.c();
                    com.baidu.android.pushservice.u.a.a("PushConnection", "PushConnection Receive err " + d.this.j.getPackageName() + System.currentTimeMillis(), d.this.j.getApplicationContext());
                } else {
                    try {
                        d.this.k.a(eVar);
                        d.this.h = 0;
                    } catch (Exception unused2) {
                        d.this.c();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class j extends Thread {
        public j() {
            setName("PushService-PushConnection-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!d.this.c) {
                com.baidu.android.pushservice.w.e eVar = null;
                synchronized (d.this.k.a()) {
                    try {
                        if (d.this.k.a().size() == 0) {
                            d.this.k.a().wait();
                        }
                        if (d.this.k.a().size() > 0) {
                            eVar = d.this.k.a().removeFirst();
                        }
                    } catch (Exception unused) {
                    }
                }
                if (d.this.c) {
                    return;
                }
                if (eVar != null && eVar.a() != null) {
                    if (eVar.e()) {
                        d.this.l = eVar.d();
                        if (com.baidu.android.pushservice.w.h.a(eVar.c()) == com.baidu.android.pushservice.w.h.MSG_ID_HANDSHAKE) {
                            d.this.m = true;
                        }
                        d.this.i.removeCallbacks(d.this.x);
                        d.this.i.postDelayed(d.this.x, 60000L);
                    }
                    try {
                        d.this.v.write(eVar.a());
                        d.this.v.flush();
                    } catch (Exception unused2) {
                        d.this.c();
                        d.this.f((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT);
                    }
                }
            }
        }
    }

    public d(Context context) {
        this.s = false;
        this.A = 0;
        this.j = context;
        this.i = new Handler(context.getMainLooper());
        int d = d();
        if (d >= 0 && d < this.z.length) {
            this.A = d;
        }
        b(context);
        com.baidu.android.pushservice.f.a(this.j).d(this.z[this.A] * 1000);
        this.D = com.baidu.android.pushservice.a0.g.c(this.j);
        this.n = com.baidu.android.pushservice.g.e();
        this.p = com.baidu.android.pushservice.g.c(this.j);
        this.s = com.baidu.android.pushservice.l.d.a(this.j);
    }

    public static d a(Context context) {
        if (F == null) {
            synchronized (d.class) {
                if (F == null) {
                    F = new d(context);
                }
            }
        }
        return F;
    }

    public final void a() {
        try {
            if (this.t != null) {
                this.t.close();
                this.t = null;
            }
            if (this.u != null) {
                this.u.close();
                this.u = null;
            }
            if (this.v != null) {
                this.v.close();
                this.v = null;
            }
        } catch (Exception unused) {
        }
    }

    public void a(int i2) {
        this.h = 0;
        this.f = false;
        c(i2);
    }

    public final void a(int i2, int i3) {
        com.baidu.android.pushservice.c a2;
        c.d hVar;
        f(i2);
        if (this.r.size() > 0) {
            E = Boolean.FALSE;
            d(i3);
            return;
        }
        g();
        this.r.clear();
        int i4 = G;
        if (i4 != 0) {
            int i5 = 1;
            if (i4 == 1) {
                a2 = com.baidu.android.pushservice.c.a(this.j);
                hVar = new g(i3);
            } else {
                if (this.s) {
                    i5 = 2;
                    if (i4 == 2) {
                        a2 = com.baidu.android.pushservice.c.a(this.j);
                        hVar = new h(i3);
                    }
                }
                G = 0;
            }
            a2.a(i5, hVar);
            return;
        }
        this.r.add(com.baidu.android.pushservice.g.e());
        E = Boolean.FALSE;
        d(i3);
    }

    public void a(int i2, String str, byte[] bArr) {
        com.baidu.android.pushservice.w.d dVar = this.k;
        if (dVar != null) {
            dVar.a(i2, str, bArr);
        }
    }

    public void a(boolean z) {
        StringBuilder sb;
        String c2 = com.baidu.android.pushservice.a0.g.c(this.j);
        if (TextUtils.equals(this.D, c2)) {
            int e2 = e();
            if (z) {
                if (com.baidu.android.pushservice.a0.g.d(this.j)) {
                    h();
                    int i2 = this.B + 1;
                    this.B = i2;
                    if (i2 >= 3) {
                        this.B = 0;
                        int i3 = this.A;
                        if (i3 < this.z.length - 1) {
                            this.B = 0;
                            this.A = i3 + 1;
                        }
                    }
                    if (this.C >= 30) {
                        this.C = 0;
                    }
                    sb = new StringBuilder();
                    sb.append("RTC stat change from ");
                    sb.append(e2);
                    sb.append(" to ");
                    sb.append(e());
                }
                this.A++;
                sb = new StringBuilder();
                sb.append("RTC stat change from ");
                sb.append(e2);
                sb.append(" to ");
                sb.append(e());
            } else {
                this.B = 0;
                this.C = 0;
                if (com.baidu.android.pushservice.a0.g.d(this.j)) {
                    int i4 = this.A;
                    if (i4 > 0) {
                        this.A = i4 - 1;
                        h();
                    }
                    sb = new StringBuilder();
                    sb.append("RTC stat change from ");
                    sb.append(e2);
                    sb.append(" to ");
                    sb.append(e());
                }
                this.A++;
                sb = new StringBuilder();
                sb.append("RTC stat change from ");
                sb.append(e2);
                sb.append(" to ");
                sb.append(e());
            }
        } else {
            this.A = d();
            this.B = 0;
            sb = new StringBuilder();
            sb.append("RTC stat change ");
            sb.append(e());
            sb.append(" because of network changing");
        }
        sb.toString();
        this.D = c2;
        com.baidu.android.pushservice.f.a(this.j).d(e() * 1000);
    }

    public final void b() {
        com.baidu.android.pushservice.u.a.c("PushConnection", "destroy", this.j.getApplicationContext());
        Handler handler = this.i;
        if (handler != null) {
            handler.removeCallbacks(this.x);
        }
        this.c = true;
        this.a = false;
        com.baidu.android.pushservice.w.d dVar = this.k;
        if (dVar != null) {
            try {
                synchronized (dVar.a()) {
                    this.k.a().notifyAll();
                }
            } catch (Exception unused) {
            }
        }
        a();
        com.baidu.android.pushservice.w.d dVar2 = this.k;
        if (dVar2 != null) {
            dVar2.b();
        }
    }

    public final synchronized void b(int i2) {
        if (!this.a && !E.booleanValue()) {
            if (!com.baidu.android.pushservice.j.a(this.j).e()) {
                com.baidu.android.pushservice.e.w(this.j);
                return;
            }
            if (this.r.size() > 0) {
                this.n = this.r.remove(0);
            }
            E = Boolean.TRUE;
            c cVar = new c(i2);
            Thread thread = this.q;
            if (thread != null) {
                thread.interrupt();
            }
            Thread thread2 = new Thread(cVar);
            this.q = thread2;
            thread2.setName("PushService-PushService-connect");
            this.q.start();
            return;
        }
        com.baidu.android.pushservice.u.a.c("PushConnection", "Connect return. mConnected:" + this.a + " mConnectting:" + E, this.j.getApplicationContext());
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x0055 */
    /* JADX WARN: Type inference failed for: r3v10, types: [int] */
    /* JADX WARN: Type inference failed for: r3v11, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public final void b(Context context) {
        StringBuilder sb;
        FileInputStream fileInputStream;
        if (PushSettings.e(context)) {
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
                        for (int i2 = 0; i2 < r3.length(); i2++) {
                            this.z[i2] = r3.getInt(i2);
                            this.A = 0;
                            this.B = 0;
                            this.C = 0;
                        }
                    }
                    String property2 = properties.getProperty("originseed");
                    if (property2 != null && property2.length() > 0) {
                        this.A = Integer.parseInt(property2);
                    }
                    try {
                        fileInputStream.close();
                        fileInputStream2 = r3;
                    } catch (IOException e3) {
                        e = e3;
                        sb = new StringBuilder();
                        sb.append("error ");
                        sb.append(e.getMessage());
                        com.baidu.android.pushservice.u.a.b("PushConnection", sb.toString(), this.j.getApplicationContext());
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream3 = fileInputStream;
                    com.baidu.android.pushservice.u.a.b("PushConnection", "getTestConfig exception " + e.getMessage(), this.j.getApplicationContext());
                    fileInputStream2 = fileInputStream3;
                    if (fileInputStream3 != null) {
                        try {
                            fileInputStream3.close();
                            fileInputStream2 = fileInputStream3;
                        } catch (IOException e5) {
                            e = e5;
                            sb = new StringBuilder();
                            sb.append("error ");
                            sb.append(e.getMessage());
                            com.baidu.android.pushservice.u.a.b("PushConnection", sb.toString(), this.j.getApplicationContext());
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e6) {
                            com.baidu.android.pushservice.u.a.b("PushConnection", "error " + e6.getMessage(), this.j.getApplicationContext());
                        }
                    }
                    throw th;
                }
            }
        }
    }

    public final void c() {
        d(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
        if (r3.r.isEmpty() != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void c(int i2) {
        com.baidu.android.pushservice.c a2;
        c.d bVar;
        if (!this.a && !E.booleanValue() && !this.b) {
            int i3 = 1;
            this.b = true;
            this.r.clear();
            int i4 = G;
            if (i4 == 0) {
                if (this.r.isEmpty()) {
                    this.r.add(com.baidu.android.pushservice.g.e());
                }
                this.b = false;
                b(i2);
            } else {
                if (i4 == 1) {
                    a2 = com.baidu.android.pushservice.c.a(this.j);
                    bVar = new a(i2);
                } else {
                    if (this.s) {
                        i3 = 2;
                        if (i4 == 2) {
                            a2 = com.baidu.android.pushservice.c.a(this.j);
                            bVar = new b(i2);
                        }
                    }
                    G = 0;
                }
                a2.a(i3, bVar);
            }
        }
    }

    public int d() {
        Context context;
        String str;
        if (com.baidu.android.pushservice.a0.g.d(this.j)) {
            if (com.baidu.android.pushservice.a0.g.e(this.j)) {
                context = this.j;
                str = "com.baidu.pushservice.CUR_PERIOD_WIFI";
            } else {
                context = this.j;
                str = "com.baidu.pushservice.CUR_PERIOD_MOBILE";
            }
            return com.baidu.android.pushservice.a0.i.a(context, str, 0);
        }
        return 0;
    }

    public final void d(int i2) {
        com.baidu.android.pushservice.u.a.c("PushConnection", "disconnectedByPeer, mStoped == " + this.f, this.j.getApplicationContext());
        b();
        if (this.f) {
            return;
        }
        int i3 = this.h + 1;
        this.h = i3;
        if (i3 <= 5) {
            this.i.removeCallbacks(e(i2));
            int i4 = this.h;
            int i5 = (i4 - 1) * 30 * 1000;
            if (i4 == 1) {
                i5 = 3000;
            }
            this.i.postDelayed(e(i2), i5);
        }
    }

    public int e() {
        int length;
        int i2 = this.A;
        if (i2 >= 0) {
            int[] iArr = this.z;
            if (i2 >= iArr.length) {
                length = iArr.length - 1;
            }
            return this.z[this.A];
        }
        length = 0;
        this.A = length;
        return this.z[this.A];
    }

    public final Runnable e(int i2) {
        this.w.a(i2);
        return this.w;
    }

    public final void f(int i2) {
        if (this.g != 0 || i2 == 0) {
            if (this.g != 0) {
                if (this.m) {
                    this.m = false;
                    return;
                } else {
                    this.g = 0L;
                    return;
                }
            }
            return;
        }
        String str = this.n + "/" + this.o + ":" + this.p + ":" + G;
    }

    public boolean f() {
        return this.a;
    }

    public final void g() {
        G = (G + 1) % 3;
    }

    public void g(int i2) {
        if (this.k != null) {
            if (System.currentTimeMillis() - this.y >= 60000 || i2 != 0) {
                com.baidu.android.pushservice.z.e.a().a(new f("heartbeat", (short) 98));
            } else {
                com.baidu.android.pushservice.u.a.c("PushConnection", "sendHeartbeatMessage ingnored， because too frequent.", this.j.getApplicationContext());
            }
        }
    }

    public void h() {
        Context context;
        int i2;
        String str;
        if (com.baidu.android.pushservice.a0.g.e(this.j)) {
            context = this.j;
            i2 = this.A;
            str = "com.baidu.pushservice.CUR_PERIOD_WIFI";
        } else {
            context = this.j;
            i2 = this.A;
            str = "com.baidu.pushservice.CUR_PERIOD_MOBILE";
        }
        com.baidu.android.pushservice.a0.i.b(context, str, i2);
    }

    public void i() {
        com.baidu.android.pushservice.u.a.c("PushConnection", "---stop---", this.j.getApplicationContext());
        this.c = true;
        this.f = true;
        this.i.removeCallbacks(this.w);
        b();
        F = null;
    }
}
