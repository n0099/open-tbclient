package com.baidu.tbadk.core.util;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.content.FileProvider;
import android.support.v4.view.MotionEventCompat;
import android.telephony.TelephonyManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.LiveNotifyActivityConfig;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PayTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.ReplyMessageActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class UtilHelper {
    private static final String NATIVE_PAY_FROM = "from_type";
    public static final int PROCESS_LIMIT_NONE = 0;
    private static final Pattern pbPattern0 = Pattern.compile("(tieba.baidu.com/p/){1}([\\d]+)");
    private static final String[] sNativeAdPrefixes = {"http://m.baidu.com/baidu.php?url=", "https://m.baidu.com/baidu.php?url="};
    private static final String[] sNativeAdEncoded = {"http%3a%2f%2fm.baidu.com%2fbaidu.php%3furl%3d", "https%3a%2f%2fm.baidu.com%2fbaidu.php%3furl%3d"};

    /* loaded from: classes.dex */
    public enum NativePageType {
        NONE,
        FRS,
        PB;

        /* JADX DEBUG: Replace access to removed values field (acg) with 'values()' method */
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
    public static class a {
        public NativePageType acf = NativePageType.NONE;
        public String id;
    }

    public static int getBitmapMaxMemory(Context context) {
        return CompatibleUtile.getInstance().getBitmapMaxMemory(context);
    }

    public static void showToast(Context context, String str) {
        h.showToast(context, str);
    }

    public static void showToast(Context context, int i) {
        h.showToast(context, i);
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

    private static String intToIp(int i) {
        return String.valueOf(i & MotionEventCompat.ACTION_MASK) + "." + ((i >> 8) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 16) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 24) & MotionEventCompat.ACTION_MASK);
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

    public static void startPushService(Context context) {
        if (context == null) {
        }
    }

    public static void quitDialog(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).ca(r.j.alert_title).au(false).cb(r.j.alert_quit_confirm).a(r.j.alert_yes_button, new bf(activity)).b(r.j.alert_no_button, new bg()).b(com.baidu.adp.base.l.C(activity)).tb();
    }

    public static String getFixedBarText(String str, int i, boolean z) {
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
                sb.deleteCharAt(i2 - 1);
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

    public static final Intent getYYNotificationIntent(Context context, com.baidu.tbadk.core.data.al alVar, String str) {
        if (context == null || alVar == null || TextUtils.isEmpty(str)) {
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
            TbadkCoreApplication.m9getInst().setWebviewCrashCount(0);
        } else if (str.startsWith("web:")) {
            if (!str.contains("ftid=")) {
                return null;
            }
            intent.putExtra("class", 29);
            intent.putExtra(PbChosenActivityConfig.KEY_TID, str.substring(str.lastIndexOf("ftid=") + 5));
            TiebaStatic.log("c10146");
        } else if (str.startsWith("opfeature:")) {
            try {
                intent.putExtra("class", 0);
                str = str.replaceFirst("opfeature:", "http://");
                intent.putExtra("url", str);
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
        } else if (str.startsWith("vote")) {
            intent.putExtra("class", 8);
        } else if (str.startsWith("twzb:")) {
            intent.putExtra("class", 31);
            String substring2 = str.substring(str.lastIndexOf("twzb:") + 5);
            String str2 = "";
            if (substring2.startsWith("pid=")) {
                str2 = substring2.substring(substring2.lastIndexOf("pid=") + 4);
            } else if (substring2.startsWith("http://")) {
                str2 = substring2.substring(substring2.lastIndexOf("p/") + 2);
            }
            if (StringUtils.isNull(str2)) {
                return null;
            }
            intent.putExtra("tid", str2);
        } else if (!str.startsWith("middlepage:")) {
            return null;
        } else {
            intent.putExtra("class", 34);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            if (!parsePushMidPageUrl(str, sb, sb2)) {
                return null;
            }
            String sb3 = sb.toString();
            String sb4 = sb2.toString();
            if (StringUtils.isNull(sb3) || StringUtils.isNull(sb4)) {
                return null;
            }
            intent.putExtra("fid", sb3);
            intent.putExtra("tid", sb4);
        }
        intent.putExtra("is_notify", true);
        intent.putExtra("link", str);
        intent.putExtra("message_id", alVar.qy());
        intent.putExtra(InterviewLiveActivityConfig.KEY_TASK_ID, alVar.getTaskId());
        if (!TextUtils.isEmpty(alVar.getStat())) {
            intent.putExtra("stat", alVar.getStat());
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

    public static a isNativeAddress(String str) {
        String substring;
        String substring2;
        String str2;
        int i = 0;
        String str3 = null;
        a aVar = new a();
        if (str == null || av.isEmpty(str)) {
            return aVar;
        }
        Matcher matcher = pbPattern0.matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group(2);
                if (!TextUtils.isEmpty(group)) {
                    aVar.id = group;
                    aVar.acf = NativePageType.PB;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (str != null) {
            str = str.toLowerCase();
            if (str.startsWith("http://tieba.baidu.com/f?")) {
                substring2 = str.substring("http://tieba.baidu.com/f?".length());
            } else {
                substring2 = str.startsWith("http://tieba.baidu.com/f?") ? str.substring("http://tieba.baidu.com/f?".length()) : null;
            }
            if (substring2 == null) {
                return aVar;
            }
            String[] split = substring2.split("&");
            if (!substring2.startsWith("kz=")) {
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
                str2 = substring2.substring(3);
            }
            if (!TextUtils.isEmpty(str2)) {
                aVar.id = str2;
                aVar.acf = NativePageType.PB;
            }
        }
        if (str != null) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                substring = lowerCase.substring("http://tieba.baidu.com/f?".length());
            } else {
                substring = lowerCase.startsWith("http://tieba.baidu.com/f?") ? lowerCase.substring("http://tieba.baidu.com/f?".length()) : null;
            }
            if (substring == null) {
                return aVar;
            }
            String[] split2 = substring.split("&");
            if (!substring.startsWith("kw=")) {
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
                str3 = substring.substring(3);
            }
            if (!TextUtils.isEmpty(str3)) {
                aVar.id = str3;
                aVar.acf = NativePageType.FRS;
            }
        }
        return aVar;
    }

    public static boolean isSystemLocationProviderEnabled(Context context) {
        if (ae.X(context)) {
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
        return false;
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

    public static boolean isNativeAdURL(String str) {
        if (str == null) {
            return false;
        }
        for (String str2 : sNativeAdPrefixes) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        for (String str3 : sNativeAdEncoded) {
            if (str.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static String appendCuidParam(String str) {
        if (av.isEmpty(str) || str.indexOf("cuid=") <= -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") > 0) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            if (!isNativeAdURL(str)) {
                sb.append("cuid=");
                sb.append(TbadkCoreApplication.m9getInst().getCuid());
            }
            sb.append("&timestamp=");
            sb.append(Long.toString(System.currentTimeMillis()));
            return sb.toString();
        }
        return str;
    }

    public static String appendVersionCode(String str) {
        return (av.isEmpty(str) || str.indexOf("_client_version=") <= -1) ? String.valueOf(str) + "&_client_version=" + TbConfig.getVersion() : str;
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
                    TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getApp(), str, null, 1, "st_param", str2);
                }
                Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
                intent.putExtra("android.intent.extra.TEXT", MessageFormat.format(context.getResources().getString(r.j.share_format), str3, str4, str5));
                intent.setFlags(268435456);
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, context.getResources().getString(r.j.share_to)));
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
            context.startActivity(Intent.createChooser(intent, TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.j.share_to)));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [903=5] */
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
                        com.baidu.adp.lib.util.o.b(randomAccessFile);
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.o.b(randomAccessFile);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                com.baidu.adp.lib.util.o.b(randomAccessFile);
                throw th;
            }
            if (randomAccessFile.read(bArr) < 1) {
                com.baidu.adp.lib.util.o.b(randomAccessFile);
                return false;
            }
            String str = new String(bArr);
            int indexOf = str.indexOf(0);
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            if (str.toLowerCase().contains("arm")) {
                com.baidu.adp.lib.util.o.b(randomAccessFile);
                return true;
            }
            com.baidu.adp.lib.util.o.b(randomAccessFile);
            return false;
        }
        return true;
    }

    public static boolean isInstalledPackage(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 8192) != null;
    }

    public static void callPhone(Context context, String str) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            BdLog.detailException(e);
        } catch (SecurityException e2) {
            BdLog.detailException(e2);
        }
    }

    public static void smsTo(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", new StringBuilder(String.valueOf(str2)).toString());
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
                intent.setData(Uri.parse(TbDomainConfig.DOMAIN_HTTPS_BAIDU));
            }
            intent.putExtra("BROWSER_RESTART", true);
            intent.putExtra("EXTRA_URL_NEW_WINDOW", true);
            intent.putExtra("isBackToLauncher", true);
            intent.addFlags(268435456);
            if (TbConfig.IS_START_BAIDU_KUANG_CLOSE_SELF) {
                com.baidu.adp.base.a.aS().aV();
            }
            context.startActivity(intent);
        } catch (Exception e) {
            startBaiduWebView(context, str);
        }
    }

    private static void startBaiduWebView(Context context, String str) {
        if (str != null && str.length() > 0) {
            com.baidu.tbadk.browser.f.v(context, "http://m.baidu.com/s?from=1001157a&word=" + str);
        } else {
            com.baidu.tbadk.browser.f.v(context, "http://m.baidu.com/?from=1001157a");
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
                    aVar.e((ImageView) view);
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
        TelephonyManager telephonyManager;
        return (!ae.ab(TbadkCoreApplication.m9getInst()) || (telephonyManager = (TelephonyManager) TbadkCoreApplication.m9getInst().getSystemService("phone")) == null) ? "" : telephonyManager.getDeviceId();
    }

    public static String getTiebaApkMd5() {
        String str = null;
        try {
            String versionName = TbadkCoreApplication.m9getInst().getVersionName();
            String string = com.baidu.tbadk.core.sharedPref.b.tW().getString("version_name", "");
            if (!TextUtils.isEmpty(versionName)) {
                if (versionName.equals(string)) {
                    str = com.baidu.tbadk.core.sharedPref.b.tW().getString("apk_md5", "");
                } else {
                    com.baidu.tbadk.core.sharedPref.b.tW().putString("version_name", versionName);
                    String d = ax.d(TbadkCoreApplication.m9getInst().getPackageManager().getPackageInfo(TbadkCoreApplication.m9getInst().getPackageName(), 0));
                    com.baidu.tbadk.core.sharedPref.b.tW().putString("apk_md5", d);
                    str = d;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            BdLog.detailException(e);
        }
        return str;
    }

    public static boolean isFlymeOsOver51() {
        String aS;
        String str = Build.DISPLAY;
        if (str != null && str.contains("Flyme") && (aS = com.baidu.adp.lib.util.k.aS(str)) != null && aS.length() >= 3) {
            int g = com.baidu.adp.lib.h.b.g(com.baidu.adp.lib.util.k.aS(aS.substring(0, 1)), 0);
            int g2 = com.baidu.adp.lib.h.b.g(com.baidu.adp.lib.util.k.aS(aS.substring(1, 2)), 0);
            if (g > 5) {
                return true;
            }
            if (g == 5 && g2 >= 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean canUseStyleImmersiveSticky() {
        if (Build.VERSION.SDK_INT >= 19 && TbadkCoreApplication.m9getInst().isMeiZuCanUseImmersive()) {
            return TbadkCoreApplication.m9getInst().isImmersiveStickyCanUse();
        }
        return false;
    }

    public static boolean useNavigationBarStyleImmersiveSticky(Activity activity, boolean z) {
        if (Build.VERSION.SDK_INT < 19 || activity == null || !com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("switch_immersive_sticky_status", true) || !TbadkCoreApplication.m9getInst().isMeiZuCanUseImmersive()) {
            return false;
        }
        for (AccessibilityServiceInfo accessibilityServiceInfo : ((AccessibilityManager) activity.getSystemService("accessibility")).getEnabledAccessibilityServiceList(1)) {
            if (!StringUtils.isNull(accessibilityServiceInfo.getSettingsActivityName()) && accessibilityServiceInfo.getSettingsActivityName().contains("talkback")) {
                com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("switch_immersive_sticky_status", false);
                TbadkCoreApplication.m9getInst().resetIsImmersiveStickyPrefHasRead(false);
                return false;
            }
        }
        boolean z2 = TbadkCoreApplication.m9getInst().getSkinType() != 2;
        if (Build.VERSION.SDK_INT >= 23) {
            useNavigationBarStyleImmersiveSticky_L(activity, z);
            StatusBarUtil.from(activity).setTransparentStatusbar(z2).setLightStatusBar(z2).process();
            return true;
        } else if (!StatusBarUtil.from(activity).setTransparentStatusbar(z2).setLightStatusBar(z2).process()) {
            com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("switch_immersive_sticky_status", false);
            TbadkCoreApplication.m9getInst().resetIsImmersiveStickyPrefHasRead(false);
            return false;
        } else if (Build.VERSION.SDK_INT < 21) {
            useNavigationBarStyleImmersiveSticky_KitKat(activity);
            return true;
        } else {
            useNavigationBarStyleImmersiveSticky_L(activity);
            return true;
        }
    }

    public static boolean useNavigationBarStyleImmersiveSticky(Activity activity) {
        return useNavigationBarStyleImmersiveSticky(activity, false);
    }

    public static void useNavigationBarStyleImmersiveSticky_L(Activity activity, boolean z) {
        if (activity != null) {
            try {
                Field field = WindowManager.LayoutParams.class.getField("FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS");
                Field field2 = WindowManager.LayoutParams.class.getField("FLAG_TRANSLUCENT_STATUS");
                Field field3 = View.class.getField("SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN");
                Field field4 = View.class.getField("SYSTEM_UI_FLAG_LAYOUT_STABLE");
                Method method = activity.getWindow().getClass().getMethod("setStatusBarColor", Integer.TYPE);
                Method method2 = View.class.getMethod("setSystemUiVisibility", Integer.TYPE);
                if (field != null && field2 != null && field3 != null && field4 != null && method != null && method2 != null) {
                    int i = field.getInt(null);
                    int i2 = field2.getInt(null);
                    int i3 = field3.getInt(null);
                    int i4 = field4.getInt(null);
                    activity.getWindow().clearFlags(i2);
                    method2.invoke(activity.getWindow().getDecorView(), Integer.valueOf(i3 | i4));
                    activity.getWindow().addFlags(i);
                    method.invoke(activity.getWindow(), 0);
                    if (z) {
                        Field field5 = WindowManager.LayoutParams.class.getField("FLAG_FULLSCREEN");
                        Method method3 = activity.getWindow().getClass().getMethod("setFlags", Integer.TYPE, Integer.TYPE);
                        int i5 = field5.getInt(null);
                        method3.invoke(activity.getWindow(), Integer.valueOf(i5), Integer.valueOf(i5));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void useNavigationBarStyleImmersiveSticky_L(Activity activity) {
        useNavigationBarStyleImmersiveSticky_L(activity, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void useNavigationBarStyleImmersiveSticky_KitKat(Activity activity) {
        int i;
        boolean z;
        Field field;
        if (activity != null) {
            try {
                field = WindowManager.LayoutParams.class.getField("FLAG_TRANSLUCENT_STATUS");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (field != null) {
                i = field.getInt(null);
                z = true;
                if (!z) {
                    activity.getWindow().setFlags(i, i);
                    return;
                }
                return;
            }
            i = -1;
            z = false;
            if (!z) {
            }
        }
    }

    public static void setStatusBarBackground(View view, int i) {
        if (view != null) {
            if (i == 2) {
                int statusBarHeight = getStatusBarHeight();
                int I = com.baidu.adp.lib.util.k.I(TbadkCoreApplication.m9getInst());
                Bitmap cQ = ar.cQ(r.f.s_navbar_bg);
                if (cQ != null) {
                    Bitmap resizeBitmap = BitmapHelper.resizeBitmap(cQ, I, statusBarHeight, false);
                    if (resizeBitmap != null) {
                        view.setBackgroundDrawable(new BitmapDrawable(resizeBitmap));
                        return;
                    } else {
                        ar.l(view, r.d.common_color_10274);
                        return;
                    }
                }
                ar.l(view, r.d.common_color_10274);
                return;
            }
            ar.l(view, r.d.common_color_10274);
        }
    }

    public static boolean isBackgroundProcessLimitNone() {
        Object processLimit = getProcessLimit();
        return processLimit != null && processLimit.toString().equals(String.valueOf(0));
    }

    public static Object getProcessLimit() {
        BdLog.d("baidu.tieba.processlimit ");
        try {
            Class<?> cls = Class.forName("android.app.ActivityManagerNative");
            Object cast = Class.forName("android.app.IActivityManager").cast(cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]));
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

    public static void setSpan(SpannableString spannableString, String str, String str2, CharacterStyle characterStyle) {
        if (spannableString != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && characterStyle != null) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            while (indexOf >= 0) {
                spannableString.setSpan(characterStyle, indexOf, indexOf + length, 33);
                indexOf = str.indexOf(str2, indexOf + length);
            }
        }
    }

    public static void setSpan(SpannableStringBuilder spannableStringBuilder, String str, String str2, CharacterStyle characterStyle) {
        if (spannableStringBuilder != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && characterStyle != null) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            while (indexOf >= 0) {
                spannableStringBuilder.setSpan(characterStyle, indexOf, indexOf + length, 33);
                indexOf = str.indexOf(str2, indexOf + length);
            }
        }
    }

    public static String formalDecimalForTwo(float f) {
        return new DecimalFormat("0.00").format(f);
    }

    public static void openGpu(Activity activity) {
        CompatibleUtile.getInstance().openGpu(activity);
    }

    public static String getFixedText(String str, int i) {
        return getFixedText(str, i, true);
    }

    @Deprecated
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

    public static boolean hasAvaiableSDCardSpace(int i) {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return false;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            if ((statFs.getAvailableBlocks() * statFs.getBlockSize()) / IjkMediaMeta.AV_CH_SIDE_RIGHT <= i) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1523=4] */
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
                com.baidu.adp.lib.util.o.h(null);
            }
        }
        if (openOrCreateDatabase != null) {
            com.baidu.adp.lib.util.o.h(openOrCreateDatabase);
            return false;
        }
        com.baidu.adp.lib.util.o.h(openOrCreateDatabase);
        return true;
    }

    public static void install_apk(Context context, String str) {
        File cZ;
        if (str != null && str.length() > 0 && (cZ = m.cZ(str)) != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(getUriFromFile(cZ, intent, context), "application/vnd.android.package-archive");
                intent.addFlags(268435456);
                if (isHaveActivityCanHandleIntent(intent)) {
                    context.startActivity(intent);
                }
            } catch (SecurityException e) {
            }
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
            com.baidu.adp.lib.util.k.showToast(context, r.j.game_start_fail);
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

    public static String getInstallApkVersionName(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg(substring2, "official_bar")));
                }
            } else if (str.length() > 4 && str.startsWith("pb:")) {
                String substring3 = str.substring(3);
                if (!TextUtils.isEmpty(substring3)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(context).createNormalCfg(substring3, null, "official_bar")));
                }
            }
        }
    }

    public static SpannableStringBuilder getSpannableIcon(Context context, String str, int i, boolean z) {
        if (com.baidu.adp.lib.util.j.isEmpty(str) || context == null || i == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Bitmap cQ = ar.cQ(i);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
        if (cQ != null) {
            bitmapDrawable.setBounds(0, 0, cQ.getWidth(), cQ.getHeight());
        }
        com.baidu.tbadk.core.view.aj ajVar = new com.baidu.tbadk.core.view.aj(bitmapDrawable);
        ajVar.setOffset(com.baidu.adp.lib.util.k.e(context, r.e.ds4));
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) " ");
        if (z) {
            spannableStringBuilder.setSpan(ajVar, length, spannableStringBuilder.length(), 17);
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.append((CharSequence) str);
            return spannableStringBuilder;
        }
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.append((CharSequence) " ");
        spannableStringBuilder.setSpan(ajVar, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static boolean commenDealIntent(Context context, Intent intent) {
        boolean z;
        LiveRoomChatActivityConfig liveRoomChatActivityConfig;
        boolean z2 = false;
        if (intent == null) {
            return false;
        }
        int i = intent.getExtras().getInt("class", -1);
        switch (i) {
            case 0:
                com.baidu.tbadk.browser.f.u(context, intent.getExtras().getString("url"));
                z = true;
                break;
            case 1:
                String stringExtra = intent.getStringExtra("id");
                String stringExtra2 = intent.getStringExtra("from");
                String string = intent.getExtras().getString("stat");
                String stringExtra3 = intent.getStringExtra("link");
                long j = intent.getExtras().getLong("message_id");
                if (intent.getBooleanExtra("is_message_pv", false)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(context).createMessageCfg(stringExtra, null, stringExtra2, j, stringExtra3, string, "op")));
                    z = true;
                    break;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(context).createNormalCfg(stringExtra, null, stringExtra2)));
                    z = true;
                    break;
                }
            case 2:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg(intent.getStringExtra(ImageViewerConfig.FORUM_NAME), intent.getStringExtra("from"))));
                z = true;
                break;
            case 3:
                z2 = true;
                if (com.baidu.tbadk.core.d.b.tP() != null) {
                    intent.setClass(context, com.baidu.tbadk.core.d.b.tP());
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
            case 20:
            case 26:
            default:
                z = false;
                break;
            case 5:
            case 11:
            case 21:
                z2 = true;
                int intExtra = intent.getIntExtra(AddFriendActivityConfig.TYPE_AT_ME, 0);
                int intExtra2 = intent.getIntExtra("reply_me", 0);
                int intExtra3 = intent.getIntExtra("chat", 0);
                int intExtra4 = intent.getIntExtra("group_msg", 0);
                int intExtra5 = intent.getIntExtra("group_msg_validate", 0);
                int intExtra6 = intent.getIntExtra("group_msg_updates", 0);
                int intExtra7 = intent.getIntExtra("live_notify_msg_updates", 0);
                int intExtra8 = intent.getIntExtra("officialbar_msg", 0);
                int intExtra9 = intent.getIntExtra("KeyOfNotiId", 16);
                com.baidu.tbadk.coreExtra.messageCenter.a.yy().c(com.baidu.tbadk.coreExtra.messageCenter.a.yy().getMsgReplyme(), com.baidu.tbadk.coreExtra.messageCenter.a.yy().getMsgAtme(), com.baidu.tbadk.coreExtra.messageCenter.a.yy().yR(), com.baidu.tbadk.coreExtra.messageCenter.a.yy().getMsgFans(), com.baidu.tbadk.coreExtra.messageCenter.a.yy().getMsgGiftNum());
                boolean z3 = intExtra3 > 0 || intExtra6 > 0 || intExtra5 > 0 || intExtra4 > 0 || intExtra8 > 0 || intExtra7 > 0;
                boolean z4 = intExtra9 == 24 && intExtra2 > 0;
                boolean z5 = intExtra9 == 25 && intExtra > 0;
                if (z4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMessageActivityConfig(context)));
                    com.baidu.tbadk.coreExtra.messageCenter.a.yy().setMsgReplyme(0);
                    Intent intent2 = new Intent();
                    intent2.putExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 2);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY, intent2));
                    z = true;
                    break;
                } else if (!z5) {
                    if (z3) {
                        if (i == 5 && com.baidu.tbadk.core.d.b.getCurrentTabType() == 3) {
                            goToMessageCenterFromNotifyCenter(context, intExtra9);
                            z = true;
                            break;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(context, intExtra9)));
                            Intent intent3 = new Intent();
                            intent3.putExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, intExtra9);
                            intent3.putExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY, intent3));
                            z = true;
                            break;
                        }
                    }
                    z = z2;
                    break;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(context)));
                    com.baidu.tbadk.coreExtra.messageCenter.a.yy().setMsgAtme(0);
                    Intent intent4 = new Intent();
                    intent4.putExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 2);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY, intent4));
                    z = true;
                    break;
                }
                break;
            case 8:
                com.baidu.tbadk.core.d.b.f(context, 2);
                z = true;
                break;
            case 9:
                z2 = true;
                if (com.baidu.tbadk.core.d.b.tP() != null) {
                    intent.setClass(context, com.baidu.tbadk.core.d.b.tP());
                    context.startActivity(intent);
                    z = true;
                    break;
                }
                z = z2;
                break;
            case 12:
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                if (com.baidu.tbadk.core.d.b.getCurrentTabType() == 8) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createNormalCfg(8)));
                } else if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, currentAccount, currentAccountName, com.baidu.tbadk.coreExtra.messageCenter.a.yy().getMsgFans())));
                }
                z = true;
                break;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(context, com.baidu.adp.lib.h.b.c(intent.getStringExtra(InviteFriendListActivityConfig.GROUP_ID), 0L), 0)));
                z = true;
                break;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.IM_UPDATES_ACTIVITY_START));
                z = true;
                break;
            case 15:
                com.baidu.tbadk.pay.e.Fv().a(new PayConfig(com.baidu.adp.lib.h.b.g(intent.getStringExtra("pay_type"), 0), intent.getStringExtra("is_left"), intent.getStringExtra("props_id"), intent.getStringExtra(PayTBeanActivityConfig.QUAN_NUM), intent.getStringExtra("props_mon"), true), context);
                z = false;
                break;
            case 16:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(context)));
                z = true;
                break;
            case 17:
                if (context instanceof Activity) {
                    liveRoomChatActivityConfig = new LiveRoomChatActivityConfig(context, com.baidu.adp.lib.h.b.g(intent.getStringExtra(InviteFriendListActivityConfig.GROUP_ID), -1));
                } else {
                    liveRoomChatActivityConfig = new LiveRoomChatActivityConfig(context, com.baidu.adp.lib.h.b.g(intent.getStringExtra(InviteFriendListActivityConfig.GROUP_ID), -1), "");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, liveRoomChatActivityConfig));
                z = true;
                break;
            case 18:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(context, "", false)));
                z = true;
                break;
            case 19:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(context)));
                z = true;
                break;
            case 22:
                String stringExtra4 = intent.getStringExtra("barid");
                String stringExtra5 = intent.getStringExtra("barname");
                String stringExtra6 = intent.getStringExtra(IntentConfig.PORTRAIT);
                long c = com.baidu.adp.lib.h.b.c(stringExtra4, -1L);
                if (c > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(context, c, stringExtra5, stringExtra6, 0)));
                    z = true;
                    break;
                }
                z = z2;
                break;
            case 23:
                String stringExtra7 = intent.getStringExtra("wanted_type");
                String stringExtra8 = intent.getStringExtra("from_type");
                int parseInt = Integer.parseInt(stringExtra7);
                int i2 = 0;
                if (!StringUtils.isNull(stringExtra8)) {
                    if (stringExtra8.equals("c10061")) {
                        i2 = 6;
                    } else if (stringExtra8.equals("c10383")) {
                        i2 = 7;
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(context, parseInt, false, i2)));
                z = true;
                break;
            case 24:
                z2 = true;
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                String currentAccountName2 = TbadkCoreApplication.getCurrentAccountName();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(context, currentAccount2, currentAccountName2, 0)));
                    z = true;
                    break;
                }
                z = z2;
                break;
            case 25:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(context, 0L)));
                z = true;
                break;
            case 27:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(context, intent.getIntExtra(SapiAccountManager.SESSION_UID, 0), intent.getStringExtra("uname"), null, 0, intent.getIntExtra("user_type", 0))));
                z = true;
                break;
            case 28:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(context, com.baidu.adp.lib.h.b.c(intent.getStringExtra(PbChosenActivityConfig.KEY_TID), 0L), null)));
                z = true;
                break;
            case 29:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(context, com.baidu.adp.lib.h.b.c(intent.getStringExtra(PbChosenActivityConfig.KEY_TID), 0L), null, 2)));
                z = true;
                break;
            case 30:
                z2 = true;
                String string2 = intent.getExtras().getString("jump_url");
                boolean z6 = intent.getExtras().getBoolean("is_ad", false);
                com.baidu.adp.base.k A = com.baidu.adp.base.l.A(context);
                if (!(A instanceof BaseActivity)) {
                    if (!(A instanceof BaseFragmentActivity)) {
                        if (A instanceof ProxyAdkBaseActivity) {
                            bc.vz().a(((ProxyAdkBaseActivity) A).getPageContext(), new String[]{string2}, z6);
                            z = true;
                            break;
                        }
                        z = z2;
                        break;
                    } else {
                        bc.vz().a(((BaseFragmentActivity) A).getPageContext(), new String[]{string2}, z6);
                        z = true;
                        break;
                    }
                } else {
                    bc.vz().a(((BaseActivity) A).getPageContext(), new String[]{string2}, z6);
                    z = true;
                    break;
                }
            case 31:
                TiebaStatic.log("c10303");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PHOTOLIVE_ACTIVITY, new PhotoLiveActivityConfig.a(context, intent.getStringExtra("tid")).oZ()));
                z = true;
                break;
            case 32:
                z2 = true;
                try {
                    PaymentConfirmRequestData paymentConfirmRequestData = (PaymentConfirmRequestData) intent.getSerializableExtra(PaymentConfirmActivityConfig.REQUEST_PARAMS);
                    if (paymentConfirmRequestData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PaymentConfirmActivityConfig(context, paymentConfirmRequestData)));
                        z = true;
                        break;
                    }
                    z = z2;
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    z = true;
                    break;
                }
            case 33:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(context)));
                TiebaStatic.log("c10430");
                z = true;
                break;
            case 34:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(context).createNormalCfg(intent.getStringExtra("fid"), intent.getStringExtra("tid"), "push")));
                z = true;
                break;
            case 35:
                z2 = true;
                String currentAccount3 = TbadkCoreApplication.getCurrentAccount();
                int i3 = 0;
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    i3 = TbadkCoreApplication.getCurrentAccountInfo().getSex();
                }
                if (currentAccount3 != null && currentAccount3.length() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(context, false, currentAccount3, i3)));
                    z = true;
                    break;
                }
                z = z2;
                break;
        }
        if (!z) {
            intent.putExtra("class", 3);
            return commenDealIntent(context, intent);
        }
        return z;
    }

    public static void goToMessageCenterFromNotifyCenter(Context context, int i) {
        if (context != null) {
            Intent intent = new Intent();
            intent.putExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, i);
            intent.putExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY, intent));
            com.baidu.tbadk.core.d.b.f(context, 3);
        }
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

    public static void showYYNotification(Context context, com.baidu.tbadk.core.data.al alVar, int i) {
        Intent yYNotificationIntent;
        if (TbadkCoreApplication.m9getInst().isPromotedMessageOn()) {
            int hours = new Date(System.currentTimeMillis()).getHours();
            if ((hours < 0 || hours > 7) && hours < 23) {
                String content = alVar.getContent();
                String link = alVar.getLink();
                if (link != null && link.length() > 0 && (yYNotificationIntent = getYYNotificationIntent(context, alVar, link)) != null) {
                    NotificationHelper.showNotification(context, i, null, content, content, PendingIntent.getService(context, 0, yYNotificationIntent, 134217728), false);
                }
            }
        }
    }

    public static void stopPushService(Context context) {
    }

    public static int getImmersiveStickyBarHeight() {
        if (canUseStyleImmersiveSticky()) {
            return getStatusBarHeight();
        }
        return 0;
    }

    public static int getStatusBarHeight() {
        try {
            return TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(com.baidu.adp.lib.h.b.g(Class.forName("com.android.internal.R$dimen").getField("status_bar_height").get(null).toString(), 0));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getLightStatusBarHeight() {
        if (canUseStyleImmersiveSticky()) {
            try {
                return TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(com.baidu.adp.lib.h.b.g(Class.forName("com.android.internal.R$dimen").getField("status_bar_height").get(null).toString(), 0));
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public static long getCorrectUserIdAfterOverflowCut(long j) {
        if (j < 0) {
            return j + ((2147483647L + 1) * 2);
        }
        return j;
    }

    public static String getTopActivityClassName() {
        Activity aT;
        ComponentName componentName;
        if (com.baidu.adp.base.a.aS() == null || (aT = com.baidu.adp.base.a.aS().aT()) == null || (componentName = aT.getComponentName()) == null) {
            return null;
        }
        return componentName.getClassName();
    }

    public static boolean isFloatWindowOpAllowed(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (TbadkCoreApplication.m9getInst().isMIUIRom()) {
            if (i >= 19) {
                return checkOp(context, 24);
            }
            return (context.getApplicationInfo().flags & 134217728) == 134217728;
        }
        return true;
    }

    private static boolean checkOp(Context context, int i) {
        Class<?> cls = null;
        try {
            Object systemService = context.getSystemService("appops");
            if (systemService != null && systemService.getClass().getSimpleName().equals("AppOpsManager")) {
                cls = systemService.getClass();
            }
            if (cls != null) {
                return ((Integer) cls.getDeclaredMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class).invoke(systemService, 24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static void setSupportHeight(Context context, View view, float f) {
        ViewGroup.LayoutParams layoutParams;
        DisplayMetrics displayMetrics;
        if (view != null && f > 0.0f && context != null && (layoutParams = view.getLayoutParams()) != null && (displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics()) != null) {
            layoutParams.height = Math.round(displayMetrics.widthPixels / f);
            view.requestLayout();
        }
    }

    public static boolean isAppForeground() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) TbadkCoreApplication.m9getInst().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && !StringUtils.isNull(runningAppProcessInfo.processName) && runningAppProcessInfo.processName.equals(TbadkCoreApplication.m9getInst().getPackageName()) && runningAppProcessInfo.importance == 100) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectOpenGLES20(Context context) {
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        return (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) == null || deviceConfigurationInfo.reqGlEsVersion < 131072) ? false : true;
    }

    public static boolean isHaveActivityCanHandleIntent(Intent intent) {
        List<ResolveInfo> list = null;
        PackageManager packageManager = TbadkCoreApplication.m9getInst().getPackageManager();
        if (packageManager != null) {
            list = packageManager.queryIntentActivities(intent, 32);
        }
        return x.s(list) > 0;
    }

    public static boolean isDecimal(String str) {
        return Pattern.compile("[0-9|\\.]+").matcher(str).matches();
    }

    public static boolean isNumber(String str) {
        return Pattern.compile("[0-9]+").matcher(str).matches();
    }

    public static boolean isPhoneNumber(String str) {
        return !StringUtils.isNull(str) && isNumber(str) && str.length() == 11 && str.startsWith("1");
    }

    public static int getRandom(Random random, int i, int i2) {
        int nextInt = random.nextInt(i);
        if (nextInt == i2) {
            return (nextInt + 1) % i;
        }
        return nextInt;
    }

    public static boolean parsePushMidPageUrl(String str, StringBuilder sb, StringBuilder sb2) {
        String str2;
        if (str.contains("middlepage")) {
            String substring = str.substring(str.lastIndexOf("middlepage:") + 11);
            String str3 = "";
            if (substring.startsWith("flag=")) {
                str3 = substring.substring(5, substring.indexOf("&"));
                substring = substring.substring(str3.length() + 1 + 5);
            }
            if ("1".equals(str3)) {
                if (substring.startsWith("fid=")) {
                    str2 = substring.substring(substring.lastIndexOf("fid=") + 4, substring.indexOf("&"));
                    substring = substring.substring(str2.length() + 1 + 4);
                } else {
                    str2 = "";
                }
                String substring2 = substring.startsWith("tid=") ? substring.substring(substring.lastIndexOf("tid=") + 4) : "";
                if (StringUtils.isNull(str2) || StringUtils.isNull(substring2)) {
                    return false;
                }
                sb.append(str2);
                sb2.append(substring2);
                return true;
            }
            return false;
        }
        return false;
    }

    public static String formatOverStep(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        return str.length() > i ? String.valueOf(str.substring(0, i)) + "..." : str;
    }

    public static boolean isUseSingleGod(UserData userData) {
        return (userData == null || userData.getGodUserData() == null || userData.getGodUserData().getType() != 2) ? false : true;
    }

    public static boolean isCurrentAccount(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return !StringUtils.isNull(currentAccount) && currentAccount.equals(str);
    }

    public static Uri getUriFromFile(File file, Intent intent, Context context) {
        if (file == null || intent == null || context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
            return FileProvider.getUriForFile(context, "com.baidu.tieba.fileProvider", file);
        }
        return Uri.fromFile(file);
    }
}
