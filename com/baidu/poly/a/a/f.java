package com.baidu.poly.a.a;

import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
/* loaded from: classes6.dex */
public class f implements e {
    private Handler bEP;
    private boolean sc;

    /* loaded from: classes6.dex */
    class a implements Runnable {
        final /* synthetic */ String bEK;
        final /* synthetic */ com.baidu.poly.a.a.c bEL;
        final /* synthetic */ com.baidu.poly.a.a.b bEM;
        final /* synthetic */ com.baidu.poly.a.a.a bEN;

        /* renamed from: com.baidu.poly.a.a.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class RunnableC0260a implements Runnable {
            final /* synthetic */ String bEG;

            RunnableC0260a(String str) {
                this.bEG = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.bEN.a(this.bEG);
            }
        }

        /* loaded from: classes6.dex */
        class b implements Runnable {
            final /* synthetic */ String bEG;
            final /* synthetic */ int bEI;

            b(int i, String str) {
                this.bEI = i;
                this.bEG = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.bEN.a(new IOException("status code " + this.bEI + ", response " + this.bEG), null);
            }
        }

        /* loaded from: classes6.dex */
        class c implements Runnable {
            final /* synthetic */ Throwable bEJ;

            c(Throwable th) {
                this.bEJ = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.bEN.a(this.bEJ, null);
            }
        }

