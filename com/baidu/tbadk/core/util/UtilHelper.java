package com.baidu.tbadk.core.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.view.MotionEventCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.moplus.MoPlusConstants;
import com.baidu.android.pushservice.PushManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
/* loaded from: classes.dex */
public class UtilHelper {

    /* loaded from: classes.dex */
    public enum NetworkStateInfo {
        UNAVAIL,
        WIFI,
        TwoG,
        ThreeG;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetworkStateInfo[] valuesCustom() {
            NetworkStateInfo[] valuesCustom = values();
            int length = valuesCustom.length;
            NetworkStateInfo[] networkStateInfoArr = new NetworkStateInfo[length];
            System.arraycopy(valuesCustom, 0, networkStateInfoArr, 0, length);
            return networkStateInfoArr;
        }
    }

    public static boolean a() {
        return d(TbadkApplication.j().b().getApplicationContext()) != NetworkStateInfo.UNAVAIL;
    }

    public static void a(Activity activity) {
        CompatibleUtile.getInstance().openGpu(activity);
    }

    public static void a(Context context) {
        if (context == null) {
            com.baidu.adp.lib.util.f.b(UtilHelper.class.getName(), "startPushService", " context is null!");
            return;
        }
        try {
            String D = TbadkApplication.D();
            if (TextUtils.isEmpty(D)) {
                PushManager.startWork(context, 0, "GXGROE8KmWiRmcWFpiWTmUbE");
                return;
            }
            int indexOf = D.indexOf("|");
            if (indexOf > 0) {
                D = D.substring(0, indexOf);
            }
            PushManager.startWork(context, "1095821", D);
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b("PushService start failed");
        }
    }

    public static void b(Context context) {
        try {
            PushManager.stopWork(context);
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b("PushService stop failed");
        }
    }

