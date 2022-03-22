package com.baidu.cyberplayer.sdk.videodownload;

import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes3.dex */
public class CyberVideoDownloader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    /* loaded from: classes3.dex */
    public class DMDownloadError {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int Cust01 = 1901;
        public static final int Cust02 = 1902;
        public static final int Http400 = 1400;
        public static final int Http401 = 1401;
        public static final int Http403 = 1403;
        public static final int Http404 = 1404;
        public static final int Http499 = 1499;
        public static final int Http599 = 1599;
        public static final int Sys05 = 1605;
        public static final int Sys101 = 1701;
        public static final int Sys104 = 1704;
        public static final int Sys110 = 1710;
        public static final int Unknown = 1999;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface DownloadListener {
        void onDataTransfer(String str, VideoDownloadBean videoDownloadBean);

        void operationCallback(String str, int i, int i2);
    }

    @Keep
    /* loaded from: classes3.dex */
    public class DownloadOperation {
        public static /* synthetic */ Interceptable $ic;
        public static final int DELETE = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CyberVideoDownloader a;

        public DownloadOperation(CyberVideoDownloader cyberVideoDownloader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cyberVideoDownloader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cyberVideoDownloader;
        }
    }

    @Keep
    /* loaded from: classes3.dex */
    public class DownloadSubStatus {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FILE_EXIST = 1;
        public static final int UNKNOWN = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CyberVideoDownloader a;

        public DownloadSubStatus(CyberVideoDownloader cyberVideoDownloader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cyberVideoDownloader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cyberVideoDownloader;
        }
    }

    @Keep
    /* loaded from: classes3.dex */
    public class DownloadTaskStatus {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ABNORMAL_EXIT = 8;
        public static final int CANCELLED = 5;
        public static final int COMPLETE = 4;
        public static final int DELETED = 7;
        public static final int ERROR = 6;
        public static final int PAUSED = 3;
        public static final int PREPARED = 9;
        public static final int RUNNING = 2;
        public static final int UNKNOWN = 0;
        public static final int WAITING = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CyberVideoDownloader a;

        public DownloadTaskStatus(CyberVideoDownloader cyberVideoDownloader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cyberVideoDownloader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cyberVideoDownloader;
        }
    }

    public CyberVideoDownloader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void cancelDownload(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            d.f(str);
        }
    }

    public static void deleteDownload(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            d.g(str);
        }
    }

    public static void pauseDownload(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            d.e(str);
        }
    }

    public static void setDownloadListener(DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, downloadListener) == null) {
            d.a(downloadListener);
        }
    }

    public static void setWorkDir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            d.d(str);
        }
    }

    public static String startDownload(String str, VideoSourceBean videoSourceBean) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, videoSourceBean)) == null) ? d.a(str, videoSourceBean) : (String) invokeLL.objValue;
    }
}
