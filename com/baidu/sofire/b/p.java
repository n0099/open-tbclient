package com.baidu.sofire.b;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
/* loaded from: classes.dex */
public final class p {
    private static String a = "";

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static java.lang.String b(android.content.Context r7) {
        /*
            r1 = 1
            r2 = 0
            java.lang.String r0 = c(r7)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L134
            java.lang.String r0 = d(r7)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L12d
            java.lang.String r0 = e(r7)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L127
            java.lang.String r0 = com.baidu.sofire.b.g.d(r7)
            java.lang.String r2 = com.baidu.sofire.b.g.e(r7)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto Lcf
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto Lcf
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "1|"
            r0.<init>(r2)
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = com.baidu.sofire.b.o.a(r2)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
        L50:
            r2 = r0
            r3 = r1
            r0 = r1
        L53:
            if (r3 != 0) goto L5f
            java.lang.String r3 = c(r7)
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L71
        L5f:
            com.baidu.sofire.e r3 = new com.baidu.sofire.e
            r3.<init>(r7)
            android.content.SharedPreferences$Editor r4 = r3.d
            java.lang.String r5 = "rpnewuid"
            r4.putString(r5, r2)
            android.content.SharedPreferences$Editor r3 = r3.d
            r3.commit()
        L71:
            if (r1 != 0) goto L7d
            java.lang.String r1 = d(r7)
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L83
        L7d:
            java.lang.String r1 = "com.q.zi.i"
            a(r7, r1, r2)
        L83:
            java.lang.String r1 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r1 = b(r7, r1)
            if (r1 == 0) goto Lce
            if (r0 != 0) goto L98
            java.lang.String r0 = e(r7)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto Lce
        L98:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> Lfa
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r4 = ".zp"
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lfa
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r4 = ".icosc"
            r3.<init>(r1, r4)     // Catch: java.lang.Throwable -> Lfa
            boolean r4 = r1.exists()     // Catch: java.lang.Throwable -> Lfa
            if (r4 == 0) goto Lf6
            boolean r4 = r1.isDirectory()     // Catch: java.lang.Throwable -> Lfa
            if (r4 != 0) goto Lbf
            r1.delete()     // Catch: java.lang.Throwable -> Lfa
            r1.mkdirs()     // Catch: java.lang.Throwable -> Lfa
        Lbf:
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> Lfa
            r4 = 0
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lfa
            r1.write(r2)     // Catch: java.lang.Throwable -> L124
            r1.flush()     // Catch: java.lang.Throwable -> L124
            r1.close()     // Catch: java.lang.Throwable -> L109
        Lce:
            return r2
        Lcf:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "0|"
            r3.<init>(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = com.baidu.sofire.b.o.a(r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r0 = r0.toString()
            goto L50
        Lf6:
            r1.mkdirs()     // Catch: java.lang.Throwable -> Lfa
            goto Lbf
        Lfa:
            r1 = move-exception
        Lfb:
            com.baidu.sofire.b.e.a()     // Catch: java.lang.Throwable -> L11f
            if (r0 == 0) goto Lce
            r0.close()     // Catch: java.lang.Throwable -> L104
            goto Lce
        L104:
            r0 = move-exception
            com.baidu.sofire.b.e.a()
            goto Lce
        L109:
            r0 = move-exception
            com.baidu.sofire.b.e.a()
            goto Lce
        L10e:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L112:
            if (r1 == 0) goto L117
            r1.close()     // Catch: java.lang.Throwable -> L118
        L117:
            throw r0
        L118:
            r1 = move-exception
            com.baidu.sofire.b.e.a()
            goto L117
        L11d:
            r0 = move-exception
            goto L112
        L11f:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L112
        L124:
            r0 = move-exception
            r0 = r1
            goto Lfb
        L127:
            r3 = r1
            r6 = r2
            r2 = r0
            r0 = r6
            goto L53
        L12d:
            r3 = r1
            r1 = r2
            r6 = r2
            r2 = r0
            r0 = r6
            goto L53
        L134:
            r1 = r2
            r3 = r2
            r6 = r0
            r0 = r2
            r2 = r6
            goto L53
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.p.b(android.content.Context):java.lang.String");
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(a)) {
            new p();
            a = b(context);
        }
        return a;
    }

    private static String c(Context context) {
        try {
            return new com.baidu.sofire.e(context).b.getString("rpnewuid", "");
        } catch (Throwable th) {
            e.a();
            return "";
        }
    }

    private static String d(Context context) {
        try {
            return a(context, "com.q.zi.i");
        } catch (Throwable th) {
            e.a();
            return "";
        }
    }

    private static String e(Context context) {
        try {
        } catch (Throwable th) {
            e.a();
        }
        if (!b(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            return "";
        }
        File file = new File(Environment.getExternalStorageDirectory(), ".zp/.icosc");
        if (file.exists()) {
            return a(file);
        }
        return "";
    }

    private static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }

    private static String a(File file) {
        FileReader fileReader;
        String str = null;
        try {
            fileReader = new FileReader(file);
            try {
                char[] cArr = new char[8192];
                CharArrayWriter charArrayWriter = new CharArrayWriter();
                while (true) {
                    int read = fileReader.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    charArrayWriter.write(cArr, 0, read);
                }
                str = charArrayWriter.toString();
                try {
                    fileReader.close();
                } catch (Throwable th) {
                    e.a();
                }
            } catch (Throwable th2) {
                try {
                    e.a();
                    return str;
                } finally {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable th3) {
                            e.a();
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            fileReader = null;
        }
        return str;
    }

    private static boolean b(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Throwable th) {
            e.a();
            return false;
        }
    }

    private static boolean a(Context context, String str, String str2) {
        try {
            return Settings.System.putString(context.getContentResolver(), str, str2);
        } catch (Throwable th) {
            e.a();
            return false;
        }
    }
}
