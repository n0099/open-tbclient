package com.baidu.poly.a;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class e implements d {
    private Handler uiHandler = new Handler(Looper.getMainLooper());

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.poly.a.e.1.run():void] */
    static /* synthetic */ Handler a(e eVar) {
        return eVar.uiHandler;
    }

    @Override // com.baidu.poly.a.d
    public void a(final String str, final b bVar, final a<String> aVar) {
        com.baidu.poly.util.b.j("================ GET ==================");
        com.baidu.poly.util.b.j("url:", str);
        com.baidu.poly.util.b.j("headers:", bVar.toString());
        com.baidu.poly.c.a.c(new Runnable() { // from class: com.baidu.poly.a.e.1
            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
                	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
                	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
                */
            @Override // java.lang.Runnable
            public void run() {
                /*
                    r9 = this;
                    r7 = 1
                    r6 = 0
                    r3 = 0
                    java.net.URL r0 = new java.net.URL     // Catch: java.lang.Throwable -> L3a
                    java.lang.String r1 = r2     // Catch: java.lang.Throwable -> L3a
                    r0.<init>(r1)     // Catch: java.lang.Throwable -> L3a
                    java.net.URLConnection r0 = r0.openConnection()     // Catch: java.lang.Throwable -> L3a
                    java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch: java.lang.Throwable -> L3a
                    com.baidu.poly.a.b r1 = r3     // Catch: java.lang.Throwable -> L3a
                    java.util.Map r1 = r1.zE()     // Catch: java.lang.Throwable -> L3a
                    java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L3a
                    java.util.Iterator r4 = r1.iterator()     // Catch: java.lang.Throwable -> L3a
                L1e:
                    boolean r1 = r4.hasNext()     // Catch: java.lang.Throwable -> L3a
                    if (r1 == 0) goto L5c
                    java.lang.Object r1 = r4.next()     // Catch: java.lang.Throwable -> L3a
                    java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L3a
                    java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Throwable -> L3a
                    java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L3a
                    java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L3a
                    java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L3a
                    r0.setRequestProperty(r2, r1)     // Catch: java.lang.Throwable -> L3a
                    goto L1e
                L3a:
                    r0 = move-exception
                    r1 = r3
                L3c:
                    com.baidu.poly.a.a r2 = r4     // Catch: java.lang.Throwable -> Lc9
                    if (r2 == 0) goto L54
                    java.lang.String r2 = "GET FAILED"
                    com.baidu.poly.util.b.g(r2, r0)     // Catch: java.lang.Throwable -> Lc9
                    com.baidu.poly.a.e r2 = com.baidu.poly.a.e.this     // Catch: java.lang.Throwable -> Lc9
                    android.os.Handler r2 = com.baidu.poly.a.e.a(r2)     // Catch: java.lang.Throwable -> Lc9
                    com.baidu.poly.a.e$1$3 r3 = new com.baidu.poly.a.e$1$3     // Catch: java.lang.Throwable -> Lc9
                    r3.<init>()     // Catch: java.lang.Throwable -> Lc9
                    r2.post(r3)     // Catch: java.lang.Throwable -> Lc9
                L54:
                    java.io.Closeable[] r0 = new java.io.Closeable[r7]
                    r0[r6] = r1
                    com.baidu.poly.util.a.b(r0)
                L5b:
                    return
                L5c:
                    r0.connect()     // Catch: java.lang.Throwable -> L3a
                    int r1 = r0.getResponseCode()     // Catch: java.lang.Throwable -> L3a
                    r2 = 200(0xc8, float:2.8E-43)
                    if (r1 < r2) goto L8d
                    r2 = 299(0x12b, float:4.19E-43)
                    if (r1 > r2) goto L8d
                    java.io.InputStream r0 = r0.getInputStream()     // Catch: java.lang.Throwable -> L3a
                    java.lang.String r1 = com.baidu.poly.util.a.h(r0)     // Catch: java.lang.Throwable -> Lb7
                    com.baidu.poly.a.a r2 = r4     // Catch: java.lang.Throwable -> Lb7
                    if (r2 == 0) goto L85
                    com.baidu.poly.a.e r2 = com.baidu.poly.a.e.this     // Catch: java.lang.Throwable -> Lb7
                    android.os.Handler r2 = com.baidu.poly.a.e.a(r2)     // Catch: java.lang.Throwable -> Lb7
                    com.baidu.poly.a.e$1$1 r3 = new com.baidu.poly.a.e$1$1     // Catch: java.lang.Throwable -> Lb7
                    r3.<init>()     // Catch: java.lang.Throwable -> Lb7
                    r2.post(r3)     // Catch: java.lang.Throwable -> Lb7
                L85:
                    java.io.Closeable[] r1 = new java.io.Closeable[r7]
                    r1[r6] = r0
                    com.baidu.poly.util.a.b(r1)
                    goto L5b
                L8d:
                    java.io.InputStream r0 = r0.getErrorStream()     // Catch: java.lang.Throwable -> L3a
                    java.lang.String r2 = com.baidu.poly.util.a.h(r0)     // Catch: java.lang.Throwable -> Lb7
                    r3 = 2
                    java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Lb7
                    r4 = 0
                    java.lang.String r5 = "response:"
                    r3[r4] = r5     // Catch: java.lang.Throwable -> Lb7
                    r4 = 1
                    r3[r4] = r2     // Catch: java.lang.Throwable -> Lb7
                    com.baidu.poly.util.b.j(r3)     // Catch: java.lang.Throwable -> Lb7
                    com.baidu.poly.a.a r3 = r4     // Catch: java.lang.Throwable -> Lb7
                    if (r3 == 0) goto L85
                    com.baidu.poly.a.e r3 = com.baidu.poly.a.e.this     // Catch: java.lang.Throwable -> Lb7
                    android.os.Handler r3 = com.baidu.poly.a.e.a(r3)     // Catch: java.lang.Throwable -> Lb7
                    com.baidu.poly.a.e$1$2 r4 = new com.baidu.poly.a.e$1$2     // Catch: java.lang.Throwable -> Lb7
                    r4.<init>()     // Catch: java.lang.Throwable -> Lb7
                    r3.post(r4)     // Catch: java.lang.Throwable -> Lb7
                    goto L85
                Lb7:
                    r1 = move-exception
                    r8 = r1
                    r1 = r0
                    r0 = r8
                    goto L3c
                Lbc:
                    r0 = move-exception
                Lbd:
                    java.io.Closeable[] r1 = new java.io.Closeable[r7]
                    r1[r6] = r3
                    com.baidu.poly.util.a.b(r1)
                    throw r0
                Lc5:
                    r1 = move-exception
                    r3 = r0
                    r0 = r1
                    goto Lbd
                Lc9:
                    r0 = move-exception
                    r3 = r1
                    goto Lbd
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.poly.a.e.AnonymousClass1.run():void");
            }
        });
    }
}
