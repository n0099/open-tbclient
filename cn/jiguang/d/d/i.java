package cn.jiguang.d.d;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.SdkType;
import com.baidu.ar.audio.AudioParams;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class i {
    private static final Object g = new Object();
    private static volatile i lv;
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private Map<Long, String> h = new HashMap();

    private i() {
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.a = g();
        this.b = h();
        this.c = i();
        this.d = j();
        this.e = k();
    }

    private static String a(Context context, String str) {
        e.bD();
        String j = e.j(str, "");
        return (TextUtils.isEmpty(j) || j.equals(cn.jiguang.d.a.d.b(context, str))) ? "" : j;
    }

    private void a(short s, String str, String str2) {
        long c = cn.jiguang.d.a.d.c(null);
        int a = cn.jiguang.d.a.d.a();
        long f = cn.jiguang.d.a.a.f();
        cn.jiguang.api.a.b bVar = new cn.jiguang.api.a.b(AudioParams.DEFAULT_AUDIO_BUFFER_SIZE);
        bVar.l(0);
        bVar.k(0);
        bVar.k(26);
        bVar.h(f);
        bVar.g(a);
        bVar.h(c);
        bVar.k(s);
        bVar.k(1);
        bVar.f(str.getBytes());
        bVar.l(bVar.current(), 0);
        byte[] byteArray = bVar.toByteArray();
        cn.jiguang.d.b.d.bx();
        cn.jiguang.d.b.d.a(byteArray, SdkType.JCORE.name(), 0);
        this.h.put(Long.valueOf(f), str2);
    }

    public static i bG() {
        if (lv == null) {
            synchronized (g) {
                if (lv == null) {
                    lv = new i();
                }
            }
        }
        return lv;
    }

    public static boolean e() {
        e.bD();
        return e.a(0);
    }

    private static boolean g() {
        try {
            Class.forName("cn.jpush.android.api.JPushInterface");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private static boolean h() {
        try {
            Class.forName("cn.jpush.im.android.api.JMessageClient");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private static boolean i() {
        try {
            Class.forName("cn.jiguang.analytics.android.api.JAnalyticsInterface");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private static boolean j() {
        try {
            Class.forName("cn.jiguang.share.android.api.JShareInterface");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private static boolean k() {
        try {
            Class.forName("cn.jiguang.adsdk.api.JSSPInterface");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public final void a(Context context) {
        if (context == null) {
            return;
        }
        String a = a(context, SdkType.JPUSH.name());
        String a2 = a(context, SdkType.JMESSAGE.name());
        String a3 = a(context, SdkType.JANALYTICS.name());
        String a4 = a(context, SdkType.JSHARE.name());
        String a5 = a(context, SdkType.JSSP.name());
        if (!TextUtils.isEmpty(a)) {
            a((short) 1, a, SdkType.JPUSH.name());
        }
        if (!TextUtils.isEmpty(a2)) {
            a((short) 2, a2, SdkType.JMESSAGE.name());
        }
        if (!TextUtils.isEmpty(a3)) {
            a((short) 4, a3, SdkType.JANALYTICS.name());
        }
        if (!TextUtils.isEmpty(a4)) {
            a((short) 5, a4, SdkType.JSHARE.name());
        }
        if (TextUtils.isEmpty(a5)) {
            return;
        }
        a((short) 9, a5, SdkType.JSSP.name());
    }

    public final void a(Context context, long j) {
        String remove = this.h.remove(Long.valueOf(j));
        if (!TextUtils.isEmpty(remove)) {
            e.bD();
            TextUtils.isEmpty(e.j(remove, ""));
        }
        if ((this.h != null && !this.h.isEmpty()) || this.b || this.a) {
            return;
        }
        cn.jiguang.d.b.d.bx().c();
    }

    public final void b(Context context, long j) {
        String remove = this.h.remove(Long.valueOf(j));
        if (!TextUtils.isEmpty(remove)) {
            e.bD();
            String j2 = e.j(remove, "");
            if (!TextUtils.isEmpty(j2)) {
                cn.jiguang.d.a.d.a(context, remove, j2);
            }
        }
        if (b(context)) {
            return;
        }
        cn.jiguang.d.b.d.bx().c();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(Context context) {
        boolean z;
        if (!this.b && !this.a) {
            if (context == null) {
                cn.jiguang.e.c.c("JClientsHelper", "get isNeedUserCtrl failed,context is null");
            } else {
                if (this.c && !TextUtils.isEmpty(a(context, SdkType.JANALYTICS.name()))) {
                    z = true;
                } else if (this.d && !TextUtils.isEmpty(a(context, SdkType.JSHARE.name()))) {
                    z = true;
                } else if (this.a && !TextUtils.isEmpty(a(context, SdkType.JPUSH.name()))) {
                    z = true;
                } else if (this.b && !TextUtils.isEmpty(a(context, SdkType.JMESSAGE.name()))) {
                    z = true;
                }
                if (!z) {
                    return false;
                }
            }
            z = false;
            if (!z) {
            }
        }
        return true;
    }

    public final short bH() {
        short s = this.a ? (short) 1 : (short) 0;
        return this.b ? (cn.jiguang.d.a.a.u() >= 0 || cn.jiguang.d.a.a.t()) ? (short) (s | 32) : (short) (s | 64) : s;
    }

    public final short c() {
        short s = this.a ? (short) 1 : (short) 0;
        if (this.c) {
            s = (short) (s | 4);
        }
        if (this.d) {
            s = (short) (s | 8);
        }
        if (this.b) {
            s = (short) (s | 32);
        }
        return this.e ? (short) (s | 128) : s;
    }

    public final void c(Context context, long j) {
        this.h.remove(Long.valueOf(j));
        if ((this.h != null && !this.h.isEmpty()) || this.b || this.a) {
            return;
        }
        cn.jiguang.d.b.d.bx().c();
    }

    public final short d() {
        short s = this.a ? (short) 1 : (short) 0;
        if (this.b) {
            s = (cn.jiguang.d.a.a.u() >= 0 || cn.jiguang.d.a.a.t()) ? (short) (s | 32) : (short) (s | 64);
        }
        if (this.c) {
            s = (short) (s | 4);
        }
        if (this.d) {
            s = (short) (s | 8);
        }
        return this.e ? (short) (s | 128) : s;
    }

    public final boolean f() {
        return this.b || this.a;
    }
}
