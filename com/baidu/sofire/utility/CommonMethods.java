package com.baidu.sofire.utility;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.XmlResourceParser;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.sofire.BaiduLog;
import com.baidu.sofire.MyProvider;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.ForHostApp;
import com.baidu.sofire.core.PluginloaderHub;
import com.baidu.sofire.d.D;
import com.baidu.sofire.rp.Report;
import com.baidu.sofire.rp.RpConstant;
import com.baidu.sofire.rp.config.ReportConfigInfo;
import com.baidu.sofire.rp.info.ReportItemInfo;
import com.baidu.sofire.rp.network.engine.ReportEngine;
import com.baidu.sofire.rp.receiver.Receiver;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UVEventType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CommonMethods {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALLOW_MUTI_PROCESS_FLAG_FILE_NAME = "ampf";
    public static final String ANDROID_MANIFEST_FILENAME = "AndroidManifest.xml";
    public static final String ANDROID_NAMESPACE = "http://schemas.android.com/apk/res/android";
    public static String APPKEY_DEFULT = "3";
    public static final String FLAG_FILE_NAME = "flg";
    public static final String LIANTIAN = "liantian";
    public static final String PKGNAME_HUAWEI_INPUT = "com.baidu.input_huawei";
    public static final String PKGNAME_SKIP_CHECK_INPUT = "com.baidu.input";
    public static String SECKEY_DEFULT = "925fc15df8a49bed0b3eca8d2b44cb7b";
    public static String sAppKey = null;
    public static int sComponentStatus = -1;
    public static String sCurrentProcessName = "";
    public static int sDebugMode = -1;
    public static HashMap<Integer, ApkInfo> sLocalCheckMap = null;
    public static int sMainProcessFlag = -1;
    public static boolean sNeedCheckConnectivity = false;
    public static MyReceiver sNetWorkReceiver = null;
    public static String sProviderProcessname = "";
    public static int sProviderstatus = -1;
    public static int sRequestWholeErrorCode = 0;
    public static long sSdkInitTimeStamp = 0;
    public static String sSecKey = null;
    public static String sServiceProcessName = "";
    public static String sServiceProcessName2 = "";
    public static JSONObject wholeRequestInfo;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(17530054, "Lcom/baidu/sofire/utility/CommonMethods;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(17530054, "Lcom/baidu/sofire/utility/CommonMethods;");
        }
    }

    public CommonMethods() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String buildComponentErrorLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("1", sComponentStatus);
                jSONObject.put("2", sProviderProcessname);
                jSONObject.put("3", sCurrentProcessName);
                jSONObject.put("4", sServiceProcessName);
                jSONObject.put("5", sServiceProcessName2);
                return jSONObject.toString();
            } catch (Throwable th) {
                handleNuLException(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static synchronized JSONArray buildLocalPluginInfo(Context context) {
        InterceptResult invokeL;
        ApkInfo pluginByID;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (CommonMethods.class) {
                try {
                    SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
                    String loadPropertiesFromAssets = loadPropertiesFromAssets(context, "sofire_local.cfg", "local");
                    if (TextUtils.isEmpty(loadPropertiesFromAssets)) {
                        return null;
                    }
                    JSONArray jSONArray = new JSONArray(loadPropertiesFromAssets);
                    if (sLocalCheckMap == null) {
                        sLocalCheckMap = new HashMap<>();
                    } else {
                        sLocalCheckMap.clear();
                    }
                    ArrayList<ApkInfo> arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        String optString = optJSONObject.optString("pkgname");
                        String optString2 = optJSONObject.optString("version");
                        int optInt = optJSONObject.optInt("id");
                        if (optInt > 0) {
                            arrayList2.add(Integer.valueOf(optInt));
                        }
                        String optString3 = optJSONObject.optString(PackageTable.MD5);
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && optInt > 0) {
                            String localLoadPluginVersion = sharedPreferenceManager.getLocalLoadPluginVersion(optInt);
                            boolean z = true;
                            boolean z2 = (TextUtils.isEmpty(localLoadPluginVersion) || compareVersionNotEquals(optString2, localLoadPluginVersion)) ? false : true;
                            if (z2 || (pluginByID = D.getInstance(context).getPluginByID(optInt)) == null || compareVersion(optString2, pluginByID.versionName) || pluginByID.initStatus != 1) {
                                z = z2;
                            }
                            String lowerCase = optString3.toLowerCase();
                            ApkInfo apkInfo = new ApkInfo();
                            apkInfo.packageName = optString;
                            apkInfo.versionName = optString2;
                            apkInfo.key = optInt;
                            apkInfo.apkMD5 = lowerCase;
                            if (z) {
                                arrayList.add(apkInfo);
                            } else {
                                sLocalCheckMap.put(Integer.valueOf(optInt), apkInfo);
                            }
                        }
                    }
                    sharedPreferenceManager.setLocalSetPluginKeys(arrayList2);
                    if (sLocalCheckMap.size() > 0 || arrayList.size() > 0) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (ApkInfo apkInfo2 : sLocalCheckMap.values()) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(PushConstants.URI_PACKAGE_NAME, apkInfo2.packageName);
                            jSONObject.put("m", apkInfo2.apkMD5);
                            jSONObject.put("l", apkInfo2.key);
                            jSONObject.put("v", apkInfo2.versionName);
                            jSONArray2.put(jSONObject);
                        }
                        for (ApkInfo apkInfo3 : arrayList) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(PushConstants.URI_PACKAGE_NAME, apkInfo3.packageName);
                            jSONObject2.put("m", apkInfo3.apkMD5);
                            jSONObject2.put("l", apkInfo3.key);
                            jSONObject2.put("v", apkInfo3.versionName);
                            jSONArray2.put(jSONObject2);
                        }
                        return jSONArray2;
                    }
                    return null;
                } catch (Throwable th) {
                    handleNuLException(th);
                    return null;
                }
            }
        }
        return (JSONArray) invokeL.objValue;
    }

    public static Object callMethodOfClass(Object obj, String str, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, str, clsArr, objArr)) == null) {
            if (obj != null && !TextUtils.isEmpty(str)) {
                if (clsArr != null && objArr != null && clsArr.length != objArr.length) {
                    throw new NoSuchMethodException("paramTypes or args fail");
                }
                Method[] declaredMethods = obj.getClass().getDeclaredMethods();
                Method method = null;
                int length = declaredMethods.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Method method2 = declaredMethods[i];
                    if (isTargetMethod(method2, str, clsArr)) {
                        method = method2;
                        break;
                    }
                    i++;
                }
                if (method != null) {
                    return method.invoke(obj, objArr);
                }
                throw new NoSuchMethodException("cannot find method in target methodName=" + str);
            }
            throw new NoSuchMethodException("object=" + obj + ", methodName=" + str);
        }
        return invokeLLLL.objValue;
    }

    public static boolean checkComponent(Context context, String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            boolean z3 = false;
            ResolveInfo resolveInfo = null;
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context.getPackageName(), MyService.class.getCanonicalName()));
                resolveInfo = context.getPackageManager().resolveService(intent, 0);
                if (resolveInfo != null && resolveInfo.serviceInfo != null) {
                    sServiceProcessName = resolveInfo.serviceInfo.processName;
                    if (str.equals(resolveInfo.serviceInfo.processName)) {
                        z3 = true;
                    }
                }
            } catch (Throwable th) {
                handleNuLException(th);
            }
            if (resolveInfo == null) {
                try {
                    String componentProcessNameFromManifest = getComponentProcessNameFromManifest(context, str, "service");
                    sServiceProcessName2 = componentProcessNameFromManifest;
                    if (str.equals(componentProcessNameFromManifest)) {
                        z3 = true;
                    }
                } catch (Throwable th2) {
                    handleNuLException(th2);
                }
            }
            if (TextUtils.isEmpty(sCurrentProcessName)) {
                sCurrentProcessName = getProcessName(Process.myPid());
            }
            if (z2 && sCurrentProcessName.equals(str) && (!z3 || z)) {
                HashMap hashMap = new HashMap();
                if (!z3) {
                    hashMap.put("0", Integer.toString(2));
                } else if (!z3) {
                    hashMap.put("0", Integer.toString(1));
                }
                if (z) {
                    hashMap.put("1", "0");
                }
                sendEventUDC(context, "1003140", hashMap, true);
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    public static synchronized boolean checkComponentStatus(Context context, boolean z) {
        InterceptResult invokeLZ;
        boolean checkComponent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, context, z)) == null) {
            synchronized (CommonMethods.class) {
                try {
                    if (sComponentStatus != -1) {
                        return sComponentStatus == 1;
                    }
                    String providerProcessName = getProviderProcessName(context);
                    if (TextUtils.isEmpty(providerProcessName)) {
                        checkComponent = checkComponent(context, context.getPackageName(), true, z);
                    } else {
                        checkComponent = checkComponent(context, providerProcessName, false, z);
                    }
                    if (checkComponent) {
                        sComponentStatus = 1;
                    } else {
                        sComponentStatus = 0;
                    }
                    return checkComponent;
                } catch (Throwable th) {
                    handleNuLException(th);
                    return false;
                }
            }
        }
        return invokeLZ.booleanValue;
    }

    public static void checkDebugRight(Context context) throws UnsupportedOperationException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, context) == null) && isDebugMode(context) && !PKGNAME_SKIP_CHECK_INPUT.equals(context.getPackageName())) {
            StringBuilder sb = new StringBuilder("SDK Self Check: ");
            int length = sb.length();
            try {
                System.loadLibrary("fire");
            } catch (Throwable unused) {
                sb.append("LoadLibrary Error,");
            }
            try {
                Class.forName(RpConstant.REFLECT_CLASS_F_NAME).getDeclaredMethod("getInstance", new Class[0]);
            } catch (Exception unused2) {
                sb.append("Proguard Error,");
            }
            try {
                boolean z = context.getPackageManager().resolveContentProvider(context.getPackageName() + ".sofire.ac.provider", 0).multiprocess;
            } catch (Throwable unused3) {
                sb.append("Provider Error,");
            }
            if (!checkComponentStatus(context, false)) {
                sb.append("Service or Receiver Error.");
            }
            if (sb.length() > length) {
                throw new UnsupportedOperationException(sb.toString());
            }
        }
    }

    public static boolean checkFlagFile(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            try {
                File file = new File(context.getFilesDir(), ".tmp");
                if (!file.exists()) {
                    file.mkdir();
                }
                return !new File(file, str).exists();
            } catch (Throwable th) {
                handleNuLException(th);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean checkNetwork(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, context, i)) == null) {
            if (i != 1 || isWifiAvailable(context)) {
                return true;
            }
            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            if (sNetWorkReceiver == null) {
                sNetWorkReceiver = new MyReceiver().setOnlyNetSelf();
            }
            registerReceiver(context, sNetWorkReceiver, intentFilter);
            sNeedCheckConnectivity = true;
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static int checkProcessAuth(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            try {
                String providerProcessName = getProviderProcessName(context);
                if (TextUtils.isEmpty(sCurrentProcessName)) {
                    sCurrentProcessName = getProcessName(Process.myPid());
                }
                if (TextUtils.isEmpty(sCurrentProcessName)) {
                    return 0;
                }
                return !TextUtils.isEmpty(providerProcessName) ? providerProcessName.equals(sCurrentProcessName) ? 1 : 2 : context.getPackageName().equals(sCurrentProcessName) ? 3 : 4;
            } catch (Throwable th) {
                handleNuLException(th);
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static void checkRedressKey(Context context, JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, jSONObject) == null) {
            try {
                SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
                String[] aPPKeyAndSecurityKeyFromHost = getAPPKeyAndSecurityKeyFromHost(context);
                boolean z = false;
                if (sharedPreferenceManager.getAppKeySwitch() == 1 && (aPPKeyAndSecurityKeyFromHost == null || aPPKeyAndSecurityKeyFromHost.length != 2 || TextUtils.isEmpty(aPPKeyAndSecurityKeyFromHost[0]) || TextUtils.isEmpty(aPPKeyAndSecurityKeyFromHost[1]))) {
                    z = true;
                }
                if (!z || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("2")) == null) {
                    return;
                }
                String optString = optJSONObject.optString("0");
                String optString2 = optJSONObject.optString("1");
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    return;
                }
                ForHostApp.getInstance(context).setSecurityVerifyInfo(optString, optString2);
            } catch (Throwable th) {
                handleNuLException(th);
            }
        }
    }

    public static boolean chmodFileExecable(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.length() != 3 || !new File(str2).exists()) {
                return false;
            }
            try {
                Runtime runtime = Runtime.getRuntime();
                runtime.exec("chmod " + str + " " + str2 + "\n").waitFor();
                return true;
            } catch (Throwable th) {
                handleNuLException(th);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean compareVersion(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                    String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                    for (int i = 0; i < split.length && i < split2.length; i++) {
                        int intValue = Integer.valueOf(split[i]).intValue() - Integer.valueOf(split2[i]).intValue();
                        if (intValue != 0) {
                            return intValue > 0;
                        }
                    }
                    if (split.length > split2.length) {
                        return true;
                    }
                } catch (Throwable unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean compareVersionNotEquals(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, str2)) == null) ? (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2)) ? false : true : invokeLL.booleanValue;
    }

    public static Class<?> convertBackPrimitiveType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            try {
                if (str.contains(Integer.class.getCanonicalName())) {
                    return Integer.TYPE;
                }
                if (str.contains(Boolean.class.getCanonicalName())) {
                    return Boolean.TYPE;
                }
                if (str.contains(Character.class.getCanonicalName())) {
                    return Character.TYPE;
                }
                if (str.contains(Byte.class.getCanonicalName())) {
                    return Byte.TYPE;
                }
                if (str.contains(Short.class.getCanonicalName())) {
                    return Short.TYPE;
                }
                if (str.contains(Long.class.getCanonicalName())) {
                    return Long.TYPE;
                }
                if (str.contains(Float.class.getCanonicalName())) {
                    return Float.TYPE;
                }
                if (str.contains(Double.class.getCanonicalName())) {
                    return Double.TYPE;
                }
                return null;
            } catch (Throwable th) {
                handleNuLException(th);
                return null;
            }
        }
        return (Class) invokeL.objValue;
    }

    public static String convertPrimitiveType(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, cls)) == null) {
            try {
                if (cls.getCanonicalName().equals(Integer.TYPE.getCanonicalName())) {
                    return Integer.class.getCanonicalName();
                }
                if (cls.getCanonicalName().equals(Boolean.TYPE.getCanonicalName())) {
                    return Boolean.class.getCanonicalName();
                }
                if (cls.getCanonicalName().equals(Character.TYPE.getCanonicalName())) {
                    return Character.class.getCanonicalName();
                }
                if (cls.getCanonicalName().equals(Byte.TYPE.getCanonicalName())) {
                    return Byte.class.getCanonicalName();
                }
                if (cls.getCanonicalName().equals(Short.TYPE.getCanonicalName())) {
                    return Short.class.getCanonicalName();
                }
                if (cls.getCanonicalName().equals(Long.TYPE.getCanonicalName())) {
                    return Long.class.getCanonicalName();
                }
                if (cls.getCanonicalName().equals(Float.TYPE.getCanonicalName())) {
                    return Float.class.getCanonicalName();
                }
                if (cls.getCanonicalName().equals(Double.TYPE.getCanonicalName())) {
                    return Double.class.getCanonicalName();
                }
                return null;
            } catch (Throwable th) {
                handleNuLException(th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void copyFile(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65554, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        copyFile(new File(str), new File(str2));
    }

    public static JSONObject createAliveOrInstall(Context context, ReportConfigInfo reportConfigInfo, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{context, reportConfigInfo, str, Boolean.valueOf(z)})) == null) {
            return createBaseLog(context, reportConfigInfo.sdkName, reportConfigInfo.sdkVersion, z ? reportConfigInfo.aliveLogId : reportConfigInfo.installLogId, str);
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject createBaseLog(Context context, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65556, null, context, str, str2, str3, str4)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("0", System.currentTimeMillis());
                jSONObject2.put("1", "0");
                jSONObject2.put("2", "0");
                String[] selectAppKeyAndSecurityKey = selectAppKeyAndSecurityKey(context);
                if (selectAppKeyAndSecurityKey != null && selectAppKeyAndSecurityKey.length == 2) {
                    jSONObject2.put("3", selectAppKeyAndSecurityKey[0]);
                } else {
                    jSONObject2.put("3", APPKEY_DEFULT);
                }
                jSONObject2.put("4", 0);
                jSONObject2.put("5", 0);
                jSONObject2.put("6", 1);
                jSONObject2.put("7", 0);
                jSONObject2.put("8", str);
                jSONObject2.put("9", str2);
                jSONObject2.put("10", str3);
                JSONObject jSONObject3 = new JSONObject();
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject3 = new JSONObject(str4);
                }
                jSONObject.put("Common_section", jSONObject2);
                jSONObject.put("Module_section", jSONObject3);
            } catch (Throwable th) {
                handleNuLException(th);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLLLL.objValue;
    }

    public static JSONObject createLog(Context context, JSONObject jSONObject) {
        InterceptResult invokeLL;
        JSONObject jSONObject2;
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, jSONObject)) == null) {
            JSONObject jSONObject3 = new JSONObject();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                jSONObject2 = jSONObject.getJSONObject("Common_section");
            } catch (Throwable th) {
                handleNuLException(th);
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                String optString = jSONObject2.optString("10");
                j = jSONObject2.optLong("0");
                String optString2 = jSONObject2.optString("1");
                String optString3 = jSONObject2.optString("3");
                str5 = jSONObject2.optString("8");
                str4 = optString3;
                str3 = optString2;
                str2 = optString;
                str = jSONObject2.optString("9");
            } else {
                j = currentTimeMillis;
                str = "";
                str2 = str;
                str3 = str2;
                str4 = str3;
                str5 = str4;
            }
            try {
                jSONObject3.put("1", context.getApplicationInfo().loadLabel(context.getPackageManager()).toString());
                jSONObject3.put("2", context.getPackageName());
                jSONObject3.put("3", VersionUtil.getVersionName(context));
                jSONObject3.put("4", DbUtil.getCUID(context));
                jSONObject3.put("5", str2);
                jSONObject3.put("6", j);
                jSONObject3.put("7", str3);
                jSONObject3.put("8", str4);
                jSONObject3.put("9", str5);
                jSONObject3.put("10", str);
                SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
                jSONObject3.put("11", sharedPreferenceManager.getClientVersion());
                jSONObject3.put("12", sharedPreferenceManager.getLocalChannel());
                jSONObject3.put("13", 1);
                if (getCurrNetworkType(context) == 4) {
                    jSONObject3.put("14", 1);
                } else {
                    jSONObject3.put("14", 2);
                }
                jSONObject3.put(Constants.VIA_ACT_TYPE_TWENTY_EIGHT, NewUid.getNewUid(context));
                if (DoubleListUtil.isBaiduGroup(context)) {
                    jSONObject3.put("23", getHostCuid(context));
                } else {
                    jSONObject3.put("23", "");
                    jSONObject3.put(UVEventType.PAY_WALLET_BANNER_SHOW, PrivacyOperationUtil.getSettingCuid(context));
                    jSONObject3.put("21", PrivacyOperationUtil.getExternalCuid(context));
                    jSONObject3.put("32", getSelfCuid(context));
                }
                Object obj = jSONObject.get("Module_section");
                if (obj instanceof JSONArray) {
                    jSONObject3.put("module_section", obj);
                } else {
                    jSONObject3.put("module_section", new JSONArray().put(obj));
                }
                return jSONObject3;
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static String decodeString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            try {
                String str2 = new String(EncryptUtil.aesDecrypt("30212102dicudiab".getBytes(), Base64.decode(str, 10), true), "UTF-8");
                return !TextUtils.isEmpty(str2) ? str2 : "";
            } catch (Throwable th) {
                handleNuLException(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void deleteDir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                File file = new File(str);
                if (file.exists()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        for (File file2 : listFiles) {
                            if (file2.isDirectory()) {
                                deleteDir(file2.getAbsolutePath());
                            } else {
                                file2.delete();
                            }
                        }
                    }
                    file.delete();
                }
            } catch (Throwable th) {
                handleNuLException(th);
            }
        }
    }

    public static void ensureQuanxian(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65561, null, str, z) == null) {
            chmodFileExecable("771", str);
            if (z) {
                chmodFileExecable("771", new File(str).getParentFile().getAbsolutePath());
            }
        }
    }

    public static String[] getAPPKeyAndSecurityKeyFromHost(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            if (TextUtils.isEmpty(sAppKey) || TextUtils.isEmpty(sSecKey)) {
                String securityVerifyInfo = SharedPreferenceManager.getInstance(context).getSecurityVerifyInfo();
                if (TextUtils.isEmpty(securityVerifyInfo)) {
                    return new String[0];
                }
                String[] split = securityVerifyInfo.split("-");
                if (split == null || split.length != 2) {
                    return new String[0];
                }
                sAppKey = split[0];
                sSecKey = split[1];
                return split;
            }
            return new String[]{sAppKey, sSecKey};
        }
        return (String[]) invokeL.objValue;
    }

    public static String getComponentProcessNameFromManifest(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        int next;
        String attributeValue;
        String canonicalName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65563, null, context, str, str2)) == null) {
            try {
                XmlResourceParser openXmlResourceParser = context.createPackageContext(context.getPackageName(), 3).getAssets().openXmlResourceParser(ANDROID_MANIFEST_FILENAME);
                if (openXmlResourceParser != null) {
                    do {
                        next = openXmlResourceParser.next();
                        if (next == 2) {
                            break;
                        }
                    } while (next != 1);
                    if (next == 2 && openXmlResourceParser.getName().equals("manifest") && (attributeValue = openXmlResourceParser.getAttributeValue(null, "package")) != null && attributeValue.length() != 0) {
                        if (validateName(attributeValue, true) != null && !"android".equals(attributeValue)) {
                            return null;
                        }
                        if (str2.equals("provider")) {
                            canonicalName = MyProvider.class.getCanonicalName();
                        } else if (str2.equals("service")) {
                            canonicalName = MyService.class.getCanonicalName();
                        } else {
                            canonicalName = str2.equals(SocialConstants.PARAM_RECEIVER) ? MyReceiver.class.getCanonicalName() : null;
                        }
                        while (true) {
                            int next2 = openXmlResourceParser.next();
                            if (next2 == 1) {
                                break;
                            } else if (next2 == 2) {
                                String name = openXmlResourceParser.getName();
                                if ("provider".equals(name)) {
                                    if (openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name").equals(canonicalName)) {
                                        String attributeValue2 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "multiprocess");
                                        if (TextUtils.isEmpty(attributeValue2) || !"true".equals(attributeValue2.toLowerCase())) {
                                            String attributeValue3 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "authorities");
                                            if (TextUtils.isEmpty(attributeValue3) || !str.equals(attributeValue3)) {
                                                return null;
                                            }
                                            String attributeValue4 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "process");
                                            if (!TextUtils.isEmpty(attributeValue4)) {
                                                if (attributeValue4.startsWith(":")) {
                                                    return context.getPackageName() + attributeValue4;
                                                }
                                                return attributeValue4;
                                            }
                                            return context.getPackageName();
                                        }
                                        return null;
                                    }
                                } else if ("service".equals(name)) {
                                    String attributeValue5 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                                    if (!TextUtils.isEmpty(attributeValue5) && attributeValue5.equals(canonicalName)) {
                                        String attributeValue6 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "process");
                                        if (!TextUtils.isEmpty(attributeValue6)) {
                                            if (attributeValue6.startsWith(":")) {
                                                return context.getPackageName() + attributeValue6;
                                            }
                                            return attributeValue6;
                                        }
                                        return context.getPackageName();
                                    }
                                } else if (SocialConstants.PARAM_RECEIVER.equals(name)) {
                                    String attributeValue7 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                                    if (!TextUtils.isEmpty(attributeValue7) && attributeValue7.equals(canonicalName)) {
                                        String attributeValue8 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "process");
                                        if (!TextUtils.isEmpty(attributeValue8)) {
                                            if (attributeValue8.startsWith(":")) {
                                                return context.getPackageName() + attributeValue8;
                                            }
                                            return attributeValue8;
                                        }
                                        return context.getPackageName();
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                handleNuLException(th);
            }
            return null;
        }
        return (String) invokeLLL.objValue;
    }

    public static int getCurrNetworkType(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    if (activeNetworkInfo.getType() == 1) {
                        return 4;
                    }
                    if (activeNetworkInfo.getType() == 0) {
                        switch (activeNetworkInfo.getSubtype()) {
                            case 1:
                            case 2:
                                return 1;
                            case 3:
                                return 2;
                            case 4:
                                return 1;
                            case 5:
                            case 6:
                                return 2;
                            case 7:
                                return 1;
                            case 8:
                            case 9:
                            case 10:
                                return 2;
                            case 11:
                                return 1;
                            case 12:
                                return 2;
                            case 13:
                                return 3;
                            case 14:
                            case 15:
                                return 2;
                            default:
                                return 5;
                        }
                    }
                    return -2;
                }
            } catch (Throwable th) {
                handleNuLException(th);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static String getCurrentAbi(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT < 21 || (packageManager = context.getPackageManager()) == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0)) == null) {
                    return "";
                }
                Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
                declaredField.setAccessible(true);
                return (String) declaredField.get(applicationInfo);
            } catch (Throwable th) {
                handleNuLException(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v4 int), (r2v2 int), (r0v3 int)] */
    public static String getDayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(1);
            int i2 = calendar.get(2);
            int i3 = calendar.get(5);
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(i2);
            sb.append(i3);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String getDefaultToken(Context context, int i) {
        InterceptResult invokeLI;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65567, null, context, i)) == null) {
            try {
                String hexString = Integer.toHexString(i);
                if (!TextUtils.isEmpty(hexString) && (length = 4 - hexString.length()) > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (length = 4 - hexString.length(); length > 0; length--) {
                        sb.append("0");
                    }
                    hexString = sb.toString() + hexString;
                }
                byte[] aesEncrypt = EncryptUtil.aesEncrypt("30212102dicudiab".getBytes(), (getDefaultTokenforepart(context) + hexString).toString().getBytes(), false);
                SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
                int pullTokenCount = sharedPreferenceManager.getPullTokenCount() + 1;
                sharedPreferenceManager.setPullTokenCount(pullTokenCount);
                String encryptToken = getEncryptToken(aesEncrypt, pullTokenCount);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(encryptToken);
                sb2.insert(sb2.length() - 2, "A");
                return sb2.toString().replace("\n", "");
            } catch (Throwable th) {
                handleNuLException(th);
                return "";
            }
        }
        return (String) invokeLI.objValue;
    }

    public static String getDefaultTokenforepart(Context context) {
        int length;
        int length2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(DbUtil.getCUID(context));
                sb.append(":");
                String hexString = Long.toHexString(System.currentTimeMillis() / 1000);
                if (!TextUtils.isEmpty(hexString) && (length2 = 8 - hexString.length()) > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (length2 = 8 - hexString.length(); length2 > 0; length2--) {
                        sb2.append("0");
                    }
                    hexString = sb2.toString() + hexString;
                }
                String hexString2 = Long.toHexString(Long.valueOf(selectAppKeyAndSecurityKey(context)[0]).longValue());
                if (!TextUtils.isEmpty(hexString2) && (length = 16 - hexString2.length()) > 0) {
                    StringBuilder sb3 = new StringBuilder();
                    for (length = 16 - hexString2.length(); length > 0; length--) {
                        sb3.append("0");
                    }
                    hexString2 = sb3.toString() + hexString2;
                }
                sb.append(hexString);
                sb.append(hexString2);
                return sb.toString();
            } catch (Throwable th) {
                handleNuLException(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getEncryptToken(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65569, null, bArr, i)) == null) {
            if (bArr != null) {
                try {
                    byte[] bytes = Long.toString(System.currentTimeMillis() / 1000).getBytes();
                    int length = bArr.length + bytes.length + 4;
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    System.arraycopy(bytes, 0, bArr2, bArr.length, bytes.length);
                    int i2 = length - 4;
                    int[] iArr = new int[i2];
                    iArr[0] = i;
                    for (int i3 = 1; i3 < i2; i3++) {
                        iArr[i3] = ((iArr[i3 - 1] * 3) + 1) % 128;
                    }
                    for (int i4 = 0; i4 < i2; i4++) {
                        bArr2[i4] = (byte) (bArr2[i4] ^ ((byte) iArr[i4]));
                    }
                    byte[] int2byte = int2byte(i);
                    System.arraycopy(int2byte, 0, bArr2, i2, int2byte.length);
                    return Base64.encodeToString(bArr2, 9).replace("\n", "");
                } catch (Throwable th) {
                    handleNuLException(th);
                }
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    public static String getHostCuid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            try {
                return DeviceId.getCUID(context);
            } catch (Throwable th) {
                handleNuLException(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static Map<String, Integer> getMapForJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                HashMap hashMap = new HashMap();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, (Integer) jSONObject.get(next));
                }
                return hashMap;
            } catch (Throwable th) {
                handleNuLException(th);
                return null;
            }
        }
        return (Map) invokeL.objValue;
    }

    public static String getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? UUID.randomUUID().toString() : (String) invokeV.objValue;
    }

    public static int getNetworkType(Context context) {
        InterceptResult invokeL;
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
            try {
                networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Throwable th) {
                handleNuLException(th);
                networkInfo = null;
            }
            if (networkInfo == null) {
                return 0;
            }
            if (1 == networkInfo.getType()) {
                return 2;
            }
            if (networkInfo.getType() == 0) {
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static byte[] getPostData(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65574, null, str)) == null) ? str.getBytes(IMAudioTransRequest.CHARSET) : (byte[]) invokeL.objValue;
    }

    public static String getProcessName(int i) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65575, null, i)) == null) {
            String str2 = null;
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    str = Application.getProcessName();
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            return str.trim();
                        }
                    } catch (Throwable th) {
                        th = th;
                        str2 = str;
                        handleNuLException(th);
                        return str2;
                    }
                } else {
                    str = null;
                }
                Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                if (invoke instanceof String) {
                    str = (String) invoke;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (!TextUtils.isEmpty(str)) {
                return str.trim();
            }
            str2 = readFileAsString(String.format("/proc/%d/cmdline", Integer.valueOf(i)));
            if (!TextUtils.isEmpty(str2)) {
                return str2.trim();
            }
            return str2;
        }
        return (String) invokeI.objValue;
    }

    public static String getProviderProcessName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) {
            try {
            } catch (Throwable th) {
                handleNuLException(th);
            }
            if (TextUtils.isEmpty(sProviderProcessname) && sProviderstatus != 1) {
                ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(context.getPackageName() + ".sofire.ac.provider", 0);
                if (resolveContentProvider != null && !resolveContentProvider.multiprocess) {
                    sProviderProcessname = resolveContentProvider.processName;
                }
                sProviderstatus = 1;
                return sProviderProcessname;
            }
            return sProviderProcessname;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PublicKey getPublicKey(PackageInfo packageInfo, String str) {
        InterceptResult invokeLL;
        PublicKey publicKey;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65577, null, packageInfo, str)) != null) {
            return (PublicKey) invokeLL.objValue;
        }
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null && signatureArr.length > 0 && signatureArr[0] != null) {
            try {
                publicKey = CertUtil.getPublicKey(signatureArr[0]);
            } catch (Throwable th) {
                handleNuLException(th);
            }
            return publicKey != null ? CertUtil.parserPublicKeyByPath(str) : publicKey;
        }
        publicKey = null;
        if (publicKey != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (android.text.TextUtils.isEmpty(r5) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getSelfCuid(Context context) {
        InterceptResult invokeL;
        Throwable th;
        String str;
        Throwable th2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65578, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        String str2 = "";
        try {
            SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
            String galaxyCUIDNew = sharedPreferenceManager.getGalaxyCUIDNew();
            if (TextUtils.isEmpty(galaxyCUIDNew)) {
                String galaxyCUID = sharedPreferenceManager.getGalaxyCUID();
                if (TextUtils.isEmpty(galaxyCUID)) {
                    try {
                        str = GdUtil.getCuid(context);
                        try {
                        } catch (Throwable th3) {
                            th2 = th3;
                            try {
                                handleNuLException(th2);
                                str2 = str;
                                sharedPreferenceManager.setGalaxyCUIDNew(str2);
                                return str2;
                            } catch (Throwable th4) {
                                th = th4;
                                handleNuLException(th);
                                return str;
                            }
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                        str = "";
                    }
                } else {
                    str2 = galaxyCUID;
                }
                sharedPreferenceManager.setGalaxyCUIDNew(str2);
                return str2;
            }
            return galaxyCUIDNew;
        } catch (Throwable th6) {
            String str3 = str2;
            th = th6;
            str = str3;
        }
    }

    public static String getSign(String str, String str2, long j) throws UnsupportedEncodingException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65579, null, new Object[]{str, str2, Long.valueOf(j)})) == null) {
            return MD5Util.getMD5(str + j + str2);
        }
        return (String) invokeCommon.objValue;
    }

    public static String getUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, context)) == null) {
            try {
                return new String(F.getInstance().ad(Base64.decode(LocalConstant.H, 0), "30212102dicudiab".getBytes()));
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void handleAesFailed(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65581, null, context) == null) {
            SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
            if (System.currentTimeMillis() - sharedPreferenceManager.getSendAesFailTime() > 86400000) {
                HashMap hashMap = new HashMap();
                hashMap.put("0", Integer.valueOf(sharedPreferenceManager.getAesFailedCount() + 1));
                sharedPreferenceManager.setAesFailedCount(0);
                sharedPreferenceManager.setSendAesFailTime();
                sendEventUDC(context, "1003119", hashMap, false);
                return;
            }
            sharedPreferenceManager.setAesFailedCount(sharedPreferenceManager.getAesFailedCount() + 1);
        }
    }

    public static void handleMapSign(Context context, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65582, null, context, bArr) == null) {
            try {
                String[] selectAppKeyAndSecurityKey = selectAppKeyAndSecurityKey(context);
                if (selectAppKeyAndSecurityKey == null || selectAppKeyAndSecurityKey.length != 2) {
                    return;
                }
                if (TextUtils.isEmpty(selectAppKeyAndSecurityKey[0]) || TextUtils.isEmpty(selectAppKeyAndSecurityKey[1]) || !"200080".equals(selectAppKeyAndSecurityKey[0]) || !context.getPackageName().equals("com.baidu.BaiduMap") || bArr == null) {
                    return;
                }
                for (int i = 0; i < bArr.length; i++) {
                    bArr[i] = (byte) (bArr[i] ^ 246);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void handleNuLException(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65583, null, th) == null) {
            BaiduLog.printThrowable(th);
        }
    }

    public static String hexEncodeString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, bArr)) == null) {
            String str = "";
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str = str + hexString.toUpperCase();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void i(Context context, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65585, null, new Object[]{context, str, str2, str3, str4, str5}) == null) {
            CtrlUtil.getInstance(context).s(false);
            CtrlUtil.getInstance(context).reportDelay();
            ReportConfigInfo reportConfigInfo = new ReportConfigInfo();
            reportConfigInfo.sdkName = str;
            reportConfigInfo.pkgName = str2;
            reportConfigInfo.sdkVersion = str3;
            reportConfigInfo.aliveLogId = str4;
            reportConfigInfo.installLogId = str5;
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
                return;
            }
            SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
            List<ReportConfigInfo> configInfos = sharedPreferenceManager.getConfigInfos();
            if (configInfos == null) {
                sharedPreferenceManager.setConfigInfos(reportConfigInfo);
            } else if (!configInfos.contains(reportConfigInfo)) {
                sharedPreferenceManager.setConfigInfos(reportConfigInfo);
            } else {
                sharedPreferenceManager.updateConfigInfos(configInfos, reportConfigInfo);
                CtrlUtil.getInstance(context).initReport();
                return;
            }
            if (!sharedPreferenceManager.isReportInstall(reportConfigInfo.installLogId)) {
                CtrlUtil.getInstance(context).reportInstall(reportConfigInfo);
            }
            CtrlUtil.getInstance(context).initReport();
            CtrlUtil.getInstance(context).report();
        }
    }

    public static byte[] int2byte(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65586, null, i)) == null) ? new byte[]{(byte) (i >>> 24), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)} : (byte[]) invokeI.objValue;
    }

    public static boolean is64BitProcess() {
        InterceptResult invokeV;
        File file;
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) {
            if (Build.VERSION.SDK_INT > 22) {
                return Process.is64Bit();
            }
            try {
                file = new File("/proc/" + Process.myPid() + "/maps");
            } catch (Throwable th2) {
                handleNuLException(th2);
            }
            if (!file.exists() || file.isDirectory()) {
                return false;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
            do {
                try {
                    readLine = bufferedReader.readLine();
                } catch (Throwable th4) {
                    th = th4;
                    handleNuLException(th);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            e = e2;
                            handleNuLException(e);
                            return false;
                        }
                    }
                    return false;
                }
                if (readLine == null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        e = e3;
                        handleNuLException(e);
                        return false;
                    }
                    return false;
                }
            } while (!readLine.contains("/system/lib64/libc.so"));
            try {
                bufferedReader.close();
                return true;
            } catch (IOException e4) {
                handleNuLException(e4);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean isDebugMode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, context)) == null) {
            try {
                if (sDebugMode < 0 && context != null) {
                    String packageName = context.getPackageName();
                    Field field = Class.forName(packageName + ".BuildConfig").getField("DEBUG");
                    field.setAccessible(true);
                    sDebugMode = field.getBoolean(null) ? 1 : 0;
                }
            } catch (Throwable th) {
                handleNuLException(th);
            }
            return sDebugMode == 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean isFileExist(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return isFileExist(new File(str));
        }
        return invokeL.booleanValue;
    }

    public static boolean isInitSuc(int i) {
        InterceptResult invokeI;
        ApkInfo pluginByID;
        PluginloaderHub peekInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65591, null, i)) == null) {
            try {
                D peekInstance2 = D.peekInstance();
                if (peekInstance2 == null || (pluginByID = peekInstance2.getPluginByID(i)) == null || pluginByID.initStatus != 1 || (peekInstance = PluginloaderHub.peekInstance()) == null) {
                    return false;
                }
                return peekInstance.getApkInfoByPackageName(pluginByID.packageName) != null;
            } catch (Throwable th) {
                handleNuLException(th);
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public static int isMainProcess(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, context)) == null) {
            try {
                int i = 1;
                if (MyProvider.isProviderProcess()) {
                    return 1;
                }
                if (sMainProcessFlag == -1) {
                    int checkProcessAuth = checkProcessAuth(context);
                    if (checkProcessAuth != 1 && (checkProcessAuth == 2 || !MyProvider.isProviderProcess())) {
                        i = 0;
                    }
                    sMainProcessFlag = i;
                }
                return sMainProcessFlag;
            } catch (Throwable th) {
                handleNuLException(th);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static boolean isMainThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65593, null)) == null) {
            try {
                return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
            } catch (Throwable th) {
                handleNuLException(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean isNetworkAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                return activeNetworkInfo.isConnected();
            } catch (Throwable th) {
                handleNuLException(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isRemoteCompareToCurrentProc(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65595, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(sCurrentProcessName)) {
                    sCurrentProcessName = getProcessName(Process.myPid());
                }
                return !str.equals(sCurrentProcessName);
            } catch (Throwable th) {
                handleNuLException(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isTargetMethod(Method method, String str, Class<?>[] clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65596, null, method, str, clsArr)) == null) {
            if (str.equals(method.getName())) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if ((parameterTypes == null || parameterTypes.length == 0) && (clsArr == null || clsArr.length == 0)) {
                    return true;
                }
                if ((clsArr == null || clsArr.length == 0) && parameterTypes != null && parameterTypes.length > 0) {
                    return false;
                }
                if (((parameterTypes == null || parameterTypes.length == 0) && clsArr != null && clsArr.length > 0) || parameterTypes == null || clsArr == null || parameterTypes.length != clsArr.length) {
                    return false;
                }
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (parameterTypes[i] != clsArr[i]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean isWifiAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65597, null, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && 1 == activeNetworkInfo.getType();
        }
        return invokeL.booleanValue;
    }

    public static String loadProperties(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65598, null, context, str, str2)) == null) {
            Properties properties = new Properties();
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open(str);
                properties.load(inputStream);
                String property = properties.getProperty(str2);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return property;
                    } catch (Throwable th) {
                        handleNuLException(th);
                        return property;
                    }
                }
                return property;
            } catch (Throwable th2) {
                try {
                    handleNuLException(th2);
                    return "";
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th3) {
                            handleNuLException(th3);
                        }
                    }
                }
            }
        }
        return (String) invokeLLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
        if (r2 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        if (r2 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
        r2.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String loadPropertiesFromAssets(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65599, null, context, str, str2)) != null) {
            return (String) invokeLLL.objValue;
        }
        String str3 = "";
        try {
            Properties properties = new Properties();
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open(str);
                properties.load(inputStream);
                str3 = properties.getProperty(str2);
            } catch (IOException unused) {
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            handleNuLException(th2);
        }
    }

    public static void parserHostData(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65600, null, context, str) == null) {
            String str2 = "";
            SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
            try {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject("0");
                    if (optJSONObject != null) {
                        String str3 = "";
                        while (optJSONObject.keys().hasNext()) {
                            str3 = String.valueOf(optJSONObject.keys().next());
                            if (!TextUtils.isEmpty(str3)) {
                                break;
                            }
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            sharedPreferenceManager.setAliveData(str3, optJSONObject.optString(str3));
                        }
                    }
                } catch (Throwable th) {
                    handleNuLException(th);
                }
                try {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("1");
                    if (optJSONObject2 != null) {
                        while (optJSONObject2.keys().hasNext()) {
                            str2 = String.valueOf(optJSONObject2.keys().next());
                            if (!TextUtils.isEmpty(str2)) {
                                break;
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            sharedPreferenceManager.setInstallData(str2, optJSONObject2.optString(str2));
                        }
                    }
                } catch (Throwable th2) {
                    handleNuLException(th2);
                }
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("2");
                    if (optJSONArray != null) {
                        sharedPreferenceManager.setAlivePkgs(optJSONArray.toString());
                    }
                } catch (Throwable th3) {
                    handleNuLException(th3);
                }
            } catch (Throwable th4) {
                handleNuLException(th4);
            }
        }
    }

    public static String readFileAsString(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65601, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            fileInputStream = new FileInputStream(str);
            try {
                String readStreamAsString = readStreamAsString(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
                return readStreamAsString;
            } catch (Throwable th) {
                th = th;
                try {
                    handleNuLException(th);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static String readStreamAsString(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65602, null, inputStream)) != null) {
            return (String) invokeL.objValue;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                if (z) {
                    z = false;
                } else {
                    sb.append('\n');
                }
                sb.append(readLine);
            } else {
                return sb.toString();
            }
        }
    }

    public static void registerDefultReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65603, null, context) == null) {
            try {
                MyReceiver myReceiver = new MyReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.action.SOFIRE.VIEW");
                intentFilter.addCategory("com.baidu.category.SOFIRE");
                intentFilter.addCategory("android.intent.category.DEFAULT");
                context.registerReceiver(myReceiver, intentFilter, context.getPackageName() + ".permission.sofire.RECEIVE", null);
            } catch (Throwable th) {
                handleNuLException(th);
            }
        }
    }

    public static boolean registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65604, null, context, broadcastReceiver, intentFilter)) == null) {
            try {
                context.registerReceiver(broadcastReceiver, intentFilter, context.getPackageName() + ".permission.sofire.RECEIVE", null);
                return true;
            } catch (Throwable th) {
                handleNuLException(th);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static JSONObject requestWholeInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65605, null, context)) == null) {
            try {
                String str = getUrl(context) + "p/5/aio";
                JSONObject jSONObject = new JSONObject();
                JSONArray buildLocalPluginInfo = buildLocalPluginInfo(context);
                if (buildLocalPluginInfo != null) {
                    jSONObject.put("0", buildLocalPluginInfo);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("1", DbUtil.getCUID(context));
                jSONObject2.put("3", String.valueOf(Build.VERSION.SDK_INT));
                jSONObject2.put("4", LocalConstant.V);
                String packageName = context.getPackageName();
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 64);
                if (packageInfo != null) {
                    jSONObject2.put("5", trimAppName(packageInfo.applicationInfo.loadLabel(packageManager).toString()));
                    jSONObject2.put("6", packageName);
                    PublicKey publicKey = getPublicKey(packageInfo, packageInfo.applicationInfo.sourceDir);
                    if (publicKey != null) {
                        byte[] encoded = publicKey.getEncoded();
                        if (encoded != null) {
                            handleMapSign(context, encoded);
                            jSONObject2.put("7", MD5Util.getMD5(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", "")));
                        } else {
                            jSONObject2.put("7", "");
                        }
                    }
                    jSONObject2.put("8", packageInfo.versionName);
                    jSONObject2.put("9", String.valueOf(SharedPreferenceManager.getInstance(context).getOncePluginId()));
                    jSONObject.put("1", jSONObject2);
                    String encryptRequestPost = EncryptConnUtil.encryptRequestPost(context, str, jSONObject.toString(), true, true);
                    if (TextUtils.isEmpty(encryptRequestPost)) {
                        return null;
                    }
                    JSONObject jSONObject3 = new JSONObject(encryptRequestPost);
                    checkRedressKey(context, jSONObject3);
                    ReportEngine.initDafalutConfiger(context, jSONObject3);
                    setPluginSettings(context, jSONObject3);
                    return jSONObject3;
                }
                sRequestWholeErrorCode = 6;
                return null;
            } catch (Throwable th) {
                handleNuLException(th);
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void s(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65606, null, context, str, z) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
                System.currentTimeMillis();
                sharedPreferenceManager.getReportNetworkType();
                JSONObject optJSONObject = jSONObject.optJSONObject("Common_section");
                long optLong = optJSONObject.optLong("0");
                String optString = optJSONObject.optString("10");
                int optInt = optJSONObject.optInt("5");
                int optInt2 = optJSONObject.optInt("6");
                int optInt3 = optJSONObject.optInt("7");
                int optInt4 = optJSONObject.optInt("11");
                if (optInt2 == 0) {
                    optInt2 = 1;
                }
                ReportItemInfo reportItemInfo = new ReportItemInfo();
                reportItemInfo.data = str;
                reportItemInfo.eventId = optString;
                reportItemInfo.frequency = optInt;
                reportItemInfo.eventType = 3;
                reportItemInfo.timestamp = optLong;
                reportItemInfo.network = optInt2;
                reportItemInfo.maxFrequency = optInt3;
                reportItemInfo.tag = optInt4;
                reportItemInfo.reportTopic = "";
                CtrlUtil.getInstance(context).postEvent(reportItemInfo, z);
            } catch (Throwable th) {
                handleNuLException(th);
            }
        }
    }

    public static String[] selectAppKeyAndSecurityKey(Context context) {
        InterceptResult invokeL;
        String[] split;
        String[] split2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65607, null, context)) == null) {
            String str = sAppKey;
            String str2 = sSecKey;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    String securityVerifyInfo = SharedPreferenceManager.getInstance(context).getSecurityVerifyInfo();
                    if (!TextUtils.isEmpty(securityVerifyInfo) && (split = securityVerifyInfo.split("-")) != null && split.length == 2) {
                        return split;
                    }
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    String securityVerifyInfoMark = SharedPreferenceManager.getInstance(context).getSecurityVerifyInfoMark();
                    if (!TextUtils.isEmpty(securityVerifyInfoMark) && (split2 = securityVerifyInfoMark.split("-")) != null && split2.length == 2) {
                        return split2;
                    }
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    str = APPKEY_DEFULT;
                    str2 = SECKEY_DEFULT;
                }
                return new String[]{str, str2};
            }
            return new String[]{str, str2};
        }
        return (String[]) invokeL.objValue;
    }

    public static void sendEventRealTime(Context context, String str, Map<String, Object> map) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65608, null, context, str, map) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "");
            jSONObject2.put("2", "");
            String[] selectAppKeyAndSecurityKey = selectAppKeyAndSecurityKey(context);
            if (selectAppKeyAndSecurityKey != null && selectAppKeyAndSecurityKey.length == 2 && !TextUtils.isEmpty(selectAppKeyAndSecurityKey[0]) && !TextUtils.isEmpty(selectAppKeyAndSecurityKey[1])) {
                str2 = selectAppKeyAndSecurityKey[0];
            } else {
                str2 = APPKEY_DEFULT;
            }
            jSONObject2.put("3", str2);
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put("8", "sofire");
            jSONObject2.put("9", LocalConstant.V);
            jSONObject2.put("10", str);
            jSONObject.put("Common_section", jSONObject2);
            if (map != null && map.size() > 0) {
                jSONObject.put("Module_section", new JSONObject(map));
            } else {
                jSONObject.put("Module_section", new JSONObject());
            }
            Report.getInstance(context).sr(jSONObject.toString());
        } catch (Throwable th) {
            handleNuLException(th);
        }
    }

    public static void sendEventUDC(Context context, String str, Map<String, Object> map, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65609, null, new Object[]{context, str, map, Boolean.valueOf(z)}) == null) && !TextUtils.isEmpty(str) && MutiPlatformAdapter.isOnline()) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("0", System.currentTimeMillis());
                jSONObject2.put("1", "");
                jSONObject2.put("2", "");
                String[] selectAppKeyAndSecurityKey = selectAppKeyAndSecurityKey(context);
                if (selectAppKeyAndSecurityKey != null && selectAppKeyAndSecurityKey.length == 2 && !TextUtils.isEmpty(selectAppKeyAndSecurityKey[0]) && !TextUtils.isEmpty(selectAppKeyAndSecurityKey[1])) {
                    str2 = selectAppKeyAndSecurityKey[0];
                } else {
                    str2 = APPKEY_DEFULT;
                }
                jSONObject2.put("3", str2);
                jSONObject2.put("4", 0);
                jSONObject2.put("5", 0);
                jSONObject2.put("6", 1);
                jSONObject2.put("7", 0);
                jSONObject2.put("8", "sofire");
                jSONObject2.put("9", LocalConstant.V);
                jSONObject2.put("10", str);
                jSONObject.put("Common_section", jSONObject2);
                if (map != null && map.size() > 0) {
                    jSONObject.put("Module_section", new JSONObject(map));
                } else {
                    jSONObject.put("Module_section", new JSONObject());
                }
                Report.getInstance(context).s(jSONObject.toString(), z);
            } catch (Throwable th) {
                handleNuLException(th);
            }
        }
    }

    public static void sendInitUDC(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65610, null, context) == null) || TextUtils.isEmpty(LocalConstant.V)) {
            return;
        }
        Report report = Report.getInstance(context);
        try {
            setAliveData(context);
            report.i("sofire", "com.baidu.sofire", LocalConstant.V, "1003003", "1003002");
        } catch (Throwable unused) {
        }
    }

    public static void setAliveData(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65611, null, context) == null) {
            try {
                Report report = Report.getInstance(context);
                JSONObject jSONObject = new JSONObject();
                D d2 = D.getInstance(context);
                Map<Integer, String> initSuceedPluginKeys = d2.getInitSuceedPluginKeys();
                jSONObject.put("0", initSuceedPluginKeys.keySet());
                jSONObject.put("1", initSuceedPluginKeys.values());
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("1003003", jSONObject);
                jSONObject2.put("0", jSONObject3);
                Map<Integer, String> initSuceedPluginPkgs = d2.getInitSuceedPluginPkgs();
                JSONArray jSONArray = new JSONArray();
                for (String str : initSuceedPluginPkgs.values()) {
                    jSONArray.put(str);
                }
                jSONArray.put("com.baidu.sofire");
                jSONObject2.put("2", jSONArray);
                report.w(jSONObject2.toString());
            } catch (Throwable unused) {
            }
        }
    }

    public static void setPluginSettings(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65612, null, context, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
            String optString = jSONObject.optString("0");
            if (!TextUtils.isEmpty(optString)) {
                sharedPreferenceManager.setLocalIp(new String(Base64.encode(EncryptUtil.aesEncrypt("30212102dicudiab".getBytes(), optString.getBytes("UTF-8"), true), 10), "UTF-8"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("4");
            if (optJSONObject == null) {
                return;
            }
            sharedPreferenceManager.setGetAppList(optJSONObject.optInt("app"));
            sharedPreferenceManager.setJsSwitch(optJSONObject.optInt("js"));
            sharedPreferenceManager.setAppKeySwitch(optJSONObject.optInt("a", 1));
            sharedPreferenceManager.setPluginCheckTime(optJSONObject.optInt("pi", 360));
            int optInt = optJSONObject.optInt(Config.FEED_LIST_PART, 1);
            if (optInt > 0) {
                int round = (int) Math.round(24.0d / optInt);
                if (round > 0) {
                    sharedPreferenceManager.setAlarmCheckTime(round);
                } else {
                    sharedPreferenceManager.setAlarmCheckTime(24);
                }
            }
            int optInt2 = optJSONObject.optInt("alm", 24);
            if (optInt2 > 0) {
                sharedPreferenceManager.setDayAlarmTime(optInt2);
            } else {
                sharedPreferenceManager.setDayAlarmTime(24);
            }
            if (optJSONObject.optInt("0", 0) > 0) {
                sharedPreferenceManager.setAllowActiveCallback(true);
            } else {
                sharedPreferenceManager.setAllowActiveCallback(false);
            }
            if (optJSONObject.optInt("1", -1) == 1) {
                sharedPreferenceManager.isStartForegroundServiceOpen();
                sharedPreferenceManager.setStartForegroundServiceSwitch(true);
            } else {
                sharedPreferenceManager.setStartForegroundServiceSwitch(false);
            }
            writeFlagFile(context, ALLOW_MUTI_PROCESS_FLAG_FILE_NAME, optJSONObject.optInt("mp", 0));
            int optInt3 = optJSONObject.optInt("tc", -1);
            if (optInt3 > 0 && optInt3 <= 20) {
                sharedPreferenceManager.setThreadPoolCoreSize(optInt3);
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("pc");
            if (optJSONObject2 != null) {
                PrivacyOperationUtil.updatePolicy(context, optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("pr");
            if (optJSONObject3 != null) {
                MutiPlatformAdapter.platformPrivateConfig(context, optJSONObject3);
            }
        } catch (Throwable th) {
            handleNuLException(th);
        }
    }

    public static void setSecurityVerifyInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65613, null, str, str2) == null) {
            sAppKey = str;
            sSecKey = str2;
        }
    }

    public static void setUpgradeAlarm(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65614, null, context, j) == null) {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent(Receiver.ACTION_REPORT_POLL);
            intent.setPackage(context.getPackageName());
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, intent, 134217728);
            try {
                alarmManager.cancel(broadcast);
            } catch (Throwable th) {
                handleNuLException(th);
            }
            try {
                alarmManager.set(1, System.currentTimeMillis() + j, broadcast);
            } catch (Throwable th2) {
                handleNuLException(th2);
            }
        }
    }

    public static String trimAppName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65615, null, str)) == null) {
            try {
                int length = str.length();
                int i = 0;
                while (i < length && (str.charAt(i) <= ' ' || str.charAt(i) == 160)) {
                    i++;
                }
                return i > 0 ? str.substring(i) : str;
            } catch (Throwable th) {
                handleNuLException(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String validateName(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65616, null, str, z)) == null) {
            int length = str.length();
            boolean z2 = false;
            boolean z3 = true;
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                    z3 = false;
                } else if (z3 || ((charAt < '0' || charAt > '9') && charAt != '_')) {
                    if (charAt != '.') {
                        return "bad character '" + charAt + "'";
                    }
                    z2 = true;
                    z3 = true;
                }
            }
            if (z2 || !z) {
                return null;
            }
            return "must have at least one '.' separator";
        }
        return (String) invokeLZ.objValue;
    }

    public static boolean writeByteArrayToFile(Context context, byte[] bArr, File file) {
        InterceptResult invokeLLL;
        FileOutputStream fileOutputStream;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65617, null, context, bArr, file)) == null) {
            if (context != null && bArr != null) {
                try {
                    if (bArr.length > 0 && file != null) {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            fileOutputStream.write(bArr);
                            fileOutputStream.flush();
                            try {
                                fileOutputStream.close();
                                return true;
                            } catch (IOException e2) {
                                handleNuLException(e2);
                                return true;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                handleNuLException(th);
                                return false;
                            } finally {
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e3) {
                                        handleNuLException(e3);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th3) {
                    fileOutputStream = null;
                    th = th3;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void writeFlagFile(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65618, null, context, str, i) == null) || i < 0) {
            return;
        }
        try {
            File file = new File(context.getFilesDir(), ".tmp");
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(file, str);
            if (i > 0) {
                if (file2.exists()) {
                    file2.delete();
                }
            } else if (i != 0 || file2.exists()) {
            } else {
                file2.createNewFile();
            }
        } catch (Throwable th) {
            handleNuLException(th);
        }
    }

    public static void copyFile(File file, File file2) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65553, null, file, file2) == null) || file == null || file2 == null || !isFileExist(file)) {
            return;
        }
        if (file2.exists()) {
            file2.delete();
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    try {
                        fileInputStream2.close();
                    } catch (Throwable unused) {
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    try {
                        handleNuLException(th);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable unused3) {
                            }
                        }
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable unused4) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable unused5) {
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static boolean isFileExist(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65589, null, file)) == null) ? file != null && file.exists() && file.isFile() && file.canRead() && file.length() > 0 : invokeL.booleanValue;
    }

    public static void deleteDir(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65560, null, str, j) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                File file = new File(str);
                if (file.exists()) {
                    if (System.currentTimeMillis() - file.lastModified() < j) {
                        return;
                    }
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        for (File file2 : listFiles) {
                            if (System.currentTimeMillis() - file2.lastModified() >= j) {
                                if (file2.isDirectory()) {
                                    deleteDir(file2.getAbsolutePath(), j);
                                } else {
                                    file2.delete();
                                }
                            }
                        }
                    }
                    if (file.isDirectory()) {
                        File[] listFiles2 = file.listFiles();
                        if (listFiles2 == null || listFiles2.length <= 0) {
                            file.delete();
                            return;
                        }
                        return;
                    }
                    file.delete();
                }
            } catch (Throwable th) {
                handleNuLException(th);
            }
        }
    }
}
