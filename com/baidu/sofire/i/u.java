package com.baidu.sofire.i;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import androidx.appcompat.widget.ActivityChooserView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.ByteBuffer;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static String f5283a;
    private static u c;

    /* renamed from: b  reason: collision with root package name */
    private Context f5284b;
    private com.baidu.sofire.g d;

    private u(Context context) {
        this.f5284b = context;
        this.d = new com.baidu.sofire.g(context);
        f5283a = a();
    }

    public static u a(Context context) {
        synchronized (u.class) {
            if (c == null) {
                c = new u(context);
            }
        }
        return c;
    }

    public static String a() {
        try {
            byte[] bytes = "Pnu1RZ`M22vl6bg0".getBytes();
            byte[] bArr = new byte[bytes.length];
            int length = bytes.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                bArr[i2] = (byte) (bytes[i] ^ 3);
                i++;
                i2++;
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
                com.baidu.sofire.j.a.a().a(this.f5284b, null);
                ByteBuffer allocate = ByteBuffer.allocate(78);
                byte[] a2 = v.a(this.f5284b);
                allocate.put(a2);
                String[] g = e.g(this.f5284b);
                if (g != null && g.length == 2 && !TextUtils.isEmpty(g[0]) && !TextUtils.isEmpty(g[1])) {
                    str2 = g[0];
                } else {
                    str2 = "0";
                }
                String str3 = TextUtils.isEmpty(str2) ? "0" : str2;
                byte[] a3 = v.a(Integer.toHexString((int) f.a(str3)));
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
                allocate2.put(v.a(hexString));
                byte[] array = allocate2.array();
                allocate.put(a3);
                allocate.put(array);
                allocate.put(a3);
                allocate.put(array);
                allocate.put(new byte[]{1});
                allocate.put(new byte[]{1});
                allocate.put(v.a(0));
                byte[] a4 = v.a((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                allocate.put(a4);
                allocate.put(array);
                ByteBuffer allocate3 = ByteBuffer.allocate(44);
                allocate3.put(a2).put(a4).put(a3).put(array);
                byte[] bArr = new byte[16];
                System.arraycopy(p.a(allocate3.array()).getBytes(), 0, bArr, 0, 16);
                allocate.put(bArr);
                byte[] b2 = a.b(f5283a.getBytes(), allocate.array());
                byte[] bArr2 = new byte[b2.length - 4];
                int b3 = this.d.b();
                byte[] a5 = v.a(b3);
                bArr2[0] = (byte) (b3 % 128);
                for (int i2 = 1; i2 < bArr2.length; i2++) {
                    bArr2[i2] = (byte) (((bArr2[i2 - 1] * 5) + 7) % 128);
                }
                ByteBuffer allocate4 = ByteBuffer.allocate(bArr2.length + 4);
                allocate4.put(bArr2).put(a5);
                byte[] array2 = allocate4.array();
                byte[] bArr3 = new byte[b2.length];
                for (int i3 = 0; i3 < b2.length; i3++) {
                    bArr3[i3] = (byte) (b2[i3] ^ array2[i3]);
                }
                ByteBuffer allocate5 = ByteBuffer.allocate(bArr3.length + 4 + 4);
                allocate5.put(bArr3);
                allocate5.put(a5);
                byte[] bArr4 = new byte[4];
                allocate5.put(v.a(Integer.parseInt(str3)));
                str = new String(Base64.encode(allocate5.array(), 11));
            } catch (Throwable th) {
                e.a();
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
    public final void a(java.lang.String r11) {
        /*
            r10 = this;
            r1 = 0
            r4 = 0
            java.lang.Class<com.baidu.sofire.i.u> r7 = com.baidu.sofire.i.u.class
            monitor-enter(r7)
            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L6a
            if (r0 == 0) goto Ld
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L70
        Lc:
            return
        Ld:
            long r8 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r0 = ""
            r2 = 1
            java.lang.String r0 = r10.a(r11, r0, r2)     // Catch: java.lang.Throwable -> L6a
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L65
            if (r2 == 0) goto L46
        L1f:
            java.lang.String r2 = ""
            r3 = 2
            java.lang.String r5 = r10.a(r0, r2, r3)     // Catch: java.lang.Throwable -> L6a
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L6a
            if (r0 != 0) goto Lc7
            java.lang.String r0 = b(r5, r8)     // Catch: java.lang.Throwable -> L6a
            byte[] r2 = r0.getBytes()     // Catch: java.lang.Throwable -> L6a
            int r0 = r2.length     // Catch: java.lang.Throwable -> L6a
            byte[] r3 = new byte[r0]     // Catch: java.lang.Throwable -> L6a
            r0 = r4
        L39:
            int r6 = r2.length     // Catch: java.lang.Throwable -> L6a
            if (r0 >= r6) goto L73
            r6 = r2[r0]     // Catch: java.lang.Throwable -> L6a
            r6 = r6 ^ 2
            byte r6 = (byte) r6     // Catch: java.lang.Throwable -> L6a
            r3[r0] = r6     // Catch: java.lang.Throwable -> L6a
            int r0 = r0 + 1
            goto L39
        L46:
            com.baidu.sofire.g r2 = r10.d     // Catch: java.lang.Throwable -> L65
            android.content.SharedPreferences$Editor r3 = r2.f5248b     // Catch: java.lang.Throwable -> L65
            java.lang.String r5 = "t_d_i_dv2"
            r3.putString(r5, r0)     // Catch: java.lang.Throwable -> L65
            android.content.SharedPreferences$Editor r2 = r2.f5248b     // Catch: java.lang.Throwable -> L65
            r2.commit()     // Catch: java.lang.Throwable -> L65
            com.baidu.sofire.g r2 = r10.d     // Catch: java.lang.Throwable -> L65
            android.content.SharedPreferences$Editor r3 = r2.f5248b     // Catch: java.lang.Throwable -> L65
            java.lang.String r5 = "t_d_i_d_tv2"
            r3.putLong(r5, r8)     // Catch: java.lang.Throwable -> L65
            android.content.SharedPreferences$Editor r2 = r2.f5248b     // Catch: java.lang.Throwable -> L65
            r2.commit()     // Catch: java.lang.Throwable -> L65
            goto L1f
        L65:
            r2 = move-exception
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L6a
            goto L1f
        L6a:
            r0 = move-exception
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L70
        L6e:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L70
            goto Lc
        L70:
            r0 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L70
            throw r0
        L73:
            r0 = 0
            byte[] r2 = android.util.Base64.encode(r3, r0)     // Catch: java.lang.Throwable -> L6a
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L6a
            r3 = 28
            if (r0 > r3) goto Lc7
            if (r2 == 0) goto Lc7
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> Le6
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> Le6
            java.lang.String r6 = "backups/.tdidv2"
            r0.<init>(r3, r6)     // Catch: java.lang.Throwable -> Le6
            java.io.File r3 = r0.getParentFile()     // Catch: java.lang.Throwable -> Le6
            boolean r6 = r3.exists()     // Catch: java.lang.Throwable -> Le6
            if (r6 != 0) goto L99
            r3.mkdir()     // Catch: java.lang.Throwable -> Le6
        L99:
            boolean r3 = r0.exists()     // Catch: java.lang.Throwable -> Le6
            if (r3 != 0) goto La2
            r0.createNewFile()     // Catch: java.lang.Throwable -> Le6
        La2:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> Le6
            r3.<init>(r0)     // Catch: java.lang.Throwable -> Le6
            java.nio.channels.FileChannel r0 = r3.getChannel()     // Catch: java.lang.Throwable -> L178
            java.nio.channels.FileLock r1 = r0.tryLock()     // Catch: java.lang.Throwable -> L17d
            if (r1 == 0) goto Lba
            boolean r6 = r1.isValid()     // Catch: java.lang.Throwable -> L181
            if (r6 == 0) goto Lba
            r3.write(r2)     // Catch: java.lang.Throwable -> L181
        Lba:
            if (r1 == 0) goto Lbf
            r1.release()     // Catch: java.lang.Throwable -> Le1
        Lbf:
            if (r0 == 0) goto Lc4
            r0.close()     // Catch: java.lang.Throwable -> Le1
        Lc4:
            r3.close()     // Catch: java.lang.Throwable -> Le1
        Lc7:
            java.lang.String r0 = ""
            r1 = 3
            java.lang.String r1 = r10.a(r5, r0, r1)     // Catch: java.lang.Throwable -> L6a
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L15e
            if (r0 == 0) goto L11c
        Ld5:
            java.lang.String r0 = ""
            r2 = 7
            java.lang.String r0 = r10.a(r1, r0, r2)     // Catch: java.lang.Throwable -> L6a
            r10.a(r0, r8)     // Catch: java.lang.Throwable -> L6a
            goto L6e
        Le1:
            r0 = move-exception
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L6a
            goto Lc7
        Le6:
            r0 = move-exception
            r0 = r1
            r2 = r1
            r3 = r1
        Lea:
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L173
            if (r2 == 0) goto Lf2
            r2.release()     // Catch: java.lang.Throwable -> Lfd
        Lf2:
            if (r0 == 0) goto Lf7
            r0.close()     // Catch: java.lang.Throwable -> Lfd
        Lf7:
            if (r3 == 0) goto Lc7
            r3.close()     // Catch: java.lang.Throwable -> Lfd
            goto Lc7
        Lfd:
            r0 = move-exception
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L6a
            goto Lc7
        L102:
            r0 = move-exception
            r4 = r0
            r5 = r1
            r6 = r1
            r3 = r1
        L107:
            if (r6 == 0) goto L10c
            r6.release()     // Catch: java.lang.Throwable -> L117
        L10c:
            if (r5 == 0) goto L111
            r5.close()     // Catch: java.lang.Throwable -> L117
        L111:
            if (r3 == 0) goto L116
            r3.close()     // Catch: java.lang.Throwable -> L117
        L116:
            throw r4     // Catch: java.lang.Throwable -> L6a
        L117:
            r0 = move-exception
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L6a
            goto L116
        L11c:
            java.lang.String r0 = b(r1, r8)     // Catch: java.lang.Throwable -> L15e
            byte[] r2 = r0.getBytes()     // Catch: java.lang.Throwable -> L15e
            int r0 = r2.length     // Catch: java.lang.Throwable -> L15e
            byte[] r3 = new byte[r0]     // Catch: java.lang.Throwable -> L15e
            r0 = r4
        L128:
            int r4 = r2.length     // Catch: java.lang.Throwable -> L15e
            if (r0 >= r4) goto L135
            r4 = r2[r0]     // Catch: java.lang.Throwable -> L15e
            r4 = r4 ^ 2
            byte r4 = (byte) r4     // Catch: java.lang.Throwable -> L15e
            r3[r0] = r4     // Catch: java.lang.Throwable -> L15e
            int r0 = r0 + 1
            goto L128
        L135:
            r0 = 0
            byte[] r0 = android.util.Base64.encode(r3, r0)     // Catch: java.lang.Throwable -> L15e
            android.content.Context r2 = r10.f5284b     // Catch: java.lang.Throwable -> L15e
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L15e
            r4 = 0
            java.lang.String r5 = "android.permission.WRITE_SETTINGS"
            r3[r4] = r5     // Catch: java.lang.Throwable -> L15e
            boolean r2 = com.baidu.sofire.i.s.a(r2, r3)     // Catch: java.lang.Throwable -> L15e
            if (r2 == 0) goto Ld5
            android.content.Context r2 = r10.f5284b     // Catch: java.lang.Throwable -> L15e
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch: java.lang.Throwable -> L15e
            java.lang.String r3 = "setting_tdidv2"
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> L15e
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L15e
            android.provider.Settings.System.putString(r2, r3, r4)     // Catch: java.lang.Throwable -> L15e
            goto Ld5
        L15e:
            r0 = move-exception
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L6a
            goto Ld5
        L164:
            r0 = move-exception
            r4 = r0
            r5 = r1
            r6 = r1
            goto L107
        L169:
            r2 = move-exception
            r4 = r2
            r5 = r0
            r6 = r1
            goto L107
        L16e:
            r2 = move-exception
            r4 = r2
            r5 = r0
            r6 = r1
            goto L107
        L173:
            r1 = move-exception
            r4 = r1
            r5 = r0
            r6 = r2
            goto L107
        L178:
            r0 = move-exception
            r0 = r1
            r2 = r1
            goto Lea
        L17d:
            r2 = move-exception
            r2 = r1
            goto Lea
        L181:
            r2 = move-exception
            r2 = r1
            goto Lea
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.i.u.a(java.lang.String):void");
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
        t a2;
        String str2;
        String str3 = "";
        try {
            t d = d();
            if (d == null || TextUtils.isEmpty(d.f5281a)) {
                Iterator<ResolveInfo> it = this.f5284b.getPackageManager().queryIntentServices(new Intent("com.baidu.action.SOFIRE.VIEW"), 0).iterator();
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
                            str = a2.f5281a;
                            try {
                                boolean isEmpty = TextUtils.isEmpty(str);
                                if (isEmpty == 0) {
                                    break;
                                }
                                str4 = str;
                            } catch (Throwable th) {
                                e.a();
                                return str;
                            }
                        }
                    }
                    str = str4;
                    str4 = str;
                }
            } else {
                str = d.f5281a;
                str2 = str3;
            }
        } catch (Throwable th2) {
            str = str2;
        }
        return str;
    }

    private t d() {
        t f;
        synchronized (u.class) {
            f = f();
            t g = g();
            t e = e();
            t a2 = a(new File(this.f5284b.getFilesDir() + File.separator + "libtdidv2.so"));
            if (f == null || TextUtils.isEmpty(f.f5281a)) {
                if (g == null || TextUtils.isEmpty(g.f5281a)) {
                    if (e == null || TextUtils.isEmpty(e.f5281a)) {
                        if (a2 == null || TextUtils.isEmpty(a2.f5281a)) {
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

    private t e() {
        try {
            String string = this.d.f5247a.getString("t_d_i_dv2", "");
            long j = this.d.f5247a.getLong("t_d_i_d_tv2", 0L);
            t tVar = new t();
            tVar.f5281a = string;
            tVar.f5282b = j;
            return tVar;
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }

    private t f() {
        try {
            String string = Settings.System.getString(this.f5284b.getContentResolver(), "setting_tdidv2");
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

    private static t g() {
        String str;
        try {
            if (Build.VERSION.SDK_INT <= 28) {
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
                str = sb.toString();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] decode = Base64.decode(str, 0);
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

    private static t a(File file) {
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
            e.a();
            return null;
        }
    }

    private void a(String str, long j) {
        try {
            if (!TextUtils.isEmpty(str)) {
                byte[] bytes = b(str, j).getBytes();
                byte[] bArr = new byte[bytes.length];
                for (int i = 0; i < bytes.length; i++) {
                    bArr[i] = (byte) (bytes[i] ^ 2);
                }
                byte[] encode = Base64.encode(bArr, 0);
                FileOutputStream openFileOutput = this.f5284b.openFileOutput("libtdidv2.so", 1);
                openFileOutput.write(encode);
                openFileOutput.close();
            }
        } catch (Throwable th) {
            e.a();
        }
    }

    private static t b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("tdid");
            long optLong = jSONObject.optLong("time");
            t tVar = new t();
            tVar.f5281a = optString;
            tVar.f5282b = optLong;
            return tVar;
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }

    private static String b(String str, long j) {
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
            byte[] a3 = v.a(i);
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
            String[] g = e.g(this.f5284b);
            if (g != null && g.length == 2 && !TextUtils.isEmpty(g[0]) && !TextUtils.isEmpty(g[1])) {
                str2 = g[0];
            } else {
                str2 = "0";
            }
            allocate2.put(v.a(Integer.parseInt(str2)));
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
                byte[] a3 = v.a(Integer.toHexString((int) f.a(str2)));
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
                allocate.put(v.a(hexString));
                byte[] array = allocate.array();
                ByteBuffer allocate2 = ByteBuffer.allocate(8);
                allocate2.put(a3);
                allocate2.put(array);
                System.arraycopy(allocate2.array(), 0, a2, 40, 8);
            }
            if (i > 0) {
                System.arraycopy(new byte[]{(byte) i}, 0, a2, 48, 1);
            }
            byte[] b2 = a.b(f5283a.getBytes(), a2);
            byte[] bArr = new byte[b2.length - 4];
            int b3 = this.d.b();
            byte[] a4 = v.a(b3);
            bArr[0] = (byte) (b3 % 128);
            for (int i3 = 1; i3 < bArr.length; i3++) {
                bArr[i3] = (byte) (((bArr[i3 - 1] * 5) + 7) % 128);
            }
            ByteBuffer allocate3 = ByteBuffer.allocate(bArr.length + 4);
            allocate3.put(bArr).put(a4);
            byte[] array2 = allocate3.array();
            byte[] bArr2 = new byte[b2.length];
            for (int i4 = 0; i4 < b2.length; i4++) {
                bArr2[i4] = (byte) (b2[i4] ^ array2[i4]);
            }
            ByteBuffer allocate4 = ByteBuffer.allocate(bArr2.length + 4 + 4);
            allocate4.put(bArr2);
            allocate4.put(a4);
            byte[] bArr3 = new byte[4];
            String[] g = e.g(this.f5284b);
            if (g != null && g.length == 2 && !TextUtils.isEmpty(g[0]) && !TextUtils.isEmpty(g[1])) {
                str3 = g[0];
            } else {
                str3 = "0";
            }
            allocate4.put(v.a(Integer.parseInt(str3)));
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
                return a.a(f5283a.getBytes(), bArr4, false);
            }
            return bArr4;
        } catch (Throwable th) {
            e.a();
            return new byte[0];
        }
    }
}
