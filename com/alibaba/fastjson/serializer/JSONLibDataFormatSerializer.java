package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
/* loaded from: classes3.dex */
public class JSONLibDataFormatSerializer implements ObjectSerializer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public JSONLibDataFormatSerializer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            if (obj == null) {
                jSONSerializer.out.writeNull();
                return;
            }
            Date date = (Date) obj;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("date", (Object) Integer.valueOf(date.getDate()));
            jSONObject.put("day", (Object) Integer.valueOf(date.getDay()));
            jSONObject.put("hours", (Object) Integer.valueOf(date.getHours()));
            jSONObject.put("minutes", (Object) Integer.valueOf(date.getMinutes()));
            jSONObject.put("month", (Object) Integer.valueOf(date.getMonth()));
            jSONObject.put("seconds", (Object) Integer.valueOf(date.getSeconds()));
            jSONObject.put("time", (Object) Long.valueOf(date.getTime()));
            jSONObject.put("timezoneOffset", (Object) Integer.valueOf(date.getTimezoneOffset()));
            jSONObject.put("year", (Object) Integer.valueOf(date.getYear()));
            jSONSerializer.write(jSONObject);
        }
    }
}
