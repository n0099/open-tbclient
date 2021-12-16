package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.sql.Clob;
import java.sql.SQLException;
/* loaded from: classes9.dex */
public class ClobSeriliazer implements ObjectSerializer {
    public static /* synthetic */ Interceptable $ic;
    public static final ClobSeriliazer instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1803365812, "Lcom/alibaba/fastjson/serializer/ClobSeriliazer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1803365812, "Lcom/alibaba/fastjson/serializer/ClobSeriliazer;");
                return;
            }
        }
        instance = new ClobSeriliazer();
    }

    public ClobSeriliazer() {
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
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) != null) {
            return;
        }
        try {
            if (obj == null) {
                jSONSerializer.writeNull();
                return;
            }
            Reader characterStream = ((Clob) obj).getCharacterStream();
            StringBuilder sb = new StringBuilder();
            try {
                char[] cArr = new char[2048];
                while (true) {
                    int read = characterStream.read(cArr, 0, 2048);
                    if (read < 0) {
                        String sb2 = sb.toString();
                        characterStream.close();
                        jSONSerializer.write(sb2);
                        return;
                    }
                    sb.append(cArr, 0, read);
                }
            } catch (Exception e2) {
                throw new JSONException("read string from reader error", e2);
            }
        } catch (SQLException e3) {
            throw new IOException("write clob error", e3);
        }
    }
}
