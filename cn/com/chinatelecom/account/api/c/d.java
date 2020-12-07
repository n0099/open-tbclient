package cn.com.chinatelecom.account.api.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes16.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f984a = d.class.getCanonicalName();
    private static String b = "";
    private static int c = 0;
    private static int d = 5;

    public static String a(Context context) {
        try {
            if (h.a(context)) {
                String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                return subscriberId == null ? "" : subscriberId;
            }
            return "";
        } catch (Throwable th) {
            return "";
        }
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("46000") || str.startsWith("46002") || str.startsWith("46004") || str.startsWith("46007")) {
                return IXAdRequestInfo.MAX_CONTENT_LENGTH;
            }
            if (str.startsWith("46003") || str.startsWith("46005") || str.startsWith("46011")) {
                return Config.EXCEPTION_CRASH_TYPE;
            }
            if (str.startsWith("46001") || str.startsWith("46006") || str.startsWith("46009")) {
                return com.baidu.fsg.base.statistics.j.f1499a;
            }
        }
        return "";
    }

    public static String b(Context context) {
        try {
            if (h.a(context)) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                return deviceId == null ? "" : deviceId;
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:64:0x0132
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String c(android.content.Context r12) {
        /*
            java.lang.String r6 = ""
            boolean r0 = cn.com.chinatelecom.account.api.c.h.a(r12)     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
            if (r0 != 0) goto La
        L9:
            return r6
        La:
            java.lang.String r2 = ""
            java.lang.String r3 = ""
            java.lang.String r5 = ""
            java.lang.String r4 = ""
            int r0 = cn.com.chinatelecom.account.api.c.d.d     // Catch: java.lang.Exception -> Lf8 java.lang.Error -> L11a
            if (r0 == 0) goto L21
            int r0 = cn.com.chinatelecom.account.api.c.d.c     // Catch: java.lang.Exception -> Lf8 java.lang.Error -> L11a
            int r1 = cn.com.chinatelecom.account.api.c.d.d     // Catch: java.lang.Exception -> Lf8 java.lang.Error -> L11a
            int r0 = r0 % r1
            if (r0 == 0) goto L25
        L21:
            int r0 = cn.com.chinatelecom.account.api.c.d.c     // Catch: java.lang.Exception -> Lf8 java.lang.Error -> L11a
            if (r0 != 0) goto L141
        L25:
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r12.getSystemService(r0)     // Catch: java.lang.Exception -> Lf8 java.lang.Error -> L11a
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch: java.lang.Exception -> Lf8 java.lang.Error -> L11a
            java.lang.Class r7 = r0.getClass()     // Catch: java.lang.Exception -> Lf8 java.lang.Error -> L11a
            java.lang.String r1 = "getImei"
            r8 = 1
            java.lang.Class[] r8 = new java.lang.Class[r8]     // Catch: java.lang.Exception -> Lf8 java.lang.Error -> L11a
            r9 = 0
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> Lf8 java.lang.Error -> L11a
            r8[r9] = r10     // Catch: java.lang.Exception -> Lf8 java.lang.Error -> L11a
            java.lang.reflect.Method r8 = r7.getDeclaredMethod(r1, r8)     // Catch: java.lang.Exception -> Lf8 java.lang.Error -> L11a
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> Lf8 java.lang.Error -> L11a
            r9 = 0
            r10 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Exception -> Lf8 java.lang.Error -> L11a
            r1[r9] = r10     // Catch: java.lang.Exception -> Lf8 java.lang.Error -> L11a
            java.lang.Object r1 = r8.invoke(r0, r1)     // Catch: java.lang.Exception -> Lf8 java.lang.Error -> L11a
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> Lf8 java.lang.Error -> L11a
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Error -> L11a java.lang.Exception -> L122
            r9 = 0
            r10 = 1
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Error -> L11a java.lang.Exception -> L122
            r2[r9] = r10     // Catch: java.lang.Error -> L11a java.lang.Exception -> L122
            java.lang.Object r2 = r8.invoke(r0, r2)     // Catch: java.lang.Error -> L11a java.lang.Exception -> L122
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Error -> L11a java.lang.Exception -> L122
            java.lang.String r3 = "getSubscriberId"
            r8 = 1
            java.lang.Class[] r8 = new java.lang.Class[r8]     // Catch: java.lang.Error -> L11a java.lang.Exception -> L124
            r9 = 0
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch: java.lang.Error -> L11a java.lang.Exception -> L124
            r8[r9] = r10     // Catch: java.lang.Error -> L11a java.lang.Exception -> L124
            java.lang.reflect.Method r7 = r7.getDeclaredMethod(r3, r8)     // Catch: java.lang.Error -> L11a java.lang.Exception -> L124
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Error -> L11a java.lang.Exception -> L124
            r8 = 0
            r9 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Error -> L11a java.lang.Exception -> L124
            r3[r8] = r9     // Catch: java.lang.Error -> L11a java.lang.Exception -> L124
            java.lang.Object r3 = r7.invoke(r0, r3)     // Catch: java.lang.Error -> L11a java.lang.Exception -> L124
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Error -> L11a java.lang.Exception -> L124
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Error -> L11a java.lang.Exception -> L127
            r8 = 0
            r9 = 1
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Error -> L11a java.lang.Exception -> L127
            r5[r8] = r9     // Catch: java.lang.Error -> L11a java.lang.Exception -> L127
            java.lang.Object r0 = r7.invoke(r0, r5)     // Catch: java.lang.Error -> L11a java.lang.Exception -> L127
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Error -> L11a java.lang.Exception -> L127
            if (r1 != 0) goto Lf4
            java.lang.String r4 = ""
        L99:
            if (r2 != 0) goto L9e
            java.lang.String r2 = ""
        L9e:
            if (r3 != 0) goto Lf6
            java.lang.String r1 = ""
        La3:
            if (r0 != 0) goto La8
            java.lang.String r0 = ""
        La8:
            r3 = 0
            cn.com.chinatelecom.account.api.c.d.c = r3     // Catch: java.lang.Error -> L11a java.lang.Exception -> L13a
            r3 = r4
        Lac:
            r4 = r0
            r0 = r1
            r1 = r3
        Laf:
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
            if (r3 == 0) goto Lb9
            java.lang.String r1 = b(r12)     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
        Lb9:
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
            if (r3 == 0) goto Lc3
            java.lang.String r0 = a(r12)     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
        Lc3:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
            r3.<init>()     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
            java.lang.StringBuilder r1 = r3.append(r1)     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
            java.lang.String r3 = "-"
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
            java.lang.String r2 = "-"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
            java.lang.String r1 = "-"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
        Lf1:
            r6 = r0
            goto L9
        Lf4:
            r4 = r1
            goto L99
        Lf6:
            r1 = r3
            goto La3
        Lf8:
            r0 = move-exception
            r1 = r2
        Lfa:
            int r2 = cn.com.chinatelecom.account.api.c.d.c     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
            if (r2 < 0) goto L104
            int r2 = cn.com.chinatelecom.account.api.c.d.c     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
            int r2 = r2 + 1
            cn.com.chinatelecom.account.api.c.d.c = r2     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
        L104:
            int r2 = cn.com.chinatelecom.account.api.c.d.c     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
            r7 = 50
            if (r2 <= r7) goto L10e
            r2 = 10
            cn.com.chinatelecom.account.api.c.d.d = r2     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
        L10e:
            r0.printStackTrace()     // Catch: java.lang.Exception -> L114 java.lang.Error -> L11a
            r0 = r5
            r2 = r3
            goto Laf
        L114:
            r0 = move-exception
            r0.printStackTrace()
            r0 = r6
            goto Lf1
        L11a:
            r0 = move-exception
            if (r0 == 0) goto L120
            r0.printStackTrace()
        L120:
            r0 = r6
            goto Lf1
        L122:
            r0 = move-exception
            goto Lfa
        L124:
            r0 = move-exception
            r3 = r2
            goto Lfa
        L127:
            r0 = move-exception
            r5 = r3
            r3 = r2
            goto Lfa
        L12b:
            r4 = move-exception
            r5 = r3
            r3 = r2
            r11 = r4
            r4 = r0
            r0 = r11
            goto Lfa
        L132:
            r1 = move-exception
            r5 = r3
            r3 = r2
            r11 = r1
            r1 = r4
            r4 = r0
            r0 = r11
            goto Lfa
        L13a:
            r3 = move-exception
            r5 = r1
            r1 = r4
            r4 = r0
            r0 = r3
            r3 = r2
            goto Lfa
        L141:
            r0 = r4
            r1 = r5
            r11 = r3
            r3 = r2
            r2 = r11
            goto Lac
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.chinatelecom.account.api.c.d.c(android.content.Context):java.lang.String");
    }

    public static String d(Context context) {
        if (context == null) {
            return "";
        }
        String str = "";
        String str2 = "";
        try {
            String[] split = c(context).split(Constants.ACCEPT_TIME_SEPARATOR_SERVER, 4);
            if (split.length == 4) {
                str = split[2];
                str2 = split[3];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(str)) {
            str = a(context);
        }
        String a2 = a(str);
        return a2 + "," + a(str2);
    }
}
