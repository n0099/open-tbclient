package com.baidu.searchbox.v8engine;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
@NotProguard
/* loaded from: classes7.dex */
public class JavaBoundObjectManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "JavaBoundObjectManager";
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Long, Object> mJavaBoundObjectMap;

    public JavaBoundObjectManager() {
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
        this.mJavaBoundObjectMap = new HashMap();
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mJavaBoundObjectMap.clear();
        }
    }

    public Object getJavaBoundObject(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? this.mJavaBoundObjectMap.get(Long.valueOf(j)) : invokeJ.objValue;
    }

    public void putJavaBoundObject(long j, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, obj) == null) {
            this.mJavaBoundObjectMap.put(Long.valueOf(j), obj);
        }
    }

    public void removeJavaBoundObject(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.mJavaBoundObjectMap.remove(Long.valueOf(j));
        }
    }
}
