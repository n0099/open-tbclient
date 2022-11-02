package com.baidu.searchbox.pms.download;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.callback.DownloadCallback;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageControl;
import com.baidu.searchbox.pms.utils.DebugUtils;
import com.baidu.searchbox.pms.utils.DownloadUtils;
import com.baidu.searchbox.pms.utils.StatisticUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class DownloadCallbackWrap implements InnerCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadCallback mCallback;
    public List<PackageInfo> mList;
    public DownloadOptions mOptions;

    public DownloadCallbackWrap(List<PackageInfo> list, DownloadCallback downloadCallback, DownloadOptions downloadOptions) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, downloadCallback, downloadOptions};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCallback = downloadCallback;
        this.mOptions = downloadOptions;
        if (downloadCallback == null) {
            this.mCallback = new DefaultDownloadCallback();
        }
        this.mList = list;
    }

    @Override // com.baidu.searchbox.pms.download.InnerCallback
    public void onProgress(PackageInfo packageInfo, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{packageInfo, Long.valueOf(j), Long.valueOf(j2)}) == null) && packageInfo != null) {
            packageInfo.currentSize = j;
            packageInfo.totalSize = j2;
            this.mCallback.onDownloadProgress(packageInfo, j, j2);
        }
    }

    public void notifySuccess(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, packageInfo) == null) {
            this.mCallback.onDownloadSuccess(packageInfo, null);
            checkAllFinish();
            StatisticUtils.sendDownload(packageInfo, 2200);
            DebugUtils.log("【回调成功】", packageInfo);
        }
    }

    @Override // com.baidu.searchbox.pms.download.InnerCallback
    public void onCancel(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, packageInfo) == null) && packageInfo != null) {
            this.mCallback.onDownloadCancel(packageInfo);
            StatisticUtils.sendDownload(packageInfo, (int) ErrorConstant.Code.DOWNLOAD_CANCELED);
            checkAllFinish();
        }
    }

    @Override // com.baidu.searchbox.pms.download.InnerCallback
    public void onPause(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, packageInfo) == null) && packageInfo != null) {
            this.mCallback.onDownloadPause(packageInfo);
        }
    }

    @Override // com.baidu.searchbox.pms.download.InnerCallback
    public void onResume(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, packageInfo) == null) && packageInfo != null) {
            this.mCallback.onDownloadResume(packageInfo, packageInfo.currentSize, packageInfo.totalSize);
        }
    }

    @Override // com.baidu.searchbox.pms.download.InnerCallback
    public void onRetry(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, packageInfo) == null) && packageInfo != null) {
            packageInfo.retryCount++;
        }
    }

    @Override // com.baidu.searchbox.pms.download.InnerCallback
    public void onStart(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, packageInfo) == null) && packageInfo != null) {
            this.mCallback.onDownloadStart(packageInfo);
        }
    }

    @Override // com.baidu.searchbox.pms.download.InnerCallback
    @SuppressLint({"StaticFieldLeak"})
    public void onSuccess(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, packageInfo) == null) {
            new AsyncTask<PackageInfo, Void, ErrorInfo>(this, packageInfo) { // from class: com.baidu.searchbox.pms.download.DownloadCallbackWrap.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadCallbackWrap this$0;
                public final /* synthetic */ PackageInfo val$info;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, packageInfo};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$info = packageInfo;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.AsyncTask
                public ErrorInfo doInBackground(PackageInfo... packageInfoArr) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, packageInfoArr)) == null) {
                        ErrorInfo ubcFileExist = DownloadUtils.ubcFileExist(this.val$info);
                        if (ubcFileExist != null) {
                            return ubcFileExist;
                        }
                        if (!DownloadUtils.isSameMD5(this.val$info.filePath, this.val$info.md5)) {
                            return new ErrorInfo(2202, this.val$info.md5);
                        }
                        this.val$info.type = 10;
                        if ((this.this$0.mOptions != null && !this.this$0.mOptions.saveToDb) || PackageControl.getInstance().addOrUpdate(this.val$info) > 0) {
                            return null;
                        }
                        return new ErrorInfo(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, this.val$info.md5);
                    }
                    return (ErrorInfo) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.AsyncTask
                public void onPostExecute(ErrorInfo errorInfo) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, errorInfo) == null) {
                        super.onPostExecute((AnonymousClass1) errorInfo);
                        if (errorInfo == null) {
                            this.this$0.notifySuccess(this.val$info);
                        } else {
                            this.this$0.notifyError(this.val$info, errorInfo);
                        }
                    }
                }
            }.executeOnExecutor(ExecutorUtilsExt.getElasticExecutor("DownloadCallbackWrap", 3), new PackageInfo[0]);
        }
    }

    private boolean isAllFinish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            for (PackageInfo packageInfo : this.mList) {
                int i = packageInfo.type;
                if (i != 5 && i != 6 && i != 10) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void checkAllFinish() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && isAllFinish()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (PackageInfo packageInfo : this.mList) {
                int i = packageInfo.type;
                if (i != 5) {
                    if (i != 6) {
                        if (i == 10) {
                            arrayList.add(packageInfo);
                        }
                    } else {
                        arrayList2.add(packageInfo);
                    }
                } else {
                    arrayList3.add(packageInfo);
                }
            }
            this.mCallback.onBulkDownloaded(arrayList, arrayList2, arrayList3);
            StatisticUtils.sendBulkDownload(arrayList, arrayList2, arrayList3, 0);
        }
    }

    public void notifyError(PackageInfo packageInfo, ErrorInfo errorInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, packageInfo, errorInfo) == null) && packageInfo != null) {
            DebugUtils.log("[回调错误]", packageInfo.packageName, errorInfo);
            packageInfo.type = 6;
            this.mCallback.onDownloadError(packageInfo, errorInfo);
            StatisticUtils.sendDownload(packageInfo, errorInfo);
            checkAllFinish();
        }
    }

    @Override // com.baidu.searchbox.pms.download.InnerCallback
    public void onError(PackageInfo packageInfo, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, packageInfo, i, str) == null) {
            notifyError(packageInfo, new ErrorInfo(i, str));
        }
    }
}
