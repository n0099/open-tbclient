package com.baidu.poly.a.a;

import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
/* loaded from: classes14.dex */
public class f implements e {
    private Handler coB;
    private boolean coC;

    /* loaded from: classes14.dex */
    class a implements Runnable {
        final /* synthetic */ com.baidu.poly.a.a.c cox;
        final /* synthetic */ com.baidu.poly.a.a.b coy;
        final /* synthetic */ com.baidu.poly.a.a.a coz;
        final /* synthetic */ String qc;

        /* renamed from: com.baidu.poly.a.a.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        class RunnableC0301a implements Runnable {
            final /* synthetic */ String cot;

            RunnableC0301a(String str) {
                this.cot = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.coz.a(this.cot);
            }
        }

        /* loaded from: classes14.dex */
        class b implements Runnable {
            final /* synthetic */ String cot;
            final /* synthetic */ int cov;

            b(int i, String str) {
                this.cov = i;
                this.cot = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.coz.a(new IOException("status code " + this.cov + ", response " + this.cot), null);
            }
        }

        /* loaded from: classes14.dex */
        class c implements Runnable {
            final /* synthetic */ Throwable cow;

            c(Throwable th) {
                this.cow = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.coz.a(this.cow, null);
            }
        }

        a(String str, com.baidu.poly.a.a.c cVar, com.baidu.poly.a.a.b bVar, com.baidu.poly.a.a.a aVar) {
            this.qc = str;
            this.cox = cVar;
            this.coy = bVar;
            this.coz = aVar;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
            	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
            	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
            */
        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [33=5] */
        @Override // java.lang.Runnable
        public void run() {
            /*
                r11 = this;
                r10 = 2
                r3 = 0
                r9 = 0
                r8 = 1
                java.net.URL r0 = new java.net.URL     // Catch: java.lang.Throwable -> L3b
                java.lang.String r1 = r11.qc     // Catch: java.lang.Throwable -> L3b
                r0.<init>(r1)     // Catch: java.lang.Throwable -> L3b
                java.net.URLConnection r0 = r0.openConnection()     // Catch: java.lang.Throwable -> L3b
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch: java.lang.Throwable -> L3b
                com.baidu.poly.a.a.c r1 = r11.cox     // Catch: java.lang.Throwable -> L3b
                java.util.Map r1 = r1.p()     // Catch: java.lang.Throwable -> L3b
                java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L3b
                java.util.Iterator r4 = r1.iterator()     // Catch: java.lang.Throwable -> L3b
            L1f:
                boolean r1 = r4.hasNext()     // Catch: java.lang.Throwable -> L3b
                if (r1 == 0) goto L69
                java.lang.Object r1 = r4.next()     // Catch: java.lang.Throwable -> L3b
                java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L3b
                java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Throwable -> L3b
                java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L3b
                java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L3b
                java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L3b
                r0.setRequestProperty(r2, r1)     // Catch: java.lang.Throwable -> L3b
                goto L1f
            L3b:
                r0 = move-exception
                r1 = r3
                r2 = r0
                r4 = r3
            L3f:
                java.lang.String r0 = "POST FAILED"
                com.baidu.poly.util.d.a(r0, r2)     // Catch: java.lang.Throwable -> L1ab
                com.baidu.poly.a.a.a r0 = r11.coz     // Catch: java.lang.Throwable -> L1ab
                if (r0 == 0) goto L5f
                com.baidu.poly.a.a.f r0 = com.baidu.poly.a.a.f.this     // Catch: java.lang.Throwable -> L1ab
                boolean r0 = com.baidu.poly.a.a.f.a(r0)     // Catch: java.lang.Throwable -> L1ab
                if (r0 == 0) goto L1a3
                com.baidu.poly.a.a.f r0 = com.baidu.poly.a.a.f.this     // Catch: java.lang.Throwable -> L1ab
                android.os.Handler r0 = com.baidu.poly.a.a.f.b(r0)     // Catch: java.lang.Throwable -> L1ab
                com.baidu.poly.a.a.f$a$c r3 = new com.baidu.poly.a.a.f$a$c     // Catch: java.lang.Throwable -> L1ab
                r3.<init>(r2)     // Catch: java.lang.Throwable -> L1ab
                r0.post(r3)     // Catch: java.lang.Throwable -> L1ab
            L5f:
                java.io.Closeable[] r0 = new java.io.Closeable[r10]
                r0[r9] = r4
                r0[r8] = r1
                com.baidu.poly.util.c.a(r0)
            L68:
                return
            L69:
                r1 = 1
                r0.setDoInput(r1)     // Catch: java.lang.Throwable -> L3b
                r1 = 1
                r0.setDoOutput(r1)     // Catch: java.lang.Throwable -> L3b
                java.lang.String r1 = "POST"
                r0.setRequestMethod(r1)     // Catch: java.lang.Throwable -> L3b
                r1 = 0
                r0.setUseCaches(r1)     // Catch: java.lang.Throwable -> L3b
                r1 = 15000(0x3a98, float:2.102E-41)
                r0.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L3b
                r1 = 15000(0x3a98, float:2.102E-41)
                r0.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L3b
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b
                r4.<init>()     // Catch: java.lang.Throwable -> L3b
                com.baidu.poly.a.a.b r1 = r11.coy     // Catch: java.lang.Throwable -> L3b
                java.util.Map r1 = r1.p()     // Catch: java.lang.Throwable -> L3b
                java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L3b
                java.util.Iterator r5 = r1.iterator()     // Catch: java.lang.Throwable -> L3b
            L98:
                boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L3b
                if (r1 == 0) goto Ld8
                java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L3b
                java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L3b
                java.lang.Object r2 = r1.getValue()     // Catch: java.lang.Throwable -> L3b
                java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L3b
                java.lang.String r2 = java.net.URLEncoder.encode(r2)     // Catch: java.lang.Throwable -> L3b
                java.lang.Object r1 = r1.getKey()     // Catch: java.lang.Throwable -> L3b
                java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L3b
                java.lang.StringBuilder r1 = r4.append(r1)     // Catch: java.lang.Throwable -> L3b
                java.lang.String r6 = "="
                java.lang.StringBuilder r1 = r1.append(r6)     // Catch: java.lang.Throwable -> L3b
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L3b
                java.lang.String r2 = "&"
                r1.append(r2)     // Catch: java.lang.Throwable -> L3b
                goto L98
            Lca:
                r0 = move-exception
                r2 = r0
                r1 = r3
                r4 = r3
            Lce:
                java.io.Closeable[] r0 = new java.io.Closeable[r10]
                r0[r9] = r4
                r0[r8] = r1
                com.baidu.poly.util.c.a(r0)
                throw r2
            Ld8:
                java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L3b
                byte[] r2 = r1.getBytes()     // Catch: java.lang.Throwable -> L3b
                java.lang.String r1 = "Content-Length"
                int r4 = r2.length     // Catch: java.lang.Throwable -> L3b
                java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L3b
                r0.setRequestProperty(r1, r4)     // Catch: java.lang.Throwable -> L3b
                r0.connect()     // Catch: java.lang.Throwable -> L3b
                java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch: java.lang.Throwable -> L3b
                java.io.OutputStream r4 = r0.getOutputStream()     // Catch: java.lang.Throwable -> L3b
                r1.<init>(r4)     // Catch: java.lang.Throwable -> L3b
                r1.write(r2)     // Catch: java.lang.Throwable -> L19e
                r1.flush()     // Catch: java.lang.Throwable -> L19e
                int r2 = r0.getResponseCode()     // Catch: java.lang.Throwable -> L19e
                r4 = 200(0xc8, float:2.8E-43)
                if (r2 < r4) goto L148
                r4 = 299(0x12b, float:4.19E-43)
                if (r2 > r4) goto L148
                java.io.InputStream r0 = r0.getInputStream()     // Catch: java.lang.Throwable -> L143
                java.lang.String r2 = com.baidu.poly.util.c.a(r0)     // Catch: java.lang.Throwable -> L13c
                com.baidu.poly.a.a.a r3 = r11.coz     // Catch: java.lang.Throwable -> L13c
                if (r3 == 0) goto L12b
                com.baidu.poly.a.a.f r3 = com.baidu.poly.a.a.f.this     // Catch: java.lang.Throwable -> L13c
                boolean r3 = com.baidu.poly.a.a.f.a(r3)     // Catch: java.lang.Throwable -> L13c
                if (r3 == 0) goto L136
                com.baidu.poly.a.a.f r3 = com.baidu.poly.a.a.f.this     // Catch: java.lang.Throwable -> L13c
                android.os.Handler r3 = com.baidu.poly.a.a.f.b(r3)     // Catch: java.lang.Throwable -> L13c
                com.baidu.poly.a.a.f$a$a r4 = new com.baidu.poly.a.a.f$a$a     // Catch: java.lang.Throwable -> L13c
                r4.<init>(r2)     // Catch: java.lang.Throwable -> L13c
                r3.post(r4)     // Catch: java.lang.Throwable -> L13c
            L12b:
                java.io.Closeable[] r2 = new java.io.Closeable[r10]
                r2[r9] = r0
                r2[r8] = r1
                com.baidu.poly.util.c.a(r2)
                goto L68
            L136:
                com.baidu.poly.a.a.a r3 = r11.coz     // Catch: java.lang.Throwable -> L13c
                r3.a(r2)     // Catch: java.lang.Throwable -> L13c
                goto L12b
            L13c:
                r2 = move-exception
                r4 = r0
                goto L3f
            L140:
                r2 = move-exception
                r4 = r0
                goto Lce
            L143:
                r0 = move-exception
                r2 = r0
                r4 = r3
                goto L3f
            L148:
                java.io.InputStream r0 = r0.getErrorStream()     // Catch: java.lang.Throwable -> L19e
                java.lang.String r3 = com.baidu.poly.util.c.a(r0)     // Catch: java.lang.Throwable -> L16b
                com.baidu.poly.a.a.a r4 = r11.coz     // Catch: java.lang.Throwable -> L16b
                if (r4 == 0) goto L12b
                com.baidu.poly.a.a.f r4 = com.baidu.poly.a.a.f.this     // Catch: java.lang.Throwable -> L16b
                boolean r4 = com.baidu.poly.a.a.f.a(r4)     // Catch: java.lang.Throwable -> L16b
                if (r4 == 0) goto L16f
                com.baidu.poly.a.a.f r4 = com.baidu.poly.a.a.f.this     // Catch: java.lang.Throwable -> L16b
                android.os.Handler r4 = com.baidu.poly.a.a.f.b(r4)     // Catch: java.lang.Throwable -> L16b
                com.baidu.poly.a.a.f$a$b r5 = new com.baidu.poly.a.a.f$a$b     // Catch: java.lang.Throwable -> L16b
                r5.<init>(r2, r3)     // Catch: java.lang.Throwable -> L16b
                r4.post(r5)     // Catch: java.lang.Throwable -> L16b
                goto L12b
            L16b:
                r2 = move-exception
                r4 = r0
                goto L3f
            L16f:
                com.baidu.poly.a.a.a r4 = r11.coz     // Catch: java.lang.Throwable -> L16b
                java.io.IOException r5 = new java.io.IOException     // Catch: java.lang.Throwable -> L16b
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L16b
                r6.<init>()     // Catch: java.lang.Throwable -> L16b
                java.lang.String r7 = "status code "
                java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L16b
                java.lang.StringBuilder r2 = r6.append(r2)     // Catch: java.lang.Throwable -> L16b
                java.lang.String r6 = ", response "
                java.lang.StringBuilder r2 = r2.append(r6)     // Catch: java.lang.Throwable -> L16b
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L16b
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L16b
                r5.<init>(r2)     // Catch: java.lang.Throwable -> L16b
                r2 = 0
                r4.a(r5, r2)     // Catch: java.lang.Throwable -> L16b
                goto L12b
            L19a:
                r2 = move-exception
                r4 = r0
                goto Lce
            L19e:
                r0 = move-exception
                r2 = r0
                r4 = r3
                goto L3f
            L1a3:
                com.baidu.poly.a.a.a r0 = r11.coz     // Catch: java.lang.Throwable -> L1ab
                r3 = 0
                r0.a(r2, r3)     // Catch: java.lang.Throwable -> L1ab
                goto L5f
            L1ab:
                r0 = move-exception
                r3 = r4
            L1ad:
                r2 = r0
                r4 = r3
                goto Lce
            L1b1:
                r0 = move-exception
                goto L1ad
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.poly.a.a.f.a.run():void");
        }
    }

    public f() {
        this(true);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.poly.a.a.f.a.run():void] */
    static /* synthetic */ boolean a(f fVar) {
        return fVar.coC;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.poly.a.a.f.a.run():void] */
    static /* synthetic */ Handler b(f fVar) {
        return fVar.coB;
    }

    public f(boolean z) {
        this.coB = new Handler(Looper.getMainLooper());
        this.coC = z;
    }

    @Override // com.baidu.poly.a.a.e
    public void a(String str, c cVar, b bVar, com.baidu.poly.a.a.a<String> aVar) {
        com.baidu.poly.c.a.execute(new a(str, cVar, bVar, aVar));
    }
}
