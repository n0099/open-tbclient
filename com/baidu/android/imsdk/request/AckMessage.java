package com.baidu.android.imsdk.request;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AckMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int RETRY_ACK = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public AckMessage() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static android.os.Message getSendMessage(int i, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, obj)) == null) {
            android.os.Message message = new android.os.Message();
            message.what = i;
            message.obj = obj;
            return message;
        }
        return (android.os.Message) invokeIL.objValue;
    }
}
