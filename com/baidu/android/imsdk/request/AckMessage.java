package com.baidu.android.imsdk.request;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class AckMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int RETRY_ACK = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public AckMessage() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static android.os.Message getSendMessage(int i2, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, obj)) == null) {
            android.os.Message message = new android.os.Message();
            message.what = i2;
            message.obj = obj;
            return message;
        }
        return (android.os.Message) invokeIL.objValue;
    }
}
