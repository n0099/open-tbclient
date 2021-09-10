package com.baidu.mapapi.synchronization.histroytrace;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class HistoryTraceManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.b.b f42001a;

    public HistoryTraceManager() {
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
        this.f42001a = new com.baidu.mapsdkplatform.comapi.synchronization.b.b();
    }

    public boolean isHttpsEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.b.b bVar = this.f42001a;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b("HistoryTraceManager", "The implement instance is null");
                return true;
            }
            return bVar.b();
        }
        return invokeV.booleanValue;
    }

    public void queryHistoryTraceData(HistoryTraceQueryOptions historyTraceQueryOptions) {
        com.baidu.mapsdkplatform.comapi.synchronization.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, historyTraceQueryOptions) == null) || (bVar = this.f42001a) == null) {
            return;
        }
        bVar.a(historyTraceQueryOptions);
    }

    public void release() {
        com.baidu.mapsdkplatform.comapi.synchronization.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.f42001a) == null) {
            return;
        }
        bVar.a();
    }

    public void renderHistoryTrace(BaiduMap baiduMap, HistoryTraceData historyTraceData, HistoryTraceDisplayOptions historyTraceDisplayOptions, int i2) {
        com.baidu.mapsdkplatform.comapi.synchronization.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048579, this, baiduMap, historyTraceData, historyTraceDisplayOptions, i2) == null) || (bVar = this.f42001a) == null) {
            return;
        }
        bVar.a(baiduMap, historyTraceData, historyTraceDisplayOptions, i2);
    }

    public void setHttpsEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.b.b bVar = this.f42001a;
            if (bVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b("HistoryTraceManager", "The implement instance is null");
            } else {
                bVar.a(z);
            }
        }
    }

    public void setOnHistoryTraceListener(OnHistoryTraceListener onHistoryTraceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onHistoryTraceListener) == null) {
            if (onHistoryTraceListener == null) {
                throw new IllegalArgumentException("HistoryTraceManager-- OnHistoryTraceListener must not be null.");
            }
            com.baidu.mapsdkplatform.comapi.synchronization.b.b bVar = this.f42001a;
            if (bVar != null) {
                bVar.a(onHistoryTraceListener);
            }
        }
    }
}
