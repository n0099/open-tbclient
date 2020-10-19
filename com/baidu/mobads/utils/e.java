package com.baidu.mobads.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.webkit.internal.ETAG;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;
@SuppressLint({"NewApi"})
/* loaded from: classes7.dex */
public class e implements IXAdCommonUtils {

    /* renamed from: a  reason: collision with root package name */
    private static String f2435a;
    private static String b;
    private static String c;
    private static String d;
    private final String e = "_cpr";
    private final AtomicLong f = new AtomicLong(1);
    private Method g = null;
    private String h = null;
    private HashMap<String, Object> i = new HashMap<>();

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public int getApkDownloadStatus(Context context, String str, String str2) {
        XAdSDKFoundationFacade.getInstance().getIoUtils();
        if (str == null || "".equals(str)) {
            return -1;
        }
        try {
            JSONObject optJSONObject = new JSONObject(context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_ACTIVATION, 0).getString(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_KEY, "{}")).optJSONObject(str);
            if (optJSONObject != null) {
                if (optJSONObject.optBoolean("a", false)) {
                    return 100;
                }
            }
        } catch (Exception e) {
            if (e != null) {
                Log.e("XAdCommonUtils", e.getMessage());
            }
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0);
            JSONObject jSONObject = new JSONObject(sharedPreferences.getString(str + "#$#" + com.baidu.mobads.command.a.b(), "{}"));
            if (jSONObject == null) {
                return -1;
            }
            int optInt = jSONObject.optInt(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, -1);
            String optString = jSONObject.optString("name", null);
            if (optString != null) {
                File file = new File(l.a(context) + optString);
                if (optInt == 3) {
                    boolean z = false;
                    if (!file.exists() || file.length() == 0) {
                        z = true;
                    } else {
                        long optLong = jSONObject.optLong("contentLength", -1L);
                        if (optLong != -1 && Math.abs(optLong - file.length()) >= 2) {
                            z = true;
                        }
                    }
                    if (z) {
                        jSONObject.put(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, 5);
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(str, jSONObject.toString());
                        if (Build.VERSION.SDK_INT >= 9) {
                            edit.apply();
                            return 5;
                        }
                        edit.commit();
                        return 5;
                    }
                    return optInt;
                }
                return optInt;
            }
            return optInt;
        } catch (Exception e2) {
            if (e2 == null) {
                return -1;
            }
            Log.e("XAdCommonUtils", e2.getMessage());
            return -1;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getStatusStr(Context context, String str, String str2) {
        n packageUtils = XAdSDKFoundationFacade.getInstance().getPackageUtils();
        try {
            int apkDownloadStatus = getApkDownloadStatus(context, str, str2);
            boolean isInstalled = packageUtils.isInstalled(context, str);
            switch (apkDownloadStatus) {
                case 0:
                case 1:
                    return isInstalled ? "INSTALLED_BY_OTHER" : "DOWNLOADING";
                case 2:
                case 4:
                    return isInstalled ? "INSTALLED_BY_OTHER" : "DOWNLOAD_FAILED";
                case 3:
                    return isInstalled ? "INSTALLED" : "DOWNLOADED";
                case 5:
                    return isInstalled ? "DONE" : "NONE";
                case 100:
                    return "DONE";
                default:
                    return isInstalled ? "INSTALLED_BY_OTHER" : "NONE";
            }
        } catch (Exception e) {
            return "NONE";
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getMD5(String str) {
        byte[] bytes = str.getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[32];
            int i = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                byte b2 = digest[i2];
                int i3 = i + 1;
                cArr2[i] = cArr[(b2 >>> 4) & 15];
                i = i3 + 1;
                cArr2[i3] = cArr[b2 & 15];
            }
            return new String(cArr2);
        } catch (NoSuchAlgorithmException e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e("AdUtil.getMD5", "", e);
            return null;
        }
    }

    private String c(String str) {
        return getMD5(str);
    }

    private String a(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            String file = context.getFilesDir().toString();
            sb.append(file.toString().substring(0, file.toString().lastIndexOf(File.separator)));
        } catch (Exception e) {
        }
        sb.append(File.separator);
        sb.append("bddownload");
        return sb.toString();
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getFileLocalFullPath(Context context, String str) {
        try {
            return a(context) + File.separator + c(str);
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public boolean isStringAvailable(String str) {
        return str != null && str.length() > 0;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public void makeCall(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                Intent intent = new Intent("android.intent.action.CALL", Uri.parse(("tel:" + str).toString()));
                intent.addFlags(268435456);
                a(context, intent);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public void sendSMS(Context context, String str, String str2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra("address", str);
            intent.putExtra("sms_body", str2);
            intent.setType("vnd.android-dir/mms-sms");
            intent.addFlags(268435456);
            a(context, intent);
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    @TargetApi(4)
    private void a(Context context, Intent intent) {
        try {
            if (Build.VERSION.SDK_INT < 19) {
                context.startActivity(intent);
            } else {
                new Handler(context.getMainLooper()).post(new f(this, context, intent));
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getDebugToken(Context context) {
        try {
            if (b == null) {
                b = d(context, IXAdCommonUtils.DEBUG_TOKEN);
            }
            return b;
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getAppId(Context context) {
        try {
            if (f2435a == null) {
                f2435a = d(context, IXAdCommonUtils.APPSID);
            }
            return f2435a;
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getAppSec(Context context) {
        if (c == null || c.length() == 0 || c.startsWith("null")) {
            setAppSec(getAppId(context));
        }
        return c;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public void setAppSec(String str) {
        c = str + "_cpr";
    }

    private String d(Context context, String str) {
        String str2 = BdStatsConstant.StatsType.ERROR;
        try {
            str2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str) + "";
            if (str2.trim().equals("")) {
                throw new Exception();
            }
        } catch (Exception e) {
            String.format("Could not read %s meta-data from AndroidManifest.xml", str);
        }
        return str2;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                while (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public long generateUniqueId() {
        long j;
        long j2;
        do {
            j = this.f.get();
            j2 = j + 1;
            if (j2 > 9223372036854775806L) {
                j2 = 1;
            }
        } while (!this.f.compareAndSet(j, j2));
        return j;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public boolean bitMaskContainsFlag(int i, int i2) {
        return (i & i2) != 0;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    @TargetApi(17)
    public Rect getScreenRect(Context context) {
        Rect rect;
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        try {
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                rect = new Rect(0, 0, displayMetrics.heightPixels, displayMetrics.widthPixels);
            } else {
                rect = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            return rect;
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public Rect getWindowRect(Context context) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    @TargetApi(4)
    public float getScreenDensity(Context context) {
        return getDisplayMetrics(context).density;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    @TargetApi(17)
    public DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public int getLogicalPixel(Context context, int i) {
        try {
            return (int) (i / getScreenDensity(context));
        } catch (Exception e) {
            return i;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public int getPixel(Context context, int i) {
        try {
            return (int) (i * getScreenDensity(context));
        } catch (Exception e) {
            return i;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getTextEncoder(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        } catch (NullPointerException e2) {
            return str;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getSubscriberId(Context context) {
        if (this.h == null) {
            try {
                if (hasPermission(context, "android.permission.READ_PHONE_STATE")) {
                    this.h = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                }
            } catch (Exception e) {
            }
        }
        return b(this.h);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getAppPackage(Context context) {
        return context.getPackageName();
    }

    public static boolean a(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e) {
            m.a().e(e);
            return false;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public boolean hasPermission(Context context, String str) {
        return a(context, str);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String encodeURIComponent(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", Constants.WAVE_SEPARATOR);
        } catch (Exception e) {
            return str;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String decodeURIComponent(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Exception e) {
            return str;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String vdUrl(String str, int i) {
        XAdSDKFoundationFacade.getInstance().getURIUitls();
        JSONObject jSONObject = new JSONObject();
        for (String str2 : str.substring(str.indexOf("?") + 1).split(ETAG.ITEM_SEPARATOR)) {
            try {
                String[] split = str2.split(ETAG.EQUAL);
                if (split.length > 1 && !split[0].equals("type")) {
                    jSONObject.putOpt(split[0], split[1]);
                }
            } catch (Exception e) {
            }
        }
        StringBuilder sb = new StringBuilder("type=" + i + ETAG.ITEM_SEPARATOR);
        TreeMap treeMap = new TreeMap();
        StringBuilder sb2 = new StringBuilder();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                try {
                    String next = keys.next();
                    if (next != null && !next.equals("")) {
                        treeMap.put(next, jSONObject.optString(next));
                    }
                } catch (Exception e2) {
                }
            }
        } catch (Exception e3) {
        }
        treeMap.put("ts", System.currentTimeMillis() + "");
        for (String str3 : treeMap.keySet()) {
            String str4 = (String) treeMap.get(str3);
            if (str3 != null && str4 != null) {
                if (!str3.equals("targetscheme")) {
                    str3 = encodeURIComponent(str3);
                    str4 = encodeURIComponent(str4);
                }
                sb.append(str3 + ETAG.EQUAL + str4 + ETAG.ITEM_SEPARATOR);
                sb2.append(str4 + Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        sb2.append("mobads,");
        sb.append("vd=" + getMD5(sb2.toString()) + ETAG.ITEM_SEPARATOR);
        return "https://mobads-logs.baidu.com/dz.zb?" + sb.toString();
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getChannelId() {
        return d;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public void setChannelId(String str) {
        d = str;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getBaiduMapsInfo(Context context) {
        Object a2 = a("mapinfo");
        if (a2 != null) {
            return String.valueOf(a2);
        }
        String str = "";
        try {
            str = new com.baidu.mobads.h.a(context).a();
        } catch (Exception e) {
            m.a().e(e);
        }
        a("mapinfo", str);
        return str;
    }

    public void a(String str, Object obj) {
        if (!a()) {
            this.i.put(str + "_E", Long.valueOf(System.currentTimeMillis() + 5000));
            this.i.put(str + "_V", obj);
        }
    }

    public Object a(String str) {
        if (a()) {
            return null;
        }
        try {
            Object obj = this.i.get(str + "_E");
            if (obj != null) {
                if (System.currentTimeMillis() < ((Long) obj).longValue()) {
                    return this.i.get(str + "_V");
                }
            }
        } catch (Exception e) {
            m.a().e(e);
        }
        return null;
    }

    public boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public void setAppId(String str) {
        f2435a = str;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x010a -> B:13:0x004f). Please submit an issue!!! */
    @TargetApi(3)
    private static String b(Context context) {
        PackageManager packageManager;
        int i;
        String[] supportedBrowsers = XAdSDKFoundationFacade.getInstance().getAdConstants().getSupportedBrowsers();
        try {
            packageManager = context.getPackageManager();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            packageManager.getPreferredActivities(arrayList, arrayList2, null);
            for (ComponentName componentName : arrayList2) {
                for (String str : supportedBrowsers) {
                    if (str.equals(componentName.getPackageName())) {
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d(str, "规则1 hit!");
                        return str;
                    }
                }
            }
            try {
                i = -1;
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
                    try {
                        if (packageManager.getLaunchIntentForPackage(runningAppProcessInfo.processName) != null && packageManager.getApplicationInfo(runningAppProcessInfo.processName, 128) != null) {
                            for (int i2 = 0; i2 < supportedBrowsers.length; i2++) {
                                if (runningAppProcessInfo.processName.equals(supportedBrowsers[i2])) {
                                    if (i == -1) {
                                        i = i2;
                                    } else if (i2 < i) {
                                        i = i2;
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                i = -1;
            }
        } catch (Exception e3) {
            com.baidu.mobads.c.a.a().a("open browser outside failed: " + e3.toString());
        }
        if (i != -1) {
            return supportedBrowsers[i];
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(DownloadConstants.REFER));
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 64);
        if (queryIntentActivities != null) {
            for (String str2 : supportedBrowsers) {
                for (int i3 = 0; i3 < queryIntentActivities.size(); i3++) {
                    if (str2.equals(queryIntentActivities.get(i3).activityInfo.packageName)) {
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d(str2, "规则2 hit!");
                        return str2;
                    }
                }
            }
        }
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            return queryIntentActivities.get(0).activityInfo.packageName;
        }
        return "";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    @TargetApi(3)
    public void browserOutside(Context context, String str) {
        Intent intent;
        if (str.startsWith("wtai://wp/mc;")) {
            str = "tel:" + str.substring("wtai://wp/mc;".length());
        }
        try {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (XAdSDKFoundationFacade.getInstance().getURIUitls().isHttpProtocol(str).booleanValue()) {
                String b2 = b(context);
                XAdSDKFoundationFacade.getInstance().getAdLogger().d("Utils", "AdUtil.browserOutside pkgOfBrowser=" + b2);
                if (b2.equals("")) {
                    intent = intent2;
                } else {
                    intent = context.getPackageManager().getLaunchIntentForPackage(b2);
                    intent.setData(Uri.parse(str));
                    intent.setAction("android.intent.action.VIEW");
                }
                intent2 = intent;
            } else if (((t) XAdSDKFoundationFacade.getInstance().getURIUitls()).a(str).booleanValue()) {
                intent2.setType("vnd.android-dir/mms-sms");
                String substring = str.substring(4, str.indexOf(63) > 0 ? str.indexOf(63) : str.length());
                intent2.putExtra("address", substring);
                int length = "body=".length() + str.indexOf("body=");
                String str2 = "";
                if (length > "body=".length()) {
                    int indexOf = str.indexOf(38, length);
                    if (indexOf <= 0) {
                        indexOf = str.length();
                    }
                    str2 = str.substring(length, indexOf);
                    intent2.putExtra("sms_body", Uri.decode(str2));
                }
                XAdSDKFoundationFacade.getInstance().getAdLogger().d(substring, str2);
            }
            if (context.getPackageManager().resolveActivity(intent2, 65536) != null) {
                context.startActivity(intent2);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdCommonUtils.browserOutside 1", str, e);
            try {
                Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent3.addFlags(268435456);
                context.startActivity(intent3);
            } catch (Exception e2) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdCommonUtils.browserOutside 2", str, e2);
            }
        }
    }

    public String b() {
        return "android_8.8146_4.0.0";
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a9, code lost:
        if (com.baidu.mobads.utils.n.b(r6) != false) goto L33;
     */
    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean hasSupportedApps(Context context, int i) {
        Intent intent;
        boolean z = true;
        try {
            IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
            switch (i) {
                case 0:
                    intent = new Intent("android.intent.action.SENDTO");
                    intent.setData(Uri.parse("mailto:baidumobadstest@baidu.com"));
                    break;
                case 1:
                    intent = new Intent("android.intent.action.SENDTO");
                    intent.setData(Uri.parse("sms:12345678"));
                    break;
                case 2:
                    return XAdSDKFoundationFacade.getInstance().getCommonUtils().hasPermission(context, "android.permission.ACCESS_WIFI_STATE") && XAdSDKFoundationFacade.getInstance().getCommonUtils().hasPermission(context, "android.permission.CHANGE_WIFI_STATE");
                case 3:
                    if (systemUtils.canSupportSdcardStroage(context)) {
                        XAdSDKFoundationFacade.getInstance().getPackageUtils();
                        break;
                    }
                    z = false;
                    return z;
                case 4:
                    intent = new Intent("android.intent.action.EDIT");
                    intent.setType("vnd.android.cursor.item/event");
                    break;
                default:
                    return false;
            }
            new ArrayList();
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
            return (queryIntentActivities == null || queryIntentActivities.size() <= 0 || queryIntentActivities.get(0).activityInfo.packageName.equals("com.android.fallback")) ? false : true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public JSONArray list2Json(List<String[]> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < list.get(i).length; i2++) {
                    jSONArray2.put(list.get(i)[i2]);
                }
                jSONArray.put(jSONArray2);
            } catch (Exception e) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            }
        }
        return jSONArray;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String base64Encode(String str) {
        return XAdSDKFoundationFacade.getInstance().getBase64().encode(str);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public JSONArray array2Json(double[] dArr) {
        JSONArray jSONArray;
        Exception e;
        if (dArr == null) {
            return null;
        }
        try {
            jSONArray = new JSONArray();
            for (double d2 : dArr) {
                try {
                    jSONArray.put(d2);
                } catch (Exception e2) {
                    e = e2;
                    XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
                    return jSONArray;
                }
            }
            return jSONArray;
        } catch (Exception e3) {
            jSONArray = null;
            e = e3;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getLocationInfo(Context context) {
        return getBaiduMapsInfo(context);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getApkFileLocalPath(Context context, String str) {
        try {
            String string = context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0).getString(str + "#$#" + com.baidu.mobads.command.a.b(), "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("folder");
                String optString2 = jSONObject.optString("filename");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    return optString + optString2;
                }
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
        return "";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public void sendDownloadAdLog(Context context, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2) {
        try {
            IXAdURIUitls uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
            IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
            IBase64 base64 = XAdSDKFoundationFacade.getInstance().getBase64();
            StringBuilder sb = new StringBuilder();
            sb.append("msg=" + str);
            sb.append("&prod=" + str2);
            sb.append("&pk=" + str3);
            sb.append("&appid=" + str4);
            sb.append("&apid=" + str5);
            sb.append("&brand=" + str6);
            sb.append("&tp=" + str7);
            sb.append("&osv=" + str8);
            sb.append("&bdr=" + i2);
            sb.append("&sn=" + systemUtils.getEncodedSN(context));
            sb.append("&mac=" + base64.encode(systemUtils.getMacAddress(context)));
            sb.append("&cuid=" + systemUtils.getCUID(context));
            sb.append("&pack=" + context.getPackageName());
            sb.append("&v=" + ("android_" + com.baidu.mobads.a.a.c + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + "4.1.30"));
            com.baidu.mobads.openad.d.c cVar = new com.baidu.mobads.openad.d.c(uRIUitls.addParameters(vdUrl(sb.toString(), i), null), "");
            cVar.e = 1;
            new com.baidu.mobads.openad.d.a().a(cVar);
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public void installApp(Context context, String str, File file, boolean z) {
        try {
            XAdSDKFoundationFacade.getInstance().getPackageUtils().b(context, file);
            if (z && str != null && str != null && !str.equals("")) {
                com.baidu.mobads.command.a aVar = new com.baidu.mobads.command.a(str, "");
                aVar.l = true;
                com.baidu.mobads.b.a aVar2 = new com.baidu.mobads.b.a(aVar);
                IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                intentFilter.addDataScheme("package");
                context.registerReceiver(aVar2, intentFilter);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public boolean isOldPermissionModel() {
        return Build.VERSION.SDK_INT < 23;
    }

    public static boolean b(Context context, String str) {
        return Build.VERSION.SDK_INT >= 23 ? c(context, str) : a(context, str);
    }

    public static boolean c(Context context, String str) {
        try {
            return ((Integer) Context.class.getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() == 0;
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            return true;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public boolean checkSelfPermission(Context context, String str) {
        return c(context, str);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String createRequestId(Context context, String str) {
        return getMD5(XAdSDKFoundationFacade.getInstance().getSystemUtils().getIMEI(context) + getAppId(context) + str + System.currentTimeMillis());
    }

    public String b(String str) {
        return str == null ? "" : str;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    runnable.run();
                } else {
                    new Handler(Looper.getMainLooper()).post(new g(this, runnable));
                }
            } catch (Exception e) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            }
        }
    }

    public static Class<?> a(Object obj) {
        try {
            return Class.forName(obj.getClass().getName());
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            return null;
        }
    }

    public static Method a(Object obj, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = a(obj).getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            return null;
        }
    }

    public Object a(Object obj, String str, Object... objArr) {
        try {
            Class[] clsArr = new Class[objArr.length];
            for (int i = 0; i < clsArr.length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
            return a(obj, str, (Class<?>[]) clsArr).invoke(obj, objArr);
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            return null;
        }
    }

    public static Object a(Class<?> cls, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            if (a(cls, str, clsArr)) {
                return cls.getMethod(str, clsArr).invoke(null, objArr);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void a(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
            } catch (Exception e) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            }
        }
    }

    public String a(List<String> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size() - 1) {
                sb.append(list.get(i2));
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                i = i2 + 1;
            } else {
                sb.append(list.get(list.size() - 1));
                return sb.toString();
            }
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public void sendDownloadAdLog(Context context, String str, int i, String str2) {
    }
}
