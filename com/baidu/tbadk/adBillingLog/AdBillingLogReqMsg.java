package com.baidu.tbadk.adBillingLog;

import c.a.r0.d.c;
import c.a.r0.d1.b0;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.AdNewLog.AdNewLogReqIdl;
import tbclient.AdNewLog.DataReq;
/* loaded from: classes11.dex */
public class AdBillingLogReqMsg extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c mReqData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdBillingLogReqMsg() {
        super(CmdConfigHttp.CMD_AD_BILLING_LOG, 309711);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void fillReqData(DataReq.Builder builder) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, builder) == null) || (cVar = this.mReqData) == null) {
            return;
        }
        builder.token = cVar.f12126d;
        int i2 = cVar.f12128f;
        if (i2 >= 0) {
            builder.da_locate = String.valueOf(i2);
        }
        int i3 = this.mReqData.f12124b;
        if (i3 >= 0) {
            builder.da_from = Integer.valueOf(i3);
        }
        c cVar2 = this.mReqData;
        builder.extra_param = cVar2.f12127e;
        builder.order_id = cVar2.f12125c;
        int i4 = cVar2.a;
        if (i4 >= 0) {
            builder.da_type = String.valueOf(i4);
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
                b0.b(builder, true, true);
                AdNewLogReqIdl.Builder builder2 = new AdNewLogReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public void setReqData(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.mReqData = cVar;
        }
    }
}
