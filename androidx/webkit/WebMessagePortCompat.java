package androidx.webkit;

import android.os.Handler;
import android.webkit.WebMessagePort;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
/* loaded from: classes.dex */
public abstract class WebMessagePortCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void close();

    public abstract WebMessagePort getFrameworkPort();

    public abstract InvocationHandler getInvocationHandler();

    public abstract void postMessage(WebMessageCompat webMessageCompat);

    public abstract void setWebMessageCallback(Handler handler, WebMessageCallbackCompat webMessageCallbackCompat);

    public abstract void setWebMessageCallback(WebMessageCallbackCompat webMessageCallbackCompat);

    /* loaded from: classes.dex */
    public static abstract class WebMessageCallbackCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void onMessage(WebMessagePortCompat webMessagePortCompat, WebMessageCompat webMessageCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webMessagePortCompat, webMessageCompat) == null) {
            }
        }

        public WebMessageCallbackCompat() {
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
    }

    public WebMessagePortCompat() {
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
}
