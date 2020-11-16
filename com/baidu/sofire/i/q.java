package com.baidu.sofire.i;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
/* loaded from: classes9.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    private static String f3643a = "";

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
            if (r3 == 0) goto L130
            java.lang.String r0 = d(r6)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L129
            java.lang.String r0 = e(r6)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L123
            java.lang.String r0 = com.baidu.sofire.i.h.e(r6)
            java.lang.String r2 = com.baidu.sofire.i.h.f(r6)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L96
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L96
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "1|"
            r0.<init>(r2)
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = com.baidu.sofire.i.p.a(r2)
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
            r3.c(r2)
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
            if (r1 == 0) goto L95
            if (r0 != 0) goto L8e
            java.lang.String r0 = e(r6)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L95
        L8e:
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lfb
            r3 = 29
            if (r1 < r3) goto Lbc
        L95:
            return r2
        L96:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "0|"
            r3.<init>(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = com.baidu.sofire.i.p.a(r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r0 = r0.toString()
            goto L50
        Lbc:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> Lfb
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> Lfb
            java.lang.String r4 = ".zp"
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lfb
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> Lfb
            java.lang.String r4 = ".icosc"
            r3.<init>(r1, r4)     // Catch: java.lang.Throwable -> Lfb
            boolean r4 = r1.exists()     // Catch: java.lang.Throwable -> Lfb
            if (r4 == 0) goto Lf7
            boolean r4 = r1.isDirectory()     // Catch: java.lang.Throwable -> Lfb
            if (r4 != 0) goto Le2
            r1.delete()     // Catch: java.lang.Throwable -> Lfb
            r1.mkdirs()     // Catch: java.lang.Throwable -> Lfb
        Le2:
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> Lfb
            r4 = 0
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lfb
            r1.write(r2)     // Catch: java.lang.Throwable -> L120
            r1.flush()     // Catch: java.lang.Throwable -> L120
            r1.close()     // Catch: java.lang.Throwable -> Lf2
            goto L95
        Lf2:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L95
        Lf7:
            r1.mkdirs()     // Catch: java.lang.Throwable -> Lfb
            goto Le2
        Lfb:
            r1 = move-exception
        Lfc:
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L11b
            if (r0 == 0) goto L95
            r0.close()     // Catch: java.lang.Throwable -> L105
            goto L95
        L105:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L95
        L10a:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L10e:
            if (r1 == 0) goto L113
            r1.close()     // Catch: java.lang.Throwable -> L114
        L113:
            throw r0
        L114:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L113
        L119:
            r0 = move-exception
            goto L10e
        L11b:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L10e
        L120:
            r0 = move-exception
            r0 = r1
            goto Lfc
        L123:
            r3 = r1
            r5 = r2
            r2 = r0
            r0 = r5
            goto L53
        L129:
            r3 = r1
            r1 = r2
            r5 = r2
            r2 = r0
            r0 = r5
            goto L53
        L130:
            r1 = r2
            r3 = r2
            r5 = r0
            r0 = r2
            r2 = r5
            goto L53
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.i.q.b(android.content.Context):java.lang.String");
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f3643a)) {
            new q();
            f3643a = b(context);
        }
        return f3643a;
    }

    private static String c(Context context) {
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String p = eVar.p();
            if (!TextUtils.isEmpty(p)) {
                return p;
            }
            String string = eVar.b.getString("rpnewuid", "");
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
