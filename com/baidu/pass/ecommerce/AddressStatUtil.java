package com.baidu.pass.ecommerce;

import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.ecommerce.EcommerceRouter;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.StatService;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public class AddressStatUtil {
    public static final String TAG = "AddressStatUtil";

    public static HashMap<String, String> getCommonParamsMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("scene", RetrieveTaskManager.KEY);
        AddressManageDTO addressManageDTO = EcommerceRouter.getInstance().getAddressManageDTO();
        if (addressManageDTO != null) {
            hashMap.put("tplse", addressManageDTO.tplse);
            hashMap.put("tplt", addressManageDTO.tplt);
        }
        return hashMap;
    }

    public static void onEventAutoStatistic(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(2);
        linkedHashMap.put("eventType", str);
        linkedHashMap.put(SapiAccount.SAPI_ACCOUNT_FROMTYPE, str2);
        StatService.onEventAutoStatistic(linkedHashMap);
    }

    public static void statAddressOption(String str, long j) {
        HashMap<String, String> commonParamsMap = getCommonParamsMap();
        commonParamsMap.put("time", "" + j);
        Log.d(TAG, "statAddressOption key=" + str + " time=" + j);
        StatService.onEvent(str, commonParamsMap);
    }

    public static void statAddressOption(String str) {
        HashMap<String, String> commonParamsMap = getCommonParamsMap();
        Log.d(TAG, "statAddressOption key=" + str);
        StatService.onEvent(str, commonParamsMap);
    }

    public static void statAddressOption(String str, HashMap<String, String> hashMap) {
        HashMap<String, String> commonParamsMap = getCommonParamsMap();
        commonParamsMap.putAll(hashMap);
        Log.d(TAG, "statAddressOption key=" + str);
        StatService.onEvent(str, commonParamsMap);
    }
}
