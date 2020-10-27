package com.baidu.tbadk.core.util;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.media.ExifInterface;
import android.support.v4.content.FileProvider;
import android.telephony.TelephonyManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AiAppGuideActivityConfig;
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.ReplyMeActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.switchs.VideoMiddlePageSwitch;
import com.baidu.tbadk.switchs.VideoSquareMiddlePageSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import com.baidu.webkit.internal.ETAG;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
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
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.conn.util.InetAddressUtils;
import tbclient.BaijiahaoInfo;
/* loaded from: classes.dex */
public class UtilHelper {
    public static final int BIG_GOD_ICON_TYPE_PB = 4;
    public static final int BJH_AUTH_ICON_TYPE_CARD = 0;
    public static final int BJH_AUTH_ICON_TYPE_PX12 = 1;
    public static final int BJH_AUTH_ICON_TYPE_PX16 = 2;
    public static final int BJH_AUTH_ICON_TYPE_PX20 = 3;
    private static final int BJH_AUTH_TYPE_COMPANY = 2;
    public static final int BJH_AUTH_TYPE_NORMAL = 0;
    private static final int BJH_AUTH_TYPE_PERSONAL = 3;
    private static final int BJH_AUTH_TYPE_STAR = 1;
    public static final String KEY_HAS_TOKEN = "has_token";
    private static final String NATIVE_PAY_FROM = "from_type";
    public static final int PROCESS_LIMIT_NONE = 0;
    private static final Pattern pbPattern0 = Pattern.compile("(tieba.baidu.com/p/){1}([\\d]+)");
    private static final String[] sNativeAdPrefixes = {"http://m.baidu.com/baidu.php?url=", "https://m.baidu.com/baidu.php?url="};
    private static final String[] sNativeAdEncoded = {"http%3a%2f%2fm.baidu.com%2fbaidu.php%3furl%3d", "https%3a%2f%2fm.baidu.com%2fbaidu.php%3furl%3d"};

    /* loaded from: classes.dex */
    public enum NativePageType {
        NONE,
        FRS,
        PB
    }

    /* loaded from: classes.dex */
    public static class a {
        public NativePageType eIp = NativePageType.NONE;
        public String id;
    }

    public static int getBitmapMaxMemory(Context context) {
        return CompatibleUtile.getInstance().getBitmapMaxMemory(context);
    }

    public static void showToast(Context context, String str) {
        f.showToast(context, str);
    }

    public static void showToast(Context context, int i) {
        f.showToast(context, i);
    }

