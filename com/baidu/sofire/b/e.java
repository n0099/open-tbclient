package com.baidu.sofire.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.content.res.XmlResourceParser;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Message;
import android.os.Process;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.sofire.MyProvider;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.rp.Report;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class e {
    public static String b;
    public static String c;
    public static boolean a = false;
    public static MyReceiver d = null;
    private static String f = "";
    private static String g = "";
    private static int h = -1;
    private static int i = -1;
    private static int j = -1;
    public static Map<String, String> e = new HashMap();

    public static void a() {
        com.baidu.sofire.b.d();
    }

    public static PublicKey a(PackageInfo packageInfo, String str) {
        PublicKey publicKey = null;
        if (packageInfo.signatures != null && packageInfo.signatures.length > 0 && packageInfo.signatures[0] != null) {
            try {
                publicKey = d.a(packageInfo.signatures[0]);
            } catch (Throwable th) {
                com.baidu.sofire.b.d();
            }
        }
        if (publicKey == null) {
            return d.a(str);
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

    public static void a(String str, String str2) {
        b = str;
        c = str2;
    }

    public static boolean a(Context context) {
        String b2;
        try {
            b2 = b(context);
            if (TextUtils.isEmpty(g)) {
                g = b(Process.myPid());
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
        if (!TextUtils.isEmpty(b2)) {
            return b2.equals(g);
        }
        if (context.getPackageName().equals(g)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0086 A[Catch: Throwable -> 0x00c1, TryCatch #0 {Throwable -> 0x00c1, blocks: (B:2:0x0000, B:4:0x0024, B:6:0x002c, B:8:0x0035, B:9:0x003e, B:10:0x0054, B:12:0x0086, B:14:0x008e, B:16:0x0097, B:17:0x00a0, B:18:0x00b5), top: B:23:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String p(Context context) {
        String str;
        String hexString;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(g.a(context)).append(":");
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
            byte[] b2 = a.b("30212102dicudiab".getBytes(), (p(context) + hexString).toString().getBytes());
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            int i4 = eVar.a.getInt("tk_sa_pu_cl", 0) + 1;
            eVar.c.putInt("tk_sa_pu_cl", i4);
            eVar.c.commit();
            String a2 = a(b2, i4);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a2);
            sb2.insert(sb2.length() - 2, "A");
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
        if (!TextUtils.isEmpty(f) || j == 1) {
            return f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName()).append(".sofire.ac.provider");
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(sb.toString(), 0);
        if (resolveContentProvider != null && !resolveContentProvider.multiprocess) {
            f = resolveContentProvider.processName;
        }
        if (resolveContentProvider == null) {
            String b2 = b(context, sb.toString(), MyProvider.class.getCanonicalName());
            if (!TextUtils.isEmpty(b2)) {
                f = b2;
            }
        }
        j = 1;
        return f;
    }

    public static synchronized boolean a(Context context, boolean z) {
        boolean z2 = true;
        synchronized (e.class) {
            try {
                if (h != -1) {
                    if (h != 1) {
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
                        h = 1;
                    } else {
                        h = 0;
                    }
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.d();
                z2 = false;
            }
        }
        return z2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:1|(2:2|3)|(3:53|54|(15:56|6|7|8|(2:10|(10:12|13|(2:15|(6:17|18|(1:20)|(4:27|(1:(1:35)(1:(1:37)))(1:30)|(1:32)|33)|38|39))(7:(2:45|(1:47))|42|18|(0)|(6:22|27|(0)|(0)(0)|(0)|33)|38|39)|41|42|18|(0)|(0)|38|39))|51|13|(0)(0)|41|42|18|(0)|(0)|38|39))|5|6|7|8|(0)|51|13|(0)(0)|41|42|18|(0)|(0)|38|39|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d5, code lost:
        r9 = r3;
        r3 = r0;
        r0 = r9;
        com.baidu.sofire.b.d();
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0054 A[Catch: Throwable -> 0x00bd, TRY_LEAVE, TryCatch #0 {Throwable -> 0x00bd, blocks: (B:9:0x0032, B:11:0x0054), top: B:55:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005f A[Catch: Throwable -> 0x00d4, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Throwable -> 0x00d4, blocks: (B:15:0x005f, B:42:0x00c2), top: B:58:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(Context context, String str, boolean z, boolean z2) {
        ResolveInfo resolveInfo;
        boolean z3;
        ResolveInfo resolveInfo2;
        boolean z4;
        boolean z5;
        boolean z6;
        ResolveInfo resolveService;
        boolean z7;
        ActivityInfo activityInfo = null;
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context.getPackageName(), MyService.class.getCanonicalName()));
            resolveService = context.getPackageManager().resolveService(intent, 0);
        } catch (Throwable th) {
            resolveInfo = null;
        }
        if (resolveService != null) {
            try {
            } catch (Throwable th2) {
                resolveInfo = resolveService;
                z3 = false;
                resolveInfo2 = resolveInfo;
                Intent intent2 = new Intent();
                ComponentName componentName = new ComponentName(context.getPackageName(), MyReceiver.class.getCanonicalName());
                intent2.setComponent(componentName);
                activityInfo = context.getPackageManager().getReceiverInfo(componentName, 0);
                if (activityInfo != null) {
                }
                z4 = false;
                if (resolveInfo2 != null) {
                }
                boolean z8 = z3;
                z5 = z4;
                z6 = z8;
                if (TextUtils.isEmpty(g)) {
                }
                if (z2) {
                }
                return z6 & z5;
            }
            if (str.equals(resolveService.serviceInfo.processName)) {
                z7 = true;
                resolveInfo2 = resolveService;
                z3 = z7;
                Intent intent22 = new Intent();
                ComponentName componentName2 = new ComponentName(context.getPackageName(), MyReceiver.class.getCanonicalName());
                intent22.setComponent(componentName2);
                activityInfo = context.getPackageManager().getReceiverInfo(componentName2, 0);
                if (activityInfo != null) {
                    if (str.equals(activityInfo.processName)) {
                        z4 = true;
                        if (resolveInfo2 != null) {
                            if (str.equals(b(context, str, NotificationCompat.CATEGORY_SERVICE))) {
                                z5 = z4;
                                z6 = true;
                                if (TextUtils.isEmpty(g)) {
                                    g = b(Process.myPid());
                                }
                                if (z2 && g.equals(str) && (!z5 || !z6 || z)) {
                                    HashMap hashMap = new HashMap();
                                    if (z5 && !z6) {
                                        hashMap.put("0", Integer.toString(2));
                                    } else if (z6) {
                                        hashMap.put("0", Integer.toString(1));
                                    } else if (!z5) {
                                        hashMap.put("0", Integer.toString(0));
                                    }
                                    if (z) {
                                        hashMap.put("1", "0");
                                    }
                                    a(context, "1003140", hashMap);
                                }
                                return z6 & z5;
                            }
                        } else {
                            if (activityInfo == null) {
                                if (str.equals(b(context, str, SocialConstants.PARAM_RECEIVER))) {
                                    z4 = true;
                                }
                            }
                            boolean z82 = z3;
                            z5 = z4;
                            z6 = z82;
                            if (TextUtils.isEmpty(g)) {
                            }
                            if (z2) {
                                HashMap hashMap2 = new HashMap();
                                if (z5) {
                                }
                                if (z6) {
                                }
                                if (z) {
                                }
                                a(context, "1003140", hashMap2);
                            }
                            return z6 & z5;
                        }
                        boolean z822 = z3;
                        z5 = z4;
                        z6 = z822;
                        if (TextUtils.isEmpty(g)) {
                        }
                        if (z2) {
                        }
                        return z6 & z5;
                    }
                }
                z4 = false;
                if (resolveInfo2 != null) {
                }
                boolean z8222 = z3;
                z5 = z4;
                z6 = z8222;
                if (TextUtils.isEmpty(g)) {
                }
                if (z2) {
                }
                return z6 & z5;
            }
        }
        z7 = false;
        resolveInfo2 = resolveService;
        z3 = z7;
        Intent intent222 = new Intent();
        ComponentName componentName22 = new ComponentName(context.getPackageName(), MyReceiver.class.getCanonicalName());
        intent222.setComponent(componentName22);
        activityInfo = context.getPackageManager().getReceiverInfo(componentName22, 0);
        if (activityInfo != null) {
        }
        z4 = false;
        if (resolveInfo2 != null) {
        }
        boolean z82222 = z3;
        z5 = z4;
        z6 = z82222;
        if (TextUtils.isEmpty(g)) {
        }
        if (z2) {
        }
        return z6 & z5;
    }

    public static boolean b(String str) {
        try {
            if (TextUtils.isEmpty(g)) {
                g = b(Process.myPid());
            }
            return !str.equals(g);
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
            return false;
        }
    }

    private static String b(Context context, String str, String str2) {
        int next;
        String str3;
        String canonicalName;
        try {
            String str4 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            XmlResourceParser openXmlResourceParser = assetManager.openXmlResourceParser(((Integer) AssetManager.class.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager, str4)).intValue(), "AndroidManifest.xml");
            if (openXmlResourceParser != null) {
                do {
                    next = openXmlResourceParser.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
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
                    if (str3 != null && !"android".equals(attributeValue)) {
                        return null;
                    }
                    if (str2.equals("provider")) {
                        canonicalName = MyProvider.class.getCanonicalName();
                    } else if (str2.equals(NotificationCompat.CATEGORY_SERVICE)) {
                        canonicalName = MyService.class.getCanonicalName();
                    } else {
                        canonicalName = str2.equals(SocialConstants.PARAM_RECEIVER) ? MyReceiver.class.getCanonicalName() : null;
                    }
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
                                    } else if (NotificationCompat.CATEGORY_SERVICE.equals(name)) {
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

    public static void b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            a(new File(str), new File(str2));
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
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Lb4
            r2.<init>(r6)     // Catch: java.lang.Throwable -> Lb4
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> Lb8
            r0.<init>(r7)     // Catch: java.lang.Throwable -> Lb8
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
            com.baidu.sofire.b.d()     // Catch: java.lang.Throwable -> Lae
            if (r1 == 0) goto L39
            r1.close()     // Catch: java.lang.Throwable -> L82
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
            java.lang.String r3 = "copyFile Suc, srcFile="
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r3 = r6.getAbsolutePath()     // Catch: java.lang.Throwable -> L2f
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r3 = " > "
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r3 = r7.getAbsolutePath()     // Catch: java.lang.Throwable -> L2f
            r1.append(r3)     // Catch: java.lang.Throwable -> L2f
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L2f
            r2.close()     // Catch: java.lang.Throwable -> L7a
        L6e:
            r0.close()     // Catch: java.lang.Throwable -> L72
            goto Lb
        L72:
            r0 = move-exception
            r0.getMessage()
            com.baidu.sofire.b.c()
            goto Lb
        L7a:
            r1 = move-exception
            r1.getMessage()
            com.baidu.sofire.b.c()
            goto L6e
        L82:
            r1 = move-exception
            r1.getMessage()
            com.baidu.sofire.b.c()
            goto L39
        L8a:
            r0 = move-exception
            r2 = r1
        L8c:
            if (r2 == 0) goto L91
            r2.close()     // Catch: java.lang.Throwable -> L97
        L91:
            if (r1 == 0) goto L96
            r1.close()     // Catch: java.lang.Throwable -> L9f
        L96:
            throw r0
        L97:
            r2 = move-exception
            r2.getMessage()
            com.baidu.sofire.b.c()
            goto L91
        L9f:
            r1 = move-exception
            r1.getMessage()
            com.baidu.sofire.b.c()
            goto L96
        La7:
            r0 = move-exception
            goto L8c
        La9:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L8c
        Lae:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r0
            r0 = r5
            goto L8c
        Lb4:
            r0 = move-exception
            r0 = r1
            goto L31
        Lb8:
            r0 = move-exception
            r0 = r1
            r1 = r2
            goto L31
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.e.a(java.io.File, java.io.File):void");
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

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
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
            } else if (parameterTypes.length != clsArr.length) {
                com.baidu.sofire.b.a();
                return false;
            } else {
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
        boolean d2 = d("771", str);
        new StringBuilder().append(str).append(",s=").append(d2);
        com.baidu.sofire.b.a();
        if (z) {
            String absolutePath = new File(str).getParentFile().getAbsolutePath();
            d("771", absolutePath);
            new StringBuilder().append(absolutePath).append(",s=").append(d2);
            com.baidu.sofire.b.a();
        }
    }

    private static boolean d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !new File(str2).exists()) {
            return false;
        }
        try {
            Runtime.getRuntime().exec("chmod " + str + " " + str2 + "\n").waitFor();
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
            com.baidu.sofire.a.a a2 = com.baidu.sofire.a.a.a(context);
            Map<Integer, String> b2 = a2.b();
            jSONObject.put("0", b2.keySet());
            jSONObject.put("1", b2.values());
            new StringBuilder("getAliveData ").append(jSONObject.toString());
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
            new StringBuilder("setAliveData = ").append(jSONArray.toString());
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
        if (!TextUtils.isEmpty("3.1.9.3")) {
            Report report = Report.getInstance(context);
            try {
                c(context);
                report.i("sofire", "com.baidu.sofire", "3.1.9.3", "1003003", "1003002");
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

    public static String e(String str) {
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
                jSONObject2.put(Constants.VIA_SHARE_TYPE_INFO, 1);
                jSONObject2.put("7", 0);
                jSONObject2.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, "sofire");
                jSONObject2.put("9", "3.1.9.3");
                jSONObject2.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, str);
                jSONObject.put("Common_section", jSONObject2);
                if (map != null && map.size() > 0) {
                    jSONObject.put("Module_section", new JSONObject(map));
                } else {
                    jSONObject.put("Module_section", new JSONObject());
                }
                Report report = Report.getInstance(context);
                String jSONObject3 = jSONObject.toString();
                com.baidu.sofire.b.a();
                report.s(jSONObject3);
            } catch (Throwable th) {
                com.baidu.sofire.b.d();
            }
        }
    }

    public static String a(Context context, String str, String str2) {
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
            if (!TextUtils.isEmpty(b2) && (split = b2.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != null && split.length == 2) {
                com.baidu.sofire.b.a();
                return split;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String string = new com.baidu.sofire.e(context).a.getString("svi", "");
            if (!TextUtils.isEmpty(string) && (split2 = string.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != null && split2.length == 2) {
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

    public static String[] h(Context context) {
        if (TextUtils.isEmpty(b) || TextUtils.isEmpty(c)) {
            String b2 = new com.baidu.sofire.e(context).b();
            if (!TextUtils.isEmpty(b2)) {
                String[] split = b2.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split == null || split.length != 2) {
                    return new String[2];
                }
                b = split[0];
                c = split[1];
                return split;
            }
            return null;
        }
        return new String[]{b, c};
    }

    private static Map<String, Integer> g(String str) {
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

    public static void f(String str) {
        Map<String, Integer> map;
        try {
            if (com.baidu.sofire.core.d.b != null) {
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(com.baidu.sofire.core.d.b);
                String string = eVar.a.getString("ses_ic", "");
                if (TextUtils.isEmpty(string)) {
                    map = new HashMap<>();
                    map.put(str, 1);
                } else {
                    Map<String, Integer> g2 = g(string);
                    if (g2 != null && g2.size() > 0) {
                        if (g2.get(str) != null) {
                            g2.put(str, Integer.valueOf(g2.get(str).intValue() + 1));
                            map = g2;
                        } else {
                            g2.put(str, 1);
                        }
                    }
                    map = g2;
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
        if (d == null) {
            d = new MyReceiver().a();
        }
        context.getApplicationContext().registerReceiver(d, intentFilter);
        a = true;
        return false;
    }

    public static void i(Context context) {
        PublicKey a2;
        byte[] encoded;
        boolean z = false;
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String d2 = eVar.d();
            long e2 = eVar.e();
            if (!TextUtils.isEmpty(d2) || e2 != 0) {
                String packageName = context.getPackageName();
                JSONArray jSONArray = new JSONArray(d2);
                String str = "";
                String str2 = "";
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);
                if (packageInfo != null && (a2 = a(packageInfo, (str2 = packageInfo.applicationInfo.sourceDir))) != null && (encoded = a2.getEncoded()) != null) {
                    a(context, encoded);
                    str = o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                    com.baidu.sofire.b.a();
                }
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    String optString = optJSONObject.optString("p");
                    String optString2 = optJSONObject.optString("s");
                    if (packageName.equals(optString) && !TextUtils.isEmpty(str) && str.equalsIgnoreCase(optString2)) {
                        z = true;
                    }
                }
                com.baidu.sofire.b.a();
                eVar.c.putBoolean("hac", z);
                eVar.c.commit();
                if (!z) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", packageName);
                    hashMap.put("1", str);
                    if (!TextUtils.isEmpty(str2)) {
                        File file = new File(str2);
                        if (file.exists()) {
                            hashMap.put("2", o.a(file));
                        } else {
                            hashMap.put("2", "");
                        }
                    } else {
                        hashMap.put("2", "");
                    }
                    a(context.getApplicationContext(), "1003120", hashMap);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
    }

    public static boolean a(Context context, String str) {
        PublicKey a2;
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String d2 = eVar.d();
            long e2 = eVar.e();
            if (TextUtils.isEmpty(d2) && e2 == 0) {
                return false;
            }
            JSONArray jSONArray = new JSONArray(d2);
            String str2 = "";
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null && (a2 = a(packageInfo, packageInfo.applicationInfo.sourceDir)) != null) {
                byte[] encoded = a2.getEncoded();
                if (encoded != null) {
                    a(context, encoded);
                    str2 = o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                    com.baidu.sofire.b.a();
                }
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    String optString = optJSONObject.optString("p");
                    String optString2 = optJSONObject.optString("s");
                    if (str.equals(optString) && !TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(optString2)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
            return true;
        }
    }

    public static void a(Context context, byte[] bArr) {
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

    public static void j(Context context) {
        com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = eVar.a.getLong("se_ae_fd", 0L);
        if (j2 == 0) {
            j2 = System.currentTimeMillis();
            eVar.j();
        }
        if (currentTimeMillis - j2 > 86400000) {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.valueOf(eVar.m() + 1));
            eVar.c(0);
            eVar.j();
            a(context, "1003119", hashMap);
            return;
        }
        eVar.c(eVar.m() + 1);
    }

    public static boolean c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            for (int i2 = 0; i2 < split.length && i2 < split2.length; i2++) {
                int intValue = Integer.valueOf(split[i2]).intValue() - Integer.valueOf(split2[i2]).intValue();
                if (intValue != 0) {
                    return intValue > 0;
                }
            }
            return split.length > split2.length;
        } catch (Throwable th) {
            return false;
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

    private static String q(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
            return "1.0.0";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x011b A[Catch: Throwable -> 0x0153, TryCatch #0 {Throwable -> 0x0153, blocks: (B:3:0x0005, B:6:0x000f, B:9:0x001c, B:11:0x0024, B:15:0x002e, B:18:0x003b, B:21:0x0048, B:24:0x0055, B:27:0x0062, B:30:0x006f, B:33:0x0086, B:36:0x0093, B:39:0x00aa, B:41:0x00cd, B:43:0x00d6, B:51:0x012b, B:46:0x00e2, B:48:0x011b, B:58:0x0149, B:54:0x0138), top: B:62:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0149 A[Catch: Throwable -> 0x0153, TRY_LEAVE, TryCatch #0 {Throwable -> 0x0153, blocks: (B:3:0x0005, B:6:0x000f, B:9:0x001c, B:11:0x0024, B:15:0x002e, B:18:0x003b, B:21:0x0048, B:24:0x0055, B:27:0x0062, B:30:0x006f, B:33:0x0086, B:36:0x0093, B:39:0x00aa, B:41:0x00cd, B:43:0x00d6, B:51:0x012b, B:46:0x00e2, B:48:0x011b, B:58:0x0149, B:54:0x0138), top: B:62:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject l(Context context) {
        String str;
        String h2;
        String str2;
        TimeZone timeZone;
        JSONObject jSONObject = new JSONObject();
        try {
            String str3 = Build.BOARD;
            if (str3 == null) {
                str3 = "";
            }
            jSONObject.put("0", str3);
            String str4 = Build.DEVICE;
            if (str4 == null) {
                str4 = "";
            }
            jSONObject.put("1", str4);
            if (Build.VERSION.SDK_INT > 7) {
                str = Build.HARDWARE;
            } else {
                str = "";
            }
            if (str == null) {
                str = "";
            }
            jSONObject.put("2", str);
            String str5 = Build.HOST;
            if (str5 == null) {
                str5 = "";
            }
            jSONObject.put("3", str5);
            String str6 = Build.DISPLAY;
            if (str6 == null) {
                str6 = "";
            }
            jSONObject.put("4", str6);
            String str7 = Build.PRODUCT;
            if (str7 == null) {
                str7 = "";
            }
            jSONObject.put("5", str7);
            String str8 = Build.VERSION.CODENAME;
            if (str8 == null) {
                str8 = "";
            }
            jSONObject.put(Constants.VIA_SHARE_TYPE_INFO, str8);
            String str9 = Build.VERSION.INCREMENTAL;
            if (str9 == null) {
                str9 = "";
            }
            jSONObject.put("7", str9);
            jSONObject.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, g.a(context));
            String str10 = Build.MANUFACTURER;
            if (str10 == null) {
                str10 = "";
            }
            jSONObject.put("9", str10);
            String str11 = Build.MODEL;
            if (str11 == null) {
                str11 = "";
            }
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, str11);
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, g.g(context));
            String str12 = Build.VERSION.RELEASE;
            if (str12 == null) {
                str12 = "";
            }
            jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, str12);
            jSONObject.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, g.b(context));
            jSONObject.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "");
            h2 = g.h(context);
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
        if (!TextUtils.isEmpty(h2)) {
            if (h2.startsWith("46000") || h2.startsWith("46002")) {
                str2 = "1";
            } else if (h2.startsWith("46001")) {
                str2 = "2";
            } else if (h2.startsWith("46003")) {
                str2 = "3";
            }
            jSONObject.put(Constants.VIA_REPORT_TYPE_WPA_STATE, str2);
            jSONObject.put(Constants.VIA_REPORT_TYPE_START_WAP, g.i(context));
            jSONObject.put(Constants.VIA_REPORT_TYPE_START_GROUP, g.j(context));
            jSONObject.put("18", g.k(context));
            jSONObject.put(Constants.VIA_ACT_TYPE_NINETEEN, g.l(context));
            jSONObject.put("20", Build.VERSION.SDK_INT);
            timeZone = TimeZone.getDefault();
            if (timeZone == null) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, timeZone.getID());
            } else {
                jSONObject.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, LivenessStat.TYPE_STRING_DEFAULT);
            }
            return jSONObject;
        }
        str2 = "";
        jSONObject.put(Constants.VIA_REPORT_TYPE_WPA_STATE, str2);
        jSONObject.put(Constants.VIA_REPORT_TYPE_START_WAP, g.i(context));
        jSONObject.put(Constants.VIA_REPORT_TYPE_START_GROUP, g.j(context));
        jSONObject.put("18", g.k(context));
        jSONObject.put(Constants.VIA_ACT_TYPE_NINETEEN, g.l(context));
        jSONObject.put("20", Build.VERSION.SDK_INT);
        timeZone = TimeZone.getDefault();
        if (timeZone == null) {
        }
        return jSONObject;
    }

    public static JSONObject a(Context context, com.baidu.sofire.rp.a.a aVar, String str, boolean z) {
        return a(context, aVar.a, aVar.c, z ? aVar.d : aVar.e, str);
    }

    public static int m(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            new StringBuilder("sj-trigger info ").append(th.toString());
            com.baidu.sofire.b.a();
            networkInfo = null;
            com.baidu.sofire.b.d();
        }
        if (networkInfo == null) {
            com.baidu.sofire.b.a();
            return 0;
        } else if (1 == networkInfo.getType()) {
            return 2;
        } else {
            return networkInfo.getType() == 0 ? 1 : 1;
        }
    }

    private static String b(int i2) {
        try {
            String h2 = h(String.format("/proc/%d/cmdline", Integer.valueOf(i2)));
            if (!TextUtils.isEmpty(h2)) {
                return h2.trim();
            }
            return h2;
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
            return null;
        }
    }

    private static String h(String str) {
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

    private static String a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, HTTP.UTF_8));
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
        JSONObject jSONObject2 = new JSONObject();
        System.currentTimeMillis();
        JSONObject jSONObject3 = null;
        try {
            jSONObject3 = jSONObject.getJSONObject("Common_section");
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
        String optString = jSONObject3.optString(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        long optLong = jSONObject3.optLong("0");
        String optString2 = jSONObject3.optString("1");
        String optString3 = jSONObject3.optString("3");
        String optString4 = jSONObject3.optString(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO);
        String optString5 = jSONObject3.optString("9");
        try {
            jSONObject2.put("1", context.getApplicationInfo().loadLabel(context.getPackageManager()).toString());
            jSONObject2.put("2", context.getPackageName());
            jSONObject2.put("3", q(context));
            jSONObject2.put("4", g.a(context));
            jSONObject2.put("5", optString);
            jSONObject2.put(Constants.VIA_SHARE_TYPE_INFO, optLong);
            jSONObject2.put("7", optString2);
            jSONObject2.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, optString3);
            jSONObject2.put("9", optString4);
            jSONObject2.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, optString5);
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            jSONObject2.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, eVar.e.getString("re_a_cv", ""));
            jSONObject2.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, eVar.e.getString("re_a_lc", ""));
            jSONObject2.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, eVar.n() ? 1 : 0);
            if (k(context) == 4) {
                jSONObject2.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, 1);
            } else {
                jSONObject2.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, 2);
            }
            jSONObject2.put("20", g.c(context));
            jSONObject2.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, g.f(context));
            jSONObject2.put(Constants.VIA_REPORT_TYPE_DATALINE, g.b(context));
            String string = eVar.b.getString("xygls", "");
            if (TextUtils.isEmpty(string)) {
                try {
                    string = k.a(context);
                    if (TextUtils.isEmpty(string)) {
                        string = "";
                    }
                    eVar.d.putString("xygls", string);
                    eVar.d.commit();
                } catch (Throwable th2) {
                }
            }
            jSONObject2.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, string);
            jSONObject2.put("25", com.baidu.sofire.rp.a.a(context));
            jSONObject2.put("26", com.baidu.sofire.rp.a.b(context));
            jSONObject2.put("27", com.baidu.sofire.rp.a.c(context));
            jSONObject2.put(Constants.VIA_ACT_TYPE_TWENTY_EIGHT, p.a(context));
            Object obj = jSONObject.get("Module_section");
            if (obj instanceof JSONArray) {
                jSONObject2.put("module_section", obj);
            } else {
                jSONObject2.put("module_section", new JSONArray().put(obj));
            }
        } catch (Throwable th3) {
            com.baidu.sofire.b.d();
        }
        return jSONObject2;
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        int indexOf;
        com.baidu.sofire.rp.a.a aVar;
        f.a(context).a();
        f a2 = f.a(context);
        Message message = new Message();
        message.what = 8;
        a2.a.a(message);
        com.baidu.sofire.rp.a.a aVar2 = new com.baidu.sofire.rp.a.a();
        aVar2.a = str;
        aVar2.b = str2;
        aVar2.c = str3;
        aVar2.d = str4;
        aVar2.e = str5;
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            List<com.baidu.sofire.rp.a.a> v = eVar.v();
            if (v == null) {
                eVar.a(aVar2);
            } else if (!v.contains(aVar2)) {
                eVar.a(aVar2);
            } else {
                if (v != null && (indexOf = v.indexOf(aVar2)) != -1 && (aVar = v.get(indexOf)) != null) {
                    eVar.f.putString("re_con", eVar.e.getString("re_con", "").replace(com.baidu.sofire.rp.a.a.a(aVar), com.baidu.sofire.rp.a.a.a(aVar2)));
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

    public static void b(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            System.currentTimeMillis();
            eVar.e.getInt("re_net_ty", 2);
            JSONObject optJSONObject = jSONObject.optJSONObject("Common_section");
            long optLong = optJSONObject.optLong("0");
            String optString = optJSONObject.optString(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
            int optInt = optJSONObject.optInt("5");
            int optInt2 = optJSONObject.optInt(Constants.VIA_SHARE_TYPE_INFO);
            int optInt3 = optJSONObject.optInt("7");
            int optInt4 = optJSONObject.optInt(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            String optString2 = optJSONObject.optString(Constants.VIA_REPORT_TYPE_SET_AVATAR, "");
            int i2 = optInt2 != 0 ? optInt2 : 1;
            com.baidu.sofire.rp.c.a aVar = new com.baidu.sofire.rp.c.a();
            aVar.d = str;
            aVar.b = optString;
            aVar.g = optInt;
            aVar.c = 3;
            aVar.e = optLong;
            aVar.f = i2;
            aVar.h = optInt3;
            aVar.i = optInt4;
            aVar.j = optString2;
            f a2 = f.a(context);
            Message message = new Message();
            message.what = 1;
            message.obj = aVar;
            a2.a.a(message);
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
    }

    public static void c(Context context, String str) {
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
                    new StringBuilder("setAliveData rp= ").append(optJSONArray.toString());
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
            jSONObject2.put(Constants.VIA_SHARE_TYPE_INFO, 1);
            jSONObject2.put("7", 0);
            jSONObject2.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, str);
            jSONObject2.put("9", str2);
            jSONObject2.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, str3);
            JSONObject jSONObject3 = !TextUtils.isEmpty(str4) ? new JSONObject(str4) : new JSONObject();
            jSONObject.put("Common_section", jSONObject2);
            jSONObject.put("Module_section", jSONObject3);
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
        return jSONObject;
    }

    public static void a(Context context, long j2) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, new Intent("com.b.r.p"), 134217728);
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

    public static void n(Context context) {
        try {
            String str = b() + "p/1/prt";
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            jSONObject.put(PushConstants.URI_PACKAGE_NAME, packageName);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);
            if (packageInfo != null) {
                PublicKey a2 = a(packageInfo, packageInfo.applicationInfo.sourceDir);
                if (a2 != null) {
                    byte[] encoded = a2.getEncoded();
                    if (encoded != null) {
                        a(context, encoded);
                        jSONObject.put("sm", o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", "")));
                        com.baidu.sofire.b.a();
                    }
                } else {
                    jSONObject.put("sm", "");
                }
            } else {
                jSONObject.put("sm", "");
            }
            String jSONObject2 = jSONObject.toString();
            com.baidu.sofire.b.a();
            String a3 = h.a(context, str, jSONObject2, false);
            com.baidu.sofire.b.a();
            if (a3 != null) {
                JSONObject jSONObject3 = new JSONObject(a3);
                JSONArray optJSONArray = jSONObject3.optJSONArray("product");
                long optLong = jSONObject3.optLong(Config.PLATFORM_TYPE);
                if (optJSONArray != null && optLong > 0) {
                    new com.baidu.sofire.e(context).a(optJSONArray.toString(), optLong);
                }
                if (optLong > 0) {
                    i(context);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
    }

    public static void o(Context context) {
        try {
            e.clear();
            String d2 = new com.baidu.sofire.e(context).d();
            com.baidu.sofire.b.a();
            if (!TextUtils.isEmpty(d2)) {
                JSONArray jSONArray = new JSONArray(d2);
                HashMap hashMap = new HashMap();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    String optString = optJSONObject.optString("p");
                    String optString2 = optJSONObject.optString("s");
                    new StringBuilder("167:").append(optString).append("_").append(optString2);
                    com.baidu.sofire.b.a();
                    hashMap.put(optString, optString2);
                }
                for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(64)) {
                    String str = packageInfo.packageName;
                    com.baidu.sofire.b.a();
                    if (hashMap.keySet().contains(str) && !str.equals(context.getPackageName())) {
                        String str2 = (String) hashMap.get(str);
                        com.baidu.sofire.b.a();
                        String str3 = packageInfo.applicationInfo.sourceDir;
                        com.baidu.sofire.b.a();
                        PublicKey a2 = a(packageInfo, str3);
                        new StringBuilder("194:").append(a2 == null);
                        com.baidu.sofire.b.a();
                        if (a2 != null) {
                            byte[] encoded = a2.getEncoded();
                            new StringBuilder("197:").append(encoded == null);
                            com.baidu.sofire.b.a();
                            if (encoded != null) {
                                a(context, encoded);
                                String a3 = o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                                com.baidu.sofire.b.a();
                                if (!TextUtils.isEmpty(a3) && a3.equals(str2)) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put(PushConstants.URI_PACKAGE_NAME, str);
                                    jSONObject.put("av", packageInfo.versionName);
                                    jSONObject.put("sm", a3);
                                    jSONObject.put("dm", Build.MODEL);
                                    jSONObject.put("al", String.valueOf(Build.VERSION.SDK_INT));
                                    e.put(str, jSONObject.toString());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
    }

    public static void a(Context context, Intent intent) {
        try {
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            if (!intent.getBooleanExtra("android.intent.extra.REPLACING", false) && e.containsKey(schemeSpecificPart)) {
                e.remove(schemeSpecificPart);
                new U(context, 4, false).start();
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d();
        }
    }

    public static boolean a(int i2) {
        ApkInfo a2;
        com.baidu.sofire.core.g a3;
        try {
            com.baidu.sofire.a.a aVar = com.baidu.sofire.a.a.d;
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
