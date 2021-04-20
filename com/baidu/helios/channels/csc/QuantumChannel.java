package com.baidu.helios.channels.csc;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.helios.channels.csc.d;
import com.baidu.sapi2.result.OneKeyLoginResult;
import d.b.p.e.a;
import d.b.p.e.c.a;
import d.b.p.g.d.a;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class QuantumChannel extends d.b.p.e.a {
    public static final int j = d.b.p.e.c.a.a(160);
    public static final int k = d.b.p.e.c.a.a(8);

    /* renamed from: f  reason: collision with root package name */
    public a.C1765a f6247f;

    /* renamed from: g  reason: collision with root package name */
    public d f6248g;

    /* renamed from: h  reason: collision with root package name */
    public f f6249h;
    public c i;

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
        public String f6250a;

        /* renamed from: b  reason: collision with root package name */
        public String f6251b;

        /* renamed from: c  reason: collision with root package name */
        public String f6252c;

        public c() {
            d.b.p.g.b.b bVar = new d.b.p.g.b.b();
            try {
                this.f6250a = new String(bVar.a(d.b.p.e.c.b.e()));
                this.f6251b = new String(bVar.a(d.b.p.e.c.b.f()));
                this.f6252c = new String(bVar.a(d.b.p.e.c.b.g()));
            } catch (Exception unused) {
                throw new IllegalStateException("");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public int f6253a;

        /* renamed from: b  reason: collision with root package name */
        public long f6254b;

        /* renamed from: d  reason: collision with root package name */
        public long f6256d;

        /* renamed from: e  reason: collision with root package name */
        public String f6257e;

        /* renamed from: c  reason: collision with root package name */
        public d.b.p.g.c.a.e f6255c = new d.b.p.g.c.a.e();

        /* renamed from: f  reason: collision with root package name */
        public boolean f6258f = true;

        public d() {
        }

        public int a() {
            return this.f6253a;
        }

        public void b(int i) {
            if (this.f6253a != i) {
                this.f6253a = i;
                this.f6258f = true;
            }
        }

        public void c(long j) {
            if (this.f6254b != j) {
                this.f6254b = j;
                this.f6258f = true;
            }
        }

        public boolean d(long j, long j2) {
            if (this.f6255c.c(j, j2)) {
                this.f6258f = true;
                return true;
            }
            return false;
        }

        public boolean e(String str) {
            String str2 = this.f6257e;
            if (str2 == str) {
                return false;
            }
            if (str == null || !str.equals(str2)) {
                this.f6258f = true;
                this.f6257e = str;
                return true;
            }
            return false;
        }

        public long f(long j) {
            return this.f6255c.a(j);
        }

        public long g() {
            return this.f6256d;
        }

        public boolean h(long j) {
            if (this.f6256d != j) {
                this.f6256d = j;
                this.f6258f = true;
                return true;
            }
            return false;
        }

        public String i() {
            return this.f6257e;
        }

        public void j() {
            String g2 = QuantumChannel.this.f6247f.g("pub.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f6253a = jSONObject.getInt("pub_ver");
                this.f6254b = jSONObject.getLong("pub_lst_ts");
                this.f6256d = jSONObject.getLong("pkg_lst_up_ts");
                this.f6255c.b(jSONObject.getLong("flags"));
                jSONObject.getInt("d_form_ver");
                this.f6257e = jSONObject.optString("aid");
                this.f6258f = false;
            } catch (Exception unused) {
                this.f6258f = true;
            }
        }

        public boolean k() {
            if (this.f6258f) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pub_ver", this.f6253a);
                    jSONObject.put("pub_lst_ts", this.f6254b);
                    jSONObject.put("pkg_lst_up_ts", this.f6256d);
                    jSONObject.put("flags", this.f6255c.d());
                    jSONObject.put("d_form_ver", 1);
                    jSONObject.put("aid", this.f6257e);
                    QuantumChannel.this.f6247f.i("pub.dat", jSONObject.toString(), true);
                    this.f6258f = false;
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
        public a.C1759a f6260a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f6261b;

        /* loaded from: classes2.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public int f6262a = 160;

            /* renamed from: b  reason: collision with root package name */
            public byte[] f6263b = new byte[160];

            /* renamed from: c  reason: collision with root package name */
            public int f6264c;

            public a a(byte b2) {
                c(this.f6264c + 1);
                byte[] bArr = this.f6263b;
                int i = this.f6264c;
                this.f6264c = i + 1;
                bArr[i] = b2;
                return this;
            }

            public e b() {
                return new e(Arrays.copyOf(this.f6263b, this.f6264c));
            }

            public final void c(int i) {
                byte[] bArr = this.f6263b;
                if (i - bArr.length > 0) {
                    int length = bArr.length;
                    int i2 = length + (length >> 1);
                    if (i2 - i >= 0) {
                        i = i2;
                    }
                    this.f6263b = Arrays.copyOf(this.f6263b, i);
                }
            }
        }

        public e(byte[] bArr) {
            this.f6261b = bArr;
            this.f6260a = d.b.p.e.c.a.b(bArr);
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

        public static e d(byte[] bArr, int i) {
            return new e(d.b.p.e.c.a.c(bArr, i));
        }

        public static byte e(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return (byte) 2;
                    }
                    throw new g("unexpected value " + i);
                }
                return (byte) 1;
            }
            return (byte) 0;
        }

        public int a() {
            return this.f6261b.length;
        }

        public int c(int i) {
            if (i >= 0) {
                byte[] bArr = this.f6261b;
                if (i < bArr.length) {
                    return b(bArr[i]);
                }
            }
            throw new IllegalArgumentException("illegal index " + i + " with current length is " + this.f6261b.length);
        }

        public byte[] f() {
            return this.f6260a.a();
        }
    }

    /* loaded from: classes2.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public Method f6265a;

        /* renamed from: b  reason: collision with root package name */
        public Method f6266b;

        /* renamed from: c  reason: collision with root package name */
        public Method f6267c;

        /* renamed from: d  reason: collision with root package name */
        public Class<?> f6268d;

        public f(Context context) {
            try {
                d(context);
            } catch (Exception unused) {
                throw new IllegalStateException("");
            }
        }

        public int a(Object obj, Object obj2) {
            try {
                return ((Integer) this.f6266b.invoke(obj, obj2)).intValue();
            } catch (Exception unused) {
                throw new d.a("");
            }
        }

        public Object b(Context context) {
            try {
                return this.f6267c.invoke(context, new Object[0]);
            } catch (Exception unused) {
                throw new d.a("");
            }
        }

        public void c(Object obj, Object obj2, int i) {
            try {
                this.f6265a.invoke(obj, obj2, Integer.valueOf(i), 1);
            } catch (Exception unused) {
                throw new d.a("");
            }
        }

        public final void d(Context context) {
            Method d2 = com.baidu.helios.channels.csc.d.d(Context.class, com.baidu.helios.channels.csc.d.c(d.b.p.e.c.b.c()), null);
            this.f6267c = d2;
            Object invoke = d2.invoke(context, new Object[0]);
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "");
            this.f6268d = com.baidu.helios.channels.csc.d.d(intent.getClass(), com.baidu.helios.channels.csc.d.c(d.b.p.e.c.b.d()), null).invoke(intent, new Object[0]).getClass();
            String c2 = com.baidu.helios.channels.csc.d.c(d.b.p.e.c.b.a());
            Class<?> cls = invoke.getClass();
            Class cls2 = Integer.TYPE;
            this.f6265a = com.baidu.helios.channels.csc.d.d(cls, c2, new Class[]{this.f6268d, cls2, cls2});
            this.f6266b = com.baidu.helios.channels.csc.d.d(invoke.getClass(), com.baidu.helios.channels.csc.d.c(d.b.p.e.c.b.b()), new Class[]{this.f6268d});
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
        public String f6269d;

        /* renamed from: e  reason: collision with root package name */
        public int f6270e;

        /* renamed from: f  reason: collision with root package name */
        public long f6271f;

        /* renamed from: g  reason: collision with root package name */
        public String f6272g;

        public h(QuantumChannel quantumChannel, String str) {
            super(quantumChannel.f6247f, str);
        }

        @Override // d.b.p.e.a.c
        public void c(JSONObject jSONObject) {
            this.f6269d = jSONObject.getString("pkg");
            this.f6270e = jSONObject.getInt("aid_ver");
            this.f6271f = jSONObject.getLong("last_fe_ts");
            this.f6272g = jSONObject.getString("id");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.b.p.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f6269d);
            jSONObject.put("aid_ver", this.f6270e);
            jSONObject.put("last_fe_ts", this.f6271f);
            jSONObject.put("id", this.f6272g);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f6269d;
        }

        public void g(int i) {
            if (this.f6270e != i) {
                this.f6270e = i;
                a(true);
            }
        }

        public void h(long j) {
            if (this.f6271f != j) {
                this.f6271f = j;
                a(true);
            }
        }

        public void i(String str) {
            if (str.equals(this.f6269d)) {
                return;
            }
            this.f6269d = str;
            a(true);
        }

        public int j() {
            return this.f6270e;
        }

        public void k(String str) {
            if (str.equals(this.f6272g)) {
                return;
            }
            this.f6272g = str;
            a(true);
        }

        public String l() {
            return this.f6272g;
        }
    }

    public QuantumChannel() {
        super("csc", 9000000L);
        this.f6248g = new d();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF, IF] complete} */
    @Override // d.b.p.e.a
    public a.h b(String str, a.g gVar) {
        h hVar;
        try {
            Object b2 = this.f6249h.b(this.f64997a.f65001a);
            if (b2 == null) {
                return a.h.b(-101, null);
            }
            if (gVar.f65007a) {
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
                        return a.h.a(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
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
                        if (gVar.f65007a && hVar != null) {
                            hVar.b();
                        }
                        return b3;
                    }
                    String i = d.b.p.h.c.a.i(o(b2, str));
                    int i2 = i(b2, str);
                    if (gVar.f65007a && hVar != null) {
                        hVar.k(i);
                        hVar.i(str);
                        hVar.h(System.currentTimeMillis());
                        hVar.g(i2);
                    }
                    a.h e3 = a.h.e(i);
                    if (gVar.f65007a && hVar != null) {
                        hVar.b();
                    }
                    return e3;
                } catch (Throwable th) {
                    if (gVar.f65007a && hVar != null) {
                        hVar.b();
                    }
                    throw th;
                }
            } catch (b e4) {
                a.h c2 = a.h.c(e4);
                if (gVar.f65007a && hVar != null) {
                    hVar.b();
                }
                return c2;
            } catch (g unused3) {
                a.h a2 = a.h.a(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                if (gVar.f65007a && hVar != null) {
                    hVar.b();
                }
                return a2;
            } catch (d.a unused4) {
                a.h b4 = a.h.b(-2, null);
                if (gVar.f65007a && hVar != null) {
                    hVar.b();
                }
                return b4;
            }
        } catch (d.a unused5) {
            return a.h.b(-101, null);
        }
    }

    @Override // d.b.p.e.a
    public void e(a.d dVar) {
        this.f6247f = this.f64998b.f("csc");
        this.f6249h = new f(this.f64997a.f65001a);
        this.i = new c();
    }

    @Override // d.b.p.e.a
    public a.f f(a.e eVar) {
        this.f6248g.j();
        try {
            return j(eVar);
        } finally {
            this.f6248g.k();
        }
    }

    public final int h(Object obj, Object obj2) {
        try {
            return this.f6249h.a(obj, obj2);
        } catch (d.a e2) {
            throw e2;
        } catch (Throwable th) {
            throw new b(th);
        }
    }

    public final int i(Object obj, String str) {
        e.a aVar = new e.a();
        for (int i = 0; i < k; i++) {
            aVar.a(e.e(h(obj, n(str, i))));
        }
        byte[] f2 = aVar.b().f();
        int i2 = 0;
        for (int i3 = 0; i3 < f2.length; i3++) {
            i2 |= (f2[i3] & 255) << (i3 * 8);
        }
        return i2;
    }

    public final a.f j(a.e eVar) {
        Object obj;
        long j2;
        int i;
        String i2;
        Context context = this.f64997a.f65001a;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            boolean z = packageInfo.lastUpdateTime != this.f6248g.g();
            this.f6248g.h(packageInfo.lastUpdateTime);
            if (!z && this.f6248g.f(6L) == 4) {
                return a.f.b(-101);
            }
            d.b.p.h.a a2 = this.f64997a.f65003c.a("aid");
            try {
                Object b2 = this.f6249h.b(context);
                if (b2 == null) {
                    return a.f.b(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                }
                try {
                    try {
                        if (this.f6248g.f(1L) == 1 && (i2 = this.f6248g.i()) != null && i2.equals(a2.c()) && p(b2, packageName)) {
                            if (this.f6248g.a() == i(b2, packageName)) {
                                return a.f.d();
                            }
                        }
                        byte[] d2 = a2.d();
                        this.f6248g.e(a2.c());
                        e d3 = e.d(d2, d2.length * 8);
                        try {
                            try {
                                int a3 = d3.a();
                                for (int i3 = 0; i3 < a3; i3++) {
                                    try {
                                        m(b2, l(packageName, i3), d3.c(i3));
                                    } catch (b unused) {
                                        i = -101;
                                        j2 = 4;
                                        this.f6248g.d(j2, 6L);
                                        return a.f.b(i);
                                    }
                                }
                                int nextInt = new Random().nextInt(255);
                                this.f6248g.b(nextInt);
                                byte[] bArr = new byte[1];
                                for (int i4 = 0; i4 < 1; i4++) {
                                    bArr[i4] = (byte) ((nextInt >> (i4 * 8)) & 255);
                                }
                                e d4 = e.d(bArr, 8);
                                try {
                                    int a4 = d4.a();
                                    for (int i5 = 0; i5 < a4; i5++) {
                                        m(b2, n(packageName, i5), d4.c(i5));
                                    }
                                    try {
                                        if (i(b2, packageName) != nextInt) {
                                            return a.f.b(-103);
                                        }
                                        try {
                                            m(b2, k(packageName), 1);
                                            this.f6248g.c(System.currentTimeMillis());
                                            this.f6248g.d(1L, 1L);
                                            return a.f.d();
                                        } catch (b unused2) {
                                            this.f6248g.d(4L, 6L);
                                            return a.f.b(-101);
                                        } catch (d.a unused3) {
                                            return a.f.b(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                                        }
                                    } catch (b unused4) {
                                        this.f6248g.d(4L, 6L);
                                        return a.f.b(-101);
                                    } catch (g unused5) {
                                        return a.f.b(-103);
                                    } catch (d.a unused6) {
                                        return a.f.b(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                                    }
                                } catch (b unused7) {
                                    this.f6248g.d(4L, 6L);
                                    return a.f.b(-101);
                                } catch (d.a unused8) {
                                    return a.f.b(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                                }
                            } catch (b unused9) {
                                j2 = 4;
                                i = -101;
                            }
                        } catch (d.a unused10) {
                            return a.f.b(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                        }
                    } catch (Exception unused11) {
                        return a.f.b(-103);
                    }
                } catch (b unused12) {
                    this.f6248g.d(4L, 6L);
                    return a.f.b(-101);
                } catch (g unused13) {
                    m(obj, k(packageName), 0);
                    return a.f.b(-103);
                } catch (d.a unused14) {
                    return a.f.b(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                }
            } catch (d.a unused15) {
                return a.f.b(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
            }
        } catch (PackageManager.NameNotFoundException unused16) {
            return a.f.b(-100);
        }
    }

    public final Object k(String str) {
        try {
            return com.baidu.helios.channels.csc.d.b(this.f6249h.f6268d, new Object[]{str, this.i.f6251b});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new b("");
        }
    }

    public final Object l(String str, int i) {
        try {
            Class<?> cls = this.f6249h.f6268d;
            return com.baidu.helios.channels.csc.d.b(cls, new Object[]{str, this.i.f6250a + i});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new b("");
        }
    }

    public final void m(Object obj, Object obj2, int i) {
        try {
            this.f6249h.c(obj, obj2, i);
        } catch (d.a e2) {
            throw e2;
        } catch (Throwable th) {
            throw new b(th);
        }
    }

    public final Object n(String str, int i) {
        try {
            Class<?> cls = this.f6249h.f6268d;
            return com.baidu.helios.channels.csc.d.b(cls, new Object[]{str, this.i.f6252c + i});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new b("");
        }
    }

    public final byte[] o(Object obj, String str) {
        e.a aVar = new e.a();
        for (int i = 0; i < j; i++) {
            aVar.a(e.e(h(obj, l(str, i))));
        }
        return aVar.b().f();
    }

    public final boolean p(Object obj, String str) {
        return h(obj, k(str)) == 1;
    }
}
