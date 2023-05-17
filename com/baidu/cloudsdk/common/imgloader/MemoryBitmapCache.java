package com.baidu.cloudsdk.common.imgloader;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class MemoryBitmapCache implements IBitmapCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IEvictPolicy mEvictPolicy;
    public Map<String, CacheEntry> mMap;
    public int mMaxSize;

    /* loaded from: classes3.dex */
    public interface IEvictPolicy {
        public static final int LRU = 0;
        public static final int OLDEST = 1;

        String findItemToDelete(Map<String, CacheEntry> map);

        void updateCacheItem(CacheEntry cacheEntry);
    }

    /* loaded from: classes3.dex */
    public static class CacheEntry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mHits;
        public Bitmap mImage;
        public long mTimeStamp;

        public CacheEntry() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class LRUPolicy implements IEvictPolicy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long mRecentTimeRange;

        public LRUPolicy(long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mRecentTimeRange = j * 1000;
        }

        @Override // com.baidu.cloudsdk.common.imgloader.MemoryBitmapCache.IEvictPolicy
        public String findItemToDelete(Map<String, CacheEntry> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
                String str = null;
                CacheEntry cacheEntry = null;
                boolean z = true;
                for (String str2 : map.keySet()) {
                    CacheEntry cacheEntry2 = map.get(str2);
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = cacheEntry2.mTimeStamp;
                    if (currentTimeMillis - j < this.mRecentTimeRange) {
                        if (z && (cacheEntry == null || cacheEntry2.mHits < cacheEntry.mHits)) {
                            str = str2;
                            cacheEntry = cacheEntry2;
                        }
                    } else if (cacheEntry == null || j < cacheEntry.mTimeStamp) {
                        str = str2;
                        cacheEntry = cacheEntry2;
                        z = false;
                    }
                }
                return str;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.cloudsdk.common.imgloader.MemoryBitmapCache.IEvictPolicy
        public void updateCacheItem(CacheEntry cacheEntry) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cacheEntry) == null) {
                if (cacheEntry.mTimeStamp + this.mRecentTimeRange < System.currentTimeMillis()) {
                    cacheEntry.mHits = 1;
                } else {
                    cacheEntry.mHits++;
                }
                cacheEntry.mTimeStamp = System.currentTimeMillis();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class OldestPolicy implements IEvictPolicy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public OldestPolicy() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.cloudsdk.common.imgloader.MemoryBitmapCache.IEvictPolicy
        public String findItemToDelete(Map<String, CacheEntry> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
                String str = null;
                CacheEntry cacheEntry = null;
                for (String str2 : map.keySet()) {
                    CacheEntry cacheEntry2 = map.get(str2);
                    if (cacheEntry == null || cacheEntry2.mTimeStamp < cacheEntry.mTimeStamp) {
                        str = str2;
                        cacheEntry = cacheEntry2;
                    }
                }
                return str;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.cloudsdk.common.imgloader.MemoryBitmapCache.IEvictPolicy
        public void updateCacheItem(CacheEntry cacheEntry) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cacheEntry) == null) {
                cacheEntry.mHits++;
                cacheEntry.mTimeStamp = System.currentTimeMillis();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MemoryBitmapCache(int i) {
        this(i, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (IEvictPolicy) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public MemoryBitmapCache(int i, IEvictPolicy iEvictPolicy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), iEvictPolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMap = new HashMap();
        this.mMaxSize = i;
        this.mEvictPolicy = iEvictPolicy;
        if (iEvictPolicy == null) {
            this.mEvictPolicy = new OldestPolicy();
        }
    }

    @Override // com.baidu.cloudsdk.common.imgloader.IBitmapCache
    public synchronized void put(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, bitmap) == null) {
            synchronized (this) {
                if (exists(str)) {
                    return;
                }
                if (this.mMap.size() >= this.mMaxSize) {
                    delete(this.mEvictPolicy.findItemToDelete(this.mMap));
                }
                CacheEntry cacheEntry = new CacheEntry();
                cacheEntry.mHits = 1;
                cacheEntry.mTimeStamp = System.currentTimeMillis();
                cacheEntry.mImage = bitmap;
                this.mMap.put(str, cacheEntry);
            }
        }
    }

    @Override // com.baidu.cloudsdk.common.imgloader.IBitmapCache
    public synchronized void clean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                Iterator<String> it = this.mMap.keySet().iterator();
                while (it.hasNext()) {
                    CacheEntry cacheEntry = this.mMap.get(it.next());
                    if (cacheEntry != null && cacheEntry.mImage != null && !cacheEntry.mImage.isRecycled()) {
                        cacheEntry.mImage.recycle();
                    }
                    it.remove();
                }
            }
        }
    }

    @Override // com.baidu.cloudsdk.common.imgloader.IBitmapCache
    public synchronized void delete(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this) {
                CacheEntry remove = this.mMap.remove(str);
                if (remove != null && remove.mImage != null && !remove.mImage.isRecycled()) {
                    remove.mImage.recycle();
                }
            }
        }
    }

    @Override // com.baidu.cloudsdk.common.imgloader.IBitmapCache
    public synchronized boolean exists(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                if (this.mMap.get(str) != null) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.IBitmapCache
    public synchronized Bitmap get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                CacheEntry cacheEntry = this.mMap.get(str);
                if (cacheEntry != null) {
                    this.mEvictPolicy.updateCacheItem(cacheEntry);
                    return cacheEntry.mImage;
                }
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public MemoryBitmapCache setEvictPolicy(IEvictPolicy iEvictPolicy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iEvictPolicy)) == null) {
            this.mEvictPolicy = iEvictPolicy;
            return this;
        }
        return (MemoryBitmapCache) invokeL.objValue;
    }

    public MemoryBitmapCache setMaxSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            this.mMaxSize = i;
            return this;
        }
        return (MemoryBitmapCache) invokeI.objValue;
    }
}
