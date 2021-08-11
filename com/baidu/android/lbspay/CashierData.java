package com.baidu.android.lbspay;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class CashierData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CUSTOMER_ID = "customerId";
    public static final String DEFAULT_RES_PAGE = "defaultResPage";
    public static String DELIVERY_CASHIER_CONTENT = "delivery_cashier_content";
    public static String DELIVERY_CASHIER_DATA = "delivery_cashier_data";
    public static final String DEVICE_TYPE = "deviceType";
    public static final String EXT_DATA = "extData";
    public static final String IMIE = "imei";
    public static final String ITEM_INFO = "itemInfo";
    public static final String MOBILE = "mobile";
    public static final String NOTIFY_URL = "notifyUrl";
    public static final String ORDERID = "orderId";
    public static final String ORDER_CREATE_TIME = "orderCreateTime";
    public static final String ORIGINALAMOUNT_AMOUNT = "originalAmount";
    public static final String PASS_UID = "passuid";
    public static final String PAY_AMOUNT = "payAmount";
    public static final String RETURN_URL = "returnUrl";
    public static final String SDK = "sdk";
    public static final String SDK_STYLE = "sdkStyle";
    public static final String SERVICE = "service";
    public static final String SIGN = "sign";
    public static final String SIGN_TYPE = "signType";
    public static final String TITLE = "title";
    public static final String TN = "tn";
    public static final String URL = "url";
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String customerId;
    public String defaultResPage;
    public String deviceType;
    public String extData;
    public String failUrl;
    public String fuser;
    public String imei;
    public String itemInfo;
    public Map<String, String> mData;
    public Map<String, String[]> mExtraData;
    public String mobile;
    public String notifyUrl;
    public String orderCreateTime;
    public String orderId;
    public String passuid;
    public String payAmount;
    public String returnUrl;
    public String sdk;
    public String service;
    public String sign;
    public String signType;
    public String title;
    public String tn;
    public String url;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-141286588, "Lcom/baidu/android/lbspay/CashierData;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-141286588, "Lcom/baidu/android/lbspay/CashierData;");
        }
    }

    public CashierData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.deviceType = "1";
        this.returnUrl = "";
        this.notifyUrl = "";
        this.imei = "";
        this.fuser = "";
        this.extData = "";
    }

    public void addParams(List<RestNameValuePair> list) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || (map = this.mData) == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key == null) {
                key = "";
            }
            if (value == null) {
                value = "";
            }
            list.add(new RestNameValuePair(key, value));
        }
    }

    public String amount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Map<String, String> map = this.mData;
            return map != null ? map.get("payAmount") : "";
        }
        return (String) invokeV.objValue;
    }

    public String getCustomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Map<String, String> map = this.mData;
            return map != null ? map.get("customerId") : "";
        }
        return (String) invokeV.objValue;
    }

    public Map<String, String> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mData : (Map) invokeV.objValue;
    }

    public String getGoodsName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Map<String, String> map = this.mData;
            return map != null ? map.get("title") : "";
        }
        return (String) invokeV.objValue;
    }

    public String[] getOderInfoDescArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Map<String, String[]> map = this.mExtraData;
            if (map != null) {
                return map.get("orderInfoDescArray");
            }
            return null;
        }
        return (String[]) invokeV.objValue;
    }

    public String getOrderNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Map<String, String> map = this.mData;
            return map != null ? map.get("orderId") : "";
        }
        return (String) invokeV.objValue;
    }

    public String originAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Map<String, String> map = this.mData;
            return map != null ? map.get("originalAmount") : "";
        }
        return (String) invokeV.objValue;
    }

    public void setData(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, map) == null) {
            this.mData = map;
        }
    }

    public void setExtraData(Map<String, String[]> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
            this.mExtraData = map;
        }
    }
}
