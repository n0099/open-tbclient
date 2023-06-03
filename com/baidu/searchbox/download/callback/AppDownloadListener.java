package com.baidu.searchbox.download.callback;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.DownloadBean;
import com.baidu.searchbox.download.model.DownloadState;
import com.baidu.searchbox.download.model.StopStatus;
/* loaded from: classes3.dex */
public class AppDownloadListener implements DownloadListener {
    public static final int PROGRESS_ONE_HUNDRED = 100;
    public IAppDownloadListener mApkDownloadListener;
    public Context mContext;
    public DownloadManagerExt mDownloadManagerExt = DownloadManagerExt.getInstance();
    public Uri mUri;

    /* renamed from: com.baidu.searchbox.download.callback.AppDownloadListener$1  reason: invalid class name */
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

    public AppDownloadListener(Context context, Uri uri, IAppDownloadListener iAppDownloadListener) {
        this.mApkDownloadListener = iAppDownloadListener;
        this.mContext = context;
        this.mUri = uri;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.searchbox.download.callback.DownloadListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onChanged(DownloadBean downloadBean) {
        int i;
        int i2;
        if (downloadBean != null && downloadBean.getStatus() == 0) {
            int i3 = AnonymousClass1.$SwitchMap$com$baidu$searchbox$download$model$DownloadState[downloadBean.getDownloadState().ordinal()];
            boolean z = true;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                this.mApkDownloadListener.onStopped(downloadBean.getDownloadId(), StopStatus.DOWNLOAD_UNSTART);
                                return;
                            }
                            return;
                        }
                        this.mApkDownloadListener.onStopped(downloadBean.getDownloadId(), StopStatus.DOWNLOAD_FAIL);
                    } else if (downloadBean.getTotalBytes() <= 0) {
                        z = false;
                        if (!z) {
                            this.mApkDownloadListener.onSuccess(downloadBean.getDownloadId(), downloadBean.getTotalBytes());
                            this.mDownloadManagerExt.unregisterObserver(this.mContext, downloadBean.getUri());
                        }
                    } else {
                        z = false;
                        if (!z) {
                        }
                    }
                } else {
                    long currentBytes = downloadBean.getCurrentBytes();
                    long totalBytes = downloadBean.getTotalBytes();
                    long downloadId = downloadBean.getDownloadId();
                    if (totalBytes <= 0) {
                        i2 = downloadBean.getProgress();
                    } else {
                        i2 = (int) ((100 * currentBytes) / totalBytes);
                    }
                    if (currentBytes > 0 && i2 != 100) {
                        this.mApkDownloadListener.onPause(downloadId, i2);
                    }
                }
            } else {
                long currentBytes2 = downloadBean.getCurrentBytes();
                long totalBytes2 = downloadBean.getTotalBytes();
                if (totalBytes2 <= 0) {
                    i = downloadBean.getProgress();
                } else {
                    i = (int) ((100 * currentBytes2) / totalBytes2);
                }
                if (currentBytes2 > 0 && i != 100) {
                    this.mApkDownloadListener.onProgressChanged(downloadBean.getDownloadId(), i);
                    this.mApkDownloadListener.onProgress(downloadBean.getDownloadId(), currentBytes2, totalBytes2, i);
                }
            }
        } else {
            long idFromUri = DownloadManagerExt.getInstance().getIdFromUri(this.mUri);
            if (idFromUri > -1) {
                this.mApkDownloadListener.onStopped(idFromUri, StopStatus.DOWNLOAD_FAIL);
            }
        }
    }
}
