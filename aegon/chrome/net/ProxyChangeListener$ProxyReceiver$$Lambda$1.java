package aegon.chrome.net;

import aegon.chrome.net.ProxyChangeListener;
import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final /* synthetic */ class ProxyChangeListener$ProxyReceiver$$Lambda$1 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ProxyChangeListener.ProxyReceiver arg$1;
    public final Intent arg$2;

    public ProxyChangeListener$ProxyReceiver$$Lambda$1(ProxyChangeListener.ProxyReceiver proxyReceiver, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {proxyReceiver, intent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.arg$1 = proxyReceiver;
        this.arg$2 = intent;
    }

    /* JADX DEBUG: Method not inlined, still used in: [aegon.chrome.net.ProxyChangeListener.ProxyReceiver.onReceive(android.content.Context, android.content.Intent):void] */
    public static Runnable lambdaFactory$(ProxyChangeListener.ProxyReceiver proxyReceiver, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, proxyReceiver, intent)) == null) ? new ProxyChangeListener$ProxyReceiver$$Lambda$1(proxyReceiver, intent) : (Runnable) invokeLL.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ProxyChangeListener.ProxyReceiver.lambda$onReceive$0(this.arg$1, this.arg$2);
        }
    }
}
