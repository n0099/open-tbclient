package com.baidu.mobads.container.util.cache;

import android.util.LruCache;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.FileUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
/* loaded from: classes3.dex */
public class LruDiskCache extends LruCache<String, CacheResource<File>> {
    public static /* synthetic */ Interceptable $ic;
    public static final String TAG;
    public static final boolean isDebug = false;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<CacheResource<File>, byte[]> bufferMap;
    public int cacheCount;
    public final String cachePath;
    public long expireTime;
    public final List<OnCacheListener> listeners;
    public volatile boolean restoreCompleted;
    public long tailModifiedTime;

    /* loaded from: classes3.dex */
    public interface OnCacheListener {
        void onCacheComplete(String str, CacheResource<File> cacheResource);

        void onCacheFailed(String str, CacheResource<File> cacheResource);

        void onResourceEvicted(String str, CacheResource<File> cacheResource);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2121010230, "Lcom/baidu/mobads/container/util/cache/LruDiskCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2121010230, "Lcom/baidu/mobads/container/util/cache/LruDiskCache;");
                return;
            }
        }
        TAG = LruDiskCache.class.getSimpleName();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LruDiskCache(int i2, String str) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.listeners = new ArrayList();
        this.restoreCompleted = false;
        this.cacheCount = 0;
        this.expireTime = 2592000000L;
        this.cachePath = str;
        this.bufferMap = new HashMap<>();
    }

    public static /* synthetic */ int access$108(LruDiskCache lruDiskCache) {
        int i2 = lruDiskCache.cacheCount;
        lruDiskCache.cacheCount = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int access$110(LruDiskCache lruDiskCache) {
        int i2 = lruDiskCache.cacheCount;
        lruDiskCache.cacheCount = i2 - 1;
        return i2;
    }

    private void deleteFileAsync(CacheResource<File> cacheResource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, cacheResource) == null) {
            TaskScheduler.getInstance().submit(new BaseTask(this, cacheResource) { // from class: com.baidu.mobads.container.util.cache.LruDiskCache.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LruDiskCache this$0;
                public final /* synthetic */ CacheResource val$res;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cacheResource};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$res = cacheResource;
                }

                @Override // com.baidu.mobads.container.executor.BaseTask
                public Object doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        try {
                            if (this.val$res != null) {
                                long currentTimeMillis = System.currentTimeMillis();
                                String name = ((File) this.val$res.get()).getName();
                                LruDiskCache.access$110(this.this$0);
                                this.val$res.recycle();
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                LruDiskCache lruDiskCache = this.this$0;
                                lruDiskCache.logWhenDebug("File deleted using " + currentTimeMillis2 + "ms: " + name);
                            }
                            this.this$0.cleanExpired();
                            return null;
                        } catch (Throwable th) {
                            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
                            remoteXAdLogger.d("Failed to delete file. " + th);
                            return null;
                        }
                    }
                    return invokeV.objValue;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logWhenDebug(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, str) == null) {
        }
    }

    private synchronized void onRestoreComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            synchronized (this) {
                this.restoreCompleted = true;
                if (this.bufferMap != null) {
                    for (CacheResource<File> cacheResource : this.bufferMap.keySet()) {
                        storeFileAsync(cacheResource, this.bufferMap.get(cacheResource));
                    }
                    this.bufferMap.clear();
                    this.bufferMap = null;
                }
            }
        }
    }

    public static LruDiskCache open(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, str, i2)) == null) {
            LruDiskCache lruDiskCache = new LruDiskCache(i2, str);
            lruDiskCache.restoreCompleted = false;
            TaskScheduler.getInstance().submit(new BaseTask(str, lruDiskCache) { // from class: com.baidu.mobads.container.util.cache.LruDiskCache.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LruDiskCache val$cache;
                public final /* synthetic */ String val$outputPath;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, lruDiskCache};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$outputPath = str;
                    this.val$cache = lruDiskCache;
                }

                @Override // com.baidu.mobads.container.executor.BaseTask
                public Object doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            File file = new File(this.val$outputPath);
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            this.val$cache.restoreCacheWithQueue(file.listFiles(), currentTimeMillis);
                            return null;
                        } catch (Exception e2) {
                            this.val$cache.restoreCompleted = true;
                            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
                            remoteXAdLogger.d("Disk cache initialize failed for " + e2.getMessage());
                            return null;
                        }
                    }
                    return invokeV.objValue;
                }
            });
            return lruDiskCache;
        }
        return (LruDiskCache) invokeLI.objValue;
    }

    private void put(String str, File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65547, this, str, file) == null) && file.exists()) {
            super.put((LruDiskCache) str, (String) new CacheResource(file));
            this.cacheCount++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreCacheWithQueue(File[] fileArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65548, this, fileArr, j) == null) {
            if (fileArr != null && fileArr.length > 0) {
                PriorityQueue priorityQueue = new PriorityQueue(11, new Comparator<File>(this) { // from class: com.baidu.mobads.container.util.cache.LruDiskCache.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LruDiskCache this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    public int compare(File file, File file2) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file, file2)) == null) ? Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified())) : invokeLL.intValue;
                    }
                });
                if (priorityQueue.size() > 0) {
                    this.tailModifiedTime = ((File) priorityQueue.peek()).lastModified();
                } else {
                    this.tailModifiedTime = System.currentTimeMillis();
                }
                priorityQueue.addAll(Arrays.asList(fileArr));
                while (!priorityQueue.isEmpty()) {
                    File file = (File) priorityQueue.poll();
                    put(file.getName(), file);
                }
            }
            logWhenDebug("Complete restore cache using " + (System.currentTimeMillis() - j) + "ms: ");
            onRestoreComplete();
        }
    }

    private void storeFileAsync(CacheResource<File> cacheResource, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, cacheResource, bArr) == null) {
            TaskScheduler.getInstance().submit(new BaseTask(this, bArr, cacheResource) { // from class: com.baidu.mobads.container.util.cache.LruDiskCache.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LruDiskCache this$0;
                public final /* synthetic */ byte[] val$data;
                public final /* synthetic */ CacheResource val$fileRes;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bArr, cacheResource};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$data = bArr;
                    this.val$fileRes = cacheResource;
                }

                @Override // com.baidu.mobads.container.executor.BaseTask
                public Object doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            FileUtils.saveBytesToFile(this.val$data, (File) this.val$fileRes.get());
                            this.this$0.put((LruDiskCache) ((File) this.val$fileRes.get()).getName(), (String) this.val$fileRes);
                            LruDiskCache.access$108(this.this$0);
                            if (!this.this$0.listeners.isEmpty()) {
                                for (OnCacheListener onCacheListener : this.this$0.listeners) {
                                    onCacheListener.onCacheComplete(((File) this.val$fileRes.get()).getName(), this.val$fileRes);
                                }
                            }
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            LruDiskCache lruDiskCache = this.this$0;
                            lruDiskCache.logWhenDebug("File saved using " + currentTimeMillis2 + "ms: " + ((File) this.val$fileRes.get()).getName() + "\nStatus:" + this.this$0.status());
                            this.this$0.cleanExpired();
                            return null;
                        } catch (Throwable th) {
                            if (!this.this$0.listeners.isEmpty()) {
                                for (OnCacheListener onCacheListener2 : this.this$0.listeners) {
                                    onCacheListener2.onCacheFailed(((File) this.val$fileRes.get()).getName(), this.val$fileRes);
                                }
                            }
                            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
                            remoteXAdLogger.d("Failed to save file. " + th);
                            return null;
                        }
                    }
                    return invokeV.objValue;
                }
            });
        }
    }

    public void addListeners(OnCacheListener onCacheListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onCacheListener) == null) {
            this.listeners.add(onCacheListener);
        }
    }

    public synchronized void cleanExpired() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (System.currentTimeMillis() - this.tailModifiedTime < this.expireTime) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Map snapshot = super.snapshot();
                this.tailModifiedTime = System.currentTimeMillis();
                for (String str : snapshot.keySet()) {
                    CacheResource cacheResource = (CacheResource) snapshot.get(str);
                    if (cacheResource.isExpired(this.expireTime)) {
                        ((File) ((CacheResource) super.remove(str)).get()).delete();
                        this.cacheCount--;
                    } else if (((File) cacheResource.get()).lastModified() < this.tailModifiedTime) {
                        this.tailModifiedTime = ((File) cacheResource.get()).lastModified();
                    }
                }
                logWhenDebug("Clear cache using " + (System.currentTimeMillis() - currentTimeMillis) + "ms: ");
            }
        }
    }

    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.evictAll();
        }
    }

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || super.get(str) == null) {
            return;
        }
        deleteFileAsync((CacheResource) super.remove(str));
    }

    public CacheResource<File> fetch(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            CacheResource<File> cacheResource = (CacheResource) super.get(str);
            if (cacheResource != null) {
                try {
                    cacheResource.get().setLastModified(System.currentTimeMillis());
                    logWhenDebug("Fetch resource for " + str + ",\nStatus:" + status());
                } catch (Throwable th) {
                    RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
                    remoteXAdLogger.d("Failed to update file. " + th);
                }
            }
            return cacheResource;
        }
        return (CacheResource) invokeL.objValue;
    }

    public String getCachePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.cachePath : (String) invokeV.objValue;
    }

    public long getCurrentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? super.size() : invokeV.longValue;
    }

    public long getMaxSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? super.maxSize() : invokeV.longValue;
    }

    public boolean query(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? fetch(str) != null && fetch(str).get().exists() : invokeL.booleanValue;
    }

    public void removeListener(OnCacheListener onCacheListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, onCacheListener) == null) && this.listeners.contains(onCacheListener)) {
            this.listeners.remove(onCacheListener);
        }
    }

    public void setExpireTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.expireTime = j;
        }
    }

    public String status() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int hitCount = hitCount() + missCount();
            return String.format(Locale.CHINA, "LruDiskCache[count=%d,size=%d/%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.cacheCount), Integer.valueOf(size()), Integer.valueOf(maxSize()), Integer.valueOf(hitCount()), Integer.valueOf(missCount()), Integer.valueOf(hitCount != 0 ? (hitCount() * 100) / hitCount : 0));
        }
        return (String) invokeV.objValue;
    }

    public void store(byte[] bArr, CacheResource<File> cacheResource) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, bArr, cacheResource) == null) || cacheResource == null) {
            return;
        }
        if (this.restoreCompleted) {
            storeFileAsync(cacheResource, bArr);
        } else {
            this.bufferMap.put(cacheResource, bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    public void entryRemoved(boolean z, String str, CacheResource<File> cacheResource, CacheResource<File> cacheResource2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, cacheResource, cacheResource2}) == null) {
            super.entryRemoved(z, (boolean) str, cacheResource, cacheResource2);
            if (z && cacheResource != null) {
                deleteFileAsync(cacheResource);
            }
            if (!z || this.listeners.isEmpty()) {
                return;
            }
            for (OnCacheListener onCacheListener : this.listeners) {
                onCacheListener.onResourceEvicted(str, cacheResource);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    public int sizeOf(String str, CacheResource<File> cacheResource) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, cacheResource)) == null) {
            if (cacheResource == null) {
                return super.sizeOf((LruDiskCache) null, (Object) null);
            }
            return cacheResource.size();
        }
        return invokeLL.intValue;
    }
}
