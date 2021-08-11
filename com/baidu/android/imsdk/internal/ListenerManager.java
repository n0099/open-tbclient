package com.baidu.android.imsdk.internal;

import com.baidu.android.imsdk.IMListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class ListenerManager {
    public static /* synthetic */ Interceptable $ic;
    public static ListenerManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, IMListener> mMap;
    public AtomicInteger mOpenCounter;

    public ListenerManager() {
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
        this.mMap = new HashMap();
        this.mOpenCounter = new AtomicInteger();
    }

    public static synchronized ListenerManager getInstance() {
        InterceptResult invokeV;
        ListenerManager listenerManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (ListenerManager.class) {
                if (sInstance == null) {
                    sInstance = new ListenerManager();
                }
                listenerManager = sInstance;
            }
            return listenerManager;
        }
        return (ListenerManager) invokeV.objValue;
    }

    private synchronized String getKey() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            synchronized (this) {
                str = "k" + System.currentTimeMillis() + this.mOpenCounter.incrementAndGet();
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public synchronized boolean addListener(String str, IMListener iMListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, iMListener)) == null) {
            synchronized (this) {
                if (str == null || iMListener == null) {
                    return false;
                }
                this.mMap.put(str, iMListener);
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public synchronized void clearListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.mMap.clear();
            }
        }
    }

    public synchronized IMListener getListener(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                if (str == null) {
                    return null;
                }
                if (this.mMap.containsKey(str)) {
                    return this.mMap.get(str);
                }
                return null;
            }
        }
        return (IMListener) invokeL.objValue;
    }

    public synchronized IMListener removeListener(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                if (str == null) {
                    return null;
                }
                if (this.mMap.containsKey(str)) {
                    return this.mMap.remove(str);
                }
                return null;
            }
        }
        return (IMListener) invokeL.objValue;
    }

    public synchronized String addListener(IMListener iMListener) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iMListener)) == null) {
            synchronized (this) {
                str = "";
                if (iMListener != null) {
                    str = getKey();
                    this.mMap.put(str, iMListener);
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
