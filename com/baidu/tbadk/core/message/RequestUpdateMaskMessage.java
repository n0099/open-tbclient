package com.baidu.tbadk.core.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.UpdateMask.DataReq;
import protobuf.UpdateMask.UpdateMaskReqIdl;
/* loaded from: classes5.dex */
public class RequestUpdateMaskMessage extends TbSocketMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FALSE = 0;
    public static final int TRUE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String gids;
    public int isAdd;
    public int isMask;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestUpdateMaskMessage() {
        super(104101);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.gids = this.gids;
            builder.isAdd = Integer.valueOf(this.isAdd);
            builder.maskRemind = Integer.valueOf(this.isMask);
            UpdateMaskReqIdl.Builder builder2 = new UpdateMaskReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeV.objValue;
    }

    public boolean isAdd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isAdd == 0 : invokeV.booleanValue;
    }

    public boolean isSettingMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isMask != 1 : invokeV.booleanValue;
    }

    public void setGids(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.gids = str;
        }
    }

    public void setIsAdd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.isAdd = !z ? 1 : 0;
        }
    }

    public void setSettingMask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.isMask = !z ? 1 : 0;
        }
    }
}
