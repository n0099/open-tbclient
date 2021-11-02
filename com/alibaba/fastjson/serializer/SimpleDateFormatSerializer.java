package com.alibaba.fastjson.serializer;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes6.dex */
public class SimpleDateFormatSerializer implements ObjectSerializer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String pattern;

    public SimpleDateFormatSerializer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pattern = str;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            if (obj == null) {
                jSONSerializer.out.writeNull();
                return;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.pattern, jSONSerializer.locale);
            simpleDateFormat.setTimeZone(jSONSerializer.timeZone);
            jSONSerializer.write(simpleDateFormat.format((Date) obj));
        }
    }
}
