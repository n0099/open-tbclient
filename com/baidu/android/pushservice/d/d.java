package com.baidu.android.pushservice.d;
/* loaded from: classes2.dex */
public class d {
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String a(android.content.Context r7, java.lang.String r8) {
        /*
            r6 = 0
            int r0 = com.baidu.android.pushservice.j.p.m(r7, r8)     // Catch: java.lang.Throwable -> L81
            r1 = 52
            if (r0 < r1) goto La2
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto La2
            boolean r1 = com.baidu.android.pushservice.j.p.z(r7, r8)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L7d
            java.lang.String r1 = "pushinfo_v3"
        L18:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            r2.<init>()     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = "content://"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = ".bdpush"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> L81
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L81
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L81
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto La0
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto La0
            com.baidu.android.pushservice.d.c$e r0 = com.baidu.android.pushservice.d.c.e.PushChannelID     // Catch: java.lang.Throwable -> L99
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> L99
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L99
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9d
            r2.<init>()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r3 = "pushchannelid  is "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L9d
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Throwable -> L9d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L9d
            com.baidu.android.pushservice.j.p.b(r2, r7)     // Catch: java.lang.Throwable -> L9d
        L77:
            if (r1 == 0) goto L7c
            r1.close()     // Catch: java.lang.Exception -> L92
        L7c:
            return r0
        L7d:
            java.lang.String r1 = "pushinfo"
            goto L18
        L81:
            r0 = move-exception
            r0 = r6
        L83:
            if (r6 == 0) goto L7c
            r6.close()     // Catch: java.lang.Exception -> L89
            goto L7c
        L89:
            r1 = move-exception
            goto L7c
        L8b:
            r0 = move-exception
        L8c:
            if (r6 == 0) goto L91
            r6.close()     // Catch: java.lang.Exception -> L94
        L91:
            throw r0
        L92:
            r1 = move-exception
            goto L7c
        L94:
            r1 = move-exception
            goto L91
        L96:
            r0 = move-exception
            r6 = r1
            goto L8c
        L99:
            r0 = move-exception
            r0 = r6
            r6 = r1
            goto L83
        L9d:
            r2 = move-exception
            r6 = r1
            goto L83
        La0:
            r0 = r6
            goto L77
        La2:
            r0 = r6
            r1 = r6
            goto L77
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.d.a(android.content.Context, java.lang.String):java.lang.String");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static void a(android.content.Context r15) {
        /*
            r6 = 0
            r14 = 2
            r7 = 0
            java.lang.String r8 = com.baidu.android.pushservice.PushSettings.b(r15)
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto Le
        Ld:
            return
        Le:
            java.lang.String r1 = com.baidu.android.pushservice.j.p.u(r15)     // Catch: java.lang.Throwable -> L181
            int r0 = com.baidu.android.pushservice.j.p.m(r15, r1)     // Catch: java.lang.Throwable -> L181
            short r2 = com.baidu.android.pushservice.a.a()     // Catch: java.lang.Throwable -> L181
            if (r0 < r2) goto L176
            android.content.ContentResolver r0 = r15.getContentResolver()     // Catch: java.lang.Throwable -> L181
            if (r0 == 0) goto L176
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L181
            r2.<init>()     // Catch: java.lang.Throwable -> L181
            java.lang.String r3 = "content://"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L181
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> L181
            java.lang.String r2 = ".bdpush"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L181
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L181
            java.lang.String r2 = "msgInfo"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L181
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L181
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L181
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L181
            r2.<init>()     // Catch: java.lang.Throwable -> L181
            com.baidu.android.pushservice.d.c$d r3 = com.baidu.android.pushservice.d.c.d.appId     // Catch: java.lang.Throwable -> L181
            java.lang.String r3 = r3.name()     // Catch: java.lang.Throwable -> L181
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L181
            java.lang.String r3 = " =? AND "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L181
            com.baidu.android.pushservice.d.c$d r3 = com.baidu.android.pushservice.d.c.d.expireTime     // Catch: java.lang.Throwable -> L181
            java.lang.String r3 = r3.name()     // Catch: java.lang.Throwable -> L181
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L181
            java.lang.String r3 = " <? AND "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L181
            com.baidu.android.pushservice.d.c$d r3 = com.baidu.android.pushservice.d.c.d.arriveTime     // Catch: java.lang.Throwable -> L181
            java.lang.String r3 = r3.name()     // Catch: java.lang.Throwable -> L181
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L181
            java.lang.String r3 = " >? "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L181
            java.lang.String r3 = r2.toString()     // Catch: java.lang.Throwable -> L181
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L181
            r2.<init>()     // Catch: java.lang.Throwable -> L181
            com.baidu.android.pushservice.d.c$d r4 = com.baidu.android.pushservice.d.c.d.expireTime     // Catch: java.lang.Throwable -> L181
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L181
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> L181
            java.lang.String r4 = " DESC LIMIT "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> L181
            r4 = 7
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> L181
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L181
            r2 = 0
            r4 = 3
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L181
            r9 = 0
            r4[r9] = r8     // Catch: java.lang.Throwable -> L181
            r9 = 1
            long r10 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L181
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L181
            r4[r9] = r10     // Catch: java.lang.Throwable -> L181
            r9 = 2
            long r10 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L181
            r12 = 86400000(0x5265c00, double:4.2687272E-316)
            long r10 = r10 - r12
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L181
            r4[r9] = r10     // Catch: java.lang.Throwable -> L181
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L181
            if (r0 == 0) goto L177
            r1 = r7
        Ld2:
            boolean r2 = r0.moveToNext()     // Catch: java.lang.Throwable -> L19a
            if (r2 == 0) goto L177
            com.baidu.android.pushservice.d.c$d r2 = com.baidu.android.pushservice.d.c.d.msgId     // Catch: java.lang.Throwable -> L19a
            java.lang.String r2 = r2.name()     // Catch: java.lang.Throwable -> L19a
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L19a
            long r2 = r0.getLong(r2)     // Catch: java.lang.Throwable -> L19a
            java.lang.String r4 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L19a
            boolean r4 = com.baidu.android.pushservice.j.p.s(r15, r4)     // Catch: java.lang.Throwable -> L19a
            if (r4 != 0) goto Ld2
            com.baidu.android.pushservice.d.c$d r4 = com.baidu.android.pushservice.d.c.d.msgBody     // Catch: java.lang.Throwable -> L19a
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L19a
            int r4 = r0.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L19a
            byte[] r4 = r0.getBlob(r4)     // Catch: java.lang.Throwable -> L19a
            if (r4 == 0) goto Ld2
            int r5 = r4.length     // Catch: java.lang.Throwable -> L19a
            if (r5 == 0) goto Ld2
            byte[] r4 = com.baidu.android.pushservice.jni.BaiduAppSSOJni.getDecrypted(r15, r8, r4)     // Catch: java.lang.Throwable -> L19a
            com.baidu.android.pushservice.d.c$d r5 = com.baidu.android.pushservice.d.c.d.expireTime     // Catch: java.lang.Throwable -> L19a
            java.lang.String r5 = r5.name()     // Catch: java.lang.Throwable -> L19a
            int r5 = r0.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L19a
            r0.getLong(r5)     // Catch: java.lang.Throwable -> L19a
            com.baidu.android.pushservice.d.c$d r5 = com.baidu.android.pushservice.d.c.d.msgType     // Catch: java.lang.Throwable -> L19a
            java.lang.String r5 = r5.name()     // Catch: java.lang.Throwable -> L19a
            int r5 = r0.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L19a
            int r5 = r0.getInt(r5)     // Catch: java.lang.Throwable -> L19a
            com.baidu.android.pushservice.d.c$d r6 = com.baidu.android.pushservice.d.c.d.secureInfo     // Catch: java.lang.Throwable -> L19a
            java.lang.String r6 = r6.name()     // Catch: java.lang.Throwable -> L19a
            int r6 = r0.getColumnIndex(r6)     // Catch: java.lang.Throwable -> L19a
            byte[] r6 = r0.getBlob(r6)     // Catch: java.lang.Throwable -> L19a
            android.content.Intent r7 = new android.content.Intent     // Catch: java.lang.Throwable -> L19a
            r7.<init>()     // Catch: java.lang.Throwable -> L19a
            java.lang.String r9 = "app_id"
            r7.putExtra(r9, r8)     // Catch: java.lang.Throwable -> L19a
            java.lang.String r9 = "message_id"
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L19a
            r7.putExtra(r9, r2)     // Catch: java.lang.Throwable -> L19a
            java.lang.String r2 = "baidu_message_type"
            r7.putExtra(r2, r5)     // Catch: java.lang.Throwable -> L19a
            java.lang.String r2 = "baidu_message_body"
            r7.putExtra(r2, r4)     // Catch: java.lang.Throwable -> L19a
            java.lang.String r2 = "baidu_message_secur_info"
            r7.putExtra(r2, r6)     // Catch: java.lang.Throwable -> L19a
            java.lang.String r2 = "bdpush_deliver_NO_CALLBACK"
            r3 = 1
            r7.putExtra(r2, r3)     // Catch: java.lang.Throwable -> L19a
            java.lang.String r2 = "com.baidu.android.pushservice.action.MESSAGE"
            java.lang.String r3 = r15.getPackageName()     // Catch: java.lang.Throwable -> L19a
            com.baidu.android.pushservice.j.p.a(r15, r7, r2, r3)     // Catch: java.lang.Throwable -> L19a
            int r1 = r1 + 1
            if (r1 <= r14) goto Ld2
            if (r0 == 0) goto Ld
            r0.close()     // Catch: java.lang.Exception -> L173
            goto Ld
        L173:
            r0 = move-exception
            goto Ld
        L176:
            r0 = r6
        L177:
            if (r0 == 0) goto Ld
            r0.close()     // Catch: java.lang.Exception -> L17e
            goto Ld
        L17e:
            r0 = move-exception
            goto Ld
        L181:
            r0 = move-exception
            r0 = r6
        L183:
            if (r0 == 0) goto Ld
            r0.close()     // Catch: java.lang.Exception -> L18a
            goto Ld
        L18a:
            r0 = move-exception
            goto Ld
        L18d:
            r0 = move-exception
        L18e:
            if (r6 == 0) goto L193
            r6.close()     // Catch: java.lang.Exception -> L194
        L193:
            throw r0
        L194:
            r1 = move-exception
            goto L193
        L196:
            r1 = move-exception
            r6 = r0
            r0 = r1
            goto L18e
        L19a:
            r1 = move-exception
            goto L183
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.d.a(android.content.Context):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String b(android.content.Context r7, java.lang.String r8) {
        /*
            r6 = 0
            int r0 = com.baidu.android.pushservice.j.p.m(r7, r8)     // Catch: java.lang.Throwable -> L81
            r1 = 52
            if (r0 < r1) goto La2
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto La2
            boolean r1 = com.baidu.android.pushservice.j.p.z(r7, r8)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L7d
            java.lang.String r1 = "pushinfo_v3"
        L18:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            r2.<init>()     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = "content://"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = ".bdpush"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> L81
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L81
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L81
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto La0
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto La0
            com.baidu.android.pushservice.d.c$e r0 = com.baidu.android.pushservice.d.c.e.PushCurPkgName     // Catch: java.lang.Throwable -> L99
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> L99
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L99
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9d
            r2.<init>()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r3 = "curPkgname  is "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L9d
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Throwable -> L9d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L9d
            com.baidu.android.pushservice.j.p.b(r2, r7)     // Catch: java.lang.Throwable -> L9d
        L77:
            if (r1 == 0) goto L7c
            r1.close()     // Catch: java.lang.Exception -> L92
        L7c:
            return r0
        L7d:
            java.lang.String r1 = "pushinfo"
            goto L18
        L81:
            r0 = move-exception
            r0 = r6
        L83:
            if (r6 == 0) goto L7c
            r6.close()     // Catch: java.lang.Exception -> L89
            goto L7c
        L89:
            r1 = move-exception
            goto L7c
        L8b:
            r0 = move-exception
        L8c:
            if (r6 == 0) goto L91
            r6.close()     // Catch: java.lang.Exception -> L94
        L91:
            throw r0
        L92:
            r1 = move-exception
            goto L7c
        L94:
            r1 = move-exception
            goto L91
        L96:
            r0 = move-exception
            r6 = r1
            goto L8c
        L99:
            r0 = move-exception
            r0 = r6
            r6 = r1
            goto L83
        L9d:
            r2 = move-exception
            r6 = r1
            goto L83
        La0:
            r0 = r6
            goto L77
        La2:
            r0 = r6
            r1 = r6
            goto L77
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.d.b(android.content.Context, java.lang.String):java.lang.String");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static int c(android.content.Context r8, java.lang.String r9) {
        /*
            r7 = 0
            r6 = 0
            int r0 = com.baidu.android.pushservice.j.p.m(r8, r9)     // Catch: java.lang.Throwable -> L82
            r1 = 52
            if (r0 < r1) goto La2
            android.content.ContentResolver r0 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L82
            if (r0 == 0) goto La2
            boolean r1 = com.baidu.android.pushservice.j.p.z(r8, r9)     // Catch: java.lang.Throwable -> L82
            if (r1 == 0) goto L7e
            java.lang.String r1 = "pushinfo_v3"
        L19:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82
            r2.<init>()     // Catch: java.lang.Throwable -> L82
            java.lang.String r3 = "content://"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L82
            java.lang.StringBuilder r2 = r2.append(r9)     // Catch: java.lang.Throwable -> L82
            java.lang.String r3 = ".bdpush"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L82
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L82
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> L82
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L82
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L82
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L82
            if (r1 == 0) goto La0
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L9b
            if (r0 == 0) goto La0
            com.baidu.android.pushservice.d.c$e r0 = com.baidu.android.pushservice.d.c.e.PushPriority     // Catch: java.lang.Throwable -> L9b
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> L9b
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L9b
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L9b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
            r2.<init>()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r3 = "pushpriority  is "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L9e
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L9e
            com.baidu.android.pushservice.j.p.b(r2, r8)     // Catch: java.lang.Throwable -> L9e
        L78:
            if (r1 == 0) goto L7d
            r1.close()     // Catch: java.lang.Exception -> L94
        L7d:
            return r0
        L7e:
            java.lang.String r1 = "pushinfo"
            goto L19
        L82:
            r0 = move-exception
            r0 = r6
            r1 = r7
        L85:
            if (r1 == 0) goto L7d
            r1.close()     // Catch: java.lang.Exception -> L8b
            goto L7d
        L8b:
            r1 = move-exception
            goto L7d
        L8d:
            r0 = move-exception
        L8e:
            if (r7 == 0) goto L93
            r7.close()     // Catch: java.lang.Exception -> L96
        L93:
            throw r0
        L94:
            r1 = move-exception
            goto L7d
        L96:
            r1 = move-exception
            goto L93
        L98:
            r0 = move-exception
            r7 = r1
            goto L8e
        L9b:
            r0 = move-exception
            r0 = r6
            goto L85
        L9e:
            r2 = move-exception
            goto L85
        La0:
            r0 = r6
            goto L78
        La2:
            r0 = r6
            r1 = r7
            goto L78
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.d.c(android.content.Context, java.lang.String):int");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static int d(android.content.Context r8, java.lang.String r9) {
        /*
            r7 = 0
            r0 = 0
            r6 = 0
            int r6 = com.baidu.android.pushservice.j.p.C(r8, r9)     // Catch: java.lang.Throwable -> Lb8
            if (r6 <= 0) goto L10
            if (r7 == 0) goto Le
            r0.close()     // Catch: java.lang.Exception -> Lcc
        Le:
            r0 = r6
        Lf:
            return r0
        L10:
            android.content.ContentResolver r0 = r8.getContentResolver()     // Catch: java.lang.Throwable -> Lb8
            if (r0 == 0) goto Le0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb8
            r1.<init>()     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r2 = "content://"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lb8
            java.lang.StringBuilder r1 = r1.append(r9)     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r2 = ".bdpush"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r2 = "pushinfo_v3"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lb8
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> Lb8
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lb8
            if (r7 == 0) goto L6a
            boolean r0 = r7.moveToFirst()     // Catch: java.lang.Throwable -> Ld5
            if (r0 == 0) goto Le0
            com.baidu.android.pushservice.d.c$e r0 = com.baidu.android.pushservice.d.c.e.PushVersion     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> Ld5
            int r0 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Ld5
            int r6 = r7.getInt(r0)     // Catch: java.lang.Throwable -> Ld5
            r0 = r6
        L62:
            if (r7 == 0) goto Lf
            r7.close()     // Catch: java.lang.Exception -> L68
            goto Lf
        L68:
            r1 = move-exception
            goto Lf
        L6a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld5
            r1.<init>()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r2 = "content://"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Ld5
            java.lang.StringBuilder r1 = r1.append(r9)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r2 = ".bdpush"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r2 = "pushinfo"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Ld5
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> Ld5
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Ld5
            if (r0 == 0) goto Ldd
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> Ld9
            if (r1 == 0) goto Ldd
            com.baidu.android.pushservice.d.c$e r1 = com.baidu.android.pushservice.d.c.e.PushVersion     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r1 = r1.name()     // Catch: java.lang.Throwable -> Ld9
            int r1 = r0.getColumnIndex(r1)     // Catch: java.lang.Throwable -> Ld9
            int r6 = r0.getInt(r1)     // Catch: java.lang.Throwable -> Ld9
            r7 = r0
            r0 = r6
            goto L62
        Lb8:
            r0 = move-exception
            r0 = r6
            r1 = r7
        Lbb:
            if (r1 == 0) goto Lf
            r1.close()     // Catch: java.lang.Exception -> Lc2
            goto Lf
        Lc2:
            r1 = move-exception
            goto Lf
        Lc5:
            r0 = move-exception
        Lc6:
            if (r7 == 0) goto Lcb
            r7.close()     // Catch: java.lang.Exception -> Lcf
        Lcb:
            throw r0
        Lcc:
            r0 = move-exception
            goto Le
        Lcf:
            r1 = move-exception
            goto Lcb
        Ld1:
            r1 = move-exception
            r7 = r0
            r0 = r1
            goto Lc6
        Ld5:
            r0 = move-exception
            r0 = r6
            r1 = r7
            goto Lbb
        Ld9:
            r1 = move-exception
            r1 = r0
            r0 = r6
            goto Lbb
        Ldd:
            r7 = r0
            r0 = r6
            goto L62
        Le0:
            r0 = r6
            goto L62
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.d.d(android.content.Context, java.lang.String):int");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String e(android.content.Context r7, java.lang.String r8) {
        /*
            r6 = 0
            int r0 = com.baidu.android.pushservice.j.p.m(r7, r8)     // Catch: java.lang.Throwable -> L81
            r1 = 52
            if (r0 < r1) goto La2
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto La2
            boolean r1 = com.baidu.android.pushservice.j.p.z(r7, r8)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L7d
            java.lang.String r1 = "pushinfo_v3"
        L18:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            r2.<init>()     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = "content://"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = ".bdpush"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> L81
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L81
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L81
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto La0
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto La0
            com.baidu.android.pushservice.d.c$e r0 = com.baidu.android.pushservice.d.c.e.PushSDKClientBindInfo     // Catch: java.lang.Throwable -> L99
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> L99
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L99
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9d
            r2.<init>()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r3 = "sdkclientbindinfo  is "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L9d
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Throwable -> L9d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L9d
            com.baidu.android.pushservice.j.p.b(r2, r7)     // Catch: java.lang.Throwable -> L9d
        L77:
            if (r1 == 0) goto L7c
            r1.close()     // Catch: java.lang.Exception -> L92
        L7c:
            return r0
        L7d:
            java.lang.String r1 = "pushinfo"
            goto L18
        L81:
            r0 = move-exception
            r0 = r6
        L83:
            if (r6 == 0) goto L7c
            r6.close()     // Catch: java.lang.Exception -> L89
            goto L7c
        L89:
            r1 = move-exception
            goto L7c
        L8b:
            r0 = move-exception
        L8c:
            if (r6 == 0) goto L91
            r6.close()     // Catch: java.lang.Exception -> L94
        L91:
            throw r0
        L92:
            r1 = move-exception
            goto L7c
        L94:
            r1 = move-exception
            goto L91
        L96:
            r0 = move-exception
            r6 = r1
            goto L8c
        L99:
            r0 = move-exception
            r0 = r6
            r6 = r1
            goto L83
        L9d:
            r2 = move-exception
            r6 = r1
            goto L83
        La0:
            r0 = r6
            goto L77
        La2:
            r0 = r6
            r1 = r6
            goto L77
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.d.e(android.content.Context, java.lang.String):java.lang.String");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String f(android.content.Context r7, java.lang.String r8) {
        /*
            r6 = 0
            int r0 = com.baidu.android.pushservice.j.p.m(r7, r8)     // Catch: java.lang.Throwable -> L81
            r1 = 52
            if (r0 < r1) goto La2
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto La2
            boolean r1 = com.baidu.android.pushservice.j.p.z(r7, r8)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L7d
            java.lang.String r1 = "pushinfo_v3"
        L18:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            r2.<init>()     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = "content://"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = ".bdpush"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> L81
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L81
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L81
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto La0
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto La0
            com.baidu.android.pushservice.d.c$e r0 = com.baidu.android.pushservice.d.c.e.PushClientsBindInfo     // Catch: java.lang.Throwable -> L99
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> L99
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L99
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9d
            r2.<init>()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r3 = "pushclientsbindinfo  is "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L9d
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Throwable -> L9d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L9d
            com.baidu.android.pushservice.j.p.b(r2, r7)     // Catch: java.lang.Throwable -> L9d
        L77:
            if (r1 == 0) goto L7c
            r1.close()     // Catch: java.lang.Exception -> L92
        L7c:
            return r0
        L7d:
            java.lang.String r1 = "pushinfo"
            goto L18
        L81:
            r0 = move-exception
            r0 = r6
        L83:
            if (r6 == 0) goto L7c
            r6.close()     // Catch: java.lang.Exception -> L89
            goto L7c
        L89:
            r1 = move-exception
            goto L7c
        L8b:
            r0 = move-exception
        L8c:
            if (r6 == 0) goto L91
            r6.close()     // Catch: java.lang.Exception -> L94
        L91:
            throw r0
        L92:
            r1 = move-exception
            goto L7c
        L94:
            r1 = move-exception
            goto L91
        L96:
            r0 = move-exception
            r6 = r1
            goto L8c
        L99:
            r0 = move-exception
            r0 = r6
            r6 = r1
            goto L83
        L9d:
            r2 = move-exception
            r6 = r1
            goto L83
        La0:
            r0 = r6
            goto L77
        La2:
            r0 = r6
            r1 = r6
            goto L77
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.d.f(android.content.Context, java.lang.String):java.lang.String");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String g(android.content.Context r7, java.lang.String r8) {
        /*
            r6 = 0
            int r0 = com.baidu.android.pushservice.j.p.m(r7, r8)     // Catch: java.lang.Throwable -> L81
            r1 = 52
            if (r0 < r1) goto La2
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto La2
            boolean r1 = com.baidu.android.pushservice.j.p.z(r7, r8)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L7d
            java.lang.String r1 = "pushinfo_v3"
        L18:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            r2.<init>()     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = "content://"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = ".bdpush"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> L81
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L81
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L81
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto La0
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto La0
            com.baidu.android.pushservice.d.c$e r0 = com.baidu.android.pushservice.d.c.e.PushSelfBindInfo     // Catch: java.lang.Throwable -> L99
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> L99
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L99
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9d
            r2.<init>()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r3 = "pushselfbindinfo  is "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L9d
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Throwable -> L9d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L9d
            com.baidu.android.pushservice.j.p.b(r2, r7)     // Catch: java.lang.Throwable -> L9d
        L77:
            if (r1 == 0) goto L7c
            r1.close()     // Catch: java.lang.Exception -> L92
        L7c:
            return r0
        L7d:
            java.lang.String r1 = "pushinfo"
            goto L18
        L81:
            r0 = move-exception
            r0 = r6
        L83:
            if (r6 == 0) goto L7c
            r6.close()     // Catch: java.lang.Exception -> L89
            goto L7c
        L89:
            r1 = move-exception
            goto L7c
        L8b:
            r0 = move-exception
        L8c:
            if (r6 == 0) goto L91
            r6.close()     // Catch: java.lang.Exception -> L94
        L91:
            throw r0
        L92:
            r1 = move-exception
            goto L7c
        L94:
            r1 = move-exception
            goto L91
        L96:
            r0 = move-exception
            r6 = r1
            goto L8c
        L99:
            r0 = move-exception
            r0 = r6
            r6 = r1
            goto L83
        L9d:
            r2 = move-exception
            r6 = r1
            goto L83
        La0:
            r0 = r6
            goto L77
        La2:
            r0 = r6
            r1 = r6
            goto L77
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.d.g(android.content.Context, java.lang.String):java.lang.String");
    }
}
