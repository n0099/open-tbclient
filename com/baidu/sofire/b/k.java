package com.baidu.sofire.b;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    private static final String a = new String(c.a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61}));
    private static final String b = new String(c.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));
    private static final String c = a + b;
    private static a d;
    private Context e;

    private k(Context context) {
        this.e = context;
    }

    private String a(String str) {
        try {
            return Settings.System.getString(this.e.getContentResolver(), str);
        } catch (Throwable th) {
            b(th);
            return null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [65=4] */
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
            } catch (Throwable th) {
                th = th;
                try {
                    b(th);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable th2) {
                            b(th2);
                        }
                    }
                    return str;
                } finally {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable th3) {
                            b(th3);
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
        }
        return str;
    }

    public static String a(Context context) {
        a c2 = c(context);
        if (c2 != null) {
            return c2.a();
        }
        return null;
    }

    private static a c(Context context) {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new k(context).a();
                }
            }
        }
        return d;
    }

    private a a() {
        Throwable th;
        try {
            a a2 = a.a(e(a("com.baidu.deviceid.v2")));
            if (a2 == null) {
                try {
                    boolean f = f("android.permission.READ_EXTERNAL_STORAGE");
                    if (f) {
                        a2 = b();
                    }
                    if (a2 == null) {
                        a c2 = c();
                        if (c2 == null && f) {
                            return b(c(""));
                        }
                        return c2;
                    }
                    return a2;
                } catch (Throwable th2) {
                    th = th2;
                    b(th);
                    return null;
                }
            }
            return a2;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private a b() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if (file.exists()) {
                String a2 = a(file);
                if (!TextUtils.isEmpty(a2)) {
                    return a.a(new String(com.baidu.sofire.b.a.a(c, c, c.a(a2.getBytes()))));
                }
            }
        } catch (Throwable th) {
            b(th);
        }
        return null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private com.baidu.sofire.b.k.a b(java.lang.String r11) {
        /*
            r10 = this;
            r1 = 0
            r0 = 1
            r2 = 0
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 23
            if (r3 >= r4) goto L14
            r5 = r0
        La:
            if (r5 == 0) goto L16
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 == 0) goto L16
            r0 = r2
        L13:
            return r0
        L14:
            r5 = r1
            goto La
        L16:
            java.lang.String r1 = ""
            java.io.File r0 = new java.io.File
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r4 = "baidu/.cuid"
            r0.<init>(r3, r4)
            boolean r3 = r0.exists()
            if (r3 != 0) goto L37
            java.io.File r0 = new java.io.File
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r4 = "backups/.SystemConfig/.cuid"
            r0.<init>(r3, r4)
        L37:
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> Lfd
            r4.<init>(r0)     // Catch: java.lang.Throwable -> Lfd
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L104
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L104
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L56
            r0.<init>()     // Catch: java.lang.Throwable -> L56
        L46:
            java.lang.String r6 = r3.readLine()     // Catch: java.lang.Throwable -> L56
            if (r6 == 0) goto L7c
            r0.append(r6)     // Catch: java.lang.Throwable -> L56
            java.lang.String r6 = "\r\n"
            r0.append(r6)     // Catch: java.lang.Throwable -> L56
            goto L46
        L56:
            r0 = move-exception
            r5 = r4
            r4 = r3
            r3 = r0
            r0 = r11
        L5b:
            b(r3)     // Catch: java.lang.Throwable -> Lf9
            if (r4 == 0) goto L63
            r4.close()     // Catch: java.lang.Throwable -> Ld6
        L63:
            if (r5 == 0) goto L68
            r5.close()     // Catch: java.lang.Throwable -> Ld6
        L68:
            r9 = r1
            r1 = r0
            r0 = r9
        L6b:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto Lf1
            com.baidu.sofire.b.k$a r3 = new com.baidu.sofire.b.k$a
            r3.<init>()
            r3.a = r0
            r3.b = r1
            r0 = r3
            goto L13
        L7c:
            r3.close()     // Catch: java.lang.Throwable -> L56
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Throwable -> L56
            java.lang.String r7 = com.baidu.sofire.b.k.c     // Catch: java.lang.Throwable -> L56
            java.lang.String r8 = com.baidu.sofire.b.k.c     // Catch: java.lang.Throwable -> L56
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L56
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Throwable -> L56
            byte[] r0 = com.baidu.sofire.b.c.a(r0)     // Catch: java.lang.Throwable -> L56
            byte[] r0 = com.baidu.sofire.b.a.a(r7, r8, r0)     // Catch: java.lang.Throwable -> L56
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L56
            java.lang.String r0 = "="
            java.lang.String[] r0 = r6.split(r0)     // Catch: java.lang.Throwable -> L56
            if (r0 == 0) goto L10b
            int r6 = r0.length     // Catch: java.lang.Throwable -> L56
            r7 = 2
            if (r6 != r7) goto L10b
            if (r5 == 0) goto Lc5
            r6 = 0
            r6 = r0[r6]     // Catch: java.lang.Throwable -> L56
            boolean r6 = r11.equals(r6)     // Catch: java.lang.Throwable -> L56
            if (r6 == 0) goto Lc5
            r5 = 1
            r1 = r0[r5]     // Catch: java.lang.Throwable -> L56
            r0 = r1
            r1 = r11
        Lb5:
            if (r3 == 0) goto Lba
            r3.close()     // Catch: java.lang.Throwable -> Lc0
        Lba:
            if (r4 == 0) goto L6b
            r4.close()     // Catch: java.lang.Throwable -> Lc0
            goto L6b
        Lc0:
            r3 = move-exception
            b(r3)
            goto L6b
        Lc5:
            if (r5 != 0) goto L10b
            boolean r5 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L56
            if (r5 == 0) goto Ld0
            r5 = 1
            r11 = r0[r5]     // Catch: java.lang.Throwable -> L56
        Ld0:
            r5 = 1
            r1 = r0[r5]     // Catch: java.lang.Throwable -> L56
            r0 = r1
            r1 = r11
            goto Lb5
        Ld6:
            r3 = move-exception
            b(r3)
            r9 = r1
            r1 = r0
            r0 = r9
            goto L6b
        Lde:
            r0 = move-exception
            r3 = r2
            r4 = r2
        Le1:
            if (r3 == 0) goto Le6
            r3.close()     // Catch: java.lang.Throwable -> Lec
        Le6:
            if (r4 == 0) goto Leb
            r4.close()     // Catch: java.lang.Throwable -> Lec
        Leb:
            throw r0
        Lec:
            r1 = move-exception
            b(r1)
            goto Leb
        Lf1:
            r0 = r2
            goto L13
        Lf4:
            r0 = move-exception
            r3 = r2
            goto Le1
        Lf7:
            r0 = move-exception
            goto Le1
        Lf9:
            r0 = move-exception
            r3 = r4
            r4 = r5
            goto Le1
        Lfd:
            r0 = move-exception
            r3 = r0
            r4 = r2
            r5 = r2
            r0 = r11
            goto L5b
        L104:
            r0 = move-exception
            r3 = r0
            r5 = r4
            r4 = r2
            r0 = r11
            goto L5b
        L10b:
            r0 = r1
            r1 = r11
            goto Lb5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.k.b(java.lang.String):com.baidu.sofire.b.k$a");
    }

    private a c() {
        try {
            String a2 = a("com.baidu.deviceid");
            String a3 = a("bd_setting_i");
            String c2 = TextUtils.isEmpty(a3) ? c("") : a3;
            String a4 = TextUtils.isEmpty(a2) ? a(o.a(("com.baidu" + c2 + b(this.e)).getBytes(), true)) : a2;
            if (!TextUtils.isEmpty(a4)) {
                a aVar = new a();
                aVar.a = a4;
                aVar.b = c2;
                return aVar;
            }
        } catch (Throwable th) {
            b(th);
        }
        return null;
    }

    private boolean d() {
        return f("android.permission.READ_PHONE_STATE");
    }

    public static String b(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String c(String str) {
        String str2;
        try {
        } catch (Throwable th) {
            b(th);
        }
        if (d()) {
            TelephonyManager telephonyManager = (TelephonyManager) this.e.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            if (telephonyManager != null) {
                str2 = telephonyManager.getDeviceId();
                String d2 = d(str2);
                return TextUtils.isEmpty(d2) ? d2 : str;
            }
            str2 = null;
            String d22 = d(str2);
            if (TextUtils.isEmpty(d22)) {
            }
        } else {
            return str;
        }
    }

    private static String d(String str) {
        if (str != null && str.contains(":")) {
            return "";
        }
        return str;
    }

    private static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.sofire.b.a.a(c, c, c.a(str.getBytes())));
        } catch (Throwable th) {
            b(th);
            return "";
        }
    }

    private boolean f(String str) {
        return this.e.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public String a;
        public String b;

        private a() {
        }

        public static a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("deviceid");
                String string2 = jSONObject.getString("imei");
                if (TextUtils.isEmpty(string) || string2 == null) {
                    return null;
                }
                a aVar = new a();
                aVar.a = string;
                aVar.b = string2;
                return aVar;
            } catch (Throwable th) {
                k.b(th);
                return null;
            }
        }

        public String a() {
            try {
                String str = this.b;
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                return this.a + "|" + new StringBuffer(str).reverse().toString();
            } catch (Throwable th) {
                k.b(th);
                return null;
            }
        }
    }
}
