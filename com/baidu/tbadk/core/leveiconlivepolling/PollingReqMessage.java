package com.baidu.tbadk.core.leveiconlivepolling;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.ss5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Loop.DataReq;
import tbclient.Loop.LoopReqIdl;
/* loaded from: classes4.dex */
public class PollingReqMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long chatroomId;
    public Integer chatroomMask;
    public String dataType;
    public String forumName;
    public String mListMsg;
    public String uniqueId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PollingReqMessage() {
        super(CmdConfigHttp.CMD_HTTP_POLLING_INTERFACE, 309732);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PollingReqMessage(int i, int i2, BdUniqueId bdUniqueId) {
        super(i, i2, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            String str = this.dataType;
            builder.data_type = str;
            builder.uniq_id = this.uniqueId;
            if (!StringUtils.isNull(str) && PollingModel.CHATROOM_FRS.equals(this.dataType)) {
                builder.chatroom_id = Long.valueOf(this.chatroomId);
                if (!StringUtils.isNull(this.forumName)) {
                    builder.forum_name = this.forumName;
                }
                if (!TextUtils.isEmpty(this.mListMsg)) {
                    builder.chatroom_new_msg = this.mListMsg;
                }
                Integer num = this.chatroomMask;
                if (num != null) {
                    builder.chatroom_mask = num;
                }
            }
            if (!StringUtils.isNull(this.forumName)) {
                builder.forum_name = this.forumName;
            }
            if (!TextUtils.isEmpty(this.dataType) && PollingModel.SUBSCRIBE_GROUP_CHAT_LIST.equals(this.dataType)) {
                if (!TextUtils.isEmpty(this.mListMsg)) {
                    builder.chatroom_new_msg = this.mListMsg;
                }
                if (!TextUtils.isEmpty(this.uniqueId)) {
                    builder.uniq_id = this.uniqueId;
                }
            }
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                ss5.a(builder, true);
            }
            LoopReqIdl.Builder builder2 = new LoopReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public long getChatroomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.chatroomId;
        }
        return invokeV.longValue;
    }

    public int getChatroomMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.chatroomMask.intValue();
        }
        return invokeV.intValue;
    }

    public String getDataType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.dataType;
        }
        return (String) invokeV.objValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.forumName;
        }
        return (String) invokeV.objValue;
    }

    public String getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.uniqueId;
        }
        return (String) invokeV.objValue;
    }

    public void setChatroomId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.chatroomId = j;
        }
    }

    public void setChatroomMask(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.chatroomMask = Integer.valueOf(i);
        }
    }

    public void setDataRoomListMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mListMsg = str;
        }
    }

    public void setDataType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.dataType = str;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.forumName = str;
        }
    }

    public void setUniqueId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.uniqueId = str;
        }
    }
}
