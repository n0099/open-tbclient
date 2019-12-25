package com.baidu.android.pushservice.c;
/* loaded from: classes5.dex */
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
            int r0 = com.baidu.android.pushservice.i.l.m(r7, r8)     // Catch: java.lang.Throwable -> L8c
            r1 = 52
            if (r0 < r1) goto Lad
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L8c
            if (r0 == 0) goto Lad
            boolean r1 = com.baidu.android.pushservice.i.l.z(r7, r8)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L88
            java.lang.String r1 = "pushinfo_v3"
        L18:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8c
            r2.<init>()     // Catch: java.lang.Throwable -> L8c
            java.lang.String r3 = "content://"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8c
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r3 = ".bdpush"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8c
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L8c
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L8c
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L8c
            r3 = 0
            com.baidu.android.pushservice.c.c$e r4 = com.baidu.android.pushservice.c.c.e.PushChannelID     // Catch: java.lang.Throwable -> L8c
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L8c
            r2[r3] = r4     // Catch: java.lang.Throwable -> L8c
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto Lab
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> La4
            if (r0 == 0) goto Lab
            com.baidu.android.pushservice.c.c$e r0 = com.baidu.android.pushservice.c.c.e.PushChannelID     // Catch: java.lang.Throwable -> La4
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> La4
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> La4
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> La4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La8
            r2.<init>()     // Catch: java.lang.Throwable -> La8
            java.lang.String r3 = "pushchannelid  is "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> La8
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Throwable -> La8
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> La8
            com.baidu.android.pushservice.i.l.b(r2, r7)     // Catch: java.lang.Throwable -> La8
        L82:
            if (r1 == 0) goto L87
            r1.close()     // Catch: java.lang.Exception -> L9d
        L87:
            return r0
        L88:
            java.lang.String r1 = "pushinfo"
            goto L18
        L8c:
            r0 = move-exception
            r0 = r6
        L8e:
            if (r6 == 0) goto L87
            r6.close()     // Catch: java.lang.Exception -> L94
            goto L87
        L94:
            r1 = move-exception
            goto L87
        L96:
            r0 = move-exception
        L97:
            if (r6 == 0) goto L9c
            r6.close()     // Catch: java.lang.Exception -> L9f
        L9c:
            throw r0
        L9d:
            r1 = move-exception
            goto L87
        L9f:
            r1 = move-exception
            goto L9c
        La1:
            r0 = move-exception
            r6 = r1
            goto L97
        La4:
            r0 = move-exception
            r0 = r6
            r6 = r1
            goto L8e
        La8:
            r2 = move-exception
            r6 = r1
            goto L8e
        Lab:
            r0 = r6
            goto L82
        Lad:
            r0 = r6
            r1 = r6
            goto L82
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.c.d.a(android.content.Context, java.lang.String):java.lang.String");
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
            java.lang.String r8 = com.baidu.android.pushservice.PushSettings.c(r15)
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto Le
        Ld:
            return
        Le:
            java.lang.String r1 = com.baidu.android.pushservice.i.l.u(r15)     // Catch: java.lang.Throwable -> L181
            int r0 = com.baidu.android.pushservice.i.l.m(r15, r1)     // Catch: java.lang.Throwable -> L181
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
            com.baidu.android.pushservice.c.c$d r3 = com.baidu.android.pushservice.c.c.d.appId     // Catch: java.lang.Throwable -> L181
            java.lang.String r3 = r3.name()     // Catch: java.lang.Throwable -> L181
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L181
            java.lang.String r3 = " =? AND "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L181
            com.baidu.android.pushservice.c.c$d r3 = com.baidu.android.pushservice.c.c.d.expireTime     // Catch: java.lang.Throwable -> L181
            java.lang.String r3 = r3.name()     // Catch: java.lang.Throwable -> L181
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L181
            java.lang.String r3 = " <? AND "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L181
            com.baidu.android.pushservice.c.c$d r3 = com.baidu.android.pushservice.c.c.d.arriveTime     // Catch: java.lang.Throwable -> L181
            java.lang.String r3 = r3.name()     // Catch: java.lang.Throwable -> L181
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L181
            java.lang.String r3 = " >? "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L181
            java.lang.String r3 = r2.toString()     // Catch: java.lang.Throwable -> L181
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L181
            r2.<init>()     // Catch: java.lang.Throwable -> L181
            com.baidu.android.pushservice.c.c$d r4 = com.baidu.android.pushservice.c.c.d.expireTime     // Catch: java.lang.Throwable -> L181
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
            com.baidu.android.pushservice.c.c$d r2 = com.baidu.android.pushservice.c.c.d.msgId     // Catch: java.lang.Throwable -> L19a
            java.lang.String r2 = r2.name()     // Catch: java.lang.Throwable -> L19a
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L19a
            long r2 = r0.getLong(r2)     // Catch: java.lang.Throwable -> L19a
            java.lang.String r4 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L19a
            boolean r4 = com.baidu.android.pushservice.i.l.s(r15, r4)     // Catch: java.lang.Throwable -> L19a
            if (r4 != 0) goto Ld2
            com.baidu.android.pushservice.c.c$d r4 = com.baidu.android.pushservice.c.c.d.msgBody     // Catch: java.lang.Throwable -> L19a
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L19a
            int r4 = r0.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L19a
            byte[] r4 = r0.getBlob(r4)     // Catch: java.lang.Throwable -> L19a
            if (r4 == 0) goto Ld2
            int r5 = r4.length     // Catch: java.lang.Throwable -> L19a
            if (r5 == 0) goto Ld2
            byte[] r4 = com.baidu.android.pushservice.jni.BaiduAppSSOJni.getDecrypted(r15, r8, r4)     // Catch: java.lang.Throwable -> L19a
            com.baidu.android.pushservice.c.c$d r5 = com.baidu.android.pushservice.c.c.d.expireTime     // Catch: java.lang.Throwable -> L19a
            java.lang.String r5 = r5.name()     // Catch: java.lang.Throwable -> L19a
            int r5 = r0.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L19a
            r0.getLong(r5)     // Catch: java.lang.Throwable -> L19a
            com.baidu.android.pushservice.c.c$d r5 = com.baidu.android.pushservice.c.c.d.msgType     // Catch: java.lang.Throwable -> L19a
            java.lang.String r5 = r5.name()     // Catch: java.lang.Throwable -> L19a
            int r5 = r0.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L19a
            int r5 = r0.getInt(r5)     // Catch: java.lang.Throwable -> L19a
            com.baidu.android.pushservice.c.c$d r6 = com.baidu.android.pushservice.c.c.d.secureInfo     // Catch: java.lang.Throwable -> L19a
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
            com.baidu.android.pushservice.i.l.a(r15, r7, r2, r3)     // Catch: java.lang.Throwable -> L19a
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.c.d.a(android.content.Context):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static int b(android.content.Context r8, java.lang.String r9) {
        /*
            r6 = 0
            r7 = 0
            int r0 = com.baidu.android.pushservice.i.l.m(r8, r9)     // Catch: java.lang.Throwable -> L8d
            r1 = 52
            if (r0 < r1) goto Lad
            android.content.ContentResolver r0 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L8d
            if (r0 == 0) goto Lad
            boolean r1 = com.baidu.android.pushservice.i.l.z(r8, r9)     // Catch: java.lang.Throwable -> L8d
            if (r1 == 0) goto L89
            java.lang.String r1 = "pushinfo_v3"
        L19:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8d
            r2.<init>()     // Catch: java.lang.Throwable -> L8d
            java.lang.String r3 = "content://"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8d
            java.lang.StringBuilder r2 = r2.append(r9)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r3 = ".bdpush"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8d
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L8d
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L8d
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L8d
            r3 = 0
            com.baidu.android.pushservice.c.c$e r4 = com.baidu.android.pushservice.c.c.e.PushPriority     // Catch: java.lang.Throwable -> L8d
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L8d
            r2[r3] = r4     // Catch: java.lang.Throwable -> L8d
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L8d
            if (r1 == 0) goto Lab
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> La6
            if (r0 == 0) goto Lab
            com.baidu.android.pushservice.c.c$e r0 = com.baidu.android.pushservice.c.c.e.PushPriority     // Catch: java.lang.Throwable -> La6
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> La6
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> La6
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> La6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La9
            r2.<init>()     // Catch: java.lang.Throwable -> La9
            java.lang.String r3 = "pushpriority  is "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> La9
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Throwable -> La9
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> La9
            com.baidu.android.pushservice.i.l.b(r2, r8)     // Catch: java.lang.Throwable -> La9
        L83:
            if (r1 == 0) goto L88
            r1.close()     // Catch: java.lang.Exception -> L9f
        L88:
            return r0
        L89:
            java.lang.String r1 = "pushinfo"
            goto L19
        L8d:
            r0 = move-exception
            r0 = r6
            r1 = r7
        L90:
            if (r1 == 0) goto L88
            r1.close()     // Catch: java.lang.Exception -> L96
            goto L88
        L96:
            r1 = move-exception
            goto L88
        L98:
            r0 = move-exception
        L99:
            if (r7 == 0) goto L9e
            r7.close()     // Catch: java.lang.Exception -> La1
        L9e:
            throw r0
        L9f:
            r1 = move-exception
            goto L88
        La1:
            r1 = move-exception
            goto L9e
        La3:
            r0 = move-exception
            r7 = r1
            goto L99
        La6:
            r0 = move-exception
            r0 = r6
            goto L90
        La9:
            r2 = move-exception
            goto L90
        Lab:
            r0 = r6
            goto L83
        Lad:
            r0 = r6
            r1 = r7
            goto L83
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.c.d.b(android.content.Context, java.lang.String):int");
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
            r6 = 0
            r7 = 0
            r0 = 0
            int r6 = com.baidu.android.pushservice.i.l.C(r8, r9)     // Catch: java.lang.Throwable -> Lce
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.c.d.c(android.content.Context, java.lang.String):int");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String d(android.content.Context r7, java.lang.String r8) {
        /*
            r6 = 0
            int r0 = com.baidu.android.pushservice.i.l.m(r7, r8)     // Catch: java.lang.Throwable -> L8c
            r1 = 52
            if (r0 < r1) goto Lad
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L8c
            if (r0 == 0) goto Lad
            boolean r1 = com.baidu.android.pushservice.i.l.z(r7, r8)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L88
            java.lang.String r1 = "pushinfo_v3"
        L18:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8c
            r2.<init>()     // Catch: java.lang.Throwable -> L8c
            java.lang.String r3 = "content://"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8c
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r3 = ".bdpush"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8c
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L8c
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L8c
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L8c
            r3 = 0
            com.baidu.android.pushservice.c.c$e r4 = com.baidu.android.pushservice.c.c.e.PushSDKClientBindInfo     // Catch: java.lang.Throwable -> L8c
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L8c
            r2[r3] = r4     // Catch: java.lang.Throwable -> L8c
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto Lab
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> La4
            if (r0 == 0) goto Lab
            com.baidu.android.pushservice.c.c$e r0 = com.baidu.android.pushservice.c.c.e.PushSDKClientBindInfo     // Catch: java.lang.Throwable -> La4
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> La4
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> La4
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> La4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La8
            r2.<init>()     // Catch: java.lang.Throwable -> La8
            java.lang.String r3 = "sdkclientbindinfo  is "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> La8
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Throwable -> La8
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> La8
            com.baidu.android.pushservice.i.l.b(r2, r7)     // Catch: java.lang.Throwable -> La8
        L82:
            if (r1 == 0) goto L87
            r1.close()     // Catch: java.lang.Exception -> L9d
        L87:
            return r0
        L88:
            java.lang.String r1 = "pushinfo"
            goto L18
        L8c:
            r0 = move-exception
            r0 = r6
        L8e:
            if (r6 == 0) goto L87
            r6.close()     // Catch: java.lang.Exception -> L94
            goto L87
        L94:
            r1 = move-exception
            goto L87
        L96:
            r0 = move-exception
        L97:
            if (r6 == 0) goto L9c
            r6.close()     // Catch: java.lang.Exception -> L9f
        L9c:
            throw r0
        L9d:
            r1 = move-exception
            goto L87
        L9f:
            r1 = move-exception
            goto L9c
        La1:
            r0 = move-exception
            r6 = r1
            goto L97
        La4:
            r0 = move-exception
            r0 = r6
            r6 = r1
            goto L8e
        La8:
            r2 = move-exception
            r6 = r1
            goto L8e
        Lab:
            r0 = r6
            goto L82
        Lad:
            r0 = r6
            r1 = r6
            goto L82
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.c.d.d(android.content.Context, java.lang.String):java.lang.String");
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
            int r0 = com.baidu.android.pushservice.i.l.m(r7, r8)     // Catch: java.lang.Throwable -> L8c
            r1 = 52
            if (r0 < r1) goto Lad
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L8c
            if (r0 == 0) goto Lad
            boolean r1 = com.baidu.android.pushservice.i.l.z(r7, r8)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L88
            java.lang.String r1 = "pushinfo_v3"
        L18:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8c
            r2.<init>()     // Catch: java.lang.Throwable -> L8c
            java.lang.String r3 = "content://"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8c
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r3 = ".bdpush"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8c
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L8c
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L8c
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L8c
            r3 = 0
            com.baidu.android.pushservice.c.c$e r4 = com.baidu.android.pushservice.c.c.e.PushClientsBindInfo     // Catch: java.lang.Throwable -> L8c
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L8c
            r2[r3] = r4     // Catch: java.lang.Throwable -> L8c
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto Lab
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> La4
            if (r0 == 0) goto Lab
            com.baidu.android.pushservice.c.c$e r0 = com.baidu.android.pushservice.c.c.e.PushClientsBindInfo     // Catch: java.lang.Throwable -> La4
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> La4
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> La4
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> La4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La8
            r2.<init>()     // Catch: java.lang.Throwable -> La8
            java.lang.String r3 = "pushclientsbindinfo  is "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> La8
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Throwable -> La8
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> La8
            com.baidu.android.pushservice.i.l.b(r2, r7)     // Catch: java.lang.Throwable -> La8
        L82:
            if (r1 == 0) goto L87
            r1.close()     // Catch: java.lang.Exception -> L9d
        L87:
            return r0
        L88:
            java.lang.String r1 = "pushinfo"
            goto L18
        L8c:
            r0 = move-exception
            r0 = r6
        L8e:
            if (r6 == 0) goto L87
            r6.close()     // Catch: java.lang.Exception -> L94
            goto L87
        L94:
            r1 = move-exception
            goto L87
        L96:
            r0 = move-exception
        L97:
            if (r6 == 0) goto L9c
            r6.close()     // Catch: java.lang.Exception -> L9f
        L9c:
            throw r0
        L9d:
            r1 = move-exception
            goto L87
        L9f:
            r1 = move-exception
            goto L9c
        La1:
            r0 = move-exception
            r6 = r1
            goto L97
        La4:
            r0 = move-exception
            r0 = r6
            r6 = r1
            goto L8e
        La8:
            r2 = move-exception
            r6 = r1
            goto L8e
        Lab:
            r0 = r6
            goto L82
        Lad:
            r0 = r6
            r1 = r6
            goto L82
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.c.d.e(android.content.Context, java.lang.String):java.lang.String");
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
            int r0 = com.baidu.android.pushservice.i.l.m(r7, r8)     // Catch: java.lang.Throwable -> L8c
            r1 = 52
            if (r0 < r1) goto Lad
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L8c
            if (r0 == 0) goto Lad
            boolean r1 = com.baidu.android.pushservice.i.l.z(r7, r8)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L88
            java.lang.String r1 = "pushinfo_v3"
        L18:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8c
            r2.<init>()     // Catch: java.lang.Throwable -> L8c
            java.lang.String r3 = "content://"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8c
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r3 = ".bdpush"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8c
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L8c
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L8c
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L8c
            r3 = 0
            com.baidu.android.pushservice.c.c$e r4 = com.baidu.android.pushservice.c.c.e.PushSelfBindInfo     // Catch: java.lang.Throwable -> L8c
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L8c
            r2[r3] = r4     // Catch: java.lang.Throwable -> L8c
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto Lab
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> La4
            if (r0 == 0) goto Lab
            com.baidu.android.pushservice.c.c$e r0 = com.baidu.android.pushservice.c.c.e.PushSelfBindInfo     // Catch: java.lang.Throwable -> La4
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> La4
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> La4
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> La4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La8
            r2.<init>()     // Catch: java.lang.Throwable -> La8
            java.lang.String r3 = "pushselfbindinfo  is "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> La8
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Throwable -> La8
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> La8
            com.baidu.android.pushservice.i.l.b(r2, r7)     // Catch: java.lang.Throwable -> La8
        L82:
            if (r1 == 0) goto L87
            r1.close()     // Catch: java.lang.Exception -> L9d
        L87:
            return r0
        L88:
            java.lang.String r1 = "pushinfo"
            goto L18
        L8c:
            r0 = move-exception
            r0 = r6
        L8e:
            if (r6 == 0) goto L87
            r6.close()     // Catch: java.lang.Exception -> L94
            goto L87
        L94:
            r1 = move-exception
            goto L87
        L96:
            r0 = move-exception
        L97:
            if (r6 == 0) goto L9c
            r6.close()     // Catch: java.lang.Exception -> L9f
        L9c:
            throw r0
        L9d:
            r1 = move-exception
            goto L87
        L9f:
            r1 = move-exception
            goto L9c
        La1:
            r0 = move-exception
            r6 = r1
            goto L97
        La4:
            r0 = move-exception
            r0 = r6
            r6 = r1
            goto L8e
        La8:
            r2 = move-exception
            r6 = r1
            goto L8e
        Lab:
            r0 = r6
            goto L82
        Lad:
            r0 = r6
            r1 = r6
            goto L82
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.c.d.f(android.content.Context, java.lang.String):java.lang.String");
    }
}
