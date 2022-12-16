package com.baidu.searchbox.dns.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.cache.disk.DiskLruCacheHelper;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ComboCache implements ICache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DiskLruCacheHelper diskLruCacheHelper;
    public MemCache memCache;

    @Override // com.baidu.searchbox.dns.cache.ICache
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public ComboCache(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.diskLruCacheHelper = new DiskLruCacheHelper(context, str);
        this.memCache = new MemCache();
    }

    @Override // com.baidu.searchbox.dns.cache.ICache
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.diskLruCacheHelper.clear();
            this.memCache.clear();
        }
    }

    @Override // com.baidu.searchbox.dns.cache.ICache
    public String get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = this.memCache.get(str);
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.diskLruCacheHelper.get(str);
                    if (DnsUtil.DEBUG) {
                        Log.d(DnsUtil.TAG, " get cache form disk: " + str2);
                    }
                } else if (DnsUtil.DEBUG) {
                    Log.d(DnsUtil.TAG, " get cache from memory : " + str2);
                }
                if (str2 != null) {
                    this.memCache.put(str, str2);
                    return str2;
                }
                return null;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.dns.cache.ICache
    public void put(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.memCache.put(str, str2);
            this.diskLruCacheHelper.put(str, str2);
        }
    }

    @Override // com.baidu.searchbox.dns.cache.ICache
    public boolean remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            boolean remove = this.memCache.remove(str);
            if (!this.diskLruCacheHelper.remove(str) && !remove) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
