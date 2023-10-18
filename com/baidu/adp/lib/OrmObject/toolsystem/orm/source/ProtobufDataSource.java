package com.baidu.adp.lib.OrmObject.toolsystem.orm.source;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b7;
import com.baidu.tieba.e8;
import com.baidu.tieba.u8;
import com.baidu.tieba.w7;
import com.baidu.tieba.y8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class ProtobufDataSource implements w7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> keySet;
    public Message message;

    public ProtobufDataSource(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {message};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.message = message;
        List<Field> b = b7.b(message.getClass());
        this.keySet = new HashSet();
        if (b != null && b.size() > 0) {
            for (Field field : b) {
                if (field != null) {
                    this.keySet.add(field.getName());
                }
            }
        }
    }

    @Override // com.baidu.tieba.w7
    public Set<String> getKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.keySet;
        }
        return (Set) invokeV.objValue;
    }

    public Object getObject(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return b7.d(this.message, str);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.w7
    public Object getObjectByType(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, type)) == null) {
            Object object = getObject(str);
            if (object != null) {
                u8 u8Var = new u8(type);
                e8 a = y8.a(object);
                if (a != null) {
                    return a.a(u8Var);
                }
                return object;
            }
            return object;
        }
        return invokeLL.objValue;
    }

    @Override // com.baidu.tieba.w7
    public void set(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, obj) == null) {
            b7.i(this.message, str, obj);
        }
    }
}
