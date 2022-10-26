package com.baidu.searchbox.pms.init;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DownloadCallback;
import com.baidu.searchbox.pms.download.DownloadManager;
import com.baidu.searchbox.pms.download.DownloadOptions;
import com.baidu.searchbox.pms.download.IDownloadManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public interface IPmsManager {
    public static final IPmsManager EMPTY = new IPmsManager() { // from class: com.baidu.searchbox.pms.init.IPmsManager.1
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.searchbox.pms.init.IPmsManager
        public void deletePackageInfo(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // com.baidu.searchbox.pms.init.IPmsManager
        public void execute(RequestParams requestParams) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, requestParams) == null) {
            }
        }

        @Override // com.baidu.searchbox.pms.init.IPmsManager
        public Map getPackageInfo(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
                return null;
            }
            return (Map) invokeLL.objValue;
        }

        @Override // com.baidu.searchbox.pms.init.IPmsManager
        public boolean isInDegradeList(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.searchbox.pms.init.IPmsManager
        public int resetUpdateVersion(String str, List list) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, list)) == null) {
                return 0;
            }
            return invokeLL.intValue;
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

        @Override // com.baidu.searchbox.pms.init.IPmsManager
        public IDownloadManager download(PackageInfo packageInfo, DownloadOptions downloadOptions, DownloadCallback downloadCallback) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, packageInfo, downloadOptions, downloadCallback)) == null) {
                return DownloadManager.getInstance();
            }
            return (IDownloadManager) invokeLLL.objValue;
        }

        @Override // com.baidu.searchbox.pms.init.IPmsManager
        public IDownloadManager download(List list, DownloadOptions downloadOptions, DownloadCallback downloadCallback) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, list, downloadOptions, downloadCallback)) == null) {
                return DownloadManager.getInstance();
            }
            return (IDownloadManager) invokeLLL.objValue;
        }
    };

    void deletePackageInfo(String str, String str2);

    IDownloadManager download(PackageInfo packageInfo, DownloadOptions downloadOptions, DownloadCallback downloadCallback);

    IDownloadManager download(List list, DownloadOptions downloadOptions, DownloadCallback downloadCallback);

    void execute(RequestParams requestParams);

    Map getPackageInfo(String str, String str2);

    boolean isInDegradeList(String str, String str2);

    int resetUpdateVersion(String str, List list);
}
