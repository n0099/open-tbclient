package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SapiDeviceInfo implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AES_KEY;
    public static final String DELIMITER;
    public static final String OS_TYPE = "android";
    public static final int VERSION = 11;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static final class DeviceInfoCookieManager {
        public static /* synthetic */ Interceptable $ic;
        public static Map<String, String> cookiesMap;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1433266239, "Lcom/baidu/sapi2/utils/SapiDeviceInfo$DeviceInfoCookieManager;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1433266239, "Lcom/baidu/sapi2/utils/SapiDeviceInfo$DeviceInfoCookieManager;");
                    return;
                }
            }
            cookiesMap = new HashMap();
        }

        public DeviceInfoCookieManager() {
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

        public static List<String> getCookiesKeyList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("PackageName");
                arrayList.add("AppVersion");
                arrayList.add("SdkVersion");
                arrayList.add("PhoneModel");
                arrayList.add("SystemVersion");
                arrayList.add("SystemType");
                arrayList.add("cuid");
                arrayList.add("tpl");
                arrayList.add("uid_count");
                arrayList.add("uid_list");
                arrayList.add("usetype");
                arrayList.add("used_times");
                arrayList.add("cur_uid");
                arrayList.add("net_type");
                arrayList.add("is_root");
                arrayList.add("wifi");
                arrayList.add("imei");
                arrayList.add("emulator");
                arrayList.add("mac_address");
                arrayList.add("cpu_info");
                arrayList.add("ram");
                arrayList.add("internal_memory");
                arrayList.add("internal_avail_memory");
                arrayList.add("up_time");
                arrayList.add("gps");
                arrayList.add("package_list");
                arrayList.add("ip");
                arrayList.add("device_name");
                arrayList.add(SuggestAddrField.KEY_MAP_LOCATION);
                arrayList.add("device_sn");
                arrayList.add("device_uuid");
                arrayList.add("mtj_cuid");
                arrayList.add("idfa");
                arrayList.add("baidumap_cuid");
                arrayList.add("sf_zid");
                arrayList.add("hostver");
                arrayList.add("iccid");
                arrayList.add("pass_bio_ver");
                arrayList.add("t_cuid");
                arrayList.add("t_appname");
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public static void updateCookiesMap(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, null, list) == null) {
                List<String> cookiesKeyList = getCookiesKeyList();
                for (int i = 0; i < cookiesKeyList.size() && i < list.size(); i++) {
                    cookiesMap.put(cookiesKeyList.get(i), list.get(i));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1472341312, "Lcom/baidu/sapi2/utils/SapiDeviceInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1472341312, "Lcom/baidu/sapi2/utils/SapiDeviceInfo;");
                return;
            }
        }
        DELIMITER = Character.toString((char) 1);
        AES_KEY = TextUtils.join("", new String[]{"O", "a", "L", "h", "z", "O", "K", "T", "T", "Q", "G", "L", "w", "8", "h", "P"});
    }

    public SapiDeviceInfo() {
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

    public static List<String> buildDeviceTokens(String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
            SapiConfiguration confignation = isAccountManager.getConfignation();
            Context context = confignation.context;
            List<Integer> diExceptIndex = SapiContext.getInstance().getDiExceptIndex();
            JSONArray grayControlParams = ParamsUtil.getGrayControlParams();
            ArrayList arrayList = new ArrayList();
            String str7 = "";
            arrayList.add((diExceptIndex.contains(0) || !ParamsUtil.checkDiUpload(grayControlParams, 0)) ? "" : context.getPackageName());
            arrayList.add((diExceptIndex.contains(1) || !ParamsUtil.checkDiUpload(grayControlParams, 1)) ? "" : SapiUtils.getVersionName(context));
            arrayList.add((diExceptIndex.contains(2) || !ParamsUtil.checkDiUpload(grayControlParams, 2)) ? "" : isAccountManager.getVersionName());
            arrayList.add((diExceptIndex.contains(3) || !ParamsUtil.checkDiUpload(grayControlParams, 3)) ? "" : getOSModel());
            arrayList.add((diExceptIndex.contains(4) || !ParamsUtil.checkDiUpload(grayControlParams, 4)) ? "" : getOSVersion());
            String str8 = "android";
            arrayList.add((diExceptIndex.contains(5) || !ParamsUtil.checkDiUpload(grayControlParams, 5)) ? "" : "android");
            arrayList.add((diExceptIndex.contains(6) || !ParamsUtil.checkDiUpload(grayControlParams, 6)) ? "" : SapiUtils.getClientId(context));
            arrayList.add((diExceptIndex.contains(7) || !ParamsUtil.checkDiUpload(grayControlParams, 7)) ? "" : confignation.tpl);
            arrayList.add("");
            arrayList.add("");
            arrayList.add((diExceptIndex.contains(10) || !ParamsUtil.checkDiUpload(grayControlParams, 10) || str == null) ? "" : "");
            arrayList.add((diExceptIndex.contains(11) || !ParamsUtil.checkDiUpload(grayControlParams, 11)) ? "" : String.valueOf(SapiContext.getInstance().getDeviceInfoReadTimes()));
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            arrayList.add((diExceptIndex.contains(12) || !ParamsUtil.checkDiUpload(grayControlParams, 12) || currentAccount == null) ? "" : currentAccount.uid);
            arrayList.add((diExceptIndex.contains(13) || !ParamsUtil.checkDiUpload(grayControlParams, 13)) ? "" : SapiUtils.getNetworkClass(context));
            if (diExceptIndex.contains(14) || !ParamsUtil.checkDiUpload(grayControlParams, 14)) {
                str2 = "";
            } else {
                str2 = SapiContext.getInstance().getRootStatus();
                if (TextUtils.isEmpty(str2)) {
                    str2 = String.valueOf(SapiUtils.isRoot());
                    SapiContext.getInstance().setRootStatus(str2);
                }
            }
            arrayList.add(str2);
            arrayList.add((diExceptIndex.contains(15) || !ParamsUtil.checkDiUpload(grayControlParams, 15)) ? "" : SapiUtils.getWifiInfo(context));
            arrayList.add((diExceptIndex.contains(16) || !ParamsUtil.checkDiUpload(grayControlParams, 16)) ? "" : SapiDeviceUtils.getIMEI(context));
            if (diExceptIndex.contains(17) || !ParamsUtil.checkDiUpload(grayControlParams, 17)) {
                str8 = "";
            } else if (SapiUtils.isEmulator(context)) {
                str8 = "emulator";
            }
            arrayList.add(str8);
            arrayList.add("");
            arrayList.add((diExceptIndex.contains(19) || !ParamsUtil.checkDiUpload(grayControlParams, 19) || SapiUtils.getCpuName() == null) ? "" : SapiUtils.getCpuName());
            arrayList.add((diExceptIndex.contains(20) || !ParamsUtil.checkDiUpload(grayControlParams, 20)) ? "" : SapiUtils.getRamMemorySize());
            if (diExceptIndex.contains(21) || !ParamsUtil.checkDiUpload(grayControlParams, 21)) {
                str3 = "";
            } else {
                str3 = SapiUtils.getInternalMemorySize() + "";
            }
            arrayList.add(str3);
            if (diExceptIndex.contains(22) || !ParamsUtil.checkDiUpload(grayControlParams, 22)) {
                str4 = "";
            } else {
                str4 = SapiUtils.getInternalAvailableMemorySize() + "";
            }
            arrayList.add(str4);
            if (diExceptIndex.contains(23) || !ParamsUtil.checkDiUpload(grayControlParams, 23)) {
                str5 = "";
            } else {
                str5 = SapiUtils.getTimeSinceBoot() + "";
            }
            arrayList.add(str5);
            if (!diExceptIndex.contains(24)) {
                ParamsUtil.checkDiUpload(grayControlParams, 24);
            }
            arrayList.add("");
            arrayList.add((diExceptIndex.contains(25) || !ParamsUtil.checkDiUpload(grayControlParams, 25)) ? "" : TextUtils.join(",", SapiUtils.getPackageList(context)));
            arrayList.add((diExceptIndex.contains(26) || !ParamsUtil.checkDiUpload(grayControlParams, 26) || SapiUtils.getLocalIpAddress() == null) ? "" : "");
            String deviceName = SapiUtils.getDeviceName();
            if (TextUtils.isEmpty(deviceName)) {
                deviceName = SapiUtils.getBlueToothDeviceName(context);
            }
            arrayList.add((diExceptIndex.contains(27) || !ParamsUtil.checkDiUpload(grayControlParams, 27)) ? "" : "");
            if (!diExceptIndex.contains(28)) {
                ParamsUtil.checkDiUpload(grayControlParams, 28);
            }
            arrayList.add("");
            arrayList.add("");
            arrayList.add("");
            arrayList.add("");
            arrayList.add("");
            arrayList.add("");
            arrayList.add((diExceptIndex.contains(34) || !ParamsUtil.checkDiUpload(grayControlParams, 34)) ? "" : isAccountManager.getCurrentZid(context));
            if (!diExceptIndex.contains(35)) {
                ParamsUtil.checkDiUpload(grayControlParams, 35);
            }
            arrayList.add("");
            arrayList.add((diExceptIndex.contains(36) || !ParamsUtil.checkDiUpload(grayControlParams, 36)) ? "" : SapiUtils.getIccid(context));
            arrayList.add((diExceptIndex.contains(37) || !ParamsUtil.checkDiUpload(grayControlParams, 37)) ? "" : "9.5.5");
            arrayList.add((diExceptIndex.contains(38) || !ParamsUtil.checkDiUpload(grayControlParams, 38)) ? "" : SapiUtils.getClientId(context));
            if (!diExceptIndex.contains(39) && ParamsUtil.checkDiUpload(grayControlParams, 39) && (str6 = confignation.mTAppName) != null) {
                str7 = str6;
            }
            arrayList.add(str7);
            Log.e("privacy_parameter_control", "token=" + arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String buildIV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return String.format("%02d", Integer.valueOf(new Random().nextInt(100))) + (System.currentTimeMillis() / 1000) + String.format("%03d", 11) + "0";
        }
        return (String) invokeV.objValue;
    }

    public static String encryptDeviceInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                String buildIV = buildIV();
                String base64Encode = SecurityUtil.base64Encode(SecurityUtil.aesEncrypt(str, buildIV, AES_KEY));
                return TextUtils.join("_", new String[]{buildIV, base64Encode, SecurityUtil.md5(TextUtils.join("_", new String[]{buildIV, base64Encode, "check"}).getBytes(), false).substring(0, 6)});
            } catch (Throwable th) {
                Log.e(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getDeviceInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            List<String> buildDeviceTokens = buildDeviceTokens(str);
            DeviceInfoCookieManager.updateCookiesMap(buildDeviceTokens);
            return encryptDeviceInfo(TextUtils.join(DELIMITER, buildDeviceTokens));
        }
        return (String) invokeL.objValue;
    }

    public static String getDiCookieInfo(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, list)) == null) ? getDiCookieInfo(list, true) : (String) invokeL.objValue;
    }

    public static String getOSModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "" : (String) invokeV.objValue;
    }

    public static String getOSVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? !TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE : "" : (String) invokeV.objValue;
    }

    public static String getDiCookieInfo(List<String> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, list, z)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (DeviceInfoCookieManager.cookiesMap.isEmpty() || list == null) {
                return null;
            }
            for (String str : list) {
                try {
                    jSONObject.put(str, DeviceInfoCookieManager.cookiesMap.get(str));
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            if ("NoZidYet".equals(jSONObject.optString("sf_zid"))) {
                try {
                    ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
                    SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                    jSONObject.put("sf_zid", isAccountManager.getZidAndCheckSafe(isAccountManager.getConfignation().context, currentAccount == null ? null : currentAccount.uid, 120));
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            if (jSONObject.length() == 0) {
                return null;
            }
            Log.e("privacy_parameter_control", "diObj=" + jSONObject);
            if (z) {
                return encryptDeviceInfo(jSONObject.toString());
            }
            return jSONObject.toString();
        }
        return (String) invokeLZ.objValue;
    }
}
