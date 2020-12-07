package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.android.pushservice.c;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.platform.comapi.UIMsg;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public final class e {
    private static volatile e m;
    private String C;
    private b e;
    private a f;
    private long h;
    private int i;
    private final Handler j;
    private final Context k;
    private com.baidu.android.pushservice.message.d l;
    private boolean n;
    private boolean o;
    private String p;
    private String q;
    private int r;
    private Thread s;
    private boolean t;
    private int z;
    private static Boolean c = false;
    private static int u = 2;

    /* renamed from: a  reason: collision with root package name */
    private int f1063a = -1;
    private boolean b = false;
    private boolean d = false;
    private boolean g = false;
    private Runnable v = new Runnable() { // from class: com.baidu.android.pushservice.e.4
        @Override // java.lang.Runnable
        public void run() {
            e.this.i();
        }
    };
    private Runnable w = new Runnable() { // from class: com.baidu.android.pushservice.e.5
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.android.pushservice.f.a.c("PushConnection", " -- Send Timeout --", e.this.k.getApplicationContext());
            if (e.this.n) {
                e.this.n = false;
            }
            e.this.a(false);
            e.this.a(10004);
            e.this.j();
            m.a("PushConnection Send Timeout " + e.this.k.getPackageName() + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + e.this.f1063a + System.currentTimeMillis(), e.this.k.getApplicationContext());
        }
    };
    private long x = 0;
    private final int[] y = {180, 300, EncoderTextureDrawer.X264_WIDTH, HttpStatus.SC_METHOD_FAILURE, UIMsg.MsgDefine.MSG_NETWORK_CHANNEL, 720, CyberPlayerManager.MEDIA_INFO_TIMED_TEXT_ERROR};
    private int A = 0;
    private int B = 0;

    /* loaded from: classes7.dex */
    class a extends Thread {
        a() {
            setName("PushService-PushConnection-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            byte[] bArr;
            while (!e.this.d) {
                try {
                    bArr = PushSocket.a(e.this.k, e.this.f1063a);
                } catch (Exception e) {
                    bArr = null;
                    com.baidu.android.pushservice.f.a.b("PushConnection", "Get message exception", e.this.k.getApplicationContext());
                    new b.c(e.this.k).a(Log.getStackTraceString(e)).a();
                }
                e.this.j.removeCallbacks(e.this.w);
                if (e.this.n) {
                    e.this.n = false;
                    e.this.a(true);
                }
                if (e.this.o) {
                    e.this.o = false;
                }
                int lastSocketError = PushSocket.getLastSocketError();
                if (bArr == null || bArr.length == 0) {
                    e.this.a(lastSocketError);
                    e.this.j();
                    m.a("PushConnection Receive err " + e.this.k.getPackageName() + " lastSocketError " + lastSocketError + " socketfd " + e.this.f1063a + System.currentTimeMillis(), e.this.k.getApplicationContext());
                } else {
                    try {
                        com.baidu.android.pushservice.message.e a2 = e.this.l.a(bArr);
                        if (a2 != null) {
                            try {
                                e.this.l.b(a2);
                            } catch (Exception e2) {
                                com.baidu.android.pushservice.f.a.b("PushConnection", "Handle message exception " + m.a(e2), e.this.k.getApplicationContext());
                                m.a("PushConnection Handle message exception " + e.this.k.getPackageName() + m.a(e2) + " lastSocketError " + lastSocketError + " socketfd " + e.this.f1063a + System.currentTimeMillis(), e.this.k.getApplicationContext());
                                new b.c(e.this.k).a(Log.getStackTraceString(e2)).a();
                                e.this.j();
                            }
                        }
                        e.this.i = 0;
                    } catch (Exception e3) {
                        com.baidu.android.pushservice.f.a.c("PushConnection", "Read message exception " + m.a(e3), e.this.k.getApplicationContext());
                        new b.c(e.this.k).a(Log.getStackTraceString(e3)).a();
                        e.this.a(lastSocketError);
                        e.this.j();
                        m.a("PushConnection Read message exception " + e.this.k.getPackageName() + m.a(e3) + " lastSocketError " + lastSocketError + " socketfd " + e.this.f1063a + System.currentTimeMillis(), e.this.k.getApplicationContext());
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    class b extends Thread {
        b() {
            setName("PushService-PushConnection-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            com.baidu.android.pushservice.message.e removeFirst;
            int i;
            while (!e.this.d) {
                synchronized (e.this.l.a()) {
                    if (e.this.l.a().size() == 0) {
                        try {
                            e.this.l.a().wait();
                        } catch (InterruptedException e) {
                            new b.c(e.this.k).a(Log.getStackTraceString(e)).a();
                        }
                    }
                    removeFirst = e.this.l.a().size() > 0 ? e.this.l.a().removeFirst() : null;
                }
                if (e.this.d) {
                    return;
                }
                if (removeFirst != null && removeFirst.b() != null) {
                    if (removeFirst.c()) {
                        e.this.n = removeFirst.d();
                        if (com.baidu.android.pushservice.message.h.a(removeFirst.a()) == com.baidu.android.pushservice.message.h.MSG_ID_HANDSHAKE) {
                            e.this.o = true;
                        }
                        e.this.j.removeCallbacks(e.this.w);
                        e.this.j.postDelayed(e.this.w, 60000L);
                    }
                    try {
                        i = PushSocket.sendMsg(e.this.f1063a, removeFirst.b(), removeFirst.b().length);
                    } catch (Exception e2) {
                        new b.c(e.this.k).a(Log.getStackTraceString(e2)).a();
                        i = -1;
                    }
                    if (i == -1) {
                        int lastSocketError = PushSocket.getLastSocketError();
                        e.this.a(lastSocketError);
                        e.this.j();
                        m.a("PushConnection sendMsg err " + e.this.k.getPackageName() + " lastSocketError " + lastSocketError + " socketfd " + e.this.f1063a + System.currentTimeMillis(), e.this.k.getApplicationContext());
                    }
                }
            }
        }
    }

    private e(Context context) {
        this.t = false;
        this.z = 0;
        this.k = context;
        this.j = new Handler(context.getMainLooper());
        int g = g();
        if (g >= 0 && g < this.y.length) {
            this.z = g;
        }
        b(context);
        g.a(this.k).a(this.y[this.z] * 1000);
        this.C = com.baidu.android.pushservice.i.g.i(this.k);
        this.p = h.d();
        this.r = h.a(this.k);
        this.t = com.baidu.android.pushservice.b.d.d(this.k);
    }

    public static e a(Context context) {
        if (m == null) {
            synchronized (e.class) {
                if (m == null) {
                    m = new e(context);
                }
            }
        }
        return m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.h == 0 && i != 0) {
            new b.C0066b(this.k).a(System.currentTimeMillis()).a(i + "").b(this.p + "/" + this.q + ":" + this.r + ":" + u + ":" + com.baidu.android.pushservice.i.g.h(this.k)).d(401100L).a();
        } else if (this.h != 0) {
            if (this.o) {
                new b.C0066b(this.k).b(System.currentTimeMillis()).a(i + "").d(401102L).a();
                this.o = false;
                return;
            }
            new b.C0066b(this.k).a(true).a(this.h).b(System.currentTimeMillis()).a(i + "").c(this.i).d(401101L).a();
            this.h = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (this.f1063a == -1 && i == 110) {
            this.r = 80;
        }
        a(i);
        l();
        if (u == 0) {
            this.p = h.d();
            c = false;
            j();
        } else if (u == 1) {
            c.a(this.k).a(1, new c.a() { // from class: com.baidu.android.pushservice.e.7
                @Override // com.baidu.android.pushservice.c.a
                public void a(int i2, String str) {
                    e.this.q = null;
                    Boolean unused = e.c = false;
                    if (TextUtils.isEmpty(str)) {
                        e.this.b(10005);
                        return;
                    }
                    e.this.p = str;
                    e.this.j();
                }
            });
        } else if (this.t && u == 2) {
            c.a(this.k).a(2, new c.a() { // from class: com.baidu.android.pushservice.e.8
                @Override // com.baidu.android.pushservice.c.a
                public void a(int i2, String str) {
                    e.this.q = null;
                    Boolean unused = e.c = false;
                    if (TextUtils.isEmpty(str)) {
                        e.this.b(10006);
                        return;
                    }
                    e.this.p = str;
                    e.this.j();
                }
            });
        } else {
            u = 0;
            this.p = h.d();
            c = false;
            j();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x0166 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.FileInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(Context context) {
        File file;
        ?? exists;
        FileInputStream fileInputStream;
        if (!context.getPackageName().startsWith("com.baidu.push") || (exists = (file = new File(Environment.getExternalStorageDirectory(), "baidu/pushservice/pushservice.cfg")).exists()) == 0) {
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
                            this.y[i] = jSONArray.getInt(i);
                            this.z = 0;
                            this.A = 0;
                            this.B = 0;
                        }
                    }
                    String property2 = properties.getProperty("originseed");
                    if (property2 != null && property2.length() > 0) {
                        this.z = Integer.parseInt(property2);
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            com.baidu.android.pushservice.f.a.b("PushConnection", "error " + e.getMessage(), this.k.getApplicationContext());
                            new b.c(this.k).a(Log.getStackTraceString(e)).a();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    com.baidu.android.pushservice.f.a.b("PushConnection", "getTestConfig exception " + e.getMessage(), this.k.getApplicationContext());
                    new b.c(this.k).a(Log.getStackTraceString(e)).a();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            com.baidu.android.pushservice.f.a.b("PushConnection", "error " + e3.getMessage(), this.k.getApplicationContext());
                            new b.c(this.k).a(Log.getStackTraceString(e3)).a();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (exists != 0) {
                    try {
                        exists.close();
                    } catch (IOException e4) {
                        com.baidu.android.pushservice.f.a.b("PushConnection", "error " + e4.getMessage(), this.k.getApplicationContext());
                        new b.c(this.k).a(Log.getStackTraceString(e4)).a();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            exists = 0;
            if (exists != 0) {
            }
            throw th;
        }
    }

    private synchronized void h() {
        if (u == 0) {
            this.p = h.d();
            i();
        } else if (u == 1) {
            c.a(this.k).a(1, new c.a() { // from class: com.baidu.android.pushservice.e.1
                @Override // com.baidu.android.pushservice.c.a
                public void a(int i, String str) {
                    if (TextUtils.isEmpty(str)) {
                        e.this.b(10005);
                        return;
                    }
                    e.this.p = str;
                    e.this.i();
                }
            });
        } else if (this.t && u == 2) {
            c.a(this.k).a(2, new c.a() { // from class: com.baidu.android.pushservice.e.2
                @Override // com.baidu.android.pushservice.c.a
                public void a(int i, String str) {
                    if (TextUtils.isEmpty(str)) {
                        e.this.b(10006);
                        return;
                    }
                    e.this.p = str;
                    e.this.i();
                }
            });
        } else {
            u = 0;
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        if (this.b || c.booleanValue()) {
            com.baidu.android.pushservice.f.a.c("PushConnection", "Connect return. mConnected:" + this.b + " mConnectting:" + c, this.k.getApplicationContext());
        } else if (j.a(this.k).e()) {
            m.a("PushConnection connectImpl from " + this.k.getPackageName() + " at Time " + System.currentTimeMillis(), this.k);
            c = true;
            this.f1063a = -1;
            Runnable runnable = new Runnable() { // from class: com.baidu.android.pushservice.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PushSocket.createSocket(e.this.p, e.this.r, new PushSocket.OnCreateSocketListener() { // from class: com.baidu.android.pushservice.e.3.1
                            @Override // com.baidu.android.pushservice.jni.PushSocket.OnCreateSocketListener
                            public void onConnect(int i) {
                                int i2;
                                e.this.f1063a = i;
                                e.this.q = PushSocket.getLastSocketIP();
                                try {
                                    i2 = PushSocket.getLastSocketError();
                                } catch (Exception e) {
                                    i2 = 0;
                                }
                                if (e.this.f1063a <= -1 || (i2 >= 101 && i2 != 115)) {
                                    e.this.b(i2);
                                    return;
                                }
                                e.this.l = new com.baidu.android.pushservice.message.f(e.this.k.getApplicationContext());
                                e.this.b = true;
                                e.this.h = System.currentTimeMillis();
                                if (e.this.f != null) {
                                    e.this.f.interrupt();
                                }
                                if (e.this.e != null) {
                                    e.this.e.interrupt();
                                }
                                e.this.d = false;
                                e.this.f = new a();
                                e.this.f.start();
                                e.this.e = new b();
                                e.this.e.start();
                                e.this.l.b();
                                Boolean unused = e.c = false;
                                e.this.p = h.d();
                            }
                        });
                    } catch (Exception e) {
                        new b.c(e.this.k).a(Log.getStackTraceString(e)).a();
                    }
                }
            };
            if (this.s != null) {
                this.s.interrupt();
            }
            this.s = new Thread(runnable);
            this.s.setName("PushService-PushService-connect");
            this.s.start();
        } else {
            f.h(this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        com.baidu.android.pushservice.f.a.c("PushConnection", "disconnectedByPeer, mStoped == " + this.g, this.k.getApplicationContext());
        m.a("PushConnection destroy from " + this.k.getPackageName() + " at Time " + System.currentTimeMillis(), this.k);
        k();
        if (this.g) {
            return;
        }
        this.i++;
        if (com.baidu.android.pushservice.b.d.g()) {
            this.j.removeCallbacks(this.v);
            this.j.postDelayed(this.v, 30000);
            com.baidu.android.pushservice.f.a.c("PushConnection", "PeakTime retry-- retry times: " + this.i + " time delay: 30000", this.k.getApplicationContext());
        } else if (this.i <= 2) {
            this.j.removeCallbacks(this.v);
            int i = (this.i - 1) * 30 * 1000;
            if (this.i == 1) {
                i = 3000;
            }
            this.j.postDelayed(this.v, i);
        }
    }

    private void k() {
        com.baidu.android.pushservice.f.a.c("PushConnection", "destroy", this.k.getApplicationContext());
        if (this.j != null) {
            this.j.removeCallbacks(this.w);
        }
        this.d = true;
        this.b = false;
        if (this.l != null) {
            try {
                synchronized (this.l.a()) {
                    this.l.a().notifyAll();
                }
            } catch (Exception e) {
                new b.c(this.k).a(Log.getStackTraceString(e)).a();
            }
        }
        PushSocket.a(this.f1063a);
        if (this.l != null) {
            this.l.c();
        }
    }

    private void l() {
        u = (u + 1) % 3;
    }

    public void a(boolean z) {
        String i = com.baidu.android.pushservice.i.g.i(this.k);
        if (TextUtils.equals(this.C, i)) {
            int e = e();
            if (!z) {
                this.A = 0;
                this.B = 0;
                if (!com.baidu.android.pushservice.i.g.a(this.k)) {
                    this.z++;
                } else if (this.z > 0) {
                    this.z--;
                    f();
                }
            } else if (com.baidu.android.pushservice.i.g.a(this.k)) {
                f();
                this.A++;
                if (this.A >= 3) {
                    this.A = 0;
                    if (this.z < this.y.length - 1) {
                        this.A = 0;
                        this.z++;
                    }
                }
                if (this.B >= 30) {
                    this.B = 0;
                }
            } else {
                this.z++;
            }
            m.a("RTC stat change from " + e + " to " + e(), this.k);
        } else {
            this.z = g();
            this.A = 0;
            m.a("RTC stat change " + e() + " because of network changing", this.k);
        }
        this.C = i;
        g.a(this.k).a(e() * 1000);
    }

    public boolean a() {
        return this.b;
    }

    public void b() {
        this.i = 0;
        this.g = false;
        h();
    }

    public void c() {
        com.baidu.android.pushservice.f.a.c("PushConnection", "---stop---", this.k.getApplicationContext());
        m.a("PushConnection stop from " + this.k.getPackageName() + " at Time " + System.currentTimeMillis(), this.k);
        this.d = true;
        this.g = true;
        this.j.removeCallbacks(this.v);
        k();
        m = null;
    }

    public void d() {
        if (this.l != null) {
            if (System.currentTimeMillis() - this.x >= 60000) {
                com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("heartbeat", (short) 98) { // from class: com.baidu.android.pushservice.e.6
                    @Override // com.baidu.android.pushservice.g.c
                    public void a() {
                        long currentTimeMillis = System.currentTimeMillis();
                        int i = (int) ((currentTimeMillis / 60000) % 5);
                        int i2 = ((int) (currentTimeMillis / 1000)) % 60;
                        if (i == 0 && i2 < 15) {
                            try {
                                Thread.sleep((long) (Math.random() * 60.0d * 1000.0d));
                            } catch (InterruptedException e) {
                            }
                        }
                        e.this.l.d();
                        e.this.x = System.currentTimeMillis();
                        com.baidu.android.pushservice.f.a.c("PushConnection", "sendHeartbeatMessage", e.this.k.getApplicationContext());
                    }
                });
            } else {
                com.baidu.android.pushservice.f.a.c("PushConnection", "sendHeartbeatMessage ingnored， because too frequent.", this.k.getApplicationContext());
            }
        }
    }

    public int e() {
        if (this.z < 0) {
            this.z = 0;
        } else if (this.z >= this.y.length) {
            this.z = this.y.length - 1;
        }
        return this.y[this.z];
    }

    public void f() {
        if (com.baidu.android.pushservice.i.g.b(this.k)) {
            com.baidu.android.pushservice.i.i.a(this.k, "com.baidu.pushservice.CUR_PERIOD_WIFI", this.z);
        } else {
            com.baidu.android.pushservice.i.i.a(this.k, "com.baidu.pushservice.CUR_PERIOD_MOBILE", this.z);
        }
    }

    public int g() {
        if (com.baidu.android.pushservice.i.g.a(this.k)) {
            return com.baidu.android.pushservice.i.g.b(this.k) ? com.baidu.android.pushservice.i.i.b(this.k, "com.baidu.pushservice.CUR_PERIOD_WIFI", 0) : com.baidu.android.pushservice.i.i.b(this.k, "com.baidu.pushservice.CUR_PERIOD_MOBILE", 0);
        }
        return 0;
    }
}
