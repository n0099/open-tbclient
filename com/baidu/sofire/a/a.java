package com.baidu.sofire.a;

import android.content.Context;
import android.telephony.TelephonyManager;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f3499a;
    private static int b = -1;

    private static String b(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Throwable th) {
            return "";
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:24:0x0071
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static synchronized java.lang.String a(android.content.Context r8) {
        /*
            java.lang.Class<com.baidu.sofire.a.a> r1 = com.baidu.sofire.a.a.class
            monitor-enter(r1)
            java.lang.String r0 = ""
            java.lang.String r2 = com.baidu.sofire.a.a.f3499a     // Catch: java.lang.Throwable -> L24
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L24
            if (r2 != 0) goto L12
            java.lang.String r0 = com.baidu.sofire.a.a.f3499a     // Catch: java.lang.Throwable -> L24
        L10:
            monitor-exit(r1)
            return r0
        L12:
            com.baidu.sofire.b.c r2 = new com.baidu.sofire.b.c     // Catch: java.lang.Throwable -> L24
            r2.<init>(r8)     // Catch: java.lang.Throwable -> L24
            java.lang.String r0 = r2.a()     // Catch: java.lang.Throwable -> L24
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L24
            if (r3 != 0) goto L26
            com.baidu.sofire.a.a.f3499a = r0     // Catch: java.lang.Throwable -> L24
            goto L10
        L24:
            r2 = move-exception
            goto L10
        L26:
            java.lang.String r3 = "android.permission.READ_PHONE_STATE"
            int r4 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L24
            int r5 = android.os.Process.myUid()     // Catch: java.lang.Throwable -> L24
            int r3 = r8.checkPermission(r3, r4, r5)     // Catch: java.lang.Throwable -> L24
            r4 = -1
            if (r3 == r4) goto L10
            java.lang.String r0 = b(r8)     // Catch: java.lang.Throwable -> L24
            com.baidu.sofire.a.a.f3499a = r0     // Catch: java.lang.Throwable -> L24
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L6f
            if (r3 != 0) goto L10
            android.content.SharedPreferences$Editor r3 = r2.f3502a     // Catch: java.lang.Throwable -> L6f
            java.lang.String r4 = "dd_v_d"
            java.lang.String r5 = com.baidu.sofire.b.c.a(r0)     // Catch: java.lang.Throwable -> L6f
            r3.putString(r4, r5)     // Catch: java.lang.Throwable -> L6f
            android.content.SharedPreferences$Editor r3 = r2.f3502a     // Catch: java.lang.Throwable -> L6f
            r3.commit()     // Catch: java.lang.Throwable -> L6f
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L6f
            java.lang.Long r3 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> L6f
            android.content.SharedPreferences$Editor r4 = r2.f3502a     // Catch: java.lang.Throwable -> L6f
            java.lang.String r5 = "dd_v_d_t"
            long r6 = r3.longValue()     // Catch: java.lang.Throwable -> L6f
            r4.putLong(r5, r6)     // Catch: java.lang.Throwable -> L6f
            android.content.SharedPreferences$Editor r2 = r2.f3502a     // Catch: java.lang.Throwable -> L6f
            r2.commit()     // Catch: java.lang.Throwable -> L6f
            goto L10
        L6f:
            r2 = move-exception
            goto L10
        L71:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.a.a.a(android.content.Context):java.lang.String");
    }
}
