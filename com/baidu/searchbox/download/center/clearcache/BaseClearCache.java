package com.baidu.searchbox.download.center.clearcache;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class BaseClearCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mCacheSize;
    public boolean mSelected;

    /* loaded from: classes2.dex */
    public interface CacheClearCallback {
        void onClearCacheResult(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface CacheSizeCallback {
        void onCacheSizeResult(long j);
    }

    public BaseClearCache() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCacheSize = 0L;
        this.mSelected = isDefaultSelected();
    }

    public abstract void calculateCacheSize(CacheSizeCallback cacheSizeCallback);

    public abstract void clearCache(CacheClearCallback cacheClearCallback);

    public abstract String getCacheDesc();

    public abstract String getCacheName();

    public long getCacheSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mCacheSize : invokeV.longValue;
    }

    public abstract String getUBCExtKey();

    public abstract boolean isCalculateCacheSize();

    public abstract boolean isDefaultSelected();

    public boolean isSelected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mSelected : invokeV.booleanValue;
    }

    public boolean isShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setCacheSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.mCacheSize = j;
        }
    }

    public void setSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mSelected = z;
        }
    }
}
