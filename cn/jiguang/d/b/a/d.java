package cn.jiguang.d.b.a;

import android.content.Context;
import cn.jiguang.d.h.x;
import cn.jiguang.g.k;
import cn.jiguang.g.m;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public final class d {
    private final Context a;
    private final long c;
    private byte[] f;
    private final cn.jiguang.d.b.g ll;
    private g lo;
    private a lp;
    private c lq;
    private final a lm = new a();
    private final a ln = new a();
    private final LinkedList<f> lr = f.J(cn.jiguang.d.a.a.m());

    public d(Context context, cn.jiguang.d.b.g gVar, long j) {
        this.a = context;
        this.ll = gVar;
        this.c = j;
    }

    private int a(a aVar, DatagramSocket datagramSocket, byte[] bArr) {
        if (aVar != null) {
            Iterator<Map.Entry<c, String>> b = aVar.b();
            while (b.hasNext()) {
                c key = b.next().getKey();
                int a = a(key.a, key.b, datagramSocket, bArr);
                if (a == 0) {
                    return a;
                }
            }
        }
        return -1;
    }

    private static int a(String str, int i, DatagramSocket datagramSocket, byte[] bArr) {
        try {
            InetAddress M = cn.jiguang.d.d.g.M(str);
            if (M == null) {
                return -1;
            }
            byte[] bArr2 = g(cn.jiguang.d.d.g.a(datagramSocket, new DatagramPacket(bArr, bArr.length, M, i))).b;
            if (bArr2 == null || bArr2.length == 0) {
                throw new Exception("byte could not be empty");
            }
            if (bArr2.length == 1) {
                return bArr2[0];
            }
            return (short) (((short) (bArr2[1] & 255)) | ((short) ((bArr2[0] & 255) << 8)));
        } catch (Throwable th) {
            return -1;
        }
    }

    private static byte[] a(String str, String str2) {
        byte[] bArr;
        byte[] bytes = str2.getBytes("UTF-8");
        boolean z = true;
        try {
            byte[] a = x.a(bytes);
            if (a.length < bytes.length) {
                bArr = a;
            } else {
                z = false;
                bArr = bytes;
            }
        } catch (IOException e) {
            z = false;
            bArr = bytes;
        }
        int length = bArr.length;
        int c = cn.jiguang.d.h.a.a.c();
        return cn.jiguang.d.d.g.a(str, c, cn.jiguang.d.h.a.a.a(cn.jiguang.d.h.a.a.a(c), bArr), z, length);
    }

    private g bL() {
        if (this.lo == null) {
            String b = cn.jiguang.d.a.b(this.a);
            long c = cn.jiguang.d.a.d.c(this.a);
            int a = k.a(this.a);
            String b2 = k.b(this.a);
            cn.jiguang.a.a.b.e R = cn.jiguang.a.a.b.f.R(this.a);
            this.lo = new g(a, b, "1.2.5", c, b2, R.b(), R.c(), R.d());
        }
        return this.lo;
    }

    public static b g(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            throw new e(3, "response is empty!");
        }
        try {
            cn.jiguang.g.g gVar = new cn.jiguang.g.g(bArr);
            gVar.a();
            String str = new String(gVar.a(2));
            long b = gVar.b();
            int i = (int) (b >>> 24);
            long j = b & 16777215;
            gVar.a();
            byte[] c = gVar.c();
            if (j != 0) {
                try {
                    c = cn.jiguang.d.h.a.a.b(cn.jiguang.d.h.a.a.a(j), c);
                    if (c == null) {
                        throw new e(4, "decrypt response error");
                    }
                } catch (Exception e) {
                    throw new e(4, "decrypt response error");
                }
            }
            if ((i & 1) == 1) {
                try {
                    c = x.b(c);
                } catch (IOException e2) {
                }
            }
            return new b(str, c);
        } catch (m e3) {
            throw new e(3, "parse head error:" + e3.getMessage());
        }
    }

    private void h() {
        while (this.lr.size() > 5) {
            this.lr.removeFirst();
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<f> it = this.lr.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        cn.jiguang.d.a.a.e(jSONArray.toString());
    }

    public final void a(String str, int i, int i2) {
        this.lm.a(str, i, String.valueOf(i2));
    }

    public final void a(String str, int i, long j, long j2, int i2) {
        if (c.a(str, i)) {
            f fVar = new f();
            fVar.a = 1;
            fVar.lt = new c(str, i);
            fVar.d = j;
            fVar.e = j2;
            fVar.j = i2;
            g bL = bL();
            if (bL != null) {
                fVar.f = bL.a();
                fVar.c = bL.b();
                fVar.g = bL.c();
                fVar.h = bL.bN();
                fVar.i = bL.e();
            }
            this.lr.add(fVar);
            h();
        }
    }

    public final boolean a(c cVar) {
        return this.lm.a(cVar);
    }

    public final void b(String str, int i, long j, long j2, int i2) {
        if (c.a(str, i)) {
            f fVar = new f();
            fVar.a = 2;
            fVar.lt = new c(str, i);
            fVar.d = j;
            fVar.e = j2;
            fVar.j = i2;
            fVar.f = k.a(this.a);
            fVar.c = cn.jiguang.d.a.d.c(this.a);
            cn.jiguang.a.a.b.e R = cn.jiguang.a.a.b.f.R(this.a);
            if (R != null && R.a()) {
                fVar.g = R.b();
                fVar.h = R.c();
                fVar.i = R.d();
            }
            this.lr.add(fVar);
            h();
        }
    }

    public final boolean b(c cVar) {
        return this.ln.a(cVar);
    }

    public final a bJ() {
        if (this.lp == null) {
            this.lp = a.I(cn.jiguang.d.a.a.l());
        }
        if (this.lp == null || this.lp.a()) {
            this.lp = new a();
            LinkedHashMap<String, Integer> bE = cn.jiguang.d.a.ld.bE();
            if (bE != null) {
                for (String str : bE.keySet()) {
                    this.lp.a(str, bE.get(str).intValue(), "hardcode_ip");
                }
            }
            if (!this.lp.a()) {
                cn.jiguang.d.a.a.d(this.lp.toString());
            }
        }
        return this.lp;
    }

    public final a bK() {
        this.lq = c.a(cn.jiguang.d.a.a.n());
        a aVar = new a();
        for (Map.Entry<String, Integer> entry : cn.jiguang.d.a.ld.bD().entrySet()) {
            aVar.a(entry.getKey(), entry.getValue().intValue(), "hardcode_domain");
        }
        if (this.lq != null) {
            aVar.a(this.lq.a, this.lq.b, "last_good");
        }
        return aVar;
    }

    public final cn.jiguang.d.b.g bM() {
        return this.ll;
    }

    public final void c(a aVar) {
        if (aVar == null || aVar.equals(this.lp)) {
            return;
        }
        this.lp = aVar;
        cn.jiguang.d.a.a.d(this.lp.toString());
    }

    public final void c(c cVar) {
        if (cVar.equals(this.lq)) {
            return;
        }
        this.lq = cVar;
        cn.jiguang.d.a.a.f(this.lq.toString());
    }

    public final byte[] c() {
        if (this.f == null) {
            bL();
            try {
                this.f = a("UG", this.lo.f().toString());
            } catch (Exception e) {
                throw new e(1, "Failed to package data - " + e.getMessage());
            }
        }
        return this.f;
    }

    public final Context d() {
        return this.a;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final void f() {
        /*
            r5 = this;
            r1 = 0
            boolean r0 = cn.jiguang.d.a.a.o()     // Catch: java.lang.Throwable -> L4d
            if (r0 != 0) goto L8
        L7:
            return
        L8:
            java.net.DatagramSocket r0 = new java.net.DatagramSocket     // Catch: java.lang.Throwable -> L4d
            r0.<init>()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r1 = cn.jiguang.d.a.a.m()     // Catch: java.lang.Throwable -> L65
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L65
            if (r2 == 0) goto L1d
            r0.close()     // Catch: java.lang.Throwable -> L1b
            goto L7
        L1b:
            r0 = move-exception
            goto L7
        L1d:
            java.lang.String r2 = "DG"
            byte[] r2 = a(r2, r1)     // Catch: java.lang.Throwable -> L65
            cn.jiguang.d.b.a.a r1 = r5.bK()     // Catch: java.lang.Throwable -> L65
            int r1 = r5.a(r1, r0, r2)     // Catch: java.lang.Throwable -> L65
            if (r1 == 0) goto L41
            cn.jiguang.c.b r1 = cn.jiguang.d.a.ld     // Catch: java.lang.Throwable -> L65
            java.lang.String r1 = r1.f()     // Catch: java.lang.Throwable -> L65
            java.util.List r1 = cn.jiguang.d.c.f.a(r1)     // Catch: java.lang.Throwable -> L65
            r3 = 0
            cn.jiguang.d.b.a.a r1 = cn.jiguang.d.b.a.a.b(r1, r3)     // Catch: java.lang.Throwable -> L65
            int r1 = r5.a(r1, r0, r2)     // Catch: java.lang.Throwable -> L65
        L41:
            if (r1 != 0) goto L47
            r1 = 0
            cn.jiguang.d.a.a.e(r1)     // Catch: java.lang.Throwable -> L65
        L47:
            r0.close()     // Catch: java.lang.Throwable -> L4b
            goto L7
        L4b:
            r0 = move-exception
            goto L7
        L4d:
            r0 = move-exception
            r0 = r1
        L4f:
            if (r0 == 0) goto L7
            r0.close()     // Catch: java.lang.Throwable -> L55
            goto L7
        L55:
            r0 = move-exception
            goto L7
        L57:
            r0 = move-exception
        L58:
            if (r1 == 0) goto L5d
            r1.close()     // Catch: java.lang.Throwable -> L5e
        L5d:
            throw r0
        L5e:
            r1 = move-exception
            goto L5d
        L60:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L58
        L65:
            r1 = move-exception
            goto L4f
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.b.a.d.f():void");
    }

    public final void h(String str, int i, int i2) {
        this.ln.a(str, i, String.valueOf(i2));
    }
}
