package com.alibaba.fastjson.support.jaxrs;

import com.baidu.cyberplayer.sdk.videodownload.CyberVideoDownloader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Priority;
import javax.ws.rs.core.FeatureContext;
import org.glassfish.jersey.internal.spi.AutoDiscoverable;
@Priority(CyberVideoDownloader.DMDownloadError.Unknown)
/* loaded from: classes4.dex */
public class FastJsonAutoDiscoverable implements AutoDiscoverable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FASTJSON_AUTO_DISCOVERABLE = "fastjson.auto.discoverable";
    public static volatile boolean autoDiscover = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1233731322, "Lcom/alibaba/fastjson/support/jaxrs/FastJsonAutoDiscoverable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1233731322, "Lcom/alibaba/fastjson/support/jaxrs/FastJsonAutoDiscoverable;");
                return;
            }
        }
        try {
            autoDiscover = Boolean.parseBoolean(System.getProperty(FASTJSON_AUTO_DISCOVERABLE, String.valueOf(autoDiscover)));
        } catch (Throwable unused) {
        }
    }

    public FastJsonAutoDiscoverable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void configure(FeatureContext featureContext) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, featureContext) == null) && !featureContext.getConfiguration().isRegistered(FastJsonFeature.class) && autoDiscover) {
            featureContext.register(FastJsonFeature.class);
        }
    }
}
