package com.alibaba.fastjson.support.spring;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.util.IOUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.AbstractView;
/* loaded from: classes9.dex */
public class FastJsonJsonView extends AbstractView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Pattern CALLBACK_PARAM_PATTERN;
    public static final String DEFAULT_CONTENT_TYPE = "application/json;charset=UTF-8";
    public static final String DEFAULT_JSONP_CONTENT_TYPE = "application/javascript";
    public transient /* synthetic */ FieldHolder $fh;
    @Deprecated
    public Charset charset;
    @Deprecated
    public String dateFormat;
    public boolean disableCaching;
    public boolean extractValueFromSingleKeyModel;
    public FastJsonConfig fastJsonConfig;
    @Deprecated
    public SerializerFeature[] features;
    @Deprecated
    public SerializeFilter[] filters;
    public String[] jsonpParameterNames;
    public Set<String> renderedAttributes;
    public boolean updateContentLength;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1805847962, "Lcom/alibaba/fastjson/support/spring/FastJsonJsonView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1805847962, "Lcom/alibaba/fastjson/support/spring/FastJsonJsonView;");
                return;
            }
        }
        CALLBACK_PARAM_PATTERN = Pattern.compile("[0-9A-Za-z_\\.]*");
    }

    public FastJsonJsonView() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.charset = Charset.forName("UTF-8");
        this.features = new SerializerFeature[0];
        this.filters = new SerializeFilter[0];
        this.disableCaching = true;
        this.updateContentLength = true;
        this.extractValueFromSingleKeyModel = false;
        this.fastJsonConfig = new FastJsonConfig();
        this.jsonpParameterNames = new String[]{"jsonp", "callback"};
        setContentType(DEFAULT_CONTENT_TYPE);
        setExposePathVariables(false);
    }

    private String getJsonpParameterValue(HttpServletRequest httpServletRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, httpServletRequest)) == null) {
            String[] strArr = this.jsonpParameterNames;
            if (strArr != null) {
                for (String str : strArr) {
                    String parameter = httpServletRequest.getParameter(str);
                    if (IOUtils.isValidJsonpQueryParam(parameter)) {
                        return parameter;
                    }
                    if (this.logger.isDebugEnabled()) {
                        this.logger.debug("Ignoring invalid jsonp parameter value: " + parameter);
                    }
                }
                return null;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public Object filterModel(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            HashMap hashMap = new HashMap(map.size());
            Set<String> keySet = !CollectionUtils.isEmpty(this.renderedAttributes) ? this.renderedAttributes : map.keySet();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!(entry.getValue() instanceof BindingResult) && keySet.contains(entry.getKey())) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
            if (this.extractValueFromSingleKeyModel && hashMap.size() == 1) {
                Iterator it = hashMap.entrySet().iterator();
                if (it.hasNext()) {
                    return ((Map.Entry) it.next()).getValue();
                }
            }
            return hashMap;
        }
        return invokeL.objValue;
    }

    @Deprecated
    public Charset getCharset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.fastJsonConfig.getCharset() : (Charset) invokeV.objValue;
    }

    @Deprecated
    public String getDateFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.fastJsonConfig.getDateFormat() : (String) invokeV.objValue;
    }

    public FastJsonConfig getFastJsonConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.fastJsonConfig : (FastJsonConfig) invokeV.objValue;
    }

    @Deprecated
    public SerializerFeature[] getFeatures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.fastJsonConfig.getSerializerFeatures() : (SerializerFeature[]) invokeV.objValue;
    }

    @Deprecated
    public SerializeFilter[] getFilters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.fastJsonConfig.getSerializeFilters() : (SerializeFilter[]) invokeV.objValue;
    }

    public boolean isExtractValueFromSingleKeyModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.extractValueFromSingleKeyModel : invokeV.booleanValue;
    }

    public void prepareResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, httpServletRequest, httpServletResponse) == null) {
            setResponseContentType(httpServletRequest, httpServletResponse);
            httpServletResponse.setCharacterEncoding(this.fastJsonConfig.getCharset().name());
            if (this.disableCaching) {
                httpServletResponse.addHeader("Pragma", "no-cache");
                httpServletResponse.addHeader("Cache-Control", "no-cache, no-store, max-age=0");
                httpServletResponse.addDateHeader("Expires", 1L);
            }
        }
    }

    public void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        JSONPObject jSONPObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, map, httpServletRequest, httpServletResponse) == null) {
            Object filterModel = filterModel(map);
            String jsonpParameterValue = getJsonpParameterValue(httpServletRequest);
            if (jsonpParameterValue != null) {
                JSONPObject jSONPObject2 = new JSONPObject(jsonpParameterValue);
                jSONPObject2.addParameter(filterModel);
                jSONPObject = jSONPObject2;
            } else {
                jSONPObject = filterModel;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int writeJSONStringWithFastJsonConfig = JSON.writeJSONStringWithFastJsonConfig(byteArrayOutputStream, this.fastJsonConfig.getCharset(), jSONPObject, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
            if (this.updateContentLength) {
                httpServletResponse.setContentLength(writeJSONStringWithFastJsonConfig);
            }
            ServletOutputStream outputStream = httpServletResponse.getOutputStream();
            byteArrayOutputStream.writeTo(outputStream);
            byteArrayOutputStream.close();
            outputStream.flush();
        }
    }

    @Deprecated
    public void setCharset(Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, charset) == null) {
            this.fastJsonConfig.setCharset(charset);
        }
    }

    @Deprecated
    public void setDateFormat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.fastJsonConfig.setDateFormat(str);
        }
    }

    public void setDisableCaching(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.disableCaching = z;
        }
    }

    public void setExtractValueFromSingleKeyModel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.extractValueFromSingleKeyModel = z;
        }
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fastJsonConfig) == null) {
            this.fastJsonConfig = fastJsonConfig;
        }
    }

    @Deprecated
    public void setFeatures(SerializerFeature... serializerFeatureArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, serializerFeatureArr) == null) {
            this.fastJsonConfig.setSerializerFeatures(serializerFeatureArr);
        }
    }

    @Deprecated
    public void setFilters(SerializeFilter... serializeFilterArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, serializeFilterArr) == null) {
            this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
        }
    }

    public void setJsonpParameterNames(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, set) == null) {
            Assert.notEmpty(set, "jsonpParameterName cannot be empty");
            this.jsonpParameterNames = (String[]) set.toArray(new String[set.size()]);
        }
    }

    public void setRenderedAttributes(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, set) == null) {
            this.renderedAttributes = set;
        }
    }

    public void setResponseContentType(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, httpServletRequest, httpServletResponse) == null) {
            if (getJsonpParameterValue(httpServletRequest) != null) {
                httpServletResponse.setContentType(DEFAULT_JSONP_CONTENT_TYPE);
            } else {
                super.setResponseContentType(httpServletRequest, httpServletResponse);
            }
        }
    }

    @Deprecated
    public void setSerializerFeature(SerializerFeature... serializerFeatureArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, serializerFeatureArr) == null) {
            this.fastJsonConfig.setSerializerFeatures(serializerFeatureArr);
        }
    }

    public void setUpdateContentLength(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.updateContentLength = z;
        }
    }
}
