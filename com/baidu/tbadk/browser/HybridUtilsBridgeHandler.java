package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.android.ext.manage.PopItemMethodConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.hybrid.NamedBridgeHandler;
import com.baidu.tieba.p85;
import com.baidu.tieba.r85;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.adapter.internal.CommonCode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class HybridUtilsBridgeHandler extends NamedBridgeHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tbadk.core.hybrid.NamedBridgeHandler
    public String scope() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Utils" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HybridUtilsBridgeHandler(p85 p85Var) {
        super(p85Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p85Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((p85) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @r85(isAsync = false, value = "showDeviceInfo")
    private JSONObject showDeviceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            String cuid = TbadkCoreApplication.getInst().getCuid();
            String osVersion = DeviceInfoHelper.getOsVersion();
            String model = DeviceInfoHelper.getModel();
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(getContext());
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(getContext());
            String str = String.valueOf(equipmentWidth) + "," + String.valueOf(equipmentHeight);
            String versionName = TbadkCoreApplication.getInst().getVersionName();
            try {
                jSONObject.put("systemName", "android");
                jSONObject.put("systemVersion", osVersion);
                jSONObject.put("model", model);
                jSONObject.put("cuid", cuid);
                jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, str);
                jSONObject.put("appVersion", versionName);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @r85(isAsync = false, value = "showNetStatus")
    private JSONObject showNetStatus() {
        InterceptResult invokeV;
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (BdNetTypeUtil.isWifiNet()) {
                i = 1;
                str = "WIFI";
            } else if (BdNetTypeUtil.is2GNet()) {
                i = 3;
                str = "2G";
            } else if (BdNetTypeUtil.is3GNet()) {
                i = 4;
                str = "3G";
            } else if (BdNetTypeUtil.is4GNet()) {
                i = 5;
                str = "4G";
            } else {
                i = 0;
                str = "NotReachable";
            }
            try {
                jSONObject.put("netStatus", i);
                jSONObject.put("netDesc", str);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @r85(isAsync = false, value = PopItemMethodConstant.showToast)
    private void showToast(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        BdToast.makeText(getContext(), jSONObject.optString("message")).show();
    }
}
