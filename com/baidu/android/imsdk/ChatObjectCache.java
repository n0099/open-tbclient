package com.baidu.android.imsdk;

import android.util.LruCache;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ChatObjectCache {
    public static /* synthetic */ Interceptable $ic;
    public static ChatObjectCache mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public LruCache<ChatObject, Object> mCache;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-748898505, "Lcom/baidu/android/imsdk/ChatObjectCache;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-748898505, "Lcom/baidu/android/imsdk/ChatObjectCache;");
        }
    }

    public ChatObjectCache() {
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
        this.mCache = null;
        this.mCache = new LruCache<>(100);
    }

    public static ChatObjectCache getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (ChatObject.class) {
                if (mInstance == null) {
                    mInstance = new ChatObjectCache();
                }
            }
            return mInstance;
        }
        return (ChatObjectCache) invokeV.objValue;
    }

    public Object get(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chatObject)) == null) {
            if (chatObject == null) {
                return null;
            }
            return this.mCache.get(chatObject);
        }
        return invokeL.objValue;
    }

    public boolean put(ChatObject chatObject, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatObject, obj)) == null) {
            if (chatObject == null) {
                return false;
            }
            this.mCache.put(chatObject, obj);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public Object remove(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatObject)) == null) ? this.mCache.remove(chatObject) : invokeL.objValue;
    }

    public void removeAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mCache.evictAll();
        }
    }
}
