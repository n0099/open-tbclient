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
    public a.C1788a f6182f;

    /* renamed from: g  reason: collision with root package name */
    public d f6183g;

    /* renamed from: h  reason: collision with root package name */
    public f f6184h;

    /* renamed from: i  reason: collision with root package name */
    public c f6185i;

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
        public String f6186a;

        /* renamed from: b  reason: collision with root package name */
        public String f6187b;

        /* renamed from: c  reason: collision with root package name */
        public String f6188c;

        public c() {
            d.a.q.g.b.b bVar = new d.a.q.g.b.b();
            try {
                this.f6186a = new String(bVar.a(d.a.q.e.c.b.e()));
                this.f6187b = new String(bVar.a(d.a.q.e.c.b.f()));
                this.f6188c = new String(bVar.a(d.a.q.e.c.b.g()));
            } catch (Exception unused) {
                throw new IllegalStateException("");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public int f6189a;

        /* renamed from: b  reason: collision with root package name */
        public long f6190b;

        /* renamed from: d  reason: collision with root package name */
        public long f6192d;

        /* renamed from: e  reason: collision with root package name */
        public String f6193e;

        /* renamed from: c  reason: collision with root package name */
        public d.a.q.g.c.a.e f6191c = new d.a.q.g.c.a.e();

        /* renamed from: f  reason: collision with root package name */
        public boolean f6194f = true;

        public d() {
        }

        public int a() {
            return this.f6189a;
        }

        public void b(int i2) {
            if (this.f6189a != i2) {
                this.f6189a = i2;
                this.f6194f = true;
            }
        }

        public void c(long j) {
            if (this.f6190b != j) {
                this.f6190b = j;
                this.f6194f = true;
            }
        }

        public boolean d(long j, long j2) {
            if (this.f6191c.c(j, j2)) {
                this.f6194f = true;
                return true;
            }
            return false;
        }

        public boolean e(String str) {
            String str2 = this.f6193e;
            if (str2 == str) {
                return false;
            }
            if (str == null || !str.equals(str2)) {
                this.f6194f = true;
                this.f6193e = str;
                return true;
            }
            return false;
        }

        public long f(long j) {
            return this.f6191c.a(j);
        }

        public long g() {
            return this.f6192d;
        }

        public boolean h(long j) {
            if (this.f6192d != j) {
                this.f6192d = j;
                this.f6194f = true;
                return true;
            }
            return false;
        }

        public String i() {
            return this.f6193e;
        }

        public void j() {
            String g2 = QuantumChannel.this.f6182f.g("pub.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f6189a = jSONObject.getInt("pub_ver");
                this.f6190b = jSONObject.getLong("pub_lst_ts");
                this.f6192d = jSONObject.getLong("pkg_lst_up_ts");
                this.f6191c.b(jSONObject.getLong("flags"));
                jSONObject.getInt("d_form_ver");
                this.f6193e = jSONObject.optString("aid");
                this.f6194f = false;
            } catch (Exception unused) {
                this.f6194f = true;
            }
        }

        public boolean k() {
            if (this.f6194f) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pub_ver", this.f6189a);
                    jSONObject.put("pub_lst_ts", this.f6190b);
                    jSONObject.put("pkg_lst_up_ts", this.f6192d);
                    jSONObject.put("flags", this.f6191c.d());
                    jSONObject.put("d_form_ver", 1);
                    jSONObject.put("aid", this.f6193e);
                    QuantumChannel.this.f6182f.i("pub.dat", jSONObject.toString(), true);
                    this.f6194f = false;
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
        public a.C1782a f6196a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f6197b;

        /* loaded from: classes2.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public int f6198a = 160;

            /* renamed from: b  reason: collision with root package name */
            public byte[] f6199b = new byte[160];

            /* renamed from: c  reason: collision with root package name */
            public int f6200c;

            public a a(byte b2) {
                c(this.f6200c + 1);
                byte[] bArr = this.f6199b;
                int i2 = this.f6200c;
                this.f6200c = i2 + 1;
                bArr[i2] = b2;
                return this;
            }

            public e b() {
                return new e(Arrays.copyOf(this.f6199b, this.f6200c));
            }

            public final void c(int i2) {
                byte[] bArr = this.f6199b;
                if (i2 - bArr.length > 0) {
                    int length = bArr.length;
                    int i3 = length + (length >> 1);
                    if (i3 - i2 >= 0) {
                        i2 = i3;
                    }
                    this.f6199b = Arrays.copyOf(this.f6199b, i2);
                }
            }
        }

        public e(byte[] bArr) {
            this.f6197b = bArr;
            this.f6196a = d.a.q.e.c.a.b(bArr);
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
            return this.f6197b.length;
        }

        public int c(int i2) {
            if (i2 >= 0) {
                byte[] bArr = this.f6197b;
                if (i2 < bArr.length) {
                    return b(bArr[i2]);
                }
            }
            throw new IllegalArgumentException("illegal index " + i2 + " with current length is " + this.f6197b.length);
        }

        public byte[] f() {
            return this.f6196a.a();
        }
    }

    /* loaded from: classes2.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public Method f6201a;

        /* renamed from: b  reason: collision with root package name */
        public Method f6202b;

        /* renamed from: c  reason: collision with root package name */
        public Method f6203c;

        /* renamed from: d  reason: collision with root package name */
        public Class<?> f6204d;

        public f(Context context) {
            try {
                d(context);
            } catch (Exception unused) {
                throw new IllegalStateException("");
            }
        }

        public int a(Object obj, Object obj2) {
            try {
                return ((Integer) this.f6202b.invoke(obj, obj2)).intValue();
            } catch (Exception unused) {
                throw new d.a("");
            }
        }

        public Object b(Context context) {
            try {
                return this.f6203c.invoke(context, new Object[0]);
            } catch (Exception unused) {
                throw new d.a("");
            }
        }

        public void c(Object obj, Object obj2, int i2) {
            try {
                this.f6201a.invoke(obj, obj2, Integer.valueOf(i2), 1);
            } catch (Exception unused) {
                throw new d.a("");
            }
        }

        public final void d(Context context) {
            Method d2 = com.baidu.helios.channels.csc.d.d(Context.class, com.baidu.helios.channels.csc.d.c(d.a.q.e.c.b.c()), null);
            this.f6203c = d2;
            Object invoke = d2.invoke(context, new Object[0]);
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "");
            this.f6204d = com.baidu.helios.channels.csc.d.d(intent.getClass(), com.baidu.helios.channels.csc.d.c(d.a.q.e.c.b.d()), null).invoke(intent, new Object[0]).getClass();
            String c2 = com.baidu.helios.channels.csc.d.c(d.a.q.e.c.b.a());
            Class<?> cls = invoke.getClass();
            Class cls2 = Integer.TYPE;
            this.f6201a = com.baidu.helios.channels.csc.d.d(cls, c2, new Class[]{this.f6204d, cls2, cls2});
            this.f6202b = com.baidu.helios.channels.csc.d.d(invoke.getClass(), com.baidu.helios.channels.csc.d.c(d.a.q.e.c.b.b()), new Class[]{this.f6204d});
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
        public String f6205d;

        /* renamed from: e  reason: collision with root package name */
        public int f6206e;

        /* renamed from: f  reason: collision with root package name */
        public long f6207f;

        /* renamed from: g  reason: collision with root package name */
        public String f6208g;

        public h(QuantumChannel quantumChannel, String str) {
            super(quantumChannel.f6182f, str);
        }

        @Override // d.a.q.e.a.c
        public void c(JSONObject jSONObject) {
            this.f6205d = jSONObject.getString("pkg");
            this.f6206e = jSONObject.getInt("aid_ver");
            this.f6207f = jSONObject.getLong("last_fe_ts");
            this.f6208g = jSONObject.getString("id");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.a.q.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f6205d);
            jSONObject.put("aid_ver", this.f6206e);
            jSONObject.put("last_fe_ts", this.f6207f);
            jSONObject.put("id", this.f6208g);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f6205d;
        }

        public void g(int i2) {
            if (this.f6206e != i2) {
                this.f6206e = i2;
                a(true);
            }
        }

        public void h(long j) {
            if (this.f6207f != j) {
                this.f6207f = j;
                a(true);
            }
        }

        public void i(String str) {
            if (str.equals(this.f6205d)) {
                return;
            }
            this.f6205d = str;
            a(true);
        }

        public int j() {
            return this.f6206e;
        }

        public void k(String str) {
            if (str.equals(this.f6208g)) {
                return;
            }
            this.f6208g = str;
            a(true);
        }

        public String l() {
            return this.f6208g;
        }
    }

    public QuantumChannel() {
        super("csc", 9000000L);
        this.f6183g = new d();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF, IF] complete} */
    @Override // d.a.q.e.a
    public a.h b(String str, a.g gVar) {
        h hVar;
        try {
            Object b2 = this.f6184h.b(this.f64091a.f64095a);
            if (b2 == null) {
                return a.h.b(-101, null);
            }
            if (gVar.f64101a) {
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
                        if (gVar.f64101a && hVar != null) {
                            hVar.b();
                        }
                        return b3;
                    }
                    String i2 = d.a.q.h.c.a.i(o(b2, str));
                    int i3 = i(b2, str);
                    if (gVar.f64101a && hVar != null) {
                        hVar.k(i2);
                        hVar.i(str);
                        hVar.h(System.currentTimeMillis());
                        hVar.g(i3);
                    }
                    a.h e3 = a.h.e(i2);
                    if (gVar.f64101a && hVar != null) {
                        hVar.b();
                    }
                    return e3;
                } catch (Throwable th) {
                    if (gVar.f64101a && hVar != null) {
                        hVar.b();
                    }
                    throw th;
                }
            } catch (b e4) {
                a.h c2 = a.h.c(e4);
                if (gVar.f64101a && hVar != null) {
                    hVar.b();
                }
                return c2;
            } catch (g unused3) {
                a.h a2 = a.h.a(-102);
                if (gVar.f64101a && hVar != null) {
                    hVar.b();
                }
                return a2;
            } catch (d.a unused4) {
                a.h b4 = a.h.b(-2, null);
                if (gVar.f64101a && hVar != null) {
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
        this.f6182f = this.f64092b.f("csc");
        this.f6184h = new f(this.f64091a.f64095a);
        this.f6185i = new c();
    }

    @Override // d.a.q.e.a
    public a.f f(a.e eVar) {
        this.f6183g.j();
        try {
            return j(eVar);
        } finally {
            this.f6183g.k();
        }
    }

    public final int h(Object obj, Object obj2) {
        try {
            return this.f6184h.a(obj, obj2);
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
        Context context = this.f64091a.f64095a;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            boolean z = packageInfo.lastUpdateTime != this.f6183g.g();
            this.f6183g.h(packageInfo.lastUpdateTime);
            if (!z && this.f6183g.f(6L) == 4) {
                return a.f.b(-101);
            }
            d.a.q.h.a a2 = this.f64091a.f64097c.a("aid");
            try {
                Object b2 = this.f6184h.b(context);
                if (b2 == null) {
                    return a.f.b(-102);
                }
                try {
                    try {
                        if (this.f6183g.f(1L) == 1 && (i3 = this.f6183g.i()) != null && i3.equals(a2.c()) && p(b2, packageName)) {
                            if (this.f6183g.a() == i(b2, packageName)) {
                                return a.f.d();
                            }
                        }
                        byte[] d2 = a2.d();
                        this.f6183g.e(a2.c());
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
                                        this.f6183g.d(j2, 6L);
                                        return a.f.b(i2);
                                    }
                                }
                                int nextInt = new Random().nextInt(255);
                                this.f6183g.b(nextInt);
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
                                            this.f6183g.c(System.currentTimeMillis());
                                            this.f6183g.d(1L, 1L);
                                            return a.f.d();
                                        } catch (b unused2) {
                                            this.f6183g.d(4L, 6L);
                                            return a.f.b(-101);
                                        } catch (d.a unused3) {
                                            return a.f.b(-102);
                                        }
                                    } catch (b unused4) {
                                        this.f6183g.d(4L, 6L);
                                        return a.f.b(-101);
                                    } catch (g unused5) {
                                        return a.f.b(-103);
                                    } catch (d.a unused6) {
                                        return a.f.b(-102);
                                    }
                                } catch (b unused7) {
                                    this.f6183g.d(4L, 6L);
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
                    this.f6183g.d(4L, 6L);
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
            return com.baidu.helios.channels.csc.d.b(this.f6184h.f6204d, new Object[]{str, this.f6185i.f6187b});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new b("");
        }
    }

    public final Object l(String str, int i2) {
        try {
            Class<?> cls = this.f6184h.f6204d;
            return com.baidu.helios.channels.csc.d.b(cls, new Object[]{str, this.f6185i.f6186a + i2});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new b("");
        }
    }

    public final void m(Object obj, Object obj2, int i2) {
        try {
            this.f6184h.c(obj, obj2, i2);
        } catch (d.a e2) {
            throw e2;
        } catch (Throwable th) {
            throw new b(th);
        }
    }

    public final Object n(String str, int i2) {
        try {
            Class<?> cls = this.f6184h.f6204d;
            return com.baidu.helios.channels.csc.d.b(cls, new Object[]{str, this.f6185i.f6188c + i2});
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
