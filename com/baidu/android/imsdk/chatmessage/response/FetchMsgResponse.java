package com.baidu.android.imsdk.chatmessage.response;

import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class FetchMsgResponse implements IRequestResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long beginId;
    public int category;
    public long contacter;
    public int count;
    public long endId;
    public int errorCode;
    public int fetchReason;
    public boolean hasMore;
    public boolean isFirstSync;
    public String listenerkey;
    public long maxMsgid;
    public List<ChatMsg> msgs;
    public int realCount;
    public String strMsg;
    public String uuid;

    public FetchMsgResponse() {
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
        this.isFirstSync = false;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "FetchMsgResponse{hasMore=" + this.hasMore + "isFirstSync=" + this.isFirstSync + ", errorCode=" + this.errorCode + ", strMsg='" + this.strMsg + "', category=" + this.category + ", contacter=" + this.contacter + ", beginId=" + this.beginId + ", endId=" + this.endId + ", count=" + this.count + ", realCount=" + this.realCount + ", maxMsgid=" + this.maxMsgid + ", uuid='" + this.uuid + "', msgs=" + this.msgs + ", listenerkey='" + this.listenerkey + "', fetchReason = " + this.fetchReason + '}';
        }
        return (String) invokeV.objValue;
    }
}
