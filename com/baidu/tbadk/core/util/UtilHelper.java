package com.baidu.tbadk.core.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
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
import android.widget.RemoteViews;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.moplus.MoPlusConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.plugins.DQSdkPlugin;
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

    public static boolean isNetOk() {
        return getNetStatusInfo(TbadkApplication.m252getInst().getApp().getApplicationContext()) != NetworkStateInfo.UNAVAIL;
    }

    public static void openGpu(Activity activity) {
        CompatibleUtile.getInstance().openGpu(activity);
    }

    public static void startPushService(Context context) {
        if (context == null) {
            BdLog.e(UtilHelper.class.getName(), "startPushService", " context is null!");
        }
    }

    public static void stopPushService(Context context) {
    }

    public static void startMoPlusService(Context context) {
        if (TbadkApplication.m252getInst().getIsMoPlusOpen()) {
            MoPlusConstants.startService(context);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x007a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.tbadk.core.util.UtilHelper$NetworkStateInfo] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    public static NetworkStateInfo getNetStatusInfo(Context context) {
        NetworkStateInfo networkStateInfo;
        ?? e = NetworkStateInfo.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                networkStateInfo = NetworkStateInfo.UNAVAIL;
                try {
                    e = "NetWorkCore";
                    BdLog.i("NetWorkCore", "NetworkStateInfo", "UNAVAIL");
                } catch (Exception e2) {
                    e = e2;
                }
            } else if (activeNetworkInfo.getType() == 1) {
                BdLog.i("NetWorkCore", "NetworkStateInfo", NetworkChangeReceiver.WIFI_STRING);
                networkStateInfo = NetworkStateInfo.WIFI;
            } else {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        BdLog.i("NetWorkCore", "NetworkStateInfo", "TwoG");
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
                        BdLog.i("NetWorkCore", "NetworkStateInfo", "ThreeG");
                        networkStateInfo = NetworkStateInfo.ThreeG;
                        break;
                    default:
                        BdLog.i("NetWorkCore", "NetworkStateInfo-default", "TwoG");
                        networkStateInfo = NetworkStateInfo.TwoG;
                        break;
                }
            }
            return networkStateInfo;
        } catch (Exception e3) {
            return e;
        }
    }

    public static int getBitmapMaxMemory(Context context) {
        int bitmapMaxMemory = CompatibleUtile.getInstance().getBitmapMaxMemory(context);
        BdLog.d("UtilHelper", "getBitmapMaxMemory", String.valueOf(bitmapMaxMemory));
        return bitmapMaxMemory;
    }

    public static void showToast(Context context, String str) {
        q.a(context, str);
    }

    public static void showToast(Context context, int i) {
        q.a(context, i);
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
            BdLog.e("UtilHelper", "getWifiMac", e.toString());
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
            BdLog.e("UtilHelper", "getGprsIpAddress", e.toString());
        }
        return null;
    }

    public static void quitDialog(Activity activity) {
        new AlertDialog.Builder(activity).setTitle(com.baidu.tieba.y.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.y.alert_quit_confirm).setPositiveButton(com.baidu.tieba.y.alert_yes_button, new bn(activity)).setNegativeButton(com.baidu.tieba.y.alert_no_button, new bo()).create().show();
    }

    public static String getIpFromDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (Exception e) {
            BdLog.e("UtilHelper", "getIpFromDomain", e.toString());
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
            if ((statFs.getAvailableBlocks() * statFs.getBlockSize()) / FileUtils.ONE_KB <= i) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [451=4] */
    public static final boolean webViewIsProbablyCorrupt(Context context) {
        SQLiteDatabase openOrCreateDatabase;
        try {
            openOrCreateDatabase = context.openOrCreateDatabase("webviewCache.db", 0, null);
        } catch (Throwable th) {
            try {
                if (BdLog.isDebugMode()) {
                    BdLog.e(UtilHelper.class.getName(), "webViewIsProbablyCorrupt", th.getMessage());
                }
            } finally {
                m.a((SQLiteDatabase) null);
            }
        }
        if (openOrCreateDatabase != null) {
            m.a(openOrCreateDatabase);
            return false;
        }
        m.a(openOrCreateDatabase);
        return true;
    }

    public static void install_apk(Context context, String str) {
        File d;
        if (str != null && str.length() > 0 && (d = x.d(str)) != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(d), "application/vnd.android.package-archive");
            context.startActivity(intent);
        }
    }

    public static boolean commenDealIntent(Context context, Intent intent) {
        DQSdkPlugin dQSdkPlugin;
        if (intent != null) {
            switch (intent.getExtras().getInt("class", -1)) {
                case 0:
                    com.baidu.tbadk.browser.a.a(context, intent.getExtras().getString("url"));
                    return true;
                case 1:
                    String stringExtra = intent.getStringExtra("id");
                    String stringExtra2 = intent.getStringExtra("from");
                    if (intent.getBooleanExtra("is_message_pv", false)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2006001, new com.baidu.tbadk.core.atomData.as(context).a(stringExtra, (String) null, stringExtra2, intent.getLongExtra("message_id", 0L))));
                        return true;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2006001, new com.baidu.tbadk.core.atomData.as(context).a(stringExtra, null, stringExtra2)));
                    return true;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2005000, new com.baidu.tbadk.core.atomData.m(context).a(intent.getStringExtra("fname"), intent.getStringExtra("from"))));
                    return true;
                case 3:
                    if (com.baidu.tbadk.core.b.b.a() == null) {
                        return true;
                    }
                    intent.setClass(context, com.baidu.tbadk.core.b.b.a());
                    context.startActivity(intent);
                    return true;
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
                    int intExtra8 = intent.getIntExtra("live_notify_msg_updates", 0);
                    int intExtra9 = intent.getIntExtra("officialbar_msg", 0);
                    int intExtra10 = intent.getIntExtra("KeyOfNotiId", 16);
                    com.baidu.tbadk.coreExtra.messageCenter.a.a().a(com.baidu.tbadk.coreExtra.messageCenter.a.a().k(), com.baidu.tbadk.coreExtra.messageCenter.a.a().l(), intExtra3, com.baidu.tbadk.coreExtra.messageCenter.a.a().o());
                    BdLog.d("group_msg:" + intExtra5 + " group_msg_validate:" + intExtra6 + " group_msg_updates" + intExtra7 + "officialbar_msg=" + intExtra9);
                    if (intExtra2 > 0 || intExtra > 0 || intExtra4 > 0 || intExtra7 > 0 || intExtra6 > 0 || intExtra5 > 0 || intExtra9 > 0 || intExtra8 > 0) {
                        com.baidu.tbadk.core.atomData.am.a = true;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bb(context, intExtra10)));
                        return false;
                    }
                case 8:
                    com.baidu.tbadk.core.b.b.a(context, 2);
                    return true;
                case 9:
                    if (com.baidu.tbadk.core.b.b.a() == null) {
                        return true;
                    }
                    intent.setClass(context, com.baidu.tbadk.core.b.b.a());
                    context.startActivity(intent);
                    return true;
                case 10:
                    com.baidu.tbadk.core.b.b.a(context, 4);
                    return true;
                case 11:
                    int intExtra11 = intent.getIntExtra("at_me", 0);
                    int intExtra12 = intent.getIntExtra("reply_me", 0);
                    int intExtra13 = intent.getIntExtra("chat", 0);
                    int intExtra14 = intent.getIntExtra("fans", 0);
                    int intExtra15 = intent.getIntExtra("group_msg", 0);
                    int intExtra16 = intent.getIntExtra("group_msg_validate", 0);
                    int intExtra17 = intent.getIntExtra("group_msg_updates", 0);
                    int intExtra18 = intent.getIntExtra("live_notify_msg_updates", 0);
                    int intExtra19 = intent.getIntExtra("officialbar_msg", 0);
                    int intExtra20 = intent.getIntExtra("KeyOfNotiId", 11);
                    com.baidu.tbadk.coreExtra.messageCenter.a.a().a(com.baidu.tbadk.coreExtra.messageCenter.a.a().k(), com.baidu.tbadk.coreExtra.messageCenter.a.a().l(), intExtra14, com.baidu.tbadk.coreExtra.messageCenter.a.a().o());
                    BdLog.d("group_msg1:" + intExtra15 + " group_msg_validate1 " + intExtra16 + " group_msg_updates1 " + intExtra17 + "officialbar_msg=" + intExtra19);
                    if (intExtra12 > 0 || intExtra11 > 0 || intExtra13 > 0 || intExtra17 > 0 || intExtra16 > 0 || intExtra15 > 0 || intExtra19 > 0 || intExtra18 > 0) {
                        com.baidu.tbadk.core.atomData.am.a = true;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bb(context, intExtra20)));
                        return false;
                    }
                case 12:
                    String currentAccount = TbadkApplication.getCurrentAccount();
                    String currentAccountName = TbadkApplication.getCurrentAccountName();
                    if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003003, new com.baidu.tbadk.core.atomData.at(context, currentAccount, currentAccountName)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(MessageTypes.CMD_ENTER_PERSONINFO_FROM_NOTIFI_LOCAL));
                        return false;
                    }
                    break;
                case 13:
                    com.baidu.tbadk.core.atomData.q qVar = new com.baidu.tbadk.core.atomData.q(context, com.baidu.adp.lib.f.b.a(intent.getStringExtra("groupid"), 0L), 0);
                    if (context instanceof BaseActivity) {
                        ((BaseActivity) context).sendMessage(new CustomMessage(2010011, qVar));
                        return true;
                    } else if (!(context instanceof BaseFragmentActivity)) {
                        return true;
                    } else {
                        ((BaseFragmentActivity) context).a(new CustomMessage(2010011, qVar));
                        return true;
                    }
                case DealIntentService.CLASS_TYPE_GROUP_EVENT /* 14 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2010013));
                    return true;
                case 15:
                    String stringExtra3 = intent.getStringExtra(PayActivityConfig.PAY_TYPE);
                    String stringExtra4 = intent.getStringExtra(PayActivityConfig.PROPS_ID);
                    String stringExtra5 = intent.getStringExtra(PayActivityConfig.QUAN_NUM);
                    String stringExtra6 = intent.getStringExtra(PayActivityConfig.IS_LEFT);
                    String stringExtra7 = intent.getStringExtra(PayActivityConfig.PROPS_MON);
                    if (TbadkApplication.m252getInst().isDQShouldOpen() && (dQSdkPlugin = (DQSdkPlugin) com.baidu.tbadk.tbplugin.m.a().b(DQSdkPlugin.class)) != null) {
                        dQSdkPlugin.startActivity(context, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7);
                        return false;
                    }
                    break;
                case 16:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ad(context)));
                    return true;
                case 17:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ae(context, com.baidu.adp.lib.f.b.a(intent.getStringExtra("groupid"), -1))));
                    return true;
                case 18:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2017002, new com.baidu.tbadk.core.atomData.bd(context, "", false)));
                    return false;
                case 19:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfig.SINGLE_SQUARE_CUSTOM_CMD, new com.baidu.tbadk.core.atomData.bc(context)));
                    return false;
                case 20:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.aq(context, com.baidu.tbadk.core.atomData.aq.d)));
                    return false;
            }
        }
        return false;
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

    public static void showNotification(Context context, com.baidu.tbadk.core.data.k kVar, int i) {
        boolean z;
        boolean z2;
        int hours = new Date(System.currentTimeMillis()).getHours();
        if ((hours < 0 || hours > 7) && hours < 23) {
            long time = new Date().getTime();
            if (com.baidu.tbadk.coreExtra.messageCenter.a.c()) {
                z = false;
                z2 = false;
            } else if (time - TbadkApplication.m252getInst().getLastNotifyTime() >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                boolean z3 = TbadkApplication.m252getInst().isMsgToneOn();
                z = TbadkApplication.m252getInst().isMsgVibrateOn();
                TbadkApplication.m252getInst().setLastNotifyTime(time);
                z2 = z3;
            } else {
                z = false;
                z2 = false;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            String d = kVar.d();
            String c = kVar.c();
            if (TbadkApplication.m252getInst().isPromotedMessageOn()) {
                Notification notification = new Notification(com.baidu.tieba.u.icon, d, System.currentTimeMillis());
                if (c != null && c.length() > 0) {
                    Intent intent = new Intent(context, DealIntentService.class);
                    if (c.startsWith("http:")) {
                        String substring = c.substring(c.lastIndexOf("/") + 1);
                        intent.putExtra("class", 1);
                        intent.putExtra("id", substring);
                        intent.putExtra("is_message_pv", true);
                    } else if (c.equals("tab://1")) {
                        intent.putExtra("class", 3);
                        intent.putExtra("is_message_pv", true);
                        intent.putExtra("refresh_all", true);
                        intent.putExtra("close_dialog", true);
                        intent.putExtra("locate_type", 0);
                        intent.setFlags(603979776);
                        TbadkApplication.m252getInst().setWebviewCrashCount(0);
                    } else if (c.startsWith("opfeature:")) {
                        try {
                            intent.putExtra("class", 0);
                            c = c.replaceFirst("opfeature:", "http://");
                            intent.putExtra("url", c);
                            intent.putExtra("is_message_pv", true);
                        } catch (Exception e) {
                            BdLog.i("MessagePullService", "showNotification", e.toString());
                            return;
                        }
                    } else if (c.startsWith("pk_before:")) {
                        intent.putExtra("class", 6);
                        intent.putExtra("value", c.substring(c.lastIndexOf(":") + 1));
                    } else if (c.startsWith("pk_after:")) {
                        intent.putExtra("class", 7);
                        intent.putExtra("value", c.substring(c.lastIndexOf(":") + 1));
                    } else if (c.startsWith("vote")) {
                        intent.putExtra("class", 8);
                    } else {
                        return;
                    }
                    intent.putExtra("is_notify", true);
                    intent.putExtra("link", c);
                    intent.putExtra("message_id", kVar.b());
                    if (!TextUtils.isEmpty(kVar.a())) {
                        intent.putExtra("stat", kVar.a());
                    }
                    PendingIntent service = PendingIntent.getService(context, 0, intent, 134217728);
                    String string = context.getString(com.baidu.tieba.y.app_name);
                    notification.icon = com.baidu.tieba.u.icon_notify;
                    notification.setLatestEventInfo(context, string, d, service);
                    RemoteViews remoteViews = new RemoteViews(TbadkApplication.m252getInst().getApp().getPackageName(), com.baidu.tieba.w.custom_notification);
                    remoteViews.setImageViewResource(com.baidu.tieba.v.notification_icon, com.baidu.tieba.u.icon);
                    remoteViews.setTextViewText(com.baidu.tieba.v.notification_content, d);
                    remoteViews.setTextViewText(com.baidu.tieba.v.notification_time, be.b(new Date()));
                    notification.contentView = remoteViews;
                    notification.defaults = -1;
                    if (!z) {
                        notification.defaults &= -3;
                    }
                    if (!z2) {
                        notification.defaults &= -2;
                    } else {
                        notification.audioStreamType = 5;
                    }
                    notification.flags |= 16;
                    notificationManager.notify(i, notification);
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
                return com.baidu.adp.lib.util.j.a(new FileInputStream(file));
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
