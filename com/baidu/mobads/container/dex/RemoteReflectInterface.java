package com.baidu.mobads.container.dex;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.components.command.XAdRemoteDownloadAPKCommand;
import com.baidu.mobads.container.components.command.XAdRemoteDownloadAdInfo;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RemoteReflectInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public RemoteReflectInterface() {
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

    public static int getDownloadStatus(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                IDownloader adsApkDownloader = XAdRemoteCommonUtils.getAdsApkDownloader(str);
                IDownloader.DownloadStatus downloadStatus = null;
                String str2 = "";
                int i2 = 0;
                if (adsApkDownloader != null) {
                    downloadStatus = adsApkDownloader.getState();
                    i2 = (int) adsApkDownloader.getProgress();
                    str2 = adsApkDownloader.getOutputPath();
                } else {
                    XAdRemoteAPKDownloadExtraInfo storedDownloadInfo = XAdRemoteAPKDownloadExtraInfo.getStoredDownloadInfo(XAdRemoteCommonUtils.getApplicationContext(), str);
                    if (storedDownloadInfo != null && storedDownloadInfo.status == IDownloader.DownloadStatus.COMPLETED) {
                        downloadStatus = storedDownloadInfo.status;
                        i2 = storedDownloadInfo.progress;
                        str2 = storedDownloadInfo.outputFolder + storedDownloadInfo.outputFileName;
                    }
                }
                if (downloadStatus != null) {
                    if (downloadStatus == IDownloader.DownloadStatus.INITING || downloadStatus == IDownloader.DownloadStatus.DOWNLOADING) {
                        return i2;
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
        return invokeL.intValue;
    }

    public static boolean isLocalFileExist(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
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
        return invokeL.booleanValue;
    }

    public static void pauseDlByPk(String str) {
        IDownloader adsApkDownloader;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            try {
                if (TextUtils.isEmpty(str) || (adsApkDownloader = XAdRemoteCommonUtils.getAdsApkDownloader(str)) == null) {
                    return;
                }
                adsApkDownloader.pause();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean resumeDownload(Context context, JSONObject jSONObject, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, jSONObject, str, str2)) == null) {
            try {
                XAdRemoteDownloadAdInfo createAdInfoFromJson = XAdRemoteDownloadAdInfo.createAdInfoFromJson(jSONObject);
                createAdInfoFromJson.mProd = str;
                createAdInfoFromJson.mDlType = str2;
                return new XAdRemoteDownloadAPKCommand(context, createAdInfoFromJson).resumeDownload();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
