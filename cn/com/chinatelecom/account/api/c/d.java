package cn.com.chinatelecom.account.api.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1122a = d.class.getCanonicalName();

    /* renamed from: b  reason: collision with root package name */
    private static String f1123b = "";
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
                return com.baidu.fsg.base.statistics.j.f2000a;
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
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:64:0x013d
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String c(android.content.Context r11) {
        /*
            java.lang.String r7 = ""
            boolean r0 = cn.com.chinatelecom.account.api.c.h.a(r11)     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
            if (r0 != 0) goto La
        L9:
            return r7
        La:
            java.lang.String r6 = ""
            java.lang.String r3 = ""
            java.lang.String r5 = ""
            java.lang.String r4 = ""
            int r0 = cn.com.chinatelecom.account.api.c.d.d     // Catch: java.lang.Exception -> Lf9 java.lang.Error -> L11e
            if (r0 == 0) goto L21
            int r0 = cn.com.chinatelecom.account.api.c.d.c     // Catch: java.lang.Exception -> Lf9 java.lang.Error -> L11e
            int r1 = cn.com.chinatelecom.account.api.c.d.d     // Catch: java.lang.Exception -> Lf9 java.lang.Error -> L11e
            int r0 = r0 % r1
            if (r0 == 0) goto L25
        L21:
            int r0 = cn.com.chinatelecom.account.api.c.d.c     // Catch: java.lang.Exception -> Lf9 java.lang.Error -> L11e
            if (r0 != 0) goto L14f
        L25:
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r11.getSystemService(r0)     // Catch: java.lang.Exception -> Lf9 java.lang.Error -> L11e
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch: java.lang.Exception -> Lf9 java.lang.Error -> L11e
            java.lang.Class r8 = r0.getClass()     // Catch: java.lang.Exception -> Lf9 java.lang.Error -> L11e
            java.lang.String r1 = "getImei"
            r2 = 1
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> Lf9 java.lang.Error -> L11e
            r9 = 0
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> Lf9 java.lang.Error -> L11e
            r2[r9] = r10     // Catch: java.lang.Exception -> Lf9 java.lang.Error -> L11e
            java.lang.reflect.Method r2 = r8.getDeclaredMethod(r1, r2)     // Catch: java.lang.Exception -> Lf9 java.lang.Error -> L11e
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> Lf9 java.lang.Error -> L11e
            r9 = 0
            r10 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Exception -> Lf9 java.lang.Error -> L11e
            r1[r9] = r10     // Catch: java.lang.Exception -> Lf9 java.lang.Error -> L11e
            java.lang.Object r1 = r2.invoke(r0, r1)     // Catch: java.lang.Exception -> Lf9 java.lang.Error -> L11e
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> Lf9 java.lang.Error -> L11e
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Error -> L11e java.lang.Exception -> L126
            r9 = 0
            r10 = 1
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Error -> L11e java.lang.Exception -> L126
            r6[r9] = r10     // Catch: java.lang.Error -> L11e java.lang.Exception -> L126
            java.lang.Object r2 = r2.invoke(r0, r6)     // Catch: java.lang.Error -> L11e java.lang.Exception -> L126
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Error -> L11e java.lang.Exception -> L126
            java.lang.String r3 = "getSubscriberId"
            r6 = 1
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch: java.lang.Error -> L11e java.lang.Exception -> L12c
            r9 = 0
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch: java.lang.Error -> L11e java.lang.Exception -> L12c
            r6[r9] = r10     // Catch: java.lang.Error -> L11e java.lang.Exception -> L12c
            java.lang.reflect.Method r6 = r8.getDeclaredMethod(r3, r6)     // Catch: java.lang.Error -> L11e java.lang.Exception -> L12c
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Error -> L11e java.lang.Exception -> L12c
            r8 = 0
            r9 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Error -> L11e java.lang.Exception -> L12c
            r3[r8] = r9     // Catch: java.lang.Error -> L11e java.lang.Exception -> L12c
            java.lang.Object r3 = r6.invoke(r0, r3)     // Catch: java.lang.Error -> L11e java.lang.Exception -> L12c
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Error -> L11e java.lang.Exception -> L12c
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Error -> L11e java.lang.Exception -> L131
            r8 = 0
            r9 = 1
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Error -> L11e java.lang.Exception -> L131
            r5[r8] = r9     // Catch: java.lang.Error -> L11e java.lang.Exception -> L131
            java.lang.Object r0 = r6.invoke(r0, r5)     // Catch: java.lang.Error -> L11e java.lang.Exception -> L131
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Error -> L11e java.lang.Exception -> L131
            if (r1 != 0) goto Lf5
            java.lang.String r4 = ""
        L99:
            if (r2 != 0) goto L9e
            java.lang.String r2 = ""
        L9e:
            if (r3 != 0) goto Lf7
            java.lang.String r1 = ""
        La3:
            if (r0 != 0) goto La8
            java.lang.String r0 = ""
        La8:
            r3 = 0
            cn.com.chinatelecom.account.api.c.d.c = r3     // Catch: java.lang.Error -> L11e java.lang.Exception -> L143
            r6 = r4
        Lac:
            r9 = r0
            r4 = r2
            r3 = r6
        Laf:
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
            if (r0 == 0) goto L14c
            java.lang.String r0 = b(r11)     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
            r2 = r0
        Lba:
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
            if (r0 == 0) goto L149
            java.lang.String r0 = a(r11)     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
        Lc4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
            r1.<init>()     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
            java.lang.String r2 = "-"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
            java.lang.String r2 = "-"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
            java.lang.String r1 = "-"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
            java.lang.StringBuilder r0 = r0.append(r9)     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
        Lf2:
            r7 = r0
            goto L9
        Lf5:
            r4 = r1
            goto L99
        Lf7:
            r1 = r3
            goto La3
        Lf9:
            r0 = move-exception
            r8 = r0
            r9 = r4
            r2 = r3
        Lfd:
            int r0 = cn.com.chinatelecom.account.api.c.d.c     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
            if (r0 < 0) goto L107
            int r0 = cn.com.chinatelecom.account.api.c.d.c     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
            int r0 = r0 + 1
            cn.com.chinatelecom.account.api.c.d.c = r0     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
        L107:
            int r0 = cn.com.chinatelecom.account.api.c.d.c     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
            r1 = 50
            if (r0 <= r1) goto L111
            r0 = 10
            cn.com.chinatelecom.account.api.c.d.d = r0     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
        L111:
            r8.printStackTrace()     // Catch: java.lang.Exception -> L118 java.lang.Error -> L11e
            r1 = r5
            r4 = r2
            r3 = r6
            goto Laf
        L118:
            r0 = move-exception
            r0.printStackTrace()
            r0 = r7
            goto Lf2
        L11e:
            r0 = move-exception
            if (r0 == 0) goto L124
            r0.printStackTrace()
        L124:
            r0 = r7
            goto Lf2
        L126:
            r0 = move-exception
            r8 = r0
            r9 = r4
            r2 = r3
            r6 = r1
            goto Lfd
        L12c:
            r0 = move-exception
            r8 = r0
            r9 = r4
            r6 = r1
            goto Lfd
        L131:
            r0 = move-exception
            r8 = r0
            r9 = r4
            r5 = r3
            r6 = r1
            goto Lfd
        L137:
            r4 = move-exception
            r8 = r4
            r9 = r0
            r5 = r3
            r6 = r1
            goto Lfd
        L13d:
            r1 = move-exception
            r8 = r1
            r9 = r0
            r5 = r3
            r6 = r4
            goto Lfd
        L143:
            r3 = move-exception
            r8 = r3
            r9 = r0
            r5 = r1
            r6 = r4
            goto Lfd
        L149:
            r0 = r1
            goto Lc4
        L14c:
            r2 = r3
            goto Lba
        L14f:
            r0 = r4
            r1 = r5
            r2 = r3
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
