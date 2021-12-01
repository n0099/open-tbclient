package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
/* loaded from: classes7.dex */
public class AnnotationSerializer implements ObjectSerializer {
    public static /* synthetic */ Interceptable $ic;
    public static AnnotationSerializer instance;
    public static volatile Class sun_AnnotationType;
    public static volatile boolean sun_AnnotationType_error;
    public static volatile Method sun_AnnotationType_getInstance;
    public static volatile Method sun_AnnotationType_members;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2007961083, "Lcom/alibaba/fastjson/serializer/AnnotationSerializer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2007961083, "Lcom/alibaba/fastjson/serializer/AnnotationSerializer;");
                return;
            }
        }
        instance = new AnnotationSerializer();
    }

    public AnnotationSerializer() {
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

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        JSONException jSONException;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            Class<?>[] interfaces = obj.getClass().getInterfaces();
            if (interfaces.length == 1 && interfaces[0].isAnnotation()) {
                Class<?> cls = interfaces[0];
                if (sun_AnnotationType == null && !sun_AnnotationType_error) {
                    try {
                        sun_AnnotationType = Class.forName("sun.reflect.annotation.AnnotationType");
                    } finally {
                    }
                }
                if (sun_AnnotationType != null) {
                    if (sun_AnnotationType_getInstance == null && !sun_AnnotationType_error) {
                        try {
                            sun_AnnotationType_getInstance = sun_AnnotationType.getMethod("getInstance", Class.class);
                        } finally {
                        }
                    }
                    if (sun_AnnotationType_members == null && !sun_AnnotationType_error) {
                        try {
                            sun_AnnotationType_members = sun_AnnotationType.getMethod("members", new Class[0]);
                        } finally {
                        }
                    }
                    if (sun_AnnotationType_getInstance != null && !sun_AnnotationType_error) {
                        try {
                            Object[] objArr = {cls};
                            Object obj3 = null;
                            try {
                                Map map = (Map) sun_AnnotationType_members.invoke(sun_AnnotationType_getInstance.invoke(null, objArr), new Object[0]);
                                JSONObject jSONObject = new JSONObject(map.size());
                                for (Map.Entry entry : map.entrySet()) {
                                    try {
                                        obj3 = ((Method) entry.getValue()).invoke(obj, new Object[0]);
                                    } catch (IllegalAccessException | InvocationTargetException unused) {
                                    }
                                    jSONObject.put((String) entry.getKey(), JSON.toJSON(obj3));
                                }
                                jSONSerializer.write(jSONObject);
                                return;
                            } finally {
                            }
                        } finally {
                        }
                    }
                    throw new JSONException("not support Type Annotation.");
                }
                throw new JSONException("not support Type Annotation.");
            }
        }
    }
}
