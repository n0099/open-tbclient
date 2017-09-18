package com.baidu.android.pushservice.d;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.d.c;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
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
    public static java.lang.String a(android.content.Context r8, java.lang.String r9) {
        /*
            r6 = 0
            int r0 = com.baidu.android.pushservice.j.p.l(r8, r9)     // Catch: java.lang.Throwable -> Lbf
            r1 = 52
            if (r0 < r1) goto Lf8
            android.content.ContentResolver r0 = r8.getContentResolver()     // Catch: java.lang.Throwable -> Lbf
            if (r0 == 0) goto Lf8
            boolean r1 = com.baidu.android.pushservice.j.p.z(r8, r9)     // Catch: java.lang.Throwable -> Lbf
            if (r1 == 0) goto Lb2
            java.lang.String r1 = "pushinfo_v3"
        L18:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbf
            r2.<init>()     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r3 = "content://"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lbf
            java.lang.StringBuilder r2 = r2.append(r9)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r3 = ".bdpush"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lbf
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lbf
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> Lbf
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r0 = "PushInfoProviderHandle"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Leb
            r1.<init>()     // Catch: java.lang.Throwable -> Leb
            java.lang.String r3 = "getChannelID cursor  is "
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> Leb
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Leb
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Leb
            com.baidu.android.pushservice.g.a.c(r0, r1)     // Catch: java.lang.Throwable -> Leb
            if (r2 == 0) goto Lf6
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Throwable -> Leb
            if (r0 == 0) goto Lf6
            com.baidu.android.pushservice.d.c$d r0 = com.baidu.android.pushservice.d.c.d.PushChannelID     // Catch: java.lang.Throwable -> Leb
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> Leb
            int r0 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Leb
            java.lang.String r1 = r2.getString(r0)     // Catch: java.lang.Throwable -> Leb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf0
            r0.<init>()     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r3 = "pushchannelid  is "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> Lf0
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lf0
            com.baidu.android.pushservice.j.p.b(r0, r8)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r0 = "PushInfoProviderHandle"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf0
            r3.<init>()     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r4 = "pushchannelid  is "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> Lf0
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lf0
            com.baidu.android.pushservice.g.a.c(r0, r3)     // Catch: java.lang.Throwable -> Lf0
            r0 = r1
        Lac:
            if (r2 == 0) goto Lb1
            r2.close()     // Catch: java.lang.Exception -> Lb7
        Lb1:
            return r0
        Lb2:
            java.lang.String r1 = "pushinfo"
            goto L18
        Lb7:
            r1 = move-exception
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)
            goto Lb1
        Lbf:
            r0 = move-exception
            r1 = r0
            r0 = r6
        Lc2:
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)     // Catch: java.lang.Throwable -> Le8
            if (r6 == 0) goto Lb1
            r6.close()     // Catch: java.lang.Exception -> Lce
            goto Lb1
        Lce:
            r1 = move-exception
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)
            goto Lb1
        Ld6:
            r0 = move-exception
            r2 = r6
        Ld8:
            if (r2 == 0) goto Ldd
            r2.close()     // Catch: java.lang.Exception -> Lde
        Ldd:
            throw r0
        Lde:
            r1 = move-exception
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)
            goto Ldd
        Le6:
            r0 = move-exception
            goto Ld8
        Le8:
            r0 = move-exception
            r2 = r6
            goto Ld8
        Leb:
            r0 = move-exception
            r1 = r0
            r0 = r6
            r6 = r2
            goto Lc2
        Lf0:
            r0 = move-exception
            r6 = r2
            r7 = r1
            r1 = r0
            r0 = r7
            goto Lc2
        Lf6:
            r0 = r6
            goto Lac
        Lf8:
            r0 = r6
            r2 = r6
            goto Lac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.d.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static void a(Context context) {
        Cursor cursor;
        ContentResolver contentResolver;
        String b = PushSettings.b(context);
        if (TextUtils.isEmpty(b)) {
            return;
        }
        try {
            String t = p.t(context);
            if (p.l(context, t) < com.baidu.android.pushservice.a.a() || (contentResolver = context.getContentResolver()) == null) {
                cursor = null;
            } else {
                cursor = contentResolver.query(Uri.parse("content://" + t + ".bdpush/msgInfo"), null, c.EnumC0018c.appId.name() + " =? AND " + c.EnumC0018c.expireTime.name() + " <? AND " + c.EnumC0018c.arriveTime.name() + " >? ", new String[]{b, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() - 86400000)}, c.EnumC0018c.expireTime.name() + " DESC LIMIT 7");
                if (cursor != null) {
                    try {
                        com.baidu.android.pushservice.g.a.c("PushInfoProviderHandle", "getMsgInfo cursor size:  " + cursor.getCount());
                        int i = 0;
                        while (cursor.moveToNext()) {
                            long j = cursor.getLong(cursor.getColumnIndex(c.EnumC0018c.msgId.name()));
                            if (p.r(context, String.valueOf(j))) {
                                com.baidu.android.pushservice.g.a.c("PushInfoProviderHandle", " msgId: " + j + " has been showed before.");
                            } else {
                                byte[] blob = cursor.getBlob(cursor.getColumnIndex(c.EnumC0018c.msgBody.name()));
                                if (blob != null && blob.length != 0) {
                                    byte[] decrypted = BaiduAppSSOJni.getDecrypted(context, b, blob);
                                    long j2 = cursor.getLong(cursor.getColumnIndex(c.EnumC0018c.expireTime.name()));
                                    int i2 = cursor.getInt(cursor.getColumnIndex(c.EnumC0018c.msgType.name()));
                                    byte[] blob2 = cursor.getBlob(cursor.getColumnIndex(c.EnumC0018c.secureInfo.name()));
                                    com.baidu.android.pushservice.g.a.c("PushInfoProviderHandle", " get msgType: " + i2 + " msgid: " + j + " expireTime: " + j2 + " msgBody: " + decrypted.length + " secureInfo: " + blob2.length);
                                    Intent intent = new Intent();
                                    intent.putExtra("app_id", b);
                                    intent.putExtra("message_id", String.valueOf(j));
                                    intent.putExtra("baidu_message_type", i2);
                                    intent.putExtra("baidu_message_body", decrypted);
                                    intent.putExtra("baidu_message_secur_info", blob2);
                                    intent.putExtra("bdpush_deliver_NO_CALLBACK", true);
                                    p.a(context, intent, PushConstants.ACTION_MESSAGE, context.getPackageName());
                                    i++;
                                    if (i > 2) {
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                                return;
                                            } catch (Exception e) {
                                                com.baidu.android.pushservice.g.a.a("PushInfoProviderHandle", e);
                                                return;
                                            }
                                        }
                                        return;
                                    }
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            com.baidu.android.pushservice.g.a.a("PushInfoProviderHandle", th);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                    return;
                                } catch (Exception e2) {
                                    com.baidu.android.pushservice.g.a.a("PushInfoProviderHandle", e2);
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th2) {
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    com.baidu.android.pushservice.g.a.a("PushInfoProviderHandle", e3);
                                }
                            }
                            throw th2;
                        }
                    }
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e4) {
                    com.baidu.android.pushservice.g.a.a("PushInfoProviderHandle", e4);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String b(android.content.Context r8, java.lang.String r9) {
        /*
            r6 = 0
            int r0 = com.baidu.android.pushservice.j.p.l(r8, r9)     // Catch: java.lang.Throwable -> Lbf
            r1 = 52
            if (r0 < r1) goto Lf8
            android.content.ContentResolver r0 = r8.getContentResolver()     // Catch: java.lang.Throwable -> Lbf
            if (r0 == 0) goto Lf8
            boolean r1 = com.baidu.android.pushservice.j.p.z(r8, r9)     // Catch: java.lang.Throwable -> Lbf
            if (r1 == 0) goto Lb2
            java.lang.String r1 = "pushinfo_v3"
        L18:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbf
            r2.<init>()     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r3 = "content://"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lbf
            java.lang.StringBuilder r2 = r2.append(r9)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r3 = ".bdpush"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lbf
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lbf
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> Lbf
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r0 = "PushInfoProviderHandle"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Leb
            r1.<init>()     // Catch: java.lang.Throwable -> Leb
            java.lang.String r3 = "getCurrentPkgName cursor  is "
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> Leb
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Leb
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Leb
            com.baidu.android.pushservice.g.a.c(r0, r1)     // Catch: java.lang.Throwable -> Leb
            if (r2 == 0) goto Lf6
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Throwable -> Leb
            if (r0 == 0) goto Lf6
            com.baidu.android.pushservice.d.c$d r0 = com.baidu.android.pushservice.d.c.d.PushCurPkgName     // Catch: java.lang.Throwable -> Leb
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> Leb
            int r0 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Leb
            java.lang.String r1 = r2.getString(r0)     // Catch: java.lang.Throwable -> Leb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf0
            r0.<init>()     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r3 = "curPkgname  is "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> Lf0
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lf0
            com.baidu.android.pushservice.j.p.b(r0, r8)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r0 = "PushInfoProviderHandle"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf0
            r3.<init>()     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r4 = "curPkgname  is "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> Lf0
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lf0
            com.baidu.android.pushservice.g.a.c(r0, r3)     // Catch: java.lang.Throwable -> Lf0
            r0 = r1
        Lac:
            if (r2 == 0) goto Lb1
            r2.close()     // Catch: java.lang.Exception -> Lb7
        Lb1:
            return r0
        Lb2:
            java.lang.String r1 = "pushinfo"
            goto L18
        Lb7:
            r1 = move-exception
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)
            goto Lb1
        Lbf:
            r0 = move-exception
            r1 = r0
            r0 = r6
        Lc2:
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)     // Catch: java.lang.Throwable -> Le8
            if (r6 == 0) goto Lb1
            r6.close()     // Catch: java.lang.Exception -> Lce
            goto Lb1
        Lce:
            r1 = move-exception
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)
            goto Lb1
        Ld6:
            r0 = move-exception
            r2 = r6
        Ld8:
            if (r2 == 0) goto Ldd
            r2.close()     // Catch: java.lang.Exception -> Lde
        Ldd:
            throw r0
        Lde:
            r1 = move-exception
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)
            goto Ldd
        Le6:
            r0 = move-exception
            goto Ld8
        Le8:
            r0 = move-exception
            r2 = r6
            goto Ld8
        Leb:
            r0 = move-exception
            r1 = r0
            r0 = r6
            r6 = r2
            goto Lc2
        Lf0:
            r0 = move-exception
            r6 = r2
            r7 = r1
            r1 = r0
            r0 = r7
            goto Lc2
        Lf6:
            r0 = r6
            goto Lac
        Lf8:
            r0 = r6
            r2 = r6
            goto Lac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.d.b(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, CONST_STR, INVOKE, MOVE_EXCEPTION, INVOKE, CONST_STR, INVOKE, MOVE_EXCEPTION] complete} */
    public static int c(Context context, String str) {
        Throwable th;
        Cursor cursor;
        int i;
        ContentResolver contentResolver;
        try {
            if (p.l(context, str) < 52 || (contentResolver = context.getContentResolver()) == null) {
                i = 0;
                cursor = null;
            } else {
                cursor = contentResolver.query(Uri.parse("content://" + str + ".bdpush/" + (p.z(context, str) ? "pushinfo_v3" : "pushinfo")), null, null, null, null);
                try {
                    com.baidu.android.pushservice.g.a.c("PushInfoProviderHandle", "getPriority cursor  is " + cursor);
                    if (cursor == null || !cursor.moveToFirst()) {
                        i = 0;
                    } else {
                        int i2 = cursor.getInt(cursor.getColumnIndex(c.d.PushPriority.name()));
                        try {
                            p.b("pushpriority  is " + i2, context);
                            com.baidu.android.pushservice.g.a.c("PushInfoProviderHandle", "pushpriority  is " + i2);
                            i = i2;
                        } catch (Throwable th2) {
                            i = i2;
                            th = th2;
                            try {
                                com.baidu.android.pushservice.g.a.a("PushInfoProviderHandle", th);
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e) {
                                        com.baidu.android.pushservice.g.a.a("PushInfoProviderHandle", e);
                                    }
                                }
                                return i;
                            } finally {
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e2) {
                                        com.baidu.android.pushservice.g.a.a("PushInfoProviderHandle", e2);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    i = 0;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
            i = 0;
        }
        return i;
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
            int r6 = com.baidu.android.pushservice.j.p.D(r8, r9)     // Catch: java.lang.Throwable -> L138
            if (r6 <= 0) goto L18
            if (r7 == 0) goto Le
            r0.close()     // Catch: java.lang.Exception -> L10
        Le:
            r0 = r6
        Lf:
            return r0
        L10:
            r0 = move-exception
            java.lang.String r1 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r1, r0)
            goto Le
        L18:
            android.content.ContentResolver r0 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L138
            if (r0 == 0) goto L171
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L138
            r1.<init>()     // Catch: java.lang.Throwable -> L138
            java.lang.String r2 = "content://"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L138
            java.lang.StringBuilder r1 = r1.append(r9)     // Catch: java.lang.Throwable -> L138
            java.lang.String r2 = ".bdpush"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L138
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L138
            java.lang.String r2 = "pushinfo_v3"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L138
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L138
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L138
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L138
            java.lang.String r1 = "PushInfoProviderHandle"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L167
            r2.<init>()     // Catch: java.lang.Throwable -> L167
            java.lang.String r3 = "getVersion pkgname = "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L167
            java.lang.StringBuilder r2 = r2.append(r9)     // Catch: java.lang.Throwable -> L167
            java.lang.String r3 = "  cursor  is "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L167
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch: java.lang.Throwable -> L167
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L167
            com.baidu.android.pushservice.g.a.c(r1, r2)     // Catch: java.lang.Throwable -> L167
            if (r7 == 0) goto Lc4
            boolean r0 = r7.moveToFirst()     // Catch: java.lang.Throwable -> L167
            if (r0 == 0) goto L171
            com.baidu.android.pushservice.d.c$d r0 = com.baidu.android.pushservice.d.c.d.PushVersion     // Catch: java.lang.Throwable -> L167
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> L167
            int r0 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L167
            int r6 = r7.getInt(r0)     // Catch: java.lang.Throwable -> L167
            java.lang.String r0 = "PushInfoProviderHandle"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L167
            r1.<init>()     // Catch: java.lang.Throwable -> L167
            java.lang.String r2 = "pkgname = "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L167
            java.lang.StringBuilder r1 = r1.append(r9)     // Catch: java.lang.Throwable -> L167
            java.lang.String r2 = " pushversion  is "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L167
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch: java.lang.Throwable -> L167
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L167
            com.baidu.android.pushservice.g.a.c(r0, r1)     // Catch: java.lang.Throwable -> L167
            r0 = r6
        Lb4:
            if (r7 == 0) goto Lf
            r7.close()     // Catch: java.lang.Exception -> Lbb
            goto Lf
        Lbb:
            r1 = move-exception
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)
            goto Lf
        Lc4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L167
            r1.<init>()     // Catch: java.lang.Throwable -> L167
            java.lang.String r2 = "content://"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L167
            java.lang.StringBuilder r1 = r1.append(r9)     // Catch: java.lang.Throwable -> L167
            java.lang.String r2 = ".bdpush"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L167
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L167
            java.lang.String r2 = "pushinfo"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L167
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L167
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L167
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L167
            if (r1 == 0) goto L134
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L16c
            if (r0 == 0) goto L134
            com.baidu.android.pushservice.d.c$d r0 = com.baidu.android.pushservice.d.c.d.PushVersion     // Catch: java.lang.Throwable -> L16c
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> L16c
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L16c
            int r6 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L16c
            java.lang.String r0 = "PushInfoProviderHandle"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L16c
            r2.<init>()     // Catch: java.lang.Throwable -> L16c
            java.lang.String r3 = "pkgname = "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L16c
            java.lang.StringBuilder r2 = r2.append(r9)     // Catch: java.lang.Throwable -> L16c
            java.lang.String r3 = " pushversion  is "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L16c
            java.lang.StringBuilder r2 = r2.append(r6)     // Catch: java.lang.Throwable -> L16c
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L16c
            com.baidu.android.pushservice.g.a.c(r0, r2)     // Catch: java.lang.Throwable -> L16c
        L134:
            r0 = r6
            r7 = r1
            goto Lb4
        L138:
            r0 = move-exception
            r1 = r0
            r2 = r7
            r0 = r6
        L13c:
            java.lang.String r3 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r3, r1)     // Catch: java.lang.Throwable -> L164
            if (r2 == 0) goto Lf
            r2.close()     // Catch: java.lang.Exception -> L149
            goto Lf
        L149:
            r1 = move-exception
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)
            goto Lf
        L152:
            r0 = move-exception
        L153:
            if (r7 == 0) goto L158
            r7.close()     // Catch: java.lang.Exception -> L159
        L158:
            throw r0
        L159:
            r1 = move-exception
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)
            goto L158
        L161:
            r0 = move-exception
            r7 = r1
            goto L153
        L164:
            r0 = move-exception
            r7 = r2
            goto L153
        L167:
            r0 = move-exception
            r1 = r0
            r2 = r7
            r0 = r6
            goto L13c
        L16c:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r6
            goto L13c
        L171:
            r0 = r6
            goto Lb4
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
    public static java.lang.String e(android.content.Context r8, java.lang.String r9) {
        /*
            r6 = 0
            int r0 = com.baidu.android.pushservice.j.p.l(r8, r9)     // Catch: java.lang.Throwable -> Lbf
            r1 = 52
            if (r0 < r1) goto Lf8
            android.content.ContentResolver r0 = r8.getContentResolver()     // Catch: java.lang.Throwable -> Lbf
            if (r0 == 0) goto Lf8
            boolean r1 = com.baidu.android.pushservice.j.p.z(r8, r9)     // Catch: java.lang.Throwable -> Lbf
            if (r1 == 0) goto Lb2
            java.lang.String r1 = "pushinfo_v3"
        L18:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbf
            r2.<init>()     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r3 = "content://"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lbf
            java.lang.StringBuilder r2 = r2.append(r9)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r3 = ".bdpush"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lbf
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lbf
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> Lbf
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r0 = "PushInfoProviderHandle"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Leb
            r1.<init>()     // Catch: java.lang.Throwable -> Leb
            java.lang.String r3 = "getSDKClientBindInfo cursor  is "
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> Leb
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Leb
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Leb
            com.baidu.android.pushservice.g.a.c(r0, r1)     // Catch: java.lang.Throwable -> Leb
            if (r2 == 0) goto Lf6
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Throwable -> Leb
            if (r0 == 0) goto Lf6
            com.baidu.android.pushservice.d.c$d r0 = com.baidu.android.pushservice.d.c.d.PushSDKClientBindInfo     // Catch: java.lang.Throwable -> Leb
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> Leb
            int r0 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Leb
            java.lang.String r1 = r2.getString(r0)     // Catch: java.lang.Throwable -> Leb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf0
            r0.<init>()     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r3 = "sdkclientbindinfo  is "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> Lf0
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lf0
            com.baidu.android.pushservice.j.p.b(r0, r8)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r0 = "PushInfoProviderHandle"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf0
            r3.<init>()     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r4 = "sdkclientbindinfo  is "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> Lf0
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lf0
            com.baidu.android.pushservice.g.a.c(r0, r3)     // Catch: java.lang.Throwable -> Lf0
            r0 = r1
        Lac:
            if (r2 == 0) goto Lb1
            r2.close()     // Catch: java.lang.Exception -> Lb7
        Lb1:
            return r0
        Lb2:
            java.lang.String r1 = "pushinfo"
            goto L18
        Lb7:
            r1 = move-exception
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)
            goto Lb1
        Lbf:
            r0 = move-exception
            r1 = r0
            r0 = r6
        Lc2:
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)     // Catch: java.lang.Throwable -> Le8
            if (r6 == 0) goto Lb1
            r6.close()     // Catch: java.lang.Exception -> Lce
            goto Lb1
        Lce:
            r1 = move-exception
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)
            goto Lb1
        Ld6:
            r0 = move-exception
            r2 = r6
        Ld8:
            if (r2 == 0) goto Ldd
            r2.close()     // Catch: java.lang.Exception -> Lde
        Ldd:
            throw r0
        Lde:
            r1 = move-exception
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)
            goto Ldd
        Le6:
            r0 = move-exception
            goto Ld8
        Le8:
            r0 = move-exception
            r2 = r6
            goto Ld8
        Leb:
            r0 = move-exception
            r1 = r0
            r0 = r6
            r6 = r2
            goto Lc2
        Lf0:
            r0 = move-exception
            r6 = r2
            r7 = r1
            r1 = r0
            r0 = r7
            goto Lc2
        Lf6:
            r0 = r6
            goto Lac
        Lf8:
            r0 = r6
            r2 = r6
            goto Lac
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
    public static java.lang.String f(android.content.Context r8, java.lang.String r9) {
        /*
            r6 = 0
            int r0 = com.baidu.android.pushservice.j.p.l(r8, r9)     // Catch: java.lang.Throwable -> Lbf
            r1 = 52
            if (r0 < r1) goto Lf8
            android.content.ContentResolver r0 = r8.getContentResolver()     // Catch: java.lang.Throwable -> Lbf
            if (r0 == 0) goto Lf8
            boolean r1 = com.baidu.android.pushservice.j.p.z(r8, r9)     // Catch: java.lang.Throwable -> Lbf
            if (r1 == 0) goto Lb2
            java.lang.String r1 = "pushinfo_v3"
        L18:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbf
            r2.<init>()     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r3 = "content://"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lbf
            java.lang.StringBuilder r2 = r2.append(r9)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r3 = ".bdpush"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lbf
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lbf
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> Lbf
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r0 = "PushInfoProviderHandle"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Leb
            r1.<init>()     // Catch: java.lang.Throwable -> Leb
            java.lang.String r3 = "getPushClientsBindInfo cursor  is "
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> Leb
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Leb
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Leb
            com.baidu.android.pushservice.g.a.c(r0, r1)     // Catch: java.lang.Throwable -> Leb
            if (r2 == 0) goto Lf6
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Throwable -> Leb
            if (r0 == 0) goto Lf6
            com.baidu.android.pushservice.d.c$d r0 = com.baidu.android.pushservice.d.c.d.PushClientsBindInfo     // Catch: java.lang.Throwable -> Leb
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> Leb
            int r0 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Leb
            java.lang.String r1 = r2.getString(r0)     // Catch: java.lang.Throwable -> Leb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf0
            r0.<init>()     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r3 = "pushclientsbindinfo  is "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> Lf0
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lf0
            com.baidu.android.pushservice.j.p.b(r0, r8)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r0 = "PushInfoProviderHandle"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf0
            r3.<init>()     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r4 = "pushclientsbindinfo  is "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> Lf0
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lf0
            com.baidu.android.pushservice.g.a.c(r0, r3)     // Catch: java.lang.Throwable -> Lf0
            r0 = r1
        Lac:
            if (r2 == 0) goto Lb1
            r2.close()     // Catch: java.lang.Exception -> Lb7
        Lb1:
            return r0
        Lb2:
            java.lang.String r1 = "pushinfo"
            goto L18
        Lb7:
            r1 = move-exception
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)
            goto Lb1
        Lbf:
            r0 = move-exception
            r1 = r0
            r0 = r6
        Lc2:
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)     // Catch: java.lang.Throwable -> Le8
            if (r6 == 0) goto Lb1
            r6.close()     // Catch: java.lang.Exception -> Lce
            goto Lb1
        Lce:
            r1 = move-exception
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)
            goto Lb1
        Ld6:
            r0 = move-exception
            r2 = r6
        Ld8:
            if (r2 == 0) goto Ldd
            r2.close()     // Catch: java.lang.Exception -> Lde
        Ldd:
            throw r0
        Lde:
            r1 = move-exception
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)
            goto Ldd
        Le6:
            r0 = move-exception
            goto Ld8
        Le8:
            r0 = move-exception
            r2 = r6
            goto Ld8
        Leb:
            r0 = move-exception
            r1 = r0
            r0 = r6
            r6 = r2
            goto Lc2
        Lf0:
            r0 = move-exception
            r6 = r2
            r7 = r1
            r1 = r0
            r0 = r7
            goto Lc2
        Lf6:
            r0 = r6
            goto Lac
        Lf8:
            r0 = r6
            r2 = r6
            goto Lac
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
    public static java.lang.String g(android.content.Context r8, java.lang.String r9) {
        /*
            r6 = 0
            int r0 = com.baidu.android.pushservice.j.p.l(r8, r9)     // Catch: java.lang.Throwable -> Lbf
            r1 = 52
            if (r0 < r1) goto Lf8
            android.content.ContentResolver r0 = r8.getContentResolver()     // Catch: java.lang.Throwable -> Lbf
            if (r0 == 0) goto Lf8
            boolean r1 = com.baidu.android.pushservice.j.p.z(r8, r9)     // Catch: java.lang.Throwable -> Lbf
            if (r1 == 0) goto Lb2
            java.lang.String r1 = "pushinfo_v3"
        L18:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbf
            r2.<init>()     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r3 = "content://"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lbf
            java.lang.StringBuilder r2 = r2.append(r9)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r3 = ".bdpush"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lbf
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lbf
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> Lbf
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r0 = "PushInfoProviderHandle"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Leb
            r1.<init>()     // Catch: java.lang.Throwable -> Leb
            java.lang.String r3 = "getPushSelfBindInfo cursor  is "
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> Leb
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Leb
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Leb
            com.baidu.android.pushservice.g.a.c(r0, r1)     // Catch: java.lang.Throwable -> Leb
            if (r2 == 0) goto Lf6
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Throwable -> Leb
            if (r0 == 0) goto Lf6
            com.baidu.android.pushservice.d.c$d r0 = com.baidu.android.pushservice.d.c.d.PushSelfBindInfo     // Catch: java.lang.Throwable -> Leb
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> Leb
            int r0 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Leb
            java.lang.String r1 = r2.getString(r0)     // Catch: java.lang.Throwable -> Leb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf0
            r0.<init>()     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r3 = "pushselfbindinfo  is "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> Lf0
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lf0
            com.baidu.android.pushservice.j.p.b(r0, r8)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r0 = "PushInfoProviderHandle"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf0
            r3.<init>()     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r4 = "pushselfbindinfo  is "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> Lf0
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lf0
            com.baidu.android.pushservice.g.a.c(r0, r3)     // Catch: java.lang.Throwable -> Lf0
            r0 = r1
        Lac:
            if (r2 == 0) goto Lb1
            r2.close()     // Catch: java.lang.Exception -> Lb7
        Lb1:
            return r0
        Lb2:
            java.lang.String r1 = "pushinfo"
            goto L18
        Lb7:
            r1 = move-exception
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)
            goto Lb1
        Lbf:
            r0 = move-exception
            r1 = r0
            r0 = r6
        Lc2:
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)     // Catch: java.lang.Throwable -> Le8
            if (r6 == 0) goto Lb1
            r6.close()     // Catch: java.lang.Exception -> Lce
            goto Lb1
        Lce:
            r1 = move-exception
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)
            goto Lb1
        Ld6:
            r0 = move-exception
            r2 = r6
        Ld8:
            if (r2 == 0) goto Ldd
            r2.close()     // Catch: java.lang.Exception -> Lde
        Ldd:
            throw r0
        Lde:
            r1 = move-exception
            java.lang.String r2 = "PushInfoProviderHandle"
            com.baidu.android.pushservice.g.a.a(r2, r1)
            goto Ldd
        Le6:
            r0 = move-exception
            goto Ld8
        Le8:
            r0 = move-exception
            r2 = r6
            goto Ld8
        Leb:
            r0 = move-exception
            r1 = r0
            r0 = r6
            r6 = r2
            goto Lc2
        Lf0:
            r0 = move-exception
            r6 = r2
            r7 = r1
            r1 = r0
            r0 = r7
            goto Lc2
        Lf6:
            r0 = r6
            goto Lac
        Lf8:
            r0 = r6
            r2 = r6
            goto Lac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.d.g(android.content.Context, java.lang.String):java.lang.String");
    }
}
