package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public interface IChatRoomFetchListener extends IMListener {
    void onResult(int i, String str, List<RoomMsgInfo> list);

    /* loaded from: classes.dex */
    public static class RoomMsgInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int errorCode;
        public long mcastId;
        public List<ChatMsg> msgs;
        public long roomId;

        public RoomMsgInfo() {
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
            this.errorCode = -1;
            this.msgs = new ArrayList();
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "ChatRoomInfo{roomId=" + this.roomId + ", mcastId=" + this.mcastId + ", msgs=" + this.msgs.toString() + '}';
            }
            return (String) invokeV.objValue;
        }
    }
}
