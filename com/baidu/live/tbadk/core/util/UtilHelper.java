package com.baidu.live.tbadk.core.util;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.app.ActivityManager;
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
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.content.FileProvider;
import android.telephony.TelephonyManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.ImageView;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.live.adp.base.BdActivityStack;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdStringHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.CloseUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.view.VerticalImageSpan;
import com.baidu.live.tbadk.pagestayduration.IPageStayDuration;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.webkit.internal.ETAG;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import org.apache.http.conn.util.InetAddressUtils;
/* loaded from: classes4.dex */
public class UtilHelper {
    private static final String NATIVE_PAY_FROM = "from_type";
    public static final int PROCESS_LIMIT_NONE = 0;
    private static long lastClickTime;
    private static final Pattern pbPattern0 = Pattern.compile("(tieba.baidu.com/p/){1}([\\d]+)");
    private static final String[] sNativeAdPrefixes = {"http://m.baidu.com/baidu.php?url=", "https://m.baidu.com/baidu.php?url="};
    private static final String[] sNativeAdEncoded = {"http%3a%2f%2fm.baidu.com%2fbaidu.php%3furl%3d", "https%3a%2f%2fm.baidu.com%2fbaidu.php%3furl%3d"};

    /* loaded from: classes4.dex */
    public static class NativePage {
        public String id;
        public NativePageType type = NativePageType.NONE;
    }

