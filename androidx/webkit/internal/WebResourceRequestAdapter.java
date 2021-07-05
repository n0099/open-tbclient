package androidx.webkit.internal;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.chromium.support_lib_boundary.WebResourceRequestBoundaryInterface;
/* loaded from: classes.dex */
public class WebResourceRequestAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WebResourceRequestBoundaryInterface mBoundaryInterface;

    public WebResourceRequestAdapter(WebResourceRequestBoundaryInterface webResourceRequestBoundaryInterface) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webResourceRequestBoundaryInterface};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBoundaryInterface = webResourceRequestBoundaryInterface;
    }

    public boolean isRedirect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBoundaryInterface.isRedirect() : invokeV.booleanValue;
    }
}
