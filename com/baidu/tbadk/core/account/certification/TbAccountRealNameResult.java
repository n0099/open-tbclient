package com.baidu.tbadk.core.account.certification;

import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TbAccountRealNameResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String callbackkey;
    public int errorStep;
    public boolean juniorRealNameSuc;
    public int resultCode;
    public String resultMsg;
    public boolean seniorRealNameSuc;
    public int subResultCode;
    public String subResultMsg;

    public TbAccountRealNameResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.resultCode = -202;
        this.subResultCode = -100000;
        this.subResultMsg = "未触发任何实名操作返回或实名时放弃返回";
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.juniorRealNameSuc && this.seniorRealNameSuc) {
                return 3;
            }
            if (this.seniorRealNameSuc) {
                return 2;
            }
            if (this.juniorRealNameSuc) {
                return 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static TbAccountRealNameResult parse(AccountRealNameResult accountRealNameResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, accountRealNameResult)) == null) {
            TbAccountRealNameResult tbAccountRealNameResult = new TbAccountRealNameResult();
            tbAccountRealNameResult.resultCode = accountRealNameResult.getResultCode();
            tbAccountRealNameResult.resultMsg = accountRealNameResult.getResultMsg();
            tbAccountRealNameResult.errorStep = accountRealNameResult.errorStep;
            tbAccountRealNameResult.callbackkey = accountRealNameResult.callbackkey;
            tbAccountRealNameResult.juniorRealNameSuc = accountRealNameResult.juniorRealNameSuc;
            tbAccountRealNameResult.seniorRealNameSuc = accountRealNameResult.seniorRealNameSuc;
            tbAccountRealNameResult.subResultCode = accountRealNameResult.subResultCode;
            tbAccountRealNameResult.subResultMsg = accountRealNameResult.subResultMsg;
            return tbAccountRealNameResult;
        }
        return (TbAccountRealNameResult) invokeL.objValue;
    }
}
