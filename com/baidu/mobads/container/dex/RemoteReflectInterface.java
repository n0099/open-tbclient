package com.baidu.mobads.container.dex;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.components.command.XAdRemoteDownloadAPKCommand;
import com.baidu.mobads.container.components.command.XAdRemoteDownloadAdInfo;
import com.baidu.mobads.container.components.downloader.IDownloader;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RemoteReflectInterface {
    public static int getDownloadStatus(String str) {
        try {
            IDownloader adsApkDownloader = XAdRemoteCommonUtils.getAdsApkDownloader(str);
            IDownloader.DownloadStatus downloadStatus = null;
            String str2 = "";
            int i = 0;
            if (adsApkDownloader != null) {
                downloadStatus = adsApkDownloader.getState();
                i = (int) adsApkDownloader.getProgress();
                str2 = adsApkDownloader.getOutputPath();
            } else {
                XAdRemoteAPKDownloadExtraInfo storedDownloadInfo = XAdRemoteAPKDownloadExtraInfo.getStoredDownloadInfo(XAdRemoteCommonUtils.getApplicationContext(), str);
                if (storedDownloadInfo != null && storedDownloadInfo.status == IDownloader.DownloadStatus.COMPLETED) {
                    downloadStatus = storedDownloadInfo.status;
                    i = storedDownloadInfo.progress;
                    str2 = storedDownloadInfo.outputFolder + storedDownloadInfo.outputFileName;
                }
            }
            if (downloadStatus != null) {
                if (downloadStatus == IDownloader.DownloadStatus.INITING || downloadStatus == IDownloader.DownloadStatus.DOWNLOADING) {
                    return i;
                }
                if (downloadStatus == IDownloader.DownloadStatus.COMPLETED) {
                    return isLocalFileExist(str2) ? 101 : -1;
                }
                if (downloadStatus != IDownloader.DownloadStatus.CANCELLED && downloadStatus != IDownloader.DownloadStatus.PAUSED) {
                    return (downloadStatus == IDownloader.DownloadStatus.ERROR || downloadStatus == IDownloader.DownloadStatus.COMPLETE_BUT_FILE_REMOVED) ? 104 : -1;
                }
                return 102;
            }
        } catch (Throwable unused) {
        }
        return -1;
    }

    public static boolean isLocalFileExist(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (file.exists()) {
                return file.length() > 0;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void pauseDlByPk(String str) {
        IDownloader adsApkDownloader;
        try {
            if (TextUtils.isEmpty(str) || (adsApkDownloader = XAdRemoteCommonUtils.getAdsApkDownloader(str)) == null) {
                return;
            }
            adsApkDownloader.pause();
        } catch (Throwable unused) {
        }
    }

    public static boolean resumeDownload(Context context, JSONObject jSONObject, String str, String str2) {
        try {
            XAdRemoteDownloadAdInfo createAdInfoFromJson = XAdRemoteDownloadAdInfo.createAdInfoFromJson(jSONObject);
            createAdInfoFromJson.mProd = str;
            createAdInfoFromJson.mDlType = str2;
            return new XAdRemoteDownloadAPKCommand(context, createAdInfoFromJson).resumeDownload();
        } catch (Throwable unused) {
            return false;
        }
    }
}
