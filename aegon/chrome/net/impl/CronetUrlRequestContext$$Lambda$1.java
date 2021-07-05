package aegon.chrome.net.impl;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final /* synthetic */ class CronetUrlRequestContext$$Lambda$1 implements SafeNativeFunctionCaller$Supplier {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CronetEngineBuilderImpl arg$1;

    public CronetUrlRequestContext$$Lambda$1(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cronetEngineBuilderImpl};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.arg$1 = cronetEngineBuilderImpl;
    }

    /* JADX DEBUG: Method not inlined, still used in: [aegon.chrome.net.impl.CronetUrlRequestContext.<init>(aegon.chrome.net.impl.CronetEngineBuilderImpl):void] */
    public static SafeNativeFunctionCaller$Supplier lambdaFactory$(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cronetEngineBuilderImpl)) == null) ? new CronetUrlRequestContext$$Lambda$1(cronetEngineBuilderImpl) : (SafeNativeFunctionCaller$Supplier) invokeL.objValue;
    }

    @Override // aegon.chrome.net.impl.SafeNativeFunctionCaller$Supplier
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? CronetUrlRequestContext.lambda$new$0(this.arg$1) : invokeV.objValue;
    }
}
