package com.baidu.sofire.i;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
/* loaded from: classes15.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    private static String f5557a = "";

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
            r3 = 1
            r4 = 0
            java.lang.String r0 = c(r7)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L130
            java.lang.String r0 = d(r7)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L12a
            java.lang.String r0 = e(r7)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L124
            java.lang.String r0 = com.baidu.sofire.i.h.e(r7)
            java.lang.String r1 = com.baidu.sofire.i.h.f(r7)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L97
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L97
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "1|"
            r0.<init>(r1)
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = com.baidu.sofire.i.p.a(r1)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
        L50:
            r2 = r0
            r1 = r3
            r5 = r3
            r6 = r3
        L54:
            if (r6 != 0) goto L60
            java.lang.String r0 = c(r7)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L68
        L60:
            com.baidu.sofire.e r0 = new com.baidu.sofire.e
            r0.<init>(r7)
            r0.c(r2)
        L68:
            if (r5 != 0) goto L74
            java.lang.String r0 = d(r7)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L7a
        L74:
            java.lang.String r0 = "com.q.zi.i"
            a(r7, r0, r2)
        L7a:
            java.lang.String r0 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r0 = b(r7, r0)
            if (r0 == 0) goto L96
            if (r1 != 0) goto L8f
            java.lang.String r0 = e(r7)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L96
        L8f:
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lfc
            r3 = 29
            if (r1 < r3) goto Lbd
        L96:
            return r2
        L97:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "0|"
            r2.<init>(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = com.baidu.sofire.i.p.a(r0)
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            goto L50
        Lbd:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> Lfc
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r4 = ".zp"
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lfc
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r4 = ".icosc"
            r3.<init>(r1, r4)     // Catch: java.lang.Throwable -> Lfc
            boolean r4 = r1.exists()     // Catch: java.lang.Throwable -> Lfc
            if (r4 == 0) goto Lf8
            boolean r4 = r1.isDirectory()     // Catch: java.lang.Throwable -> Lfc
            if (r4 != 0) goto Le3
            r1.delete()     // Catch: java.lang.Throwable -> Lfc
            r1.mkdirs()     // Catch: java.lang.Throwable -> Lfc
        Le3:
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> Lfc
            r4 = 0
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lfc
            r1.write(r2)     // Catch: java.lang.Throwable -> L121
            r1.flush()     // Catch: java.lang.Throwable -> L121
            r1.close()     // Catch: java.lang.Throwable -> Lf3
            goto L96
        Lf3:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L96
        Lf8:
            r1.mkdirs()     // Catch: java.lang.Throwable -> Lfc
            goto Le3
        Lfc:
            r1 = move-exception
        Lfd:
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L11d
            if (r0 == 0) goto L96
            r0.close()     // Catch: java.lang.Throwable -> L106
            goto L96
        L106:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L96
        L10b:
            r1 = move-exception
            r2 = r1
            r3 = r0
        L10e:
            if (r3 == 0) goto L113
            r3.close()     // Catch: java.lang.Throwable -> L114
        L113:
            throw r2
        L114:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L113
        L119:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L10e
        L11d:
            r1 = move-exception
            r2 = r1
            r3 = r0
            goto L10e
        L121:
            r0 = move-exception
            r0 = r1
            goto Lfd
        L124:
            r2 = r0
            r1 = r4
            r5 = r3
            r6 = r3
            goto L54
        L12a:
            r2 = r0
            r1 = r4
            r5 = r4
            r6 = r3
            goto L54
        L130:
            r2 = r0
            r1 = r4
            r5 = r4
            r6 = r4
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.i.q.b(android.content.Context):java.lang.String");
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f5557a)) {
            new q();
            f5557a = b(context);
        }
        return f5557a;
    }

    private static String c(Context context) {
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String p = eVar.p();
            if (!TextUtils.isEmpty(p)) {
                return p;
            }
            String string = eVar.f5521b.getString("rpnewuid", "");
            if (!TextUtils.isEmpty(string)) {
                eVar.c(string);
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
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable th3) {
                            e.a();
                        }
                    }
                    return str;
                } catch (Throwable th4) {
                    FileReader fileReader2 = fileReader;
                    if (fileReader2 != null) {
                        try {
                            fileReader2.close();
                        } catch (Throwable th5) {
                            e.a();
                        }
                    }
                    throw th4;
                }
            }
        } catch (Throwable th6) {
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
