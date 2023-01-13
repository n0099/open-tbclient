package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.nk5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ActiveConfig.ActiveConfigReqIdl;
import tbclient.ActiveConfig.DataReq;
/* loaded from: classes3.dex */
public class ActiveConfigReqMsg extends NetMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LAUNTCH_FROM_HOME_PAGE = 1;
    public static final int LAUNTCH_FROM_START = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isFirstUp;
    public boolean isSchemaUp;
    public int launtchType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActiveConfigReqMsg() {
        super(CmdConfigHttp.CMD_ACTIVE_CONFIG, 309637);
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
        this.launtchType = 0;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                if (this.isFirstUp) {
                    builder.is_first_up = 1;
                } else {
                    builder.is_first_up = 0;
                }
                if (this.isSchemaUp) {
                    builder.is_schema_up = 1;
                } else {
                    builder.is_schema_up = 0;
                }
                nk5.c(builder, true, true, false);
                ActiveConfigReqIdl.Builder builder2 = new ActiveConfigReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public void setFirstUp(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.isFirstUp = z;
        }
    }

    public void setSchemaUp(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.isSchemaUp = z;
        }
    }
}
