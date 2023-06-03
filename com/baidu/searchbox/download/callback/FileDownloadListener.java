package com.baidu.searchbox.download.callback;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.DownloadBean;
import com.baidu.searchbox.download.model.DownloadState;
import com.baidu.searchbox.download.model.StopStatus;
/* loaded from: classes3.dex */
public class FileDownloadListener implements DownloadListener {
    public IDownloadListener mApkDownloadListener;
    public Context mContext;
    public DownloadManagerExt mDownloadManagerExt = DownloadManagerExt.getInstance();

    /* renamed from: com.baidu.searchbox.download.callback.FileDownloadListener$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$download$model$DownloadState;

        static {
            int[] iArr = new int[DownloadState.values().length];
            $SwitchMap$com$baidu$searchbox$download$model$DownloadState = iArr;
            try {
                iArr[DownloadState.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$model$DownloadState[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$model$DownloadState[DownloadState.DOWNLOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$model$DownloadState[DownloadState.DOWNLOAD_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$model$DownloadState[DownloadState.NOT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public FileDownloadListener(Context context, IDownloadListener iDownloadListener) {
        this.mApkDownloadListener = iDownloadListener;
        this.mContext = context;
    }

    @Override // com.baidu.searchbox.download.callback.DownloadListener
    public void onChanged(DownloadBean downloadBean) {
        if (downloadBean != null && downloadBean.getStatus() == 0) {
            int i = AnonymousClass1.$SwitchMap$com$baidu$searchbox$download$model$DownloadState[downloadBean.getDownloadState().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                this.mApkDownloadListener.onStopped(StopStatus.DOWNLOAD_UNSTART);
                                return;
                            }
                            return;
                        }
                        this.mApkDownloadListener.onStopped(StopStatus.DOWNLOAD_FAIL);
                        return;
                    } else if (downloadBean.getCurrentBytes() == downloadBean.getTotalBytes() && downloadBean.getCurrentBytes() > 0 && downloadBean.getTotalBytes() > 0) {
                        Uri uri = downloadBean.getUri();
                        this.mApkDownloadListener.onSuccess(uri);
                        this.mDownloadManagerExt.unregisterObserver(this.mContext, uri);
                        return;
                    } else {
                        return;
                    }
                }
                long currentBytes = downloadBean.getCurrentBytes();
                long totalBytes = downloadBean.getTotalBytes();
                Uri uri2 = downloadBean.getUri();
                int i2 = (totalBytes > 0L ? 1 : (totalBytes == 0L ? 0 : -1));
                if (i2 <= 0) {
                    this.mApkDownloadListener.onPause(uri2, 0);
                    return;
                }
                int floor = (int) Math.floor((100 * currentBytes) / totalBytes);
                if (currentBytes > 0 && i2 > 0 && floor != 100) {
                    this.mApkDownloadListener.onPause(uri2, floor);
                    return;
                }
                return;
            }
            long currentBytes2 = downloadBean.getCurrentBytes();
            long totalBytes2 = downloadBean.getTotalBytes();
            int i3 = (totalBytes2 > 0L ? 1 : (totalBytes2 == 0L ? 0 : -1));
            if (i3 > 0) {
                int floor2 = (int) Math.floor((100 * currentBytes2) / totalBytes2);
                if (currentBytes2 > 0 && i3 > 0 && floor2 != 100) {
                    this.mApkDownloadListener.onProgressChanged(downloadBean.getUri(), floor2);
                    this.mApkDownloadListener.onProgress(downloadBean.getUri(), currentBytes2, totalBytes2);
                    return;
                }
                return;
            }
            return;
        }
        this.mApkDownloadListener.onStopped(StopStatus.DOWNLOAD_FAIL);
    }
}
