package aegon.chrome.net.impl;

import aegon.chrome.net.impl.CronetUrlRequestContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final /* synthetic */ class CronetUrlRequestContext$1$$Lambda$1 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CronetUrlRequestContext.AnonymousClass1 arg$1;

    public CronetUrlRequestContext$1$$Lambda$1(CronetUrlRequestContext.AnonymousClass1 anonymousClass1) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {anonymousClass1};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.arg$1 = anonymousClass1;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            CronetUrlRequestContext.AnonymousClass1.lambda$run$0(this.arg$1);
        }
    }
}
