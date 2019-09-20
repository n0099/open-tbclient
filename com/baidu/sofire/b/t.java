package com.baidu.sofire.b;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.ByteBuffer;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class t {
    public static String a;
    private static t c;
    private Context b;
    private com.baidu.sofire.g d;

    private t(Context context) {
        this.b = context;
        this.d = new com.baidu.sofire.g(context);
        a = a();
    }

    public static t a(Context context) {
        synchronized (t.class) {
            if (c == null) {
                c = new t(context);
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
            e.a();
            return "";
        }
    }

    public final synchronized String b() {
        String str;
        String str2;
        synchronized (this) {
            try {
                ByteBuffer allocate = ByteBuffer.allocate(78);
                byte[] a2 = u.a(this.b);
                allocate.put(a2);
                String[] g = e.g(this.b);
                if (g != null && g.length == 2 && !TextUtils.isEmpty(g[0]) && !TextUtils.isEmpty(g[1])) {
                    str2 = g[0];
                } else {
                    str2 = "0";
                }
                String str3 = TextUtils.isEmpty(str2) ? "0" : str2;
                byte[] a3 = u.a(Integer.toHexString((int) f.a(str3)));
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
                allocate2.put(u.a(hexString));
                byte[] array = allocate2.array();
                allocate.put(a3);
                allocate.put(array);
                allocate.put(a3);
                allocate.put(array);
                allocate.put(new byte[]{1});
                allocate.put(new byte[]{1});
                allocate.put(u.a(0));
                byte[] a4 = u.a(Integer.MAX_VALUE);
                allocate.put(a4);
                allocate.put(array);
                ByteBuffer allocate3 = ByteBuffer.allocate(44);
                allocate3.put(a2).put(a4).put(a3).put(array);
                byte[] bArr = new byte[16];
                System.arraycopy(p.a(allocate3.array()).getBytes(), 0, bArr, 0, 16);
                allocate.put(bArr);
                byte[] b = a.b(a.getBytes(), allocate.array());
                byte[] bArr2 = new byte[b.length - 4];
                int b2 = this.d.b();
                byte[] a5 = u.a(b2);
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
                allocate5.put(u.a(Integer.parseInt(str3)));
                str = new String(Base64.encode(allocate5.array(), 11));
            } catch (Throwable th) {
                e.a();
                str = "";
            }
        }
        return str;
    }

    public final void a(String str) {
        synchronized (t.class) {
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                String a2 = a(str, "", 1);
                a(a2, currentTimeMillis);
                String a3 = a(a2, "", 2);
                c(a3, currentTimeMillis);
                b(a(a3, "", 3), currentTimeMillis);
            }
        }
    }

    public final synchronized String c() {
        String str;
        str = "";
        try {
            s d = d();
            if (d != null && !TextUtils.isEmpty(d.a)) {
                str = d.a;
            }
        } catch (Throwable th) {
            e.a();
        }
        return str;
    }

    private s d() {
        String str;
        long j;
        long j2;
        long j3 = 0;
        synchronized (t.class) {
            s e = e();
            s f = f();
            s g = g();
            String str2 = "";
            String str3 = "";
            char c2 = 0;
            if (e == null) {
                str = "";
                j = 0;
            } else {
                j = e.b;
                str = e.a;
            }
            if (f != null) {
                j2 = f.b;
                str2 = f.a;
            } else {
                j2 = 0;
            }
            if (g != null) {
                j3 = g.b;
                str3 = g.a;
            }
            if (j2 >= j && j2 >= j3) {
                c2 = 2;
            } else if (j3 >= j && j3 >= j2) {
                c2 = 3;
            } else if (j >= j2 && j >= j3) {
                c2 = 1;
            }
            switch (c2) {
                case 1:
                    if (j > j2) {
                        b(str, j);
                    }
                    if (j > j3) {
                        c(str, j);
                    }
                    return e;
                case 2:
                    if (j2 > j) {
                        a(str2, j2);
                    }
                    if (j2 > j3) {
                        c(str2, j2);
                    }
                    return f;
                case 3:
                    if (j3 > j) {
                        a(str3, j3);
                    }
                    if (j3 > j2) {
                        b(str3, j3);
                    }
                    return g;
                default:
                    return e;
            }
        }
    }

    private s e() {
        try {
            String string = this.d.a.getString("t_d_i_dv2", "");
            long j = this.d.a.getLong("t_d_i_d_tv2", 0L);
            s sVar = new s();
            sVar.a = string;
            sVar.b = j;
            return sVar;
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }

    private void a(String str, long j) {
        try {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.sofire.g gVar = this.d;
                gVar.b.putString("t_d_i_dv2", str);
                gVar.b.commit();
                com.baidu.sofire.g gVar2 = this.d;
                gVar2.b.putLong("t_d_i_d_tv2", j);
                gVar2.b.commit();
            }
        } catch (Throwable th) {
            e.a();
        }
    }

    private s f() {
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
            e.a();
            return null;
        }
    }

    private void b(String str, long j) {
        try {
            if (!TextUtils.isEmpty(str)) {
                byte[] bytes = d(str, j).getBytes();
                byte[] bArr = new byte[bytes.length];
                for (int i = 0; i < bytes.length; i++) {
                    bArr[i] = (byte) (bytes[i] ^ 2);
                }
                byte[] encode = Base64.encode(bArr, 0);
                if (r.a(this.b, new String[]{"android.permission.WRITE_SETTINGS"})) {
                    Settings.System.putString(this.b.getContentResolver(), "setting_tdidv2", new String(encode));
                }
            }
        } catch (Throwable th) {
            e.a();
        }
    }

    private static s g() {
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
            e.a();
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
    private static void c(java.lang.String r7, long r8) {
        /*
            r1 = 0
            r0 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r7)
            if (r2 == 0) goto L9
        L8:
            return
        L9:
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L73
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> L73
            java.lang.String r4 = "backups/.tdidv2"
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L73
            java.io.File r2 = r3.getParentFile()     // Catch: java.lang.Throwable -> L73
            boolean r4 = r2.exists()     // Catch: java.lang.Throwable -> L73
            if (r4 != 0) goto L22
            r2.mkdir()     // Catch: java.lang.Throwable -> L73
        L22:
            boolean r2 = r3.exists()     // Catch: java.lang.Throwable -> L73
            if (r2 != 0) goto L2b
            r3.createNewFile()     // Catch: java.lang.Throwable -> L73
        L2b:
            java.lang.String r2 = d(r7, r8)     // Catch: java.lang.Throwable -> L73
            byte[] r2 = r2.getBytes()     // Catch: java.lang.Throwable -> L73
            int r4 = r2.length     // Catch: java.lang.Throwable -> L73
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L73
        L36:
            int r5 = r2.length     // Catch: java.lang.Throwable -> L73
            if (r1 >= r5) goto L43
            r5 = r2[r1]     // Catch: java.lang.Throwable -> L73
            r5 = r5 ^ 2
            byte r5 = (byte) r5     // Catch: java.lang.Throwable -> L73
            r4[r1] = r5     // Catch: java.lang.Throwable -> L73
            int r1 = r1 + 1
            goto L36
        L43:
            r1 = 0
            byte[] r4 = android.util.Base64.encode(r4, r1)     // Catch: java.lang.Throwable -> L73
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L73
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L73
            java.nio.channels.FileChannel r1 = r2.getChannel()     // Catch: java.lang.Throwable -> Lc4
            java.nio.channels.FileLock r0 = r1.tryLock()     // Catch: java.lang.Throwable -> Lc7
            if (r0 == 0) goto L60
            boolean r3 = r0.isValid()     // Catch: java.lang.Throwable -> Lcc
            if (r3 == 0) goto L60
            r2.write(r4)     // Catch: java.lang.Throwable -> Lcc
        L60:
            if (r0 == 0) goto L65
            r0.release()     // Catch: java.lang.Throwable -> L6e
        L65:
            if (r1 == 0) goto L6a
            r1.close()     // Catch: java.lang.Throwable -> L6e
        L6a:
            r2.close()     // Catch: java.lang.Throwable -> L6e
            goto L8
        L6e:
            r0 = move-exception
            com.baidu.sofire.b.e.a()
            goto L8
        L73:
            r1 = move-exception
            r1 = r0
            r2 = r0
        L76:
            com.baidu.sofire.b.e.a()     // Catch: java.lang.Throwable -> Lbd
            if (r1 == 0) goto L7e
            r1.release()     // Catch: java.lang.Throwable -> L89
        L7e:
            if (r0 == 0) goto L83
            r0.close()     // Catch: java.lang.Throwable -> L89
        L83:
            if (r2 == 0) goto L8
            r2.close()     // Catch: java.lang.Throwable -> L89
            goto L8
        L89:
            r0 = move-exception
            com.baidu.sofire.b.e.a()
            goto L8
        L8f:
            r1 = move-exception
            r2 = r0
            r3 = r0
            r6 = r1
            r1 = r0
            r0 = r6
        L95:
            if (r2 == 0) goto L9a
            r2.release()     // Catch: java.lang.Throwable -> La5
        L9a:
            if (r1 == 0) goto L9f
            r1.close()     // Catch: java.lang.Throwable -> La5
        L9f:
            if (r3 == 0) goto La4
            r3.close()     // Catch: java.lang.Throwable -> La5
        La4:
            throw r0
        La5:
            r1 = move-exception
            com.baidu.sofire.b.e.a()
            goto La4
        Laa:
            r1 = move-exception
            r3 = r2
            r2 = r0
            r6 = r0
            r0 = r1
            r1 = r6
            goto L95
        Lb1:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r0
            r0 = r6
            goto L95
        Lb7:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r0
            r0 = r6
            goto L95
        Lbd:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r6
            goto L95
        Lc4:
            r1 = move-exception
            r1 = r0
            goto L76
        Lc7:
            r3 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L76
        Lcc:
            r3 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L76
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.t.c(java.lang.String, long):void");
    }

    private static s b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("tdid");
            long optLong = jSONObject.optLong("time");
            s sVar = new s();
            sVar.a = optString;
            sVar.b = optLong;
            return sVar;
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }

    private static String d(String str, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tdid", str);
            jSONObject.put("time", j);
            return jSONObject.toString();
        } catch (Throwable th) {
            e.a();
            return "";
        }
    }

    public final String a(String str, int i) {
        String str2;
        try {
            byte[] a2 = a(str, false);
            byte[] bArr = new byte[a2.length - 4];
            byte[] a3 = u.a(i);
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
            String[] g = e.g(this.b);
            if (g != null && g.length == 2 && !TextUtils.isEmpty(g[0]) && !TextUtils.isEmpty(g[1])) {
                str2 = g[0];
            } else {
                str2 = "0";
            }
            allocate2.put(u.a(Integer.parseInt(str2)));
            return new String(Base64.encode(allocate2.array(), 11));
        } catch (Throwable th) {
            e.a();
            return str;
        }
    }

    private String a(String str, String str2, int i) {
        String str3;
        try {
            byte[] a2 = a(str, true);
            if (!TextUtils.isEmpty(str2) && 0 > 0) {
                byte[] a3 = u.a(Integer.toHexString((int) f.a(str2)));
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
                allocate.put(u.a(hexString));
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
            byte[] a4 = u.a(b2);
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
            String[] g = e.g(this.b);
            if (g != null && g.length == 2 && !TextUtils.isEmpty(g[0]) && !TextUtils.isEmpty(g[1])) {
                str3 = g[0];
            } else {
                str3 = "0";
            }
            allocate4.put(u.a(Integer.parseInt(str3)));
            return new String(Base64.encode(allocate4.array(), 11));
        } catch (Throwable th) {
            e.a();
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
            e.a();
            return new byte[0];
        }
    }
}