        a(String str, com.baidu.poly.a.a.c cVar, com.baidu.poly.a.a.b bVar, com.baidu.poly.a.a.a aVar) {
            this.bEK = str;
            this.bEL = cVar;
            this.bEM = bVar;
            this.bEN = aVar;
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
                r12 = this;
                r10 = 2
                r3 = 0
                r9 = 0
                r8 = 1
                java.net.URL r0 = new java.net.URL     // Catch: java.lang.Throwable -> L3b
                java.lang.String r1 = r12.bEK     // Catch: java.lang.Throwable -> L3b
                r0.<init>(r1)     // Catch: java.lang.Throwable -> L3b
                java.net.URLConnection r0 = r0.openConnection()     // Catch: java.lang.Throwable -> L3b
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch: java.lang.Throwable -> L3b
                com.baidu.poly.a.a.c r1 = r12.bEL     // Catch: java.lang.Throwable -> L3b
                java.util.Map r1 = r1.p()     // Catch: java.lang.Throwable -> L3b
                java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L3b
                java.util.Iterator r4 = r1.iterator()     // Catch: java.lang.Throwable -> L3b
            L1f:
                boolean r1 = r4.hasNext()     // Catch: java.lang.Throwable -> L3b
                if (r1 == 0) goto L68
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
                r1 = r0
                r0 = r3
            L3e:
                java.lang.String r2 = "POST FAILED"
                com.baidu.poly.util.d.a(r2, r1)     // Catch: java.lang.Throwable -> L1b0
                com.baidu.poly.a.a.a r2 = r12.bEN     // Catch: java.lang.Throwable -> L1b0
                if (r2 == 0) goto L5e
                com.baidu.poly.a.a.f r2 = com.baidu.poly.a.a.f.this     // Catch: java.lang.Throwable -> L1b0
                boolean r2 = com.baidu.poly.a.a.f.a(r2)     // Catch: java.lang.Throwable -> L1b0
                if (r2 == 0) goto L1a8
                com.baidu.poly.a.a.f r2 = com.baidu.poly.a.a.f.this     // Catch: java.lang.Throwable -> L1b0
                android.os.Handler r2 = com.baidu.poly.a.a.f.b(r2)     // Catch: java.lang.Throwable -> L1b0
                com.baidu.poly.a.a.f$a$c r4 = new com.baidu.poly.a.a.f$a$c     // Catch: java.lang.Throwable -> L1b0
                r4.<init>(r1)     // Catch: java.lang.Throwable -> L1b0
                r2.post(r4)     // Catch: java.lang.Throwable -> L1b0
            L5e:
                java.io.Closeable[] r1 = new java.io.Closeable[r10]
                r1[r9] = r3
                r1[r8] = r0
                com.baidu.poly.util.c.a(r1)
            L67:
                return
            L68:
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
                com.baidu.poly.a.a.b r1 = r12.bEM     // Catch: java.lang.Throwable -> L3b
                java.util.Map r1 = r1.p()     // Catch: java.lang.Throwable -> L3b
                java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L3b
                java.util.Iterator r5 = r1.iterator()     // Catch: java.lang.Throwable -> L3b
            L97:
                boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L3b
                if (r1 == 0) goto Ld5
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
                goto L97
            Lc9:
                r0 = move-exception
                r1 = r3
            Lcb:
                java.io.Closeable[] r2 = new java.io.Closeable[r10]
                r2[r9] = r3
                r2[r8] = r1
                com.baidu.poly.util.c.a(r2)
                throw r0
            Ld5:
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
                r1.write(r2)     // Catch: java.lang.Throwable -> L1a2
                r1.flush()     // Catch: java.lang.Throwable -> L1a2
                int r2 = r0.getResponseCode()     // Catch: java.lang.Throwable -> L1a2
                r4 = 200(0xc8, float:2.8E-43)
                if (r2 < r4) goto L149
                r4 = 299(0x12b, float:4.19E-43)
                if (r2 > r4) goto L149
                java.io.InputStream r0 = r0.getInputStream()     // Catch: java.lang.Throwable -> L143
                java.lang.String r2 = com.baidu.poly.util.c.a(r0)     // Catch: java.lang.Throwable -> L139
                com.baidu.poly.a.a.a r3 = r12.bEN     // Catch: java.lang.Throwable -> L139
                if (r3 == 0) goto L128
                com.baidu.poly.a.a.f r3 = com.baidu.poly.a.a.f.this     // Catch: java.lang.Throwable -> L139
                boolean r3 = com.baidu.poly.a.a.f.a(r3)     // Catch: java.lang.Throwable -> L139
                if (r3 == 0) goto L133
                com.baidu.poly.a.a.f r3 = com.baidu.poly.a.a.f.this     // Catch: java.lang.Throwable -> L139
                android.os.Handler r3 = com.baidu.poly.a.a.f.b(r3)     // Catch: java.lang.Throwable -> L139
                com.baidu.poly.a.a.f$a$a r4 = new com.baidu.poly.a.a.f$a$a     // Catch: java.lang.Throwable -> L139
                r4.<init>(r2)     // Catch: java.lang.Throwable -> L139
                r3.post(r4)     // Catch: java.lang.Throwable -> L139
            L128:
                java.io.Closeable[] r2 = new java.io.Closeable[r10]
                r2[r9] = r0
                r2[r8] = r1
                com.baidu.poly.util.c.a(r2)
                goto L67
            L133:
                com.baidu.poly.a.a.a r3 = r12.bEN     // Catch: java.lang.Throwable -> L139
                r3.a(r2)     // Catch: java.lang.Throwable -> L139
                goto L128
            L139:
                r2 = move-exception
                r3 = r0
                r0 = r1
                r1 = r2
                goto L3e
            L13f:
                r2 = move-exception
                r3 = r0
                r0 = r2
                goto Lcb
            L143:
                r0 = move-exception
                r11 = r1
                r1 = r0
                r0 = r11
                goto L3e
            L149:
                java.io.InputStream r0 = r0.getErrorStream()     // Catch: java.lang.Throwable -> L1a2
                java.lang.String r3 = com.baidu.poly.util.c.a(r0)     // Catch: java.lang.Throwable -> L16c
                com.baidu.poly.a.a.a r4 = r12.bEN     // Catch: java.lang.Throwable -> L16c
                if (r4 == 0) goto L128
                com.baidu.poly.a.a.f r4 = com.baidu.poly.a.a.f.this     // Catch: java.lang.Throwable -> L16c
                boolean r4 = com.baidu.poly.a.a.f.a(r4)     // Catch: java.lang.Throwable -> L16c
                if (r4 == 0) goto L172
                com.baidu.poly.a.a.f r4 = com.baidu.poly.a.a.f.this     // Catch: java.lang.Throwable -> L16c
                android.os.Handler r4 = com.baidu.poly.a.a.f.b(r4)     // Catch: java.lang.Throwable -> L16c
                com.baidu.poly.a.a.f$a$b r5 = new com.baidu.poly.a.a.f$a$b     // Catch: java.lang.Throwable -> L16c
                r5.<init>(r2, r3)     // Catch: java.lang.Throwable -> L16c
                r4.post(r5)     // Catch: java.lang.Throwable -> L16c
                goto L128
            L16c:
                r2 = move-exception
                r3 = r0
                r0 = r1
                r1 = r2
                goto L3e
            L172:
                com.baidu.poly.a.a.a r4 = r12.bEN     // Catch: java.lang.Throwable -> L16c
                java.io.IOException r5 = new java.io.IOException     // Catch: java.lang.Throwable -> L16c
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L16c
                r6.<init>()     // Catch: java.lang.Throwable -> L16c
                java.lang.String r7 = "status code "
                java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L16c
                java.lang.StringBuilder r2 = r6.append(r2)     // Catch: java.lang.Throwable -> L16c
                java.lang.String r6 = ", response "
                java.lang.StringBuilder r2 = r2.append(r6)     // Catch: java.lang.Throwable -> L16c
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L16c
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L16c
                r5.<init>(r2)     // Catch: java.lang.Throwable -> L16c
                r2 = 0
                r4.a(r5, r2)     // Catch: java.lang.Throwable -> L16c
                goto L128
            L19d:
                r2 = move-exception
                r3 = r0
                r0 = r2
                goto Lcb
            L1a2:
                r0 = move-exception
                r11 = r1
                r1 = r0
                r0 = r11
                goto L3e
            L1a8:
                com.baidu.poly.a.a.a r2 = r12.bEN     // Catch: java.lang.Throwable -> L1b0
                r4 = 0
                r2.a(r1, r4)     // Catch: java.lang.Throwable -> L1b0
                goto L5e
            L1b0:
                r1 = move-exception
                r11 = r1
                r1 = r0
                r0 = r11
                goto Lcb
            L1b6:
                r0 = move-exception
                goto Lcb
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
        return fVar.sc;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.poly.a.a.f.a.run():void] */
    static /* synthetic */ Handler b(f fVar) {
        return fVar.bEP;
    }

    public f(boolean z) {
        this.bEP = new Handler(Looper.getMainLooper());
        this.sc = z;
    }

    @Override // com.baidu.poly.a.a.e
    public void a(String str, c cVar, b bVar, com.baidu.poly.a.a.a<String> aVar) {
        com.baidu.poly.c.a.execute(new a(str, cVar, bVar, aVar));
    }
}
