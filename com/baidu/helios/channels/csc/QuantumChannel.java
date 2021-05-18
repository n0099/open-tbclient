package com.baidu.helios.channels.csc;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.helios.channels.csc.d;
import d.a.q.e.a;
import d.a.q.e.c.a;
import d.a.q.g.d.a;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class QuantumChannel extends d.a.q.e.a {
    public static final int j = d.a.q.e.c.a.a(160);
    public static final int k = d.a.q.e.c.a.a(8);

    /* renamed from: f  reason: collision with root package name */
    public a.C1785a f6282f;

    /* renamed from: g  reason: collision with root package name */
    public d f6283g;

    /* renamed from: h  reason: collision with root package name */
    public f f6284h;

    /* renamed from: i  reason: collision with root package name */
    public c f6285i;

    /* loaded from: classes2.dex */
    public static class b extends Exception {
        public b(String str) {
            super(str);
        }

        public b(String str, Throwable th) {
            super(str, th);
        }

        public b(Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f6286a;

        /* renamed from: b  reason: collision with root package name */
        public String f6287b;

        /* renamed from: c  reason: collision with root package name */
        public String f6288c;

        public c() {
            d.a.q.g.b.b bVar = new d.a.q.g.b.b();
            try {
                this.f6286a = new String(bVar.a(d.a.q.e.c.b.e()));
                this.f6287b = new String(bVar.a(d.a.q.e.c.b.f()));
                this.f6288c = new String(bVar.a(d.a.q.e.c.b.g()));
            } catch (Exception unused) {
                throw new IllegalStateException("");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public int f6289a;

        /* renamed from: b  reason: collision with root package name */
        public long f6290b;

        /* renamed from: d  reason: collision with root package name */
        public long f6292d;

        /* renamed from: e  reason: collision with root package name */
        public String f6293e;

        /* renamed from: c  reason: collision with root package name */
        public d.a.q.g.c.a.e f6291c = new d.a.q.g.c.a.e();

        /* renamed from: f  reason: collision with root package name */
        public boolean f6294f = true;

        public d() {
        }

        public int a() {
            return this.f6289a;
        }

        public void b(int i2) {
            if (this.f6289a != i2) {
                this.f6289a = i2;
                this.f6294f = true;
            }
        }

        public void c(long j) {
            if (this.f6290b != j) {
                this.f6290b = j;
                this.f6294f = true;
            }
        }

        public boolean d(long j, long j2) {
            if (this.f6291c.c(j, j2)) {
                this.f6294f = true;
                return true;
            }
            return false;
        }

        public boolean e(String str) {
            String str2 = this.f6293e;
            if (str2 == str) {
                return false;
            }
            if (str == null || !str.equals(str2)) {
                this.f6294f = true;
                this.f6293e = str;
                return true;
            }
            return false;
        }

        public long f(long j) {
            return this.f6291c.a(j);
        }

        public long g() {
            return this.f6292d;
        }

        public boolean h(long j) {
            if (this.f6292d != j) {
                this.f6292d = j;
                this.f6294f = true;
                return true;
            }
            return false;
        }

        public String i() {
            return this.f6293e;
        }

        public void j() {
            String g2 = QuantumChannel.this.f6282f.g("pub.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f6289a = jSONObject.getInt("pub_ver");
                this.f6290b = jSONObject.getLong("pub_lst_ts");
                this.f6292d = jSONObject.getLong("pkg_lst_up_ts");
                this.f6291c.b(jSONObject.getLong("flags"));
                jSONObject.getInt("d_form_ver");
                this.f6293e = jSONObject.optString("aid");
                this.f6294f = false;
            } catch (Exception unused) {
                this.f6294f = true;
            }
        }

        public boolean k() {
            if (this.f6294f) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pub_ver", this.f6289a);
                    jSONObject.put("pub_lst_ts", this.f6290b);
                    jSONObject.put("pkg_lst_up_ts", this.f6292d);
                    jSONObject.put("flags", this.f6291c.d());
                    jSONObject.put("d_form_ver", 1);
                    jSONObject.put("aid", this.f6293e);
                    QuantumChannel.this.f6282f.i("pub.dat", jSONObject.toString(), true);
                    this.f6294f = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public a.C1779a f6296a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f6297b;

        /* loaded from: classes2.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public int f6298a = 160;

            /* renamed from: b  reason: collision with root package name */
            public byte[] f6299b = new byte[160];

            /* renamed from: c  reason: collision with root package name */
            public int f6300c;

            public a a(byte b2) {
                c(this.f6300c + 1);
                byte[] bArr = this.f6299b;
                int i2 = this.f6300c;
                this.f6300c = i2 + 1;
                bArr[i2] = b2;
                return this;
            }

            public e b() {
                return new e(Arrays.copyOf(this.f6299b, this.f6300c));
            }

            public final void c(int i2) {
                byte[] bArr = this.f6299b;
                if (i2 - bArr.length > 0) {
                    int length = bArr.length;
                    int i3 = length + (length >> 1);
                    if (i3 - i2 >= 0) {
                        i2 = i3;
                    }
                    this.f6299b = Arrays.copyOf(this.f6299b, i2);
                }
            }
        }

        public e(byte[] bArr) {
            this.f6297b = bArr;
            this.f6296a = d.a.q.e.c.a.b(bArr);
        }

        public static int b(byte b2) {
            if (b2 != 0) {
                if (b2 != 1) {
                    if (b2 == 2) {
                        return 2;
                    }
                    throw new IllegalStateException();
                }
                return 1;
            }
            return 0;
        }

        public static e d(byte[] bArr, int i2) {
            return new e(d.a.q.e.c.a.c(bArr, i2));
        }

        public static byte e(int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return (byte) 2;
                    }
                    throw new g("unexpected value " + i2);
                }
                return (byte) 1;
            }
            return (byte) 0;
        }

        public int a() {
            return this.f6297b.length;
        }

        public int c(int i2) {
            if (i2 >= 0) {
                byte[] bArr = this.f6297b;
                if (i2 < bArr.length) {
                    return b(bArr[i2]);
                }
            }
            throw new IllegalArgumentException("illegal index " + i2 + " with current length is " + this.f6297b.length);
        }

        public byte[] f() {
            return this.f6296a.a();
        }
    }

    /* loaded from: classes2.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public Method f6301a;

        /* renamed from: b  reason: collision with root package name */
        public Method f6302b;

        /* renamed from: c  reason: collision with root package name */
        public Method f6303c;

        /* renamed from: d  reason: collision with root package name */
        public Class<?> f6304d;

        public f(Context context) {
            try {
                d(context);
            } catch (Exception unused) {
                throw new IllegalStateException("");
            }
        }

        public int a(Object obj, Object obj2) {
            try {
                return ((Integer) this.f6302b.invoke(obj, obj2)).intValue();
            } catch (Exception unused) {
                throw new d.a("");
            }
        }

        public Object b(Context context) {
            try {
                return this.f6303c.invoke(context, new Object[0]);
            } catch (Exception unused) {
                throw new d.a("");
            }
        }

        public void c(Object obj, Object obj2, int i2) {
            try {
                this.f6301a.invoke(obj, obj2, Integer.valueOf(i2), 1);
            } catch (Exception unused) {
                throw new d.a("");
            }
        }

        public final void d(Context context) {
            Method d2 = com.baidu.helios.channels.csc.d.d(Context.class, com.baidu.helios.channels.csc.d.c(d.a.q.e.c.b.c()), null);
            this.f6303c = d2;
            Object invoke = d2.invoke(context, new Object[0]);
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "");
            this.f6304d = com.baidu.helios.channels.csc.d.d(intent.getClass(), com.baidu.helios.channels.csc.d.c(d.a.q.e.c.b.d()), null).invoke(intent, new Object[0]).getClass();
            String c2 = com.baidu.helios.channels.csc.d.c(d.a.q.e.c.b.a());
            Class<?> cls = invoke.getClass();
            Class cls2 = Integer.TYPE;
            this.f6301a = com.baidu.helios.channels.csc.d.d(cls, c2, new Class[]{this.f6304d, cls2, cls2});
            this.f6302b = com.baidu.helios.channels.csc.d.d(invoke.getClass(), com.baidu.helios.channels.csc.d.c(d.a.q.e.c.b.b()), new Class[]{this.f6304d});
        }
    }

    /* loaded from: classes2.dex */
    public static class g extends Exception {
        public g(String str) {
            super(str);
        }

        public g(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: classes2.dex */
    public class h extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f6305d;

        /* renamed from: e  reason: collision with root package name */
        public int f6306e;

        /* renamed from: f  reason: collision with root package name */
        public long f6307f;

        /* renamed from: g  reason: collision with root package name */
        public String f6308g;

        public h(QuantumChannel quantumChannel, String str) {
            super(quantumChannel.f6282f, str);
        }

        @Override // d.a.q.e.a.c
        public void c(JSONObject jSONObject) {
            this.f6305d = jSONObject.getString("pkg");
            this.f6306e = jSONObject.getInt("aid_ver");
            this.f6307f = jSONObject.getLong("last_fe_ts");
            this.f6308g = jSONObject.getString("id");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.a.q.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f6305d);
            jSONObject.put("aid_ver", this.f6306e);
            jSONObject.put("last_fe_ts", this.f6307f);
            jSONObject.put("id", this.f6308g);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f6305d;
        }

        public void g(int i2) {
            if (this.f6306e != i2) {
                this.f6306e = i2;
                a(true);
            }
        }

        public void h(long j) {
            if (this.f6307f != j) {
                this.f6307f = j;
                a(true);
            }
        }

        public void i(String str) {
            if (str.equals(this.f6305d)) {
                return;
            }
            this.f6305d = str;
            a(true);
        }

        public int j() {
            return this.f6306e;
        }

        public void k(String str) {
            if (str.equals(this.f6308g)) {
                return;
            }
            this.f6308g = str;
            a(true);
        }

        public String l() {
            return this.f6308g;
        }
    }

    public QuantumChannel() {
        super("csc", 9000000L);
        this.f6283g = new d();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF, IF] complete} */
    @Override // d.a.q.e.a
    public a.h b(String str, a.g gVar) {
        h hVar;
        try {
            Object b2 = this.f6284h.b(this.f64215a.f64219a);
            if (b2 == null) {
                return a.h.b(-101, null);
            }
            if (gVar.f64225a) {
                hVar = new h(this, str);
                hVar.d();
                if (str.equals(hVar.f())) {
                    try {
                        if (hVar.j() == i(b2, str)) {
                            String l = hVar.l();
                            if (!TextUtils.isEmpty(l)) {
                                return a.h.e(l);
                            }
                        }
                    } catch (b e2) {
                        return a.h.c(e2);
                    } catch (g unused) {
                        return a.h.a(-102);
                    } catch (d.a unused2) {
                        return a.h.b(-101, null);
                    }
                }
            } else {
                hVar = null;
            }
            try {
                try {
                    if (!p(b2, str)) {
                        a.h b3 = a.h.b(-2, null);
                        if (gVar.f64225a && hVar != null) {
                            hVar.b();
                        }
                        return b3;
                    }
                    String i2 = d.a.q.h.c.a.i(o(b2, str));
                    int i3 = i(b2, str);
                    if (gVar.f64225a && hVar != null) {
                        hVar.k(i2);
                        hVar.i(str);
                        hVar.h(System.currentTimeMillis());
                        hVar.g(i3);
                    }
                    a.h e3 = a.h.e(i2);
                    if (gVar.f64225a && hVar != null) {
                        hVar.b();
                    }
                    return e3;
                } catch (Throwable th) {
                    if (gVar.f64225a && hVar != null) {
                        hVar.b();
                    }
                    throw th;
                }
            } catch (b e4) {
                a.h c2 = a.h.c(e4);
                if (gVar.f64225a && hVar != null) {
                    hVar.b();
                }
                return c2;
            } catch (g unused3) {
                a.h a2 = a.h.a(-102);
                if (gVar.f64225a && hVar != null) {
                    hVar.b();
                }
                return a2;
            } catch (d.a unused4) {
                a.h b4 = a.h.b(-2, null);
                if (gVar.f64225a && hVar != null) {
                    hVar.b();
                }
                return b4;
            }
        } catch (d.a unused5) {
            return a.h.b(-101, null);
        }
    }

    @Override // d.a.q.e.a
    public void e(a.d dVar) {
        this.f6282f = this.f64216b.f("csc");
        this.f6284h = new f(this.f64215a.f64219a);
        this.f6285i = new c();
    }

    @Override // d.a.q.e.a
    public a.f f(a.e eVar) {
        this.f6283g.j();
        try {
            return j(eVar);
        } finally {
            this.f6283g.k();
        }
    }

    public final int h(Object obj, Object obj2) {
        try {
            return this.f6284h.a(obj, obj2);
        } catch (d.a e2) {
            throw e2;
        } catch (Throwable th) {
            throw new b(th);
        }
    }

    public final int i(Object obj, String str) {
        e.a aVar = new e.a();
        for (int i2 = 0; i2 < k; i2++) {
            aVar.a(e.e(h(obj, n(str, i2))));
        }
        byte[] f2 = aVar.b().f();
        int i3 = 0;
        for (int i4 = 0; i4 < f2.length; i4++) {
            i3 |= (f2[i4] & 255) << (i4 * 8);
        }
        return i3;
    }

    public final a.f j(a.e eVar) {
        Object obj;
        long j2;
        int i2;
        String i3;
        Context context = this.f64215a.f64219a;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            boolean z = packageInfo.lastUpdateTime != this.f6283g.g();
            this.f6283g.h(packageInfo.lastUpdateTime);
            if (!z && this.f6283g.f(6L) == 4) {
                return a.f.b(-101);
            }
            d.a.q.h.a a2 = this.f64215a.f64221c.a("aid");
            try {
                Object b2 = this.f6284h.b(context);
                if (b2 == null) {
                    return a.f.b(-102);
                }
                try {
                    try {
                        if (this.f6283g.f(1L) == 1 && (i3 = this.f6283g.i()) != null && i3.equals(a2.c()) && p(b2, packageName)) {
                            if (this.f6283g.a() == i(b2, packageName)) {
                                return a.f.d();
                            }
                        }
                        byte[] d2 = a2.d();
                        this.f6283g.e(a2.c());
                        e d3 = e.d(d2, d2.length * 8);
                        try {
                            try {
                                int a3 = d3.a();
                                for (int i4 = 0; i4 < a3; i4++) {
                                    try {
                                        m(b2, l(packageName, i4), d3.c(i4));
                                    } catch (b unused) {
                                        i2 = -101;
                                        j2 = 4;
                                        this.f6283g.d(j2, 6L);
                                        return a.f.b(i2);
                                    }
                                }
                                int nextInt = new Random().nextInt(255);
                                this.f6283g.b(nextInt);
                                byte[] bArr = new byte[1];
                                for (int i5 = 0; i5 < 1; i5++) {
                                    bArr[i5] = (byte) ((nextInt >> (i5 * 8)) & 255);
                                }
                                e d4 = e.d(bArr, 8);
                                try {
                                    int a4 = d4.a();
                                    for (int i6 = 0; i6 < a4; i6++) {
                                        m(b2, n(packageName, i6), d4.c(i6));
                                    }
                                    try {
                                        if (i(b2, packageName) != nextInt) {
                                            return a.f.b(-103);
                                        }
                                        try {
                                            m(b2, k(packageName), 1);
                                            this.f6283g.c(System.currentTimeMillis());
                                            this.f6283g.d(1L, 1L);
                                            return a.f.d();
                                        } catch (b unused2) {
                                            this.f6283g.d(4L, 6L);
                                            return a.f.b(-101);
                                        } catch (d.a unused3) {
                                            return a.f.b(-102);
                                        }
                                    } catch (b unused4) {
                                        this.f6283g.d(4L, 6L);
                                        return a.f.b(-101);
                                    } catch (g unused5) {
                                        return a.f.b(-103);
                                    } catch (d.a unused6) {
                                        return a.f.b(-102);
                                    }
                                } catch (b unused7) {
                                    this.f6283g.d(4L, 6L);
                                    return a.f.b(-101);
                                } catch (d.a unused8) {
                                    return a.f.b(-102);
                                }
                            } catch (b unused9) {
                                j2 = 4;
                                i2 = -101;
                            }
                        } catch (d.a unused10) {
                            return a.f.b(-102);
                        }
                    } catch (Exception unused11) {
                        return a.f.b(-103);
                    }
                } catch (b unused12) {
                    this.f6283g.d(4L, 6L);
                    return a.f.b(-101);
                } catch (g unused13) {
                    m(obj, k(packageName), 0);
                    return a.f.b(-103);
                } catch (d.a unused14) {
                    return a.f.b(-102);
                }
            } catch (d.a unused15) {
                return a.f.b(-102);
            }
        } catch (PackageManager.NameNotFoundException unused16) {
            return a.f.b(-100);
        }
    }

    public final Object k(String str) {
        try {
            return com.baidu.helios.channels.csc.d.b(this.f6284h.f6304d, new Object[]{str, this.f6285i.f6287b});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new b("");
        }
    }

    public final Object l(String str, int i2) {
        try {
            Class<?> cls = this.f6284h.f6304d;
            return com.baidu.helios.channels.csc.d.b(cls, new Object[]{str, this.f6285i.f6286a + i2});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new b("");
        }
    }

    public final void m(Object obj, Object obj2, int i2) {
        try {
            this.f6284h.c(obj, obj2, i2);
        } catch (d.a e2) {
            throw e2;
        } catch (Throwable th) {
            throw new b(th);
        }
    }

    public final Object n(String str, int i2) {
        try {
            Class<?> cls = this.f6284h.f6304d;
            return com.baidu.helios.channels.csc.d.b(cls, new Object[]{str, this.f6285i.f6288c + i2});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new b("");
        }
    }

    public final byte[] o(Object obj, String str) {
        e.a aVar = new e.a();
        for (int i2 = 0; i2 < j; i2++) {
            aVar.a(e.e(h(obj, l(str, i2))));
        }
        return aVar.b().f();
    }

    public final boolean p(Object obj, String str) {
        return h(obj, k(str)) == 1;
    }
}
