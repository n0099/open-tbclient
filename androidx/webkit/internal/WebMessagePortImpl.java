package androidx.webkit.internal;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
/* loaded from: classes.dex */
public class WebMessagePortImpl extends WebMessagePortCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebMessagePortBoundaryInterface mBoundaryInterface;
    public WebMessagePort mFrameworksImpl;

    public WebMessagePortImpl(WebMessagePort webMessagePort) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webMessagePort};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFrameworksImpl = webMessagePort;
    }

    @RequiresApi(23)
    public static WebMessage compatToFrameworkMessage(WebMessageCompat webMessageCompat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, webMessageCompat)) == null) {
            return new WebMessage(webMessageCompat.getData(), compatToPorts(webMessageCompat.getPorts()));
        }
        return (WebMessage) invokeL.objValue;
    }

    @RequiresApi(23)
    public static WebMessagePort[] compatToPorts(WebMessagePortCompat[] webMessagePortCompatArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, webMessagePortCompatArr)) == null) {
            if (webMessagePortCompatArr == null) {
                return null;
            }
            int length = webMessagePortCompatArr.length;
            WebMessagePort[] webMessagePortArr = new WebMessagePort[length];
            for (int i = 0; i < length; i++) {
                webMessagePortArr[i] = webMessagePortCompatArr[i].getFrameworkPort();
            }
            return webMessagePortArr;
        }
        return (WebMessagePort[]) invokeL.objValue;
    }

    @RequiresApi(23)
    public static WebMessageCompat frameworkMessageToCompat(WebMessage webMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, webMessage)) == null) {
            return new WebMessageCompat(webMessage.getData(), portsToCompat(webMessage.getPorts()));
        }
        return (WebMessageCompat) invokeL.objValue;
    }

    public static WebMessagePortCompat[] portsToCompat(WebMessagePort[] webMessagePortArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, webMessagePortArr)) == null) {
            if (webMessagePortArr == null) {
                return null;
            }
            WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[webMessagePortArr.length];
            for (int i = 0; i < webMessagePortArr.length; i++) {
                webMessagePortCompatArr[i] = new WebMessagePortImpl(webMessagePortArr[i]);
            }
            return webMessagePortCompatArr;
        }
        return (WebMessagePortCompat[]) invokeL.objValue;
    }

    public WebMessagePortImpl(InvocationHandler invocationHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invocationHandler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBoundaryInterface = (WebMessagePortBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessagePortBoundaryInterface.class, invocationHandler);
    }

    @Override // androidx.webkit.WebMessagePortCompat
    @SuppressLint({"NewApi"})
    public void postMessage(@NonNull WebMessageCompat webMessageCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, webMessageCompat) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("WEB_MESSAGE_PORT_POST_MESSAGE");
            if (feature.isSupportedByFramework()) {
                getFrameworksImpl().postMessage(compatToFrameworkMessage(webMessageCompat));
            } else if (feature.isSupportedByWebView()) {
                getBoundaryInterface().postMessage(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessageAdapter(webMessageCompat)));
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }

    @Override // androidx.webkit.WebMessagePortCompat
    @SuppressLint({"NewApi"})
    public void setWebMessageCallback(@NonNull WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, webMessageCallbackCompat) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK");
            if (feature.isSupportedByFramework()) {
                getFrameworksImpl().setWebMessageCallback(new WebMessagePort.WebMessageCallback(this, webMessageCallbackCompat) { // from class: androidx.webkit.internal.WebMessagePortImpl.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WebMessagePortImpl this$0;
                    public final /* synthetic */ WebMessagePortCompat.WebMessageCallbackCompat val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, webMessageCallbackCompat};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$callback = webMessageCallbackCompat;
                    }

                    @Override // android.webkit.WebMessagePort.WebMessageCallback
                    public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webMessagePort, webMessage) == null) {
                            this.val$callback.onMessage(new WebMessagePortImpl(webMessagePort), WebMessagePortImpl.frameworkMessageToCompat(webMessage));
                        }
                    }
                });
            } else if (feature.isSupportedByWebView()) {
                getBoundaryInterface().setWebMessageCallback(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessageCallbackAdapter(webMessageCallbackCompat)));
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }

    private WebMessagePortBoundaryInterface getBoundaryInterface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (this.mBoundaryInterface == null) {
                this.mBoundaryInterface = (WebMessagePortBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessagePortBoundaryInterface.class, WebViewGlueCommunicator.getCompatConverter().convertWebMessagePort(this.mFrameworksImpl));
            }
            return this.mBoundaryInterface;
        }
        return (WebMessagePortBoundaryInterface) invokeV.objValue;
    }

    @RequiresApi(23)
    private WebMessagePort getFrameworksImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (this.mFrameworksImpl == null) {
                this.mFrameworksImpl = WebViewGlueCommunicator.getCompatConverter().convertWebMessagePort(Proxy.getInvocationHandler(this.mBoundaryInterface));
            }
            return this.mFrameworksImpl;
        }
        return (WebMessagePort) invokeV.objValue;
    }

    @Override // androidx.webkit.WebMessagePortCompat
    @RequiresApi(23)
    public WebMessagePort getFrameworkPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return getFrameworksImpl();
        }
        return (WebMessagePort) invokeV.objValue;
    }

    @Override // androidx.webkit.WebMessagePortCompat
    public InvocationHandler getInvocationHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return Proxy.getInvocationHandler(getBoundaryInterface());
        }
        return (InvocationHandler) invokeV.objValue;
    }

    @Override // androidx.webkit.WebMessagePortCompat
    @SuppressLint({"NewApi"})
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("WEB_MESSAGE_PORT_CLOSE");
            if (feature.isSupportedByFramework()) {
                getFrameworksImpl().close();
            } else if (feature.isSupportedByWebView()) {
                getBoundaryInterface().close();
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }

    @Override // androidx.webkit.WebMessagePortCompat
    @SuppressLint({"NewApi"})
    public void setWebMessageCallback(Handler handler, @NonNull WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, handler, webMessageCallbackCompat) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("CREATE_WEB_MESSAGE_CHANNEL");
            if (feature.isSupportedByFramework()) {
                getFrameworksImpl().setWebMessageCallback(new WebMessagePort.WebMessageCallback(this, webMessageCallbackCompat) { // from class: androidx.webkit.internal.WebMessagePortImpl.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WebMessagePortImpl this$0;
                    public final /* synthetic */ WebMessagePortCompat.WebMessageCallbackCompat val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, webMessageCallbackCompat};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$callback = webMessageCallbackCompat;
                    }

                    @Override // android.webkit.WebMessagePort.WebMessageCallback
                    public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webMessagePort, webMessage) == null) {
                            this.val$callback.onMessage(new WebMessagePortImpl(webMessagePort), WebMessagePortImpl.frameworkMessageToCompat(webMessage));
                        }
                    }
                }, handler);
            } else if (feature.isSupportedByWebView()) {
                getBoundaryInterface().setWebMessageCallback(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessageCallbackAdapter(webMessageCallbackCompat)), handler);
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }
}
