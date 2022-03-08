package com.baidu.searchbox.player.kernel;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class DumediaKernelFactory implements IKernelFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DumediaKernelFactory() {
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

    @Override // com.baidu.searchbox.player.kernel.IKernelFactory
    @NonNull
    @PublicMethod
    public AbsVideoKernel create(@NonNull String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != -1026184943) {
                if (hashCode == 313531039 && str.equals(AbsVideoKernel.CYBER_PLAYER)) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (str.equals(AbsVideoKernel.NORMAL_PLAYER)) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                return new NormalVideoKernel();
            }
            return new CyberVideoKernel();
        }
        return (AbsVideoKernel) invokeL.objValue;
    }
}
