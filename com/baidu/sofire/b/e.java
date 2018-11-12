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
import android.os.Process;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioPlayer;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.sofire.MyProvider;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.ac.U;
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
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
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

    public static void a(Throwable th) {
        com.baidu.sofire.b.b(th);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PublicKey a(PackageInfo packageInfo, String str) {
        PublicKey publicKey;
        if (packageInfo.signatures != null && packageInfo.signatures.length > 0 && packageInfo.signatures[0] != null) {
            try {
                publicKey = d.a(packageInfo.signatures[0]);
            } catch (Throwable th) {
                a(th);
            }
            if (publicKey != null) {
                return d.a(str);
            }
            return publicKey;
        }
        publicKey = null;
        if (publicKey != null) {
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00be -> B:5:0x0016). Please submit an issue!!! */
    public static String a(Class<?> cls) {
        try {
        } catch (Throwable th) {
            a(th);
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
            a(th);
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
                g = a(Process.myPid());
            }
        } catch (Throwable th) {
            a(th);
        }
        if (!TextUtils.isEmpty(b2)) {
            return b2.equals(g);
        }
        if (context.getPackageName().equals(g)) {
            return true;
        }
        return false;
    }

    public static String b(Context context) {
        try {
        } catch (Throwable th) {
            a(th);
        }
        if (!TextUtils.isEmpty(f) || j == 1) {
            return f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName()).append(".").append("sofire").append(".ac.provider");
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
                a(th);
                z2 = false;
            }
        }
        return z2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:1|(2:2|3)|(3:58|59|(13:61|6|7|8|(3:47|48|(8:50|11|(3:13|(1:15)|40)(2:(1:44)|40)|16|(1:18)|(4:25|(1:(1:33)(1:(1:35)))(1:28)|(1:30)|31)|36|37))|10|11|(0)(0)|16|(0)|(6:20|25|(0)|(0)(0)|(0)|31)|36|37))|5|6|7|8|(0)|10|11|(0)(0)|16|(0)|(0)|36|37|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00be, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d4, code lost:
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d5, code lost:
        a(r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005f A[Catch: Throwable -> 0x00d4, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Throwable -> 0x00d4, blocks: (B:15:0x005f, B:43:0x00c4), top: B:63:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00d8 -> B:18:0x006e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(Context context, String str, boolean z, boolean z2) {
        ResolveInfo resolveInfo;
        boolean z3;
        ResolveInfo resolveInfo2;
        ActivityInfo activityInfo;
        boolean z4;
        boolean z5;
        ResolveInfo resolveService;
        boolean z6;
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
                if (resolveInfo2 == null) {
                }
                z3 = TextUtils.isEmpty(g);
                if (z3) {
                }
                if (z2) {
                }
                return z4 & z5;
            }
            if (str.equals(resolveService.serviceInfo.processName)) {
                z6 = true;
                z3 = z6;
                resolveInfo2 = resolveService;
                Intent intent22 = new Intent();
                ComponentName componentName2 = new ComponentName(context.getPackageName(), MyReceiver.class.getCanonicalName());
                intent22.setComponent(componentName2);
                activityInfo = context.getPackageManager().getReceiverInfo(componentName2, 0);
                if (activityInfo != null) {
                    try {
                    } catch (Throwable th3) {
                        ActivityInfo activityInfo2 = activityInfo;
                        activityInfo = activityInfo2;
                        z4 = false;
                        if (resolveInfo2 == null) {
                        }
                        z3 = TextUtils.isEmpty(g);
                        if (z3) {
                        }
                        if (z2) {
                        }
                        return z4 & z5;
                    }
                    if (str.equals(activityInfo.processName)) {
                        z4 = true;
                        if (resolveInfo2 == null) {
                            if (str.equals(b(context, str, NotificationCompat.CATEGORY_SERVICE))) {
                                z5 = z4;
                                z4 = true;
                            }
                            z5 = z4;
                            z4 = z3;
                        } else {
                            if (activityInfo == null && str.equals(b(context, str, SocialConstants.PARAM_RECEIVER))) {
                                z4 = z3;
                                z5 = true;
                            }
                            z5 = z4;
                            z4 = z3;
                        }
                        z3 = TextUtils.isEmpty(g);
                        if (z3) {
                            g = a(Process.myPid());
                        }
                        if (z2 && g.equals(str) && (!z5 || !z4 || z)) {
                            HashMap hashMap = new HashMap();
                            if (z5 && !z4) {
                                hashMap.put("0", Integer.toString(2));
                            } else if (z4) {
                                hashMap.put("0", Integer.toString(1));
                            } else if (!z5) {
                                hashMap.put("0", Integer.toString(0));
                            }
                            if (z) {
                                hashMap.put("1", "0");
                            }
                            a(context, "1003140", hashMap);
                        }
                        return z4 & z5;
                    }
                }
                z4 = false;
                if (resolveInfo2 == null) {
                }
                z3 = TextUtils.isEmpty(g);
                if (z3) {
                }
                if (z2) {
                    HashMap hashMap2 = new HashMap();
                    if (z5) {
                    }
                    if (z4) {
                    }
                    if (z) {
                    }
                    a(context, "1003140", hashMap2);
                }
                return z4 & z5;
            }
        }
        z6 = false;
        z3 = z6;
        resolveInfo2 = resolveService;
        Intent intent222 = new Intent();
        ComponentName componentName22 = new ComponentName(context.getPackageName(), MyReceiver.class.getCanonicalName());
        intent222.setComponent(componentName22);
        activityInfo = context.getPackageManager().getReceiverInfo(componentName22, 0);
        if (activityInfo != null) {
        }
        z4 = false;
        if (resolveInfo2 == null) {
        }
        z3 = TextUtils.isEmpty(g);
        if (z3) {
        }
        if (z2) {
        }
        return z4 & z5;
    }

    public static boolean b(String str) {
        try {
            if (TextUtils.isEmpty(g)) {
                g = a(Process.myPid());
            }
            return !str.equals(g);
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    private static String b(Context context, String str, String str2) {
        int next;
        String canonicalName;
        try {
            String str3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            XmlResourceParser openXmlResourceParser = assetManager.openXmlResourceParser(((Integer) AssetManager.class.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager, str3)).intValue(), "AndroidManifest.xml");
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
                    if (b(attributeValue, true) != null && !HttpConstants.OS_TYPE_VALUE.equals(attributeValue)) {
                        return null;
                    }
                    if (str2.equals("provider")) {
                        canonicalName = MyProvider.class.getCanonicalName();
                    } else if (str2.equals(NotificationCompat.CATEGORY_SERVICE)) {
                        canonicalName = MyService.class.getCanonicalName();
                    } else {
                        canonicalName = str2.equals(SocialConstants.PARAM_RECEIVER) ? MyReceiver.class.getCanonicalName() : null;
                    }
                    com.baidu.sofire.b.a("Try Component Name :" + canonicalName);
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
            a(th);
        }
        return null;
    }

    private static String b(String str, boolean z) {
        int length = str.length();
        boolean z2 = true;
        boolean z3 = false;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                z2 = false;
            } else if (z2 || ((charAt < '0' || charAt > '9') && charAt != '_')) {
                if (charAt != '.') {
                    return "bad character '" + charAt + "'";
                }
                z2 = true;
                z3 = true;
            }
        }
        if (z3 || !z) {
            return null;
        }
        return "must have at least one '.' separator";
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [583=4] */
    public static void a(java.io.File r5, java.io.File r6) {
        /*
            r2 = 0
            if (r5 == 0) goto Lb
            if (r6 == 0) goto Lb
            boolean r0 = a(r5)
            if (r0 != 0) goto Lc
        Lb:
            return
        Lc:
            boolean r0 = r6.exists()
            if (r0 == 0) goto L15
            r6.delete()
        L15:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Lc3
            r3.<init>(r5)     // Catch: java.lang.Throwable -> Lc3
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> Lc7
            r1.<init>(r6)     // Catch: java.lang.Throwable -> Lc7
            r0 = 8192(0x2000, float:1.148E-41)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L2f
        L23:
            int r2 = r3.read(r0)     // Catch: java.lang.Throwable -> L2f
            r4 = -1
            if (r2 == r4) goto L48
            r4 = 0
            r1.write(r0, r4, r2)     // Catch: java.lang.Throwable -> L2f
            goto L23
        L2f:
            r0 = move-exception
            r2 = r3
        L31:
            a(r0)     // Catch: java.lang.Throwable -> Lc0
            if (r2 == 0) goto L39
            r2.close()     // Catch: java.lang.Throwable -> L92
        L39:
            if (r1 == 0) goto Lb
            r1.close()     // Catch: java.lang.Throwable -> L3f
            goto Lb
        L3f:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            com.baidu.sofire.b.a(r1, r0)
            goto Lb
        L48:
            r1.flush()     // Catch: java.lang.Throwable -> L2f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2f
            r0.<init>()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r2 = "copyFile Suc, srcFile="
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r2 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L2f
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r2 = " > "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r2 = r6.getAbsolutePath()     // Catch: java.lang.Throwable -> L2f
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L2f
            com.baidu.sofire.b.a(r0)     // Catch: java.lang.Throwable -> L2f
            if (r3 == 0) goto L7a
            r3.close()     // Catch: java.lang.Throwable -> L89
        L7a:
            if (r1 == 0) goto Lb
            r1.close()     // Catch: java.lang.Throwable -> L80
            goto Lb
        L80:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            com.baidu.sofire.b.a(r1, r0)
            goto Lb
        L89:
            r0 = move-exception
            java.lang.String r2 = r0.getMessage()
            com.baidu.sofire.b.a(r2, r0)
            goto L7a
        L92:
            r0 = move-exception
            java.lang.String r2 = r0.getMessage()
            com.baidu.sofire.b.a(r2, r0)
            goto L39
        L9b:
            r0 = move-exception
            r1 = r2
            r3 = r2
        L9e:
            if (r3 == 0) goto La3
            r3.close()     // Catch: java.lang.Throwable -> La9
        La3:
            if (r1 == 0) goto La8
            r1.close()     // Catch: java.lang.Throwable -> Lb2
        La8:
            throw r0
        La9:
            r2 = move-exception
            java.lang.String r3 = r2.getMessage()
            com.baidu.sofire.b.a(r3, r2)
            goto La3
        Lb2:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.baidu.sofire.b.a(r2, r1)
            goto La8
        Lbb:
            r0 = move-exception
            r1 = r2
            goto L9e
        Lbe:
            r0 = move-exception
            goto L9e
        Lc0:
            r0 = move-exception
            r3 = r2
            goto L9e
        Lc3:
            r0 = move-exception
            r1 = r2
            goto L31
        Lc7:
            r0 = move-exception
            r1 = r2
            r2 = r3
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
                                com.baidu.sofire.b.a(file2.getAbsolutePath() + " d:" + file2.delete());
                            }
                        }
                    }
                    com.baidu.sofire.b.a(file.getAbsolutePath() + " d:" + file.delete());
                }
            }
        } catch (Throwable th) {
            a(th);
        }
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        Method method;
        if (obj == null || TextUtils.isEmpty(str)) {
            com.baidu.sofire.b.a("callMethodOfClass fail");
            throw new NoSuchMethodException("object=" + obj + ", methodName=" + str);
        } else if (clsArr != null && objArr != null && clsArr.length != objArr.length) {
            com.baidu.sofire.b.a("callMethodOfClass fail");
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
                com.baidu.sofire.b.a("callMethodOfClass fail");
                throw new NoSuchMethodException("cannot find method in target methodName=" + str);
            }
            return method.invoke(obj, objArr);
        }
    }

    private static boolean a(Method method, String str, Class<?>[] clsArr) {
        if (str.equals(method.getName())) {
            com.baidu.sofire.b.a("methodName=" + str);
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ((parameterTypes == null || parameterTypes.length == 0) && (clsArr == null || clsArr.length == 0)) {
                com.baidu.sofire.b.a("suc");
                return true;
            } else if ((clsArr == null || clsArr.length == 0) && parameterTypes != null && parameterTypes.length > 0) {
                com.baidu.sofire.b.a("fail");
                return false;
            } else if ((parameterTypes == null || parameterTypes.length == 0) && clsArr != null && clsArr.length > 0) {
                com.baidu.sofire.b.a("fail");
                return false;
            } else if (parameterTypes.length != clsArr.length) {
                com.baidu.sofire.b.a("fail");
                return false;
            } else {
                for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                    if (parameterTypes[i2] != clsArr[i2]) {
                        com.baidu.sofire.b.a("fail");
                        return false;
                    }
                }
                com.baidu.sofire.b.a("suc");
                return true;
            }
        }
        return false;
    }

    public static void a(String str, boolean z) {
        boolean c2 = c("771", str);
        com.baidu.sofire.b.a(str + ",s=" + c2);
        if (z) {
            String absolutePath = new File(str).getParentFile().getAbsolutePath();
            c("771", absolutePath);
            com.baidu.sofire.b.a(absolutePath + ",s=" + c2);
        }
    }

    public static boolean c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !new File(str2).exists()) {
            return false;
        }
        try {
            Runtime.getRuntime().exec("chmod " + str + " " + str2 + "\n").waitFor();
            return true;
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static void c(Context context) {
        try {
            Report report = Report.getInstance(context);
            JSONObject jSONObject = new JSONObject();
            com.baidu.sofire.a.a a2 = com.baidu.sofire.a.a.a(context);
            Map<Integer, String> c2 = a2.c();
            jSONObject.put("0", c2.keySet());
            jSONObject.put("1", c2.values());
            com.baidu.sofire.b.a("getAliveData " + jSONObject.toString());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("1003003", jSONObject);
            jSONObject2.put("0", jSONObject3);
            Map<Integer, String> d2 = a2.d();
            JSONArray jSONArray = new JSONArray();
            for (String str : d2.values()) {
                jSONArray.put(str);
            }
            jSONArray.put("com.baidu.sofire");
            com.baidu.sofire.b.a("setAliveData = " + jSONArray.toString());
            jSONObject2.put("2", jSONArray);
            report.w(jSONObject2.toString());
        } catch (Throwable th) {
            com.baidu.sofire.b.a(th.getMessage(), th);
        }
    }

    public static void d(Context context) {
        com.baidu.sofire.b.a("v=3.1.8");
        if (!TextUtils.isEmpty("3.1.8")) {
            Report report = Report.getInstance(context);
            try {
                c(context);
                report.i("sofire", "com.baidu.sofire", "3.1.8", "1003003", "1003002");
            } catch (Throwable th) {
                com.baidu.sofire.b.a(th.getMessage(), th);
            }
        }
    }

    public static String e(Context context) {
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
            a(th);
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
                String[] h2 = h(context);
                if (h2 != null && h2.length == 2 && !TextUtils.isEmpty(h2[0]) && !TextUtils.isEmpty(h2[1])) {
                    str2 = h2[0];
                } else {
                    str2 = "3";
                }
                jSONObject2.put("3", str2);
                jSONObject2.put("4", 0);
                jSONObject2.put("5", 0);
                jSONObject2.put(Constants.VIA_SHARE_TYPE_INFO, 1);
                jSONObject2.put("7", 0);
                jSONObject2.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, "sofire");
                jSONObject2.put("9", "3.1.8");
                jSONObject2.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, str);
                jSONObject.put("Common_section", jSONObject2);
                if (map != null && map.size() > 0) {
                    jSONObject.put("Module_section", new JSONObject(map));
                } else {
                    jSONObject.put("Module_section", new JSONObject());
                }
                Report report = Report.getInstance(context);
                String jSONObject3 = jSONObject.toString();
                com.baidu.sofire.b.a("sendEventUDC:" + jSONObject3);
                report.s(jSONObject3);
            } catch (Throwable th) {
                a(th);
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
                        com.baidu.sofire.b.a(e2.getMessage(), e2);
                    }
                }
            } catch (IOException e3) {
                com.baidu.sofire.b.a(e3.getMessage(), e3);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        com.baidu.sofire.b.a(e4.getMessage(), e4);
                    }
                }
            }
        } catch (Throwable th) {
            a(th);
        }
        return str3;
    }

    public static boolean f(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        return 1 == activeNetworkInfo.getType();
    }

    public static boolean g(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static String[] h(Context context) {
        String[] split;
        String[] split2;
        String str = b;
        String str2 = c;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.baidu.sofire.b.a("get key  key select in memory!");
            return new String[]{str, str2};
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String c2 = new com.baidu.sofire.e(context).c();
            if (!TextUtils.isEmpty(c2) && (split = c2.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != null && split.length == 2) {
                com.baidu.sofire.b.a("get key  key select from Info");
                String str3 = split[0];
                String str4 = split[1];
                return split;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String d2 = new com.baidu.sofire.e(context).d();
            if (!TextUtils.isEmpty(d2) && (split2 = d2.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != null && split2.length == 2) {
                com.baidu.sofire.b.a("get key  key select in mark");
                String str5 = split2[0];
                String str6 = split2[1];
                return split2;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.baidu.sofire.b.a("get key  key select by default");
            str = "3";
            str2 = "925fc15df8a49bed0b3eca8d2b44cb7b";
        }
        return new String[]{str, str2};
    }

    public static String[] i(Context context) {
        if (TextUtils.isEmpty(b) || TextUtils.isEmpty(c)) {
            String c2 = new com.baidu.sofire.e(context).c();
            if (!TextUtils.isEmpty(c2)) {
                String[] split = c2.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
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

    public static Map<String, Integer> f(String str) {
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
            a(th);
            return null;
        }
    }

    public static void g(String str) {
        Map<String, Integer> map;
        try {
            if (com.baidu.sofire.core.d.a != null) {
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(com.baidu.sofire.core.d.a);
                String e2 = eVar.e();
                if (TextUtils.isEmpty(e2)) {
                    map = new HashMap<>();
                    map.put(str, 1);
                } else {
                    Map<String, Integer> f2 = f(e2);
                    if (f2 != null && f2.size() > 0) {
                        if (f2.get(str) != null) {
                            f2.put(str, Integer.valueOf(f2.get(str).intValue() + 1));
                            map = f2;
                        } else {
                            f2.put(str, 1);
                        }
                    }
                    map = f2;
                }
                if (map != null && map.size() > 0) {
                    eVar.a(new JSONObject(map).toString());
                }
            }
        } catch (Throwable th) {
            a(th);
        }
    }

    public static boolean a(Context context, int i2) {
        if (i2 != 1 || f(context)) {
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

    public static void j(Context context) {
        PublicKey a2;
        byte[] encoded;
        boolean z = false;
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String h2 = eVar.h();
            long i2 = eVar.i();
            if (!TextUtils.isEmpty(h2) || i2 != 0) {
                String packageName = context.getPackageName();
                JSONArray jSONArray = new JSONArray(h2);
                String str = "";
                String str2 = "";
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);
                if (packageInfo != null && (a2 = a(packageInfo, (str2 = packageInfo.applicationInfo.sourceDir))) != null && (encoded = a2.getEncoded()) != null) {
                    a(context, encoded);
                    str = o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                    com.baidu.sofire.b.a("nsm=" + str);
                }
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                    String optString = optJSONObject.optString("p");
                    String optString2 = optJSONObject.optString("s");
                    if (packageName.equals(optString) && !TextUtils.isEmpty(str) && str.equalsIgnoreCase(optString2)) {
                        z = true;
                    }
                }
                com.baidu.sofire.b.a("Host Check:" + z);
                eVar.b(z);
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
            a(th);
        }
    }

    public static boolean a(Context context, String str) {
        PublicKey a2;
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String h2 = eVar.h();
            long i2 = eVar.i();
            if (TextUtils.isEmpty(h2) && i2 == 0) {
                return false;
            }
            JSONArray jSONArray = new JSONArray(h2);
            String str2 = "";
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null && (a2 = a(packageInfo, packageInfo.applicationInfo.sourceDir)) != null) {
                byte[] encoded = a2.getEncoded();
                if (encoded != null) {
                    a(context, encoded);
                    str2 = o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                    com.baidu.sofire.b.a("nsm=" + str2);
                }
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
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
            a(th);
            return true;
        }
    }

    public static void a(Context context, byte[] bArr) {
        try {
            String[] h2 = h(context);
            if (h2 != null && h2.length == 2 && !TextUtils.isEmpty(h2[0]) && !TextUtils.isEmpty(h2[1]) && "200080".equals(h2[0]) && context.getPackageName().equals("com.baidu.BaiduMap") && bArr != null) {
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    bArr[i2] = (byte) (bArr[i2] ^ 246);
                }
            }
        } catch (Throwable th) {
        }
    }

    public static void k(Context context) {
        com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
        if (System.currentTimeMillis() - eVar.p() > 86400000) {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.valueOf(eVar.t() + 1));
            eVar.f(0);
            eVar.q();
            a(context, "1003119", hashMap);
            return;
        }
        eVar.f(eVar.t() + 1);
    }

    public static boolean d(String str, String str2) {
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

    public static int l(Context context) {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Throwable th) {
            a(th);
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

    public static String m(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable th) {
            a(th);
            return "1.0.0";
        }
    }

    public static JSONObject n(Context context) {
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
            jSONObject.put(Constants.VIA_SHARE_TYPE_INFO, str5);
            String str6 = Build.VERSION.INCREMENTAL;
            if (str6 == null) {
                str6 = "";
            }
            jSONObject.put("7", str6);
            jSONObject.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, g.a(context));
            String c2 = g.c();
            if (c2 == null) {
                c2 = "";
            }
            jSONObject.put("9", c2);
            String d2 = g.d();
            if (d2 == null) {
                d2 = "";
            }
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, d2);
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, g.h(context));
            String e2 = g.e();
            if (e2 == null) {
                e2 = "";
            }
            jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, e2);
            jSONObject.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, g.b(context));
            jSONObject.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "");
            jSONObject.put(Constants.VIA_REPORT_TYPE_WPA_STATE, g.i(context));
            jSONObject.put(Constants.VIA_REPORT_TYPE_START_WAP, g.k(context));
            jSONObject.put("17", g.l(context));
            jSONObject.put("18", g.m(context));
            jSONObject.put(Constants.VIA_ACT_TYPE_NINETEEN, g.n(context));
            jSONObject.put("20", Build.VERSION.SDK_INT);
            TimeZone timeZone = TimeZone.getDefault();
            if (timeZone != null) {
                jSONObject.put("21", timeZone.getID());
            } else {
                jSONObject.put("21", AiAppsAudioPlayer.ERROR_UNKNOWN);
            }
        } catch (Throwable th) {
            a(th);
        }
        return jSONObject;
    }

    public static JSONObject a(Context context, com.baidu.sofire.rp.a.a aVar, String str, boolean z) {
        return a(context, aVar.a, aVar.c, z ? aVar.d : aVar.e, str);
    }

    public static int o(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            com.baidu.sofire.b.a("sj-trigger info " + th.toString());
            a(th);
            networkInfo = null;
        }
        if (networkInfo == null) {
            com.baidu.sofire.b.a("sj-trigger info == null");
            return 0;
        } else if (1 == networkInfo.getType()) {
            return 2;
        } else {
            return networkInfo.getType() == 0 ? 1 : 1;
        }
    }

    public static String a(int i2) {
        Throwable th;
        String h2;
        try {
            h2 = h(String.format("/proc/%d/cmdline", Integer.valueOf(i2)));
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (!TextUtils.isEmpty(h2)) {
                return h2.trim();
            }
            return h2;
        } catch (Throwable th3) {
            th = th3;
            a(th);
            return null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public static String h(String str) {
        FileInputStream fileInputStream;
        String str2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                str2 = a(fileInputStream);
            } catch (Throwable th) {
                th = th;
                try {
                    a(th);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th2) {
                        }
                    }
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
            th = th4;
            fileInputStream = null;
        }
        return str2;
    }

    public static String a(InputStream inputStream) {
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
        JSONObject jSONObject2 = new JSONObject();
        System.currentTimeMillis();
        JSONObject jSONObject3 = null;
        try {
            jSONObject3 = jSONObject.getJSONObject("Common_section");
        } catch (Throwable th) {
            a(th);
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
            jSONObject2.put("3", m(context));
            jSONObject2.put("4", g.a(context));
            jSONObject2.put("5", optString);
            jSONObject2.put(Constants.VIA_SHARE_TYPE_INFO, optLong);
            jSONObject2.put("7", optString2);
            jSONObject2.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, optString3);
            jSONObject2.put("9", optString4);
            jSONObject2.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, optString5);
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            jSONObject2.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, eVar.ae());
            jSONObject2.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, eVar.ad());
            jSONObject2.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, eVar.u() ? 1 : 0);
            if (l(context) == 4) {
                jSONObject2.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, 1);
            } else {
                jSONObject2.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, 2);
            }
            jSONObject2.put("20", g.c(context));
            jSONObject2.put("21", g.g(context));
            jSONObject2.put(Constants.VIA_REPORT_TYPE_DATALINE, g.b(context));
            String w = eVar.w();
            if (TextUtils.isEmpty(w)) {
                try {
                    w = k.a(context);
                    if (TextUtils.isEmpty(w)) {
                        w = "";
                    }
                    eVar.c(w);
                } catch (Throwable th2) {
                }
            }
            jSONObject2.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, w);
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
            a(th3);
        }
        return jSONObject2;
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        f.a(context).a(false);
        f.a(context).c();
        com.baidu.sofire.rp.a.a aVar = new com.baidu.sofire.rp.a.a();
        aVar.a = str;
        aVar.b = str2;
        aVar.c = str3;
        aVar.d = str4;
        aVar.e = str5;
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            List<com.baidu.sofire.rp.a.a> P = eVar.P();
            if (P == null) {
                eVar.a(aVar);
            } else if (!P.contains(aVar)) {
                eVar.a(aVar);
            } else {
                eVar.a(P, aVar);
                f.a(context).a();
                return;
            }
            if (!eVar.k(aVar.e)) {
                f.a(context).a(aVar);
            }
            f.a(context).a();
            f.a(context).b();
        }
    }

    public static void b(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            System.currentTimeMillis();
            eVar.Q();
            JSONObject optJSONObject = jSONObject.optJSONObject("Common_section");
            long optLong = optJSONObject.optLong("0");
            String optString = optJSONObject.optString(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
            int optInt = optJSONObject.optInt("5");
            int optInt2 = optJSONObject.optInt(Constants.VIA_SHARE_TYPE_INFO);
            int optInt3 = optJSONObject.optInt("7");
            int optInt4 = optJSONObject.optInt(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            String optString2 = optJSONObject.optString(Constants.VIA_REPORT_TYPE_SET_AVATAR, "");
            if (optInt2 == 0) {
                optInt2 = 1;
            }
            com.baidu.sofire.rp.c.a aVar = new com.baidu.sofire.rp.c.a();
            aVar.d = str;
            aVar.b = optString;
            aVar.g = optInt;
            aVar.c = 3;
            aVar.e = optLong;
            aVar.f = optInt2;
            aVar.h = optInt3;
            aVar.i = optInt4;
            aVar.j = optString2;
            f.a(context).a(aVar);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void c(Context context, String str) {
        com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
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
                            eVar.d(str2, optJSONObject.optString(str2));
                        }
                    }
                } catch (Throwable th) {
                    a(th);
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
                            eVar.e(str3, optJSONObject2.optString(str3));
                        }
                    }
                } catch (Throwable th2) {
                    a(th2);
                }
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("2");
                    if (optJSONArray != null) {
                        com.baidu.sofire.b.a("setAliveData rp= " + optJSONArray.toString());
                        eVar.m(optJSONArray.toString());
                    }
                } catch (Throwable th3) {
                    a(th3);
                }
            }
        } catch (Throwable th4) {
            a(th4);
        }
    }

    public static String a() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2);
        return i2 + "" + i3 + "" + calendar.get(5);
    }

    public static JSONObject a(Context context, String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "0");
            jSONObject2.put("2", "0");
            String[] h2 = h(context);
            if (h2 != null && h2.length == 2) {
                jSONObject2.put("3", h2[0]);
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
            a(th);
        }
        return jSONObject;
    }

    public static void a(Context context, long j2) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, new Intent("com.b.r.p"), 134217728);
        try {
            alarmManager.cancel(broadcast);
        } catch (Throwable th) {
            a(th);
        }
        try {
            alarmManager.set(0, System.currentTimeMillis() + j2, broadcast);
        } catch (Throwable th2) {
            a(th2);
        }
    }

    public static String a(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            str = str + hexString.toUpperCase();
        }
        return str;
    }

    public static void p(Context context) {
        try {
            String str = e(context) + "p/1/prt";
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
                        String a3 = o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                        jSONObject.put("sm", a3);
                        com.baidu.sofire.b.a("nsm=" + a3);
                    }
                } else {
                    jSONObject.put("sm", "");
                }
            } else {
                jSONObject.put("sm", "");
            }
            String jSONObject2 = jSONObject.toString();
            com.baidu.sofire.b.a(jSONObject2);
            String a4 = h.a(context, str, jSONObject2, false, true);
            com.baidu.sofire.b.a("list:after java decrypt ResponseDataJsonString=" + a4);
            if (a4 != null) {
                JSONObject jSONObject3 = new JSONObject(a4);
                JSONArray optJSONArray = jSONObject3.optJSONArray("product");
                long optLong = jSONObject3.optLong(Config.PLATFORM_TYPE);
                if (optJSONArray != null && optLong > 0) {
                    new com.baidu.sofire.e(context).a(optJSONArray.toString(), optLong);
                }
                if (optLong > 0) {
                    j(context);
                }
            }
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void q(Context context) {
        try {
            e.clear();
            String h2 = new com.baidu.sofire.e(context).h();
            com.baidu.sofire.b.a("157:" + h2);
            if (!TextUtils.isEmpty(h2)) {
                JSONArray jSONArray = new JSONArray(h2);
                HashMap hashMap = new HashMap();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    String optString = optJSONObject.optString("p");
                    String optString2 = optJSONObject.optString("s");
                    com.baidu.sofire.b.a("167:" + optString + BaseRequestAction.SPLITE + optString2);
                    hashMap.put(optString, optString2);
                }
                for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(64)) {
                    String str = packageInfo.packageName;
                    com.baidu.sofire.b.a("174:" + str);
                    if (hashMap.keySet().contains(str) && !str.equals(context.getPackageName())) {
                        String str2 = (String) hashMap.get(str);
                        com.baidu.sofire.b.a("179:" + str2);
                        String str3 = packageInfo.applicationInfo.sourceDir;
                        com.baidu.sofire.b.a("181:" + str3);
                        PublicKey a2 = a(packageInfo, str3);
                        com.baidu.sofire.b.a("194:" + (a2 == null));
                        if (a2 != null) {
                            byte[] encoded = a2.getEncoded();
                            com.baidu.sofire.b.a("197:" + (encoded == null));
                            if (encoded != null) {
                                a(context, encoded);
                                String a3 = o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                                com.baidu.sofire.b.a("nsm=" + a3);
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
            a(th);
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
            a(th);
        }
    }
}
