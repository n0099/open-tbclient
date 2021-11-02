package com.baidu.android.imsdk.chatmessage.sync;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class Generator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SYNC_ALL_MESSAGE = 5;
    public static final int SYNC_CHAT_MESSAGE = 0;
    public static final int SYNC_GROUP_MESSAGE = 6;
    public static final int SYNC_NOTIFY_MESSAGE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public Generator() {
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

    public static SyncStrategy generate(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i2)) == null) {
            if (i2 != 5) {
                return null;
            }
            return SyncAllMessage.getInstance(context);
        }
        return (SyncStrategy) invokeLI.objValue;
    }
}
