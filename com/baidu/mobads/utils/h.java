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
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.down.utils.Utils;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.searchbox.bddownload.core.breakpoint.sqllite.BreakpointSQLiteKey;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
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
/* loaded from: classes2.dex */
public class h implements IXAdCommonUtils {

    /* renamed from: a  reason: collision with root package name */
    public static String f8530a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f8531b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f8532c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f8533d = null;

    /* renamed from: h  reason: collision with root package name */
    public static String f8534h = "";

    /* renamed from: e  reason: collision with root package name */
    public final String f8535e = "_cpr";

    /* renamed from: f  reason: collision with root package name */
    public final AtomicLong f8536f = new AtomicLong(1);

    /* renamed from: g  reason: collision with root package name */
    public Method f8537g = null;
    public HashMap<String, Object> i = new HashMap<>();

    private String a(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            String file = context.getFilesDir().toString();
            sb.append(file.toString().substring(0, file.toString().lastIndexOf(File.separator)));
        } catch (Exception unused) {
        }
        sb.append(File.separator);
        sb.append("bddownload");
        return sb.toString();
    }

    @TargetApi(3)
    public static String b(Context context) {
        int i;
        String[] supportedBrowsers = XAdSDKFoundationFacade.getInstance().getAdConstants().getSupportedBrowsers();
        try {
            PackageManager packageManager = context.getPackageManager();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            packageManager.getPreferredActivities(arrayList, arrayList2, null);
            Iterator<ComponentName> it = arrayList2.iterator();
            while (true) {
                if (it.hasNext()) {
                    ComponentName next = it.next();
                    for (String str : supportedBrowsers) {
                        if (str.equals(next.getPackageName())) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().d(str, "规则1 hit!");
                            return str;
                        }
                    }
                } else {
                    try {
                        i = -1;
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                            try {
                                if (packageManager.getLaunchIntentForPackage(runningAppProcessInfo.processName) != null && packageManager.getApplicationInfo(runningAppProcessInfo.processName, 128) != null) {
                                    for (int i2 = 0; i2 < supportedBrowsers.length; i2++) {
                                        if (runningAppProcessInfo.processName.equals(supportedBrowsers[i2]) && (i == -1 || i2 < i)) {
                                            i = i2;
                                        }
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        i = -1;
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
                    return (queryIntentActivities == null || queryIntentActivities.size() <= 0) ? "" : queryIntentActivities.get(0).activityInfo.packageName;
                }
            }
        } catch (Exception unused3) {
            return "";
        }
    }

    private String d(String str) {
        return getMD5(str);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public JSONArray array2Json(double[] dArr) {
        JSONArray jSONArray = null;
        if (dArr == null) {
            return null;
        }
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (double d2 : dArr) {
                try {
                    jSONArray2.put(d2);
                } catch (Exception e2) {
                    e = e2;
                    jSONArray = jSONArray2;
                    XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
                    return jSONArray;
                }
            }
            return jSONArray2;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public String b() {
        return "android_8.8448_4.0.0";
    }

    public String b(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String base64Encode(String str) {
        return XAdSDKFoundationFacade.getInstance().getBase64().encode(str);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public boolean bitMaskContainsFlag(int i, int i2) {
        return (i & i2) != 0;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    @TargetApi(3)
    public void browserOutside(Context context, String str) {
        if (str.startsWith("wtai://wp/mc;")) {
            str = "tel:" + str.substring(13);
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            String str2 = "";
            if (XAdSDKFoundationFacade.getInstance().getURIUitls().isHttpProtocol(str).booleanValue()) {
                String b2 = b(context);
                XAdSDKFoundationFacade.getInstance().getAdLogger().d(Utils.TAG, "AdUtil.browserOutside pkgOfBrowser=" + b2);
                if (!b2.equals("")) {
                    intent = context.getPackageManager().getLaunchIntentForPackage(b2);
                    intent.setData(Uri.parse(str));
                    intent.setAction("android.intent.action.VIEW");
                }
            } else if (XAdSDKFoundationFacade.getInstance().getURIUitls().isMessageProtocol(str).booleanValue()) {
                intent.setType("vnd.android-dir/mms-sms");
                String substring = str.substring(4, str.indexOf(63) > 0 ? str.indexOf(63) : str.length());
                intent.putExtra("address", substring);
                int indexOf = str.indexOf("body=") + 5;
                if (indexOf > 5) {
                    int indexOf2 = str.indexOf(38, indexOf);
                    if (indexOf2 <= 0) {
                        indexOf2 = str.length();
                    }
                    str2 = str.substring(indexOf, indexOf2);
                    intent.putExtra("sms_body", Uri.decode(str2));
                }
                XAdSDKFoundationFacade.getInstance().getAdLogger().d(substring, str2);
            }
            if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                context.startActivity(intent);
            }
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdCommonUtils.browserOutside 1", str, e2);
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent2.addFlags(268435456);
                context.startActivity(intent2);
            } catch (Exception e3) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdCommonUtils.browserOutside 2", str, e3);
            }
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

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String decodeURIComponent(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String encodeURIComponent(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", SmallTailInfo.EMOTION_SUFFIX).replaceAll("\\%7E", Constants.WAVE_SEPARATOR);
        } catch (Exception unused) {
            return str;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public long generateUniqueId() {
        long j;
        long j2;
        do {
            j = this.f8536f.get();
            j2 = j + 1;
        } while (!this.f8536f.compareAndSet(j, j2 <= 9223372036854775806L ? j2 : 1L));
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00be, code lost:
        if (java.lang.Math.abs(r9 - r2.length()) >= 2) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c3  */
    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getApkDownloadStatus(Context context, String str, String str2) {
        XAdSDKFoundationFacade.getInstance().getIoUtils();
        int i = -1;
        if (str != null && !"".equals(str)) {
            boolean z = false;
            try {
                JSONObject optJSONObject = new JSONObject(context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_ACTIVATION, 0).getString(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_KEY, StringUtil.EMPTY_ARRAY)).optJSONObject(str);
                if (optJSONObject != null) {
                    if (optJSONObject.optBoolean("a", false)) {
                        return 100;
                    }
                }
            } catch (Exception e2) {
                Log.e("XAdCommonUtils", e2.getMessage());
            }
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0);
                JSONObject jSONObject = new JSONObject(sharedPreferences.getString(str + "#$#" + com.baidu.mobads.command.a.a(), StringUtil.EMPTY_ARRAY));
                int optInt = jSONObject.optInt(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, -1);
                try {
                    String optString = jSONObject.optString(BreakpointSQLiteKey.FILENAME, null);
                    if (optString != null) {
                        File file = new File(p.a(context) + optString);
                        if (optInt == 3) {
                            if (file.exists() && file.length() != 0) {
                                long optLong = jSONObject.optLong("contentLength", -1L);
                                if (optLong != -1) {
                                }
                                if (z) {
                                    optInt = 5;
                                    try {
                                        jSONObject.put(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, 5);
                                        SharedPreferences.Editor edit = sharedPreferences.edit();
                                        edit.putString(str, jSONObject.toString());
                                        if (Build.VERSION.SDK_INT >= 9) {
                                            edit.apply();
                                        } else {
                                            edit.commit();
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        i = 5;
                                        Log.e("XAdCommonUtils", e.getMessage());
                                        return i;
                                    }
                                }
                            }
                            z = true;
                            if (z) {
                            }
                        }
                    }
                    return optInt;
                } catch (Exception e4) {
                    e = e4;
                    i = optInt;
                }
            } catch (Exception e5) {
                e = e5;
            }
        }
        return i;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getApkFileLocalPath(Context context, String str) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0);
            String string = sharedPreferences.getString(str + "#$#" + com.baidu.mobads.command.a.a(), "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("folder");
                String optString2 = jSONObject.optString(BreakpointSQLiteKey.FILENAME);
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    return optString + optString2;
                }
            }
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
        }
        return "";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getAppId(Context context) {
        try {
            if (f8530a == null) {
                f8530a = d(context, IXAdCommonUtils.APPSID);
            }
            return f8530a;
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getAppPackage(Context context) {
        return context.getPackageName();
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getAppSec(Context context) {
        String str = f8532c;
        if (str == null || str.length() == 0 || f8532c.startsWith(StringUtil.NULL_STRING)) {
            setAppSec(getAppId(context));
        }
        return f8532c;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getBaiduMapsInfo(Context context) {
        String packageName = context != null ? context.getApplicationContext().getPackageName() : null;
        if (TextUtils.isEmpty(f8534h)) {
            com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new j(this, packageName));
        }
        return f8534h;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getChannelId() {
        return f8533d;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getDebugToken(Context context) {
        try {
            if (f8531b == null) {
                f8531b = d(context, IXAdCommonUtils.DEBUG_TOKEN);
            }
            return f8531b;
        } catch (Exception unused) {
            return "";
        }
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
    public String getFileLocalFullPath(Context context, String str) {
        try {
            return a(context) + File.separator + d(str);
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getLocationInfo(Context context) {
        return getBaiduMapsInfo(context);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public int getLogicalPixel(Context context, int i) {
        try {
            return (int) (i / getScreenDensity(context));
        } catch (Exception unused) {
            return i;
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
        } catch (NoSuchAlgorithmException e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e("AdUtil.getMD5", "", e2);
            return null;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public int getPixel(Context context, int i) {
        try {
            return (int) (i * getScreenDensity(context));
        } catch (Exception unused) {
            return i;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    @TargetApi(4)
    public float getScreenDensity(Context context) {
        return getDisplayMetrics(context).density;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    @TargetApi(17)
    public Rect getScreenRect(Context context) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        try {
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                return new Rect(0, 0, displayMetrics.heightPixels, displayMetrics.widthPixels);
            }
            return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getStatusStr(Context context, String str, String str2) {
        String str3;
        String str4 = "NONE";
        r packageUtils = XAdSDKFoundationFacade.getInstance().getPackageUtils();
        try {
            int apkDownloadStatus = getApkDownloadStatus(context, str, str2);
            boolean isInstalled = packageUtils.isInstalled(context, str);
            if (apkDownloadStatus == 0 || apkDownloadStatus == 1) {
                if (isInstalled) {
                    return "INSTALLED_BY_OTHER";
                }
                str3 = "DOWNLOADING";
                return str3;
            }
            if (apkDownloadStatus != 2) {
                if (apkDownloadStatus == 3) {
                    str3 = isInstalled ? "INSTALLED" : "DOWNLOADED";
                    return str3;
                } else if (apkDownloadStatus != 4) {
                    if (apkDownloadStatus != 5) {
                        if (apkDownloadStatus == 100) {
                            return "DONE";
                        }
                        if (isInstalled) {
                            str4 = "INSTALLED_BY_OTHER";
                        }
                    } else if (isInstalled) {
                        str4 = "DONE";
                    }
                    return str4;
                }
            }
            if (!isInstalled) {
                str3 = "DOWNLOAD_FAILED";
                return str3;
            }
            return "INSTALLED_BY_OTHER";
        } catch (Exception unused) {
            return "NONE";
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getSubscriberId(Context context) {
        return "";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String getTextEncoder(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException | NullPointerException unused) {
            return str;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public Rect getWindowRect(Context context) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public boolean hasPermission(Context context, String str) {
        return a(context, str);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public boolean hasSupportedApps(Context context, int i) {
        Intent intent;
        List<ResolveInfo> queryIntentActivities;
        try {
            IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
            if (i == 0) {
                intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse("mailto:baidumobadstest@baidu.com"));
            } else if (i == 1) {
                intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse("sms:12345678"));
            } else if (i == 2) {
                return XAdSDKFoundationFacade.getInstance().getCommonUtils().hasPermission(context, "android.permission.ACCESS_WIFI_STATE") && XAdSDKFoundationFacade.getInstance().getCommonUtils().hasPermission(context, "android.permission.CHANGE_WIFI_STATE");
            } else if (i == 3) {
                if (systemUtils.canSupportSdcardStroage(context)) {
                    XAdSDKFoundationFacade.getInstance().getPackageUtils();
                    return r.b(context);
                }
                return false;
            } else if (i != 4) {
                return false;
            } else {
                intent = new Intent("android.intent.action.EDIT");
                intent.setType("vnd.android.cursor.item/event");
            }
            new ArrayList();
            queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
        } catch (Exception unused) {
        }
        return (queryIntentActivities == null || queryIntentActivities.size() <= 0 || queryIntentActivities.get(0).activityInfo.packageName.equals("com.android.fallback")) ? false : true;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public void installApp(Context context, String str, File file, boolean z) {
        try {
            XAdSDKFoundationFacade.getInstance().getPackageUtils().b(context, file);
            if (!z || str == null || str == null || str.equals("")) {
                return;
            }
            com.baidu.mobads.command.a aVar = new com.baidu.mobads.command.a(str, "");
            aVar.f8187g = true;
            com.baidu.mobads.a.a aVar2 = new com.baidu.mobads.a.a(aVar);
            IntentFilter intentFilter = new IntentFilter(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addDataScheme("package");
            context.registerReceiver(aVar2, intentFilter);
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public boolean isOldPermissionModel() {
        return Build.VERSION.SDK_INT < 23;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public boolean isStringAvailable(String str) {
        return str != null && str.length() > 0;
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
            } catch (Exception e2) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
            }
        }
        return jSONArray;
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
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public void sendDownloadAdLog(Context context, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2) {
        IXAdURIUitls uRIUitls;
        StringBuilder sb;
        try {
            uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
            IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
            IBase64 base64 = XAdSDKFoundationFacade.getInstance().getBase64();
            sb = new StringBuilder();
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
            sb.append("&cuid=" + base64.encode(systemUtils.getCUID(context)));
            sb.append("&pack=" + context.getPackageName());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("&v=");
            sb2.append("android_" + com.baidu.mobads.constants.a.f8206c + "_4.1.30");
            sb.append(sb2.toString());
        } catch (Exception e2) {
            e = e2;
        }
        try {
            com.baidu.mobads.openad.b.b bVar = new com.baidu.mobads.openad.b.b(uRIUitls.addParameters(vdUrl(sb.toString(), i), null), "");
            bVar.f8414e = 1;
            new com.baidu.mobads.openad.b.a().a(bVar);
        } catch (Exception e3) {
            e = e3;
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public void sendDownloadAdLog(Context context, String str, int i, String str2) {
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
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public void setAppId(String str) {
        f8530a = str;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public void setAppSec(String str) {
        f8532c = str + "_cpr";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public void setChannelId(String str) {
        f8533d = str;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdCommonUtils
    public String vdUrl(String str, int i) {
        XAdSDKFoundationFacade.getInstance().getURIUitls();
        JSONObject jSONObject = new JSONObject();
        for (String str2 : str.substring(str.indexOf("?") + 1).split("&")) {
            try {
                String[] split = str2.split("=");
                if (!split[0].equals("type")) {
                    if (split.length > 1) {
                        jSONObject.putOpt(split[0], split[1]);
                    } else if (split.length == 1) {
                        jSONObject.putOpt(split[0], StringUtil.NULL_STRING);
                    }
                }
            } catch (Exception unused) {
            }
        }
        StringBuilder sb = new StringBuilder("type=" + i + "&");
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
                } catch (Exception unused2) {
                }
            }
        } catch (Exception unused3) {
        }
        treeMap.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, System.currentTimeMillis() + "");
        for (String str3 : treeMap.keySet()) {
            String str4 = (String) treeMap.get(str3);
            if (str3 != null && str4 != null) {
                if (!str3.equals("targetscheme")) {
                    str3 = encodeURIComponent(str3);
                    str4 = encodeURIComponent(str4);
                }
                sb.append(str3 + "=" + str4 + "&");
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str4);
                sb3.append(",");
                sb2.append(sb3.toString());
            }
        }
        sb2.append("mobads,");
        sb.append("vd=" + getMD5(sb2.toString()) + "&");
        return "https://mobads-logs.baidu.com/dz.zb?" + sb.toString();
    }

    private String d(Context context, String str) {
        String str2 = "error";
        try {
            str2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str) + "";
        } catch (Exception unused) {
            String.format("Could not read %s meta-data from AndroidManifest.xml", str);
        }
        if (str2.trim().equals("")) {
            throw new Exception();
        }
        return str2;
    }

    public static boolean c(Context context, String str) {
        try {
            return ((Integer) Context.class.getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() == 0;
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
            return true;
        }
    }

    @TargetApi(4)
    private void a(Context context, Intent intent) {
        try {
            if (Build.VERSION.SDK_INT < 19) {
                context.startActivity(intent);
            } else {
                new Handler(context.getMainLooper()).post(new i(this, context, intent));
            }
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
        }
    }

    public static boolean a(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e2) {
            q.a().e(e2);
            return false;
        }
    }

    public void a(String str, Object obj) {
        if (a()) {
            return;
        }
        HashMap<String, Object> hashMap = this.i;
        hashMap.put(str + "_E", Long.valueOf(System.currentTimeMillis() + 5000));
        HashMap<String, Object> hashMap2 = this.i;
        hashMap2.put(str + "_V", obj);
    }

    public Object a(String str) {
        if (a()) {
            return null;
        }
        try {
            HashMap<String, Object> hashMap = this.i;
            Object obj = hashMap.get(str + "_E");
            if (obj != null) {
                if (System.currentTimeMillis() < ((Long) obj).longValue()) {
                    HashMap<String, Object> hashMap2 = this.i;
                    return hashMap2.get(str + "_V");
                }
            }
        } catch (Exception e2) {
            q.a().e(e2);
        }
        return null;
    }

    public boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(new k(this, runnable));
            }
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
        }
    }

    public static Class<?> a(Object obj) {
        try {
            return Class.forName(obj.getClass().getName());
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
            return null;
        }
    }

    public static Method a(Object obj, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = a(obj).getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
            return null;
        }
    }

    public static boolean b(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return c(context, str);
        }
        return a(context, str);
    }

    public Object a(Object obj, String str, Object... objArr) {
        try {
            int length = objArr.length;
            Class[] clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
            return a(obj, str, (Class<?>[]) clsArr).invoke(obj, objArr);
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
            return null;
        }
    }

    public void a(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
            } catch (Exception e2) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
            }
        }
    }

    public String a(List<String> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i));
            sb.append(",");
        }
        sb.append(list.get(list.size() - 1));
        return sb.toString();
    }
}
