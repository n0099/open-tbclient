package com.baidu.nps.pm;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class BundleInfoGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, BundleInfo> bundleInfoMap;
    public long timeStamp;

    public BundleInfoGroup(long j) {
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
        this.bundleInfoMap = new HashMap();
        this.timeStamp = 0L;
        this.timeStamp = j;
    }

    public synchronized BundleInfo getBundleByType(int i) {
        InterceptResult invokeI;
        BundleInfo bundleInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            synchronized (this) {
                bundleInfo = this.bundleInfoMap.get(Integer.valueOf(i));
            }
            return bundleInfo;
        }
        return (BundleInfo) invokeI.objValue;
    }

    public synchronized void removeBundleByType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            synchronized (this) {
                this.bundleInfoMap.remove(Integer.valueOf(i));
            }
        }
    }

    public synchronized void setTimeStamp(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            synchronized (this) {
                this.timeStamp = j;
            }
        }
    }

    public synchronized long getTimeStamp() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                j = this.timeStamp;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public synchronized void swapBundleByType(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            synchronized (this) {
                BundleInfo remove = this.bundleInfoMap.remove(Integer.valueOf(i));
                if (remove != null) {
                    this.bundleInfoMap.put(Integer.valueOf(i2), remove);
                }
            }
        }
    }

    public synchronized void updateBundleByType(int i, BundleInfo bundleInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, bundleInfo) == null) {
            synchronized (this) {
                bundleInfo.setType(i);
                this.bundleInfoMap.put(Integer.valueOf(i), bundleInfo);
            }
        }
    }
}
