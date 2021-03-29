package com.baidu.searchbox.pms.download;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class DownloadCallbackWrap implements InnerCallback {
    public DownloadCallback mCallback;
    public List<PackageInfo> mList;
    public DownloadOptions mOptions;

    public DownloadCallbackWrap(List<PackageInfo> list, DownloadCallback downloadCallback, DownloadOptions downloadOptions) {
        this.mCallback = downloadCallback;
        this.mOptions = downloadOptions;
        if (downloadCallback == null) {
            this.mCallback = new DefaultDownloadCallback();
        }
        this.mList = list;
    }

    private boolean isAllFinish() {
        for (PackageInfo packageInfo : this.mList) {
            int i = packageInfo.type;
            if (i != 5 && i != 6 && i != 10) {
                return false;
            }
        }
        return true;
    }

    public void checkAllFinish() {
        if (isAllFinish()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (PackageInfo packageInfo : this.mList) {
                int i = packageInfo.type;
                if (i == 5) {
                    arrayList3.add(packageInfo);
                } else if (i == 6) {
                    arrayList2.add(packageInfo);
                } else if (i == 10) {
                    arrayList.add(packageInfo);
                }
            }
            this.mCallback.onBulkDownloaded(arrayList, arrayList2, arrayList3);
            StatisticUtils.sendBulkDownload(arrayList, arrayList2, arrayList3, 0);
        }
    }

    public void notifyError(PackageInfo packageInfo, ErrorInfo errorInfo) {
        if (packageInfo != null) {
            DebugUtils.log("[回调错误]", packageInfo.packageName, errorInfo);
            packageInfo.type = 6;
            this.mCallback.onDownloadError(packageInfo, errorInfo);
            StatisticUtils.sendDownload(packageInfo, errorInfo);
            checkAllFinish();
        }
    }

    public void notifySuccess(PackageInfo packageInfo) {
        this.mCallback.onDownloadSuccess(packageInfo, null);
        checkAllFinish();
        StatisticUtils.sendDownload(packageInfo, 2200);
        DebugUtils.log("【回调成功】", packageInfo);
    }

    @Override // com.baidu.searchbox.pms.download.InnerCallback
    public void onCancel(PackageInfo packageInfo) {
        if (packageInfo != null) {
            this.mCallback.onDownloadCancel(packageInfo);
            StatisticUtils.sendDownload(packageInfo, (int) ErrorConstant.Code.DOWNLOAD_CANCELED);
            checkAllFinish();
        }
    }

    @Override // com.baidu.searchbox.pms.download.InnerCallback
    public void onError(PackageInfo packageInfo, int i, String str) {
        notifyError(packageInfo, new ErrorInfo(i, str));
    }

    @Override // com.baidu.searchbox.pms.download.InnerCallback
    public void onPause(PackageInfo packageInfo) {
        if (packageInfo != null) {
            this.mCallback.onDownloadPause(packageInfo);
        }
    }

    @Override // com.baidu.searchbox.pms.download.InnerCallback
    public void onProgress(PackageInfo packageInfo, long j, long j2) {
        if (packageInfo != null) {
            packageInfo.currentSize = j;
            packageInfo.totalSize = j2;
            this.mCallback.onDownloadProgress(packageInfo, j, j2);
        }
    }

    @Override // com.baidu.searchbox.pms.download.InnerCallback
    public void onResume(PackageInfo packageInfo) {
        if (packageInfo != null) {
            this.mCallback.onDownloadResume(packageInfo, packageInfo.currentSize, packageInfo.totalSize);
        }
    }

    @Override // com.baidu.searchbox.pms.download.InnerCallback
    public void onRetry(PackageInfo packageInfo) {
        if (packageInfo != null) {
            packageInfo.retryCount++;
        }
    }

    @Override // com.baidu.searchbox.pms.download.InnerCallback
    public void onStart(PackageInfo packageInfo) {
        if (packageInfo != null) {
            this.mCallback.onDownloadStart(packageInfo);
        }
    }

    @Override // com.baidu.searchbox.pms.download.InnerCallback
    @SuppressLint({"StaticFieldLeak"})
    public void onSuccess(final PackageInfo packageInfo) {
        new AsyncTask<PackageInfo, Void, ErrorInfo>() { // from class: com.baidu.searchbox.pms.download.DownloadCallbackWrap.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            public ErrorInfo doInBackground(PackageInfo... packageInfoArr) {
                ErrorInfo ubcFileExist = DownloadUtils.ubcFileExist(packageInfo);
                if (ubcFileExist != null) {
                    return ubcFileExist;
                }
                if (!DownloadUtils.isSameMD5(packageInfo.filePath, packageInfo.md5)) {
                    return new ErrorInfo(2202, packageInfo.md5);
                }
                packageInfo.type = 10;
                if ((DownloadCallbackWrap.this.mOptions == null || DownloadCallbackWrap.this.mOptions.saveToDb) && PackageControl.getInstance().addOrUpdate(packageInfo) <= 0) {
                    return new ErrorInfo(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, packageInfo.md5);
                }
                return null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            public void onPostExecute(ErrorInfo errorInfo) {
                super.onPostExecute((AnonymousClass1) errorInfo);
                if (errorInfo == null) {
                    DownloadCallbackWrap.this.notifySuccess(packageInfo);
                } else {
                    DownloadCallbackWrap.this.notifyError(packageInfo, errorInfo);
                }
            }
        }.executeOnExecutor(ExecutorUtilsExt.getElasticExecutor("DownloadCallbackWrap", 3), new PackageInfo[0]);
    }
}
