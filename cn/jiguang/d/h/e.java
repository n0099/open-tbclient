package cn.jiguang.d.h;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.api.SdkType;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public final class e {
    private static final Object mA = new Object();
    private static volatile e mz;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public int l;
    public String m;
    private transient AtomicBoolean my = new AtomicBoolean(false);
    public short n;
    public int o;
    public String p;
    public String q;
    public String r;
    public String s;
    private String u;
    private String v;

    private e() {
    }

    private static String a(String str, String str2) {
        return !cn.jiguang.g.i.a(str) ? str : str2;
    }

    public static byte an(Context context) {
        ArrayList<Object> a = cn.jiguang.d.d.e.bT().a(context, SdkType.JPUSH.name(), 21, "platformtype", 1);
        Object obj = a.size() > 0 ? a.get(0) : null;
        if (obj == null || !(obj instanceof Byte)) {
            return (byte) 0;
        }
        return ((Byte) obj).byteValue();
    }

    public static e ch() {
        if (mz == null) {
            synchronized (mA) {
                if (mz == null) {
                    mz = new e();
                }
            }
        }
        return mz;
    }

    public static String d(Context context) {
        ArrayList<Object> a = cn.jiguang.d.d.e.bT().a(context, SdkType.JPUSH.name(), 21, "platformregid", 1);
        Object obj = a.size() > 0 ? a.get(0) : null;
        return (obj == null || !(obj instanceof String)) ? "" : (String) obj;
    }

    public final String a() {
        return this.u;
    }

    public final void a(Context context) {
        if (this.my.get() || context == null) {
            return;
        }
        b(context);
        this.my.set(true);
    }

    public final String b() {
        return a(this.b, " ") + "$$" + a(this.c, " ") + "$$" + a(this.d, " ") + "$$" + a(this.e, " ") + "$$" + a(this.k, " ") + "$$" + (this.f + "|" + this.g + "|" + this.h + "|" + this.i + "|" + this.j) + "$$" + this.l + "$$" + this.m;
    }

    public final void b(Context context) {
        if (context == null) {
            cn.jiguang.e.c.c("DeviceInfo", "context is null");
            return;
        }
        String g = cn.jiguang.g.a.g(context);
        String e = cn.jiguang.g.a.e(context, "");
        if (TextUtils.isEmpty(g)) {
            g = " ";
        }
        if (TextUtils.isEmpty(e)) {
            e = " ";
        }
        this.u = g + "$$" + e + "$$" + context.getPackageName() + "$$" + cn.jiguang.d.a.b(context);
        this.a = cn.jiguang.d.d.d.a(context);
        this.n = cn.jiguang.d.d.i.bW().c();
        this.b = Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SP + Integer.toString(Build.VERSION.SDK_INT);
        this.c = Build.MODEL;
        this.d = cn.jiguang.g.j.a(context, "gsm.version.baseband", "baseband");
        this.e = Build.DEVICE;
        this.k = cn.jiguang.d.a.a.H("");
        cn.jiguang.d.d.e.bT();
        this.i = cn.jiguang.d.d.e.j(SdkType.JCORE.name(), "");
        cn.jiguang.d.d.e.bT();
        this.g = cn.jiguang.d.d.e.j(SdkType.JANALYTICS.name(), "");
        cn.jiguang.d.d.e.bT();
        this.h = cn.jiguang.d.d.e.j(SdkType.JSHARE.name(), "");
        cn.jiguang.d.d.e.bT();
        this.f = cn.jiguang.d.d.e.j(SdkType.JPUSH.name(), "");
        cn.jiguang.d.d.e.bT();
        this.j = cn.jiguang.d.d.e.j(SdkType.JSSP.name(), "");
        this.l = cn.jiguang.g.a.j(context) ? 1 : 0;
        this.m = cn.jiguang.g.a.a(context);
        this.v = cn.jiguang.g.a.d(context, this.v);
        this.p = cn.jiguang.g.a.i(context);
        this.o = cn.jiguang.g.a.a;
        this.q = cn.jiguang.g.a.h(context);
        this.r = cn.jiguang.g.a.b(context, " ");
        if (!cn.jiguang.g.i.e(this.r)) {
            this.r = " ";
        }
        this.v = cn.jiguang.g.a.d(context, " ");
        this.s = Build.SERIAL;
        cn.jiguang.d.a.a.a(this.v, this.q, this.r);
    }

    public final String c() {
        return this.o + "$$" + a(this.p, " ") + "$$" + a(this.v, " ") + "$$" + a(this.q, " ") + "$$" + a(this.r, " ") + "$$" + a("unknown".equalsIgnoreCase(this.s) ? " " : this.s, " ");
    }
}
