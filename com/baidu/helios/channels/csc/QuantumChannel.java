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
    private c avS;
    private e avT;
    private a avU;
    a.C0148a avw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class a {
        String a;
        String b;
        String c;

        private a() {
            com.baidu.helios.common.a.b bVar = new com.baidu.helios.common.a.b();
            try {
                this.a = new String(bVar.B(com.baidu.helios.channels.csc.b.sB()));
                this.b = new String(bVar.B(com.baidu.helios.channels.csc.b.sC()));
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
        public long a;
        private int r;
        private long t;
        private String u;
        private int v;
        private com.baidu.helios.common.b.a.e avV = new com.baidu.helios.common.b.a.e();
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
            if (this.a != j) {
                this.a = j;
                this.w = true;
            }
        }

        public boolean a(long j, long j2) {
            if (this.avV.d(j, j2)) {
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
            return this.avV.T(j);
        }

        public long c() {
            return this.t;
        }

        public String d() {
            return this.u;
        }

        public void e() {
            String q = QuantumChannel.this.avw.q("pub.dat", true);
            if (TextUtils.isEmpty(q)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(q);
                this.r = jSONObject.getInt("pub_ver");
                this.a = jSONObject.getLong("pub_lst_ts");
                this.t = jSONObject.getLong("pkg_lst_up_ts");
                this.avV.S(jSONObject.getLong("flags"));
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
                    jSONObject.put("pub_lst_ts", this.a);
                    jSONObject.put("pkg_lst_up_ts", this.t);
                    jSONObject.put("flags", this.avV.Ae());
                    jSONObject.put("d_form_ver", 1);
                    jSONObject.put("aid", this.u);
                    QuantumChannel.this.avw.d("pub.dat", jSONObject.toString(), true);
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
        a.C0147a avX;
        private byte[] b;

        /* loaded from: classes18.dex */
        public static class a {
            private int a = 160;
            private byte[] b = new byte[this.a];
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

            public d zR() {
                return new d(Arrays.copyOf(this.b, this.c));
            }
        }

        public d(byte[] bArr) {
            this.b = bArr;
            this.avX = com.baidu.helios.channels.csc.a.x(bArr);
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
        static byte m22do(int i) {
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

        public static d g(byte[] bArr, int i) {
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
            return this.avX.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class e {
        Method a;
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
            this.d = com.baidu.helios.channels.csc.d.a(intent.getClass(), com.baidu.helios.channels.csc.d.a(com.baidu.helios.channels.csc.b.sA()), null).invoke(intent, new Object[0]).getClass();
            this.a = com.baidu.helios.channels.csc.d.a(invoke.getClass(), com.baidu.helios.channels.csc.d.a(com.baidu.helios.channels.csc.b.a()), new Class[]{this.d, Integer.TYPE, Integer.TYPE});
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
                this.a.invoke(obj, obj2, Integer.valueOf(i), 1);
            } catch (Exception e) {
                throw new d.a("");
            }
        }

        Object ai(Context context) {
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
            super(QuantumChannel.this.avw, str);
        }

        public String a() {
            return this.h;
        }

        public void a(int i) {
            if (this.i != i) {
                this.i = i;
                aT(true);
            }
        }

        public void a(long j) {
            if (this.j != j) {
                this.j = j;
                aT(true);
            }
        }

        public void a(String str) {
            if (str.equals(this.h)) {
                return;
            }
            this.h = str;
            aT(true);
        }

        public int b() {
            return this.i;
        }

        public void b(String str) {
            if (str.equals(this.k)) {
                return;
            }
            this.k = str;
            aT(true);
        }

        public String c() {
            return this.k;
        }

        @Override // com.baidu.helios.channels.a.b
        public void p(JSONObject jSONObject) {
            this.h = jSONObject.getString(Config.INPUT_DEF_PKG);
            this.i = jSONObject.getInt("aid_ver");
            this.j = jSONObject.getLong("last_fe_ts");
            this.k = jSONObject.getString("id");
            this.l = jSONObject.getInt("d_form_ver");
        }

        @Override // com.baidu.helios.channels.a.b
        public void q(JSONObject jSONObject) {
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
        this.avS = new c();
    }

    private int a(Object obj, Object obj2) {
        try {
            return this.avT.a(obj, obj2);
        } catch (d.a e2) {
            throw e2;
        } catch (Throwable th) {
            throw new b(th);
        }
    }

    private Object a(String str) {
        try {
            return com.baidu.helios.channels.csc.d.a(this.avT.d, new Object[]{str, this.avU.b});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new b("");
        }
    }

    private void a(Object obj, Object obj2, int i) {
        try {
            this.avT.a(obj, obj2, i);
        } catch (d.a e2) {
            throw e2;
        } catch (Throwable th) {
            throw new b(th);
        }
    }

    private a.e b(a.d dVar) {
        String d2;
        Context context = this.avM.applicationContext;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            boolean z = packageInfo.lastUpdateTime != this.avS.c();
            this.avS.Q(packageInfo.lastUpdateTime);
            if (z || this.avS.b(6L) != 4) {
                com.baidu.helios.ids.a fw = this.avM.avQ.fw("aid");
                try {
                    Object ai = this.avT.ai(context);
                    if (ai == null) {
                        return a.e.dm(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                    }
                    try {
                        if (this.avS.b(1L) == 1 && (d2 = this.avS.d()) != null && d2.equals(fw.Am()) && e(ai, packageName)) {
                            if (this.avS.a() == c(ai, packageName)) {
                                return a.e.zN();
                            }
                        }
                        byte[] An = fw.An();
                        this.avS.a(fw.Am());
                        d g2 = d.g(An, An.length * 8);
                        try {
                            int a2 = g2.a();
                            for (int i = 0; i < a2; i++) {
                                a(ai, w(packageName, i), g2.a(i));
                            }
                            int nextInt = new Random().nextInt(255);
                            this.avS.a(nextInt);
                            byte[] bArr = new byte[1];
                            for (int i2 = 0; i2 < 1; i2++) {
                                bArr[i2] = (byte) ((nextInt >> (i2 * 8)) & 255);
                            }
                            d g3 = d.g(bArr, 8);
                            try {
                                int a3 = g3.a();
                                for (int i3 = 0; i3 < a3; i3++) {
                                    a(ai, x(packageName, i3), g3.a(i3));
                                }
                                try {
                                    if (c(ai, packageName) != nextInt) {
                                        return a.e.dm(-103);
                                    }
                                    try {
                                        a(ai, a(packageName), 1);
                                        this.avS.a(System.currentTimeMillis());
                                        this.avS.a(1L, 1L);
                                        return a.e.zN();
                                    } catch (b e2) {
                                        this.avS.a(4L, 6L);
                                        return a.e.dm(-101);
                                    } catch (d.a e3) {
                                        return a.e.dm(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                                    }
                                } catch (b e4) {
                                    this.avS.a(4L, 6L);
                                    return a.e.dm(-101);
                                } catch (g e5) {
                                    return a.e.dm(-103);
                                } catch (d.a e6) {
                                    return a.e.dm(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                                }
                            } catch (b e7) {
                                this.avS.a(4L, 6L);
                                return a.e.dm(-101);
                            } catch (d.a e8) {
                                return a.e.dm(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                            }
                        } catch (b e9) {
                            this.avS.a(4L, 6L);
                            return a.e.dm(-101);
                        } catch (d.a e10) {
                            return a.e.dm(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                        }
                    } catch (b e11) {
                        this.avS.a(4L, 6L);
                        return a.e.dm(-101);
                    } catch (g e12) {
                        try {
                            a(ai, a(packageName), 0);
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

    private int c(Object obj, String str) {
        d.a aVar = new d.a();
        for (int i = 0; i < d; i++) {
            aVar.b(d.m22do(a(obj, x(str, i))));
        }
        byte[] b2 = aVar.zR().b();
        int i2 = 0;
        for (int i3 = 0; i3 < b2.length; i3++) {
            i2 |= (b2[i3] & 255) << (i3 * 8);
        }
        return i2;
    }

    private byte[] d(Object obj, String str) {
        d.a aVar = new d.a();
        for (int i = 0; i < b; i++) {
            aVar.b(d.m22do(a(obj, w(str, i))));
        }
        return aVar.zR().b();
    }

    private boolean e(Object obj, String str) {
        return a(obj, a(str)) == 1;
    }

    private Object w(String str, int i) {
        try {
            return com.baidu.helios.channels.csc.d.a(this.avT.d, new Object[]{str, this.avU.a + i});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new b("");
        }
    }

    private Object x(String str, int i) {
        try {
            return com.baidu.helios.channels.csc.d.a(this.avT.d, new Object[]{str, this.avU.c + i});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new b("");
        }
    }

    @Override // com.baidu.helios.channels.a
    public a.e a(a.d dVar) {
        this.avS.e();
        try {
            return b(dVar);
        } finally {
            this.avS.f();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF, IF] complete} */
    @Override // com.baidu.helios.channels.a
    public a.g a(String str, a.f fVar) {
        f fVar2 = null;
        try {
            Object ai = this.avT.ai(this.avM.applicationContext);
            if (ai == null) {
                return a.g.e(-101, null);
            }
            if (fVar.useCache) {
                f fVar3 = new f(str);
                fVar3.zL();
                if (str.equals(fVar3.a())) {
                    try {
                        if (fVar3.b() == c(ai, str)) {
                            String c2 = fVar3.c();
                            if (!TextUtils.isEmpty(c2)) {
                                return a.g.ft(c2);
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
                        if (!e(ai, str)) {
                            a.g e5 = a.g.e(-2, null);
                            if (!fVar.useCache || fVar2 == null) {
                                return e5;
                            }
                            fVar2.zM();
                            return e5;
                        }
                        String D = com.baidu.helios.ids.a.a.D(d(ai, str));
                        int c3 = c(ai, str);
                        if (fVar.useCache && fVar2 != null) {
                            fVar2.b(D);
                            fVar2.a(str);
                            fVar2.a(System.currentTimeMillis());
                            fVar2.a(c3);
                        }
                        a.g ft = a.g.ft(D);
                        if (!fVar.useCache || fVar2 == null) {
                            return ft;
                        }
                        fVar2.zM();
                        return ft;
                    } catch (g e6) {
                        a.g dn = a.g.dn(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                        if (!fVar.useCache || fVar2 == null) {
                            return dn;
                        }
                        fVar2.zM();
                        return dn;
                    }
                } catch (b e7) {
                    a.g j = a.g.j(e7);
                    if (!fVar.useCache || fVar2 == null) {
                        return j;
                    }
                    fVar2.zM();
                    return j;
                } catch (d.a e8) {
                    a.g e9 = a.g.e(-2, null);
                    if (!fVar.useCache || fVar2 == null) {
                        return e9;
                    }
                    fVar2.zM();
                    return e9;
                }
            } catch (Throwable th) {
                if (fVar.useCache && fVar2 != null) {
                    fVar2.zM();
                }
                throw th;
            }
        } catch (d.a e10) {
            return a.g.e(-101, null);
        }
    }

    @Override // com.baidu.helios.channels.a
    public void a(a.c cVar) {
        this.avw = this.avN.fv("csc");
        this.avT = new e(this.avM.applicationContext);
        this.avU = new a();
    }
}
