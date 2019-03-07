package cn.jiguang.d.b.a.a;

import android.text.TextUtils;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class i {
    final cn.jiguang.d.b.a.d lm;

    public i(cn.jiguang.d.b.a.d dVar) {
        this.lm = dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private cn.jiguang.d.b.a.a a(InetAddress inetAddress, int i, String str, DatagramSocket datagramSocket) {
        long j;
        long j2;
        int i2;
        Throwable th;
        long j3;
        String hostAddress = inetAddress.getHostAddress();
        long bH = cn.jiguang.d.a.a.bH() + System.currentTimeMillis();
        try {
        } catch (cn.jiguang.d.b.a.e e) {
            e = e;
            j = 0;
            j2 = bH;
        }
        try {
            try {
                byte[] c = this.lm.c();
                DatagramPacket datagramPacket = new DatagramPacket(c, c.length, inetAddress, i);
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    byte[] a = cn.jiguang.d.d.g.a(datagramSocket, datagramPacket);
                    long currentTimeMillis2 = (System.currentTimeMillis() - currentTimeMillis) / 1000;
                    cn.jiguang.d.a.a.a(currentTimeMillis);
                    cn.jiguang.d.b.j L = cn.jiguang.d.d.g.L(new String(cn.jiguang.d.b.a.d.g(a).b));
                    if (L == null) {
                        throw new cn.jiguang.d.b.a.e(5, "Can not parse sis info from host: " + hostAddress);
                    }
                    L.h();
                    cn.jiguang.e.c.b("SisPolicy", "Get sis info succeed with host: " + hostAddress + " type:" + str);
                    cn.jiguang.d.a.a.e();
                    cn.jiguang.d.a.a.a(L.g());
                    this.lm.c(cn.jiguang.d.b.a.a.a(L));
                    cn.jiguang.d.b.a.a b = cn.jiguang.d.b.a.a.b(L);
                    if (b.a()) {
                        throw new cn.jiguang.d.b.a.e(5, "sis address is Empty from host:" + hostAddress);
                    }
                    this.lm.c(new cn.jiguang.d.b.a.c(hostAddress, i));
                    return b;
                } catch (Exception e2) {
                    long currentTimeMillis3 = (System.currentTimeMillis() - j3) / 1000;
                    try {
                        j2 = cn.jiguang.d.a.a.a(j3);
                    } catch (cn.jiguang.d.b.a.e e3) {
                        e = e3;
                        j2 = j3;
                        j = currentTimeMillis3;
                    } catch (Throwable th2) {
                        th = th2;
                        j2 = j3;
                        j = currentTimeMillis3;
                        i2 = 0;
                    }
                    try {
                        throw new cn.jiguang.d.b.a.e(2, "Can not get sis response from host: - " + hostAddress + " - " + e2.getMessage());
                    } catch (cn.jiguang.d.b.a.e e4) {
                        e = e4;
                        j = currentTimeMillis3;
                        try {
                            i2 = e.a();
                            try {
                                throw e;
                            } catch (Throwable th3) {
                                th = th3;
                                if (i2 == 0) {
                                    this.lm.a(hostAddress, i, j2, j, i2);
                                    this.lm.a(hostAddress, i, i2);
                                } else {
                                    this.lm.c(new cn.jiguang.d.b.a.c(hostAddress, i));
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            i2 = 0;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        j = currentTimeMillis3;
                        i2 = 0;
                        if (i2 == 0) {
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                throw new cn.jiguang.d.b.a.e(1, "Failed to package data - " + e5.getMessage());
            }
        } catch (Throwable th6) {
            th = th6;
            i2 = 0;
            j = 0;
            j2 = bH;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int a();

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    protected final cn.jiguang.d.b.a.a a(cn.jiguang.d.b.a.a r10) {
        /*
            r9 = this;
            r2 = 0
            if (r10 == 0) goto L9
            boolean r0 = r10.a()
            if (r0 == 0) goto Lb
        L9:
            r0 = r2
        La:
            return r0
        Lb:
            java.net.DatagramSocket r3 = new java.net.DatagramSocket     // Catch: java.lang.Throwable -> Lc5
            r3.<init>()     // Catch: java.lang.Throwable -> Lc5
            java.util.Iterator r4 = r10.b()     // Catch: java.lang.Throwable -> L99
        L14:
            boolean r0 = r4.hasNext()     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto Lac
            java.lang.Object r0 = r4.next()     // Catch: java.lang.Throwable -> L99
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L99
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L99
            cn.jiguang.d.b.a.c r1 = (cn.jiguang.d.b.a.c) r1     // Catch: java.lang.Throwable -> L99
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L99
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L99
            java.lang.String r5 = r1.a     // Catch: java.lang.Throwable -> L99
            java.net.InetAddress r5 = cn.jiguang.d.d.g.M(r5)     // Catch: java.lang.Throwable -> L99
            if (r5 == 0) goto L14
            java.lang.String r6 = r5.getHostAddress()     // Catch: java.lang.Throwable -> L99
            r1.a = r6     // Catch: java.lang.Throwable -> L99
            java.lang.String r6 = "SisPolicy"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            java.lang.String r8 = "To get sis - host:"
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L99
            java.lang.String r8 = r1.a     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch: java.lang.Throwable -> L99
            java.lang.String r8 = ", port:"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch: java.lang.Throwable -> L99
            int r8 = r1.b     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch: java.lang.Throwable -> L99
            java.lang.String r8 = " ,type:"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r7 = r7.append(r0)     // Catch: java.lang.Throwable -> L99
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L99
            cn.jiguang.e.c.a(r6, r7)     // Catch: java.lang.Throwable -> L99
            cn.jiguang.d.b.a.d r6 = r9.lm     // Catch: java.lang.Throwable -> L99
            boolean r6 = r6.a(r1)     // Catch: java.lang.Throwable -> L99
            if (r6 != 0) goto L14
            int r1 = r1.b     // Catch: java.lang.Throwable -> L80
            cn.jiguang.d.b.a.a r0 = r9.a(r5, r1, r0, r3)     // Catch: java.lang.Throwable -> L80
            if (r3 == 0) goto La
            r3.close()     // Catch: java.lang.Throwable -> L7e
            goto La
        L7e:
            r1 = move-exception
            goto La
        L80:
            r0 = move-exception
            java.lang.String r1 = "SisPolicy"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            java.lang.String r6 = "singleSendSis failed, error:"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r0 = r5.append(r0)     // Catch: java.lang.Throwable -> L99
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L99
            cn.jiguang.e.c.c(r1, r0)     // Catch: java.lang.Throwable -> L99
            goto L14
        L99:
            r0 = move-exception
            r1 = r3
        L9b:
            java.lang.String r3 = "SisPolicy"
            java.lang.String r4 = "Get sis info error :"
            cn.jiguang.e.c.a(r3, r4, r0)     // Catch: java.lang.Throwable -> Lc2
            if (r1 == 0) goto La9
            r1.close()     // Catch: java.lang.Throwable -> Lbc
        La9:
            r0 = r2
            goto La
        Lac:
            if (r3 == 0) goto La9
            r3.close()     // Catch: java.lang.Throwable -> Lb2
            goto La9
        Lb2:
            r0 = move-exception
            goto La9
        Lb4:
            r0 = move-exception
            r3 = r2
        Lb6:
            if (r3 == 0) goto Lbb
            r3.close()     // Catch: java.lang.Throwable -> Lbe
        Lbb:
            throw r0
        Lbc:
            r0 = move-exception
            goto La9
        Lbe:
            r1 = move-exception
            goto Lbb
        Lc0:
            r0 = move-exception
            goto Lb6
        Lc2:
            r0 = move-exception
            r3 = r1
            goto Lb6
        Lc5:
            r0 = move-exception
            r1 = r2
            goto L9b
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.b.a.a.i.a(cn.jiguang.d.b.a.a):cn.jiguang.d.b.a.a");
    }

    public final int b(cn.jiguang.d.b.a.a aVar) {
        int a;
        if (aVar == null || aVar.a()) {
            return -1;
        }
        Iterator<Map.Entry<cn.jiguang.d.b.a.c, String>> b = aVar.b();
        while (b.hasNext()) {
            if (this.lm.bM().d()) {
                return 2;
            }
            Map.Entry<cn.jiguang.d.b.a.c, String> next = b.next();
            cn.jiguang.d.b.a.c key = next.getKey();
            String value = next.getValue();
            if (!TextUtils.isEmpty(key.a) && key.b > 0) {
                String str = key.a;
                int i = key.b;
                if (this.lm.b(key)) {
                    a = 1;
                    continue;
                } else {
                    cn.jiguang.e.c.a("SisPolicy", "Open connection with " + value + " - ip:" + str + ", port:" + i);
                    long currentTimeMillis = System.currentTimeMillis();
                    cn.jiguang.d.b.g bM = this.lm.bM();
                    if (bM.d()) {
                        a = -991;
                    } else {
                        a = cn.jiguang.d.g.c.cf().cg().a(str, i);
                        if (a != 0 && !bM.d()) {
                            cn.jiguang.e.c.a("ConnectingHelper", "Open connection failed - ret:" + a);
                        }
                    }
                    if (a != 0) {
                        this.lm.b(str, i, cn.jiguang.d.a.a.a(currentTimeMillis), (System.currentTimeMillis() - currentTimeMillis) / 1000, a);
                        this.lm.b(str, i, a);
                        continue;
                    } else {
                        continue;
                    }
                }
            } else {
                a = 1;
                continue;
            }
            if (a == 0) {
                cn.jiguang.d.a.a.a(key.a, key.b);
                cn.jiguang.e.c.b("SisPolicy", "Succeed to open connection - ip:" + key.a + ", port:" + key.b);
                return 0;
            }
        }
        return -1;
    }
}
