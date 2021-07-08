package com.baidu.searchbox.pms.init;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DownloadCallback;
import com.baidu.searchbox.pms.db.PackageManager;
import com.baidu.searchbox.pms.download.DownloadManager;
import com.baidu.searchbox.pms.download.DownloadOptions;
import com.baidu.searchbox.pms.download.IDownloadManager;
import com.baidu.searchbox.pms.init.request.RequestDataUtils;
import com.baidu.searchbox.pms.init.request.RequestTask;
import com.baidu.searchbox.pms.init.response.ResponseDataProcess;
import com.baidu.searchbox.pms.utils.CommonUtils;
import com.baidu.searchbox.pms.utils.DebugUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
@Singleton
@Service
/* loaded from: classes2.dex */
public class PmsManagerImpl implements IPmsManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PmsManagerImpl() {
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
            PackageManager.deleteLatestPackageFile(str, str2);
        }
    }

    @Override // com.baidu.searchbox.pms.init.IPmsManager
    @NonNull
    public IDownloadManager download(@NonNull PackageInfo packageInfo, @Nullable DownloadOptions downloadOptions, @Nullable DownloadCallback downloadCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, packageInfo, downloadOptions, downloadCallback)) == null) ? download(Collections.singletonList(packageInfo), downloadOptions, downloadCallback) : (IDownloadManager) invokeLLL.objValue;
    }

    @Override // com.baidu.searchbox.pms.init.IPmsManager
    public void execute(RequestParams requestParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, requestParams) == null) {
            if (requestParams == null) {
                DebugUtils.throwExceptionForDebug("requestParams should not be null");
                return;
            }
            String checkParamsWithMsg = RequestDataUtils.checkParamsWithMsg(requestParams);
            if (!TextUtils.isEmpty(checkParamsWithMsg)) {
                ResponseDataProcess.dispatchFetchError(new ErrorInfo(2102, checkParamsWithMsg), requestParams.getChannelList());
            } else {
                CommonUtils.postThread(new RequestTask(requestParams), "pms_execute");
            }
        }
    }

    @Override // com.baidu.searchbox.pms.init.IPmsManager
    public Map<String, PackageInfo> getPackageInfo(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) ? PackageManager.getFinishedPackageInfo(str, str2) : (Map) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.pms.init.IPmsManager
    public boolean isInDegradeList(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) ? RequestDataUtils.isPackageNameDegrade("aps", str, str2) || RequestDataUtils.isPackageNameDegrade(ApsCloudControlProcessor.SERVER_DPM, str, str2) : invokeLL.booleanValue;
    }

    @Override // com.baidu.searchbox.pms.init.IPmsManager
    public int resetUpdateVersion(String str, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, list)) == null) ? PackageManager.resetUpdateVersion(str, list) : invokeLL.intValue;
    }

    @Override // com.baidu.searchbox.pms.init.IPmsManager
    @NonNull
    public IDownloadManager download(@NonNull List<PackageInfo> list, @Nullable DownloadOptions downloadOptions, @Nullable DownloadCallback downloadCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, list, downloadOptions, downloadCallback)) == null) {
            IDownloadManager downloadManager = DownloadManager.getInstance();
            downloadManager.start(list, downloadOptions, downloadCallback);
            return downloadManager;
        }
        return (IDownloadManager) invokeLLL.objValue;
    }
}
