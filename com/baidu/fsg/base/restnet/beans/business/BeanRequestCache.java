package com.baidu.fsg.base.restnet.beans.business;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.NoProguard;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public final class BeanRequestCache implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public static BeanRequestCache mRequestCache;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, BeanRequestBase> mRequestList;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1185046314, "Lcom/baidu/fsg/base/restnet/beans/business/BeanRequestCache;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1185046314, "Lcom/baidu/fsg/base/restnet/beans/business/BeanRequestCache;");
        }
    }

    public BeanRequestCache() {
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
        this.mRequestList = new HashMap<>();
    }

    public static synchronized BeanRequestCache getInstance() {
        InterceptResult invokeV;
        BeanRequestCache beanRequestCache;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (BeanRequestCache.class) {
                if (mRequestCache == null) {
                    mRequestCache = new BeanRequestCache();
                }
                beanRequestCache = mRequestCache;
            }
            return beanRequestCache;
        }
        return (BeanRequestCache) invokeV.objValue;
    }

    public void addBeanRequestToCache(String str, BeanRequestBase beanRequestBase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, beanRequestBase) == null) || str == null || str.equals("") || beanRequestBase == null) {
            return;
        }
        this.mRequestList.put(str, beanRequestBase);
    }

    public void clearPaySdkRequestCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogUtil.e(BeanRequestCache.class.getSimpleName(), "clearPaySdkRequestCache", null);
            Set<String> keySet = this.mRequestList.keySet();
            HashSet<String> hashSet = new HashSet();
            for (String str : keySet) {
                if (this.mRequestList.get(str) != null && this.mRequestList.get(str).mBelongPaySdk) {
                    hashSet.add(str);
                }
            }
            for (String str2 : hashSet) {
                removeBeanRequestFromCache(str2);
            }
        }
    }

    public void clearRequestCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mRequestList.clear();
        }
    }

    public BeanRequestBase getBeanRequestFromCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str == null || str.equals("")) {
                return null;
            }
            return this.mRequestList.get(str);
        }
        return (BeanRequestBase) invokeL.objValue;
    }

    public void removeBeanRequestFromCache(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mRequestList.remove(str);
    }
}
