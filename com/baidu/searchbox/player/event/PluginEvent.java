package com.baidu.searchbox.player.event;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.interfaces.INeuron;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class PluginEvent extends VideoEvent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PluginEvent() {
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

    @PublicMethod(version = "12.8.0.0")
    public static VideoEvent obtainEvent(@NonNull String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            VideoEvent obtain = VideoEvent.obtain(str, 7);
            obtain.setTargetType(1);
            obtain.setPriority(i);
            return obtain;
        }
        return (VideoEvent) invokeLI.objValue;
    }

    @Override // com.baidu.searchbox.player.event.VideoEvent
    public boolean filter(@NonNull INeuron iNeuron) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iNeuron)) == null) {
            if (1 != iNeuron.getType()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
