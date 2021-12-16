package com.alibaba.fastjson.support.jaxrs;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import org.glassfish.jersey.CommonProperties;
import org.glassfish.jersey.internal.util.PropertiesHelper;
/* loaded from: classes9.dex */
public class FastJsonFeature implements Feature {
    public static /* synthetic */ Interceptable $ic;
    public static final String JSON_FEATURE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-296879020, "Lcom/alibaba/fastjson/support/jaxrs/FastJsonFeature;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-296879020, "Lcom/alibaba/fastjson/support/jaxrs/FastJsonFeature;");
                return;
            }
        }
        JSON_FEATURE = FastJsonFeature.class.getSimpleName();
    }

    public FastJsonFeature() {
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

    public boolean configure(FeatureContext featureContext) {
        InterceptResult invokeL;
        Configuration configuration;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, featureContext)) == null) {
            try {
                configuration = featureContext.getConfiguration();
            } catch (NoSuchMethodError unused) {
            }
            if (JSON_FEATURE.equalsIgnoreCase((String) CommonProperties.getValue(configuration.getProperties(), configuration.getRuntimeType(), "jersey.config.jsonFeature", JSON_FEATURE, String.class))) {
                featureContext.property(PropertiesHelper.getPropertyNameForRuntime("jersey.config.jsonFeature", configuration.getRuntimeType()), JSON_FEATURE);
                if (!configuration.isRegistered(FastJsonProvider.class)) {
                    featureContext.register(FastJsonProvider.class, new Class[]{MessageBodyReader.class, MessageBodyWriter.class});
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
