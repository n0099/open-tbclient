package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.view.MotionEventCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AladinServerConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.LiveNotifyActivityConfig;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PayActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SingleMentionActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.plugins.DQSdkPlugin;
import com.baidu.tbadk.plugins.XiubaPlugin;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class UtilHelper {
    public static final int PROCESS_LIMIT_NONE = 0;
    private static final Pattern pbPattern0 = Pattern.compile("(tieba.baidu.com/p/){1}([\\d]+)");

    /* loaded from: classes.dex */
    public enum NativePageType {
        NONE,
        FRS,
        PB;

        /* JADX DEBUG: Replace access to removed values field (VH) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NativePageType[] valuesCustom() {
            NativePageType[] valuesCustom = values();
            int length = valuesCustom.length;
            NativePageType[] nativePageTypeArr = new NativePageType[length];
            System.arraycopy(valuesCustom, 0, nativePageTypeArr, 0, length);
            return nativePageTypeArr;
        }
    }

    /* loaded from: classes.dex */
    public enum NetworkStateInfo {
        UNAVAIL,
        WIFI,
        TwoG,
        ThreeG;

        /* JADX DEBUG: Replace access to removed values field (VI) with 'values()' method */
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
        return getNetStatusInfo(TbadkCoreApplication.m411getInst().getApp().getApplicationContext()) != NetworkStateInfo.UNAVAIL;
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
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AladinServerConfig(context)));
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
                    case 14:
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
        i.showToast(context, str);
    }

    public static void showToast(Context context, int i) {
        i.showToast(context, i);
    }

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
        new com.baidu.tbadk.core.dialog.a(activity).bw(com.baidu.tieba.y.alert_title).ac(false).bx(com.baidu.tieba.y.alert_quit_confirm).a(com.baidu.tieba.y.alert_yes_button, new bp(activity)).b(com.baidu.tieba.y.alert_no_button, new bq()).b(com.baidu.adp.base.m.D(activity)).re();
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
        return getFixedText(str, i, true);
    }

    public static String getFixedText(String str, int i, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
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
            } else if (z) {
                sb.append("...");
            }
        }
        return sb.toString();
    }

    public static int getFixedTextSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) > 255) {
                i += 2;
            } else {
                i++;
            }
        }
        return i;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [528=4] */
    public static final boolean webViewIsProbablyCorrupt(Context context) {
        SQLiteDatabase openOrCreateDatabase;
        try {
            openOrCreateDatabase = context.openOrCreateDatabase("webviewCache.db", 0, null);
        } catch (Throwable th) {
            try {
                if (BdLog.isDebugMode()) {
                    BdLog.e(th.getMessage());
                }
            } finally {
                com.baidu.adp.lib.util.v.i(null);
            }
        }
        if (openOrCreateDatabase != null) {
            com.baidu.adp.lib.util.v.i(openOrCreateDatabase);
            return false;
        }
        com.baidu.adp.lib.util.v.i(openOrCreateDatabase);
        return true;
    }

    public static void install_apk(Context context, String str) {
        File cm;
        if (str != null && str.length() > 0 && (cm = o.cm(str)) != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(cm), "application/vnd.android.package-archive");
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
            com.baidu.adp.lib.util.n.showToast(context, com.baidu.tieba.y.game_start_fail);
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

    public static int getInstallApkVersion(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void commenDealUrl(Context context, String str, String... strArr) {
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 4 && str.startsWith("web:")) {
                String substring = str.substring(4);
                String str2 = strArr[0];
                if (!TextUtils.isEmpty(substring)) {
                    com.baidu.tbadk.browser.f.b(context, str2, substring, false);
                }
            } else if (str.length() > 4 && str.startsWith("frs:")) {
                String substring2 = str.substring(4);
                if (!TextUtils.isEmpty(substring2)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(context).createNormalCfg(substring2, "official_bar")));
                }
            } else if (str.length() > 4 && str.startsWith("pb:")) {
                String substring3 = str.substring(3);
                if (!TextUtils.isEmpty(substring3)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(context).createNormalCfg(substring3, null, "official_bar")));
                }
            }
        }
    }

    public static boolean commenDealIntent(Context context, Intent intent) {
        boolean z;
        LiveRoomChatActivityConfig liveRoomChatActivityConfig;
        DQSdkPlugin dQSdkPlugin;
        boolean z2 = false;
        if (intent == null) {
            return false;
        }
        int i = intent.getExtras().getInt("class", -1);
        switch (i) {
            case 0:
                com.baidu.tbadk.browser.f.x(context, intent.getExtras().getString(ImageViewerConfig.URL));
                z = true;
                break;
            case 1:
                String stringExtra = intent.getStringExtra("id");
                String stringExtra2 = intent.getStringExtra("from");
                String string = intent.getExtras().getString("stat");
                String stringExtra3 = intent.getStringExtra("link");
                long j = intent.getExtras().getLong("message_id");
                if (intent.getBooleanExtra("is_message_pv", false)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(context).createMessageCfg(stringExtra, null, stringExtra2, j, stringExtra3, string, "op")));
                    z = true;
                    break;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(context).createNormalCfg(stringExtra, null, stringExtra2)));
                    z = true;
                    break;
                }
            case 2:
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(context).createNormalCfg(intent.getStringExtra(ImageViewerConfig.FORUM_NAME), intent.getStringExtra("from"))));
                z = true;
                break;
            case 3:
                z2 = true;
                if (com.baidu.tbadk.core.c.b.ru() != null) {
                    intent.setClass(context, com.baidu.tbadk.core.c.b.ru());
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
                int intExtra = intent.getIntExtra(AddFriendActivityConfig.TYPE_AT_ME, 0);
                int intExtra2 = intent.getIntExtra("reply_me", 0);
                int intExtra3 = intent.getIntExtra("chat", 0);
                int intExtra4 = intent.getIntExtra("group_msg", 0);
                int intExtra5 = intent.getIntExtra("group_msg_validate", 0);
                int intExtra6 = intent.getIntExtra("group_msg_updates", 0);
                int intExtra7 = intent.getIntExtra("live_notify_msg_updates", 0);
                int intExtra8 = intent.getIntExtra("officialbar_msg", 0);
                int intExtra9 = intent.getIntExtra("KeyOfNotiId", 16);
                com.baidu.tbadk.coreExtra.messageCenter.a.uT().a(com.baidu.tbadk.coreExtra.messageCenter.a.uT().getMsgReplyme(), com.baidu.tbadk.coreExtra.messageCenter.a.uT().getMsgAtme(), com.baidu.tbadk.coreExtra.messageCenter.a.uT().vm(), com.baidu.tbadk.coreExtra.messageCenter.a.uT().getMsgFans(), com.baidu.tbadk.coreExtra.messageCenter.a.uT().getMsgGiftNum());
                boolean z3 = intExtra3 > 0 || intExtra6 > 0 || intExtra5 > 0 || intExtra4 > 0 || intExtra8 > 0 || intExtra7 > 0;
                if (intExtra9 == 24 && intExtra2 > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SingleMentionActivityConfig(context, intExtra9, false)));
                    z = true;
                    break;
                } else if (intExtra9 == 25 && intExtra > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SingleMentionActivityConfig(context, intExtra9, false)));
                    z = true;
                    break;
                } else if (!z3 || intExtra9 == 24 || intExtra9 == 25) {
                    z = true;
                    break;
                } else if (i == 5 && com.baidu.tbadk.core.c.b.getCurrentTabType() == 3) {
                    com.baidu.tbadk.core.c.b.e(context, 3);
                    z = true;
                    break;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChatMessageActivityConfig(context)));
                    z = true;
                    break;
                }
                break;
            case 8:
                com.baidu.tbadk.core.c.b.e(context, 2);
                z = true;
                break;
            case 9:
                z2 = true;
                if (com.baidu.tbadk.core.c.b.ru() != null) {
                    intent.setClass(context, com.baidu.tbadk.core.c.b.ru());
                    context.startActivity(intent);
                    z = true;
                    break;
                }
                z = z2;
                break;
            case 12:
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, currentAccount, currentAccountName)));
                    z = true;
                    break;
                }
                z = z2;
                break;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(context, com.baidu.adp.lib.g.c.a(intent.getStringExtra(InviteFriendListActivityConfig.GROUP_ID), 0L), 0)));
                z = true;
                break;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage(2008013));
                z = true;
                break;
            case 15:
                String stringExtra4 = intent.getStringExtra("pay_type");
                String stringExtra5 = intent.getStringExtra(PayActivityConfig.PROPS_ID);
                String stringExtra6 = intent.getStringExtra("quan_num");
                String stringExtra7 = intent.getStringExtra(PayActivityConfig.IS_LEFT);
                String stringExtra8 = intent.getStringExtra(PayActivityConfig.PROPS_MON);
                if (TbadkCoreApplication.m411getInst().isDQShouldOpen() && (dQSdkPlugin = (DQSdkPlugin) PluginCenter.getInstance().getDqClassInstance()) != null) {
                    dQSdkPlugin.startActivity(context, stringExtra4, stringExtra5, stringExtra6, stringExtra7, stringExtra8);
                    z = true;
                    break;
                }
                z = z2;
                break;
            case 16:
                TiebaStatic.eventStat(context, "message_broadcast_open", "");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LiveNotifyActivityConfig(context)));
                z = true;
                break;
            case 17:
                if (context instanceof Activity) {
                    liveRoomChatActivityConfig = new LiveRoomChatActivityConfig(context, com.baidu.adp.lib.g.c.toInt(intent.getStringExtra(InviteFriendListActivityConfig.GROUP_ID), -1));
                } else {
                    liveRoomChatActivityConfig = new LiveRoomChatActivityConfig(context, com.baidu.adp.lib.g.c.toInt(intent.getStringExtra(InviteFriendListActivityConfig.GROUP_ID), -1), "");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, liveRoomChatActivityConfig));
                z = true;
                break;
            case 18:
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new SquareSearchActivityConfig(context, "", false)));
                z = true;
                break;
            case 19:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(context)));
                z = true;
                break;
            case 20:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(context, NotLoginGuideActivityConfig.FROM_LOGO)));
                z = true;
                break;
            case 22:
                String stringExtra9 = intent.getStringExtra("barid");
                String stringExtra10 = intent.getStringExtra(CreateBarActivityConfig.BAR_NAME_STRING);
                String stringExtra11 = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                long a = com.baidu.adp.lib.g.c.a(stringExtra9, -1L);
                if (a > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(context, a, stringExtra10, stringExtra11, 0)));
                    z = true;
                    break;
                }
                z = z2;
                break;
            case 23:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(context, Integer.parseInt(intent.getStringExtra("wanted_type")))));
                z = true;
                break;
            case 24:
                z2 = true;
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(context, currentAccount2, 0)));
                    z = true;
                    break;
                }
                z = z2;
                break;
            case 25:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(context, 0L)));
                z = true;
                break;
            case 26:
                XiubaPlugin xiubaPlugin = (XiubaPlugin) PluginCenter.getInstance().getXiubaClassInstance();
                if (xiubaPlugin != null) {
                    xiubaPlugin.startXiuba(context);
                }
                z = true;
                break;
            case 27:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(context, intent.getIntExtra(SapiAccountManager.SESSION_UID, 0), intent.getStringExtra("uname"), null, 0, intent.getIntExtra(OfficalBarChatActivityConfig.USER_TYPE, 0))));
                z = true;
                break;
            case 28:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(context, com.baidu.adp.lib.g.c.a(intent.getStringExtra(PbChosenActivityConfig.KEY_TID), 0L), null)));
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

    public static void showYYNotification(Context context, com.baidu.tbadk.core.data.p pVar, int i) {
        Intent yYNotificationIntent;
        if (TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
            int hours = new Date(System.currentTimeMillis()).getHours();
            if ((hours < 0 || hours > 7) && hours < 23) {
                String content = pVar.getContent();
                String link = pVar.getLink();
                if (link != null && link.length() > 0 && (yYNotificationIntent = getYYNotificationIntent(context, pVar, link)) != null) {
                    NotificationHelper.showNotification(context, i, null, content, content, PendingIntent.getService(context, 0, yYNotificationIntent, 134217728), false);
                }
            }
        }
    }

    public static final Intent getYYNotificationIntent(Context context, com.baidu.tbadk.core.data.p pVar, String str) {
        if (context == null || pVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        if (str.startsWith("http:")) {
            String substring = str.substring(str.lastIndexOf("/") + 1);
            intent.putExtra("class", 1);
            intent.putExtra("id", substring);
            intent.putExtra("is_message_pv", true);
        } else if (str.equals("tab://1")) {
            intent.putExtra("class", 3);
            intent.putExtra("is_message_pv", true);
            intent.putExtra(FrsActivityConfig.KEY_REFRESH, true);
            intent.putExtra("close_dialog", true);
            intent.putExtra("locate_type", 0);
            intent.setFlags(603979776);
            TbadkCoreApplication.m411getInst().setWebviewCrashCount(0);
        } else if (str.startsWith("opfeature:")) {
            try {
                intent.putExtra("class", 0);
                str = str.replaceFirst("opfeature:", "http://");
                intent.putExtra(ImageViewerConfig.URL, str);
                intent.putExtra("is_message_pv", true);
            } catch (Exception e) {
                BdLog.e(e.toString());
                return null;
            }
        } else if (str.startsWith("pk_before:")) {
            intent.putExtra("class", 6);
            intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
        } else if (str.startsWith("pk_after:")) {
            intent.putExtra("class", 7);
            intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
        } else if (!str.startsWith("vote")) {
            return null;
        } else {
            intent.putExtra("class", 8);
        }
        intent.putExtra("is_notify", true);
        intent.putExtra("link", str);
        intent.putExtra("message_id", pVar.qg());
        intent.putExtra("task_id", pVar.getTaskId());
        if (!TextUtils.isEmpty(pVar.getStat())) {
            intent.putExtra("stat", pVar.getStat());
        }
        return intent;
    }

    public static String getCurrentVerson(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static br isNativeAddress(String str) {
        String str2;
        String str3 = null;
        int i = 0;
        br brVar = new br();
        if (str == null || bd.isEmpty(str)) {
            return brVar;
        }
        Matcher matcher = pbPattern0.matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group(2);
                if (!TextUtils.isEmpty(group)) {
                    brVar.id = group;
                    brVar.VG = NativePageType.PB;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (str != null) {
            str = str.toLowerCase();
            if (str.startsWith("http://tieba.baidu.com/f?")) {
                String substring = str.substring("http://tieba.baidu.com/f?".length());
                if (substring == null) {
                    return brVar;
                }
                String[] split = substring.split("&");
                if (!substring.startsWith("kz=")) {
                    int i2 = 0;
                    while (true) {
                        if (i2 < split.length) {
                            if (split[i2] == null || !split[i2].startsWith("kz=")) {
                                i2++;
                            } else {
                                str2 = split[i2].substring(3);
                                break;
                            }
                        } else {
                            str2 = null;
                            break;
                        }
                    }
                } else {
                    str2 = substring.substring(3);
                }
                if (!TextUtils.isEmpty(str2)) {
                    brVar.id = str2;
                    brVar.VG = NativePageType.PB;
                }
            }
        }
        if (str != null) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                String substring2 = lowerCase.substring("http://tieba.baidu.com/f?".length());
                if (substring2 == null) {
                    return brVar;
                }
                String[] split2 = substring2.split("&");
                if (!substring2.startsWith("kw=")) {
                    while (true) {
                        if (i >= split2.length) {
                            break;
                        } else if (split2[i] == null || !split2[i].startsWith("kw=")) {
                            i++;
                        } else {
                            str3 = split2[i].substring(3);
                            break;
                        }
                    }
                } else {
                    str3 = substring2.substring(3);
                }
                if (!TextUtils.isEmpty(str3)) {
                    brVar.id = str3;
                    brVar.VG = NativePageType.FRS;
                }
            }
        }
        return brVar;
    }

    public static boolean isSystemLocationProviderEnabled(Context context) {
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (!locationManager.isProviderEnabled("gps")) {
                if (!locationManager.isProviderEnabled("network")) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String formatNumber(String str) {
        StringBuilder sb = new StringBuilder("");
        if (str != null) {
            int i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                sb.insert(0, str.charAt(length));
                i++;
                if (i % 3 == 0 && length != 0) {
                    sb.insert(0, ",");
                    i = 0;
                }
            }
        }
        return sb.toString();
    }

    public static boolean FirstStartActivity(Activity activity) {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) activity.getSystemService("activity")).getRunningTasks(100)) {
            if (runningTaskInfo.baseActivity.getClassName().equals(activity.getClass().getName())) {
                return true;
            }
        }
        return false;
    }

    public static int ver2int(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String[] split = str.split("\\.");
        int i = 0;
        for (int i2 = 0; i2 < split.length; i2++) {
            i |= Integer.valueOf(split[i2]).intValue() << ((3 - i2) * 8);
        }
        return i;
    }

    public static String int2ver(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append((i >> 24) & MotionEventCompat.ACTION_MASK).append(".");
        sb.append((i >> 16) & MotionEventCompat.ACTION_MASK).append(".");
        sb.append((i >> 8) & MotionEventCompat.ACTION_MASK).append(".");
        sb.append(i & MotionEventCompat.ACTION_MASK);
        return sb.toString();
    }

    public static String appendCuidParam(String str) {
        if (bd.isEmpty(str) || str.indexOf("cuid=") <= -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") > 0) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            sb.append("cuid=");
            sb.append(TbadkCoreApplication.m411getInst().getCuid());
            sb.append("&timestamp=");
            sb.append(Long.toString(System.currentTimeMillis()));
            return sb.toString();
        }
        return str;
    }

    public static String appendVersionCode(String str) {
        return (bd.isEmpty(str) || str.indexOf("_client_version=") <= -1) ? String.valueOf(str) + "&_client_version=" + TbConfig.getVersion() : str;
    }

    public static String urlAddParam(String str, String str2) {
        if (str != null && str2 != null) {
            if (str.indexOf("?") < 0) {
                str = String.valueOf(str) + "?";
            } else if (!str.endsWith("?") && !str.endsWith("&")) {
                str = String.valueOf(str) + "&";
            }
            return String.valueOf(str) + str2;
        }
        return str;
    }

    public static boolean isAutoBrightness(Context context) {
        return CompatibleUtile.getInstance().isAutoBrightness(context);
    }

    public static void shareThread(Context context, String str, String str2, String str3, String str4) {
        if (str2 != null && str3 != null && str4 != null) {
            try {
                if (str3.length() > 140) {
                    str3 = str3.substring(0, 140);
                }
                String str5 = "http://tieba.baidu.com/p/" + str2 + "?share=9105";
                if (str != null) {
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), str, null, 1, "st_param", str2);
                }
                Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
                intent.putExtra("android.intent.extra.TEXT", MessageFormat.format(context.getResources().getString(com.baidu.tieba.y.share_format), str3, str4, str5));
                intent.setFlags(268435456);
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, context.getResources().getString(com.baidu.tieba.y.share_to)));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void share(Context context, String str, String str2, String str3) {
        try {
            Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
            intent.addCategory("android.intent.category.DEFAULT");
            if (str2.length() > 140) {
                str2 = str2.substring(0, 140);
            }
            intent.putExtra("android.intent.extra.TEXT", str2);
            intent.setFlags(268435456);
            intent.setType("text/plain");
            context.startActivity(Intent.createChooser(intent, TbadkCoreApplication.m411getInst().getApp().getResources().getString(com.baidu.tieba.y.share_to)));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1505=5] */
    public static boolean isARM() {
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        if (Build.CPU_ABI == null || !Build.CPU_ABI.toLowerCase().contains("arm")) {
            try {
                bArr = new byte[1024];
                randomAccessFile = new RandomAccessFile("/proc/cpuinfo", "r");
                try {
                    try {
                    } catch (Exception e) {
                        e = e;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.util.v.c(randomAccessFile);
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.v.c(randomAccessFile);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                com.baidu.adp.lib.util.v.c(randomAccessFile);
                throw th;
            }
            if (randomAccessFile.read(bArr) < 1) {
                com.baidu.adp.lib.util.v.c(randomAccessFile);
                return false;
            }
            String str = new String(bArr);
            int indexOf = str.indexOf(0);
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            if (str.toLowerCase().contains("arm")) {
                com.baidu.adp.lib.util.v.c(randomAccessFile);
                return true;
            }
            com.baidu.adp.lib.util.v.c(randomAccessFile);
            return false;
        }
        return true;
    }

    public static boolean isInstalledPackage(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 8192) != null;
    }

    public static void callPhone(Context context, String str) {
        Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + str));
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            BdLog.detailException(e);
        } catch (SecurityException e2) {
            BdLog.detailException(e2);
        }
    }

    public static void smsPhone(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", "");
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            BdLog.detailException(e);
        } catch (SecurityException e2) {
            BdLog.detailException(e2);
        }
    }

    public static void startBaiDuBar(Context context, String str) {
        try {
            TiebaStatic.eventStat(context, "search_in_baidu", "searchclick", 1, new Object[0]);
            Intent intent = new Intent();
            intent.addCategory("android.intent.category.DEFAULT");
            if (!TextUtils.isEmpty(str)) {
                intent.setAction("com.baidu.searchbox.action.SEARCH");
                intent.putExtra("key_value", str);
            } else {
                intent.setAction("com.baidu.searchbox.action.VIEW");
                intent.setData(Uri.parse("http://www.baidu.com"));
            }
            intent.putExtra("BROWSER_RESTART", true);
            intent.putExtra("EXTRA_URL_NEW_WINDOW", true);
            intent.putExtra("isBackToLauncher", true);
            intent.addFlags(268435456);
            if (TbConfig.getAppRunMode() == TbConfig.AppRunMode.RUN_IN_KUANG_SDK) {
                com.baidu.adp.base.a.dF().dH();
            }
            context.startActivity(intent);
        } catch (Exception e) {
            startBaiduWebView(context, str);
        }
    }

    private static void startBaiduWebView(Context context, String str) {
        if (str != null && str.length() > 0) {
            com.baidu.tbadk.browser.f.y(context, "http://m.baidu.com/s?from=1001157a&word=" + str);
        } else {
            com.baidu.tbadk.browser.f.y(context, "http://m.baidu.com/?from=1001157a");
        }
    }

    public static String getMetaValue(Context context, String str) {
        if (context == null || str == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Bundle bundle = applicationInfo != null ? applicationInfo.metaData : null;
            if (bundle != null) {
                return bundle.getString(str);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static void setBitmapByTag(View view, String str, com.baidu.adp.widget.a.a aVar) {
        if (view != null && str != null) {
            if (view.getTag() != null && view.getTag().equals(str)) {
                if (aVar == null) {
                    view.invalidate();
                } else if (view instanceof ImageView) {
                    aVar.a((ImageView) view);
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt != null) {
                        setBitmapByTag(childAt, str, aVar);
                    }
                }
            }
        }
    }

    public static String getDeviceId() {
        TelephonyManager telephonyManager = (TelephonyManager) TbadkCoreApplication.m411getInst().getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getDeviceId() : "";
    }

    public static String getTiebaApkMd5() {
        String str = null;
        try {
            String versionName = TbadkCoreApplication.m411getInst().getVersionName();
            String string = com.baidu.tbadk.core.sharedPref.b.rB().getString("version_name", "");
            if (!TextUtils.isEmpty(versionName)) {
                if (versionName.equals(string)) {
                    str = com.baidu.tbadk.core.sharedPref.b.rB().getString("apk_md5", "");
                } else {
                    com.baidu.tbadk.core.sharedPref.b.rB().putString("version_name", versionName);
                    String d = bf.d(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(TbadkCoreApplication.m411getInst().getPackageName(), 0));
                    com.baidu.tbadk.core.sharedPref.b.rB().putString("apk_md5", d);
                    str = d;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            BdLog.detailException(e);
        }
        return str;
    }

    public static Object getProcessLimit() {
        BdLog.d("baidu.tieba.processlimit ");
        try {
            Class<?> cls = Class.forName("android.app.ActivityManagerNative");
            Object cast = Class.forName("android.app.IActivityManager").cast(cls.getMethod("getDefault", null).invoke(cls, null));
            return cast.getClass().getMethod("getProcessLimit", new Class[0]).invoke(cast, new Object[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            BdLog.e("getProcessLimit error");
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            BdLog.e("getProcessLimit error");
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            BdLog.e("getProcessLimit error");
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            BdLog.e("getProcessLimit error");
            return null;
        }
    }

    public static boolean isBackgroundProcessLimitNone() {
        Object processLimit = getProcessLimit();
        return processLimit != null && processLimit.toString().equals(String.valueOf(0));
    }

    public static void startHardAccelerated(Window window) {
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("FLAG_HARDWARE_ACCELERATED");
                declaredField.setAccessible(true);
                int i = declaredField.getInt(null);
                Window.class.getMethod("setFlags", Integer.TYPE, Integer.TYPE).invoke(window, Integer.valueOf(i), Integer.valueOf(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
