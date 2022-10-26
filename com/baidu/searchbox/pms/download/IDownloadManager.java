package com.baidu.searchbox.pms.download;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DownloadCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public interface IDownloadManager {
    public static final IDownloadManager EMPTY = new IDownloadManager() { // from class: com.baidu.searchbox.pms.download.IDownloadManager.1
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.searchbox.pms.download.IDownloadManager
        public void cancel(PackageInfo packageInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, packageInfo) == null) {
            }
        }

        @Override // com.baidu.searchbox.pms.download.IDownloadManager
        public int getStatus(PackageInfo packageInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, packageInfo)) == null) {
                return 0;
            }
            return invokeL.intValue;
        }

        @Override // com.baidu.searchbox.pms.download.IDownloadManager
        public void pause(PackageInfo packageInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, packageInfo) == null) {
            }
        }

        @Override // com.baidu.searchbox.pms.download.IDownloadManager
        public void resume(PackageInfo packageInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, packageInfo) == null) {
            }
        }

        @Override // com.baidu.searchbox.pms.download.IDownloadManager
        public void start(List list, DownloadOptions downloadOptions, DownloadCallback downloadCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, list, downloadOptions, downloadCallback) == null) {
            }
        }

        {
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
    };

    void cancel(PackageInfo packageInfo);

    int getStatus(PackageInfo packageInfo);

    void pause(PackageInfo packageInfo);

    void resume(PackageInfo packageInfo);

    void start(List list, DownloadOptions downloadOptions, DownloadCallback downloadCallback);
}
