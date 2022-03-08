package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SerializeBeanInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Class<?> beanType;
    public int features;
    public final FieldInfo[] fields;
    public final JSONType jsonType;
    public final FieldInfo[] sortedFields;
    public final String typeKey;
    public final String typeName;

    public SerializeBeanInfo(Class<?> cls, JSONType jSONType, String str, String str2, int i2, FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, jSONType, str, str2, Integer.valueOf(i2), fieldInfoArr, fieldInfoArr2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.beanType = cls;
        this.jsonType = jSONType;
        this.typeName = str;
        this.typeKey = str2;
        this.features = i2;
        this.fields = fieldInfoArr;
        this.sortedFields = fieldInfoArr2;
    }
}
