package com.baidu.searchbox.player.kernel;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class DefaultKernelFactory implements IKernelFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DefaultKernelFactory() {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.searchbox.player.kernel.IKernelFactory
    @NonNull
    @PublicMethod
    public AbsVideoKernel create(@NonNull String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            switch (str.hashCode()) {
                case -1026184943:
                    if (str.equals("NormalVideoKernel")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -745233251:
                    if (str.equals("TextureVideoKernel")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 313531039:
                    if (str.equals("CyberVideoKernel")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1194622411:
                    if (str.equals("SurfaceVideoKernel")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        return new NormalVideoKernel();
                    }
                    return new CyberVideoKernel();
                }
                return new SurfaceVideoKernel();
            }
            return new TextureVideoKernel(new StretchTextureView(BDPlayerConfig.getAppContext()));
        }
        return (AbsVideoKernel) invokeL.objValue;
    }
}
