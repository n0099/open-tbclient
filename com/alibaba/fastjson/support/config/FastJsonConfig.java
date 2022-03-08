package com.alibaba.fastjson.support.config;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.Charset;
import java.util.Map;
/* loaded from: classes3.dex */
public class FastJsonConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Charset charset;
    public Map<Class<?>, SerializeFilter> classSerializeFilters;
    public String dateFormat;
    public Feature[] features;
    public ParseProcess parseProcess;
    public ParserConfig parserConfig;
    public SerializeConfig serializeConfig;
    public SerializeFilter[] serializeFilters;
    public SerializerFeature[] serializerFeatures;
    public boolean writeContentLength;

    public FastJsonConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.charset = IOUtils.UTF8;
        this.serializeConfig = SerializeConfig.getGlobalInstance();
        this.parserConfig = ParserConfig.getGlobalInstance();
        this.serializerFeatures = new SerializerFeature[]{SerializerFeature.BrowserSecure};
        this.serializeFilters = new SerializeFilter[0];
        this.features = new Feature[0];
        this.writeContentLength = true;
    }

    public Charset getCharset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.charset : (Charset) invokeV.objValue;
    }

    public Map<Class<?>, SerializeFilter> getClassSerializeFilters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.classSerializeFilters : (Map) invokeV.objValue;
    }

    public String getDateFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.dateFormat : (String) invokeV.objValue;
    }

    public Feature[] getFeatures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.features : (Feature[]) invokeV.objValue;
    }

    public ParseProcess getParseProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.parseProcess : (ParseProcess) invokeV.objValue;
    }

    public ParserConfig getParserConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.parserConfig : (ParserConfig) invokeV.objValue;
    }

    public SerializeConfig getSerializeConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.serializeConfig : (SerializeConfig) invokeV.objValue;
    }

    public SerializeFilter[] getSerializeFilters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.serializeFilters : (SerializeFilter[]) invokeV.objValue;
    }

    public SerializerFeature[] getSerializerFeatures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.serializerFeatures : (SerializerFeature[]) invokeV.objValue;
    }

    public boolean isWriteContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.writeContentLength : invokeV.booleanValue;
    }

    public void setCharset(Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, charset) == null) {
            this.charset = charset;
        }
    }

    public void setClassSerializeFilters(Map<Class<?>, SerializeFilter> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, map) == null) || map == null) {
            return;
        }
        for (Map.Entry<Class<?>, SerializeFilter> entry : map.entrySet()) {
            this.serializeConfig.addFilter(entry.getKey(), entry.getValue());
        }
        this.classSerializeFilters = map;
    }

    public void setDateFormat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.dateFormat = str;
        }
    }

    public void setFeatures(Feature... featureArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, featureArr) == null) {
            this.features = featureArr;
        }
    }

    public void setParseProcess(ParseProcess parseProcess) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, parseProcess) == null) {
            this.parseProcess = parseProcess;
        }
    }

    public void setParserConfig(ParserConfig parserConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, parserConfig) == null) {
            this.parserConfig = parserConfig;
        }
    }

    public void setSerializeConfig(SerializeConfig serializeConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, serializeConfig) == null) {
            this.serializeConfig = serializeConfig;
        }
    }

    public void setSerializeFilters(SerializeFilter... serializeFilterArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, serializeFilterArr) == null) {
            this.serializeFilters = serializeFilterArr;
        }
    }

    public void setSerializerFeatures(SerializerFeature... serializerFeatureArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, serializerFeatureArr) == null) {
            this.serializerFeatures = serializerFeatureArr;
        }
    }

    public void setWriteContentLength(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.writeContentLength = z;
        }
    }
}
