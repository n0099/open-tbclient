package com.baidu.mobads.container.components.downloader;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Observer;
/* loaded from: classes3.dex */
public interface IDownloader {
    public static final String TEMP_SUFFIX = ".tmp";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class DownloadStatus {
        public static final /* synthetic */ DownloadStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DownloadStatus CANCELLED;
        public static final DownloadStatus COMPLETED;
        public static final DownloadStatus COMPLETE_BUT_FILE_REMOVED;
        public static final DownloadStatus DOWNLOADING;
        public static final DownloadStatus ERROR;
        public static final DownloadStatus INITING;
        public static final DownloadStatus NONE;
        public static final DownloadStatus PAUSED;
        public transient /* synthetic */ FieldHolder $fh;
        public int code;
        public String msg;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1273196709, "Lcom/baidu/mobads/container/components/downloader/IDownloader$DownloadStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1273196709, "Lcom/baidu/mobads/container/components/downloader/IDownloader$DownloadStatus;");
                    return;
                }
            }
            NONE = new DownloadStatus("NONE", 0, -1, "未开始");
            INITING = new DownloadStatus("INITING", 1, 0, "下载准备中");
            DOWNLOADING = new DownloadStatus(AdDownloadApkUtils.DL_STATUS_DOWNLOADING, 2, 1, "正在下载");
            CANCELLED = new DownloadStatus("CANCELLED", 3, 2, "已取消下载");
            COMPLETED = new DownloadStatus("COMPLETED", 4, 3, "下载完成");
            ERROR = new DownloadStatus("ERROR", 5, 4, "下载失败");
            COMPLETE_BUT_FILE_REMOVED = new DownloadStatus("COMPLETE_BUT_FILE_REMOVED", 6, 5, "下载完但文件异常");
            DownloadStatus downloadStatus = new DownloadStatus("PAUSED", 7, 6, "已暂停下载");
            PAUSED = downloadStatus;
            $VALUES = new DownloadStatus[]{NONE, INITING, DOWNLOADING, CANCELLED, COMPLETED, ERROR, COMPLETE_BUT_FILE_REMOVED, downloadStatus};
        }

        public DownloadStatus(String str, int i2, int i3, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.code = i3;
            this.msg = str2;
        }

        public static DownloadStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DownloadStatus) Enum.valueOf(DownloadStatus.class, str) : (DownloadStatus) invokeL.objValue;
        }

        public static DownloadStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DownloadStatus[]) $VALUES.clone() : (DownloadStatus[]) invokeV.objValue;
        }

        public int getCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.code : invokeV.intValue;
        }

        public String getMessage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.msg : (String) invokeV.objValue;
        }
    }

    void addObserver(Observer observer);

    void cancel();

    int getFileSize();

    long getFileSizeLong();

    String getOutputPath();

    String getPackageName();

    float getProgress();

    DownloadStatus getState();

    String getTargetURL();

    String getURL();

    boolean isDownloadOnlyWifi();

    boolean isPausedManually();

    void pause();

    void removeObservers();

    void resume();

    void setDownloadOnlyWifi(boolean z);

    void setPausedManually(boolean z);

    void start();
}
