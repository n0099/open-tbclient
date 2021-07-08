package com.baidu.mobads.container.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.service.PluginLoader;
import com.baidu.mobads.container.util.AppUtils;
import com.baidu.mobads.container.util.SendLogUtil;
import com.baidu.mobads.container.util.oaid.UniqueIdUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PackageUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long CONFIG_INTERVAL = 86400000;
    public static final int INSTALL_APP_URL_MAX_LEN = 3000;
    public static final String PKGS_PREF_INSTALL_SENT = "install_sent";
    public static int RSPLASH_HTML_LOG = 0;
    public static int RSPLASH_JSON_LOG = 0;
    public static int SOURCE_DONWLOAD_APO_FEED_JSON = 0;
    public static int SOURCE_DONWLOAD_APO_GIF_JSON = 0;
    public static int SOURCE_DONWLOAD_APO_HANDLECLICK_HTML = 0;
    public static int SOURCE_DONWLOAD_APO_LINEARGIF_JSON = 0;
    public static int SOURCE_DONWLOAD_APO_LINEARSTATIC_JSON = 0;
    public static int SOURCE_DONWLOAD_APO_LINEARVIDEO_JSON = 0;
    public static int SOURCE_DONWLOAD_APO_MONITOR = 0;
    public static int SOURCE_DONWLOAD_APO_OPENAPP_HTML = 0;
    public static int SOURCE_DONWLOAD_APO_RSPLASH_JSON = 0;
    public static int SOURCE_DONWLOAD_APO_RSPLASH_VIDEO_JSON = 0;
    public static final int SUBTYPE_END_FRAME_VISIBLE = 10;
    public static final int SUBTYPE_REWARD_CACHE_FAILED = 4;
    public static final int SUBTYPE_REWARD_CACHE_SUCCESS = 3;
    public static final int SUBTYPE_REWARD_CALL_SHOW = 1;
    public static final int SUBTYPE_REWARD_CLICK_BANNER = 8;
    public static final int SUBTYPE_REWARD_CLICK_END_FRAME = 9;
    public static final int SUBTYPE_REWARD_DOWNLOADBTN_CLICK = 13;
    public static final int SUBTYPE_REWARD_MATERIAL_CLICK = 14;
    public static final int SUBTYPE_REWARD_PLAY_SHOW = 12;
    public static final int SUBTYPE_REWARD_SHOW_FAILED = 2;
    public static final int SUBTYPE_REWARD_SKIP_CLICK = 15;
    public static final int SUBTYPE_REWARD_VIDEO_CLOSE = 7;
    public static final int SUBTYPE_REWARD_VIDEO_PLAY_COMPLETE = 6;
    public static final int SUBTYPE_REWARD_VIDEO_PLAY_FAILED = 11;
    public static final int SUBTYPE_REWARD_VIDEO_PLAY_START = 5;
    public static final String TAG = "PackageUtils";
    public static final String TIEBA_APPID = "bb3808eb";
    public static JSONArray mCustomerInstalled;
    public static HashMap<String, String> mPageMap;
    public static JSONArray mSystemInstalled;
    public static volatile long sLastSendInstall;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(970051746, "Lcom/baidu/mobads/container/util/PackageUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(970051746, "Lcom/baidu/mobads/container/util/PackageUtils;");
                return;
            }
        }
        mPageMap = new HashMap<>();
        SOURCE_DONWLOAD_APO_MONITOR = 1;
        SOURCE_DONWLOAD_APO_RSPLASH_JSON = 2;
        SOURCE_DONWLOAD_APO_FEED_JSON = 3;
        SOURCE_DONWLOAD_APO_GIF_JSON = 4;
        SOURCE_DONWLOAD_APO_OPENAPP_HTML = 5;
        SOURCE_DONWLOAD_APO_HANDLECLICK_HTML = 6;
        SOURCE_DONWLOAD_APO_LINEARGIF_JSON = 7;
        SOURCE_DONWLOAD_APO_LINEARSTATIC_JSON = 8;
        SOURCE_DONWLOAD_APO_LINEARVIDEO_JSON = 9;
        SOURCE_DONWLOAD_APO_RSPLASH_VIDEO_JSON = 10;
        RSPLASH_JSON_LOG = 414;
        RSPLASH_HTML_LOG = SDKLogTypeConstants.TYPE_RSPLASH_HTML_LOG;
        sLastSendInstall = 0L;
    }

    public PackageUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static synchronized boolean checkSendInstalled(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (PackageUtils.class) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    sLastSendInstall = getLastSendInstalled(context);
                    if (currentTimeMillis - sLastSendInstall > 86400000) {
                        setLastSendInstalled(context, currentTimeMillis);
                        sLastSendInstall = currentTimeMillis;
                        return true;
                    }
                    return false;
                } catch (Exception unused) {
                    return false;
                }
            }
        }
        return invokeL.booleanValue;
    }

    public static String encodePackage(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray)) == null) {
            String str = "";
            try {
                for (int length = jSONArray.length() - 1; length >= 0; length--) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(length);
                    String hexString = Long.toHexString(murmurhash264B(jSONObject.getString("p")));
                    if (jSONObject.optString("v") != null) {
                        String str2 = hexString + '_' + Base64.encode(jSONObject.optString("v"));
                        hexString = jSONObject.getString("c") != null ? str2 + '_' + jSONObject.getString("c") : str2;
                    }
                    String str3 = hexString + ',';
                    if (str.length() + str3.length() > 3000) {
                        break;
                    }
                    str = str + str3;
                }
                return AdURIUtils.isStringAvailable(str) ? str.substring(0, str.length() - 1) : str;
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().e(e2);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getCPUSerial() {
        String readLine;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            try {
                LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /proc/cpuinfo").getInputStream()));
                for (int i2 = 1; i2 < 100 && (readLine = lineNumberReader.readLine()) != null; i2++) {
                    if (readLine.indexOf("Serial") > -1) {
                        return readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                    }
                }
                return "default";
            } catch (Exception unused) {
                return "exception";
            }
        }
        return (String) invokeV.objValue;
    }

    public static JSONArray getCurrentApp(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (PermissionUtils.checkPermission(context, "android.permission.GET_TASKS")) {
                try {
                    List<ActivityManager.RecentTaskInfo> recentTasks = ((ActivityManager) context.getSystemService("activity")).getRecentTasks(64, 0);
                    for (int i2 = 0; i2 < recentTasks.size(); i2++) {
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(recentTasks.get(i2).baseIntent.getComponent().getPackageName(), 0);
                        if (!packageInfo.packageName.startsWith("com.android") && !packageInfo.packageName.startsWith("com.sec")) {
                            jSONArray.put(new AppUtils.ApkInfo(context, packageInfo).toRecentJSONObject());
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public static synchronized JSONArray getInstalled(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            synchronized (PackageUtils.class) {
                if (!PermissionUtils.hasPermission("permission_app_list")) {
                    return new JSONArray();
                }
                if (mCustomerInstalled == null) {
                    mCustomerInstalled = new JSONArray();
                    try {
                        for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(0)) {
                            if (!AppUtils.isSystemPackage(packageInfo)) {
                                mCustomerInstalled.put(new AppUtils.ApkInfo(context, packageInfo).toJSONObject());
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                return mCustomerInstalled;
            }
        }
        return (JSONArray) invokeL.objValue;
    }

    public static long getLastSendInstalled(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? context.getSharedPreferences(PKGS_PREF_INSTALL_SENT, 0).getLong("install_sent_time", 0L) : invokeL.longValue;
    }

    public static JSONArray getRecentAll(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (PermissionUtils.checkPermission(context, "android.permission.GET_TASKS")) {
                ArrayList arrayList = new ArrayList();
                SharedPreferences.Editor edit = context.getSharedPreferences("__sdk_ral", 0).edit();
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.clear().apply();
                } else {
                    edit.clear().commit();
                }
                try {
                    List<ActivityManager.RecentTaskInfo> recentTasks = ((ActivityManager) context.getSystemService("activity")).getRecentTasks(64, 0);
                    for (int i2 = 0; i2 < recentTasks.size(); i2++) {
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(recentTasks.get(i2).baseIntent.getComponent().getPackageName(), 0);
                        if (!packageInfo.packageName.startsWith("com.android") && !packageInfo.packageName.startsWith("com.sec") && !arrayList.contains(packageInfo.packageName)) {
                            arrayList.add(packageInfo.packageName);
                            jSONArray.put(new AppUtils.ApkInfo(context, packageInfo).toRecentJSONObject());
                        }
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    if (arrayList.size() > 0) {
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            if (arrayList.get(i3) != null && arrayList.get(i3) != "") {
                                stringBuffer.append((String) arrayList.get(i3));
                                stringBuffer.append("#");
                            }
                        }
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    if (stringBuffer2 != null) {
                        edit.putString("ral", Base64.encode(stringBuffer2));
                        if (Build.VERSION.SDK_INT >= 9) {
                            edit.apply();
                        } else {
                            edit.commit();
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public static JSONArray getRecentDiff(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (PermissionUtils.checkPermission(context, "android.permission.GET_TASKS")) {
                ArrayList arrayList = new ArrayList();
                SharedPreferences sharedPreferences = context.getSharedPreferences("__sdk_ral", 0);
                String string = sharedPreferences.getString("ral", null);
                if (string != null) {
                    String decodeStr = Base64.decodeStr(string);
                    if (!TextUtils.isEmpty(decodeStr)) {
                        for (String str : decodeStr.split("#")) {
                            arrayList.add(str);
                        }
                    }
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                try {
                    List<ActivityManager.RecentTaskInfo> recentTasks = ((ActivityManager) context.getSystemService("activity")).getRecentTasks(64, 0);
                    for (int i2 = 0; i2 < recentTasks.size(); i2++) {
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(recentTasks.get(i2).baseIntent.getComponent().getPackageName(), 0);
                        if (!packageInfo.packageName.startsWith("com.android") && !packageInfo.packageName.startsWith("com.sec") && !arrayList.contains(packageInfo.packageName)) {
                            arrayList.add(packageInfo.packageName);
                            jSONArray.put(new AppUtils.ApkInfo(context, packageInfo).toRecentJSONObject());
                        }
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    if (arrayList.size() > 0) {
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            if (arrayList.get(i3) != null && arrayList.get(i3) != "") {
                                stringBuffer.append((String) arrayList.get(i3));
                                stringBuffer.append("#");
                            }
                        }
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    if (stringBuffer2 != null) {
                        edit.putString("ral", Base64.encode(stringBuffer2));
                        if (Build.VERSION.SDK_INT >= 9) {
                            edit.apply();
                        } else {
                            edit.commit();
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public static String getSDAvailableSize(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                return Formatter.formatFileSize(context, statFs.getBlockSize() * statFs.getAvailableBlocks());
            }
            return Formatter.formatFileSize(context, 0L);
        }
        return (String) invokeL.objValue;
    }

    public static String getSDTotalSize(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                return Formatter.formatFileSize(context, statFs.getBlockSize() * statFs.getBlockCount());
            }
            return Formatter.formatFileSize(context, 0L);
        }
        return (String) invokeL.objValue;
    }

    public static synchronized JSONArray getSysInstalled(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            synchronized (PackageUtils.class) {
                if (!PermissionUtils.hasPermission("permission_app_list")) {
                    return new JSONArray();
                }
                if (mSystemInstalled == null) {
                    mSystemInstalled = new JSONArray();
                    try {
                        for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(0)) {
                            if (AppUtils.isSystemPackage(packageInfo) && !packageInfo.packageName.startsWith("com.android") && !packageInfo.packageName.startsWith("com.sec")) {
                                mSystemInstalled.put(new AppUtils.ApkInfo(context, packageInfo).toJSONObject());
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                return mSystemInstalled;
            }
        }
        return (JSONArray) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0183 A[Catch: Exception -> 0x01a5, TryCatch #9 {Exception -> 0x01a5, blocks: (B:69:0x0157, B:71:0x0183, B:72:0x018c), top: B:90:0x0157 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isAPOOpenAvailable(XAdContainerContext xAdContainerContext, String str, IXAdInstanceInfo iXAdInstanceInfo, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        StringBuilder sb;
        boolean z;
        boolean z2;
        List<ResolveInfo> list;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{xAdContainerContext, str, iXAdInstanceInfo, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (xAdContainerContext == null || iXAdInstanceInfo == null) {
                return true;
            }
            Context appContext = xAdContainerContext.getAppContext();
            String appPackageName = iXAdInstanceInfo.getAppPackageName();
            HashMap<String, String> hashMap = new HashMap<>();
            StringBuilder sb2 = new StringBuilder();
            if (appContext == null) {
                return true;
            }
            PackageManager packageManager = appContext.getPackageManager();
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
                if (queryIntentActivities.size() > 0) {
                    hashMap.put("open", "true");
                    hashMap.put("n", String.valueOf(queryIntentActivities.size()));
                    int i6 = 0;
                    boolean z3 = true;
                    while (i6 < queryIntentActivities.size()) {
                        try {
                            ResolveInfo resolveInfo = queryIntentActivities.get(i6);
                            if (i6 == 0) {
                                sb2.append(resolveInfo.activityInfo.packageName);
                            } else {
                                sb2.append(",");
                                sb2.append(resolveInfo.activityInfo.packageName);
                            }
                            if (appPackageName == null || !appPackageName.equals(resolveInfo.activityInfo.packageName)) {
                                list = queryIntentActivities;
                                sb = sb2;
                            } else {
                                String str2 = "";
                                list = queryIntentActivities;
                                try {
                                    sb = sb2;
                                    try {
                                        int i7 = packageManager.getPackageInfo(resolveInfo.activityInfo.packageName, 0).versionCode;
                                        try {
                                            str2 = packageManager.getPackageInfo(resolveInfo.activityInfo.packageName, 0).versionName;
                                            if (i7 < i4) {
                                                z3 = false;
                                            }
                                            try {
                                                hashMap.put("installedVersion", String.valueOf(i7));
                                                hashMap.put("requiredVersion", String.valueOf(i4));
                                                hashMap.put("realopen", String.valueOf(z3));
                                            } catch (Exception e2) {
                                                e = e2;
                                                z = z3;
                                                RemoteXAdLogger.getInstance().d(e.getMessage());
                                                SendLogUtil.Builder create = SendLogUtil.Builder.create(appContext);
                                                create.appendType(i2);
                                                create.append("fb_act", i3);
                                                create.append(hashMap);
                                                create.append("open", z);
                                                create.append("targetscheme", str);
                                                create.append("pk", appPackageName);
                                                create.appendAdInfo(iXAdInstanceInfo);
                                                if (sb.length() > 0) {
                                                }
                                                create.appendProdType(xAdContainerContext.getAdProd());
                                                create.appendAppSid(xAdContainerContext.getAppsid());
                                                create.appendApId(xAdContainerContext.getAdPlacementId());
                                                create.send();
                                                return z;
                                            }
                                        } catch (Exception unused) {
                                            i5 = i7;
                                            try {
                                                hashMap.put("exception", "true");
                                                hashMap.put("installedVersion", String.valueOf(i5));
                                                hashMap.put("requiredVersion", String.valueOf(i4));
                                                hashMap.put("realopen", String.valueOf(z3));
                                                hashMap.put("installedVersionName", str2);
                                                i6++;
                                                queryIntentActivities = list;
                                                sb2 = sb;
                                            } catch (Throwable th) {
                                                th = th;
                                                hashMap.put("installedVersion", String.valueOf(i5));
                                                hashMap.put("requiredVersion", String.valueOf(i4));
                                                hashMap.put("realopen", String.valueOf(z3));
                                                hashMap.put("installedVersionName", "");
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            i5 = i7;
                                            hashMap.put("installedVersion", String.valueOf(i5));
                                            hashMap.put("requiredVersion", String.valueOf(i4));
                                            hashMap.put("realopen", String.valueOf(z3));
                                            hashMap.put("installedVersionName", "");
                                            throw th;
                                        }
                                    } catch (Exception unused2) {
                                        i5 = -1;
                                        hashMap.put("exception", "true");
                                        hashMap.put("installedVersion", String.valueOf(i5));
                                        hashMap.put("requiredVersion", String.valueOf(i4));
                                        hashMap.put("realopen", String.valueOf(z3));
                                        hashMap.put("installedVersionName", str2);
                                        i6++;
                                        queryIntentActivities = list;
                                        sb2 = sb;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        i5 = -1;
                                        hashMap.put("installedVersion", String.valueOf(i5));
                                        hashMap.put("requiredVersion", String.valueOf(i4));
                                        hashMap.put("realopen", String.valueOf(z3));
                                        hashMap.put("installedVersionName", "");
                                        throw th;
                                    }
                                } catch (Exception unused3) {
                                    sb = sb2;
                                } catch (Throwable th4) {
                                    th = th4;
                                    sb = sb2;
                                }
                                hashMap.put("installedVersionName", str2);
                            }
                            i6++;
                            queryIntentActivities = list;
                            sb2 = sb;
                        } catch (Exception e3) {
                            e = e3;
                            sb = sb2;
                        }
                    }
                    sb = sb2;
                    z2 = z3;
                } else {
                    sb = sb2;
                    try {
                        hashMap.put("open", "false");
                        z2 = false;
                    } catch (Exception e4) {
                        e = e4;
                        z = false;
                        RemoteXAdLogger.getInstance().d(e.getMessage());
                        SendLogUtil.Builder create2 = SendLogUtil.Builder.create(appContext);
                        create2.appendType(i2);
                        create2.append("fb_act", i3);
                        create2.append(hashMap);
                        create2.append("open", z);
                        create2.append("targetscheme", str);
                        create2.append("pk", appPackageName);
                        create2.appendAdInfo(iXAdInstanceInfo);
                        if (sb.length() > 0) {
                        }
                        create2.appendProdType(xAdContainerContext.getAdProd());
                        create2.appendAppSid(xAdContainerContext.getAppsid());
                        create2.appendApId(xAdContainerContext.getAdPlacementId());
                        create2.send();
                        return z;
                    }
                }
                z = z2;
            } catch (Exception e5) {
                e = e5;
                sb = sb2;
                z = true;
            }
            try {
                SendLogUtil.Builder create22 = SendLogUtil.Builder.create(appContext);
                create22.appendType(i2);
                create22.append("fb_act", i3);
                create22.append(hashMap);
                create22.append("open", z);
                create22.append("targetscheme", str);
                create22.append("pk", appPackageName);
                create22.appendAdInfo(iXAdInstanceInfo);
                if (sb.length() > 0) {
                    create22.append("p", sb.toString());
                }
                create22.appendProdType(xAdContainerContext.getAdProd());
                create22.appendAppSid(xAdContainerContext.getAppsid());
                create22.appendApId(xAdContainerContext.getAdPlacementId());
                create22.send();
                return z;
            } catch (Exception e6) {
                RemoteXAdLogger.getInstance().d(e6.getMessage());
                return z;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static long murmurhash264B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            byte[] bytes = str.getBytes();
            return murmurhash264B(bytes, bytes.length);
        }
        return invokeL.longValue;
    }

    public static void sendAPOInfo(XAdContainerContext xAdContainerContext, String str, String str2, int i2, int i3, int i4, HashMap<String, String> hashMap) {
        String str3;
        StringBuilder sb;
        boolean z;
        List<ResolveInfo> list;
        StringBuilder sb2;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{xAdContainerContext, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), hashMap}) == null) {
            try {
                IXAdInstanceInfo adInstanceInfo = xAdContainerContext.getAdInstanceInfo();
                Context appContext = xAdContainerContext.getAppContext();
                PackageManager packageManager = appContext.getPackageManager();
                String encodeUrl = AdURIUtils.encodeUrl(str);
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
                HashMap<String, String> hashMap2 = new HashMap<>();
                StringBuilder sb3 = new StringBuilder();
                if (queryIntentActivities.size() > 0) {
                    hashMap2.put("open", "true");
                    hashMap2.put("n", String.valueOf(queryIntentActivities.size()));
                    z = true;
                    str3 = encodeUrl;
                    int i6 = 0;
                    while (i6 < queryIntentActivities.size()) {
                        ResolveInfo resolveInfo = queryIntentActivities.get(i6);
                        if (i6 == 0) {
                            list = queryIntentActivities;
                            sb3.append(resolveInfo.activityInfo.packageName);
                        } else {
                            list = queryIntentActivities;
                            sb3.append(",");
                            sb3.append(resolveInfo.activityInfo.packageName);
                        }
                        if (str2.equals(resolveInfo.activityInfo.packageName)) {
                            try {
                                try {
                                    sb2 = sb3;
                                    try {
                                        i5 = packageManager.getPackageInfo(resolveInfo.activityInfo.packageName, 0).versionCode;
                                    } catch (Exception unused) {
                                        i5 = -1;
                                        try {
                                            hashMap2.put("exception", "true");
                                            hashMap2.put("installedVersionCode", String.valueOf(i5));
                                            hashMap2.put("requiredVersion", String.valueOf(i4));
                                            hashMap2.put("realopen", String.valueOf(z));
                                            hashMap2.put("installedVersionName", "");
                                            i6++;
                                            queryIntentActivities = list;
                                            sb3 = sb2;
                                        } catch (Throwable th) {
                                            th = th;
                                            hashMap2.put("installedVersionCode", String.valueOf(i5));
                                            hashMap2.put("requiredVersion", String.valueOf(i4));
                                            hashMap2.put("realopen", String.valueOf(z));
                                            hashMap2.put("installedVersionName", "");
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    i5 = -1;
                                }
                            } catch (Exception unused2) {
                                sb2 = sb3;
                            }
                            try {
                                String str4 = packageManager.getPackageInfo(resolveInfo.activityInfo.packageName, 0).versionName;
                                if (i5 < i4) {
                                    z = false;
                                }
                                hashMap2.put("installedVersionCode", String.valueOf(i5));
                                hashMap2.put("requiredVersion", String.valueOf(i4));
                                hashMap2.put("realopen", String.valueOf(z));
                                hashMap2.put("installedVersionName", str4);
                            } catch (Exception unused3) {
                                hashMap2.put("exception", "true");
                                hashMap2.put("installedVersionCode", String.valueOf(i5));
                                hashMap2.put("requiredVersion", String.valueOf(i4));
                                hashMap2.put("realopen", String.valueOf(z));
                                hashMap2.put("installedVersionName", "");
                                i6++;
                                queryIntentActivities = list;
                                sb3 = sb2;
                            } catch (Throwable th3) {
                                th = th3;
                                hashMap2.put("installedVersionCode", String.valueOf(i5));
                                hashMap2.put("requiredVersion", String.valueOf(i4));
                                hashMap2.put("realopen", String.valueOf(z));
                                hashMap2.put("installedVersionName", "");
                                throw th;
                            }
                        } else {
                            sb2 = sb3;
                        }
                        i6++;
                        queryIntentActivities = list;
                        sb3 = sb2;
                    }
                    sb = sb3;
                } else {
                    str3 = encodeUrl;
                    sb = sb3;
                    hashMap2.put("open", "false");
                    z = false;
                }
                SendLogUtil.Builder append = SendLogUtil.Builder.create(appContext).appendType(i2).append("fb_act", i3).append("pk", str2).append("targetscheme", str3).appendApId(xAdContainerContext.getAdPlacementId()).appendAppSid(xAdContainerContext.getAppsid()).appendProdType(xAdContainerContext.getAdProd()).append("mac", "").append("targetVer", CommonUtils.getTargetVersion(appContext)).append(hashMap).append(hashMap2).append("open", z);
                if (adInstanceInfo != null) {
                    append.appendAdInfo(adInstanceInfo);
                }
                if (sb.length() > 0) {
                    append.append("p", sb.toString());
                }
                append.sendWithVd();
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(TAG, e2.getMessage());
            }
        }
    }

    public static boolean sendAPOInfo(Context context, String str, String str2, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{context, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void sendAppInstallInfo(Context context, XAdContainerContext xAdContainerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, context, xAdContainerContext) == null) {
            try {
                if (System.currentTimeMillis() - sLastSendInstall > 86400000) {
                    TaskScheduler.getInstance().submit(new BaseTask<Long>(context, xAdContainerContext) { // from class: com.baidu.mobads.container.util.PackageUtils.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ XAdContainerContext val$mAdContainerContext;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {context, xAdContainerContext};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$context = context;
                            this.val$mAdContainerContext = xAdContainerContext;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.mobads.container.executor.BaseTask
                        public Long doInBackground() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                                if (PackageUtils.checkSendInstalled(this.val$context)) {
                                    PackageUtils.sendInstalled(this.val$context, this.val$mAdContainerContext);
                                    PackageUtils.sendSysInstalled(this.val$context, this.val$mAdContainerContext);
                                    PackageUtils.sendInfo(this.val$context, this.val$mAdContainerContext);
                                }
                                return Long.valueOf(PackageUtils.sLastSendInstall);
                            }
                            return (Long) invokeV.objValue;
                        }
                    }, 2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void sendDownloadAPOLog(Context context, XAdContainerContext xAdContainerContext, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{context, xAdContainerContext, str, str2, Integer.valueOf(i2)}) == null) {
            try {
                SendLogUtil.Builder.create(context).appendType(SDKLogTypeConstants.TYPE_APO_WAKE_UP_MONITOR).appendProdType(xAdContainerContext.getAdProd()).appendAppSid(xAdContainerContext.getAppsid()).appendApId(xAdContainerContext.getAdPlacementId()).append("mac", "").append("schema", AdURIUtils.encodeUrl(str2)).append("pk", str).append("source", i2).sendWithVd();
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(TAG, e2.getMessage());
            }
        }
    }

    public static void sendInfo(Context context, XAdContainerContext xAdContainerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, context, xAdContainerContext) == null) {
            try {
                SendLogUtil.Builder append = SendLogUtil.Builder.create(context).appendType(SDKLogTypeConstants.TYPE_SEND_INFO).appendApId(xAdContainerContext.getAdPlacementId()).appendProdType(xAdContainerContext.getAdProd()).appendAppSid(xAdContainerContext.getAppsid()).append("mac", "").append("cpuSerial", getCPUSerial()).append("simState", ((TelephonyManager) context.getSystemService("phone")).getSimState()).append("sdState", Environment.getExternalStorageState().equals("mounted"));
                boolean hasPermission = PermissionUtils.hasPermission("permission_storage");
                if (hasPermission) {
                    append.append("sdTotalSize", getSDTotalSize(context));
                    append.append("sdAvailableSize", getSDAvailableSize(context));
                }
                append.append("hasSdPermission", hasPermission);
                Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                append.append("chargeState", registerReceiver.getIntExtra("plugged", -1));
                int intExtra = registerReceiver.getIntExtra("level", 0);
                int intExtra2 = registerReceiver.getIntExtra("scale", 100);
                append.append("batteryLevel", intExtra);
                append.append("batteryScale", intExtra2);
                append.append("isDeviceRooted", new Root().isDeviceRooted());
                if (new Random().nextDouble() < 0.4d) {
                    append.append("zd", PluginLoader.getZid(context));
                    append.append("td", PluginLoader.getTdid(context));
                }
                int targetVersion = CommonUtils.getTargetVersion(context);
                append.append("targetVer", targetVersion);
                try {
                    append.append("oaid", "" + UniqueIdUtils.getMiidOAID(context));
                } catch (Throwable unused) {
                }
                if (Integer.parseInt(DeviceUtils.getInstance().getPhoneOSBuildVersionSdk()) >= 26 && targetVersion >= 26) {
                    append.append("allowIns", CommonUtils.getInstallPermission(context));
                }
                append.sendWithVd();
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(TAG, e2.getMessage());
            }
            try {
                SendLogUtil.Builder.create(context).appendType(SDKLogTypeConstants.TYPE_FOR_XUZHANG).send();
            } catch (Exception unused2) {
            }
            RemoteCommonUtils.getInstance().sendLog4DlFailed(context, System.currentTimeMillis());
        }
    }

    public static void sendInstalled(Context context, XAdContainerContext xAdContainerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, context, xAdContainerContext) == null) {
            try {
                JSONArray jSONArray = new JSONArray("[]");
                boolean z = true;
                if (SDKLogSecurityManager.isEnvSecurity()) {
                    z = false;
                } else {
                    jSONArray = getInstalled(context);
                }
                SendLogUtil.Builder append = SendLogUtil.Builder.create(context).appendType(3).appendApId(xAdContainerContext.getAdPlacementId()).appendProdType(xAdContainerContext.getAdProd()).appendAppSid(xAdContainerContext.getAppsid()).append("t", jSONArray.length()).append("spbaiduid", CommonUtils.getSPBaiduId(context)).append("safenv", z);
                if (jSONArray.length() > 0) {
                    append.append("p", encodePackage(jSONArray));
                }
                append.send();
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(TAG, e2.getMessage());
            }
        }
    }

    public static void sendRVideoLog(XAdContainerContext xAdContainerContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65561, null, xAdContainerContext, i2) == null) {
            String adProd = xAdContainerContext.getAdProd();
            if ("rvideo".equals(adProd)) {
                sendRVideoLog(xAdContainerContext, i2, 601);
            } else if ("fvideo".equals(adProd)) {
                sendRVideoLog(xAdContainerContext, i2, 603);
            }
        }
    }

    public static void sendRsplashLog(Context context, XAdContainerContext xAdContainerContext, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65563, null, context, xAdContainerContext, i2, i3) == null) {
            try {
                SendLogUtil.Builder append = SendLogUtil.Builder.create(context).appendType(i2).appendProdType(xAdContainerContext.getAdProd()).appendAppSid(xAdContainerContext.getAppsid()).appendApId(xAdContainerContext.getAdPlacementId()).appendAdInfo(xAdContainerContext.getAdInstanceInfo()).append("mac", "");
                append.append("logtime", System.currentTimeMillis() + "").append("subtype", i3).sendWithVd();
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(TAG, e2.getMessage());
            }
        }
    }

    public static void sendSysInstalled(Context context, XAdContainerContext xAdContainerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, null, context, xAdContainerContext) == null) {
            try {
                JSONArray jSONArray = new JSONArray("[]");
                boolean z = true;
                if (SDKLogSecurityManager.isEnvSecurity()) {
                    z = false;
                } else {
                    jSONArray = getSysInstalled(context);
                }
                SendLogUtil.Builder append = SendLogUtil.Builder.create(context).appendType(SDKLogTypeConstants.TYPE_SYSTEM_SPP_LIST).appendApId(xAdContainerContext.getAdPlacementId()).appendProdType(xAdContainerContext.getAdProd()).appendAppSid(xAdContainerContext.getAppsid()).append("t", jSONArray.length()).append("spbaiduid", CommonUtils.getSPBaiduId(context)).append("safenv", z);
                if (jSONArray.length() > 0) {
                    append.append("p", encodePackage(jSONArray));
                }
                append.send();
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(TAG, e2.getMessage());
            }
        }
    }

    public static synchronized void setLastSendInstalled(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65565, null, context, j) == null) {
            synchronized (PackageUtils.class) {
                try {
                    SharedPreferences.Editor edit = context.getSharedPreferences(PKGS_PREF_INSTALL_SENT, 0).edit();
                    edit.putLong("install_sent_time", j);
                    if (Build.VERSION.SDK_INT >= 9) {
                        edit.apply();
                    } else {
                        edit.commit();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public static long murmurhash264B(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65553, null, bArr, i2)) == null) ? murmurhash264B(bArr, i2, 428279572) : invokeLI.longValue;
    }

    public static long murmurhash264B(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65554, null, bArr, i2, i3)) == null) {
            int i15 = i3 ^ i2;
            int i16 = 0;
            int i17 = 0;
            while (i2 >= 8) {
                int i18 = (int) (((bArr[i16] & 255) + ((bArr[i8] & 255) << 8) + ((bArr[i9] & 255) << 16) + ((bArr[i10] & 255) << 24)) * 1540483477);
                i15 = ((int) (i15 * 1540483477)) ^ ((int) (((i18 >>> 24) ^ i18) * 1540483477));
                int i19 = (int) (((bArr[i11] & 255) + ((bArr[i12] & 255) << 8) + ((bArr[i13] & 255) << 16) + ((bArr[i14] & 255) << 24)) * 1540483477);
                i17 = ((int) (i17 * 1540483477)) ^ ((int) ((i19 ^ (i19 >>> 24)) * 1540483477));
                i2 = (i2 - 4) - 4;
                i16 = i16 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1;
            }
            if (i2 >= 4) {
                int i20 = (int) (((bArr[i16] & 255) + ((bArr[i5] & 255) << 8) + ((bArr[i6] & 255) << 16) + ((bArr[i7] & 255) << 24)) * 1540483477);
                i15 = ((int) (i15 * 1540483477)) ^ ((int) (((i20 >>> 24) ^ i20) * 1540483477));
                i2 -= 4;
                i16 = i16 + 1 + 1 + 1 + 1;
            }
            if (i2 == 3) {
                i17 = (int) ((((i17 ^ ((bArr[i16 + 2] & 255) << 16)) ^ ((bArr[i16 + 1] & 255) << 8)) ^ (bArr[i16] & 255)) * 1540483477);
            }
            if (i2 == 2) {
                i17 = (int) (((i17 ^ ((bArr[i16 + 1] & 255) << 8)) ^ (bArr[i16] & 255)) * 1540483477);
            }
            if (i2 == 1) {
                i17 = (int) (((bArr[i16] & 255) ^ i17) * 1540483477);
            }
            int i21 = (int) (((i17 >>> 18) ^ i15) * 1540483477);
            int i22 = (int) (((i21 >>> 22) ^ i17) * 1540483477);
            return (((int) ((i22 ^ (i4 >>> 19)) * 1540483477)) & 4294967295L) | (((int) ((i21 ^ (i22 >>> 17)) * 1540483477)) << 32);
        }
        return invokeLII.longValue;
    }

    public static void sendRVideoLog(XAdContainerContext xAdContainerContext, int i2, int i3) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65562, null, xAdContainerContext, i2, i3) == null) {
            try {
                Context appContext = xAdContainerContext.getAppContext();
                try {
                    str = URLEncoder.encode(xAdContainerContext.getAdInstanceInfo().getClickThroughUrl(), "UTF-8");
                } catch (Exception unused) {
                    str = "";
                }
                SendLogUtil.Builder append = SendLogUtil.Builder.create(appContext).appendType(i3).appendProdType(xAdContainerContext.getAdProd()).appendAppSid(xAdContainerContext.getAppsid()).appendApId(xAdContainerContext.getAdPlacementId()).appendAdInfo(xAdContainerContext.getAdInstanceInfo()).append("mac", "");
                append.append("logtime", System.currentTimeMillis() + "").append("subtype", i2).append("curl", str).sendWithVd();
            } catch (Throwable th) {
                RemoteXAdLogger.getInstance().d(TAG, th.getMessage());
            }
        }
    }

    public static boolean isAPOOpenAvailable(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, str)) == null) {
            if (context != null) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    return packageManager.queryIntentActivities(intent, 65536).size() > 0;
                } catch (Exception e2) {
                    RemoteXAdLogger.getInstance().d(e2.getMessage());
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
