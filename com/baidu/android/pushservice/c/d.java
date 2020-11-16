package com.baidu.android.pushservice.c;
/* loaded from: classes7.dex */
public class d {
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static int a(android.content.Context r8, java.lang.String r9) {
        /*
            r6 = 0
            r7 = 0
            r0 = 0
            int r6 = com.baidu.android.pushservice.i.m.p(r8, r9)     // Catch: java.lang.Throwable -> Lce
            if (r6 <= 0) goto L10
            if (r7 == 0) goto Le
            r0.close()     // Catch: java.lang.Exception -> Le2
        Le:
            r0 = r6
        Lf:
            return r0
        L10:
            android.content.ContentResolver r0 = r8.getContentResolver()     // Catch: java.lang.Throwable -> Lce
            if (r0 == 0) goto Lf7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lce
            r1.<init>()     // Catch: java.lang.Throwable -> Lce
            java.lang.String r2 = "content://"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lce
            java.lang.StringBuilder r1 = r1.append(r9)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r2 = ".bdpush"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r2 = "pushinfo_v3"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lce
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> Lce
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> Lce
            r3 = 0
            com.baidu.android.pushservice.c.c$e r4 = com.baidu.android.pushservice.c.c.e.PushVersion     // Catch: java.lang.Throwable -> Lce
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> Lce
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lce
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lce
            if (r7 == 0) goto L75
            boolean r0 = r7.moveToFirst()     // Catch: java.lang.Throwable -> Leb
            if (r0 == 0) goto Lf7
            com.baidu.android.pushservice.c.c$e r0 = com.baidu.android.pushservice.c.c.e.PushVersion     // Catch: java.lang.Throwable -> Leb
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> Leb
            int r0 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Leb
            int r6 = r7.getInt(r0)     // Catch: java.lang.Throwable -> Leb
            r0 = r6
        L6d:
            if (r7 == 0) goto Lf
            r7.close()     // Catch: java.lang.Exception -> L73
            goto Lf
        L73:
            r1 = move-exception
            goto Lf
        L75:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Leb
            r1.<init>()     // Catch: java.lang.Throwable -> Leb
            java.lang.String r2 = "content://"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Leb
            java.lang.StringBuilder r1 = r1.append(r9)     // Catch: java.lang.Throwable -> Leb
            java.lang.String r2 = ".bdpush"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Leb
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Leb
            java.lang.String r2 = "pushinfo"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Leb
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Leb
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> Leb
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> Leb
            r3 = 0
            com.baidu.android.pushservice.c.c$e r4 = com.baidu.android.pushservice.c.c.e.PushVersion     // Catch: java.lang.Throwable -> Leb
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> Leb
            r2[r3] = r4     // Catch: java.lang.Throwable -> Leb
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Leb
            if (r0 == 0) goto Lf3
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> Lef
            if (r1 == 0) goto Lf3
            com.baidu.android.pushservice.c.c$e r1 = com.baidu.android.pushservice.c.c.e.PushVersion     // Catch: java.lang.Throwable -> Lef
            java.lang.String r1 = r1.name()     // Catch: java.lang.Throwable -> Lef
            int r1 = r0.getColumnIndex(r1)     // Catch: java.lang.Throwable -> Lef
            int r6 = r0.getInt(r1)     // Catch: java.lang.Throwable -> Lef
            r7 = r0
            r0 = r6
            goto L6d
        Lce:
            r0 = move-exception
            r0 = r6
            r1 = r7
        Ld1:
            if (r1 == 0) goto Lf
            r1.close()     // Catch: java.lang.Exception -> Ld8
            goto Lf
        Ld8:
            r1 = move-exception
            goto Lf
        Ldb:
            r0 = move-exception
        Ldc:
            if (r7 == 0) goto Le1
            r7.close()     // Catch: java.lang.Exception -> Le5
        Le1:
            throw r0
        Le2:
            r0 = move-exception
            goto Le
        Le5:
            r1 = move-exception
            goto Le1
        Le7:
            r1 = move-exception
            r7 = r0
            r0 = r1
            goto Ldc
        Leb:
            r0 = move-exception
            r0 = r6
            r1 = r7
            goto Ld1
        Lef:
            r1 = move-exception
            r1 = r0
            r0 = r6
            goto Ld1
        Lf3:
            r7 = r0
            r0 = r6
            goto L6d
        Lf7:
            r0 = r6
            goto L6d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.c.d.a(android.content.Context, java.lang.String):int");
    }
}
