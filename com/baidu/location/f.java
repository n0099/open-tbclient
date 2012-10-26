package com.baidu.location;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.baidu.location.c;
import com.baidu.location.e;
/* loaded from: classes.dex */
public final class f extends Service {
    static final int A = 56;
    static final int C = 54;
    static final int E = 55;
    static final int I = 51;
    static final int J = 53;
    static final int K = 13;
    static final int N = 22;
    static String O = Environment.getExternalStorageDirectory().getPath() + "/baidu/tempdata";
    static final int P = 65;
    static final int Q = 21;
    static final int R = 61;
    static final int S = 64;
    static final int U = 11;
    static final int a = 25;

    /* renamed from: byte  reason: not valid java name */
    static final int f127byte = 12;
    static final int c = 42;

    /* renamed from: case  reason: not valid java name */
    static final int f128case = 14;

    /* renamed from: char  reason: not valid java name */
    static final float f129char = 2.6f;
    static final int d = 3000;
    static final int e = 52;
    static final int f = 31;
    public static final String g = "baidu_location_service";

    /* renamed from: goto  reason: not valid java name */
    static final int f130goto = 24;

    /* renamed from: if  reason: not valid java name */
    static final int f131if = 1000;

    /* renamed from: int  reason: not valid java name */
    static final int f132int = 43;
    static final int j = 3000;
    static final int l = 57;
    static final int m = 23;
    static final int o = 27;
    static final int p = 15;
    static final int s = 63;
    static final int t = 2000;

    /* renamed from: try  reason: not valid java name */
    static final int f133try = 26;
    static final int u = 62;
    static final int w = 91;
    static final int x = 71;
    static final int y = 41;
    static final int z = 81;

    /* renamed from: do  reason: not valid java name */
    final Handler f134do = new b();
    final Messenger n = new Messenger(this.f134do);
    private c L = null;
    private com.baidu.location.b D = null;
    private e k = null;
    private com.baidu.location.a H = null;
    private e.c B = null;
    private e.c b = null;

    /* renamed from: for  reason: not valid java name */
    private e.c f136for = null;
    private c.a M = null;
    private c.a q = null;

    /* renamed from: long  reason: not valid java name */
    private c.a f137long = null;
    private Location G = null;
    private String h = null;
    private String T = null;

    /* renamed from: void  reason: not valid java name */
    private String f139void = null;

    /* renamed from: else  reason: not valid java name */
    private boolean f135else = false;

