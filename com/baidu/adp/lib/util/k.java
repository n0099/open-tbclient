package com.baidu.adp.lib.util;
/* loaded from: classes.dex */
public class k {
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [64=4] */
    public static java.util.List<com.baidu.adp.lib.cache.t<java.lang.String>> a(com.baidu.adp.lib.cache.s<java.lang.String> r6) {
        /*
            r2 = 0
            java.util.LinkedList r1 = new java.util.LinkedList
            r1.<init>()
            if (r6 != 0) goto L10
            r3 = r2
        L9:
            if (r3 != 0) goto L75
            com.baidu.adp.lib.f.a.a(r3)
            r0 = r2
        Lf:
            return r0
        L10:
            boolean r0 = r6 instanceof com.baidu.adp.lib.cache.u     // Catch: java.lang.Throwable -> Laa
            if (r0 != 0) goto L16
            r3 = r2
            goto L9
        L16:
            com.baidu.adp.lib.cache.u r6 = (com.baidu.adp.lib.cache.u) r6     // Catch: java.lang.Throwable -> Laa
            com.baidu.adp.lib.cache.r r0 = r6.b()     // Catch: java.lang.Throwable -> Laa
            boolean r0 = r0 instanceof com.baidu.adp.lib.cache.o     // Catch: java.lang.Throwable -> Laa
            if (r0 != 0) goto L22
            r3 = r2
            goto L9
        L22:
            com.baidu.adp.lib.cache.r r0 = r6.b()     // Catch: java.lang.Throwable -> Laa
            com.baidu.adp.lib.cache.o r0 = (com.baidu.adp.lib.cache.o) r0     // Catch: java.lang.Throwable -> Laa
            com.baidu.adp.lib.cache.c r0 = r0.b()     // Catch: java.lang.Throwable -> Laa
            com.baidu.adp.a.i r3 = r0.b()     // Catch: java.lang.Throwable -> Laa
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> Laa
            java.lang.String r4 = r6.a()     // Catch: java.lang.Throwable -> Laa
            android.database.Cursor r3 = r0.b(r3, r4)     // Catch: java.lang.Throwable -> Laa
            goto L9
        L3d:
            com.baidu.adp.lib.cache.t r0 = new com.baidu.adp.lib.cache.t     // Catch: java.lang.Throwable -> L89
            r0.<init>()     // Catch: java.lang.Throwable -> L89
            java.lang.String r2 = "m_key"
            int r2 = r3.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L89
            java.lang.String r2 = r3.getString(r2)     // Catch: java.lang.Throwable -> L89
            r0.a = r2     // Catch: java.lang.Throwable -> L89
            java.lang.String r2 = "saveTime"
            int r2 = r3.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L89
            long r4 = r3.getLong(r2)     // Catch: java.lang.Throwable -> L89
            r0.c = r4     // Catch: java.lang.Throwable -> L89
            java.lang.String r2 = "timeToExpire"
            int r2 = r3.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L89
            long r4 = r3.getLong(r2)     // Catch: java.lang.Throwable -> L89
            r0.d = r4     // Catch: java.lang.Throwable -> L89
            java.lang.String r2 = "m_value"
            int r2 = r3.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L89
            java.lang.String r2 = r3.getString(r2)     // Catch: java.lang.Throwable -> L89
            r0.b = r2     // Catch: java.lang.Throwable -> L89
            r1.add(r0)     // Catch: java.lang.Throwable -> L89
        L75:
            boolean r0 = r3.moveToNext()     // Catch: java.lang.Throwable -> L92
            if (r0 != 0) goto L3d
            com.baidu.adp.lib.f.a.a(r3)
        L7e:
            com.baidu.adp.lib.util.l r0 = new com.baidu.adp.lib.util.l
            r2 = 0
            r0.<init>(r2)
            java.util.Collections.sort(r1, r0)
            r0 = r1
            goto Lf
        L89:
            r0 = move-exception
            java.lang.Class<com.baidu.adp.lib.util.k> r2 = com.baidu.adp.lib.util.k.class
            java.lang.String r4 = "listAllTextItemsInDBCache"
            com.baidu.adp.lib.util.f.a(r2, r4, r0)     // Catch: java.lang.Throwable -> L92
            goto L75
        L92:
            r0 = move-exception
            r2 = r3
        L94:
            java.lang.Class<com.baidu.adp.lib.util.k> r3 = com.baidu.adp.lib.util.k.class
            java.lang.String r4 = "listAllTextItemsInDBCache"
            com.baidu.adp.lib.util.f.a(r3, r4, r0)     // Catch: java.lang.Throwable -> La7
            com.baidu.adp.lib.f.a.a(r2)
            goto L7e
        L9f:
            r0 = move-exception
            r3 = r2
        La1:
            com.baidu.adp.lib.f.a.a(r3)
            throw r0
        La5:
            r0 = move-exception
            goto La1
        La7:
            r0 = move-exception
            r3 = r2
            goto La1
        Laa:
            r0 = move-exception
            goto L94
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.adp.lib.util.k.a(com.baidu.adp.lib.cache.s):java.util.List");
    }
}
