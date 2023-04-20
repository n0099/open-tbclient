package com.baidu.tbadk.BdToken;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.BdTokenController;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.rq5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetUserByTiebaUid.DataReq;
import tbclient.GetUserByTiebaUid.GetUserByTiebaUidReqIdl;
/* loaded from: classes3.dex */
public class TiebaUidCheckReqMsg extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTokenController.m mTiebaUidData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TiebaUidCheckReqMsg() {
        super(CmdConfigHttp.CMD_HTTP_TIEBA_UID_CHECK, 309702);
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

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                if (this.mTiebaUidData.b() != null) {
                    builder.tieba_uid = this.mTiebaUidData.b();
                }
                rq5.c(builder, true, true, true);
                GetUserByTiebaUidReqIdl.Builder builder2 = new GetUserByTiebaUidReqIdl.Builder();
                builder2.data = builder.build(true);
                return builder2.build(true);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public void setTiebaUid(BdTokenController.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar) == null) {
            this.mTiebaUidData = mVar;
        }
    }
}