    public static void c(Context context) {
        MoPlusConstants.startService(context);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0069 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.tbadk.core.util.UtilHelper$NetworkStateInfo] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    public static NetworkStateInfo d(Context context) {
        NetworkStateInfo networkStateInfo;
        ?? e = NetworkStateInfo.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                networkStateInfo = NetworkStateInfo.UNAVAIL;
                try {
                    e = "NetWorkCore";
                    com.baidu.adp.lib.util.f.a("NetWorkCore", "NetworkStateInfo", "UNAVAIL");
                } catch (Exception e2) {
                    e = e2;
                }
            } else if (activeNetworkInfo.getType() == 1) {
                com.baidu.adp.lib.util.f.a("NetWorkCore", "NetworkStateInfo", "WIFI");
                networkStateInfo = NetworkStateInfo.WIFI;
            } else {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        com.baidu.adp.lib.util.f.a("NetWorkCore", "NetworkStateInfo", "TwoG");
                        networkStateInfo = NetworkStateInfo.TwoG;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        com.baidu.adp.lib.util.f.a("NetWorkCore", "NetworkStateInfo", "ThreeG");
                        networkStateInfo = NetworkStateInfo.ThreeG;
                        break;
                    default:
                        com.baidu.adp.lib.util.f.a("NetWorkCore", "NetworkStateInfo-default", "TwoG");
                        networkStateInfo = NetworkStateInfo.TwoG;
                        break;
                }
            }
            return networkStateInfo;
        } catch (Exception e3) {
            return e;
        }
    }

    public static int e(Context context) {
        int bitmapMaxMemory = CompatibleUtile.getInstance().getBitmapMaxMemory(context);
        com.baidu.adp.lib.util.f.e("UtilHelper", "getBitmapMaxMemory", String.valueOf(bitmapMaxMemory));
        return bitmapMaxMemory;
    }

    public static void a(Context context, String str) {
        p.a(context, str);
    }

    public static void a(Context context, int i) {
        p.a(context, i);
    }

    @SuppressLint({"DefaultLocale"})
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Matcher matcher = Pattern.compile("http(s)?://([\\w-]+\\.)+[\\w-]+/?").matcher(str.toLowerCase());
        String str2 = "";
        if (matcher.find()) {
            str2 = matcher.group();
            if (str2.indexOf(com.baidu.loginshare.e.f) >= 0) {
                str2 = str2.replace(com.baidu.loginshare.e.f, "");
            } else if (str2.indexOf(com.baidu.loginshare.e.g) >= 0) {
                str2 = str2.replace(com.baidu.loginshare.e.g, "");
            }
        }
        return str2.replace("/", "");
    }

    public static String f(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (!wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(true);
            }
            int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
            return String.valueOf(ipAddress & MotionEventCompat.ACTION_MASK) + "." + ((ipAddress >> 8) & MotionEventCompat.ACTION_MASK) + "." + ((ipAddress >> 16) & MotionEventCompat.ACTION_MASK) + "." + ((ipAddress >> 24) & MotionEventCompat.ACTION_MASK);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("UtilHelper", "getWifiMac", e.toString());
            return null;
        }
    }

    public static String b() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException e) {
            com.baidu.adp.lib.util.f.b("UtilHelper", "getGprsIpAddress", e.toString());
        }
        return null;
    }

    public static void b(Activity activity) {
        new AlertDialog.Builder(activity).setTitle(com.baidu.tbadk.l.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tbadk.l.alert_quit_confirm).setPositiveButton(com.baidu.tbadk.l.alert_yes_button, new bl(activity)).setNegativeButton(com.baidu.tbadk.l.alert_no_button, new bm()).create().show();
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("UtilHelper", "getIpFromDomain", e.toString());
            return null;
        }
    }

    public static String a(String str, int i) {
        StringBuilder sb = new StringBuilder();
        double d = 0.0d;
        int i2 = 0;
        while (true) {
            if (i2 >= str.length()) {
                break;
            }
            char charAt = str.charAt(i2);
            if ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || (charAt >= '0' && charAt <= '9'))) {
                d += 0.5d;
            } else {
                d += 1.0d;
            }
            if (d <= i) {
                sb.append(charAt);
                i2++;
            } else {
                sb.append("...");
                break;
            }
        }
        return sb.toString();
    }

    public static boolean a(long j, long j2) {
        return j <= j2 && j / 86400000 == j2 / 86400000;
    }

    public static boolean g(Context context) {
        return Build.VERSION.SDK_INT > 4 && CompatibleUtile.getInstance().supportMultiTouch(context);
    }

    public static boolean a(int i) {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return false;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            if ((statFs.getAvailableBlocks() * statFs.getBlockSize()) / FileUtils.ONE_KB <= FileUtils.ONE_KB) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [423=4] */
    public static final boolean h(Context context) {
        SQLiteDatabase openOrCreateDatabase;
        try {
            openOrCreateDatabase = context.openOrCreateDatabase("webviewCache.db", 0, null);
        } catch (Throwable th) {
            try {
                if (com.baidu.adp.lib.util.f.a()) {
                    com.baidu.adp.lib.util.f.b(UtilHelper.class.getName(), "webViewIsProbablyCorrupt", th.getMessage());
                }
            } finally {
                l.a((SQLiteDatabase) null);
            }
        }
        if (openOrCreateDatabase != null) {
            l.a(openOrCreateDatabase);
            return false;
        }
        l.a(openOrCreateDatabase);
        return true;
    }

    public static void b(Context context, String str) {
        File d;
        if (str != null && str.length() > 0 && (d = w.d(str)) != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(d), "application/vnd.android.package-archive");
            context.startActivity(intent);
        }
    }

    public static boolean a(Context context, Intent intent) {
        if (intent != null) {
            switch (intent.getExtras().getInt("class", -1)) {
                case 0:
                    com.baidu.tbadk.browser.a.a(context, intent.getExtras().getString("url"));
                    return true;
                case 1:
                    String stringExtra = intent.getStringExtra("id");
                    String stringExtra2 = intent.getStringExtra("from");
                    if (intent.getBooleanExtra("is_message_pv", false)) {
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2004001, new com.baidu.tbadk.core.b.af(context).a(stringExtra, null, stringExtra2, intent.getLongExtra("message_id", 0L))));
                        return true;
                    }
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2004001, new com.baidu.tbadk.core.b.af(context).a(stringExtra, null, stringExtra2)));
                    return true;
                case 2:
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(context).a(intent.getStringExtra("fname"), intent.getStringExtra("from"))));
                    return true;
                case 3:
                    if (com.baidu.tbadk.core.d.b.a() != null) {
                        intent.setClass(context, com.baidu.tbadk.core.d.b.a());
                        context.startActivity(intent);
                        return true;
                    }
                    break;
                case 4:
                case 6:
                case 7:
                default:
                    return false;
                case 5:
                    int intExtra = intent.getIntExtra("at_me", 0);
                    int intExtra2 = intent.getIntExtra("reply_me", 0);
                    int intExtra3 = intent.getIntExtra("fans", 0);
                    int intExtra4 = intent.getIntExtra("chat", 0);
                    int intExtra5 = intent.getIntExtra("group_msg", 0);
                    int intExtra6 = intent.getIntExtra("group_msg_validate", 0);
                    int intExtra7 = intent.getIntExtra("group_msg_updates", 0);
                    int intExtra8 = intent.getIntExtra("officialbar_msg", 0);
                    int intExtra9 = intent.getIntExtra("KeyOfNotiId", 16);
                    com.baidu.tbadk.coreExtra.messageCenter.a.a().a(intExtra2, intExtra, intExtra3, intExtra4);
                    com.baidu.adp.lib.util.f.e("group_msg:" + intExtra5 + " group_msg_validate:" + intExtra6 + " group_msg_updates" + intExtra7 + "officialbar_msg=" + intExtra8);
                    if (intExtra2 > 0 || intExtra > 0 || intExtra4 > 0 || intExtra7 > 0 || intExtra6 > 0 || intExtra5 > 0 || intExtra8 > 0) {
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.ap(context, intExtra9)));
                        return false;
                    }
                    return false;
                case 8:
                    com.baidu.tbadk.core.d.b.a(context, 2);
                    return true;
                case 9:
                    if (com.baidu.tbadk.core.d.b.a() != null) {
                        intent.setClass(context, com.baidu.tbadk.core.d.b.a());
                        context.startActivity(intent);
                        return true;
                    }
                    break;
                case 10:
                    com.baidu.tbadk.core.d.b.a(context, 4);
                    return true;
                case 11:
                    int intExtra10 = intent.getIntExtra("at_me", 0);
                    int intExtra11 = intent.getIntExtra("reply_me", 0);
                    int intExtra12 = intent.getIntExtra("fans", 0);
                    int intExtra13 = intent.getIntExtra("chat", 0);
                    int intExtra14 = intent.getIntExtra("group_msg", 0);
                    int intExtra15 = intent.getIntExtra("group_msg_validate", 0);
                    int intExtra16 = intent.getIntExtra("group_msg_updates", 0);
                    int intExtra17 = intent.getIntExtra("officialbar_msg", 0);
                    int intExtra18 = intent.getIntExtra("KeyOfNotiId", 16);
                    com.baidu.tbadk.coreExtra.messageCenter.a.a().a(intExtra11, intExtra10, intExtra12, intExtra13);
                    com.baidu.adp.lib.util.f.e("group_msg1:" + intExtra14 + " group_msg_validate1 " + intExtra15 + " group_msg_updates1 " + intExtra16 + "officialbar_msg=" + intExtra17);
                    if (intExtra11 > 0 || intExtra10 > 0 || intExtra13 > 0 || intExtra16 > 0 || intExtra15 > 0 || intExtra14 > 0 || intExtra17 > 0) {
                        com.baidu.tbadk.core.b.ab.a = true;
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.ap(context, intExtra18)));
                        return false;
                    }
                    return false;
                case 12:
                    String E = TbadkApplication.E();
                    String O = TbadkApplication.O();
                    if (TextUtils.isEmpty(E) || TextUtils.isEmpty(O)) {
                        return false;
                    }
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tbadk.core.b.ag(context, E, O)));
                    return false;
                case 13:
                    com.baidu.tbadk.core.b.o oVar = new com.baidu.tbadk.core.b.o(context, com.baidu.adp.lib.f.b.a(intent.getStringExtra("groupid"), 0L), 0);
                    if (context instanceof com.baidu.tbadk.a) {
                        ((com.baidu.tbadk.a) context).sendMessage(new com.baidu.adp.framework.message.a(2008011, oVar));
                        return true;
                    } else if (context instanceof com.baidu.tbadk.core.e) {
                        ((com.baidu.tbadk.core.e) context).a(new com.baidu.adp.framework.message.a(2008011, oVar));
                        return true;
                    }
                    break;
                case 14:
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2008013));
                    return true;
            }
            return true;
        }
        return false;
    }
}
