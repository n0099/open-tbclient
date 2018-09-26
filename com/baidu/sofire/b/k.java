package com.baidu.sofire.b;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class k {
    private static final String a = new String(c.a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61}));
    private static final String b = new String(c.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));
    private static final String c = a + b;
    private static a d;
    private Context e;

    static /* synthetic */ void a() {
    }

    private k(Context context) {
        this.e = context;
    }

    private String a(String str) {
        try {
            return Settings.System.getString(this.e.getContentResolver(), str);
        } catch (Throwable th) {
            return null;
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
    private static java.lang.String a(java.io.File r7) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3b
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L3b
            r2 = 8192(0x2000, float:1.148E-41)
            char[] r2 = new char[r2]     // Catch: java.lang.Throwable -> L1a
            java.io.CharArrayWriter r3 = new java.io.CharArrayWriter     // Catch: java.lang.Throwable -> L1a
            r3.<init>()     // Catch: java.lang.Throwable -> L1a
        Lf:
            int r4 = r1.read(r2)     // Catch: java.lang.Throwable -> L1a
            if (r4 <= 0) goto L21
            r5 = 0
            r3.write(r2, r5, r4)     // Catch: java.lang.Throwable -> L1a
            goto Lf
        L1a:
            r2 = move-exception
        L1b:
            if (r1 == 0) goto L20
            r1.close()     // Catch: java.lang.Throwable -> L35
        L20:
            return r0
        L21:
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L1a
            r1.close()     // Catch: java.lang.Throwable -> L29
            goto L20
        L29:
            r1 = move-exception
            goto L20
        L2b:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L2f:
            if (r1 == 0) goto L34
            r1.close()     // Catch: java.lang.Throwable -> L37
        L34:
            throw r0
        L35:
            r1 = move-exception
            goto L20
        L37:
            r1 = move-exception
            goto L34
        L39:
            r0 = move-exception
            goto L2f
        L3b:
            r1 = move-exception
            r1 = r0
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.k.a(java.io.File):java.lang.String");
    }

    public static String a(Context context) {
        a b2 = b(context);
        if (b2 != null) {
            return b2.a();
        }
        return null;
    }

    private static a b(Context context) {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new k(context).b();
                }
            }
        }
        return d;
    }

    private a b() {
        boolean z;
        try {
            a a2 = a.a(d(a("com.baidu.deviceid.v2")));
            if (a2 != null) {
                return a2;
            }
            if (this.e.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                a2 = c();
            }
            if (a2 == null) {
                a d2 = d();
                if (d2 == null && z) {
                    return b(c(""));
                }
                return d2;
            }
            return a2;
        } catch (Throwable th) {
            return null;
        }
    }

    private static a c() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if (file.exists()) {
                String a2 = a(file);
                if (!TextUtils.isEmpty(a2)) {
                    try {
                        return a.a(new String(com.baidu.sofire.b.a.a(c, c, c.a(a2.getBytes()))));
                    } catch (Throwable th) {
                    }
                }
            }
        } catch (Throwable th2) {
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
    private static com.baidu.sofire.b.k.a b(java.lang.String r11) {
        /*
            r6 = 0
            r2 = 0
            r0 = 1
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r1 >= r3) goto L14
            r5 = r0
        La:
            if (r5 == 0) goto L16
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 == 0) goto L16
            r0 = r2
        L13:
            return r0
        L14:
            r5 = r6
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
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> Le6
            r4.<init>(r0)     // Catch: java.lang.Throwable -> Le6
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lec
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Lec
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L56
            r0.<init>()     // Catch: java.lang.Throwable -> L56
        L46:
            java.lang.String r7 = r3.readLine()     // Catch: java.lang.Throwable -> L56
            if (r7 == 0) goto L76
            r0.append(r7)     // Catch: java.lang.Throwable -> L56
            java.lang.String r7 = "\r\n"
            r0.append(r7)     // Catch: java.lang.Throwable -> L56
            goto L46
        L56:
            r0 = move-exception
            r0 = r11
        L58:
            if (r3 == 0) goto L5d
            r3.close()     // Catch: java.lang.Throwable -> Lc9
        L5d:
            if (r4 == 0) goto L62
            r4.close()     // Catch: java.lang.Throwable -> Lc9
        L62:
            r10 = r1
            r1 = r0
            r0 = r10
        L65:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto Ldc
            com.baidu.sofire.b.k$a r2 = new com.baidu.sofire.b.k$a
            r2.<init>(r6)
            r2.a = r0
            r2.b = r1
            r0 = r2
            goto L13
        L76:
            r3.close()     // Catch: java.lang.Throwable -> L56
            java.lang.String r7 = new java.lang.String     // Catch: java.lang.Throwable -> L56
            java.lang.String r8 = com.baidu.sofire.b.k.c     // Catch: java.lang.Throwable -> L56
            java.lang.String r9 = com.baidu.sofire.b.k.c     // Catch: java.lang.Throwable -> L56
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L56
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Throwable -> L56
            byte[] r0 = com.baidu.sofire.b.c.a(r0)     // Catch: java.lang.Throwable -> L56
            byte[] r0 = com.baidu.sofire.b.a.a(r8, r9, r0)     // Catch: java.lang.Throwable -> L56
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L56
            java.lang.String r0 = "="
            java.lang.String[] r0 = r7.split(r0)     // Catch: java.lang.Throwable -> L56
            if (r0 == 0) goto Lf1
            int r7 = r0.length     // Catch: java.lang.Throwable -> L56
            r8 = 2
            if (r7 != r8) goto Lf1
            if (r5 == 0) goto Lb8
            r7 = 0
            r7 = r0[r7]     // Catch: java.lang.Throwable -> L56
            boolean r7 = r11.equals(r7)     // Catch: java.lang.Throwable -> L56
            if (r7 == 0) goto Lb8
            r5 = 1
            r1 = r0[r5]     // Catch: java.lang.Throwable -> L56
            r0 = r1
            r1 = r11
        Laf:
            r3.close()     // Catch: java.lang.Throwable -> Lb6
            r4.close()     // Catch: java.lang.Throwable -> Lb6
            goto L65
        Lb6:
            r3 = move-exception
            goto L65
        Lb8:
            if (r5 != 0) goto Lf1
            boolean r5 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L56
            if (r5 == 0) goto Lc3
            r5 = 1
            r11 = r0[r5]     // Catch: java.lang.Throwable -> L56
        Lc3:
            r5 = 1
            r1 = r0[r5]     // Catch: java.lang.Throwable -> L56
            r0 = r1
            r1 = r11
            goto Laf
        Lc9:
            r3 = move-exception
            r10 = r1
            r1 = r0
            r0 = r10
            goto L65
        Lce:
            r0 = move-exception
            r3 = r2
            r4 = r2
        Ld1:
            if (r3 == 0) goto Ld6
            r3.close()     // Catch: java.lang.Throwable -> Ldf
        Ld6:
            if (r4 == 0) goto Ldb
            r4.close()     // Catch: java.lang.Throwable -> Ldf
        Ldb:
            throw r0
        Ldc:
            r0 = r2
            goto L13
        Ldf:
            r1 = move-exception
            goto Ldb
        Le1:
            r0 = move-exception
            r3 = r2
            goto Ld1
        Le4:
            r0 = move-exception
            goto Ld1
        Le6:
            r0 = move-exception
            r3 = r2
            r4 = r2
            r0 = r11
            goto L58
        Lec:
            r0 = move-exception
            r3 = r2
            r0 = r11
            goto L58
        Lf1:
            r0 = r1
            r1 = r11
            goto Laf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.k.b(java.lang.String):com.baidu.sofire.b.k$a");
    }

    private a d() {
        String str;
        try {
            String a2 = a("com.baidu.deviceid");
            String a3 = a("bd_setting_i");
            String c2 = TextUtils.isEmpty(a3) ? c("") : a3;
            if (TextUtils.isEmpty(a2)) {
                String string = Settings.Secure.getString(this.e.getContentResolver(), "android_id");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                str = a(n.b(("com.baidu" + c2 + string).getBytes()));
            } else {
                str = a2;
            }
            if (!TextUtils.isEmpty(str)) {
                a aVar = new a((byte) 0);
                aVar.a = str;
                aVar.b = c2;
                return aVar;
            }
        } catch (Throwable th) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String c(String str) {
        String str2;
        boolean z;
        try {
            if (this.e.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
                z = true;
            } else {
                z = false;
            }
        } catch (Throwable th) {
        }
        if (z) {
            TelephonyManager telephonyManager = (TelephonyManager) this.e.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            if (telephonyManager != null) {
                str2 = telephonyManager.getDeviceId();
                if (str2 != null && str2.contains(":")) {
                    str2 = "";
                }
                return TextUtils.isEmpty(str2) ? str2 : str;
            }
            str2 = null;
            if (str2 != null) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str2)) {
            }
        } else {
            return str;
        }
    }

    private static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.sofire.b.a.a(c, c, c.a(str.getBytes())));
        } catch (Throwable th) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public String a;
        public String b;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
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
                k.a();
                return null;
            }
        }

        public final String a() {
            try {
                String str = this.b;
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                return this.a + "|" + new StringBuffer(str).reverse().toString();
            } catch (Throwable th) {
                k.a();
                return null;
            }
        }
    }
}
