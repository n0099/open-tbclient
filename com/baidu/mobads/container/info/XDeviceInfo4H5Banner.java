package com.baidu.mobads.container.info;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.util.APKStateManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class XDeviceInfo4H5Banner extends XDeviceInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XDeviceInfo4H5Banner(XAdContainerContext xAdContainerContext) {
        super(xAdContainerContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xAdContainerContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((XAdContainerContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.mobads.container.info.XDeviceInfo
    public JSONObject getConfs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject confs = super.getConfs();
            if (confs != null) {
                try {
                    confs.putOpt("WRAPPER", "android");
                    confs.putOpt("PRELOAD", Boolean.FALSE);
                    JSONObject jSONObject = confs.getJSONObject("FET");
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put("MSSP", true);
                    confs.put("iadex", APKStateManager.getInstance().getIADEXValue(this.mAdContainerCxt.getAppContext()));
                    confs.put("FET", jSONObject);
                    confs.put(IAdRequestParam.MSA, 1);
                    handleAbility(confs);
                } catch (Exception e2) {
                    this.logger.d(e2);
                }
            }
            return confs;
        }
        return (JSONObject) invokeV.objValue;
    }
}
