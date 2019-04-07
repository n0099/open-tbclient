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
        com.baidu.poly.c.a.e(new Runnable() { // from class: com.baidu.poly.a.e.1
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
                    r8 = this;
                    r6 = 1
                    r5 = 0
                    r3 = 0
                    java.net.URL r0 = new java.net.URL     // Catch: java.lang.Throwable -> L3a
                    java.lang.String r1 = r2     // Catch: java.lang.Throwable -> L3a
                    r0.<init>(r1)     // Catch: java.lang.Throwable -> L3a
                    java.net.URLConnection r0 = r0.openConnection()     // Catch: java.lang.Throwable -> L3a
                    java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch: java.lang.Throwable -> L3a
                    com.baidu.poly.a.b r1 = r3     // Catch: java.lang.Throwable -> L3a
                    java.util.Map r1 = r1.tu()     // Catch: java.lang.Throwable -> L3a
                    java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L3a
                    java.util.Iterator r4 = r1.iterator()     // Catch: java.lang.Throwable -> L3a
                L1e:
                    boolean r1 = r4.hasNext()     // Catch: java.lang.Throwable -> L3a
                    if (r1 == 0) goto L56
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
                    com.baidu.poly.a.a r2 = r4     // Catch: java.lang.Throwable -> Lb4
                    if (r2 == 0) goto L4e
                    com.baidu.poly.a.e r2 = com.baidu.poly.a.e.this     // Catch: java.lang.Throwable -> Lb4
                    android.os.Handler r2 = com.baidu.poly.a.e.a(r2)     // Catch: java.lang.Throwable -> Lb4
                    com.baidu.poly.a.e$1$3 r3 = new com.baidu.poly.a.e$1$3     // Catch: java.lang.Throwable -> Lb4
                    r3.<init>()     // Catch: java.lang.Throwable -> Lb4
                    r2.post(r3)     // Catch: java.lang.Throwable -> Lb4
                L4e:
                    java.io.Closeable[] r0 = new java.io.Closeable[r6]
                    r0[r5] = r1
                    com.baidu.poly.util.a.b(r0)
                L55:
                    return
                L56:
                    r0.connect()     // Catch: java.lang.Throwable -> L3a
                    int r1 = r0.getResponseCode()     // Catch: java.lang.Throwable -> L3a
                    r2 = 200(0xc8, float:2.8E-43)
                    if (r1 < r2) goto L87
                    r2 = 299(0x12b, float:4.19E-43)
                    if (r1 > r2) goto L87
                    java.io.InputStream r0 = r0.getInputStream()     // Catch: java.lang.Throwable -> L3a
                    java.lang.String r1 = com.baidu.poly.util.a.l(r0)     // Catch: java.lang.Throwable -> La2
                    com.baidu.poly.a.a r2 = r4     // Catch: java.lang.Throwable -> La2
                    if (r2 == 0) goto L7f
                    com.baidu.poly.a.e r2 = com.baidu.poly.a.e.this     // Catch: java.lang.Throwable -> La2
                    android.os.Handler r2 = com.baidu.poly.a.e.a(r2)     // Catch: java.lang.Throwable -> La2
                    com.baidu.poly.a.e$1$1 r3 = new com.baidu.poly.a.e$1$1     // Catch: java.lang.Throwable -> La2
                    r3.<init>()     // Catch: java.lang.Throwable -> La2
                    r2.post(r3)     // Catch: java.lang.Throwable -> La2
                L7f:
                    java.io.Closeable[] r1 = new java.io.Closeable[r6]
                    r1[r5] = r0
                    com.baidu.poly.util.a.b(r1)
                    goto L55
                L87:
                    java.io.InputStream r0 = r0.getErrorStream()     // Catch: java.lang.Throwable -> L3a
                    java.lang.String r2 = com.baidu.poly.util.a.l(r0)     // Catch: java.lang.Throwable -> La2
                    com.baidu.poly.a.a r3 = r4     // Catch: java.lang.Throwable -> La2
                    if (r3 == 0) goto L7f
                    com.baidu.poly.a.e r3 = com.baidu.poly.a.e.this     // Catch: java.lang.Throwable -> La2
                    android.os.Handler r3 = com.baidu.poly.a.e.a(r3)     // Catch: java.lang.Throwable -> La2
                    com.baidu.poly.a.e$1$2 r4 = new com.baidu.poly.a.e$1$2     // Catch: java.lang.Throwable -> La2
                    r4.<init>()     // Catch: java.lang.Throwable -> La2
                    r3.post(r4)     // Catch: java.lang.Throwable -> La2
                    goto L7f
                La2:
                    r1 = move-exception
                    r7 = r1
                    r1 = r0
                    r0 = r7
                    goto L3c
                La7:
                    r0 = move-exception
                La8:
                    java.io.Closeable[] r1 = new java.io.Closeable[r6]
                    r1[r5] = r3
                    com.baidu.poly.util.a.b(r1)
                    throw r0
                Lb0:
                    r1 = move-exception
                    r3 = r0
                    r0 = r1
                    goto La8
                Lb4:
                    r0 = move-exception
                    r3 = r1
                    goto La8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.poly.a.e.AnonymousClass1.run():void");
            }
        });
    }
}
