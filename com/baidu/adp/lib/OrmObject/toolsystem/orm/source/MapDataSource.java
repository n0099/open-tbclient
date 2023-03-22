package com.baidu.adp.lib.OrmObject.toolsystem.orm.source;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ed;
import com.baidu.tieba.ud;
import com.baidu.tieba.wc;
import com.baidu.tieba.yd;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class MapDataSource implements wc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Object> map;

    public MapDataSource(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.map = map;
    }

    public Object getObject(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return this.map.get(str);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.wc
    public Set<String> getKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.map.keySet();
        }
        return (Set) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wc
    public Object getObjectByType(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, type)) == null) {
            Object object = getObject(str);
            if (object != null) {
                ud udVar = new ud(type);
                ed a = yd.a(object);
                if (a != null) {
                    return a.a(udVar);
                }
                return object;
            }
            return object;
        }
        return invokeLL.objValue;
    }

    @Override // com.baidu.tieba.wc
    public void set(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, obj) == null) {
            this.map.put(str, obj);
        }
    }
}
