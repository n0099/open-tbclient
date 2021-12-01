package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONPathException;
import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.JSONWriter;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.JSONReaderScanner;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.SymbolTable;
import com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.AfterFilter;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.BeforeFilter;
import com.alibaba.fastjson.serializer.ContextObjectSerializer;
import com.alibaba.fastjson.serializer.ContextValueFilter;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.LabelFilter;
import com.alibaba.fastjson.serializer.Labels;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.alibaba.fastjson.serializer.SerialContext;
import com.alibaba.fastjson.serializer.SerializeBeanInfo;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializeFilterable;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class ASMClassLoader extends ClassLoader {
    public static /* synthetic */ Interceptable $ic;
    public static ProtectionDomain DOMAIN;
    public static Map<String, Class<?>> classMapping;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1243552124, "Lcom/alibaba/fastjson/util/ASMClassLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1243552124, "Lcom/alibaba/fastjson/util/ASMClassLoader;");
                return;
            }
        }
        classMapping = new HashMap();
        DOMAIN = (ProtectionDomain) AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: com.alibaba.fastjson.util.ASMClassLoader.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.security.PrivilegedAction
            public Object run() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? ASMClassLoader.class.getProtectionDomain() : invokeV.objValue;
            }
        });
        Class<?>[] clsArr = {JSON.class, JSONObject.class, JSONArray.class, JSONPath.class, JSONAware.class, JSONException.class, JSONPathException.class, JSONReader.class, JSONStreamAware.class, JSONWriter.class, TypeReference.class, FieldInfo.class, TypeUtils.class, IOUtils.class, IdentityHashMap.class, ParameterizedTypeImpl.class, JavaBeanInfo.class, ObjectSerializer.class, JavaBeanSerializer.class, SerializeFilterable.class, SerializeBeanInfo.class, JSONSerializer.class, SerializeWriter.class, SerializeFilter.class, Labels.class, LabelFilter.class, ContextValueFilter.class, AfterFilter.class, BeforeFilter.class, NameFilter.class, PropertyFilter.class, PropertyPreFilter.class, ValueFilter.class, SerializerFeature.class, ContextObjectSerializer.class, SerialContext.class, SerializeConfig.class, JavaBeanDeserializer.class, ParserConfig.class, DefaultJSONParser.class, JSONLexer.class, JSONLexerBase.class, ParseContext.class, JSONToken.class, SymbolTable.class, Feature.class, JSONScanner.class, JSONReaderScanner.class, AutowiredObjectDeserializer.class, ObjectDeserializer.class, ExtraProcessor.class, ExtraProcessable.class, ExtraTypeProvider.class, BeanContext.class, FieldDeserializer.class, DefaultFieldDeserializer.class};
        for (int i2 = 0; i2 < 56; i2++) {
            Class<?> cls = clsArr[i2];
            classMapping.put(cls.getName(), cls);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ASMClassLoader() {
        super(getParentClassLoader());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ClassLoader) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static ClassLoader getParentClassLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                try {
                    contextClassLoader.loadClass(JSON.class.getName());
                    return contextClassLoader;
                } catch (ClassNotFoundException unused) {
                }
            }
            return JSON.class.getClassLoader();
        }
        return (ClassLoader) invokeV.objValue;
    }

    public Class<?> defineClassPublic(String str, byte[] bArr, int i2, int i3) throws ClassFormatError {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, str, bArr, i2, i3)) == null) ? defineClass(str, bArr, i2, i3, DOMAIN) : (Class) invokeLLII.objValue;
    }

    public boolean isExternalClass(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader == null) {
                return false;
            }
            for (ClassLoader classLoader2 = this; classLoader2 != null; classLoader2 = classLoader2.getParent()) {
                if (classLoader2 == classLoader) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            Class<?> cls = classMapping.get(str);
            if (cls != null) {
                return cls;
            }
            try {
                return super.loadClass(str, z);
            } catch (ClassNotFoundException e2) {
                throw e2;
            }
        }
        return (Class) invokeLZ.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ASMClassLoader(ClassLoader classLoader) {
        super(classLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {classLoader};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ClassLoader) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }
}
