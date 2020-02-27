package com.baidu.sofire.i;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.ByteBuffer;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class s {
    public static String a;
    private static s c;
    private Context b;
    private com.baidu.sofire.g d;

    private s(Context context) {
        this.b = context;
        this.d = new com.baidu.sofire.g(context);
        a = a();
    }

    public static s a(Context context) {
        synchronized (s.class) {
            if (c == null) {
                c = new s(context);
            }
        }
        return c;
    }

    public static String a() {
        try {
            byte[] bytes = "Pnu1RZ`M22vl6bg0".getBytes();
            byte[] bArr = new byte[bytes.length];
            int i = 0;
            for (byte b : bytes) {
                bArr[i] = (byte) (b ^ 3);
                i++;
            }
            return new String(bArr);
        } catch (Throwable th) {
            d.a();
            return "";
        }
    }

    public final synchronized String b() {
        String str;
        String str2;
        synchronized (this) {
            try {
                ByteBuffer allocate = ByteBuffer.allocate(78);
                byte[] a2 = t.a(this.b);
                allocate.put(a2);
                String[] g = d.g(this.b);
                if (g != null && g.length == 2 && !TextUtils.isEmpty(g[0]) && !TextUtils.isEmpty(g[1])) {
                    str2 = g[0];
                } else {
                    str2 = "0";
                }
                String str3 = TextUtils.isEmpty(str2) ? "0" : str2;
                byte[] a3 = t.a(Integer.toHexString((int) e.a(str3)));
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                String hexString = Integer.toHexString(currentTimeMillis);
                if (hexString.length() < 8) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i = 0; i < 8 - hexString.length(); i++) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(hexString);
                    hexString = stringBuffer.toString();
                }
                allocate2.put(t.a(hexString));
                byte[] array = allocate2.array();
                allocate.put(a3);
                allocate.put(array);
                allocate.put(a3);
                allocate.put(array);
                allocate.put(new byte[]{1});
                allocate.put(new byte[]{1});
                allocate.put(t.a(0));
                byte[] a4 = t.a(Integer.MAX_VALUE);
                allocate.put(a4);
                allocate.put(array);
                ByteBuffer allocate3 = ByteBuffer.allocate(44);
                allocate3.put(a2).put(a4).put(a3).put(array);
                byte[] bArr = new byte[16];
                System.arraycopy(o.a(allocate3.array()).getBytes(), 0, bArr, 0, 16);
                allocate.put(bArr);
                byte[] b = a.b(a.getBytes(), allocate.array());
                byte[] bArr2 = new byte[b.length - 4];
                int b2 = this.d.b();
                byte[] a5 = t.a(b2);
                bArr2[0] = (byte) (b2 % 128);
                for (int i2 = 1; i2 < bArr2.length; i2++) {
                    bArr2[i2] = (byte) (((bArr2[i2 - 1] * 5) + 7) % 128);
                }
                ByteBuffer allocate4 = ByteBuffer.allocate(bArr2.length + 4);
                allocate4.put(bArr2).put(a5);
                byte[] array2 = allocate4.array();
                byte[] bArr3 = new byte[b.length];
                for (int i3 = 0; i3 < b.length; i3++) {
                    bArr3[i3] = (byte) (b[i3] ^ array2[i3]);
                }
                ByteBuffer allocate5 = ByteBuffer.allocate(bArr3.length + 4 + 4);
                allocate5.put(bArr3);
                allocate5.put(a5);
                byte[] bArr4 = new byte[4];
                allocate5.put(t.a(Integer.parseInt(str3)));
                str = new String(Base64.encode(allocate5.array(), 11));
            } catch (Throwable th) {
                d.a();
                str = "";
            }
        }
        return str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final void a(java.lang.String r12) {
        /*
            r11 = this;
            r1 = 0
            r0 = 0
            java.lang.Class<com.baidu.sofire.i.s> r4 = com.baidu.sofire.i.s.class
            monitor-enter(r4)
            boolean r2 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L8b
            if (r2 == 0) goto Ld
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L92
        Lc:
            return
        Ld:
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L8b
            java.lang.String r2 = ""
            r3 = 1
            java.lang.String r2 = r11.a(r12, r2, r3)     // Catch: java.lang.Throwable -> L8b
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L86
            if (r3 == 0) goto L67
        L1f:
            java.lang.String r3 = ""
            r5 = 2
            java.lang.String r3 = r11.a(r2, r3, r5)     // Catch: java.lang.Throwable -> L8b
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L8b
            if (r2 != 0) goto Lbf
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> Ldb
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> Ldb
            java.lang.String r8 = "backups/.tdidv2"
            r5.<init>(r2, r8)     // Catch: java.lang.Throwable -> Ldb
            java.io.File r2 = r5.getParentFile()     // Catch: java.lang.Throwable -> Ldb
            boolean r8 = r2.exists()     // Catch: java.lang.Throwable -> Ldb
            if (r8 != 0) goto L46
            r2.mkdir()     // Catch: java.lang.Throwable -> Ldb
        L46:
            boolean r2 = r5.exists()     // Catch: java.lang.Throwable -> Ldb
            if (r2 != 0) goto L4f
            r5.createNewFile()     // Catch: java.lang.Throwable -> Ldb
        L4f:
            java.lang.String r2 = c(r3, r6)     // Catch: java.lang.Throwable -> Ldb
            byte[] r2 = r2.getBytes()     // Catch: java.lang.Throwable -> Ldb
            int r8 = r2.length     // Catch: java.lang.Throwable -> Ldb
            byte[] r8 = new byte[r8]     // Catch: java.lang.Throwable -> Ldb
        L5a:
            int r9 = r2.length     // Catch: java.lang.Throwable -> Ldb
            if (r1 >= r9) goto L95
            r9 = r2[r1]     // Catch: java.lang.Throwable -> Ldb
            r9 = r9 ^ 2
            byte r9 = (byte) r9     // Catch: java.lang.Throwable -> Ldb
            r8[r1] = r9     // Catch: java.lang.Throwable -> Ldb
            int r1 = r1 + 1
            goto L5a
        L67:
            com.baidu.sofire.g r3 = r11.d     // Catch: java.lang.Throwable -> L86
            android.content.SharedPreferences$Editor r5 = r3.b     // Catch: java.lang.Throwable -> L86
            java.lang.String r8 = "t_d_i_dv2"
            r5.putString(r8, r2)     // Catch: java.lang.Throwable -> L86
            android.content.SharedPreferences$Editor r3 = r3.b     // Catch: java.lang.Throwable -> L86
            r3.commit()     // Catch: java.lang.Throwable -> L86
            com.baidu.sofire.g r3 = r11.d     // Catch: java.lang.Throwable -> L86
            android.content.SharedPreferences$Editor r5 = r3.b     // Catch: java.lang.Throwable -> L86
            java.lang.String r8 = "t_d_i_d_tv2"
            r5.putLong(r8, r6)     // Catch: java.lang.Throwable -> L86
            android.content.SharedPreferences$Editor r3 = r3.b     // Catch: java.lang.Throwable -> L86
            r3.commit()     // Catch: java.lang.Throwable -> L86
            goto L1f
        L86:
            r3 = move-exception
            com.baidu.sofire.i.d.a()     // Catch: java.lang.Throwable -> L8b
            goto L1f
        L8b:
            r0 = move-exception
            com.baidu.sofire.i.d.a()     // Catch: java.lang.Throwable -> L92
        L8f:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L92
            goto Lc
        L92:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L92
            throw r0
        L95:
            r1 = 0
            byte[] r8 = android.util.Base64.encode(r8, r1)     // Catch: java.lang.Throwable -> Ldb
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> Ldb
            r2.<init>(r5)     // Catch: java.lang.Throwable -> Ldb
            java.nio.channels.FileChannel r1 = r2.getChannel()     // Catch: java.lang.Throwable -> L12b
            java.nio.channels.FileLock r0 = r1.tryLock()     // Catch: java.lang.Throwable -> L12e
            if (r0 == 0) goto Lb2
            boolean r5 = r0.isValid()     // Catch: java.lang.Throwable -> L133
            if (r5 == 0) goto Lb2
            r2.write(r8)     // Catch: java.lang.Throwable -> L133
        Lb2:
            if (r0 == 0) goto Lb7
            r0.release()     // Catch: java.lang.Throwable -> Ld6
        Lb7:
            if (r1 == 0) goto Lbc
            r1.close()     // Catch: java.lang.Throwable -> Ld6
        Lbc:
            r2.close()     // Catch: java.lang.Throwable -> Ld6
        Lbf:
            java.lang.String r0 = ""
            r1 = 3
            java.lang.String r0 = r11.a(r3, r0, r1)     // Catch: java.lang.Throwable -> L8b
            r11.a(r0, r6)     // Catch: java.lang.Throwable -> L8b
            java.lang.String r1 = ""
            r2 = 7
            java.lang.String r0 = r11.a(r0, r1, r2)     // Catch: java.lang.Throwable -> L8b
            r11.b(r0, r6)     // Catch: java.lang.Throwable -> L8b
            goto L8f
        Ld6:
            r0 = move-exception
            com.baidu.sofire.i.d.a()     // Catch: java.lang.Throwable -> L8b
            goto Lbf
        Ldb:
            r1 = move-exception
            r1 = r0
            r2 = r0
        Lde:
            com.baidu.sofire.i.d.a()     // Catch: java.lang.Throwable -> L124
            if (r1 == 0) goto Le6
            r1.release()     // Catch: java.lang.Throwable -> Lf1
        Le6:
            if (r0 == 0) goto Leb
            r0.close()     // Catch: java.lang.Throwable -> Lf1
        Leb:
            if (r2 == 0) goto Lbf
            r2.close()     // Catch: java.lang.Throwable -> Lf1
            goto Lbf
        Lf1:
            r0 = move-exception
            com.baidu.sofire.i.d.a()     // Catch: java.lang.Throwable -> L8b
            goto Lbf
        Lf6:
            r1 = move-exception
            r2 = r0
            r3 = r0
            r10 = r1
            r1 = r0
            r0 = r10
        Lfc:
            if (r2 == 0) goto L101
            r2.release()     // Catch: java.lang.Throwable -> L10c
        L101:
            if (r1 == 0) goto L106
            r1.close()     // Catch: java.lang.Throwable -> L10c
        L106:
            if (r3 == 0) goto L10b
            r3.close()     // Catch: java.lang.Throwable -> L10c
        L10b:
            throw r0     // Catch: java.lang.Throwable -> L8b
        L10c:
            r1 = move-exception
            com.baidu.sofire.i.d.a()     // Catch: java.lang.Throwable -> L8b
            goto L10b
        L111:
            r1 = move-exception
            r3 = r2
            r2 = r0
            r10 = r0
            r0 = r1
            r1 = r10
            goto Lfc
        L118:
            r3 = move-exception
            r10 = r3
            r3 = r2
            r2 = r0
            r0 = r10
            goto Lfc
        L11e:
            r3 = move-exception
            r10 = r3
            r3 = r2
            r2 = r0
            r0 = r10
            goto Lfc
        L124:
            r3 = move-exception
            r10 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r10
            goto Lfc
        L12b:
            r1 = move-exception
            r1 = r0
            goto Lde
        L12e:
            r5 = move-exception
            r10 = r1
            r1 = r0
            r0 = r10
            goto Lde
        L133:
            r5 = move-exception
            r10 = r1
            r1 = r0
            r0 = r10
            goto Lde
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.i.s.a(java.lang.String):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: boolean */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0084, code lost:
        a(r0);
        r1 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized String c() {
        String str;
        r a2;
        String str2;
        String str3 = "";
        try {
            r d = d();
            if (d == null || TextUtils.isEmpty(d.a)) {
                Iterator<ResolveInfo> it = this.b.getPackageManager().queryIntentServices(new Intent("com.baidu.action.SOFIRE.VIEW"), 0).iterator();
                String str4 = str3;
                while (true) {
                    if (!it.hasNext()) {
                        str = str4;
                        str2 = str4;
                        break;
                    }
                    ResolveInfo next = it.next();
                    if (next.serviceInfo != null && next.serviceInfo.applicationInfo != null) {
                        File file = new File(new File(next.serviceInfo.applicationInfo.dataDir + File.separator + com.baidu.fsg.face.base.b.c.g), "libtdidv2.so");
                        if (file.exists() && (a2 = a(file)) != null) {
                            str = a2.a;
                            try {
                                boolean isEmpty = TextUtils.isEmpty(str);
                                if (isEmpty == 0) {
                                    break;
                                }
                                str4 = str;
                            } catch (Throwable th) {
                                d.a();
                                return str;
                            }
                        }
                    }
                    str = str4;
                    str4 = str;
                }
            } else {
                str = d.a;
                str2 = str3;
            }
        } catch (Throwable th2) {
            str = str2;
        }
        return str;
    }

    private r d() {
        r f;
        synchronized (s.class) {
            f = f();
            r g = g();
            r e = e();
            r a2 = a(new File(this.b.getFilesDir() + File.separator + "libtdidv2.so"));
            if (f == null || TextUtils.isEmpty(f.a)) {
                if (g == null || TextUtils.isEmpty(g.a)) {
                    if (e == null || TextUtils.isEmpty(e.a)) {
                        if (a2 == null || TextUtils.isEmpty(a2.a)) {
                            return null;
                        }
                        return a2;
                    }
                    return e;
                }
                return g;
            }
        }
        return f;
    }

    private r e() {
        try {
            String string = this.d.a.getString("t_d_i_dv2", "");
            long j = this.d.a.getLong("t_d_i_d_tv2", 0L);
            r rVar = new r();
            rVar.a = string;
            rVar.b = j;
            return rVar;
        } catch (Throwable th) {
            d.a();
            return null;
        }
    }

    private r f() {
        try {
            String string = Settings.System.getString(this.b.getContentResolver(), "setting_tdidv2");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            byte[] decode = Base64.decode(string, 0);
            byte[] bArr = new byte[decode.length];
            for (int i = 0; i < decode.length; i++) {
                bArr[i] = (byte) (decode[i] ^ 2);
            }
            return b(new String(bArr));
        } catch (Throwable th) {
            d.a();
            return null;
        }
    }

    private void a(String str, long j) {
        try {
            if (!TextUtils.isEmpty(str)) {
                byte[] bytes = c(str, j).getBytes();
                byte[] bArr = new byte[bytes.length];
                for (int i = 0; i < bytes.length; i++) {
                    bArr[i] = (byte) (bytes[i] ^ 2);
                }
                byte[] encode = Base64.encode(bArr, 0);
                if (q.a(this.b, new String[]{"android.permission.WRITE_SETTINGS"})) {
                    Settings.System.putString(this.b.getContentResolver(), "setting_tdidv2", new String(encode));
                }
            }
        } catch (Throwable th) {
            d.a();
        }
    }

    private static r g() {
        try {
            FileReader fileReader = new FileReader(new File(Environment.getExternalStorageDirectory(), "backups/.tdidv2"));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            fileReader.close();
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(sb2)) {
                return null;
            }
            byte[] decode = Base64.decode(sb2, 0);
            byte[] bArr = new byte[decode.length];
            for (int i = 0; i < decode.length; i++) {
                bArr[i] = (byte) (decode[i] ^ 2);
            }
            return b(new String(bArr));
        } catch (Throwable th) {
            d.a();
            return null;
        }
    }

    private static r a(File file) {
        try {
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                bufferedReader.close();
                String sb2 = sb.toString();
                if (TextUtils.isEmpty(sb2)) {
                    return null;
                }
                byte[] decode = Base64.decode(sb2, 0);
                byte[] bArr = new byte[decode.length];
                for (int i = 0; i < decode.length; i++) {
                    bArr[i] = (byte) (decode[i] ^ 2);
                }
                return b(new String(bArr));
            }
            return null;
        } catch (Throwable th) {
            d.a();
            return null;
        }
    }

    private void b(String str, long j) {
        try {
            if (!TextUtils.isEmpty(str)) {
                byte[] bytes = c(str, j).getBytes();
                byte[] bArr = new byte[bytes.length];
                for (int i = 0; i < bytes.length; i++) {
                    bArr[i] = (byte) (bytes[i] ^ 2);
                }
                byte[] encode = Base64.encode(bArr, 0);
                FileOutputStream openFileOutput = this.b.openFileOutput("libtdidv2.so", 1);
                openFileOutput.write(encode);
                openFileOutput.close();
            }
        } catch (Throwable th) {
            d.a();
        }
    }

    private static r b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("tdid");
            long optLong = jSONObject.optLong("time");
            r rVar = new r();
            rVar.a = optString;
            rVar.b = optLong;
            return rVar;
        } catch (Throwable th) {
            d.a();
            return null;
        }
    }

    private static String c(String str, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tdid", str);
            jSONObject.put("time", j);
            return jSONObject.toString();
        } catch (Throwable th) {
            d.a();
            return "";
        }
    }

    public final String a(String str, int i) {
        String str2;
        try {
            byte[] a2 = a(str, false);
            byte[] bArr = new byte[a2.length - 4];
            byte[] a3 = t.a(i);
            bArr[0] = (byte) (i % 128);
            for (int i2 = 1; i2 < bArr.length; i2++) {
                bArr[i2] = (byte) (((bArr[i2 - 1] * 5) + 7) % 128);
            }
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 4);
            allocate.put(bArr).put(a3);
            byte[] array = allocate.array();
            byte[] bArr2 = new byte[a2.length];
            for (int i3 = 0; i3 < a2.length; i3++) {
                bArr2[i3] = (byte) (a2[i3] ^ array[i3]);
            }
            ByteBuffer allocate2 = ByteBuffer.allocate(bArr2.length + 4 + 4);
            allocate2.put(bArr2);
            allocate2.put(a3);
            byte[] bArr3 = new byte[4];
            String[] g = d.g(this.b);
            if (g != null && g.length == 2 && !TextUtils.isEmpty(g[0]) && !TextUtils.isEmpty(g[1])) {
                str2 = g[0];
            } else {
                str2 = "0";
            }
            allocate2.put(t.a(Integer.parseInt(str2)));
            return new String(Base64.encode(allocate2.array(), 11));
        } catch (Throwable th) {
            d.a();
            return str;
        }
    }

    private String a(String str, String str2, int i) {
        String str3;
        try {
            byte[] a2 = a(str, true);
            if (!TextUtils.isEmpty(str2) && 0 > 0) {
                byte[] a3 = t.a(Integer.toHexString((int) e.a(str2)));
                ByteBuffer allocate = ByteBuffer.allocate(4);
                String hexString = Integer.toHexString(0);
                if (hexString.length() < 8) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i2 = 0; i2 < 8 - hexString.length(); i2++) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(hexString);
                    hexString = stringBuffer.toString();
                }
                allocate.put(t.a(hexString));
                byte[] array = allocate.array();
                ByteBuffer allocate2 = ByteBuffer.allocate(8);
                allocate2.put(a3);
                allocate2.put(array);
                System.arraycopy(allocate2.array(), 0, a2, 40, 8);
            }
            if (i > 0) {
                System.arraycopy(new byte[]{(byte) i}, 0, a2, 48, 1);
            }
            byte[] b = a.b(a.getBytes(), a2);
            byte[] bArr = new byte[b.length - 4];
            int b2 = this.d.b();
            byte[] a4 = t.a(b2);
            bArr[0] = (byte) (b2 % 128);
            for (int i3 = 1; i3 < bArr.length; i3++) {
                bArr[i3] = (byte) (((bArr[i3 - 1] * 5) + 7) % 128);
            }
            ByteBuffer allocate3 = ByteBuffer.allocate(bArr.length + 4);
            allocate3.put(bArr).put(a4);
            byte[] array2 = allocate3.array();
            byte[] bArr2 = new byte[b.length];
            for (int i4 = 0; i4 < b.length; i4++) {
                bArr2[i4] = (byte) (b[i4] ^ array2[i4]);
            }
            ByteBuffer allocate4 = ByteBuffer.allocate(bArr2.length + 4 + 4);
            allocate4.put(bArr2);
            allocate4.put(a4);
            byte[] bArr3 = new byte[4];
            String[] g = d.g(this.b);
            if (g != null && g.length == 2 && !TextUtils.isEmpty(g[0]) && !TextUtils.isEmpty(g[1])) {
                str3 = g[0];
            } else {
                str3 = "0";
            }
            allocate4.put(t.a(Integer.parseInt(str3)));
            return new String(Base64.encode(allocate4.array(), 11));
        } catch (Throwable th) {
            d.a();
            return str;
        }
    }

    private static byte[] a(String str, boolean z) {
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] bArr = new byte[4];
            byte[] bArr2 = new byte[(decode.length - 4) - 4];
            System.arraycopy(decode, (decode.length - 4) - 4, bArr, 0, 4);
            System.arraycopy(decode, 0, bArr2, 0, (decode.length - 4) - 4);
            byte[] bArr3 = new byte[(decode.length - 8) - 4];
            int i = 0;
            for (int i2 = 0; i2 < 4; i2++) {
                i += (bArr[i2] & 255) << ((3 - i2) * 8);
            }
            bArr3[0] = (byte) (i % 128);
            for (int i3 = 1; i3 < bArr3.length; i3++) {
                bArr3[i3] = (byte) (((bArr3[i3 - 1] * 5) + 7) % 128);
            }
            ByteBuffer allocate = ByteBuffer.allocate(bArr3.length + 4);
            allocate.put(bArr3).put(bArr);
            byte[] array = allocate.array();
            byte[] bArr4 = new byte[bArr2.length];
            for (int i4 = 0; i4 < bArr2.length; i4++) {
                bArr4[i4] = (byte) (bArr2[i4] ^ array[i4]);
            }
            if (z) {
                return a.a(a.getBytes(), bArr4, false);
            }
            return bArr4;
        } catch (Throwable th) {
            d.a();
            return new byte[0];
        }
    }
}