    /* loaded from: classes4.dex */
    public enum NativePageType {
        NONE,
        FRS,
        PB
    }

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - lastClickTime;
        if (j > 0 && j < 1200) {
            return true;
        }
        lastClickTime = currentTimeMillis;
        return false;
    }

    public static int getBitmapMaxMemory(Context context) {
        return CompatibleUtile.getInstance().getBitmapMaxMemory(context);
    }

    public static void showToast(Context context, String str) {
        CustomToast2.showToast(context, str);
    }

    public static void showToast(Context context, int i) {
        CustomToast2.showToast(context, i);
    }

    public static int getNetworkOperator() {
        String simOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService("phone")).getSimOperator();
        if (simOperator == null || simOperator.length() < 4 || BdStringHelper.isEmptyStringAfterTrim(simOperator)) {
            return 0;
        }
        String substring = simOperator.substring(0, 3);
        if (substring == null || !substring.equals(BdNetTypeUtil.NATION_CODE)) {
            return 0;
        }
        switch (JavaTypesHelper.toInt(simOperator.substring(3), 0)) {
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
                    stringBuffer.append(String.valueOf(JavaTypesHelper.toInt(split[i3], 0, 16)));
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
        new BdAlertDialog(activity).setTitle(a.h.sdk_inform).setCancelable(false).setMessageId(a.h.sdk_alert_quit_confirm).setPositiveButton(a.h.sdk_alert_yes_button, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.tbadk.core.util.UtilHelper.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
                TbadkCoreApplication.getInst().notifyAppEnterBackground();
                activity.finish();
            }
        }).setNegativeButton(a.h.sdk_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.tbadk.core.util.UtilHelper.1
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
            }
        }).create(IScrollableHelper.getBbPageContext(activity)).show();
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

    public static String getCurrentVerson(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isSystemLocationProviderEnabled(Context context) {
        boolean z;
        if (PermissionUtil.checkLocationForGoogle(context)) {
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
                    sb.insert(0, ",");
                    i = 0;
                }
            }
        }
        return sb.toString();
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
        if (StringHelper.isEmpty(str) || str.indexOf("cuid=") <= -1) {
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
            }
            sb.append("&timestamp=");
            sb.append(Long.toString(System.currentTimeMillis()));
            return sb.toString();
        }
        return str;
    }

    public static String appendVersionCode(String str) {
        return (StringHelper.isEmpty(str) || str.indexOf("_client_version=") <= -1) ? str + "&_client_version=" + TbConfig.getVersion() : str;
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
            context.startActivity(Intent.createChooser(intent, TbadkCoreApplication.getInst().getApp().getResources().getString(a.h.sdk_share_to)));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [844=4] */
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
                        CloseUtil.close(randomAccessFile);
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    CloseUtil.close(randomAccessFile);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                CloseUtil.close(randomAccessFile);
                throw th;
            }
            if (randomAccessFile.read(bArr) < 1) {
                CloseUtil.close(randomAccessFile);
                return false;
            }
            String str = new String(bArr);
            int indexOf = str.indexOf(0);
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            if (str.toLowerCase().contains("arm")) {
                CloseUtil.close(randomAccessFile);
                return true;
            }
            CloseUtil.close(randomAccessFile);
            return false;
        }
        return true;
    }

    public static boolean is64Bit() {
        boolean z;
        IOException e;
        BufferedReader bufferedReader;
        if (Build.VERSION.SDK_INT >= 21) {
            return Build.SUPPORTED_64_BIT_ABIS.length > 0;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            z = bufferedReader.readLine().contains("aarch64");
        } catch (IOException e2) {
            z = false;
            e = e2;
        }
        try {
            bufferedReader.close();
            return z;
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            return z;
        }
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
            TiebaInitialize.eventStat(context, "search_in_baidu", "searchclick", 1, new Object[0]);
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
                BdActivityStack.getInst().releaseAllAcitivities();
            }
            context.startActivity(intent);
        } catch (Exception e) {
            startBaiduWebView(context, str);
        }
    }

    private static void startBaiduWebView(Context context, String str) {
        if (str != null && str.length() > 0) {
            BrowserHelper.startInternalWebActivity(context, "http://m.baidu.com/s?from=1001157a&word=" + str);
        } else {
            BrowserHelper.startInternalWebActivity(context, "http://m.baidu.com/?from=1001157a");
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

    public static void setBitmapByTag(View view, String str, BdImage bdImage) {
        if (view != null && str != null) {
            if (view.getTag() != null && view.getTag().equals(str)) {
                if (bdImage == null) {
                    view.invalidate();
                } else if (view instanceof ImageView) {
                    bdImage.drawImageTo((ImageView) view);
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt != null) {
                        setBitmapByTag(childAt, str, bdImage);
                    }
                }
            }
        }
    }

    public static String getDeviceId() {
        TelephonyManager telephonyManager;
        try {
            if (PermissionUtil.checkReadPhoneState(TbadkCoreApplication.getInst()) && (telephonyManager = (TelephonyManager) TbadkCoreApplication.getInst().getSystemService("phone")) != null) {
                return telephonyManager.getDeviceId();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getTiebaApkMd5() {
        String str = null;
        try {
            String versionName = TbadkCoreApplication.getInst().getVersionName();
            String string = SharedPrefHelper.getInstance().getString(SharedPrefConfig.VERSION_NAME, "");
            if (!TextUtils.isEmpty(versionName)) {
                if (versionName.equals(string)) {
                    str = SharedPrefHelper.getInstance().getString(SharedPrefConfig.APK_MD5, "");
                } else {
                    SharedPrefHelper.getInstance().putString(SharedPrefConfig.VERSION_NAME, versionName);
                    String aPKMd5 = TbMd5.getAPKMd5(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(TbadkCoreApplication.getInst().getPackageName(), 0));
                    SharedPrefHelper.getInstance().putString(SharedPrefConfig.APK_MD5, aPKMd5);
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
        if (str != null && str.contains("Flyme") && (numFromStr = BdUtilHelper.getNumFromStr(str)) != null && numFromStr.length() >= 3) {
            int i = JavaTypesHelper.toInt(BdUtilHelper.getNumFromStr(numFromStr.substring(0, 1)), 0);
            int i2 = JavaTypesHelper.toInt(BdUtilHelper.getNumFromStr(numFromStr.substring(1, 2)), 0);
            if (i > 5) {
                return true;
            }
            if (i == 5 && i2 >= 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean canUseStyleImmersiveSticky() {
        if (Build.VERSION.SDK_INT >= 19 && TbadkCoreApplication.getInst() != null && TbadkCoreApplication.getInst().isMeiZuCanUseImmersive()) {
            return TbadkCoreApplication.getInst().isImmersiveStickyCanUse();
        }
        return false;
    }

    public static boolean useNavigationBarStyleImmersiveSticky(Activity activity, boolean z) {
        if (Build.VERSION.SDK_INT < 19 || activity == null) {
            return false;
        }
        if (SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SWITCH_IMMERSIVE_STICKY_STATUS, true) && TbadkCoreApplication.getInst().isMeiZuCanUseImmersive()) {
            for (AccessibilityServiceInfo accessibilityServiceInfo : ((AccessibilityManager) activity.getSystemService("accessibility")).getEnabledAccessibilityServiceList(1)) {
                if (!StringUtils.isNull(accessibilityServiceInfo.getSettingsActivityName()) && accessibilityServiceInfo.getSettingsActivityName().contains("talkback")) {
                    SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SWITCH_IMMERSIVE_STICKY_STATUS, false);
                    TbadkCoreApplication.getInst().resetIsImmersiveStickyPrefHasRead(false);
                    return false;
                }
            }
            TbadkCoreApplication.getInst().getSkinType();
            if (Build.VERSION.SDK_INT >= 23) {
                useNavigationBarStyleImmersiveSticky_M(activity, z);
                StatusBarUtil.from(activity).setTransparentStatusbar(true).setLightStatusBar(true).process();
                return true;
            } else if (!StatusBarUtil.from(activity).setTransparentStatusbar(true).setLightStatusBar(true).process()) {
                SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.SWITCH_IMMERSIVE_STICKY_STATUS, false);
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
        return false;
    }

    public static boolean useNavigationBarStyleImmersiveSticky(Activity activity) {
        boolean useNavigationBarStyleImmersiveSticky = useNavigationBarStyleImmersiveSticky(activity, false);
        changeStatusBarIconAndTextColor(TbadkCoreApplication.getInst().getSkinType() == 1, activity);
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
                            window.getDecorView().setSystemUiVisibility(field5.getInt(null) | i3);
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
            SkinManager.setBackgroundColor(view, a.c.sdk_common_color_10274);
        }
    }

    public static void changeStatusBarIconAndTextColor(boolean z, Activity activity) {
        int i;
        if (activity != null && activity.getWindow() != null) {
            if (Build.DISPLAY.toLowerCase().contains("flyme")) {
                changeFlyMeStatusBarColor(activity.getWindow());
            }
            if (Build.VERSION.SDK_INT >= 23) {
                View decorView = activity.getWindow().getDecorView();
                if (decorView != null) {
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

    private static void changeFlyMeStatusBarColor(Window window) {
        if (window != null) {
            try {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                Method declaredMethod = Window.class.getDeclaredMethod("setStatusBarColor", Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(window, Integer.valueOf(SkinManager.getColor(a.c.sdk_common_color_10274)));
            } catch (IllegalAccessException e) {
            } catch (NoSuchMethodException e2) {
            } catch (InvocationTargetException e3) {
            }
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

    public static String formalDecimalForTwo(double d) {
        return new DecimalFormat("0.00").format(d);
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
                CloseUtil.close((SQLiteDatabase) null);
            }
        }
        if (openOrCreateDatabase != null) {
            CloseUtil.close(openOrCreateDatabase);
            return false;
        }
        CloseUtil.close(openOrCreateDatabase);
        return true;
    }

    public static void install_apk(Context context, String str) {
        File GetFile;
        if (str != null && str.length() > 0 && (GetFile = FileHelper.GetFile(str)) != null) {
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
            BdUtilHelper.showToast(context, a.h.sdk_game_start_fail);
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

    public static SpannableStringBuilder getSpannableIconByVertical(Context context, String str, int i, boolean z) {
        if (BdStringHelper.isEmpty(str) || context == null || i == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Bitmap bitmap = SkinManager.getBitmap(i);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        if (bitmap != null) {
            bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        VerticalImageSpan verticalImageSpan = new VerticalImageSpan(bitmapDrawable);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) " ");
        if (z) {
            spannableStringBuilder.setSpan(verticalImageSpan, length, spannableStringBuilder.length(), 17);
            spannableStringBuilder.append((CharSequence) str);
            return spannableStringBuilder;
        }
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(verticalImageSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1742=4] */
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
            return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(JavaTypesHelper.toInt(Class.forName("com.android.internal.R$dimen").getField("status_bar_height").get(null).toString(), 0));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getLightStatusBarHeight() {
        if (canUseStyleImmersiveSticky()) {
            try {
                return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(JavaTypesHelper.toInt(Class.forName("com.android.internal.R$dimen").getField("status_bar_height").get(null).toString(), 0));
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
        Activity currentActivity;
        ComponentName componentName;
        if (BdActivityStack.getInst() == null || (currentActivity = BdActivityStack.getInst().currentActivity()) == null || (componentName = currentActivity.getComponentName()) == null) {
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
        return ListUtils.getCount(list) > 0;
    }

    public static boolean isDecimal(String str) {
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

    public static int getRealScreenOrientation(Context context) {
        int i = 2;
        if (context == null) {
            return 1;
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(context);
        int i2 = context.getResources().getConfiguration().orientation;
        if (i2 == 2 || screenDimensions[0] <= screenDimensions[1]) {
            i = i2;
        }
        if (i != 0) {
            return i;
        }
        return 1;
    }

    public static long getDayBetweenTime(long j, long j2) {
        return ((j2 - j) / 1000) / 86400;
    }

    public static String getForumNameWithBar(String str) {
        return getForumNameWithGodBar(str, -1, false);
    }

    public static String getForumNameWithBar(String str, int i, boolean z) {
        if (i <= -1) {
            if (BdStringHelper.byteLength(str) > 14) {
                str = StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
            }
        } else {
            str = getFixedBarText(str, i, z);
        }
        return TbadkCoreApplication.getInst().getString(a.h.sdk_chosen_pb_original_bar, new Object[]{str});
    }

    public static String getForumNameWithGodBar(String str, int i, boolean z) {
        if (i <= -1) {
            if (BdStringHelper.byteLength(str) > 14) {
                str = StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
            }
        } else {
            str = getFixedBarText(str, i, z);
        }
        return TbadkCoreApplication.getInst().getString(a.h.sdk_chosen_pb_original_god_bar, new Object[]{str});
    }

    public static String getFromPageKey(TbPageContext tbPageContext) {
        if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof IPageStayDuration)) {
            return null;
        }
        IPageStayDuration iPageStayDuration = (IPageStayDuration) tbPageContext.getPageActivity();
        if (iPageStayDuration.getCurrentPageSourceKeyList() == null) {
            return null;
        }
        return (String) ListUtils.getItem(iPageStayDuration.getCurrentPageSourceKeyList(), iPageStayDuration.getCurrentPageSourceKeyList().size() - 1);
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
}
