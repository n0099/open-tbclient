package com.baidu.searchbox.live.nps;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.SubBundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.tieba.a91;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MultiPluginHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AB_TEST_ENABLE_NPS_MULTI_PLUGIN = "android_live_enable_nps_multi_plugin_online";
    public static final int ARCH_TYPE_NEW = 3;
    public static final int ARCH_TYPE_OLD = 1;
    public static final int ARCH_TYPE_OLD_KEEP_LOCAL = 2;
    public static final String MEDIA_NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.livenps";
    public static final int MIX_NEW_ARCH_PLUGIN_VERSION = 508000000;
    public static final String UBC_ID_CANCEL_JOIN_LIVE = "4417";
    public static final String YY_NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.yylive.entrance";
    public static AbConfigService abService;
    public static AppInfoService appService;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(320149544, "Lcom/baidu/searchbox/live/nps/MultiPluginHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(320149544, "Lcom/baidu/searchbox/live/nps/MultiPluginHelper;");
                return;
            }
        }
        appService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        abService = (AbConfigService) ServiceManager.getService(AbConfigService.Companion.getSERVICE_REFERENCE());
    }

    public MultiPluginHelper() {
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

    public static String bundleToJsonStr(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            if (map != null && !map.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                for (String str : map.keySet()) {
                    try {
                        jSONObject.put(str, map.get(str));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                return jSONObject.toString();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean newArchSubPluginNeedForceUpdate(Set set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, set)) == null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup((String) it.next());
                if (bundleGroup != null) {
                    BundleInfo bundleByType = bundleGroup.getBundleByType(1);
                    if (bundleByType != null && bundleByType.getVersionCode() >= 508000000 && bundleByType.needForceUpdate()) {
                        return true;
                    }
                    BundleInfo bundleByType2 = bundleGroup.getBundleByType(2);
                    if (bundleByType2 != null && bundleByType2.getVersionCode() >= 508000000 && bundleByType2.needForceUpdate()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static HashMap stringToMap(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (String str3 : str.split("&")) {
                String[] split = str3.split("=");
                try {
                    String decode = URLDecoder.decode(split[0], "UTF-8");
                    if (split.length > 1) {
                        str2 = URLDecoder.decode(split[1], "UTF-8");
                    } else {
                        str2 = "";
                    }
                    hashMap.put(decode, str2);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static void fillSubBundlePkgName(BundleInfo bundleInfo, Set set) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, bundleInfo, set) == null) && bundleInfo != null && bundleInfo.isMainBundle() && set != null) {
            for (SubBundleInfo subBundleInfo : bundleInfo.getSubBundle()) {
                set.add(subBundleInfo.getPackageName());
            }
        }
    }

    public static String getParamsStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int indexOf = str.indexOf("?");
            if (indexOf <= 0) {
                return null;
            }
            return str.substring(indexOf + 1);
        }
        return (String) invokeL.objValue;
    }

    public static void log(String str) {
        AppInfoService appInfoService;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, str) == null) && (appInfoService = appService) != null && appInfoService.isDebug()) {
            Log.e("MultiPluginWay", "MultiPluginHelper " + str);
        }
    }

    public static int getPluginArchLaunchType(boolean z) {
        InterceptResult invokeZ;
        BundleInfo bundleInfo;
        BundleInfo bundleInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65541, null, z)) == null) {
            log("getPluginArchLaunchType ignoreEntrance:  " + z);
            BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps");
            BundleInfoGroup bundleGroup2 = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.yylive.entrance");
            if (bundleGroup == null) {
                return 3;
            }
            BundleInfo bundleByType = bundleGroup.getBundleByType(3);
            BundleInfo bundleByType2 = bundleGroup.getBundleByType(2);
            boolean z2 = true;
            BundleInfo bundleByType3 = bundleGroup.getBundleByType(1);
            BundleInfo bundleInfo3 = null;
            if (bundleGroup2 != null) {
                bundleInfo3 = bundleGroup2.getBundleByType(3);
                bundleInfo2 = bundleGroup2.getBundleByType(2);
                bundleInfo = bundleGroup2.getBundleByType(1);
            } else {
                bundleInfo = null;
                bundleInfo2 = null;
            }
            if (bundleByType == null && bundleByType2 == null && bundleInfo3 == null && bundleInfo2 == null) {
                log("ARCH_TYPE_NEW installLivenps downloadLivenps installEntrance downloadEntrance all null");
                return 3;
            } else if (bundleByType != null && bundleByType.getVersionCode() >= 508000000) {
                log("ARCH_TYPE_NEW installLivenps version: " + bundleByType.getVersionCode());
                return 3;
            } else if (bundleInfo3 != null && bundleInfo3.getVersionCode() >= 508000000) {
                log("ARCH_TYPE_NEW installEntrance version: " + bundleInfo3.getVersionCode());
                return 3;
            } else if (bundleByType3 != null && bundleByType3.getVersionCode() >= 508000000 && bundleByType3.needForceUpdate()) {
                log("ARCH_TYPE_NEW updateLivenps version: " + bundleByType3.getVersionCode() + "  needForceUpdate:" + bundleByType3.needForceUpdate());
                return 3;
            } else if (bundleInfo != null && bundleInfo.getVersionCode() >= 508000000 && bundleInfo.needForceUpdate()) {
                log("ARCH_TYPE_NEW updateEntrance version: " + bundleInfo.getVersionCode() + "  needForceUpdate" + bundleInfo.needForceUpdate());
                return 3;
            } else {
                boolean z3 = false;
                if (bundleByType2 != null && bundleByType2.getVersionCode() >= 508000000) {
                    log("downloadLivenps version: " + bundleByType2.getVersionCode());
                    z3 = true;
                }
                BundleInfo presetBundle = NPSPackageManager.getInstance().getPresetBundle("com.baidu.searchbox.livenps");
                if (presetBundle != null && presetBundle.getVersionCode() >= 508000000) {
                    log("presetLivenps version: " + presetBundle.getVersionCode());
                } else {
                    z2 = z3;
                }
                if (z2 && (z || (bundleInfo2 != null && bundleInfo2.getVersionCode() >= 508000000))) {
                    if (bundleInfo2 != null) {
                        log("downloadEntrance version: " + bundleInfo2.getVersionCode());
                    }
                    return 3;
                }
                HashSet hashSet = new HashSet();
                fillSubBundlePkgName(bundleByType2, hashSet);
                fillSubBundlePkgName(bundleByType3, hashSet);
                fillSubBundlePkgName(bundleInfo2, hashSet);
                fillSubBundlePkgName(bundleInfo, hashSet);
                if (newArchSubPluginNeedForceUpdate(hashSet)) {
                    log("ARCH_TYPE_NEW newArchSubPluginNeedForceUpdate true");
                    return 3;
                }
                int c = a91.b().c("com.baidu.searchbox.livenps");
                if (bundleByType != null && bundleByType.getVersionCode() < 508000000 && bundleByType.getVersionCode() >= c) {
                    log("installLivenps：" + bundleByType.getVersionCode());
                    log("installLivenps.livenpsHostMinVersion：" + c);
                    if (z2 && bundleInfo2 != null && bundleInfo2.getVersionCode() >= 508000000) {
                        log("ARCH_TYPE_NEW downloadEntrance：" + bundleInfo2.getVersionCode());
                        return 3;
                    }
                    if (bundleInfo2 != null) {
                        log("ARCH_TYPE_OLD_KEEP_LOCAL downloadEntrance version: " + bundleInfo2.getVersionCode());
                    } else {
                        log("ARCH_TYPE_OLD_KEEP_LOCAL downloadEntrance null:");
                    }
                    return 2;
                } else if (!isMultiPluginOn() && bundleByType == null && bundleByType2 != null && bundleByType2.getVersionCode() < 508000000 && bundleByType2.getVersionCode() >= c) {
                    log("downloadLivenps.getVersionCode：" + bundleByType2.getVersionCode());
                    log("downloadLivenps.livenpsHostMinVersion：" + c);
                    log("ARCH_TYPE_OLD_KEEP_LOCAL installLivenps null  downloadLivenps: " + bundleByType2.getVersionCode());
                    return 2;
                } else {
                    log("ARCH_TYPE_NEW：兜底");
                    return 3;
                }
            }
        }
        return invokeZ.intValue;
    }

    public static boolean isMultiPluginOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            AbConfigService abConfigService = abService;
            boolean z = false;
            if (abConfigService != null) {
                z = abConfigService.getSwitch(AB_TEST_ENABLE_NPS_MULTI_PLUGIN, false);
                log("isMultiPluginOn abService result: " + z);
            }
            log("isMultiPluginOn result: " + z);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean isNetworkAvailableForImmediately() {
        InterceptResult invokeV;
        NetworkInfo[] allNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (LiveNpsRuntime.getApplication() == null) {
                return false;
            }
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) LiveNpsRuntime.getApplication().getSystemService("connectivity");
                if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null && allNetworkInfo.length > 0) {
                    for (NetworkInfo networkInfo : allNetworkInfo) {
                        if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static void logCancelJoinLive(String str, boolean z, UBCManager uBCManager) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{str, Boolean.valueOf(z), uBCManager}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "live");
                if ("download".equals(str)) {
                    str2 = "entrance_download";
                } else if ("install".equals(str)) {
                    str2 = "entrance_install";
                } else if ("load".equals(str)) {
                    str2 = "entrance_load";
                } else {
                    str2 = "";
                }
                jSONObject.put("type", str2);
                jSONObject.put("value", "suc");
                if (z) {
                    jSONObject.put("page", "yyshow");
                } else {
                    jSONObject.put("page", "media");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (uBCManager != null) {
                uBCManager.onEvent("4417", jSONObject);
            }
        }
    }

    public static Map paramsJsonToMap(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (opt instanceof String) {
                    hashMap.put(next, (String) opt);
                } else {
                    hashMap.put(next, opt.toString());
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.Map] */
    public static String parserYYSchemaUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            HashMap stringToMap = stringToMap(getParamsStr(str));
            boolean containsKey = stringToMap.containsKey("params");
            HashMap hashMap = stringToMap;
            if (containsKey) {
                try {
                    hashMap = paramsJsonToMap(new JSONObject((String) stringToMap.get("params")));
                } catch (Exception unused) {
                    hashMap = null;
                }
            }
            if (hashMap != null) {
                return (String) hashMap.get("url");
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}
