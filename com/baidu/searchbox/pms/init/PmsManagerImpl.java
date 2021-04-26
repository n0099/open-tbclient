package com.baidu.searchbox.pms.init;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.util.Collections;
import java.util.List;
import java.util.Map;
@Singleton
@Service
/* loaded from: classes2.dex */
public class PmsManagerImpl implements IPmsManager {
    @Override // com.baidu.searchbox.pms.init.IPmsManager
    public void deletePackageInfo(String str, String str2) {
        PackageManager.deleteLatestPackageFile(str, str2);
    }

    @Override // com.baidu.searchbox.pms.init.IPmsManager
    @NonNull
    public IDownloadManager download(@NonNull PackageInfo packageInfo, @Nullable DownloadOptions downloadOptions, @Nullable DownloadCallback downloadCallback) {
        return download(Collections.singletonList(packageInfo), downloadOptions, downloadCallback);
    }

    @Override // com.baidu.searchbox.pms.init.IPmsManager
    public void execute(RequestParams requestParams) {
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

    @Override // com.baidu.searchbox.pms.init.IPmsManager
    public Map<String, PackageInfo> getPackageInfo(String str, String str2) {
        return PackageManager.getFinishedPackageInfo(str, str2);
    }

    @Override // com.baidu.searchbox.pms.init.IPmsManager
    public boolean isInDegradeList(String str, String str2) {
        return RequestDataUtils.isPackageNameDegrade("aps", str, str2) || RequestDataUtils.isPackageNameDegrade(ApsCloudControlProcessor.SERVER_DPM, str, str2);
    }

    @Override // com.baidu.searchbox.pms.init.IPmsManager
    public int resetUpdateVersion(String str, List<String> list) {
        return PackageManager.resetUpdateVersion(str, list);
    }

    @Override // com.baidu.searchbox.pms.init.IPmsManager
    @NonNull
    public IDownloadManager download(@NonNull List<PackageInfo> list, @Nullable DownloadOptions downloadOptions, @Nullable DownloadCallback downloadCallback) {
        IDownloadManager downloadManager = DownloadManager.getInstance();
        downloadManager.start(list, downloadOptions, downloadCallback);
        return downloadManager;
    }
}
