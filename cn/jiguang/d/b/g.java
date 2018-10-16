package cn.jiguang.d.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.api.SdkType;
import cn.jiguang.d.h.t;
import cn.jpush.android.api.JPushInterface;
import com.baidu.ar.audio.AudioParams;
import com.baidu.ar.constants.HttpConstants;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes3.dex */
public final class g implements Runnable {
    public static AtomicLong a = new AtomicLong(0);
    public static AtomicBoolean lB = new AtomicBoolean(false);
    private Context c;
    private Handler d;
    private volatile boolean e = false;
    private boolean f = true;
    private ExecutorService lC;

    public g(Context context, Handler handler) {
        this.c = context;
        this.d = handler;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x00f2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0204  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(int i) {
        boolean z;
        boolean z2;
        int i2;
        while (!this.e) {
            if (i <= 0) {
                cn.jiguang.e.c.a("NetworkingClient", "login error,retry login too many times");
                return false;
            }
            if (!cn.jiguang.d.a.d.d(this.c) || TextUtils.isEmpty(cn.jiguang.d.a.d.e(this.c))) {
                Context context = this.c;
                a.get();
                String a2 = cn.jiguang.d.h.e.ci().a();
                String str = cn.jiguang.d.h.e.ci().a;
                String b = cn.jiguang.d.h.e.ci().b();
                String c = cn.jiguang.d.h.e.ci().c();
                short c2 = cn.jiguang.d.d.i.bX().c();
                String m = cn.jiguang.d.a.d.m(context);
                long f = cn.jiguang.d.a.a.f();
                int abs = Math.abs(new Random().nextInt());
                cn.jiguang.d.h.a.a.a(abs);
                cn.jiguang.api.a.b bVar = new cn.jiguang.api.a.b(AudioParams.DEFAULT_AUDIO_BUFFER_SIZE);
                bVar.l(0);
                bVar.k(16);
                bVar.k(0);
                bVar.h(f);
                bVar.g(abs);
                bVar.h(0L);
                bVar.f(a2.getBytes());
                bVar.f(str.getBytes());
                bVar.f(b.getBytes());
                bVar.k(0);
                bVar.f(c.getBytes());
                cn.jiguang.d.d.i.bX().d();
                bVar.k(c2);
                bVar.f(m.getBytes());
                bVar.l(bVar.current(), 0);
                byte[] a3 = cn.jiguang.d.e.a.a.b.a(bVar.toByteArray(), 0);
                if (a3 == null) {
                    z = false;
                } else if (cn.jiguang.d.g.c.cg().ch().j(a3) != 0) {
                    z = false;
                } else {
                    cn.jiguang.d.g.d o = cn.jiguang.d.g.c.cg().ch().o(HttpConstants.HTTP_CONNECT_TIMEOUT);
                    if (o.a() != 0) {
                        cn.jiguang.e.c.c("ConnectingHelper", "Register failed - recv msg failed with error code:" + o.a() + ",msg:" + o.c());
                        z = false;
                    } else {
                        cn.jiguang.api.h h = cn.jiguang.d.e.a.a.a.h(o.ce().array());
                        if (h == null) {
                            z = false;
                        } else if (h.getCommand() != 0) {
                            z = false;
                        } else {
                            cn.jiguang.d.e.a.f fVar = (cn.jiguang.d.e.a.f) h;
                            int i3 = fVar.code;
                            cn.jiguang.d.a.a.a(context, i3);
                            d.bO().b(i3);
                            if (i3 == 0) {
                                long juid = fVar.getJuid();
                                String a4 = fVar.a();
                                String b2 = fVar.b();
                                String c3 = fVar.c();
                                cn.jiguang.e.c.b("ConnectingHelper", "Register succeed - juid:" + juid + ", registrationId:" + b2 + ", deviceId:" + c3);
                                if (cn.jiguang.g.i.a(b2) || 0 == juid) {
                                    cn.jiguang.e.c.d("ConnectingHelper", "Unexpected: registrationId/juid should not be empty. ");
                                    z = false;
                                } else {
                                    cn.jiguang.g.a.f(context, c3);
                                    cn.jiguang.d.a.d.a(context, juid, a4, b2, c3);
                                    cn.jiguang.g.a.a(context, JPushInterface.ACTION_REGISTRATION_ID, JPushInterface.EXTRA_REGISTRATION_ID, b2);
                                    z = true;
                                }
                            } else {
                                cn.jiguang.d.d.g.a(context, i3, true);
                                z = false;
                            }
                        }
                    }
                }
                if (z) {
                    cn.jiguang.a.a.c.b.b(this.c, cn.jiguang.d.h.e.ci());
                    if (cn.jiguang.d.a.a.j()) {
                        cn.jiguang.d.a.a.h();
                    }
                    cn.jiguang.d.i.f.ck().cl().b(cn.jiguang.d.a.d.c(this.c));
                } else {
                    if (cn.jiguang.d.a.a.j()) {
                        this.d.sendEmptyMessageDelayed(1001, 100L);
                    }
                    f();
                    z2 = false;
                    if (z2) {
                        return false;
                    }
                    Context context2 = this.c;
                    a.get();
                    long c4 = cn.jiguang.d.a.d.c(context2);
                    String b3 = cn.jiguang.g.i.b(cn.jiguang.d.a.d.e(context2));
                    if (b3 == null) {
                        b3 = "";
                    }
                    String b4 = cn.jiguang.d.a.b(context2);
                    cn.jiguang.d.d.e.bU();
                    String j = cn.jiguang.d.d.e.j(SdkType.JCORE.name(), "");
                    int d = TextUtils.isEmpty(j) ? 0 : cn.jiguang.g.a.d(j);
                    cn.jiguang.d.d.e.bU();
                    String j2 = cn.jiguang.d.d.e.j(SdkType.JANALYTICS.name(), "");
                    int d2 = TextUtils.isEmpty(j2) ? 0 : cn.jiguang.g.a.d(j2);
                    cn.jiguang.d.d.e.bU();
                    String j3 = cn.jiguang.d.d.e.j(SdkType.JSHARE.name(), "");
                    int d3 = TextUtils.isEmpty(j3) ? 0 : cn.jiguang.g.a.d(j3);
                    cn.jiguang.d.d.e.bU();
                    String j4 = cn.jiguang.d.d.e.j(SdkType.JPUSH.name(), "");
                    int d4 = TextUtils.isEmpty(j4) ? 0 : cn.jiguang.g.a.d(j4);
                    cn.jiguang.d.d.e.bU();
                    String j5 = cn.jiguang.d.d.e.j(SdkType.JSSP.name(), "");
                    int d5 = TextUtils.isEmpty(j5) ? 0 : cn.jiguang.g.a.d(j5);
                    cn.jiguang.d.h.e.ci();
                    byte an = cn.jiguang.d.h.e.an(context2);
                    cn.jiguang.e.c.b("ConnectingHelper", "Login with - juid:" + c4 + ", appKey:" + b4 + ", sdkVersion:" + d + ", pushVersion:" + d4 + ", analyticsVersion:" + d2 + " ,shareVersion:" + d3 + ",sspSdkVer:" + d5 + ", pluginPlatformType:" + ((int) an));
                    short d6 = cn.jiguang.d.d.i.bX().d();
                    int a5 = cn.jiguang.g.k.a(context2);
                    String i4 = cn.jiguang.g.a.i(context2);
                    cn.jiguang.a.a.b.e R = cn.jiguang.a.a.b.f.R(context2);
                    String e = R != null ? R.e() : "";
                    String c5 = cn.jiguang.g.i.c(String.format(Locale.ENGLISH, cn.jiguang.c.c.a(context2), new Object[0]));
                    String upperCase = c5 == null ? "" : c5.toUpperCase();
                    String m2 = cn.jiguang.d.a.d.m(context2);
                    long f2 = cn.jiguang.d.a.a.f();
                    long j6 = d;
                    cn.jiguang.api.a.b bVar2 = new cn.jiguang.api.a.b(AudioParams.DEFAULT_AUDIO_BUFFER_SIZE);
                    bVar2.l(0);
                    bVar2.k(21);
                    bVar2.k(1);
                    bVar2.h(f2);
                    bVar2.g(0L);
                    bVar2.h(c4);
                    bVar2.k(97);
                    bVar2.k(0);
                    bVar2.l(0);
                    bVar2.f(b3.getBytes());
                    bVar2.g(d4);
                    bVar2.g(d2);
                    bVar2.g(d3);
                    bVar2.g(j6);
                    bVar2.g(d5);
                    bVar2.f(b4.getBytes());
                    bVar2.k(0);
                    bVar2.k(d6);
                    bVar2.k(an);
                    bVar2.k(a5);
                    bVar2.f(i4.getBytes());
                    bVar2.f(e.getBytes());
                    bVar2.f(upperCase.getBytes());
                    bVar2.f(m2.getBytes());
                    bVar2.l(bVar2.current(), 0);
                    byte[] a6 = cn.jiguang.d.e.a.a.b.a(bVar2.toByteArray(), 1);
                    if (a6 == null || a6.length <= 0) {
                        i2 = -1;
                    } else if (cn.jiguang.d.g.c.cg().ch().j(a6) != 0) {
                        i2 = -1;
                    } else {
                        cn.jiguang.d.g.d o2 = cn.jiguang.d.g.c.cg().ch().o(HttpConstants.HTTP_CONNECT_TIMEOUT);
                        if (o2.a() != 0) {
                            cn.jiguang.e.c.c("ConnectingHelper", "Login failed - recv msg failed wit error code:" + o2.a() + ",msg:" + o2.c());
                            i2 = -1;
                        } else {
                            cn.jiguang.api.h h2 = cn.jiguang.d.e.a.a.a.h(o2.ce().array());
                            if (h2 == null) {
                                cn.jiguang.e.c.c("ConnectingHelper", "Login failed - unknown command");
                                i2 = -1;
                            } else if (h2 instanceof cn.jiguang.d.e.a.e) {
                                cn.jiguang.d.e.a.e eVar = (cn.jiguang.d.e.a.e) h2;
                                int i5 = eVar.code;
                                d.bO().a(i5);
                                if (i5 == 0) {
                                    int sid = eVar.getSid();
                                    long a7 = eVar.a() * 1000;
                                    cn.jiguang.d.a.d.a(context2, sid);
                                    cn.jiguang.d.a.a.b(a7);
                                    cn.jiguang.e.c.b("ConnectingHelper", "Login succeed - sid:" + sid + ", serverTime;" + a7);
                                    cn.jiguang.d.d.g.a(context2, a7);
                                } else if (i5 == 10000) {
                                    cn.jiguang.e.c.c("ConnectingHelper", "Login failed with Local error - code:" + i5);
                                } else {
                                    cn.jiguang.e.c.c("ConnectingHelper", "Login failed with server error - code:" + cn.jiguang.g.h.a(i5));
                                }
                                i2 = i5;
                            } else {
                                cn.jiguang.e.c.c("ConnectingHelper", "Login failed - it is not LoginResponse");
                                i2 = -1;
                            }
                        }
                    }
                    if (i2 < 0) {
                        return false;
                    }
                    if (i2 <= 0) {
                        if (0 != a.get()) {
                            cn.jiguang.d.d.g.a(Message.obtain(this.d, 7304), a.get());
                            if (cn.jiguang.d.d.i.bX().b(this.c)) {
                                return true;
                            }
                            cn.jiguang.e.c.a("NetworkingClient", "need not keep tcp connect,will close connection");
                            return false;
                        }
                        return false;
                    }
                    cn.jiguang.d.d.g.a(Message.obtain(this.d, 7306), a.get());
                    if (i2 != 108) {
                        if (i2 == 102) {
                            cn.jiguang.d.a.a.i();
                            this.d.sendEmptyMessageDelayed(1003, 100L);
                        } else if (i2 == 1012) {
                            cn.jiguang.d.a.a.a();
                        }
                        return false;
                    }
                    cn.jiguang.g.a.n(this.c);
                    i--;
                }
            }
            z2 = true;
            if (z2) {
            }
        }
        return false;
    }

    private boolean a(Context context) {
        cn.jiguang.d.h.e.ci().a(context);
        try {
            a.set(Thread.currentThread().getId());
            cn.jiguang.d.b.a.a.f fVar = new cn.jiguang.d.b.a.a.f(context, this, a.get());
            if (fVar.b() != 0) {
                fVar.a();
                f();
                return false;
            } else if (a(2)) {
                fVar.a();
                return true;
            } else {
                fVar.a();
                f();
                return false;
            }
        } catch (UnsatisfiedLinkError e) {
            cn.jiguang.e.c.b("NetworkingClient", "长连接失败, jpush.so加载异常", e);
            return false;
        }
    }

    private void f() {
        cn.jiguang.e.c.a("NetworkingClient", "Action - closeConnection - connection:" + a.get());
        if (0 != a.get()) {
            try {
                lB.set(true);
                a.set(0L);
                cn.jiguang.d.g.c.cg().ch().a();
                lB.set(false);
            } catch (Exception e) {
            }
            this.f = false;
            if (cn.jiguang.d.d.i.bX().f()) {
                cn.jiguang.d.d.g.a(Message.obtain(this.d, 7301), a.get());
            }
        }
    }

    public final void a() {
        cn.jiguang.e.c.a("NetworkingClient", "Action - tryStop - connection:" + a.get());
        this.e = true;
        this.f = false;
        if (a.get() != 0) {
            cn.jiguang.d.g.c.cg().ch().a();
        }
    }

    public final synchronized void b() {
        if (this.f) {
            this.lC = Executors.newSingleThreadExecutor();
            this.lC.execute(this);
        }
    }

    public final synchronized void c() {
        a();
        t.a(this.lC);
    }

    public final boolean d() {
        return this.e;
    }

    public final boolean e() {
        return this.f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        cn.jiguang.e.c.b("NetworkingClient", "Begin to run in ConnectingThread - id:" + Thread.currentThread().getId());
        try {
        } catch (Throwable th) {
            cn.jiguang.e.c.c("NetworkingClient", "run exception", th);
        }
        if (!a(this.c)) {
            cn.jiguang.e.c.a("NetworkingClient", "prepare Push Channel failed , returned");
            return;
        }
        do {
            if (!this.e) {
                cn.jiguang.e.c.a("NetworkingClient", "Network listening...");
                cn.jiguang.d.g.d o = cn.jiguang.d.g.c.cg().ch().o(0);
                if (o != null) {
                    if (o.a() != 0) {
                        cn.jiguang.e.c.a("NetworkingClient", " recv failed with error code:" + o.a() + ",msg:" + o.c() + ",No Break!!");
                    } else {
                        ByteBuffer ce = o.ce();
                        int length = ce.array().length;
                        byte[] bArr = new byte[length];
                        System.arraycopy(ce.array(), 0, bArr, 0, length);
                        cn.jiguang.d.e.a.a.a.b(this.c, bArr);
                        cn.jiguang.e.c.a("NetworkingClient", "Received bytes - len:" + ce.array().length + ", connection:" + a.get() + ", pkg:" + cn.jiguang.d.a.c);
                    }
                }
            }
            if (this.e) {
                cn.jiguang.e.c.a("NetworkingClient", "Break receiving by wantStop - connection:" + a.get());
            }
            f();
            return;
        } while (0 != a.get());
        cn.jiguang.e.c.c("NetworkingClient", "mConnection is reset to 0 when network listening. Break now.");
    }
}
