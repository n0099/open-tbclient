package com.baidu.searchbox.config.eventmessage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class CommonEventMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_INVALID = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public int arg0;
    public int arg1;
    public int messageId;
    public Object obj;

    public CommonEventMessage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.messageId = i;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "messageId=" + this.messageId + " arg0=" + this.arg0 + " arg1=" + this.arg1;
        }
        return (String) invokeV.objValue;
    }
}
