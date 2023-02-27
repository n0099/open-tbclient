package com.baidu.pass.ecommerce;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.ecommerce.EcommerceRouter;
import com.baidu.sapi2.ecommerce.activity.AddressEditActivity;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.stat.AddressManagerStat;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.StatService;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class AddressStatUtil {
    public static final String TAG = "AddressStatUtil";

    public static HashMap<String, String> getCommonParamsMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("scene", "api");
        AddressManageDTO addressManageDTO = EcommerceRouter.getInstance().getAddressManageDTO();
        if (addressManageDTO != null) {
            hashMap.put("tplse", addressManageDTO.tplse);
            hashMap.put("tplt", addressManageDTO.tplt);
        }
        return hashMap;
    }

    public static void statAddressOption(String str) {
        HashMap<String, String> commonParamsMap = getCommonParamsMap();
        commonParamsMap.put("name", "auto_statistic");
        commonParamsMap.put("eventType", str);
        commonParamsMap.put("v", String.valueOf(System.currentTimeMillis()));
        commonParamsMap.put("clientfrom", "mobilesdk_enhanced");
        String str2 = AddressEditActivity.sFromType;
        if (str2 != null) {
            commonParamsMap.put(SapiAccount.SAPI_ACCOUNT_FROMTYPE, str2);
        }
        Log.d(TAG, "statAddressOption key=" + str);
        AddressManagerStat.statExtMap.put(str, "1");
        StatService.onEventAutoStat(str, commonParamsMap);
    }

    public static void statAddressOption(String str, long j) {
        HashMap<String, String> commonParamsMap = getCommonParamsMap();
        commonParamsMap.put("time", "" + j);
        commonParamsMap.put("name", "auto_statistic");
        commonParamsMap.put("eventType", str);
        commonParamsMap.put("v", String.valueOf(System.currentTimeMillis()));
        commonParamsMap.put("clientfrom", "mobilesdk_enhanced");
        String str2 = AddressEditActivity.sFromType;
        if (str2 != null) {
            commonParamsMap.put(SapiAccount.SAPI_ACCOUNT_FROMTYPE, str2);
        }
        Log.d(TAG, "statAddressOption key=" + str + " time=" + j);
        AddressManagerStat.statExtMap.put(str, "1");
        StatService.onEventAutoStat(str, commonParamsMap);
    }

    public static void statAddressOption(String str, HashMap<String, String> hashMap) {
        HashMap<String, String> commonParamsMap = getCommonParamsMap();
        commonParamsMap.putAll(hashMap);
        commonParamsMap.put("name", "auto_statistic");
        commonParamsMap.put("eventType", str);
        commonParamsMap.put("v", String.valueOf(System.currentTimeMillis()));
        commonParamsMap.put("clientfrom", "mobilesdk_enhanced");
        String str2 = AddressEditActivity.sFromType;
        if (str2 != null) {
            commonParamsMap.put(SapiAccount.SAPI_ACCOUNT_FROMTYPE, str2);
        }
        Log.d(TAG, "statAddressOption key=" + str);
        AddressManagerStat.statExtMap.put(str, hashMap);
        StatService.onEventAutoStat(str, commonParamsMap);
    }
}
