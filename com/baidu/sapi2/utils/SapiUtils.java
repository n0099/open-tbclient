package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.provider.Telephony;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.share.ShareUtils;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.kuaishou.weapon.un.s;
import com.kuaishou.weapon.un.w0;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.SimpleTimeZone;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class SapiUtils implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String COOKIE_EXPIRES_DATE_FORMAT = "EEE, dd-MMM-yyyy HH:mm:ss 'GMT'";
    public static final String COOKIE_HTTPS_URL_PREFIX = "https://";
    public static final String COOKIE_URL_PREFIX = "https://www.";
    public static final String DELIMITER2;
    public static final String DELIMITER3;
    public static final String KEY_QR_LOGIN_CMD = "cmd";
    public static final String KEY_QR_LOGIN_ENCUID = "encuid";
    public static final String KEY_QR_LOGIN_ERROR = "error";
    public static final String KEY_QR_LOGIN_LP = "lp";
    public static final String KEY_QR_LOGIN_SIGN = "sign";
    public static final int MAX_WIFI_LIST = 10;
    public static final int NETWORK_TYPE_1XRTT = 7;
    public static final int NETWORK_TYPE_CDMA = 4;
    public static final int NETWORK_TYPE_EDGE = 2;
    public static final int NETWORK_TYPE_EHRPD = 14;
    public static final int NETWORK_TYPE_EVDO_0 = 5;
    public static final int NETWORK_TYPE_EVDO_A = 6;
    public static final int NETWORK_TYPE_EVDO_B = 12;
    public static final int NETWORK_TYPE_GPRS = 1;
    public static final int NETWORK_TYPE_HSDPA = 8;
    public static final int NETWORK_TYPE_HSPA = 10;
    public static final int NETWORK_TYPE_HSPAP = 15;
    public static final int NETWORK_TYPE_HSUPA = 9;
    public static final int NETWORK_TYPE_IDEN = 11;
    public static final int NETWORK_TYPE_LTE = 13;
    public static final int NETWORK_TYPE_NR = 20;
    public static final int NETWORK_TYPE_UMTS = 3;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final String QR_LOGIN_LP_APP = "app";
    public static final String QR_LOGIN_LP_PC = "pc";
    public static String iccid;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(607552353, "Lcom/baidu/sapi2/utils/SapiUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(607552353, "Lcom/baidu/sapi2/utils/SapiUtils;");
                return;
            }
        }
        DELIMITER2 = Character.toString((char) 2);
        DELIMITER3 = Character.toString((char) 3);
    }

    public SapiUtils() {
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

    public static String buildBDUSSCookie(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
            return buildCookie(str, str2, str3, calendar.getTime(), false);
        }
        return (String) invokeLLL.objValue;
    }

    public static String buildCookie(String str, String str2, String str3, Date date, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, str3, date, Boolean.valueOf(z)})) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("=");
            sb.append(str3);
            sb.append(";domain=");
            sb.append(str);
            sb.append(";path=/;expires=");
            sb.append(simpleDateFormat.format(date));
            sb.append(";httponly");
            sb.append(z ? ";secure" : "");
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String buildCuidCookie(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            return "cuid=" + str2 + ";domain=" + str + ";path=/;httponly";
        }
        return (String) invokeLL.objValue;
    }

    public static String buildDarkModeCookie(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(5, TextUtils.isEmpty(str2) ? -1 : 1);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
            return "passtheme=" + str2 + ";domain=" + str + ";path=/;expires=" + simpleDateFormat.format(calendar.getTime());
        }
        return (String) invokeLL.objValue;
    }

    public static String buildDeviceInfoCookie(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, str2, str3)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
            return buildCookie(str, str2, str3, calendar.getTime(), true);
        }
        return (String) invokeLLL.objValue;
    }

    public static String buildIqiyiCookie(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, str, str2, str3)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(5, TextUtils.isEmpty(str3) ? -2 : 2);
            return buildCookie(str, str2, str3, calendar.getTime(), false);
        }
        return (String) invokeLLL.objValue;
    }

    public static String buildPtokenCookie(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) ? buildPtokenCookie(str, "PTOKEN", str2) : (String) invokeLL.objValue;
    }

    public static String buildSidCookie(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, str2)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(5, 7);
            return buildCookie(str, "sid", str2, calendar.getTime(), false);
        }
        return (String) invokeLL.objValue;
    }

    public static String buildStokenCookie(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(1, TextUtils.isEmpty(str2) ? -8 : 8);
            return buildCookie(str, "STOKEN", str2, calendar.getTime(), true);
        }
        return (String) invokeLL.objValue;
    }

    public static String calculateSig(Map<String, String> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, map, str)) == null) {
            map.remove(FunAdSdk.PLATFORM_SIG);
            ArrayList arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                arrayList.add(str2);
            }
            Collections.sort(arrayList);
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                try {
                    String str4 = map.get(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        sb.append(str3);
                        sb.append("=");
                        sb.append(URLEncoder.encode(str4, "UTF-8"));
                        sb.append("&");
                    }
                } catch (UnsupportedEncodingException e2) {
                    Log.e(e2);
                }
            }
            sb.append("sign_key=");
            sb.append(str);
            return SecurityUtil.md5(sb.toString().getBytes(), false);
        }
        return (String) invokeLL.objValue;
    }

    @TargetApi(23)
    public static boolean checkRequestPermission(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) != 0) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        return false;
                    }
                    if (context.checkCallingOrSelfPermission(str) != 0) {
                        return false;
                    }
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static String createRequestParams(List<PassNameValuePair> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, list)) == null) {
            StringBuilder sb = new StringBuilder();
            if (list != null) {
                for (PassNameValuePair passNameValuePair : list) {
                    if (!TextUtils.isEmpty(passNameValuePair.getName()) && !TextUtils.isEmpty(passNameValuePair.getValue())) {
                        if (TextUtils.isEmpty(sb.toString())) {
                            sb.append(passNameValuePair.getName());
                            sb.append("=");
                            sb.append(passNameValuePair.getValue());
                        } else {
                            sb.append("&");
                            sb.append(passNameValuePair.getName());
                            sb.append("=");
                            sb.append(passNameValuePair.getValue());
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static int dip2px(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65552, null, context, f2)) == null) {
            if (context != null) {
                return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
            }
            throw new IllegalArgumentException("Context can't be null");
        }
        return invokeLF.intValue;
    }

    public static Bitmap drawableToBitamp(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, drawable)) == null) {
            if (drawable == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 26 && (drawable instanceof AdaptiveIconDrawable)) {
                AdaptiveIconDrawable adaptiveIconDrawable = (AdaptiveIconDrawable) drawable;
                LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{adaptiveIconDrawable.getBackground(), adaptiveIconDrawable.getForeground()});
                Bitmap createBitmap = Bitmap.createBitmap(layerDrawable.getIntrinsicWidth(), layerDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                layerDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                layerDrawable.draw(canvas);
                return createBitmap;
            }
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return (Bitmap) invokeL.objValue;
    }

    public static String getAppName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static List<String> getAuthorizedDomains() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? SapiContext.getInstance().getAuthorizedDomains() : (List) invokeV.objValue;
    }

    public static List<String> getAuthorizedDomainsForPtoken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? SapiContext.getInstance().getAuthorizedDomainsForPtoken() : (List) invokeV.objValue;
    }

    @TargetApi(3)
    public static String getBlueToothDeviceName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            try {
                SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
                return (confignation == null || !confignation.isAgreeDangerousProtocol()) ? "" : Settings.Secure.getString(context.getContentResolver(), "bluetooth_name");
            } catch (Exception e2) {
                Log.e(e2);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getClientId(Context context) {
        InterceptResult invokeL;
        ISAccountManager isAccountManager;
        SapiConfiguration confignation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            ServiceManager serviceManager = ServiceManager.getInstance();
            if (serviceManager == null || (isAccountManager = serviceManager.getIsAccountManager()) == null || (confignation = isAccountManager.getConfignation()) == null) {
                return null;
            }
            if (confignation.isAgreeDangerousProtocol() || confignation.isSupportBrowseMode()) {
                if (TextUtils.isEmpty(confignation.clientId)) {
                    confignation.clientId = getDeviceID(context);
                }
                return confignation.clientId;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getCookie(String str, String str2) {
        InterceptResult invokeLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, str, str2)) == null) {
            try {
                CookieSyncManager.createInstance(ServiceManager.getInstance().getIsAccountManager().getConfignation().context);
                String cookie = CookieManager.getInstance().getCookie(str);
                if (TextUtils.isEmpty(cookie)) {
                    return "";
                }
                for (String str3 : cookie.split(";")) {
                    String trim = str3.trim();
                    if (!TextUtils.isEmpty(trim) && (indexOf = trim.indexOf("=")) > -1) {
                        String[] strArr = new String[2];
                        strArr[0] = trim.substring(0, indexOf);
                        int i2 = indexOf + 1;
                        if (i2 < trim.length()) {
                            strArr[1] = trim.substring(i2, trim.length());
                        }
                        if (strArr[0].equals(str2)) {
                            return strArr[1];
                        }
                    }
                }
                return "";
            } catch (Throwable th) {
                Log.e(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String getCookieBduss() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? getCookie(SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL), HttpRequest.BDUSS) : (String) invokeV.objValue;
    }

    public static String getCookiePtoken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
            String cookie = getCookie(confignation.environment.getWap(), "PTOKEN");
            return TextUtils.isEmpty(cookie) ? getCookie(confignation.environment.getURL(), "PTOKEN") : cookie;
        }
        return (String) invokeV.objValue;
    }

    public static String getCpuName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            try {
                FileReader fileReader = new FileReader("/proc/cpuinfo");
                String readLine = new BufferedReader(fileReader).readLine();
                fileReader.close();
                if (!TextUtils.isEmpty(readLine)) {
                    String[] split = readLine.split(":\\s+", 2);
                    return split.length > 1 ? split[1] : "";
                }
            } catch (FileNotFoundException e2) {
                Log.e(e2);
            } catch (IOException e3) {
                Log.e(e3);
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static List<String> getCuidAuthorizedDomains() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? SapiContext.getInstance().getCuidAuthorizedDomains() : (List) invokeV.objValue;
    }

    @TargetApi(3)
    public static String getCurProcessName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            try {
                int myPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
                return "";
            } catch (Throwable th) {
                Log.e(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean getDefaultHttpsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? SapiContext.getInstance().getDefaultHttpsEnabled() : invokeV.booleanValue;
    }

    public static String getDeviceID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            try {
                return DeviceId.getDeviceID(context);
            } catch (Throwable unused) {
                Random random = new Random();
                random.setSeed(System.currentTimeMillis());
                return "123456789" + SecurityUtil.md5(String.valueOf(random.nextInt(100)).getBytes(), false);
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getDeviceName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            try {
                return ServiceManager.getInstance().getIsAccountManager().getConfignation().deviceName;
            } catch (Exception e2) {
                Log.e(e2);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getIccid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            if (ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol()) {
                if (!TextUtils.isEmpty(iccid)) {
                    return iccid;
                }
                try {
                    if (Build.VERSION.SDK_INT >= 22) {
                        StringBuilder sb = new StringBuilder();
                        List<SubscriptionInfo> activeSubscriptionInfoList = SubscriptionManager.from(context).getActiveSubscriptionInfoList();
                        if (activeSubscriptionInfoList == null) {
                            return null;
                        }
                        for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                            if (Build.VERSION.SDK_INT >= 30) {
                                sb.append(subscriptionInfo.getSubscriptionId());
                                sb.append(DELIMITER2);
                            } else {
                                sb.append(subscriptionInfo.getIccId());
                                sb.append(DELIMITER2);
                            }
                        }
                        if (sb.length() > 0) {
                            String substring = sb.toString().substring(0, sb.length() - 1);
                            iccid = substring;
                            return substring;
                        }
                    } else {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (telephonyManager != null) {
                            String simSerialNumber = telephonyManager.getSimSerialNumber();
                            iccid = simSerialNumber;
                            return simSerialNumber;
                        }
                    }
                } catch (Exception unused) {
                }
                return null;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static long getInternalAvailableMemorySize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                return (statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1024;
            } catch (Throwable th) {
                Log.e(th);
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public static long getInternalMemorySize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                return (statFs.getBlockSize() * statFs.getBlockCount()) / 1024;
            } catch (Throwable th) {
                Log.e(th);
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public static int getLastLoginType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? Enums.LastLoginType.getValueByName(SapiContext.getInstance().getString(SapiContext.KEY_PRE_LOGIN_TYPE)) : invokeV.intValue;
    }

    public static String getLocalIpAddress() {
        String hostAddress;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            try {
                if (ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol()) {
                    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                    while (networkInterfaces.hasMoreElements()) {
                        Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement = inetAddresses.nextElement();
                            if (!nextElement.isLoopbackAddress() && (hostAddress = nextElement.getHostAddress()) != null && hostAddress.length() > 0 && (nextElement instanceof Inet4Address)) {
                                return hostAddress;
                            }
                        }
                    }
                    return null;
                }
                return null;
            } catch (Throwable th) {
                Log.e(th);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getLoginType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) ? SapiContext.getInstance().getAccountActionType() : (String) invokeV.objValue;
    }

    @TargetApi(3)
    public static String getNetworkClass(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) {
            try {
                activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Throwable th) {
                Log.e(th);
            }
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING;
                }
                if (activeNetworkInfo.getType() == 0) {
                    int subtype = activeNetworkInfo.getSubtype();
                    if (subtype != 20) {
                        switch (subtype) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                return "2G";
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                return "3G";
                            case 13:
                                return "4G";
                            default:
                                return RomUtils.UNKNOWN;
                        }
                    }
                    return "5G";
                }
                return RomUtils.UNKNOWN;
            }
            return "UNCNCT";
        }
        return (String) invokeL.objValue;
    }

    public static List<String> getPackageList(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent("baidu.intent.action.account.SHARE_SERVICE"), 32);
            if (queryIntentServices != null) {
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    if (serviceInfo != null) {
                        arrayList.add(serviceInfo.packageName);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String getPackageSign(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65576, null, context, str)) == null) {
            String str2 = "";
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                    if (packageInfo.signatures.length > 0) {
                        str2 = SecurityUtil.md5(packageInfo.signatures[0].toByteArray(), false);
                    }
                } catch (Throwable th) {
                    Log.e(th);
                }
                if (TextUtils.isEmpty(str2)) {
                    Log.d("get pgkSign error, for pkgName=" + str, new Object[0]);
                }
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static String[] getPkgIconAndName(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65577, null, context, str)) == null) {
            String[] strArr = new String[2];
            PackageManager packageManager = context.getPackageManager();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                strArr[1] = packageInfo.applicationInfo.loadLabel(packageManager).toString();
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(drawableToBitamp(packageInfo.applicationInfo.loadIcon(packageManager)), 80, 80, true);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i2 = 100;
                createScaledBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                while (byteArrayOutputStream.toByteArray().length > 524288 && i2 > 0) {
                    i2 /= 2;
                    byteArrayOutputStream.reset();
                    createScaledBitmap.compress(Bitmap.CompressFormat.PNG, i2, byteArrayOutputStream);
                }
                strArr[0] = "data:image/png;base64," + SecurityUtil.base64Encode(byteArrayOutputStream.toByteArray());
                byteArrayOutputStream.close();
            } catch (Exception e2) {
                Log.e(e2);
            }
            return strArr;
        }
        return (String[]) invokeLL.objValue;
    }

    public static String getRamMemorySize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) {
            try {
                FileReader fileReader = new FileReader("/proc/meminfo");
                String readLine = new BufferedReader(fileReader).readLine();
                fileReader.close();
                if (!TextUtils.isEmpty(readLine)) {
                    String[] split = readLine.split(":\\s+", 2);
                    return split.length > 1 ? split[1].replace("kB", "").trim() : "";
                }
            } catch (FileNotFoundException e2) {
                Log.e(e2);
            } catch (IOException e3) {
                Log.e(e3);
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static String getSmsCheckCode(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, str)) == null) {
            for (String str2 : str.replaceAll("[^0-9]*([0-9]*)[^0-9]*", "$1-").split("-")) {
                if (str2.length() == 6) {
                    return str2;
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static long getTimeSinceBoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) ? SystemClock.elapsedRealtime() / 1000 : invokeV.longValue;
    }

    public static String getVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Throwable th) {
                Log.e(th);
                return "0";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getWifiInfo(Context context) {
        InterceptResult invokeL;
        String str;
        String str2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, context)) == null) {
            String str3 = "";
            if (ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol()) {
                StringBuffer stringBuffer = new StringBuffer();
                try {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    WifiInfo connectionInfo = ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol() ? wifiManager.getConnectionInfo() : null;
                    int i3 = 0;
                    if (connectionInfo != null) {
                        i2 = StrictMath.abs(connectionInfo.getRssi());
                        str2 = connectionInfo.getSSID();
                        if (str2 != null) {
                            str2 = str2.replace("\"", "");
                        }
                        str = connectionInfo.getBSSID();
                        if (str != null) {
                            str = str.replace(":", "");
                        }
                    } else {
                        str = "";
                        str2 = str;
                        i2 = 0;
                    }
                    List<ScanResult> scanResults = checkRequestPermission(s.f57423g, context) ? wifiManager.getScanResults() : null;
                    if (scanResults != null) {
                        for (ScanResult scanResult : scanResults) {
                            String str4 = scanResult.BSSID;
                            String str5 = scanResult.SSID;
                            int abs = StrictMath.abs(scanResult.level);
                            String replace = str4 != null ? str4.replace(":", "") : "";
                            if (!replace.equals(str) && abs != 0) {
                                if (i3 >= 10) {
                                    break;
                                }
                                stringBuffer.append(DELIMITER2);
                                stringBuffer.append(replace);
                                stringBuffer.append(DELIMITER3);
                                stringBuffer.append(abs);
                                stringBuffer.append(DELIMITER3);
                                stringBuffer.append(str5);
                                stringBuffer.append(DELIMITER3);
                                stringBuffer.append("2");
                                i3++;
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        str3 = DELIMITER2 + str + DELIMITER3 + i2 + DELIMITER3 + str2 + DELIMITER3 + '1';
                    }
                } catch (Exception e2) {
                    Log.e(e2);
                }
                return str3 + stringBuffer.toString();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean hasActiveNetwork(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, context)) == null) {
            if (context == null) {
                return false;
            }
            try {
                return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
            } catch (Throwable th) {
                Log.e(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @TargetApi(3)
    public static void hideSoftInput(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65584, null, activity) == null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (!inputMethodManager.isActive() || activity.getCurrentFocus() == null || activity.getCurrentFocus().getWindowToken() == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public static boolean isAppInstalled(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65585, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                        return true;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @TargetApi(4)
    public static boolean isDebug(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, context)) == null) {
            try {
            } catch (Exception e2) {
                Log.e(e2);
            }
            return (context.getApplicationInfo().flags & 2) != 0;
        }
        return invokeL.booleanValue;
    }

    @TargetApi(4)
    public static boolean isEmulator(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65587, null, context)) != null) {
            return invokeL.booleanValue;
        }
        if (!SapiDeviceUtils.isForbidDangerousPermissionApp(context) && ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol()) {
            if (Build.VERSION.SDK_INT > 27 && context.getApplicationInfo().targetSdkVersion > 27) {
                if (checkRequestPermission(s.f57419c, context)) {
                    try {
                        str = Build.getSerial();
                    } catch (Throwable unused) {
                    }
                }
            } else {
                str = Build.SERIAL;
            }
            return !"000000000000000".equals(SapiDeviceUtils.getIMEI(context)) || Build.FINGERPRINT.contains("test-keys") || Build.FINGERPRINT.startsWith("unknown") || Build.BRAND.startsWith("generic") || Build.BOARD.equals("unknown") || "unknown".equals(str);
        }
        str = null;
        if ("000000000000000".equals(SapiDeviceUtils.getIMEI(context))) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isExecutable(String str) {
        InterceptResult invokeL;
        Process process;
        Process exec;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65588, null, str)) != null) {
            return invokeL.booleanValue;
        }
        BufferedReader bufferedReader = null;
        try {
            if ("/system/bin/su".equals(str)) {
                exec = Runtime.getRuntime().exec("ls -l /system/bin/su");
            } else {
                exec = "/system/xbin/su".equals(str) ? Runtime.getRuntime().exec("ls -l /system/xbin/su") : null;
            }
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null && readLine.length() >= 4) {
                        char charAt = readLine.charAt(3);
                        if (charAt == 's' || charAt == 'x') {
                            try {
                                bufferedReader2.close();
                            } catch (Exception e2) {
                                Log.e(e2);
                            }
                            if (exec != null) {
                                exec.destroy();
                            }
                            return true;
                        }
                    }
                    try {
                        bufferedReader2.close();
                    } catch (Exception e3) {
                        Log.e(e3);
                    }
                    if (exec != null) {
                        exec.destroy();
                        return false;
                    }
                    return false;
                } catch (IOException e4) {
                    process = exec;
                    e = e4;
                    bufferedReader = bufferedReader2;
                    try {
                        Log.e(e);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e5) {
                                Log.e(e5);
                            }
                        }
                        if (process != null) {
                            process.destroy();
                            return false;
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e6) {
                                Log.e(e6);
                            }
                        }
                        if (process != null) {
                            process.destroy();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    process = exec;
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    if (process != null) {
                    }
                    throw th;
                }
            } catch (IOException e7) {
                process = exec;
                e = e7;
            } catch (Throwable th3) {
                process = exec;
                th = th3;
            }
        } catch (IOException e8) {
            e = e8;
            process = null;
        } catch (Throwable th4) {
            th = th4;
            process = null;
        }
    }

    public static boolean isMethodOverWrited(Object obj, String str, Class cls, Class... clsArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65589, null, obj, str, cls, clsArr)) == null) ? !cls.equals(obj.getClass().getMethod(str, clsArr).getDeclaringClass()) : invokeLLLL.booleanValue;
    }

    public static boolean isOauthQrLoginSchema(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.contains("qrsign") && str.contains("scope") && str.contains("channelid") && str.contains("client_id")) {
                Map<String, String> urlParamsToMap = urlParamsToMap(str);
                return (TextUtils.isEmpty(urlParamsToMap.get("qrsign")) || TextUtils.isEmpty(urlParamsToMap.get("scope")) || TextUtils.isEmpty(urlParamsToMap.get("channelid")) || TextUtils.isEmpty(urlParamsToMap.get("client_id"))) ? false : true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @TargetApi(4)
    public static boolean isOnline(SapiConfiguration sapiConfiguration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, sapiConfiguration)) == null) {
            Context context = sapiConfiguration.context;
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                return false;
            }
            if (packageName.matches("com.baidu.sapi2.(.*)")) {
                return true;
            }
            if (isDebug(context)) {
                Log.e(ShareUtils.TAG, "isDebug=true  isSupportDebugShareLogin=" + sapiConfiguration.isSupportDebugShareLogin);
                return sapiConfiguration.isSupportDebugShareLogin;
            }
            Map<String, String> authorizedPackages = SapiContext.getInstance().getAuthorizedPackages();
            String packageSign = getPackageSign(context, packageName);
            for (String str : authorizedPackages.keySet()) {
                if (packageName.matches(str) && packageSign.equals(authorizedPackages.get(str))) {
                    return true;
                }
            }
            Log.e(ShareUtils.TAG, "share: don't have match pkg");
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String[] isQrArtificialAppeal(String str) {
        InterceptResult invokeL;
        Domain environment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, str)) == null) {
            String host = Uri.parse(ServiceManager.getInstance().getIsAccountManager().getConfignation().getEnvironment().getWap()).getHost();
            Uri parse = Uri.parse(str);
            String str2 = Uri.parse(environment.getWap()).getHost() + "/v3/getpass/artificialappeal";
            if (!TextUtils.isEmpty(str) && str.contains(str2)) {
                String[] strArr = {Uri.decode(parse.getQueryParameter("title")), Uri.decode(parse.getQueryParameter("url"))};
                Uri parse2 = Uri.parse(strArr[1]);
                if (!TextUtils.isEmpty(strArr[1]) && host.equals(parse2.getHost())) {
                    return strArr;
                }
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    public static boolean isQrLoginEnuidSchema(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, null, str)) == null) {
            if (isOauthQrLoginSchema(str)) {
                return true;
            }
            if (TextUtils.isEmpty(str) || !str.contains(KEY_QR_LOGIN_ENCUID)) {
                return false;
            }
            return !TextUtils.isEmpty(urlParamsToMap(str).get(KEY_QR_LOGIN_ENCUID));
        }
        return invokeL.booleanValue;
    }

    public static boolean isQrLoginSchema(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, null, str)) == null) {
            if (isOauthQrLoginSchema(str)) {
                return true;
            }
            if (!TextUtils.isEmpty(str) && str.contains("error") && str.contains("sign") && str.contains("cmd") && str.contains(KEY_QR_LOGIN_LP)) {
                Map<String, String> urlParamsToMap = urlParamsToMap(str);
                return (TextUtils.isEmpty(urlParamsToMap.get("error")) || TextUtils.isEmpty(urlParamsToMap.get("sign")) || TextUtils.isEmpty(urlParamsToMap.get("cmd")) || TextUtils.isEmpty(urlParamsToMap.get(KEY_QR_LOGIN_LP))) ? false : true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65595, null)) == null) ? (new File("/system/bin/su").exists() && isExecutable("/system/bin/su")) || (new File("/system/xbin/su").exists() && isExecutable("/system/xbin/su")) : invokeV.booleanValue;
    }

    public static boolean isValidPhoneNumber(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65596, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return Pattern.compile("^(1)\\d{10}$").matcher(str).matches();
        }
        return invokeL.booleanValue;
    }

    public static boolean isValidUsername(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65597, null, str)) == null) ? !TextUtils.isEmpty(str) && str.length() <= 14 : invokeL.booleanValue;
    }

    public static JSONArray map2JsonArray(Map<String, Long> map, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65598, null, map, str, str2)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, Long> entry : map.entrySet()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        try {
                            jSONObject.put(str, entry.getKey());
                            jSONObject.put(str2, entry.getValue());
                        } catch (JSONException unused) {
                        }
                    }
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeLLL.objValue;
    }

    public static String mapToUrlParams(Map<String, String> map, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65599, null, map, z)) == null) {
            if (map == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (sb.length() <= 0 && !z) {
                    sb.append("?");
                } else {
                    sb.append("&");
                }
                if (value == null) {
                    try {
                        sb.append(key);
                        sb.append("=");
                    } catch (Exception e2) {
                        sb.append(key);
                        sb.append("=");
                        sb.append((Object) value);
                        e2.printStackTrace();
                    }
                } else {
                    sb.append(key);
                    sb.append("=");
                    sb.append(URLEncoder.encode(value.toString(), "UTF-8"));
                }
            }
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public static void notEmpty(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65600, null, str, str2) == null) && TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void notNull(Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65601, null, obj, str) == null) && obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static String parseQrFaceAuthSchema(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65602, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String[] strArr = {"ucenter/qrlivingnav", "url", "tpl"};
            for (int i2 = 0; i2 < 3; i2++) {
                if (!str.contains(strArr[i2])) {
                    return null;
                }
            }
            return URLDecoder.decode(str.substring(str.indexOf("url=") + 4, str.length()));
        }
        return (String) invokeL.objValue;
    }

    public static Map<String, String> parseQrLoginSchema(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65603, null, str)) == null) {
            HashMap hashMap = new HashMap();
            if (isOauthQrLoginSchema(str)) {
                hashMap.put(KEY_QR_LOGIN_LP, "pc");
                return hashMap;
            } else if (isQrLoginSchema(str)) {
                Map<String, String> urlParamsToMap = urlParamsToMap(str);
                if ("pc".equals(urlParamsToMap.get(KEY_QR_LOGIN_LP))) {
                    HashMap hashMap2 = new HashMap();
                    if (ServiceManager.getInstance().getIsAccountManager().getSession() == null) {
                        hashMap2.put("islogin", "0");
                    } else {
                        hashMap2.put("islogin", "1");
                    }
                    hashMap2.put("client", "android");
                    StatService.onEvent(StatService.STAT_ENENT_QR_LOGIN_ENTER, hashMap2);
                }
                return urlParamsToMap;
            } else {
                return hashMap;
            }
        }
        return (Map) invokeL.objValue;
    }

    public static int px2sp(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65604, null, context, f2)) == null) ? (int) ((f2 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f) : invokeLF.intValue;
    }

    public static void sendSms(Context context, String str, List<String> list) {
        String defaultSmsPackage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65605, null, context, str, list) == null) {
            String join = (list == null || list.isEmpty()) ? "" : TextUtils.join(w0.w1.equalsIgnoreCase(Build.MANUFACTURER) ? "," : ";", list);
            Uri parse = Uri.parse("smsto:" + join);
            Intent intent = new Intent();
            intent.setData(parse);
            intent.putExtra("sms_body", str);
            intent.setAction("android.intent.action.SENDTO");
            if (Build.VERSION.SDK_INT >= 19 && (defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(context)) != null) {
                intent.setPackage(defaultSmsPackage);
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            try {
                context.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean statExtraValid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65606, null, str)) == null) ? !TextUtils.isEmpty(str) && str.getBytes().length <= SapiContext.getInstance().getLoginStatExtraLimitLen() : invokeL.booleanValue;
    }

    public static void syncCookies(Context context, List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65607, null, context, list) == null) {
            CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
            List<String> cuidAuthorizedDomains = getCuidAuthorizedDomains();
            if (confignation.getEnvironment() != Domain.DOMAIN_ONLINE) {
                String replaceAll = confignation.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
                String replaceAll2 = confignation.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
                cuidAuthorizedDomains.add(replaceAll);
                cuidAuthorizedDomains.add(replaceAll2);
            }
            for (String str : cuidAuthorizedDomains) {
                cookieManager.setCookie("https://" + str, buildCuidCookie(str, getClientId(context)));
                String searchBoxSid = SapiContext.getInstance().getSearchBoxSid();
                if (!TextUtils.isEmpty(searchBoxSid)) {
                    cookieManager.setCookie("https://" + str, buildSidCookie(str, searchBoxSid));
                }
            }
            if (list != null) {
                for (PassNameValuePair passNameValuePair : list) {
                    if (!TextUtils.isEmpty(passNameValuePair.getName()) && !TextUtils.isEmpty(passNameValuePair.getValue())) {
                        cookieManager.setCookie(passNameValuePair.getName(), passNameValuePair.getValue());
                    }
                }
            }
            if (Build.VERSION.SDK_INT < 21) {
                CookieSyncManager.getInstance().sync();
            } else {
                cookieManager.flush();
            }
        }
    }

    public static Map<String, String> urlParamsToMap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65608, null, str)) == null) {
            HashMap hashMap = new HashMap();
            if (TextUtils.isEmpty(str)) {
                return hashMap;
            }
            if (str.contains("?")) {
                try {
                    str = str.substring(str.indexOf("?") + 1, str.length());
                } catch (Exception e2) {
                    Log.e(e2);
                }
            }
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (split.length == 2) {
                    hashMap.put(split[0], split[1]);
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static boolean validateMobile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65609, null, str)) == null) ? Pattern.compile("1[3456789]\\d{9}").matcher(str).matches() : invokeL.booleanValue;
    }

    public static int versionCompareTo(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65610, null, str, str2)) == null) {
            String replaceAll = TextUtils.isEmpty(str) ? "0" : str.replaceAll("[^\\d\\.]+", "");
            String replaceAll2 = TextUtils.isEmpty(str2) ? "0" : str2.replaceAll("[^\\d\\.]+", "");
            String[] split = replaceAll.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            String[] split2 = replaceAll2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (String str3 : split) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str3)));
            }
            for (String str4 : split2) {
                arrayList2.add(Integer.valueOf(Integer.parseInt(str4)));
            }
            int size = arrayList.size() > arrayList2.size() ? arrayList.size() : arrayList2.size();
            while (arrayList.size() < size) {
                arrayList.add(0);
            }
            while (arrayList2.size() < size) {
                arrayList2.add(0);
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (((Integer) arrayList.get(i2)).intValue() > ((Integer) arrayList2.get(i2)).intValue()) {
                    return 1;
                }
                if (((Integer) arrayList.get(i2)).intValue() < ((Integer) arrayList2.get(i2)).intValue()) {
                    return -1;
                }
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static boolean webLogin(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65611, null, context, str)) == null) ? ServiceManager.getInstance().getIsAccountManager().getIsAccountService().webLogin(context, str) : invokeLL.booleanValue;
    }

    public static boolean webLogout(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65613, null, context)) == null) {
            if (context == null) {
                return false;
            }
            try {
                ArrayList arrayList = new ArrayList();
                for (String str : getAuthorizedDomains()) {
                    arrayList.add(new PassNameValuePair(COOKIE_URL_PREFIX + str, buildBDUSSCookie(str, "")));
                }
                for (String str2 : getAuthorizedDomainsForPtoken()) {
                    arrayList.add(new PassNameValuePair(COOKIE_URL_PREFIX + str2, buildPtokenCookie(str2, "")));
                    arrayList.add(new PassNameValuePair("https://" + str2, buildPtokenCookie(str2, "")));
                }
                for (String str3 : getAuthorizedDomainsForPtoken()) {
                    arrayList.add(new PassNameValuePair("https://" + str3, buildStokenCookie(str3, "")));
                }
                syncCookies(context, arrayList);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String buildPtokenCookie(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, str, str2, str3)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
            return buildCookie(str, str2, str3, calendar.getTime(), true);
        }
        return (String) invokeLLL.objValue;
    }

    public static boolean webLogin(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65612, null, context, str, str2)) == null) ? ServiceManager.getInstance().getIsAccountManager().getIsAccountService().webLogin(context, str, str2) : invokeLLL.booleanValue;
    }

    public static String buildBDUSSCookie(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) ? buildBDUSSCookie(str, HttpRequest.BDUSS, str2) : (String) invokeLL.objValue;
    }
}
