package androidx.webkit.internal;

import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
/* loaded from: classes.dex */
public class WebMessageAdapter implements WebMessageBoundaryInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebMessageCompat mWebMessageCompat;

    public WebMessageAdapter(WebMessageCompat webMessageCompat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webMessageCompat};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mWebMessageCompat = webMessageCompat;
    }

    public static WebMessagePortCompat[] toWebMessagePortCompats(InvocationHandler[] invocationHandlerArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, invocationHandlerArr)) == null) {
            WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[invocationHandlerArr.length];
            for (int i2 = 0; i2 < invocationHandlerArr.length; i2++) {
                webMessagePortCompatArr[i2] = new WebMessagePortImpl(invocationHandlerArr[i2]);
            }
            return webMessagePortCompatArr;
        }
        return (WebMessagePortCompat[]) invokeL.objValue;
    }

    public static WebMessageCompat webMessageCompatFromBoundaryInterface(WebMessageBoundaryInterface webMessageBoundaryInterface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, webMessageBoundaryInterface)) == null) ? new WebMessageCompat(webMessageBoundaryInterface.getData(), toWebMessagePortCompats(webMessageBoundaryInterface.getPorts())) : (WebMessageCompat) invokeL.objValue;
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    public String getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mWebMessageCompat.getData() : (String) invokeV.objValue;
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    public InvocationHandler[] getPorts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WebMessagePortCompat[] ports = this.mWebMessageCompat.getPorts();
            if (ports == null) {
                return null;
            }
            InvocationHandler[] invocationHandlerArr = new InvocationHandler[ports.length];
            for (int i2 = 0; i2 < ports.length; i2++) {
                invocationHandlerArr[i2] = ports[i2].getInvocationHandler();
            }
            return invocationHandlerArr;
        }
        return (InvocationHandler[]) invokeV.objValue;
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public String[] getSupportedFeatures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new String[0] : (String[]) invokeV.objValue;
    }
}
