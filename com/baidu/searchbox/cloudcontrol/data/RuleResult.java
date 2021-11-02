package com.baidu.searchbox.cloudcontrol.data;

import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class RuleResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ICloudControlProcessor mProcessor;
    public String mServiceName;

    public RuleResult() {
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

    public static RuleResult make(String str, ICloudControlProcessor iCloudControlProcessor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, iCloudControlProcessor)) == null) {
            RuleResult ruleResult = new RuleResult();
            ruleResult.mServiceName = str;
            ruleResult.mProcessor = iCloudControlProcessor;
            return ruleResult;
        }
        return (RuleResult) invokeLL.objValue;
    }
}
