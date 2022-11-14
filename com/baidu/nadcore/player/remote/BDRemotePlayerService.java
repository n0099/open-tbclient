package com.baidu.nadcore.player.remote;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerService;
import com.baidu.tieba.gz0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BDRemotePlayerService extends RemotePlayerService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BDRemotePlayerService() {
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

    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerService
    public long getKernelNetHandle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return gz0.c.a().getNetHandle();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerService
    public long getPCDNNetHandle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return gz0.c.a().getNetHandle();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerService, android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent)) == null) {
            gz0.c.a().onServiceBind(this);
            return super.onBind(intent);
        }
        return (IBinder) invokeL.objValue;
    }
}
