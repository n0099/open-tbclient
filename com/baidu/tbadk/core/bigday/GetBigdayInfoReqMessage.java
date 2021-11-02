package com.baidu.tbadk.core.bigday;

import b.a.e.e.p.l;
import b.a.q0.d1.z;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetBigday.DataReq;
import tbclient.GetBigday.GetBigdayReqIdl;
/* loaded from: classes8.dex */
public class GetBigdayInfoReqMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetBigdayInfoReqMessage() {
        super(CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609);
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

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                if (z) {
                    z.a(builder, true);
                }
                builder.scr_h = Integer.valueOf(l.i(TbadkCoreApplication.getInst().getContext()));
                builder.scr_w = Integer.valueOf(l.k(TbadkCoreApplication.getInst().getContext()));
                GetBigdayReqIdl.Builder builder2 = new GetBigdayReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }
}
