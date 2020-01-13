package com.baidu.poly.a.g;
/* loaded from: classes10.dex */
public class b {
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public void a(com.baidu.poly.a.a.c r10, com.baidu.poly.a.a.b r11) {
        /*
            r9 = this;
            r8 = 0
            r7 = 1
            r3 = 0
            java.net.URL r0 = new java.net.URL     // Catch: java.lang.Throwable -> L39
            java.lang.String r1 = "https://etrade.baidu.com/sgw/common/pingd/trace"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L39
            java.net.URLConnection r0 = r0.openConnection()     // Catch: java.lang.Throwable -> L39
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch: java.lang.Throwable -> L39
            java.util.Map r1 = r10.Cb()     // Catch: java.lang.Throwable -> L39
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L39
            java.util.Iterator r4 = r1.iterator()     // Catch: java.lang.Throwable -> L39
        L1d:
            boolean r1 = r4.hasNext()     // Catch: java.lang.Throwable -> L39
            if (r1 == 0) goto L43
            java.lang.Object r1 = r4.next()     // Catch: java.lang.Throwable -> L39
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L39
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Throwable -> L39
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L39
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L39
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L39
            r0.setRequestProperty(r2, r1)     // Catch: java.lang.Throwable -> L39
            goto L1d
        L39:
            r0 = move-exception
            r1 = r3
        L3b:
            java.io.Closeable[] r0 = new java.io.Closeable[r7]
            r0[r8] = r1
            com.baidu.poly.util.b.a(r0)
        L42:
            return
        L43:
            r1 = 1
            r0.setDoInput(r1)     // Catch: java.lang.Throwable -> L39
            r1 = 1
            r0.setDoOutput(r1)     // Catch: java.lang.Throwable -> L39
            java.lang.String r1 = "POST"
            r0.setRequestMethod(r1)     // Catch: java.lang.Throwable -> L39
            r1 = 0
            r0.setUseCaches(r1)     // Catch: java.lang.Throwable -> L39
            r1 = 5000(0x1388, float:7.006E-42)
            r0.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L39
            r1 = 5000(0x1388, float:7.006E-42)
            r0.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L39
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L39
            r4.<init>()     // Catch: java.lang.Throwable -> L39
            java.util.Map r1 = r11.Cb()     // Catch: java.lang.Throwable -> L39
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L39
            java.util.Iterator r5 = r1.iterator()     // Catch: java.lang.Throwable -> L39
        L70:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L39
            if (r1 == 0) goto Laf
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L39
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L39
            java.lang.Object r2 = r1.getValue()     // Catch: java.lang.Throwable -> L39
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L39
            java.lang.String r6 = "utf-8"
            java.lang.String r2 = java.net.URLEncoder.encode(r2, r6)     // Catch: java.lang.Throwable -> L39
            java.lang.Object r1 = r1.getKey()     // Catch: java.lang.Throwable -> L39
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L39
            java.lang.StringBuilder r1 = r4.append(r1)     // Catch: java.lang.Throwable -> L39
            java.lang.String r6 = "="
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch: java.lang.Throwable -> L39
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L39
            java.lang.String r2 = "&"
            r1.append(r2)     // Catch: java.lang.Throwable -> L39
            goto L70
        La5:
            r0 = move-exception
            r1 = r3
        La7:
            java.io.Closeable[] r2 = new java.io.Closeable[r7]
            r2[r8] = r1
            com.baidu.poly.util.b.a(r2)
            throw r0
        Laf:
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L39
            byte[] r2 = r1.getBytes()     // Catch: java.lang.Throwable -> L39
            java.lang.String r1 = "Content-Length"
            int r4 = r2.length     // Catch: java.lang.Throwable -> L39
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L39
            r0.setRequestProperty(r1, r4)     // Catch: java.lang.Throwable -> L39
            r0.connect()     // Catch: java.lang.Throwable -> L39
            java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch: java.lang.Throwable -> L39
            java.io.OutputStream r4 = r0.getOutputStream()     // Catch: java.lang.Throwable -> L39
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L39
            r1.write(r2)     // Catch: java.lang.Throwable -> Le0
            r1.flush()     // Catch: java.lang.Throwable -> Le0
            r0.getResponseCode()     // Catch: java.lang.Throwable -> Le0
            java.io.Closeable[] r0 = new java.io.Closeable[r7]
            r0[r8] = r1
            com.baidu.poly.util.b.a(r0)
            goto L42
        Le0:
            r0 = move-exception
            goto L3b
        Le3:
            r0 = move-exception
            goto La7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.poly.a.g.b.a(com.baidu.poly.a.a.c, com.baidu.poly.a.a.b):void");
    }
}
