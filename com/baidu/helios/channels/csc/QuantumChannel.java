package com.baidu.helios.channels.csc;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.helios.channels.a;
import com.baidu.helios.channels.csc.a;
import com.baidu.helios.channels.csc.d;
import com.baidu.helios.common.c.a;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.result.OneKeyLoginResult;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class QuantumChannel extends com.baidu.helios.channels.a {
    private static final int b = com.baidu.helios.channels.csc.a.a(160);
    private static final int d = com.baidu.helios.channels.csc.a.a(8);
    a.C0151a auZ;
    private c avv;
    private e avw;
    private a avx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f1798a;
        String b;
        String c;

        private a() {
            com.baidu.helios.common.a.b bVar = new com.baidu.helios.common.a.b();
            try {
                this.f1798a = new String(bVar.B(com.baidu.helios.channels.csc.b.sG()));
                this.b = new String(bVar.B(com.baidu.helios.channels.csc.b.sH()));
                this.c = new String(bVar.B(com.baidu.helios.channels.csc.b.g()));
            } catch (Exception e) {
                throw new IllegalStateException("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public long f1799a;
        private int r;
        private long t;
        private String u;
        private int v;
        private com.baidu.helios.common.b.a.e avy = new com.baidu.helios.common.b.a.e();
        private boolean w = true;

        c() {
        }

        public boolean Q(long j) {
            if (this.t != j) {
                this.t = j;
                this.w = true;
                return true;
            }
            return false;
        }

        public int a() {
            return this.r;
        }

        public void a(int i) {
            if (this.r != i) {
                this.r = i;
                this.w = true;
            }
        }

        public void a(long j) {
            if (this.f1799a != j) {
                this.f1799a = j;
                this.w = true;
            }
        }

        public boolean a(long j, long j2) {
            if (this.avy.d(j, j2)) {
                this.w = true;
                return true;
            }
            return false;
        }

        public boolean a(String str) {
            if (this.u == str) {
                return false;
            }
            if (str == null || !str.equals(this.u)) {
                this.w = true;
                this.u = str;
                return true;
            }
            return false;
        }

        public long b(long j) {
            return this.avy.S(j);
        }

        public long c() {
            return this.t;
        }

        public String d() {
            return this.u;
        }

        public void e() {
            String q = QuantumChannel.this.auZ.q("pub.dat", true);
            if (TextUtils.isEmpty(q)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(q);
                this.r = jSONObject.getInt("pub_ver");
                this.f1799a = jSONObject.getLong("pub_lst_ts");
                this.t = jSONObject.getLong("pkg_lst_up_ts");
                this.avy.R(jSONObject.getLong("flags"));
                this.v = jSONObject.getInt("d_form_ver");
                this.u = jSONObject.optString("aid");
                this.w = false;
            } catch (Exception e) {
                this.w = true;
            }
        }

        public boolean f() {
            if (this.w) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pub_ver", this.r);
                    jSONObject.put("pub_lst_ts", this.f1799a);
                    jSONObject.put("pkg_lst_up_ts", this.t);
                    jSONObject.put("flags", this.avy.zR());
                    jSONObject.put("d_form_ver", 1);
                    jSONObject.put("aid", this.u);
                    QuantumChannel.this.auZ.d("pub.dat", jSONObject.toString(), true);
                    this.w = false;
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class d {
        a.C0150a avA;
        private byte[] b;

        /* loaded from: classes18.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private int f1800a = 160;
            private byte[] b = new byte[this.f1800a];
            private int c;

            private void a(int i) {
                if (i - this.b.length > 0) {
                    int length = this.b.length;
                    int i2 = length + (length >> 1);
                    if (i2 - i >= 0) {
                        i = i2;
                    }
                    this.b = Arrays.copyOf(this.b, i);
                }
            }

            public a b(byte b) {
                a(this.c + 1);
                byte[] bArr = this.b;
                int i = this.c;
                this.c = i + 1;
                bArr[i] = b;
                return this;
            }

            public d zE() {
                return new d(Arrays.copyOf(this.b, this.c));
            }
        }

        public d(byte[] bArr) {
            this.b = bArr;
            this.avA = com.baidu.helios.channels.csc.a.x(bArr);
        }

        static int a(byte b) {
            switch (b) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                default:
                    throw new IllegalStateException();
            }
        }

        /* renamed from: do  reason: not valid java name */
        static byte m21do(int i) {
            switch (i) {
                case 0:
                    return (byte) 0;
                case 1:
                    return (byte) 1;
                case 2:
                    return (byte) 2;
                default:
                    throw new g("unexpected value " + i);
            }
        }

        public static d h(byte[] bArr, int i) {
            return new d(com.baidu.helios.channels.csc.a.a(bArr, i));
        }

        public int a() {
            return this.b.length;
        }

        public int a(int i) {
            if (i < 0 || i >= this.b.length) {
                throw new IllegalArgumentException("illegal index " + i + " with current length is " + this.b.length);
            }
            return a(this.b[i]);
        }

        public byte[] b() {
            return this.avA.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        Method f1801a;
        Method b;
        Method c;
        Class<?> d;

        e(Context context) {
            try {
                b(context);
            } catch (Exception e) {
                throw new IllegalStateException("");
            }
        }

        private void b(Context context) {
            this.c = com.baidu.helios.channels.csc.d.a(Context.class, com.baidu.helios.channels.csc.d.a(com.baidu.helios.channels.csc.b.c()), null);
            Object invoke = this.c.invoke(context, new Object[0]);
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "");
            this.d = com.baidu.helios.channels.csc.d.a(intent.getClass(), com.baidu.helios.channels.csc.d.a(com.baidu.helios.channels.csc.b.sF()), null).invoke(intent, new Object[0]).getClass();
            this.f1801a = com.baidu.helios.channels.csc.d.a(invoke.getClass(), com.baidu.helios.channels.csc.d.a(com.baidu.helios.channels.csc.b.a()), new Class[]{this.d, Integer.TYPE, Integer.TYPE});
            this.b = com.baidu.helios.channels.csc.d.a(invoke.getClass(), com.baidu.helios.channels.csc.d.a(com.baidu.helios.channels.csc.b.b()), new Class[]{this.d});
        }

        int a(Object obj, Object obj2) {
            try {
                return ((Integer) this.b.invoke(obj, obj2)).intValue();
            } catch (Exception e) {
                throw new d.a("");
            }
        }

        void a(Object obj, Object obj2, int i) {
            try {
                this.f1801a.invoke(obj, obj2, Integer.valueOf(i), 1);
            } catch (Exception e) {
                throw new d.a("");
            }
        }

        Object al(Context context) {
            try {
                return this.c.invoke(context, new Object[0]);
            } catch (Exception e) {
                throw new d.a("");
            }
        }
    }

    /* loaded from: classes18.dex */
    class f extends a.b {
        private String h;
        private int i;
        private long j;
        private String k;
        private int l;

        public f(String str) {
            super(QuantumChannel.this.auZ, str);
        }

        public String a() {
            return this.h;
        }

        public void a(int i) {
            if (this.i != i) {
                this.i = i;
                aY(true);
            }
        }

        public void a(long j) {
            if (this.j != j) {
                this.j = j;
                aY(true);
            }
        }

        public void a(String str) {
            if (str.equals(this.h)) {
                return;
            }
            this.h = str;
            aY(true);
        }

        public int b() {
            return this.i;
        }

        public void b(String str) {
            if (str.equals(this.k)) {
                return;
            }
            this.k = str;
            aY(true);
        }

        public String c() {
            return this.k;
        }

        @Override // com.baidu.helios.channels.a.b
        public void j(JSONObject jSONObject) {
            this.h = jSONObject.getString(Config.INPUT_DEF_PKG);
            this.i = jSONObject.getInt("aid_ver");
            this.j = jSONObject.getLong("last_fe_ts");
            this.k = jSONObject.getString("id");
            this.l = jSONObject.getInt("d_form_ver");
        }

        @Override // com.baidu.helios.channels.a.b
        public void k(JSONObject jSONObject) {
            jSONObject.put(Config.INPUT_DEF_PKG, this.h);
            jSONObject.put("aid_ver", this.i);
            jSONObject.put("last_fe_ts", this.j);
            jSONObject.put("id", this.k);
            jSONObject.put("d_form_ver", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class g extends Exception {
        public g(String str) {
            super(str);
        }

        public g(String str, Throwable th) {
            super(str, th);
        }
    }

    public QuantumChannel() {
        super("csc", 9000000L);
        this.avv = new c();
    }

    private int a(Object obj, Object obj2) {
        try {
            return this.avw.a(obj, obj2);
        } catch (d.a e2) {
            throw e2;
        } catch (Throwable th) {
            throw new b(th);
        }
    }

    private Object a(String str) {
        try {
            return com.baidu.helios.channels.csc.d.a(this.avw.d, new Object[]{str, this.avx.b});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new b("");
        }
    }

    private void a(Object obj, Object obj2, int i) {
        try {
            this.avw.a(obj, obj2, i);
        } catch (d.a e2) {
            throw e2;
        } catch (Throwable th) {
            throw new b(th);
        }
    }

    private a.e b(a.d dVar) {
        String d2;
        Context context = this.avp.applicationContext;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            boolean z = packageInfo.lastUpdateTime != this.avv.c();
            this.avv.Q(packageInfo.lastUpdateTime);
            if (z || this.avv.b(6L) != 4) {
                com.baidu.helios.ids.a fy = this.avp.avt.fy("aid");
                try {
                    Object al = this.avw.al(context);
                    if (al == null) {
                        return a.e.dm(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                    }
                    try {
                        if (this.avv.b(1L) == 1 && (d2 = this.avv.d()) != null && d2.equals(fy.zZ()) && f(al, packageName)) {
                            if (this.avv.a() == d(al, packageName)) {
                                return a.e.zA();
                            }
                        }
                        byte[] Aa = fy.Aa();
                        this.avv.a(fy.zZ());
                        d h = d.h(Aa, Aa.length * 8);
                        try {
                            int a2 = h.a();
                            for (int i = 0; i < a2; i++) {
                                a(al, w(packageName, i), h.a(i));
                            }
                            int nextInt = new Random().nextInt(255);
                            this.avv.a(nextInt);
                            byte[] bArr = new byte[1];
                            for (int i2 = 0; i2 < 1; i2++) {
                                bArr[i2] = (byte) ((nextInt >> (i2 * 8)) & 255);
                            }
                            d h2 = d.h(bArr, 8);
                            try {
                                int a3 = h2.a();
                                for (int i3 = 0; i3 < a3; i3++) {
                                    a(al, x(packageName, i3), h2.a(i3));
                                }
                                try {
                                    if (d(al, packageName) != nextInt) {
                                        return a.e.dm(-103);
                                    }
                                    try {
                                        a(al, a(packageName), 1);
                                        this.avv.a(System.currentTimeMillis());
                                        this.avv.a(1L, 1L);
                                        return a.e.zA();
                                    } catch (b e2) {
                                        this.avv.a(4L, 6L);
                                        return a.e.dm(-101);
                                    } catch (d.a e3) {
                                        return a.e.dm(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                                    }
                                } catch (b e4) {
                                    this.avv.a(4L, 6L);
                                    return a.e.dm(-101);
                                } catch (g e5) {
                                    return a.e.dm(-103);
                                } catch (d.a e6) {
                                    return a.e.dm(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                                }
                            } catch (b e7) {
                                this.avv.a(4L, 6L);
                                return a.e.dm(-101);
                            } catch (d.a e8) {
                                return a.e.dm(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                            }
                        } catch (b e9) {
                            this.avv.a(4L, 6L);
                            return a.e.dm(-101);
                        } catch (d.a e10) {
                            return a.e.dm(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                        }
                    } catch (b e11) {
                        this.avv.a(4L, 6L);
                        return a.e.dm(-101);
                    } catch (g e12) {
                        try {
                            a(al, a(packageName), 0);
                        } catch (Exception e13) {
                        }
                        return a.e.dm(-103);
                    } catch (d.a e14) {
                        return a.e.dm(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                    }
                } catch (d.a e15) {
                    return a.e.dm(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                }
            }
            return a.e.dm(-101);
        } catch (PackageManager.NameNotFoundException e16) {
            return a.e.dm(-100);
        }
    }

    private int d(Object obj, String str) {
        d.a aVar = new d.a();
        for (int i = 0; i < d; i++) {
            aVar.b(d.m21do(a(obj, x(str, i))));
        }
        byte[] b2 = aVar.zE().b();
        int i2 = 0;
        for (int i3 = 0; i3 < b2.length; i3++) {
            i2 |= (b2[i3] & 255) << (i3 * 8);
        }
        return i2;
    }

    private byte[] e(Object obj, String str) {
        d.a aVar = new d.a();
        for (int i = 0; i < b; i++) {
            aVar.b(d.m21do(a(obj, w(str, i))));
        }
        return aVar.zE().b();
    }

    private boolean f(Object obj, String str) {
        return a(obj, a(str)) == 1;
    }

    private Object w(String str, int i) {
        try {
            return com.baidu.helios.channels.csc.d.a(this.avw.d, new Object[]{str, this.avx.f1798a + i});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new b("");
        }
    }

    private Object x(String str, int i) {
        try {
            return com.baidu.helios.channels.csc.d.a(this.avw.d, new Object[]{str, this.avx.c + i});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new b("");
        }
    }

    @Override // com.baidu.helios.channels.a
    public a.e a(a.d dVar) {
        this.avv.e();
        try {
            return b(dVar);
        } finally {
            this.avv.f();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF, IF] complete} */
    @Override // com.baidu.helios.channels.a
    public a.g a(String str, a.f fVar) {
        f fVar2 = null;
        try {
            Object al = this.avw.al(this.avp.applicationContext);
            if (al == null) {
                return a.g.e(-101, null);
            }
            if (fVar.useCache) {
                f fVar3 = new f(str);
                fVar3.zy();
                if (str.equals(fVar3.a())) {
                    try {
                        if (fVar3.b() == d(al, str)) {
                            String c2 = fVar3.c();
                            if (!TextUtils.isEmpty(c2)) {
                                return a.g.fv(c2);
                            }
                        }
                        fVar2 = fVar3;
                    } catch (b e2) {
                        return a.g.j(e2);
                    } catch (g e3) {
                        return a.g.dn(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                    } catch (d.a e4) {
                        return a.g.e(-101, null);
                    }
                } else {
                    fVar2 = fVar3;
                }
            }
            try {
                try {
                    try {
                        if (!f(al, str)) {
                            a.g e5 = a.g.e(-2, null);
                            if (!fVar.useCache || fVar2 == null) {
                                return e5;
                            }
                            fVar2.zz();
                            return e5;
                        }
                        String D = com.baidu.helios.ids.a.a.D(e(al, str));
                        int d2 = d(al, str);
                        if (fVar.useCache && fVar2 != null) {
                            fVar2.b(D);
                            fVar2.a(str);
                            fVar2.a(System.currentTimeMillis());
                            fVar2.a(d2);
                        }
                        a.g fv = a.g.fv(D);
                        if (!fVar.useCache || fVar2 == null) {
                            return fv;
                        }
                        fVar2.zz();
                        return fv;
                    } catch (g e6) {
                        a.g dn = a.g.dn(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                        if (!fVar.useCache || fVar2 == null) {
                            return dn;
                        }
                        fVar2.zz();
                        return dn;
                    }
                } catch (b e7) {
                    a.g j = a.g.j(e7);
                    if (!fVar.useCache || fVar2 == null) {
                        return j;
                    }
                    fVar2.zz();
                    return j;
                } catch (d.a e8) {
                    a.g e9 = a.g.e(-2, null);
                    if (!fVar.useCache || fVar2 == null) {
                        return e9;
                    }
                    fVar2.zz();
                    return e9;
                }
            } catch (Throwable th) {
                if (fVar.useCache && fVar2 != null) {
                    fVar2.zz();
                }
                throw th;
            }
        } catch (d.a e10) {
            return a.g.e(-101, null);
        }
    }

    @Override // com.baidu.helios.channels.a
    public void a(a.c cVar) {
        this.auZ = this.avq.fx("csc");
        this.avw = new e(this.avp.applicationContext);
        this.avx = new a();
    }
}
