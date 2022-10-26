package com.baidu.searchbox.player.kernel;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class DumediaKernelFactory implements IKernelFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DumediaKernelFactory() {
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

    @Override // com.baidu.searchbox.player.kernel.IKernelFactory
    public AbsVideoKernel create(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != -1026184943) {
                if (hashCode == 313531039 && str.equals(AbsVideoKernel.CYBER_PLAYER)) {
                    c = 0;
                }
                c = 65535;
            } else {
                if (str.equals(AbsVideoKernel.NORMAL_PLAYER)) {
                    c = 1;
                }
                c = 65535;
            }
            if (c != 0) {
                return new NormalVideoKernel();
            }
            return new CyberVideoKernel();
        }
        return (AbsVideoKernel) invokeL.objValue;
    }
}
