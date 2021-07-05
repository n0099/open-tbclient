package com.baidu.android.imrtc.utils;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class BIMRtcEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CREATE_ACTION = -10;
    public static final int TOKEN_ACTION = -11;
    public transient /* synthetic */ FieldHolder $fh;
    public String ext;
    public int notifyAction;
    public String notifyRoomId;
    public long notifySeqId;
    public int requestAction;
    public String requestRoomId;
    public int sdkAction;
    public String sdkRoomId;
    public long sdkSeqId;
    public int serverAction;
    public String serverRoomId;
    public long serverSedId;

    public BIMRtcEvent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.requestAction = -1;
        this.requestRoomId = "-1";
        this.notifyAction = -1;
        this.notifyRoomId = "-1";
        this.notifySeqId = -1L;
        this.sdkAction = -1;
        this.sdkRoomId = "-1";
        this.sdkSeqId = -1L;
        this.serverAction = -1;
        this.serverRoomId = "-1";
        this.serverSedId = -1L;
        this.ext = "";
    }

    public String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("BIMRtcEvent——Action,RoomId,SeqId {request: ");
            sb.append(this.requestAction);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.requestRoomId);
            sb.append("; sdk: ");
            sb.append(this.sdkAction);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.sdkRoomId);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.sdkSeqId);
            sb.append("; server: ");
            sb.append(this.serverAction);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.serverRoomId);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.serverSedId);
            sb.append("; notify: ");
            sb.append(this.notifyAction);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.notifyRoomId);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.notifySeqId);
            if (this.requestAction == -10) {
                str = ", ext: " + this.ext;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
