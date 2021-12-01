package com.baidu.nadcore.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class LruCache<K, V> extends LinkedHashMap<K, V> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_CACHE_SIZE = 32;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mMaxCacheSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LruCache() {
        super((int) (Math.ceil(42.66666793823242d) + 1.0d), 0.75f, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Float) objArr[1]).floatValue(), ((Boolean) objArr[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMaxCacheSize = 32;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, entry)) == null) ? size() > this.mMaxCacheSize : invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LruCache(int i2) {
        super((int) (Math.ceil(i2 / 0.75f) + 1.0d), 0.75f, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Float) objArr2[1]).floatValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMaxCacheSize = i2;
    }
}
