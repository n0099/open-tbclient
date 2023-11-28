package com.baidu.tbadk.adBillingLog;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.NetMessageHelper;
import com.baidu.tieba.oq4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.AdNewLog.AdNewLogReqIdl;
import tbclient.AdNewLog.DataReq;
/* loaded from: classes4.dex */
public class AdBillingLogReqMsg extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oq4 mReqData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdBillingLogReqMsg() {
        super(CmdConfigHttp.CMD_AD_BILLING_LOG, 309711);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void fillReqData(DataReq.Builder builder) {
        oq4 oq4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, this, builder) != null) || (oq4Var = this.mReqData) == null) {
            return;
        }
        builder.token = oq4Var.d;
        int i = oq4Var.f;
        if (i >= 0) {
            builder.da_locate = String.valueOf(i);
        }
        int i2 = this.mReqData.b;
        if (i2 >= 0) {
            builder.da_from = Integer.valueOf(i2);
        }
        oq4 oq4Var2 = this.mReqData;
        builder.extra_param = oq4Var2.e;
        builder.order_id = oq4Var2.c;
        int i3 = oq4Var2.a;
        if (i3 >= 0) {
            builder.da_type = String.valueOf(i3);
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                fillReqData(builder);
                NetMessageHelper.bindCommonParamsToProtobufData(builder, true, true);
                AdNewLogReqIdl.Builder builder2 = new AdNewLogReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception e) {
                BdLog.e(e);
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public void setReqData(oq4 oq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oq4Var) == null) {
            this.mReqData = oq4Var;
        }
    }
}
