package com.baidu.android.imsdk.mcast;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class IMExitChatRoomGroupMsg extends IMJoinChatRoomGroupMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMExitChatRoomGroupMsg";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMExitChatRoomGroupMsg(Context context, long j, int i, long j2, String str) {
        super(context, j, i, j2, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Long) objArr2[1]).longValue(), ((Integer) objArr2[2]).intValue(), ((Long) objArr2[3]).longValue(), (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setType(213);
    }

    public static IMExitChatRoomGroupMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, intent)) == null) {
            return new IMExitChatRoomGroupMsg(context, intent.getLongExtra(Constants.EXTRA_ROOM_TYPE, 0L), intent.getIntExtra(Constants.EXTRA_BATCH_TYPE, 0), intent.getLongExtra(Constants.EXTRA_CHAT_ROOM_GROUP_ID, 0L), intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
        }
        return (IMExitChatRoomGroupMsg) invokeLL.objValue;
    }
}
