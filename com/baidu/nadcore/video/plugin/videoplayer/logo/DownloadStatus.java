package com.baidu.nadcore.video.plugin.videoplayer.logo;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class DownloadStatus {
    public static final /* synthetic */ DownloadStatus[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final DownloadStatus DOWNLOADED;
    public static final DownloadStatus DOWNLOADING;
    public static final DownloadStatus DOWNLOAD_FAILED;
    public static final DownloadStatus DOWNLOAD_PAUSED;
    public static final DownloadStatus NOT_START;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1300195659, "Lcom/baidu/nadcore/video/plugin/videoplayer/logo/DownloadStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1300195659, "Lcom/baidu/nadcore/video/plugin/videoplayer/logo/DownloadStatus;");
                return;
            }
        }
        NOT_START = new DownloadStatus("NOT_START", 0);
        DOWNLOADING = new DownloadStatus("DOWNLOADING", 1);
        DOWNLOAD_PAUSED = new DownloadStatus("DOWNLOAD_PAUSED", 2);
        DOWNLOADED = new DownloadStatus("DOWNLOADED", 3);
        DownloadStatus downloadStatus = new DownloadStatus("DOWNLOAD_FAILED", 4);
        DOWNLOAD_FAILED = downloadStatus;
        $VALUES = new DownloadStatus[]{NOT_START, DOWNLOADING, DOWNLOAD_PAUSED, DOWNLOADED, downloadStatus};
    }

    public DownloadStatus(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static DownloadStatus valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (DownloadStatus) Enum.valueOf(DownloadStatus.class, str);
        }
        return (DownloadStatus) invokeL.objValue;
    }

    public static DownloadStatus[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (DownloadStatus[]) $VALUES.clone();
        }
        return (DownloadStatus[]) invokeV.objValue;
    }
}
