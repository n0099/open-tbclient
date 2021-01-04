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
/* loaded from: classes15.dex */
public class QuantumChannel extends com.baidu.helios.channels.a {

    /* renamed from: b  reason: collision with root package name */
    private static final int f2470b = com.baidu.helios.channels.csc.a.a(160);
    private static final int d = com.baidu.helios.channels.csc.a.a(8);
    private c awO;
    private e awP;
    private a awQ;
    a.C0141a awu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f2471a;

        /* renamed from: b  reason: collision with root package name */
        String f2472b;
        String c;

        private a() {
            com.baidu.helios.common.a.b bVar = new com.baidu.helios.common.a.b();
            try {
                this.f2471a = new String(bVar.y(com.baidu.helios.channels.csc.b.sl()));
                this.f2472b = new String(bVar.y(com.baidu.helios.channels.csc.b.f()));
                this.c = new String(bVar.y(com.baidu.helios.channels.csc.b.g()));
            } catch (Exception e) {
                throw new IllegalStateException("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
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
    /* loaded from: classes15.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public long f2473a;
        private int r;
        private long t;
        private String u;
        private int v;
        private com.baidu.helios.common.b.a.e awR = new com.baidu.helios.common.b.a.e();
        private boolean w = true;

        c() {
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
            if (this.f2473a != j) {
                this.f2473a = j;
                this.w = true;
            }
        }

        public boolean a(long j, long j2) {
            if (this.awR.g(j, j2)) {
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
            return this.awR.P(j);
        }

        public long c() {
            return this.t;
        }

        public boolean c(long j) {
            if (this.t != j) {
                this.t = j;
                this.w = true;
                return true;
            }
            return false;
        }

        public String d() {
            return this.u;
        }

        public void e() {
            String p = QuantumChannel.this.awu.p("pub.dat", true);
            if (TextUtils.isEmpty(p)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(p);
                this.r = jSONObject.getInt("pub_ver");
                this.f2473a = jSONObject.getLong("pub_lst_ts");
                this.t = jSONObject.getLong("pkg_lst_up_ts");
                this.awR.O(jSONObject.getLong("flags"));
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
                    jSONObject.put("pub_lst_ts", this.f2473a);
                    jSONObject.put("pkg_lst_up_ts", this.t);
                    jSONObject.put("flags", this.awR.zc());
                    jSONObject.put("d_form_ver", 1);
                    jSONObject.put("aid", this.u);
                    QuantumChannel.this.awu.c("pub.dat", jSONObject.toString(), true);
                    this.w = false;
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class d {
        a.C0140a awT;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f2474b;

        /* loaded from: classes15.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private int f2475a = 160;

            /* renamed from: b  reason: collision with root package name */
            private byte[] f2476b = new byte[this.f2475a];
            private int c;

            private void a(int i) {
                if (i - this.f2476b.length > 0) {
                    int length = this.f2476b.length;
                    int i2 = length + (length >> 1);
                    if (i2 - i >= 0) {
                        i = i2;
                    }
                    this.f2476b = Arrays.copyOf(this.f2476b, i);
                }
            }

            public a b(byte b2) {
                a(this.c + 1);
                byte[] bArr = this.f2476b;
                int i = this.c;
                this.c = i + 1;
                bArr[i] = b2;
                return this;
            }

            public d yN() {
                return new d(Arrays.copyOf(this.f2476b, this.c));
            }
        }

        public d(byte[] bArr) {
            this.f2474b = bArr;
            this.awT = com.baidu.helios.channels.csc.a.u(bArr);
        }

        static int a(byte b2) {
            switch (b2) {
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

        static byte b(int i) {
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
            return this.f2474b.length;
        }

        public int a(int i) {
            if (i < 0 || i >= this.f2474b.length) {
                throw new IllegalArgumentException("illegal index " + i + " with current length is " + this.f2474b.length);
            }
            return a(this.f2474b[i]);
        }

        public byte[] b() {
            return this.awT.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        Method f2477a;

        /* renamed from: b  reason: collision with root package name */
        Method f2478b;
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
            this.d = com.baidu.helios.channels.csc.d.a(intent.getClass(), com.baidu.helios.channels.csc.d.a(com.baidu.helios.channels.csc.b.sk()), null).invoke(intent, new Object[0]).getClass();
            this.f2477a = com.baidu.helios.channels.csc.d.a(invoke.getClass(), com.baidu.helios.channels.csc.d.a(com.baidu.helios.channels.csc.b.a()), new Class[]{this.d, Integer.TYPE, Integer.TYPE});
            this.f2478b = com.baidu.helios.channels.csc.d.a(invoke.getClass(), com.baidu.helios.channels.csc.d.a(com.baidu.helios.channels.csc.b.b()), new Class[]{this.d});
        }

        int a(Object obj, Object obj2) {
            try {
                return ((Integer) this.f2478b.invoke(obj, obj2)).intValue();
            } catch (Exception e) {
                throw new d.a("");
            }
        }

        void a(Object obj, Object obj2, int i) {
            try {
                this.f2477a.invoke(obj, obj2, Integer.valueOf(i), 1);
            } catch (Exception e) {
                throw new d.a("");
            }
        }

        Object am(Context context) {
            try {
                return this.c.invoke(context, new Object[0]);
            } catch (Exception e) {
                throw new d.a("");
            }
        }
    }

    /* loaded from: classes15.dex */
    class f extends a.b {
        private String h;
        private int i;
        private long j;
        private String k;
        private int l;

        public f(String str) {
            super(QuantumChannel.this.awu, str);
        }

        public String a() {
            return this.h;
        }

        public void a(int i) {
            if (this.i != i) {
                this.i = i;
                aV(true);
            }
        }

        public void a(long j) {
            if (this.j != j) {
                this.j = j;
                aV(true);
            }
        }

        public void a(String str) {
            if (str.equals(this.h)) {
                return;
            }
            this.h = str;
            aV(true);
        }

        public int b() {
            return this.i;
        }

        public void b(String str) {
            if (str.equals(this.k)) {
                return;
            }
            this.k = str;
            aV(true);
        }

        public String c() {
            return this.k;
        }

        @Override // com.baidu.helios.channels.a.b
        public void q(JSONObject jSONObject) {
            this.h = jSONObject.getString(Config.INPUT_DEF_PKG);
            this.i = jSONObject.getInt("aid_ver");
            this.j = jSONObject.getLong("last_fe_ts");
            this.k = jSONObject.getString("id");
            this.l = jSONObject.getInt("d_form_ver");
        }

        @Override // com.baidu.helios.channels.a.b
        public void r(JSONObject jSONObject) {
            jSONObject.put(Config.INPUT_DEF_PKG, this.h);
            jSONObject.put("aid_ver", this.i);
            jSONObject.put("last_fe_ts", this.j);
            jSONObject.put("id", this.k);
            jSONObject.put("d_form_ver", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
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
        this.awO = new c();
    }

    private int a(Object obj, Object obj2) {
        try {
            return this.awP.a(obj, obj2);
        } catch (d.a e2) {
            throw e2;
        } catch (Throwable th) {
            throw new b(th);
        }
    }

    private int a(Object obj, String str) {
        d.a aVar = new d.a();
        for (int i = 0; i < d; i++) {
            aVar.b(d.b(a(obj, x(str, i))));
        }
        byte[] b2 = aVar.yN().b();
        int i2 = 0;
        for (int i3 = 0; i3 < b2.length; i3++) {
            i2 |= (b2[i3] & 255) << (i3 * 8);
        }
        return i2;
    }

    private Object a(String str) {
        try {
            return com.baidu.helios.channels.csc.d.a(this.awP.d, new Object[]{str, this.awQ.f2472b});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new b("");
        }
    }

    private void a(Object obj, Object obj2, int i) {
        try {
            this.awP.a(obj, obj2, i);
        } catch (d.a e2) {
            throw e2;
        } catch (Throwable th) {
            throw new b(th);
        }
    }

    private a.e b(a.d dVar) {
        String d2;
        Context context = this.awI.applicationContext;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            boolean z = packageInfo.lastUpdateTime != this.awO.c();
            this.awO.c(packageInfo.lastUpdateTime);
            if (z || this.awO.b(6L) != 4) {
                com.baidu.helios.ids.a fn = this.awI.awM.fn("aid");
                try {
                    Object am = this.awP.am(context);
                    if (am == null) {
                        return a.e.dq(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                    }
                    try {
                        if (this.awO.b(1L) == 1 && (d2 = this.awO.d()) != null && d2.equals(fn.zk()) && d(am, packageName)) {
                            if (this.awO.a() == a(am, packageName)) {
                                return a.e.yJ();
                            }
                        }
                        byte[] zl = fn.zl();
                        this.awO.a(fn.zk());
                        d g2 = d.g(zl, zl.length * 8);
                        try {
                            int a2 = g2.a();
                            for (int i = 0; i < a2; i++) {
                                a(am, w(packageName, i), g2.a(i));
                            }
                            int nextInt = new Random().nextInt(255);
                            this.awO.a(nextInt);
                            byte[] bArr = new byte[1];
                            for (int i2 = 0; i2 < 1; i2++) {
                                bArr[i2] = (byte) ((nextInt >> (i2 * 8)) & 255);
                            }
                            d g3 = d.g(bArr, 8);
                            try {
                                int a3 = g3.a();
                                for (int i3 = 0; i3 < a3; i3++) {
                                    a(am, x(packageName, i3), g3.a(i3));
                                }
                                try {
                                    if (a(am, packageName) != nextInt) {
                                        return a.e.dq(-103);
                                    }
                                    try {
                                        a(am, a(packageName), 1);
                                        this.awO.a(System.currentTimeMillis());
                                        this.awO.a(1L, 1L);
                                        return a.e.yJ();
                                    } catch (b e2) {
                                        this.awO.a(4L, 6L);
                                        return a.e.dq(-101);
                                    } catch (d.a e3) {
                                        return a.e.dq(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                                    }
                                } catch (b e4) {
                                    this.awO.a(4L, 6L);
                                    return a.e.dq(-101);
                                } catch (g e5) {
                                    return a.e.dq(-103);
                                } catch (d.a e6) {
                                    return a.e.dq(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                                }
                            } catch (b e7) {
                                this.awO.a(4L, 6L);
                                return a.e.dq(-101);
                            } catch (d.a e8) {
                                return a.e.dq(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                            }
                        } catch (b e9) {
                            this.awO.a(4L, 6L);
                            return a.e.dq(-101);
                        } catch (d.a e10) {
                            return a.e.dq(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                        }
                    } catch (b e11) {
                        this.awO.a(4L, 6L);
                        return a.e.dq(-101);
                    } catch (g e12) {
                        try {
                            a(am, a(packageName), 0);
                        } catch (Exception e13) {
                        }
                        return a.e.dq(-103);
                    } catch (d.a e14) {
                        return a.e.dq(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                    }
                } catch (d.a e15) {
                    return a.e.dq(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                }
            }
            return a.e.dq(-101);
        } catch (PackageManager.NameNotFoundException e16) {
            return a.e.dq(-100);
        }
    }

    private byte[] c(Object obj, String str) {
        d.a aVar = new d.a();
        for (int i = 0; i < f2470b; i++) {
            aVar.b(d.b(a(obj, w(str, i))));
        }
        return aVar.yN().b();
    }

    private boolean d(Object obj, String str) {
        return a(obj, a(str)) == 1;
    }

    private Object w(String str, int i) {
        try {
            return com.baidu.helios.channels.csc.d.a(this.awP.d, new Object[]{str, this.awQ.f2471a + i});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new b("");
        }
    }

    private Object x(String str, int i) {
        try {
            return com.baidu.helios.channels.csc.d.a(this.awP.d, new Object[]{str, this.awQ.c + i});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new b("");
        }
    }

    @Override // com.baidu.helios.channels.a
    public a.e a(a.d dVar) {
        this.awO.e();
        try {
            return b(dVar);
        } finally {
            this.awO.f();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF, IF] complete} */
    @Override // com.baidu.helios.channels.a
    public a.g a(String str, a.f fVar) {
        f fVar2 = null;
        try {
            Object am = this.awP.am(this.awI.applicationContext);
            if (am == null) {
                return a.g.e(-101, null);
            }
            if (fVar.useCache) {
                f fVar3 = new f(str);
                fVar3.yH();
                if (str.equals(fVar3.a())) {
                    try {
                        if (fVar3.b() == a(am, str)) {
                            String c2 = fVar3.c();
                            if (!TextUtils.isEmpty(c2)) {
                                return a.g.fk(c2);
                            }
                        }
                        fVar2 = fVar3;
                    } catch (b e2) {
                        return a.g.j(e2);
                    } catch (g e3) {
                        return a.g.dr(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
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
                        if (!d(am, str)) {
                            a.g e5 = a.g.e(-2, null);
                            if (!fVar.useCache || fVar2 == null) {
                                return e5;
                            }
                            fVar2.yI();
                            return e5;
                        }
                        String B = com.baidu.helios.ids.a.a.B(c(am, str));
                        int a2 = a(am, str);
                        if (fVar.useCache && fVar2 != null) {
                            fVar2.b(B);
                            fVar2.a(str);
                            fVar2.a(System.currentTimeMillis());
                            fVar2.a(a2);
                        }
                        a.g fk = a.g.fk(B);
                        if (!fVar.useCache || fVar2 == null) {
                            return fk;
                        }
                        fVar2.yI();
                        return fk;
                    } catch (g e6) {
                        a.g dr = a.g.dr(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                        if (!fVar.useCache || fVar2 == null) {
                            return dr;
                        }
                        fVar2.yI();
                        return dr;
                    }
                } catch (b e7) {
                    a.g j = a.g.j(e7);
                    if (!fVar.useCache || fVar2 == null) {
                        return j;
                    }
                    fVar2.yI();
                    return j;
                } catch (d.a e8) {
                    a.g e9 = a.g.e(-2, null);
                    if (!fVar.useCache || fVar2 == null) {
                        return e9;
                    }
                    fVar2.yI();
                    return e9;
                }
            } catch (Throwable th) {
                if (fVar.useCache && fVar2 != null) {
                    fVar2.yI();
                }
                throw th;
            }
        } catch (d.a e10) {
            return a.g.e(-101, null);
        }
    }

    @Override // com.baidu.helios.channels.a
    public void a(a.c cVar) {
        this.awu = this.awJ.fm("csc");
        this.awP = new e(this.awI.applicationContext);
        this.awQ = new a();
    }
}
