package com.baidu.poly.a.a;

import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
/* loaded from: classes11.dex */
public class f implements e {
    private Handler btZ = new Handler(Looper.getMainLooper());

    /* loaded from: classes11.dex */
    class a implements Runnable {
        final /* synthetic */ String btU;
        final /* synthetic */ com.baidu.poly.a.a.c btV;
        final /* synthetic */ com.baidu.poly.a.a.b btW;
        final /* synthetic */ com.baidu.poly.a.a.a btX;

        /* renamed from: com.baidu.poly.a.a.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        class RunnableC0233a implements Runnable {
            final /* synthetic */ String btQ;

            RunnableC0233a(String str) {
                this.btQ = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.btX.a(this.btQ);
            }
        }

        /* loaded from: classes11.dex */
        class b implements Runnable {
            final /* synthetic */ String btQ;
            final /* synthetic */ int btS;

            b(int i, String str) {
                this.btS = i;
                this.btQ = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.btX.a(new IOException("status code " + this.btS + ", response " + this.btQ), null);
            }
        }

        /* loaded from: classes11.dex */
        class c implements Runnable {
            final /* synthetic */ Throwable btT;

            c(Throwable th) {
                this.btT = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.btX.a(this.btT, null);
            }
        }

        a(String str, com.baidu.poly.a.a.c cVar, com.baidu.poly.a.a.b bVar, com.baidu.poly.a.a.a aVar) {
            this.btU = str;
            this.btV = cVar;
            this.btW = bVar;
            this.btX = aVar;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
            	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
            	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
            */
        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [29=4] */
        @Override // java.lang.Runnable
        public void run() {
            /*
                r11 = this;
                r3 = 0
                r9 = 2
                r8 = 0
                r7 = 1
                java.net.URL r0 = new java.net.URL     // Catch: java.lang.Throwable -> L3b
                java.lang.String r1 = r11.btU     // Catch: java.lang.Throwable -> L3b
                r0.<init>(r1)     // Catch: java.lang.Throwable -> L3b
                java.net.URLConnection r0 = r0.openConnection()     // Catch: java.lang.Throwable -> L3b
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch: java.lang.Throwable -> L3b
                com.baidu.poly.a.a.c r1 = r11.btV     // Catch: java.lang.Throwable -> L3b
                java.util.Map r1 = r1.MK()     // Catch: java.lang.Throwable -> L3b
                java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L3b
                java.util.Iterator r4 = r1.iterator()     // Catch: java.lang.Throwable -> L3b
            L1f:
                boolean r1 = r4.hasNext()     // Catch: java.lang.Throwable -> L3b
                if (r1 == 0) goto L60
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
                com.baidu.poly.util.d.a(r2, r1)     // Catch: java.lang.Throwable -> L162
                com.baidu.poly.a.a.a r2 = r11.btX     // Catch: java.lang.Throwable -> L162
                if (r2 == 0) goto L56
                com.baidu.poly.a.a.f r2 = com.baidu.poly.a.a.f.this     // Catch: java.lang.Throwable -> L162
                android.os.Handler r2 = com.baidu.poly.a.a.f.a(r2)     // Catch: java.lang.Throwable -> L162
                com.baidu.poly.a.a.f$a$c r4 = new com.baidu.poly.a.a.f$a$c     // Catch: java.lang.Throwable -> L162
                r4.<init>(r1)     // Catch: java.lang.Throwable -> L162
                r2.post(r4)     // Catch: java.lang.Throwable -> L162
            L56:
                java.io.Closeable[] r1 = new java.io.Closeable[r9]
                r1[r8] = r3
                r1[r7] = r0
                com.baidu.poly.util.c.a(r1)
            L5f:
                return
            L60:
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
                com.baidu.poly.a.a.b r1 = r11.btW     // Catch: java.lang.Throwable -> L3b
                java.util.Map r1 = r1.MK()     // Catch: java.lang.Throwable -> L3b
                java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L3b
                java.util.Iterator r5 = r1.iterator()     // Catch: java.lang.Throwable -> L3b
            L8f:
                boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L3b
                if (r1 == 0) goto Lcd
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
                goto L8f
            Lc1:
                r0 = move-exception
                r1 = r3
            Lc3:
                java.io.Closeable[] r2 = new java.io.Closeable[r9]
                r2[r8] = r3
                r2[r7] = r1
                com.baidu.poly.util.c.a(r2)
                throw r0
            Lcd:
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
                r1.write(r2)     // Catch: java.lang.Throwable -> L159
                r1.flush()     // Catch: java.lang.Throwable -> L159
                int r2 = r0.getResponseCode()     // Catch: java.lang.Throwable -> L159
                r4 = 200(0xc8, float:2.8E-43)
                if (r2 < r4) goto L133
                r4 = 299(0x12b, float:4.19E-43)
                if (r2 > r4) goto L133
                java.io.InputStream r0 = r0.getInputStream()     // Catch: java.lang.Throwable -> L12d
                java.lang.String r2 = com.baidu.poly.util.c.a(r0)     // Catch: java.lang.Throwable -> L127
                com.baidu.poly.a.a.a r3 = r11.btX     // Catch: java.lang.Throwable -> L127
                if (r3 == 0) goto L118
                com.baidu.poly.a.a.f r3 = com.baidu.poly.a.a.f.this     // Catch: java.lang.Throwable -> L127
                android.os.Handler r3 = com.baidu.poly.a.a.f.a(r3)     // Catch: java.lang.Throwable -> L127
                com.baidu.poly.a.a.f$a$a r4 = new com.baidu.poly.a.a.f$a$a     // Catch: java.lang.Throwable -> L127
                r4.<init>(r2)     // Catch: java.lang.Throwable -> L127
                r3.post(r4)     // Catch: java.lang.Throwable -> L127
            L118:
                java.io.Closeable[] r2 = new java.io.Closeable[r9]
                r2[r8] = r0
                r2[r7] = r1
                com.baidu.poly.util.c.a(r2)
                goto L5f
            L123:
                r2 = move-exception
                r3 = r0
                r0 = r2
                goto Lc3
            L127:
                r2 = move-exception
                r3 = r0
                r0 = r1
                r1 = r2
                goto L3e
            L12d:
                r0 = move-exception
                r10 = r1
                r1 = r0
                r0 = r10
                goto L3e
            L133:
                java.io.InputStream r0 = r0.getErrorStream()     // Catch: java.lang.Throwable -> L159
                java.lang.String r3 = com.baidu.poly.util.c.a(r0)     // Catch: java.lang.Throwable -> L14e
                com.baidu.poly.a.a.a r4 = r11.btX     // Catch: java.lang.Throwable -> L14e
                if (r4 == 0) goto L118
                com.baidu.poly.a.a.f r4 = com.baidu.poly.a.a.f.this     // Catch: java.lang.Throwable -> L14e
                android.os.Handler r4 = com.baidu.poly.a.a.f.a(r4)     // Catch: java.lang.Throwable -> L14e
                com.baidu.poly.a.a.f$a$b r5 = new com.baidu.poly.a.a.f$a$b     // Catch: java.lang.Throwable -> L14e
                r5.<init>(r2, r3)     // Catch: java.lang.Throwable -> L14e
                r4.post(r5)     // Catch: java.lang.Throwable -> L14e
                goto L118
            L14e:
                r2 = move-exception
                r3 = r0
                r0 = r1
                r1 = r2
                goto L3e
            L154:
                r2 = move-exception
                r3 = r0
                r0 = r2
                goto Lc3
            L159:
                r0 = move-exception
                r10 = r1
                r1 = r0
                r0 = r10
                goto L3e
            L15f:
                r0 = move-exception
                goto Lc3
            L162:
                r1 = move-exception
                r10 = r1
                r1 = r0
                r0 = r10
                goto Lc3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.poly.a.a.f.a.run():void");
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.poly.a.a.f.a.run():void] */
    static /* synthetic */ Handler a(f fVar) {
        return fVar.btZ;
    }

    @Override // com.baidu.poly.a.a.e
    public void a(String str, c cVar, b bVar, com.baidu.poly.a.a.a<String> aVar) {
        com.baidu.poly.b.b.g(new a(str, cVar, bVar, aVar));
    }
}
