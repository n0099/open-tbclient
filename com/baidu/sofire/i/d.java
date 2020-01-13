package com.baidu.sofire.i;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.res.XmlResourceParser;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Message;
import android.os.Process;
import android.support.media.ExifInterface;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import com.baidu.sofire.MyActivity;
import com.baidu.sofire.MyProvider;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.rp.Report;
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class d {
    public static String b;
    public static String c;
    public static HashMap<Integer, ApkInfo> f;
    public static boolean a = false;
    public static int d = 0;
    public static MyReceiver e = null;
    private static String i = "";
    private static String j = "";
    private static int k = -1;
    private static int l = -1;
    private static int m = -1;
    public static JSONObject g = null;
    public static long h = 0;

    public static void a() {
        com.baidu.sofire.b.d();
    }

    private static PublicKey a(PackageInfo packageInfo, String str) {
        PublicKey publicKey = null;
        if (packageInfo.signatures != null && packageInfo.signatures.length > 0 && packageInfo.signatures[0] != null) {
            try {
                publicKey = c.a(packageInfo.signatures[0]);
            } catch (Throwable th) {
                com.baidu.sofire.b.d();
            }
        }
        if (publicKey == null) {
            return c.a(str);
        }
        return publicKey;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00be -> B:5:0x0016). Please submit an issue!!! */
    public static String a(Class<?> cls) {
        try {
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
        if (cls.getCanonicalName().equals(Integer.TYPE.getCanonicalName())) {
            return Integer.class.getCanonicalName();
        } else if (cls.getCanonicalName().equals(Boolean.TYPE.getCanonicalName())) {
            return Boolean.class.getCanonicalName();
        } else {
            if (cls.getCanonicalName().equals(Character.TYPE.getCanonicalName())) {
                return Character.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Byte.TYPE.getCanonicalName())) {
                return Byte.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Short.TYPE.getCanonicalName())) {
                return Short.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Long.TYPE.getCanonicalName())) {
                return Long.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Float.TYPE.getCanonicalName())) {
                return Float.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Double.TYPE.getCanonicalName())) {
                return Double.class.getCanonicalName();
            }
            return null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x007c -> B:5:0x000e). Please submit an issue!!! */
    public static Class<?> a(String str) {
        try {
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
        if (str.contains(Integer.class.getCanonicalName())) {
            return Integer.TYPE;
        } else if (str.contains(Boolean.class.getCanonicalName())) {
            return Boolean.TYPE;
        } else {
            if (str.contains(Character.class.getCanonicalName())) {
                return Character.TYPE;
            }
            if (str.contains(Byte.class.getCanonicalName())) {
                return Byte.TYPE;
            }
            if (str.contains(Short.class.getCanonicalName())) {
                return Short.TYPE;
            }
            if (str.contains(Long.class.getCanonicalName())) {
                return Long.TYPE;
            }
            if (str.contains(Float.class.getCanonicalName())) {
                return Float.TYPE;
            }
            if (str.contains(Double.class.getCanonicalName())) {
                return Double.TYPE;
            }
            return null;
        }
    }

    public static int a(Context context) {
        try {
            String b2 = b(context);
            if (TextUtils.isEmpty(j)) {
                j = b(Process.myPid());
            }
            return !TextUtils.isEmpty(b2) ? b2.equals(j) ? 1 : 2 : !context.getPackageName().equals(j) ? 2 : 1;
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0086 A[Catch: Throwable -> 0x00c1, TryCatch #0 {Throwable -> 0x00c1, blocks: (B:2:0x0000, B:4:0x0024, B:6:0x002c, B:8:0x0035, B:9:0x003e, B:10:0x0054, B:12:0x0086, B:14:0x008e, B:16:0x0097, B:17:0x00a0, B:18:0x00b5), top: B:23:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String q(Context context) {
        String str;
        String hexString;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(g.b(context)).append(":");
            String hexString2 = Long.toHexString(System.currentTimeMillis() / 1000);
            if (!TextUtils.isEmpty(hexString2)) {
                int length = hexString2.length();
                if (8 - length > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (int i2 = 8 - length; i2 > 0; i2--) {
                        sb2.append("0");
                    }
                    str = sb2.toString() + hexString2;
                    String str2 = g(context)[0];
                    hexString = Long.toHexString(Long.valueOf(str2).longValue());
                    new StringBuilder("time ").append(str).append(" appkey").append(str2);
                    com.baidu.sofire.b.a();
                    if (!TextUtils.isEmpty(hexString)) {
                        int length2 = hexString.length();
                        if (16 - length2 > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            for (int i3 = 16 - length2; i3 > 0; i3--) {
                                sb3.append("0");
                            }
                            hexString = sb3.toString() + hexString;
                        }
                    }
                    sb.append(str).append(hexString);
                    return sb.toString();
                }
            }
            str = hexString2;
            String str22 = g(context)[0];
            hexString = Long.toHexString(Long.valueOf(str22).longValue());
            new StringBuilder("time ").append(str).append(" appkey").append(str22);
            com.baidu.sofire.b.a();
            if (!TextUtils.isEmpty(hexString)) {
            }
            sb.append(str).append(hexString);
            return sb.toString();
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
            return "";
        }
    }

    private static String a(byte[] bArr, int i2) {
        try {
            if (bArr != null) {
                byte[] bytes = Long.toString(System.currentTimeMillis() / 1000).getBytes();
                byte[] bArr2 = new byte[bArr.length + bytes.length + 4];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                System.arraycopy(bytes, 0, bArr2, bArr.length, bytes.length);
                int[] iArr = new int[bArr2.length - 4];
                iArr[0] = i2;
                for (int i3 = 1; i3 < iArr.length; i3++) {
                    iArr[i3] = ((iArr[i3 - 1] * 3) + 1) % 128;
                }
                for (int i4 = 0; i4 < iArr.length; i4++) {
                    bArr2[i4] = (byte) (bArr2[i4] ^ ((byte) iArr[i4]));
                }
                System.arraycopy(new byte[]{(byte) (i2 >>> 24), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)}, 0, bArr2, bArr2.length - 4, 4);
                return Base64.encodeToString(bArr2, 9).replace("\n", "");
            }
            com.baidu.sofire.b.a();
            return "";
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
            return "";
        }
    }

    public static String a(Context context, int i2) {
        try {
            String hexString = Integer.toHexString(i2);
            if (!TextUtils.isEmpty(hexString)) {
                int length = hexString.length();
                if (4 - length > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 4 - length; i3 > 0; i3--) {
                        sb.append("0");
                    }
                    hexString = sb.toString() + hexString;
                }
            }
            byte[] b2 = a.b("30212102dicudiab".getBytes(), (q(context) + hexString).toString().getBytes());
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            int i4 = eVar.a.getInt("tk_sa_pu_cl", 0) + 1;
            eVar.c.putInt("tk_sa_pu_cl", i4);
            eVar.c.commit();
            String a2 = a(b2, i4);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a2);
            sb2.insert(sb2.length() - 2, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
            return sb2.toString().replace("\n", "");
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
            return "";
        }
    }

    public static String b(Context context) {
        try {
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
        if (!TextUtils.isEmpty(i) || l == 1) {
            return i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName()).append(".sofire.ac.provider");
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(sb.toString(), 0);
        if (resolveContentProvider != null && !resolveContentProvider.multiprocess) {
            i = resolveContentProvider.processName;
        }
        l = 1;
        return i;
    }

    public static synchronized boolean a(Context context, boolean z) {
        boolean z2 = true;
        synchronized (d.class) {
            try {
                if (k != -1) {
                    if (k != 1) {
                        z2 = false;
                    }
                } else {
                    String b2 = b(context);
                    if (TextUtils.isEmpty(b2)) {
                        z2 = a(context, context.getPackageName(), true, z);
                    } else {
                        z2 = a(context, b2, false, z);
                    }
                    if (z2) {
                        k = 1;
                    } else {
                        k = 0;
                    }
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.d();
                z2 = false;
            }
        }
        return z2;
    }

    private static boolean a(Context context, String str, boolean z, boolean z2) {
        boolean z3 = false;
        ResolveInfo resolveInfo = null;
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context.getPackageName(), MyService.class.getCanonicalName()));
            resolveInfo = context.getPackageManager().resolveService(intent, 0);
            if (resolveInfo != null) {
                if (str.equals(resolveInfo.serviceInfo.processName)) {
                    z3 = true;
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
        if (resolveInfo == null) {
            try {
                if (str.equals(a(context, str, "service"))) {
                    z3 = true;
                }
            } catch (Throwable th2) {
                com.baidu.sofire.b.d();
            }
        }
        if (TextUtils.isEmpty(j)) {
            j = b(Process.myPid());
        }
        if (z2 && j.equals(str) && (!z3 || z)) {
            HashMap hashMap = new HashMap();
            if (!z3) {
                hashMap.put("0", Integer.toString(2));
            } else if (!z3) {
                hashMap.put("0", Integer.toString(1));
            }
            if (z) {
                hashMap.put("1", "0");
            }
            a(context, "1003140", hashMap);
        }
        return z3;
    }

    public static boolean b(String str) {
        try {
            if (TextUtils.isEmpty(j)) {
                j = b(Process.myPid());
            }
            return !str.equals(j);
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
            return false;
        }
    }

    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            a(new File(str), new File(str2));
        }
    }

    private static String a(Context context, String str, String str2) {
        int next;
        String str3;
        String canonicalName;
        try {
            XmlResourceParser openXmlResourceParser = context.createPackageContext(context.getPackageName(), 3).getAssets().openXmlResourceParser("AndroidManifest.xml");
            if (openXmlResourceParser != null) {
                while (true) {
                    next = openXmlResourceParser.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                    com.baidu.sofire.b.a();
                }
                if (next == 2 && openXmlResourceParser.getName().equals("manifest")) {
                    String attributeValue = openXmlResourceParser.getAttributeValue(null, "package");
                    if (attributeValue == null || attributeValue.length() == 0) {
                        return null;
                    }
                    int length = attributeValue.length();
                    int i2 = 0;
                    boolean z = true;
                    boolean z2 = false;
                    while (true) {
                        if (i2 < length) {
                            char charAt = attributeValue.charAt(i2);
                            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                                z = false;
                            } else if (z || ((charAt < '0' || charAt > '9') && charAt != '_')) {
                                if (charAt != '.') {
                                    str3 = "bad character '" + charAt + "'";
                                    break;
                                }
                                z = true;
                                z2 = true;
                            }
                            i2++;
                        } else {
                            str3 = z2 ? null : "must have at least one '.' separator";
                        }
                    }
                    if (str3 != null && !PraiseDataPassUtil.KEY_FROM_OS.equals(attributeValue)) {
                        return null;
                    }
                    if (str2.equals("provider")) {
                        canonicalName = MyProvider.class.getCanonicalName();
                    } else if (str2.equals("service")) {
                        canonicalName = MyService.class.getCanonicalName();
                    } else {
                        canonicalName = str2.equals(SocialConstants.PARAM_RECEIVER) ? MyReceiver.class.getCanonicalName() : null;
                    }
                    new StringBuilder().append(canonicalName);
                    com.baidu.sofire.b.a();
                    while (true) {
                        int next2 = openXmlResourceParser.next();
                        if (next2 != 1) {
                            switch (next2) {
                                case 2:
                                    String name = openXmlResourceParser.getName();
                                    if ("provider".equals(name)) {
                                        if (!openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name").equals(canonicalName)) {
                                            break;
                                        } else {
                                            String attributeValue2 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "multiprocess");
                                            if (TextUtils.isEmpty(attributeValue2) || !"true".equals(attributeValue2.toLowerCase())) {
                                                String attributeValue3 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "authorities");
                                                if (!TextUtils.isEmpty(attributeValue3) && str.equals(attributeValue3)) {
                                                    String attributeValue4 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "process");
                                                    if (!TextUtils.isEmpty(attributeValue4)) {
                                                        if (attributeValue4.startsWith(":")) {
                                                            return context.getPackageName() + attributeValue4;
                                                        }
                                                        return attributeValue4;
                                                    }
                                                    return context.getPackageName();
                                                }
                                                return null;
                                            }
                                            return null;
                                        }
                                    } else if ("service".equals(name)) {
                                        String attributeValue5 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                                        if (!TextUtils.isEmpty(attributeValue5) && attributeValue5.equals(canonicalName)) {
                                            String attributeValue6 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "process");
                                            if (!TextUtils.isEmpty(attributeValue6)) {
                                                if (attributeValue6.startsWith(":")) {
                                                    return context.getPackageName() + attributeValue6;
                                                }
                                                return attributeValue6;
                                            }
                                            return context.getPackageName();
                                        }
                                    } else if (SocialConstants.PARAM_RECEIVER.equals(name)) {
                                        String attributeValue7 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                                        if (!TextUtils.isEmpty(attributeValue7) && attributeValue7.equals(canonicalName)) {
                                            String attributeValue8 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "process");
                                            if (!TextUtils.isEmpty(attributeValue8)) {
                                                if (attributeValue8.startsWith(":")) {
                                                    return context.getPackageName() + attributeValue8;
                                                }
                                                return attributeValue8;
                                            }
                                            return context.getPackageName();
                                        }
                                    } else {
                                        continue;
                                    }
                                    break;
                            }
                        }
                    }
                }
                return null;
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
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
    public static void a(java.io.File r6, java.io.File r7) {
        /*
            r1 = 0
            if (r6 == 0) goto Lb
            if (r7 == 0) goto Lb
            boolean r0 = a(r6)
            if (r0 != 0) goto Lc
        Lb:
            return
        Lc:
            boolean r0 = r7.exists()
            if (r0 == 0) goto L15
            r7.delete()
        L15:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Lb1
            r2.<init>(r6)     // Catch: java.lang.Throwable -> Lb1
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> Lb5
            r0.<init>(r7)     // Catch: java.lang.Throwable -> Lb5
            r1 = 8192(0x2000, float:1.148E-41)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L2f
        L23:
            int r3 = r2.read(r1)     // Catch: java.lang.Throwable -> L2f
            r4 = -1
            if (r3 == r4) goto L47
            r4 = 0
            r0.write(r1, r4, r3)     // Catch: java.lang.Throwable -> L2f
            goto L23
        L2f:
            r1 = move-exception
            r1 = r2
        L31:
            com.baidu.sofire.b.d()     // Catch: java.lang.Throwable -> Lab
            if (r1 == 0) goto L39
            r1.close()     // Catch: java.lang.Throwable -> L7f
        L39:
            if (r0 == 0) goto Lb
            r0.close()     // Catch: java.lang.Throwable -> L3f
            goto Lb
        L3f:
            r0 = move-exception
            r0.getMessage()
            com.baidu.sofire.b.c()
            goto Lb
        L47:
            r0.flush()     // Catch: java.lang.Throwable -> L2f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2f
            r1.<init>()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r3 = r6.getAbsolutePath()     // Catch: java.lang.Throwable -> L2f
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r3 = " > "
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r3 = r7.getAbsolutePath()     // Catch: java.lang.Throwable -> L2f
            r1.append(r3)     // Catch: java.lang.Throwable -> L2f
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L2f
            r2.close()     // Catch: java.lang.Throwable -> L77
        L6b:
            r0.close()     // Catch: java.lang.Throwable -> L6f
            goto Lb
        L6f:
            r0 = move-exception
            r0.getMessage()
            com.baidu.sofire.b.c()
            goto Lb
        L77:
            r1 = move-exception
            r1.getMessage()
            com.baidu.sofire.b.c()
            goto L6b
        L7f:
            r1 = move-exception
            r1.getMessage()
            com.baidu.sofire.b.c()
            goto L39
        L87:
            r0 = move-exception
            r2 = r1
        L89:
            if (r2 == 0) goto L8e
            r2.close()     // Catch: java.lang.Throwable -> L94
        L8e:
            if (r1 == 0) goto L93
            r1.close()     // Catch: java.lang.Throwable -> L9c
        L93:
            throw r0
        L94:
            r2 = move-exception
            r2.getMessage()
            com.baidu.sofire.b.c()
            goto L8e
        L9c:
            r1 = move-exception
            r1.getMessage()
            com.baidu.sofire.b.c()
            goto L93
        La4:
            r0 = move-exception
            goto L89
        La6:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L89
        Lab:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r0
            r0 = r5
            goto L89
        Lb1:
            r0 = move-exception
            r0 = r1
            goto L31
        Lb5:
            r0 = move-exception
            r0 = r1
            r1 = r2
            goto L31
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.i.d.a(java.io.File, java.io.File):void");
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return a(new File(str));
    }

    public static boolean a(File file) {
        return file != null && file.exists() && file.isFile() && file.canRead() && file.length() > 0;
    }

    public static void d(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        for (File file2 : listFiles) {
                            if (file2.isDirectory()) {
                                d(file2.getAbsolutePath());
                            } else {
                                new StringBuilder().append(file2.getAbsolutePath()).append(" d:").append(file2.delete());
                                com.baidu.sofire.b.a();
                            }
                        }
                    }
                    new StringBuilder().append(file.getAbsolutePath()).append(" d:").append(file.delete());
                    com.baidu.sofire.b.a();
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method;
        if (obj == null || TextUtils.isEmpty(str)) {
            com.baidu.sofire.b.a();
            throw new NoSuchMethodException("object=" + obj + ", methodName=" + str);
        } else if (clsArr != null && objArr != null && clsArr.length != objArr.length) {
            com.baidu.sofire.b.a();
            throw new NoSuchMethodException("paramTypes or args fail");
        } else {
            Method[] declaredMethods = obj.getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i2];
                if (a(method, str, clsArr)) {
                    break;
                }
                i2++;
            }
            if (method == null) {
                com.baidu.sofire.b.a();
                throw new NoSuchMethodException("cannot find method in target methodName=" + str);
            }
            return method.invoke(obj, objArr);
        }
    }

    private static boolean a(Method method, String str, Class<?>[] clsArr) {
        if (str.equals(method.getName())) {
            new StringBuilder().append(str);
            com.baidu.sofire.b.a();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ((parameterTypes == null || parameterTypes.length == 0) && (clsArr == null || clsArr.length == 0)) {
                com.baidu.sofire.b.a();
                return true;
            } else if ((clsArr == null || clsArr.length == 0) && parameterTypes != null && parameterTypes.length > 0) {
                com.baidu.sofire.b.a();
                return false;
            } else if ((parameterTypes == null || parameterTypes.length == 0) && clsArr != null && clsArr.length > 0) {
                com.baidu.sofire.b.a();
                return false;
            } else if (parameterTypes == null || clsArr == null) {
                return false;
            } else {
                if (parameterTypes.length != clsArr.length) {
                    com.baidu.sofire.b.a();
                    return false;
                }
                for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                    if (parameterTypes[i2] != clsArr[i2]) {
                        com.baidu.sofire.b.a();
                        return false;
                    }
                }
                com.baidu.sofire.b.a();
                return true;
            }
        }
        return false;
    }

    public static void a(String str, boolean z) {
        boolean c2 = c("771", str);
        new StringBuilder().append(str).append(",s=").append(c2);
        com.baidu.sofire.b.a();
        if (z) {
            String absolutePath = new File(str).getParentFile().getAbsolutePath();
            c("771", absolutePath);
            new StringBuilder().append(absolutePath).append(",s=").append(c2);
            com.baidu.sofire.b.a();
        }
    }

    private static boolean c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !new File(str2).exists()) {
            return false;
        }
        try {
            Runtime.getRuntime().exec("chmod " + str + HanziToPinyin.Token.SEPARATOR + str2 + "\n").waitFor();
            return true;
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
            return false;
        }
    }

    public static void c(Context context) {
        try {
            Report report = Report.getInstance(context);
            JSONObject jSONObject = new JSONObject();
            com.baidu.sofire.c.a a2 = com.baidu.sofire.c.a.a(context);
            Map<Integer, String> b2 = a2.b();
            jSONObject.put("0", b2.keySet());
            jSONObject.put("1", b2.values());
            new StringBuilder().append(jSONObject.toString());
            com.baidu.sofire.b.a();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("1003003", jSONObject);
            jSONObject2.put("0", jSONObject3);
            Map<Integer, String> c2 = a2.c();
            JSONArray jSONArray = new JSONArray();
            for (String str : c2.values()) {
                jSONArray.put(str);
            }
            jSONArray.put("com.baidu.sofire");
            new StringBuilder().append(jSONArray.toString());
            com.baidu.sofire.b.a();
            jSONObject2.put("2", jSONArray);
            report.w(jSONObject2.toString());
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.sofire.b.c();
        }
    }

    public static void d(Context context) {
        com.baidu.sofire.b.a();
        if (!TextUtils.isEmpty("3.3.9.8.2")) {
            Report report = Report.getInstance(context);
            try {
                c(context);
                report.i("sofire", "com.baidu.sofire", "3.3.9.8.2", "1003003", "1003002");
            } catch (Throwable th) {
                th.getMessage();
                com.baidu.sofire.b.c();
            }
        }
    }

    public static String b() {
        try {
            return new String(F.getInstance().ad(Base64.decode(n.a, 0), "30212102dicudiab".getBytes()));
        } catch (Throwable th) {
            return "";
        }
    }

    private static String g(String str) {
        try {
            int length = str.length();
            int i2 = 0;
            while (i2 < length && (str.charAt(i2) <= ' ' || str.charAt(i2) == 160)) {
                i2++;
            }
            if (i2 > 0) {
                return str.substring(i2);
            }
            return str;
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
            return "";
        }
    }

    public static void a(Context context, String str, Map<String, Object> map) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("0", System.currentTimeMillis());
                jSONObject2.put("1", "");
                jSONObject2.put("2", "");
                String[] g2 = g(context);
                if (g2 != null && g2.length == 2 && !TextUtils.isEmpty(g2[0]) && !TextUtils.isEmpty(g2[1])) {
                    str2 = g2[0];
                } else {
                    str2 = "3";
                }
                jSONObject2.put("3", str2);
                jSONObject2.put("4", 0);
                jSONObject2.put("5", 0);
                jSONObject2.put("6", 1);
                jSONObject2.put("7", 0);
                jSONObject2.put("8", "sofire");
                jSONObject2.put("9", "3.3.9.8.2");
                jSONObject2.put("10", str);
                jSONObject.put("Common_section", jSONObject2);
                if (map.size() > 0) {
                    jSONObject.put("Module_section", new JSONObject(map));
                } else {
                    jSONObject.put("Module_section", new JSONObject());
                }
                Report report = Report.getInstance(context);
                String jSONObject3 = jSONObject.toString();
                new StringBuilder().append(jSONObject3);
                com.baidu.sofire.b.a();
                report.s(jSONObject3);
            } catch (Throwable th) {
                com.baidu.sofire.b.d();
            }
        }
    }

    private static String b(Context context, String str, String str2) {
        String str3 = "";
        try {
            Properties properties = new Properties();
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open(str);
                properties.load(inputStream);
                str3 = properties.getProperty(str2);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.getMessage();
                        com.baidu.sofire.b.c();
                    }
                }
            } catch (IOException e3) {
                e3.getMessage();
                com.baidu.sofire.b.c();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.getMessage();
                        com.baidu.sofire.b.c();
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
        return str3;
    }

    public static boolean e(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && 1 == activeNetworkInfo.getType()) {
            return true;
        }
        return false;
    }

    public static boolean f(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
            return false;
        }
    }

    public static String[] g(Context context) {
        String[] split;
        String[] split2;
        String str = b;
        String str2 = c;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.baidu.sofire.b.a();
            return new String[]{str, str2};
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String b2 = new com.baidu.sofire.e(context).b();
            if (!TextUtils.isEmpty(b2) && (split = b2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != null && split.length == 2) {
                com.baidu.sofire.b.a();
                return split;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String string = new com.baidu.sofire.e(context).a.getString("svi", "");
            if (!TextUtils.isEmpty(string) && (split2 = string.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != null && split2.length == 2) {
                com.baidu.sofire.b.a();
                return split2;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.baidu.sofire.b.a();
            str = "3";
            str2 = "925fc15df8a49bed0b3eca8d2b44cb7b";
        }
        return new String[]{str, str2};
    }

    private static Map<String, Integer> h(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, (Integer) jSONObject.get(next));
            }
            return hashMap;
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
            return null;
        }
    }

    public static void e(String str) {
        Map<String, Integer> map;
        try {
            if (com.baidu.sofire.core.d.b != null) {
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(com.baidu.sofire.core.d.b);
                String string = eVar.a.getString("ses_ic", "");
                if (TextUtils.isEmpty(string)) {
                    map = new HashMap<>();
                    map.put(str, 1);
                } else {
                    Map<String, Integer> h2 = h(string);
                    if (h2 != null && h2.size() > 0) {
                        if (h2.get(str) != null) {
                            h2.put(str, Integer.valueOf(h2.get(str).intValue() + 1));
                            map = h2;
                        } else {
                            h2.put(str, 1);
                        }
                    }
                    map = h2;
                }
                if (map != null && map.size() > 0) {
                    eVar.c.putString("ses_ic", new JSONObject(map).toString());
                    eVar.c.commit();
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
    }

    public static boolean b(Context context, int i2) {
        if (i2 != 1 || e(context)) {
            return true;
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        if (e == null) {
            e = new MyReceiver().a();
        }
        a(context, e, intentFilter);
        a = true;
        return false;
    }

    private static void a(Context context, byte[] bArr) {
        try {
            String[] g2 = g(context);
            if (g2 == null || g2.length != 2 || TextUtils.isEmpty(g2[0]) || TextUtils.isEmpty(g2[1]) || !"200080".equals(g2[0]) || !context.getPackageName().equals("com.baidu.BaiduMap") || bArr == null) {
                return;
            }
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr[i2] = (byte) (bArr[i2] ^ 246);
            }
        } catch (Throwable th) {
        }
    }

    public static void h(Context context) {
        com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = eVar.a.getLong("se_ae_fd", 0L);
        if (j2 == 0) {
            j2 = System.currentTimeMillis();
            eVar.h();
        }
        if (currentTimeMillis - j2 > 86400000) {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.valueOf(eVar.k() + 1));
            eVar.c(0);
            eVar.h();
            a(context, "1003119", hashMap);
            return;
        }
        eVar.c(eVar.k() + 1);
    }

    public static boolean b(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2)) ? false : true;
    }

    public static boolean i(Context context) {
        try {
            if (m < 0 && context != null) {
                Field field = Class.forName(context.getPackageName() + ".BuildConfig").getField("DEBUG");
                field.setAccessible(true);
                m = field.getBoolean(null) ? 1 : 0;
            }
            if (m == 1) {
                return true;
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
        return false;
    }

    public static void j(Context context) throws UnsupportedOperationException {
        if (i(context) && !"com.baidu.input".equals(context.getPackageName())) {
            StringBuilder sb = new StringBuilder("SDK Self Check: ");
            int length = sb.length();
            try {
                System.loadLibrary("fire");
            } catch (Throwable th) {
                sb.append("LoadLibrary Error,");
            }
            try {
                Class.forName("com.baidu.sofire.ac.F").getDeclaredMethod("getInstance", new Class[0]);
            } catch (Exception e2) {
                sb.append("Proguard Error,");
            }
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(context.getPackageName()).append(".sofire.ac.provider");
                boolean z = context.getPackageManager().resolveContentProvider(sb2.toString(), 0).multiprocess;
            } catch (Throwable th2) {
                sb.append("Provider Error,");
            }
            if (!a(context, false)) {
                sb.append("Service or Receiver Error.");
            }
            if ("5".equals("1")) {
                try {
                    context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), MyActivity.class.getCanonicalName()), 0);
                } catch (Throwable th3) {
                    sb.append("Activity error ");
                }
            }
            if (sb.length() > length) {
                throw new UnsupportedOperationException(sb.toString());
            }
        }
    }

    public static int k(Context context) {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
        if (connectivityManager == null) {
            return -1;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
            if (activeNetworkInfo.getType() == 1) {
                return 4;
            }
            if (activeNetworkInfo.getType() == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                        return 1;
                    case 2:
                        return 1;
                    case 3:
                        return 2;
                    case 4:
                        return 1;
                    case 5:
                        return 2;
                    case 6:
                        return 2;
                    case 7:
                        return 1;
                    case 8:
                        return 2;
                    case 9:
                        return 2;
                    case 10:
                        return 2;
                    case 11:
                        return 1;
                    case 12:
                        return 2;
                    case 13:
                        return 3;
                    case 14:
                        return 2;
                    case 15:
                        return 2;
                    default:
                        return 5;
                }
            }
            return -2;
        }
        return -1;
    }

    private static String r(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
            return "1.0.0";
        }
    }

    public static JSONObject l(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = Build.BOARD;
            if (str == null) {
                str = "";
            }
            jSONObject.put("0", str);
            String str2 = Build.DEVICE;
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put("1", str2);
            String b2 = g.b();
            if (b2 == null) {
                b2 = "";
            }
            jSONObject.put("2", b2);
            String str3 = Build.HOST;
            if (str3 == null) {
                str3 = "";
            }
            jSONObject.put("3", str3);
            String a2 = g.a();
            if (a2 == null) {
                a2 = "";
            }
            jSONObject.put("4", a2);
            String str4 = Build.PRODUCT;
            if (str4 == null) {
                str4 = "";
            }
            jSONObject.put("5", str4);
            String str5 = Build.VERSION.CODENAME;
            if (str5 == null) {
                str5 = "";
            }
            jSONObject.put("6", str5);
            String str6 = Build.VERSION.INCREMENTAL;
            if (str6 == null) {
                str6 = "";
            }
            jSONObject.put("7", str6);
            jSONObject.put("8", g.b(context));
            String c2 = g.c();
            if (c2 == null) {
                c2 = "";
            }
            jSONObject.put("9", c2);
            String d2 = g.d();
            if (d2 == null) {
                d2 = "";
            }
            jSONObject.put("10", d2);
            jSONObject.put("11", g.h(context));
            String e2 = g.e();
            if (e2 == null) {
                e2 = "";
            }
            jSONObject.put("12", e2);
            jSONObject.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_JOININ_GROUP, g.c(context));
            jSONObject.put("14", "");
            jSONObject.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_WPA_STATE, g.i(context));
            jSONObject.put("17", g.j(context));
            jSONObject.put("18", g.k(context));
            jSONObject.put("20", Build.VERSION.SDK_INT);
            TimeZone timeZone = TimeZone.getDefault();
            if (timeZone != null) {
                jSONObject.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_QQFAVORITES, timeZone.getID());
            } else {
                jSONObject.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_QQFAVORITES, "-1");
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
        return jSONObject;
    }

    public static JSONObject a(Context context, com.baidu.sofire.d.a aVar, String str, boolean z) {
        return a(context, aVar.a, aVar.c, z ? aVar.d : aVar.e, str);
    }

    public static int m(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            networkInfo = null;
            com.baidu.sofire.b.d();
        }
        if (networkInfo == null) {
            return 0;
        }
        if (1 == networkInfo.getType()) {
            return 2;
        }
        return networkInfo.getType() == 0 ? 1 : 1;
    }

    private static String b(int i2) {
        try {
            String i3 = i(String.format("/proc/%d/cmdline", Integer.valueOf(i2)));
            if (!TextUtils.isEmpty(i3)) {
                return i3.trim();
            }
            return i3;
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
            return null;
        }
    }

    private static String i(String str) {
        FileInputStream fileInputStream;
        String str2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                str2 = a(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (Throwable th) {
                }
            } catch (Throwable th2) {
                try {
                    com.baidu.sofire.b.d();
                    return str2;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th3) {
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            fileInputStream = null;
        }
        return str2;
    }

    private static String a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                if (!z) {
                    sb.append('\n');
                } else {
                    z = false;
                }
                sb.append(readLine);
            } else {
                return sb.toString();
            }
        }
    }

    public static JSONObject a(Context context, JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        long j2;
        String str6;
        JSONObject jSONObject2 = new JSONObject();
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject3 = null;
        try {
            jSONObject3 = jSONObject.getJSONObject("Common_section");
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
        if (jSONObject3 == null) {
            str = "";
            str2 = "";
            str3 = "";
            str4 = "";
            str5 = "";
            j2 = currentTimeMillis;
        } else {
            String optString = jSONObject3.optString("10");
            long optLong = jSONObject3.optLong("0");
            String optString2 = jSONObject3.optString("1");
            String optString3 = jSONObject3.optString("3");
            String optString4 = jSONObject3.optString("8");
            str = jSONObject3.optString("9");
            str2 = optString4;
            str3 = optString3;
            str4 = optString2;
            str5 = optString;
            j2 = optLong;
        }
        try {
            jSONObject2.put("1", context.getApplicationInfo().loadLabel(context.getPackageManager()).toString());
            jSONObject2.put("2", context.getPackageName());
            jSONObject2.put("3", r(context));
            jSONObject2.put("4", g.b(context));
            jSONObject2.put("5", str5);
            jSONObject2.put("6", j2);
            jSONObject2.put("7", str4);
            jSONObject2.put("8", str3);
            jSONObject2.put("9", str2);
            jSONObject2.put("10", str);
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            jSONObject2.put("11", eVar.e.getString("re_a_cv", ""));
            jSONObject2.put("12", eVar.e.getString("re_a_lc", ""));
            jSONObject2.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_JOININ_GROUP, 1);
            if (k(context) == 4) {
                jSONObject2.put("14", 1);
            } else {
                jSONObject2.put("14", 2);
            }
            jSONObject2.put("20", g.d(context));
            jSONObject2.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_QQFAVORITES, g.g(context));
            jSONObject2.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE, g.c(context));
            String n = eVar.n();
            if (TextUtils.isEmpty(n)) {
                String string = eVar.b.getString("xygls", "");
                if (TextUtils.isEmpty(string)) {
                    str6 = k.a(context);
                    if (TextUtils.isEmpty(str6)) {
                        str6 = "";
                    }
                } else {
                    str6 = string;
                }
                if (TextUtils.isEmpty(str6)) {
                    eVar.d.putString("xyglsn", "");
                    eVar.d.commit();
                } else {
                    eVar.d.putString("xyglsn", new String(Base64.encode(a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str6.getBytes("UTF-8")), 10), "UTF-8"));
                    eVar.d.commit();
                }
            } else {
                str6 = n;
            }
            jSONObject2.put("32", str6);
            jSONObject2.put(SoUtils.SO_EVENT_ID_NEW_SO, com.baidu.sofire.rp.a.a(context));
            jSONObject2.put("26", com.baidu.sofire.rp.a.b(context));
            jSONObject2.put(com.tencent.connect.common.Constants.VIA_ACT_TYPE_TWENTY_EIGHT, p.a(context));
            String c2 = s.a(context).c();
            if (TextUtils.isEmpty(c2)) {
                jSONObject2.put("30", "");
            } else {
                jSONObject2.put("30", c2);
            }
            jSONObject2.put(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, DeviceId.getCUID(context));
            Object obj = jSONObject.get("Module_section");
            if (obj instanceof JSONArray) {
                jSONObject2.put("module_section", obj);
            } else {
                jSONObject2.put("module_section", new JSONArray().put(obj));
            }
        } catch (Throwable th2) {
            com.baidu.sofire.b.d();
        }
        return jSONObject2;
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        int indexOf;
        com.baidu.sofire.d.a aVar;
        f.a(context).a();
        f a2 = f.a(context);
        Message message = new Message();
        message.what = 8;
        a2.a.a(message);
        com.baidu.sofire.d.a aVar2 = new com.baidu.sofire.d.a();
        aVar2.a = str;
        aVar2.b = str2;
        aVar2.c = str3;
        aVar2.d = str4;
        aVar2.e = str5;
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            List<com.baidu.sofire.d.a> x = eVar.x();
            if (x == null) {
                eVar.a(aVar2);
            } else if (!x.contains(aVar2)) {
                eVar.a(aVar2);
            } else {
                if (x != null && (indexOf = x.indexOf(aVar2)) != -1 && (aVar = x.get(indexOf)) != null) {
                    eVar.f.putString("re_con", eVar.e.getString("re_con", "").replace(com.baidu.sofire.d.a.a(aVar), com.baidu.sofire.d.a.a(aVar2)));
                    eVar.f.commit();
                }
                f.a(context).b();
                return;
            }
            if (!eVar.e.getBoolean("re_net_ins_" + aVar2.e, false)) {
                f a3 = f.a(context);
                Message message2 = new Message();
                message2.what = 3;
                message2.obj = aVar2;
                a3.a.a(message2);
            }
            f.a(context).b();
            f.a(context).c();
        }
    }

    public static void a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            System.currentTimeMillis();
            eVar.e.getInt("re_net_ty", 2);
            JSONObject optJSONObject = jSONObject.optJSONObject("Common_section");
            long optLong = optJSONObject.optLong("0");
            String optString = optJSONObject.optString("10");
            int optInt = optJSONObject.optInt("5");
            int optInt2 = optJSONObject.optInt("6");
            int optInt3 = optJSONObject.optInt("7");
            int optInt4 = optJSONObject.optInt("11");
            int i2 = optInt2 != 0 ? optInt2 : 1;
            com.baidu.sofire.f.a aVar = new com.baidu.sofire.f.a();
            aVar.d = str;
            aVar.b = optString;
            aVar.g = optInt;
            aVar.c = 3;
            aVar.e = optLong;
            aVar.f = i2;
            aVar.h = optInt3;
            aVar.i = optInt4;
            aVar.j = "";
            f a2 = f.a(context);
            Message message = new Message();
            message.what = 1;
            message.obj = aVar;
            a2.a.a(message);
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
    }

    public static void b(Context context, String str) {
        com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("0");
                if (optJSONObject != null) {
                    String str2 = "";
                    while (optJSONObject.keys().hasNext()) {
                        str2 = String.valueOf(optJSONObject.keys().next());
                        if (!TextUtils.isEmpty(str2)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        eVar.f.putString("al_da" + str2, optJSONObject.optString(str2));
                        eVar.f.commit();
                    }
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.d();
            }
            try {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("1");
                if (optJSONObject2 != null) {
                    String str3 = "";
                    while (optJSONObject2.keys().hasNext()) {
                        str3 = String.valueOf(optJSONObject2.keys().next());
                        if (!TextUtils.isEmpty(str3)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        eVar.f.putString("in_da" + str3, optJSONObject2.optString(str3));
                        eVar.f.commit();
                    }
                }
            } catch (Throwable th2) {
                com.baidu.sofire.b.d();
            }
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("2");
                if (optJSONArray != null) {
                    new StringBuilder().append(optJSONArray.toString());
                    com.baidu.sofire.b.a();
                    eVar.f.putString("li_pk_s", optJSONArray.toString());
                    eVar.f.commit();
                }
            } catch (Throwable th3) {
                com.baidu.sofire.b.d();
            }
        } catch (Throwable th4) {
            com.baidu.sofire.b.d();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v1 int), (r2v1 int), (wrap: int : 0x000f: INVOKE  (r0v1 int A[REMOVE]) = (r0v0 java.util.Calendar), (5 int) type: VIRTUAL call: java.util.Calendar.get(int):int)] */
    public static String c() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2);
        return new StringBuilder().append(i2).append(i3).append(calendar.get(5)).toString();
    }

    public static JSONObject a(Context context, String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "0");
            jSONObject2.put("2", "0");
            String[] g2 = g(context);
            if (g2 != null && g2.length == 2) {
                jSONObject2.put("3", g2[0]);
            } else {
                jSONObject2.put("3", "3");
            }
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put("8", str);
            jSONObject2.put("9", str2);
            jSONObject2.put("10", str3);
            JSONObject jSONObject3 = !TextUtils.isEmpty(str4) ? new JSONObject(str4) : new JSONObject();
            jSONObject.put("Common_section", jSONObject2);
            jSONObject.put("Module_section", jSONObject3);
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
        return jSONObject;
    }

    public static void a(Context context, long j2) {
        if (!"tvshield".equals("sofire")) {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("com.b.r.p");
            intent.setPackage(context.getPackageName());
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, intent, 134217728);
            try {
                alarmManager.cancel(broadcast);
            } catch (Throwable th) {
                com.baidu.sofire.b.d();
            }
            try {
                alarmManager.set(0, System.currentTimeMillis() + j2, broadcast);
            } catch (Throwable th2) {
                com.baidu.sofire.b.d();
            }
        }
    }

    public static String a(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            str = str + hexString.toUpperCase();
        }
        return str;
    }

    public static boolean a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            if ("tvshield".equals("sofire")) {
                return false;
            }
            context.registerReceiver(broadcastReceiver, intentFilter, context.getPackageName() + ".permission.sofire.RECEIVE", null);
            return true;
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
            return false;
        }
    }

    public static void n(Context context) {
        try {
            if (!"tvshield".equals("sofire")) {
                MyReceiver myReceiver = new MyReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.action.SOFIRE.VIEW");
                intentFilter.addCategory("com.baidu.category.SOFIRE");
                intentFilter.addCategory("android.intent.category.DEFAULT");
                context.registerReceiver(myReceiver, intentFilter, context.getPackageName() + ".permission.sofire.RECEIVE", null);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
    }

    public static JSONObject o(Context context) {
        String[] strArr;
        boolean z = false;
        try {
            String str = b() + "p/5/aio";
            com.baidu.sofire.b.a();
            JSONObject jSONObject = new JSONObject();
            JSONArray s = s(context);
            if (s != null) {
                jSONObject.put("0", s);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", Build.MODEL);
            jSONObject2.put("1", g.b(context));
            jSONObject2.put("3", String.valueOf(Build.VERSION.SDK_INT));
            jSONObject2.put("4", "3.3.9.8.2");
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 64);
            if (packageInfo != null) {
                jSONObject2.put("5", g(packageInfo.applicationInfo.loadLabel(packageManager).toString()));
                jSONObject2.put("6", packageName);
                PublicKey a2 = a(packageInfo, packageInfo.applicationInfo.sourceDir);
                if (a2 != null) {
                    byte[] encoded = a2.getEncoded();
                    if (encoded != null) {
                        a(context, encoded);
                        jSONObject2.put("7", o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", "")));
                    } else {
                        jSONObject2.put("7", "");
                    }
                }
                jSONObject2.put("8", packageInfo.versionName);
                jSONObject2.put("9", String.valueOf(new com.baidu.sofire.e(context).a.getInt("opi", 0)));
                jSONObject.put("1", jSONObject2);
                String jSONObject3 = jSONObject.toString();
                new StringBuilder().append(str).append("---").append(jSONObject3);
                com.baidu.sofire.b.a();
                String a3 = h.a(context, str, jSONObject3, true);
                com.baidu.sofire.b.a();
                if (TextUtils.isEmpty(a3)) {
                    return null;
                }
                JSONObject jSONObject4 = new JSONObject(a3);
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
                if (TextUtils.isEmpty(b) || TextUtils.isEmpty(c)) {
                    String b2 = new com.baidu.sofire.e(context).b();
                    if (!TextUtils.isEmpty(b2)) {
                        strArr = b2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        if (strArr == null || strArr.length != 2) {
                            strArr = new String[0];
                        } else {
                            b = strArr[0];
                            c = strArr[1];
                        }
                    } else {
                        strArr = new String[0];
                    }
                } else {
                    strArr = new String[]{b, c};
                }
                if (eVar.a.getInt("appinv_ky", 1) == 1 && (strArr == null || strArr.length != 2 || TextUtils.isEmpty(strArr[0]) || TextUtils.isEmpty(strArr[1]))) {
                    z = true;
                }
                if (z) {
                    JSONObject optJSONObject = jSONObject4.optJSONObject("2");
                    new StringBuilder("c:").append(optJSONObject);
                    com.baidu.sofire.b.a();
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("0");
                        String optString2 = optJSONObject.optString("1");
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            com.baidu.sofire.core.d a4 = com.baidu.sofire.core.d.a(context);
                            try {
                                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && (!"3".equals(optString) || !"925fc15df8a49bed0b3eca8d2b44cb7b".equals(optString2))) {
                                    b = optString;
                                    c = optString2;
                                    com.baidu.sofire.e eVar2 = a4.a;
                                    eVar2.c.putString("svi_n", optString + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString2);
                                    eVar2.c.commit();
                                }
                            } catch (Throwable th) {
                                com.baidu.sofire.b.d();
                            }
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject4.optJSONObject("3");
                new StringBuilder("i:").append(optJSONObject2);
                com.baidu.sofire.b.a();
                JSONObject jSONObject5 = optJSONObject2.getJSONObject("c");
                com.baidu.sofire.e eVar3 = new com.baidu.sofire.e(context);
                int optInt = jSONObject5.optInt("n");
                if (optInt > 0) {
                    eVar3.f.putInt("re_net_ty", optInt);
                    eVar3.f.commit();
                }
                int optInt2 = jSONObject5.optInt("i");
                if (optInt2 > 0) {
                    eVar3.f.putInt("re_net_hr", optInt2);
                    eVar3.f.commit();
                }
                int optInt3 = jSONObject5.optInt("i2");
                if (optInt3 > 0) {
                    eVar3.f.putInt("re_net_hr_bc", optInt3);
                    eVar3.f.commit();
                }
                int optInt4 = jSONObject5.optInt("w");
                if (optInt4 > 0) {
                    eVar3.f.putInt("re_net_wt", optInt4);
                    eVar3.f.commit();
                }
                if (jSONObject5.optInt("s1") > 0) {
                    eVar3.f.putInt("re_net_one_lt", jSONObject5.optInt("s1"));
                    eVar3.f.commit();
                }
                int optInt5 = jSONObject5.optInt(Config.SESSTION_TRACK_START_TIME);
                if (optInt5 > 0) {
                    eVar3.f.putInt("re_net_dy_lt", optInt5);
                    eVar3.f.commit();
                }
                int optInt6 = jSONObject5.optInt("t");
                if (optInt6 > 0) {
                    eVar3.f.putInt("re_net_over", optInt6);
                    eVar3.f.commit();
                }
                int optInt7 = jSONObject5.optInt("l1");
                if (optInt7 > 0) {
                    eVar3.f.putInt("up_nu_co", optInt7);
                    eVar3.f.commit();
                }
                int optInt8 = jSONObject5.optInt("l2");
                if (optInt8 > 0) {
                    eVar3.f.putInt("up_nu_li", optInt8);
                    eVar3.f.commit();
                }
                com.baidu.sofire.e eVar4 = new com.baidu.sofire.e(context);
                try {
                    String optString3 = jSONObject4.optString("0");
                    if (!TextUtils.isEmpty(optString3)) {
                        eVar4.d.putString("gli", new String(Base64.encode(a.a("30212102dicudiab".getBytes(), optString3.getBytes("UTF-8")), 10), "UTF-8"));
                        eVar4.d.commit();
                    }
                } catch (Throwable th2) {
                    com.baidu.sofire.b.d();
                }
                JSONObject optJSONObject3 = jSONObject4.optJSONObject("4");
                new StringBuilder("s:").append(optJSONObject3);
                com.baidu.sofire.b.a();
                if (optJSONObject3 == null) {
                    return jSONObject4;
                }
                int optInt9 = optJSONObject3.optInt("app");
                new StringBuilder("App-").append(Integer.toString(optInt9));
                com.baidu.sofire.b.a();
                eVar4.c.putInt("appinv_t", optInt9);
                eVar4.c.commit();
                int optInt10 = optJSONObject3.optInt("js");
                new StringBuilder("JS-").append(Integer.toString(optInt10));
                com.baidu.sofire.b.a();
                eVar4.c.putInt("appinv_js", optInt10);
                eVar4.c.commit();
                int optInt11 = optJSONObject3.optInt(Config.APP_VERSION_CODE, 1);
                new StringBuilder("get key-").append(Integer.toString(optInt11));
                com.baidu.sofire.b.a();
                eVar4.c.putInt("appinv_ky", optInt11);
                eVar4.c.commit();
                int optInt12 = optJSONObject3.optInt("pi", 360);
                new StringBuilder("net Interval-").append(Integer.toString(optInt12));
                com.baidu.sofire.b.a();
                eVar4.c.putInt("appplg_te", optInt12);
                eVar4.c.commit();
                int optInt13 = optJSONObject3.optInt(Config.FEED_LIST_PART, 1);
                if (optInt13 > 0) {
                    int round = (int) Math.round(24.0d / optInt13);
                    if (round > 0) {
                        eVar4.e(round);
                    } else {
                        eVar4.e(24);
                    }
                }
                int optInt14 = optJSONObject3.optInt("alm", 24);
                if (optInt14 > 0) {
                    eVar4.d(optInt14);
                } else {
                    eVar4.d(24);
                }
                if (optJSONObject3.optInt("0", 0) > 0) {
                    eVar4.c(true);
                } else {
                    eVar4.c(false);
                }
                if (optJSONObject3.optInt("1", -1) != 1) {
                    eVar4.b(false);
                } else {
                    eVar4.a.getBoolean("se_fg_s", false);
                    eVar4.b(true);
                }
                eVar4.c.putInt("appinv_sai", optJSONObject3.optInt("ai", 0));
                eVar4.c.commit();
                return jSONObject4;
            }
            d = 6;
            return null;
        } catch (Throwable th3) {
            com.baidu.sofire.b.d();
            return null;
        }
    }

    private static synchronized JSONArray s(Context context) {
        JSONArray jSONArray;
        synchronized (d.class) {
            try {
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
                if (eVar.t()) {
                    jSONArray = null;
                } else {
                    String b2 = b(context, "sofire_local.cfg", RecentlyVisitedForumModel.LOCAL_ACCOUNT);
                    if (TextUtils.isEmpty(b2)) {
                        jSONArray = null;
                    } else {
                        JSONArray jSONArray2 = new JSONArray(b2);
                        if (f == null) {
                            f = new HashMap<>();
                        } else {
                            f.clear();
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            JSONObject optJSONObject = jSONArray2.optJSONObject(i2);
                            String optString = optJSONObject.optString("pkgname");
                            String optString2 = optJSONObject.optString("version");
                            int optInt = optJSONObject.optInt("id");
                            if (optInt > 0) {
                                arrayList.add(Integer.valueOf(optInt));
                            }
                            String optString3 = optJSONObject.optString("md5");
                            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && optInt > 0) {
                                String lowerCase = optString3.toLowerCase();
                                ApkInfo apkInfo = new ApkInfo();
                                apkInfo.packageName = optString;
                                apkInfo.versionName = optString2;
                                apkInfo.key = optInt;
                                apkInfo.apkMD5 = lowerCase;
                                f.put(Integer.valueOf(optInt), apkInfo);
                            }
                        }
                        eVar.a(arrayList);
                        if (f.size() <= 0) {
                            eVar.s();
                            jSONArray = null;
                        } else {
                            JSONArray jSONArray3 = new JSONArray();
                            for (ApkInfo apkInfo2 : f.values()) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("pk", apkInfo2.packageName);
                                jSONObject.put("m", apkInfo2.apkMD5);
                                jSONObject.put("l", apkInfo2.key);
                                jSONObject.put("v", apkInfo2.versionName);
                                jSONArray3.put(jSONObject);
                            }
                            jSONArray = jSONArray3;
                        }
                    }
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.d();
                jSONArray = null;
            }
        }
        return jSONArray;
    }

    public static String f(String str) {
        String str2;
        try {
            str2 = new String(a.a("30212102dicudiab".getBytes(), Base64.decode(str, 10), true), "UTF-8");
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
        return !TextUtils.isEmpty(str2) ? str2 : "";
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2406=4] */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d() {
        File file;
        BufferedReader bufferedReader;
        if (Build.VERSION.SDK_INT > 22) {
            return Process.is64Bit();
        }
        try {
            file = new File("/proc/" + Process.myPid() + "/maps");
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
            return false;
        }
        if (!file.exists() || file.isDirectory()) {
            return false;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                            return false;
                        } catch (IOException e2) {
                            com.baidu.sofire.b.d();
                            return false;
                        }
                    } else if (readLine.contains("/system/lib64/libc.so")) {
                        try {
                            break;
                        } catch (IOException e3) {
                            com.baidu.sofire.b.d();
                        }
                    }
                } catch (Throwable th2) {
                    com.baidu.sofire.b.d();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            return false;
                        } catch (IOException e4) {
                            com.baidu.sofire.b.d();
                            return false;
                        }
                    }
                    return false;
                }
                com.baidu.sofire.b.d();
                return false;
            }
        } catch (Throwable th3) {
            bufferedReader = null;
        }
        return true;
    }

    public static String p(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        try {
            if (Build.VERSION.SDK_INT >= 21 && (packageManager = context.getPackageManager()) != null && (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0)) != null) {
                Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
                declaredField.setAccessible(true);
                return (String) declaredField.get(applicationInfo);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
        return "";
    }

    public static boolean a(int i2) {
        ApkInfo a2;
        com.baidu.sofire.core.g a3;
        try {
            com.baidu.sofire.c.a aVar = com.baidu.sofire.c.a.d;
            if (aVar == null || (a2 = aVar.a(i2)) == null || a2.initStatus != 1 || (a3 = com.baidu.sofire.core.g.a()) == null) {
                return false;
            }
            return a3.d(a2.packageName) != null;
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
            return false;
        }
    }
}