    public static int getNetworkOperator() {
        String simOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService("phone")).getSimOperator();
        if (simOperator == null || simOperator.length() < 4 || com.baidu.adp.lib.util.k.isEmptyStringAfterTrim(simOperator)) {
            return 0;
        }
        String substring = simOperator.substring(0, 3);
        if (substring == null || !substring.equals(BdNetTypeUtil.NATION_CODE)) {
            return 0;
        }
        switch (com.baidu.adp.lib.f.b.toInt(simOperator.substring(3), 0)) {
            case 0:
            case 2:
            case 7:
                return 1;
            case 1:
            case 6:
                return 2;
            case 3:
            case 5:
            case 11:
                return 3;
            case 4:
            case 8:
            case 9:
            case 10:
            default:
                return 0;
        }
    }

    public static String getClientIP() {
        if (com.baidu.adp.lib.util.j.isWifiNet()) {
            return getWifiMac(TbadkCoreApplication.getInst().getApp());
        }
        return getGprsIpv4Address();
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
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    private static String transforIPV6(String str) {
        if (!StringUtils.isNull(str)) {
            StringBuffer stringBuffer = new StringBuffer();
            int indexOf = str.indexOf("::");
            if (indexOf >= 0) {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 2);
                int length = !StringUtils.isNull(substring) ? substring.split(":").length : 0;
                int length2 = !StringUtils.isNull(substring2) ? substring2.split(":").length : 0;
                int i = (8 - length) - length2;
                if (length > 0) {
                    stringBuffer.append(transforIPV6(substring));
                    stringBuffer.append(".");
                }
                for (int i2 = 0; i2 < i; i2++) {
                    stringBuffer.append("0");
                    if (i2 < i - 1) {
                        stringBuffer.append(".");
                    }
                }
                if (length2 > 0) {
                    stringBuffer.append(".");
                    stringBuffer.append(transforIPV6(substring2));
                }
            } else {
                String[] split = str.split(":");
                for (int i3 = 0; i3 < split.length; i3++) {
                    stringBuffer.append(String.valueOf(com.baidu.adp.lib.f.b.toInt(split[i3], 0, 16)));
                    if (i3 < split.length - 1) {
                        stringBuffer.append(".");
                    }
                }
            }
            return stringBuffer.toString();
        }
        return str;
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

    public static String getGprsIpv4Address() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    String hostAddress = nextElement.getHostAddress();
                    if (!nextElement.isLoopbackAddress() && InetAddressUtils.isIPv4Address(hostAddress)) {
                        return hostAddress;
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

    public static void quitDialog(final Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).ol(R.string.inform).iM(false).om(R.string.alert_quit_confirm).a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.core.util.UtilHelper.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                TbadkCoreApplication.getInst().notifyAppEnterBackground();
                activity.finish();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.UtilHelper.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(com.baidu.adp.base.i.I(activity)).bmC();
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
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    public static String getFixedBarText(String str, int i, boolean z, boolean z2) {
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
            } else if (z && z2) {
                sb.deleteCharAt(i2 - 1);
                sb.append(StringHelper.STRING_MORE);
            } else if (z) {
                sb.append(StringHelper.STRING_MORE);
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

    public static String getCurrentDay() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    public static boolean isSupportGesture(Context context) {
        return Build.VERSION.SDK_INT > 4 && CompatibleUtile.getInstance().supportMultiTouch(context);
    }

    public static final Intent getYYNotificationIntent(Context context, com.baidu.tbadk.core.data.at atVar, String str) {
        if (context == null || atVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list") || str.contains("com.baidu.tieba://unidispatch/frs?kw=")) {
            try {
                return Intent.parseUri(str, 1);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        Intent intent = new Intent(context, DealIntentService.class);
        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP)) {
            String substring = str.substring(str.lastIndexOf("/") + 1);
            intent.putExtra(DealIntentService.KEY_CLASS, 1);
            intent.putExtra("key_start_from", 7);
            intent.putExtra("id", substring);
            intent.putExtra("is_message_pv", true);
        } else if (str.equals("tab://1")) {
            intent.putExtra(DealIntentService.KEY_CLASS, 3);
            intent.putExtra("is_message_pv", true);
            intent.putExtra(FrsActivityConfig.KEY_REFRESH, true);
            intent.putExtra("close_dialog", true);
            intent.putExtra("locate_type", 0);
            intent.setFlags(603979776);
            TbadkCoreApplication.getInst().setWebviewCrashCount(0);
        } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
            if (!str.contains("ftid=")) {
                return null;
            }
            intent.putExtra(DealIntentService.KEY_CLASS, 29);
            intent.putExtra(PbChosenActivityConfig.KEY_TID, str.substring(str.lastIndexOf("ftid=") + 5));
            TiebaStatic.log(TbadkCoreStatisticKey.PUSH_RECOMMEND_PB_RECEIVE);
        } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE)) {
            try {
                intent.putExtra(DealIntentService.KEY_CLASS, 0);
                str = str.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE, "http://");
                intent.putExtra("url", str);
                intent.putExtra("is_message_pv", true);
            } catch (Exception e2) {
                BdLog.e(e2.toString());
                return null;
            }
        } else if (str.startsWith("pk_before:")) {
            intent.putExtra(DealIntentService.KEY_CLASS, 6);
            intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
        } else if (str.startsWith("pk_after:")) {
            intent.putExtra(DealIntentService.KEY_CLASS, 7);
            intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
        } else if (str.startsWith("vote")) {
            intent.putExtra(DealIntentService.KEY_CLASS, 8);
        } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PHOTOLIVE)) {
            intent.putExtra(DealIntentService.KEY_CLASS, 31);
            String substring2 = str.substring(str.lastIndexOf(UrlSchemaHelper.SCHEMA_TYPE_PHOTOLIVE) + 5);
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
        } else if (!str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_MIDDLE_PAGE)) {
            return null;
        } else {
            intent.putExtra(DealIntentService.KEY_CLASS, 34);
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
        intent.putExtra("message_id", atVar.getMessageID());
        intent.putExtra("task_id", atVar.getTaskId());
        if (!TextUtils.isEmpty(atVar.getStat())) {
            intent.putExtra("stat", atVar.getStat());
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
        if (str == null || at.isEmpty(str)) {
            return aVar;
        }
        Matcher matcher = pbPattern0.matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group(2);
                if (!TextUtils.isEmpty(group)) {
                    aVar.id = group;
                    aVar.eIp = NativePageType.PB;
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
            String[] split = substring2.split(ETAG.ITEM_SEPARATOR);
            if (!substring2.startsWith("kz=")) {
                int i2 = 0;
                while (true) {
                    if (i2 >= split.length) {
                        str2 = null;
                        break;
                    } else if (split[i2] == null || !split[i2].startsWith("kz=")) {
                        i2++;
                    } else {
                        str2 = split[i2].substring(3);
                        break;
                    }
                }
            } else {
                str2 = substring2.substring(3);
            }
            if (!TextUtils.isEmpty(str2)) {
                aVar.id = str2;
                aVar.eIp = NativePageType.PB;
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
            String[] split2 = substring.split(ETAG.ITEM_SEPARATOR);
            if (!substring.startsWith("kw=")) {
                while (true) {
                    if (i < split2.length) {
                        if (split2[i] == null || !split2[i].startsWith("kw=")) {
                            i++;
                        } else {
                            str3 = split2[i].substring(3);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                str3 = substring.substring(3);
            }
            if (!TextUtils.isEmpty(str3)) {
                aVar.id = str3;
                aVar.eIp = NativePageType.FRS;
            }
        }
        return aVar;
    }

    public static boolean isSystemLocationProviderEnabled(Context context) {
        boolean z;
        if (ae.checkLocationForGoogle(context)) {
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                if (!locationManager.isProviderEnabled("gps")) {
                    if (!locationManager.isProviderEnabled("network")) {
                        z = false;
                        return z;
                    }
                }
                z = true;
                return z;
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
                    sb.insert(0, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    i = 0;
                }
            }
        }
        return sb.toString();
    }

    public static boolean FirstStartActivity(Activity activity) {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) activity.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(100)) {
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
        sb.append((i >> 24) & 255).append(".");
        sb.append((i >> 16) & 255).append(".");
        sb.append((i >> 8) & 255).append(".");
        sb.append(i & 255);
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
        if (at.isEmpty(str) || str.indexOf("cuid=") <= -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") > 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
            } else {
                sb.append("?");
            }
            if (!isNativeAdURL(str)) {
                sb.append("cuid=");
                sb.append(TbadkCoreApplication.getInst().getCuid());
                sb.append("&cuid_galaxy2=");
                sb.append(TbadkCoreApplication.getInst().getCuidGalaxy2());
                sb.append("&cuid_gid=");
                sb.append(TbadkCoreApplication.getInst().getCuidGid());
            }
            sb.append("&timestamp=");
            sb.append(Long.toString(System.currentTimeMillis()));
            return sb.toString();
        }
        return str;
    }

    public static String appendVersionCode(String str) {
        return (at.isEmpty(str) || str.indexOf("_client_version=") <= -1) ? str + "&_client_version=" + TbConfig.getVersion() : str;
    }

    public static String urlAddParam(String str, String str2) {
        if (str != null && str2 != null) {
            if (str.indexOf("?") < 0) {
                str = str + "?";
            } else if (!str.endsWith("?") && !str.endsWith(ETAG.ITEM_SEPARATOR)) {
                str = str + ETAG.ITEM_SEPARATOR;
            }
            return str + str2;
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
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), str, null, 1, "st_param", str2);
                }
                Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
                intent.putExtra("android.intent.extra.TEXT", MessageFormat.format(context.getResources().getString(R.string.share_format), str3, str4, str5));
                intent.setFlags(268435456);
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, context.getResources().getString(R.string.share_to)));
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
            context.startActivity(Intent.createChooser(intent, TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.share_to)));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

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
                        com.baidu.adp.lib.util.n.close(randomAccessFile);
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.n.close(randomAccessFile);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                com.baidu.adp.lib.util.n.close(randomAccessFile);
                throw th;
            }
            if (randomAccessFile.read(bArr) >= 1) {
                String str = new String(bArr);
                int indexOf = str.indexOf(0);
                if (indexOf != -1) {
                    str = str.substring(0, indexOf);
                }
                if (str.toLowerCase().contains("arm")) {
                    com.baidu.adp.lib.util.n.close(randomAccessFile);
                    return true;
                }
                com.baidu.adp.lib.util.n.close(randomAccessFile);
                return false;
            }
            com.baidu.adp.lib.util.n.close(randomAccessFile);
            return false;
        }
        return true;
    }

    public static boolean isInstalledPackage(Context context, String str) {
        if (context.getPackageManager().getApplicationInfo(str, 8192) != null) {
            return true;
        }
        return false;
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
        intent.putExtra("sms_body", str2 + "");
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
                intent.setData(Uri.parse("http://www.baidu.com/"));
            }
            intent.putExtra("BROWSER_RESTART", true);
            intent.putExtra("EXTRA_URL_NEW_WINDOW", true);
            intent.putExtra("isBackToLauncher", true);
            intent.addFlags(268435456);
            if (TbConfig.IS_START_BAIDU_KUANG_CLOSE_SELF) {
                com.baidu.adp.base.a.lg().releaseAllAcitivities();
            }
            context.startActivity(intent);
        } catch (Exception e) {
            startBaiduWebView(context, str);
        }
    }

    private static void startBaiduWebView(Context context, String str) {
        if (str != null && str.length() > 0) {
            com.baidu.tbadk.browser.a.startInternalWebActivity(context, "http://m.baidu.com/s?from=1001157a&word=" + str);
        } else {
            com.baidu.tbadk.browser.a.startInternalWebActivity(context, "http://m.baidu.com/?from=1001157a");
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

    public static void setBitmapByTag(View view, String str, com.baidu.adp.widget.ImageView.a aVar) {
        if (view != null && str != null) {
            if (view.getTag() != null && view.getTag().equals(str)) {
                if (aVar == null) {
                    view.invalidate();
                } else if (view instanceof ImageView) {
                    aVar.drawImageTo((ImageView) view);
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
        return (!ae.checkReadPhoneState(TbadkCoreApplication.getInst()) || (telephonyManager = (TelephonyManager) TbadkCoreApplication.getInst().getSystemService("phone")) == null) ? "" : telephonyManager.getDeviceId();
    }

    public static String getTiebaApkMd5() {
        String str = null;
        try {
            String versionName = TbadkCoreApplication.getInst().getVersionName();
            String string = com.baidu.tbadk.core.sharedPref.b.bnH().getString(SharedPrefConfig.VERSION_NAME, "");
            if (!TextUtils.isEmpty(versionName)) {
                if (versionName.equals(string)) {
                    str = com.baidu.tbadk.core.sharedPref.b.bnH().getString(SharedPrefConfig.APK_MD5, "");
                } else {
                    com.baidu.tbadk.core.sharedPref.b.bnH().putString(SharedPrefConfig.VERSION_NAME, versionName);
                    String aPKMd5 = av.getAPKMd5(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(TbadkCoreApplication.getInst().getPackageName(), 0));
                    com.baidu.tbadk.core.sharedPref.b.bnH().putString(SharedPrefConfig.APK_MD5, aPKMd5);
                    str = aPKMd5;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            BdLog.detailException(e);
        }
        return str;
    }

    public static boolean isFlymeOsOver51() {
        String numFromStr;
        String str = Build.DISPLAY;
        if (str != null && str.contains("Flyme") && (numFromStr = com.baidu.adp.lib.util.l.getNumFromStr(str)) != null && numFromStr.length() >= 3) {
            int i = com.baidu.adp.lib.f.b.toInt(com.baidu.adp.lib.util.l.getNumFromStr(numFromStr.substring(0, 1)), 0);
            int i2 = com.baidu.adp.lib.f.b.toInt(com.baidu.adp.lib.util.l.getNumFromStr(numFromStr.substring(1, 2)), 0);
            if (i == 6 && i2 <= 1) {
                return true;
            }
            if (i == 5 && i2 >= 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMeizuM355() {
        return "Meizu".equalsIgnoreCase(Build.BRAND) && "M355".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean isMeizuE3() {
        return "Meizu".equalsIgnoreCase(Build.BRAND) && "MEIZU E3".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean isMeizuPro7Plus() {
        return "Meizu".equalsIgnoreCase(Build.BRAND) && "PRO 7 Plus".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean isOnePlus6() {
        return "OnePlus".equalsIgnoreCase(Build.BRAND) && "ONEPLUS A6000".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean isSMF9000() {
        return Build.MODEL.equalsIgnoreCase("SM-F9000");
    }

    public static boolean canUseStyleImmersiveSticky() {
        if (Build.VERSION.SDK_INT >= 19 && TbadkCoreApplication.getInst() != null && TbadkCoreApplication.getInst().isMeiZuCanUseImmersive() && !isSMF9000()) {
            return TbadkCoreApplication.getInst().isImmersiveStickyCanUse();
        }
        return false;
    }

    public static boolean useNavigationBarStyleImmersiveSticky(Activity activity, boolean z) {
        if (Build.VERSION.SDK_INT < 19 || activity == null || !com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.SWITCH_IMMERSIVE_STICKY_STATUS, true) || !TbadkCoreApplication.getInst().isMeiZuCanUseImmersive()) {
            return false;
        }
        for (AccessibilityServiceInfo accessibilityServiceInfo : ((AccessibilityManager) activity.getSystemService("accessibility")).getEnabledAccessibilityServiceList(1)) {
            if (!StringUtils.isNull(accessibilityServiceInfo.getSettingsActivityName()) && accessibilityServiceInfo.getSettingsActivityName().contains("talkback")) {
                com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.SWITCH_IMMERSIVE_STICKY_STATUS, false);
                TbadkCoreApplication.getInst().resetIsImmersiveStickyPrefHasRead(false);
                return false;
            }
        }
        boolean z2 = TbadkCoreApplication.getInst().getSkinType() != 2;
        if (Build.VERSION.SDK_INT >= 23) {
            useNavigationBarStyleImmersiveSticky_M(activity, z);
            StatusBarUtil.from(activity).setTransparentStatusbar(z2).setLightStatusBar(z2).process();
            return true;
        } else if (!StatusBarUtil.from(activity).setTransparentStatusbar(z2).setLightStatusBar(z2).process()) {
            com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.SWITCH_IMMERSIVE_STICKY_STATUS, false);
            TbadkCoreApplication.getInst().resetIsImmersiveStickyPrefHasRead(false);
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
        boolean z = false;
        boolean useNavigationBarStyleImmersiveSticky = useNavigationBarStyleImmersiveSticky(activity, false);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            z = true;
        }
        changeStatusBarIconAndTextColor(z, activity);
        return useNavigationBarStyleImmersiveSticky;
    }

    public static void useNavigationBarStyleImmersiveSticky_L(Activity activity, boolean z, boolean z2) {
        if (activity != null) {
            useNavigationBarStyleImmersiveSticky_L(activity.getWindow(), z, z2);
        }
    }

    public static void useNavigationBarStyleImmersiveSticky_L(Window window, boolean z, boolean z2) {
        if (window != null) {
            try {
                Field field = WindowManager.LayoutParams.class.getField("FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS");
                Field field2 = WindowManager.LayoutParams.class.getField("FLAG_TRANSLUCENT_STATUS");
                Field field3 = View.class.getField("SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN");
                Field field4 = View.class.getField("SYSTEM_UI_FLAG_LAYOUT_STABLE");
                Method method = window.getClass().getMethod("setStatusBarColor", Integer.TYPE);
                Method method2 = View.class.getMethod("setSystemUiVisibility", Integer.TYPE);
                if (field != null && field2 != null && field3 != null && field4 != null && method != null && method2 != null) {
                    int i = field.getInt(null);
                    int i2 = field2.getInt(null);
                    int i3 = field3.getInt(null);
                    int i4 = field4.getInt(null);
                    window.clearFlags(i2);
                    if (z2) {
                        Field field5 = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR");
                        if (field5 != null) {
                            window.getDecorView().setSystemUiVisibility(field5.getInt(null) | i3 | i4);
                        }
                    } else {
                        method2.invoke(window.getDecorView(), Integer.valueOf(i3 | i4));
                    }
                    window.addFlags(i);
                    method.invoke(window, 0);
                    if (z) {
                        Field field6 = WindowManager.LayoutParams.class.getField("FLAG_FULLSCREEN");
                        Method method3 = window.getClass().getMethod("setFlags", Integer.TYPE, Integer.TYPE);
                        int i5 = field6.getInt(null);
                        method3.invoke(window, Integer.valueOf(i5), Integer.valueOf(i5));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void useNavigationBarStyleImmersiveSticky_M(Activity activity, boolean z) {
        useNavigationBarStyleImmersiveSticky_L(activity, z, true);
    }

    public static void useNavigationBarStyleImmersiveSticky_L(Activity activity) {
        useNavigationBarStyleImmersiveSticky_L(activity, false, false);
    }

    public static void useNavigationBarStyleImmersiveSticky_KitKat(Activity activity) {
        if (activity != null) {
            boolean z = false;
            int i = -1;
            try {
                Field field = WindowManager.LayoutParams.class.getField("FLAG_TRANSLUCENT_STATUS");
                if (field != null) {
                    i = field.getInt(null);
                    z = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (z) {
                activity.getWindow().setFlags(i, i);
            }
        }
    }

    public static void setStatusBarBackground(View view, int i) {
        if (view != null) {
            ap.setBackgroundColor(view, R.color.cp_bg_line_d);
        }
    }

    public static void changeStatusBarIconAndTextColor(boolean z, Activity activity) {
        int i;
        if (activity != null && activity.getWindow() != null && !isMeizuM355()) {
            if (Build.DISPLAY.toLowerCase().contains("flyme")) {
                changeFlyMeStatusBarColor(activity.getWindow(), z);
                setFlymeImmersedWindow(activity.getWindow(), canUseStyleImmersiveSticky());
            }
            if (Build.VERSION.SDK_INT >= 23) {
                View decorView = activity.getWindow().getDecorView();
                if (decorView != null && Build.VERSION.SDK_INT >= 23) {
                    int systemUiVisibility = decorView.getSystemUiVisibility();
                    if (z) {
                        i = systemUiVisibility & (-8193);
                    } else {
                        if (TbadkCoreApplication.getInst().isMIUIRom()) {
                            Window window = activity.getWindow();
                            window.addFlags(Integer.MIN_VALUE);
                            window.clearFlags(67108864);
                        }
                        i = systemUiVisibility | 8192;
                    }
                    decorView.setSystemUiVisibility(i);
                    return;
                }
                return;
            }
            StatusBarUtil.from(activity).setTransparentStatusbar(true).setLightStatusBar(z ? false : true).process();
        }
    }

    public static boolean isFlyMeOs() {
        return Build.DISPLAY.toLowerCase().contains("flyme");
    }

    private static void changeFlyMeStatusBarColor(Window window, boolean z) {
        int color;
        if (canUseStyleImmersiveSticky()) {
            ar.setStatusBarDarkIcon(window, z);
        } else if (Build.VERSION.SDK_INT >= 19 && window != null) {
            try {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                Method declaredMethod = Window.class.getDeclaredMethod("setStatusBarColor", Integer.TYPE);
                declaredMethod.setAccessible(true);
                if (z) {
                    color = ap.getColor(R.color.black_alpha60);
                } else {
                    color = ap.getColor(R.color.common_color_10274);
                }
                declaredMethod.invoke(window, Integer.valueOf(color));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public static void setFlymeImmersedWindow(Window window, boolean z) {
        int i;
        if (z && window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (Build.VERSION.SDK_INT < 19) {
                try {
                    Field declaredField = attributes.getClass().getDeclaredField("meizuFlags");
                    declaredField.setAccessible(true);
                    int i2 = declaredField.getInt(attributes);
                    if (z) {
                        i = 64 | i2;
                    } else {
                        i = i2 & (-65);
                    }
                    declaredField.setInt(attributes, i);
                    return;
                } catch (Exception e) {
                    BdLog.e(e);
                    return;
                }
            }
            attributes.flags |= 67108864;
            window.setAttributes(attributes);
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
                sb.append(StringHelper.STRING_MORE);
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
        SQLiteDatabase openOrCreateDatabase;
        try {
            openOrCreateDatabase = context.openOrCreateDatabase("webviewCache.db", 0, null);
        } catch (Throwable th) {
            try {
                if (BdLog.isDebugMode()) {
                    BdLog.e(th.getMessage());
                }
            } finally {
                com.baidu.adp.lib.util.n.close((SQLiteDatabase) null);
            }
        }
        if (openOrCreateDatabase != null) {
            com.baidu.adp.lib.util.n.close(openOrCreateDatabase);
            return false;
        }
        com.baidu.adp.lib.util.n.close(openOrCreateDatabase);
        return true;
    }

    public static void install_apk(Context context, String str) {
        File GetFile;
        if (str != null && str.length() > 0 && (GetFile = n.GetFile(str)) != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(getUriFromFile(GetFile, intent, context), "application/vnd.android.package-archive");
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
            com.baidu.adp.lib.util.l.showToast(context, R.string.game_start_fail);
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
            if (str.length() > 4 && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
                String substring = str.substring(4);
                String str2 = strArr[0];
                if (!TextUtils.isEmpty(substring)) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str2, substring, false);
                }
            } else if (str.length() > 4 && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_FRS)) {
                String substring2 = str.substring(4);
                if (!TextUtils.isEmpty(substring2)) {
                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(context).createNormalCfg(substring2, "official_bar");
                    createNormalCfg.setCallFrom(13);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                }
            } else if (str.length() > 4 && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                String substring3 = str.substring(3);
                if (!TextUtils.isEmpty(substring3)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(context).createNormalCfg(substring3, null, "official_bar")));
                }
            }
        }
    }

    public static SpannableStringBuilder getSpannableIcon(Context context, String str, int i, boolean z) {
        if (com.baidu.adp.lib.util.k.isEmpty(str) || context == null || i == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Bitmap bitmap = ap.getBitmap(i);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        if (bitmap != null) {
            bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
        iVar.setOffset(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds4));
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) " ");
        if (z) {
            spannableStringBuilder.setSpan(iVar, length, spannableStringBuilder.length(), 17);
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.append((CharSequence) str);
            return spannableStringBuilder;
        }
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.append((CharSequence) " ");
        spannableStringBuilder.setSpan(iVar, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder getSpannableIconByVertical(Context context, String str, int i, boolean z) {
        if (com.baidu.adp.lib.util.k.isEmpty(str) || context == null || i == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Bitmap bitmap = ap.getBitmap(i);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        if (bitmap != null) {
            bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        com.baidu.tbadk.core.view.l lVar = new com.baidu.tbadk.core.view.l(bitmapDrawable);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) " ");
        if (z) {
            spannableStringBuilder.setSpan(lVar, length, spannableStringBuilder.length(), 17);
            spannableStringBuilder.append((CharSequence) str);
            return spannableStringBuilder;
        }
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(lVar, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static boolean commenDealIntent(Context context, Intent intent) {
        boolean z;
        PbActivityConfig createNormalCfg;
        boolean z2 = false;
        if (intent == null || intent.getExtras() == null) {
            return false;
        }
        int i = intent.getExtras().getInt(DealIntentService.KEY_CLASS, -1);
        switch (i) {
            case 0:
                com.baidu.tbadk.browser.a.startWebActivity(context, intent.getExtras().getString("url"));
                z = true;
                break;
            case 1:
                String stringExtra = intent.getStringExtra("id");
                String stringExtra2 = intent.getStringExtra("from");
                String string = intent.getExtras().getString("stat");
                String stringExtra3 = intent.getStringExtra("link");
                String stringExtra4 = intent.getStringExtra("task_id");
                if (!at.isEmpty(stringExtra4)) {
                    TbadkCoreApplication.getInst().setTaskId(stringExtra4);
                }
                boolean booleanExtra = intent.getBooleanExtra(TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY, false);
                long j = intent.getExtras().getLong("message_id");
                int i2 = intent.getExtras().getInt("video_channel_id", 0);
                if (i2 > 0) {
                    TiebaStatic.log(new aq("c11918").aj("obj_id", i2));
                }
                if (intent.getBooleanExtra("is_message_pv", false)) {
                    createNormalCfg = new PbActivityConfig(context).createMessageCfg(stringExtra, null, stringExtra2, j, stringExtra3, string, "op");
                } else {
                    createNormalCfg = new PbActivityConfig(context).createNormalCfg(stringExtra, null, stringExtra2);
                }
                if (booleanExtra) {
                    createNormalCfg.setFromPushNotify();
                    String stringExtra5 = intent.getStringExtra("gid");
                    if (!TextUtils.isEmpty(stringExtra5)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(stringExtra5 + "", 4)));
                    }
                }
                if (intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_LOCAL_PUSH, false)) {
                    TiebaStatic.log(new aq("c13265"));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                z = true;
                break;
            case 2:
                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(context).createNormalCfg(intent.getStringExtra("fname"), intent.getStringExtra("from"));
                createNormalCfg2.setCallFrom(13);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                z = true;
                break;
            case 3:
                z2 = true;
                if (com.baidu.tbadk.core.e.b.bnx() != null) {
                    intent.setClass(context, com.baidu.tbadk.core.e.b.bnx());
                    if (!(context instanceof Activity) && intent != null) {
                        intent.addFlags(268435456);
                    }
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
            case 16:
            case 17:
            case 20:
            case 26:
            default:
                z = false;
                break;
            case 5:
            case 11:
            case 21:
            case 35:
                z2 = true;
                int intExtra = intent.getIntExtra("agree_me", 0);
                int intExtra2 = intent.getIntExtra("at_me", 0);
                int intExtra3 = intent.getIntExtra("reply_me", 0);
                int intExtra4 = intent.getIntExtra("chat", 0);
                int intExtra5 = intent.getIntExtra("group_msg", 0);
                int intExtra6 = intent.getIntExtra("group_msg_validate", 0);
                int intExtra7 = intent.getIntExtra("group_msg_updates", 0);
                int intExtra8 = intent.getIntExtra("officialbar_msg", 0);
                int intExtra9 = intent.getIntExtra("KeyOfNotiId", 16);
                int btL = com.baidu.tbadk.coreExtra.messageCenter.b.bts().btL();
                int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.b.bts().getMsgReplyme();
                int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.b.bts().getMsgAtme();
                int btM = com.baidu.tbadk.coreExtra.messageCenter.b.bts().btM();
                int msgFans = com.baidu.tbadk.coreExtra.messageCenter.b.bts().getMsgFans();
                int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.b.bts().getMsgGiftNum();
                com.baidu.tbadk.coreExtra.messageCenter.b.bts().d(btL, msgReplyme, msgAtme, btM, msgFans, msgGiftNum);
                boolean z3 = intExtra4 > 0 || intExtra7 > 0 || intExtra6 > 0 || intExtra5 > 0 || intExtra8 > 0;
                boolean z4 = intExtra9 == 29 && intExtra > 0;
                boolean z5 = intExtra9 == 24 && intExtra3 > 0;
                boolean z6 = intExtra9 == 25 && intExtra2 > 0;
                if (z4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(context)));
                    com.baidu.tbadk.coreExtra.messageCenter.b.bts().qy(0);
                    z = true;
                    break;
                } else if (!z5) {
                    if (!z6) {
                        if (i == 35) {
                            if (z3 || intExtra > 0 || intExtra3 > 0 || intExtra2 > 0 || msgGiftNum > 0 || btM > 0) {
                                goToMessageCenterFromNotifyCenter(intExtra9);
                                z = true;
                                break;
                            } else {
                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                int i3 = 0;
                                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                    i3 = TbadkCoreApplication.getCurrentAccountInfo().getSex();
                                }
                                if (currentAccount != null && currentAccount.length() > 0) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(context, false, currentAccount, i3)));
                                    com.baidu.tbadk.coreExtra.messageCenter.b.bts().setMsgFans(0);
                                }
                                z = true;
                                break;
                            }
                        } else {
                            if (z3) {
                                TiebaStatic.log(TbadkCoreStatisticKey.PUSH_MESSAGE_CLICK);
                                if (i == 5 && com.baidu.tbadk.core.e.b.getCurrentTabType() == 3) {
                                    goToMessageCenterFromNotifyCenter(intExtra9);
                                    z = true;
                                    break;
                                } else {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(context, intent.getIntExtra("tab_id", -1))));
                                    Intent intent2 = new Intent();
                                    intent2.putExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, intExtra9);
                                    intent2.putExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 2);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY, intent2));
                                    z = true;
                                    break;
                                }
                            }
                            z = z2;
                            break;
                        }
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(context)));
                        com.baidu.tbadk.coreExtra.messageCenter.b.bts().setMsgAtme(0);
                        z = true;
                        break;
                    }
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bts().setMsgReplyme(0);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMeActivityConfig(context)));
                    com.baidu.tbadk.coreExtra.messageCenter.b.bts().setMsgReplyme(0);
                    z = true;
                    break;
                }
                break;
            case 8:
                com.baidu.tbadk.core.e.b.r(context, 2);
                z = true;
                break;
            case 9:
                if (!TbadkCoreApplication.isLogin()) {
                    bg.skipToLoginActivity(context);
                    z = true;
                    break;
                } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(context)));
                    z = true;
                    break;
                } else {
                    com.baidu.tbadk.core.e.b.r(context, 1);
                    z = true;
                    break;
                }
            case 12:
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                if (com.baidu.tbadk.core.e.b.getCurrentTabType() == 8) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createNormalCfg(8)));
                } else if (!TextUtils.isEmpty(currentAccount2) && !TextUtils.isEmpty(currentAccountName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, currentAccount2, currentAccountName, com.baidu.tbadk.coreExtra.messageCenter.b.bts().getMsgFans())));
                }
                z = true;
                break;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(context, com.baidu.adp.lib.f.b.toLong(intent.getStringExtra("groupid"), 0L), 0)));
                z = true;
                break;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.IM_UPDATES_ACTIVITY_START));
                z = true;
                break;
            case 15:
                com.baidu.tbadk.pay.c.bzK().a(new PayConfig(com.baidu.adp.lib.f.b.toInt(intent.getStringExtra("pay_type"), 0), intent.getStringExtra("is_left"), intent.getStringExtra("props_id"), intent.getStringExtra("quan_num"), intent.getStringExtra("props_mon"), true, intent.getStringExtra("refer_page"), intent.getStringExtra("click_zone")), context);
                z = false;
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
                String stringExtra6 = intent.getStringExtra("barid");
                String stringExtra7 = intent.getStringExtra("barname");
                String stringExtra8 = intent.getStringExtra("portrait");
                long j2 = com.baidu.adp.lib.f.b.toLong(stringExtra6, -1L);
                if (j2 > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(context, j2, stringExtra7, stringExtra8, 0)));
                    z = true;
                    break;
                }
                z = z2;
                break;
            case 23:
                String stringExtra9 = intent.getStringExtra("wanted_type");
                String stringExtra10 = intent.getStringExtra("from_type");
                String stringExtra11 = intent.getStringExtra("refer_page");
                String stringExtra12 = intent.getStringExtra("click_zone");
                int parseInt = Integer.parseInt(stringExtra9);
                int i4 = 0;
                if (!StringUtils.isNull(stringExtra10)) {
                    if (stringExtra10.equals(TbadkCoreStatisticKey.TAIL_PAY_MEMBER_SUCCESS)) {
                        i4 = 6;
                    } else if (stringExtra10.equals(TbadkCoreStatisticKey.BUBBLE_PAY_MEMBER_SUCCESS)) {
                        i4 = 7;
                    }
                }
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(context, parseInt, false, i4);
                memberPayActivityConfig.setReferPageClickZone(stringExtra11, stringExtra12);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                z = true;
                break;
            case 24:
                z2 = true;
                String currentAccount3 = TbadkCoreApplication.getCurrentAccount();
                String currentAccountName2 = TbadkCoreApplication.getCurrentAccountName();
                if (currentAccount3 != null && currentAccount3.length() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(context, currentAccount3, currentAccountName2, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow() : currentAccountName2, 0)));
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(context, com.baidu.adp.lib.f.b.toLong(intent.getStringExtra("uid"), 0L), intent.getStringExtra(BdStatsConstant.StatsKey.UNAME), null, 0, intent.getIntExtra("user_type", 0))));
                z = true;
                break;
            case 28:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(context, com.baidu.adp.lib.f.b.toLong(intent.getStringExtra(PbChosenActivityConfig.KEY_TID), 0L), null)));
                z = true;
                break;
            case 29:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(context, com.baidu.adp.lib.f.b.toLong(intent.getStringExtra(PbChosenActivityConfig.KEY_TID), 0L), null, 2)));
                z = true;
                break;
            case 30:
                z2 = true;
                String string2 = intent.getExtras().getString(BigdayActivityConfig.JUMP_URL);
                boolean z7 = intent.getExtras().getBoolean("is_ad", false);
                com.baidu.adp.base.h G = com.baidu.adp.base.i.G(context);
                if (G instanceof BaseActivity) {
                    be.boR().a(((BaseActivity) G).getPageContext(), new String[]{string2}, z7);
                    z = true;
                    break;
                } else if (G instanceof BaseFragmentActivity) {
                    be.boR().a(((BaseFragmentActivity) G).getPageContext(), new String[]{string2}, z7);
                    z = true;
                    break;
                } else {
                    if (G instanceof ProxyAdkBaseActivity) {
                        be.boR().a(((ProxyAdkBaseActivity) G).getPageContext(), new String[]{string2}, z7);
                        z = true;
                        break;
                    }
                    z = z2;
                    break;
                }
            case 31:
                TiebaStatic.log(TbadkCoreStatisticKey.PUSH_ENTRANCE);
                z = true;
                break;
            case 32:
                try {
                    PaymentConfirmRequestData paymentConfirmRequestData = (PaymentConfirmRequestData) intent.getSerializableExtra(PaymentConfirmActivityConfig.REQUEST_PARAMS);
                    if (paymentConfirmRequestData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PaymentConfirmActivityConfig(context, paymentConfirmRequestData, "", "")));
                    }
                    z = true;
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    z = true;
                    break;
                }
            case 33:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(context)));
                TiebaStatic.log(TbadkCoreStatisticKey.PL_COLLECT_UPDATE_NOTIFICATION);
                z = true;
                break;
            case 34:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(context).createNormalCfg(intent.getStringExtra("fid"), intent.getStringExtra("tid"), "push")));
                z = true;
                break;
            case 36:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(context, intent.getIntExtra("tab_id", -1))));
                z = true;
                break;
            case 37:
                z2 = true;
                String stringExtra13 = intent.getStringExtra(IntentConfig.KEY_AI_APP_SCHEMA);
                TbPageContext<BaseFragmentActivity> tbPageContext = null;
                if (context instanceof BaseActivity) {
                    tbPageContext = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    tbPageContext = ((BaseFragmentActivity) context).getPageContext();
                }
                if (tbPageContext != null) {
                    be.boR().b(tbPageContext, new String[]{stringExtra13});
                    z = true;
                    break;
                }
                z = z2;
                break;
            case 38:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AiAppGuideActivityConfig(context)));
                z = true;
                break;
            case 39:
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(context).createSubPbActivityConfig(intent.getStringExtra("thread_id"), intent.getStringExtra("post_id"), "", true);
                createSubPbActivityConfig.setIsFromeSchema(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
                z = true;
                break;
        }
        if (!z) {
            intent.putExtra(DealIntentService.KEY_CLASS, 3);
            return commenDealIntent(context, intent);
        }
        return z;
    }

    public static void goToMessageCenterFromNotifyCenter(int i) {
        Intent intent = new Intent();
        intent.putExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, i);
        intent.putExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 1);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY, intent));
        com.baidu.tbadk.core.e.b.r(TbadkCoreApplication.getInst().getApplicationContext(), 3);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2590=4] */
    public static String getSystemProperty(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader3.readLine();
                bufferedReader3.close();
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                        return readLine;
                    } catch (IOException e) {
                        return readLine;
                    }
                }
                return readLine;
            } catch (IOException e2) {
                bufferedReader = bufferedReader3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader3;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void showYYNotification(Context context, com.baidu.tbadk.core.data.at atVar, int i) {
        String content = atVar.getContent();
        String link = atVar.getLink();
        if (link != null && link.length() > 0) {
            Intent yYNotificationIntent = getYYNotificationIntent(context, atVar, link);
            if (yYNotificationIntent != null && yYNotificationIntent.getDataString() != null && yYNotificationIntent.getDataString().contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                yYNotificationIntent.setFlags(276824064);
                NotificationHelper.showNotification(context, i, null, content, content, PendingIntent.getActivity(context, i, yYNotificationIntent, 134217728), false);
            } else if (yYNotificationIntent != null) {
                NotificationHelper.showNotification(context, i, null, content, content, PendingIntent.getService(context, 0, yYNotificationIntent, 134217728), false);
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
            return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(com.baidu.adp.lib.f.b.toInt(Class.forName("com.android.internal.R$dimen").getField("status_bar_height").get(null).toString(), 0));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getLightStatusBarHeight() {
        if (canUseStyleImmersiveSticky()) {
            try {
                return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(com.baidu.adp.lib.f.b.toInt(Class.forName("com.android.internal.R$dimen").getField("status_bar_height").get(null).toString(), 0));
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public static int getStatusBarHeight_gtoe9_0() {
        int identifier = TbadkCoreApplication.getInst().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            return 0;
        }
        return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(identifier);
    }

    public static int getStatusBarHeight_ltoe9_0() {
        try {
            return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(com.baidu.adp.lib.f.b.toInt(Class.forName("com.android.internal.R$dimen").getField("status_bar_height").get(null).toString(), 0));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static long getCorrectUserIdAfterOverflowCut(long j) {
        if (j < 0) {
            return j + ((2147483647L + 1) * 2);
        }
        return j;
    }

    public static String getTopActivityClassName() {
        Activity currentActivity;
        ComponentName componentName;
        if (com.baidu.adp.base.a.lg() == null || (currentActivity = com.baidu.adp.base.a.lg().currentActivity()) == null || (componentName = currentActivity.getComponentName()) == null) {
            return null;
        }
        return componentName.getClassName();
    }

    public static boolean isFloatWindowOpAllowed(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (TbadkCoreApplication.getInst().isMIUIRom()) {
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
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) TbadkCoreApplication.getInst().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && !StringUtils.isNull(runningAppProcessInfo.processName) && runningAppProcessInfo.processName.equals(TbadkCoreApplication.getInst().getPackageName()) && runningAppProcessInfo.importance == 100) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectOpenGLES20(Context context) {
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) == null || (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) == null) {
            return false;
        }
        return deviceConfigurationInfo.reqGlEsVersion >= 131072;
    }

    public static boolean isHaveActivityCanHandleIntent(Intent intent) {
        List<ResolveInfo> list = null;
        PackageManager packageManager = TbadkCoreApplication.getInst().getPackageManager();
        if (packageManager != null) {
            list = packageManager.queryIntentActivities(intent, 32);
        }
        return y.getCount(list) > 0;
    }

    public static boolean isDecimal(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return Pattern.compile("[0-9|\\.]+").matcher(str).matches();
    }

    public static boolean isNumber(String str) {
        return Pattern.compile(EditTextPasteFilterUtils.REGX_NUMBER).matcher(str).matches();
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
            String substring = str.substring(str.lastIndexOf(UrlSchemaHelper.SCHEMA_TYPE_MIDDLE_PAGE) + 11);
            String str3 = "";
            if (substring.startsWith("flag=")) {
                str3 = substring.substring(5, substring.indexOf(ETAG.ITEM_SEPARATOR));
                substring = substring.substring(str3.length() + 1 + 5);
            }
            if (!"1".equals(str3)) {
                return false;
            }
            if (substring.startsWith("fid=")) {
                str2 = substring.substring(substring.lastIndexOf("fid=") + 4, substring.indexOf(ETAG.ITEM_SEPARATOR));
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

    public static String formatOverStep(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        return str.length() > i ? str.substring(0, i) + StringHelper.STRING_MORE : str;
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

    public static boolean isSelf(MetaData metaData) {
        if (metaData == null) {
            return false;
        }
        String userId = metaData.getUserId();
        if (StringUtils.isNull(userId)) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return !StringUtils.isNull(currentAccount) && currentAccount.equals(userId);
    }

    public static Uri getUriFromFile(File file, Intent intent, Context context) {
        if (file == null || intent == null || context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
            return FileProvider.getUriForFile(context, "com.baidu.tieba.fileprovider", file);
        }
        return Uri.fromFile(file);
    }

    public static int getRealScreenOrientation(Context context) {
        int[] screenDimensions = com.baidu.adp.lib.util.l.getScreenDimensions(context);
        int i = context.getResources().getConfiguration().orientation;
        if (i == 2 || screenDimensions[0] <= screenDimensions[1]) {
            return i;
        }
        return 2;
    }

    public static long getDayBetweenTime(long j, long j2) {
        return ((j2 - j) / 1000) / 86400;
    }

    public static String getForumNameWithBar(String str) {
        return getForumNameWithGodBar(str, -1, false);
    }

    public static String getForumNameWithBar(String str, int i, boolean z) {
        if (i <= -1) {
            if (com.baidu.adp.lib.util.k.byteLength(str) > 14) {
                str = at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
            }
        } else {
            str = getFixedBarText(str, i, z);
        }
        return TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{str});
    }

    public static String getForumNameWithGodBar(String str, int i, boolean z) {
        if (i <= -1) {
            if (com.baidu.adp.lib.util.k.byteLength(str) > 14) {
                str = at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
            }
        } else {
            str = getFixedBarText(str, i, z);
        }
        return TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_god_bar, new Object[]{str});
    }

    public static String getUserName(com.baidu.tbadk.data.MetaData metaData) {
        return metaData == null ? "" : metaData.getName_show();
    }

    public static void showHeadImageViewBigV(HeadImageView headImageView, com.baidu.tbadk.data.MetaData metaData) {
        showHeadImageViewBigV(headImageView, metaData, 0);
    }

    public static void showHeadImageViewBigV(HeadImageView headImageView, com.baidu.tbadk.data.MetaData metaData, int i) {
        boolean z = true;
        if (headImageView != null && metaData != null) {
            if (metaData.isNewGod()) {
                headImageView.setBjhAuthIconRes(0);
                headImageView.setBazhuIconRes(0);
                headImageView.setGodIconResId(R.drawable.icon_mask_shen_liang20_svg);
                headImageView.setShowV(true);
            } else if (metaData.getBazhuGradeData() != null && !at.isEmpty(metaData.getBazhuGradeData().getLevel()) && metaData.showBazhuGrade()) {
                int bazhuIconId = getBazhuIconId(metaData.getBazhuGradeData().getLevel(), true);
                headImageView.setBjhAuthIconRes(0);
                headImageView.setBazhuIconRes(bazhuIconId);
                headImageView.setShowV(true);
            } else if (metaData.getBaijiahaoInfo() != null && isShowBjhBigV(metaData.getBaijiahaoInfo())) {
                headImageView.setBjhAuthIconRes(getBjhBigVIconId(metaData.getBaijiahaoInfo().auth_id.intValue(), i));
                headImageView.setShowV(true);
            } else {
                boolean z2 = (metaData.getPendantData() == null || StringUtils.isNull(metaData.getPendantData().bhW())) ? false : true;
                if (!metaData.isBigV() || z2) {
                    z = false;
                }
                headImageView.setShowV(z);
            }
        }
    }

    public static Drawable getBjhBigVIconDrawable(int i) {
        return SvgManager.boN().a(i, SvgManager.SvgResourceStateType.NORMAL);
    }

    public static int getBjhBigVIconId(int i, int i2) {
        if (i <= 0) {
            return 0;
        }
        if (i2 == 0 || i2 == 4) {
            return R.drawable.ic_icon_mask_v14_n_svg;
        }
        if (i2 == 1) {
            return R.drawable.ic_icon_mask_v12_n_svg;
        }
        if (i2 == 2) {
            return R.drawable.ic_icon_mask_v16_n_svg;
        }
        if (i2 == 3) {
            return R.drawable.ic_icon_mask_v20_n_svg;
        }
        return R.drawable.ic_icon_mask_v14_n_svg;
    }

    public static int getBazhuIconId(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        return (str.equals("5") || str.toUpperCase().equals(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS)) ? z ? R.drawable.pic_barman_5level_simple12 : R.drawable.pic_barman_5level40 : (str.equals("4") || str.toUpperCase().equals("B")) ? z ? R.drawable.pic_barman_4level_simple12 : R.drawable.pic_barman_4level40 : (str.equals("3") || str.toUpperCase().equals("C")) ? z ? R.drawable.pic_barman_3level_simple12 : R.drawable.pic_barman_3level40 : (str.equals("2") || str.toUpperCase().equals("D")) ? z ? R.drawable.pic_barman_2level_simple12 : R.drawable.pic_barman_2level40 : z ? R.drawable.pic_barman_1level_simple12 : R.drawable.pic_barman_1level40;
    }

    public static boolean showHeadBjhBigVIcon(ImageView imageView, com.baidu.tbadk.data.MetaData metaData, int i) {
        if (imageView == null || metaData == null || metaData.getBaijiahaoInfo() == null || !isShowBjhBigV(metaData.getBaijiahaoInfo())) {
            return false;
        }
        int bjhBigVIconId = getBjhBigVIconId(metaData.getBaijiahaoInfo().auth_id.intValue(), i);
        imageView.setVisibility(0);
        SvgManager.boN().a(imageView, bjhBigVIconId, SvgManager.SvgResourceStateType.NORMAL);
        return true;
    }

    public static boolean showHeadBazhuIcon(ImageView imageView, com.baidu.tbadk.data.MetaData metaData, boolean z) {
        if (imageView == null || metaData == null || metaData.getBazhuGradeData() == null || at.isEmpty(metaData.getBazhuGradeData().getLevel()) || !metaData.showBazhuGrade()) {
            return false;
        }
        int bazhuIconId = getBazhuIconId(metaData.getBazhuGradeData().getLevel(), z);
        imageView.setVisibility(0);
        ap.setImageResource(imageView, bazhuIconId);
        return true;
    }

    public static boolean showHeadBjhBigVIcon(HeadPendantView headPendantView, com.baidu.tbadk.data.MetaData metaData, int i) {
        if (headPendantView == null || metaData == null || metaData.getBaijiahaoInfo() == null || !isShowBjhBigV(metaData.getBaijiahaoInfo())) {
            return false;
        }
        headPendantView.a(metaData, i);
        return true;
    }

    private static boolean isShowBjhBigV(BaijiahaoInfo baijiahaoInfo) {
        return baijiahaoInfo != null && baijiahaoInfo.auth_id.intValue() > 0;
    }

    public static String getFromPageKey(TbPageContext tbPageContext) {
        if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof com.baidu.tbadk.m.a)) {
            return null;
        }
        com.baidu.tbadk.m.a aVar = (com.baidu.tbadk.m.a) tbPageContext.getPageActivity();
        if (aVar.getCurrentPageSourceKeyList() == null) {
            return null;
        }
        return (String) y.getItem(aVar.getCurrentPageSourceKeyList(), aVar.getCurrentPageSourceKeyList().size() - 1);
    }

    public static boolean isGotoVideoMiddlePage() {
        return SwitchManager.getInstance().findType(VideoMiddlePageSwitch.KEY) == 1;
    }

    public static boolean isGotoVideoSquareMiddlePage() {
        return SwitchManager.getInstance().findType(VideoSquareMiddlePageSwitch.KEY) == 1;
    }

    public static boolean isOppoConcaveScreen() {
        if (TbadkCoreApplication.getInst().getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism")) {
            String str = Build.MODEL;
            for (String str2 : new String[]{"PAAM00", "PAAT00", "PACM00", "PACT00", "CPH1831", "CPH1833"}) {
                if (str.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean hasNotchAtHuawei(Activity activity) {
        boolean z;
        if (activity == null) {
            return false;
        }
        try {
            Class<?> loadClass = activity.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            z = ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException e) {
            z = false;
        } catch (NoSuchMethodException e2) {
            z = false;
        } catch (Exception e3) {
            z = false;
        }
        return z;
    }

    public static boolean isNotchScreen(Activity activity) {
        boolean hasNotchAndroidP = Build.VERSION.SDK_INT >= 28 ? hasNotchAndroidP(activity) : false;
        return !hasNotchAndroidP ? hasNotchMiui() || hasNotchAtHuawei(activity) || isOnePlus6() || hasNotchOPPO() || hasNotchVivo() : hasNotchAndroidP;
    }

    public static boolean hasNotchOPPO() {
        return TbadkCoreApplication.getInst().getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean hasNotchVivo() {
        try {
            Class<?> loadClass = TbadkCoreApplication.getInst().getClassLoader().loadClass("android.util.FtFeature");
            Method[] declaredMethods = loadClass.getDeclaredMethods();
            if (declaredMethods != null) {
                for (Method method : declaredMethods) {
                    if (method != null && method.getName().equalsIgnoreCase("isFeatureSupport")) {
                        return ((Boolean) method.invoke(loadClass, 32)).booleanValue();
                    }
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean hasNotchMiui() {
        String systemProperty = getSystemProperty("ro.miui.notch");
        return !StringUtils.isNULL(systemProperty) && systemProperty.equals("1");
    }

    public static boolean hasNotchAndroidP(Activity activity) {
        if (activity == null) {
            return false;
        }
        try {
            View decorView = activity.getWindow().getDecorView();
            if (decorView == null || Build.VERSION.SDK_INT < 23) {
                return false;
            }
            WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
            Method declaredMethod = WindowInsets.class.getDeclaredMethod("getDisplayCutout", new Class[0]);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(rootWindowInsets, new Object[0]) != null;
        } catch (NoSuchMethodException e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean isCutoutScreen(Activity activity) {
        try {
            Resources resources = activity.getResources();
            int identifier = resources.getIdentifier("config_mainBuiltInDisplayCutout", "string", "android");
            String string = identifier > 0 ? resources.getString(identifier) : null;
            if (string != null) {
                return !TextUtils.isEmpty(string);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static int getVirtualBarHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics.heightPixels - windowManager.getDefaultDisplay().getHeight();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getScreenHeight(Context context) {
        int i;
        if (context == null) {
            return 0;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            i = displayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (i == 0) {
            return com.baidu.adp.lib.util.l.getEquipmentHeight(context);
        }
        return i;
    }

    public static String getClipBoardContent() {
        try {
            ClipData primaryClip = ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip != null && primaryClip.getItemAt(0) != null && primaryClip.getItemAt(0).getText() != null) {
                return primaryClip.getItemAt(0).getText().toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void clearClipBoardBySchemaParam(String str) {
        Uri parse;
        String queryParameter;
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && (queryParameter = parse.getQueryParameter(KEY_HAS_TOKEN)) != null && queryParameter.equals("1")) {
            clearClipBoard();
        }
    }

    public static void clearClipBoard() {
        try {
            ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyToClipBoard(String str) {
        try {
            ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("", str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long getTimesMorning() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static long getNextDayMorning() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static void setNavigationBarBackground(Activity activity, int i) {
        if (activity != null && g.bnQ()) {
            if (Build.VERSION.SDK_INT > 21) {
                setNavigationBarBackground_L(activity, i);
            } else {
                setNavigationBarBackground_K(activity, i);
            }
        }
    }

    public static void setNavigationBarBackgroundForVivoX20(Activity activity, int i) {
        if (activity != null && g.bnS() && isNavigationbarShown(activity.getResources())) {
            if (Build.VERSION.SDK_INT > 21) {
                setNavigationBarBackground_L(activity, i);
            } else {
                setNavigationBarBackground_K(activity, i);
            }
        }
    }

    private static void setNavigationBarBackground_L(Activity activity, int i) {
        activity.getWindow().setNavigationBarColor(i);
    }

    private static void setNavigationBarBackground_K(Activity activity, int i) {
        activity.getWindow().addFlags(134217728);
        View view = new View(activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.a.getNavigationBarHeight(activity));
        layoutParams.gravity = 80;
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(i);
        ((ViewGroup) activity.getWindow().getDecorView()).addView(view);
    }

    public static boolean isNavigationbarShown(Resources resources) {
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        return identifier > 0 && resources.getBoolean(identifier);
    }

    public static RectF fixedDrawableRect(Rect rect, View view) {
        GifView gifView;
        TbImageView tbImageView;
        if (rect == null || (!(view instanceof TbImageView) && !(view instanceof GifView))) {
            return null;
        }
        RectF rectF = new RectF();
        if (view instanceof TbImageView) {
            rectF.right = rectF.left + tbImageView.getImageWidth();
            rectF.bottom = rectF.top + tbImageView.getImageHeight();
            ((TbImageView) view).getImageMatrix().mapRect(rectF);
        } else if (view instanceof GifView) {
            rectF.right = rectF.left + gifView.getImageWidth();
            rectF.bottom = rectF.top + gifView.getImageHeight();
            ((GifView) view).getImageMatrix().mapRect(rectF);
        }
        rectF.left += rect.left;
        rectF.right += rect.left;
        rectF.top += rect.top;
        rectF.bottom += rect.top;
        return rectF;
    }

    public static long getTodayZeroTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static void showSkinChangeAnimation(Activity activity) {
        if (!com.baidu.tbadk.util.l.isFastDoubleClick() && activity != null) {
            final View decorView = activity.getWindow().getDecorView();
            final Bitmap cacheBitmapFromView = getCacheBitmapFromView(decorView);
            if ((decorView instanceof ViewGroup) && cacheBitmapFromView != null) {
                final View view = new View(activity);
                view.setBackgroundDrawable(new BitmapDrawable(activity.getResources(), cacheBitmapFromView));
                ((ViewGroup) decorView).addView(view, new ViewGroup.LayoutParams(-1, -1));
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.core.util.UtilHelper.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        ((ViewGroup) decorView).removeView(view);
                        if (cacheBitmapFromView != null && !cacheBitmapFromView.isRecycled()) {
                            cacheBitmapFromView.recycle();
                        }
                    }
                });
                ofFloat.start();
            }
        }
    }

    public static Bitmap getCacheBitmapFromView(View view) {
        Bitmap bitmap = null;
        com.baidu.tbadk.imageManager.c.byE().freePicCache(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) * com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()) * 2);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache(true);
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache != null) {
            try {
                bitmap = Bitmap.createBitmap(drawingCache);
                view.setDrawingCacheEnabled(false);
                return bitmap;
            } catch (OutOfMemoryError e) {
                System.gc();
                return bitmap;
            }
        }
        return null;
    }

    public static boolean dealOneScheme(Context context, String str) {
        if (context == null || at.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (isIntentAvailable(context, intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return (queryIntentActivities == null || queryIntentActivities.isEmpty()) ? false : true;
    }

    public static boolean isHuaWeiU9508Device() {
        String str = Build.MODEL;
        return !TextUtils.isEmpty(str) && str.contains("Huawei_HUAWEI U9508");
    }

    public static boolean isMiNotchDevice() {
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("MI 8") || str.contains("MI8");
    }

    public static Drawable getSelectorDrawableByAlpha(@DrawableRes int i, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        Drawable drawable = ap.getDrawable(i);
        Drawable drawable2 = ap.getDrawable(i);
        drawable2.mutate();
        drawable2.setAlpha((int) (255.0f * f));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static boolean isOppoDevice() {
        String str = Build.BRAND;
        if (at.isEmpty(str)) {
            return false;
        }
        return str.contains(RomUtils.ROM_OPPO) || str.contains(RomUtils.MANUFACTURER_OPPO) || str.contains("Oppo");
    }

    public static boolean isVivoDevice() {
        String str = Build.BRAND;
        if (at.isEmpty(str)) {
            return false;
        }
        return str.contains(RomUtils.ROM_VIVO) || str.contains(RomUtils.MANUFACTURER_VIVO) || str.contains("Vivo");
    }

    public static int getNavigationBarHeight(Context context) {
        Resources resources;
        int identifier;
        if (!hasNavBar(context) || (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            boolean z = resources.getBoolean(identifier);
            String navBarOverride = getNavBarOverride();
            if ("1".equals(navBarOverride)) {
                return false;
            }
            if ("0".equals(navBarOverride)) {
                return true;
            }
            return z;
        }
        return ViewConfiguration.get(context).hasPermanentMenuKey() ? false : true;
    }

    public static String getNavBarOverride() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable th) {
            return null;
        }
    }

    public static int getDimenPixelSize(int i) {
        return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
    }

    public static TbPageContext getTbPageContext(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    public static void hideStatusBar(Activity activity, View view) {
        if (activity != null && view != null) {
            if (Build.VERSION.SDK_INT < 16) {
                if (activity.getWindow() != null) {
                    activity.getWindow().setFlags(1024, 1024);
                    return;
                } else {
                    view.setSystemUiVisibility(2);
                    return;
                }
            }
            view.setSystemUiVisibility(4);
        }
    }

    public static void showStatusBar(Activity activity, View view) {
        if (activity != null && view != null) {
            if (Build.VERSION.SDK_INT < 16) {
                if (activity.getWindow() != null) {
                    activity.getWindow().clearFlags(1024);
                    return;
                } else {
                    view.setSystemUiVisibility(0);
                    return;
                }
            }
            view.setSystemUiVisibility(0);
        }
    }

    public static boolean isActivityStartFromScheme(Activity activity) {
        return (activity == null || activity.getIntent() == null || at.isEmpty(activity.getIntent().getDataString())) ? false : true;
    }

    public static boolean isUgcThreadType(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }
}