    /* renamed from: new  reason: not valid java name */
    private boolean f138new = true;
    private boolean F = false;
    private boolean r = false;
    private long i = 0;
    private long v = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.r) {
                f.this.r = false;
                f.this.m134int();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (f.this.f135else) {
                switch (message.what) {
                    case 11:
                        f.this.m123do(message);
                        break;
                    case 12:
                        f.this.m139new(message);
                        break;
                    case 15:
                        f.this.m143try(message);
                        break;
                    case 21:
                        f.this.a(message, 21);
                        break;
                    case 22:
                        f.this.m135int(message);
                        break;
                    case f.f130goto /* 24 */:
                        f.this.a(message);
                        break;
                    case 25:
                        f.this.m127for(message);
                        break;
                    case 26:
                        f.this.a(message, 26);
                        break;
                    case f.f /* 31 */:
                        f.this.m142try();
                        break;
                    case f.y /* 41 */:
                        f.this.m130if();
                        break;
                    case f.I /* 51 */:
                        f.this.a();
                        break;
                    case f.e /* 52 */:
                        f.this.m118case();
                        break;
                    case f.J /* 53 */:
                        f.this.m120char();
                        break;
                    case f.l /* 57 */:
                        f.this.m131if(message);
                        break;
                    case 62:
                    case 63:
                        f.this.a(21);
                        break;
                    case f.S /* 64 */:
                    case 65:
                        f.this.a(26);
                        break;
                    case f.z /* 81 */:
                        f.this.m126for();
                        break;
                    case f.w /* 91 */:
                        f.this.m122do();
                        break;
                }
            }
            super.handleMessage(message);
        }
    }

    private String a(String str) {
        j.a(g, "generate locdata ...");
        if ((this.M == null || !this.M.m93if()) && this.L != null) {
            this.M = this.L.a();
        }
        if (this.M != null) {
            j.m188if(g, this.M.a());
        } else {
            j.m188if(g, "cellInfo null...");
        }
        if ((this.B == null || !this.B.m111if()) && this.k != null) {
            this.B = this.k.m105new();
        }
        if (this.B != null) {
            j.m188if(g, this.B.m107byte());
        } else {
            j.m188if(g, "wifi list null");
        }
        if (this.D == null || !this.D.m58case()) {
            this.G = null;
        } else {
            this.G = this.D.m59do();
        }
        String m38try = this.H != null ? this.H.m38try() : null;
        String format = 3 == g.m150do(this) ? "&cn=32" : String.format("&cn=%d", Integer.valueOf(this.L.m90new()));
        if (this.f138new) {
            format = format + "&rq=1";
        }
        String str2 = format + m38try;
        if (str != null) {
            str2 = str + str2;
        }
        return j.a(this.M, this.B, this.G, str2, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.D == null) {
            return;
        }
        j.a(g, "on new gps...");
        Location m59do = this.D.m59do();
        if (this.D.m58case() && k.m194if(m59do) && this.L != null && this.k != null && this.H != null) {
            if (this.k != null) {
                this.k.m103for();
            }
            k.a(this.L.a(), this.k.m102do(), m59do, this.H.m38try());
        }
        if (this.H == null || !this.D.m58case()) {
            return;
        }
        this.H.m35if(this.D.m60if());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        c.a a2;
        String str = null;
        j.a(g, "on network exception");
        j.m188if(g, "on network exception");
        this.T = null;
        this.b = null;
        this.q = null;
        String str2 = "{\"result\":{\"time\":\"" + j.a() + "\",\"error\":\"63\"}}";
        if (j.f181do && (a2 = this.L.a()) != null) {
            str = h.a(a2.f106if, a2.f105for, a2.f109try);
        }
        if (str == null || str.length() == 0) {
            str = str2;
        }
        if (this.H != null) {
            this.H.a(str, i);
        }
        if (i == 21) {
            m138new();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        j.a(g, "manual upload ...");
        double d2 = message.getData().getDouble("x");
        double d3 = message.getData().getDouble("y");
        String string = message.getData().getString("addr");
        if (this.L != null && this.k != null && this.H != null) {
            k.a(this.L.a(), this.k.m102do(), this.H.m38try(), d2, d3, string);
        }
        m134int();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, int i) {
        j.a(g, "on network success");
        j.m188if(g, "on network success");
        String str = (String) message.obj;
        j.a(g, "network:" + str);
        if (this.H != null) {
            this.H.a(str, i);
        }
        if (j.a(str)) {
            if (i == 21) {
                this.T = str;
            } else {
                this.f139void = str;
            }
        } else if (i == 21) {
            this.T = null;
        } else {
            this.f139void = null;
        }
        int m185if = j.m185if(str, "ssid\":\"", "\"");
        if (m185if == Integer.MIN_VALUE || this.b == null) {
            this.h = null;
        } else {
            this.h = this.b.m110if(m185if);
        }
        double m182do = j.m182do(str, "radius\":\"", "\"");
        double m182do2 = j.m182do(str, "x\":\"", "\"");
        double m182do3 = j.m182do(str, "y\":\"", "\"");
        if (m182do != Double.MIN_VALUE && m182do2 != Double.MIN_VALUE && m182do3 != Double.MIN_VALUE && (this.b == null || this.b.m113int() == 0)) {
            h.a(this.q, m182do2, m182do3, (float) m182do);
        }
        double m182do4 = j.m182do(str, "a\":\"", "\"");
        if (m182do4 != Double.MIN_VALUE) {
            k.a(m182do4, j.m182do(str, "b\":\"", "\""), j.m182do(str, "c\":\"", "\""), j.m182do(str, "b\":\"", "\""));
        }
        int m185if2 = j.m185if(str, "rWifiN\":\"", "\"");
        if (m185if2 > 15) {
            j.f188new = m185if2;
        }
        int m185if3 = j.m185if(str, "rWifiT\":\"", "\"");
        if (m185if3 > 500) {
            j.f183for = m185if3;
        }
        float a2 = j.a(str, "hSpeedDis\":\"", "\"");
        if (a2 > 5.0f) {
            j.f179case = a2;
        }
        float a3 = j.a(str, "mSpeedDis\":\"", "\"");
        if (a3 > 5.0f) {
            j.f185if = a3;
        }
        float a4 = j.a(str, "mWifiR\":\"", "\"");
        if (a4 < 1.0f && a4 > 0.2d) {
            j.f180char = a4;
        }
        if (i == 21) {
            m138new();
        }
    }

    private boolean a(c.a aVar) {
        if (this.L == null) {
            return false;
        }
        this.M = this.L.a();
        if (this.M != aVar) {
            if (this.M == null || aVar == null) {
                return true;
            }
            return aVar.a(this.M) ? false : true;
        }
        return false;
    }

    private boolean a(e.c cVar) {
        if (this.k == null) {
            return false;
        }
        this.B = this.k.m105new();
        if (cVar != this.B) {
            if (this.B == null || cVar == null) {
                return true;
            }
            return cVar.a(this.B) ? false : true;
        }
        return false;
    }

    /* renamed from: byte  reason: not valid java name */
    private void m116byte() {
        if (this.T == null || !g.m158if(this)) {
            return;
        }
        g.m152else();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: case  reason: not valid java name */
    public void m118case() {
        j.a(g, "on switch gps ...");
        if (this.H == null) {
            return;
        }
        if (this.H.m32for()) {
            if (this.D == null) {
                this.D = new com.baidu.location.b(this, this.f134do);
            }
            this.D.m61int();
        } else if (this.D != null) {
            this.D.a();
            this.D = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: char  reason: not valid java name */
    public void m120char() {
        if (this.H != null) {
            this.H.m37new();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m122do() {
        if (g.m158if(this)) {
            g.m152else();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m123do(Message message) {
        if (this.H != null) {
            this.H.m31for(message);
        }
        if (this.k != null) {
            this.k.m106try();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: for  reason: not valid java name */
    public void m126for() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: for  reason: not valid java name */
    public void m127for(Message message) {
        if (System.currentTimeMillis() - this.v < 3000) {
            j.a(g, "request too frequency ...");
            if (this.f139void != null) {
                this.H.a(this.f139void, 26);
                return;
            }
        }
        if (this.H != null) {
            String a2 = a(this.H.a(message));
            if (this.h != null) {
                a2 = a2 + this.h;
                this.h = null;
            }
            g.m150do(this);
            if (g.m159if(a2, this.f134do)) {
                this.f137long = this.M;
                this.f136for = this.B;
            } else {
                j.a(g, "request poi error ..");
            }
            this.v = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m130if() {
        j.a(g, "on new wifi ...");
        if (this.r) {
            m134int();
            this.r = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m131if(Message message) {
        if (message == null || message.obj == null) {
            j.a(g, "Gps updateloation is null");
            return;
        }
        Location location = (Location) message.obj;
        if (location != null) {
            j.a(g, "on update gps...");
            if (!k.m194if(location) || this.L == null || this.k == null || this.H == null) {
                return;
            }
            if (this.k != null) {
                this.k.m103for();
            }
            if (j.c) {
                k.a(this.L.a(), this.k.m102do(), location, this.H.m38try());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: int  reason: not valid java name */
    public void m134int() {
        if (this.F) {
            return;
        }
        if (System.currentTimeMillis() - this.i < 1000) {
            j.a(g, "request too frequency ...");
            if (this.T != null) {
                this.H.a(this.T);
                m138new();
                return;
            }
        }
        j.a(g, "start network locating ...");
        j.m188if(g, "start network locating ...");
        this.F = true;
        if (!a(this.b) && !a(this.q) && this.T != null) {
            this.H.a(this.T);
            m138new();
            return;
        }
        String a2 = a((String) null);
        if (a2 == null) {
            this.H.a("{\"result\":{\"time\":\"" + j.a() + "\",\"error\":\"62\"}}");
            m138new();
            return;
        }
        if (this.h != null) {
            a2 = a2 + this.h;
            this.h = null;
        }
        if (g.a(a2, this.f134do)) {
            this.q = this.M;
            this.b = this.B;
        } else {
            j.a(g, "request error ..");
        }
        if (this.f138new) {
            c.a a3 = this.L.a();
            if (a3 == null) {
                return;
            }
            String a4 = h.a(a3.f106if, a3.f105for, a3.f109try);
            if (a4 != null && !a4.equals("")) {
                this.H.a(a4);
            }
            this.f138new = false;
        }
        this.i = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: int  reason: not valid java name */
    public void m135int(Message message) {
        j.a(g, "on request location ...");
        j.m188if(g, "on request location ...");
        if (this.H == null) {
            return;
        }
        if (this.H.m30do(message) == 1 && this.D != null && this.D.m58case()) {
            j.a(g, "send gps location to client ...");
            this.H.a(this.D.m60if(), message);
        } else if (this.f138new) {
            m134int();
        } else if (this.k == null || !this.k.m103for()) {
            m134int();
        } else {
            this.r = true;
            this.f134do.postDelayed(new a(), 2000L);
        }
    }

    /* renamed from: new  reason: not valid java name */
    private void m138new() {
        this.F = false;
        m116byte();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: new  reason: not valid java name */
    public void m139new(Message message) {
        if (this.H != null) {
            this.H.m34if(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: try  reason: not valid java name */
    public void m142try() {
        j.a(g, "on new cell ...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: try  reason: not valid java name */
    public void m143try(Message message) {
        if (this.H != null) {
            this.H.m36int(message);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.n.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        this.L = new c(this, this.f134do);
        this.k = new e(this, this.f134do);
        this.H = new com.baidu.location.a(this.f134do);
        this.L.m87do();
        this.k.m104int();
        this.f135else = true;
        this.F = false;
        this.r = false;
        j.a(g, "onCreate");
        Log.d(g, "baidu location service start1 ..." + Process.myPid());
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.L != null) {
            this.L.m86byte();
        }
        if (this.k != null) {
            this.k.m101case();
        }
        if (this.D != null) {
            this.D.a();
        }
        k.m192if();
        h.m168if();
        this.F = false;
        this.r = false;
        this.f135else = false;
        j.a(g, "onDestroy");
        Log.d(g, "baidu location service stop ...");
    }
}
