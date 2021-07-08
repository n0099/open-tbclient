package com.baidu.searchbox.pms.init;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

        {
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

        @Override // com.baidu.searchbox.pms.init.IPmsManager
        public void deletePackageInfo(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // com.baidu.searchbox.pms.init.IPmsManager
        @NonNull
        public IDownloadManager download(@NonNull PackageInfo packageInfo, @Nullable DownloadOptions downloadOptions, @Nullable DownloadCallback downloadCallback) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, packageInfo, downloadOptions, downloadCallback)) == null) ? DownloadManager.getInstance() : (IDownloadManager) invokeLLL.objValue;
        }

        @Override // com.baidu.searchbox.pms.init.IPmsManager
        public void execute(RequestParams requestParams) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, requestParams) == null) {
            }
        }

        @Override // com.baidu.searchbox.pms.init.IPmsManager
        public Map<String, PackageInfo> getPackageInfo(String str, String str2) {
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
        public int resetUpdateVersion(String str, List<String> list) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, list)) == null) {
                return 0;
            }
            return invokeLL.intValue;
        }

        @Override // com.baidu.searchbox.pms.init.IPmsManager
        @NonNull
        public IDownloadManager download(@NonNull List<PackageInfo> list, @Nullable DownloadOptions downloadOptions, @Nullable DownloadCallback downloadCallback) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, list, downloadOptions, downloadCallback)) == null) ? DownloadManager.getInstance() : (IDownloadManager) invokeLLL.objValue;
        }
    };

    void deletePackageInfo(String str, String str2);

    @NonNull
    IDownloadManager download(@NonNull PackageInfo packageInfo, @Nullable DownloadOptions downloadOptions, @Nullable DownloadCallback downloadCallback);

    @NonNull
    IDownloadManager download(@NonNull List<PackageInfo> list, @Nullable DownloadOptions downloadOptions, @Nullable DownloadCallback downloadCallback);

    void execute(RequestParams requestParams);

    Map<String, PackageInfo> getPackageInfo(String str, String str2);

    boolean isInDegradeList(String str, String str2);

    int resetUpdateVersion(String str, List<String> list);
}
