package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.hybrid.NamedBridgeHandler;
import com.baidu.tieba.ii;
import com.baidu.tieba.j45;
import com.baidu.tieba.ki;
import com.baidu.tieba.l45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.adapter.internal.CommonCode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
    public HybridUtilsBridgeHandler(j45 j45Var) {
        super(j45Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j45Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((j45) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @l45(isAsync = false, value = "showDeviceInfo")
    private JSONObject showDeviceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            String cuid = TbadkCoreApplication.getInst().getCuid();
            String k = ki.k();
            String g = ki.g();
            int l = ii.l(getContext());
            int j = ii.j(getContext());
            String str = String.valueOf(l) + "," + String.valueOf(j);
            String versionName = TbadkCoreApplication.getInst().getVersionName();
            try {
                jSONObject.put("systemName", "android");
                jSONObject.put("systemVersion", k);
                jSONObject.put("model", g);
                jSONObject.put("cuid", cuid);
                jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, str);
                jSONObject.put("appVersion", versionName);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @l45(isAsync = false, value = "showNetStatus")
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

    @l45(isAsync = false, value = "showToast")
    private void showToast(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        BdToast.b(getContext(), jSONObject.optString("message")).o();
    }
}
