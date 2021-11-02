package com.baidu.searchbox.pms.download;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Autowired
/* loaded from: classes7.dex */
public class DownloadManager {
    public static /* synthetic */ Interceptable $ic;
    public static IDownloadManager sDownloadManager;
    public transient /* synthetic */ FieldHolder $fh;

    public DownloadManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Inject(force = false)
    public static IDownloadManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sDownloadManager == null) {
                sDownloadManager = IDownloadManager.EMPTY;
            }
            return DownloadManagerImpl_Factory.get();
        }
        return (IDownloadManager) invokeV.objValue;
    }

    public static void setDownloadManager(IDownloadManager iDownloadManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, iDownloadManager) == null) {
            sDownloadManager = iDownloadManager;
        }
    }
}
