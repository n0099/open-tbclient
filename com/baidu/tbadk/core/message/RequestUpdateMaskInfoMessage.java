package com.baidu.tbadk.core.message;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.UpdateMaskInfo.DataReq;
import protobuf.UpdateMaskInfo.UpdateMaskInfoReqIdl;
/* loaded from: classes6.dex */
public class RequestUpdateMaskInfoMessage extends TbSocketMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FALSE = 0;
    public static final int SWITCH_PRIVATE_CHAT_SINGLE = 9;
    public static final int TBR_RECEVIER_MSG_CALL_FROM_MESSAGE = 1;
    public static final int TBR_RECEVIER_MSG_CALL_FROM_PERSONAL = 2;
    public static final int TBR_RECEVIER_MSG_CALL_FROM_SETTING = 5;
    public static final int TRUE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int call_from;
    public long g_id;
    public int isMask;
    public String list;
    public int maskType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestUpdateMaskInfoMessage() {
        super(104102);
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
        this.call_from = 1;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.type = Integer.valueOf(this.maskType);
            builder.isMask = Integer.valueOf(this.isMask);
            builder.list = this.list;
            builder.g_id = Long.valueOf(this.g_id);
            builder.call_from = Integer.valueOf(this.call_from);
            UpdateMaskInfoReqIdl.Builder builder2 = new UpdateMaskInfoReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeV.objValue;
    }

    public int getCallFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.call_from : invokeV.intValue;
    }

    public long getG_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g_id : invokeV.longValue;
    }

    public int getIsMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.isMask : invokeV.intValue;
    }

    public String getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.list : (String) invokeV.objValue;
    }

    public int getMaskType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.maskType : invokeV.intValue;
    }

    public boolean isMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.isMask == 1 : invokeV.booleanValue;
    }

    public boolean isSettingMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.isMask != 1 : invokeV.booleanValue;
    }

    public void setCallFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.call_from = i2;
        }
    }

    public void setG_id(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            this.g_id = j2;
        }
    }

    public void setIsMask(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.isMask = i2;
        }
    }

    public void setList(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.list = str;
        }
    }

    public void setMask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.isMask = z ? 1 : 0;
        }
    }

    public void setMaskType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.maskType = i2;
        }
    }

    public void setSettingMask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.isMask = !z ? 1 : 0;
        }
    }
}
