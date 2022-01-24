package com.baidu.searchbox.download.center.clearcache;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.BaseClearCache;
import com.baidu.searchbox.download.center.clearcache.controller.ClearCacheTips;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class MainClearCache extends BaseClearCache {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CALCULATE_TASK_NAME = "getMainCacheSize";
    public static final String CLEAR_CACHE_FORCE_LIST_KEY = "clear_cache";
    public static final String CLEAR_TASK_NAME = "clearMainCache";
    public static final String EXT_KEY = "main";
    public static final long TIMEOUT = 2;
    public static BaseClearCache sDownloadClearCache;
    public static final List<BaseClearCache> sSubClearCacheList;
    public transient /* synthetic */ FieldHolder $fh;
    public List<BaseClearCache> mShowClearCacheList;

    /* loaded from: classes11.dex */
    public interface MainClearCacheCallback extends BaseClearCache.CacheClearCallback {
        void onItemClearCacheResult(BaseClearCache baseClearCache, long j2, boolean z);
    }

    /* loaded from: classes11.dex */
    public interface MainClearSizeCallback extends BaseClearCache.CacheSizeCallback {
        void onItemCacheSizeResult(BaseClearCache baseClearCache, long j2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1396663808, "Lcom/baidu/searchbox/download/center/clearcache/MainClearCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1396663808, "Lcom/baidu/searchbox/download/center/clearcache/MainClearCache;");
                return;
            }
        }
        sSubClearCacheList = new ArrayList();
        ClearCacheRuntime.getClearCacheContext().addClearCache(sSubClearCacheList);
        sDownloadClearCache = ClearCacheRuntime.getClearCacheContext().getDownloadClearCache();
    }

    public MainClearCache() {
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
        this.mShowClearCacheList = new ArrayList();
        JSONArray forceList = UserSettingForceListListener.getForceList(CLEAR_CACHE_FORCE_LIST_KEY);
        for (BaseClearCache baseClearCache : sSubClearCacheList) {
            boolean z = false;
            if (forceList != null && forceList.length() > 0) {
                int i4 = 0;
                while (true) {
                    if (i4 >= forceList.length()) {
                        break;
                    }
                    JSONObject optJSONObject = forceList.optJSONObject(i4);
                    if (optJSONObject == null || !TextUtils.equals(optJSONObject.optString(UserSettingForceListListener.FORCE_LIST_ITEM_ID_KEY), baseClearCache.getUBCExtKey())) {
                        i4++;
                    } else {
                        if ("1".equals(optJSONObject.optString(UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY))) {
                            this.mShowClearCacheList.add(baseClearCache);
                        }
                        z = true;
                    }
                }
            }
            if (!z && baseClearCache.isShow()) {
                this.mShowClearCacheList.add(baseClearCache);
            }
        }
    }

    @Override // com.baidu.searchbox.download.center.clearcache.BaseClearCache
    public void calculateCacheSize(BaseClearCache.CacheSizeCallback cacheSizeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cacheSizeCallback) == null) {
            ExecutorUtilsExt.postOnElastic(new Runnable(this, cacheSizeCallback) { // from class: com.baidu.searchbox.download.center.clearcache.MainClearCache.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MainClearCache this$0;
                public final /* synthetic */ BaseClearCache.CacheSizeCallback val$cacheSizeCallback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cacheSizeCallback};
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
                    this.val$cacheSizeCallback = cacheSizeCallback;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        List<BaseClearCache> calculateCacheList = this.this$0.getCalculateCacheList();
                        CountDownLatch countDownLatch = new CountDownLatch(calculateCacheList.size());
                        for (BaseClearCache baseClearCache : calculateCacheList) {
                            baseClearCache.calculateCacheSize(new BaseClearCache.CacheSizeCallback(this, baseClearCache, countDownLatch) { // from class: com.baidu.searchbox.download.center.clearcache.MainClearCache.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$1;
                                public final /* synthetic */ BaseClearCache val$baseClearCache;
                                public final /* synthetic */ CountDownLatch val$latch;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, baseClearCache, countDownLatch};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$baseClearCache = baseClearCache;
                                    this.val$latch = countDownLatch;
                                }

                                @Override // com.baidu.searchbox.download.center.clearcache.BaseClearCache.CacheSizeCallback
                                public void onCacheSizeResult(long j2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeJ(1048576, this, j2) == null) {
                                        if (j2 >= 0) {
                                            this.val$baseClearCache.setCacheSize(j2);
                                        }
                                        BaseClearCache.CacheSizeCallback cacheSizeCallback2 = this.this$1.val$cacheSizeCallback;
                                        if (cacheSizeCallback2 instanceof MainClearSizeCallback) {
                                            BaseClearCache baseClearCache2 = this.val$baseClearCache;
                                            ((MainClearSizeCallback) cacheSizeCallback2).onItemCacheSizeResult(baseClearCache2, baseClearCache2.getCacheSize());
                                        }
                                        this.val$latch.countDown();
                                    }
                                }
                            });
                        }
                        try {
                            countDownLatch.await(2L, TimeUnit.MINUTES);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        long j2 = 0;
                        for (BaseClearCache baseClearCache2 : calculateCacheList) {
                            if (baseClearCache2.getCacheSize() >= 1024) {
                                j2 += baseClearCache2.getCacheSize();
                            }
                        }
                        this.this$0.setCacheSize(j2);
                        try {
                            ClearCacheTips.notifyTips(j2);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        BaseClearCache.CacheSizeCallback cacheSizeCallback2 = this.val$cacheSizeCallback;
                        if (cacheSizeCallback2 != null) {
                            cacheSizeCallback2.onCacheSizeResult(j2);
                        }
                    }
                }
            }, CALCULATE_TASK_NAME, 1);
        }
    }

    @Override // com.baidu.searchbox.download.center.clearcache.BaseClearCache
    public void clearCache(BaseClearCache.CacheClearCallback cacheClearCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cacheClearCallback) == null) {
            ExecutorUtilsExt.postOnElastic(new Runnable(this, cacheClearCallback) { // from class: com.baidu.searchbox.download.center.clearcache.MainClearCache.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MainClearCache this$0;
                public final /* synthetic */ BaseClearCache.CacheClearCallback val$clearCacheCallback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cacheClearCallback};
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
                    this.val$clearCacheCallback = cacheClearCallback;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        List<BaseClearCache> selectedClearCacheList = this.this$0.getSelectedClearCacheList();
                        CountDownLatch countDownLatch = new CountDownLatch(selectedClearCacheList.size());
                        for (BaseClearCache baseClearCache : selectedClearCacheList) {
                            baseClearCache.clearCache(new BaseClearCache.CacheClearCallback(this, baseClearCache, countDownLatch) { // from class: com.baidu.searchbox.download.center.clearcache.MainClearCache.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;
                                public final /* synthetic */ BaseClearCache val$baseClearCache;
                                public final /* synthetic */ CountDownLatch val$latch;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, baseClearCache, countDownLatch};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$baseClearCache = baseClearCache;
                                    this.val$latch = countDownLatch;
                                }

                                @Override // com.baidu.searchbox.download.center.clearcache.BaseClearCache.CacheClearCallback
                                public void onClearCacheResult(boolean z) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeZ(1048576, this, z) == null) {
                                        long cacheSize = this.val$baseClearCache.getCacheSize();
                                        if (z) {
                                            this.val$baseClearCache.setCacheSize(0L);
                                        }
                                        BaseClearCache.CacheClearCallback cacheClearCallback2 = this.this$1.val$clearCacheCallback;
                                        if (cacheClearCallback2 instanceof MainClearCacheCallback) {
                                            ((MainClearCacheCallback) cacheClearCallback2).onItemClearCacheResult(this.val$baseClearCache, cacheSize, z);
                                        }
                                        this.val$latch.countDown();
                                    }
                                }
                            });
                        }
                        try {
                            countDownLatch.await(2L, TimeUnit.MINUTES);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        long j2 = 0;
                        for (BaseClearCache baseClearCache2 : this.this$0.getCalculateCacheList()) {
                            j2 += baseClearCache2.getCacheSize();
                        }
                        this.this$0.setCacheSize(j2);
                        try {
                            ClearCacheTips.notifyTips(j2);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        BaseClearCache.CacheClearCallback cacheClearCallback2 = this.val$clearCacheCallback;
                        if (cacheClearCallback2 != null) {
                            cacheClearCallback2.onClearCacheResult(true);
                        }
                    }
                }
            }, CLEAR_TASK_NAME, 1);
        }
    }

    @Override // com.baidu.searchbox.download.center.clearcache.BaseClearCache
    public String getCacheDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.download.center.clearcache.BaseClearCache
    public String getCacheName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public List<BaseClearCache> getCalculateCacheList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(sDownloadClearCache);
            for (BaseClearCache baseClearCache : this.mShowClearCacheList) {
                if (baseClearCache.isCalculateCacheSize()) {
                    arrayList.add(baseClearCache);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public long getDownloadSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? sDownloadClearCache.getCacheSize() : invokeV.longValue;
    }

    public long getSelectedCacheSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long j2 = 0;
            for (BaseClearCache baseClearCache : sSubClearCacheList) {
                if (baseClearCache.isSelected() && baseClearCache.getCacheSize() >= 1024) {
                    j2 += baseClearCache.getCacheSize();
                }
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public List<BaseClearCache> getSelectedClearCacheList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (BaseClearCache baseClearCache : this.mShowClearCacheList) {
                if (baseClearCache.isSelected()) {
                    arrayList.add(baseClearCache);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public long getSelectedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<BaseClearCache> selectedClearCacheList = getSelectedClearCacheList();
            long j2 = 0;
            if (selectedClearCacheList != null && selectedClearCacheList.size() > 0) {
                for (BaseClearCache baseClearCache : selectedClearCacheList) {
                    j2 += baseClearCache.getCacheSize();
                }
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public List<BaseClearCache> getShowClearCacheList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mShowClearCacheList : (List) invokeV.objValue;
    }

    public List<BaseClearCache> getSubClearCacheList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? sSubClearCacheList : (List) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.download.center.clearcache.BaseClearCache
    public String getUBCExtKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "main" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.download.center.clearcache.BaseClearCache
    public boolean isCalculateCacheSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.download.center.clearcache.BaseClearCache
    public boolean isDefaultSelected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
