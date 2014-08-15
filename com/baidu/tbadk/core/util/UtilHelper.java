package com.baidu.tbadk.core.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.aladin.AladinServer;
import com.baidu.tbadk.core.atomData.PayActivityConfig;
import com.baidu.tbadk.core.atomData.bw;
import com.baidu.tbadk.core.atomData.bx;
import com.baidu.tbadk.core.atomData.by;
import com.baidu.tbadk.core.atomData.cb;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.plugins.DQSdkPlugin;
import com.baidu.tbadk.plugins.LightAppPlugin;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Enumeration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    public static boolean isNetOk() {
        return getNetStatusInfo(TbadkApplication.m252getInst().getApp().getApplicationContext()) != NetworkStateInfo.UNAVAIL;
    }

    public static void openGpu(Activity activity) {
        CompatibleUtile.getInstance().openGpu(activity);
    }

    public static void startPushService(Context context) {
        if (context == null) {
        }
    }

    public static void stopPushService(Context context) {
    }

    public static void startMoPlusService(Context context) {
        AladinServer.start(context);
    }

    public static NetworkStateInfo getNetStatusInfo(Context context) {
        NetworkStateInfo networkStateInfo;
        NetworkStateInfo networkStateInfo2 = NetworkStateInfo.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                networkStateInfo = NetworkStateInfo.UNAVAIL;
            } else if (activeNetworkInfo.getType() == 1) {
                networkStateInfo = NetworkStateInfo.WIFI;
            } else {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
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
                    case DealIntentService.CLASS_TYPE_GROUP_EVENT /* 14 */:
                    case 15:
                        networkStateInfo = NetworkStateInfo.ThreeG;
                        break;
                    default:
                        networkStateInfo = NetworkStateInfo.TwoG;
                        break;
                }
            }
            return networkStateInfo;
        } catch (Exception e) {
            return networkStateInfo2;
        }
    }

    public static int getBitmapMaxMemory(Context context) {
        return CompatibleUtile.getInstance().getBitmapMaxMemory(context);
    }

    public static void showToast(Context context, String str) {
        m.a(context, str);
    }

    public static void showToast(Context context, int i) {
        m.a(context, i);
    }

    @SuppressLint({"DefaultLocale"})
    public static String getDomainName(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Matcher matcher = Pattern.compile("http(s)?://([\\w-]+\\.)+[\\w-]+/?").matcher(str.toLowerCase());
        String str2 = "";
        if (matcher.find()) {
            str2 = matcher.group();
            if (str2.indexOf("http://") > -1) {
                str2 = str2.replace("http://", "");
            } else if (str2.indexOf("https://") > -1) {
                str2 = str2.replace("https://", "");
            }
        }
        return str2.replace("/", "");
    }

    private static String intToIp(int i) {
        return String.valueOf(i & MotionEventCompat.ACTION_MASK) + "." + ((i >> 8) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 16) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    public static String getWifiMac(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (!wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(true);
            }
            return intToIp(wifiManager.getConnectionInfo().getIpAddress());
        } catch (Exception e) {
            BdLog.e(e.toString());
            return null;
        }
    }

    public static String getGprsIpAddress() {
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
            BdLog.e(e.toString());
        }
        return null;
    }

    public static void quitDialog(Activity activity) {
        com.baidu.adp.lib.e.d.a(new AlertDialog.Builder(activity).setTitle(com.baidu.tieba.x.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.x.alert_quit_confirm).setPositiveButton(com.baidu.tieba.x.alert_yes_button, new bl(activity)).setNegativeButton(com.baidu.tieba.x.alert_no_button, new bm()).create(), activity);
    }

    public static String getIpFromDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public static String getFixedText(String str, int i) {
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

    public static boolean isSameDay(long j, long j2) {
        return j <= j2 && j / 86400000 == j2 / 86400000;
    }

    public static boolean isSupportGesture(Context context) {
        return Build.VERSION.SDK_INT > 4 && CompatibleUtile.getInstance().supportMultiTouch(context);
    }

    public static boolean hasAvaiableSDCardSpace(int i) {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return false;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            if ((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024 <= i) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static final boolean webViewIsProbablyCorrupt(Context context) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        try {
            newSingleThreadExecutor.shutdown();
            return ((Boolean) newSingleThreadExecutor.submit(new bn(context)).get()).booleanValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return true;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static void install_apk(Context context, String str) {
        File d;
        if (str != null && str.length() > 0 && (d = s.d(str)) != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(d), "application/vnd.android.package-archive");
            context.startActivity(intent);
        }
    }

    public static boolean startApk(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setComponent(new ComponentName(str, str2));
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            com.baidu.adp.lib.util.j.a(context, com.baidu.tieba.x.game_start_fail);
            return false;
        }
    }

    public static boolean isInstallApk(Context context, String str) {
        PackageInfo packageInfo;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static void commenDealUrl(Context context, String str, String... strArr) {
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 4 && str.startsWith("web:")) {
                String substring = str.substring(4);
                String str2 = strArr[0];
                if (!TextUtils.isEmpty(substring)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new cb(context, str2, substring, false)));
                }
            } else if (str.length() > 4 && str.startsWith("frs:")) {
                String substring2 = str.substring(4);
                if (!TextUtils.isEmpty(substring2)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.s(context).a(substring2, "official_bar")));
                }
            } else if (str.length() > 4 && str.startsWith("pb:")) {
                String substring3 = str.substring(3);
                if (!TextUtils.isEmpty(substring3)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new com.baidu.tbadk.core.atomData.bb(context).a(substring3, null, "official_bar")));
                }
            }
        }
    }

    public static void launchWebGameActivity(Context context, String str, String str2) {
        com.baidu.tbadk.pluginArch.c a;
        LightAppPlugin lightAppPlugin;
        if (com.baidu.adp.lib.a.f.a().b("t5core") == 0 && (a = com.baidu.tbadk.pluginArch.d.a().a("lightapp")) != null && (lightAppPlugin = (LightAppPlugin) a.a(LightAppPlugin.class)) != null) {
            lightAppPlugin.launchLightApp(context, TbConfig.api_key, str2);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.w(context, str, str2, true)));
        }
    }

    public static boolean commenDealIntent(Context context, Intent intent) {
        boolean z;
        com.baidu.tbadk.core.atomData.al alVar;
        com.baidu.tbadk.pluginArch.c a;
        DQSdkPlugin dQSdkPlugin;
        boolean z2 = false;
        if (intent == null) {
            return false;
        }
        int i = intent.getExtras().getInt("class", -1);
        switch (i) {
            case 0:
                com.baidu.tbadk.browser.a.a(context, intent.getExtras().getString("url"));
                z = true;
                break;
            case 1:
                String stringExtra = intent.getStringExtra("id");
                String stringExtra2 = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FROM);
                if (intent.getBooleanExtra("is_message_pv", false)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new com.baidu.tbadk.core.atomData.bb(context).a(stringExtra, (String) null, stringExtra2, intent.getLongExtra("message_id", 0L))));
                    z = true;
                    break;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new com.baidu.tbadk.core.atomData.bb(context).a(stringExtra, null, stringExtra2)));
                    z = true;
                    break;
                }
            case 2:
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.s(context).a(intent.getStringExtra("fname"), intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FROM))));
                z = true;
                break;
            case 3:
                z2 = true;
                if (com.baidu.tbadk.core.b.b.a() != null) {
                    intent.setClass(context, com.baidu.tbadk.core.b.b.a());
                    context.startActivity(intent);
                    z = true;
                    break;
                }
                z = z2;
                break;
            case 4:
            case 6:
            case 7:
            case 10:
            default:
                z = false;
                break;
            case 5:
            case 11:
            case 21:
                z2 = true;
                int intExtra = intent.getIntExtra("at_me", 0);
                int intExtra2 = intent.getIntExtra("reply_me", 0);
                int intExtra3 = intent.getIntExtra("chat", 0);
                int intExtra4 = intent.getIntExtra("group_msg", 0);
                int intExtra5 = intent.getIntExtra("group_msg_validate", 0);
                int intExtra6 = intent.getIntExtra("group_msg_updates", 0);
                int intExtra7 = intent.getIntExtra("live_notify_msg_updates", 0);
                int intExtra8 = intent.getIntExtra("officialbar_msg", 0);
                int intExtra9 = intent.getIntExtra("KeyOfNotiId", 16);
                com.baidu.tbadk.coreExtra.messageCenter.a.a().a(com.baidu.tbadk.coreExtra.messageCenter.a.a().m(), com.baidu.tbadk.coreExtra.messageCenter.a.a().n(), com.baidu.tbadk.coreExtra.messageCenter.a.a().p(), com.baidu.tbadk.coreExtra.messageCenter.a.a().q());
                boolean z3 = intExtra3 > 0 || intExtra6 > 0 || intExtra5 > 0 || intExtra4 > 0 || intExtra8 > 0 || intExtra7 > 0;
                boolean z4 = intExtra2 > 0 || intExtra > 0;
                if (z3 && intExtra9 != 11) {
                    if (i == 5 && com.baidu.tbadk.core.b.b.c() == 3) {
                        com.baidu.tbadk.core.b.b.a(context, 3);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.h(context)));
                    }
                }
                if (z4 && intExtra9 == 11) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new bw(context, intExtra9, false)));
                    z = true;
                    break;
                }
                z = z2;
                break;
            case 8:
                com.baidu.tbadk.core.b.b.a(context, 2);
                z = true;
                break;
            case 9:
                z2 = true;
                if (com.baidu.tbadk.core.b.b.a() != null) {
                    intent.setClass(context, com.baidu.tbadk.core.b.b.a());
                    context.startActivity(intent);
                    z = true;
                    break;
                }
                z = z2;
                break;
            case 12:
                String currentAccount = TbadkApplication.getCurrentAccount();
                String currentAccountName = TbadkApplication.getCurrentAccountName();
                if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new com.baidu.tbadk.core.atomData.bg(context, currentAccount, currentAccountName)));
                    z = true;
                    break;
                }
                z = z2;
                break;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage(2008011, new com.baidu.tbadk.core.atomData.y(context, com.baidu.adp.lib.e.b.a(intent.getStringExtra("groupid"), 0L), 0)));
                z = true;
                break;
            case DealIntentService.CLASS_TYPE_GROUP_EVENT /* 14 */:
                MessageManager.getInstance().sendMessage(new CustomMessage(2008013));
                z = true;
                break;
            case 15:
                String stringExtra3 = intent.getStringExtra(PayActivityConfig.PAY_TYPE);
                String stringExtra4 = intent.getStringExtra(PayActivityConfig.PROPS_ID);
                String stringExtra5 = intent.getStringExtra(PayActivityConfig.QUAN_NUM);
                String stringExtra6 = intent.getStringExtra(PayActivityConfig.IS_LEFT);
                String stringExtra7 = intent.getStringExtra(PayActivityConfig.PROPS_MON);
                if (TbadkApplication.m252getInst().isDQShouldOpen() && (a = com.baidu.tbadk.pluginArch.d.a().a("dqsdk")) != null && (dQSdkPlugin = (DQSdkPlugin) a.a(DQSdkPlugin.class)) != null) {
                    dQSdkPlugin.startActivity(context, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7);
                    z = true;
                    break;
                }
                z = z2;
                break;
            case 16:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ak(context)));
                z = true;
                break;
            case 17:
                if (context instanceof Activity) {
                    alVar = new com.baidu.tbadk.core.atomData.al(context, com.baidu.adp.lib.e.b.a(intent.getStringExtra("groupid"), -1));
                } else {
                    alVar = new com.baidu.tbadk.core.atomData.al(context, com.baidu.adp.lib.e.b.a(intent.getStringExtra("groupid"), -1), "");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, alVar));
                z = true;
                break;
            case 18:
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new by(context, "", false)));
                z = true;
                break;
            case 19:
                MessageManager.getInstance().sendMessage(new CustomMessage(2010010, new bx(context)));
                z = true;
                break;
            case 20:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.az(context, com.baidu.tbadk.core.atomData.az.d)));
                z = true;
                break;
            case 22:
                String stringExtra8 = intent.getStringExtra("barid");
                String stringExtra9 = intent.getStringExtra("barname");
                String stringExtra10 = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                long a2 = com.baidu.adp.lib.e.b.a(stringExtra8, -1L);
                if (a2 > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new com.baidu.tbadk.core.atomData.ba(context, a2, stringExtra9, stringExtra10, 0)));
                    z = true;
                    break;
                }
                z = z2;
                break;
            case DealIntentService.CLASS_TYPE_NATIVE_PAY /* 23 */:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.at(context, Integer.parseInt(intent.getStringExtra("wanted_type")))));
                z = true;
                break;
        }
        if (!z) {
            intent.putExtra("class", 3);
            return commenDealIntent(context, intent);
        }
        return z;
    }

    public static String getSystemProperty(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = null;
        try {
            bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
        } catch (IOException e) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader2.readLine();
            bufferedReader2.close();
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                    return readLine;
                } catch (IOException e2) {
                    return readLine;
                }
            }
            return readLine;
        } catch (IOException e3) {
            bufferedReader = bufferedReader2;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader3 = bufferedReader2;
            if (bufferedReader3 != null) {
                try {
                    bufferedReader3.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
    }

    public static void showYYNotification(Context context, com.baidu.tbadk.core.data.k kVar, int i) {
        if (TbadkApplication.m252getInst().isPromotedMessageOn()) {
            int hours = new Date(System.currentTimeMillis()).getHours();
            if ((hours < 0 || hours > 7) && hours < 23) {
                String e = kVar.e();
                String d = kVar.d();
                if (d != null && d.length() > 0) {
                    Intent intent = new Intent(context, DealIntentService.class);
                    if (d.startsWith("http:")) {
                        String substring = d.substring(d.lastIndexOf("/") + 1);
                        intent.putExtra("class", 1);
                        intent.putExtra("id", substring);
                        intent.putExtra("is_message_pv", true);
                    } else if (d.equals("tab://1")) {
                        intent.putExtra("class", 3);
                        intent.putExtra("is_message_pv", true);
                        intent.putExtra("refresh_all", true);
                        intent.putExtra("close_dialog", true);
                        intent.putExtra("locate_type", 0);
                        intent.setFlags(603979776);
                        TbadkApplication.m252getInst().setWebviewCrashCount(0);
                    } else if (d.startsWith("opfeature:")) {
                        try {
                            intent.putExtra("class", 0);
                            d = d.replaceFirst("opfeature:", "http://");
                            intent.putExtra("url", d);
                            intent.putExtra("is_message_pv", true);
                        } catch (Exception e2) {
                            BdLog.e(e2.toString());
                            return;
                        }
                    } else if (d.startsWith("pk_before:")) {
                        intent.putExtra("class", 6);
                        intent.putExtra("value", d.substring(d.lastIndexOf(":") + 1));
                    } else if (d.startsWith("pk_after:")) {
                        intent.putExtra("class", 7);
                        intent.putExtra("value", d.substring(d.lastIndexOf(":") + 1));
                    } else if (d.startsWith("vote")) {
                        intent.putExtra("class", 8);
                    } else {
                        return;
                    }
                    intent.putExtra("is_notify", true);
                    intent.putExtra("link", d);
                    intent.putExtra("message_id", kVar.b());
                    intent.putExtra("task_id", kVar.c());
                    if (!TextUtils.isEmpty(kVar.a())) {
                        intent.putExtra("stat", kVar.a());
                    }
                    ap.a(context, i, (String) null, e, e, PendingIntent.getService(context, 0, intent, 134217728), false);
                }
            }
        }
    }

    public static String creatSignInt(PackageInfo packageInfo) {
        long j = 0;
        String md5 = getMd5(packageInfo);
        if (md5 == null || md5.length() < 32) {
            return "-1";
        }
        String substring = md5.substring(8, 24);
        long j2 = 0;
        for (int i = 0; i < 8; i++) {
            j2 = (j2 * 16) + Integer.parseInt(substring.substring(i, i + 1), 16);
        }
        for (int i2 = 8; i2 < substring.length(); i2++) {
            j = (j * 16) + Integer.parseInt(substring.substring(i2, i2 + 1), 16);
        }
        return String.valueOf((j + j2) & 4294967295L);
    }

    private static String getMd5(PackageInfo packageInfo) {
        String str = null;
        if (packageInfo == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(packageInfo.signatures[0].toCharsString().getBytes());
            byte[] digest = messageDigest.digest();
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (int i = 0; i < digest.length; i++) {
                sb.append(cArr[(digest[i] & 240) >>> 4]);
                sb.append(cArr[digest[i] & 15]);
            }
            str = sb.toString();
            return str;
        } catch (NoSuchAlgorithmException e) {
            BdLog.detailException(e);
            return str;
        }
    }

    public static String getAPKMd5(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        File file = new File(packageInfo.applicationInfo.publicSourceDir);
        if (file.exists()) {
            try {
                return com.baidu.adp.lib.util.i.a(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return null;
    }

    public static String getCurrentVerson(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
