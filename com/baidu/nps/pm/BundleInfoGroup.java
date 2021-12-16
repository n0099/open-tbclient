package com.baidu.nps.pm;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class BundleInfoGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, BundleInfo> bundleInfoMap;
    public long timeStamp;

    public BundleInfoGroup(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.bundleInfoMap = new HashMap();
        this.timeStamp = 0L;
        this.timeStamp = j2;
    }

    public synchronized BundleInfo getBundleByType(int i2) {
        InterceptResult invokeI;
        BundleInfo bundleInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            synchronized (this) {
                bundleInfo = this.bundleInfoMap.get(Integer.valueOf(i2));
            }
            return bundleInfo;
        }
        return (BundleInfo) invokeI.objValue;
    }

    public synchronized long getTimeStamp() {
        InterceptResult invokeV;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                j2 = this.timeStamp;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public synchronized void removeBundleByType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            synchronized (this) {
                this.bundleInfoMap.remove(Integer.valueOf(i2));
            }
        }
    }

    public synchronized void setTimeStamp(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            synchronized (this) {
                this.timeStamp = j2;
            }
        }
    }

    public synchronized void swapBundleByType(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            synchronized (this) {
                BundleInfo remove = this.bundleInfoMap.remove(Integer.valueOf(i2));
                if (remove != null) {
                    this.bundleInfoMap.put(Integer.valueOf(i3), remove);
                }
            }
        }
    }

    public synchronized void updateBundleByType(int i2, BundleInfo bundleInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, bundleInfo) == null) {
            synchronized (this) {
                bundleInfo.setType(i2);
                this.bundleInfoMap.put(Integer.valueOf(i2), bundleInfo);
            }
        }
    }
}
