package com.baidu.sofire.b;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
/* loaded from: classes2.dex */
public final class q {
    private static String a = "";

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static java.lang.String b(android.content.Context r6) {
        /*
            r1 = 1
            r2 = 0
            java.lang.String r0 = c(r6)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L12a
            java.lang.String r0 = d(r6)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L123
            java.lang.String r0 = e(r6)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L11d
            java.lang.String r0 = com.baidu.sofire.b.h.d(r6)
            java.lang.String r2 = com.baidu.sofire.b.h.e(r6)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto Lc5
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto Lc5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "1|"
            r0.<init>(r2)
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = com.baidu.sofire.b.p.a(r2)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
        L50:
            r2 = r0
            r3 = r1
            r0 = r1
        L53:
            if (r3 != 0) goto L5f
            java.lang.String r3 = c(r6)
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L67
        L5f:
            com.baidu.sofire.e r3 = new com.baidu.sofire.e
            r3.<init>(r6)
            r3.b(r2)
        L67:
            if (r1 != 0) goto L73
            java.lang.String r1 = d(r6)
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L79
        L73:
            java.lang.String r1 = "com.q.zi.i"
            a(r6, r1, r2)
        L79:
            java.lang.String r1 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r1 = b(r6, r1)
            if (r1 == 0) goto Lc4
            if (r0 != 0) goto L8e
            java.lang.String r0 = e(r6)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto Lc4
        L8e:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> Lf0
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r4 = ".zp"
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf0
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r4 = ".icosc"
            r3.<init>(r1, r4)     // Catch: java.lang.Throwable -> Lf0
            boolean r4 = r1.exists()     // Catch: java.lang.Throwable -> Lf0
            if (r4 == 0) goto Lec
            boolean r4 = r1.isDirectory()     // Catch: java.lang.Throwable -> Lf0
            if (r4 != 0) goto Lb5
            r1.delete()     // Catch: java.lang.Throwable -> Lf0
            r1.mkdirs()     // Catch: java.lang.Throwable -> Lf0
        Lb5:
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> Lf0
            r4 = 0
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf0
            r1.write(r2)     // Catch: java.lang.Throwable -> L11a
            r1.flush()     // Catch: java.lang.Throwable -> L11a
            r1.close()     // Catch: java.lang.Throwable -> Lff
        Lc4:
            return r2
        Lc5:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "0|"
            r3.<init>(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = com.baidu.sofire.b.p.a(r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r0 = r0.toString()
            goto L50
        Lec:
            r1.mkdirs()     // Catch: java.lang.Throwable -> Lf0
            goto Lb5
        Lf0:
            r1 = move-exception
        Lf1:
            com.baidu.sofire.b.e.a()     // Catch: java.lang.Throwable -> L115
            if (r0 == 0) goto Lc4
            r0.close()     // Catch: java.lang.Throwable -> Lfa
            goto Lc4
        Lfa:
            r0 = move-exception
            com.baidu.sofire.b.e.a()
            goto Lc4
        Lff:
            r0 = move-exception
            com.baidu.sofire.b.e.a()
            goto Lc4
        L104:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L108:
            if (r1 == 0) goto L10d
            r1.close()     // Catch: java.lang.Throwable -> L10e
        L10d:
            throw r0
        L10e:
            r1 = move-exception
            com.baidu.sofire.b.e.a()
            goto L10d
        L113:
            r0 = move-exception
            goto L108
        L115:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L108
        L11a:
            r0 = move-exception
            r0 = r1
            goto Lf1
        L11d:
            r3 = r1
            r5 = r2
            r2 = r0
            r0 = r5
            goto L53
        L123:
            r3 = r1
            r1 = r2
            r5 = r2
            r2 = r0
            r0 = r5
            goto L53
        L12a:
            r1 = r2
            r3 = r2
            r5 = r0
            r0 = r2
            r2 = r5
            goto L53
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.q.b(android.content.Context):java.lang.String");
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(a)) {
            new q();
            a = b(context);
        }
        return a;
    }

    private static String c(Context context) {
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String o = eVar.o();
            if (!TextUtils.isEmpty(o)) {
                return o;
            }
            String string = eVar.b.getString("rpnewuid", "");
            if (!TextUtils.isEmpty(string)) {
                eVar.b(string);
                return string;
            }
            return "";
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
