package com.baidu.pass.ecommerce;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.ecommerce.EcommerceRouter;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.StatService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes10.dex */
public class AddressStatUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AddressStatUtil";
    public transient /* synthetic */ FieldHolder $fh;

    public AddressStatUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static HashMap<String, String> getCommonParamsMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("scene", RetrieveTaskManager.KEY);
            AddressManageDTO addressManageDTO = EcommerceRouter.getInstance().getAddressManageDTO();
            if (addressManageDTO != null) {
                hashMap.put("tplse", addressManageDTO.tplse);
                hashMap.put("tplt", addressManageDTO.tplt);
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public static void onEventAutoStatistic(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(2);
            linkedHashMap.put("eventType", str);
            linkedHashMap.put(SapiAccount.SAPI_ACCOUNT_FROMTYPE, str2);
            StatService.onEventAutoStatistic(linkedHashMap);
        }
    }

    public static void statAddressOption(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, j2) == null) {
            HashMap<String, String> commonParamsMap = getCommonParamsMap();
            commonParamsMap.put("time", "" + j2);
            Log.d(TAG, "statAddressOption key=" + str + " time=" + j2);
            StatService.onEvent(str, commonParamsMap);
        }
    }

    public static void statAddressOption(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            HashMap<String, String> commonParamsMap = getCommonParamsMap();
            Log.d(TAG, "statAddressOption key=" + str);
            StatService.onEvent(str, commonParamsMap);
        }
    }

    public static void statAddressOption(String str, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, hashMap) == null) {
            HashMap<String, String> commonParamsMap = getCommonParamsMap();
            commonParamsMap.putAll(hashMap);
            Log.d(TAG, "statAddressOption key=" + str);
            StatService.onEvent(str, commonParamsMap);
        }
    }
}
